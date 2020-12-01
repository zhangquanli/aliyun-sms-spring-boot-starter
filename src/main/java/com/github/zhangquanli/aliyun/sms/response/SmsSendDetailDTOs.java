package com.github.zhangquanli.aliyun.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * SmsSendDetailDTOs
 *
 * @author zhangquanli
 */
public class SmsSendDetailDTOs {
    /**
     * 描述：短信发送明细。
     */
    @JsonProperty("SmsSendDetailDTO")
    private List<SmsSendDetailDTO> smsSendDetailDTO;

    public List<SmsSendDetailDTO> getSmsSendDetailDTO() {
        return smsSendDetailDTO;
    }

    public void setSmsSendDetailDTO(List<SmsSendDetailDTO> smsSendDetailDTO) {
        this.smsSendDetailDTO = smsSendDetailDTO;
    }
}
