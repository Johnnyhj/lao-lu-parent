package com.ai.ge.platform.serviceimpl.http.crm.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 */
public class CrmOrderComplete {
    /**
     * 已激活号码
     */
    @XStreamAlias(value = "phone_number")
    private String phoneNumber;

    /**
     * 工单
     */
    @XStreamAlias(value = "ol_nbr")
    private String olNbr;

    /**
     * 是否竣工
     */
    @XStreamAlias(value = "order_state")
    private String orderState;

    /**
     * 竣工时间
     */
    @XStreamAlias(value = "complate_time")
    private String complateTime;

    /**
     * 套餐生效时间
     */
    @XStreamAlias(value = "valid_time")
    private String validTime;

    /**
     * 开户时间
     */
    @XStreamAlias(value = "create_time")
    private String createTime;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOlNbr() {
        return olNbr;
    }

    public void setOlNbr(String olNbr) {
        this.olNbr = olNbr;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getComplateTime() {
        return complateTime;
    }

    public void setComplateTime(String complateTime) {
        this.complateTime = complateTime;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
