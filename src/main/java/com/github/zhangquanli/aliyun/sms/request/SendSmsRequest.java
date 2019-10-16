package com.github.zhangquanli.aliyun.sms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * SendSmsRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendSmsRequest implements AliyunSmsRequest {

    /**
     * 描述：接收短信的手机号码。支持对多个手机号码发送短信，手机号码之间以英文逗号（,）分隔。
     * 示例：15900000000
     * 是否必填：是
     */
    private String phoneNumbers;
    /**
     * 描述：短信签名名称。
     * 示例：阿里云
     * 是否必填：是
     */
    private String signName;
    /**
     * 描述：短信模板CODE。
     * 示例：SMS_153055065
     * 是否必填：是
     */
    private String templateCode;
    /**
     * 描述：短信模板变量对应的实际值，JSON格式。
     * 示例：{"code":"1111"}
     * 是否必填：否
     */
    private String templateParam;
    /**
     * 描述：上行短信扩展码，无特殊需要此字段的用户请忽略此字段。
     * 示例：90999
     * 是否必填：否
     */
    private String smsUpExtendCode;
    /**
     * 描述：外部流水扩展字段。
     * 示例：abcdefgh
     * 是否必填：否
     */
    private String outId;

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>(6);
        // 必填
        if (phoneNumbers == null) {
            throw new RuntimeException("phoneNumbers can not be null");
        }
        map.put("PhoneNumbers", phoneNumbers);
        if (signName == null) {
            throw new RuntimeException("signName can not be null");
        }
        map.put("SignName", signName);
        if (templateCode == null) {
            throw new RuntimeException("templateCode can not be null");
        }
        map.put("TemplateCode", templateCode);
        // 非必填
        if (templateParam != null) {
            map.put("TemplateParam", templateParam);
        }
        if (smsUpExtendCode != null) {
            map.put("SmsUpExtendCode", smsUpExtendCode);
        }
        if (outId != null) {
            map.put("OutId", outId);
        }
        return map;
    }
}
