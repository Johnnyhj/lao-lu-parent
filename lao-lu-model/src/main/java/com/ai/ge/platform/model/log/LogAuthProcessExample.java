package com.ai.ge.platform.model.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LogAuthProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogAuthProcessExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andProcessIdIsNull() {
            addCriterion("PROCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("PROCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(Long value) {
            addCriterion("PROCESS_ID =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(Long value) {
            addCriterion("PROCESS_ID <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(Long value) {
            addCriterion("PROCESS_ID >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROCESS_ID >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(Long value) {
            addCriterion("PROCESS_ID <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(Long value) {
            addCriterion("PROCESS_ID <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<Long> values) {
            addCriterion("PROCESS_ID in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<Long> values) {
            addCriterion("PROCESS_ID not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(Long value1, Long value2) {
            addCriterion("PROCESS_ID between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(Long value1, Long value2) {
            addCriterion("PROCESS_ID not between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNull() {
            addCriterion("SYS_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNotNull() {
            addCriterion("SYS_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdEqualTo(Long value) {
            addCriterion("SYS_USER_ID =", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotEqualTo(Long value) {
            addCriterion("SYS_USER_ID <>", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThan(Long value) {
            addCriterion("SYS_USER_ID >", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SYS_USER_ID >=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThan(Long value) {
            addCriterion("SYS_USER_ID <", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThanOrEqualTo(Long value) {
            addCriterion("SYS_USER_ID <=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIn(List<Long> values) {
            addCriterion("SYS_USER_ID in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotIn(List<Long> values) {
            addCriterion("SYS_USER_ID not in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdBetween(Long value1, Long value2) {
            addCriterion("SYS_USER_ID between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotBetween(Long value1, Long value2) {
            addCriterion("SYS_USER_ID not between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdIsNull() {
            addCriterion("AUTH_SYS_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdIsNotNull() {
            addCriterion("AUTH_SYS_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdEqualTo(Long value) {
            addCriterion("AUTH_SYS_USER_ID =", value, "authSysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdNotEqualTo(Long value) {
            addCriterion("AUTH_SYS_USER_ID <>", value, "authSysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdGreaterThan(Long value) {
            addCriterion("AUTH_SYS_USER_ID >", value, "authSysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("AUTH_SYS_USER_ID >=", value, "authSysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdLessThan(Long value) {
            addCriterion("AUTH_SYS_USER_ID <", value, "authSysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdLessThanOrEqualTo(Long value) {
            addCriterion("AUTH_SYS_USER_ID <=", value, "authSysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdIn(List<Long> values) {
            addCriterion("AUTH_SYS_USER_ID in", values, "authSysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdNotIn(List<Long> values) {
            addCriterion("AUTH_SYS_USER_ID not in", values, "authSysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdBetween(Long value1, Long value2) {
            addCriterion("AUTH_SYS_USER_ID between", value1, value2, "authSysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthSysUserIdNotBetween(Long value1, Long value2) {
            addCriterion("AUTH_SYS_USER_ID not between", value1, value2, "authSysUserId");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameIsNull() {
            addCriterion("AUTH_ROLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameIsNotNull() {
            addCriterion("AUTH_ROLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameEqualTo(String value) {
            addCriterion("AUTH_ROLE_NAME =", value, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameNotEqualTo(String value) {
            addCriterion("AUTH_ROLE_NAME <>", value, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameGreaterThan(String value) {
            addCriterion("AUTH_ROLE_NAME >", value, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_ROLE_NAME >=", value, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameLessThan(String value) {
            addCriterion("AUTH_ROLE_NAME <", value, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameLessThanOrEqualTo(String value) {
            addCriterion("AUTH_ROLE_NAME <=", value, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameLike(String value) {
            addCriterion("AUTH_ROLE_NAME like", value, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameNotLike(String value) {
            addCriterion("AUTH_ROLE_NAME not like", value, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameIn(List<String> values) {
            addCriterion("AUTH_ROLE_NAME in", values, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameNotIn(List<String> values) {
            addCriterion("AUTH_ROLE_NAME not in", values, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameBetween(String value1, String value2) {
            addCriterion("AUTH_ROLE_NAME between", value1, value2, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andAuthRoleNameNotBetween(String value1, String value2) {
            addCriterion("AUTH_ROLE_NAME not between", value1, value2, "authRoleName");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNull() {
            addCriterion("EFFECTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNotNull() {
            addCriterion("EFFECTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME =", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME <>", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME >", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME >=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThan(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME <", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME <=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIn(List<Date> values) {
            addCriterionForJDBCDate("EFFECTIVE_TIME in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("EFFECTIVE_TIME not in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EFFECTIVE_TIME between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EFFECTIVE_TIME not between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeIsNull() {
            addCriterion("FAIL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFailTimeIsNotNull() {
            addCriterion("FAIL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFailTimeEqualTo(Date value) {
            addCriterionForJDBCDate("FAIL_TIME =", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("FAIL_TIME <>", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("FAIL_TIME >", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FAIL_TIME >=", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeLessThan(Date value) {
            addCriterionForJDBCDate("FAIL_TIME <", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FAIL_TIME <=", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeIn(List<Date> values) {
            addCriterionForJDBCDate("FAIL_TIME in", values, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("FAIL_TIME not in", values, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FAIL_TIME between", value1, value2, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FAIL_TIME not between", value1, value2, "failTime");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNull() {
            addCriterion("AUTH_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNotNull() {
            addCriterion("AUTH_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeEqualTo(Short value) {
            addCriterion("AUTH_TYPE =", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotEqualTo(Short value) {
            addCriterion("AUTH_TYPE <>", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThan(Short value) {
            addCriterion("AUTH_TYPE >", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("AUTH_TYPE >=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThan(Short value) {
            addCriterion("AUTH_TYPE <", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThanOrEqualTo(Short value) {
            addCriterion("AUTH_TYPE <=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIn(List<Short> values) {
            addCriterion("AUTH_TYPE in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotIn(List<Short> values) {
            addCriterion("AUTH_TYPE not in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeBetween(Short value1, Short value2) {
            addCriterion("AUTH_TYPE between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotBetween(Short value1, Short value2) {
            addCriterion("AUTH_TYPE not between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNull() {
            addCriterion("OPERATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNotNull() {
            addCriterion("OPERATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeEqualTo(Short value) {
            addCriterion("OPERATE_TYPE =", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotEqualTo(Short value) {
            addCriterion("OPERATE_TYPE <>", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThan(Short value) {
            addCriterion("OPERATE_TYPE >", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("OPERATE_TYPE >=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThan(Short value) {
            addCriterion("OPERATE_TYPE <", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThanOrEqualTo(Short value) {
            addCriterion("OPERATE_TYPE <=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIn(List<Short> values) {
            addCriterion("OPERATE_TYPE in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotIn(List<Short> values) {
            addCriterion("OPERATE_TYPE not in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeBetween(Short value1, Short value2) {
            addCriterion("OPERATE_TYPE between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotBetween(Short value1, Short value2) {
            addCriterion("OPERATE_TYPE not between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNull() {
            addCriterion("RESOURCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("RESOURCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdEqualTo(Long value) {
            addCriterion("RESOURCE_ID =", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotEqualTo(Long value) {
            addCriterion("RESOURCE_ID <>", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThan(Long value) {
            addCriterion("RESOURCE_ID >", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("RESOURCE_ID >=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThan(Long value) {
            addCriterion("RESOURCE_ID <", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(Long value) {
            addCriterion("RESOURCE_ID <=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdIn(List<Long> values) {
            addCriterion("RESOURCE_ID in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotIn(List<Long> values) {
            addCriterion("RESOURCE_ID not in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdBetween(Long value1, Long value2) {
            addCriterion("RESOURCE_ID between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotBetween(Long value1, Long value2) {
            addCriterion("RESOURCE_ID not between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("RESOURCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("RESOURCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("RESOURCE_NAME =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("RESOURCE_NAME <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("RESOURCE_NAME >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_NAME >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("RESOURCE_NAME <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_NAME <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("RESOURCE_NAME like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("RESOURCE_NAME not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("RESOURCE_NAME in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("RESOURCE_NAME not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("RESOURCE_NAME between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_NAME not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Long value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Long value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("ROLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("ROLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("ROLE_NAME =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("ROLE_NAME <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("ROLE_NAME >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("ROLE_NAME <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("ROLE_NAME like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("ROLE_NAME not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("ROLE_NAME in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("ROLE_NAME not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("ROLE_NAME between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("ROLE_NAME not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}