package com.ai.ge.platform.serviceimpl.http.ws;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;


/**
 * Created by Sam on 17/6/16.
 */
public class Body {


    @XStreamAlias("queryOneCheckInfoResponse")
    private OneCheckInfoRsp oneCheckInfoRsp;


    @XStreamAlias("ns1:accountBalanceQueryResponse")
    private BalanceQueryRsp balanceQueryRsp;


//    @XStreamAlias("multiRef")
    @XStreamImplicit(itemFieldName="multiRef")
    private List<MultiRef> multiRefs;


    public OneCheckInfoRsp getOneCheckInfoRsp() {
        return oneCheckInfoRsp;
    }

    public void setOneCheckInfoRsp(OneCheckInfoRsp oneCheckInfoRsp) {
        this.oneCheckInfoRsp = oneCheckInfoRsp;
    }

    public BalanceQueryRsp getBalanceQueryRsp() {
        return balanceQueryRsp;
    }

    public void setBalanceQueryRsp(BalanceQueryRsp balanceQueryRsp) {
        this.balanceQueryRsp = balanceQueryRsp;
    }

    public List<MultiRef> getMultiRefs() {
        return multiRefs;
    }

    public void setMultiRefs(List<MultiRef> multiRefs) {
        this.multiRefs = multiRefs;
    }
}
