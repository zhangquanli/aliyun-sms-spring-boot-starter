package com.github.zhangquanli.aliyun.sms.request;

import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * QuerySmsTemplateRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySmsTemplateRequest extends AbstractRequest {

    /**
     * 描述：短信模板CODE。
     * 示例：SMS_152550005
     * 是否必填：是
     */
    private String templateCode;
}
