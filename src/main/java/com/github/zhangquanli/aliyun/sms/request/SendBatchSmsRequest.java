package com.github.zhangquanli.aliyun.sms.request;

import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SendBatchSmsRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendBatchSmsRequest extends AbstractRequest {

    /**
     * 描述：接收短信的手机号码，JSON数组格式。
     * 示例：["15900000000","13500000000"]
     * 是否必填：是
     */
    private String phoneNumberJson;
    /**
     * 描述：短信签名名称，JSON数组格式。
     * 示例：["阿里云","阿里巴巴"]
     * 是否必填：是
     */
    private String signNameJson;
    /**
     * 描述：短信模板CODE。
     * 示例：SMS_152550005
     * 是否必填：是
     */
    private String templateCode;
    /**
     * 描述：短信模板变量对应的实际值，JSON格式。
     * 示例：[{"name":"TemplateParamJson"},{"name":"TemplateParamJson"}]
     * 是否必填：否
     */
    private String templateParamJson;
    /**
     * 描述：上行短信扩展码，JSON数组格式。无特殊需要此字段的用户请忽略此字段。
     * 示例：["90999","90998"]
     * 是否必填：否
     */
    private String smsUpExtendCodeJson;
}
