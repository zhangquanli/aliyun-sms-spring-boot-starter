package com.github.zhangquanli.aliyun.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * QuerySmsSignResponse
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySmsSignResponse {

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
    /**
     * 描述：签名审核状态。其中：
     * 0：审核中。
     * 1：审核通过。
     * 2：审核失败，请在返回参数Reason中查看审核失败原因。
     * 示例：1
     */
    @JsonProperty("SignStatus")
    private String signStatus;
    /**
     * 描述：审核备注。
     * 如果审核状态为审核通过或审核中，参数Reason显示为“无审核备注”。
     * 如果审核状态为审核未通过，参数Reason显示审核的具体原因。
     * 示例：文件不能证明信息真实性，请重新上传
     */
    @JsonProperty("Reason")
    private String reason;
    /**
     * 描述：短信签名的创建日期和时间。
     * 示例：2019-01-08 16:44:13
     */
    @JsonProperty("CreateDate")
    private String createDate;
}
