package com.ai.ge.platform.model.product;

import java.util.Date;

public class ProductPics {
    private Long prodPicsId;

    private Long prodId;

    private String picsUrl;

    private Short picType;

    private Short sort;

    private Date createTime;

    private String picOwnerUrl;

    public Long getProdPicsId() {
        return prodPicsId;
    }

    public void setProdPicsId(Long prodPicsId) {
        this.prodPicsId = prodPicsId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getPicsUrl() {
        return picsUrl;
    }

    public void setPicsUrl(String picsUrl) {
        this.picsUrl = picsUrl;
    }

    public Short getPicType() {
        return picType;
    }

    public void setPicType(Short picType) {
        this.picType = picType;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPicOwnerUrl() {
        return picOwnerUrl;
    }

    public void setPicOwnerUrl(String picOwnerUrl) {
        this.picOwnerUrl = picOwnerUrl;
    }
}