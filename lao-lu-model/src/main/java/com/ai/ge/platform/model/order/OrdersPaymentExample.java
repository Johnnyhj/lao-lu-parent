package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersPaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersPaymentExample() {
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

        public Criteria andPaymentIdIsNull() {
            addCriterion("PAYMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("PAYMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdEqualTo(Long value) {
            addCriterion("PAYMENT_ID =", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotEqualTo(Long value) {
            addCriterion("PAYMENT_ID <>", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThan(Long value) {
            addCriterion("PAYMENT_ID >", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PAYMENT_ID >=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThan(Long value) {
            addCriterion("PAYMENT_ID <", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThanOrEqualTo(Long value) {
            addCriterion("PAYMENT_ID <=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIn(List<Long> values) {
            addCriterion("PAYMENT_ID in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotIn(List<Long> values) {
            addCriterion("PAYMENT_ID not in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdBetween(Long value1, Long value2) {
            addCriterion("PAYMENT_ID between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotBetween(Long value1, Long value2) {
            addCriterion("PAYMENT_ID not between", value1, value2, "paymentId");
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

        public Criteria andPackageIdIsNull() {
            addCriterion("PACKAGE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNotNull() {
            addCriterion("PACKAGE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPackageIdEqualTo(Long value) {
            addCriterion("PACKAGE_ID =", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotEqualTo(Long value) {
            addCriterion("PACKAGE_ID <>", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThan(Long value) {
            addCriterion("PACKAGE_ID >", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PACKAGE_ID >=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThan(Long value) {
            addCriterion("PACKAGE_ID <", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThanOrEqualTo(Long value) {
            addCriterion("PACKAGE_ID <=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdIn(List<Long> values) {
            addCriterion("PACKAGE_ID in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotIn(List<Long> values) {
            addCriterion("PACKAGE_ID not in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdBetween(Long value1, Long value2) {
            addCriterion("PACKAGE_ID between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotBetween(Long value1, Long value2) {
            addCriterion("PACKAGE_ID not between", value1, value2, "packageId");
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

        public Criteria andPaySeqIsNull() {
            addCriterion("PAY_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andPaySeqIsNotNull() {
            addCriterion("PAY_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andPaySeqEqualTo(String value) {
            addCriterion("PAY_SEQ =", value, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqNotEqualTo(String value) {
            addCriterion("PAY_SEQ <>", value, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqGreaterThan(String value) {
            addCriterion("PAY_SEQ >", value, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_SEQ >=", value, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqLessThan(String value) {
            addCriterion("PAY_SEQ <", value, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqLessThanOrEqualTo(String value) {
            addCriterion("PAY_SEQ <=", value, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqLike(String value) {
            addCriterion("PAY_SEQ like", value, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqNotLike(String value) {
            addCriterion("PAY_SEQ not like", value, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqIn(List<String> values) {
            addCriterion("PAY_SEQ in", values, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqNotIn(List<String> values) {
            addCriterion("PAY_SEQ not in", values, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqBetween(String value1, String value2) {
            addCriterion("PAY_SEQ between", value1, value2, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPaySeqNotBetween(String value1, String value2) {
            addCriterion("PAY_SEQ not between", value1, value2, "paySeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqIsNull() {
            addCriterion("PF_ORDER_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqIsNotNull() {
            addCriterion("PF_ORDER_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqEqualTo(String value) {
            addCriterion("PF_ORDER_SEQ =", value, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqNotEqualTo(String value) {
            addCriterion("PF_ORDER_SEQ <>", value, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqGreaterThan(String value) {
            addCriterion("PF_ORDER_SEQ >", value, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqGreaterThanOrEqualTo(String value) {
            addCriterion("PF_ORDER_SEQ >=", value, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqLessThan(String value) {
            addCriterion("PF_ORDER_SEQ <", value, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqLessThanOrEqualTo(String value) {
            addCriterion("PF_ORDER_SEQ <=", value, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqLike(String value) {
            addCriterion("PF_ORDER_SEQ like", value, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqNotLike(String value) {
            addCriterion("PF_ORDER_SEQ not like", value, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqIn(List<String> values) {
            addCriterion("PF_ORDER_SEQ in", values, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqNotIn(List<String> values) {
            addCriterion("PF_ORDER_SEQ not in", values, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqBetween(String value1, String value2) {
            addCriterion("PF_ORDER_SEQ between", value1, value2, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andPfOrderSeqNotBetween(String value1, String value2) {
            addCriterion("PF_ORDER_SEQ not between", value1, value2, "pfOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqIsNull() {
            addCriterion("REFUND_ORDER_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqIsNotNull() {
            addCriterion("REFUND_ORDER_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqEqualTo(String value) {
            addCriterion("REFUND_ORDER_SEQ =", value, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqNotEqualTo(String value) {
            addCriterion("REFUND_ORDER_SEQ <>", value, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqGreaterThan(String value) {
            addCriterion("REFUND_ORDER_SEQ >", value, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqGreaterThanOrEqualTo(String value) {
            addCriterion("REFUND_ORDER_SEQ >=", value, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqLessThan(String value) {
            addCriterion("REFUND_ORDER_SEQ <", value, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqLessThanOrEqualTo(String value) {
            addCriterion("REFUND_ORDER_SEQ <=", value, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqLike(String value) {
            addCriterion("REFUND_ORDER_SEQ like", value, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqNotLike(String value) {
            addCriterion("REFUND_ORDER_SEQ not like", value, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqIn(List<String> values) {
            addCriterion("REFUND_ORDER_SEQ in", values, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqNotIn(List<String> values) {
            addCriterion("REFUND_ORDER_SEQ not in", values, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqBetween(String value1, String value2) {
            addCriterion("REFUND_ORDER_SEQ between", value1, value2, "refundOrderSeq");
            return (Criteria) this;
        }

        public Criteria andRefundOrderSeqNotBetween(String value1, String value2) {
            addCriterion("REFUND_ORDER_SEQ not between", value1, value2, "refundOrderSeq");
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