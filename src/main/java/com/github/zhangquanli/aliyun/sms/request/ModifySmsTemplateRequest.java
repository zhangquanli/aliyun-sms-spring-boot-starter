package com.github.zhangquanli.aliyun.sms.request;

import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ModifySmsTemplateRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifySmsTemplateRequest extends AbstractRequest {

    /**
     * 示例：短信模板CODE。
     * 示例：SMS_152550005
     * 是否必填：是
     */
    private String templateCode;
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
}
