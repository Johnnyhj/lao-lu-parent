package com.ai.ge.platform.model.auth;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SystemAuthorizationHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemAuthorizationHistoryExample() {
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

        public Criteria andSysAuthIdIsNull() {
            addCriterion("SYS_AUTH_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdIsNotNull() {
            addCriterion("SYS_AUTH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdEqualTo(Long value) {
            addCriterion("SYS_AUTH_ID =", value, "sysAuthId");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdNotEqualTo(Long value) {
            addCriterion("SYS_AUTH_ID <>", value, "sysAuthId");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdGreaterThan(Long value) {
            addCriterion("SYS_AUTH_ID >", value, "sysAuthId");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SYS_AUTH_ID >=", value, "sysAuthId");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdLessThan(Long value) {
            addCriterion("SYS_AUTH_ID <", value, "sysAuthId");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdLessThanOrEqualTo(Long value) {
            addCriterion("SYS_AUTH_ID <=", value, "sysAuthId");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdIn(List<Long> values) {
            addCriterion("SYS_AUTH_ID in", values, "sysAuthId");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdNotIn(List<Long> values) {
            addCriterion("SYS_AUTH_ID not in", values, "sysAuthId");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdBetween(Long value1, Long value2) {
            addCriterion("SYS_AUTH_ID between", value1, value2, "sysAuthId");
            return (Criteria) this;
        }

        public Criteria andSysAuthIdNotBetween(Long value1, Long value2) {
            addCriterion("SYS_AUTH_ID not between", value1, value2, "sysAuthId");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("TOKEN =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("TOKEN <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("TOKEN >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("TOKEN >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("TOKEN <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("TOKEN <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("TOKEN like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("TOKEN not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("TOKEN in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("TOKEN not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("TOKEN between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("TOKEN not between", value1, value2, "token");
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

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andReqIpIsNull() {
            addCriterion("REQ_IP is null");
            return (Criteria) this;
        }

        public Criteria andReqIpIsNotNull() {
            addCriterion("REQ_IP is not null");
            return (Criteria) this;
        }

        public Criteria andReqIpEqualTo(String value) {
            addCriterion("REQ_IP =", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpNotEqualTo(String value) {
            addCriterion("REQ_IP <>", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpGreaterThan(String value) {
            addCriterion("REQ_IP >", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_IP >=", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpLessThan(String value) {
            addCriterion("REQ_IP <", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpLessThanOrEqualTo(String value) {
            addCriterion("REQ_IP <=", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpLike(String value) {
            addCriterion("REQ_IP like", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpNotLike(String value) {
            addCriterion("REQ_IP not like", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpIn(List<String> values) {
            addCriterion("REQ_IP in", values, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpNotIn(List<String> values) {
            addCriterion("REQ_IP not in", values, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpBetween(String value1, String value2) {
            addCriterion("REQ_IP between", value1, value2, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpNotBetween(String value1, String value2) {
            addCriterion("REQ_IP not between", value1, value2, "reqIp");
            return (Criteria) this;
        }

        public Criteria andAuthResultIsNull() {
            addCriterion("AUTH_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andAuthResultIsNotNull() {
            addCriterion("AUTH_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andAuthResultEqualTo(Short value) {
            addCriterion("AUTH_RESULT =", value, "authResult");
            return (Criteria) this;
        }

        public Criteria andAuthResultNotEqualTo(Short value) {
            addCriterion("AUTH_RESULT <>", value, "authResult");
            return (Criteria) this;
        }

        public Criteria andAuthResultGreaterThan(Short value) {
            addCriterion("AUTH_RESULT >", value, "authResult");
            return (Criteria) this;
        }

        public Criteria andAuthResultGreaterThanOrEqualTo(Short value) {
            addCriterion("AUTH_RESULT >=", value, "authResult");
            return (Criteria) this;
        }

        public Criteria andAuthResultLessThan(Short value) {
            addCriterion("AUTH_RESULT <", value, "authResult");
            return (Criteria) this;
        }

        public Criteria andAuthResultLessThanOrEqualTo(Short value) {
            addCriterion("AUTH_RESULT <=", value, "authResult");
            return (Criteria) this;
        }

        public Criteria andAuthResultIn(List<Short> values) {
            addCriterion("AUTH_RESULT in", values, "authResult");
            return (Criteria) this;
        }

        public Criteria andAuthResultNotIn(List<Short> values) {
            addCriterion("AUTH_RESULT not in", values, "authResult");
            return (Criteria) this;
        }

        public Criteria andAuthResultBetween(Short value1, Short value2) {
            addCriterion("AUTH_RESULT between", value1, value2, "authResult");
            return (Criteria) this;
        }

        public Criteria andAuthResultNotBetween(Short value1, Short value2) {
            addCriterion("AUTH_RESULT not between", value1, value2, "authResult");
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

        public Criteria andFailReasonEqualTo(Short value) {
            addCriterion("FAIL_REASON =", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotEqualTo(Short value) {
            addCriterion("FAIL_REASON <>", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThan(Short value) {
            addCriterion("FAIL_REASON >", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThanOrEqualTo(Short value) {
            addCriterion("FAIL_REASON >=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThan(Short value) {
            addCriterion("FAIL_REASON <", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThanOrEqualTo(Short value) {
            addCriterion("FAIL_REASON <=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonIn(List<Short> values) {
            addCriterion("FAIL_REASON in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotIn(List<Short> values) {
            addCriterion("FAIL_REASON not in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonBetween(Short value1, Short value2) {
            addCriterion("FAIL_REASON between", value1, value2, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotBetween(Short value1, Short value2) {
            addCriterion("FAIL_REASON not between", value1, value2, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextIsNull() {
            addCriterion("FAIL_REASON_TEXT is null");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextIsNotNull() {
            addCriterion("FAIL_REASON_TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextEqualTo(String value) {
            addCriterion("FAIL_REASON_TEXT =", value, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextNotEqualTo(String value) {
            addCriterion("FAIL_REASON_TEXT <>", value, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextGreaterThan(String value) {
            addCriterion("FAIL_REASON_TEXT >", value, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextGreaterThanOrEqualTo(String value) {
            addCriterion("FAIL_REASON_TEXT >=", value, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextLessThan(String value) {
            addCriterion("FAIL_REASON_TEXT <", value, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextLessThanOrEqualTo(String value) {
            addCriterion("FAIL_REASON_TEXT <=", value, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextLike(String value) {
            addCriterion("FAIL_REASON_TEXT like", value, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextNotLike(String value) {
            addCriterion("FAIL_REASON_TEXT not like", value, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextIn(List<String> values) {
            addCriterion("FAIL_REASON_TEXT in", values, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextNotIn(List<String> values) {
            addCriterion("FAIL_REASON_TEXT not in", values, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextBetween(String value1, String value2) {
            addCriterion("FAIL_REASON_TEXT between", value1, value2, "failReasonText");
            return (Criteria) this;
        }

        public Criteria andFailReasonTextNotBetween(String value1, String value2) {
            addCriterion("FAIL_REASON_TEXT not between", value1, value2, "failReasonText");
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

        public Criteria andInvalidTimeIsNull() {
            addCriterion("INVALID_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIsNotNull() {
            addCriterion("INVALID_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeEqualTo(Date value) {
            addCriterionForJDBCDate("INVALID_TIME =", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("INVALID_TIME <>", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("INVALID_TIME >", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INVALID_TIME >=", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeLessThan(Date value) {
            addCriterionForJDBCDate("INVALID_TIME <", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INVALID_TIME <=", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIn(List<Date> values) {
            addCriterionForJDBCDate("INVALID_TIME in", values, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("INVALID_TIME not in", values, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INVALID_TIME between", value1, value2, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INVALID_TIME not between", value1, value2, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeIsNull() {
            addCriterion("TOKEN_USE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeIsNotNull() {
            addCriterion("TOKEN_USE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeEqualTo(Date value) {
            addCriterionForJDBCDate("TOKEN_USE_TIME =", value, "tokenUseTime");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("TOKEN_USE_TIME <>", value, "tokenUseTime");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("TOKEN_USE_TIME >", value, "tokenUseTime");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TOKEN_USE_TIME >=", value, "tokenUseTime");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeLessThan(Date value) {
            addCriterionForJDBCDate("TOKEN_USE_TIME <", value, "tokenUseTime");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TOKEN_USE_TIME <=", value, "tokenUseTime");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeIn(List<Date> values) {
            addCriterionForJDBCDate("TOKEN_USE_TIME in", values, "tokenUseTime");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("TOKEN_USE_TIME not in", values, "tokenUseTime");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TOKEN_USE_TIME between", value1, value2, "tokenUseTime");
            return (Criteria) this;
        }

        public Criteria andTokenUseTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TOKEN_USE_TIME not between", value1, value2, "tokenUseTime");
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