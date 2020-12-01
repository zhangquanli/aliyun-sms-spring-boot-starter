package com.github.zhangquanli.aliyun.sms;

import com.github.zhangquanli.aliyun.sms.http.AbstractHttpClient;
import com.github.zhangquanli.aliyun.sms.request.*;
import com.github.zhangquanli.aliyun.sms.response.*;

import static com.github.zhangquanli.aliyun.sms.AliyunSmsAction.*;

/**
 * AliyunSmsImpl
 *
 * @author zhangquanli
 */
public class AliyunSmsImpl extends AbstractHttpClient implements AliyunSms {
    public AliyunSmsImpl(AliyunSmsProperties aliyunSmsProperties) {
        super(aliyunSmsProperties);
    }

    @Override
    public SendSmsResponse sendSms(SendSmsRequest sendSmsRequest) {
        return get(buildUrl(SEND_SMS, sendSmsRequest), SendSmsResponse.class);
    }

    @Override
    public SendBatchSmsResponse sendBatchSms(SendBatchSmsRequest sendBatchSmsRequest) {
        return get(buildUrl(SEND_BATCH_SMS, sendBatchSmsRequest), SendBatchSmsResponse.class);
    }

    @Override
    public QuerySendDetailsResponse querySendDetails(QuerySendDetailsRequest querySendDetailsRequest) {
        return get(buildUrl(QUERY_SEND_DETAILS, querySendDetailsRequest), QuerySendDetailsResponse.class);
    }

    @Override
    public AddSmsSignResponse addSmsSign(AddSmsSignRequest addSmsSignRequest) {
        return get(buildUrl(ADD_SMS_SIGN, addSmsSignRequest), AddSmsSignResponse.class);
    }

    @Override
    public DeleteSmsSignResponse deleteSmsSign(DeleteSmsSignRequest deleteSmsSignRequest) {
        return get(buildUrl(DELETE_SMS_SIGN, deleteSmsSignRequest), DeleteSmsSignResponse.class);
    }

    @Override
    public ModifySmsSignResponse modifySmsSign(ModifySmsSignRequest modifySmsSignRequest) {
        return get(buildUrl(MODIFY_SMS_SIGN, modifySmsSignRequest), ModifySmsSignResponse.class);
    }

    @Override
    public QuerySmsSignResponse querySmsSign(QuerySmsSignRequest querySmsSignRequest) {
        return get(buildUrl(QUERY_SMS_SIGN, querySmsSignRequest), QuerySmsSignResponse.class);
    }

    @Override
    public AddSmsTemplateResponse addSmsTemplate(AddSmsTemplateRequest addSmsTemplateRequest) {
        return get(buildUrl(ADD_SMS_TEMPLATE, addSmsTemplateRequest), AddSmsTemplateResponse.class);
    }

    @Override
    public DeleteSmsTemplateResponse deleteSmsTemplate(DeleteSmsTemplateRequest deleteSmsTemplateRequest) {
        return get(buildUrl(DELETE_SMS_TEMPLATE, deleteSmsTemplateRequest), DeleteSmsTemplateResponse.class);
    }

    @Override
    public ModifySmsTemplateResponse modifySmsTemplate(ModifySmsTemplateRequest modifySmsTemplateRequest) {
        return get(buildUrl(MODIFY_SMS_TEMPLATE, modifySmsTemplateRequest), ModifySmsTemplateResponse.class);
    }

    @Override
    public QuerySmsTemplateResponse querySmsTemplate(QuerySmsTemplateRequest querySmsTemplateRequest) {
        return get(buildUrl(QUERY_SMS_TEMPLATE, querySmsTemplateRequest), QuerySmsTemplateResponse.class);
    }
}
