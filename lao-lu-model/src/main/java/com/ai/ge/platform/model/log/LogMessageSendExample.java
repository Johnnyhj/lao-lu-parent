package com.ai.ge.platform.model.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LogMessageSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogMessageSendExample() {
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

        public Criteria andMessageSendIdIsNull() {
            addCriterion("MESSAGE_SEND_ID is null");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdIsNotNull() {
            addCriterion("MESSAGE_SEND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdEqualTo(Long value) {
            addCriterion("MESSAGE_SEND_ID =", value, "messageSendId");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdNotEqualTo(Long value) {
            addCriterion("MESSAGE_SEND_ID <>", value, "messageSendId");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdGreaterThan(Long value) {
            addCriterion("MESSAGE_SEND_ID >", value, "messageSendId");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MESSAGE_SEND_ID >=", value, "messageSendId");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdLessThan(Long value) {
            addCriterion("MESSAGE_SEND_ID <", value, "messageSendId");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdLessThanOrEqualTo(Long value) {
            addCriterion("MESSAGE_SEND_ID <=", value, "messageSendId");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdIn(List<Long> values) {
            addCriterion("MESSAGE_SEND_ID in", values, "messageSendId");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdNotIn(List<Long> values) {
            addCriterion("MESSAGE_SEND_ID not in", values, "messageSendId");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdBetween(Long value1, Long value2) {
            addCriterion("MESSAGE_SEND_ID between", value1, value2, "messageSendId");
            return (Criteria) this;
        }

        public Criteria andMessageSendIdNotBetween(Long value1, Long value2) {
            addCriterion("MESSAGE_SEND_ID not between", value1, value2, "messageSendId");
            return (Criteria) this;
        }

        public Criteria andReceiveNumIsNull() {
            addCriterion("RECEIVE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNumIsNotNull() {
            addCriterion("RECEIVE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNumEqualTo(String value) {
            addCriterion("RECEIVE_NUM =", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumNotEqualTo(String value) {
            addCriterion("RECEIVE_NUM <>", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumGreaterThan(String value) {
            addCriterion("RECEIVE_NUM >", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_NUM >=", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumLessThan(String value) {
            addCriterion("RECEIVE_NUM <", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_NUM <=", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumLike(String value) {
            addCriterion("RECEIVE_NUM like", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumNotLike(String value) {
            addCriterion("RECEIVE_NUM not like", value, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumIn(List<String> values) {
            addCriterion("RECEIVE_NUM in", values, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumNotIn(List<String> values) {
            addCriterion("RECEIVE_NUM not in", values, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumBetween(String value1, String value2) {
            addCriterion("RECEIVE_NUM between", value1, value2, "receiveNum");
            return (Criteria) this;
        }

        public Criteria andReceiveNumNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_NUM not between", value1, value2, "receiveNum");
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

        public Criteria andChannelEqualTo(Short value) {
            addCriterion("CHANNEL =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(Short value) {
            addCriterion("CHANNEL <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(Short value) {
            addCriterion("CHANNEL >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(Short value) {
            addCriterion("CHANNEL >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(Short value) {
            addCriterion("CHANNEL <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(Short value) {
            addCriterion("CHANNEL <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<Short> values) {
            addCriterion("CHANNEL in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<Short> values) {
            addCriterion("CHANNEL not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(Short value1, Short value2) {
            addCriterion("CHANNEL between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(Short value1, Short value2) {
            addCriterion("CHANNEL not between", value1, value2, "channel");
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

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSendTextIsNull() {
            addCriterion("SEND_TEXT is null");
            return (Criteria) this;
        }

        public Criteria andSendTextIsNotNull() {
            addCriterion("SEND_TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andSendTextEqualTo(String value) {
            addCriterion("SEND_TEXT =", value, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextNotEqualTo(String value) {
            addCriterion("SEND_TEXT <>", value, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextGreaterThan(String value) {
            addCriterion("SEND_TEXT >", value, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_TEXT >=", value, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextLessThan(String value) {
            addCriterion("SEND_TEXT <", value, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextLessThanOrEqualTo(String value) {
            addCriterion("SEND_TEXT <=", value, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextLike(String value) {
            addCriterion("SEND_TEXT like", value, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextNotLike(String value) {
            addCriterion("SEND_TEXT not like", value, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextIn(List<String> values) {
            addCriterion("SEND_TEXT in", values, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextNotIn(List<String> values) {
            addCriterion("SEND_TEXT not in", values, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextBetween(String value1, String value2) {
            addCriterion("SEND_TEXT between", value1, value2, "sendText");
            return (Criteria) this;
        }

        public Criteria andSendTextNotBetween(String value1, String value2) {
            addCriterion("SEND_TEXT not between", value1, value2, "sendText");
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

        public Criteria andFailReasonIsNull() {
            addCriterion("FAIL_REASON is null");
            return (Criteria) this;
        }

        public Criteria andFailReasonIsNotNull() {
            addCriterion("FAIL_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andFailReasonEqualTo(String value) {
            addCriterion("FAIL_REASON =", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotEqualTo(String value) {
            addCriterion("FAIL_REASON <>", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThan(String value) {
            addCriterion("FAIL_REASON >", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThanOrEqualTo(String value) {
            addCriterion("FAIL_REASON >=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThan(String value) {
            addCriterion("FAIL_REASON <", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThanOrEqualTo(String value) {
            addCriterion("FAIL_REASON <=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLike(String value) {
            addCriterion("FAIL_REASON like", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotLike(String value) {
            addCriterion("FAIL_REASON not like", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonIn(List<String> values) {
            addCriterion("FAIL_REASON in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotIn(List<String> values) {
            addCriterion("FAIL_REASON not in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonBetween(String value1, String value2) {
            addCriterion("FAIL_REASON between", value1, value2, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotBetween(String value1, String value2) {
            addCriterion("FAIL_REASON not between", value1, value2, "failReason");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumIsNull() {
            addCriterion("REPEAT_SEND_NUM is null");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumIsNotNull() {
            addCriterion("REPEAT_SEND_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumEqualTo(Short value) {
            addCriterion("REPEAT_SEND_NUM =", value, "repeatSendNum");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumNotEqualTo(Short value) {
            addCriterion("REPEAT_SEND_NUM <>", value, "repeatSendNum");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumGreaterThan(Short value) {
            addCriterion("REPEAT_SEND_NUM >", value, "repeatSendNum");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumGreaterThanOrEqualTo(Short value) {
            addCriterion("REPEAT_SEND_NUM >=", value, "repeatSendNum");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumLessThan(Short value) {
            addCriterion("REPEAT_SEND_NUM <", value, "repeatSendNum");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumLessThanOrEqualTo(Short value) {
            addCriterion("REPEAT_SEND_NUM <=", value, "repeatSendNum");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumIn(List<Short> values) {
            addCriterion("REPEAT_SEND_NUM in", values, "repeatSendNum");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumNotIn(List<Short> values) {
            addCriterion("REPEAT_SEND_NUM not in", values, "repeatSendNum");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumBetween(Short value1, Short value2) {
            addCriterion("REPEAT_SEND_NUM between", value1, value2, "repeatSendNum");
            return (Criteria) this;
        }

        public Criteria andRepeatSendNumNotBetween(Short value1, Short value2) {
            addCriterion("REPEAT_SEND_NUM not between", value1, value2, "repeatSendNum");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("AREA is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("AREA is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("AREA =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("AREA <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("AREA >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("AREA >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("AREA <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("AREA <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("AREA like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("AREA not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("AREA in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("AREA not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("AREA between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("AREA not between", value1, value2, "area");
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

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andReadStatusIsNull() {
            addCriterion("READ_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andReadStatusIsNotNull() {
            addCriterion("READ_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andReadStatusEqualTo(Short value) {
            addCriterion("READ_STATUS =", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotEqualTo(Short value) {
            addCriterion("READ_STATUS <>", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusGreaterThan(Short value) {
            addCriterion("READ_STATUS >", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("READ_STATUS >=", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusLessThan(Short value) {
            addCriterion("READ_STATUS <", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusLessThanOrEqualTo(Short value) {
            addCriterion("READ_STATUS <=", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusIn(List<Short> values) {
            addCriterion("READ_STATUS in", values, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotIn(List<Short> values) {
            addCriterion("READ_STATUS not in", values, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusBetween(Short value1, Short value2) {
            addCriterion("READ_STATUS between", value1, value2, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotBetween(Short value1, Short value2) {
            addCriterion("READ_STATUS not between", value1, value2, "readStatus");
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