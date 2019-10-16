package com.github.zhangquanli.aliyun.sms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ModifySmsSignRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifySmsSignRequest implements AliyunSmsRequest {

    /**
     * 描述：签名名称。
     * 示例：阿里云
     * 是否必填：是
     */
    private String signName;
    /**
     * 描述：签名来源。其中：
     * 0：企事业单位的全称或简称。
     * 1：工信部备案网站的全称或简称。
     * 2：APP应用的全称或简称。
     * 3：公众号或小程序的全称或简称。
     * 4：电商平台店铺名的全称或简称。
     * 5：商标名的全称或简称
     * 示例：1
     */
    private Integer signSource;
    /**
     * 描述：短信签名申请说明。请在申请说明中详细描述您的业务使用场景，申请工信部备案网站的全称或简称请在此处填写域名，长度不超过200个字符。
     * 示例：当前的短信签名应用于双11大促推广营销
     */
    private String remark;

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>(3);
        if (signName == null) {
            throw new RuntimeException("signName can not be null");
        }
        map.put("SignName", signName);
        if (signSource == null) {
            throw new RuntimeException("signSource can not be null");
        }
        map.put("SignSource", signSource.toString());
        if (remark == null) {
            throw new RuntimeException("remark can not be null");
        }
        map.put("Remark", remark);
        return map;
    }
}
