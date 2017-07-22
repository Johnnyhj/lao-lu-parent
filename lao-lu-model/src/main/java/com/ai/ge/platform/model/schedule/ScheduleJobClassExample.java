package com.ai.ge.platform.model.schedule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ScheduleJobClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScheduleJobClassExample() {
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
            addCriterion(condition, value, property);
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
            addCriterion(condition, value1, value2, property);
        }

        public Criteria andJobIdIsNull() {
            addCriterion("JOB_ID is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("JOB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Long value) {
            addCriterion("JOB_ID =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Long value) {
            addCriterion("JOB_ID <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Long value) {
            addCriterion("JOB_ID >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("JOB_ID >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Long value) {
            addCriterion("JOB_ID <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Long value) {
            addCriterion("JOB_ID <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Long> values) {
            addCriterion("JOB_ID in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Long> values) {
            addCriterion("JOB_ID not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Long value1, Long value2) {
            addCriterion("JOB_ID between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Long value1, Long value2) {
            addCriterion("JOB_ID not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andHandleClassIsNull() {
            addCriterion("HANDLE_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andHandleClassIsNotNull() {
            addCriterion("HANDLE_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andHandleClassEqualTo(String value) {
            addCriterion("HANDLE_CLASS =", value, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassNotEqualTo(String value) {
            addCriterion("HANDLE_CLASS <>", value, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassGreaterThan(String value) {
            addCriterion("HANDLE_CLASS >", value, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassGreaterThanOrEqualTo(String value) {
            addCriterion("HANDLE_CLASS >=", value, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassLessThan(String value) {
            addCriterion("HANDLE_CLASS <", value, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassLessThanOrEqualTo(String value) {
            addCriterion("HANDLE_CLASS <=", value, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassLike(String value) {
            addCriterion("HANDLE_CLASS like", value, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassNotLike(String value) {
            addCriterion("HANDLE_CLASS not like", value, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassIn(List<String> values) {
            addCriterion("HANDLE_CLASS in", values, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassNotIn(List<String> values) {
            addCriterion("HANDLE_CLASS not in", values, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassBetween(String value1, String value2) {
            addCriterion("HANDLE_CLASS between", value1, value2, "handleClass");
            return (Criteria) this;
        }

        public Criteria andHandleClassNotBetween(String value1, String value2) {
            addCriterion("HANDLE_CLASS not between", value1, value2, "handleClass");
            return (Criteria) this;
        }

        public Criteria andJobCnIsNull() {
            addCriterion("JOB_CN is null");
            return (Criteria) this;
        }

        public Criteria andJobCnIsNotNull() {
            addCriterion("JOB_CN is not null");
            return (Criteria) this;
        }

        public Criteria andJobCnEqualTo(String value) {
            addCriterion("JOB_CN =", value, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnNotEqualTo(String value) {
            addCriterion("JOB_CN <>", value, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnGreaterThan(String value) {
            addCriterion("JOB_CN >", value, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_CN >=", value, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnLessThan(String value) {
            addCriterion("JOB_CN <", value, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnLessThanOrEqualTo(String value) {
            addCriterion("JOB_CN <=", value, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnLike(String value) {
            addCriterion("JOB_CN like", value, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnNotLike(String value) {
            addCriterion("JOB_CN not like", value, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnIn(List<String> values) {
            addCriterion("JOB_CN in", values, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnNotIn(List<String> values) {
            addCriterion("JOB_CN not in", values, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnBetween(String value1, String value2) {
            addCriterion("JOB_CN between", value1, value2, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobCnNotBetween(String value1, String value2) {
            addCriterion("JOB_CN not between", value1, value2, "jobCn");
            return (Criteria) this;
        }

        public Criteria andJobEnIsNull() {
            addCriterion("JOB_EN is null");
            return (Criteria) this;
        }

        public Criteria andJobEnIsNotNull() {
            addCriterion("JOB_EN is not null");
            return (Criteria) this;
        }

        public Criteria andJobEnEqualTo(String value) {
            addCriterion("JOB_EN =", value, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnNotEqualTo(String value) {
            addCriterion("JOB_EN <>", value, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnGreaterThan(String value) {
            addCriterion("JOB_EN >", value, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_EN >=", value, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnLessThan(String value) {
            addCriterion("JOB_EN <", value, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnLessThanOrEqualTo(String value) {
            addCriterion("JOB_EN <=", value, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnLike(String value) {
            addCriterion("JOB_EN like", value, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnNotLike(String value) {
            addCriterion("JOB_EN not like", value, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnIn(List<String> values) {
            addCriterion("JOB_EN in", values, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnNotIn(List<String> values) {
            addCriterion("JOB_EN not in", values, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnBetween(String value1, String value2) {
            addCriterion("JOB_EN between", value1, value2, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobEnNotBetween(String value1, String value2) {
            addCriterion("JOB_EN not between", value1, value2, "jobEn");
            return (Criteria) this;
        }

        public Criteria andJobDescIsNull() {
            addCriterion("JOB_DESC is null");
            return (Criteria) this;
        }

        public Criteria andJobDescIsNotNull() {
            addCriterion("JOB_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andJobDescEqualTo(String value) {
            addCriterion("JOB_DESC =", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescNotEqualTo(String value) {
            addCriterion("JOB_DESC <>", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescGreaterThan(String value) {
            addCriterion("JOB_DESC >", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_DESC >=", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescLessThan(String value) {
            addCriterion("JOB_DESC <", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescLessThanOrEqualTo(String value) {
            addCriterion("JOB_DESC <=", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescLike(String value) {
            addCriterion("JOB_DESC like", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescNotLike(String value) {
            addCriterion("JOB_DESC not like", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescIn(List<String> values) {
            addCriterion("JOB_DESC in", values, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescNotIn(List<String> values) {
            addCriterion("JOB_DESC not in", values, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescBetween(String value1, String value2) {
            addCriterion("JOB_DESC between", value1, value2, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescNotBetween(String value1, String value2) {
            addCriterion("JOB_DESC not between", value1, value2, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobParamIsNull() {
            addCriterion("JOB_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andJobParamIsNotNull() {
            addCriterion("JOB_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andJobParamEqualTo(String value) {
            addCriterion("JOB_PARAM =", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamNotEqualTo(String value) {
            addCriterion("JOB_PARAM <>", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamGreaterThan(String value) {
            addCriterion("JOB_PARAM >", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_PARAM >=", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamLessThan(String value) {
            addCriterion("JOB_PARAM <", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamLessThanOrEqualTo(String value) {
            addCriterion("JOB_PARAM <=", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamLike(String value) {
            addCriterion("JOB_PARAM like", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamNotLike(String value) {
            addCriterion("JOB_PARAM not like", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamIn(List<String> values) {
            addCriterion("JOB_PARAM in", values, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamNotIn(List<String> values) {
            addCriterion("JOB_PARAM not in", values, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamBetween(String value1, String value2) {
            addCriterion("JOB_PARAM between", value1, value2, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamNotBetween(String value1, String value2) {
            addCriterion("JOB_PARAM not between", value1, value2, "jobParam");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Date value) {
            addCriterionForJDBCDate("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Date value) {
            addCriterionForJDBCDate("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Date value) {
            addCriterionForJDBCDate("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Date value) {
            addCriterionForJDBCDate("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Date> values) {
            addCriterionForJDBCDate("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Date> values) {
            addCriterionForJDBCDate("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNull() {
            addCriterion("JOB_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNotNull() {
            addCriterion("JOB_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andJobGroupEqualTo(BigDecimal value) {
            addCriterion("JOB_GROUP =", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotEqualTo(BigDecimal value) {
            addCriterion("JOB_GROUP <>", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThan(BigDecimal value) {
            addCriterion("JOB_GROUP >", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("JOB_GROUP >=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThan(BigDecimal value) {
            addCriterion("JOB_GROUP <", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThanOrEqualTo(BigDecimal value) {
            addCriterion("JOB_GROUP <=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupIn(List<BigDecimal> values) {
            addCriterion("JOB_GROUP in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotIn(List<BigDecimal> values) {
            addCriterion("JOB_GROUP not in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JOB_GROUP between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JOB_GROUP not between", value1, value2, "jobGroup");
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