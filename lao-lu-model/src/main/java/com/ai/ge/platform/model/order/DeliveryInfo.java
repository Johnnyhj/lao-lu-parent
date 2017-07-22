package com.ai.ge.platform.model.order;

import java.util.Date;

public class DeliveryInfo {
    private Long deliveryId;

    private Short deliveryType;

    private Short status;

    private String expressName;

    private String expressSeq;

    private Date createTime;

    private Date updateTime;

    private Float expressMoney;

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Short getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Short deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressSeq() {
        return expressSeq;
    }

    public void setExpressSeq(String expressSeq) {
        this.expressSeq = expressSeq;
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

    public Float getExpressMoney() {
        return expressMoney;
    }

    public void setExpressMoney(Float expressMoney) {
        this.expressMoney = expressMoney;
    }
}