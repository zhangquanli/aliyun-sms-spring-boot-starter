package com.github.zhangquanli.aliyun.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractResponse;

/**
 * AddSmsSignResponse
 *
 * @author zhangquanli
 */
public class AddSmsSignResponse extends AbstractResponse {
    /**
     * 描述：签名名称。
     * 示例：阿里云
     */
    @JsonProperty("SignName")
    private String signName;

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }
}
