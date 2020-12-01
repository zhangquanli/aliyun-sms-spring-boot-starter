package com.github.zhangquanli.aliyun.sms.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.zhangquanli.aliyun.sms.AliyunSmsException;

public abstract class JsonUtils {
    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String writeValueAsString(Object value) {
        try {
            if (value == null) {
                throw new AliyunSmsException("数据转换失败");
            }
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new AliyunSmsException("数据转换失败", e);
        }
    }

    public static <T> T readValue(String content, Class<T> valueType) {
        try {
            if (content == null) {
                throw new AliyunSmsException("数据转换失败");
            }
            return objectMapper.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new AliyunSmsException("数据转换失败", e);
        }
    }
    
    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) {
        try {
            if (content == null) {
                throw new AliyunSmsException("数据转换失败");
            }
            return objectMapper.readValue(content, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new AliyunSmsException("数据转换失败", e);
        }
    }
}
