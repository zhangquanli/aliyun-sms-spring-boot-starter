package com.github.zhangquanli.aliyun.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;
import com.github.zhangquanli.aliyun.sms.utils.JsonUtils;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * SendBatchSmsRequest
 * <p>
 * 官方文档：https://help.aliyun.com/document_detail/102364.html
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
     * 描述：上行短信扩展码，JSON数组格式。
     * 示例：["90999","90998"]
     * 是否必填：否
     */
    @JsonProperty("SmsUpExtendCodeJson")
    private String smsUpExtendCodeJson;

    private SendBatchSmsRequest(Builder builder) {
        Assert.notEmpty(builder.phoneNumbers, "phoneNumbers can not be empty");
        this.phoneNumberJson = JsonUtils.writeValueAsString(builder.phoneNumbers);
        Assert.notEmpty(builder.signNames, "signNames can not be empty");
        this.signNameJson = JsonUtils.writeValueAsString(builder.signNames);
        Assert.hasText(builder.templateCode, "templateCode can not be blank");
        this.templateCode = builder.templateCode;
        this.templateParamJson = JsonUtils.writeValueAsString(builder.templateParams);
        this.smsUpExtendCodeJson = JsonUtils.writeValueAsString(builder.smsUpExtendCodes);
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
        private List<String> phoneNumbers;
        private List<String> signNames;
        private String templateCode;
        private List<Map<String, Object>> templateParams;
        private String smsUpExtendCodes;

        private Builder() {
        }

        public Builder phoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Builder signNames(List<String> signNames) {
            this.signNames = signNames;
            return this;
        }

        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        public Builder templateParams(List<Map<String, Object>> templateParams) {
            this.templateParams = templateParams;
            return this;
        }

        public Builder smsUpExtendCodes(String smsUpExtendCodes) {
            this.smsUpExtendCodes = smsUpExtendCodes;
            return this;
        }

        public SendBatchSmsRequest build() {
            return new SendBatchSmsRequest(this);
        }
    }
}
