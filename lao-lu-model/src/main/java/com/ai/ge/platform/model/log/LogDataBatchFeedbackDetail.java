package com.ai.ge.platform.model.log;

import java.util.Date;

public class LogDataBatchFeedbackDetail {
    private Integer logFeedbackDetailId;

    private Integer logFeedbackId;

    private Integer splitBlock;

    private Integer dataNum;

    private String splitFilePath;

    private Integer splitStatus;

    private Integer pushStatus;

    private Integer pushRepeat;

    private String pushInterfaceFeedback;

    private Date pushTime;

    private Date pushCompleteTime;

    private Date createTime;

    private Integer interfaceCallId;

    public Integer getLogFeedbackDetailId() {
        return logFeedbackDetailId;
    }

    public void setLogFeedbackDetailId(Integer logFeedbackDetailId) {
        this.logFeedbackDetailId = logFeedbackDetailId;
    }

    public Integer getLogFeedbackId() {
        return logFeedbackId;
    }

    public void setLogFeedbackId(Integer logFeedbackId) {
        this.logFeedbackId = logFeedbackId;
    }

    public Integer getSplitBlock() {
        return splitBlock;
    }

    public void setSplitBlock(Integer splitBlock) {
        this.splitBlock = splitBlock;
    }

    public Integer getDataNum() {
        return dataNum;
    }

    public void setDataNum(Integer dataNum) {
        this.dataNum = dataNum;
    }

    public String getSplitFilePath() {
        return splitFilePath;
    }

    public void setSplitFilePath(String splitFilePath) {
        this.splitFilePath = splitFilePath == null ? null : splitFilePath.trim();
    }

    public Integer getSplitStatus() {
        return splitStatus;
    }

    public void setSplitStatus(Integer splitStatus) {
        this.splitStatus = splitStatus;
    }

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Integer getPushRepeat() {
        return pushRepeat;
    }

    public void setPushRepeat(Integer pushRepeat) {
        this.pushRepeat = pushRepeat;
    }

    public String getPushInterfaceFeedback() {
        return pushInterfaceFeedback;
    }

    public void setPushInterfaceFeedback(String pushInterfaceFeedback) {
        this.pushInterfaceFeedback = pushInterfaceFeedback == null ? null : pushInterfaceFeedback.trim();
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Date getPushCompleteTime() {
        return pushCompleteTime;
    }

    public void setPushCompleteTime(Date pushCompleteTime) {
        this.pushCompleteTime = pushCompleteTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getInterfaceCallId() {
        return interfaceCallId;
    }

    public void setInterfaceCallId(Integer interfaceCallId) {
        this.interfaceCallId = interfaceCallId;
    }
}