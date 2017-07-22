package com.ai.ge.platform.model.ws.billing;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * 2.2.	累积量查询，响应
 */
public class CurrAcuRsp extends Rsp {

    @XStreamImplicit(itemFieldName = "CUMULATION_list")
    private List<Cumulation> cumulations;

    public List<Cumulation> getCumulations() {
        return cumulations;
    }

    public void setCumulations(List<Cumulation> cumulations) {
        this.cumulations = cumulations;
    }


}
