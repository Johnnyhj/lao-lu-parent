package com.ai.ge.platform.model.sys;

import com.ai.ge.platform.dto.user.SysUserDto;

import java.io.Serializable;
import java.util.Date;

public class SystemAuthorization implements Serializable{
    private static final long serialVersionUID = 6406083843023395438L;
    private Long sysAuthId;

    private String token;

    private String phoneNum;

    private String area;

    private String channel;

    private String reqIp;

    private Short authResult;

    private Short failReason;

    private String failReasonText;

    private Date createTime;

    private Date invalidTime;

    private Date tokenUseTime;

    private SysUserDto loginUser;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    public SysUserDto getLoginUser()
    {
        return loginUser;
    }

    public void setLoginUser(SysUserDto loginUser)
    {
        this.loginUser = loginUser;
    }
}