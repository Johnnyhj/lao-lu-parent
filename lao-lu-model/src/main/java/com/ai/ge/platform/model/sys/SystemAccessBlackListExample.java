package com.ai.ge.platform.model.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SystemAccessBlackListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemAccessBlackListExample() {
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

        public Criteria andBlIpIsNull() {
            addCriterion("BL_IP is null");
            return (Criteria) this;
        }

        public Criteria andBlIpIsNotNull() {
            addCriterion("BL_IP is not null");
            return (Criteria) this;
        }

        public Criteria andBlIpEqualTo(String value) {
            addCriterion("BL_IP =", value, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpNotEqualTo(String value) {
            addCriterion("BL_IP <>", value, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpGreaterThan(String value) {
            addCriterion("BL_IP >", value, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpGreaterThanOrEqualTo(String value) {
            addCriterion("BL_IP >=", value, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpLessThan(String value) {
            addCriterion("BL_IP <", value, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpLessThanOrEqualTo(String value) {
            addCriterion("BL_IP <=", value, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpLike(String value) {
            addCriterion("BL_IP like", value, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpNotLike(String value) {
            addCriterion("BL_IP not like", value, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpIn(List<String> values) {
            addCriterion("BL_IP in", values, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpNotIn(List<String> values) {
            addCriterion("BL_IP not in", values, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpBetween(String value1, String value2) {
            addCriterion("BL_IP between", value1, value2, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlIpNotBetween(String value1, String value2) {
            addCriterion("BL_IP not between", value1, value2, "blIp");
            return (Criteria) this;
        }

        public Criteria andBlTimeIsNull() {
            addCriterion("BL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBlTimeIsNotNull() {
            addCriterion("BL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBlTimeEqualTo(Date value) {
            addCriterionForJDBCDate("BL_TIME =", value, "blTime");
            return (Criteria) this;
        }

        public Criteria andBlTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("BL_TIME <>", value, "blTime");
            return (Criteria) this;
        }

        public Criteria andBlTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("BL_TIME >", value, "blTime");
            return (Criteria) this;
        }

        public Criteria andBlTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BL_TIME >=", value, "blTime");
            return (Criteria) this;
        }

        public Criteria andBlTimeLessThan(Date value) {
            addCriterionForJDBCDate("BL_TIME <", value, "blTime");
            return (Criteria) this;
        }

        public Criteria andBlTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BL_TIME <=", value, "blTime");
            return (Criteria) this;
        }

        public Criteria andBlTimeIn(List<Date> values) {
            addCriterionForJDBCDate("BL_TIME in", values, "blTime");
            return (Criteria) this;
        }

        public Criteria andBlTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("BL_TIME not in", values, "blTime");
            return (Criteria) this;
        }

        public Criteria andBlTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BL_TIME between", value1, value2, "blTime");
            return (Criteria) this;
        }

        public Criteria andBlTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BL_TIME not between", value1, value2, "blTime");
            return (Criteria) this;
        }

        public Criteria andBlAccNumIsNull() {
            addCriterion("BL_ACC_NUM is null");
            return (Criteria) this;
        }

        public Criteria andBlAccNumIsNotNull() {
            addCriterion("BL_ACC_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andBlAccNumEqualTo(Long value) {
            addCriterion("BL_ACC_NUM =", value, "blAccNum");
            return (Criteria) this;
        }

        public Criteria andBlAccNumNotEqualTo(Long value) {
            addCriterion("BL_ACC_NUM <>", value, "blAccNum");
            return (Criteria) this;
        }

        public Criteria andBlAccNumGreaterThan(Long value) {
            addCriterion("BL_ACC_NUM >", value, "blAccNum");
            return (Criteria) this;
        }

        public Criteria andBlAccNumGreaterThanOrEqualTo(Long value) {
            addCriterion("BL_ACC_NUM >=", value, "blAccNum");
            return (Criteria) this;
        }

        public Criteria andBlAccNumLessThan(Long value) {
            addCriterion("BL_ACC_NUM <", value, "blAccNum");
            return (Criteria) this;
        }

        public Criteria andBlAccNumLessThanOrEqualTo(Long value) {
            addCriterion("BL_ACC_NUM <=", value, "blAccNum");
            return (Criteria) this;
        }

        public Criteria andBlAccNumIn(List<Long> values) {
            addCriterion("BL_ACC_NUM in", values, "blAccNum");
            return (Criteria) this;
        }

        public Criteria andBlAccNumNotIn(List<Long> values) {
            addCriterion("BL_ACC_NUM not in", values, "blAccNum");
            return (Criteria) this;
        }

        public Criteria andBlAccNumBetween(Long value1, Long value2) {
            addCriterion("BL_ACC_NUM between", value1, value2, "blAccNum");
            return (Criteria) this;
        }

        public Criteria andBlAccNumNotBetween(Long value1, Long value2) {
            addCriterion("BL_ACC_NUM not between", value1, value2, "blAccNum");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdIsNull() {
            addCriterion("BL_ACC_THRESHOLD is null");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdIsNotNull() {
            addCriterion("BL_ACC_THRESHOLD is not null");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdEqualTo(String value) {
            addCriterion("BL_ACC_THRESHOLD =", value, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdNotEqualTo(String value) {
            addCriterion("BL_ACC_THRESHOLD <>", value, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdGreaterThan(String value) {
            addCriterion("BL_ACC_THRESHOLD >", value, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdGreaterThanOrEqualTo(String value) {
            addCriterion("BL_ACC_THRESHOLD >=", value, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdLessThan(String value) {
            addCriterion("BL_ACC_THRESHOLD <", value, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdLessThanOrEqualTo(String value) {
            addCriterion("BL_ACC_THRESHOLD <=", value, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdLike(String value) {
            addCriterion("BL_ACC_THRESHOLD like", value, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdNotLike(String value) {
            addCriterion("BL_ACC_THRESHOLD not like", value, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdIn(List<String> values) {
            addCriterion("BL_ACC_THRESHOLD in", values, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdNotIn(List<String> values) {
            addCriterion("BL_ACC_THRESHOLD not in", values, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdBetween(String value1, String value2) {
            addCriterion("BL_ACC_THRESHOLD between", value1, value2, "blAccThreshold");
            return (Criteria) this;
        }

        public Criteria andBlAccThresholdNotBetween(String value1, String value2) {
            addCriterion("BL_ACC_THRESHOLD not between", value1, value2, "blAccThreshold");
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