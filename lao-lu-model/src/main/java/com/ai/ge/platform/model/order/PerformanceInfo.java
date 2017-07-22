package com.ai.ge.platform.model.order;

import java.util.Date;

public class PerformanceInfo {
    private Long performanceId;

    private Long orderId;

    private Short status;

    private String orderDescribe;

    private Short performTimes;

    private Short completeTimes;

    private Date beginTime;

    private Date endTime;

    private Long offerSpecId;

    private String performanceCode;

    private Float performanceMoney;

    private Long provinceAearId;

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getOrderDescribe() {
        return orderDescribe;
    }

    public void setOrderDescribe(String orderDescribe) {
        this.orderDescribe = orderDescribe;
    }

    public Short getPerformTimes() {
        return performTimes;
    }

    public void setPerformTimes(Short performTimes) {
        this.performTimes = performTimes;
    }

    public Short getCompleteTimes() {
        return completeTimes;
    }

    public void setCompleteTimes(Short completeTimes) {
        this.completeTimes = completeTimes;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getOfferSpecId() {
        return offerSpecId;
    }

    public void setOfferSpecId(Long offerSpecId) {
        this.offerSpecId = offerSpecId;
    }

    public String getPerformanceCode() {
        return performanceCode;
    }

    public void setPerformanceCode(String performanceCode) {
        this.performanceCode = performanceCode;
    }

    public Float getPerformanceMoney() {
        return performanceMoney;
    }

    public void setPerformanceMoney(Float performanceMoney) {
        this.performanceMoney = performanceMoney;
    }

    public Long getProvinceAearId() {
        return provinceAearId;
    }

    public void setProvinceAearId(Long provinceAearId) {
        this.provinceAearId = provinceAearId;
    }
}