package com.ai.ge.platform.model.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NumberInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NumberInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("NUMBER =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("NUMBER <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("NUMBER >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("NUMBER >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("NUMBER <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("NUMBER <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("NUMBER like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("NUMBER not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("NUMBER in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("NUMBER not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("NUMBER between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("NUMBER not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Short value) {
            addCriterion("LEVEL =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Short value) {
            addCriterion("LEVEL <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Short value) {
            addCriterion("LEVEL >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("LEVEL >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Short value) {
            addCriterion("LEVEL <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Short value) {
            addCriterion("LEVEL <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Short> values) {
            addCriterion("LEVEL in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Short> values) {
            addCriterion("LEVEL not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Short value1, Short value2) {
            addCriterion("LEVEL between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Short value1, Short value2) {
            addCriterion("LEVEL not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andProTypeIdIsNull() {
            addCriterion("PRO_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProTypeIdIsNotNull() {
            addCriterion("PRO_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeIdEqualTo(Long value) {
            addCriterion("PRO_TYPE_ID =", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdNotEqualTo(Long value) {
            addCriterion("PRO_TYPE_ID <>", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdGreaterThan(Long value) {
            addCriterion("PRO_TYPE_ID >", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PRO_TYPE_ID >=", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdLessThan(Long value) {
            addCriterion("PRO_TYPE_ID <", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("PRO_TYPE_ID <=", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdIn(List<Long> values) {
            addCriterion("PRO_TYPE_ID in", values, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdNotIn(List<Long> values) {
            addCriterion("PRO_TYPE_ID not in", values, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdBetween(Long value1, Long value2) {
            addCriterion("PRO_TYPE_ID between", value1, value2, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("PRO_TYPE_ID not between", value1, value2, "proTypeId");
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