package com.ai.ge.platform.model.log;

import java.util.Date;

public class LogInterfaceCall implements LoggerStorageObject {
    private Long interfaceCallId;

    private String phoneNum;

    private String url;

    private String actionName;

    private Date requestTimes;

    private Short httpCode;

    private Date responseTimes;

    private Integer interfaceCallTimes;

    private Short result;

    private String externalOrderSeq;

    private String orderGroupSeq;

    private Short repeateCallNum;

    private Date createTime;

    private String remarks;

    public Long getInterfaceCallId() {
        return interfaceCallId;
    }

    public void setInterfaceCallId(Long interfaceCallId) {
        this.interfaceCallId = interfaceCallId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Date getRequestTimes() {
        return requestTimes;
    }

    public void setRequestTimes(Date requestTimes) {
        this.requestTimes = requestTimes;
    }

    public Short getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Short httpCode) {
        this.httpCode = httpCode;
    }

    public Date getResponseTimes() {
        return responseTimes;
    }

    public void setResponseTimes(Date responseTimes) {
        this.responseTimes = responseTimes;
    }

    public Integer getInterfaceCallTimes() {
        return interfaceCallTimes;
    }

    public void setInterfaceCallTimes(Integer interfaceCallTimes) {
        this.interfaceCallTimes = interfaceCallTimes;
    }

    public Short getResult() {
        return result;
    }

    public void setResult(Short result) {
        this.result = result;
    }

    public String getExternalOrderSeq() {
        return externalOrderSeq;
    }

    public void setExternalOrderSeq(String externalOrderSeq) {
        this.externalOrderSeq = externalOrderSeq;
    }

    public String getOrderGroupSeq() {
        return orderGroupSeq;
    }

    public void setOrderGroupSeq(String orderGroupSeq) {
        this.orderGroupSeq = orderGroupSeq;
    }

    public Short getRepeateCallNum() {
        return repeateCallNum;
    }

    public void setRepeateCallNum(Short repeateCallNum) {
        this.repeateCallNum = repeateCallNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}