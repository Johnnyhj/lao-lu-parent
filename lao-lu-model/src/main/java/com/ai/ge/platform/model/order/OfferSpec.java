package com.ai.ge.platform.model.order;

import java.util.Date;

public class OfferSpec {
    private Long offerSpecId;

    private String name;

    private String code;

    private String manageCode;

    private String simpleSpell;

    private Short agreementTypeCd;

    private Short offerTypeCd;

    private Integer areaId;

    private String summary;

    private Date startDt;

    private Date endDt;

    private Short statusCd;

    private Date statusDt;

    private Date createDt;

    private Date version;

    private Long provinceAearId;

    private Long cityAearId;

    private Short userType;

    public Short getUserType()
    {
        return userType;
    }

    public void setUserType(Short userType)
    {
        this.userType = userType;
    }

    public Long getOfferSpecId() {
        return offerSpecId;
    }

    public void setOfferSpecId(Long offerSpecId) {
        this.offerSpecId = offerSpecId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getManageCode() {
        return manageCode;
    }

    public void setManageCode(String manageCode) {
        this.manageCode = manageCode;
    }

    public String getSimpleSpell() {
        return simpleSpell;
    }

    public void setSimpleSpell(String simpleSpell) {
        this.simpleSpell = simpleSpell;
    }

    public Short getAgreementTypeCd() {
        return agreementTypeCd;
    }

    public void setAgreementTypeCd(Short agreementTypeCd) {
        this.agreementTypeCd = agreementTypeCd;
    }

    public Short getOfferTypeCd() {
        return offerTypeCd;
    }

    public void setOfferTypeCd(Short offerTypeCd) {
        this.offerTypeCd = offerTypeCd;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    public Short getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Short statusCd) {
        this.statusCd = statusCd;
    }

    public Date getStatusDt() {
        return statusDt;
    }

    public void setStatusDt(Date statusDt) {
        this.statusDt = statusDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
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