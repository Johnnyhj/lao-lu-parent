package com.ai.ge.platform.model.user;

import java.util.Date;

public class SysOrganization {
    private Long id;

    private String name;

    private Long parentId;

    private String parentIds;

    private Short available;

	private String post;

    private Short orgAdmin;

    private Long leaderId;
    private Long rootId;

    private Date createTime;

    private Date updateTime;

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

    public Short getAvailable() {
        return available;
    }

    public void setAvailable(Short available) {

        this.available = available;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }

    public boolean isRootNode() {
        return parentId == 0;
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
	
	public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Short getOrgAdmin() {
        return orgAdmin;
    }

    public void setOrgAdmin(Short orgAdmin) {
        this.orgAdmin = orgAdmin;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }
}