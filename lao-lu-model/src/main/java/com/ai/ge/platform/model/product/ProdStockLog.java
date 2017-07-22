package com.ai.ge.platform.model.product;

import java.util.Date;

public class ProdStockLog {
    private Long stockId;

    private Long prodSaleAttrId;

    private Long orderId;

    private Long proTypeId;

    private Integer inOutNumber;

    private Integer actionType;

    private String mark;

    private Date createTime;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getProdSaleAttrId() {
        return prodSaleAttrId;
    }

    public void setProdSaleAttrId(Long prodSaleAttrId) {
        this.prodSaleAttrId = prodSaleAttrId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProTypeId() {
        return proTypeId;
    }

    public void setProTypeId(Long proTypeId) {
        this.proTypeId = proTypeId;
    }

    public Integer getInOutNumber() {
        return inOutNumber;
    }

    public void setInOutNumber(Integer inOutNumber) {
        this.inOutNumber = inOutNumber;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}