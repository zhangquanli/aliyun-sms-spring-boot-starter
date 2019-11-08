package com.github.zhangquanli.aliyun.sms.request;

import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DeleteSmsSignRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteSmsSignRequest extends AbstractRequest {

    /**
     * 描述：短信签名。
     * 示例：阿里云
     * 是否必填：是
     */
    private String signName;
}
