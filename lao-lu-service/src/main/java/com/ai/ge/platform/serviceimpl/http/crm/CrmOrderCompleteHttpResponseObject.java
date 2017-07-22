package com.ai.ge.platform.serviceimpl.http.crm;

import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.crm.response.CrmOrderComplete;
import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * CRM 工单竣工
 */
public class CrmOrderCompleteHttpResponseObject extends HttpResponseObject {



    @XStreamAlias(value = "prodOrderInfo")
    private  CrmOrderComplete crmOrderComplete;


    @XStreamAlias(value = "result")
    private String privte_code;

    public String getPrivte_code() {
        return privte_code;
    }

    public void setPrivte_code(String privte_code) {
        super.setResultCode(privte_code);
        this.privte_code = privte_code;
    }

    public CrmOrderComplete getCrmOrderComplete() {
        return crmOrderComplete;
    }

    public void setCrmOrderComplete(CrmOrderComplete crmOrderComplete) {
        this.crmOrderComplete = crmOrderComplete;
    }
}
