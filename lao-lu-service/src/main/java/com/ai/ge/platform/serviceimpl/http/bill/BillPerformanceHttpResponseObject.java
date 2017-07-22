package com.ai.ge.platform.serviceimpl.http.bill;

import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.bill.response.BillPerformance;
import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * 计费用户履约
 */
public class BillPerformanceHttpResponseObject extends HttpResponseObject {



    @XStreamAlias(value = "accountBalanceSet")
    private List<BillPerformance> billPerformances;


    @XStreamAlias(value = "result")
    private String privte_code;

    @XStreamAlias(value = "code")
    private String privte_exception;

    @XStreamAlias(value = "msg")
    private String privte_msg;


    public List<BillPerformance> getBillPerformances() {
        return billPerformances;
    }

    public void setBillPerformances(List<BillPerformance> billPerformances) {
        this.billPerformances = billPerformances;
    }


    public String getPrivte_code() {
        return privte_code;
    }

    public void setPrivte_code(String privte_code) {
        this.privte_code = privte_code;
    }

    public String getPrivte_exception() {
        return privte_exception;
    }

    public void setPrivte_exception(String privte_exception) {
        this.privte_exception = privte_exception;
    }

    public String getPrivte_msg() {
        return privte_msg;
    }

    public void setPrivte_msg(String privte_msg) {
        this.privte_msg = privte_msg;
    }
}
