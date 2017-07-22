package com.ai.ge.platform.model.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LogInterfaceCallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogInterfaceCallExample() {
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

        public Criteria andInterfaceCallIdIsNull() {
            addCriterion("INTERFACE_CALL_ID is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdIsNotNull() {
            addCriterion("INTERFACE_CALL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdEqualTo(Long value) {
            addCriterion("INTERFACE_CALL_ID =", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdNotEqualTo(Long value) {
            addCriterion("INTERFACE_CALL_ID <>", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdGreaterThan(Long value) {
            addCriterion("INTERFACE_CALL_ID >", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdGreaterThanOrEqualTo(Long value) {
            addCriterion("INTERFACE_CALL_ID >=", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdLessThan(Long value) {
            addCriterion("INTERFACE_CALL_ID <", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdLessThanOrEqualTo(Long value) {
            addCriterion("INTERFACE_CALL_ID <=", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdIn(List<Long> values) {
            addCriterion("INTERFACE_CALL_ID in", values, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdNotIn(List<Long> values) {
            addCriterion("INTERFACE_CALL_ID not in", values, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdBetween(Long value1, Long value2) {
            addCriterion("INTERFACE_CALL_ID between", value1, value2, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdNotBetween(Long value1, Long value2) {
            addCriterion("INTERFACE_CALL_ID not between", value1, value2, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("PHONE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("PHONE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("PHONE_NUM =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("PHONE_NUM <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("PHONE_NUM >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_NUM >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("PHONE_NUM <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("PHONE_NUM <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("PHONE_NUM like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("PHONE_NUM not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("PHONE_NUM in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("PHONE_NUM not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("PHONE_NUM between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("PHONE_NUM not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andActionNameIsNull() {
            addCriterion("ACTION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andActionNameIsNotNull() {
            addCriterion("ACTION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andActionNameEqualTo(String value) {
            addCriterion("ACTION_NAME =", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameNotEqualTo(String value) {
            addCriterion("ACTION_NAME <>", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameGreaterThan(String value) {
            addCriterion("ACTION_NAME >", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION_NAME >=", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameLessThan(String value) {
            addCriterion("ACTION_NAME <", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameLessThanOrEqualTo(String value) {
            addCriterion("ACTION_NAME <=", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameLike(String value) {
            addCriterion("ACTION_NAME like", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameNotLike(String value) {
            addCriterion("ACTION_NAME not like", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameIn(List<String> values) {
            addCriterion("ACTION_NAME in", values, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameNotIn(List<String> values) {
            addCriterion("ACTION_NAME not in", values, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameBetween(String value1, String value2) {
            addCriterion("ACTION_NAME between", value1, value2, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameNotBetween(String value1, String value2) {
            addCriterion("ACTION_NAME not between", value1, value2, "actionName");
            return (Criteria) this;
        }

        public Criteria andRequestTimesIsNull() {
            addCriterion("REQUEST_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimesIsNotNull() {
            addCriterion("REQUEST_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimesEqualTo(Date value) {
            addCriterionForJDBCDate("REQUEST_TIMES =", value, "requestTimes");
            return (Criteria) this;
        }

        public Criteria andRequestTimesNotEqualTo(Date value) {
            addCriterionForJDBCDate("REQUEST_TIMES <>", value, "requestTimes");
            return (Criteria) this;
        }

        public Criteria andRequestTimesGreaterThan(Date value) {
            addCriterionForJDBCDate("REQUEST_TIMES >", value, "requestTimes");
            return (Criteria) this;
        }

        public Criteria andRequestTimesGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("REQUEST_TIMES >=", value, "requestTimes");
            return (Criteria) this;
        }

        public Criteria andRequestTimesLessThan(Date value) {
            addCriterionForJDBCDate("REQUEST_TIMES <", value, "requestTimes");
            return (Criteria) this;
        }

        public Criteria andRequestTimesLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("REQUEST_TIMES <=", value, "requestTimes");
            return (Criteria) this;
        }

        public Criteria andRequestTimesIn(List<Date> values) {
            addCriterionForJDBCDate("REQUEST_TIMES in", values, "requestTimes");
            return (Criteria) this;
        }

        public Criteria andRequestTimesNotIn(List<Date> values) {
            addCriterionForJDBCDate("REQUEST_TIMES not in", values, "requestTimes");
            return (Criteria) this;
        }

        public Criteria andRequestTimesBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("REQUEST_TIMES between", value1, value2, "requestTimes");
            return (Criteria) this;
        }

        public Criteria andRequestTimesNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("REQUEST_TIMES not between", value1, value2, "requestTimes");
            return (Criteria) this;
        }

        public Criteria andHttpCodeIsNull() {
            addCriterion("HTTP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andHttpCodeIsNotNull() {
            addCriterion("HTTP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andHttpCodeEqualTo(Short value) {
            addCriterion("HTTP_CODE =", value, "httpCode");
            return (Criteria) this;
        }

        public Criteria andHttpCodeNotEqualTo(Short value) {
            addCriterion("HTTP_CODE <>", value, "httpCode");
            return (Criteria) this;
        }

        public Criteria andHttpCodeGreaterThan(Short value) {
            addCriterion("HTTP_CODE >", value, "httpCode");
            return (Criteria) this;
        }

        public Criteria andHttpCodeGreaterThanOrEqualTo(Short value) {
            addCriterion("HTTP_CODE >=", value, "httpCode");
            return (Criteria) this;
        }

        public Criteria andHttpCodeLessThan(Short value) {
            addCriterion("HTTP_CODE <", value, "httpCode");
            return (Criteria) this;
        }

        public Criteria andHttpCodeLessThanOrEqualTo(Short value) {
            addCriterion("HTTP_CODE <=", value, "httpCode");
            return (Criteria) this;
        }

        public Criteria andHttpCodeIn(List<Short> values) {
            addCriterion("HTTP_CODE in", values, "httpCode");
            return (Criteria) this;
        }

        public Criteria andHttpCodeNotIn(List<Short> values) {
            addCriterion("HTTP_CODE not in", values, "httpCode");
            return (Criteria) this;
        }

        public Criteria andHttpCodeBetween(Short value1, Short value2) {
            addCriterion("HTTP_CODE between", value1, value2, "httpCode");
            return (Criteria) this;
        }

        public Criteria andHttpCodeNotBetween(Short value1, Short value2) {
            addCriterion("HTTP_CODE not between", value1, value2, "httpCode");
            return (Criteria) this;
        }

        public Criteria andResponseTimesIsNull() {
            addCriterion("RESPONSE_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andResponseTimesIsNotNull() {
            addCriterion("RESPONSE_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andResponseTimesEqualTo(Date value) {
            addCriterionForJDBCDate("RESPONSE_TIMES =", value, "responseTimes");
            return (Criteria) this;
        }

        public Criteria andResponseTimesNotEqualTo(Date value) {
            addCriterionForJDBCDate("RESPONSE_TIMES <>", value, "responseTimes");
            return (Criteria) this;
        }

        public Criteria andResponseTimesGreaterThan(Date value) {
            addCriterionForJDBCDate("RESPONSE_TIMES >", value, "responseTimes");
            return (Criteria) this;
        }

        public Criteria andResponseTimesGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RESPONSE_TIMES >=", value, "responseTimes");
            return (Criteria) this;
        }

        public Criteria andResponseTimesLessThan(Date value) {
            addCriterionForJDBCDate("RESPONSE_TIMES <", value, "responseTimes");
            return (Criteria) this;
        }

        public Criteria andResponseTimesLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RESPONSE_TIMES <=", value, "responseTimes");
            return (Criteria) this;
        }

        public Criteria andResponseTimesIn(List<Date> values) {
            addCriterionForJDBCDate("RESPONSE_TIMES in", values, "responseTimes");
            return (Criteria) this;
        }

        public Criteria andResponseTimesNotIn(List<Date> values) {
            addCriterionForJDBCDate("RESPONSE_TIMES not in", values, "responseTimes");
            return (Criteria) this;
        }

        public Criteria andResponseTimesBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RESPONSE_TIMES between", value1, value2, "responseTimes");
            return (Criteria) this;
        }

        public Criteria andResponseTimesNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RESPONSE_TIMES not between", value1, value2, "responseTimes");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesIsNull() {
            addCriterion("INTERFACE_CALL_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesIsNotNull() {
            addCriterion("INTERFACE_CALL_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesEqualTo(Integer value) {
            addCriterion("INTERFACE_CALL_TIMES =", value, "interfaceCallTimes");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesNotEqualTo(Integer value) {
            addCriterion("INTERFACE_CALL_TIMES <>", value, "interfaceCallTimes");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesGreaterThan(Integer value) {
            addCriterion("INTERFACE_CALL_TIMES >", value, "interfaceCallTimes");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("INTERFACE_CALL_TIMES >=", value, "interfaceCallTimes");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesLessThan(Integer value) {
            addCriterion("INTERFACE_CALL_TIMES <", value, "interfaceCallTimes");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesLessThanOrEqualTo(Integer value) {
            addCriterion("INTERFACE_CALL_TIMES <=", value, "interfaceCallTimes");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesIn(List<Integer> values) {
            addCriterion("INTERFACE_CALL_TIMES in", values, "interfaceCallTimes");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesNotIn(List<Integer> values) {
            addCriterion("INTERFACE_CALL_TIMES not in", values, "interfaceCallTimes");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesBetween(Integer value1, Integer value2) {
            addCriterion("INTERFACE_CALL_TIMES between", value1, value2, "interfaceCallTimes");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("INTERFACE_CALL_TIMES not between", value1, value2, "interfaceCallTimes");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(Short value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(Short value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(Short value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(Short value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(Short value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(Short value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<Short> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<Short> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(Short value1, Short value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(Short value1, Short value2) {
            addCriterion("RESULT not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqIsNull() {
            addCriterion("EXTERNAL_ORDER_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqIsNotNull() {
            addCriterion("EXTERNAL_ORDER_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqEqualTo(String value) {
            addCriterion("EXTERNAL_ORDER_SEQ =", value, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqNotEqualTo(String value) {
            addCriterion("EXTERNAL_ORDER_SEQ <>", value, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqGreaterThan(String value) {
            addCriterion("EXTERNAL_ORDER_SEQ >", value, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqGreaterThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_ORDER_SEQ >=", value, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqLessThan(String value) {
            addCriterion("EXTERNAL_ORDER_SEQ <", value, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqLessThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_ORDER_SEQ <=", value, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqLike(String value) {
            addCriterion("EXTERNAL_ORDER_SEQ like", value, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqNotLike(String value) {
            addCriterion("EXTERNAL_ORDER_SEQ not like", value, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqIn(List<String> values) {
            addCriterion("EXTERNAL_ORDER_SEQ in", values, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqNotIn(List<String> values) {
            addCriterion("EXTERNAL_ORDER_SEQ not in", values, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqBetween(String value1, String value2) {
            addCriterion("EXTERNAL_ORDER_SEQ between", value1, value2, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andExternalOrderSeqNotBetween(String value1, String value2) {
            addCriterion("EXTERNAL_ORDER_SEQ not between", value1, value2, "externalOrderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqIsNull() {
            addCriterion("ORDER_GROUP_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqIsNotNull() {
            addCriterion("ORDER_GROUP_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqEqualTo(String value) {
            addCriterion("ORDER_GROUP_SEQ =", value, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqNotEqualTo(String value) {
            addCriterion("ORDER_GROUP_SEQ <>", value, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqGreaterThan(String value) {
            addCriterion("ORDER_GROUP_SEQ >", value, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_GROUP_SEQ >=", value, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqLessThan(String value) {
            addCriterion("ORDER_GROUP_SEQ <", value, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqLessThanOrEqualTo(String value) {
            addCriterion("ORDER_GROUP_SEQ <=", value, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqLike(String value) {
            addCriterion("ORDER_GROUP_SEQ like", value, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqNotLike(String value) {
            addCriterion("ORDER_GROUP_SEQ not like", value, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqIn(List<String> values) {
            addCriterion("ORDER_GROUP_SEQ in", values, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqNotIn(List<String> values) {
            addCriterion("ORDER_GROUP_SEQ not in", values, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqBetween(String value1, String value2) {
            addCriterion("ORDER_GROUP_SEQ between", value1, value2, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andOrderGroupSeqNotBetween(String value1, String value2) {
            addCriterion("ORDER_GROUP_SEQ not between", value1, value2, "orderGroupSeq");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumIsNull() {
            addCriterion("REPEATE_CALL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumIsNotNull() {
            addCriterion("REPEATE_CALL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumEqualTo(Short value) {
            addCriterion("REPEATE_CALL_NUM =", value, "repeateCallNum");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumNotEqualTo(Short value) {
            addCriterion("REPEATE_CALL_NUM <>", value, "repeateCallNum");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumGreaterThan(Short value) {
            addCriterion("REPEATE_CALL_NUM >", value, "repeateCallNum");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumGreaterThanOrEqualTo(Short value) {
            addCriterion("REPEATE_CALL_NUM >=", value, "repeateCallNum");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumLessThan(Short value) {
            addCriterion("REPEATE_CALL_NUM <", value, "repeateCallNum");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumLessThanOrEqualTo(Short value) {
            addCriterion("REPEATE_CALL_NUM <=", value, "repeateCallNum");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumIn(List<Short> values) {
            addCriterion("REPEATE_CALL_NUM in", values, "repeateCallNum");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumNotIn(List<Short> values) {
            addCriterion("REPEATE_CALL_NUM not in", values, "repeateCallNum");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumBetween(Short value1, Short value2) {
            addCriterion("REPEATE_CALL_NUM between", value1, value2, "repeateCallNum");
            return (Criteria) this;
        }

        public Criteria andRepeateCallNumNotBetween(Short value1, Short value2) {
            addCriterion("REPEATE_CALL_NUM not between", value1, value2, "repeateCallNum");
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

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
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