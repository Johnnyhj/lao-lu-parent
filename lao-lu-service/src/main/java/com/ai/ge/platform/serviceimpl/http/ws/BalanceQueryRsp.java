package com.ai.ge.platform.serviceimpl.http.ws;

import com.ai.ge.platform.serviceimpl.http.bill.BillPerformanceHttpResponseObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Sam on 17/6/16.
 */
public class BalanceQueryRsp {

    @XStreamAlias("ns1:accountBalanceQueryResponse")
    private BillPerformanceHttpResponseObject billPerformanceHttpResponseObject;


    public BillPerformanceHttpResponseObject getBillPerformanceHttpResponseObject() {
        return billPerformanceHttpResponseObject;
    }

    public void setBillPerformanceHttpResponseObject(BillPerformanceHttpResponseObject billPerformanceHttpResponseObject) {
        this.billPerformanceHttpResponseObject = billPerformanceHttpResponseObject;
    }
}
