package com.kemyond.virus.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HisVirusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HisVirusExample() {
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

        public Criteria andSequenceIdIsNull() {
            addCriterion("SEQUENCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIdIsNotNull() {
            addCriterion("SEQUENCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceIdEqualTo(Long value) {
            addCriterion("SEQUENCE_ID =", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdNotEqualTo(Long value) {
            addCriterion("SEQUENCE_ID <>", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdGreaterThan(Long value) {
            addCriterion("SEQUENCE_ID >", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SEQUENCE_ID >=", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdLessThan(Long value) {
            addCriterion("SEQUENCE_ID <", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdLessThanOrEqualTo(Long value) {
            addCriterion("SEQUENCE_ID <=", value, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdIn(List<Long> values) {
            addCriterion("SEQUENCE_ID in", values, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdNotIn(List<Long> values) {
            addCriterion("SEQUENCE_ID not in", values, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdBetween(Long value1, Long value2) {
            addCriterion("SEQUENCE_ID between", value1, value2, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andSequenceIdNotBetween(Long value1, Long value2) {
            addCriterion("SEQUENCE_ID not between", value1, value2, "sequenceId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("TASK_ID =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("TASK_ID <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("TASK_ID >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TASK_ID >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("TASK_ID <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("TASK_ID <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("TASK_ID in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("TASK_ID not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("TASK_ID between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("TASK_ID not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FILE_NAME =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FILE_NAME <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FILE_NAME >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_NAME >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FILE_NAME <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_NAME <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FILE_NAME like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FILE_NAME not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FILE_NAME in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FILE_NAME not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FILE_NAME between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FILE_NAME not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileMarkIsNull() {
            addCriterion("FILE_MARK is null");
            return (Criteria) this;
        }

        public Criteria andFileMarkIsNotNull() {
            addCriterion("FILE_MARK is not null");
            return (Criteria) this;
        }

        public Criteria andFileMarkEqualTo(String value) {
            addCriterion("FILE_MARK =", value, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkNotEqualTo(String value) {
            addCriterion("FILE_MARK <>", value, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkGreaterThan(String value) {
            addCriterion("FILE_MARK >", value, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_MARK >=", value, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkLessThan(String value) {
            addCriterion("FILE_MARK <", value, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkLessThanOrEqualTo(String value) {
            addCriterion("FILE_MARK <=", value, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkLike(String value) {
            addCriterion("FILE_MARK like", value, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkNotLike(String value) {
            addCriterion("FILE_MARK not like", value, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkIn(List<String> values) {
            addCriterion("FILE_MARK in", values, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkNotIn(List<String> values) {
            addCriterion("FILE_MARK not in", values, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkBetween(String value1, String value2) {
            addCriterion("FILE_MARK between", value1, value2, "fileMark");
            return (Criteria) this;
        }

        public Criteria andFileMarkNotBetween(String value1, String value2) {
            addCriterion("FILE_MARK not between", value1, value2, "fileMark");
            return (Criteria) this;
        }

        public Criteria andScanTypeIsNull() {
            addCriterion("SCAN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andScanTypeIsNotNull() {
            addCriterion("SCAN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andScanTypeEqualTo(Byte value) {
            addCriterion("SCAN_TYPE =", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeNotEqualTo(Byte value) {
            addCriterion("SCAN_TYPE <>", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeGreaterThan(Byte value) {
            addCriterion("SCAN_TYPE >", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SCAN_TYPE >=", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeLessThan(Byte value) {
            addCriterion("SCAN_TYPE <", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeLessThanOrEqualTo(Byte value) {
            addCriterion("SCAN_TYPE <=", value, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeIn(List<Byte> values) {
            addCriterion("SCAN_TYPE in", values, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeNotIn(List<Byte> values) {
            addCriterion("SCAN_TYPE not in", values, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeBetween(Byte value1, Byte value2) {
            addCriterion("SCAN_TYPE between", value1, value2, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("SCAN_TYPE not between", value1, value2, "scanType");
            return (Criteria) this;
        }

        public Criteria andScanStatusIsNull() {
            addCriterion("SCAN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andScanStatusIsNotNull() {
            addCriterion("SCAN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andScanStatusEqualTo(Byte value) {
            addCriterion("SCAN_STATUS =", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusNotEqualTo(Byte value) {
            addCriterion("SCAN_STATUS <>", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusGreaterThan(Byte value) {
            addCriterion("SCAN_STATUS >", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("SCAN_STATUS >=", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusLessThan(Byte value) {
            addCriterion("SCAN_STATUS <", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusLessThanOrEqualTo(Byte value) {
            addCriterion("SCAN_STATUS <=", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusIn(List<Byte> values) {
            addCriterion("SCAN_STATUS in", values, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusNotIn(List<Byte> values) {
            addCriterion("SCAN_STATUS not in", values, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusBetween(Byte value1, Byte value2) {
            addCriterion("SCAN_STATUS between", value1, value2, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("SCAN_STATUS not between", value1, value2, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("DETAIL =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("DETAIL <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("DETAIL >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("DETAIL <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("DETAIL <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("DETAIL like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("DETAIL not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("DETAIL in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("DETAIL not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("DETAIL between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("DETAIL not between", value1, value2, "detail");
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

        public Criteria andReservedIsNull() {
            addCriterion("RESERVED is null");
            return (Criteria) this;
        }

        public Criteria andReservedIsNotNull() {
            addCriterion("RESERVED is not null");
            return (Criteria) this;
        }

        public Criteria andReservedEqualTo(String value) {
            addCriterion("RESERVED =", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotEqualTo(String value) {
            addCriterion("RESERVED <>", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThan(String value) {
            addCriterion("RESERVED >", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED >=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThan(String value) {
            addCriterion("RESERVED <", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThanOrEqualTo(String value) {
            addCriterion("RESERVED <=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLike(String value) {
            addCriterion("RESERVED like", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotLike(String value) {
            addCriterion("RESERVED not like", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedIn(List<String> values) {
            addCriterion("RESERVED in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotIn(List<String> values) {
            addCriterion("RESERVED not in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedBetween(String value1, String value2) {
            addCriterion("RESERVED between", value1, value2, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotBetween(String value1, String value2) {
            addCriterion("RESERVED not between", value1, value2, "reserved");
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