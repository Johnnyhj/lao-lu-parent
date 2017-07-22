package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PerformanceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PerformanceInfoExample() {
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

        public Criteria andPerformanceIdIsNull() {
            addCriterion("PERFORMANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdIsNotNull() {
            addCriterion("PERFORMANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdEqualTo(Long value) {
            addCriterion("PERFORMANCE_ID =", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdNotEqualTo(Long value) {
            addCriterion("PERFORMANCE_ID <>", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdGreaterThan(Long value) {
            addCriterion("PERFORMANCE_ID >", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PERFORMANCE_ID >=", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdLessThan(Long value) {
            addCriterion("PERFORMANCE_ID <", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdLessThanOrEqualTo(Long value) {
            addCriterion("PERFORMANCE_ID <=", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdIn(List<Long> values) {
            addCriterion("PERFORMANCE_ID in", values, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdNotIn(List<Long> values) {
            addCriterion("PERFORMANCE_ID not in", values, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdBetween(Long value1, Long value2) {
            addCriterion("PERFORMANCE_ID between", value1, value2, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdNotBetween(Long value1, Long value2) {
            addCriterion("PERFORMANCE_ID not between", value1, value2, "performanceId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeIsNull() {
            addCriterion("ORDER_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeIsNotNull() {
            addCriterion("ORDER_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeEqualTo(String value) {
            addCriterion("ORDER_DESCRIBE =", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeNotEqualTo(String value) {
            addCriterion("ORDER_DESCRIBE <>", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeGreaterThan(String value) {
            addCriterion("ORDER_DESCRIBE >", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_DESCRIBE >=", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeLessThan(String value) {
            addCriterion("ORDER_DESCRIBE <", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_DESCRIBE <=", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeLike(String value) {
            addCriterion("ORDER_DESCRIBE like", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeNotLike(String value) {
            addCriterion("ORDER_DESCRIBE not like", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeIn(List<String> values) {
            addCriterion("ORDER_DESCRIBE in", values, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeNotIn(List<String> values) {
            addCriterion("ORDER_DESCRIBE not in", values, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeBetween(String value1, String value2) {
            addCriterion("ORDER_DESCRIBE between", value1, value2, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeNotBetween(String value1, String value2) {
            addCriterion("ORDER_DESCRIBE not between", value1, value2, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andPerformTimesIsNull() {
            addCriterion("PERFORM_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andPerformTimesIsNotNull() {
            addCriterion("PERFORM_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andPerformTimesEqualTo(Short value) {
            addCriterion("PERFORM_TIMES =", value, "performTimes");
            return (Criteria) this;
        }

        public Criteria andPerformTimesNotEqualTo(Short value) {
            addCriterion("PERFORM_TIMES <>", value, "performTimes");
            return (Criteria) this;
        }

        public Criteria andPerformTimesGreaterThan(Short value) {
            addCriterion("PERFORM_TIMES >", value, "performTimes");
            return (Criteria) this;
        }

        public Criteria andPerformTimesGreaterThanOrEqualTo(Short value) {
            addCriterion("PERFORM_TIMES >=", value, "performTimes");
            return (Criteria) this;
        }

        public Criteria andPerformTimesLessThan(Short value) {
            addCriterion("PERFORM_TIMES <", value, "performTimes");
            return (Criteria) this;
        }

        public Criteria andPerformTimesLessThanOrEqualTo(Short value) {
            addCriterion("PERFORM_TIMES <=", value, "performTimes");
            return (Criteria) this;
        }

        public Criteria andPerformTimesIn(List<Short> values) {
            addCriterion("PERFORM_TIMES in", values, "performTimes");
            return (Criteria) this;
        }

        public Criteria andPerformTimesNotIn(List<Short> values) {
            addCriterion("PERFORM_TIMES not in", values, "performTimes");
            return (Criteria) this;
        }

        public Criteria andPerformTimesBetween(Short value1, Short value2) {
            addCriterion("PERFORM_TIMES between", value1, value2, "performTimes");
            return (Criteria) this;
        }

        public Criteria andPerformTimesNotBetween(Short value1, Short value2) {
            addCriterion("PERFORM_TIMES not between", value1, value2, "performTimes");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesIsNull() {
            addCriterion("COMPLETE_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesIsNotNull() {
            addCriterion("COMPLETE_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesEqualTo(Short value) {
            addCriterion("COMPLETE_TIMES =", value, "completeTimes");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesNotEqualTo(Short value) {
            addCriterion("COMPLETE_TIMES <>", value, "completeTimes");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesGreaterThan(Short value) {
            addCriterion("COMPLETE_TIMES >", value, "completeTimes");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesGreaterThanOrEqualTo(Short value) {
            addCriterion("COMPLETE_TIMES >=", value, "completeTimes");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesLessThan(Short value) {
            addCriterion("COMPLETE_TIMES <", value, "completeTimes");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesLessThanOrEqualTo(Short value) {
            addCriterion("COMPLETE_TIMES <=", value, "completeTimes");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesIn(List<Short> values) {
            addCriterion("COMPLETE_TIMES in", values, "completeTimes");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesNotIn(List<Short> values) {
            addCriterion("COMPLETE_TIMES not in", values, "completeTimes");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesBetween(Short value1, Short value2) {
            addCriterion("COMPLETE_TIMES between", value1, value2, "completeTimes");
            return (Criteria) this;
        }

        public Criteria andCompleteTimesNotBetween(Short value1, Short value2) {
            addCriterion("COMPLETE_TIMES not between", value1, value2, "completeTimes");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("BEGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("BEGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("BEGIN_TIME =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("BEGIN_TIME <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("BEGIN_TIME >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BEGIN_TIME >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("BEGIN_TIME <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("BEGIN_TIME <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("BEGIN_TIME in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("BEGIN_TIME not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("BEGIN_TIME between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("BEGIN_TIME not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdIsNull() {
            addCriterion("OFFER_SPEC_ID is null");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdIsNotNull() {
            addCriterion("OFFER_SPEC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdEqualTo(Long value) {
            addCriterion("OFFER_SPEC_ID =", value, "offerSpecId");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdNotEqualTo(Long value) {
            addCriterion("OFFER_SPEC_ID <>", value, "offerSpecId");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdGreaterThan(Long value) {
            addCriterion("OFFER_SPEC_ID >", value, "offerSpecId");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OFFER_SPEC_ID >=", value, "offerSpecId");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdLessThan(Long value) {
            addCriterion("OFFER_SPEC_ID <", value, "offerSpecId");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdLessThanOrEqualTo(Long value) {
            addCriterion("OFFER_SPEC_ID <=", value, "offerSpecId");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdIn(List<Long> values) {
            addCriterion("OFFER_SPEC_ID in", values, "offerSpecId");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdNotIn(List<Long> values) {
            addCriterion("OFFER_SPEC_ID not in", values, "offerSpecId");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdBetween(Long value1, Long value2) {
            addCriterion("OFFER_SPEC_ID between", value1, value2, "offerSpecId");
            return (Criteria) this;
        }

        public Criteria andOfferSpecIdNotBetween(Long value1, Long value2) {
            addCriterion("OFFER_SPEC_ID not between", value1, value2, "offerSpecId");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeIsNull() {
            addCriterion("PERFORMANCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeIsNotNull() {
            addCriterion("PERFORMANCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeEqualTo(String value) {
            addCriterion("PERFORMANCE_CODE =", value, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeNotEqualTo(String value) {
            addCriterion("PERFORMANCE_CODE <>", value, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeGreaterThan(String value) {
            addCriterion("PERFORMANCE_CODE >", value, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PERFORMANCE_CODE >=", value, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeLessThan(String value) {
            addCriterion("PERFORMANCE_CODE <", value, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeLessThanOrEqualTo(String value) {
            addCriterion("PERFORMANCE_CODE <=", value, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeLike(String value) {
            addCriterion("PERFORMANCE_CODE like", value, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeNotLike(String value) {
            addCriterion("PERFORMANCE_CODE not like", value, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeIn(List<String> values) {
            addCriterion("PERFORMANCE_CODE in", values, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeNotIn(List<String> values) {
            addCriterion("PERFORMANCE_CODE not in", values, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeBetween(String value1, String value2) {
            addCriterion("PERFORMANCE_CODE between", value1, value2, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceCodeNotBetween(String value1, String value2) {
            addCriterion("PERFORMANCE_CODE not between", value1, value2, "performanceCode");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyIsNull() {
            addCriterion("PERFORMANCE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyIsNotNull() {
            addCriterion("PERFORMANCE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyEqualTo(Float value) {
            addCriterion("PERFORMANCE_MONEY =", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyNotEqualTo(Float value) {
            addCriterion("PERFORMANCE_MONEY <>", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyGreaterThan(Float value) {
            addCriterion("PERFORMANCE_MONEY >", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("PERFORMANCE_MONEY >=", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyLessThan(Float value) {
            addCriterion("PERFORMANCE_MONEY <", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyLessThanOrEqualTo(Float value) {
            addCriterion("PERFORMANCE_MONEY <=", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyIn(List<Float> values) {
            addCriterion("PERFORMANCE_MONEY in", values, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyNotIn(List<Float> values) {
            addCriterion("PERFORMANCE_MONEY not in", values, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyBetween(Float value1, Float value2) {
            addCriterion("PERFORMANCE_MONEY between", value1, value2, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyNotBetween(Float value1, Float value2) {
            addCriterion("PERFORMANCE_MONEY not between", value1, value2, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdIsNull() {
            addCriterion("PROVINCE_AEAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdIsNotNull() {
            addCriterion("PROVINCE_AEAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdEqualTo(Long value) {
            addCriterion("PROVINCE_AEAR_ID =", value, "provinceAearId");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdNotEqualTo(Long value) {
            addCriterion("PROVINCE_AEAR_ID <>", value, "provinceAearId");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdGreaterThan(Long value) {
            addCriterion("PROVINCE_AEAR_ID >", value, "provinceAearId");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROVINCE_AEAR_ID >=", value, "provinceAearId");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdLessThan(Long value) {
            addCriterion("PROVINCE_AEAR_ID <", value, "provinceAearId");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdLessThanOrEqualTo(Long value) {
            addCriterion("PROVINCE_AEAR_ID <=", value, "provinceAearId");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdIn(List<Long> values) {
            addCriterion("PROVINCE_AEAR_ID in", values, "provinceAearId");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdNotIn(List<Long> values) {
            addCriterion("PROVINCE_AEAR_ID not in", values, "provinceAearId");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdBetween(Long value1, Long value2) {
            addCriterion("PROVINCE_AEAR_ID between", value1, value2, "provinceAearId");
            return (Criteria) this;
        }

        public Criteria andProvinceAearIdNotBetween(Long value1, Long value2) {
            addCriterion("PROVINCE_AEAR_ID not between", value1, value2, "provinceAearId");
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