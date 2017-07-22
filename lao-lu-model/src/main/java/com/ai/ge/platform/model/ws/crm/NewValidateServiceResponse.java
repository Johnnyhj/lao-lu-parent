package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * CRM校验返回
 */
public class NewValidateServiceResponse extends Result {

    @XStreamAlias("depCustOrderId")
    private String depCustOrderId;

    @XStreamAlias("custOrderId")
    private String custOrderId;

    @XStreamAlias("custId")
    private String custId;

    @XStreamAlias("ruleInfo")
    private RuleInfo ruleInfo;

    public String getDepCustOrderId() {
        return depCustOrderId;
    }

    public void setDepCustOrderId(String depCustOrderId) {
        this.depCustOrderId = depCustOrderId;
    }

    public String getCustOrderId() {
        return custOrderId;
    }

    public void setCustOrderId(String custOrderId) {
        this.custOrderId = custOrderId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public RuleInfo getRuleInfo() {
        return ruleInfo;
    }

    public void setRuleInfo(RuleInfo ruleInfo) {
        this.ruleInfo = ruleInfo;
    }
}
