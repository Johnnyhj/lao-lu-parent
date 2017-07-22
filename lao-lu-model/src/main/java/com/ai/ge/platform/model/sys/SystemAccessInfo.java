package com.ai.ge.platform.model.sys;

import java.util.Date;

public class SystemAccessInfo {
    private Long id;

    private String accIp;

    private Date accTime;

    private String accMethod;

    private String reqUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccIp() {
        return accIp;
    }

    public void setAccIp(String accIp) {
        this.accIp = accIp == null ? null : accIp.trim();
    }

    public Date getAccTime() {
        return accTime;
    }

    public void setAccTime(Date accTime) {
        this.accTime = accTime;
    }

    public String getAccMethod() {
        return accMethod;
    }

    public void setAccMethod(String accMethod) {
        this.accMethod = accMethod == null ? null : accMethod.trim();
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl == null ? null : reqUrl.trim();
    }
}