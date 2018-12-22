package com.git.db.beans;

import java.util.ArrayList;
import java.util.List;

public class TblActivityDefExample {
	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblActivityDefExample() {
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

        public Criteria andActivityNoIsNull() {
            addCriterion("Activity_No is null");
            return (Criteria) this;
        }

        public Criteria andActivityNoIsNotNull() {
            addCriterion("Activity_No is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNoEqualTo(String value) {
            addCriterion("Activity_No =", value, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoNotEqualTo(String value) {
            addCriterion("Activity_No <>", value, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoGreaterThan(String value) {
            addCriterion("Activity_No >", value, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoGreaterThanOrEqualTo(String value) {
            addCriterion("Activity_No >=", value, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoLessThan(String value) {
            addCriterion("Activity_No <", value, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoLessThanOrEqualTo(String value) {
            addCriterion("Activity_No <=", value, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoLike(String value) {
            addCriterion("Activity_No like", value, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoNotLike(String value) {
            addCriterion("Activity_No not like", value, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoIn(List<String> values) {
            addCriterion("Activity_No in", values, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoNotIn(List<String> values) {
            addCriterion("Activity_No not in", values, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoBetween(String value1, String value2) {
            addCriterion("Activity_No between", value1, value2, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNoNotBetween(String value1, String value2) {
            addCriterion("Activity_No not between", value1, value2, "activityNo");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNull() {
            addCriterion("Activity_Name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("Activity_Name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("Activity_Name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("Activity_Name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("Activity_Name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("Activity_Name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("Activity_Name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("Activity_Name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("Activity_Name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("Activity_Name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("Activity_Name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("Activity_Name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("Activity_Name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("Activity_Name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityDescIsNull() {
            addCriterion("Activity_Desc is null");
            return (Criteria) this;
        }

        public Criteria andActivityDescIsNotNull() {
            addCriterion("Activity_Desc is not null");
            return (Criteria) this;
        }

        public Criteria andActivityDescEqualTo(String value) {
            addCriterion("Activity_Desc =", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescNotEqualTo(String value) {
            addCriterion("Activity_Desc <>", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescGreaterThan(String value) {
            addCriterion("Activity_Desc >", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescGreaterThanOrEqualTo(String value) {
            addCriterion("Activity_Desc >=", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescLessThan(String value) {
            addCriterion("Activity_Desc <", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescLessThanOrEqualTo(String value) {
            addCriterion("Activity_Desc <=", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescLike(String value) {
            addCriterion("Activity_Desc like", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescNotLike(String value) {
            addCriterion("Activity_Desc not like", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescIn(List<String> values) {
            addCriterion("Activity_Desc in", values, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescNotIn(List<String> values) {
            addCriterion("Activity_Desc not in", values, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescBetween(String value1, String value2) {
            addCriterion("Activity_Desc between", value1, value2, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescNotBetween(String value1, String value2) {
            addCriterion("Activity_Desc not between", value1, value2, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andStartTypeIsNull() {
            addCriterion("Start_Type is null");
            return (Criteria) this;
        }

        public Criteria andStartTypeIsNotNull() {
            addCriterion("Start_Type is not null");
            return (Criteria) this;
        }

        public Criteria andStartTypeEqualTo(String value) {
            addCriterion("Start_Type =", value, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeNotEqualTo(String value) {
            addCriterion("Start_Type <>", value, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeGreaterThan(String value) {
            addCriterion("Start_Type >", value, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Start_Type >=", value, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeLessThan(String value) {
            addCriterion("Start_Type <", value, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeLessThanOrEqualTo(String value) {
            addCriterion("Start_Type <=", value, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeLike(String value) {
            addCriterion("Start_Type like", value, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeNotLike(String value) {
            addCriterion("Start_Type not like", value, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeIn(List<String> values) {
            addCriterion("Start_Type in", values, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeNotIn(List<String> values) {
            addCriterion("Start_Type not in", values, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeBetween(String value1, String value2) {
            addCriterion("Start_Type between", value1, value2, "startType");
            return (Criteria) this;
        }

        public Criteria andStartTypeNotBetween(String value1, String value2) {
            addCriterion("Start_Type not between", value1, value2, "startType");
            return (Criteria) this;
        }

        public Criteria andPreActivityIsNull() {
            addCriterion("Pre_Activity is null");
            return (Criteria) this;
        }

        public Criteria andPreActivityIsNotNull() {
            addCriterion("Pre_Activity is not null");
            return (Criteria) this;
        }

        public Criteria andPreActivityEqualTo(String value) {
            addCriterion("Pre_Activity =", value, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityNotEqualTo(String value) {
            addCriterion("Pre_Activity <>", value, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityGreaterThan(String value) {
            addCriterion("Pre_Activity >", value, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityGreaterThanOrEqualTo(String value) {
            addCriterion("Pre_Activity >=", value, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityLessThan(String value) {
            addCriterion("Pre_Activity <", value, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityLessThanOrEqualTo(String value) {
            addCriterion("Pre_Activity <=", value, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityLike(String value) {
            addCriterion("Pre_Activity like", value, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityNotLike(String value) {
            addCriterion("Pre_Activity not like", value, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityIn(List<String> values) {
            addCriterion("Pre_Activity in", values, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityNotIn(List<String> values) {
            addCriterion("Pre_Activity not in", values, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityBetween(String value1, String value2) {
            addCriterion("Pre_Activity between", value1, value2, "preActivity");
            return (Criteria) this;
        }

        public Criteria andPreActivityNotBetween(String value1, String value2) {
            addCriterion("Pre_Activity not between", value1, value2, "preActivity");
            return (Criteria) this;
        }

        public Criteria andParam1IsNull() {
            addCriterion("Param1 is null");
            return (Criteria) this;
        }

        public Criteria andParam1IsNotNull() {
            addCriterion("Param1 is not null");
            return (Criteria) this;
        }

        public Criteria andParam1EqualTo(Float value) {
            addCriterion("Param1 =", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotEqualTo(Float value) {
            addCriterion("Param1 <>", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1GreaterThan(Float value) {
            addCriterion("Param1 >", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1GreaterThanOrEqualTo(Float value) {
            addCriterion("Param1 >=", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1LessThan(Float value) {
            addCriterion("Param1 <", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1LessThanOrEqualTo(Float value) {
            addCriterion("Param1 <=", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1In(List<Float> values) {
            addCriterion("Param1 in", values, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotIn(List<Float> values) {
            addCriterion("Param1 not in", values, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1Between(Float value1, Float value2) {
            addCriterion("Param1 between", value1, value2, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotBetween(Float value1, Float value2) {
            addCriterion("Param1 not between", value1, value2, "param1");
            return (Criteria) this;
        }

        public Criteria andParam2IsNull() {
            addCriterion("Param2 is null");
            return (Criteria) this;
        }

        public Criteria andParam2IsNotNull() {
            addCriterion("Param2 is not null");
            return (Criteria) this;
        }

        public Criteria andParam2EqualTo(String value) {
            addCriterion("Param2 =", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotEqualTo(String value) {
            addCriterion("Param2 <>", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2GreaterThan(String value) {
            addCriterion("Param2 >", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2GreaterThanOrEqualTo(String value) {
            addCriterion("Param2 >=", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2LessThan(String value) {
            addCriterion("Param2 <", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2LessThanOrEqualTo(String value) {
            addCriterion("Param2 <=", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2Like(String value) {
            addCriterion("Param2 like", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotLike(String value) {
            addCriterion("Param2 not like", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2In(List<String> values) {
            addCriterion("Param2 in", values, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotIn(List<String> values) {
            addCriterion("Param2 not in", values, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2Between(String value1, String value2) {
            addCriterion("Param2 between", value1, value2, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotBetween(String value1, String value2) {
            addCriterion("Param2 not between", value1, value2, "param2");
            return (Criteria) this;
        }

        public Criteria andParam3IsNull() {
            addCriterion("Param3 is null");
            return (Criteria) this;
        }

        public Criteria andParam3IsNotNull() {
            addCriterion("Param3 is not null");
            return (Criteria) this;
        }

        public Criteria andParam3EqualTo(String value) {
            addCriterion("Param3 =", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotEqualTo(String value) {
            addCriterion("Param3 <>", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3GreaterThan(String value) {
            addCriterion("Param3 >", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3GreaterThanOrEqualTo(String value) {
            addCriterion("Param3 >=", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3LessThan(String value) {
            addCriterion("Param3 <", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3LessThanOrEqualTo(String value) {
            addCriterion("Param3 <=", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3Like(String value) {
            addCriterion("Param3 like", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotLike(String value) {
            addCriterion("Param3 not like", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3In(List<String> values) {
            addCriterion("Param3 in", values, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotIn(List<String> values) {
            addCriterion("Param3 not in", values, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3Between(String value1, String value2) {
            addCriterion("Param3 between", value1, value2, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotBetween(String value1, String value2) {
            addCriterion("Param3 not between", value1, value2, "param3");
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