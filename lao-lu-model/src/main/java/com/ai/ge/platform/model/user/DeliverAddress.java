package com.ai.ge.platform.model.user;

import com.alibaba.fastjson.annotation.JSONField;

public class DeliverAddress {
    private Long id;

    private Long platformUserId;

    private String deliverFullname;

    private String defaultDeliverAddre;

    private String deliverPhone;

    private String deliverMobile;

    private String address;

    private String zip;

    private String deliverProvince;

    private String deliverCity;

    private String deliverArea;

    private String addressCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatformUserId() {
        return platformUserId;
    }

    public void setPlatformUserId(Long platformUserId) {
        this.platformUserId = platformUserId;
    }

    public String getDeliverFullname() {
        return deliverFullname;
    }
    @JSONField(name = "deliver_fullname")
    public void setDeliverFullname(String deliverFullname) {
        this.deliverFullname = deliverFullname;
    }

    public String getDefaultDeliverAddre() {
        return defaultDeliverAddre;
    }
    @JSONField(name = "default_deliver_address")
    public void setDefaultDeliverAddre(String defaultDeliverAddre) {
        this.defaultDeliverAddre = defaultDeliverAddre;
    }

    public String getDeliverPhone() {
        return deliverPhone;
    }
    @JSONField(name = "deliver_phone")
    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone;
    }

    public String getDeliverMobile() {
        return deliverMobile;
    }
    @JSONField(name = "deliver_mobile")
    public void setDeliverMobile(String deliverMobile) {
        this.deliverMobile = deliverMobile;
    }

    public String getAddress() {
        return address;
    }
    @JSONField(name = "address")
    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }
    @JSONField(name = "zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDeliverProvince() {
        return deliverProvince;
    }
    @JSONField(name = "deliver_province")
    public void setDeliverProvince(String deliverProvince) {
        this.deliverProvince = deliverProvince;
    }

    public String getDeliverCity() {
        return deliverCity;
    }
    @JSONField(name = "deliver_city")
    public void setDeliverCity(String deliverCity) {
        this.deliverCity = deliverCity;
    }

    public String getDeliverArea() {
        return deliverArea;
    }
    @JSONField(name = "deliver_area")
    public void setDeliverArea(String deliverArea) {
        this.deliverArea = deliverArea;
    }

    public String getAddressCode() {
        return addressCode;
    }
    @JSONField(name = "address_code")
    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }
}