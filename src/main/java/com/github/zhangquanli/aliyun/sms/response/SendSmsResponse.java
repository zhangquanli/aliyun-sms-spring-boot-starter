package com.github.zhangquanli.aliyun.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractResponse;

/**
 * SendSmsResponse
 *
 * @author zhangquanli
 */
public class SendSmsResponse extends AbstractResponse {

    /**
     * 描述：发送回执ID，可根据该ID在接口QuerySendDetails中查询具体的发送状态。
     * 示例：900619746936498440^0
     */
    @JsonProperty("BizId")
    private String bizId;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
