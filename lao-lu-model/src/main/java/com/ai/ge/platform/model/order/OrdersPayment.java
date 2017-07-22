package com.ai.ge.platform.model.order;

import java.util.Date;

public class OrdersPayment extends OrdersPaymentKey {
    private Long prodId;

    private Long prodSaleAttrId;

    private String orderSeq;

    private Integer quantity;

    private Long packageId;

    private Float ordersMoney;

    private Float expressMoney;

    private Float totalMoney;

    private Short payType;

    private Float payMoney;

    private String custId;

    private Date ceateTime;

    private Date updateTime;

    private Short status;

    private String orderDescribe;

    private String paySeq;

    private String pfOrderSeq;

    private String refundOrderSeq;

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public Long getProdSaleAttrId() {
        return prodSaleAttrId;
    }

    public void setProdSaleAttrId(Long prodSaleAttrId) {
        this.prodSaleAttrId = prodSaleAttrId;
    }

    public String getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(String orderSeq) {
        this.orderSeq = orderSeq;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Float getOrdersMoney() {
        return ordersMoney;
    }

    public void setOrdersMoney(Float ordersMoney) {
        this.ordersMoney = ordersMoney;
    }

    public Float getExpressMoney() {
        return expressMoney;
    }

    public void setExpressMoney(Float expressMoney) {
        this.expressMoney = expressMoney;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public Float getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Float payMoney) {
        this.payMoney = payMoney;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Date getCeateTime() {
        return ceateTime;
    }

    public void setCeateTime(Date ceateTime) {
        this.ceateTime = ceateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getOrderDescribe() {
        return orderDescribe;
    }

    public void setOrderDescribe(String orderDescribe) {
        this.orderDescribe = orderDescribe;
    }

    public String getPaySeq() {
        return paySeq;
    }

    public void setPaySeq(String paySeq) {
        this.paySeq = paySeq;
    }

    public String getPfOrderSeq() {
        return pfOrderSeq;
    }

    public void setPfOrderSeq(String pfOrderSeq) {
        this.pfOrderSeq = pfOrderSeq;
    }

    public String getRefundOrderSeq() {
        return refundOrderSeq;
    }

    public void setRefundOrderSeq(String refundOrderSeq) {
        this.refundOrderSeq = refundOrderSeq;
    }
}