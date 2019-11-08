package com.github.zhangquanli.aliyun.sms.http;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AbstractResponse
 *
 * @author zhangquanli
 */
public abstract class AbstractResponse {

    /**
     * 描述：请求状态码。 返回OK代表请求成功。
     * 示例：OK
     */
    @JsonProperty("Code")
    private String code;
    /**
     * 描述：状态码的描述。
     * 示例：OK
     */
    @JsonProperty("Message")
    private String message;
    /**
     * 描述：请求 ID。无论调用接口成功与否，都会返回请求 ID。
     * 示例：2184201F-BFB3-446B-B1F2-C746B7BF0657
     */
    @JsonProperty("RequestId")
    private String requestId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
