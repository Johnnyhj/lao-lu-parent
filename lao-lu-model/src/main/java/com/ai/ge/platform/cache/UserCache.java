package com.ai.ge.platform.cache;

import java.io.Serializable;

public class UserCache implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5957730529082524969L;

    private Long devId;

    private String openId;

    private Long userId;

    private Long custId;

    private Long shopId;

    private Long schoolId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCustId() {
        return custId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

}
