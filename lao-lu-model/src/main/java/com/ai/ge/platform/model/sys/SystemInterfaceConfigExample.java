package com.ai.ge.platform.model.sys;

import java.util.ArrayList;
import java.util.List;

public class SystemInterfaceConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemInterfaceConfigExample() {
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

        public Criteria andInterfaceConfigIdIsNull() {
            addCriterion("INTERFACE_CONFIG_ID is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdIsNotNull() {
            addCriterion("INTERFACE_CONFIG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdEqualTo(Long value) {
            addCriterion("INTERFACE_CONFIG_ID =", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdNotEqualTo(Long value) {
            addCriterion("INTERFACE_CONFIG_ID <>", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdGreaterThan(Long value) {
            addCriterion("INTERFACE_CONFIG_ID >", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdGreaterThanOrEqualTo(Long value) {
            addCriterion("INTERFACE_CONFIG_ID >=", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdLessThan(Long value) {
            addCriterion("INTERFACE_CONFIG_ID <", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdLessThanOrEqualTo(Long value) {
            addCriterion("INTERFACE_CONFIG_ID <=", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdIn(List<Long> values) {
            addCriterion("INTERFACE_CONFIG_ID in", values, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdNotIn(List<Long> values) {
            addCriterion("INTERFACE_CONFIG_ID not in", values, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdBetween(Long value1, Long value2) {
            addCriterion("INTERFACE_CONFIG_ID between", value1, value2, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdNotBetween(Long value1, Long value2) {
            addCriterion("INTERFACE_CONFIG_ID not between", value1, value2, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelIsNull() {
            addCriterion("INTERFACE_CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelIsNotNull() {
            addCriterion("INTERFACE_CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelEqualTo(String value) {
            addCriterion("INTERFACE_CHANNEL =", value, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelNotEqualTo(String value) {
            addCriterion("INTERFACE_CHANNEL <>", value, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelGreaterThan(String value) {
            addCriterion("INTERFACE_CHANNEL >", value, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelGreaterThanOrEqualTo(String value) {
            addCriterion("INTERFACE_CHANNEL >=", value, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelLessThan(String value) {
            addCriterion("INTERFACE_CHANNEL <", value, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelLessThanOrEqualTo(String value) {
            addCriterion("INTERFACE_CHANNEL <=", value, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelLike(String value) {
            addCriterion("INTERFACE_CHANNEL like", value, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelNotLike(String value) {
            addCriterion("INTERFACE_CHANNEL not like", value, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelIn(List<String> values) {
            addCriterion("INTERFACE_CHANNEL in", values, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelNotIn(List<String> values) {
            addCriterion("INTERFACE_CHANNEL not in", values, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelBetween(String value1, String value2) {
            addCriterion("INTERFACE_CHANNEL between", value1, value2, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceChannelNotBetween(String value1, String value2) {
            addCriterion("INTERFACE_CHANNEL not between", value1, value2, "interfaceChannel");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeIsNull() {
            addCriterion("INTERFACE_CONFIG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeIsNotNull() {
            addCriterion("INTERFACE_CONFIG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_CODE =", value, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeNotEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_CODE <>", value, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeGreaterThan(String value) {
            addCriterion("INTERFACE_CONFIG_CODE >", value, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeGreaterThanOrEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_CODE >=", value, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeLessThan(String value) {
            addCriterion("INTERFACE_CONFIG_CODE <", value, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeLessThanOrEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_CODE <=", value, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeLike(String value) {
            addCriterion("INTERFACE_CONFIG_CODE like", value, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeNotLike(String value) {
            addCriterion("INTERFACE_CONFIG_CODE not like", value, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeIn(List<String> values) {
            addCriterion("INTERFACE_CONFIG_CODE in", values, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeNotIn(List<String> values) {
            addCriterion("INTERFACE_CONFIG_CODE not in", values, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeBetween(String value1, String value2) {
            addCriterion("INTERFACE_CONFIG_CODE between", value1, value2, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigCodeNotBetween(String value1, String value2) {
            addCriterion("INTERFACE_CONFIG_CODE not between", value1, value2, "interfaceConfigCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameIsNull() {
            addCriterion("INTERFACE_CONFIG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameIsNotNull() {
            addCriterion("INTERFACE_CONFIG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_NAME =", value, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameNotEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_NAME <>", value, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameGreaterThan(String value) {
            addCriterion("INTERFACE_CONFIG_NAME >", value, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameGreaterThanOrEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_NAME >=", value, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameLessThan(String value) {
            addCriterion("INTERFACE_CONFIG_NAME <", value, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameLessThanOrEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_NAME <=", value, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameLike(String value) {
            addCriterion("INTERFACE_CONFIG_NAME like", value, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameNotLike(String value) {
            addCriterion("INTERFACE_CONFIG_NAME not like", value, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameIn(List<String> values) {
            addCriterion("INTERFACE_CONFIG_NAME in", values, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameNotIn(List<String> values) {
            addCriterion("INTERFACE_CONFIG_NAME not in", values, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameBetween(String value1, String value2) {
            addCriterion("INTERFACE_CONFIG_NAME between", value1, value2, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigNameNotBetween(String value1, String value2) {
            addCriterion("INTERFACE_CONFIG_NAME not between", value1, value2, "interfaceConfigName");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlIsNull() {
            addCriterion("INTERFACE_CONFIG_URL is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlIsNotNull() {
            addCriterion("INTERFACE_CONFIG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_URL =", value, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlNotEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_URL <>", value, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlGreaterThan(String value) {
            addCriterion("INTERFACE_CONFIG_URL >", value, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlGreaterThanOrEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_URL >=", value, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlLessThan(String value) {
            addCriterion("INTERFACE_CONFIG_URL <", value, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlLessThanOrEqualTo(String value) {
            addCriterion("INTERFACE_CONFIG_URL <=", value, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlLike(String value) {
            addCriterion("INTERFACE_CONFIG_URL like", value, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlNotLike(String value) {
            addCriterion("INTERFACE_CONFIG_URL not like", value, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlIn(List<String> values) {
            addCriterion("INTERFACE_CONFIG_URL in", values, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlNotIn(List<String> values) {
            addCriterion("INTERFACE_CONFIG_URL not in", values, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlBetween(String value1, String value2) {
            addCriterion("INTERFACE_CONFIG_URL between", value1, value2, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigUrlNotBetween(String value1, String value2) {
            addCriterion("INTERFACE_CONFIG_URL not between", value1, value2, "interfaceConfigUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlIsNull() {
            addCriterion("REQUEST_TEMPLATE_URL is null");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlIsNotNull() {
            addCriterion("REQUEST_TEMPLATE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlEqualTo(String value) {
            addCriterion("REQUEST_TEMPLATE_URL =", value, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlNotEqualTo(String value) {
            addCriterion("REQUEST_TEMPLATE_URL <>", value, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlGreaterThan(String value) {
            addCriterion("REQUEST_TEMPLATE_URL >", value, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_TEMPLATE_URL >=", value, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlLessThan(String value) {
            addCriterion("REQUEST_TEMPLATE_URL <", value, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_TEMPLATE_URL <=", value, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlLike(String value) {
            addCriterion("REQUEST_TEMPLATE_URL like", value, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlNotLike(String value) {
            addCriterion("REQUEST_TEMPLATE_URL not like", value, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlIn(List<String> values) {
            addCriterion("REQUEST_TEMPLATE_URL in", values, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlNotIn(List<String> values) {
            addCriterion("REQUEST_TEMPLATE_URL not in", values, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlBetween(String value1, String value2) {
            addCriterion("REQUEST_TEMPLATE_URL between", value1, value2, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTemplateUrlNotBetween(String value1, String value2) {
            addCriterion("REQUEST_TEMPLATE_URL not between", value1, value2, "requestTemplateUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionIsNull() {
            addCriterion("INTERFACE_CONFIG_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionIsNotNull() {
            addCriterion("INTERFACE_CONFIG_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionEqualTo(Short value) {
            addCriterion("INTERFACE_CONFIG_VERSION =", value, "interfaceConfigVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionNotEqualTo(Short value) {
            addCriterion("INTERFACE_CONFIG_VERSION <>", value, "interfaceConfigVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionGreaterThan(Short value) {
            addCriterion("INTERFACE_CONFIG_VERSION >", value, "interfaceConfigVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionGreaterThanOrEqualTo(Short value) {
            addCriterion("INTERFACE_CONFIG_VERSION >=", value, "interfaceConfigVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionLessThan(Short value) {
            addCriterion("INTERFACE_CONFIG_VERSION <", value, "interfaceConfigVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionLessThanOrEqualTo(Short value) {
            addCriterion("INTERFACE_CONFIG_VERSION <=", value, "interfaceConfigVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionIn(List<Short> values) {
            addCriterion("INTERFACE_CONFIG_VERSION in", values, "interfaceConfigVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionNotIn(List<Short> values) {
            addCriterion("INTERFACE_CONFIG_VERSION not in", values, "interfaceConfigVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionBetween(Short value1, Short value2) {
            addCriterion("INTERFACE_CONFIG_VERSION between", value1, value2, "interfaceConfigVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigVersionNotBetween(Short value1, Short value2) {
            addCriterion("INTERFACE_CONFIG_VERSION not between", value1, value2, "interfaceConfigVersion");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceIsNull() {
            addCriterion("INTERFACE_INSTANCE is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceIsNotNull() {
            addCriterion("INTERFACE_INSTANCE is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceEqualTo(String value) {
            addCriterion("INTERFACE_INSTANCE =", value, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceNotEqualTo(String value) {
            addCriterion("INTERFACE_INSTANCE <>", value, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceGreaterThan(String value) {
            addCriterion("INTERFACE_INSTANCE >", value, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceGreaterThanOrEqualTo(String value) {
            addCriterion("INTERFACE_INSTANCE >=", value, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceLessThan(String value) {
            addCriterion("INTERFACE_INSTANCE <", value, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceLessThanOrEqualTo(String value) {
            addCriterion("INTERFACE_INSTANCE <=", value, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceLike(String value) {
            addCriterion("INTERFACE_INSTANCE like", value, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceNotLike(String value) {
            addCriterion("INTERFACE_INSTANCE not like", value, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceIn(List<String> values) {
            addCriterion("INTERFACE_INSTANCE in", values, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceNotIn(List<String> values) {
            addCriterion("INTERFACE_INSTANCE not in", values, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceBetween(String value1, String value2) {
            addCriterion("INTERFACE_INSTANCE between", value1, value2, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceInstanceNotBetween(String value1, String value2) {
            addCriterion("INTERFACE_INSTANCE not between", value1, value2, "interfaceInstance");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameIsNull() {
            addCriterion("INTERFACE_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameIsNotNull() {
            addCriterion("INTERFACE_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameEqualTo(String value) {
            addCriterion("INTERFACE_USERNAME =", value, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameNotEqualTo(String value) {
            addCriterion("INTERFACE_USERNAME <>", value, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameGreaterThan(String value) {
            addCriterion("INTERFACE_USERNAME >", value, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("INTERFACE_USERNAME >=", value, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameLessThan(String value) {
            addCriterion("INTERFACE_USERNAME <", value, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameLessThanOrEqualTo(String value) {
            addCriterion("INTERFACE_USERNAME <=", value, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameLike(String value) {
            addCriterion("INTERFACE_USERNAME like", value, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameNotLike(String value) {
            addCriterion("INTERFACE_USERNAME not like", value, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameIn(List<String> values) {
            addCriterion("INTERFACE_USERNAME in", values, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameNotIn(List<String> values) {
            addCriterion("INTERFACE_USERNAME not in", values, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameBetween(String value1, String value2) {
            addCriterion("INTERFACE_USERNAME between", value1, value2, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfaceUsernameNotBetween(String value1, String value2) {
            addCriterion("INTERFACE_USERNAME not between", value1, value2, "interfaceUsername");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordIsNull() {
            addCriterion("INTERFACE_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordIsNotNull() {
            addCriterion("INTERFACE_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordEqualTo(String value) {
            addCriterion("INTERFACE_PASSWORD =", value, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordNotEqualTo(String value) {
            addCriterion("INTERFACE_PASSWORD <>", value, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordGreaterThan(String value) {
            addCriterion("INTERFACE_PASSWORD >", value, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("INTERFACE_PASSWORD >=", value, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordLessThan(String value) {
            addCriterion("INTERFACE_PASSWORD <", value, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordLessThanOrEqualTo(String value) {
            addCriterion("INTERFACE_PASSWORD <=", value, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordLike(String value) {
            addCriterion("INTERFACE_PASSWORD like", value, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordNotLike(String value) {
            addCriterion("INTERFACE_PASSWORD not like", value, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordIn(List<String> values) {
            addCriterion("INTERFACE_PASSWORD in", values, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordNotIn(List<String> values) {
            addCriterion("INTERFACE_PASSWORD not in", values, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordBetween(String value1, String value2) {
            addCriterion("INTERFACE_PASSWORD between", value1, value2, "interfacePassword");
            return (Criteria) this;
        }

        public Criteria andInterfacePasswordNotBetween(String value1, String value2) {
            addCriterion("INTERFACE_PASSWORD not between", value1, value2, "interfacePassword");
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