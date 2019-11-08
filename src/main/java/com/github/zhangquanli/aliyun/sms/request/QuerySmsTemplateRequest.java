package com.github.zhangquanli.aliyun.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;

/**
 * QuerySmsTemplateRequest
 *
 * @author zhangquanli
 */
public class QuerySmsTemplateRequest extends AbstractRequest {

    /**
     * 描述：短信模板CODE。
     * 示例：SMS_152550005
     * 是否必填：是
     */
    @JsonProperty("TemplateCode")
    private String templateCode;

    private QuerySmsTemplateRequest(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String templateCode;

        public Builder() {
        }

        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        public QuerySmsTemplateRequest build() {
            return new QuerySmsTemplateRequest(templateCode);
        }
    }
}
