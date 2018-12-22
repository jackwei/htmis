package com.git.db.beans;

import java.util.ArrayList;
import java.util.List;

public class TblParticInstExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblParticInstExample() {
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

        public Criteria andParticInstIdIsNull() {
            addCriterion("Partic_Inst_Id is null");
            return (Criteria) this;
        }

        public Criteria andParticInstIdIsNotNull() {
            addCriterion("Partic_Inst_Id is not null");
            return (Criteria) this;
        }

        public Criteria andParticInstIdEqualTo(Long value) {
            addCriterion("Partic_Inst_Id =", value, "particInstId");
            return (Criteria) this;
        }

        public Criteria andParticInstIdNotEqualTo(Long value) {
            addCriterion("Partic_Inst_Id <>", value, "particInstId");
            return (Criteria) this;
        }

        public Criteria andParticInstIdGreaterThan(Long value) {
            addCriterion("Partic_Inst_Id >", value, "particInstId");
            return (Criteria) this;
        }

        public Criteria andParticInstIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Partic_Inst_Id >=", value, "particInstId");
            return (Criteria) this;
        }

        public Criteria andParticInstIdLessThan(Long value) {
            addCriterion("Partic_Inst_Id <", value, "particInstId");
            return (Criteria) this;
        }

        public Criteria andParticInstIdLessThanOrEqualTo(Long value) {
            addCriterion("Partic_Inst_Id <=", value, "particInstId");
            return (Criteria) this;
        }

        public Criteria andParticInstIdIn(List<Long> values) {
            addCriterion("Partic_Inst_Id in", values, "particInstId");
            return (Criteria) this;
        }

        public Criteria andParticInstIdNotIn(List<Long> values) {
            addCriterion("Partic_Inst_Id not in", values, "particInstId");
            return (Criteria) this;
        }

        public Criteria andParticInstIdBetween(Long value1, Long value2) {
            addCriterion("Partic_Inst_Id between", value1, value2, "particInstId");
            return (Criteria) this;
        }

        public Criteria andParticInstIdNotBetween(Long value1, Long value2) {
            addCriterion("Partic_Inst_Id not between", value1, value2, "particInstId");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdIsNull() {
            addCriterion("Process_Inst_ID is null");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdIsNotNull() {
            addCriterion("Process_Inst_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdEqualTo(Long value) {
            addCriterion("Process_Inst_ID =", value, "processInstId");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdNotEqualTo(Long value) {
            addCriterion("Process_Inst_ID <>", value, "processInstId");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdGreaterThan(Long value) {
            addCriterion("Process_Inst_ID >", value, "processInstId");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Process_Inst_ID >=", value, "processInstId");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdLessThan(Long value) {
            addCriterion("Process_Inst_ID <", value, "processInstId");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdLessThanOrEqualTo(Long value) {
            addCriterion("Process_Inst_ID <=", value, "processInstId");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdIn(List<Long> values) {
            addCriterion("Process_Inst_ID in", values, "processInstId");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdNotIn(List<Long> values) {
            addCriterion("Process_Inst_ID not in", values, "processInstId");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdBetween(Long value1, Long value2) {
            addCriterion("Process_Inst_ID between", value1, value2, "processInstId");
            return (Criteria) this;
        }

        public Criteria andProcessInstIdNotBetween(Long value1, Long value2) {
            addCriterion("Process_Inst_ID not between", value1, value2, "processInstId");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdIsNull() {
            addCriterion("Activity_Inst_ID is null");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdIsNotNull() {
            addCriterion("Activity_Inst_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdEqualTo(Long value) {
            addCriterion("Activity_Inst_ID =", value, "activityInstId");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdNotEqualTo(Long value) {
            addCriterion("Activity_Inst_ID <>", value, "activityInstId");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdGreaterThan(Long value) {
            addCriterion("Activity_Inst_ID >", value, "activityInstId");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Activity_Inst_ID >=", value, "activityInstId");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdLessThan(Long value) {
            addCriterion("Activity_Inst_ID <", value, "activityInstId");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdLessThanOrEqualTo(Long value) {
            addCriterion("Activity_Inst_ID <=", value, "activityInstId");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdIn(List<Long> values) {
            addCriterion("Activity_Inst_ID in", values, "activityInstId");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdNotIn(List<Long> values) {
            addCriterion("Activity_Inst_ID not in", values, "activityInstId");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdBetween(Long value1, Long value2) {
            addCriterion("Activity_Inst_ID between", value1, value2, "activityInstId");
            return (Criteria) this;
        }

        public Criteria andActivityInstIdNotBetween(Long value1, Long value2) {
            addCriterion("Activity_Inst_ID not between", value1, value2, "activityInstId");
            return (Criteria) this;
        }

        public Criteria andParticUserIdIsNull() {
            addCriterion("Partic_User_Id is null");
            return (Criteria) this;
        }

        public Criteria andParticUserIdIsNotNull() {
            addCriterion("Partic_User_Id is not null");
            return (Criteria) this;
        }

        public Criteria andParticUserIdEqualTo(Long value) {
            addCriterion("Partic_User_Id =", value, "particUserId");
            return (Criteria) this;
        }

        public Criteria andParticUserIdNotEqualTo(Long value) {
            addCriterion("Partic_User_Id <>", value, "particUserId");
            return (Criteria) this;
        }

        public Criteria andParticUserIdGreaterThan(Long value) {
            addCriterion("Partic_User_Id >", value, "particUserId");
            return (Criteria) this;
        }

        public Criteria andParticUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Partic_User_Id >=", value, "particUserId");
            return (Criteria) this;
        }

        public Criteria andParticUserIdLessThan(Long value) {
            addCriterion("Partic_User_Id <", value, "particUserId");
            return (Criteria) this;
        }

        public Criteria andParticUserIdLessThanOrEqualTo(Long value) {
            addCriterion("Partic_User_Id <=", value, "particUserId");
            return (Criteria) this;
        }

        public Criteria andParticUserIdIn(List<Long> values) {
            addCriterion("Partic_User_Id in", values, "particUserId");
            return (Criteria) this;
        }

        public Criteria andParticUserIdNotIn(List<Long> values) {
            addCriterion("Partic_User_Id not in", values, "particUserId");
            return (Criteria) this;
        }

        public Criteria andParticUserIdBetween(Long value1, Long value2) {
            addCriterion("Partic_User_Id between", value1, value2, "particUserId");
            return (Criteria) this;
        }

        public Criteria andParticUserIdNotBetween(Long value1, Long value2) {
            addCriterion("Partic_User_Id not between", value1, value2, "particUserId");
            return (Criteria) this;
        }

        public Criteria andParticUserValueIsNull() {
            addCriterion("Partic_User_Value is null");
            return (Criteria) this;
        }

        public Criteria andParticUserValueIsNotNull() {
            addCriterion("Partic_User_Value is not null");
            return (Criteria) this;
        }

        public Criteria andParticUserValueEqualTo(String value) {
            addCriterion("Partic_User_Value =", value, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueNotEqualTo(String value) {
            addCriterion("Partic_User_Value <>", value, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueGreaterThan(String value) {
            addCriterion("Partic_User_Value >", value, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueGreaterThanOrEqualTo(String value) {
            addCriterion("Partic_User_Value >=", value, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueLessThan(String value) {
            addCriterion("Partic_User_Value <", value, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueLessThanOrEqualTo(String value) {
            addCriterion("Partic_User_Value <=", value, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueLike(String value) {
            addCriterion("Partic_User_Value like", value, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueNotLike(String value) {
            addCriterion("Partic_User_Value not like", value, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueIn(List<String> values) {
            addCriterion("Partic_User_Value in", values, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueNotIn(List<String> values) {
            addCriterion("Partic_User_Value not in", values, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueBetween(String value1, String value2) {
            addCriterion("Partic_User_Value between", value1, value2, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andParticUserValueNotBetween(String value1, String value2) {
            addCriterion("Partic_User_Value not between", value1, value2, "particUserValue");
            return (Criteria) this;
        }

        public Criteria andExcuteStateIsNull() {
            addCriterion("Excute_State is null");
            return (Criteria) this;
        }

        public Criteria andExcuteStateIsNotNull() {
            addCriterion("Excute_State is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteStateEqualTo(String value) {
            addCriterion("Excute_State =", value, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateNotEqualTo(String value) {
            addCriterion("Excute_State <>", value, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateGreaterThan(String value) {
            addCriterion("Excute_State >", value, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateGreaterThanOrEqualTo(String value) {
            addCriterion("Excute_State >=", value, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateLessThan(String value) {
            addCriterion("Excute_State <", value, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateLessThanOrEqualTo(String value) {
            addCriterion("Excute_State <=", value, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateLike(String value) {
            addCriterion("Excute_State like", value, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateNotLike(String value) {
            addCriterion("Excute_State not like", value, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateIn(List<String> values) {
            addCriterion("Excute_State in", values, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateNotIn(List<String> values) {
            addCriterion("Excute_State not in", values, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateBetween(String value1, String value2) {
            addCriterion("Excute_State between", value1, value2, "excuteState");
            return (Criteria) this;
        }

        public Criteria andExcuteStateNotBetween(String value1, String value2) {
            addCriterion("Excute_State not between", value1, value2, "excuteState");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeIsNull() {
            addCriterion("PartiIn_Type is null");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeIsNotNull() {
            addCriterion("PartiIn_Type is not null");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeEqualTo(String value) {
            addCriterion("PartiIn_Type =", value, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeNotEqualTo(String value) {
            addCriterion("PartiIn_Type <>", value, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeGreaterThan(String value) {
            addCriterion("PartiIn_Type >", value, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PartiIn_Type >=", value, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeLessThan(String value) {
            addCriterion("PartiIn_Type <", value, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeLessThanOrEqualTo(String value) {
            addCriterion("PartiIn_Type <=", value, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeLike(String value) {
            addCriterion("PartiIn_Type like", value, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeNotLike(String value) {
            addCriterion("PartiIn_Type not like", value, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeIn(List<String> values) {
            addCriterion("PartiIn_Type in", values, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeNotIn(List<String> values) {
            addCriterion("PartiIn_Type not in", values, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeBetween(String value1, String value2) {
            addCriterion("PartiIn_Type between", value1, value2, "partiinType");
            return (Criteria) this;
        }

        public Criteria andPartiinTypeNotBetween(String value1, String value2) {
            addCriterion("PartiIn_Type not between", value1, value2, "partiinType");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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