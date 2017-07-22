package com.ai.ge.platform.model.order;

import java.util.Date;

public class OfferSpecInfo {
    private Long offerSpecId;

    private String compOffer;

    private Short busiTypeCd;

    private Short feeType;

    private String lifecycleRuleCd;

    private Date appStartDt;

    private Date appEndDt;

    private Short timeUnitCd;

    private Integer effTime;

    private Integer changeEffTime;

    private Integer preSaleTime;

    private Integer inUseTime;

    private Long rpmonth;

    private String costDesc;

    private String flowDesc;

    private String callDesc;

    private String saleDesc;

    private Long provinceAearId;

    private Long cityAearId;

    public Long getOfferSpecId() {
        return offerSpecId;
    }

    public void setOfferSpecId(Long offerSpecId) {
        this.offerSpecId = offerSpecId;
    }

    public String getCompOffer() {
        return compOffer;
    }

    public void setCompOffer(String compOffer) {
        this.compOffer = compOffer;
    }

    public Short getBusiTypeCd() {
        return busiTypeCd;
    }

    public void setBusiTypeCd(Short busiTypeCd) {
        this.busiTypeCd = busiTypeCd;
    }

    public Short getFeeType() {
        return feeType;
    }

    public void setFeeType(Short feeType) {
        this.feeType = feeType;
    }

    public String getLifecycleRuleCd() {
        return lifecycleRuleCd;
    }

    public void setLifecycleRuleCd(String lifecycleRuleCd) {
        this.lifecycleRuleCd = lifecycleRuleCd;
    }

    public Date getAppStartDt() {
        return appStartDt;
    }

    public void setAppStartDt(Date appStartDt) {
        this.appStartDt = appStartDt;
    }

    public Date getAppEndDt() {
        return appEndDt;
    }

    public void setAppEndDt(Date appEndDt) {
        this.appEndDt = appEndDt;
    }

    public Short getTimeUnitCd() {
        return timeUnitCd;
    }

    public void setTimeUnitCd(Short timeUnitCd) {
        this.timeUnitCd = timeUnitCd;
    }

    public Integer getEffTime() {
        return effTime;
    }

    public void setEffTime(Integer effTime) {
        this.effTime = effTime;
    }

    public Integer getChangeEffTime() {
        return changeEffTime;
    }

    public void setChangeEffTime(Integer changeEffTime) {
        this.changeEffTime = changeEffTime;
    }

    public Integer getPreSaleTime() {
        return preSaleTime;
    }

    public void setPreSaleTime(Integer preSaleTime) {
        this.preSaleTime = preSaleTime;
    }

    public Integer getInUseTime() {
        return inUseTime;
    }

    public void setInUseTime(Integer inUseTime) {
        this.inUseTime = inUseTime;
    }

    public Long getRpmonth() {
        return rpmonth;
    }

    public void setRpmonth(Long rpmonth) {
        this.rpmonth = rpmonth;
    }

    public String getCostDesc() {
        return costDesc;
    }

    public void setCostDesc(String costDesc) {
        this.costDesc = costDesc;
    }

    public String getFlowDesc() {
        return flowDesc;
    }

    public void setFlowDesc(String flowDesc) {
        this.flowDesc = flowDesc;
    }

    public String getCallDesc() {
        return callDesc;
    }

    public void setCallDesc(String callDesc) {
        this.callDesc = callDesc;
    }

    public String getSaleDesc() {
        return saleDesc;
    }

    public void setSaleDesc(String saleDesc) {
        this.saleDesc = saleDesc;
    }

    public Long getProvinceAearId() {
        return provinceAearId;
    }

    public void setProvinceAearId(Long provinceAearId) {
        this.provinceAearId = provinceAearId;
    }

    public Long getCityAearId() {
        return cityAearId;
    }

    public void setCityAearId(Long cityAearId) {
        this.cityAearId = cityAearId;
    }
}