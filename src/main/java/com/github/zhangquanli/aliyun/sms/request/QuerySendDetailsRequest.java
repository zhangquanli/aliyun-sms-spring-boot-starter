package com.github.zhangquanli.aliyun.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.aliyun.sms.http.AbstractRequest;

/**
 * QuerySendDetailsRequest
 *
 * @author zhangquanli
 */
public class QuerySendDetailsRequest extends AbstractRequest {

    /**
     * 描述：分页查看发送记录，指定发送记录的的当前页码。
     * 示例：1
     * 是否必填：是
     */
    @JsonProperty("CurrentPage")
    private Long currentPage;
    /**
     * 描述：分页查看发送记录，指定每页显示的短信记录数量。取值范围为1~50。
     * 示例：10
     * 是否必填：是
     */
    @JsonProperty("PageSize")
    private Long pageSize;
    /**
     * 描述：接收短信的手机号码。
     * 示例：15900000000
     * 是否必填：是
     */
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
    /**
     * 描述：短信发送日期，支持查询最近30天的记录。格式为yyyyMMdd。
     * 示例：20181228
     * 是否必填：是
     */
    @JsonProperty("SendDate")
    private String sendDate;
    /**
     * 描述：发送回执ID，即发送流水号。调用发送接口SendSms或SendBatchSms发送短信时，返回值中的BizId字段。
     * 示例：134523^4351232
     * 是否必填：否
     */
    @JsonProperty("BizId")
    private String bizId;

    private QuerySendDetailsRequest(Long currentPage, Long pageSize, String phoneNumber, String sendDate, String bizId) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.phoneNumber = phoneNumber;
        this.sendDate = sendDate;
        this.bizId = bizId;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSendDate() {
        return sendDate;
    }

    public String getBizId() {
        return bizId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long currentPage;
        private Long pageSize;
        private String phoneNumber;
        private String sendDate;
        private String bizId;

        public Builder() {
        }

        public Builder currentPage(Long currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        public Builder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder sendDate(String sendDate) {
            this.sendDate = sendDate;
            return this;
        }

        public Builder bizId(String bizId) {
            this.bizId = bizId;
            return this;
        }

        public QuerySendDetailsRequest build() {
            return new QuerySendDetailsRequest(currentPage, pageSize, phoneNumber, sendDate, bizId);
        }
    }
}
