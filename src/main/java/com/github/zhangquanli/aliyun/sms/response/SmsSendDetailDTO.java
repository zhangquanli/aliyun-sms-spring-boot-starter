package com.github.zhangquanli.aliyun.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SmsSendDetailDTO
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsSendDetailDTO {

    /**
     * 描述：运营商短信状态码。短信发送成功：DELIVRD；短信发送失败：失败错误码请参考错误码文档。https://help.aliyun.com/document_detail/101347.html
     * 示例：DELIVRD
     */
    @JsonProperty("ErrCode")
    private String errCode;
    /**
     * 描述：短信发送状态，包括：1：等待回执；2：发送失败；3：发送成功。
     * 示例：3
     */
    @JsonProperty("SendStatus")
    private Long sendStatus;
    /**
     * 描述：短信模板CODE。
     * 示例：SMS_122310183
     */
    @JsonProperty("TemplateCode")
    private String templateCode;
    /**
     * 描述：接收短信的手机号码。
     * 示例：15200000000
     */
    @JsonProperty("PhoneNum")
    private String phoneNum;
    /**
     * 描述：短信内容。
     * 示例：【阿里云】验证码为：123，您正在登录，若非本人操作，请勿泄露
     */
    @JsonProperty("Content")
    private String content;
    /**
     * 描述：短信发送日期和时间。
     * 示例：2019-01-08 16:44:10
     */
    @JsonProperty("SendDate")
    private String sendDate;
    /**
     * 描述：短信接收日期和时间。
     * 示例：2019-01-08 16:44:13
     */
    @JsonProperty("ReceiveDate")
    private String receiveDate;
    /**
     * 描述：外部流水扩展字段。
     * 示例：123
     */
    @JsonProperty("OutId")
    private String outId;
}
