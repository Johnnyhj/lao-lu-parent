package com.ai.ge.platform.model.order;

public class Freight {
    private Long freightId;

    private Long originalProvinceAearId;

    private Long originalCityAearId;

    private Short isDefault;

    private Short status;

    private Float money;

    private Long destinationProvinceAearId;

    private Long destinationCityAearId;

    private String extend;

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public Long getOriginalProvinceAearId() {
        return originalProvinceAearId;
    }

    public void setOriginalProvinceAearId(Long originalProvinceAearId) {
        this.originalProvinceAearId = originalProvinceAearId;
    }

    public Long getOriginalCityAearId() {
        return originalCityAearId;
    }

    public void setOriginalCityAearId(Long originalCityAearId) {
        this.originalCityAearId = originalCityAearId;
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

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Long getDestinationProvinceAearId() {
        return destinationProvinceAearId;
    }

    public void setDestinationProvinceAearId(Long destinationProvinceAearId) {
        this.destinationProvinceAearId = destinationProvinceAearId;
    }

    public Long getDestinationCityAearId() {
        return destinationCityAearId;
    }

    public void setDestinationCityAearId(Long destinationCityAearId) {
        this.destinationCityAearId = destinationCityAearId;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}