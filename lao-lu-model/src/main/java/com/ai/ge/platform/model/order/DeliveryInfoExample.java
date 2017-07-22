package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliveryInfoExample() {
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

        public Criteria andDeliveryIdIsNull() {
            addCriterion("DELIVERY_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdIsNotNull() {
            addCriterion("DELIVERY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdEqualTo(Long value) {
            addCriterion("DELIVERY_ID =", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotEqualTo(Long value) {
            addCriterion("DELIVERY_ID <>", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdGreaterThan(Long value) {
            addCriterion("DELIVERY_ID >", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DELIVERY_ID >=", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdLessThan(Long value) {
            addCriterion("DELIVERY_ID <", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdLessThanOrEqualTo(Long value) {
            addCriterion("DELIVERY_ID <=", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdIn(List<Long> values) {
            addCriterion("DELIVERY_ID in", values, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotIn(List<Long> values) {
            addCriterion("DELIVERY_ID not in", values, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdBetween(Long value1, Long value2) {
            addCriterion("DELIVERY_ID between", value1, value2, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotBetween(Long value1, Long value2) {
            addCriterion("DELIVERY_ID not between", value1, value2, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNull() {
            addCriterion("DELIVERY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNotNull() {
            addCriterion("DELIVERY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeEqualTo(Short value) {
            addCriterion("DELIVERY_TYPE =", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotEqualTo(Short value) {
            addCriterion("DELIVERY_TYPE <>", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThan(Short value) {
            addCriterion("DELIVERY_TYPE >", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("DELIVERY_TYPE >=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThan(Short value) {
            addCriterion("DELIVERY_TYPE <", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThanOrEqualTo(Short value) {
            addCriterion("DELIVERY_TYPE <=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIn(List<Short> values) {
            addCriterion("DELIVERY_TYPE in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotIn(List<Short> values) {
            addCriterion("DELIVERY_TYPE not in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeBetween(Short value1, Short value2) {
            addCriterion("DELIVERY_TYPE between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotBetween(Short value1, Short value2) {
            addCriterion("DELIVERY_TYPE not between", value1, value2, "deliveryType");
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

        public Criteria andExpressNameIsNull() {
            addCriterion("EXPRESS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNotNull() {
            addCriterion("EXPRESS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNameEqualTo(String value) {
            addCriterion("EXPRESS_NAME =", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotEqualTo(String value) {
            addCriterion("EXPRESS_NAME <>", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThan(String value) {
            addCriterion("EXPRESS_NAME >", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            addCriterion("EXPRESS_NAME >=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThan(String value) {
            addCriterion("EXPRESS_NAME <", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThanOrEqualTo(String value) {
            addCriterion("EXPRESS_NAME <=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLike(String value) {
            addCriterion("EXPRESS_NAME like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotLike(String value) {
            addCriterion("EXPRESS_NAME not like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameIn(List<String> values) {
            addCriterion("EXPRESS_NAME in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotIn(List<String> values) {
            addCriterion("EXPRESS_NAME not in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameBetween(String value1, String value2) {
            addCriterion("EXPRESS_NAME between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotBetween(String value1, String value2) {
            addCriterion("EXPRESS_NAME not between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressSeqIsNull() {
            addCriterion("EXPRESS_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andExpressSeqIsNotNull() {
            addCriterion("EXPRESS_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andExpressSeqEqualTo(String value) {
            addCriterion("EXPRESS_SEQ =", value, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqNotEqualTo(String value) {
            addCriterion("EXPRESS_SEQ <>", value, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqGreaterThan(String value) {
            addCriterion("EXPRESS_SEQ >", value, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqGreaterThanOrEqualTo(String value) {
            addCriterion("EXPRESS_SEQ >=", value, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqLessThan(String value) {
            addCriterion("EXPRESS_SEQ <", value, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqLessThanOrEqualTo(String value) {
            addCriterion("EXPRESS_SEQ <=", value, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqLike(String value) {
            addCriterion("EXPRESS_SEQ like", value, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqNotLike(String value) {
            addCriterion("EXPRESS_SEQ not like", value, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqIn(List<String> values) {
            addCriterion("EXPRESS_SEQ in", values, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqNotIn(List<String> values) {
            addCriterion("EXPRESS_SEQ not in", values, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqBetween(String value1, String value2) {
            addCriterion("EXPRESS_SEQ between", value1, value2, "expressSeq");
            return (Criteria) this;
        }

        public Criteria andExpressSeqNotBetween(String value1, String value2) {
            addCriterion("EXPRESS_SEQ not between", value1, value2, "expressSeq");
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

        public Criteria andExpressMoneyIsNull() {
            addCriterion("EXPRESS_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyIsNotNull() {
            addCriterion("EXPRESS_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyEqualTo(Float value) {
            addCriterion("EXPRESS_MONEY =", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotEqualTo(Float value) {
            addCriterion("EXPRESS_MONEY <>", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyGreaterThan(Float value) {
            addCriterion("EXPRESS_MONEY >", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("EXPRESS_MONEY >=", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyLessThan(Float value) {
            addCriterion("EXPRESS_MONEY <", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyLessThanOrEqualTo(Float value) {
            addCriterion("EXPRESS_MONEY <=", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyIn(List<Float> values) {
            addCriterion("EXPRESS_MONEY in", values, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotIn(List<Float> values) {
            addCriterion("EXPRESS_MONEY not in", values, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyBetween(Float value1, Float value2) {
            addCriterion("EXPRESS_MONEY between", value1, value2, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotBetween(Float value1, Float value2) {
            addCriterion("EXPRESS_MONEY not between", value1, value2, "expressMoney");
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