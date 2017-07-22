package com.ai.ge.platform.model.sys;

public class SystemArea {
    private Long areaId;

    private String areaName;

    private Short areaLevel;

    private Long parAreaId;

    private String areaCode;

    private Short areaStatus;

    private String payAppid;

    private String paySecret;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Short getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Short areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Long getParAreaId() {
        return parAreaId;
    }

    public void setParAreaId(Long parAreaId) {
        this.parAreaId = parAreaId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Short getAreaStatus() {
        return areaStatus;
    }

    public void setAreaStatus(Short areaStatus) {
        this.areaStatus = areaStatus;
    }

    public String getPayAppid() {
        return payAppid;
    }

    public void setPayAppid(String payAppid) {
        this.payAppid = payAppid;
    }

    public String getPaySecret() {
        return paySecret;
    }

    public void setPaySecret(String paySecret) {
        this.paySecret = paySecret;
    }
}