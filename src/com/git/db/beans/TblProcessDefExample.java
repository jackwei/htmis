package com.git.db.beans;

import java.util.ArrayList;
import java.util.List;

public class TblProcessDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblProcessDefExample() {
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

        public Criteria andProcessNoIsNull() {
            addCriterion("Process_No is null");
            return (Criteria) this;
        }

        public Criteria andProcessNoIsNotNull() {
            addCriterion("Process_No is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNoEqualTo(String value) {
            addCriterion("Process_No =", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotEqualTo(String value) {
            addCriterion("Process_No <>", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoGreaterThan(String value) {
            addCriterion("Process_No >", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoGreaterThanOrEqualTo(String value) {
            addCriterion("Process_No >=", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoLessThan(String value) {
            addCriterion("Process_No <", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoLessThanOrEqualTo(String value) {
            addCriterion("Process_No <=", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoLike(String value) {
            addCriterion("Process_No like", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotLike(String value) {
            addCriterion("Process_No not like", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoIn(List<String> values) {
            addCriterion("Process_No in", values, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotIn(List<String> values) {
            addCriterion("Process_No not in", values, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoBetween(String value1, String value2) {
            addCriterion("Process_No between", value1, value2, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotBetween(String value1, String value2) {
            addCriterion("Process_No not between", value1, value2, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNull() {
            addCriterion("Process_Name is null");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNotNull() {
            addCriterion("Process_Name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNameEqualTo(String value) {
            addCriterion("Process_Name =", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotEqualTo(String value) {
            addCriterion("Process_Name <>", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThan(String value) {
            addCriterion("Process_Name >", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("Process_Name >=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThan(String value) {
            addCriterion("Process_Name <", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThanOrEqualTo(String value) {
            addCriterion("Process_Name <=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLike(String value) {
            addCriterion("Process_Name like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotLike(String value) {
            addCriterion("Process_Name not like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameIn(List<String> values) {
            addCriterion("Process_Name in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotIn(List<String> values) {
            addCriterion("Process_Name not in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameBetween(String value1, String value2) {
            addCriterion("Process_Name between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotBetween(String value1, String value2) {
            addCriterion("Process_Name not between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessDescIsNull() {
            addCriterion("Process_Desc is null");
            return (Criteria) this;
        }

        public Criteria andProcessDescIsNotNull() {
            addCriterion("Process_Desc is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDescEqualTo(String value) {
            addCriterion("Process_Desc =", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotEqualTo(String value) {
            addCriterion("Process_Desc <>", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescGreaterThan(String value) {
            addCriterion("Process_Desc >", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescGreaterThanOrEqualTo(String value) {
            addCriterion("Process_Desc >=", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLessThan(String value) {
            addCriterion("Process_Desc <", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLessThanOrEqualTo(String value) {
            addCriterion("Process_Desc <=", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLike(String value) {
            addCriterion("Process_Desc like", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotLike(String value) {
            addCriterion("Process_Desc not like", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescIn(List<String> values) {
            addCriterion("Process_Desc in", values, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotIn(List<String> values) {
            addCriterion("Process_Desc not in", values, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescBetween(String value1, String value2) {
            addCriterion("Process_Desc between", value1, value2, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotBetween(String value1, String value2) {
            addCriterion("Process_Desc not between", value1, value2, "processDesc");
            return (Criteria) this;
        }

        public Criteria andCurrentStateIsNull() {
            addCriterion("Current_State is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStateIsNotNull() {
            addCriterion("Current_State is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStateEqualTo(String value) {
            addCriterion("Current_State =", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotEqualTo(String value) {
            addCriterion("Current_State <>", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateGreaterThan(String value) {
            addCriterion("Current_State >", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateGreaterThanOrEqualTo(String value) {
            addCriterion("Current_State >=", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateLessThan(String value) {
            addCriterion("Current_State <", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateLessThanOrEqualTo(String value) {
            addCriterion("Current_State <=", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateLike(String value) {
            addCriterion("Current_State like", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotLike(String value) {
            addCriterion("Current_State not like", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateIn(List<String> values) {
            addCriterion("Current_State in", values, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotIn(List<String> values) {
            addCriterion("Current_State not in", values, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateBetween(String value1, String value2) {
            addCriterion("Current_State between", value1, value2, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotBetween(String value1, String value2) {
            addCriterion("Current_State not between", value1, value2, "currentState");
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