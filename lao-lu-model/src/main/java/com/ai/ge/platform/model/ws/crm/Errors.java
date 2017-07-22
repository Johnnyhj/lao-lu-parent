package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by sx on 2016/3/16.
 */
public class Errors {
    @XStreamImplicit(itemFieldName = "error")
    private List<Error> error;

    public List<Error> getError() {
        return error;
    }

    public void setError(List<Error> error) {
        this.error = error;
    }
}
