package com.github.zhangquanli.aliyun.sms;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AliyunSmsAutoConfiguration
 *
 * @author zhangquanli
 */
@Configuration
@EnableConfigurationProperties(AliyunSmsProperties.class)
@ConditionalOnProperty(prefix = "aliyun.sms", name = {"access-key-id", "access-key-secret"})
public class AliyunSmsAutoConfiguration {

    private AliyunSmsProperties aliyunSmsProperties;

    public AliyunSmsAutoConfiguration(AliyunSmsProperties aliyunSmsProperties) {
        this.aliyunSmsProperties = aliyunSmsProperties;
    }

    @Bean
    public AliyunSms aliyunSms() {
        return new AliyunSmsImpl(aliyunSmsProperties);
    }
}
