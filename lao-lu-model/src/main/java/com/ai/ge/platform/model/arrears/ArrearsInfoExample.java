package com.ai.ge.platform.model.arrears;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArrearsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArrearsInfoExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneIsNull() {
            addCriterion("ARREARS_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneIsNotNull() {
            addCriterion("ARREARS_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneEqualTo(String value) {
            addCriterion("ARREARS_PHONE =", value, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneNotEqualTo(String value) {
            addCriterion("ARREARS_PHONE <>", value, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneGreaterThan(String value) {
            addCriterion("ARREARS_PHONE >", value, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ARREARS_PHONE >=", value, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneLessThan(String value) {
            addCriterion("ARREARS_PHONE <", value, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneLessThanOrEqualTo(String value) {
            addCriterion("ARREARS_PHONE <=", value, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneLike(String value) {
            addCriterion("ARREARS_PHONE like", value, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneNotLike(String value) {
            addCriterion("ARREARS_PHONE not like", value, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneIn(List<String> values) {
            addCriterion("ARREARS_PHONE in", values, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneNotIn(List<String> values) {
            addCriterion("ARREARS_PHONE not in", values, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneBetween(String value1, String value2) {
            addCriterion("ARREARS_PHONE between", value1, value2, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andArrearsPhoneNotBetween(String value1, String value2) {
            addCriterion("ARREARS_PHONE not between", value1, value2, "arrearsPhone");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeIsNull() {
            addCriterion("IDENTITY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeIsNotNull() {
            addCriterion("IDENTITY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeEqualTo(Short value) {
            addCriterion("IDENTITY_TYPE =", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeNotEqualTo(Short value) {
            addCriterion("IDENTITY_TYPE <>", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeGreaterThan(Short value) {
            addCriterion("IDENTITY_TYPE >", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("IDENTITY_TYPE >=", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeLessThan(Short value) {
            addCriterion("IDENTITY_TYPE <", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeLessThanOrEqualTo(Short value) {
            addCriterion("IDENTITY_TYPE <=", value, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeIn(List<Short> values) {
            addCriterion("IDENTITY_TYPE in", values, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeNotIn(List<Short> values) {
            addCriterion("IDENTITY_TYPE not in", values, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeBetween(Short value1, Short value2) {
            addCriterion("IDENTITY_TYPE between", value1, value2, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityTypeNotBetween(Short value1, Short value2) {
            addCriterion("IDENTITY_TYPE not between", value1, value2, "identityType");
            return (Criteria) this;
        }

        public Criteria andIdentityNumIsNull() {
            addCriterion("IDENTITY_NUM is null");
            return (Criteria) this;
        }

        public Criteria andIdentityNumIsNotNull() {
            addCriterion("IDENTITY_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityNumEqualTo(String value) {
            addCriterion("IDENTITY_NUM =", value, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumNotEqualTo(String value) {
            addCriterion("IDENTITY_NUM <>", value, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumGreaterThan(String value) {
            addCriterion("IDENTITY_NUM >", value, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumGreaterThanOrEqualTo(String value) {
            addCriterion("IDENTITY_NUM >=", value, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumLessThan(String value) {
            addCriterion("IDENTITY_NUM <", value, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumLessThanOrEqualTo(String value) {
            addCriterion("IDENTITY_NUM <=", value, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumLike(String value) {
            addCriterion("IDENTITY_NUM like", value, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumNotLike(String value) {
            addCriterion("IDENTITY_NUM not like", value, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumIn(List<String> values) {
            addCriterion("IDENTITY_NUM in", values, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumNotIn(List<String> values) {
            addCriterion("IDENTITY_NUM not in", values, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumBetween(String value1, String value2) {
            addCriterion("IDENTITY_NUM between", value1, value2, "identityNum");
            return (Criteria) this;
        }

        public Criteria andIdentityNumNotBetween(String value1, String value2) {
            addCriterion("IDENTITY_NUM not between", value1, value2, "identityNum");
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

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(Long value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(Long value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(Long value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(Long value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(Long value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(Long value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<Long> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<Long> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(Long value1, Long value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(Long value1, Long value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyIsNull() {
            addCriterion("ARREARS_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyIsNotNull() {
            addCriterion("ARREARS_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyEqualTo(Integer value) {
            addCriterion("ARREARS_MONEY =", value, "arrearsMoney");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyNotEqualTo(Integer value) {
            addCriterion("ARREARS_MONEY <>", value, "arrearsMoney");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyGreaterThan(Integer value) {
            addCriterion("ARREARS_MONEY >", value, "arrearsMoney");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("ARREARS_MONEY >=", value, "arrearsMoney");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyLessThan(Integer value) {
            addCriterion("ARREARS_MONEY <", value, "arrearsMoney");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("ARREARS_MONEY <=", value, "arrearsMoney");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyIn(List<Integer> values) {
            addCriterion("ARREARS_MONEY in", values, "arrearsMoney");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyNotIn(List<Integer> values) {
            addCriterion("ARREARS_MONEY not in", values, "arrearsMoney");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyBetween(Integer value1, Integer value2) {
            addCriterion("ARREARS_MONEY between", value1, value2, "arrearsMoney");
            return (Criteria) this;
        }

        public Criteria andArrearsMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("ARREARS_MONEY not between", value1, value2, "arrearsMoney");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthIsNull() {
            addCriterion("ARREARS_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthIsNotNull() {
            addCriterion("ARREARS_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthEqualTo(Integer value) {
            addCriterion("ARREARS_MONTH =", value, "arrearsMonth");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthNotEqualTo(Integer value) {
            addCriterion("ARREARS_MONTH <>", value, "arrearsMonth");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthGreaterThan(Integer value) {
            addCriterion("ARREARS_MONTH >", value, "arrearsMonth");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("ARREARS_MONTH >=", value, "arrearsMonth");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthLessThan(Integer value) {
            addCriterion("ARREARS_MONTH <", value, "arrearsMonth");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthLessThanOrEqualTo(Integer value) {
            addCriterion("ARREARS_MONTH <=", value, "arrearsMonth");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthIn(List<Integer> values) {
            addCriterion("ARREARS_MONTH in", values, "arrearsMonth");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthNotIn(List<Integer> values) {
            addCriterion("ARREARS_MONTH not in", values, "arrearsMonth");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthBetween(Integer value1, Integer value2) {
            addCriterion("ARREARS_MONTH between", value1, value2, "arrearsMonth");
            return (Criteria) this;
        }

        public Criteria andArrearsMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("ARREARS_MONTH not between", value1, value2, "arrearsMonth");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyIsNull() {
            addCriterion("ACCOUNT_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyIsNotNull() {
            addCriterion("ACCOUNT_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyEqualTo(Integer value) {
            addCriterion("ACCOUNT_MONEY =", value, "accountMoney");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyNotEqualTo(Integer value) {
            addCriterion("ACCOUNT_MONEY <>", value, "accountMoney");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyGreaterThan(Integer value) {
            addCriterion("ACCOUNT_MONEY >", value, "accountMoney");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACCOUNT_MONEY >=", value, "accountMoney");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyLessThan(Integer value) {
            addCriterion("ACCOUNT_MONEY <", value, "accountMoney");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("ACCOUNT_MONEY <=", value, "accountMoney");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyIn(List<Integer> values) {
            addCriterion("ACCOUNT_MONEY in", values, "accountMoney");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyNotIn(List<Integer> values) {
            addCriterion("ACCOUNT_MONEY not in", values, "accountMoney");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyBetween(Integer value1, Integer value2) {
            addCriterion("ACCOUNT_MONEY between", value1, value2, "accountMoney");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("ACCOUNT_MONEY not between", value1, value2, "accountMoney");
            return (Criteria) this;
        }

        public Criteria andCountsIsNull() {
            addCriterion("COUNTS is null");
            return (Criteria) this;
        }

        public Criteria andCountsIsNotNull() {
            addCriterion("COUNTS is not null");
            return (Criteria) this;
        }

        public Criteria andCountsEqualTo(Integer value) {
            addCriterion("COUNTS =", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotEqualTo(Integer value) {
            addCriterion("COUNTS <>", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsGreaterThan(Integer value) {
            addCriterion("COUNTS >", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("COUNTS >=", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsLessThan(Integer value) {
            addCriterion("COUNTS <", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsLessThanOrEqualTo(Integer value) {
            addCriterion("COUNTS <=", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsIn(List<Integer> values) {
            addCriterion("COUNTS in", values, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotIn(List<Integer> values) {
            addCriterion("COUNTS not in", values, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsBetween(Integer value1, Integer value2) {
            addCriterion("COUNTS between", value1, value2, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("COUNTS not between", value1, value2, "counts");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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