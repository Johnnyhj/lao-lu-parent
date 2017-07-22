package com.ai.ge.platform.model.auth;

import java.util.Date;

public class SystemAuthorizationHistory {
    private Long sysAuthId;

    private String token;

    private String phoneNum;

    private String userName;

    private String password;

    private String reqIp;

    private Short authResult;

    private Short failReason;

    private String failReasonText;

    private Date createTime;

    private Date invalidTime;

    private Date tokenUseTime;

    public Long getSysAuthId() {
        return sysAuthId;
    }

    public void setSysAuthId(Long sysAuthId) {
        this.sysAuthId = sysAuthId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReqIp() {
        return reqIp;
    }

    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }

    public Short getAuthResult() {
        return authResult;
    }

    public void setAuthResult(Short authResult) {
        this.authResult = authResult;
    }

    public Short getFailReason() {
        return failReason;
    }

    public void setFailReason(Short failReason) {
        this.failReason = failReason;
    }

    public String getFailReasonText() {
        return failReasonText;
    }

    public void setFailReasonText(String failReasonText) {
        this.failReasonText = failReasonText;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public Date getTokenUseTime() {
        return tokenUseTime;
    }

    public void setTokenUseTime(Date tokenUseTime) {
        this.tokenUseTime = tokenUseTime;
    }
}