package com.ai.ge.platform.model.product;

import java.util.Date;

public class ProdSaleAttrConfig {
    private Long configId;

    private Long prodId;

    private String saleAttrName;

    private String saleAttrValue;

    private Short status;

    private Date createTime;

    private Date updateTime;

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getSaleAttrName() {
        return saleAttrName;
    }

    public void setSaleAttrName(String saleAttrName) {
        this.saleAttrName = saleAttrName;
    }

    public String getSaleAttrValue() {
        return saleAttrValue;
    }

    public void setSaleAttrValue(String saleAttrValue) {
        this.saleAttrValue = saleAttrValue;
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
}