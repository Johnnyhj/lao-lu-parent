package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by sx on 2016/3/16.
 */
public class OrderValidateForECReturn {


    @XStreamAlias("NewValidateServiceResponse")
    private NewValidateServiceResponse newValidateServiceResponse;

    public NewValidateServiceResponse getNewValidateServiceResponse() {
        return newValidateServiceResponse;
    }

    public void setNewValidateServiceResponse(NewValidateServiceResponse newValidateServiceResponse) {
        this.newValidateServiceResponse = newValidateServiceResponse;
    }
}
