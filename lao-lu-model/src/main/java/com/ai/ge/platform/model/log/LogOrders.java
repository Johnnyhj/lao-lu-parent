package com.ai.ge.platform.model.log;

import java.math.BigDecimal;
import java.util.Date;

public class LogOrders implements LoggerStorageObject {
    private Long olId;

    private Long prodId;

    private String prodCode;

    private String prodName;

    private Long providId;

    private String orderSeq;

    private Integer quantity;

    private BigDecimal ordersMoney;

    private Long custId;

    private String phoneNum;

    private Date createTime;

    private Date logCreateTime;

    private Short status;

    private String payType;

    private String payNo;

    public Long getOlId() {
        return olId;
    }

    public void setOlId(Long olId) {
        this.olId = olId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
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

    public BigDecimal getOrdersMoney() {
        return ordersMoney;
    }

    public void setOrdersMoney(BigDecimal ordersMoney) {
        this.ordersMoney = ordersMoney;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLogCreateTime() {
        return logCreateTime;
    }

    public void setLogCreateTime(Date logCreateTime) {
        this.logCreateTime = logCreateTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }
}