package com.ai.ge.platform.model.wx;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信通用接口凭证
 */
public class AccessToken {

	/**
	 *  获取到的凭证
	 */
    @JSONField(name = "access_token")
	private String accessToken;
	
	/**
	 *  凭证有效时间，单位：秒
	 */

    @JSONField(name = "expires_in")
	private int expiresIn;


    /**
     * 用户刷新access_token
     */

    @JSONField(name = "refresh_token")
    private String refreshToken;

    /**
     * 用户唯一标识
     */

    @JSONField(name = "openid")
    private String openid;

    /**
     * 用户授权的作用域，使用逗号（,）分隔
     */

    @JSONField(name = "scope")
    private String scope;


    /**
     * 持久化进Redis时间，用于判断是否需要刷新
     */
    private long persistentTime;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public long getPersistentTime() {
        return persistentTime;
    }

    public void setPersistentTime(long persistentTime) {
        this.persistentTime = persistentTime;
    }
}