package com.github.zhangquanli.aliyun.sms;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * AliyunSmsProperties
 *
 * @author zhangquanli
 */
@ConfigurationProperties(prefix = "aliyun.sms")
public class AliyunSmsProperties {

    private String accessKeyId;
    private String accessKeySecret;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
