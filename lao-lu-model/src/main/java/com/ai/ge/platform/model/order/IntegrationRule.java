package com.ai.ge.platform.model.order;

public class IntegrationRule {
    private Long integrationRuleId;

    private Long provinceAearId;

    private Long cityAearId;

    private Short isDefault;

    private Short status;

    private String integration;

    private String extend;

    private Long offerSpecId;

    private Integer performanceTimes;

    private Short ruleType;

    public Long getIntegrationRuleId() {
        return integrationRuleId;
    }

    public void setIntegrationRuleId(Long integrationRuleId) {
        this.integrationRuleId = integrationRuleId;
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

    public Short getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Short isDefault) {
        this.isDefault = isDefault;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getIntegration() {
        return integration;
    }

    public void setIntegration(String integration) {
        this.integration = integration;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public Long getOfferSpecId() {
        return offerSpecId;
    }

    public void setOfferSpecId(Long offerSpecId) {
        this.offerSpecId = offerSpecId;
    }

    public Integer getPerformanceTimes() {
        return performanceTimes;
    }

    public void setPerformanceTimes(Integer performanceTimes) {
        this.performanceTimes = performanceTimes;
    }

    public Short getRuleType() {
        return ruleType;
    }

    public void setRuleType(Short ruleType) {
        this.ruleType = ruleType;
    }
}