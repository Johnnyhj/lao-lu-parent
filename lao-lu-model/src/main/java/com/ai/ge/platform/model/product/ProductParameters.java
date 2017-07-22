package com.ai.ge.platform.model.product;

public class ProductParameters {
    private Long prodId;

    private Long paraSpecId;

    private String pName;

    private String pValues;

    private Short isImport;

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public Long getParaSpecId() {
        return paraSpecId;
    }

    public void setParaSpecId(Long paraSpecId) {
        this.paraSpecId = paraSpecId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpValues() {
        return pValues;
    }

    public void setpValues(String pValues) {
        this.pValues = pValues;
    }

    public Short getIsImport() {
        return isImport;
    }

    public void setIsImport(Short isImport) {
        this.isImport = isImport;
    }
}