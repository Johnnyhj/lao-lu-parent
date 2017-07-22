package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfferSpecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfferSpecExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andManageCodeIsNull() {
            addCriterion("MANAGE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andManageCodeIsNotNull() {
            addCriterion("MANAGE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andManageCodeEqualTo(String value) {
            addCriterion("MANAGE_CODE =", value, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeNotEqualTo(String value) {
            addCriterion("MANAGE_CODE <>", value, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeGreaterThan(String value) {
            addCriterion("MANAGE_CODE >", value, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MANAGE_CODE >=", value, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeLessThan(String value) {
            addCriterion("MANAGE_CODE <", value, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeLessThanOrEqualTo(String value) {
            addCriterion("MANAGE_CODE <=", value, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeLike(String value) {
            addCriterion("MANAGE_CODE like", value, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeNotLike(String value) {
            addCriterion("MANAGE_CODE not like", value, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeIn(List<String> values) {
            addCriterion("MANAGE_CODE in", values, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeNotIn(List<String> values) {
            addCriterion("MANAGE_CODE not in", values, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeBetween(String value1, String value2) {
            addCriterion("MANAGE_CODE between", value1, value2, "manageCode");
            return (Criteria) this;
        }

        public Criteria andManageCodeNotBetween(String value1, String value2) {
            addCriterion("MANAGE_CODE not between", value1, value2, "manageCode");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellIsNull() {
            addCriterion("SIMPLE_SPELL is null");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellIsNotNull() {
            addCriterion("SIMPLE_SPELL is not null");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellEqualTo(String value) {
            addCriterion("SIMPLE_SPELL =", value, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellNotEqualTo(String value) {
            addCriterion("SIMPLE_SPELL <>", value, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellGreaterThan(String value) {
            addCriterion("SIMPLE_SPELL >", value, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellGreaterThanOrEqualTo(String value) {
            addCriterion("SIMPLE_SPELL >=", value, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellLessThan(String value) {
            addCriterion("SIMPLE_SPELL <", value, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellLessThanOrEqualTo(String value) {
            addCriterion("SIMPLE_SPELL <=", value, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellLike(String value) {
            addCriterion("SIMPLE_SPELL like", value, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellNotLike(String value) {
            addCriterion("SIMPLE_SPELL not like", value, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellIn(List<String> values) {
            addCriterion("SIMPLE_SPELL in", values, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellNotIn(List<String> values) {
            addCriterion("SIMPLE_SPELL not in", values, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellBetween(String value1, String value2) {
            addCriterion("SIMPLE_SPELL between", value1, value2, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andSimpleSpellNotBetween(String value1, String value2) {
            addCriterion("SIMPLE_SPELL not between", value1, value2, "simpleSpell");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdIsNull() {
            addCriterion("AGREEMENT_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdIsNotNull() {
            addCriterion("AGREEMENT_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdEqualTo(Short value) {
            addCriterion("AGREEMENT_TYPE_CD =", value, "agreementTypeCd");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdNotEqualTo(Short value) {
            addCriterion("AGREEMENT_TYPE_CD <>", value, "agreementTypeCd");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdGreaterThan(Short value) {
            addCriterion("AGREEMENT_TYPE_CD >", value, "agreementTypeCd");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdGreaterThanOrEqualTo(Short value) {
            addCriterion("AGREEMENT_TYPE_CD >=", value, "agreementTypeCd");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdLessThan(Short value) {
            addCriterion("AGREEMENT_TYPE_CD <", value, "agreementTypeCd");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdLessThanOrEqualTo(Short value) {
            addCriterion("AGREEMENT_TYPE_CD <=", value, "agreementTypeCd");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdIn(List<Short> values) {
            addCriterion("AGREEMENT_TYPE_CD in", values, "agreementTypeCd");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdNotIn(List<Short> values) {
            addCriterion("AGREEMENT_TYPE_CD not in", values, "agreementTypeCd");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdBetween(Short value1, Short value2) {
            addCriterion("AGREEMENT_TYPE_CD between", value1, value2, "agreementTypeCd");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeCdNotBetween(Short value1, Short value2) {
            addCriterion("AGREEMENT_TYPE_CD not between", value1, value2, "agreementTypeCd");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdIsNull() {
            addCriterion("OFFER_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdIsNotNull() {
            addCriterion("OFFER_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdEqualTo(Short value) {
            addCriterion("OFFER_TYPE_CD =", value, "offerTypeCd");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdNotEqualTo(Short value) {
            addCriterion("OFFER_TYPE_CD <>", value, "offerTypeCd");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdGreaterThan(Short value) {
            addCriterion("OFFER_TYPE_CD >", value, "offerTypeCd");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdGreaterThanOrEqualTo(Short value) {
            addCriterion("OFFER_TYPE_CD >=", value, "offerTypeCd");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdLessThan(Short value) {
            addCriterion("OFFER_TYPE_CD <", value, "offerTypeCd");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdLessThanOrEqualTo(Short value) {
            addCriterion("OFFER_TYPE_CD <=", value, "offerTypeCd");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdIn(List<Short> values) {
            addCriterion("OFFER_TYPE_CD in", values, "offerTypeCd");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdNotIn(List<Short> values) {
            addCriterion("OFFER_TYPE_CD not in", values, "offerTypeCd");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdBetween(Short value1, Short value2) {
            addCriterion("OFFER_TYPE_CD between", value1, value2, "offerTypeCd");
            return (Criteria) this;
        }

        public Criteria andOfferTypeCdNotBetween(Short value1, Short value2) {
            addCriterion("OFFER_TYPE_CD not between", value1, value2, "offerTypeCd");
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

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("AREA_ID =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("AREA_ID <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("AREA_ID >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AREA_ID >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("AREA_ID <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("AREA_ID <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("AREA_ID in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("AREA_ID not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("AREA_ID between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AREA_ID not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("SUMMARY is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("SUMMARY is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("SUMMARY =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("SUMMARY <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("SUMMARY >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("SUMMARY >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("SUMMARY <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("SUMMARY <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("SUMMARY like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("SUMMARY not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("SUMMARY in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("SUMMARY not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("SUMMARY between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("SUMMARY not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andStartDtIsNull() {
            addCriterion("START_DT is null");
            return (Criteria) this;
        }

        public Criteria andStartDtIsNotNull() {
            addCriterion("START_DT is not null");
            return (Criteria) this;
        }

        public Criteria andStartDtEqualTo(Date value) {
            addCriterion("START_DT =", value, "startDt");
            return (Criteria) this;
        }

        public Criteria andStartDtNotEqualTo(Date value) {
            addCriterion("START_DT <>", value, "startDt");
            return (Criteria) this;
        }

        public Criteria andStartDtGreaterThan(Date value) {
            addCriterion("START_DT >", value, "startDt");
            return (Criteria) this;
        }

        public Criteria andStartDtGreaterThanOrEqualTo(Date value) {
            addCriterion("START_DT >=", value, "startDt");
            return (Criteria) this;
        }

        public Criteria andStartDtLessThan(Date value) {
            addCriterion("START_DT <", value, "startDt");
            return (Criteria) this;
        }

        public Criteria andStartDtLessThanOrEqualTo(Date value) {
            addCriterion("START_DT <=", value, "startDt");
            return (Criteria) this;
        }

        public Criteria andStartDtIn(List<Date> values) {
            addCriterion("START_DT in", values, "startDt");
            return (Criteria) this;
        }

        public Criteria andStartDtNotIn(List<Date> values) {
            addCriterion("START_DT not in", values, "startDt");
            return (Criteria) this;
        }

        public Criteria andStartDtBetween(Date value1, Date value2) {
            addCriterion("START_DT between", value1, value2, "startDt");
            return (Criteria) this;
        }

        public Criteria andStartDtNotBetween(Date value1, Date value2) {
            addCriterion("START_DT not between", value1, value2, "startDt");
            return (Criteria) this;
        }

        public Criteria andEndDtIsNull() {
            addCriterion("END_DT is null");
            return (Criteria) this;
        }

        public Criteria andEndDtIsNotNull() {
            addCriterion("END_DT is not null");
            return (Criteria) this;
        }

        public Criteria andEndDtEqualTo(Date value) {
            addCriterion("END_DT =", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtNotEqualTo(Date value) {
            addCriterion("END_DT <>", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtGreaterThan(Date value) {
            addCriterion("END_DT >", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtGreaterThanOrEqualTo(Date value) {
            addCriterion("END_DT >=", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtLessThan(Date value) {
            addCriterion("END_DT <", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtLessThanOrEqualTo(Date value) {
            addCriterion("END_DT <=", value, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtIn(List<Date> values) {
            addCriterion("END_DT in", values, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtNotIn(List<Date> values) {
            addCriterion("END_DT not in", values, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtBetween(Date value1, Date value2) {
            addCriterion("END_DT between", value1, value2, "endDt");
            return (Criteria) this;
        }

        public Criteria andEndDtNotBetween(Date value1, Date value2) {
            addCriterion("END_DT not between", value1, value2, "endDt");
            return (Criteria) this;
        }

        public Criteria andStatusCdIsNull() {
            addCriterion("STATUS_CD is null");
            return (Criteria) this;
        }

        public Criteria andStatusCdIsNotNull() {
            addCriterion("STATUS_CD is not null");
            return (Criteria) this;
        }

        public Criteria andStatusCdEqualTo(Short value) {
            addCriterion("STATUS_CD =", value, "statusCd");
            return (Criteria) this;
        }

        public Criteria andStatusCdNotEqualTo(Short value) {
            addCriterion("STATUS_CD <>", value, "statusCd");
            return (Criteria) this;
        }

        public Criteria andStatusCdGreaterThan(Short value) {
            addCriterion("STATUS_CD >", value, "statusCd");
            return (Criteria) this;
        }

        public Criteria andStatusCdGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS_CD >=", value, "statusCd");
            return (Criteria) this;
        }

        public Criteria andStatusCdLessThan(Short value) {
            addCriterion("STATUS_CD <", value, "statusCd");
            return (Criteria) this;
        }

        public Criteria andStatusCdLessThanOrEqualTo(Short value) {
            addCriterion("STATUS_CD <=", value, "statusCd");
            return (Criteria) this;
        }

        public Criteria andStatusCdIn(List<Short> values) {
            addCriterion("STATUS_CD in", values, "statusCd");
            return (Criteria) this;
        }

        public Criteria andStatusCdNotIn(List<Short> values) {
            addCriterion("STATUS_CD not in", values, "statusCd");
            return (Criteria) this;
        }

        public Criteria andStatusCdBetween(Short value1, Short value2) {
            addCriterion("STATUS_CD between", value1, value2, "statusCd");
            return (Criteria) this;
        }

        public Criteria andStatusCdNotBetween(Short value1, Short value2) {
            addCriterion("STATUS_CD not between", value1, value2, "statusCd");
            return (Criteria) this;
        }

        public Criteria andStatusDtIsNull() {
            addCriterion("STATUS_DT is null");
            return (Criteria) this;
        }

        public Criteria andStatusDtIsNotNull() {
            addCriterion("STATUS_DT is not null");
            return (Criteria) this;
        }

        public Criteria andStatusDtEqualTo(Date value) {
            addCriterion("STATUS_DT =", value, "statusDt");
            return (Criteria) this;
        }

        public Criteria andStatusDtNotEqualTo(Date value) {
            addCriterion("STATUS_DT <>", value, "statusDt");
            return (Criteria) this;
        }

        public Criteria andStatusDtGreaterThan(Date value) {
            addCriterion("STATUS_DT >", value, "statusDt");
            return (Criteria) this;
        }

        public Criteria andStatusDtGreaterThanOrEqualTo(Date value) {
            addCriterion("STATUS_DT >=", value, "statusDt");
            return (Criteria) this;
        }

        public Criteria andStatusDtLessThan(Date value) {
            addCriterion("STATUS_DT <", value, "statusDt");
            return (Criteria) this;
        }

        public Criteria andStatusDtLessThanOrEqualTo(Date value) {
            addCriterion("STATUS_DT <=", value, "statusDt");
            return (Criteria) this;
        }

        public Criteria andStatusDtIn(List<Date> values) {
            addCriterion("STATUS_DT in", values, "statusDt");
            return (Criteria) this;
        }

        public Criteria andStatusDtNotIn(List<Date> values) {
            addCriterion("STATUS_DT not in", values, "statusDt");
            return (Criteria) this;
        }

        public Criteria andStatusDtBetween(Date value1, Date value2) {
            addCriterion("STATUS_DT between", value1, value2, "statusDt");
            return (Criteria) this;
        }

        public Criteria andStatusDtNotBetween(Date value1, Date value2) {
            addCriterion("STATUS_DT not between", value1, value2, "statusDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtIsNull() {
            addCriterion("CREATE_DT is null");
            return (Criteria) this;
        }

        public Criteria andCreateDtIsNotNull() {
            addCriterion("CREATE_DT is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDtEqualTo(Date value) {
            addCriterion("CREATE_DT =", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotEqualTo(Date value) {
            addCriterion("CREATE_DT <>", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtGreaterThan(Date value) {
            addCriterion("CREATE_DT >", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DT >=", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtLessThan(Date value) {
            addCriterion("CREATE_DT <", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DT <=", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtIn(List<Date> values) {
            addCriterion("CREATE_DT in", values, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotIn(List<Date> values) {
            addCriterion("CREATE_DT not in", values, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtBetween(Date value1, Date value2) {
            addCriterion("CREATE_DT between", value1, value2, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DT not between", value1, value2, "createDt");
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
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Date value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Date value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Date value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Date value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Date value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Date> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Date> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Date value1, Date value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Date value1, Date value2) {
            addCriterion("VERSION not between", value1, value2, "version");
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