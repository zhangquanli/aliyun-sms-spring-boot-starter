package com.github.zhangquanli.aliyun.sms;

import com.github.zhangquanli.aliyun.sms.request.*;
import com.github.zhangquanli.aliyun.sms.response.*;

/**
 * 短信服务
 * <p>
 * 官方文档地址：https://help.aliyun.com/document_detail/101300.html
 *
 * @author zhangquanli
 */
public interface AliyunSms {
    // ~ 短信发送接口
    // =================================================================================================================

    /**
     * 短信发送接口，支持在一次请求中向多个不同的手机号码发送同样内容的短信
     */
    SendSmsResponse sendSms(SendSmsRequest sendSmsRequest);

    /**
     * 短信批量发送接口，支持在一次请求中分别向多个不同的手机号码发送不同签名的短信
     */
    SendBatchSmsResponse sendBatchSms(SendBatchSmsRequest sendBatchSmsRequest);

    // ~ 短信查询接口
    // =================================================================================================================

    /**
     * 查询发送记录
     */
    QuerySendDetailsResponse querySendDetails(QuerySendDetailsRequest querySendDetailsRequest);

    // ~ 签名申请接口
    // =================================================================================================================

    /**
     * 申请短信签名
     */
    AddSmsSignResponse addSmsSign(AddSmsSignRequest addSmsSignRequest);

    /**
     * 删除短信签名
     */
    DeleteSmsSignResponse deleteSmsSign(DeleteSmsSignRequest deleteSmsSignRequest);

    /**
     * 修改未审核通过的短信签名，并重新提交审核
     */
    ModifySmsSignResponse modifySmsSign(ModifySmsSignRequest modifySmsSignRequest);

    /**
     * 查询短信签名的审批状态
     */
    QuerySmsSignResponse querySmsSign(QuerySmsSignRequest querySmsSignRequest);

    // ~ 模板申请接口
    // =================================================================================================================

    /**
     * 申请短信模板
     */
    AddSmsTemplateResponse addSmsTemplate(AddSmsTemplateRequest addSmsTemplateRequest);

    /**
     * 删除短信模板
     */
    DeleteSmsTemplateResponse deleteSmsTemplate(DeleteSmsTemplateRequest deleteSmsTemplateRequest);

    /**
     * 修改未审核通过的短信模板，并重新提交审核
     */
    ModifySmsTemplateResponse modifySmsTemplate(ModifySmsTemplateRequest modifySmsTemplateRequest);

    /**
     * 查询短信模板的审核状态
     */
    QuerySmsTemplateResponse querySmsTemplate(QuerySmsTemplateRequest querySmsTemplateRequest);
}
