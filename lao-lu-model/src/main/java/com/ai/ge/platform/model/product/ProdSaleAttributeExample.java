package com.ai.ge.platform.model.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdSaleAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProdSaleAttributeExample() {
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

        public Criteria andSaleCombiAttrIsNull() {
            addCriterion("SALE_COMBI_ATTR is null");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrIsNotNull() {
            addCriterion("SALE_COMBI_ATTR is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrEqualTo(String value) {
            addCriterion("SALE_COMBI_ATTR =", value, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrNotEqualTo(String value) {
            addCriterion("SALE_COMBI_ATTR <>", value, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrGreaterThan(String value) {
            addCriterion("SALE_COMBI_ATTR >", value, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_COMBI_ATTR >=", value, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrLessThan(String value) {
            addCriterion("SALE_COMBI_ATTR <", value, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrLessThanOrEqualTo(String value) {
            addCriterion("SALE_COMBI_ATTR <=", value, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrLike(String value) {
            addCriterion("SALE_COMBI_ATTR like", value, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrNotLike(String value) {
            addCriterion("SALE_COMBI_ATTR not like", value, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrIn(List<String> values) {
            addCriterion("SALE_COMBI_ATTR in", values, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrNotIn(List<String> values) {
            addCriterion("SALE_COMBI_ATTR not in", values, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrBetween(String value1, String value2) {
            addCriterion("SALE_COMBI_ATTR between", value1, value2, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andSaleCombiAttrNotBetween(String value1, String value2) {
            addCriterion("SALE_COMBI_ATTR not between", value1, value2, "saleCombiAttr");
            return (Criteria) this;
        }

        public Criteria andProdStockNumIsNull() {
            addCriterion("PROD_STOCK_NUM is null");
            return (Criteria) this;
        }

        public Criteria andProdStockNumIsNotNull() {
            addCriterion("PROD_STOCK_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andProdStockNumEqualTo(Long value) {
            addCriterion("PROD_STOCK_NUM =", value, "prodStockNum");
            return (Criteria) this;
        }

        public Criteria andProdStockNumNotEqualTo(Long value) {
            addCriterion("PROD_STOCK_NUM <>", value, "prodStockNum");
            return (Criteria) this;
        }

        public Criteria andProdStockNumGreaterThan(Long value) {
            addCriterion("PROD_STOCK_NUM >", value, "prodStockNum");
            return (Criteria) this;
        }

        public Criteria andProdStockNumGreaterThanOrEqualTo(Long value) {
            addCriterion("PROD_STOCK_NUM >=", value, "prodStockNum");
            return (Criteria) this;
        }

        public Criteria andProdStockNumLessThan(Long value) {
            addCriterion("PROD_STOCK_NUM <", value, "prodStockNum");
            return (Criteria) this;
        }

        public Criteria andProdStockNumLessThanOrEqualTo(Long value) {
            addCriterion("PROD_STOCK_NUM <=", value, "prodStockNum");
            return (Criteria) this;
        }

        public Criteria andProdStockNumIn(List<Long> values) {
            addCriterion("PROD_STOCK_NUM in", values, "prodStockNum");
            return (Criteria) this;
        }

        public Criteria andProdStockNumNotIn(List<Long> values) {
            addCriterion("PROD_STOCK_NUM not in", values, "prodStockNum");
            return (Criteria) this;
        }

        public Criteria andProdStockNumBetween(Long value1, Long value2) {
            addCriterion("PROD_STOCK_NUM between", value1, value2, "prodStockNum");
            return (Criteria) this;
        }

        public Criteria andProdStockNumNotBetween(Long value1, Long value2) {
            addCriterion("PROD_STOCK_NUM not between", value1, value2, "prodStockNum");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnIsNull() {
            addCriterion("PROD_STOCK_WARN is null");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnIsNotNull() {
            addCriterion("PROD_STOCK_WARN is not null");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnEqualTo(Long value) {
            addCriterion("PROD_STOCK_WARN =", value, "prodStockWarn");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnNotEqualTo(Long value) {
            addCriterion("PROD_STOCK_WARN <>", value, "prodStockWarn");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnGreaterThan(Long value) {
            addCriterion("PROD_STOCK_WARN >", value, "prodStockWarn");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnGreaterThanOrEqualTo(Long value) {
            addCriterion("PROD_STOCK_WARN >=", value, "prodStockWarn");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnLessThan(Long value) {
            addCriterion("PROD_STOCK_WARN <", value, "prodStockWarn");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnLessThanOrEqualTo(Long value) {
            addCriterion("PROD_STOCK_WARN <=", value, "prodStockWarn");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnIn(List<Long> values) {
            addCriterion("PROD_STOCK_WARN in", values, "prodStockWarn");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnNotIn(List<Long> values) {
            addCriterion("PROD_STOCK_WARN not in", values, "prodStockWarn");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnBetween(Long value1, Long value2) {
            addCriterion("PROD_STOCK_WARN between", value1, value2, "prodStockWarn");
            return (Criteria) this;
        }

        public Criteria andProdStockWarnNotBetween(Long value1, Long value2) {
            addCriterion("PROD_STOCK_WARN not between", value1, value2, "prodStockWarn");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("PRICE not between", value1, value2, "price");
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