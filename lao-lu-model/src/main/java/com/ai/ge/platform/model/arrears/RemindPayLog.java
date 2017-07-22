package com.ai.ge.platform.model.arrears;

import java.util.Date;

public class RemindPayLog {
    private Long rpId;

    private Long arrearsId;

    private Date arrearsTime;

    private Long staffCode;

    private Short status;

    private Short actionType;

    public Long getRpId() {
        return rpId;
    }

    public void setRpId(Long rpId) {
        this.rpId = rpId;
    }

    public Long getArrearsId() {
        return arrearsId;
    }

    public void setArrearsId(Long arrearsId) {
        this.arrearsId = arrearsId;
    }

    public Date getArrearsTime() {
        return arrearsTime;
    }

    public void setArrearsTime(Date arrearsTime) {
        this.arrearsTime = arrearsTime;
    }

    public Long getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(Long staffCode) {
        this.staffCode = staffCode;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getActionType() {
        return actionType;
    }

    public void setActionType(Short actionType) {
        this.actionType = actionType;
    }
}