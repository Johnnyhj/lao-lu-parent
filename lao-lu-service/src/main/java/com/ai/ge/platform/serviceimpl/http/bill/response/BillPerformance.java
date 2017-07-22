package com.ai.ge.platform.serviceimpl.http.bill.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 */
public class BillPerformance {



    @XStreamAlias(value = "accountID")
    private String accountId;

    @XStreamAlias(value = "accountName")
    private String accountName;

    @XStreamAlias(value = "accountBalance")
    private Integer accountBalance;

    @XStreamAlias(value = "expireDate")
    private String expirdate;

    @XStreamAlias(value = "balanceType")
    private String balanceType;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getExpirdate() {
        return expirdate;
    }

    public void setExpirdate(String expirdate) {
        this.expirdate = expirdate;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }


    //    @JSONField(name = "phone_number")
//    private String phoneNumber;
//
//    @JSONField(name = "is_credit")
//    private String isCredit;
//
//    private String cost;
//
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getIsCredit() {
//        return isCredit;
//    }
//
//    public void setIsCredit(String isCredit) {
//        this.isCredit = isCredit;
//    }
//
//    public String getCost() {
//        return cost;
//    }
//
//    public void setCost(String cost) {
//        this.cost = cost;
//    }



}
