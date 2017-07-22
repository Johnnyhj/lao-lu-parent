package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfferSpecInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfferSpecInfoExample() {
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

        public Criteria andCompOfferIsNull() {
            addCriterion("COMP_OFFER is null");
            return (Criteria) this;
        }

        public Criteria andCompOfferIsNotNull() {
            addCriterion("COMP_OFFER is not null");
            return (Criteria) this;
        }

        public Criteria andCompOfferEqualTo(String value) {
            addCriterion("COMP_OFFER =", value, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferNotEqualTo(String value) {
            addCriterion("COMP_OFFER <>", value, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferGreaterThan(String value) {
            addCriterion("COMP_OFFER >", value, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_OFFER >=", value, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferLessThan(String value) {
            addCriterion("COMP_OFFER <", value, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferLessThanOrEqualTo(String value) {
            addCriterion("COMP_OFFER <=", value, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferLike(String value) {
            addCriterion("COMP_OFFER like", value, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferNotLike(String value) {
            addCriterion("COMP_OFFER not like", value, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferIn(List<String> values) {
            addCriterion("COMP_OFFER in", values, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferNotIn(List<String> values) {
            addCriterion("COMP_OFFER not in", values, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferBetween(String value1, String value2) {
            addCriterion("COMP_OFFER between", value1, value2, "compOffer");
            return (Criteria) this;
        }

        public Criteria andCompOfferNotBetween(String value1, String value2) {
            addCriterion("COMP_OFFER not between", value1, value2, "compOffer");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdIsNull() {
            addCriterion("BUSI_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdIsNotNull() {
            addCriterion("BUSI_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdEqualTo(Short value) {
            addCriterion("BUSI_TYPE_CD =", value, "busiTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdNotEqualTo(Short value) {
            addCriterion("BUSI_TYPE_CD <>", value, "busiTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdGreaterThan(Short value) {
            addCriterion("BUSI_TYPE_CD >", value, "busiTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdGreaterThanOrEqualTo(Short value) {
            addCriterion("BUSI_TYPE_CD >=", value, "busiTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdLessThan(Short value) {
            addCriterion("BUSI_TYPE_CD <", value, "busiTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdLessThanOrEqualTo(Short value) {
            addCriterion("BUSI_TYPE_CD <=", value, "busiTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdIn(List<Short> values) {
            addCriterion("BUSI_TYPE_CD in", values, "busiTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdNotIn(List<Short> values) {
            addCriterion("BUSI_TYPE_CD not in", values, "busiTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdBetween(Short value1, Short value2) {
            addCriterion("BUSI_TYPE_CD between", value1, value2, "busiTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusiTypeCdNotBetween(Short value1, Short value2) {
            addCriterion("BUSI_TYPE_CD not between", value1, value2, "busiTypeCd");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNull() {
            addCriterion("FEE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNotNull() {
            addCriterion("FEE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(Short value) {
            addCriterion("FEE_TYPE =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotEqualTo(Short value) {
            addCriterion("FEE_TYPE <>", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThan(Short value) {
            addCriterion("FEE_TYPE >", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("FEE_TYPE >=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThan(Short value) {
            addCriterion("FEE_TYPE <", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThanOrEqualTo(Short value) {
            addCriterion("FEE_TYPE <=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIn(List<Short> values) {
            addCriterion("FEE_TYPE in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotIn(List<Short> values) {
            addCriterion("FEE_TYPE not in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeBetween(Short value1, Short value2) {
            addCriterion("FEE_TYPE between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotBetween(Short value1, Short value2) {
            addCriterion("FEE_TYPE not between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdIsNull() {
            addCriterion("LIFECYCLE_RULE_CD is null");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdIsNotNull() {
            addCriterion("LIFECYCLE_RULE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdEqualTo(String value) {
            addCriterion("LIFECYCLE_RULE_CD =", value, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdNotEqualTo(String value) {
            addCriterion("LIFECYCLE_RULE_CD <>", value, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdGreaterThan(String value) {
            addCriterion("LIFECYCLE_RULE_CD >", value, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdGreaterThanOrEqualTo(String value) {
            addCriterion("LIFECYCLE_RULE_CD >=", value, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdLessThan(String value) {
            addCriterion("LIFECYCLE_RULE_CD <", value, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdLessThanOrEqualTo(String value) {
            addCriterion("LIFECYCLE_RULE_CD <=", value, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdLike(String value) {
            addCriterion("LIFECYCLE_RULE_CD like", value, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdNotLike(String value) {
            addCriterion("LIFECYCLE_RULE_CD not like", value, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdIn(List<String> values) {
            addCriterion("LIFECYCLE_RULE_CD in", values, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdNotIn(List<String> values) {
            addCriterion("LIFECYCLE_RULE_CD not in", values, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdBetween(String value1, String value2) {
            addCriterion("LIFECYCLE_RULE_CD between", value1, value2, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andLifecycleRuleCdNotBetween(String value1, String value2) {
            addCriterion("LIFECYCLE_RULE_CD not between", value1, value2, "lifecycleRuleCd");
            return (Criteria) this;
        }

        public Criteria andAppStartDtIsNull() {
            addCriterion("APP_START_DT is null");
            return (Criteria) this;
        }

        public Criteria andAppStartDtIsNotNull() {
            addCriterion("APP_START_DT is not null");
            return (Criteria) this;
        }

        public Criteria andAppStartDtEqualTo(Date value) {
            addCriterion("APP_START_DT =", value, "appStartDt");
            return (Criteria) this;
        }

        public Criteria andAppStartDtNotEqualTo(Date value) {
            addCriterion("APP_START_DT <>", value, "appStartDt");
            return (Criteria) this;
        }

        public Criteria andAppStartDtGreaterThan(Date value) {
            addCriterion("APP_START_DT >", value, "appStartDt");
            return (Criteria) this;
        }

        public Criteria andAppStartDtGreaterThanOrEqualTo(Date value) {
            addCriterion("APP_START_DT >=", value, "appStartDt");
            return (Criteria) this;
        }

        public Criteria andAppStartDtLessThan(Date value) {
            addCriterion("APP_START_DT <", value, "appStartDt");
            return (Criteria) this;
        }

        public Criteria andAppStartDtLessThanOrEqualTo(Date value) {
            addCriterion("APP_START_DT <=", value, "appStartDt");
            return (Criteria) this;
        }

        public Criteria andAppStartDtIn(List<Date> values) {
            addCriterion("APP_START_DT in", values, "appStartDt");
            return (Criteria) this;
        }

        public Criteria andAppStartDtNotIn(List<Date> values) {
            addCriterion("APP_START_DT not in", values, "appStartDt");
            return (Criteria) this;
        }

        public Criteria andAppStartDtBetween(Date value1, Date value2) {
            addCriterion("APP_START_DT between", value1, value2, "appStartDt");
            return (Criteria) this;
        }

        public Criteria andAppStartDtNotBetween(Date value1, Date value2) {
            addCriterion("APP_START_DT not between", value1, value2, "appStartDt");
            return (Criteria) this;
        }

        public Criteria andAppEndDtIsNull() {
            addCriterion("APP_END_DT is null");
            return (Criteria) this;
        }

        public Criteria andAppEndDtIsNotNull() {
            addCriterion("APP_END_DT is not null");
            return (Criteria) this;
        }

        public Criteria andAppEndDtEqualTo(Date value) {
            addCriterion("APP_END_DT =", value, "appEndDt");
            return (Criteria) this;
        }

        public Criteria andAppEndDtNotEqualTo(Date value) {
            addCriterion("APP_END_DT <>", value, "appEndDt");
            return (Criteria) this;
        }

        public Criteria andAppEndDtGreaterThan(Date value) {
            addCriterion("APP_END_DT >", value, "appEndDt");
            return (Criteria) this;
        }

        public Criteria andAppEndDtGreaterThanOrEqualTo(Date value) {
            addCriterion("APP_END_DT >=", value, "appEndDt");
            return (Criteria) this;
        }

        public Criteria andAppEndDtLessThan(Date value) {
            addCriterion("APP_END_DT <", value, "appEndDt");
            return (Criteria) this;
        }

        public Criteria andAppEndDtLessThanOrEqualTo(Date value) {
            addCriterion("APP_END_DT <=", value, "appEndDt");
            return (Criteria) this;
        }

        public Criteria andAppEndDtIn(List<Date> values) {
            addCriterion("APP_END_DT in", values, "appEndDt");
            return (Criteria) this;
        }

        public Criteria andAppEndDtNotIn(List<Date> values) {
            addCriterion("APP_END_DT not in", values, "appEndDt");
            return (Criteria) this;
        }

        public Criteria andAppEndDtBetween(Date value1, Date value2) {
            addCriterion("APP_END_DT between", value1, value2, "appEndDt");
            return (Criteria) this;
        }

        public Criteria andAppEndDtNotBetween(Date value1, Date value2) {
            addCriterion("APP_END_DT not between", value1, value2, "appEndDt");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdIsNull() {
            addCriterion("TIME_UNIT_CD is null");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdIsNotNull() {
            addCriterion("TIME_UNIT_CD is not null");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdEqualTo(Short value) {
            addCriterion("TIME_UNIT_CD =", value, "timeUnitCd");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdNotEqualTo(Short value) {
            addCriterion("TIME_UNIT_CD <>", value, "timeUnitCd");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdGreaterThan(Short value) {
            addCriterion("TIME_UNIT_CD >", value, "timeUnitCd");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdGreaterThanOrEqualTo(Short value) {
            addCriterion("TIME_UNIT_CD >=", value, "timeUnitCd");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdLessThan(Short value) {
            addCriterion("TIME_UNIT_CD <", value, "timeUnitCd");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdLessThanOrEqualTo(Short value) {
            addCriterion("TIME_UNIT_CD <=", value, "timeUnitCd");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdIn(List<Short> values) {
            addCriterion("TIME_UNIT_CD in", values, "timeUnitCd");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdNotIn(List<Short> values) {
            addCriterion("TIME_UNIT_CD not in", values, "timeUnitCd");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdBetween(Short value1, Short value2) {
            addCriterion("TIME_UNIT_CD between", value1, value2, "timeUnitCd");
            return (Criteria) this;
        }

        public Criteria andTimeUnitCdNotBetween(Short value1, Short value2) {
            addCriterion("TIME_UNIT_CD not between", value1, value2, "timeUnitCd");
            return (Criteria) this;
        }

        public Criteria andEffTimeIsNull() {
            addCriterion("EFF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffTimeIsNotNull() {
            addCriterion("EFF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffTimeEqualTo(Integer value) {
            addCriterion("EFF_TIME =", value, "effTime");
            return (Criteria) this;
        }

        public Criteria andEffTimeNotEqualTo(Integer value) {
            addCriterion("EFF_TIME <>", value, "effTime");
            return (Criteria) this;
        }

        public Criteria andEffTimeGreaterThan(Integer value) {
            addCriterion("EFF_TIME >", value, "effTime");
            return (Criteria) this;
        }

        public Criteria andEffTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("EFF_TIME >=", value, "effTime");
            return (Criteria) this;
        }

        public Criteria andEffTimeLessThan(Integer value) {
            addCriterion("EFF_TIME <", value, "effTime");
            return (Criteria) this;
        }

        public Criteria andEffTimeLessThanOrEqualTo(Integer value) {
            addCriterion("EFF_TIME <=", value, "effTime");
            return (Criteria) this;
        }

        public Criteria andEffTimeIn(List<Integer> values) {
            addCriterion("EFF_TIME in", values, "effTime");
            return (Criteria) this;
        }

        public Criteria andEffTimeNotIn(List<Integer> values) {
            addCriterion("EFF_TIME not in", values, "effTime");
            return (Criteria) this;
        }

        public Criteria andEffTimeBetween(Integer value1, Integer value2) {
            addCriterion("EFF_TIME between", value1, value2, "effTime");
            return (Criteria) this;
        }

        public Criteria andEffTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("EFF_TIME not between", value1, value2, "effTime");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeIsNull() {
            addCriterion("CHANGE_EFF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeIsNotNull() {
            addCriterion("CHANGE_EFF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeEqualTo(Integer value) {
            addCriterion("CHANGE_EFF_TIME =", value, "changeEffTime");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeNotEqualTo(Integer value) {
            addCriterion("CHANGE_EFF_TIME <>", value, "changeEffTime");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeGreaterThan(Integer value) {
            addCriterion("CHANGE_EFF_TIME >", value, "changeEffTime");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHANGE_EFF_TIME >=", value, "changeEffTime");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeLessThan(Integer value) {
            addCriterion("CHANGE_EFF_TIME <", value, "changeEffTime");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeLessThanOrEqualTo(Integer value) {
            addCriterion("CHANGE_EFF_TIME <=", value, "changeEffTime");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeIn(List<Integer> values) {
            addCriterion("CHANGE_EFF_TIME in", values, "changeEffTime");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeNotIn(List<Integer> values) {
            addCriterion("CHANGE_EFF_TIME not in", values, "changeEffTime");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeBetween(Integer value1, Integer value2) {
            addCriterion("CHANGE_EFF_TIME between", value1, value2, "changeEffTime");
            return (Criteria) this;
        }

        public Criteria andChangeEffTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("CHANGE_EFF_TIME not between", value1, value2, "changeEffTime");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeIsNull() {
            addCriterion("PRE_SALE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeIsNotNull() {
            addCriterion("PRE_SALE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeEqualTo(Integer value) {
            addCriterion("PRE_SALE_TIME =", value, "preSaleTime");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeNotEqualTo(Integer value) {
            addCriterion("PRE_SALE_TIME <>", value, "preSaleTime");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeGreaterThan(Integer value) {
            addCriterion("PRE_SALE_TIME >", value, "preSaleTime");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRE_SALE_TIME >=", value, "preSaleTime");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeLessThan(Integer value) {
            addCriterion("PRE_SALE_TIME <", value, "preSaleTime");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeLessThanOrEqualTo(Integer value) {
            addCriterion("PRE_SALE_TIME <=", value, "preSaleTime");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeIn(List<Integer> values) {
            addCriterion("PRE_SALE_TIME in", values, "preSaleTime");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeNotIn(List<Integer> values) {
            addCriterion("PRE_SALE_TIME not in", values, "preSaleTime");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeBetween(Integer value1, Integer value2) {
            addCriterion("PRE_SALE_TIME between", value1, value2, "preSaleTime");
            return (Criteria) this;
        }

        public Criteria andPreSaleTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("PRE_SALE_TIME not between", value1, value2, "preSaleTime");
            return (Criteria) this;
        }

        public Criteria andInUseTimeIsNull() {
            addCriterion("IN_USE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInUseTimeIsNotNull() {
            addCriterion("IN_USE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInUseTimeEqualTo(Integer value) {
            addCriterion("IN_USE_TIME =", value, "inUseTime");
            return (Criteria) this;
        }

        public Criteria andInUseTimeNotEqualTo(Integer value) {
            addCriterion("IN_USE_TIME <>", value, "inUseTime");
            return (Criteria) this;
        }

        public Criteria andInUseTimeGreaterThan(Integer value) {
            addCriterion("IN_USE_TIME >", value, "inUseTime");
            return (Criteria) this;
        }

        public Criteria andInUseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("IN_USE_TIME >=", value, "inUseTime");
            return (Criteria) this;
        }

        public Criteria andInUseTimeLessThan(Integer value) {
            addCriterion("IN_USE_TIME <", value, "inUseTime");
            return (Criteria) this;
        }

        public Criteria andInUseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("IN_USE_TIME <=", value, "inUseTime");
            return (Criteria) this;
        }

        public Criteria andInUseTimeIn(List<Integer> values) {
            addCriterion("IN_USE_TIME in", values, "inUseTime");
            return (Criteria) this;
        }

        public Criteria andInUseTimeNotIn(List<Integer> values) {
            addCriterion("IN_USE_TIME not in", values, "inUseTime");
            return (Criteria) this;
        }

        public Criteria andInUseTimeBetween(Integer value1, Integer value2) {
            addCriterion("IN_USE_TIME between", value1, value2, "inUseTime");
            return (Criteria) this;
        }

        public Criteria andInUseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("IN_USE_TIME not between", value1, value2, "inUseTime");
            return (Criteria) this;
        }

        public Criteria andRpmonthIsNull() {
            addCriterion("RPMONTH is null");
            return (Criteria) this;
        }

        public Criteria andRpmonthIsNotNull() {
            addCriterion("RPMONTH is not null");
            return (Criteria) this;
        }

        public Criteria andRpmonthEqualTo(Long value) {
            addCriterion("RPMONTH =", value, "rpmonth");
            return (Criteria) this;
        }

        public Criteria andRpmonthNotEqualTo(Long value) {
            addCriterion("RPMONTH <>", value, "rpmonth");
            return (Criteria) this;
        }

        public Criteria andRpmonthGreaterThan(Long value) {
            addCriterion("RPMONTH >", value, "rpmonth");
            return (Criteria) this;
        }

        public Criteria andRpmonthGreaterThanOrEqualTo(Long value) {
            addCriterion("RPMONTH >=", value, "rpmonth");
            return (Criteria) this;
        }

        public Criteria andRpmonthLessThan(Long value) {
            addCriterion("RPMONTH <", value, "rpmonth");
            return (Criteria) this;
        }

        public Criteria andRpmonthLessThanOrEqualTo(Long value) {
            addCriterion("RPMONTH <=", value, "rpmonth");
            return (Criteria) this;
        }

        public Criteria andRpmonthIn(List<Long> values) {
            addCriterion("RPMONTH in", values, "rpmonth");
            return (Criteria) this;
        }

        public Criteria andRpmonthNotIn(List<Long> values) {
            addCriterion("RPMONTH not in", values, "rpmonth");
            return (Criteria) this;
        }

        public Criteria andRpmonthBetween(Long value1, Long value2) {
            addCriterion("RPMONTH between", value1, value2, "rpmonth");
            return (Criteria) this;
        }

        public Criteria andRpmonthNotBetween(Long value1, Long value2) {
            addCriterion("RPMONTH not between", value1, value2, "rpmonth");
            return (Criteria) this;
        }

        public Criteria andCostDescIsNull() {
            addCriterion("COST_DESC is null");
            return (Criteria) this;
        }

        public Criteria andCostDescIsNotNull() {
            addCriterion("COST_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andCostDescEqualTo(String value) {
            addCriterion("COST_DESC =", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescNotEqualTo(String value) {
            addCriterion("COST_DESC <>", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescGreaterThan(String value) {
            addCriterion("COST_DESC >", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescGreaterThanOrEqualTo(String value) {
            addCriterion("COST_DESC >=", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescLessThan(String value) {
            addCriterion("COST_DESC <", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescLessThanOrEqualTo(String value) {
            addCriterion("COST_DESC <=", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescLike(String value) {
            addCriterion("COST_DESC like", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescNotLike(String value) {
            addCriterion("COST_DESC not like", value, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescIn(List<String> values) {
            addCriterion("COST_DESC in", values, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescNotIn(List<String> values) {
            addCriterion("COST_DESC not in", values, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescBetween(String value1, String value2) {
            addCriterion("COST_DESC between", value1, value2, "costDesc");
            return (Criteria) this;
        }

        public Criteria andCostDescNotBetween(String value1, String value2) {
            addCriterion("COST_DESC not between", value1, value2, "costDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescIsNull() {
            addCriterion("FLOW_DESC is null");
            return (Criteria) this;
        }

        public Criteria andFlowDescIsNotNull() {
            addCriterion("FLOW_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andFlowDescEqualTo(String value) {
            addCriterion("FLOW_DESC =", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescNotEqualTo(String value) {
            addCriterion("FLOW_DESC <>", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescGreaterThan(String value) {
            addCriterion("FLOW_DESC >", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescGreaterThanOrEqualTo(String value) {
            addCriterion("FLOW_DESC >=", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescLessThan(String value) {
            addCriterion("FLOW_DESC <", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescLessThanOrEqualTo(String value) {
            addCriterion("FLOW_DESC <=", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescLike(String value) {
            addCriterion("FLOW_DESC like", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescNotLike(String value) {
            addCriterion("FLOW_DESC not like", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescIn(List<String> values) {
            addCriterion("FLOW_DESC in", values, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescNotIn(List<String> values) {
            addCriterion("FLOW_DESC not in", values, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescBetween(String value1, String value2) {
            addCriterion("FLOW_DESC between", value1, value2, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescNotBetween(String value1, String value2) {
            addCriterion("FLOW_DESC not between", value1, value2, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescIsNull() {
            addCriterion("CALL_DESC is null");
            return (Criteria) this;
        }

        public Criteria andCallDescIsNotNull() {
            addCriterion("CALL_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andCallDescEqualTo(String value) {
            addCriterion("CALL_DESC =", value, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescNotEqualTo(String value) {
            addCriterion("CALL_DESC <>", value, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescGreaterThan(String value) {
            addCriterion("CALL_DESC >", value, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescGreaterThanOrEqualTo(String value) {
            addCriterion("CALL_DESC >=", value, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescLessThan(String value) {
            addCriterion("CALL_DESC <", value, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescLessThanOrEqualTo(String value) {
            addCriterion("CALL_DESC <=", value, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescLike(String value) {
            addCriterion("CALL_DESC like", value, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescNotLike(String value) {
            addCriterion("CALL_DESC not like", value, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescIn(List<String> values) {
            addCriterion("CALL_DESC in", values, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescNotIn(List<String> values) {
            addCriterion("CALL_DESC not in", values, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescBetween(String value1, String value2) {
            addCriterion("CALL_DESC between", value1, value2, "callDesc");
            return (Criteria) this;
        }

        public Criteria andCallDescNotBetween(String value1, String value2) {
            addCriterion("CALL_DESC not between", value1, value2, "callDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescIsNull() {
            addCriterion("SALE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andSaleDescIsNotNull() {
            addCriterion("SALE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andSaleDescEqualTo(String value) {
            addCriterion("SALE_DESC =", value, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescNotEqualTo(String value) {
            addCriterion("SALE_DESC <>", value, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescGreaterThan(String value) {
            addCriterion("SALE_DESC >", value, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_DESC >=", value, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescLessThan(String value) {
            addCriterion("SALE_DESC <", value, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescLessThanOrEqualTo(String value) {
            addCriterion("SALE_DESC <=", value, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescLike(String value) {
            addCriterion("SALE_DESC like", value, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescNotLike(String value) {
            addCriterion("SALE_DESC not like", value, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescIn(List<String> values) {
            addCriterion("SALE_DESC in", values, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescNotIn(List<String> values) {
            addCriterion("SALE_DESC not in", values, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescBetween(String value1, String value2) {
            addCriterion("SALE_DESC between", value1, value2, "saleDesc");
            return (Criteria) this;
        }

        public Criteria andSaleDescNotBetween(String value1, String value2) {
            addCriterion("SALE_DESC not between", value1, value2, "saleDesc");
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

        public Criteria andCityAearIdIsNull() {
            addCriterion("CITY_AEAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andCityAearIdIsNotNull() {
            addCriterion("CITY_AEAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCityAearIdEqualTo(Long value) {
            addCriterion("CITY_AEAR_ID =", value, "cityAearId");
            return (Criteria) this;
        }

        public Criteria andCityAearIdNotEqualTo(Long value) {
            addCriterion("CITY_AEAR_ID <>", value, "cityAearId");
            return (Criteria) this;
        }

        public Criteria andCityAearIdGreaterThan(Long value) {
            addCriterion("CITY_AEAR_ID >", value, "cityAearId");
            return (Criteria) this;
        }

        public Criteria andCityAearIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CITY_AEAR_ID >=", value, "cityAearId");
            return (Criteria) this;
        }

        public Criteria andCityAearIdLessThan(Long value) {
            addCriterion("CITY_AEAR_ID <", value, "cityAearId");
            return (Criteria) this;
        }

        public Criteria andCityAearIdLessThanOrEqualTo(Long value) {
            addCriterion("CITY_AEAR_ID <=", value, "cityAearId");
            return (Criteria) this;
        }

        public Criteria andCityAearIdIn(List<Long> values) {
            addCriterion("CITY_AEAR_ID in", values, "cityAearId");
            return (Criteria) this;
        }

        public Criteria andCityAearIdNotIn(List<Long> values) {
            addCriterion("CITY_AEAR_ID not in", values, "cityAearId");
            return (Criteria) this;
        }

        public Criteria andCityAearIdBetween(Long value1, Long value2) {
            addCriterion("CITY_AEAR_ID between", value1, value2, "cityAearId");
            return (Criteria) this;
        }

        public Criteria andCityAearIdNotBetween(Long value1, Long value2) {
            addCriterion("CITY_AEAR_ID not between", value1, value2, "cityAearId");
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