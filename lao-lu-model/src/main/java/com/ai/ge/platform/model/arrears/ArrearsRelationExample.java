package com.ai.ge.platform.model.arrears;

import java.util.ArrayList;
import java.util.List;

public class ArrearsRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArrearsRelationExample() {
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

        public Criteria andReIdIsNull() {
            addCriterion("RE_ID is null");
            return (Criteria) this;
        }

        public Criteria andReIdIsNotNull() {
            addCriterion("RE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReIdEqualTo(Long value) {
            addCriterion("RE_ID =", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotEqualTo(Long value) {
            addCriterion("RE_ID <>", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdGreaterThan(Long value) {
            addCriterion("RE_ID >", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdGreaterThanOrEqualTo(Long value) {
            addCriterion("RE_ID >=", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdLessThan(Long value) {
            addCriterion("RE_ID <", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdLessThanOrEqualTo(Long value) {
            addCriterion("RE_ID <=", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdIn(List<Long> values) {
            addCriterion("RE_ID in", values, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotIn(List<Long> values) {
            addCriterion("RE_ID not in", values, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdBetween(Long value1, Long value2) {
            addCriterion("RE_ID between", value1, value2, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotBetween(Long value1, Long value2) {
            addCriterion("RE_ID not between", value1, value2, "reId");
            return (Criteria) this;
        }

        public Criteria andAuIdIsNull() {
            addCriterion("AU_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuIdIsNotNull() {
            addCriterion("AU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuIdEqualTo(Long value) {
            addCriterion("AU_ID =", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotEqualTo(Long value) {
            addCriterion("AU_ID <>", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdGreaterThan(Long value) {
            addCriterion("AU_ID >", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("AU_ID >=", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdLessThan(Long value) {
            addCriterion("AU_ID <", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdLessThanOrEqualTo(Long value) {
            addCriterion("AU_ID <=", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdIn(List<Long> values) {
            addCriterion("AU_ID in", values, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotIn(List<Long> values) {
            addCriterion("AU_ID not in", values, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdBetween(Long value1, Long value2) {
            addCriterion("AU_ID between", value1, value2, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotBetween(Long value1, Long value2) {
            addCriterion("AU_ID not between", value1, value2, "auId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdIsNull() {
            addCriterion("ARREARS_ID is null");
            return (Criteria) this;
        }

        public Criteria andArrearsIdIsNotNull() {
            addCriterion("ARREARS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andArrearsIdEqualTo(Long value) {
            addCriterion("ARREARS_ID =", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdNotEqualTo(Long value) {
            addCriterion("ARREARS_ID <>", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdGreaterThan(Long value) {
            addCriterion("ARREARS_ID >", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ARREARS_ID >=", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdLessThan(Long value) {
            addCriterion("ARREARS_ID <", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdLessThanOrEqualTo(Long value) {
            addCriterion("ARREARS_ID <=", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdIn(List<Long> values) {
            addCriterion("ARREARS_ID in", values, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdNotIn(List<Long> values) {
            addCriterion("ARREARS_ID not in", values, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdBetween(Long value1, Long value2) {
            addCriterion("ARREARS_ID between", value1, value2, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdNotBetween(Long value1, Long value2) {
            addCriterion("ARREARS_ID not between", value1, value2, "arrearsId");
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