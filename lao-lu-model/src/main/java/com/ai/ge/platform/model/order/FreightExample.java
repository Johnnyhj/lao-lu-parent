package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.List;

public class FreightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FreightExample() {
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

        public Criteria andFreightIdIsNull() {
            addCriterion("FREIGHT_ID is null");
            return (Criteria) this;
        }

        public Criteria andFreightIdIsNotNull() {
            addCriterion("FREIGHT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFreightIdEqualTo(Long value) {
            addCriterion("FREIGHT_ID =", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotEqualTo(Long value) {
            addCriterion("FREIGHT_ID <>", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdGreaterThan(Long value) {
            addCriterion("FREIGHT_ID >", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FREIGHT_ID >=", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdLessThan(Long value) {
            addCriterion("FREIGHT_ID <", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdLessThanOrEqualTo(Long value) {
            addCriterion("FREIGHT_ID <=", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdIn(List<Long> values) {
            addCriterion("FREIGHT_ID in", values, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotIn(List<Long> values) {
            addCriterion("FREIGHT_ID not in", values, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdBetween(Long value1, Long value2) {
            addCriterion("FREIGHT_ID between", value1, value2, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotBetween(Long value1, Long value2) {
            addCriterion("FREIGHT_ID not between", value1, value2, "freightId");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdIsNull() {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdIsNotNull() {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdEqualTo(Long value) {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID =", value, "originalProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdNotEqualTo(Long value) {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID <>", value, "originalProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdGreaterThan(Long value) {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID >", value, "originalProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID >=", value, "originalProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdLessThan(Long value) {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID <", value, "originalProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdLessThanOrEqualTo(Long value) {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID <=", value, "originalProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdIn(List<Long> values) {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID in", values, "originalProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdNotIn(List<Long> values) {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID not in", values, "originalProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdBetween(Long value1, Long value2) {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID between", value1, value2, "originalProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalProvinceAearIdNotBetween(Long value1, Long value2) {
            addCriterion("ORIGINAL_PROVINCE_AEAR_ID not between", value1, value2, "originalProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdIsNull() {
            addCriterion("ORIGINAL_CITY_AEAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdIsNotNull() {
            addCriterion("ORIGINAL_CITY_AEAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdEqualTo(Long value) {
            addCriterion("ORIGINAL_CITY_AEAR_ID =", value, "originalCityAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdNotEqualTo(Long value) {
            addCriterion("ORIGINAL_CITY_AEAR_ID <>", value, "originalCityAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdGreaterThan(Long value) {
            addCriterion("ORIGINAL_CITY_AEAR_ID >", value, "originalCityAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORIGINAL_CITY_AEAR_ID >=", value, "originalCityAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdLessThan(Long value) {
            addCriterion("ORIGINAL_CITY_AEAR_ID <", value, "originalCityAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdLessThanOrEqualTo(Long value) {
            addCriterion("ORIGINAL_CITY_AEAR_ID <=", value, "originalCityAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdIn(List<Long> values) {
            addCriterion("ORIGINAL_CITY_AEAR_ID in", values, "originalCityAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdNotIn(List<Long> values) {
            addCriterion("ORIGINAL_CITY_AEAR_ID not in", values, "originalCityAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdBetween(Long value1, Long value2) {
            addCriterion("ORIGINAL_CITY_AEAR_ID between", value1, value2, "originalCityAearId");
            return (Criteria) this;
        }

        public Criteria andOriginalCityAearIdNotBetween(Long value1, Long value2) {
            addCriterion("ORIGINAL_CITY_AEAR_ID not between", value1, value2, "originalCityAearId");
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

        public Criteria andMoneyIsNull() {
            addCriterion("MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Float value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Float value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Float value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Float value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Float value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Float> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Float> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Float value1, Float value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Float value1, Float value2) {
            addCriterion("MONEY not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdIsNull() {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdIsNotNull() {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdEqualTo(Long value) {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID =", value, "destinationProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdNotEqualTo(Long value) {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID <>", value, "destinationProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdGreaterThan(Long value) {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID >", value, "destinationProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID >=", value, "destinationProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdLessThan(Long value) {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID <", value, "destinationProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdLessThanOrEqualTo(Long value) {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID <=", value, "destinationProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdIn(List<Long> values) {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID in", values, "destinationProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdNotIn(List<Long> values) {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID not in", values, "destinationProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdBetween(Long value1, Long value2) {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID between", value1, value2, "destinationProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationProvinceAearIdNotBetween(Long value1, Long value2) {
            addCriterion("DESTINATION_PROVINCE_AEAR_ID not between", value1, value2, "destinationProvinceAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdIsNull() {
            addCriterion("DESTINATION_CITY_AEAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdIsNotNull() {
            addCriterion("DESTINATION_CITY_AEAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdEqualTo(Long value) {
            addCriterion("DESTINATION_CITY_AEAR_ID =", value, "destinationCityAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdNotEqualTo(Long value) {
            addCriterion("DESTINATION_CITY_AEAR_ID <>", value, "destinationCityAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdGreaterThan(Long value) {
            addCriterion("DESTINATION_CITY_AEAR_ID >", value, "destinationCityAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DESTINATION_CITY_AEAR_ID >=", value, "destinationCityAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdLessThan(Long value) {
            addCriterion("DESTINATION_CITY_AEAR_ID <", value, "destinationCityAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdLessThanOrEqualTo(Long value) {
            addCriterion("DESTINATION_CITY_AEAR_ID <=", value, "destinationCityAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdIn(List<Long> values) {
            addCriterion("DESTINATION_CITY_AEAR_ID in", values, "destinationCityAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdNotIn(List<Long> values) {
            addCriterion("DESTINATION_CITY_AEAR_ID not in", values, "destinationCityAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdBetween(Long value1, Long value2) {
            addCriterion("DESTINATION_CITY_AEAR_ID between", value1, value2, "destinationCityAearId");
            return (Criteria) this;
        }

        public Criteria andDestinationCityAearIdNotBetween(Long value1, Long value2) {
            addCriterion("DESTINATION_CITY_AEAR_ID not between", value1, value2, "destinationCityAearId");
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