package com.ai.ge.platform.model.order;

import java.util.Date;

public class OrdersGroup {
    private Long ordersGroupId;

    private Long custId;

    private String orderSeqGroup;

    private Float expressMoney;

    private Float orderMoney;

    private Float totalMoney;

    private Short status;

    private String custmName;

    private String custmPhone;

    private String custmAddress;

    private Date createTime;

    private Date updateTime;

    public Long getOrdersGroupId() {
        return ordersGroupId;
    }

    public void setOrdersGroupId(Long ordersGroupId) {
        this.ordersGroupId = ordersGroupId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getOrderSeqGroup() {
        return orderSeqGroup;
    }

    public void setOrderSeqGroup(String orderSeqGroup) {
        this.orderSeqGroup = orderSeqGroup;
    }

    public Float getExpressMoney() {
        return expressMoney;
    }

    public void setExpressMoney(Float expressMoney) {
        this.expressMoney = expressMoney;
    }

    public Float getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Float orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
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