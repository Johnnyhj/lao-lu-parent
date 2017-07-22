package com.ai.ge.platform.model.wx;

/**
 * 微信接口调用返回结果
 */
public class WxResult {

    public static final int SUCCESS_CODE = 0;

    private Integer errcode;
    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
