package com.github.zhangquanli.aliyun.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;
import org.springframework.util.Assert;

/**
 * QuerySmsSignRequest
 * <p>
 * 官方文档：https://help.aliyun.com/document_detail/121210.html
 *
 * @author zhangquanli
 */
public class QuerySmsSignRequest extends AbstractRequest {
    /**
     * 描述：短信签名。
     * 示例：阿里云
     * 是否必填：是
     */
    @JsonProperty("SignName")
    private String signName;

    private QuerySmsSignRequest(Builder builder) {
        Assert.hasText(builder.signName, "signName can not be blank");
        this.signName = builder.signName;
    }

    public String getSignName() {
        return signName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String signName;

        private Builder() {
        }

        public Builder signName(String signName) {
            this.signName = signName;
            return this;
        }

        public QuerySmsSignRequest build() {
            return new QuerySmsSignRequest(this);
        }
    }
}
