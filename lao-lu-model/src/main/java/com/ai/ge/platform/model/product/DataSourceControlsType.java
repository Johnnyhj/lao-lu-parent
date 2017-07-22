package com.ai.ge.platform.model.product;

import java.util.Date;

public class DataSourceControlsType {
    private Integer dscTypeCd;

    private String name;

    private String description;

    private Date createTime;

    private Date version;

    public Integer getDscTypeCd() {
        return dscTypeCd;
    }

    public void setDscTypeCd(Integer dscTypeCd) {
        this.dscTypeCd = dscTypeCd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }
}