package com.github.zhangquanli.aliyun.sms.request;

import java.util.Map;

/**
 * AliyunSmsRequest
 *
 * @author zhangquanli
 */
public interface AliyunSmsRequest {

    /**
     * 获取键值对
     *
     * @return 键值对
     */
    Map<String, String> toMap();
}
