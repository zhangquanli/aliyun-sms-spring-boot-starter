package com.github.zhangquanli.aliyun.sms.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.github.zhangquanli.aliyun.sms.constants.AliyunSmsConstants.*;

/**
 * AliyunSmsUtils
 *
 * @author zhangquanli
 */
public class AliyunSmsUtils {

    public static void main(String[] args) {
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        Map<String, String> params = new HashMap<>();
        params.put("AccessKeyId", "testId");
        params.put("Action", "SendSms");
        params.put("Format", "XML");
        params.put("RegionId", "cn-hangzhou");
        params.put("SignatureMethod", "HMAC-SHA1");
        params.put("SignatureNonce", "45e25e9b-0a6f-4070-8c85-2956eda1b466");
        params.put("SignatureVersion", "1.0");
        params.put("Timestamp", "2017-07-12T02:42:19Z");
        params.put("Version", "2017-05-25");

        params.put("PhoneNumbers", "15300000001");
        params.put("SignName", "阿里云短信测试专用");
        params.put("TemplateParam", "{\"customer\":\"test\"}");
        params.put("TemplateCode", "SMS_71390007");
        params.put("OutId", "123");

        String testSecret = signature(params, "testSecret");
        System.out.println(testSecret.equals("zJDF%2BLrzhj%2FThnlvIToysFRq6t4%3D"));
    }

    public static String requestUrl(Map<String, String> params, String action, String accessKeyId, String accessKeySecret) {
        // 填充请求参数
        Map<String, String> requestParams = fillRequestParams(params, action, accessKeyId);
        // 计算请求签名
        String signature = signature(requestParams, accessKeySecret);
        String sortedQueryString = sortedQueryString(requestParams);
        // 拼接请求地址
        return "http://dysmsapi.aliyuncs.com/?" + SIGNATURE_KEY + "=" + signature + "&" + sortedQueryString;
    }

    /**
     * 获取请求签名
     *
     * @param params 请求参数
     * @return 请求签名
     */
    private static String signature(Map<String, String> params, String accessKeySecret) {
        String sortedQueryString = sortedQueryString(params);
        // 拼接额外数据
        sortedQueryString = "GET" + "&" + specialUrlEncode("/") + "&" + specialUrlEncode(sortedQueryString);
        // 使用accessKeySecret对字符串签名
        String sign = sign(accessKeySecret + "&", sortedQueryString);
        return specialUrlEncode(sign);
    }

    /**
     * 生成表单字符串（不包含签名）
     *
     * @param params 请求参数
     * @return 表单字符串（不包含签名）
     */
    private static String sortedQueryString(Map<String, String> params) {
        // 排序并拼接字符串
        params.remove(SIGNATURE_KEY);
        Map<String, String> sortedParams = new TreeMap<>(params);
        StringBuilder sortedQueryStringTemp = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sortedQueryStringTemp.append("&")
                    .append(specialUrlEncode(key))
                    .append("=")
                    .append(specialUrlEncode(value));
        }
        return sortedQueryStringTemp.toString().substring(1);
    }

    private static Map<String, String> fillRequestParams(Map<String, String> params, String action, String accessKeyId) {
        Map<String, String> requestParams = new HashMap<>(params);
        requestParams.put(ACCESS_KEY_ID_KEY, accessKeyId);
        requestParams.put(ACTION_KEY, action);
        requestParams.put(FORMAT_KEY, format());
        requestParams.put(REGION_ID_KEY, regionId());
        requestParams.put(SIGNATURE_METHOD_KEY, signatureMethod());
        requestParams.put(SIGNATURE_NONCE_KEY, signatureNonce());
        requestParams.put(SIGNATURE_VERSION_KEY, signatureVersion());
        requestParams.put(TIMESTAMP_KEY, timestamp());
        requestParams.put(VERSION_KEY, version());
        return requestParams;
    }

    private static String specialUrlEncode(String value) {
        try {
            String encode = URLEncoder.encode(value, "UTF-8");
            return encode.replace("+", "%20")
                    .replace("*", "%2A")
                    .replace("%7E", "~");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String sign(String accessKeySecret, String value) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(accessKeySecret.getBytes(StandardCharsets.UTF_8), "HmacSHA1"));
            byte[] signData = mac.doFinal(value.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(signData);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String format() {
        return "json";
    }

    private static String regionId() {
        return "cn-hangzhou";
    }

    private static String signatureMethod() {
        return "HMAC-SHA1";
    }

    private static String signatureNonce() {
        return UUID.randomUUID().toString();
    }

    private static String signatureVersion() {
        return "1.0";
    }

    private static String timestamp() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return df.format(new Date());
    }

    private static String version() {
        return "2017-05-25";
    }
}
