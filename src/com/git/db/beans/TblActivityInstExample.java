package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblActivityInstExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblActivityInstExample() {
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("Create_Time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("Create_Time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("Create_Time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("Create_Time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("Create_Time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Create_Time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("Create_Time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("Create_Time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("Create_Time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("Create_Time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("Create_Time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("Create_Time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFinalTimeIsNull() {
            addCriterion("Final_Time is null");
            return (Criteria) this;
        }

        public Criteria andFinalTimeIsNotNull() {
            addCriterion("Final_Time is not null");
            return (Criteria) this;
        }

        public Criteria andFinalTimeEqualTo(Date value) {
            addCriterion("Final_Time =", value, "finalTime");
            return (Criteria) this;
        }

        public Criteria andFinalTimeNotEqualTo(Date value) {
            addCriterion("Final_Time <>", value, "finalTime");
            return (Criteria) this;
        }

        public Criteria andFinalTimeGreaterThan(Date value) {
            addCriterion("Final_Time >", value, "finalTime");
            return (Criteria) this;
        }

        public Criteria andFinalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Final_Time >=", value, "finalTime");
            return (Criteria) this;
        }

        public Criteria andFinalTimeLessThan(Date value) {
            addCriterion("Final_Time <", value, "finalTime");
            return (Criteria) this;
        }

        public Criteria andFinalTimeLessThanOrEqualTo(Date value) {
            addCriterion("Final_Time <=", value, "finalTime");
            return (Criteria) this;
        }

        public Criteria andFinalTimeIn(List<Date> values) {
            addCriterion("Final_Time in", values, "finalTime");
            return (Criteria) this;
        }

        public Criteria andFinalTimeNotIn(List<Date> values) {
            addCriterion("Final_Time not in", values, "finalTime");
            return (Criteria) this;
        }

        public Criteria andFinalTimeBetween(Date value1, Date value2) {
            addCriterion("Final_Time between", value1, value2, "finalTime");
            return (Criteria) this;
        }

        public Criteria andFinalTimeNotBetween(Date value1, Date value2) {
            addCriterion("Final_Time not between", value1, value2, "finalTime");
            return (Criteria) this;
        }

        public Criteria andAduitResultIsNull() {
            addCriterion("Aduit_Result is null");
            return (Criteria) this;
        }

        public Criteria andAduitResultIsNotNull() {
            addCriterion("Aduit_Result is not null");
            return (Criteria) this;
        }

        public Criteria andAduitResultEqualTo(String value) {
            addCriterion("Aduit_Result =", value, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultNotEqualTo(String value) {
            addCriterion("Aduit_Result <>", value, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultGreaterThan(String value) {
            addCriterion("Aduit_Result >", value, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultGreaterThanOrEqualTo(String value) {
            addCriterion("Aduit_Result >=", value, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultLessThan(String value) {
            addCriterion("Aduit_Result <", value, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultLessThanOrEqualTo(String value) {
            addCriterion("Aduit_Result <=", value, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultLike(String value) {
            addCriterion("Aduit_Result like", value, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultNotLike(String value) {
            addCriterion("Aduit_Result not like", value, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultIn(List<String> values) {
            addCriterion("Aduit_Result in", values, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultNotIn(List<String> values) {
            addCriterion("Aduit_Result not in", values, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultBetween(String value1, String value2) {
            addCriterion("Aduit_Result between", value1, value2, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitResultNotBetween(String value1, String value2) {
            addCriterion("Aduit_Result not between", value1, value2, "aduitResult");
            return (Criteria) this;
        }

        public Criteria andAduitIsNull() {
            addCriterion("Aduit is null");
            return (Criteria) this;
        }

        public Criteria andAduitIsNotNull() {
            addCriterion("Aduit is not null");
            return (Criteria) this;
        }

        public Criteria andAduitEqualTo(String value) {
            addCriterion("Aduit =", value, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitNotEqualTo(String value) {
            addCriterion("Aduit <>", value, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitGreaterThan(String value) {
            addCriterion("Aduit >", value, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitGreaterThanOrEqualTo(String value) {
            addCriterion("Aduit >=", value, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitLessThan(String value) {
            addCriterion("Aduit <", value, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitLessThanOrEqualTo(String value) {
            addCriterion("Aduit <=", value, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitLike(String value) {
            addCriterion("Aduit like", value, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitNotLike(String value) {
            addCriterion("Aduit not like", value, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitIn(List<String> values) {
            addCriterion("Aduit in", values, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitNotIn(List<String> values) {
            addCriterion("Aduit not in", values, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitBetween(String value1, String value2) {
            addCriterion("Aduit between", value1, value2, "aduit");
            return (Criteria) this;
        }

        public Criteria andAduitNotBetween(String value1, String value2) {
            addCriterion("Aduit not between", value1, value2, "aduit");
            return (Criteria) this;
        }

        public Criteria andCheckdateIsNull() {
            addCriterion("checkdate is null");
            return (Criteria) this;
        }

        public Criteria andCheckdateIsNotNull() {
            addCriterion("checkdate is not null");
            return (Criteria) this;
        }

        public Criteria andCheckdateEqualTo(Date value) {
            addCriterion("checkdate =", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotEqualTo(Date value) {
            addCriterion("checkdate <>", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateGreaterThan(Date value) {
            addCriterion("checkdate >", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateGreaterThanOrEqualTo(Date value) {
            addCriterion("checkdate >=", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateLessThan(Date value) {
            addCriterion("checkdate <", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateLessThanOrEqualTo(Date value) {
            addCriterion("checkdate <=", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateIn(List<Date> values) {
            addCriterion("checkdate in", values, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotIn(List<Date> values) {
            addCriterion("checkdate not in", values, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateBetween(Date value1, Date value2) {
            addCriterion("checkdate between", value1, value2, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotBetween(Date value1, Date value2) {
            addCriterion("checkdate not between", value1, value2, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdesIsNull() {
            addCriterion("checkdes is null");
            return (Criteria) this;
        }

        public Criteria andCheckdesIsNotNull() {
            addCriterion("checkdes is not null");
            return (Criteria) this;
        }

        public Criteria andCheckdesEqualTo(String value) {
            addCriterion("checkdes =", value, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesNotEqualTo(String value) {
            addCriterion("checkdes <>", value, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesGreaterThan(String value) {
            addCriterion("checkdes >", value, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesGreaterThanOrEqualTo(String value) {
            addCriterion("checkdes >=", value, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesLessThan(String value) {
            addCriterion("checkdes <", value, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesLessThanOrEqualTo(String value) {
            addCriterion("checkdes <=", value, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesLike(String value) {
            addCriterion("checkdes like", value, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesNotLike(String value) {
            addCriterion("checkdes not like", value, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesIn(List<String> values) {
            addCriterion("checkdes in", values, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesNotIn(List<String> values) {
            addCriterion("checkdes not in", values, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesBetween(String value1, String value2) {
            addCriterion("checkdes between", value1, value2, "checkdes");
            return (Criteria) this;
        }

        public Criteria andCheckdesNotBetween(String value1, String value2) {
            addCriterion("checkdes not between", value1, value2, "checkdes");
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

        public Criteria andRemark1IsNull() {
            addCriterion("remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("remark1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("remark1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("remark1 not between", value1, value2, "remark1");
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