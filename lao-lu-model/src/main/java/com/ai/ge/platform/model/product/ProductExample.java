package com.ai.ge.platform.model.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProdNameIsNull() {
            addCriterion("PROD_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProdNameIsNotNull() {
            addCriterion("PROD_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProdNameEqualTo(String value) {
            addCriterion("PROD_NAME =", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotEqualTo(String value) {
            addCriterion("PROD_NAME <>", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameGreaterThan(String value) {
            addCriterion("PROD_NAME >", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_NAME >=", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLessThan(String value) {
            addCriterion("PROD_NAME <", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLessThanOrEqualTo(String value) {
            addCriterion("PROD_NAME <=", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLike(String value) {
            addCriterion("PROD_NAME like", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotLike(String value) {
            addCriterion("PROD_NAME not like", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameIn(List<String> values) {
            addCriterion("PROD_NAME in", values, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotIn(List<String> values) {
            addCriterion("PROD_NAME not in", values, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameBetween(String value1, String value2) {
            addCriterion("PROD_NAME between", value1, value2, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotBetween(String value1, String value2) {
            addCriterion("PROD_NAME not between", value1, value2, "prodName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
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

        public Criteria andOnTimeIsNull() {
            addCriterion("ON_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOnTimeIsNotNull() {
            addCriterion("ON_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOnTimeEqualTo(Date value) {
            addCriterion("ON_TIME =", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeNotEqualTo(Date value) {
            addCriterion("ON_TIME <>", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeGreaterThan(Date value) {
            addCriterion("ON_TIME >", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ON_TIME >=", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeLessThan(Date value) {
            addCriterion("ON_TIME <", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeLessThanOrEqualTo(Date value) {
            addCriterion("ON_TIME <=", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeIn(List<Date> values) {
            addCriterion("ON_TIME in", values, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeNotIn(List<Date> values) {
            addCriterion("ON_TIME not in", values, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeBetween(Date value1, Date value2) {
            addCriterion("ON_TIME between", value1, value2, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeNotBetween(Date value1, Date value2) {
            addCriterion("ON_TIME not between", value1, value2, "onTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeIsNull() {
            addCriterion("OFF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOffTimeIsNotNull() {
            addCriterion("OFF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOffTimeEqualTo(Date value) {
            addCriterion("OFF_TIME =", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeNotEqualTo(Date value) {
            addCriterion("OFF_TIME <>", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeGreaterThan(Date value) {
            addCriterion("OFF_TIME >", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OFF_TIME >=", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeLessThan(Date value) {
            addCriterion("OFF_TIME <", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeLessThanOrEqualTo(Date value) {
            addCriterion("OFF_TIME <=", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeIn(List<Date> values) {
            addCriterion("OFF_TIME in", values, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeNotIn(List<Date> values) {
            addCriterion("OFF_TIME not in", values, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeBetween(Date value1, Date value2) {
            addCriterion("OFF_TIME between", value1, value2, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeNotBetween(Date value1, Date value2) {
            addCriterion("OFF_TIME not between", value1, value2, "offTime");
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