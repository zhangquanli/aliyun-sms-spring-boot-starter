package com.github.zhangquanli.aliyun.sms;

import com.github.zhangquanli.aliyun.sms.http.AbstractHttpClient;
import com.github.zhangquanli.aliyun.sms.request.*;
import com.github.zhangquanli.aliyun.sms.response.*;

import static com.github.zhangquanli.aliyun.sms.constants.AliyunSmsAction.*;

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
        String url = buildUrl(SEND_SMS, sendSmsRequest);
        String responseJson = get(url);
        return convert(responseJson, SendSmsResponse.class);
    }

    @Override
    public SendBatchSmsResponse sendBatchSms(SendBatchSmsRequest sendBatchSmsRequest) {
        String url = buildUrl(SEND_BATCH_SMS, sendBatchSmsRequest);
        String responseJson = get(url);
        return convert(responseJson, SendBatchSmsResponse.class);
    }

    @Override
    public QuerySendDetailsResponse querySendDetails(QuerySendDetailsRequest querySendDetailsRequest) {
        String url = buildUrl(QUERY_SEND_DETAILS, querySendDetailsRequest);
        String responseJson = get(url);
        return convert(responseJson, QuerySendDetailsResponse.class);
    }

    @Override
    public AddSmsSignResponse addSmsSign(AddSmsSignRequest addSmsSignRequest) {
        String url = buildUrl(ADD_SMS_SIGN, addSmsSignRequest);
        String responseJson = get(url);
        return convert(responseJson, AddSmsSignResponse.class);
    }

    @Override
    public DeleteSmsSignResponse deleteSmsSign(DeleteSmsSignRequest deleteSmsSignRequest) {
        String url = buildUrl(DELETE_SMS_SIGN, deleteSmsSignRequest);
        String responseJson = get(url);
        return convert(responseJson, DeleteSmsSignResponse.class);
    }

    @Override
    public ModifySmsSignResponse modifySmsSign(ModifySmsSignRequest modifySmsSignRequest) {
        String url = buildUrl(MODIFY_SMS_SIGN, modifySmsSignRequest);
        String responseJson = get(url);
        return convert(responseJson, ModifySmsSignResponse.class);
    }

    @Override
    public QuerySmsSignResponse querySmsSign(QuerySmsSignRequest querySmsSignRequest) {
        String url = buildUrl(QUERY_SMS_SIGN, querySmsSignRequest);
        String responseJson = get(url);
        return convert(responseJson, QuerySmsSignResponse.class);
    }

    @Override
    public AddSmsTemplateResponse addSmsTemplate(AddSmsTemplateRequest addSmsTemplateRequest) {
        String url = buildUrl(ADD_SMS_TEMPLATE, addSmsTemplateRequest);
        String responseJson = get(url);
        return convert(responseJson, AddSmsTemplateResponse.class);
    }

    @Override
    public DeleteSmsTemplateResponse deleteSmsTemplate(DeleteSmsTemplateRequest deleteSmsTemplateRequest) {
        String url = buildUrl(DELETE_SMS_TEMPLATE, deleteSmsTemplateRequest);
        String responseJson = get(url);
        return convert(responseJson, DeleteSmsTemplateResponse.class);
    }

    @Override
    public ModifySmsTemplateResponse modifySmsTemplate(ModifySmsTemplateRequest modifySmsTemplateRequest) {
        String url = buildUrl(MODIFY_SMS_TEMPLATE, modifySmsTemplateRequest);
        String responseJson = get(url);
        return convert(responseJson, ModifySmsTemplateResponse.class);
    }

    @Override
    public QuerySmsTemplateResponse querySmsTemplate(QuerySmsTemplateRequest querySmsTemplateRequest) {
        String url = buildUrl(QUERY_SMS_TEMPLATE, querySmsTemplateRequest);
        String responseJson = get(url);
        return convert(responseJson, QuerySmsTemplateResponse.class);
    }
}
