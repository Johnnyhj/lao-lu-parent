package com.ai.ge.platform.serviceimpl.http.zhima;

import com.ai.ge.platform.service.http.HttpRequestObject;
import org.apache.commons.lang.CharEncoding;

/**
 *
 */
public class ZhimaHttpRequestObject extends HttpRequestObject {

    /**
     * 加密加签时使用的charset
     */
    private String charset = CharEncoding.UTF_8;
    /**
     * 要调用的接口名
     */
    private String method;
    /**
     * 接口版本，目前只支持1.0
     */
    private String version = "1.0";
    /**
     * 来源平台，默认为zmop
     */
    private String platform = "zmop";
    /**
     * RSA加密后的业务参数
     */
    private String params;
    /**
     * 对params参数加密前的签名,算法为SHA1WithRSA
     */
    private String sign;
    /**
     * 商户传入的业务流水号。此字段由商户生成，需确保唯一性，用于定位每一次请求，后续按此流水进行对帐。
     * 生成规则: 固定30位数字串，前17位为精确到毫秒的时间yyyyMMddhhmmssSSS，后13位为自增数字。
     */
    private String transactionId;


    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
