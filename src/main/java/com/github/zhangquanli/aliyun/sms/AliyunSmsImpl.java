package com.github.zhangquanli.aliyun.sms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.zhangquanli.aliyun.sms.request.*;
import com.github.zhangquanli.aliyun.sms.response.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Map;

import static com.github.zhangquanli.aliyun.sms.constants.AliyunSmsAction.*;
import static com.github.zhangquanli.aliyun.sms.utils.AliyunSmsUtils.requestUrl;

/**
 * AliyunSmsImpl
 *
 * @author zhangquanli
 */
public class AliyunSmsImpl implements AliyunSms {

    private String accessKeyId;
    private String accessKeySecret;
    private OkHttpClient okHttpClient;
    private ObjectMapper objectMapper;

    public AliyunSmsImpl(AliyunSmsProperties aliyunSmsProperties) {
        this.accessKeyId = aliyunSmsProperties.getAccessKeyId();
        this.accessKeySecret = aliyunSmsProperties.getAccessKeySecret();
        this.okHttpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public SendSmsResponse sendSms(SendSmsRequest request) {
        String json = get(request, SEND_SMS);
        try {
            return objectMapper.readValue(json, new TypeReference<SendSmsResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public SendBatchSmsResponse sendBatchSms(SendBatchSmsRequest request) {
        String json = get(request, SEND_BATCH_SMS);
        try {
            return objectMapper.readValue(json, new TypeReference<SendBatchSmsResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public QuerySendDetailsResponse querySendDetails(QuerySendDetailsRequest request) {
        String json = get(request, QUERY_SEND_DETAILS);
        try {
            return objectMapper.readValue(json, new TypeReference<QuerySendDetailsResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public AddSmsSignResponse addSmsSign(AddSmsSignRequest request) {
        String json = get(request, ADD_SMS_SIGN);
        try {
            return objectMapper.readValue(json, new TypeReference<AddSmsSignResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public DeleteSmsSignResponse deleteSmsSign(DeleteSmsSignRequest request) {
        String json = get(request, DELETE_SMS_SIGN);
        try {
            return objectMapper.readValue(json, new TypeReference<DeleteSmsSignResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ModifySmsSignResponse modifySmsSign(ModifySmsSignRequest request) {
        String json = get(request, MODIFY_SMS_SIGN);
        try {
            return objectMapper.readValue(json, new TypeReference<ModifySmsSignResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public QuerySmsSignResponse querySmsSign(QuerySmsSignRequest request) {
        String json = get(request, QUERY_SMS_SIGN);
        try {
            return objectMapper.readValue(json, new TypeReference<QuerySmsSignResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public AddSmsTemplateResponse addSmsTemplate(AddSmsTemplateRequest request) {
        String json = get(request, ADD_SMS_TEMPLATE);
        try {
            return objectMapper.readValue(json, new TypeReference<AddSmsTemplateResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public DeleteSmsTemplateResponse deleteSmsTemplate(DeleteSmsTemplateRequest request) {
        String json = get(request, DELETE_SMS_TEMPLATE);
        try {
            return objectMapper.readValue(json, new TypeReference<DeleteSmsTemplateResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ModifySmsTemplateResponse modifySmsTemplate(ModifySmsTemplateRequest request) {
        String json = get(request, MODIFY_SMS_TEMPLATE);
        try {
            return objectMapper.readValue(json, new TypeReference<ModifySmsTemplateResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public QuerySmsTemplateResponse querySmsTemplate(QuerySmsTemplateRequest request) {
        String json = get(request, QUERY_SMS_TEMPLATE);
        try {
            return objectMapper.readValue(json, new TypeReference<QuerySmsTemplateResponse>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private String get(AliyunSmsRequest aliyunSmsRequest, String action) {
        // 请求参数
        Map<String, String> params = aliyunSmsRequest.toMap();
        String requestUrl = requestUrl(params, action, accessKeyId, accessKeySecret);
        Request request = new Request.Builder().url(requestUrl).get().build();
        // 响应结果
        try (Response response = okHttpClient.newCall(request).execute();) {
            ResponseBody body = response.body();
            if (body == null) {
                throw new RuntimeException("【阿里云】【短信服务】响应数据为空");
            }
            return body.string();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
