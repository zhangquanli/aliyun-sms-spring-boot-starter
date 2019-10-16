package com.github.zhangquanli.aliyun.sms;

import com.github.zhangquanli.aliyun.sms.request.*;
import com.github.zhangquanli.aliyun.sms.response.*;

/**
 * 阿里云短信服务
 * <br/>
 * 官方文档地址：https://help.aliyun.com/document_detail/101300.html
 *
 * @author zhangquanli
 */
public interface AliyunSms {

    /**
     * 短信发送接口，支持在一次请求中向多个不同的手机号码发送同样内容的短信
     */
    SendSmsResponse sendSms(SendSmsRequest request);

    /**
     * 短信批量发送接口，支持在一次请求中分别向多个不同的手机号码发送不同签名的短信
     */
    SendBatchSmsResponse sendBatchSms(SendBatchSmsRequest request);

    /**
     * 查询发送记录
     */
    QuerySendDetailsResponse querySendDetails(QuerySendDetailsRequest request);

    /**
     * 申请短信签名
     */
    AddSmsSignResponse addSmsSign(AddSmsSignRequest request);

    /**
     * 删除短信签名
     */
    DeleteSmsSignResponse deleteSmsSign(DeleteSmsSignRequest request);

    /**
     * 修改未审核通过的短信签名，并重新提交审核
     */
    ModifySmsSignResponse modifySmsSign(ModifySmsSignRequest request);

    /**
     * 查询短信签名的审批状态
     */
    QuerySmsSignResponse querySmsSign(QuerySmsSignRequest request);

    /**
     * 申请短信模板
     */
    AddSmsTemplateResponse addSmsTemplate(AddSmsTemplateRequest request);

    /**
     * 删除短信模板
     */
    DeleteSmsTemplateResponse deleteSmsTemplate(DeleteSmsTemplateRequest request);

    /**
     * 修改未审核通过的短信模板，并重新提交审核
     */
    ModifySmsTemplateResponse modifySmsTemplate(ModifySmsTemplateRequest request);

    /**
     * 查询短信模板的审核状态
     */
    QuerySmsTemplateResponse querySmsTemplate(QuerySmsTemplateRequest request);
}
