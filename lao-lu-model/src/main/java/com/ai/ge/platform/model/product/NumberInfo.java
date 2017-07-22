package com.ai.ge.platform.model.product;

import java.util.Date;

public class NumberInfo {
    private Long id;

    private String number;

    private Short level;

    private Long proTypeId;

    private Short status;

    private Date createTime;

    private Date updateTime;

    private Long provinceAearId;

    private Long cityAearId;

    // 省份地市名称，导入时使用
    private String provinceName;

    private String cityName;

    public String getProvinceName()
    {
        return provinceName;
    }

    public void setProvinceName(String provinceName)
    {
        this.provinceName = provinceName;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Long getProTypeId() {
        return proTypeId;
    }

    public void setProTypeId(Long proTypeId) {
        this.proTypeId = proTypeId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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

    public Long getProvinceAearId() {
        return provinceAearId;
    }

    public void setProvinceAearId(Long provinceAearId) {
        this.provinceAearId = provinceAearId;
    }

    public Long getCityAearId() {
        return cityAearId;
    }

    public void setCityAearId(Long cityAearId) {
        this.cityAearId = cityAearId;
    }
}