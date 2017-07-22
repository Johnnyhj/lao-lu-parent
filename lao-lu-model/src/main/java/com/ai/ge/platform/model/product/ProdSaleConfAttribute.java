package com.ai.ge.platform.model.product;

public class ProdSaleConfAttribute {
    private Long prodSaleAttrId;

    private Long configId;

    private Short attrSort;

    public Long getProdSaleAttrId() {
        return prodSaleAttrId;
    }

    public void setProdSaleAttrId(Long prodSaleAttrId) {
        this.prodSaleAttrId = prodSaleAttrId;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Short getAttrSort() {
        return attrSort;
    }

    public void setAttrSort(Short attrSort) {
        this.attrSort = attrSort;
    }
}