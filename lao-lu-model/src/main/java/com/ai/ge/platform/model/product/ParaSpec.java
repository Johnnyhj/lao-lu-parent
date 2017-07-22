package com.ai.ge.platform.model.product;

public class ParaSpec {
    private Long paraSpecId;

    private String name;

    private Integer dscTypeCd;

    private Integer dscDataCd;

    private String discription;

    private Short sort;

    public Long getParaSpecId() {
        return paraSpecId;
    }

    public void setParaSpecId(Long paraSpecId) {
        this.paraSpecId = paraSpecId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDscTypeCd() {
        return dscTypeCd;
    }

    public void setDscTypeCd(Integer dscTypeCd) {
        this.dscTypeCd = dscTypeCd;
    }

    public Integer getDscDataCd() {
        return dscDataCd;
    }

    public void setDscDataCd(Integer dscDataCd) {
        this.dscDataCd = dscDataCd;
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