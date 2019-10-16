package com.github.zhangquanli.aliyun.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SmsSendDetailDTOs
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsSendDetailDTOs {

    /**
     * 描述：短信发送明细。
     */
    @JsonProperty("SmsSendDetailDTO")
    private List<SmsSendDetailDTO> smsSendDetailDTO;
}
