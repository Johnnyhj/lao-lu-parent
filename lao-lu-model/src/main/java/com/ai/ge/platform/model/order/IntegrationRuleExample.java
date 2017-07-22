package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.List;

public class IntegrationRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntegrationRuleExample() {
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

        public Criteria andIntegrationRuleIdIsNull() {
            addCriterion("INTEGRATION_RULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdIsNotNull() {
            addCriterion("INTEGRATION_RULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdEqualTo(Long value) {
            addCriterion("INTEGRATION_RULE_ID =", value, "integrationRuleId");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdNotEqualTo(Long value) {
            addCriterion("INTEGRATION_RULE_ID <>", value, "integrationRuleId");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdGreaterThan(Long value) {
            addCriterion("INTEGRATION_RULE_ID >", value, "integrationRuleId");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("INTEGRATION_RULE_ID >=", value, "integrationRuleId");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdLessThan(Long value) {
            addCriterion("INTEGRATION_RULE_ID <", value, "integrationRuleId");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("INTEGRATION_RULE_ID <=", value, "integrationRuleId");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdIn(List<Long> values) {
            addCriterion("INTEGRATION_RULE_ID in", values, "integrationRuleId");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdNotIn(List<Long> values) {
            addCriterion("INTEGRATION_RULE_ID not in", values, "integrationRuleId");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdBetween(Long value1, Long value2) {
            addCriterion("INTEGRATION_RULE_ID between", value1, value2, "integrationRuleId");
            return (Criteria) this;
        }

        public Criteria andIntegrationRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("INTEGRATION_RULE_ID not between", value1, value2, "integrationRuleId");
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

        public Criteria andIsDefaultIsNull() {
            addCriterion("IS_DEFAULT is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("IS_DEFAULT is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Short value) {
            addCriterion("IS_DEFAULT =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Short value) {
            addCriterion("IS_DEFAULT <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Short value) {
            addCriterion("IS_DEFAULT >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_DEFAULT >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Short value) {
            addCriterion("IS_DEFAULT <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Short value) {
            addCriterion("IS_DEFAULT <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Short> values) {
            addCriterion("IS_DEFAULT in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Short> values) {
            addCriterion("IS_DEFAULT not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Short value1, Short value2) {
            addCriterion("IS_DEFAULT between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Short value1, Short value2) {
            addCriterion("IS_DEFAULT not between", value1, value2, "isDefault");
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

        public Criteria andIntegrationIsNull() {
            addCriterion("INTEGRATION is null");
            return (Criteria) this;
        }

        public Criteria andIntegrationIsNotNull() {
            addCriterion("INTEGRATION is not null");
            return (Criteria) this;
        }

        public Criteria andIntegrationEqualTo(String value) {
            addCriterion("INTEGRATION =", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotEqualTo(String value) {
            addCriterion("INTEGRATION <>", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationGreaterThan(String value) {
            addCriterion("INTEGRATION >", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationGreaterThanOrEqualTo(String value) {
            addCriterion("INTEGRATION >=", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLessThan(String value) {
            addCriterion("INTEGRATION <", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLessThanOrEqualTo(String value) {
            addCriterion("INTEGRATION <=", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLike(String value) {
            addCriterion("INTEGRATION like", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotLike(String value) {
            addCriterion("INTEGRATION not like", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationIn(List<String> values) {
            addCriterion("INTEGRATION in", values, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotIn(List<String> values) {
            addCriterion("INTEGRATION not in", values, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationBetween(String value1, String value2) {
            addCriterion("INTEGRATION between", value1, value2, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotBetween(String value1, String value2) {
            addCriterion("INTEGRATION not between", value1, value2, "integration");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("EXTEND is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("EXTEND is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("EXTEND =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("EXTEND <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("EXTEND >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("EXTEND >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("EXTEND <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("EXTEND <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("EXTEND like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("EXTEND not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("EXTEND in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("EXTEND not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("EXTEND between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("EXTEND not between", value1, value2, "extend");
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

        public Criteria andPerformanceTimesIsNull() {
            addCriterion("PERFORMANCE_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesIsNotNull() {
            addCriterion("PERFORMANCE_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesEqualTo(Integer value) {
            addCriterion("PERFORMANCE_TIMES =", value, "performanceTimes");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesNotEqualTo(Integer value) {
            addCriterion("PERFORMANCE_TIMES <>", value, "performanceTimes");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesGreaterThan(Integer value) {
            addCriterion("PERFORMANCE_TIMES >", value, "performanceTimes");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("PERFORMANCE_TIMES >=", value, "performanceTimes");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesLessThan(Integer value) {
            addCriterion("PERFORMANCE_TIMES <", value, "performanceTimes");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesLessThanOrEqualTo(Integer value) {
            addCriterion("PERFORMANCE_TIMES <=", value, "performanceTimes");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesIn(List<Integer> values) {
            addCriterion("PERFORMANCE_TIMES in", values, "performanceTimes");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesNotIn(List<Integer> values) {
            addCriterion("PERFORMANCE_TIMES not in", values, "performanceTimes");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesBetween(Integer value1, Integer value2) {
            addCriterion("PERFORMANCE_TIMES between", value1, value2, "performanceTimes");
            return (Criteria) this;
        }

        public Criteria andPerformanceTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("PERFORMANCE_TIMES not between", value1, value2, "performanceTimes");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIsNull() {
            addCriterion("RULE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIsNotNull() {
            addCriterion("RULE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeEqualTo(Short value) {
            addCriterion("RULE_TYPE =", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotEqualTo(Short value) {
            addCriterion("RULE_TYPE <>", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeGreaterThan(Short value) {
            addCriterion("RULE_TYPE >", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("RULE_TYPE >=", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLessThan(Short value) {
            addCriterion("RULE_TYPE <", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLessThanOrEqualTo(Short value) {
            addCriterion("RULE_TYPE <=", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIn(List<Short> values) {
            addCriterion("RULE_TYPE in", values, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotIn(List<Short> values) {
            addCriterion("RULE_TYPE not in", values, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeBetween(Short value1, Short value2) {
            addCriterion("RULE_TYPE between", value1, value2, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotBetween(Short value1, Short value2) {
            addCriterion("RULE_TYPE not between", value1, value2, "ruleType");
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