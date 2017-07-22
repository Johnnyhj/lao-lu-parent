package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by sx on 2016/3/16.
 */
public class Actions {
    @XStreamImplicit(itemFieldName = "action")
    private List<Action> action;

    public List<Action> getAction() {
        return action;
    }

    public void setAction(List<Action> action) {
        this.action = action;
    }
}
