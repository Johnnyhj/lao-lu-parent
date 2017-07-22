package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PerformanceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PerformanceLogExample() {
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

        public Criteria andOlIdIsNull() {
            addCriterion("OL_ID is null");
            return (Criteria) this;
        }

        public Criteria andOlIdIsNotNull() {
            addCriterion("OL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOlIdEqualTo(Long value) {
            addCriterion("OL_ID =", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotEqualTo(Long value) {
            addCriterion("OL_ID <>", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdGreaterThan(Long value) {
            addCriterion("OL_ID >", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OL_ID >=", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdLessThan(Long value) {
            addCriterion("OL_ID <", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdLessThanOrEqualTo(Long value) {
            addCriterion("OL_ID <=", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdIn(List<Long> values) {
            addCriterion("OL_ID in", values, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotIn(List<Long> values) {
            addCriterion("OL_ID not in", values, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdBetween(Long value1, Long value2) {
            addCriterion("OL_ID between", value1, value2, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotBetween(Long value1, Long value2) {
            addCriterion("OL_ID not between", value1, value2, "olId");
            return (Criteria) this;
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

        public Criteria andPerformanceTimeIsNull() {
            addCriterion("PERFORMANCE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeIsNotNull() {
            addCriterion("PERFORMANCE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeEqualTo(Date value) {
            addCriterion("PERFORMANCE_TIME =", value, "performanceTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeNotEqualTo(Date value) {
            addCriterion("PERFORMANCE_TIME <>", value, "performanceTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeGreaterThan(Date value) {
            addCriterion("PERFORMANCE_TIME >", value, "performanceTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PERFORMANCE_TIME >=", value, "performanceTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeLessThan(Date value) {
            addCriterion("PERFORMANCE_TIME <", value, "performanceTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeLessThanOrEqualTo(Date value) {
            addCriterion("PERFORMANCE_TIME <=", value, "performanceTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeIn(List<Date> values) {
            addCriterion("PERFORMANCE_TIME in", values, "performanceTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeNotIn(List<Date> values) {
            addCriterion("PERFORMANCE_TIME not in", values, "performanceTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeBetween(Date value1, Date value2) {
            addCriterion("PERFORMANCE_TIME between", value1, value2, "performanceTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimeNotBetween(Date value1, Date value2) {
            addCriterion("PERFORMANCE_TIME not between", value1, value2, "performanceTime");
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

        public Criteria andPerformanceMoneyEqualTo(Long value) {
            addCriterion("PERFORMANCE_MONEY =", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyNotEqualTo(Long value) {
            addCriterion("PERFORMANCE_MONEY <>", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyGreaterThan(Long value) {
            addCriterion("PERFORMANCE_MONEY >", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("PERFORMANCE_MONEY >=", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyLessThan(Long value) {
            addCriterion("PERFORMANCE_MONEY <", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyLessThanOrEqualTo(Long value) {
            addCriterion("PERFORMANCE_MONEY <=", value, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyIn(List<Long> values) {
            addCriterion("PERFORMANCE_MONEY in", values, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyNotIn(List<Long> values) {
            addCriterion("PERFORMANCE_MONEY not in", values, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyBetween(Long value1, Long value2) {
            addCriterion("PERFORMANCE_MONEY between", value1, value2, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceMoneyNotBetween(Long value1, Long value2) {
            addCriterion("PERFORMANCE_MONEY not between", value1, value2, "performanceMoney");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumIsNull() {
            addCriterion("PERFORMANCE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumIsNotNull() {
            addCriterion("PERFORMANCE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumEqualTo(Integer value) {
            addCriterion("PERFORMANCE_NUM =", value, "performanceNum");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumNotEqualTo(Integer value) {
            addCriterion("PERFORMANCE_NUM <>", value, "performanceNum");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumGreaterThan(Integer value) {
            addCriterion("PERFORMANCE_NUM >", value, "performanceNum");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PERFORMANCE_NUM >=", value, "performanceNum");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumLessThan(Integer value) {
            addCriterion("PERFORMANCE_NUM <", value, "performanceNum");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumLessThanOrEqualTo(Integer value) {
            addCriterion("PERFORMANCE_NUM <=", value, "performanceNum");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumIn(List<Integer> values) {
            addCriterion("PERFORMANCE_NUM in", values, "performanceNum");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumNotIn(List<Integer> values) {
            addCriterion("PERFORMANCE_NUM not in", values, "performanceNum");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumBetween(Integer value1, Integer value2) {
            addCriterion("PERFORMANCE_NUM between", value1, value2, "performanceNum");
            return (Criteria) this;
        }

        public Criteria andPerformanceNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PERFORMANCE_NUM not between", value1, value2, "performanceNum");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("PAY_TYPE =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("PAY_TYPE <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("PAY_TYPE >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("PAY_TYPE <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("PAY_TYPE like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("PAY_TYPE not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("PAY_TYPE in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("PAY_TYPE not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("PAY_TYPE between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("PAY_TYPE not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusIsNull() {
            addCriterion("PERFORMANCE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusIsNotNull() {
            addCriterion("PERFORMANCE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusEqualTo(Long value) {
            addCriterion("PERFORMANCE_STATUS =", value, "performanceStatus");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusNotEqualTo(Long value) {
            addCriterion("PERFORMANCE_STATUS <>", value, "performanceStatus");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusGreaterThan(Long value) {
            addCriterion("PERFORMANCE_STATUS >", value, "performanceStatus");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("PERFORMANCE_STATUS >=", value, "performanceStatus");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusLessThan(Long value) {
            addCriterion("PERFORMANCE_STATUS <", value, "performanceStatus");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusLessThanOrEqualTo(Long value) {
            addCriterion("PERFORMANCE_STATUS <=", value, "performanceStatus");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusIn(List<Long> values) {
            addCriterion("PERFORMANCE_STATUS in", values, "performanceStatus");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusNotIn(List<Long> values) {
            addCriterion("PERFORMANCE_STATUS not in", values, "performanceStatus");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusBetween(Long value1, Long value2) {
            addCriterion("PERFORMANCE_STATUS between", value1, value2, "performanceStatus");
            return (Criteria) this;
        }

        public Criteria andPerformanceStatusNotBetween(Long value1, Long value2) {
            addCriterion("PERFORMANCE_STATUS not between", value1, value2, "performanceStatus");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthIsNull() {
            addCriterion("PERFORMANCE_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthIsNotNull() {
            addCriterion("PERFORMANCE_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthEqualTo(String value) {
            addCriterion("PERFORMANCE_MONTH =", value, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthNotEqualTo(String value) {
            addCriterion("PERFORMANCE_MONTH <>", value, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthGreaterThan(String value) {
            addCriterion("PERFORMANCE_MONTH >", value, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthGreaterThanOrEqualTo(String value) {
            addCriterion("PERFORMANCE_MONTH >=", value, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthLessThan(String value) {
            addCriterion("PERFORMANCE_MONTH <", value, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthLessThanOrEqualTo(String value) {
            addCriterion("PERFORMANCE_MONTH <=", value, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthLike(String value) {
            addCriterion("PERFORMANCE_MONTH like", value, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthNotLike(String value) {
            addCriterion("PERFORMANCE_MONTH not like", value, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthIn(List<String> values) {
            addCriterion("PERFORMANCE_MONTH in", values, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthNotIn(List<String> values) {
            addCriterion("PERFORMANCE_MONTH not in", values, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthBetween(String value1, String value2) {
            addCriterion("PERFORMANCE_MONTH between", value1, value2, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andPerformanceMonthNotBetween(String value1, String value2) {
            addCriterion("PERFORMANCE_MONTH not between", value1, value2, "performanceMonth");
            return (Criteria) this;
        }

        public Criteria andCrateTimeIsNull() {
            addCriterion("CRATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCrateTimeIsNotNull() {
            addCriterion("CRATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCrateTimeEqualTo(Date value) {
            addCriterion("CRATE_TIME =", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeNotEqualTo(Date value) {
            addCriterion("CRATE_TIME <>", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeGreaterThan(Date value) {
            addCriterion("CRATE_TIME >", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRATE_TIME >=", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeLessThan(Date value) {
            addCriterion("CRATE_TIME <", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRATE_TIME <=", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeIn(List<Date> values) {
            addCriterion("CRATE_TIME in", values, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeNotIn(List<Date> values) {
            addCriterion("CRATE_TIME not in", values, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeBetween(Date value1, Date value2) {
            addCriterion("CRATE_TIME between", value1, value2, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRATE_TIME not between", value1, value2, "crateTime");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNull() {
            addCriterion("IS_SEND is null");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNotNull() {
            addCriterion("IS_SEND is not null");
            return (Criteria) this;
        }

        public Criteria andIsSendEqualTo(Long value) {
            addCriterion("IS_SEND =", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotEqualTo(Long value) {
            addCriterion("IS_SEND <>", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThan(Long value) {
            addCriterion("IS_SEND >", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThanOrEqualTo(Long value) {
            addCriterion("IS_SEND >=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThan(Long value) {
            addCriterion("IS_SEND <", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThanOrEqualTo(Long value) {
            addCriterion("IS_SEND <=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendIn(List<Long> values) {
            addCriterion("IS_SEND in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotIn(List<Long> values) {
            addCriterion("IS_SEND not in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendBetween(Long value1, Long value2) {
            addCriterion("IS_SEND between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotBetween(Long value1, Long value2) {
            addCriterion("IS_SEND not between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andBizDateIsNull() {
            addCriterion("BIZ_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBizDateIsNotNull() {
            addCriterion("BIZ_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBizDateEqualTo(Date value) {
            addCriterion("BIZ_DATE =", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateNotEqualTo(Date value) {
            addCriterion("BIZ_DATE <>", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateGreaterThan(Date value) {
            addCriterion("BIZ_DATE >", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateGreaterThanOrEqualTo(Date value) {
            addCriterion("BIZ_DATE >=", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateLessThan(Date value) {
            addCriterion("BIZ_DATE <", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateLessThanOrEqualTo(Date value) {
            addCriterion("BIZ_DATE <=", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateIn(List<Date> values) {
            addCriterion("BIZ_DATE in", values, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateNotIn(List<Date> values) {
            addCriterion("BIZ_DATE not in", values, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateBetween(Date value1, Date value2) {
            addCriterion("BIZ_DATE between", value1, value2, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateNotBetween(Date value1, Date value2) {
            addCriterion("BIZ_DATE not between", value1, value2, "bizDate");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeIsNull() {
            addCriterion("USER_CREDENTIALS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeIsNotNull() {
            addCriterion("USER_CREDENTIALS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeEqualTo(Short value) {
            addCriterion("USER_CREDENTIALS_TYPE =", value, "userCredentialsType");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeNotEqualTo(Short value) {
            addCriterion("USER_CREDENTIALS_TYPE <>", value, "userCredentialsType");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeGreaterThan(Short value) {
            addCriterion("USER_CREDENTIALS_TYPE >", value, "userCredentialsType");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("USER_CREDENTIALS_TYPE >=", value, "userCredentialsType");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeLessThan(Short value) {
            addCriterion("USER_CREDENTIALS_TYPE <", value, "userCredentialsType");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeLessThanOrEqualTo(Short value) {
            addCriterion("USER_CREDENTIALS_TYPE <=", value, "userCredentialsType");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeIn(List<Short> values) {
            addCriterion("USER_CREDENTIALS_TYPE in", values, "userCredentialsType");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeNotIn(List<Short> values) {
            addCriterion("USER_CREDENTIALS_TYPE not in", values, "userCredentialsType");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeBetween(Short value1, Short value2) {
            addCriterion("USER_CREDENTIALS_TYPE between", value1, value2, "userCredentialsType");
            return (Criteria) this;
        }

        public Criteria andUserCredentialsTypeNotBetween(Short value1, Short value2) {
            addCriterion("USER_CREDENTIALS_TYPE not between", value1, value2, "userCredentialsType");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("CUST_ID like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("CUST_ID not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIsNull() {
            addCriterion("ORDER_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIsNotNull() {
            addCriterion("ORDER_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSeqEqualTo(String value) {
            addCriterion("ORDER_SEQ =", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotEqualTo(String value) {
            addCriterion("ORDER_SEQ <>", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGreaterThan(String value) {
            addCriterion("ORDER_SEQ >", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_SEQ >=", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqLessThan(String value) {
            addCriterion("ORDER_SEQ <", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqLessThanOrEqualTo(String value) {
            addCriterion("ORDER_SEQ <=", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqLike(String value) {
            addCriterion("ORDER_SEQ like", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotLike(String value) {
            addCriterion("ORDER_SEQ not like", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIn(List<String> values) {
            addCriterion("ORDER_SEQ in", values, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotIn(List<String> values) {
            addCriterion("ORDER_SEQ not in", values, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqBetween(String value1, String value2) {
            addCriterion("ORDER_SEQ between", value1, value2, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotBetween(String value1, String value2) {
            addCriterion("ORDER_SEQ not between", value1, value2, "orderSeq");
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

        public Criteria andOrderStatusIsNull() {
            addCriterion("ORDER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("ORDER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Short value) {
            addCriterion("ORDER_STATUS =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Short value) {
            addCriterion("ORDER_STATUS <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Short value) {
            addCriterion("ORDER_STATUS >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("ORDER_STATUS >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Short value) {
            addCriterion("ORDER_STATUS <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Short value) {
            addCriterion("ORDER_STATUS <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Short> values) {
            addCriterion("ORDER_STATUS in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Short> values) {
            addCriterion("ORDER_STATUS not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Short value1, Short value2) {
            addCriterion("ORDER_STATUS between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Short value1, Short value2) {
            addCriterion("ORDER_STATUS not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andBillDescIsNull() {
            addCriterion("BILL_DESC is null");
            return (Criteria) this;
        }

        public Criteria andBillDescIsNotNull() {
            addCriterion("BILL_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andBillDescEqualTo(String value) {
            addCriterion("BILL_DESC =", value, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescNotEqualTo(String value) {
            addCriterion("BILL_DESC <>", value, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescGreaterThan(String value) {
            addCriterion("BILL_DESC >", value, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_DESC >=", value, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescLessThan(String value) {
            addCriterion("BILL_DESC <", value, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescLessThanOrEqualTo(String value) {
            addCriterion("BILL_DESC <=", value, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescLike(String value) {
            addCriterion("BILL_DESC like", value, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescNotLike(String value) {
            addCriterion("BILL_DESC not like", value, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescIn(List<String> values) {
            addCriterion("BILL_DESC in", values, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescNotIn(List<String> values) {
            addCriterion("BILL_DESC not in", values, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescBetween(String value1, String value2) {
            addCriterion("BILL_DESC between", value1, value2, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillDescNotBetween(String value1, String value2) {
            addCriterion("BILL_DESC not between", value1, value2, "billDesc");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNull() {
            addCriterion("BILL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNotNull() {
            addCriterion("BILL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(String value) {
            addCriterion("BILL_TYPE =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotEqualTo(String value) {
            addCriterion("BILL_TYPE <>", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThan(String value) {
            addCriterion("BILL_TYPE >", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_TYPE >=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThan(String value) {
            addCriterion("BILL_TYPE <", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThanOrEqualTo(String value) {
            addCriterion("BILL_TYPE <=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLike(String value) {
            addCriterion("BILL_TYPE like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotLike(String value) {
            addCriterion("BILL_TYPE not like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIn(List<String> values) {
            addCriterion("BILL_TYPE in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotIn(List<String> values) {
            addCriterion("BILL_TYPE not in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeBetween(String value1, String value2) {
            addCriterion("BILL_TYPE between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotBetween(String value1, String value2) {
            addCriterion("BILL_TYPE not between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillLastDateIsNull() {
            addCriterion("BILL_LAST_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBillLastDateIsNotNull() {
            addCriterion("BILL_LAST_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillLastDateEqualTo(Date value) {
            addCriterion("BILL_LAST_DATE =", value, "billLastDate");
            return (Criteria) this;
        }

        public Criteria andBillLastDateNotEqualTo(Date value) {
            addCriterion("BILL_LAST_DATE <>", value, "billLastDate");
            return (Criteria) this;
        }

        public Criteria andBillLastDateGreaterThan(Date value) {
            addCriterion("BILL_LAST_DATE >", value, "billLastDate");
            return (Criteria) this;
        }

        public Criteria andBillLastDateGreaterThanOrEqualTo(Date value) {
            addCriterion("BILL_LAST_DATE >=", value, "billLastDate");
            return (Criteria) this;
        }

        public Criteria andBillLastDateLessThan(Date value) {
            addCriterion("BILL_LAST_DATE <", value, "billLastDate");
            return (Criteria) this;
        }

        public Criteria andBillLastDateLessThanOrEqualTo(Date value) {
            addCriterion("BILL_LAST_DATE <=", value, "billLastDate");
            return (Criteria) this;
        }

        public Criteria andBillLastDateIn(List<Date> values) {
            addCriterion("BILL_LAST_DATE in", values, "billLastDate");
            return (Criteria) this;
        }

        public Criteria andBillLastDateNotIn(List<Date> values) {
            addCriterion("BILL_LAST_DATE not in", values, "billLastDate");
            return (Criteria) this;
        }

        public Criteria andBillLastDateBetween(Date value1, Date value2) {
            addCriterion("BILL_LAST_DATE between", value1, value2, "billLastDate");
            return (Criteria) this;
        }

        public Criteria andBillLastDateNotBetween(Date value1, Date value2) {
            addCriterion("BILL_LAST_DATE not between", value1, value2, "billLastDate");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateIsNull() {
            addCriterion("BILL_PAYOFF_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateIsNotNull() {
            addCriterion("BILL_PAYOFF_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateEqualTo(Date value) {
            addCriterion("BILL_PAYOFF_DATE =", value, "billPayoffDate");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateNotEqualTo(Date value) {
            addCriterion("BILL_PAYOFF_DATE <>", value, "billPayoffDate");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateGreaterThan(Date value) {
            addCriterion("BILL_PAYOFF_DATE >", value, "billPayoffDate");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateGreaterThanOrEqualTo(Date value) {
            addCriterion("BILL_PAYOFF_DATE >=", value, "billPayoffDate");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateLessThan(Date value) {
            addCriterion("BILL_PAYOFF_DATE <", value, "billPayoffDate");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateLessThanOrEqualTo(Date value) {
            addCriterion("BILL_PAYOFF_DATE <=", value, "billPayoffDate");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateIn(List<Date> values) {
            addCriterion("BILL_PAYOFF_DATE in", values, "billPayoffDate");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateNotIn(List<Date> values) {
            addCriterion("BILL_PAYOFF_DATE not in", values, "billPayoffDate");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateBetween(Date value1, Date value2) {
            addCriterion("BILL_PAYOFF_DATE between", value1, value2, "billPayoffDate");
            return (Criteria) this;
        }

        public Criteria andBillPayoffDateNotBetween(Date value1, Date value2) {
            addCriterion("BILL_PAYOFF_DATE not between", value1, value2, "billPayoffDate");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtIsNull() {
            addCriterion("BILL_TYPE_OVD_AMT is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtIsNotNull() {
            addCriterion("BILL_TYPE_OVD_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtEqualTo(Long value) {
            addCriterion("BILL_TYPE_OVD_AMT =", value, "billTypeOvdAmt");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtNotEqualTo(Long value) {
            addCriterion("BILL_TYPE_OVD_AMT <>", value, "billTypeOvdAmt");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtGreaterThan(Long value) {
            addCriterion("BILL_TYPE_OVD_AMT >", value, "billTypeOvdAmt");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("BILL_TYPE_OVD_AMT >=", value, "billTypeOvdAmt");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtLessThan(Long value) {
            addCriterion("BILL_TYPE_OVD_AMT <", value, "billTypeOvdAmt");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtLessThanOrEqualTo(Long value) {
            addCriterion("BILL_TYPE_OVD_AMT <=", value, "billTypeOvdAmt");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtIn(List<Long> values) {
            addCriterion("BILL_TYPE_OVD_AMT in", values, "billTypeOvdAmt");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtNotIn(List<Long> values) {
            addCriterion("BILL_TYPE_OVD_AMT not in", values, "billTypeOvdAmt");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtBetween(Long value1, Long value2) {
            addCriterion("BILL_TYPE_OVD_AMT between", value1, value2, "billTypeOvdAmt");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdAmtNotBetween(Long value1, Long value2) {
            addCriterion("BILL_TYPE_OVD_AMT not between", value1, value2, "billTypeOvdAmt");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateIsNull() {
            addCriterion("BILL_TYPE_OVD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateIsNotNull() {
            addCriterion("BILL_TYPE_OVD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateEqualTo(Date value) {
            addCriterion("BILL_TYPE_OVD_DATE =", value, "billTypeOvdDate");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateNotEqualTo(Date value) {
            addCriterion("BILL_TYPE_OVD_DATE <>", value, "billTypeOvdDate");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateGreaterThan(Date value) {
            addCriterion("BILL_TYPE_OVD_DATE >", value, "billTypeOvdDate");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateGreaterThanOrEqualTo(Date value) {
            addCriterion("BILL_TYPE_OVD_DATE >=", value, "billTypeOvdDate");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateLessThan(Date value) {
            addCriterion("BILL_TYPE_OVD_DATE <", value, "billTypeOvdDate");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateLessThanOrEqualTo(Date value) {
            addCriterion("BILL_TYPE_OVD_DATE <=", value, "billTypeOvdDate");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateIn(List<Date> values) {
            addCriterion("BILL_TYPE_OVD_DATE in", values, "billTypeOvdDate");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateNotIn(List<Date> values) {
            addCriterion("BILL_TYPE_OVD_DATE not in", values, "billTypeOvdDate");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateBetween(Date value1, Date value2) {
            addCriterion("BILL_TYPE_OVD_DATE between", value1, value2, "billTypeOvdDate");
            return (Criteria) this;
        }

        public Criteria andBillTypeOvdDateNotBetween(Date value1, Date value2) {
            addCriterion("BILL_TYPE_OVD_DATE not between", value1, value2, "billTypeOvdDate");
            return (Criteria) this;
        }

        public Criteria andBillMemoIsNull() {
            addCriterion("BILL_MEMO is null");
            return (Criteria) this;
        }

        public Criteria andBillMemoIsNotNull() {
            addCriterion("BILL_MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andBillMemoEqualTo(String value) {
            addCriterion("BILL_MEMO =", value, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoNotEqualTo(String value) {
            addCriterion("BILL_MEMO <>", value, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoGreaterThan(String value) {
            addCriterion("BILL_MEMO >", value, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_MEMO >=", value, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoLessThan(String value) {
            addCriterion("BILL_MEMO <", value, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoLessThanOrEqualTo(String value) {
            addCriterion("BILL_MEMO <=", value, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoLike(String value) {
            addCriterion("BILL_MEMO like", value, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoNotLike(String value) {
            addCriterion("BILL_MEMO not like", value, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoIn(List<String> values) {
            addCriterion("BILL_MEMO in", values, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoNotIn(List<String> values) {
            addCriterion("BILL_MEMO not in", values, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoBetween(String value1, String value2) {
            addCriterion("BILL_MEMO between", value1, value2, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillMemoNotBetween(String value1, String value2) {
            addCriterion("BILL_MEMO not between", value1, value2, "billMemo");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidIsNull() {
            addCriterion("BILL_TRANSACTIONID is null");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidIsNotNull() {
            addCriterion("BILL_TRANSACTIONID is not null");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidEqualTo(String value) {
            addCriterion("BILL_TRANSACTIONID =", value, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidNotEqualTo(String value) {
            addCriterion("BILL_TRANSACTIONID <>", value, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidGreaterThan(String value) {
            addCriterion("BILL_TRANSACTIONID >", value, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_TRANSACTIONID >=", value, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidLessThan(String value) {
            addCriterion("BILL_TRANSACTIONID <", value, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidLessThanOrEqualTo(String value) {
            addCriterion("BILL_TRANSACTIONID <=", value, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidLike(String value) {
            addCriterion("BILL_TRANSACTIONID like", value, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidNotLike(String value) {
            addCriterion("BILL_TRANSACTIONID not like", value, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidIn(List<String> values) {
            addCriterion("BILL_TRANSACTIONID in", values, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidNotIn(List<String> values) {
            addCriterion("BILL_TRANSACTIONID not in", values, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidBetween(String value1, String value2) {
            addCriterion("BILL_TRANSACTIONID between", value1, value2, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillTransactionidNotBetween(String value1, String value2) {
            addCriterion("BILL_TRANSACTIONID not between", value1, value2, "billTransactionid");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusIsNull() {
            addCriterion("BILL_PAYOFF_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusIsNotNull() {
            addCriterion("BILL_PAYOFF_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusEqualTo(Short value) {
            addCriterion("BILL_PAYOFF_STATUS =", value, "billPayoffStatus");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusNotEqualTo(Short value) {
            addCriterion("BILL_PAYOFF_STATUS <>", value, "billPayoffStatus");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusGreaterThan(Short value) {
            addCriterion("BILL_PAYOFF_STATUS >", value, "billPayoffStatus");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("BILL_PAYOFF_STATUS >=", value, "billPayoffStatus");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusLessThan(Short value) {
            addCriterion("BILL_PAYOFF_STATUS <", value, "billPayoffStatus");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusLessThanOrEqualTo(Short value) {
            addCriterion("BILL_PAYOFF_STATUS <=", value, "billPayoffStatus");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusIn(List<Short> values) {
            addCriterion("BILL_PAYOFF_STATUS in", values, "billPayoffStatus");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusNotIn(List<Short> values) {
            addCriterion("BILL_PAYOFF_STATUS not in", values, "billPayoffStatus");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusBetween(Short value1, Short value2) {
            addCriterion("BILL_PAYOFF_STATUS between", value1, value2, "billPayoffStatus");
            return (Criteria) this;
        }

        public Criteria andBillPayoffStatusNotBetween(Short value1, Short value2) {
            addCriterion("BILL_PAYOFF_STATUS not between", value1, value2, "billPayoffStatus");
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