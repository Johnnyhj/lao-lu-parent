package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOrderDescribeIsNull() {
            addCriterion("ORDER_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeIsNotNull() {
            addCriterion("ORDER_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeEqualTo(String value) {
            addCriterion("ORDER_DESCRIBE =", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeNotEqualTo(String value) {
            addCriterion("ORDER_DESCRIBE <>", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeGreaterThan(String value) {
            addCriterion("ORDER_DESCRIBE >", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_DESCRIBE >=", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeLessThan(String value) {
            addCriterion("ORDER_DESCRIBE <", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_DESCRIBE <=", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeLike(String value) {
            addCriterion("ORDER_DESCRIBE like", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeNotLike(String value) {
            addCriterion("ORDER_DESCRIBE not like", value, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeIn(List<String> values) {
            addCriterion("ORDER_DESCRIBE in", values, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeNotIn(List<String> values) {
            addCriterion("ORDER_DESCRIBE not in", values, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeBetween(String value1, String value2) {
            addCriterion("ORDER_DESCRIBE between", value1, value2, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderDescribeNotBetween(String value1, String value2) {
            addCriterion("ORDER_DESCRIBE not between", value1, value2, "orderDescribe");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("CUSTOMER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("CUSTOMER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("CUSTOMER_NAME =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("CUSTOMER_NAME <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("CUSTOMER_NAME >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_NAME >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("CUSTOMER_NAME <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_NAME <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("CUSTOMER_NAME like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("CUSTOMER_NAME not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("CUSTOMER_NAME in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("CUSTOMER_NAME not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("CUSTOMER_NAME between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_NAME not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNull() {
            addCriterion("CUSTOMER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNotNull() {
            addCriterion("CUSTOMER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneEqualTo(String value) {
            addCriterion("CUSTOMER_PHONE =", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotEqualTo(String value) {
            addCriterion("CUSTOMER_PHONE <>", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThan(String value) {
            addCriterion("CUSTOMER_PHONE >", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_PHONE >=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThan(String value) {
            addCriterion("CUSTOMER_PHONE <", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_PHONE <=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLike(String value) {
            addCriterion("CUSTOMER_PHONE like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotLike(String value) {
            addCriterion("CUSTOMER_PHONE not like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIn(List<String> values) {
            addCriterion("CUSTOMER_PHONE in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotIn(List<String> values) {
            addCriterion("CUSTOMER_PHONE not in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneBetween(String value1, String value2) {
            addCriterion("CUSTOMER_PHONE between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_PHONE not between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIsNull() {
            addCriterion("CUSTOMER_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIsNotNull() {
            addCriterion("CUSTOMER_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressEqualTo(String value) {
            addCriterion("CUSTOMER_ADDRESS =", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotEqualTo(String value) {
            addCriterion("CUSTOMER_ADDRESS <>", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressGreaterThan(String value) {
            addCriterion("CUSTOMER_ADDRESS >", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_ADDRESS >=", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLessThan(String value) {
            addCriterion("CUSTOMER_ADDRESS <", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_ADDRESS <=", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLike(String value) {
            addCriterion("CUSTOMER_ADDRESS like", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotLike(String value) {
            addCriterion("CUSTOMER_ADDRESS not like", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIn(List<String> values) {
            addCriterion("CUSTOMER_ADDRESS in", values, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotIn(List<String> values) {
            addCriterion("CUSTOMER_ADDRESS not in", values, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressBetween(String value1, String value2) {
            addCriterion("CUSTOMER_ADDRESS between", value1, value2, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_ADDRESS not between", value1, value2, "customerAddress");
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

        public Criteria andTelPhoneIsNull() {
            addCriterion("TEL_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andTelPhoneIsNotNull() {
            addCriterion("TEL_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTelPhoneEqualTo(String value) {
            addCriterion("TEL_PHONE =", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneNotEqualTo(String value) {
            addCriterion("TEL_PHONE <>", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneGreaterThan(String value) {
            addCriterion("TEL_PHONE >", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("TEL_PHONE >=", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneLessThan(String value) {
            addCriterion("TEL_PHONE <", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneLessThanOrEqualTo(String value) {
            addCriterion("TEL_PHONE <=", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneLike(String value) {
            addCriterion("TEL_PHONE like", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneNotLike(String value) {
            addCriterion("TEL_PHONE not like", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneIn(List<String> values) {
            addCriterion("TEL_PHONE in", values, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneNotIn(List<String> values) {
            addCriterion("TEL_PHONE not in", values, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneBetween(String value1, String value2) {
            addCriterion("TEL_PHONE between", value1, value2, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneNotBetween(String value1, String value2) {
            addCriterion("TEL_PHONE not between", value1, value2, "telPhone");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIsNull() {
            addCriterion("LOAN_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIsNotNull() {
            addCriterion("LOAN_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyEqualTo(Float value) {
            addCriterion("LOAN_MONEY =", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotEqualTo(Float value) {
            addCriterion("LOAN_MONEY <>", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyGreaterThan(Float value) {
            addCriterion("LOAN_MONEY >", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("LOAN_MONEY >=", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyLessThan(Float value) {
            addCriterion("LOAN_MONEY <", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyLessThanOrEqualTo(Float value) {
            addCriterion("LOAN_MONEY <=", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIn(List<Float> values) {
            addCriterion("LOAN_MONEY in", values, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotIn(List<Float> values) {
            addCriterion("LOAN_MONEY not in", values, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyBetween(Float value1, Float value2) {
            addCriterion("LOAN_MONEY between", value1, value2, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotBetween(Float value1, Float value2) {
            addCriterion("LOAN_MONEY not between", value1, value2, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNull() {
            addCriterion("PAY_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNotNull() {
            addCriterion("PAY_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyEqualTo(Float value) {
            addCriterion("PAY_MONEY =", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotEqualTo(Float value) {
            addCriterion("PAY_MONEY <>", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThan(Float value) {
            addCriterion("PAY_MONEY >", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("PAY_MONEY >=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThan(Float value) {
            addCriterion("PAY_MONEY <", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThanOrEqualTo(Float value) {
            addCriterion("PAY_MONEY <=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIn(List<Float> values) {
            addCriterion("PAY_MONEY in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotIn(List<Float> values) {
            addCriterion("PAY_MONEY not in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyBetween(Float value1, Float value2) {
            addCriterion("PAY_MONEY between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotBetween(Float value1, Float value2) {
            addCriterion("PAY_MONEY not between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andLenderIdIsNull() {
            addCriterion("LENDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andLenderIdIsNotNull() {
            addCriterion("LENDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLenderIdEqualTo(Long value) {
            addCriterion("LENDER_ID =", value, "lenderId");
            return (Criteria) this;
        }

        public Criteria andLenderIdNotEqualTo(Long value) {
            addCriterion("LENDER_ID <>", value, "lenderId");
            return (Criteria) this;
        }

        public Criteria andLenderIdGreaterThan(Long value) {
            addCriterion("LENDER_ID >", value, "lenderId");
            return (Criteria) this;
        }

        public Criteria andLenderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LENDER_ID >=", value, "lenderId");
            return (Criteria) this;
        }

        public Criteria andLenderIdLessThan(Long value) {
            addCriterion("LENDER_ID <", value, "lenderId");
            return (Criteria) this;
        }

        public Criteria andLenderIdLessThanOrEqualTo(Long value) {
            addCriterion("LENDER_ID <=", value, "lenderId");
            return (Criteria) this;
        }

        public Criteria andLenderIdIn(List<Long> values) {
            addCriterion("LENDER_ID in", values, "lenderId");
            return (Criteria) this;
        }

        public Criteria andLenderIdNotIn(List<Long> values) {
            addCriterion("LENDER_ID not in", values, "lenderId");
            return (Criteria) this;
        }

        public Criteria andLenderIdBetween(Long value1, Long value2) {
            addCriterion("LENDER_ID between", value1, value2, "lenderId");
            return (Criteria) this;
        }

        public Criteria andLenderIdNotBetween(Long value1, Long value2) {
            addCriterion("LENDER_ID not between", value1, value2, "lenderId");
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

        public Criteria andCertNoIsNull() {
            addCriterion("CERT_NO is null");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNotNull() {
            addCriterion("CERT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCertNoEqualTo(String value) {
            addCriterion("CERT_NO =", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotEqualTo(String value) {
            addCriterion("CERT_NO <>", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThan(String value) {
            addCriterion("CERT_NO >", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_NO >=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThan(String value) {
            addCriterion("CERT_NO <", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThanOrEqualTo(String value) {
            addCriterion("CERT_NO <=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLike(String value) {
            addCriterion("CERT_NO like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotLike(String value) {
            addCriterion("CERT_NO not like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoIn(List<String> values) {
            addCriterion("CERT_NO in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotIn(List<String> values) {
            addCriterion("CERT_NO not in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoBetween(String value1, String value2) {
            addCriterion("CERT_NO between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotBetween(String value1, String value2) {
            addCriterion("CERT_NO not between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueIsNull() {
            addCriterion("CERT_TYPE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueIsNotNull() {
            addCriterion("CERT_TYPE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueEqualTo(String value) {
            addCriterion("CERT_TYPE_VALUE =", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueNotEqualTo(String value) {
            addCriterion("CERT_TYPE_VALUE <>", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueGreaterThan(String value) {
            addCriterion("CERT_TYPE_VALUE >", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE_VALUE >=", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueLessThan(String value) {
            addCriterion("CERT_TYPE_VALUE <", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueLessThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE_VALUE <=", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueLike(String value) {
            addCriterion("CERT_TYPE_VALUE like", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueNotLike(String value) {
            addCriterion("CERT_TYPE_VALUE not like", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueIn(List<String> values) {
            addCriterion("CERT_TYPE_VALUE in", values, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueNotIn(List<String> values) {
            addCriterion("CERT_TYPE_VALUE not in", values, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueBetween(String value1, String value2) {
            addCriterion("CERT_TYPE_VALUE between", value1, value2, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueNotBetween(String value1, String value2) {
            addCriterion("CERT_TYPE_VALUE not between", value1, value2, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andOlNbrIsNull() {
            addCriterion("OL_NBR is null");
            return (Criteria) this;
        }

        public Criteria andOlNbrIsNotNull() {
            addCriterion("OL_NBR is not null");
            return (Criteria) this;
        }

        public Criteria andOlNbrEqualTo(String value) {
            addCriterion("OL_NBR =", value, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrNotEqualTo(String value) {
            addCriterion("OL_NBR <>", value, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrGreaterThan(String value) {
            addCriterion("OL_NBR >", value, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrGreaterThanOrEqualTo(String value) {
            addCriterion("OL_NBR >=", value, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrLessThan(String value) {
            addCriterion("OL_NBR <", value, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrLessThanOrEqualTo(String value) {
            addCriterion("OL_NBR <=", value, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrLike(String value) {
            addCriterion("OL_NBR like", value, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrNotLike(String value) {
            addCriterion("OL_NBR not like", value, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrIn(List<String> values) {
            addCriterion("OL_NBR in", values, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrNotIn(List<String> values) {
            addCriterion("OL_NBR not in", values, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrBetween(String value1, String value2) {
            addCriterion("OL_NBR between", value1, value2, "olNbr");
            return (Criteria) this;
        }

        public Criteria andOlNbrNotBetween(String value1, String value2) {
            addCriterion("OL_NBR not between", value1, value2, "olNbr");
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