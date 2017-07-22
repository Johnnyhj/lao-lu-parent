package com.ai.ge.platform.model.order;

import java.util.Date;

public class OrdersOperateLog {
    private Long operateId;

    private Long orderId;

    private Long sysUserId;

    private String remark;

    private Long provinceAearId;

    private Long cityAearId;

    private Date createTime;

    private Date updateTime;

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}