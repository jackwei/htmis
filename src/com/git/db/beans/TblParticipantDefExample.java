package com.git.db.beans;

import java.util.ArrayList;
import java.util.List;

public class TblParticipantDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblParticipantDefExample() {
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

        public Criteria andParticDefIdIsNull() {
            addCriterion("Partic_Def_Id is null");
            return (Criteria) this;
        }

        public Criteria andParticDefIdIsNotNull() {
            addCriterion("Partic_Def_Id is not null");
            return (Criteria) this;
        }

        public Criteria andParticDefIdEqualTo(Long value) {
            addCriterion("Partic_Def_Id =", value, "particDefId");
            return (Criteria) this;
        }

        public Criteria andParticDefIdNotEqualTo(Long value) {
            addCriterion("Partic_Def_Id <>", value, "particDefId");
            return (Criteria) this;
        }

        public Criteria andParticDefIdGreaterThan(Long value) {
            addCriterion("Partic_Def_Id >", value, "particDefId");
            return (Criteria) this;
        }

        public Criteria andParticDefIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Partic_Def_Id >=", value, "particDefId");
            return (Criteria) this;
        }

        public Criteria andParticDefIdLessThan(Long value) {
            addCriterion("Partic_Def_Id <", value, "particDefId");
            return (Criteria) this;
        }

        public Criteria andParticDefIdLessThanOrEqualTo(Long value) {
            addCriterion("Partic_Def_Id <=", value, "particDefId");
            return (Criteria) this;
        }

        public Criteria andParticDefIdIn(List<Long> values) {
            addCriterion("Partic_Def_Id in", values, "particDefId");
            return (Criteria) this;
        }

        public Criteria andParticDefIdNotIn(List<Long> values) {
            addCriterion("Partic_Def_Id not in", values, "particDefId");
            return (Criteria) this;
        }

        public Criteria andParticDefIdBetween(Long value1, Long value2) {
            addCriterion("Partic_Def_Id between", value1, value2, "particDefId");
            return (Criteria) this;
        }

        public Criteria andParticDefIdNotBetween(Long value1, Long value2) {
            addCriterion("Partic_Def_Id not between", value1, value2, "particDefId");
            return (Criteria) this;
        }

        public Criteria andParticTypeIsNull() {
            addCriterion("Partic_Type is null");
            return (Criteria) this;
        }

        public Criteria andParticTypeIsNotNull() {
            addCriterion("Partic_Type is not null");
            return (Criteria) this;
        }

        public Criteria andParticTypeEqualTo(String value) {
            addCriterion("Partic_Type =", value, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeNotEqualTo(String value) {
            addCriterion("Partic_Type <>", value, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeGreaterThan(String value) {
            addCriterion("Partic_Type >", value, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Partic_Type >=", value, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeLessThan(String value) {
            addCriterion("Partic_Type <", value, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeLessThanOrEqualTo(String value) {
            addCriterion("Partic_Type <=", value, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeLike(String value) {
            addCriterion("Partic_Type like", value, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeNotLike(String value) {
            addCriterion("Partic_Type not like", value, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeIn(List<String> values) {
            addCriterion("Partic_Type in", values, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeNotIn(List<String> values) {
            addCriterion("Partic_Type not in", values, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeBetween(String value1, String value2) {
            addCriterion("Partic_Type between", value1, value2, "particType");
            return (Criteria) this;
        }

        public Criteria andParticTypeNotBetween(String value1, String value2) {
            addCriterion("Partic_Type not between", value1, value2, "particType");
            return (Criteria) this;
        }

        public Criteria andParticValueIsNull() {
            addCriterion("Partic_Value is null");
            return (Criteria) this;
        }

        public Criteria andParticValueIsNotNull() {
            addCriterion("Partic_Value is not null");
            return (Criteria) this;
        }

        public Criteria andParticValueEqualTo(String value) {
            addCriterion("Partic_Value =", value, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueNotEqualTo(String value) {
            addCriterion("Partic_Value <>", value, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueGreaterThan(String value) {
            addCriterion("Partic_Value >", value, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueGreaterThanOrEqualTo(String value) {
            addCriterion("Partic_Value >=", value, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueLessThan(String value) {
            addCriterion("Partic_Value <", value, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueLessThanOrEqualTo(String value) {
            addCriterion("Partic_Value <=", value, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueLike(String value) {
            addCriterion("Partic_Value like", value, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueNotLike(String value) {
            addCriterion("Partic_Value not like", value, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueIn(List<String> values) {
            addCriterion("Partic_Value in", values, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueNotIn(List<String> values) {
            addCriterion("Partic_Value not in", values, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueBetween(String value1, String value2) {
            addCriterion("Partic_Value between", value1, value2, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValueNotBetween(String value1, String value2) {
            addCriterion("Partic_Value not between", value1, value2, "particValue");
            return (Criteria) this;
        }

        public Criteria andParticValue2IsNull() {
            addCriterion("Partic_Value2 is null");
            return (Criteria) this;
        }

        public Criteria andParticValue2IsNotNull() {
            addCriterion("Partic_Value2 is not null");
            return (Criteria) this;
        }

        public Criteria andParticValue2EqualTo(String value) {
            addCriterion("Partic_Value2 =", value, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2NotEqualTo(String value) {
            addCriterion("Partic_Value2 <>", value, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2GreaterThan(String value) {
            addCriterion("Partic_Value2 >", value, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2GreaterThanOrEqualTo(String value) {
            addCriterion("Partic_Value2 >=", value, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2LessThan(String value) {
            addCriterion("Partic_Value2 <", value, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2LessThanOrEqualTo(String value) {
            addCriterion("Partic_Value2 <=", value, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2Like(String value) {
            addCriterion("Partic_Value2 like", value, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2NotLike(String value) {
            addCriterion("Partic_Value2 not like", value, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2In(List<String> values) {
            addCriterion("Partic_Value2 in", values, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2NotIn(List<String> values) {
            addCriterion("Partic_Value2 not in", values, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2Between(String value1, String value2) {
            addCriterion("Partic_Value2 between", value1, value2, "particValue2");
            return (Criteria) this;
        }

        public Criteria andParticValue2NotBetween(String value1, String value2) {
            addCriterion("Partic_Value2 not between", value1, value2, "particValue2");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdIsNull() {
            addCriterion("Process_Def_Id is null");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdIsNotNull() {
            addCriterion("Process_Def_Id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdEqualTo(Long value) {
            addCriterion("Process_Def_Id =", value, "processDefId");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdNotEqualTo(Long value) {
            addCriterion("Process_Def_Id <>", value, "processDefId");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdGreaterThan(Long value) {
            addCriterion("Process_Def_Id >", value, "processDefId");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Process_Def_Id >=", value, "processDefId");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdLessThan(Long value) {
            addCriterion("Process_Def_Id <", value, "processDefId");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdLessThanOrEqualTo(Long value) {
            addCriterion("Process_Def_Id <=", value, "processDefId");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdIn(List<Long> values) {
            addCriterion("Process_Def_Id in", values, "processDefId");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdNotIn(List<Long> values) {
            addCriterion("Process_Def_Id not in", values, "processDefId");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdBetween(Long value1, Long value2) {
            addCriterion("Process_Def_Id between", value1, value2, "processDefId");
            return (Criteria) this;
        }

        public Criteria andProcessDefIdNotBetween(Long value1, Long value2) {
            addCriterion("Process_Def_Id not between", value1, value2, "processDefId");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdIsNull() {
            addCriterion("Activity_Def_Id is null");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdIsNotNull() {
            addCriterion("Activity_Def_Id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdEqualTo(Long value) {
            addCriterion("Activity_Def_Id =", value, "activityDefId");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdNotEqualTo(Long value) {
            addCriterion("Activity_Def_Id <>", value, "activityDefId");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdGreaterThan(Long value) {
            addCriterion("Activity_Def_Id >", value, "activityDefId");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Activity_Def_Id >=", value, "activityDefId");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdLessThan(Long value) {
            addCriterion("Activity_Def_Id <", value, "activityDefId");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdLessThanOrEqualTo(Long value) {
            addCriterion("Activity_Def_Id <=", value, "activityDefId");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdIn(List<Long> values) {
            addCriterion("Activity_Def_Id in", values, "activityDefId");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdNotIn(List<Long> values) {
            addCriterion("Activity_Def_Id not in", values, "activityDefId");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdBetween(Long value1, Long value2) {
            addCriterion("Activity_Def_Id between", value1, value2, "activityDefId");
            return (Criteria) this;
        }

        public Criteria andActivityDefIdNotBetween(Long value1, Long value2) {
            addCriterion("Activity_Def_Id not between", value1, value2, "activityDefId");
            return (Criteria) this;
        }

        public Criteria andParticValueIdIsNull() {
            addCriterion("Partic_Value_Id is null");
            return (Criteria) this;
        }

        public Criteria andParticValueIdIsNotNull() {
            addCriterion("Partic_Value_Id is not null");
            return (Criteria) this;
        }

        public Criteria andParticValueIdEqualTo(Long value) {
            addCriterion("Partic_Value_Id =", value, "particValueId");
            return (Criteria) this;
        }

        public Criteria andParticValueIdNotEqualTo(Long value) {
            addCriterion("Partic_Value_Id <>", value, "particValueId");
            return (Criteria) this;
        }

        public Criteria andParticValueIdGreaterThan(Long value) {
            addCriterion("Partic_Value_Id >", value, "particValueId");
            return (Criteria) this;
        }

        public Criteria andParticValueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Partic_Value_Id >=", value, "particValueId");
            return (Criteria) this;
        }

        public Criteria andParticValueIdLessThan(Long value) {
            addCriterion("Partic_Value_Id <", value, "particValueId");
            return (Criteria) this;
        }

        public Criteria andParticValueIdLessThanOrEqualTo(Long value) {
            addCriterion("Partic_Value_Id <=", value, "particValueId");
            return (Criteria) this;
        }

        public Criteria andParticValueIdIn(List<Long> values) {
            addCriterion("Partic_Value_Id in", values, "particValueId");
            return (Criteria) this;
        }

        public Criteria andParticValueIdNotIn(List<Long> values) {
            addCriterion("Partic_Value_Id not in", values, "particValueId");
            return (Criteria) this;
        }

        public Criteria andParticValueIdBetween(Long value1, Long value2) {
            addCriterion("Partic_Value_Id between", value1, value2, "particValueId");
            return (Criteria) this;
        }

        public Criteria andParticValueIdNotBetween(Long value1, Long value2) {
            addCriterion("Partic_Value_Id not between", value1, value2, "particValueId");
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