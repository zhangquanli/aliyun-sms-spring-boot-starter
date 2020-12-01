package com.github.zhangquanli.aliyun.sms;

/**
 * AliyunSmsException
 *
 * @author zhangquanli
 */
public class AliyunSmsException extends RuntimeException {
    public AliyunSmsException(String message) {
        super(message);
    }

    public AliyunSmsException(String message, Throwable cause) {
        super(message, cause);
    }
}
