package com.ai.ge.platform.model.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogDataBatchFeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogDataBatchFeedbackExample() {
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

        public Criteria andLogFeedbackIdIsNull() {
            addCriterion("LOG_FEEDBACK_ID is null");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdIsNotNull() {
            addCriterion("LOG_FEEDBACK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdEqualTo(Integer value) {
            addCriterion("LOG_FEEDBACK_ID =", value, "logFeedbackId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdNotEqualTo(Integer value) {
            addCriterion("LOG_FEEDBACK_ID <>", value, "logFeedbackId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdGreaterThan(Integer value) {
            addCriterion("LOG_FEEDBACK_ID >", value, "logFeedbackId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOG_FEEDBACK_ID >=", value, "logFeedbackId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdLessThan(Integer value) {
            addCriterion("LOG_FEEDBACK_ID <", value, "logFeedbackId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdLessThanOrEqualTo(Integer value) {
            addCriterion("LOG_FEEDBACK_ID <=", value, "logFeedbackId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdIn(List<Integer> values) {
            addCriterion("LOG_FEEDBACK_ID in", values, "logFeedbackId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdNotIn(List<Integer> values) {
            addCriterion("LOG_FEEDBACK_ID not in", values, "logFeedbackId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdBetween(Integer value1, Integer value2) {
            addCriterion("LOG_FEEDBACK_ID between", value1, value2, "logFeedbackId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LOG_FEEDBACK_ID not between", value1, value2, "logFeedbackId");
            return (Criteria) this;
        }

        public Criteria andPushSeqIsNull() {
            addCriterion("PUSH_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andPushSeqIsNotNull() {
            addCriterion("PUSH_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andPushSeqEqualTo(String value) {
            addCriterion("PUSH_SEQ =", value, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqNotEqualTo(String value) {
            addCriterion("PUSH_SEQ <>", value, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqGreaterThan(String value) {
            addCriterion("PUSH_SEQ >", value, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqGreaterThanOrEqualTo(String value) {
            addCriterion("PUSH_SEQ >=", value, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqLessThan(String value) {
            addCriterion("PUSH_SEQ <", value, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqLessThanOrEqualTo(String value) {
            addCriterion("PUSH_SEQ <=", value, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqLike(String value) {
            addCriterion("PUSH_SEQ like", value, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqNotLike(String value) {
            addCriterion("PUSH_SEQ not like", value, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqIn(List<String> values) {
            addCriterion("PUSH_SEQ in", values, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqNotIn(List<String> values) {
            addCriterion("PUSH_SEQ not in", values, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqBetween(String value1, String value2) {
            addCriterion("PUSH_SEQ between", value1, value2, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushSeqNotBetween(String value1, String value2) {
            addCriterion("PUSH_SEQ not between", value1, value2, "pushSeq");
            return (Criteria) this;
        }

        public Criteria andPushVersionIsNull() {
            addCriterion("PUSH_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andPushVersionIsNotNull() {
            addCriterion("PUSH_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andPushVersionEqualTo(Integer value) {
            addCriterion("PUSH_VERSION =", value, "pushVersion");
            return (Criteria) this;
        }

        public Criteria andPushVersionNotEqualTo(Integer value) {
            addCriterion("PUSH_VERSION <>", value, "pushVersion");
            return (Criteria) this;
        }

        public Criteria andPushVersionGreaterThan(Integer value) {
            addCriterion("PUSH_VERSION >", value, "pushVersion");
            return (Criteria) this;
        }

        public Criteria andPushVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUSH_VERSION >=", value, "pushVersion");
            return (Criteria) this;
        }

        public Criteria andPushVersionLessThan(Integer value) {
            addCriterion("PUSH_VERSION <", value, "pushVersion");
            return (Criteria) this;
        }

        public Criteria andPushVersionLessThanOrEqualTo(Integer value) {
            addCriterion("PUSH_VERSION <=", value, "pushVersion");
            return (Criteria) this;
        }

        public Criteria andPushVersionIn(List<Integer> values) {
            addCriterion("PUSH_VERSION in", values, "pushVersion");
            return (Criteria) this;
        }

        public Criteria andPushVersionNotIn(List<Integer> values) {
            addCriterion("PUSH_VERSION not in", values, "pushVersion");
            return (Criteria) this;
        }

        public Criteria andPushVersionBetween(Integer value1, Integer value2) {
            addCriterion("PUSH_VERSION between", value1, value2, "pushVersion");
            return (Criteria) this;
        }

        public Criteria andPushVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("PUSH_VERSION not between", value1, value2, "pushVersion");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathIsNull() {
            addCriterion("SOURCE_FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathIsNotNull() {
            addCriterion("SOURCE_FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathEqualTo(String value) {
            addCriterion("SOURCE_FILE_PATH =", value, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathNotEqualTo(String value) {
            addCriterion("SOURCE_FILE_PATH <>", value, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathGreaterThan(String value) {
            addCriterion("SOURCE_FILE_PATH >", value, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_FILE_PATH >=", value, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathLessThan(String value) {
            addCriterion("SOURCE_FILE_PATH <", value, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_FILE_PATH <=", value, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathLike(String value) {
            addCriterion("SOURCE_FILE_PATH like", value, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathNotLike(String value) {
            addCriterion("SOURCE_FILE_PATH not like", value, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathIn(List<String> values) {
            addCriterion("SOURCE_FILE_PATH in", values, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathNotIn(List<String> values) {
            addCriterion("SOURCE_FILE_PATH not in", values, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathBetween(String value1, String value2) {
            addCriterion("SOURCE_FILE_PATH between", value1, value2, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andSourceFilePathNotBetween(String value1, String value2) {
            addCriterion("SOURCE_FILE_PATH not between", value1, value2, "sourceFilePath");
            return (Criteria) this;
        }

        public Criteria andCreateStatusIsNull() {
            addCriterion("CREATE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCreateStatusIsNotNull() {
            addCriterion("CREATE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStatusEqualTo(Integer value) {
            addCriterion("CREATE_STATUS =", value, "createStatus");
            return (Criteria) this;
        }

        public Criteria andCreateStatusNotEqualTo(Integer value) {
            addCriterion("CREATE_STATUS <>", value, "createStatus");
            return (Criteria) this;
        }

        public Criteria andCreateStatusGreaterThan(Integer value) {
            addCriterion("CREATE_STATUS >", value, "createStatus");
            return (Criteria) this;
        }

        public Criteria andCreateStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATE_STATUS >=", value, "createStatus");
            return (Criteria) this;
        }

        public Criteria andCreateStatusLessThan(Integer value) {
            addCriterion("CREATE_STATUS <", value, "createStatus");
            return (Criteria) this;
        }

        public Criteria andCreateStatusLessThanOrEqualTo(Integer value) {
            addCriterion("CREATE_STATUS <=", value, "createStatus");
            return (Criteria) this;
        }

        public Criteria andCreateStatusIn(List<Integer> values) {
            addCriterion("CREATE_STATUS in", values, "createStatus");
            return (Criteria) this;
        }

        public Criteria andCreateStatusNotIn(List<Integer> values) {
            addCriterion("CREATE_STATUS not in", values, "createStatus");
            return (Criteria) this;
        }

        public Criteria andCreateStatusBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_STATUS between", value1, value2, "createStatus");
            return (Criteria) this;
        }

        public Criteria andCreateStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_STATUS not between", value1, value2, "createStatus");
            return (Criteria) this;
        }

        public Criteria andSplitStatusIsNull() {
            addCriterion("SPLIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSplitStatusIsNotNull() {
            addCriterion("SPLIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSplitStatusEqualTo(Integer value) {
            addCriterion("SPLIT_STATUS =", value, "splitStatus");
            return (Criteria) this;
        }

        public Criteria andSplitStatusNotEqualTo(Integer value) {
            addCriterion("SPLIT_STATUS <>", value, "splitStatus");
            return (Criteria) this;
        }

        public Criteria andSplitStatusGreaterThan(Integer value) {
            addCriterion("SPLIT_STATUS >", value, "splitStatus");
            return (Criteria) this;
        }

        public Criteria andSplitStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("SPLIT_STATUS >=", value, "splitStatus");
            return (Criteria) this;
        }

        public Criteria andSplitStatusLessThan(Integer value) {
            addCriterion("SPLIT_STATUS <", value, "splitStatus");
            return (Criteria) this;
        }

        public Criteria andSplitStatusLessThanOrEqualTo(Integer value) {
            addCriterion("SPLIT_STATUS <=", value, "splitStatus");
            return (Criteria) this;
        }

        public Criteria andSplitStatusIn(List<Integer> values) {
            addCriterion("SPLIT_STATUS in", values, "splitStatus");
            return (Criteria) this;
        }

        public Criteria andSplitStatusNotIn(List<Integer> values) {
            addCriterion("SPLIT_STATUS not in", values, "splitStatus");
            return (Criteria) this;
        }

        public Criteria andSplitStatusBetween(Integer value1, Integer value2) {
            addCriterion("SPLIT_STATUS between", value1, value2, "splitStatus");
            return (Criteria) this;
        }

        public Criteria andSplitStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("SPLIT_STATUS not between", value1, value2, "splitStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusIsNull() {
            addCriterion("PUSH_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPushStatusIsNotNull() {
            addCriterion("PUSH_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPushStatusEqualTo(Integer value) {
            addCriterion("PUSH_STATUS =", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotEqualTo(Integer value) {
            addCriterion("PUSH_STATUS <>", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusGreaterThan(Integer value) {
            addCriterion("PUSH_STATUS >", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUSH_STATUS >=", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusLessThan(Integer value) {
            addCriterion("PUSH_STATUS <", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusLessThanOrEqualTo(Integer value) {
            addCriterion("PUSH_STATUS <=", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusIn(List<Integer> values) {
            addCriterion("PUSH_STATUS in", values, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotIn(List<Integer> values) {
            addCriterion("PUSH_STATUS not in", values, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusBetween(Integer value1, Integer value2) {
            addCriterion("PUSH_STATUS between", value1, value2, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("PUSH_STATUS not between", value1, value2, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeIsNull() {
            addCriterion("FILE_CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeIsNotNull() {
            addCriterion("FILE_CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeEqualTo(Date value) {
            addCriterion("FILE_CREATE_TIME =", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeNotEqualTo(Date value) {
            addCriterion("FILE_CREATE_TIME <>", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeGreaterThan(Date value) {
            addCriterion("FILE_CREATE_TIME >", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FILE_CREATE_TIME >=", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeLessThan(Date value) {
            addCriterion("FILE_CREATE_TIME <", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("FILE_CREATE_TIME <=", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeIn(List<Date> values) {
            addCriterion("FILE_CREATE_TIME in", values, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeNotIn(List<Date> values) {
            addCriterion("FILE_CREATE_TIME not in", values, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeBetween(Date value1, Date value2) {
            addCriterion("FILE_CREATE_TIME between", value1, value2, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("FILE_CREATE_TIME not between", value1, value2, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andSplitTimeIsNull() {
            addCriterion("SPLIT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSplitTimeIsNotNull() {
            addCriterion("SPLIT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSplitTimeEqualTo(Date value) {
            addCriterion("SPLIT_TIME =", value, "splitTime");
            return (Criteria) this;
        }

        public Criteria andSplitTimeNotEqualTo(Date value) {
            addCriterion("SPLIT_TIME <>", value, "splitTime");
            return (Criteria) this;
        }

        public Criteria andSplitTimeGreaterThan(Date value) {
            addCriterion("SPLIT_TIME >", value, "splitTime");
            return (Criteria) this;
        }

        public Criteria andSplitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SPLIT_TIME >=", value, "splitTime");
            return (Criteria) this;
        }

        public Criteria andSplitTimeLessThan(Date value) {
            addCriterion("SPLIT_TIME <", value, "splitTime");
            return (Criteria) this;
        }

        public Criteria andSplitTimeLessThanOrEqualTo(Date value) {
            addCriterion("SPLIT_TIME <=", value, "splitTime");
            return (Criteria) this;
        }

        public Criteria andSplitTimeIn(List<Date> values) {
            addCriterion("SPLIT_TIME in", values, "splitTime");
            return (Criteria) this;
        }

        public Criteria andSplitTimeNotIn(List<Date> values) {
            addCriterion("SPLIT_TIME not in", values, "splitTime");
            return (Criteria) this;
        }

        public Criteria andSplitTimeBetween(Date value1, Date value2) {
            addCriterion("SPLIT_TIME between", value1, value2, "splitTime");
            return (Criteria) this;
        }

        public Criteria andSplitTimeNotBetween(Date value1, Date value2) {
            addCriterion("SPLIT_TIME not between", value1, value2, "splitTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("PUSH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("PUSH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterion("PUSH_TIME =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterion("PUSH_TIME <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterion("PUSH_TIME >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PUSH_TIME >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterion("PUSH_TIME <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("PUSH_TIME <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<Date> values) {
            addCriterion("PUSH_TIME in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<Date> values) {
            addCriterion("PUSH_TIME not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterion("PUSH_TIME between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("PUSH_TIME not between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeIsNull() {
            addCriterion("PUSH_COMPLETE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeIsNotNull() {
            addCriterion("PUSH_COMPLETE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeEqualTo(Date value) {
            addCriterion("PUSH_COMPLETE_TIME =", value, "pushCompleteTime");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeNotEqualTo(Date value) {
            addCriterion("PUSH_COMPLETE_TIME <>", value, "pushCompleteTime");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeGreaterThan(Date value) {
            addCriterion("PUSH_COMPLETE_TIME >", value, "pushCompleteTime");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PUSH_COMPLETE_TIME >=", value, "pushCompleteTime");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeLessThan(Date value) {
            addCriterion("PUSH_COMPLETE_TIME <", value, "pushCompleteTime");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("PUSH_COMPLETE_TIME <=", value, "pushCompleteTime");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeIn(List<Date> values) {
            addCriterion("PUSH_COMPLETE_TIME in", values, "pushCompleteTime");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeNotIn(List<Date> values) {
            addCriterion("PUSH_COMPLETE_TIME not in", values, "pushCompleteTime");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("PUSH_COMPLETE_TIME between", value1, value2, "pushCompleteTime");
            return (Criteria) this;
        }

        public Criteria andPushCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("PUSH_COMPLETE_TIME not between", value1, value2, "pushCompleteTime");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonIsNull() {
            addCriterion("SPLIT_FAIL_REASON is null");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonIsNotNull() {
            addCriterion("SPLIT_FAIL_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonEqualTo(String value) {
            addCriterion("SPLIT_FAIL_REASON =", value, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonNotEqualTo(String value) {
            addCriterion("SPLIT_FAIL_REASON <>", value, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonGreaterThan(String value) {
            addCriterion("SPLIT_FAIL_REASON >", value, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonGreaterThanOrEqualTo(String value) {
            addCriterion("SPLIT_FAIL_REASON >=", value, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonLessThan(String value) {
            addCriterion("SPLIT_FAIL_REASON <", value, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonLessThanOrEqualTo(String value) {
            addCriterion("SPLIT_FAIL_REASON <=", value, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonLike(String value) {
            addCriterion("SPLIT_FAIL_REASON like", value, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonNotLike(String value) {
            addCriterion("SPLIT_FAIL_REASON not like", value, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonIn(List<String> values) {
            addCriterion("SPLIT_FAIL_REASON in", values, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonNotIn(List<String> values) {
            addCriterion("SPLIT_FAIL_REASON not in", values, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonBetween(String value1, String value2) {
            addCriterion("SPLIT_FAIL_REASON between", value1, value2, "splitFailReason");
            return (Criteria) this;
        }

        public Criteria andSplitFailReasonNotBetween(String value1, String value2) {
            addCriterion("SPLIT_FAIL_REASON not between", value1, value2, "splitFailReason");
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