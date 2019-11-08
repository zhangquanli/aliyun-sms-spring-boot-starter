package com.github.zhangquanli.aliyun.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;

/**
 * QuerySmsSignRequest
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

    private QuerySmsSignRequest(String signName) {
        this.signName = signName;
    }

    public String getSignName() {
        return signName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String signName;

        public Builder() {
        }

        public Builder signName(String signName) {
            this.signName = signName;
            return this;
        }

        public QuerySmsSignRequest build() {
            return new QuerySmsSignRequest(signName);
        }
    }
}
