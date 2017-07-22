package com.ai.ge.platform.model.arrears;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreditListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CreditListExample() {
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

        public Criteria andCreditIdIsNull() {
            addCriterion("CREDIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreditIdIsNotNull() {
            addCriterion("CREDIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreditIdEqualTo(Long value) {
            addCriterion("CREDIT_ID =", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdNotEqualTo(Long value) {
            addCriterion("CREDIT_ID <>", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdGreaterThan(Long value) {
            addCriterion("CREDIT_ID >", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CREDIT_ID >=", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdLessThan(Long value) {
            addCriterion("CREDIT_ID <", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdLessThanOrEqualTo(Long value) {
            addCriterion("CREDIT_ID <=", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdIn(List<Long> values) {
            addCriterion("CREDIT_ID in", values, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdNotIn(List<Long> values) {
            addCriterion("CREDIT_ID not in", values, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdBetween(Long value1, Long value2) {
            addCriterion("CREDIT_ID between", value1, value2, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdNotBetween(Long value1, Long value2) {
            addCriterion("CREDIT_ID not between", value1, value2, "creditId");
            return (Criteria) this;
        }

        public Criteria andArrAuIdIsNull() {
            addCriterion("ARR_AU_ID is null");
            return (Criteria) this;
        }

        public Criteria andArrAuIdIsNotNull() {
            addCriterion("ARR_AU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andArrAuIdEqualTo(Long value) {
            addCriterion("ARR_AU_ID =", value, "arrAuId");
            return (Criteria) this;
        }

        public Criteria andArrAuIdNotEqualTo(Long value) {
            addCriterion("ARR_AU_ID <>", value, "arrAuId");
            return (Criteria) this;
        }

        public Criteria andArrAuIdGreaterThan(Long value) {
            addCriterion("ARR_AU_ID >", value, "arrAuId");
            return (Criteria) this;
        }

        public Criteria andArrAuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ARR_AU_ID >=", value, "arrAuId");
            return (Criteria) this;
        }

        public Criteria andArrAuIdLessThan(Long value) {
            addCriterion("ARR_AU_ID <", value, "arrAuId");
            return (Criteria) this;
        }

        public Criteria andArrAuIdLessThanOrEqualTo(Long value) {
            addCriterion("ARR_AU_ID <=", value, "arrAuId");
            return (Criteria) this;
        }

        public Criteria andArrAuIdIn(List<Long> values) {
            addCriterion("ARR_AU_ID in", values, "arrAuId");
            return (Criteria) this;
        }

        public Criteria andArrAuIdNotIn(List<Long> values) {
            addCriterion("ARR_AU_ID not in", values, "arrAuId");
            return (Criteria) this;
        }

        public Criteria andArrAuIdBetween(Long value1, Long value2) {
            addCriterion("ARR_AU_ID between", value1, value2, "arrAuId");
            return (Criteria) this;
        }

        public Criteria andArrAuIdNotBetween(Long value1, Long value2) {
            addCriterion("ARR_AU_ID not between", value1, value2, "arrAuId");
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

        public Criteria andAuIdEqualTo(String value) {
            addCriterion("AU_ID =", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotEqualTo(String value) {
            addCriterion("AU_ID <>", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdGreaterThan(String value) {
            addCriterion("AU_ID >", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdGreaterThanOrEqualTo(String value) {
            addCriterion("AU_ID >=", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdLessThan(String value) {
            addCriterion("AU_ID <", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdLessThanOrEqualTo(String value) {
            addCriterion("AU_ID <=", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdLike(String value) {
            addCriterion("AU_ID like", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotLike(String value) {
            addCriterion("AU_ID not like", value, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdIn(List<String> values) {
            addCriterion("AU_ID in", values, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotIn(List<String> values) {
            addCriterion("AU_ID not in", values, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdBetween(String value1, String value2) {
            addCriterion("AU_ID between", value1, value2, "auId");
            return (Criteria) this;
        }

        public Criteria andAuIdNotBetween(String value1, String value2) {
            addCriterion("AU_ID not between", value1, value2, "auId");
            return (Criteria) this;
        }

        public Criteria andCreditTypeIsNull() {
            addCriterion("CREDIT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCreditTypeIsNotNull() {
            addCriterion("CREDIT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditTypeEqualTo(Short value) {
            addCriterion("CREDIT_TYPE =", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotEqualTo(Short value) {
            addCriterion("CREDIT_TYPE <>", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeGreaterThan(Short value) {
            addCriterion("CREDIT_TYPE >", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("CREDIT_TYPE >=", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeLessThan(Short value) {
            addCriterion("CREDIT_TYPE <", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeLessThanOrEqualTo(Short value) {
            addCriterion("CREDIT_TYPE <=", value, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeIn(List<Short> values) {
            addCriterion("CREDIT_TYPE in", values, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotIn(List<Short> values) {
            addCriterion("CREDIT_TYPE not in", values, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeBetween(Short value1, Short value2) {
            addCriterion("CREDIT_TYPE between", value1, value2, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditTypeNotBetween(Short value1, Short value2) {
            addCriterion("CREDIT_TYPE not between", value1, value2, "creditType");
            return (Criteria) this;
        }

        public Criteria andCreditDescIsNull() {
            addCriterion("CREDIT_DESC is null");
            return (Criteria) this;
        }

        public Criteria andCreditDescIsNotNull() {
            addCriterion("CREDIT_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andCreditDescEqualTo(String value) {
            addCriterion("CREDIT_DESC =", value, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescNotEqualTo(String value) {
            addCriterion("CREDIT_DESC <>", value, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescGreaterThan(String value) {
            addCriterion("CREDIT_DESC >", value, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_DESC >=", value, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescLessThan(String value) {
            addCriterion("CREDIT_DESC <", value, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_DESC <=", value, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescLike(String value) {
            addCriterion("CREDIT_DESC like", value, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescNotLike(String value) {
            addCriterion("CREDIT_DESC not like", value, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescIn(List<String> values) {
            addCriterion("CREDIT_DESC in", values, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescNotIn(List<String> values) {
            addCriterion("CREDIT_DESC not in", values, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescBetween(String value1, String value2) {
            addCriterion("CREDIT_DESC between", value1, value2, "creditDesc");
            return (Criteria) this;
        }

        public Criteria andCreditDescNotBetween(String value1, String value2) {
            addCriterion("CREDIT_DESC not between", value1, value2, "creditDesc");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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