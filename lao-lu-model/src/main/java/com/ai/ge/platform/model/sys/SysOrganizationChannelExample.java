package com.ai.ge.platform.model.sys;

import java.util.ArrayList;
import java.util.List;

public class SysOrganizationChannelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysOrganizationChannelExample() {
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

        public Criteria andSocIdIsNull() {
            addCriterion("SOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSocIdIsNotNull() {
            addCriterion("SOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSocIdEqualTo(Long value) {
            addCriterion("SOC_ID =", value, "socId");
            return (Criteria) this;
        }

        public Criteria andSocIdNotEqualTo(Long value) {
            addCriterion("SOC_ID <>", value, "socId");
            return (Criteria) this;
        }

        public Criteria andSocIdGreaterThan(Long value) {
            addCriterion("SOC_ID >", value, "socId");
            return (Criteria) this;
        }

        public Criteria andSocIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SOC_ID >=", value, "socId");
            return (Criteria) this;
        }

        public Criteria andSocIdLessThan(Long value) {
            addCriterion("SOC_ID <", value, "socId");
            return (Criteria) this;
        }

        public Criteria andSocIdLessThanOrEqualTo(Long value) {
            addCriterion("SOC_ID <=", value, "socId");
            return (Criteria) this;
        }

        public Criteria andSocIdIn(List<Long> values) {
            addCriterion("SOC_ID in", values, "socId");
            return (Criteria) this;
        }

        public Criteria andSocIdNotIn(List<Long> values) {
            addCriterion("SOC_ID not in", values, "socId");
            return (Criteria) this;
        }

        public Criteria andSocIdBetween(Long value1, Long value2) {
            addCriterion("SOC_ID between", value1, value2, "socId");
            return (Criteria) this;
        }

        public Criteria andSocIdNotBetween(Long value1, Long value2) {
            addCriterion("SOC_ID not between", value1, value2, "socId");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdIsNull() {
            addCriterion("SYS_ORGANIZATION_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdIsNotNull() {
            addCriterion("SYS_ORGANIZATION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdEqualTo(Long value) {
            addCriterion("SYS_ORGANIZATION_ID =", value, "sysOrganizationId");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdNotEqualTo(Long value) {
            addCriterion("SYS_ORGANIZATION_ID <>", value, "sysOrganizationId");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdGreaterThan(Long value) {
            addCriterion("SYS_ORGANIZATION_ID >", value, "sysOrganizationId");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SYS_ORGANIZATION_ID >=", value, "sysOrganizationId");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdLessThan(Long value) {
            addCriterion("SYS_ORGANIZATION_ID <", value, "sysOrganizationId");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdLessThanOrEqualTo(Long value) {
            addCriterion("SYS_ORGANIZATION_ID <=", value, "sysOrganizationId");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdIn(List<Long> values) {
            addCriterion("SYS_ORGANIZATION_ID in", values, "sysOrganizationId");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdNotIn(List<Long> values) {
            addCriterion("SYS_ORGANIZATION_ID not in", values, "sysOrganizationId");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdBetween(Long value1, Long value2) {
            addCriterion("SYS_ORGANIZATION_ID between", value1, value2, "sysOrganizationId");
            return (Criteria) this;
        }

        public Criteria andSysOrganizationIdNotBetween(Long value1, Long value2) {
            addCriterion("SYS_ORGANIZATION_ID not between", value1, value2, "sysOrganizationId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("CHANNEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("CHANNEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Long value) {
            addCriterion("CHANNEL_ID =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Long value) {
            addCriterion("CHANNEL_ID <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Long value) {
            addCriterion("CHANNEL_ID >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CHANNEL_ID >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Long value) {
            addCriterion("CHANNEL_ID <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Long value) {
            addCriterion("CHANNEL_ID <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Long> values) {
            addCriterion("CHANNEL_ID in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Long> values) {
            addCriterion("CHANNEL_ID not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Long value1, Long value2) {
            addCriterion("CHANNEL_ID between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Long value1, Long value2) {
            addCriterion("CHANNEL_ID not between", value1, value2, "channelId");
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