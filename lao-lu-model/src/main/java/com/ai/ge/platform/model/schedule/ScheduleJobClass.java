package com.ai.ge.platform.model.schedule;

import java.math.BigDecimal;
import java.util.Date;

public class ScheduleJobClass {
    private Long jobId;

    private String handleClass;

    private String jobCn;

    private String jobEn;

    private String jobDesc;

    private String jobParam;

    private String state;

    private Date version;

    private BigDecimal jobGroup;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getHandleClass() {
        return handleClass;
    }

    public void setHandleClass(String handleClass) {
        this.handleClass = handleClass == null ? null : handleClass.trim();
    }

    public String getJobCn() {
        return jobCn;
    }

    public void setJobCn(String jobCn) {
        this.jobCn = jobCn == null ? null : jobCn.trim();
    }

    public String getJobEn() {
        return jobEn;
    }

    public void setJobEn(String jobEn) {
        this.jobEn = jobEn == null ? null : jobEn.trim();
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc == null ? null : jobDesc.trim();
    }

    public String getJobParam() {
        return jobParam;
    }

    public void setJobParam(String jobParam) {
        this.jobParam = jobParam == null ? null : jobParam.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }

    public BigDecimal getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(BigDecimal jobGroup) {
        this.jobGroup = jobGroup;
    }
}