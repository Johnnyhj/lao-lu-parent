package com.ai.ge.platform.model.arrears;

import java.util.Date;

public class ArrearsInfo {
    private Long arrearsId;

    private String name;

    private String arrearsPhone;

    private Short identityType;

    private String identityNum;

    private Date arrearsTime;

    private Date createTime;

    private Long account;

    private Integer arrearsMoney;

    private Integer arrearsMonth;

    private Integer accountMoney;

    private Integer counts;

    private Date updateTime;

    private Integer status;

    public Long getArrearsId() {
        return arrearsId;
    }

    public void setArrearsId(Long arrearsId) {
        this.arrearsId = arrearsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArrearsPhone() {
        return arrearsPhone;
    }

    public void setArrearsPhone(String arrearsPhone) {
        this.arrearsPhone = arrearsPhone;
    }

    public Short getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Short identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public Date getArrearsTime() {
        return arrearsTime;
    }

    public void setArrearsTime(Date arrearsTime) {
        this.arrearsTime = arrearsTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Integer getArrearsMoney() {
        return arrearsMoney;
    }

    public void setArrearsMoney(Integer arrearsMoney) {
        this.arrearsMoney = arrearsMoney;
    }

    public Integer getArrearsMonth() {
        return arrearsMonth;
    }

    public void setArrearsMonth(Integer arrearsMonth) {
        this.arrearsMonth = arrearsMonth;
    }

    public Integer getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(Integer accountMoney) {
        this.accountMoney = accountMoney;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}