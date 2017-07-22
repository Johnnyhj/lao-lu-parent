package com.ai.ge.platform.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysOrgaRoleRelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysOrgaRoleRelExample() {
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

        public Criteria andOrgaRoleIdIsNull() {
            addCriterion("ORGA_ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdIsNotNull() {
            addCriterion("ORGA_ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdEqualTo(Long value) {
            addCriterion("ORGA_ROLE_ID =", value, "orgaRoleId");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdNotEqualTo(Long value) {
            addCriterion("ORGA_ROLE_ID <>", value, "orgaRoleId");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdGreaterThan(Long value) {
            addCriterion("ORGA_ROLE_ID >", value, "orgaRoleId");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORGA_ROLE_ID >=", value, "orgaRoleId");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdLessThan(Long value) {
            addCriterion("ORGA_ROLE_ID <", value, "orgaRoleId");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("ORGA_ROLE_ID <=", value, "orgaRoleId");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdIn(List<Long> values) {
            addCriterion("ORGA_ROLE_ID in", values, "orgaRoleId");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdNotIn(List<Long> values) {
            addCriterion("ORGA_ROLE_ID not in", values, "orgaRoleId");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdBetween(Long value1, Long value2) {
            addCriterion("ORGA_ROLE_ID between", value1, value2, "orgaRoleId");
            return (Criteria) this;
        }

        public Criteria andOrgaRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("ORGA_ROLE_ID not between", value1, value2, "orgaRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Long value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Long value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdIsNull() {
            addCriterion("ORGA_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgaIdIsNotNull() {
            addCriterion("ORGA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgaIdEqualTo(Long value) {
            addCriterion("ORGA_ID =", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdNotEqualTo(Long value) {
            addCriterion("ORGA_ID <>", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdGreaterThan(Long value) {
            addCriterion("ORGA_ID >", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORGA_ID >=", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdLessThan(Long value) {
            addCriterion("ORGA_ID <", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdLessThanOrEqualTo(Long value) {
            addCriterion("ORGA_ID <=", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdIn(List<Long> values) {
            addCriterion("ORGA_ID in", values, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdNotIn(List<Long> values) {
            addCriterion("ORGA_ID not in", values, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdBetween(Long value1, Long value2) {
            addCriterion("ORGA_ID between", value1, value2, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdNotBetween(Long value1, Long value2) {
            addCriterion("ORGA_ID not between", value1, value2, "orgaId");
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

        public Criteria andEffectiveTimeIsNull() {
            addCriterion("EFFECTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNotNull() {
            addCriterion("EFFECTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME =", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME <>", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME >", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME >=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThan(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME <", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECTIVE_TIME <=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIn(List<Date> values) {
            addCriterionForJDBCDate("EFFECTIVE_TIME in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("EFFECTIVE_TIME not in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EFFECTIVE_TIME between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EFFECTIVE_TIME not between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeIsNull() {
            addCriterion("FAIL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFailTimeIsNotNull() {
            addCriterion("FAIL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFailTimeEqualTo(Date value) {
            addCriterionForJDBCDate("FAIL_TIME =", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("FAIL_TIME <>", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("FAIL_TIME >", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FAIL_TIME >=", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeLessThan(Date value) {
            addCriterionForJDBCDate("FAIL_TIME <", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FAIL_TIME <=", value, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeIn(List<Date> values) {
            addCriterionForJDBCDate("FAIL_TIME in", values, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("FAIL_TIME not in", values, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FAIL_TIME between", value1, value2, "failTime");
            return (Criteria) this;
        }

        public Criteria andFailTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FAIL_TIME not between", value1, value2, "failTime");
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