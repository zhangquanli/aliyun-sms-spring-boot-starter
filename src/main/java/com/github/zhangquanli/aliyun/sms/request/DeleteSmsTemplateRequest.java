package com.github.zhangquanli.aliyun.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;

/**
 * DeleteSmsTemplateRequest
 *
 * @author zhangquanli
 */
public class DeleteSmsTemplateRequest extends AbstractRequest {

    /**
     * 描述：短信模板CODE。
     * 示例：SMS_152550005
     * 是否必填：是
     */
    @JsonProperty("TemplateCode")
    private String templateCode;

    private DeleteSmsTemplateRequest(String templateCode) {
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

        public DeleteSmsTemplateRequest build() {
            return new DeleteSmsTemplateRequest(templateCode);
        }
    }
}
