package com.ai.ge.platform.serviceimpl.http.zhima;

import com.ai.ge.platform.service.http.HttpRequestAuthObject;

/**
 *
 */
public class ZhimaHttpRequestAuthObject implements HttpRequestAuthObject {

    public ZhimaHttpRequestAuthObject(String appId, String privateKey, String publicKey) {
        this.appId = appId;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public ZhimaHttpRequestAuthObject() {

    }

    private String appId;

    private String privateKey;

    private String publicKey;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
