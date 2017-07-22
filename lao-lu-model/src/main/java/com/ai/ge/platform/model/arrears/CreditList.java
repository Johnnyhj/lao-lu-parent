package com.ai.ge.platform.model.arrears;

import java.util.Date;

public class CreditList {
    private Long creditId;

    private Long arrAuId;

    private String auId;

    private Short creditType;

    private String creditDesc;

    private Short status;

    private Date createTime;

    private Date updateTime;

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    public Long getArrAuId() {
        return arrAuId;
    }

    public void setArrAuId(Long arrAuId) {
        this.arrAuId = arrAuId;
    }

    public String getAuId() {
        return auId;
    }

    public void setAuId(String auId) {
        this.auId = auId;
    }

    public Short getCreditType() {
        return creditType;
    }

    public void setCreditType(Short creditType) {
        this.creditType = creditType;
    }

    public String getCreditDesc() {
        return creditDesc;
    }

    public void setCreditDesc(String creditDesc) {
        this.creditDesc = creditDesc;
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