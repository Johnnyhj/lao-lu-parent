package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by sx on 2016/3/16.
 */
public class Rules {

    @XStreamImplicit(itemFieldName = "rule")
    private List<Rule> rule;

    public List<Rule> getRule() {
        return rule;
    }

    public void setRule(List<Rule> rule) {
        this.rule = rule;
    }
}
