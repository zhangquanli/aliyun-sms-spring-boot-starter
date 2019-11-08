package com.github.zhangquanli.aliyun.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;

/**
 * SendBatchSmsRequest
 *
 * @author zhangquanli
 */
public class SendBatchSmsRequest extends AbstractRequest {

    /**
     * 描述：接收短信的手机号码，JSON数组格式。
     * 示例：["15900000000","13500000000"]
     * 是否必填：是
     */
    @JsonProperty("PhoneNumberJson")
    private String phoneNumberJson;
    /**
     * 描述：短信签名名称，JSON数组格式。
     * 示例：["阿里云","阿里巴巴"]
     * 是否必填：是
     */
    @JsonProperty("SignNameJson")
    private String signNameJson;
    /**
     * 描述：短信模板CODE。
     * 示例：SMS_152550005
     * 是否必填：是
     */
    @JsonProperty("TemplateCode")
    private String templateCode;
    /**
     * 描述：短信模板变量对应的实际值，JSON格式。
     * 示例：[{"name":"TemplateParamJson"},{"name":"TemplateParamJson"}]
     * 是否必填：否
     */
    @JsonProperty("TemplateParamJson")
    private String templateParamJson;
    /**
     * 描述：上行短信扩展码，JSON数组格式。无特殊需要此字段的用户请忽略此字段。
     * 示例：["90999","90998"]
     * 是否必填：否
     */
    @JsonProperty("SmsUpExtendCodeJson")
    private String smsUpExtendCodeJson;

    private SendBatchSmsRequest(String phoneNumberJson, String signNameJson, String templateCode, String templateParamJson, String smsUpExtendCodeJson) {
        this.phoneNumberJson = phoneNumberJson;
        this.signNameJson = signNameJson;
        this.templateCode = templateCode;
        this.templateParamJson = templateParamJson;
        this.smsUpExtendCodeJson = smsUpExtendCodeJson;
    }

    public String getPhoneNumberJson() {
        return phoneNumberJson;
    }

    public String getSignNameJson() {
        return signNameJson;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public String getTemplateParamJson() {
        return templateParamJson;
    }

    public String getSmsUpExtendCodeJson() {
        return smsUpExtendCodeJson;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String phoneNumberJson;
        private String signNameJson;
        private String templateCode;
        private String templateParamJson;
        private String smsUpExtendCodeJson;

        public Builder() {
        }

        public Builder phoneNumberJson(String phoneNumberJson) {
            this.phoneNumberJson = phoneNumberJson;
            return this;
        }

        public Builder signNameJson(String signNameJson) {
            this.signNameJson = signNameJson;
            return this;
        }

        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        public Builder templateParamJson(String templateParamJson) {
            this.templateParamJson = templateParamJson;
            return this;
        }

        public Builder smsUpExtendCodeJson(String smsUpExtendCodeJson) {
            this.smsUpExtendCodeJson = smsUpExtendCodeJson;
            return this;
        }

        public SendBatchSmsRequest build() {
            return new SendBatchSmsRequest(phoneNumberJson, signNameJson, templateCode, templateParamJson, smsUpExtendCodeJson);
        }
    }
}
