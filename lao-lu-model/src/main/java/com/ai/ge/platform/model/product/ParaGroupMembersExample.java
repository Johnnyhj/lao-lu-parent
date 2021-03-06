package com.ai.ge.platform.model.product;

import java.util.ArrayList;
import java.util.List;

public class ParaGroupMembersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParaGroupMembersExample() {
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

        public Criteria andParaSpecIdIsNull() {
            addCriterion("PARA_SPEC_ID is null");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdIsNotNull() {
            addCriterion("PARA_SPEC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdEqualTo(Long value) {
            addCriterion("PARA_SPEC_ID =", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdNotEqualTo(Long value) {
            addCriterion("PARA_SPEC_ID <>", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdGreaterThan(Long value) {
            addCriterion("PARA_SPEC_ID >", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARA_SPEC_ID >=", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdLessThan(Long value) {
            addCriterion("PARA_SPEC_ID <", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdLessThanOrEqualTo(Long value) {
            addCriterion("PARA_SPEC_ID <=", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdIn(List<Long> values) {
            addCriterion("PARA_SPEC_ID in", values, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdNotIn(List<Long> values) {
            addCriterion("PARA_SPEC_ID not in", values, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdBetween(Long value1, Long value2) {
            addCriterion("PARA_SPEC_ID between", value1, value2, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdNotBetween(Long value1, Long value2) {
            addCriterion("PARA_SPEC_ID not between", value1, value2, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdIsNull() {
            addCriterion("PARA_SPEC_GROUP_CD is null");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdIsNotNull() {
            addCriterion("PARA_SPEC_GROUP_CD is not null");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdEqualTo(Long value) {
            addCriterion("PARA_SPEC_GROUP_CD =", value, "paraSpecGroupCd");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdNotEqualTo(Long value) {
            addCriterion("PARA_SPEC_GROUP_CD <>", value, "paraSpecGroupCd");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdGreaterThan(Long value) {
            addCriterion("PARA_SPEC_GROUP_CD >", value, "paraSpecGroupCd");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARA_SPEC_GROUP_CD >=", value, "paraSpecGroupCd");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdLessThan(Long value) {
            addCriterion("PARA_SPEC_GROUP_CD <", value, "paraSpecGroupCd");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdLessThanOrEqualTo(Long value) {
            addCriterion("PARA_SPEC_GROUP_CD <=", value, "paraSpecGroupCd");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdIn(List<Long> values) {
            addCriterion("PARA_SPEC_GROUP_CD in", values, "paraSpecGroupCd");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdNotIn(List<Long> values) {
            addCriterion("PARA_SPEC_GROUP_CD not in", values, "paraSpecGroupCd");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdBetween(Long value1, Long value2) {
            addCriterion("PARA_SPEC_GROUP_CD between", value1, value2, "paraSpecGroupCd");
            return (Criteria) this;
        }

        public Criteria andParaSpecGroupCdNotBetween(Long value1, Long value2) {
            addCriterion("PARA_SPEC_GROUP_CD not between", value1, value2, "paraSpecGroupCd");
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