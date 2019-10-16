package com.github.zhangquanli.aliyun.sms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Map;

/**
 * QuerySmsSignRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySmsSignRequest implements AliyunSmsRequest {

    /**
     * 描述：短信签名。
     * 示例：阿里云
     * 是否必填：是
     */
    private String signName;

    @Override
    public Map<String, String> toMap() {
        if (signName == null) {
            throw new RuntimeException("signName can not be null");
        }
        return Collections.singletonMap("SignName", signName);
    }
}
