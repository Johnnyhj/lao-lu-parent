package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersLogExample() {
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

        public Criteria andOlIdIsNull() {
            addCriterion("OL_ID is null");
            return (Criteria) this;
        }

        public Criteria andOlIdIsNotNull() {
            addCriterion("OL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOlIdEqualTo(Long value) {
            addCriterion("OL_ID =", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotEqualTo(Long value) {
            addCriterion("OL_ID <>", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdGreaterThan(Long value) {
            addCriterion("OL_ID >", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OL_ID >=", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdLessThan(Long value) {
            addCriterion("OL_ID <", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdLessThanOrEqualTo(Long value) {
            addCriterion("OL_ID <=", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdIn(List<Long> values) {
            addCriterion("OL_ID in", values, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotIn(List<Long> values) {
            addCriterion("OL_ID not in", values, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdBetween(Long value1, Long value2) {
            addCriterion("OL_ID between", value1, value2, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotBetween(Long value1, Long value2) {
            addCriterion("OL_ID not between", value1, value2, "olId");
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

        public Criteria andOrdersOutIdIsNull() {
            addCriterion("ORDERS_OUT_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdIsNotNull() {
            addCriterion("ORDERS_OUT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdEqualTo(Long value) {
            addCriterion("ORDERS_OUT_ID =", value, "ordersOutId");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdNotEqualTo(Long value) {
            addCriterion("ORDERS_OUT_ID <>", value, "ordersOutId");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdGreaterThan(Long value) {
            addCriterion("ORDERS_OUT_ID >", value, "ordersOutId");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDERS_OUT_ID >=", value, "ordersOutId");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdLessThan(Long value) {
            addCriterion("ORDERS_OUT_ID <", value, "ordersOutId");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdLessThanOrEqualTo(Long value) {
            addCriterion("ORDERS_OUT_ID <=", value, "ordersOutId");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdIn(List<Long> values) {
            addCriterion("ORDERS_OUT_ID in", values, "ordersOutId");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdNotIn(List<Long> values) {
            addCriterion("ORDERS_OUT_ID not in", values, "ordersOutId");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdBetween(Long value1, Long value2) {
            addCriterion("ORDERS_OUT_ID between", value1, value2, "ordersOutId");
            return (Criteria) this;
        }

        public Criteria andOrdersOutIdNotBetween(Long value1, Long value2) {
            addCriterion("ORDERS_OUT_ID not between", value1, value2, "ordersOutId");
            return (Criteria) this;
        }

        public Criteria andProvidIdIsNull() {
            addCriterion("PROVID_ID is null");
            return (Criteria) this;
        }

        public Criteria andProvidIdIsNotNull() {
            addCriterion("PROVID_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProvidIdEqualTo(Long value) {
            addCriterion("PROVID_ID =", value, "providId");
            return (Criteria) this;
        }

        public Criteria andProvidIdNotEqualTo(Long value) {
            addCriterion("PROVID_ID <>", value, "providId");
            return (Criteria) this;
        }

        public Criteria andProvidIdGreaterThan(Long value) {
            addCriterion("PROVID_ID >", value, "providId");
            return (Criteria) this;
        }

        public Criteria andProvidIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROVID_ID >=", value, "providId");
            return (Criteria) this;
        }

        public Criteria andProvidIdLessThan(Long value) {
            addCriterion("PROVID_ID <", value, "providId");
            return (Criteria) this;
        }

        public Criteria andProvidIdLessThanOrEqualTo(Long value) {
            addCriterion("PROVID_ID <=", value, "providId");
            return (Criteria) this;
        }

        public Criteria andProvidIdIn(List<Long> values) {
            addCriterion("PROVID_ID in", values, "providId");
            return (Criteria) this;
        }

        public Criteria andProvidIdNotIn(List<Long> values) {
            addCriterion("PROVID_ID not in", values, "providId");
            return (Criteria) this;
        }

        public Criteria andProvidIdBetween(Long value1, Long value2) {
            addCriterion("PROVID_ID between", value1, value2, "providId");
            return (Criteria) this;
        }

        public Criteria andProvidIdNotBetween(Long value1, Long value2) {
            addCriterion("PROVID_ID not between", value1, value2, "providId");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIsNull() {
            addCriterion("ORDER_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIsNotNull() {
            addCriterion("ORDER_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSeqEqualTo(String value) {
            addCriterion("ORDER_SEQ =", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotEqualTo(String value) {
            addCriterion("ORDER_SEQ <>", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGreaterThan(String value) {
            addCriterion("ORDER_SEQ >", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_SEQ >=", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqLessThan(String value) {
            addCriterion("ORDER_SEQ <", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqLessThanOrEqualTo(String value) {
            addCriterion("ORDER_SEQ <=", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqLike(String value) {
            addCriterion("ORDER_SEQ like", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotLike(String value) {
            addCriterion("ORDER_SEQ not like", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIn(List<String> values) {
            addCriterion("ORDER_SEQ in", values, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotIn(List<String> values) {
            addCriterion("ORDER_SEQ not in", values, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqBetween(String value1, String value2) {
            addCriterion("ORDER_SEQ between", value1, value2, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotBetween(String value1, String value2) {
            addCriterion("ORDER_SEQ not between", value1, value2, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("QUANTITY =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("QUANTITY <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("QUANTITY >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("QUANTITY >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("QUANTITY <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("QUANTITY <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("QUANTITY in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("QUANTITY not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("QUANTITY between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("QUANTITY not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyIsNull() {
            addCriterion("ORDERS_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyIsNotNull() {
            addCriterion("ORDERS_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyEqualTo(Float value) {
            addCriterion("ORDERS_MONEY =", value, "ordersMoney");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyNotEqualTo(Float value) {
            addCriterion("ORDERS_MONEY <>", value, "ordersMoney");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyGreaterThan(Float value) {
            addCriterion("ORDERS_MONEY >", value, "ordersMoney");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("ORDERS_MONEY >=", value, "ordersMoney");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyLessThan(Float value) {
            addCriterion("ORDERS_MONEY <", value, "ordersMoney");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyLessThanOrEqualTo(Float value) {
            addCriterion("ORDERS_MONEY <=", value, "ordersMoney");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyIn(List<Float> values) {
            addCriterion("ORDERS_MONEY in", values, "ordersMoney");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyNotIn(List<Float> values) {
            addCriterion("ORDERS_MONEY not in", values, "ordersMoney");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyBetween(Float value1, Float value2) {
            addCriterion("ORDERS_MONEY between", value1, value2, "ordersMoney");
            return (Criteria) this;
        }

        public Criteria andOrdersMoneyNotBetween(Float value1, Float value2) {
            addCriterion("ORDERS_MONEY not between", value1, value2, "ordersMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyIsNull() {
            addCriterion("EXPRESS_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyIsNotNull() {
            addCriterion("EXPRESS_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyEqualTo(Float value) {
            addCriterion("EXPRESS_MONEY =", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotEqualTo(Float value) {
            addCriterion("EXPRESS_MONEY <>", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyGreaterThan(Float value) {
            addCriterion("EXPRESS_MONEY >", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("EXPRESS_MONEY >=", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyLessThan(Float value) {
            addCriterion("EXPRESS_MONEY <", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyLessThanOrEqualTo(Float value) {
            addCriterion("EXPRESS_MONEY <=", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyIn(List<Float> values) {
            addCriterion("EXPRESS_MONEY in", values, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotIn(List<Float> values) {
            addCriterion("EXPRESS_MONEY not in", values, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyBetween(Float value1, Float value2) {
            addCriterion("EXPRESS_MONEY between", value1, value2, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotBetween(Float value1, Float value2) {
            addCriterion("EXPRESS_MONEY not between", value1, value2, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("TOTAL_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("TOTAL_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(Float value) {
            addCriterion("TOTAL_MONEY =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(Float value) {
            addCriterion("TOTAL_MONEY <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(Float value) {
            addCriterion("TOTAL_MONEY >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("TOTAL_MONEY >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(Float value) {
            addCriterion("TOTAL_MONEY <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(Float value) {
            addCriterion("TOTAL_MONEY <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<Float> values) {
            addCriterion("TOTAL_MONEY in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<Float> values) {
            addCriterion("TOTAL_MONEY not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(Float value1, Float value2) {
            addCriterion("TOTAL_MONEY between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(Float value1, Float value2) {
            addCriterion("TOTAL_MONEY not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("CUST_ID like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("CUST_ID not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCeateTimeIsNull() {
            addCriterion("CEATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCeateTimeIsNotNull() {
            addCriterion("CEATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCeateTimeEqualTo(Date value) {
            addCriterion("CEATE_TIME =", value, "ceateTime");
            return (Criteria) this;
        }

        public Criteria andCeateTimeNotEqualTo(Date value) {
            addCriterion("CEATE_TIME <>", value, "ceateTime");
            return (Criteria) this;
        }

        public Criteria andCeateTimeGreaterThan(Date value) {
            addCriterion("CEATE_TIME >", value, "ceateTime");
            return (Criteria) this;
        }

        public Criteria andCeateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CEATE_TIME >=", value, "ceateTime");
            return (Criteria) this;
        }

        public Criteria andCeateTimeLessThan(Date value) {
            addCriterion("CEATE_TIME <", value, "ceateTime");
            return (Criteria) this;
        }

        public Criteria andCeateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CEATE_TIME <=", value, "ceateTime");
            return (Criteria) this;
        }

        public Criteria andCeateTimeIn(List<Date> values) {
            addCriterion("CEATE_TIME in", values, "ceateTime");
            return (Criteria) this;
        }

        public Criteria andCeateTimeNotIn(List<Date> values) {
            addCriterion("CEATE_TIME not in", values, "ceateTime");
            return (Criteria) this;
        }

        public Criteria andCeateTimeBetween(Date value1, Date value2) {
            addCriterion("CEATE_TIME between", value1, value2, "ceateTime");
            return (Criteria) this;
        }

        public Criteria andCeateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CEATE_TIME not between", value1, value2, "ceateTime");
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

        public Criteria andCustmNameIsNull() {
            addCriterion("CUSTM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustmNameIsNotNull() {
            addCriterion("CUSTM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustmNameEqualTo(String value) {
            addCriterion("CUSTM_NAME =", value, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameNotEqualTo(String value) {
            addCriterion("CUSTM_NAME <>", value, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameGreaterThan(String value) {
            addCriterion("CUSTM_NAME >", value, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTM_NAME >=", value, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameLessThan(String value) {
            addCriterion("CUSTM_NAME <", value, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameLessThanOrEqualTo(String value) {
            addCriterion("CUSTM_NAME <=", value, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameLike(String value) {
            addCriterion("CUSTM_NAME like", value, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameNotLike(String value) {
            addCriterion("CUSTM_NAME not like", value, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameIn(List<String> values) {
            addCriterion("CUSTM_NAME in", values, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameNotIn(List<String> values) {
            addCriterion("CUSTM_NAME not in", values, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameBetween(String value1, String value2) {
            addCriterion("CUSTM_NAME between", value1, value2, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmNameNotBetween(String value1, String value2) {
            addCriterion("CUSTM_NAME not between", value1, value2, "custmName");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneIsNull() {
            addCriterion("CUSTM_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneIsNotNull() {
            addCriterion("CUSTM_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneEqualTo(String value) {
            addCriterion("CUSTM_PHONE =", value, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneNotEqualTo(String value) {
            addCriterion("CUSTM_PHONE <>", value, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneGreaterThan(String value) {
            addCriterion("CUSTM_PHONE >", value, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTM_PHONE >=", value, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneLessThan(String value) {
            addCriterion("CUSTM_PHONE <", value, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneLessThanOrEqualTo(String value) {
            addCriterion("CUSTM_PHONE <=", value, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneLike(String value) {
            addCriterion("CUSTM_PHONE like", value, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneNotLike(String value) {
            addCriterion("CUSTM_PHONE not like", value, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneIn(List<String> values) {
            addCriterion("CUSTM_PHONE in", values, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneNotIn(List<String> values) {
            addCriterion("CUSTM_PHONE not in", values, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneBetween(String value1, String value2) {
            addCriterion("CUSTM_PHONE between", value1, value2, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmPhoneNotBetween(String value1, String value2) {
            addCriterion("CUSTM_PHONE not between", value1, value2, "custmPhone");
            return (Criteria) this;
        }

        public Criteria andCustmAddressIsNull() {
            addCriterion("CUSTM_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCustmAddressIsNotNull() {
            addCriterion("CUSTM_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCustmAddressEqualTo(String value) {
            addCriterion("CUSTM_ADDRESS =", value, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressNotEqualTo(String value) {
            addCriterion("CUSTM_ADDRESS <>", value, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressGreaterThan(String value) {
            addCriterion("CUSTM_ADDRESS >", value, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTM_ADDRESS >=", value, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressLessThan(String value) {
            addCriterion("CUSTM_ADDRESS <", value, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressLessThanOrEqualTo(String value) {
            addCriterion("CUSTM_ADDRESS <=", value, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressLike(String value) {
            addCriterion("CUSTM_ADDRESS like", value, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressNotLike(String value) {
            addCriterion("CUSTM_ADDRESS not like", value, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressIn(List<String> values) {
            addCriterion("CUSTM_ADDRESS in", values, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressNotIn(List<String> values) {
            addCriterion("CUSTM_ADDRESS not in", values, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressBetween(String value1, String value2) {
            addCriterion("CUSTM_ADDRESS between", value1, value2, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andCustmAddressNotBetween(String value1, String value2) {
            addCriterion("CUSTM_ADDRESS not between", value1, value2, "custmAddress");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Short value) {
            addCriterion("PAY_TYPE =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Short value) {
            addCriterion("PAY_TYPE <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Short value) {
            addCriterion("PAY_TYPE >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("PAY_TYPE >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Short value) {
            addCriterion("PAY_TYPE <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Short value) {
            addCriterion("PAY_TYPE <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Short> values) {
            addCriterion("PAY_TYPE in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Short> values) {
            addCriterion("PAY_TYPE not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Short value1, Short value2) {
            addCriterion("PAY_TYPE between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Short value1, Short value2) {
            addCriterion("PAY_TYPE not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNull() {
            addCriterion("PAY_NO is null");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNotNull() {
            addCriterion("PAY_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPayNoEqualTo(String value) {
            addCriterion("PAY_NO =", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotEqualTo(String value) {
            addCriterion("PAY_NO <>", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThan(String value) {
            addCriterion("PAY_NO >", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_NO >=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThan(String value) {
            addCriterion("PAY_NO <", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThanOrEqualTo(String value) {
            addCriterion("PAY_NO <=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLike(String value) {
            addCriterion("PAY_NO like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotLike(String value) {
            addCriterion("PAY_NO not like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoIn(List<String> values) {
            addCriterion("PAY_NO in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotIn(List<String> values) {
            addCriterion("PAY_NO not in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoBetween(String value1, String value2) {
            addCriterion("PAY_NO between", value1, value2, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotBetween(String value1, String value2) {
            addCriterion("PAY_NO not between", value1, value2, "payNo");
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