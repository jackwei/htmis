package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TblProcessInstExample {
	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblProcessInstExample() {
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

        public Criteria andBussNoIsNull() {
            addCriterion("Buss_No is null");
            return (Criteria) this;
        }

        public Criteria andBussNoIsNotNull() {
            addCriterion("Buss_No is not null");
            return (Criteria) this;
        }

        public Criteria andBussNoEqualTo(String value) {
            addCriterion("Buss_No =", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoNotEqualTo(String value) {
            addCriterion("Buss_No <>", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoGreaterThan(String value) {
            addCriterion("Buss_No >", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoGreaterThanOrEqualTo(String value) {
            addCriterion("Buss_No >=", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoLessThan(String value) {
            addCriterion("Buss_No <", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoLessThanOrEqualTo(String value) {
            addCriterion("Buss_No <=", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoLike(String value) {
            addCriterion("Buss_No like", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoNotLike(String value) {
            addCriterion("Buss_No not like", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoIn(List<String> values) {
            addCriterion("Buss_No in", values, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoNotIn(List<String> values) {
            addCriterion("Buss_No not in", values, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoBetween(String value1, String value2) {
            addCriterion("Buss_No between", value1, value2, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoNotBetween(String value1, String value2) {
            addCriterion("Buss_No not between", value1, value2, "bussNo");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameIsNull() {
            addCriterion("ProcessInstName is null");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameIsNotNull() {
            addCriterion("ProcessInstName is not null");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameEqualTo(String value) {
            addCriterion("ProcessInstName =", value, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameNotEqualTo(String value) {
            addCriterion("ProcessInstName <>", value, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameGreaterThan(String value) {
            addCriterion("ProcessInstName >", value, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameGreaterThanOrEqualTo(String value) {
            addCriterion("ProcessInstName >=", value, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameLessThan(String value) {
            addCriterion("ProcessInstName <", value, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameLessThanOrEqualTo(String value) {
            addCriterion("ProcessInstName <=", value, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameLike(String value) {
            addCriterion("ProcessInstName like", value, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameNotLike(String value) {
            addCriterion("ProcessInstName not like", value, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameIn(List<String> values) {
            addCriterion("ProcessInstName in", values, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameNotIn(List<String> values) {
            addCriterion("ProcessInstName not in", values, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameBetween(String value1, String value2) {
            addCriterion("ProcessInstName between", value1, value2, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstnameNotBetween(String value1, String value2) {
            addCriterion("ProcessInstName not between", value1, value2, "processinstname");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescIsNull() {
            addCriterion("ProcessInstDesc is null");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescIsNotNull() {
            addCriterion("ProcessInstDesc is not null");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescEqualTo(String value) {
            addCriterion("ProcessInstDesc =", value, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescNotEqualTo(String value) {
            addCriterion("ProcessInstDesc <>", value, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescGreaterThan(String value) {
            addCriterion("ProcessInstDesc >", value, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescGreaterThanOrEqualTo(String value) {
            addCriterion("ProcessInstDesc >=", value, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescLessThan(String value) {
            addCriterion("ProcessInstDesc <", value, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescLessThanOrEqualTo(String value) {
            addCriterion("ProcessInstDesc <=", value, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescLike(String value) {
            addCriterion("ProcessInstDesc like", value, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescNotLike(String value) {
            addCriterion("ProcessInstDesc not like", value, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescIn(List<String> values) {
            addCriterion("ProcessInstDesc in", values, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescNotIn(List<String> values) {
            addCriterion("ProcessInstDesc not in", values, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescBetween(String value1, String value2) {
            addCriterion("ProcessInstDesc between", value1, value2, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andProcessinstdescNotBetween(String value1, String value2) {
            addCriterion("ProcessInstDesc not between", value1, value2, "processinstdesc");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("Creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("Creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("Creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("Creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("Creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("Creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("Creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("Creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("Creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("Creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("Creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("Creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("Creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("Creator not between", value1, value2, "creator");
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

        public Criteria andParam4IsNull() {
            addCriterion("Param4 is null");
            return (Criteria) this;
        }

        public Criteria andParam4IsNotNull() {
            addCriterion("Param4 is not null");
            return (Criteria) this;
        }

        public Criteria andParam4EqualTo(Long value) {
            addCriterion("Param4 =", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4NotEqualTo(Long value) {
            addCriterion("Param4 <>", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4GreaterThan(Long value) {
            addCriterion("Param4 >", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4GreaterThanOrEqualTo(Long value) {
            addCriterion("Param4 >=", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4LessThan(Long value) {
            addCriterion("Param4 <", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4LessThanOrEqualTo(Long value) {
            addCriterion("Param4 <=", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4In(List<Long> values) {
            addCriterion("Param4 in", values, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4NotIn(List<Long> values) {
            addCriterion("Param4 not in", values, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4Between(Long value1, Long value2) {
            addCriterion("Param4 between", value1, value2, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4NotBetween(Long value1, Long value2) {
            addCriterion("Param4 not between", value1, value2, "param4");
            return (Criteria) this;
        }

        public Criteria andParam5IsNull() {
            addCriterion("Param5 is null");
            return (Criteria) this;
        }

        public Criteria andParam5IsNotNull() {
            addCriterion("Param5 is not null");
            return (Criteria) this;
        }

        public Criteria andParam5EqualTo(Date value) {
            addCriterionForJDBCDate("Param5 =", value, "param5");
            return (Criteria) this;
        }

        public Criteria andParam5NotEqualTo(Date value) {
            addCriterionForJDBCDate("Param5 <>", value, "param5");
            return (Criteria) this;
        }

        public Criteria andParam5GreaterThan(Date value) {
            addCriterionForJDBCDate("Param5 >", value, "param5");
            return (Criteria) this;
        }

        public Criteria andParam5GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Param5 >=", value, "param5");
            return (Criteria) this;
        }

        public Criteria andParam5LessThan(Date value) {
            addCriterionForJDBCDate("Param5 <", value, "param5");
            return (Criteria) this;
        }

        public Criteria andParam5LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Param5 <=", value, "param5");
            return (Criteria) this;
        }

        public Criteria andParam5In(List<Date> values) {
            addCriterionForJDBCDate("Param5 in", values, "param5");
            return (Criteria) this;
        }

        public Criteria andParam5NotIn(List<Date> values) {
            addCriterionForJDBCDate("Param5 not in", values, "param5");
            return (Criteria) this;
        }

        public Criteria andParam5Between(Date value1, Date value2) {
            addCriterionForJDBCDate("Param5 between", value1, value2, "param5");
            return (Criteria) this;
        }

        public Criteria andParam5NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Param5 not between", value1, value2, "param5");
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