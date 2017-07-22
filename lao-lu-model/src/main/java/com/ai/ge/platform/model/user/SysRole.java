package com.ai.ge.platform.model.user;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysRole {
    private Long id;

    private String role;

    private String description;

    private String resourceIds;

    private Short available;
    private Date createTime;

    private Date updateTime;


    private List<Long> listResourceIds; //拥有的资源

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Short getAvailable() {
        return available;
    }

    public void setAvailable(Short available) {
        this.available = available;
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

    public List<Long> getListResourceIds() {
        if (CollectionUtils.isEmpty(listResourceIds)) {
            listResourceIds = new ArrayList<Long>();
        }

        if (StringUtils.isNotBlank(resourceIds)) {
            String[] resourceIdArr = resourceIds.split(",");
            for (String s : resourceIdArr) {
                listResourceIds.add(Long.parseLong(s));
            }
        }

        return listResourceIds;
    }
}