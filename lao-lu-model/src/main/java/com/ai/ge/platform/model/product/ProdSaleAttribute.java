package com.ai.ge.platform.model.product;

import java.util.Date;

public class ProdSaleAttribute {
    private Long prodSaleAttrId;

    private Long prodId;

    private String saleCombiAttr;

    private Long prodStockNum;

    private Long prodStockWarn;

    private Float price;

    private Short status;

    private Date createTime;

    private Date updateTime;

    public Long getProdSaleAttrId() {
        return prodSaleAttrId;
    }

    public void setProdSaleAttrId(Long prodSaleAttrId) {
        this.prodSaleAttrId = prodSaleAttrId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getSaleCombiAttr() {
        return saleCombiAttr;
    }

    public void setSaleCombiAttr(String saleCombiAttr) {
        this.saleCombiAttr = saleCombiAttr;
    }

    public Long getProdStockNum() {
        return prodStockNum;
    }

    public void setProdStockNum(Long prodStockNum) {
        this.prodStockNum = prodStockNum;
    }

    public Long getProdStockWarn() {
        return prodStockWarn;
    }

    public void setProdStockWarn(Long prodStockWarn) {
        this.prodStockWarn = prodStockWarn;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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