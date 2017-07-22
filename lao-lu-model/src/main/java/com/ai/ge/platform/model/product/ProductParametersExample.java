package com.ai.ge.platform.model.product;

import java.util.ArrayList;
import java.util.List;

public class ProductParametersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductParametersExample() {
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

        public Criteria andProdIdIsNull() {
            addCriterion("PROD_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("PROD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(Long value) {
            addCriterion("PROD_ID =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(Long value) {
            addCriterion("PROD_ID <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(Long value) {
            addCriterion("PROD_ID >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROD_ID >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(Long value) {
            addCriterion("PROD_ID <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(Long value) {
            addCriterion("PROD_ID <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<Long> values) {
            addCriterion("PROD_ID in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<Long> values) {
            addCriterion("PROD_ID not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(Long value1, Long value2) {
            addCriterion("PROD_ID between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(Long value1, Long value2) {
            addCriterion("PROD_ID not between", value1, value2, "prodId");
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

        public Criteria andPNameIsNull() {
            addCriterion("P_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("P_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("P_NAME =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("P_NAME <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("P_NAME >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("P_NAME >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("P_NAME <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("P_NAME <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("P_NAME like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("P_NAME not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("P_NAME in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("P_NAME not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("P_NAME between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("P_NAME not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPValuesIsNull() {
            addCriterion("P_VALUES is null");
            return (Criteria) this;
        }

        public Criteria andPValuesIsNotNull() {
            addCriterion("P_VALUES is not null");
            return (Criteria) this;
        }

        public Criteria andPValuesEqualTo(String value) {
            addCriterion("P_VALUES =", value, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesNotEqualTo(String value) {
            addCriterion("P_VALUES <>", value, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesGreaterThan(String value) {
            addCriterion("P_VALUES >", value, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesGreaterThanOrEqualTo(String value) {
            addCriterion("P_VALUES >=", value, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesLessThan(String value) {
            addCriterion("P_VALUES <", value, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesLessThanOrEqualTo(String value) {
            addCriterion("P_VALUES <=", value, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesLike(String value) {
            addCriterion("P_VALUES like", value, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesNotLike(String value) {
            addCriterion("P_VALUES not like", value, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesIn(List<String> values) {
            addCriterion("P_VALUES in", values, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesNotIn(List<String> values) {
            addCriterion("P_VALUES not in", values, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesBetween(String value1, String value2) {
            addCriterion("P_VALUES between", value1, value2, "pValues");
            return (Criteria) this;
        }

        public Criteria andPValuesNotBetween(String value1, String value2) {
            addCriterion("P_VALUES not between", value1, value2, "pValues");
            return (Criteria) this;
        }

        public Criteria andIsImportIsNull() {
            addCriterion("IS_IMPORT is null");
            return (Criteria) this;
        }

        public Criteria andIsImportIsNotNull() {
            addCriterion("IS_IMPORT is not null");
            return (Criteria) this;
        }

        public Criteria andIsImportEqualTo(Short value) {
            addCriterion("IS_IMPORT =", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportNotEqualTo(Short value) {
            addCriterion("IS_IMPORT <>", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportGreaterThan(Short value) {
            addCriterion("IS_IMPORT >", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_IMPORT >=", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportLessThan(Short value) {
            addCriterion("IS_IMPORT <", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportLessThanOrEqualTo(Short value) {
            addCriterion("IS_IMPORT <=", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportIn(List<Short> values) {
            addCriterion("IS_IMPORT in", values, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportNotIn(List<Short> values) {
            addCriterion("IS_IMPORT not in", values, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportBetween(Short value1, Short value2) {
            addCriterion("IS_IMPORT between", value1, value2, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportNotBetween(Short value1, Short value2) {
            addCriterion("IS_IMPORT not between", value1, value2, "isImport");
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