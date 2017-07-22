package com.ai.ge.platform.model.arrears;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemindPayLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RemindPayLogExample() {
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

        public Criteria andRpIdIsNull() {
            addCriterion("RP_ID is null");
            return (Criteria) this;
        }

        public Criteria andRpIdIsNotNull() {
            addCriterion("RP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRpIdEqualTo(Long value) {
            addCriterion("RP_ID =", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdNotEqualTo(Long value) {
            addCriterion("RP_ID <>", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdGreaterThan(Long value) {
            addCriterion("RP_ID >", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("RP_ID >=", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdLessThan(Long value) {
            addCriterion("RP_ID <", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdLessThanOrEqualTo(Long value) {
            addCriterion("RP_ID <=", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdIn(List<Long> values) {
            addCriterion("RP_ID in", values, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdNotIn(List<Long> values) {
            addCriterion("RP_ID not in", values, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdBetween(Long value1, Long value2) {
            addCriterion("RP_ID between", value1, value2, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdNotBetween(Long value1, Long value2) {
            addCriterion("RP_ID not between", value1, value2, "rpId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdIsNull() {
            addCriterion("ARREARS_ID is null");
            return (Criteria) this;
        }

        public Criteria andArrearsIdIsNotNull() {
            addCriterion("ARREARS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andArrearsIdEqualTo(Long value) {
            addCriterion("ARREARS_ID =", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdNotEqualTo(Long value) {
            addCriterion("ARREARS_ID <>", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdGreaterThan(Long value) {
            addCriterion("ARREARS_ID >", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ARREARS_ID >=", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdLessThan(Long value) {
            addCriterion("ARREARS_ID <", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdLessThanOrEqualTo(Long value) {
            addCriterion("ARREARS_ID <=", value, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdIn(List<Long> values) {
            addCriterion("ARREARS_ID in", values, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdNotIn(List<Long> values) {
            addCriterion("ARREARS_ID not in", values, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdBetween(Long value1, Long value2) {
            addCriterion("ARREARS_ID between", value1, value2, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsIdNotBetween(Long value1, Long value2) {
            addCriterion("ARREARS_ID not between", value1, value2, "arrearsId");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeIsNull() {
            addCriterion("ARREARS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeIsNotNull() {
            addCriterion("ARREARS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeEqualTo(Date value) {
            addCriterion("ARREARS_TIME =", value, "arrearsTime");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeNotEqualTo(Date value) {
            addCriterion("ARREARS_TIME <>", value, "arrearsTime");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeGreaterThan(Date value) {
            addCriterion("ARREARS_TIME >", value, "arrearsTime");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ARREARS_TIME >=", value, "arrearsTime");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeLessThan(Date value) {
            addCriterion("ARREARS_TIME <", value, "arrearsTime");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeLessThanOrEqualTo(Date value) {
            addCriterion("ARREARS_TIME <=", value, "arrearsTime");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeIn(List<Date> values) {
            addCriterion("ARREARS_TIME in", values, "arrearsTime");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeNotIn(List<Date> values) {
            addCriterion("ARREARS_TIME not in", values, "arrearsTime");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeBetween(Date value1, Date value2) {
            addCriterion("ARREARS_TIME between", value1, value2, "arrearsTime");
            return (Criteria) this;
        }

        public Criteria andArrearsTimeNotBetween(Date value1, Date value2) {
            addCriterion("ARREARS_TIME not between", value1, value2, "arrearsTime");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIsNull() {
            addCriterion("STAFF_CODE is null");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIsNotNull() {
            addCriterion("STAFF_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCodeEqualTo(Long value) {
            addCriterion("STAFF_CODE =", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotEqualTo(Long value) {
            addCriterion("STAFF_CODE <>", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeGreaterThan(Long value) {
            addCriterion("STAFF_CODE >", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("STAFF_CODE >=", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLessThan(Long value) {
            addCriterion("STAFF_CODE <", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLessThanOrEqualTo(Long value) {
            addCriterion("STAFF_CODE <=", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIn(List<Long> values) {
            addCriterion("STAFF_CODE in", values, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotIn(List<Long> values) {
            addCriterion("STAFF_CODE not in", values, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeBetween(Long value1, Long value2) {
            addCriterion("STAFF_CODE between", value1, value2, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotBetween(Long value1, Long value2) {
            addCriterion("STAFF_CODE not between", value1, value2, "staffCode");
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

        public Criteria andActionTypeIsNull() {
            addCriterion("ACTION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andActionTypeIsNotNull() {
            addCriterion("ACTION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andActionTypeEqualTo(Short value) {
            addCriterion("ACTION_TYPE =", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotEqualTo(Short value) {
            addCriterion("ACTION_TYPE <>", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeGreaterThan(Short value) {
            addCriterion("ACTION_TYPE >", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("ACTION_TYPE >=", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeLessThan(Short value) {
            addCriterion("ACTION_TYPE <", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeLessThanOrEqualTo(Short value) {
            addCriterion("ACTION_TYPE <=", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeIn(List<Short> values) {
            addCriterion("ACTION_TYPE in", values, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotIn(List<Short> values) {
            addCriterion("ACTION_TYPE not in", values, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeBetween(Short value1, Short value2) {
            addCriterion("ACTION_TYPE between", value1, value2, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotBetween(Short value1, Short value2) {
            addCriterion("ACTION_TYPE not between", value1, value2, "actionType");
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