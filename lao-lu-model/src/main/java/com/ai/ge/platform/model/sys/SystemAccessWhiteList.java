package com.ai.ge.platform.model.sys;

import java.util.Date;

public class SystemAccessWhiteList {
    private Long id;

    private String wlIp;

    private Date wlTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWlIp() {
        return wlIp;
    }

    public void setWlIp(String wlIp) {
        this.wlIp = wlIp == null ? null : wlIp.trim();
    }

    public Date getWlTime() {
        return wlTime;
    }

    public void setWlTime(Date wlTime) {
        this.wlTime = wlTime;
    }
}