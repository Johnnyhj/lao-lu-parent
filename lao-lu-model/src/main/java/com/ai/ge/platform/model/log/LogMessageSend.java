package com.ai.ge.platform.model.log;

import java.util.Date;

public class LogMessageSend implements LoggerStorageObject{
    private Long messageSendId;

    private String receiveNum;

    private Short channel;

    private Short type;

    private String sendText;

    private Date createTime;

    private Short status;

    private String failReason;

    private Short repeatSendNum;

    private String area;

    private String remarks;

    private String title;

    private Short readStatus;

    /**
     * 搜索关键字
     */
    private String keyword;

    public String getKeyword()
    {
        return keyword;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public Long getMessageSendId() {
        return messageSendId;
    }

    public void setMessageSendId(Long messageSendId) {
        this.messageSendId = messageSendId;
    }

    public String getReceiveNum() {
        return receiveNum;
    }

    public void setReceiveNum(String receiveNum) {
        this.receiveNum = receiveNum;
    }

    public Short getChannel() {
        return channel;
    }

    public void setChannel(Short channel) {
        this.channel = channel;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getSendText() {
        return sendText;
    }

    public void setSendText(String sendText) {
        this.sendText = sendText;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Short getRepeatSendNum() {
        return repeatSendNum;
    }

    public void setRepeatSendNum(Short repeatSendNum) {
        this.repeatSendNum = repeatSendNum;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Short readStatus) {
        this.readStatus = readStatus;
    }

    @Override
    public String toString()
    {
        return "LogMessageSend{" + "messageSendId=" + messageSendId + ", receiveNum='" + receiveNum + '\'' + ", channel=" + channel + ", type=" + type + ", sendText='" + sendText + '\'' + ", createTime=" + createTime + ", status=" + status + ", failReason='" + failReason + '\'' + ", repeatSendNum=" + repeatSendNum + ", area='" + area + '\'' + ", remarks='" + remarks + '\'' + ", title='" + title + '\'' + ", readStatus=" + readStatus + ", keyword='" + keyword + '\'' + '}';
    }
}