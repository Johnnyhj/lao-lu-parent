package com.ai.ge.platform.serviceimpl.http.ws;

import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.crm.response.CrmOrderComplete;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Sam on 17/6/16.
 */
public class OneCheckInfoRet {

    @XStreamAlias("queryCustInfoResponse")
    private CrmOrderCompleteHttpResponseObject crmOrderCompleteHttpResponseObject;

    public CrmOrderCompleteHttpResponseObject getCrmOrderCompleteHttpResponseObject() {
        return crmOrderCompleteHttpResponseObject;
    }

    public void setCrmOrderCompleteHttpResponseObject(CrmOrderCompleteHttpResponseObject crmOrderCompleteHttpResponseObject) {
        this.crmOrderCompleteHttpResponseObject = crmOrderCompleteHttpResponseObject;
    }}
