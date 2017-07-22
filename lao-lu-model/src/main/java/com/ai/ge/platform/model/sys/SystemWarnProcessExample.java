package com.ai.ge.platform.model.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SystemWarnProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemWarnProcessExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSystemWarnProcessIdIsNull() {
            addCriterion("SYSTEM_WARN_PROCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdIsNotNull() {
            addCriterion("SYSTEM_WARN_PROCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdEqualTo(Long value) {
            addCriterion("SYSTEM_WARN_PROCESS_ID =", value, "systemWarnProcessId");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdNotEqualTo(Long value) {
            addCriterion("SYSTEM_WARN_PROCESS_ID <>", value, "systemWarnProcessId");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdGreaterThan(Long value) {
            addCriterion("SYSTEM_WARN_PROCESS_ID >", value, "systemWarnProcessId");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SYSTEM_WARN_PROCESS_ID >=", value, "systemWarnProcessId");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdLessThan(Long value) {
            addCriterion("SYSTEM_WARN_PROCESS_ID <", value, "systemWarnProcessId");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdLessThanOrEqualTo(Long value) {
            addCriterion("SYSTEM_WARN_PROCESS_ID <=", value, "systemWarnProcessId");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdIn(List<Long> values) {
            addCriterion("SYSTEM_WARN_PROCESS_ID in", values, "systemWarnProcessId");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdNotIn(List<Long> values) {
            addCriterion("SYSTEM_WARN_PROCESS_ID not in", values, "systemWarnProcessId");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdBetween(Long value1, Long value2) {
            addCriterion("SYSTEM_WARN_PROCESS_ID between", value1, value2, "systemWarnProcessId");
            return (Criteria) this;
        }

        public Criteria andSystemWarnProcessIdNotBetween(Long value1, Long value2) {
            addCriterion("SYSTEM_WARN_PROCESS_ID not between", value1, value2, "systemWarnProcessId");
            return (Criteria) this;
        }

        public Criteria andWarnMessageIsNull() {
            addCriterion("WARN_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andWarnMessageIsNotNull() {
            addCriterion("WARN_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andWarnMessageEqualTo(String value) {
            addCriterion("WARN_MESSAGE =", value, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageNotEqualTo(String value) {
            addCriterion("WARN_MESSAGE <>", value, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageGreaterThan(String value) {
            addCriterion("WARN_MESSAGE >", value, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageGreaterThanOrEqualTo(String value) {
            addCriterion("WARN_MESSAGE >=", value, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageLessThan(String value) {
            addCriterion("WARN_MESSAGE <", value, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageLessThanOrEqualTo(String value) {
            addCriterion("WARN_MESSAGE <=", value, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageLike(String value) {
            addCriterion("WARN_MESSAGE like", value, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageNotLike(String value) {
            addCriterion("WARN_MESSAGE not like", value, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageIn(List<String> values) {
            addCriterion("WARN_MESSAGE in", values, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageNotIn(List<String> values) {
            addCriterion("WARN_MESSAGE not in", values, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageBetween(String value1, String value2) {
            addCriterion("WARN_MESSAGE between", value1, value2, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andWarnMessageNotBetween(String value1, String value2) {
            addCriterion("WARN_MESSAGE not between", value1, value2, "warnMessage");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("CHANNEL =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("CHANNEL <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("CHANNEL >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("CHANNEL <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("CHANNEL like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("CHANNEL not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("CHANNEL in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("CHANNEL not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("CHANNEL between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("CHANNEL not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andPrcessIdIsNull() {
            addCriterion("PRCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andPrcessIdIsNotNull() {
            addCriterion("PRCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPrcessIdEqualTo(Long value) {
            addCriterion("PRCESS_ID =", value, "prcessId");
            return (Criteria) this;
        }

        public Criteria andPrcessIdNotEqualTo(Long value) {
            addCriterion("PRCESS_ID <>", value, "prcessId");
            return (Criteria) this;
        }

        public Criteria andPrcessIdGreaterThan(Long value) {
            addCriterion("PRCESS_ID >", value, "prcessId");
            return (Criteria) this;
        }

        public Criteria andPrcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PRCESS_ID >=", value, "prcessId");
            return (Criteria) this;
        }

        public Criteria andPrcessIdLessThan(Long value) {
            addCriterion("PRCESS_ID <", value, "prcessId");
            return (Criteria) this;
        }

        public Criteria andPrcessIdLessThanOrEqualTo(Long value) {
            addCriterion("PRCESS_ID <=", value, "prcessId");
            return (Criteria) this;
        }

        public Criteria andPrcessIdIn(List<Long> values) {
            addCriterion("PRCESS_ID in", values, "prcessId");
            return (Criteria) this;
        }

        public Criteria andPrcessIdNotIn(List<Long> values) {
            addCriterion("PRCESS_ID not in", values, "prcessId");
            return (Criteria) this;
        }

        public Criteria andPrcessIdBetween(Long value1, Long value2) {
            addCriterion("PRCESS_ID between", value1, value2, "prcessId");
            return (Criteria) this;
        }

        public Criteria andPrcessIdNotBetween(Long value1, Long value2) {
            addCriterion("PRCESS_ID not between", value1, value2, "prcessId");
            return (Criteria) this;
        }

        public Criteria andPrcessNameIsNull() {
            addCriterion("PRCESS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPrcessNameIsNotNull() {
            addCriterion("PRCESS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPrcessNameEqualTo(String value) {
            addCriterion("PRCESS_NAME =", value, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameNotEqualTo(String value) {
            addCriterion("PRCESS_NAME <>", value, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameGreaterThan(String value) {
            addCriterion("PRCESS_NAME >", value, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRCESS_NAME >=", value, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameLessThan(String value) {
            addCriterion("PRCESS_NAME <", value, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameLessThanOrEqualTo(String value) {
            addCriterion("PRCESS_NAME <=", value, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameLike(String value) {
            addCriterion("PRCESS_NAME like", value, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameNotLike(String value) {
            addCriterion("PRCESS_NAME not like", value, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameIn(List<String> values) {
            addCriterion("PRCESS_NAME in", values, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameNotIn(List<String> values) {
            addCriterion("PRCESS_NAME not in", values, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameBetween(String value1, String value2) {
            addCriterion("PRCESS_NAME between", value1, value2, "prcessName");
            return (Criteria) this;
        }

        public Criteria andPrcessNameNotBetween(String value1, String value2) {
            addCriterion("PRCESS_NAME not between", value1, value2, "prcessName");
            return (Criteria) this;
        }

        public Criteria andProcessResultIsNull() {
            addCriterion("PROCESS_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andProcessResultIsNotNull() {
            addCriterion("PROCESS_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andProcessResultEqualTo(String value) {
            addCriterion("PROCESS_RESULT =", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultNotEqualTo(String value) {
            addCriterion("PROCESS_RESULT <>", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultGreaterThan(String value) {
            addCriterion("PROCESS_RESULT >", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS_RESULT >=", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultLessThan(String value) {
            addCriterion("PROCESS_RESULT <", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultLessThanOrEqualTo(String value) {
            addCriterion("PROCESS_RESULT <=", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultLike(String value) {
            addCriterion("PROCESS_RESULT like", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultNotLike(String value) {
            addCriterion("PROCESS_RESULT not like", value, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultIn(List<String> values) {
            addCriterion("PROCESS_RESULT in", values, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultNotIn(List<String> values) {
            addCriterion("PROCESS_RESULT not in", values, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultBetween(String value1, String value2) {
            addCriterion("PROCESS_RESULT between", value1, value2, "processResult");
            return (Criteria) this;
        }

        public Criteria andProcessResultNotBetween(String value1, String value2) {
            addCriterion("PROCESS_RESULT not between", value1, value2, "processResult");
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
            addCriterionForJDBCDate("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME not between", value1, value2, "createTime");
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
            addCriterionForJDBCDate("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeIsNull() {
            addCriterion("PRCESS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeIsNotNull() {
            addCriterion("PRCESS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeEqualTo(Date value) {
            addCriterionForJDBCDate("PRCESS_TIME =", value, "prcessTime");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("PRCESS_TIME <>", value, "prcessTime");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("PRCESS_TIME >", value, "prcessTime");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PRCESS_TIME >=", value, "prcessTime");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeLessThan(Date value) {
            addCriterionForJDBCDate("PRCESS_TIME <", value, "prcessTime");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PRCESS_TIME <=", value, "prcessTime");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeIn(List<Date> values) {
            addCriterionForJDBCDate("PRCESS_TIME in", values, "prcessTime");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("PRCESS_TIME not in", values, "prcessTime");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PRCESS_TIME between", value1, value2, "prcessTime");
            return (Criteria) this;
        }

        public Criteria andPrcessTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PRCESS_TIME not between", value1, value2, "prcessTime");
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