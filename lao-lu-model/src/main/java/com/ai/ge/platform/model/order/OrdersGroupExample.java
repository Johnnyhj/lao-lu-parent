package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersGroupExample() {
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

        public Criteria andOrdersGroupIdIsNull() {
            addCriterion("ORDERS_GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdIsNotNull() {
            addCriterion("ORDERS_GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdEqualTo(Long value) {
            addCriterion("ORDERS_GROUP_ID =", value, "ordersGroupId");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdNotEqualTo(Long value) {
            addCriterion("ORDERS_GROUP_ID <>", value, "ordersGroupId");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdGreaterThan(Long value) {
            addCriterion("ORDERS_GROUP_ID >", value, "ordersGroupId");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDERS_GROUP_ID >=", value, "ordersGroupId");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdLessThan(Long value) {
            addCriterion("ORDERS_GROUP_ID <", value, "ordersGroupId");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("ORDERS_GROUP_ID <=", value, "ordersGroupId");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdIn(List<Long> values) {
            addCriterion("ORDERS_GROUP_ID in", values, "ordersGroupId");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdNotIn(List<Long> values) {
            addCriterion("ORDERS_GROUP_ID not in", values, "ordersGroupId");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdBetween(Long value1, Long value2) {
            addCriterion("ORDERS_GROUP_ID between", value1, value2, "ordersGroupId");
            return (Criteria) this;
        }

        public Criteria andOrdersGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("ORDERS_GROUP_ID not between", value1, value2, "ordersGroupId");
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

        public Criteria andCustIdEqualTo(Long value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Long value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Long value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Long value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Long value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Long> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Long> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Long value1, Long value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Long value1, Long value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupIsNull() {
            addCriterion("ORDER_SEQ_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupIsNotNull() {
            addCriterion("ORDER_SEQ_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupEqualTo(String value) {
            addCriterion("ORDER_SEQ_GROUP =", value, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupNotEqualTo(String value) {
            addCriterion("ORDER_SEQ_GROUP <>", value, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupGreaterThan(String value) {
            addCriterion("ORDER_SEQ_GROUP >", value, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_SEQ_GROUP >=", value, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupLessThan(String value) {
            addCriterion("ORDER_SEQ_GROUP <", value, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupLessThanOrEqualTo(String value) {
            addCriterion("ORDER_SEQ_GROUP <=", value, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupLike(String value) {
            addCriterion("ORDER_SEQ_GROUP like", value, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupNotLike(String value) {
            addCriterion("ORDER_SEQ_GROUP not like", value, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupIn(List<String> values) {
            addCriterion("ORDER_SEQ_GROUP in", values, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupNotIn(List<String> values) {
            addCriterion("ORDER_SEQ_GROUP not in", values, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupBetween(String value1, String value2) {
            addCriterion("ORDER_SEQ_GROUP between", value1, value2, "orderSeqGroup");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGroupNotBetween(String value1, String value2) {
            addCriterion("ORDER_SEQ_GROUP not between", value1, value2, "orderSeqGroup");
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

        public Criteria andOrderMoneyIsNull() {
            addCriterion("ORDER_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIsNotNull() {
            addCriterion("ORDER_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyEqualTo(Float value) {
            addCriterion("ORDER_MONEY =", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotEqualTo(Float value) {
            addCriterion("ORDER_MONEY <>", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThan(Float value) {
            addCriterion("ORDER_MONEY >", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("ORDER_MONEY >=", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThan(Float value) {
            addCriterion("ORDER_MONEY <", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThanOrEqualTo(Float value) {
            addCriterion("ORDER_MONEY <=", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIn(List<Float> values) {
            addCriterion("ORDER_MONEY in", values, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotIn(List<Float> values) {
            addCriterion("ORDER_MONEY not in", values, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyBetween(Float value1, Float value2) {
            addCriterion("ORDER_MONEY between", value1, value2, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotBetween(Float value1, Float value2) {
            addCriterion("ORDER_MONEY not between", value1, value2, "orderMoney");
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