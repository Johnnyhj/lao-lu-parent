package com.ai.ge.platform.model.sys;

import java.util.ArrayList;
import java.util.List;

public class AlipayConfigurationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlipayConfigurationInfoExample() {
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

        public Criteria andAlipayConfIdIsNull() {
            addCriterion("ALIPAY_CONF_ID is null");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdIsNotNull() {
            addCriterion("ALIPAY_CONF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdEqualTo(Long value) {
            addCriterion("ALIPAY_CONF_ID =", value, "alipayConfId");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdNotEqualTo(Long value) {
            addCriterion("ALIPAY_CONF_ID <>", value, "alipayConfId");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdGreaterThan(Long value) {
            addCriterion("ALIPAY_CONF_ID >", value, "alipayConfId");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ALIPAY_CONF_ID >=", value, "alipayConfId");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdLessThan(Long value) {
            addCriterion("ALIPAY_CONF_ID <", value, "alipayConfId");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdLessThanOrEqualTo(Long value) {
            addCriterion("ALIPAY_CONF_ID <=", value, "alipayConfId");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdIn(List<Long> values) {
            addCriterion("ALIPAY_CONF_ID in", values, "alipayConfId");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdNotIn(List<Long> values) {
            addCriterion("ALIPAY_CONF_ID not in", values, "alipayConfId");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdBetween(Long value1, Long value2) {
            addCriterion("ALIPAY_CONF_ID between", value1, value2, "alipayConfId");
            return (Criteria) this;
        }

        public Criteria andAlipayConfIdNotBetween(Long value1, Long value2) {
            addCriterion("ALIPAY_CONF_ID not between", value1, value2, "alipayConfId");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyIsNull() {
            addCriterion("ALIPAY_PUBLIC_KEY is null");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyIsNotNull() {
            addCriterion("ALIPAY_PUBLIC_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyEqualTo(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY =", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotEqualTo(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY <>", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyGreaterThan(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY >", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY >=", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyLessThan(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY <", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY <=", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyLike(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY like", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotLike(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY not like", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyIn(List<String> values) {
            addCriterion("ALIPAY_PUBLIC_KEY in", values, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotIn(List<String> values) {
            addCriterion("ALIPAY_PUBLIC_KEY not in", values, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyBetween(String value1, String value2) {
            addCriterion("ALIPAY_PUBLIC_KEY between", value1, value2, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotBetween(String value1, String value2) {
            addCriterion("ALIPAY_PUBLIC_KEY not between", value1, value2, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerIsNull() {
            addCriterion("ALIPAY_PARTNER is null");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerIsNotNull() {
            addCriterion("ALIPAY_PARTNER is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerEqualTo(String value) {
            addCriterion("ALIPAY_PARTNER =", value, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerNotEqualTo(String value) {
            addCriterion("ALIPAY_PARTNER <>", value, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerGreaterThan(String value) {
            addCriterion("ALIPAY_PARTNER >", value, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerGreaterThanOrEqualTo(String value) {
            addCriterion("ALIPAY_PARTNER >=", value, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerLessThan(String value) {
            addCriterion("ALIPAY_PARTNER <", value, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerLessThanOrEqualTo(String value) {
            addCriterion("ALIPAY_PARTNER <=", value, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerLike(String value) {
            addCriterion("ALIPAY_PARTNER like", value, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerNotLike(String value) {
            addCriterion("ALIPAY_PARTNER not like", value, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerIn(List<String> values) {
            addCriterion("ALIPAY_PARTNER in", values, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerNotIn(List<String> values) {
            addCriterion("ALIPAY_PARTNER not in", values, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerBetween(String value1, String value2) {
            addCriterion("ALIPAY_PARTNER between", value1, value2, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayPartnerNotBetween(String value1, String value2) {
            addCriterion("ALIPAY_PARTNER not between", value1, value2, "alipayPartner");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidIsNull() {
            addCriterion("ALIPAY_APP_APPID is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidIsNotNull() {
            addCriterion("ALIPAY_APP_APPID is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidEqualTo(String value) {
            addCriterion("ALIPAY_APP_APPID =", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidNotEqualTo(String value) {
            addCriterion("ALIPAY_APP_APPID <>", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidGreaterThan(String value) {
            addCriterion("ALIPAY_APP_APPID >", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidGreaterThanOrEqualTo(String value) {
            addCriterion("ALIPAY_APP_APPID >=", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidLessThan(String value) {
            addCriterion("ALIPAY_APP_APPID <", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidLessThanOrEqualTo(String value) {
            addCriterion("ALIPAY_APP_APPID <=", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidLike(String value) {
            addCriterion("ALIPAY_APP_APPID like", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidNotLike(String value) {
            addCriterion("ALIPAY_APP_APPID not like", value, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidIn(List<String> values) {
            addCriterion("ALIPAY_APP_APPID in", values, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidNotIn(List<String> values) {
            addCriterion("ALIPAY_APP_APPID not in", values, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidBetween(String value1, String value2) {
            addCriterion("ALIPAY_APP_APPID between", value1, value2, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppAppidNotBetween(String value1, String value2) {
            addCriterion("ALIPAY_APP_APPID not between", value1, value2, "alipayAppAppid");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyIsNull() {
            addCriterion("ALIPAY_APP_PRIVATE_KEY is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyIsNotNull() {
            addCriterion("ALIPAY_APP_PRIVATE_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyEqualTo(String value) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY =", value, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyNotEqualTo(String value) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY <>", value, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyGreaterThan(String value) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY >", value, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY >=", value, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyLessThan(String value) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY <", value, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY <=", value, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyLike(String value) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY like", value, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyNotLike(String value) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY not like", value, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyIn(List<String> values) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY in", values, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyNotIn(List<String> values) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY not in", values, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyBetween(String value1, String value2) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY between", value1, value2, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("ALIPAY_APP_PRIVATE_KEY not between", value1, value2, "alipayAppPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyIsNull() {
            addCriterion("ALIPAY_APP_PUBLIC_KEY is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyIsNotNull() {
            addCriterion("ALIPAY_APP_PUBLIC_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyEqualTo(String value) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY =", value, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyNotEqualTo(String value) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY <>", value, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyGreaterThan(String value) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY >", value, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY >=", value, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyLessThan(String value) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY <", value, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY <=", value, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyLike(String value) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY like", value, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyNotLike(String value) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY not like", value, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyIn(List<String> values) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY in", values, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyNotIn(List<String> values) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY not in", values, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyBetween(String value1, String value2) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY between", value1, value2, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppPublicKeyNotBetween(String value1, String value2) {
            addCriterion("ALIPAY_APP_PUBLIC_KEY not between", value1, value2, "alipayAppPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayIsNull() {
            addCriterion("ALIPAY_APP_GATEWAY is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayIsNotNull() {
            addCriterion("ALIPAY_APP_GATEWAY is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayEqualTo(String value) {
            addCriterion("ALIPAY_APP_GATEWAY =", value, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayNotEqualTo(String value) {
            addCriterion("ALIPAY_APP_GATEWAY <>", value, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayGreaterThan(String value) {
            addCriterion("ALIPAY_APP_GATEWAY >", value, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayGreaterThanOrEqualTo(String value) {
            addCriterion("ALIPAY_APP_GATEWAY >=", value, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayLessThan(String value) {
            addCriterion("ALIPAY_APP_GATEWAY <", value, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayLessThanOrEqualTo(String value) {
            addCriterion("ALIPAY_APP_GATEWAY <=", value, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayLike(String value) {
            addCriterion("ALIPAY_APP_GATEWAY like", value, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayNotLike(String value) {
            addCriterion("ALIPAY_APP_GATEWAY not like", value, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayIn(List<String> values) {
            addCriterion("ALIPAY_APP_GATEWAY in", values, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayNotIn(List<String> values) {
            addCriterion("ALIPAY_APP_GATEWAY not in", values, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayBetween(String value1, String value2) {
            addCriterion("ALIPAY_APP_GATEWAY between", value1, value2, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayAppGatewayNotBetween(String value1, String value2) {
            addCriterion("ALIPAY_APP_GATEWAY not between", value1, value2, "alipayAppGateway");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusIsNull() {
            addCriterion("ALIPAY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusIsNotNull() {
            addCriterion("ALIPAY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusEqualTo(Short value) {
            addCriterion("ALIPAY_STATUS =", value, "alipayStatus");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusNotEqualTo(Short value) {
            addCriterion("ALIPAY_STATUS <>", value, "alipayStatus");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusGreaterThan(Short value) {
            addCriterion("ALIPAY_STATUS >", value, "alipayStatus");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("ALIPAY_STATUS >=", value, "alipayStatus");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusLessThan(Short value) {
            addCriterion("ALIPAY_STATUS <", value, "alipayStatus");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusLessThanOrEqualTo(Short value) {
            addCriterion("ALIPAY_STATUS <=", value, "alipayStatus");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusIn(List<Short> values) {
            addCriterion("ALIPAY_STATUS in", values, "alipayStatus");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusNotIn(List<Short> values) {
            addCriterion("ALIPAY_STATUS not in", values, "alipayStatus");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusBetween(Short value1, Short value2) {
            addCriterion("ALIPAY_STATUS between", value1, value2, "alipayStatus");
            return (Criteria) this;
        }

        public Criteria andAlipayStatusNotBetween(Short value1, Short value2) {
            addCriterion("ALIPAY_STATUS not between", value1, value2, "alipayStatus");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("AREA_ID is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("AREA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Long value) {
            addCriterion("AREA_ID =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Long value) {
            addCriterion("AREA_ID <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Long value) {
            addCriterion("AREA_ID >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("AREA_ID >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Long value) {
            addCriterion("AREA_ID <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("AREA_ID <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Long> values) {
            addCriterion("AREA_ID in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Long> values) {
            addCriterion("AREA_ID not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Long value1, Long value2) {
            addCriterion("AREA_ID between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("AREA_ID not between", value1, value2, "areaId");
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