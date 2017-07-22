package com.ai.ge.platform.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysRoleResourceReleationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleResourceReleationExample() {
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

        public Criteria andSrrIdIsNull() {
            addCriterion("SRR_ID is null");
            return (Criteria) this;
        }

        public Criteria andSrrIdIsNotNull() {
            addCriterion("SRR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSrrIdEqualTo(Long value) {
            addCriterion("SRR_ID =", value, "srrId");
            return (Criteria) this;
        }

        public Criteria andSrrIdNotEqualTo(Long value) {
            addCriterion("SRR_ID <>", value, "srrId");
            return (Criteria) this;
        }

        public Criteria andSrrIdGreaterThan(Long value) {
            addCriterion("SRR_ID >", value, "srrId");
            return (Criteria) this;
        }

        public Criteria andSrrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SRR_ID >=", value, "srrId");
            return (Criteria) this;
        }

        public Criteria andSrrIdLessThan(Long value) {
            addCriterion("SRR_ID <", value, "srrId");
            return (Criteria) this;
        }

        public Criteria andSrrIdLessThanOrEqualTo(Long value) {
            addCriterion("SRR_ID <=", value, "srrId");
            return (Criteria) this;
        }

        public Criteria andSrrIdIn(List<Long> values) {
            addCriterion("SRR_ID in", values, "srrId");
            return (Criteria) this;
        }

        public Criteria andSrrIdNotIn(List<Long> values) {
            addCriterion("SRR_ID not in", values, "srrId");
            return (Criteria) this;
        }

        public Criteria andSrrIdBetween(Long value1, Long value2) {
            addCriterion("SRR_ID between", value1, value2, "srrId");
            return (Criteria) this;
        }

        public Criteria andSrrIdNotBetween(Long value1, Long value2) {
            addCriterion("SRR_ID not between", value1, value2, "srrId");
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

        public Criteria andSysResourceIdIsNull() {
            addCriterion("SYS_RESOURCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdIsNotNull() {
            addCriterion("SYS_RESOURCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdEqualTo(Long value) {
            addCriterion("SYS_RESOURCE_ID =", value, "sysResourceId");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdNotEqualTo(Long value) {
            addCriterion("SYS_RESOURCE_ID <>", value, "sysResourceId");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdGreaterThan(Long value) {
            addCriterion("SYS_RESOURCE_ID >", value, "sysResourceId");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SYS_RESOURCE_ID >=", value, "sysResourceId");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdLessThan(Long value) {
            addCriterion("SYS_RESOURCE_ID <", value, "sysResourceId");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdLessThanOrEqualTo(Long value) {
            addCriterion("SYS_RESOURCE_ID <=", value, "sysResourceId");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdIn(List<Long> values) {
            addCriterion("SYS_RESOURCE_ID in", values, "sysResourceId");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdNotIn(List<Long> values) {
            addCriterion("SYS_RESOURCE_ID not in", values, "sysResourceId");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdBetween(Long value1, Long value2) {
            addCriterion("SYS_RESOURCE_ID between", value1, value2, "sysResourceId");
            return (Criteria) this;
        }

        public Criteria andSysResourceIdNotBetween(Long value1, Long value2) {
            addCriterion("SYS_RESOURCE_ID not between", value1, value2, "sysResourceId");
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