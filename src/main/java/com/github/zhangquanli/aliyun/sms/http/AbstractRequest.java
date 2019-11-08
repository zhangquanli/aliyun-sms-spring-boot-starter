package com.github.zhangquanli.aliyun.sms.http;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.UUID;

/**
 * AbstractRequest
 *
 * @author zhangquanli
 */
public abstract class AbstractRequest {

    /**
     * 描述：访问密钥 ID。AccessKey 用于调用 API。
     * 示例：testId
     * 是否必填：是
     */
    @JsonProperty("AccessKeyId")
    private String accessKeyId;
    /**
     * 描述：API 的名称。
     * 示例：SendSms
     * 是否必填：是
     */
    @JsonProperty("Action")
    private String action;
    /**
     * 描述：返回参数的语言类型。取值范围：json | xml。默认值：json。
     * 示例：json
     * 是否必填：否
     */
    @JsonProperty("Format")
    private String format;
    /**
     * 描述：API支持的RegionID，如短信API的值为：cn-hangzhou。
     * 示例：cn-hangzhou
     * 是否必填：否
     */
    @JsonProperty("RegionId")
    private String regionId;
    /**
     * 描述：签名方式。取值范围：HMAC-SHA1。
     * 示例：HMAC-SHA1
     * 是否必填：是
     */
    @JsonProperty("SignatureMethod")
    private String signatureMethod;
    /**
     * 描述：签名唯一随机数。用于防止网络重放攻击，建议您每一次请求都使用不同的随机数。
     * 示例：313ef0fb-0393-464f-a6e2-59d9ca2585b1
     * 是否必填：是
     */
    @JsonProperty("SignatureNonce")
    private String signatureNonce;
    /**
     * 描述：签名算法版本。取值范围：1.0。
     * 示例：1.0
     * 是否必填：是
     */
    @JsonProperty("SignatureVersion")
    private String signatureVersion;
    /**
     * 描述：请求的时间戳。按照ISO8601 标准表示，并需要使用UTC时间，格式为yyyy-MM-ddTHH:mm:ssZ。
     * 示例：2018-01-01T12:00:00Z
     * 是否必填：是
     */
    @JsonProperty("Timestamp")
    private String timestamp;
    /**
     * 描述：API 的版本号，格式为 YYYY-MM-DD。取值范围：2017-05-25。
     * 示例：2017-05-25
     * 是否必填：是
     */
    @JsonProperty("Version")
    private String version;

    protected AbstractRequest() {
        this.format = format();
        this.regionId = regionId();
        this.signatureMethod = signatureMethod();
        this.signatureNonce = signatureNonce();
        this.signatureVersion = signatureVersion();
        this.timestamp = timestamp();
        this.version = version();
    }

    void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    void setAction(String action) {
        this.action = action;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAction() {
        return action;
    }

    public String getFormat() {
        return format;
    }

    public String getRegionId() {
        return regionId;
    }

    public String getSignatureMethod() {
        return signatureMethod;
    }

    public String getSignatureNonce() {
        return signatureNonce;
    }

    public String getSignatureVersion() {
        return signatureVersion;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getVersion() {
        return version;
    }

    private String format() {
        return "json";
    }

    private String regionId() {
        return "cn-hangzhou";
    }

    private String signatureMethod() {
        return "HMAC-SHA1";
    }

    private String signatureNonce() {
        return UUID.randomUUID().toString();
    }

    private String signatureVersion() {
        return "1.0";
    }

    private String timestamp() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return df.format(new Date());
    }

    private String version() {
        return "2017-05-25";
    }
}
