package com.github.zhangquanli.aliyun.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * QuerySendDetailsResponse
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySendDetailsResponse {

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
     * 描述：请求ID。
     * 示例：F655A8D5-B967-440B-8683-DAD6FF8DE990
     */
    @JsonProperty("RequestId")
    private String requestId;

    /**
     * 描述：短信发送总条数。
     * 示例：1
     */
    @JsonProperty("TotalCount")
    private String totalCount;

    /**
     * 描述：短信发送明细。
     */
    @JsonProperty("SmsSendDetailDTOs")
    private SmsSendDetailDTOs SmsSendDetailDTOs;
}
