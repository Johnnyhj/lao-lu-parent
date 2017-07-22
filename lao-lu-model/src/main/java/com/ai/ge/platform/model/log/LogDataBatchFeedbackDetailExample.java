package com.ai.ge.platform.model.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogDataBatchFeedbackDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogDataBatchFeedbackDetailExample() {
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

        public Criteria andLogFeedbackDetailIdIsNull() {
            addCriterion("LOG_FEEDBACK_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdIsNotNull() {
            addCriterion("LOG_FEEDBACK_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdEqualTo(Integer value) {
            addCriterion("LOG_FEEDBACK_DETAIL_ID =", value, "logFeedbackDetailId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdNotEqualTo(Integer value) {
            addCriterion("LOG_FEEDBACK_DETAIL_ID <>", value, "logFeedbackDetailId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdGreaterThan(Integer value) {
            addCriterion("LOG_FEEDBACK_DETAIL_ID >", value, "logFeedbackDetailId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOG_FEEDBACK_DETAIL_ID >=", value, "logFeedbackDetailId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdLessThan(Integer value) {
            addCriterion("LOG_FEEDBACK_DETAIL_ID <", value, "logFeedbackDetailId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("LOG_FEEDBACK_DETAIL_ID <=", value, "logFeedbackDetailId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdIn(List<Integer> values) {
            addCriterion("LOG_FEEDBACK_DETAIL_ID in", values, "logFeedbackDetailId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdNotIn(List<Integer> values) {
            addCriterion("LOG_FEEDBACK_DETAIL_ID not in", values, "logFeedbackDetailId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("LOG_FEEDBACK_DETAIL_ID between", value1, value2, "logFeedbackDetailId");
            return (Criteria) this;
        }

        public Criteria andLogFeedbackDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LOG_FEEDBACK_DETAIL_ID not between", value1, value2, "logFeedbackDetailId");
            return (Criteria) this;
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

        public Criteria andSplitBlockIsNull() {
            addCriterion("SPLIT_BLOCK is null");
            return (Criteria) this;
        }

        public Criteria andSplitBlockIsNotNull() {
            addCriterion("SPLIT_BLOCK is not null");
            return (Criteria) this;
        }

        public Criteria andSplitBlockEqualTo(Integer value) {
            addCriterion("SPLIT_BLOCK =", value, "splitBlock");
            return (Criteria) this;
        }

        public Criteria andSplitBlockNotEqualTo(Integer value) {
            addCriterion("SPLIT_BLOCK <>", value, "splitBlock");
            return (Criteria) this;
        }

        public Criteria andSplitBlockGreaterThan(Integer value) {
            addCriterion("SPLIT_BLOCK >", value, "splitBlock");
            return (Criteria) this;
        }

        public Criteria andSplitBlockGreaterThanOrEqualTo(Integer value) {
            addCriterion("SPLIT_BLOCK >=", value, "splitBlock");
            return (Criteria) this;
        }

        public Criteria andSplitBlockLessThan(Integer value) {
            addCriterion("SPLIT_BLOCK <", value, "splitBlock");
            return (Criteria) this;
        }

        public Criteria andSplitBlockLessThanOrEqualTo(Integer value) {
            addCriterion("SPLIT_BLOCK <=", value, "splitBlock");
            return (Criteria) this;
        }

        public Criteria andSplitBlockIn(List<Integer> values) {
            addCriterion("SPLIT_BLOCK in", values, "splitBlock");
            return (Criteria) this;
        }

        public Criteria andSplitBlockNotIn(List<Integer> values) {
            addCriterion("SPLIT_BLOCK not in", values, "splitBlock");
            return (Criteria) this;
        }

        public Criteria andSplitBlockBetween(Integer value1, Integer value2) {
            addCriterion("SPLIT_BLOCK between", value1, value2, "splitBlock");
            return (Criteria) this;
        }

        public Criteria andSplitBlockNotBetween(Integer value1, Integer value2) {
            addCriterion("SPLIT_BLOCK not between", value1, value2, "splitBlock");
            return (Criteria) this;
        }

        public Criteria andDataNumIsNull() {
            addCriterion("DATA_NUM is null");
            return (Criteria) this;
        }

        public Criteria andDataNumIsNotNull() {
            addCriterion("DATA_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andDataNumEqualTo(Integer value) {
            addCriterion("DATA_NUM =", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumNotEqualTo(Integer value) {
            addCriterion("DATA_NUM <>", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumGreaterThan(Integer value) {
            addCriterion("DATA_NUM >", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("DATA_NUM >=", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumLessThan(Integer value) {
            addCriterion("DATA_NUM <", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumLessThanOrEqualTo(Integer value) {
            addCriterion("DATA_NUM <=", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumIn(List<Integer> values) {
            addCriterion("DATA_NUM in", values, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumNotIn(List<Integer> values) {
            addCriterion("DATA_NUM not in", values, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumBetween(Integer value1, Integer value2) {
            addCriterion("DATA_NUM between", value1, value2, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumNotBetween(Integer value1, Integer value2) {
            addCriterion("DATA_NUM not between", value1, value2, "dataNum");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathIsNull() {
            addCriterion("SPLIT_FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathIsNotNull() {
            addCriterion("SPLIT_FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathEqualTo(String value) {
            addCriterion("SPLIT_FILE_PATH =", value, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathNotEqualTo(String value) {
            addCriterion("SPLIT_FILE_PATH <>", value, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathGreaterThan(String value) {
            addCriterion("SPLIT_FILE_PATH >", value, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("SPLIT_FILE_PATH >=", value, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathLessThan(String value) {
            addCriterion("SPLIT_FILE_PATH <", value, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathLessThanOrEqualTo(String value) {
            addCriterion("SPLIT_FILE_PATH <=", value, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathLike(String value) {
            addCriterion("SPLIT_FILE_PATH like", value, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathNotLike(String value) {
            addCriterion("SPLIT_FILE_PATH not like", value, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathIn(List<String> values) {
            addCriterion("SPLIT_FILE_PATH in", values, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathNotIn(List<String> values) {
            addCriterion("SPLIT_FILE_PATH not in", values, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathBetween(String value1, String value2) {
            addCriterion("SPLIT_FILE_PATH between", value1, value2, "splitFilePath");
            return (Criteria) this;
        }

        public Criteria andSplitFilePathNotBetween(String value1, String value2) {
            addCriterion("SPLIT_FILE_PATH not between", value1, value2, "splitFilePath");
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

        public Criteria andPushRepeatIsNull() {
            addCriterion("PUSH_REPEAT is null");
            return (Criteria) this;
        }

        public Criteria andPushRepeatIsNotNull() {
            addCriterion("PUSH_REPEAT is not null");
            return (Criteria) this;
        }

        public Criteria andPushRepeatEqualTo(Integer value) {
            addCriterion("PUSH_REPEAT =", value, "pushRepeat");
            return (Criteria) this;
        }

        public Criteria andPushRepeatNotEqualTo(Integer value) {
            addCriterion("PUSH_REPEAT <>", value, "pushRepeat");
            return (Criteria) this;
        }

        public Criteria andPushRepeatGreaterThan(Integer value) {
            addCriterion("PUSH_REPEAT >", value, "pushRepeat");
            return (Criteria) this;
        }

        public Criteria andPushRepeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUSH_REPEAT >=", value, "pushRepeat");
            return (Criteria) this;
        }

        public Criteria andPushRepeatLessThan(Integer value) {
            addCriterion("PUSH_REPEAT <", value, "pushRepeat");
            return (Criteria) this;
        }

        public Criteria andPushRepeatLessThanOrEqualTo(Integer value) {
            addCriterion("PUSH_REPEAT <=", value, "pushRepeat");
            return (Criteria) this;
        }

        public Criteria andPushRepeatIn(List<Integer> values) {
            addCriterion("PUSH_REPEAT in", values, "pushRepeat");
            return (Criteria) this;
        }

        public Criteria andPushRepeatNotIn(List<Integer> values) {
            addCriterion("PUSH_REPEAT not in", values, "pushRepeat");
            return (Criteria) this;
        }

        public Criteria andPushRepeatBetween(Integer value1, Integer value2) {
            addCriterion("PUSH_REPEAT between", value1, value2, "pushRepeat");
            return (Criteria) this;
        }

        public Criteria andPushRepeatNotBetween(Integer value1, Integer value2) {
            addCriterion("PUSH_REPEAT not between", value1, value2, "pushRepeat");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackIsNull() {
            addCriterion("PUSH_INTERFACE_FEEDBACK is null");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackIsNotNull() {
            addCriterion("PUSH_INTERFACE_FEEDBACK is not null");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackEqualTo(String value) {
            addCriterion("PUSH_INTERFACE_FEEDBACK =", value, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackNotEqualTo(String value) {
            addCriterion("PUSH_INTERFACE_FEEDBACK <>", value, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackGreaterThan(String value) {
            addCriterion("PUSH_INTERFACE_FEEDBACK >", value, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackGreaterThanOrEqualTo(String value) {
            addCriterion("PUSH_INTERFACE_FEEDBACK >=", value, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackLessThan(String value) {
            addCriterion("PUSH_INTERFACE_FEEDBACK <", value, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackLessThanOrEqualTo(String value) {
            addCriterion("PUSH_INTERFACE_FEEDBACK <=", value, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackLike(String value) {
            addCriterion("PUSH_INTERFACE_FEEDBACK like", value, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackNotLike(String value) {
            addCriterion("PUSH_INTERFACE_FEEDBACK not like", value, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackIn(List<String> values) {
            addCriterion("PUSH_INTERFACE_FEEDBACK in", values, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackNotIn(List<String> values) {
            addCriterion("PUSH_INTERFACE_FEEDBACK not in", values, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackBetween(String value1, String value2) {
            addCriterion("PUSH_INTERFACE_FEEDBACK between", value1, value2, "pushInterfaceFeedback");
            return (Criteria) this;
        }

        public Criteria andPushInterfaceFeedbackNotBetween(String value1, String value2) {
            addCriterion("PUSH_INTERFACE_FEEDBACK not between", value1, value2, "pushInterfaceFeedback");
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

        public Criteria andInterfaceCallIdIsNull() {
            addCriterion("INTERFACE_CALL_ID is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdIsNotNull() {
            addCriterion("INTERFACE_CALL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdEqualTo(Integer value) {
            addCriterion("INTERFACE_CALL_ID =", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdNotEqualTo(Integer value) {
            addCriterion("INTERFACE_CALL_ID <>", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdGreaterThan(Integer value) {
            addCriterion("INTERFACE_CALL_ID >", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("INTERFACE_CALL_ID >=", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdLessThan(Integer value) {
            addCriterion("INTERFACE_CALL_ID <", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdLessThanOrEqualTo(Integer value) {
            addCriterion("INTERFACE_CALL_ID <=", value, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdIn(List<Integer> values) {
            addCriterion("INTERFACE_CALL_ID in", values, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdNotIn(List<Integer> values) {
            addCriterion("INTERFACE_CALL_ID not in", values, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdBetween(Integer value1, Integer value2) {
            addCriterion("INTERFACE_CALL_ID between", value1, value2, "interfaceCallId");
            return (Criteria) this;
        }

        public Criteria andInterfaceCallIdNotBetween(Integer value1, Integer value2) {
            addCriterion("INTERFACE_CALL_ID not between", value1, value2, "interfaceCallId");
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