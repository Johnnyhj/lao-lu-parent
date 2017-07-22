package com.ai.ge.platform.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysResource {
    private Long id;

    private String name;

    private String type;

    private String url;

    private Long parentId;

    private String parentIds;

    private String permission;

    private Short available;
    private Long rootId;

    private Date createTime;

    private Date updateTime;

    private List<SysResource> sysResources = new ArrayList<SysResource>();

    public enum ResourceType {
        menu("菜单"), button("按钮");

        private final String info;

        ResourceType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Short getAvailable() {
        return available;
    }

    public void setAvailable(Short available) {


        this.available = available;
    }

    public boolean isRootNode() {
        return parentId == 0;
    }

    public List<SysResource> getSysResources() {
        return sysResources;
    }

    public void setSysResources(List<SysResource> sysResources) {
        this.sysResources = sysResources;
    }
    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
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


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        SysResource that = (SysResource) object;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}