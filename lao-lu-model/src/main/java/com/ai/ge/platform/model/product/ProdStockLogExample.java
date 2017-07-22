package com.ai.ge.platform.model.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdStockLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProdStockLogExample() {
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

        public Criteria andStockIdIsNull() {
            addCriterion("STOCK_ID is null");
            return (Criteria) this;
        }

        public Criteria andStockIdIsNotNull() {
            addCriterion("STOCK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStockIdEqualTo(Long value) {
            addCriterion("STOCK_ID =", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotEqualTo(Long value) {
            addCriterion("STOCK_ID <>", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThan(Long value) {
            addCriterion("STOCK_ID >", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThanOrEqualTo(Long value) {
            addCriterion("STOCK_ID >=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThan(Long value) {
            addCriterion("STOCK_ID <", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThanOrEqualTo(Long value) {
            addCriterion("STOCK_ID <=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdIn(List<Long> values) {
            addCriterion("STOCK_ID in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotIn(List<Long> values) {
            addCriterion("STOCK_ID not in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdBetween(Long value1, Long value2) {
            addCriterion("STOCK_ID between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotBetween(Long value1, Long value2) {
            addCriterion("STOCK_ID not between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdIsNull() {
            addCriterion("PROD_SALE_ATTR_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdIsNotNull() {
            addCriterion("PROD_SALE_ATTR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdEqualTo(Long value) {
            addCriterion("PROD_SALE_ATTR_ID =", value, "prodSaleAttrId");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdNotEqualTo(Long value) {
            addCriterion("PROD_SALE_ATTR_ID <>", value, "prodSaleAttrId");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdGreaterThan(Long value) {
            addCriterion("PROD_SALE_ATTR_ID >", value, "prodSaleAttrId");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROD_SALE_ATTR_ID >=", value, "prodSaleAttrId");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdLessThan(Long value) {
            addCriterion("PROD_SALE_ATTR_ID <", value, "prodSaleAttrId");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdLessThanOrEqualTo(Long value) {
            addCriterion("PROD_SALE_ATTR_ID <=", value, "prodSaleAttrId");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdIn(List<Long> values) {
            addCriterion("PROD_SALE_ATTR_ID in", values, "prodSaleAttrId");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdNotIn(List<Long> values) {
            addCriterion("PROD_SALE_ATTR_ID not in", values, "prodSaleAttrId");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdBetween(Long value1, Long value2) {
            addCriterion("PROD_SALE_ATTR_ID between", value1, value2, "prodSaleAttrId");
            return (Criteria) this;
        }

        public Criteria andProdSaleAttrIdNotBetween(Long value1, Long value2) {
            addCriterion("PROD_SALE_ATTR_ID not between", value1, value2, "prodSaleAttrId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
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

        public Criteria andInOutNumberIsNull() {
            addCriterion("IN_OUT_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andInOutNumberIsNotNull() {
            addCriterion("IN_OUT_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andInOutNumberEqualTo(Integer value) {
            addCriterion("IN_OUT_NUMBER =", value, "inOutNumber");
            return (Criteria) this;
        }

        public Criteria andInOutNumberNotEqualTo(Integer value) {
            addCriterion("IN_OUT_NUMBER <>", value, "inOutNumber");
            return (Criteria) this;
        }

        public Criteria andInOutNumberGreaterThan(Integer value) {
            addCriterion("IN_OUT_NUMBER >", value, "inOutNumber");
            return (Criteria) this;
        }

        public Criteria andInOutNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("IN_OUT_NUMBER >=", value, "inOutNumber");
            return (Criteria) this;
        }

        public Criteria andInOutNumberLessThan(Integer value) {
            addCriterion("IN_OUT_NUMBER <", value, "inOutNumber");
            return (Criteria) this;
        }

        public Criteria andInOutNumberLessThanOrEqualTo(Integer value) {
            addCriterion("IN_OUT_NUMBER <=", value, "inOutNumber");
            return (Criteria) this;
        }

        public Criteria andInOutNumberIn(List<Integer> values) {
            addCriterion("IN_OUT_NUMBER in", values, "inOutNumber");
            return (Criteria) this;
        }

        public Criteria andInOutNumberNotIn(List<Integer> values) {
            addCriterion("IN_OUT_NUMBER not in", values, "inOutNumber");
            return (Criteria) this;
        }

        public Criteria andInOutNumberBetween(Integer value1, Integer value2) {
            addCriterion("IN_OUT_NUMBER between", value1, value2, "inOutNumber");
            return (Criteria) this;
        }

        public Criteria andInOutNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("IN_OUT_NUMBER not between", value1, value2, "inOutNumber");
            return (Criteria) this;
        }

        public Criteria andActionTypeIsNull() {
            addCriterion("ACTION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andActionTypeIsNotNull() {
            addCriterion("ACTION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andActionTypeEqualTo(Integer value) {
            addCriterion("ACTION_TYPE =", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotEqualTo(Integer value) {
            addCriterion("ACTION_TYPE <>", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeGreaterThan(Integer value) {
            addCriterion("ACTION_TYPE >", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACTION_TYPE >=", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeLessThan(Integer value) {
            addCriterion("ACTION_TYPE <", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ACTION_TYPE <=", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeIn(List<Integer> values) {
            addCriterion("ACTION_TYPE in", values, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotIn(List<Integer> values) {
            addCriterion("ACTION_TYPE not in", values, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeBetween(Integer value1, Integer value2) {
            addCriterion("ACTION_TYPE between", value1, value2, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ACTION_TYPE not between", value1, value2, "actionType");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("MARK is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("MARK is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("MARK =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("MARK <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("MARK >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("MARK >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("MARK <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("MARK <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("MARK like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("MARK not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("MARK in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("MARK not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("MARK between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("MARK not between", value1, value2, "mark");
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