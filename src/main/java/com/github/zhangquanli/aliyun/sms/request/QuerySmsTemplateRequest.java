package com.github.zhangquanli.aliyun.sms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Map;

/**
 * QuerySmsTemplateRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySmsTemplateRequest implements AliyunSmsRequest {

    /**
     * 描述：短信模板CODE。
     * 示例：SMS_152550005
     * 是否必填：是
     */
    private String templateCode;

    @Override
    public Map<String, String> toMap() {
        if (templateCode == null) {
            throw new RuntimeException("templateCode can not be null");
        }
        return Collections.singletonMap("TemplateCode", templateCode);
    }
}
