package com.ai.ge.platform.serviceimpl.http.ws;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Sam on 17/6/18.
 */
public class MultiRef {

    @XStreamAlias(value = "result")
    private String result;

    @XStreamAlias(value = "code")
    private String code;

    @XStreamAlias(value = "msg")
    private String msg;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
