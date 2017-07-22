package com.ai.ge.platform.model.product;

import java.util.ArrayList;
import java.util.List;

public class ParaSpecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParaSpecExample() {
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

        public Criteria andDscTypeCdIsNull() {
            addCriterion("DSC_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdIsNotNull() {
            addCriterion("DSC_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdEqualTo(Integer value) {
            addCriterion("DSC_TYPE_CD =", value, "dscTypeCd");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdNotEqualTo(Integer value) {
            addCriterion("DSC_TYPE_CD <>", value, "dscTypeCd");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdGreaterThan(Integer value) {
            addCriterion("DSC_TYPE_CD >", value, "dscTypeCd");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DSC_TYPE_CD >=", value, "dscTypeCd");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdLessThan(Integer value) {
            addCriterion("DSC_TYPE_CD <", value, "dscTypeCd");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdLessThanOrEqualTo(Integer value) {
            addCriterion("DSC_TYPE_CD <=", value, "dscTypeCd");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdIn(List<Integer> values) {
            addCriterion("DSC_TYPE_CD in", values, "dscTypeCd");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdNotIn(List<Integer> values) {
            addCriterion("DSC_TYPE_CD not in", values, "dscTypeCd");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdBetween(Integer value1, Integer value2) {
            addCriterion("DSC_TYPE_CD between", value1, value2, "dscTypeCd");
            return (Criteria) this;
        }

        public Criteria andDscTypeCdNotBetween(Integer value1, Integer value2) {
            addCriterion("DSC_TYPE_CD not between", value1, value2, "dscTypeCd");
            return (Criteria) this;
        }

        public Criteria andDscDataCdIsNull() {
            addCriterion("DSC_DATA_CD is null");
            return (Criteria) this;
        }

        public Criteria andDscDataCdIsNotNull() {
            addCriterion("DSC_DATA_CD is not null");
            return (Criteria) this;
        }

        public Criteria andDscDataCdEqualTo(Integer value) {
            addCriterion("DSC_DATA_CD =", value, "dscDataCd");
            return (Criteria) this;
        }

        public Criteria andDscDataCdNotEqualTo(Integer value) {
            addCriterion("DSC_DATA_CD <>", value, "dscDataCd");
            return (Criteria) this;
        }

        public Criteria andDscDataCdGreaterThan(Integer value) {
            addCriterion("DSC_DATA_CD >", value, "dscDataCd");
            return (Criteria) this;
        }

        public Criteria andDscDataCdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DSC_DATA_CD >=", value, "dscDataCd");
            return (Criteria) this;
        }

        public Criteria andDscDataCdLessThan(Integer value) {
            addCriterion("DSC_DATA_CD <", value, "dscDataCd");
            return (Criteria) this;
        }

        public Criteria andDscDataCdLessThanOrEqualTo(Integer value) {
            addCriterion("DSC_DATA_CD <=", value, "dscDataCd");
            return (Criteria) this;
        }

        public Criteria andDscDataCdIn(List<Integer> values) {
            addCriterion("DSC_DATA_CD in", values, "dscDataCd");
            return (Criteria) this;
        }

        public Criteria andDscDataCdNotIn(List<Integer> values) {
            addCriterion("DSC_DATA_CD not in", values, "dscDataCd");
            return (Criteria) this;
        }

        public Criteria andDscDataCdBetween(Integer value1, Integer value2) {
            addCriterion("DSC_DATA_CD between", value1, value2, "dscDataCd");
            return (Criteria) this;
        }

        public Criteria andDscDataCdNotBetween(Integer value1, Integer value2) {
            addCriterion("DSC_DATA_CD not between", value1, value2, "dscDataCd");
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