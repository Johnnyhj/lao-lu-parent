package com.ai.ge.platform.model.user;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUser implements Serializable {
    private static final long serialVersionUID = -3831167893884470834L;
    private Long id;

    private String username;

    private String password;

    private String salt;

    private String roleIds;

    private List<Long> listRoleIds; //拥有的角色列表

    private Short locked;

    private Short userType;

    private Date createTime;

    private Date updateTime;

    private String telPhone;

    private String email;

    private String jobUnit;

	private String userLevel;

    private Long provinceAearId;

    private Long cityAearId;

    /**
     * 页面临时使用
     */
    private Long tempAreaId;

    public Long getTempAreaId()
    {
        return tempAreaId;
    }

    public void setTempAreaId(Long tempAreaId)
    {
        this.tempAreaId = tempAreaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Short getLocked() {
        return locked;
    }

    public void setLocked(Short locked) {
        this.locked = locked;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
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

    public String getCredentialsSalt() {
        return username + salt;
    }

    public List<Long> getListRoleIds() {
        if (CollectionUtils.isEmpty(listRoleIds)) {
            listRoleIds = new ArrayList<Long>();
        }

        if (StringUtils.isNotBlank(roleIds)) {
            String[] roleIdArr = roleIds.split(",");
            for (String s : roleIdArr) {
                listRoleIds.add(Long.parseLong(s));
            }

        }

        return listRoleIds;
    }
    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobUnit() {
        return jobUnit;
    }

    public void setJobUnit(String jobUnit) {
        this.jobUnit = jobUnit;
    }

	public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
	
	public Long getProvinceAearId() {
        return provinceAearId;
    }

    public void setProvinceAearId(Long provinceAearId) {
        this.provinceAearId = provinceAearId;
    }

    public Long getCityAearId()
    {
        return cityAearId;
    }

    public void setCityAearId(Long cityAearId)
    {
        this.cityAearId = cityAearId;
    }
}