package com.ai.ge.platform.model.order;

public class PackageOrdersRelations {
    private Long relationId;

    private Long orderId;

    private Long ordersGroupId;

    private Long orderGroupId;

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrdersGroupId() {
        return ordersGroupId;
    }

    public void setOrdersGroupId(Long ordersGroupId) {
        this.ordersGroupId = ordersGroupId;
    }

    public Long getOrderGroupId() {
        return orderGroupId;
    }

    public void setOrderGroupId(Long orderGroupId) {
        this.orderGroupId = orderGroupId;
    }
}