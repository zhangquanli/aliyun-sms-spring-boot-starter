package com.github.zhangquanli.aliyun.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * QuerySmsTemplateResponse
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySmsTemplateResponse extends AbstractResponse {

    /**
     * 描述：请求状态码。返回OK代表请求成功。
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
     * 描述：短信模板CODE。
     * 示例：SMS_152550005
     */
    @JsonProperty("TemplateCode")
    private String templateCode;
    /**
     * 描述：短信类型。其中：
     * 0：验证码。
     * 1：短信通知。
     * 2：推广短信。
     * 3：国际/港澳台消息。
     * 示例：1
     */
    @JsonProperty("TemplateType")
    private Integer templateType;
    /**
     * 描述：模板名称。
     * 示例：阿里云短信测试模板
     */
    @JsonProperty("TemplateName")
    private String templateName;
    /**
     * 描述：模板内容。
     * 示例：亲爱的会员！阿里云短信服务祝您新年快乐！
     */
    @JsonProperty("TemplateContent")
    private String templateContent;
    /**
     * 描述：
     * 模板审核状态。其中：
     * 0：审核中。
     * 1：审核通过。
     * 2：审核失败，请在返回参数Reason中查看审核失败原因。
     * 示例：1
     */
    @JsonProperty("TemplateStatus")
    private Integer templateStatus;
    /**
     * 描述：审核备注。
     * 如果审核状态为审核通过或审核中，参数Reason显示为“无审核备注”。
     * 如果审核状态为审核未通过，参数Reason显示审核的具体原因。
     * 示例：非验证码类型短信，请选择短信通知类型为推广短信。
     */
    @JsonProperty("Reason")
    private String reason;
    /**
     * 描述：短信模板的创建日期和时间。
     * 示例：2019-06-04 11:42:17
     */
    @JsonProperty("CreateDate")
    private String createDate;
}
