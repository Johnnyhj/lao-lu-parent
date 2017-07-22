package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by sx on 2016/3/16.
 */
public class Action {

    @XStreamAsAttribute
    @XStreamAlias("relaTypeCd")
    private String relaTypeCd;

    @XStreamAsAttribute
    @XStreamAlias("relaDesc")
    private String relaDesc;

    @XStreamAsAttribute
    @XStreamAlias("relaLevel")
    private String relaLevel;

    @XStreamAsAttribute
    @XStreamAlias("olId")
    private String olId;

    @XStreamAsAttribute
    @XStreamAlias("seq")
    private String seq;

    public String getRelaTypeCd() {
        return relaTypeCd;
    }

    public void setRelaTypeCd(String relaTypeCd) {
        this.relaTypeCd = relaTypeCd;
    }

    public String getRelaDesc() {
        return relaDesc;
    }

    public void setRelaDesc(String relaDesc) {
        this.relaDesc = relaDesc;
    }

    public String getRelaLevel() {
        return relaLevel;
    }

    public void setRelaLevel(String relaLevel) {
        this.relaLevel = relaLevel;
    }

    public String getOlId() {
        return olId;
    }

    public void setOlId(String olId) {
        this.olId = olId;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
