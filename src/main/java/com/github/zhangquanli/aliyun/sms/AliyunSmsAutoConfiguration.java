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
@ConditionalOnProperty(prefix = "aliyun.sms", name = {"access-key-id", "access-key-secret"})
@EnableConfigurationProperties(AliyunSmsProperties.class)
@Configuration
public class AliyunSmsAutoConfiguration {
    @Bean
    public AliyunSms aliyunSms(AliyunSmsProperties aliyunSmsProperties) {
        return new AliyunSmsImpl(aliyunSmsProperties);
    }
}
