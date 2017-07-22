package com.ai.ge.platform.model.product;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductTypeExample() {
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

        public Criteria andProdTypeCdIsNull() {
            addCriterion("PROD_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdIsNotNull() {
            addCriterion("PROD_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdEqualTo(Long value) {
            addCriterion("PROD_TYPE_CD =", value, "prodTypeCd");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdNotEqualTo(Long value) {
            addCriterion("PROD_TYPE_CD <>", value, "prodTypeCd");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdGreaterThan(Long value) {
            addCriterion("PROD_TYPE_CD >", value, "prodTypeCd");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROD_TYPE_CD >=", value, "prodTypeCd");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdLessThan(Long value) {
            addCriterion("PROD_TYPE_CD <", value, "prodTypeCd");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdLessThanOrEqualTo(Long value) {
            addCriterion("PROD_TYPE_CD <=", value, "prodTypeCd");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdIn(List<Long> values) {
            addCriterion("PROD_TYPE_CD in", values, "prodTypeCd");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdNotIn(List<Long> values) {
            addCriterion("PROD_TYPE_CD not in", values, "prodTypeCd");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdBetween(Long value1, Long value2) {
            addCriterion("PROD_TYPE_CD between", value1, value2, "prodTypeCd");
            return (Criteria) this;
        }

        public Criteria andProdTypeCdNotBetween(Long value1, Long value2) {
            addCriterion("PROD_TYPE_CD not between", value1, value2, "prodTypeCd");
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

        public Criteria andParentTypeCdIsNull() {
            addCriterion("PARENT_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdIsNotNull() {
            addCriterion("PARENT_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdEqualTo(Long value) {
            addCriterion("PARENT_TYPE_CD =", value, "parentTypeCd");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdNotEqualTo(Long value) {
            addCriterion("PARENT_TYPE_CD <>", value, "parentTypeCd");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdGreaterThan(Long value) {
            addCriterion("PARENT_TYPE_CD >", value, "parentTypeCd");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARENT_TYPE_CD >=", value, "parentTypeCd");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdLessThan(Long value) {
            addCriterion("PARENT_TYPE_CD <", value, "parentTypeCd");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdLessThanOrEqualTo(Long value) {
            addCriterion("PARENT_TYPE_CD <=", value, "parentTypeCd");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdIn(List<Long> values) {
            addCriterion("PARENT_TYPE_CD in", values, "parentTypeCd");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdNotIn(List<Long> values) {
            addCriterion("PARENT_TYPE_CD not in", values, "parentTypeCd");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdBetween(Long value1, Long value2) {
            addCriterion("PARENT_TYPE_CD between", value1, value2, "parentTypeCd");
            return (Criteria) this;
        }

        public Criteria andParentTypeCdNotBetween(Long value1, Long value2) {
            addCriterion("PARENT_TYPE_CD not between", value1, value2, "parentTypeCd");
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

        public Criteria andTypeIconUrlIsNull() {
            addCriterion("TYPE_ICON_URL is null");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlIsNotNull() {
            addCriterion("TYPE_ICON_URL is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlEqualTo(String value) {
            addCriterion("TYPE_ICON_URL =", value, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlNotEqualTo(String value) {
            addCriterion("TYPE_ICON_URL <>", value, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlGreaterThan(String value) {
            addCriterion("TYPE_ICON_URL >", value, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_ICON_URL >=", value, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlLessThan(String value) {
            addCriterion("TYPE_ICON_URL <", value, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlLessThanOrEqualTo(String value) {
            addCriterion("TYPE_ICON_URL <=", value, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlLike(String value) {
            addCriterion("TYPE_ICON_URL like", value, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlNotLike(String value) {
            addCriterion("TYPE_ICON_URL not like", value, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlIn(List<String> values) {
            addCriterion("TYPE_ICON_URL in", values, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlNotIn(List<String> values) {
            addCriterion("TYPE_ICON_URL not in", values, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlBetween(String value1, String value2) {
            addCriterion("TYPE_ICON_URL between", value1, value2, "typeIconUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIconUrlNotBetween(String value1, String value2) {
            addCriterion("TYPE_ICON_URL not between", value1, value2, "typeIconUrl");
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