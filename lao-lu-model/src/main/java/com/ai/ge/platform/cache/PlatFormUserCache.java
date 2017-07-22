package com.ai.ge.platform.cache;

import com.ai.ge.platform.model.user.PlatformUser;

import java.io.Serializable;

/**
 * Created by Sam on 17/5/26.
 */
public class PlatFormUserCache implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5957730529082534969L;

    private Long id;

    private String userId;

    private String realName;

    private String alipayUserId;

    private PlatformUser platformUser;

    private long zmScore;

    private long provinceId;

    private long provinceZmScore;

    public PlatformUser getPlatformUser() {
        return platformUser;
    }

    public void setPlatformUser(PlatformUser platformUser) {
        this.platformUser = platformUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAlipayUserId() {
        return alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId;
    }

    public long getZmScore() {
        return zmScore;
    }

    public void setZmScore(long zmScore) {
        this.zmScore = zmScore;
    }

    public long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(long provinceId) {
        this.provinceId = provinceId;
    }

    public long getProvinceZmScore() {
        return provinceZmScore;
    }

    public void setProvinceZmScore(long provinceZmScore) {
        this.provinceZmScore = provinceZmScore;
    }
}
