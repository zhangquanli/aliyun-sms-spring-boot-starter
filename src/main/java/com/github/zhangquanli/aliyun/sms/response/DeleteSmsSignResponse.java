package com.github.zhangquanli.aliyun.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractResponse;

/**
 * DeleteSmsSignResponse
 *
 * @author zhangquanli
 */
public class DeleteSmsSignResponse extends AbstractResponse {
    
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
