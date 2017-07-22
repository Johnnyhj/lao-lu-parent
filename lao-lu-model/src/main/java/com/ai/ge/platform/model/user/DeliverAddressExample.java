package com.ai.ge.platform.model.user;

import java.util.ArrayList;
import java.util.List;

public class DeliverAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliverAddressExample() {
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

        public Criteria andPlatformUserIdIsNull() {
            addCriterion("PLATFORM_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdIsNotNull() {
            addCriterion("PLATFORM_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdEqualTo(Long value) {
            addCriterion("PLATFORM_USER_ID =", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdNotEqualTo(Long value) {
            addCriterion("PLATFORM_USER_ID <>", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdGreaterThan(Long value) {
            addCriterion("PLATFORM_USER_ID >", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PLATFORM_USER_ID >=", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdLessThan(Long value) {
            addCriterion("PLATFORM_USER_ID <", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdLessThanOrEqualTo(Long value) {
            addCriterion("PLATFORM_USER_ID <=", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdIn(List<Long> values) {
            addCriterion("PLATFORM_USER_ID in", values, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdNotIn(List<Long> values) {
            addCriterion("PLATFORM_USER_ID not in", values, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdBetween(Long value1, Long value2) {
            addCriterion("PLATFORM_USER_ID between", value1, value2, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdNotBetween(Long value1, Long value2) {
            addCriterion("PLATFORM_USER_ID not between", value1, value2, "platformUserId");
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

        public Criteria andDefaultDeliverAddreIsNull() {
            addCriterion("DEFAULT_DELIVER_ADDRE is null");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreIsNotNull() {
            addCriterion("DEFAULT_DELIVER_ADDRE is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreEqualTo(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRE =", value, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreNotEqualTo(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRE <>", value, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreGreaterThan(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRE >", value, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreGreaterThanOrEqualTo(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRE >=", value, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreLessThan(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRE <", value, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreLessThanOrEqualTo(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRE <=", value, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreLike(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRE like", value, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreNotLike(String value) {
            addCriterion("DEFAULT_DELIVER_ADDRE not like", value, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreIn(List<String> values) {
            addCriterion("DEFAULT_DELIVER_ADDRE in", values, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreNotIn(List<String> values) {
            addCriterion("DEFAULT_DELIVER_ADDRE not in", values, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreBetween(String value1, String value2) {
            addCriterion("DEFAULT_DELIVER_ADDRE between", value1, value2, "defaultDeliverAddre");
            return (Criteria) this;
        }

        public Criteria andDefaultDeliverAddreNotBetween(String value1, String value2) {
            addCriterion("DEFAULT_DELIVER_ADDRE not between", value1, value2, "defaultDeliverAddre");
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