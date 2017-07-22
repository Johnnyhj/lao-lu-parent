package com.ai.ge.platform.model.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductPicsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductPicsExample() {
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

        public Criteria andProdPicsIdIsNull() {
            addCriterion("PROD_PICS_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdIsNotNull() {
            addCriterion("PROD_PICS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdEqualTo(Long value) {
            addCriterion("PROD_PICS_ID =", value, "prodPicsId");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdNotEqualTo(Long value) {
            addCriterion("PROD_PICS_ID <>", value, "prodPicsId");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdGreaterThan(Long value) {
            addCriterion("PROD_PICS_ID >", value, "prodPicsId");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROD_PICS_ID >=", value, "prodPicsId");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdLessThan(Long value) {
            addCriterion("PROD_PICS_ID <", value, "prodPicsId");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdLessThanOrEqualTo(Long value) {
            addCriterion("PROD_PICS_ID <=", value, "prodPicsId");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdIn(List<Long> values) {
            addCriterion("PROD_PICS_ID in", values, "prodPicsId");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdNotIn(List<Long> values) {
            addCriterion("PROD_PICS_ID not in", values, "prodPicsId");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdBetween(Long value1, Long value2) {
            addCriterion("PROD_PICS_ID between", value1, value2, "prodPicsId");
            return (Criteria) this;
        }

        public Criteria andProdPicsIdNotBetween(Long value1, Long value2) {
            addCriterion("PROD_PICS_ID not between", value1, value2, "prodPicsId");
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

        public Criteria andPicsUrlIsNull() {
            addCriterion("PICS_URL is null");
            return (Criteria) this;
        }

        public Criteria andPicsUrlIsNotNull() {
            addCriterion("PICS_URL is not null");
            return (Criteria) this;
        }

        public Criteria andPicsUrlEqualTo(String value) {
            addCriterion("PICS_URL =", value, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlNotEqualTo(String value) {
            addCriterion("PICS_URL <>", value, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlGreaterThan(String value) {
            addCriterion("PICS_URL >", value, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("PICS_URL >=", value, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlLessThan(String value) {
            addCriterion("PICS_URL <", value, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlLessThanOrEqualTo(String value) {
            addCriterion("PICS_URL <=", value, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlLike(String value) {
            addCriterion("PICS_URL like", value, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlNotLike(String value) {
            addCriterion("PICS_URL not like", value, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlIn(List<String> values) {
            addCriterion("PICS_URL in", values, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlNotIn(List<String> values) {
            addCriterion("PICS_URL not in", values, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlBetween(String value1, String value2) {
            addCriterion("PICS_URL between", value1, value2, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicsUrlNotBetween(String value1, String value2) {
            addCriterion("PICS_URL not between", value1, value2, "picsUrl");
            return (Criteria) this;
        }

        public Criteria andPicTypeIsNull() {
            addCriterion("PIC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPicTypeIsNotNull() {
            addCriterion("PIC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPicTypeEqualTo(Short value) {
            addCriterion("PIC_TYPE =", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeNotEqualTo(Short value) {
            addCriterion("PIC_TYPE <>", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeGreaterThan(Short value) {
            addCriterion("PIC_TYPE >", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("PIC_TYPE >=", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeLessThan(Short value) {
            addCriterion("PIC_TYPE <", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeLessThanOrEqualTo(Short value) {
            addCriterion("PIC_TYPE <=", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeIn(List<Short> values) {
            addCriterion("PIC_TYPE in", values, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeNotIn(List<Short> values) {
            addCriterion("PIC_TYPE not in", values, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeBetween(Short value1, Short value2) {
            addCriterion("PIC_TYPE between", value1, value2, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeNotBetween(Short value1, Short value2) {
            addCriterion("PIC_TYPE not between", value1, value2, "picType");
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

        public Criteria andPicOwnerUrlIsNull() {
            addCriterion("PIC_OWNER_URL is null");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlIsNotNull() {
            addCriterion("PIC_OWNER_URL is not null");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlEqualTo(String value) {
            addCriterion("PIC_OWNER_URL =", value, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlNotEqualTo(String value) {
            addCriterion("PIC_OWNER_URL <>", value, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlGreaterThan(String value) {
            addCriterion("PIC_OWNER_URL >", value, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("PIC_OWNER_URL >=", value, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlLessThan(String value) {
            addCriterion("PIC_OWNER_URL <", value, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlLessThanOrEqualTo(String value) {
            addCriterion("PIC_OWNER_URL <=", value, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlLike(String value) {
            addCriterion("PIC_OWNER_URL like", value, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlNotLike(String value) {
            addCriterion("PIC_OWNER_URL not like", value, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlIn(List<String> values) {
            addCriterion("PIC_OWNER_URL in", values, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlNotIn(List<String> values) {
            addCriterion("PIC_OWNER_URL not in", values, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlBetween(String value1, String value2) {
            addCriterion("PIC_OWNER_URL between", value1, value2, "picOwnerUrl");
            return (Criteria) this;
        }

        public Criteria andPicOwnerUrlNotBetween(String value1, String value2) {
            addCriterion("PIC_OWNER_URL not between", value1, value2, "picOwnerUrl");
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