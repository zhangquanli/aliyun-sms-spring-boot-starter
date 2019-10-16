package com.github.zhangquanli.aliyun.sms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * QuerySendDetailsRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySendDetailsRequest implements AliyunSmsRequest {

    /**
     * 描述：分页查看发送记录，指定发送记录的的当前页码。
     * 示例：1
     * 是否必填：是
     */
    private Long currentPage;
    /**
     * 描述：分页查看发送记录，指定每页显示的短信记录数量。取值范围为1~50。
     * 示例：10
     * 是否必填：是
     */
    private Long pageSize;
    /**
     * 描述：接收短信的手机号码。
     * 示例：15900000000
     * 是否必填：是
     */
    private String phoneNumber;
    /**
     * 描述：短信发送日期，支持查询最近30天的记录。格式为yyyyMMdd。
     * 示例：20181228
     * 是否必填：是
     */
    private String sendDate;
    /**
     * 描述：发送回执ID，即发送流水号。调用发送接口SendSms或SendBatchSms发送短信时，返回值中的BizId字段。
     * 示例：134523^4351232
     * 是否必填：否
     */
    private String bizId;

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>(5);
        // 必填
        if (currentPage == null) {
            throw new RuntimeException("currentPage can not be null");
        }
        map.put("CurrentPage", currentPage.toString());
        if (pageSize == null) {
            throw new RuntimeException("pageSize can not be null");
        }
        map.put("PageSize", pageSize.toString());
        if (phoneNumber == null) {
            throw new RuntimeException("phoneNumber can not be null");
        }
        map.put("PhoneNumber", phoneNumber);
        if (sendDate == null) {
            throw new RuntimeException("sendDate can not be null");
        }
        map.put("SendDate", sendDate);
        // 非必填
        if (bizId != null) {
            map.put("BizId", bizId);
        }
        return map;
    }
}
