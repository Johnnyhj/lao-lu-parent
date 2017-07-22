package com.ai.ge.platform.model.product;

public class ProductType {
    private Long prodTypeCd;

    private String name;

    private Long parentTypeCd;

    private Short statusCd;

    private Short level;

    private String typeIconUrl;

    private Short sort;

    public Long getProdTypeCd() {
        return prodTypeCd;
    }

    public void setProdTypeCd(Long prodTypeCd) {
        this.prodTypeCd = prodTypeCd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentTypeCd() {
        return parentTypeCd;
    }

    public void setParentTypeCd(Long parentTypeCd) {
        this.parentTypeCd = parentTypeCd;
    }

    public Short getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Short statusCd) {
        this.statusCd = statusCd;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public String getTypeIconUrl() {
        return typeIconUrl;
    }

    public void setTypeIconUrl(String typeIconUrl) {
        this.typeIconUrl = typeIconUrl;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }
}