package com.github.zhangquanli.aliyun.sms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * SendBatchSmsRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendBatchSmsRequest implements AliyunSmsRequest {

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

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>(5);
        // 必填
        if (phoneNumberJson == null) {
            throw new RuntimeException("phoneNumberJson can not be null");
        }
        map.put("PhoneNumberJson", phoneNumberJson);
        if (signNameJson == null) {
            throw new RuntimeException("signNameJson can not be null");
        }
        map.put("SignNameJson", signNameJson);
        if (templateCode == null) {
            throw new RuntimeException("templateCode can not be null");
        }
        map.put("TemplateCode", templateCode);
        // 非必填
        if (templateParamJson != null) {
            map.put("TemplateParamJson", templateParamJson);
        }
        if (smsUpExtendCodeJson != null) {
            map.put("SmsUpExtendCodeJson", smsUpExtendCodeJson);
        }
        return map;
    }
}
