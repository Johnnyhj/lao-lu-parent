package com.ai.ge.platform.dto.user;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Sam on 17/6/6.
 */
public class PlatformUserGis {

    private String province;
    private String city;
    private String longitude;
    private String latitude;
    private String accuracy;

    private String subcode;

    private String msg;

    private String code;

    public String getProvince() {
        return province;
    }

    @JSONField(name = "province")
    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    @JSONField(name = "city")
    public void setCity(String city) {
        this.city = city;
    }

    public String getLongitude() {
        return longitude;
    }

    @JSONField(name = "longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    @JSONField(name = "latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAccuracy() {
        return accuracy;
    }

    @JSONField(name = "accuracy")
    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getSubcode() {
        return subcode;
    }

    @JSONField(name = "sub_code")
    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    public String getMsg() {
        return msg;
    }

    @JSONField(name = "msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    @JSONField(name = "code")
    public void setCode(String code) {
        this.code = code;
    }
}
