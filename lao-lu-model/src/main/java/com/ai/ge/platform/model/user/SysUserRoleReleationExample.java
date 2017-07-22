package com.ai.ge.platform.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysUserRoleReleationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserRoleReleationExample() {
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

        public Criteria andSurrIdIsNull() {
            addCriterion("SURR_ID is null");
            return (Criteria) this;
        }

        public Criteria andSurrIdIsNotNull() {
            addCriterion("SURR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSurrIdEqualTo(Long value) {
            addCriterion("SURR_ID =", value, "surrId");
            return (Criteria) this;
        }

        public Criteria andSurrIdNotEqualTo(Long value) {
            addCriterion("SURR_ID <>", value, "surrId");
            return (Criteria) this;
        }

        public Criteria andSurrIdGreaterThan(Long value) {
            addCriterion("SURR_ID >", value, "surrId");
            return (Criteria) this;
        }

        public Criteria andSurrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SURR_ID >=", value, "surrId");
            return (Criteria) this;
        }

        public Criteria andSurrIdLessThan(Long value) {
            addCriterion("SURR_ID <", value, "surrId");
            return (Criteria) this;
        }

        public Criteria andSurrIdLessThanOrEqualTo(Long value) {
            addCriterion("SURR_ID <=", value, "surrId");
            return (Criteria) this;
        }

        public Criteria andSurrIdIn(List<Long> values) {
            addCriterion("SURR_ID in", values, "surrId");
            return (Criteria) this;
        }

        public Criteria andSurrIdNotIn(List<Long> values) {
            addCriterion("SURR_ID not in", values, "surrId");
            return (Criteria) this;
        }

        public Criteria andSurrIdBetween(Long value1, Long value2) {
            addCriterion("SURR_ID between", value1, value2, "surrId");
            return (Criteria) this;
        }

        public Criteria andSurrIdNotBetween(Long value1, Long value2) {
            addCriterion("SURR_ID not between", value1, value2, "surrId");
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

        public Criteria andSysRoleIdIsNull() {
            addCriterion("SYS_ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdIsNotNull() {
            addCriterion("SYS_ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdEqualTo(Long value) {
            addCriterion("SYS_ROLE_ID =", value, "sysRoleId");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdNotEqualTo(Long value) {
            addCriterion("SYS_ROLE_ID <>", value, "sysRoleId");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdGreaterThan(Long value) {
            addCriterion("SYS_ROLE_ID >", value, "sysRoleId");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SYS_ROLE_ID >=", value, "sysRoleId");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdLessThan(Long value) {
            addCriterion("SYS_ROLE_ID <", value, "sysRoleId");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("SYS_ROLE_ID <=", value, "sysRoleId");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdIn(List<Long> values) {
            addCriterion("SYS_ROLE_ID in", values, "sysRoleId");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdNotIn(List<Long> values) {
            addCriterion("SYS_ROLE_ID not in", values, "sysRoleId");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdBetween(Long value1, Long value2) {
            addCriterion("SYS_ROLE_ID between", value1, value2, "sysRoleId");
            return (Criteria) this;
        }

        public Criteria andSysRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("SYS_ROLE_ID not between", value1, value2, "sysRoleId");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME not between", value1, value2, "updateTime");
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