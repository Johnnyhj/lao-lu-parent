package com.ai.ge.platform.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlatformUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlatformUserExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueIsNull() {
            addCriterion("USER_TYPE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueIsNotNull() {
            addCriterion("USER_TYPE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueEqualTo(String value) {
            addCriterion("USER_TYPE_VALUE =", value, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueNotEqualTo(String value) {
            addCriterion("USER_TYPE_VALUE <>", value, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueGreaterThan(String value) {
            addCriterion("USER_TYPE_VALUE >", value, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TYPE_VALUE >=", value, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueLessThan(String value) {
            addCriterion("USER_TYPE_VALUE <", value, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueLessThanOrEqualTo(String value) {
            addCriterion("USER_TYPE_VALUE <=", value, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueLike(String value) {
            addCriterion("USER_TYPE_VALUE like", value, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueNotLike(String value) {
            addCriterion("USER_TYPE_VALUE not like", value, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueIn(List<String> values) {
            addCriterion("USER_TYPE_VALUE in", values, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueNotIn(List<String> values) {
            addCriterion("USER_TYPE_VALUE not in", values, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueBetween(String value1, String value2) {
            addCriterion("USER_TYPE_VALUE between", value1, value2, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserTypeValueNotBetween(String value1, String value2) {
            addCriterion("USER_TYPE_VALUE not between", value1, value2, "userTypeValue");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("USER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("USER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(String value) {
            addCriterion("USER_STATUS =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(String value) {
            addCriterion("USER_STATUS <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(String value) {
            addCriterion("USER_STATUS >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(String value) {
            addCriterion("USER_STATUS >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(String value) {
            addCriterion("USER_STATUS <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(String value) {
            addCriterion("USER_STATUS <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLike(String value) {
            addCriterion("USER_STATUS like", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotLike(String value) {
            addCriterion("USER_STATUS not like", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<String> values) {
            addCriterion("USER_STATUS in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<String> values) {
            addCriterion("USER_STATUS not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(String value1, String value2) {
            addCriterion("USER_STATUS between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(String value1, String value2) {
            addCriterion("USER_STATUS not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andFirmNameIsNull() {
            addCriterion("FIRM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFirmNameIsNotNull() {
            addCriterion("FIRM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFirmNameEqualTo(String value) {
            addCriterion("FIRM_NAME =", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotEqualTo(String value) {
            addCriterion("FIRM_NAME <>", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameGreaterThan(String value) {
            addCriterion("FIRM_NAME >", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameGreaterThanOrEqualTo(String value) {
            addCriterion("FIRM_NAME >=", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameLessThan(String value) {
            addCriterion("FIRM_NAME <", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameLessThanOrEqualTo(String value) {
            addCriterion("FIRM_NAME <=", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameLike(String value) {
            addCriterion("FIRM_NAME like", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotLike(String value) {
            addCriterion("FIRM_NAME not like", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameIn(List<String> values) {
            addCriterion("FIRM_NAME in", values, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotIn(List<String> values) {
            addCriterion("FIRM_NAME not in", values, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameBetween(String value1, String value2) {
            addCriterion("FIRM_NAME between", value1, value2, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotBetween(String value1, String value2) {
            addCriterion("FIRM_NAME not between", value1, value2, "firmName");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("REAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("REAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("REAL_NAME =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("REAL_NAME <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("REAL_NAME >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("REAL_NAME >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("REAL_NAME <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("REAL_NAME <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("REAL_NAME like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("REAL_NAME not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("REAL_NAME in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("REAL_NAME not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("REAL_NAME between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("REAL_NAME not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNull() {
            addCriterion("CERT_NO is null");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNotNull() {
            addCriterion("CERT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCertNoEqualTo(String value) {
            addCriterion("CERT_NO =", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotEqualTo(String value) {
            addCriterion("CERT_NO <>", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThan(String value) {
            addCriterion("CERT_NO >", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_NO >=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThan(String value) {
            addCriterion("CERT_NO <", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThanOrEqualTo(String value) {
            addCriterion("CERT_NO <=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLike(String value) {
            addCriterion("CERT_NO like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotLike(String value) {
            addCriterion("CERT_NO not like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoIn(List<String> values) {
            addCriterion("CERT_NO in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotIn(List<String> values) {
            addCriterion("CERT_NO not in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoBetween(String value1, String value2) {
            addCriterion("CERT_NO between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotBetween(String value1, String value2) {
            addCriterion("CERT_NO not between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("GENDER =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("GENDER <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("GENDER >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("GENDER >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("GENDER <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("GENDER <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("GENDER like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("GENDER not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("GENDER in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("GENDER not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("GENDER between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("GENDER not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueIsNull() {
            addCriterion("CERT_TYPE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueIsNotNull() {
            addCriterion("CERT_TYPE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueEqualTo(String value) {
            addCriterion("CERT_TYPE_VALUE =", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueNotEqualTo(String value) {
            addCriterion("CERT_TYPE_VALUE <>", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueGreaterThan(String value) {
            addCriterion("CERT_TYPE_VALUE >", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE_VALUE >=", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueLessThan(String value) {
            addCriterion("CERT_TYPE_VALUE <", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueLessThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE_VALUE <=", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueLike(String value) {
            addCriterion("CERT_TYPE_VALUE like", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueNotLike(String value) {
            addCriterion("CERT_TYPE_VALUE not like", value, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueIn(List<String> values) {
            addCriterion("CERT_TYPE_VALUE in", values, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueNotIn(List<String> values) {
            addCriterion("CERT_TYPE_VALUE not in", values, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueBetween(String value1, String value2) {
            addCriterion("CERT_TYPE_VALUE between", value1, value2, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andCertTypeValueNotBetween(String value1, String value2) {
            addCriterion("CERT_TYPE_VALUE not between", value1, value2, "certTypeValue");
            return (Criteria) this;
        }

        public Criteria andAddressCodeIsNull() {
            addCriterion("ADDRESS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAddressCodeIsNotNull() {
            addCriterion("ADDRESS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCodeEqualTo(String value) {
            addCriterion("ADDRESS_CODE =", value, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeNotEqualTo(String value) {
            addCriterion("ADDRESS_CODE <>", value, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeGreaterThan(String value) {
            addCriterion("ADDRESS_CODE >", value, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS_CODE >=", value, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeLessThan(String value) {
            addCriterion("ADDRESS_CODE <", value, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS_CODE <=", value, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeLike(String value) {
            addCriterion("ADDRESS_CODE like", value, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeNotLike(String value) {
            addCriterion("ADDRESS_CODE not like", value, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeIn(List<String> values) {
            addCriterion("ADDRESS_CODE in", values, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeNotIn(List<String> values) {
            addCriterion("ADDRESS_CODE not in", values, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeBetween(String value1, String value2) {
            addCriterion("ADDRESS_CODE between", value1, value2, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAddressCodeNotBetween(String value1, String value2) {
            addCriterion("ADDRESS_CODE not between", value1, value2, "addressCode");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdIsNull() {
            addCriterion("ALIPAY_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdIsNotNull() {
            addCriterion("ALIPAY_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdEqualTo(String value) {
            addCriterion("ALIPAY_USER_ID =", value, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdNotEqualTo(String value) {
            addCriterion("ALIPAY_USER_ID <>", value, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdGreaterThan(String value) {
            addCriterion("ALIPAY_USER_ID >", value, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("ALIPAY_USER_ID >=", value, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdLessThan(String value) {
            addCriterion("ALIPAY_USER_ID <", value, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdLessThanOrEqualTo(String value) {
            addCriterion("ALIPAY_USER_ID <=", value, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdLike(String value) {
            addCriterion("ALIPAY_USER_ID like", value, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdNotLike(String value) {
            addCriterion("ALIPAY_USER_ID not like", value, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdIn(List<String> values) {
            addCriterion("ALIPAY_USER_ID in", values, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdNotIn(List<String> values) {
            addCriterion("ALIPAY_USER_ID not in", values, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdBetween(String value1, String value2) {
            addCriterion("ALIPAY_USER_ID between", value1, value2, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andAlipayUserIdNotBetween(String value1, String value2) {
            addCriterion("ALIPAY_USER_ID not between", value1, value2, "alipayUserId");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlIsNull() {
            addCriterion("IDCARD_CORRECT_URL is null");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlIsNotNull() {
            addCriterion("IDCARD_CORRECT_URL is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlEqualTo(String value) {
            addCriterion("IDCARD_CORRECT_URL =", value, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlNotEqualTo(String value) {
            addCriterion("IDCARD_CORRECT_URL <>", value, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlGreaterThan(String value) {
            addCriterion("IDCARD_CORRECT_URL >", value, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlGreaterThanOrEqualTo(String value) {
            addCriterion("IDCARD_CORRECT_URL >=", value, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlLessThan(String value) {
            addCriterion("IDCARD_CORRECT_URL <", value, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlLessThanOrEqualTo(String value) {
            addCriterion("IDCARD_CORRECT_URL <=", value, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlLike(String value) {
            addCriterion("IDCARD_CORRECT_URL like", value, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlNotLike(String value) {
            addCriterion("IDCARD_CORRECT_URL not like", value, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlIn(List<String> values) {
            addCriterion("IDCARD_CORRECT_URL in", values, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlNotIn(List<String> values) {
            addCriterion("IDCARD_CORRECT_URL not in", values, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlBetween(String value1, String value2) {
            addCriterion("IDCARD_CORRECT_URL between", value1, value2, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardCorrectUrlNotBetween(String value1, String value2) {
            addCriterion("IDCARD_CORRECT_URL not between", value1, value2, "idcardCorrectUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlIsNull() {
            addCriterion("IDCARD_OPPOSITE_URL is null");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlIsNotNull() {
            addCriterion("IDCARD_OPPOSITE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlEqualTo(String value) {
            addCriterion("IDCARD_OPPOSITE_URL =", value, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlNotEqualTo(String value) {
            addCriterion("IDCARD_OPPOSITE_URL <>", value, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlGreaterThan(String value) {
            addCriterion("IDCARD_OPPOSITE_URL >", value, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("IDCARD_OPPOSITE_URL >=", value, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlLessThan(String value) {
            addCriterion("IDCARD_OPPOSITE_URL <", value, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlLessThanOrEqualTo(String value) {
            addCriterion("IDCARD_OPPOSITE_URL <=", value, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlLike(String value) {
            addCriterion("IDCARD_OPPOSITE_URL like", value, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlNotLike(String value) {
            addCriterion("IDCARD_OPPOSITE_URL not like", value, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlIn(List<String> values) {
            addCriterion("IDCARD_OPPOSITE_URL in", values, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlNotIn(List<String> values) {
            addCriterion("IDCARD_OPPOSITE_URL not in", values, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlBetween(String value1, String value2) {
            addCriterion("IDCARD_OPPOSITE_URL between", value1, value2, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardOppositeUrlNotBetween(String value1, String value2) {
            addCriterion("IDCARD_OPPOSITE_URL not between", value1, value2, "idcardOppositeUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlIsNull() {
            addCriterion("IDCARD_HAND_URL is null");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlIsNotNull() {
            addCriterion("IDCARD_HAND_URL is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlEqualTo(String value) {
            addCriterion("IDCARD_HAND_URL =", value, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlNotEqualTo(String value) {
            addCriterion("IDCARD_HAND_URL <>", value, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlGreaterThan(String value) {
            addCriterion("IDCARD_HAND_URL >", value, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlGreaterThanOrEqualTo(String value) {
            addCriterion("IDCARD_HAND_URL >=", value, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlLessThan(String value) {
            addCriterion("IDCARD_HAND_URL <", value, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlLessThanOrEqualTo(String value) {
            addCriterion("IDCARD_HAND_URL <=", value, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlLike(String value) {
            addCriterion("IDCARD_HAND_URL like", value, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlNotLike(String value) {
            addCriterion("IDCARD_HAND_URL not like", value, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlIn(List<String> values) {
            addCriterion("IDCARD_HAND_URL in", values, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlNotIn(List<String> values) {
            addCriterion("IDCARD_HAND_URL not in", values, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlBetween(String value1, String value2) {
            addCriterion("IDCARD_HAND_URL between", value1, value2, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andIdcardHandUrlNotBetween(String value1, String value2) {
            addCriterion("IDCARD_HAND_URL not between", value1, value2, "idcardHandUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("AVATAR is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("AVATAR is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("AVATAR =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("AVATAR <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("AVATAR >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("AVATAR >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("AVATAR <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("AVATAR <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("AVATAR like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("AVATAR not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("AVATAR in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("AVATAR not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("AVATAR between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("AVATAR not between", value1, value2, "avatar");
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

        public Criteria andIsCertifiedIsNull() {
            addCriterion("IS_CERTIFIED is null");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedIsNotNull() {
            addCriterion("IS_CERTIFIED is not null");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedEqualTo(String value) {
            addCriterion("IS_CERTIFIED =", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedNotEqualTo(String value) {
            addCriterion("IS_CERTIFIED <>", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedGreaterThan(String value) {
            addCriterion("IS_CERTIFIED >", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_CERTIFIED >=", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedLessThan(String value) {
            addCriterion("IS_CERTIFIED <", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedLessThanOrEqualTo(String value) {
            addCriterion("IS_CERTIFIED <=", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedLike(String value) {
            addCriterion("IS_CERTIFIED like", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedNotLike(String value) {
            addCriterion("IS_CERTIFIED not like", value, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedIn(List<String> values) {
            addCriterion("IS_CERTIFIED in", values, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedNotIn(List<String> values) {
            addCriterion("IS_CERTIFIED not in", values, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedBetween(String value1, String value2) {
            addCriterion("IS_CERTIFIED between", value1, value2, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifiedNotBetween(String value1, String value2) {
            addCriterion("IS_CERTIFIED not between", value1, value2, "isCertified");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthIsNull() {
            addCriterion("IS_BANK_AUTH is null");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthIsNotNull() {
            addCriterion("IS_BANK_AUTH is not null");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthEqualTo(String value) {
            addCriterion("IS_BANK_AUTH =", value, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthNotEqualTo(String value) {
            addCriterion("IS_BANK_AUTH <>", value, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthGreaterThan(String value) {
            addCriterion("IS_BANK_AUTH >", value, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthGreaterThanOrEqualTo(String value) {
            addCriterion("IS_BANK_AUTH >=", value, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthLessThan(String value) {
            addCriterion("IS_BANK_AUTH <", value, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthLessThanOrEqualTo(String value) {
            addCriterion("IS_BANK_AUTH <=", value, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthLike(String value) {
            addCriterion("IS_BANK_AUTH like", value, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthNotLike(String value) {
            addCriterion("IS_BANK_AUTH not like", value, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthIn(List<String> values) {
            addCriterion("IS_BANK_AUTH in", values, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthNotIn(List<String> values) {
            addCriterion("IS_BANK_AUTH not in", values, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthBetween(String value1, String value2) {
            addCriterion("IS_BANK_AUTH between", value1, value2, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsBankAuthNotBetween(String value1, String value2) {
            addCriterion("IS_BANK_AUTH not between", value1, value2, "isBankAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthIsNull() {
            addCriterion("IS_ID_AUTH is null");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthIsNotNull() {
            addCriterion("IS_ID_AUTH is not null");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthEqualTo(String value) {
            addCriterion("IS_ID_AUTH =", value, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthNotEqualTo(String value) {
            addCriterion("IS_ID_AUTH <>", value, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthGreaterThan(String value) {
            addCriterion("IS_ID_AUTH >", value, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthGreaterThanOrEqualTo(String value) {
            addCriterion("IS_ID_AUTH >=", value, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthLessThan(String value) {
            addCriterion("IS_ID_AUTH <", value, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthLessThanOrEqualTo(String value) {
            addCriterion("IS_ID_AUTH <=", value, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthLike(String value) {
            addCriterion("IS_ID_AUTH like", value, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthNotLike(String value) {
            addCriterion("IS_ID_AUTH not like", value, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthIn(List<String> values) {
            addCriterion("IS_ID_AUTH in", values, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthNotIn(List<String> values) {
            addCriterion("IS_ID_AUTH not in", values, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthBetween(String value1, String value2) {
            addCriterion("IS_ID_AUTH between", value1, value2, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsIdAuthNotBetween(String value1, String value2) {
            addCriterion("IS_ID_AUTH not between", value1, value2, "isIdAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthIsNull() {
            addCriterion("IS_MOBILE_AUTH is null");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthIsNotNull() {
            addCriterion("IS_MOBILE_AUTH is not null");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthEqualTo(String value) {
            addCriterion("IS_MOBILE_AUTH =", value, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthNotEqualTo(String value) {
            addCriterion("IS_MOBILE_AUTH <>", value, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthGreaterThan(String value) {
            addCriterion("IS_MOBILE_AUTH >", value, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthGreaterThanOrEqualTo(String value) {
            addCriterion("IS_MOBILE_AUTH >=", value, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthLessThan(String value) {
            addCriterion("IS_MOBILE_AUTH <", value, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthLessThanOrEqualTo(String value) {
            addCriterion("IS_MOBILE_AUTH <=", value, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthLike(String value) {
            addCriterion("IS_MOBILE_AUTH like", value, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthNotLike(String value) {
            addCriterion("IS_MOBILE_AUTH not like", value, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthIn(List<String> values) {
            addCriterion("IS_MOBILE_AUTH in", values, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthNotIn(List<String> values) {
            addCriterion("IS_MOBILE_AUTH not in", values, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthBetween(String value1, String value2) {
            addCriterion("IS_MOBILE_AUTH between", value1, value2, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthNotBetween(String value1, String value2) {
            addCriterion("IS_MOBILE_AUTH not between", value1, value2, "isMobileAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthIsNull() {
            addCriterion("IS_LICENCE_AUTH is null");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthIsNotNull() {
            addCriterion("IS_LICENCE_AUTH is not null");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthEqualTo(String value) {
            addCriterion("IS_LICENCE_AUTH =", value, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthNotEqualTo(String value) {
            addCriterion("IS_LICENCE_AUTH <>", value, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthGreaterThan(String value) {
            addCriterion("IS_LICENCE_AUTH >", value, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthGreaterThanOrEqualTo(String value) {
            addCriterion("IS_LICENCE_AUTH >=", value, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthLessThan(String value) {
            addCriterion("IS_LICENCE_AUTH <", value, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthLessThanOrEqualTo(String value) {
            addCriterion("IS_LICENCE_AUTH <=", value, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthLike(String value) {
            addCriterion("IS_LICENCE_AUTH like", value, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthNotLike(String value) {
            addCriterion("IS_LICENCE_AUTH not like", value, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthIn(List<String> values) {
            addCriterion("IS_LICENCE_AUTH in", values, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthNotIn(List<String> values) {
            addCriterion("IS_LICENCE_AUTH not in", values, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthBetween(String value1, String value2) {
            addCriterion("IS_LICENCE_AUTH between", value1, value2, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andIsLicenceAuthNotBetween(String value1, String value2) {
            addCriterion("IS_LICENCE_AUTH not between", value1, value2, "isLicenceAuth");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneIsNull() {
            addCriterion("DELIVER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneIsNotNull() {
            addCriterion("DELIVER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneEqualTo(String value) {
            addCriterion("DELIVER_PHONE =", value, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneNotEqualTo(String value) {
            addCriterion("DELIVER_PHONE <>", value, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneGreaterThan(String value) {
            addCriterion("DELIVER_PHONE >", value, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVER_PHONE >=", value, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneLessThan(String value) {
            addCriterion("DELIVER_PHONE <", value, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneLessThanOrEqualTo(String value) {
            addCriterion("DELIVER_PHONE <=", value, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneLike(String value) {
            addCriterion("DELIVER_PHONE like", value, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneNotLike(String value) {
            addCriterion("DELIVER_PHONE not like", value, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneIn(List<String> values) {
            addCriterion("DELIVER_PHONE in", values, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneNotIn(List<String> values) {
            addCriterion("DELIVER_PHONE not in", values, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneBetween(String value1, String value2) {
            addCriterion("DELIVER_PHONE between", value1, value2, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverPhoneNotBetween(String value1, String value2) {
            addCriterion("DELIVER_PHONE not between", value1, value2, "deliverPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileIsNull() {
            addCriterion("DELIVER_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileIsNotNull() {
            addCriterion("DELIVER_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileEqualTo(String value) {
            addCriterion("DELIVER_MOBILE =", value, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileNotEqualTo(String value) {
            addCriterion("DELIVER_MOBILE <>", value, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileGreaterThan(String value) {
            addCriterion("DELIVER_MOBILE >", value, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVER_MOBILE >=", value, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileLessThan(String value) {
            addCriterion("DELIVER_MOBILE <", value, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileLessThanOrEqualTo(String value) {
            addCriterion("DELIVER_MOBILE <=", value, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileLike(String value) {
            addCriterion("DELIVER_MOBILE like", value, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileNotLike(String value) {
            addCriterion("DELIVER_MOBILE not like", value, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileIn(List<String> values) {
            addCriterion("DELIVER_MOBILE in", values, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileNotIn(List<String> values) {
            addCriterion("DELIVER_MOBILE not in", values, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileBetween(String value1, String value2) {
            addCriterion("DELIVER_MOBILE between", value1, value2, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverMobileNotBetween(String value1, String value2) {
            addCriterion("DELIVER_MOBILE not between", value1, value2, "deliverMobile");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameIsNull() {
            addCriterion("DELIVER_FULLNAME is null");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameIsNotNull() {
            addCriterion("DELIVER_FULLNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameEqualTo(String value) {
            addCriterion("DELIVER_FULLNAME =", value, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameNotEqualTo(String value) {
            addCriterion("DELIVER_FULLNAME <>", value, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameGreaterThan(String value) {
            addCriterion("DELIVER_FULLNAME >", value, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVER_FULLNAME >=", value, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameLessThan(String value) {
            addCriterion("DELIVER_FULLNAME <", value, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameLessThanOrEqualTo(String value) {
            addCriterion("DELIVER_FULLNAME <=", value, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameLike(String value) {
            addCriterion("DELIVER_FULLNAME like", value, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameNotLike(String value) {
            addCriterion("DELIVER_FULLNAME not like", value, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameIn(List<String> values) {
            addCriterion("DELIVER_FULLNAME in", values, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameNotIn(List<String> values) {
            addCriterion("DELIVER_FULLNAME not in", values, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameBetween(String value1, String value2) {
            addCriterion("DELIVER_FULLNAME between", value1, value2, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andDeliverFullnameNotBetween(String value1, String value2) {
            addCriterion("DELIVER_FULLNAME not between", value1, value2, "deliverFullname");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("PROVINCE =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("PROVINCE <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("PROVINCE >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("PROVINCE <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("PROVINCE like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("PROVINCE not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("PROVINCE in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("PROVINCE not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("PROVINCE between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("PROVINCE not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("CITY like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("CITY not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("CITY not between", value1, value2, "city");
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

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andZipIsNull() {
            addCriterion("ZIP is null");
            return (Criteria) this;
        }

        public Criteria andZipIsNotNull() {
            addCriterion("ZIP is not null");
            return (Criteria) this;
        }

        public Criteria andZipEqualTo(String value) {
            addCriterion("ZIP =", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotEqualTo(String value) {
            addCriterion("ZIP <>", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThan(String value) {
            addCriterion("ZIP >", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThanOrEqualTo(String value) {
            addCriterion("ZIP >=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThan(String value) {
            addCriterion("ZIP <", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThanOrEqualTo(String value) {
            addCriterion("ZIP <=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLike(String value) {
            addCriterion("ZIP like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotLike(String value) {
            addCriterion("ZIP not like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipIn(List<String> values) {
            addCriterion("ZIP in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotIn(List<String> values) {
            addCriterion("ZIP not in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipBetween(String value1, String value2) {
            addCriterion("ZIP between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotBetween(String value1, String value2) {
            addCriterion("ZIP not between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceIsNull() {
            addCriterion("DELIVER_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceIsNotNull() {
            addCriterion("DELIVER_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceEqualTo(String value) {
            addCriterion("DELIVER_PROVINCE =", value, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceNotEqualTo(String value) {
            addCriterion("DELIVER_PROVINCE <>", value, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceGreaterThan(String value) {
            addCriterion("DELIVER_PROVINCE >", value, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVER_PROVINCE >=", value, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceLessThan(String value) {
            addCriterion("DELIVER_PROVINCE <", value, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceLessThanOrEqualTo(String value) {
            addCriterion("DELIVER_PROVINCE <=", value, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceLike(String value) {
            addCriterion("DELIVER_PROVINCE like", value, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceNotLike(String value) {
            addCriterion("DELIVER_PROVINCE not like", value, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceIn(List<String> values) {
            addCriterion("DELIVER_PROVINCE in", values, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceNotIn(List<String> values) {
            addCriterion("DELIVER_PROVINCE not in", values, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceBetween(String value1, String value2) {
            addCriterion("DELIVER_PROVINCE between", value1, value2, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverProvinceNotBetween(String value1, String value2) {
            addCriterion("DELIVER_PROVINCE not between", value1, value2, "deliverProvince");
            return (Criteria) this;
        }

        public Criteria andDeliverCityIsNull() {
            addCriterion("DELIVER_CITY is null");
            return (Criteria) this;
        }

        public Criteria andDeliverCityIsNotNull() {
            addCriterion("DELIVER_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverCityEqualTo(String value) {
            addCriterion("DELIVER_CITY =", value, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityNotEqualTo(String value) {
            addCriterion("DELIVER_CITY <>", value, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityGreaterThan(String value) {
            addCriterion("DELIVER_CITY >", value, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVER_CITY >=", value, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityLessThan(String value) {
            addCriterion("DELIVER_CITY <", value, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityLessThanOrEqualTo(String value) {
            addCriterion("DELIVER_CITY <=", value, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityLike(String value) {
            addCriterion("DELIVER_CITY like", value, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityNotLike(String value) {
            addCriterion("DELIVER_CITY not like", value, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityIn(List<String> values) {
            addCriterion("DELIVER_CITY in", values, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityNotIn(List<String> values) {
            addCriterion("DELIVER_CITY not in", values, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityBetween(String value1, String value2) {
            addCriterion("DELIVER_CITY between", value1, value2, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverCityNotBetween(String value1, String value2) {
            addCriterion("DELIVER_CITY not between", value1, value2, "deliverCity");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaIsNull() {
            addCriterion("DELIVER_AREA is null");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaIsNotNull() {
            addCriterion("DELIVER_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaEqualTo(String value) {
            addCriterion("DELIVER_AREA =", value, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaNotEqualTo(String value) {
            addCriterion("DELIVER_AREA <>", value, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaGreaterThan(String value) {
            addCriterion("DELIVER_AREA >", value, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVER_AREA >=", value, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaLessThan(String value) {
            addCriterion("DELIVER_AREA <", value, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaLessThanOrEqualTo(String value) {
            addCriterion("DELIVER_AREA <=", value, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaLike(String value) {
            addCriterion("DELIVER_AREA like", value, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaNotLike(String value) {
            addCriterion("DELIVER_AREA not like", value, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaIn(List<String> values) {
            addCriterion("DELIVER_AREA in", values, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaNotIn(List<String> values) {
            addCriterion("DELIVER_AREA not in", values, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaBetween(String value1, String value2) {
            addCriterion("DELIVER_AREA between", value1, value2, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDeliverAreaNotBetween(String value1, String value2) {
            addCriterion("DELIVER_AREA not between", value1, value2, "deliverArea");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressIsNull() {
            addCriterion("DEFAULT_DELIVER_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressIsNotNull() {
            addCriterion("DEFAULT_DELIVER_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressEqualTo(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRESS =", value, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressNotEqualTo(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRESS <>", value, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressGreaterThan(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRESS >", value, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRESS >=", value, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressLessThan(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRESS <", value, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressLessThanOrEqualTo(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRESS <=", value, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressLike(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRESS like", value, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressNotLike(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRESS not like", value, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressIn(List<String> values) {
            addCriterion("DEFAULT_DELIVER_ADDRESS in", values, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressNotIn(List<String> values) {
            addCriterion("DEFAULT_DELIVER_ADDRESS not in", values, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressBetween(String value1, String value2) {
            addCriterion("DEFAULT_DELIVER_ADDRESS between", value1, value2, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddressNotBetween(String value1, String value2) {
            addCriterion("DEFAULT_DELIVER_ADDRESS not between", value1, value2, "defaultDeliverAddress");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedIsNull() {
            addCriterion("IS_STUDENT_CERTIFIED is null");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedIsNotNull() {
            addCriterion("IS_STUDENT_CERTIFIED is not null");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedEqualTo(String value) {
            addCriterion("IS_STUDENT_CERTIFIED =", value, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedNotEqualTo(String value) {
            addCriterion("IS_STUDENT_CERTIFIED <>", value, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedGreaterThan(String value) {
            addCriterion("IS_STUDENT_CERTIFIED >", value, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_STUDENT_CERTIFIED >=", value, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedLessThan(String value) {
            addCriterion("IS_STUDENT_CERTIFIED <", value, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedLessThanOrEqualTo(String value) {
            addCriterion("IS_STUDENT_CERTIFIED <=", value, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedLike(String value) {
            addCriterion("IS_STUDENT_CERTIFIED like", value, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedNotLike(String value) {
            addCriterion("IS_STUDENT_CERTIFIED not like", value, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedIn(List<String> values) {
            addCriterion("IS_STUDENT_CERTIFIED in", values, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedNotIn(List<String> values) {
            addCriterion("IS_STUDENT_CERTIFIED not in", values, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedBetween(String value1, String value2) {
            addCriterion("IS_STUDENT_CERTIFIED between", value1, value2, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsStudentCertifiedNotBetween(String value1, String value2) {
            addCriterion("IS_STUDENT_CERTIFIED not between", value1, value2, "isStudentCertified");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeAIsNull() {
            addCriterion("IS_CERTIFY_GRADE_A is null");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeAIsNotNull() {
            addCriterion("IS_CERTIFY_GRADE_A is not null");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeAEqualTo(String value) {
            addCriterion("IS_CERTIFY_GRADE_A =", value, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeANotEqualTo(String value) {
            addCriterion("IS_CERTIFY_GRADE_A <>", value, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeAGreaterThan(String value) {
            addCriterion("IS_CERTIFY_GRADE_A >", value, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeAGreaterThanOrEqualTo(String value) {
            addCriterion("IS_CERTIFY_GRADE_A >=", value, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeALessThan(String value) {
            addCriterion("IS_CERTIFY_GRADE_A <", value, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeALessThanOrEqualTo(String value) {
            addCriterion("IS_CERTIFY_GRADE_A <=", value, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeALike(String value) {
            addCriterion("IS_CERTIFY_GRADE_A like", value, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeANotLike(String value) {
            addCriterion("IS_CERTIFY_GRADE_A not like", value, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeAIn(List<String> values) {
            addCriterion("IS_CERTIFY_GRADE_A in", values, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeANotIn(List<String> values) {
            addCriterion("IS_CERTIFY_GRADE_A not in", values, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeABetween(String value1, String value2) {
            addCriterion("IS_CERTIFY_GRADE_A between", value1, value2, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andIsCertifyGradeANotBetween(String value1, String value2) {
            addCriterion("IS_CERTIFY_GRADE_A not between", value1, value2, "isCertifyGradeA");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("BIRTHDAY =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("BIRTHDAY <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("BIRTHDAY >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("BIRTHDAY >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("BIRTHDAY <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("BIRTHDAY <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("BIRTHDAY like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("BIRTHDAY not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("BIRTHDAY in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("BIRTHDAY not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("BIRTHDAY between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("BIRTHDAY not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("NICK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("NICK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("NICK_NAME =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("NICK_NAME <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("NICK_NAME >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("NICK_NAME >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("NICK_NAME <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("NICK_NAME <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("NICK_NAME like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("NICK_NAME not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("NICK_NAME in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("NICK_NAME not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("NICK_NAME between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("NICK_NAME not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameIsNull() {
            addCriterion("FAMILY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFamilyNameIsNotNull() {
            addCriterion("FAMILY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyNameEqualTo(String value) {
            addCriterion("FAMILY_NAME =", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotEqualTo(String value) {
            addCriterion("FAMILY_NAME <>", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameGreaterThan(String value) {
            addCriterion("FAMILY_NAME >", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameGreaterThanOrEqualTo(String value) {
            addCriterion("FAMILY_NAME >=", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameLessThan(String value) {
            addCriterion("FAMILY_NAME <", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameLessThanOrEqualTo(String value) {
            addCriterion("FAMILY_NAME <=", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameLike(String value) {
            addCriterion("FAMILY_NAME like", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotLike(String value) {
            addCriterion("FAMILY_NAME not like", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameIn(List<String> values) {
            addCriterion("FAMILY_NAME in", values, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotIn(List<String> values) {
            addCriterion("FAMILY_NAME not in", values, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameBetween(String value1, String value2) {
            addCriterion("FAMILY_NAME between", value1, value2, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotBetween(String value1, String value2) {
            addCriterion("FAMILY_NAME not between", value1, value2, "familyName");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayIsNull() {
            addCriterion("REDUCED_BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayIsNotNull() {
            addCriterion("REDUCED_BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayEqualTo(String value) {
            addCriterion("REDUCED_BIRTHDAY =", value, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayNotEqualTo(String value) {
            addCriterion("REDUCED_BIRTHDAY <>", value, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayGreaterThan(String value) {
            addCriterion("REDUCED_BIRTHDAY >", value, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("REDUCED_BIRTHDAY >=", value, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayLessThan(String value) {
            addCriterion("REDUCED_BIRTHDAY <", value, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayLessThanOrEqualTo(String value) {
            addCriterion("REDUCED_BIRTHDAY <=", value, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayLike(String value) {
            addCriterion("REDUCED_BIRTHDAY like", value, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayNotLike(String value) {
            addCriterion("REDUCED_BIRTHDAY not like", value, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayIn(List<String> values) {
            addCriterion("REDUCED_BIRTHDAY in", values, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayNotIn(List<String> values) {
            addCriterion("REDUCED_BIRTHDAY not in", values, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayBetween(String value1, String value2) {
            addCriterion("REDUCED_BIRTHDAY between", value1, value2, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andReducedBirthdayNotBetween(String value1, String value2) {
            addCriterion("REDUCED_BIRTHDAY not between", value1, value2, "reducedBirthday");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenIsNull() {
            addCriterion("IS_BALANCE_FROZEN is null");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenIsNotNull() {
            addCriterion("IS_BALANCE_FROZEN is not null");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenEqualTo(String value) {
            addCriterion("IS_BALANCE_FROZEN =", value, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenNotEqualTo(String value) {
            addCriterion("IS_BALANCE_FROZEN <>", value, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenGreaterThan(String value) {
            addCriterion("IS_BALANCE_FROZEN >", value, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenGreaterThanOrEqualTo(String value) {
            addCriterion("IS_BALANCE_FROZEN >=", value, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenLessThan(String value) {
            addCriterion("IS_BALANCE_FROZEN <", value, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenLessThanOrEqualTo(String value) {
            addCriterion("IS_BALANCE_FROZEN <=", value, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenLike(String value) {
            addCriterion("IS_BALANCE_FROZEN like", value, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenNotLike(String value) {
            addCriterion("IS_BALANCE_FROZEN not like", value, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenIn(List<String> values) {
            addCriterion("IS_BALANCE_FROZEN in", values, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenNotIn(List<String> values) {
            addCriterion("IS_BALANCE_FROZEN not in", values, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenBetween(String value1, String value2) {
            addCriterion("IS_BALANCE_FROZEN between", value1, value2, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andIsBalanceFrozenNotBetween(String value1, String value2) {
            addCriterion("IS_BALANCE_FROZEN not between", value1, value2, "isBalanceFrozen");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeIsNull() {
            addCriterion("BALANCE_FREEZE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeIsNotNull() {
            addCriterion("BALANCE_FREEZE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeEqualTo(String value) {
            addCriterion("BALANCE_FREEZE_TYPE =", value, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeNotEqualTo(String value) {
            addCriterion("BALANCE_FREEZE_TYPE <>", value, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeGreaterThan(String value) {
            addCriterion("BALANCE_FREEZE_TYPE >", value, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BALANCE_FREEZE_TYPE >=", value, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeLessThan(String value) {
            addCriterion("BALANCE_FREEZE_TYPE <", value, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeLessThanOrEqualTo(String value) {
            addCriterion("BALANCE_FREEZE_TYPE <=", value, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeLike(String value) {
            addCriterion("BALANCE_FREEZE_TYPE like", value, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeNotLike(String value) {
            addCriterion("BALANCE_FREEZE_TYPE not like", value, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeIn(List<String> values) {
            addCriterion("BALANCE_FREEZE_TYPE in", values, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeNotIn(List<String> values) {
            addCriterion("BALANCE_FREEZE_TYPE not in", values, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeBetween(String value1, String value2) {
            addCriterion("BALANCE_FREEZE_TYPE between", value1, value2, "balanceFreezeType");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezeTypeNotBetween(String value1, String value2) {
            addCriterion("BALANCE_FREEZE_TYPE not between", value1, value2, "balanceFreezeType");
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