package com.ai.ge.platform.model.product;

import java.util.ArrayList;
import java.util.List;

public class ParaDiscreteValueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParaDiscreteValueExample() {
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

        public Criteria andParaSpecIdIsNull() {
            addCriterion("PARA_SPEC_ID is null");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdIsNotNull() {
            addCriterion("PARA_SPEC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdEqualTo(Long value) {
            addCriterion("PARA_SPEC_ID =", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdNotEqualTo(Long value) {
            addCriterion("PARA_SPEC_ID <>", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdGreaterThan(Long value) {
            addCriterion("PARA_SPEC_ID >", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARA_SPEC_ID >=", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdLessThan(Long value) {
            addCriterion("PARA_SPEC_ID <", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdLessThanOrEqualTo(Long value) {
            addCriterion("PARA_SPEC_ID <=", value, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdIn(List<Long> values) {
            addCriterion("PARA_SPEC_ID in", values, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdNotIn(List<Long> values) {
            addCriterion("PARA_SPEC_ID not in", values, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdBetween(Long value1, Long value2) {
            addCriterion("PARA_SPEC_ID between", value1, value2, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParaSpecIdNotBetween(Long value1, Long value2) {
            addCriterion("PARA_SPEC_ID not between", value1, value2, "paraSpecId");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdIsNull() {
            addCriterion("PAR_PARA_SPEC_ID is null");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdIsNotNull() {
            addCriterion("PAR_PARA_SPEC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdEqualTo(Long value) {
            addCriterion("PAR_PARA_SPEC_ID =", value, "parParaSpecId");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdNotEqualTo(Long value) {
            addCriterion("PAR_PARA_SPEC_ID <>", value, "parParaSpecId");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdGreaterThan(Long value) {
            addCriterion("PAR_PARA_SPEC_ID >", value, "parParaSpecId");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PAR_PARA_SPEC_ID >=", value, "parParaSpecId");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdLessThan(Long value) {
            addCriterion("PAR_PARA_SPEC_ID <", value, "parParaSpecId");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdLessThanOrEqualTo(Long value) {
            addCriterion("PAR_PARA_SPEC_ID <=", value, "parParaSpecId");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdIn(List<Long> values) {
            addCriterion("PAR_PARA_SPEC_ID in", values, "parParaSpecId");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdNotIn(List<Long> values) {
            addCriterion("PAR_PARA_SPEC_ID not in", values, "parParaSpecId");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdBetween(Long value1, Long value2) {
            addCriterion("PAR_PARA_SPEC_ID between", value1, value2, "parParaSpecId");
            return (Criteria) this;
        }

        public Criteria andParParaSpecIdNotBetween(Long value1, Long value2) {
            addCriterion("PAR_PARA_SPEC_ID not between", value1, value2, "parParaSpecId");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueIsNull() {
            addCriterion("DISCRETE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueIsNotNull() {
            addCriterion("DISCRETE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueEqualTo(Integer value) {
            addCriterion("DISCRETE_VALUE =", value, "discreteValue");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueNotEqualTo(Integer value) {
            addCriterion("DISCRETE_VALUE <>", value, "discreteValue");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueGreaterThan(Integer value) {
            addCriterion("DISCRETE_VALUE >", value, "discreteValue");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("DISCRETE_VALUE >=", value, "discreteValue");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueLessThan(Integer value) {
            addCriterion("DISCRETE_VALUE <", value, "discreteValue");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueLessThanOrEqualTo(Integer value) {
            addCriterion("DISCRETE_VALUE <=", value, "discreteValue");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueIn(List<Integer> values) {
            addCriterion("DISCRETE_VALUE in", values, "discreteValue");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueNotIn(List<Integer> values) {
            addCriterion("DISCRETE_VALUE not in", values, "discreteValue");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueBetween(Integer value1, Integer value2) {
            addCriterion("DISCRETE_VALUE between", value1, value2, "discreteValue");
            return (Criteria) this;
        }

        public Criteria andDiscreteValueNotBetween(Integer value1, Integer value2) {
            addCriterion("DISCRETE_VALUE not between", value1, value2, "discreteValue");
            return (Criteria) this;
        }

        public Criteria andDiscriptionIsNull() {
            addCriterion("DISCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDiscriptionIsNotNull() {
            addCriterion("DISCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDiscriptionEqualTo(String value) {
            addCriterion("DISCRIPTION =", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotEqualTo(String value) {
            addCriterion("DISCRIPTION <>", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionGreaterThan(String value) {
            addCriterion("DISCRIPTION >", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DISCRIPTION >=", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionLessThan(String value) {
            addCriterion("DISCRIPTION <", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionLessThanOrEqualTo(String value) {
            addCriterion("DISCRIPTION <=", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionLike(String value) {
            addCriterion("DISCRIPTION like", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotLike(String value) {
            addCriterion("DISCRIPTION not like", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionIn(List<String> values) {
            addCriterion("DISCRIPTION in", values, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotIn(List<String> values) {
            addCriterion("DISCRIPTION not in", values, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionBetween(String value1, String value2) {
            addCriterion("DISCRIPTION between", value1, value2, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotBetween(String value1, String value2) {
            addCriterion("DISCRIPTION not between", value1, value2, "discription");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Short value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Short value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Short value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Short value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Short value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Short value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Short> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Short> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Short value1, Short value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Short value1, Short value2) {
            addCriterion("SORT not between", value1, value2, "sort");
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