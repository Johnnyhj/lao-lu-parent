package com.ai.ge.platform.model.order;

import java.util.Date;

public class CustomerShopCart {
    private Long scId;

    private Long custId;

    private Long prodId;

    private Long providId;

    private Long prodSaleAttrId;

    private Short scType;

    private Integer quantity;

    private Date createTime;

    private Date updateTime;

    public Long getScId() {
        return scId;
    }

    public void setScId(Long scId) {
        this.scId = scId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

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

    public Long getProdSaleAttrId() {
        return prodSaleAttrId;
    }

    public void setProdSaleAttrId(Long prodSaleAttrId) {
        this.prodSaleAttrId = prodSaleAttrId;
    }

    public Short getScType() {
        return scType;
    }

    public void setScType(Short scType) {
        this.scType = scType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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