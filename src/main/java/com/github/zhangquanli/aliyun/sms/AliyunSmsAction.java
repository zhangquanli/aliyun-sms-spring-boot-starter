package com.github.zhangquanli.aliyun.sms;

/**
 * AliyunSmsAction
 *
 * @author zhangquanli
 */
public interface AliyunSmsAction {
    // ~ 短信发送接口
    // =================================================================================================================

    /**
     * 发送短信
     */
    String SEND_SMS = "SendSms";
    /**
     * 批量发送短信
     */
    String SEND_BATCH_SMS = "SendBatchSms";

    // ~ 短信查询接口
    // =================================================================================================================

    /**
     * 查询短信发送的状态
     */
    String QUERY_SEND_DETAILS = "QuerySendDetails";

    // ~ 签名申请接口
    // =================================================================================================================

    /**
     * 申请短信签名
     */
    String ADD_SMS_SIGN = "AddSmsSign";
    /**
     * 删除短信签名
     */
    String DELETE_SMS_SIGN = "DeleteSmsSign";
    /**
     * 修改未通过审核的短信签名，并重新提交审核
     */
    String MODIFY_SMS_SIGN = "ModifySmsSign";
    /**
     * 查询短信签名的审核状态
     */
    String QUERY_SMS_SIGN = "QuerySmsSign";

    // ~ 模板申请接口
    // =================================================================================================================

    /**
     * 申请短信模板
     */
    String ADD_SMS_TEMPLATE = "AddSmsTemplate";
    /**
     * 删除短信模板
     */
    String DELETE_SMS_TEMPLATE = "DeleteSmsTemplate";
    /**
     * 修改未通过审核的短信模板，并重新提交审核
     */
    String MODIFY_SMS_TEMPLATE = "ModifySmsTemplate";
    /**
     * 查询短信模板的审核状态
     */
    String QUERY_SMS_TEMPLATE = "QuerySmsTemplate";
}
