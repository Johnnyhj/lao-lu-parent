package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by sx on 2016/3/16.
 */
public class Rule {

    @XStreamAsAttribute
    @XStreamAlias("ruleRepeal")
    private String ruleRepeal;

    @XStreamAlias("ruleCode")
    private String ruleCode;

    @XStreamAlias("ruleLevel")
    private String ruleLevel;

    @XStreamAlias("ruleResult")
    private String ruleResult;

    @XStreamAlias("ruleLevelName")
    private String ruleLevelName;

    @XStreamAlias("ruleId")
    private String ruleId;

    @XStreamAlias("ruleDesc")
    private String ruleDesc;

    public String getRuleRepeal() {
        return ruleRepeal;
    }

    public void setRuleRepeal(String ruleRepeal) {
        this.ruleRepeal = ruleRepeal;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleLevel() {
        return ruleLevel;
    }

    public void setRuleLevel(String ruleLevel) {
        this.ruleLevel = ruleLevel;
    }

    public String getRuleResult() {
        return ruleResult;
    }

    public void setRuleResult(String ruleResult) {
        this.ruleResult = ruleResult;
    }

    public String getRuleLevelName() {
        return ruleLevelName;
    }

    public void setRuleLevelName(String ruleLevelName) {
        this.ruleLevelName = ruleLevelName;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }
}
