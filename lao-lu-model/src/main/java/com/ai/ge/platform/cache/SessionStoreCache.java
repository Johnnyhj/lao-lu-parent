package com.ai.ge.platform.cache;

import java.io.Serializable;

/**
 * HttpSession中存放变量
 */
public class SessionStoreCache implements Serializable{
    /**
     * SessionStoreCache对象Key
     */
    public static final String SESSION_CACHE = "session_cache_store";

    /**
     * HttpSession中用户对象Key
     */
    public static final String SESSION_USER = "session_user";

    /**
     * HttpSession中用户对象Key
     */
    public static final String SESSION_CUSTOMER = "session_customer";

    /**
     * 为防止请求未返回重复提交，请求地址中携带随机参数，此参数放置于Cookie中
     */
    public static final String RANDOM_PARAMS = "random_params_store";

    private static final long serialVersionUID = -1144051979887001964L;
    /**
     * 渠道
     */
    private String channelNo;
    /**
     * 手机号码
     */
    private String phoneNum;


    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
