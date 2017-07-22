package com.ai.ge.platform.model.sys;

import java.util.ArrayList;
import java.util.List;

public class SystemDataDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemDataDictionaryExample() {
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

        public Criteria andDdIdIsNull() {
            addCriterion("DD_ID is null");
            return (Criteria) this;
        }

        public Criteria andDdIdIsNotNull() {
            addCriterion("DD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDdIdEqualTo(Long value) {
            addCriterion("DD_ID =", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdNotEqualTo(Long value) {
            addCriterion("DD_ID <>", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdGreaterThan(Long value) {
            addCriterion("DD_ID >", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DD_ID >=", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdLessThan(Long value) {
            addCriterion("DD_ID <", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdLessThanOrEqualTo(Long value) {
            addCriterion("DD_ID <=", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdIn(List<Long> values) {
            addCriterion("DD_ID in", values, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdNotIn(List<Long> values) {
            addCriterion("DD_ID not in", values, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdBetween(Long value1, Long value2) {
            addCriterion("DD_ID between", value1, value2, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdNotBetween(Long value1, Long value2) {
            addCriterion("DD_ID not between", value1, value2, "ddId");
            return (Criteria) this;
        }

        public Criteria andKeyIsNull() {
            addCriterion("KEY is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("KEY is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("KEY =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("KEY <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("KEY >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("KEY >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("KEY <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("KEY <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("KEY like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("KEY not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("KEY in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("KEY not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("KEY between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("KEY not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("VALUE is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("VALUE =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("VALUE <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("VALUE >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("VALUE >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("VALUE <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("VALUE <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("VALUE like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("VALUE not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("VALUE in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("VALUE not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("VALUE between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("VALUE not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNull() {
            addCriterion("DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("DESCRIBE =", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("DESCRIBE <>", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThan(String value) {
            addCriterion("DESCRIBE >", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIBE >=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThan(String value) {
            addCriterion("DESCRIBE <", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThanOrEqualTo(String value) {
            addCriterion("DESCRIBE <=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLike(String value) {
            addCriterion("DESCRIBE like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("DESCRIBE not like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("DESCRIBE in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("DESCRIBE not in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("DESCRIBE between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("DESCRIBE not between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andExpand1IsNull() {
            addCriterion("EXPAND1 is null");
            return (Criteria) this;
        }

        public Criteria andExpand1IsNotNull() {
            addCriterion("EXPAND1 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand1EqualTo(String value) {
            addCriterion("EXPAND1 =", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotEqualTo(String value) {
            addCriterion("EXPAND1 <>", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1GreaterThan(String value) {
            addCriterion("EXPAND1 >", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1GreaterThanOrEqualTo(String value) {
            addCriterion("EXPAND1 >=", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1LessThan(String value) {
            addCriterion("EXPAND1 <", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1LessThanOrEqualTo(String value) {
            addCriterion("EXPAND1 <=", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1Like(String value) {
            addCriterion("EXPAND1 like", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotLike(String value) {
            addCriterion("EXPAND1 not like", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1In(List<String> values) {
            addCriterion("EXPAND1 in", values, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotIn(List<String> values) {
            addCriterion("EXPAND1 not in", values, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1Between(String value1, String value2) {
            addCriterion("EXPAND1 between", value1, value2, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotBetween(String value1, String value2) {
            addCriterion("EXPAND1 not between", value1, value2, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand2IsNull() {
            addCriterion("EXPAND2 is null");
            return (Criteria) this;
        }

        public Criteria andExpand2IsNotNull() {
            addCriterion("EXPAND2 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand2EqualTo(String value) {
            addCriterion("EXPAND2 =", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotEqualTo(String value) {
            addCriterion("EXPAND2 <>", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2GreaterThan(String value) {
            addCriterion("EXPAND2 >", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2GreaterThanOrEqualTo(String value) {
            addCriterion("EXPAND2 >=", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2LessThan(String value) {
            addCriterion("EXPAND2 <", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2LessThanOrEqualTo(String value) {
            addCriterion("EXPAND2 <=", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2Like(String value) {
            addCriterion("EXPAND2 like", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotLike(String value) {
            addCriterion("EXPAND2 not like", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2In(List<String> values) {
            addCriterion("EXPAND2 in", values, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotIn(List<String> values) {
            addCriterion("EXPAND2 not in", values, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2Between(String value1, String value2) {
            addCriterion("EXPAND2 between", value1, value2, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotBetween(String value1, String value2) {
            addCriterion("EXPAND2 not between", value1, value2, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand3IsNull() {
            addCriterion("EXPAND3 is null");
            return (Criteria) this;
        }

        public Criteria andExpand3IsNotNull() {
            addCriterion("EXPAND3 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand3EqualTo(String value) {
            addCriterion("EXPAND3 =", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3NotEqualTo(String value) {
            addCriterion("EXPAND3 <>", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3GreaterThan(String value) {
            addCriterion("EXPAND3 >", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3GreaterThanOrEqualTo(String value) {
            addCriterion("EXPAND3 >=", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3LessThan(String value) {
            addCriterion("EXPAND3 <", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3LessThanOrEqualTo(String value) {
            addCriterion("EXPAND3 <=", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3Like(String value) {
            addCriterion("EXPAND3 like", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3NotLike(String value) {
            addCriterion("EXPAND3 not like", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3In(List<String> values) {
            addCriterion("EXPAND3 in", values, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3NotIn(List<String> values) {
            addCriterion("EXPAND3 not in", values, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3Between(String value1, String value2) {
            addCriterion("EXPAND3 between", value1, value2, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3NotBetween(String value1, String value2) {
            addCriterion("EXPAND3 not between", value1, value2, "expand3");
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