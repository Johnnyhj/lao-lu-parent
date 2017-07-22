package com.ai.ge.platform.model.sys;

import java.util.Date;

public class SystemAccessBlackList {
    private Long id;

    private String blIp;

    private Date blTime;

    private Long blAccNum;

    private String blAccThreshold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlIp() {
        return blIp;
    }

    public void setBlIp(String blIp) {
        this.blIp = blIp == null ? null : blIp.trim();
    }

    public Date getBlTime() {
        return blTime;
    }

    public void setBlTime(Date blTime) {
        this.blTime = blTime;
    }

    public Long getBlAccNum() {
        return blAccNum;
    }

    public void setBlAccNum(Long blAccNum) {
        this.blAccNum = blAccNum;
    }

    public String getBlAccThreshold() {
        return blAccThreshold;
    }

    public void setBlAccThreshold(String blAccThreshold) {
        this.blAccThreshold = blAccThreshold == null ? null : blAccThreshold.trim();
    }
}