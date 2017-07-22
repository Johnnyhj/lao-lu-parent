package com.ai.ge.platform.model.log;

import java.util.Date;

public class LogDataBatchFeedback {
    private Integer logFeedbackId;

    private String pushSeq;

    private Integer pushVersion;

    private String sourceFilePath;

    private Integer createStatus;

    private Integer splitStatus;

    private Integer pushStatus;

    private Date fileCreateTime;

    private Date splitTime;

    private Date pushTime;

    private Date pushCompleteTime;

    private String splitFailReason;

    private Date createTime;

    public Integer getLogFeedbackId() {
        return logFeedbackId;
    }

    public void setLogFeedbackId(Integer logFeedbackId) {
        this.logFeedbackId = logFeedbackId;
    }

    public String getPushSeq() {
        return pushSeq;
    }

    public void setPushSeq(String pushSeq) {
        this.pushSeq = pushSeq == null ? null : pushSeq.trim();
    }

    public Integer getPushVersion() {
        return pushVersion;
    }

    public void setPushVersion(Integer pushVersion) {
        this.pushVersion = pushVersion;
    }

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath == null ? null : sourceFilePath.trim();
    }

    public Integer getCreateStatus() {
        return createStatus;
    }

    public void setCreateStatus(Integer createStatus) {
        this.createStatus = createStatus;
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

    public Date getFileCreateTime() {
        return fileCreateTime;
    }

    public void setFileCreateTime(Date fileCreateTime) {
        this.fileCreateTime = fileCreateTime;
    }

    public Date getSplitTime() {
        return splitTime;
    }

    public void setSplitTime(Date splitTime) {
        this.splitTime = splitTime;
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

    public String getSplitFailReason() {
        return splitFailReason;
    }

    public void setSplitFailReason(String splitFailReason) {
        this.splitFailReason = splitFailReason == null ? null : splitFailReason.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}