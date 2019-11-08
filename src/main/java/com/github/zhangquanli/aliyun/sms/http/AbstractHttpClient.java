package com.github.zhangquanli.aliyun.sms.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.zhangquanli.aliyun.sms.AliyunSmsProperties;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;

/**
 * AbstractHttpClient
 *
 * @author zhangquanli
 */
public abstract class AbstractHttpClient {
    private static final Logger log = LoggerFactory.getLogger(AbstractHttpClient.class);
    private String accessKeyId;
    private String accessKeySecret;
    private OkHttpClient okHttpClient;
    private ObjectMapper objectMapper;

    protected AbstractHttpClient(AliyunSmsProperties aliyunSmsProperties) {
        this.accessKeyId = aliyunSmsProperties.getAccessKeyId();
        this.accessKeySecret = aliyunSmsProperties.getAccessKeySecret();
        this.okHttpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    protected String buildUrl(String action, AbstractRequest abstractRequest) {
        // 1. 指定请求参数
        Map<String, Object> params;
        try {
            abstractRequest.setAccessKeyId(accessKeyId);
            abstractRequest.setAction(action);
            String json = objectMapper.writeValueAsString(abstractRequest);
            params = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonProcessingException e) {
            String msg = "【阿里云】>>>【短信】>>>数据转换失败";
            log.error(msg, e);
            throw new RuntimeException(msg);
        }
        params.remove("Signature");
        // 2. 根据参数Key排序
        Map<String, Object> sortedParams = new TreeMap<>(params);
        // 3. 构造待请求的请求串
        StringBuilder sortedQueryStringTemp = new StringBuilder();
        for (String key : sortedParams.keySet()) {
            Object value = sortedParams.get(key);
            sortedQueryStringTemp.append("&")
                    .append(specialUrlEncode(key))
                    .append("=")
                    .append(specialUrlEncode(value.toString()));
        }
        String sortedQueryString = sortedQueryStringTemp.toString().substring(1);
        String stringToSign = "GET&" + specialUrlEncode("/") + "&" + specialUrlEncode(sortedQueryString);
        // 4. 签名
        String sign = sign(accessKeySecret + "&", stringToSign);
        // 5. 增加签名结果到请求参数中，发送请求
        String signature = specialUrlEncode(sign);
        return "http://dysmsapi.aliyuncs.com/?Signature=" + signature + "&" + sortedQueryString;
    }

    protected String get(String url) {
        Request request = new Request.Builder().url(url).get().build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String msg = "【阿里云】>>>【短信】>>>响应状态异常";
                RuntimeException e = new RuntimeException(msg);
                log.error(msg, e);
                throw e;
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                String msg = "【阿里云】>>>【短信】>>>响应数据为空";
                RuntimeException e = new RuntimeException(msg);
                log.error(msg, e);
                throw e;
            }
            String responseJson = responseBody.string();
            if (log.isDebugEnabled()) {
                log.debug("【阿里云】>>>【短信】>>>响应数据：{}", responseJson);
            }
            return responseJson;
        } catch (IOException e) {
            String msg = "【阿里云】>>>【短信】>>>网络请求异常";
            log.error(msg, e);
            throw new RuntimeException(msg);
        }
    }

    protected <T extends AbstractResponse> T convert(String json, Class<T> targetClass) {
        try {
            return objectMapper.readValue(json, targetClass);
        } catch (JsonProcessingException e) {
            String msg = "【阿里云】>>>【短信】>>>数据转换异常";
            log.error(msg, e);
            throw new RuntimeException(msg);
        }
    }

    private String sign(String accessKeySecret, String stringToSign) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(accessKeySecret.getBytes(StandardCharsets.UTF_8), "HmacSHA1"));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(signData);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            String msg = "【阿里云】>>>【短信】>>>构造签名失败";
            log.error(msg, e);
            throw new RuntimeException(msg);
        }
    }

    private String specialUrlEncode(String value) {
        try {
            String encode = URLEncoder.encode(value, "UTF-8");
            return encode.replace("+", "%20")
                    .replace("*", "%2A")
                    .replace("%7E", "~");
        } catch (UnsupportedEncodingException e) {
            String msg = "【阿里云】>>>【短信】>>>构造签名失败";
            log.error(msg, e);
            throw new RuntimeException(msg);
        }
    }
}
