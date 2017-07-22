package com.ai.ge.platform.model.ws.billing;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 计费查询手机号码归属地响应包
 */
public class AreaCodeQrsp extends Rsp {

    /**
     * 手机归属地
     */
    @XStreamAlias("AREA_CODE")
    private String areaCode;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
