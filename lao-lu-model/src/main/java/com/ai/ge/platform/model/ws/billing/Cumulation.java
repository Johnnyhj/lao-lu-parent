package com.ai.ge.platform.model.ws.billing;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Cumulation {
    /**
     * 套餐ID
     */
    @XStreamAlias("OFFER_ID")
    private String offerId;
    /**
     * 套餐
     */
    @XStreamAlias("OFFER_NAME")
    private String offerName;

    /**
     * 优惠名称
     */
    @XStreamAlias("ACCU_NAME")
    private String accuName;

    /**
     * 开始时间
     */
    @XStreamAlias("START_TIME")
    private String startTime;

    /**
     * 结束时间
     */
    @XStreamAlias("END_TIME")
    private String endTime;

    /**
     * 单位
     */
    @XStreamAlias("UNIT_NAME")
    private String unitName;

    /**
     * 累积量总量
     */
    @XStreamAlias("CUMULATION_TOTAL")
    private String cumulationTotal;

    /**
     * 已使用累积量
     */
    @XStreamAlias("CUMULATION_ALREADY")
    private String cumulationAlready;

    /**
     * 剩余累积量
     */
    @XStreamAlias("CUMULATION_LEFT")
    private String cumulationLeft;

    /**
     * 流量不清零标识，
     * 1：上月结余
     * 0：本月
     */
    @XStreamAlias("FLAG1")
    private String flag1;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getAccuName() {
        return accuName;
    }

    public void setAccuName(String accuName) {
        this.accuName = accuName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getCumulationTotal() {
        return cumulationTotal;
    }

    public void setCumulationTotal(String cumulationTotal) {
        this.cumulationTotal = cumulationTotal;
    }

    public String getCumulationAlready() {
        return cumulationAlready;
    }

    public void setCumulationAlready(String cumulationAlready) {
        this.cumulationAlready = cumulationAlready;
    }

    public String getCumulationLeft() {
        return cumulationLeft;
    }

    public void setCumulationLeft(String cumulationLeft) {
        this.cumulationLeft = cumulationLeft;
    }

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1;
    }
}