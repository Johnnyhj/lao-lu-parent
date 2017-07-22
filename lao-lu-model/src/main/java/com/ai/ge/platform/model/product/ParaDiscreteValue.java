package com.ai.ge.platform.model.product;

public class ParaDiscreteValue {
    private Long id;

    private Long paraSpecId;

    private Long parParaSpecId;

    private Integer discreteValue;

    private String discription;

    private Short sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParaSpecId() {
        return paraSpecId;
    }

    public void setParaSpecId(Long paraSpecId) {
        this.paraSpecId = paraSpecId;
    }

    public Long getParParaSpecId() {
        return parParaSpecId;
    }

    public void setParParaSpecId(Long parParaSpecId) {
        this.parParaSpecId = parParaSpecId;
    }

    public Integer getDiscreteValue() {
        return discreteValue;
    }

    public void setDiscreteValue(Integer discreteValue) {
        this.discreteValue = discreteValue;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }
}