package com.ai.ge.platform.model.sys;

import java.util.Date;

public class SystemWarnProcess {
    private Long systemWarnProcessId;

    private String warnMessage;

    private String channel;

    private Long prcessId;

    private String prcessName;

    private String processResult;

    private Date createTime;

    private Date updateTime;

    private Date prcessTime;

    public Long getSystemWarnProcessId() {
        return systemWarnProcessId;
    }

    public void setSystemWarnProcessId(Long systemWarnProcessId) {
        this.systemWarnProcessId = systemWarnProcessId;
    }

    public String getWarnMessage() {
        return warnMessage;
    }

    public void setWarnMessage(String warnMessage) {
        this.warnMessage = warnMessage;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Long getPrcessId() {
        return prcessId;
    }

    public void setPrcessId(Long prcessId) {
        this.prcessId = prcessId;
    }

    public String getPrcessName() {
        return prcessName;
    }

    public void setPrcessName(String prcessName) {
        this.prcessName = prcessName;
    }

    public String getProcessResult() {
        return processResult;
    }

    public void setProcessResult(String processResult) {
        this.processResult = processResult;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPrcessTime() {
        return prcessTime;
    }

    public void setPrcessTime(Date prcessTime) {
        this.prcessTime = prcessTime;
    }
}