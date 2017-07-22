package com.ai.ge.platform.model.order;

import java.util.Date;

public class OrdersLog {
    private Long olId;

    private Long orderId;

    private Long prodId;

    private Long prodSaleAttrId;

    private Long ordersOutId;

    private Long providId;

    private String orderSeq;

    private Integer quantity;

    private Float ordersMoney;

    private Float expressMoney;

    private Float totalMoney;

    private String custId;

    private Date ceateTime;

    private Short status;

    private String custmName;

    private String custmPhone;

    private String custmAddress;

    private Short payType;

    private String payNo;

    public Long getOlId() {
        return olId;
    }

    public void setOlId(Long olId) {
        this.olId = olId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

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

    public Long getOrdersOutId() {
        return ordersOutId;
    }

    public void setOrdersOutId(Long ordersOutId) {
        this.ordersOutId = ordersOutId;
    }

    public Long getProvidId() {
        return providId;
    }

    public void setProvidId(Long providId) {
        this.providId = providId;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getCustmName() {
        return custmName;
    }

    public void setCustmName(String custmName) {
        this.custmName = custmName;
    }

    public String getCustmPhone() {
        return custmPhone;
    }

    public void setCustmPhone(String custmPhone) {
        this.custmPhone = custmPhone;
    }

    public String getCustmAddress() {
        return custmAddress;
    }

    public void setCustmAddress(String custmAddress) {
        this.custmAddress = custmAddress;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }
}