package com.github.zhangquanli.aliyun.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ModifySmsSignResponse
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifySmsSignResponse extends AbstractResponse {
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
     * 描述：签名名称。
     * 示例：阿里云
     */
    @JsonProperty("SignName")
    private String signName;
}
