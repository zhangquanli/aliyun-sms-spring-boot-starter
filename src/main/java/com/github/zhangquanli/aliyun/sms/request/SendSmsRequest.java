package com.github.zhangquanli.aliyun.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;
import com.github.zhangquanli.aliyun.sms.utils.JsonUtils;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * SendSmsRequest
 * <p>
 * 官方文档：https://help.aliyun.com/document_detail/101414.html
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

    private SendSmsRequest(Builder builder) {
        Assert.notEmpty(builder.phoneNumbers, "phoneNumbers can not be empty");
        this.phoneNumbers = String.join(",", builder.phoneNumbers);
        Assert.hasText(builder.signName, "signName can not be blank");
        this.signName = builder.signName;
        Assert.hasText(builder.templateCode, "templateCode can not be blank");
        this.templateCode = builder.templateCode;
        this.templateParam = JsonUtils.writeValueAsString(builder.templateParam);
        this.smsUpExtendCode = builder.smsUpExtendCode;
        this.outId = builder.outId;
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
        private List<String> phoneNumbers;
        private String signName;
        private String templateCode;
        private Map<String, Object> templateParam;
        private String smsUpExtendCode;
        private String outId;

        private Builder() {
        }

        public Builder phoneNumbers(List<String> phoneNumbers) {
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

        public Builder templateParam(Map<String, Object> templateParam) {
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
            return new SendSmsRequest(this);
        }
    }
}
