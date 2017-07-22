package com.ai.ge.platform.serviceimpl.http.ws;

import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpResponseObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Sam on 17/6/16.
 */
public class OneCheckInfoRsp {


    @XStreamAlias("queryOneCheckInfoReturn")
    private OneCheckInfoRet oneCheckInfoRet;

    public OneCheckInfoRet getOneCheckInfoRet() {
        return oneCheckInfoRet;
    }

    public void setOneCheckInfoRet(OneCheckInfoRet oneCheckInfoRet) {
        this.oneCheckInfoRet = oneCheckInfoRet;
    }
}
