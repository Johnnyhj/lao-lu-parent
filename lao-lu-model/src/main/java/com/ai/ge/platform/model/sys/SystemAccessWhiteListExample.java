package com.ai.ge.platform.model.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SystemAccessWhiteListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemAccessWhiteListExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWlIpIsNull() {
            addCriterion("WL_IP is null");
            return (Criteria) this;
        }

        public Criteria andWlIpIsNotNull() {
            addCriterion("WL_IP is not null");
            return (Criteria) this;
        }

        public Criteria andWlIpEqualTo(String value) {
            addCriterion("WL_IP =", value, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpNotEqualTo(String value) {
            addCriterion("WL_IP <>", value, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpGreaterThan(String value) {
            addCriterion("WL_IP >", value, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpGreaterThanOrEqualTo(String value) {
            addCriterion("WL_IP >=", value, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpLessThan(String value) {
            addCriterion("WL_IP <", value, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpLessThanOrEqualTo(String value) {
            addCriterion("WL_IP <=", value, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpLike(String value) {
            addCriterion("WL_IP like", value, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpNotLike(String value) {
            addCriterion("WL_IP not like", value, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpIn(List<String> values) {
            addCriterion("WL_IP in", values, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpNotIn(List<String> values) {
            addCriterion("WL_IP not in", values, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpBetween(String value1, String value2) {
            addCriterion("WL_IP between", value1, value2, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlIpNotBetween(String value1, String value2) {
            addCriterion("WL_IP not between", value1, value2, "wlIp");
            return (Criteria) this;
        }

        public Criteria andWlTimeIsNull() {
            addCriterion("WL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWlTimeIsNotNull() {
            addCriterion("WL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWlTimeEqualTo(Date value) {
            addCriterionForJDBCDate("WL_TIME =", value, "wlTime");
            return (Criteria) this;
        }

        public Criteria andWlTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("WL_TIME <>", value, "wlTime");
            return (Criteria) this;
        }

        public Criteria andWlTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("WL_TIME >", value, "wlTime");
            return (Criteria) this;
        }

        public Criteria andWlTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("WL_TIME >=", value, "wlTime");
            return (Criteria) this;
        }

        public Criteria andWlTimeLessThan(Date value) {
            addCriterionForJDBCDate("WL_TIME <", value, "wlTime");
            return (Criteria) this;
        }

        public Criteria andWlTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("WL_TIME <=", value, "wlTime");
            return (Criteria) this;
        }

        public Criteria andWlTimeIn(List<Date> values) {
            addCriterionForJDBCDate("WL_TIME in", values, "wlTime");
            return (Criteria) this;
        }

        public Criteria andWlTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("WL_TIME not in", values, "wlTime");
            return (Criteria) this;
        }

        public Criteria andWlTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("WL_TIME between", value1, value2, "wlTime");
            return (Criteria) this;
        }

        public Criteria andWlTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("WL_TIME not between", value1, value2, "wlTime");
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