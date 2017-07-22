package com.ai.ge.platform.result;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {


    private static final long serialVersionUID = -2154894149860566877L;
    // 结果码 1:success; 0:fault
    private String resultCode;

    // 结果信息
    private String resultMsg;

    private Long prodId;
    // 可将返回对象已json格式放入返回
    private String params;

    private List<?> Objlist;

    public Result() {
    }

    public Result(String resultCode, String resultMsg) {
        super();
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public Result(String resultCode, String resultMsg, String params) {
        super();
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.params = params;
    }

    public Result(String resultCode, String resultMsg, String params, List<?> list) {
        super();
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.params = params;
        this.Objlist = list;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public List<?> getObjlist() {
        return Objlist;
    }

    public void setObjlist(List<?> objlist) {
        Objlist = objlist;
    }

}
