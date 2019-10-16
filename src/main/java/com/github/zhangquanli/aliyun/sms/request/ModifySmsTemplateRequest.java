package com.github.zhangquanli.aliyun.sms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * ModifySmsTemplateRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifySmsTemplateRequest implements AliyunSmsRequest {

    /**
     * 描述：短信类型。其中：
     * 0：验证码。
     * 1：短信通知。
     * 2：推广短信。
     * 3：国际/港澳台消息。
     * 示例：1
     * 是否必填：是
     */
    private Integer templateType;
    /**
     * 描述：模板名称，长度为1~30个字符。
     * 示例：阿里云短信测试模板
     * 是否必填：是
     */
    private String templateName;
    /**
     * 描述：模板内容，长度为1~500个字符。
     * 示例：您正在申请手机注册，验证码为：${code}，5分钟内有效！
     * 是否必填：是
     */
    private String templateContent;
    /**
     * 描述：短信模板申请说明。请在申请说明中描述您的业务使用场景，长度为1~100个字符。
     * 示例：当前的短信模板应用于双11大促推广营销
     * 是否必填：是
     */
    private String remark;

    @Override
    public Map<String, String> toMap() {
        if (templateType == null) {
            throw new RuntimeException("templateType can not be null");
        }
        if (templateName == null) {
            throw new RuntimeException("templateName can not be null");
        }
        if (templateContent == null) {
            throw new RuntimeException("templateContent can not be null");
        }
        if (remark == null) {
            throw new RuntimeException("remark can not be null");
        }
        Map<String, String> map = new HashMap<>(4);
        map.put("TemplateType", templateType.toString());
        map.put("TemplateName", templateName);
        map.put("TemplateContent", templateContent);
        map.put("Remark", remark);
        return map;
    }
}
