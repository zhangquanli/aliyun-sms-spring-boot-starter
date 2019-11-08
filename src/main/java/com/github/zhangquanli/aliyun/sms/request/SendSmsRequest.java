package com.github.zhangquanli.aliyun.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;

/**
 * SendSmsRequest
 *
 * @author zhangquanli
 */
public class SendSmsRequest extends AbstractRequest {

    /**
     * 描述：接收短信的手机号码。支持对多个手机号码发送短信，手机号码之间以英文逗号（,）分隔。
     * 示例：15900000000
     * 是否必填：是
     */
    @JsonProperty("PhoneNumbers")
    private String phoneNumbers;
    /**
     * 描述：短信签名名称。
     * 示例：阿里云
     * 是否必填：是
     */
    @JsonProperty("SignName")
    private String signName;
    /**
     * 描述：短信模板CODE。
     * 示例：SMS_153055065
     * 是否必填：是
     */
    @JsonProperty("TemplateCode")
    private String templateCode;
    /**
     * 描述：短信模板变量对应的实际值，JSON格式。
     * 示例：{"code":"1111"}
     * 是否必填：否
     */
    @JsonProperty("TemplateParam")
    private String templateParam;
    /**
     * 描述：上行短信扩展码，无特殊需要此字段的用户请忽略此字段。
     * 示例：90999
     * 是否必填：否
     */
    @JsonProperty("SmsUpExtendCode")
    private String smsUpExtendCode;
    /**
     * 描述：外部流水扩展字段。
     * 示例：abcdefgh
     * 是否必填：否
     */
    @JsonProperty("OutId")
    private String outId;

    private SendSmsRequest(String phoneNumbers, String signName, String templateCode, String templateParam, String smsUpExtendCode, String outId) {
        this.phoneNumbers = phoneNumbers;
        this.signName = signName;
        this.templateCode = templateCode;
        this.templateParam = templateParam;
        this.smsUpExtendCode = smsUpExtendCode;
        this.outId = outId;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getSignName() {
        return signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public String getSmsUpExtendCode() {
        return smsUpExtendCode;
    }

    public String getOutId() {
        return outId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String phoneNumbers;
        private String signName;
        private String templateCode;
        private String templateParam;
        private String smsUpExtendCode;
        private String outId;

        public Builder() {
        }

        public Builder phoneNumbers(String phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Builder signName(String signName) {
            this.signName = signName;
            return this;
        }

        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        public Builder templateParam(String templateParam) {
            this.templateParam = templateParam;
            return this;
        }

        public Builder smsUpExtendCode(String smsUpExtendCode) {
            this.smsUpExtendCode = smsUpExtendCode;
            return this;
        }

        public Builder outId(String outId) {
            this.outId = outId;
            return this;
        }

        public SendSmsRequest build() {
            return new SendSmsRequest(phoneNumbers, signName, templateCode, templateParam, smsUpExtendCode, outId);
        }
    }
}
