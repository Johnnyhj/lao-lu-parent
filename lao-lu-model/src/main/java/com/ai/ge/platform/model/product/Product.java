package com.ai.ge.platform.model.product;

import java.util.Date;

public class Product {
    private Long prodId;

    private Long providId;

    private Long prodTypeCd;

    private String prodName;

    private String description;

    private Short status;

    private Date createTime;

    private Date onTime;

    private Date offTime;

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public Long getProvidId() {
        return providId;
    }

    public void setProvidId(Long providId) {
        this.providId = providId;
    }

    public Long getProdTypeCd() {
        return prodTypeCd;
    }

    public void setProdTypeCd(Long prodTypeCd) {
        this.prodTypeCd = prodTypeCd;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getOnTime() {
        return onTime;
    }

    public void setOnTime(Date onTime) {
        this.onTime = onTime;
    }

    public Date getOffTime() {
        return offTime;
    }

    public void setOffTime(Date offTime) {
        this.offTime = offTime;
    }
}