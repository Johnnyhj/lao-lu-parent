package com.ai.ge.platform.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerShopCartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerShopCartExample() {
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

        public Criteria andScIdIsNull() {
            addCriterion("SC_ID is null");
            return (Criteria) this;
        }

        public Criteria andScIdIsNotNull() {
            addCriterion("SC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andScIdEqualTo(Long value) {
            addCriterion("SC_ID =", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdNotEqualTo(Long value) {
            addCriterion("SC_ID <>", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdGreaterThan(Long value) {
            addCriterion("SC_ID >", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SC_ID >=", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdLessThan(Long value) {
            addCriterion("SC_ID <", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdLessThanOrEqualTo(Long value) {
            addCriterion("SC_ID <=", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdIn(List<Long> values) {
            addCriterion("SC_ID in", values, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdNotIn(List<Long> values) {
            addCriterion("SC_ID not in", values, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdBetween(Long value1, Long value2) {
            addCriterion("SC_ID between", value1, value2, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdNotBetween(Long value1, Long value2) {
            addCriterion("SC_ID not between", value1, value2, "scId");
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

        public Criteria andScTypeIsNull() {
            addCriterion("SC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andScTypeIsNotNull() {
            addCriterion("SC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andScTypeEqualTo(Short value) {
            addCriterion("SC_TYPE =", value, "scType");
            return (Criteria) this;
        }

        public Criteria andScTypeNotEqualTo(Short value) {
            addCriterion("SC_TYPE <>", value, "scType");
            return (Criteria) this;
        }

        public Criteria andScTypeGreaterThan(Short value) {
            addCriterion("SC_TYPE >", value, "scType");
            return (Criteria) this;
        }

        public Criteria andScTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("SC_TYPE >=", value, "scType");
            return (Criteria) this;
        }

        public Criteria andScTypeLessThan(Short value) {
            addCriterion("SC_TYPE <", value, "scType");
            return (Criteria) this;
        }

        public Criteria andScTypeLessThanOrEqualTo(Short value) {
            addCriterion("SC_TYPE <=", value, "scType");
            return (Criteria) this;
        }

        public Criteria andScTypeIn(List<Short> values) {
            addCriterion("SC_TYPE in", values, "scType");
            return (Criteria) this;
        }

        public Criteria andScTypeNotIn(List<Short> values) {
            addCriterion("SC_TYPE not in", values, "scType");
            return (Criteria) this;
        }

        public Criteria andScTypeBetween(Short value1, Short value2) {
            addCriterion("SC_TYPE between", value1, value2, "scType");
            return (Criteria) this;
        }

        public Criteria andScTypeNotBetween(Short value1, Short value2) {
            addCriterion("SC_TYPE not between", value1, value2, "scType");
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