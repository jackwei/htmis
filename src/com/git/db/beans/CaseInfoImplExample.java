package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseInfoImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaseInfoImplExample() {
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

        public Criteria andCaseIdIsNull() {
            addCriterion("Case_Id is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("Case_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(Long value) {
            addCriterion("Case_Id =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(Long value) {
            addCriterion("Case_Id <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(Long value) {
            addCriterion("Case_Id >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Case_Id >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(Long value) {
            addCriterion("Case_Id <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(Long value) {
            addCriterion("Case_Id <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<Long> values) {
            addCriterion("Case_Id in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<Long> values) {
            addCriterion("Case_Id not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(Long value1, Long value2) {
            addCriterion("Case_Id between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(Long value1, Long value2) {
            addCriterion("Case_Id not between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCasenumberIsNull() {
            addCriterion("casenumber is null");
            return (Criteria) this;
        }

        public Criteria andCasenumberIsNotNull() {
            addCriterion("casenumber is not null");
            return (Criteria) this;
        }

        public Criteria andCasenumberEqualTo(String value) {
            addCriterion("casenumber =", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberNotEqualTo(String value) {
            addCriterion("casenumber <>", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberGreaterThan(String value) {
            addCriterion("casenumber >", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberGreaterThanOrEqualTo(String value) {
            addCriterion("casenumber >=", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberLessThan(String value) {
            addCriterion("casenumber <", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberLessThanOrEqualTo(String value) {
            addCriterion("casenumber <=", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberLike(String value) {
            addCriterion("casenumber like", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberNotLike(String value) {
            addCriterion("casenumber not like", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberIn(List<String> values) {
            addCriterion("casenumber in", values, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberNotIn(List<String> values) {
            addCriterion("casenumber not in", values, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberBetween(String value1, String value2) {
            addCriterion("casenumber between", value1, value2, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberNotBetween(String value1, String value2) {
            addCriterion("casenumber not between", value1, value2, "casenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberIsNull() {
            addCriterion("excasenumber is null");
            return (Criteria) this;
        }

        public Criteria andExcasenumberIsNotNull() {
            addCriterion("excasenumber is not null");
            return (Criteria) this;
        }

        public Criteria andExcasenumberEqualTo(String value) {
            addCriterion("excasenumber =", value, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberNotEqualTo(String value) {
            addCriterion("excasenumber <>", value, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberGreaterThan(String value) {
            addCriterion("excasenumber >", value, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberGreaterThanOrEqualTo(String value) {
            addCriterion("excasenumber >=", value, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberLessThan(String value) {
            addCriterion("excasenumber <", value, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberLessThanOrEqualTo(String value) {
            addCriterion("excasenumber <=", value, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberLike(String value) {
            addCriterion("excasenumber like", value, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberNotLike(String value) {
            addCriterion("excasenumber not like", value, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberIn(List<String> values) {
            addCriterion("excasenumber in", values, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberNotIn(List<String> values) {
            addCriterion("excasenumber not in", values, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberBetween(String value1, String value2) {
            addCriterion("excasenumber between", value1, value2, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andExcasenumberNotBetween(String value1, String value2) {
            addCriterion("excasenumber not between", value1, value2, "excasenumber");
            return (Criteria) this;
        }

        public Criteria andAcademynumIsNull() {
            addCriterion("academynum is null");
            return (Criteria) this;
        }

        public Criteria andAcademynumIsNotNull() {
            addCriterion("academynum is not null");
            return (Criteria) this;
        }

        public Criteria andAcademynumEqualTo(String value) {
            addCriterion("academynum =", value, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumNotEqualTo(String value) {
            addCriterion("academynum <>", value, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumGreaterThan(String value) {
            addCriterion("academynum >", value, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumGreaterThanOrEqualTo(String value) {
            addCriterion("academynum >=", value, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumLessThan(String value) {
            addCriterion("academynum <", value, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumLessThanOrEqualTo(String value) {
            addCriterion("academynum <=", value, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumLike(String value) {
            addCriterion("academynum like", value, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumNotLike(String value) {
            addCriterion("academynum not like", value, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumIn(List<String> values) {
            addCriterion("academynum in", values, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumNotIn(List<String> values) {
            addCriterion("academynum not in", values, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumBetween(String value1, String value2) {
            addCriterion("academynum between", value1, value2, "academynum");
            return (Criteria) this;
        }

        public Criteria andAcademynumNotBetween(String value1, String value2) {
            addCriterion("academynum not between", value1, value2, "academynum");
            return (Criteria) this;
        }

        public Criteria andShipnameIsNull() {
            addCriterion("shipname is null");
            return (Criteria) this;
        }

        public Criteria andShipnameIsNotNull() {
            addCriterion("shipname is not null");
            return (Criteria) this;
        }

        public Criteria andShipnameEqualTo(String value) {
            addCriterion("shipname =", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameNotEqualTo(String value) {
            addCriterion("shipname <>", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameGreaterThan(String value) {
            addCriterion("shipname >", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameGreaterThanOrEqualTo(String value) {
            addCriterion("shipname >=", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameLessThan(String value) {
            addCriterion("shipname <", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameLessThanOrEqualTo(String value) {
            addCriterion("shipname <=", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameLike(String value) {
            addCriterion("shipname like", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameNotLike(String value) {
            addCriterion("shipname not like", value, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameIn(List<String> values) {
            addCriterion("shipname in", values, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameNotIn(List<String> values) {
            addCriterion("shipname not in", values, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameBetween(String value1, String value2) {
            addCriterion("shipname between", value1, value2, "shipname");
            return (Criteria) this;
        }

        public Criteria andShipnameNotBetween(String value1, String value2) {
            addCriterion("shipname not between", value1, value2, "shipname");
            return (Criteria) this;
        }

        public Criteria andCasetypeidIsNull() {
            addCriterion("casetypeid is null");
            return (Criteria) this;
        }

        public Criteria andCasetypeidIsNotNull() {
            addCriterion("casetypeid is not null");
            return (Criteria) this;
        }

        public Criteria andCasetypeidEqualTo(String value) {
            addCriterion("casetypeid =", value, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidNotEqualTo(String value) {
            addCriterion("casetypeid <>", value, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidGreaterThan(String value) {
            addCriterion("casetypeid >", value, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidGreaterThanOrEqualTo(String value) {
            addCriterion("casetypeid >=", value, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidLessThan(String value) {
            addCriterion("casetypeid <", value, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidLessThanOrEqualTo(String value) {
            addCriterion("casetypeid <=", value, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidLike(String value) {
            addCriterion("casetypeid like", value, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidNotLike(String value) {
            addCriterion("casetypeid not like", value, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidIn(List<String> values) {
            addCriterion("casetypeid in", values, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidNotIn(List<String> values) {
            addCriterion("casetypeid not in", values, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidBetween(String value1, String value2) {
            addCriterion("casetypeid between", value1, value2, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypeidNotBetween(String value1, String value2) {
            addCriterion("casetypeid not between", value1, value2, "casetypeid");
            return (Criteria) this;
        }

        public Criteria andCasetypenameIsNull() {
            addCriterion("casetypename is null");
            return (Criteria) this;
        }

        public Criteria andCasetypenameIsNotNull() {
            addCriterion("casetypename is not null");
            return (Criteria) this;
        }

        public Criteria andCasetypenameEqualTo(String value) {
            addCriterion("casetypename =", value, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameNotEqualTo(String value) {
            addCriterion("casetypename <>", value, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameGreaterThan(String value) {
            addCriterion("casetypename >", value, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameGreaterThanOrEqualTo(String value) {
            addCriterion("casetypename >=", value, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameLessThan(String value) {
            addCriterion("casetypename <", value, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameLessThanOrEqualTo(String value) {
            addCriterion("casetypename <=", value, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameLike(String value) {
            addCriterion("casetypename like", value, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameNotLike(String value) {
            addCriterion("casetypename not like", value, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameIn(List<String> values) {
            addCriterion("casetypename in", values, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameNotIn(List<String> values) {
            addCriterion("casetypename not in", values, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameBetween(String value1, String value2) {
            addCriterion("casetypename between", value1, value2, "casetypename");
            return (Criteria) this;
        }

        public Criteria andCasetypenameNotBetween(String value1, String value2) {
            addCriterion("casetypename not between", value1, value2, "casetypename");
            return (Criteria) this;
        }

        public Criteria andAccidentdateIsNull() {
            addCriterion("accidentdate is null");
            return (Criteria) this;
        }

        public Criteria andAccidentdateIsNotNull() {
            addCriterion("accidentdate is not null");
            return (Criteria) this;
        }

        public Criteria andAccidentdateEqualTo(Date value) {
            addCriterion("accidentdate =", value, "accidentdate");
            return (Criteria) this;
        }

        public Criteria andAccidentdateNotEqualTo(Date value) {
            addCriterion("accidentdate <>", value, "accidentdate");
            return (Criteria) this;
        }

        public Criteria andAccidentdateGreaterThan(Date value) {
            addCriterion("accidentdate >", value, "accidentdate");
            return (Criteria) this;
        }

        public Criteria andAccidentdateGreaterThanOrEqualTo(Date value) {
            addCriterion("accidentdate >=", value, "accidentdate");
            return (Criteria) this;
        }

        public Criteria andAccidentdateLessThan(Date value) {
            addCriterion("accidentdate <", value, "accidentdate");
            return (Criteria) this;
        }

        public Criteria andAccidentdateLessThanOrEqualTo(Date value) {
            addCriterion("accidentdate <=", value, "accidentdate");
            return (Criteria) this;
        }

        public Criteria andAccidentdateIn(List<Date> values) {
            addCriterion("accidentdate in", values, "accidentdate");
            return (Criteria) this;
        }

        public Criteria andAccidentdateNotIn(List<Date> values) {
            addCriterion("accidentdate not in", values, "accidentdate");
            return (Criteria) this;
        }

        public Criteria andAccidentdateBetween(Date value1, Date value2) {
            addCriterion("accidentdate between", value1, value2, "accidentdate");
            return (Criteria) this;
        }

        public Criteria andAccidentdateNotBetween(Date value1, Date value2) {
            addCriterion("accidentdate not between", value1, value2, "accidentdate");
            return (Criteria) this;
        }

        public Criteria andAccidentportidIsNull() {
            addCriterion("accidentportid is null");
            return (Criteria) this;
        }

        public Criteria andAccidentportidIsNotNull() {
            addCriterion("accidentportid is not null");
            return (Criteria) this;
        }

        public Criteria andAccidentportidEqualTo(String value) {
            addCriterion("accidentportid =", value, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidNotEqualTo(String value) {
            addCriterion("accidentportid <>", value, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidGreaterThan(String value) {
            addCriterion("accidentportid >", value, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidGreaterThanOrEqualTo(String value) {
            addCriterion("accidentportid >=", value, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidLessThan(String value) {
            addCriterion("accidentportid <", value, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidLessThanOrEqualTo(String value) {
            addCriterion("accidentportid <=", value, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidLike(String value) {
            addCriterion("accidentportid like", value, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidNotLike(String value) {
            addCriterion("accidentportid not like", value, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidIn(List<String> values) {
            addCriterion("accidentportid in", values, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidNotIn(List<String> values) {
            addCriterion("accidentportid not in", values, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidBetween(String value1, String value2) {
            addCriterion("accidentportid between", value1, value2, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportidNotBetween(String value1, String value2) {
            addCriterion("accidentportid not between", value1, value2, "accidentportid");
            return (Criteria) this;
        }

        public Criteria andAccidentportIsNull() {
            addCriterion("accidentport is null");
            return (Criteria) this;
        }

        public Criteria andAccidentportIsNotNull() {
            addCriterion("accidentport is not null");
            return (Criteria) this;
        }

        public Criteria andAccidentportEqualTo(String value) {
            addCriterion("accidentport =", value, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportNotEqualTo(String value) {
            addCriterion("accidentport <>", value, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportGreaterThan(String value) {
            addCriterion("accidentport >", value, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportGreaterThanOrEqualTo(String value) {
            addCriterion("accidentport >=", value, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportLessThan(String value) {
            addCriterion("accidentport <", value, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportLessThanOrEqualTo(String value) {
            addCriterion("accidentport <=", value, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportLike(String value) {
            addCriterion("accidentport like", value, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportNotLike(String value) {
            addCriterion("accidentport not like", value, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportIn(List<String> values) {
            addCriterion("accidentport in", values, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportNotIn(List<String> values) {
            addCriterion("accidentport not in", values, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportBetween(String value1, String value2) {
            addCriterion("accidentport between", value1, value2, "accidentport");
            return (Criteria) this;
        }

        public Criteria andAccidentportNotBetween(String value1, String value2) {
            addCriterion("accidentport not between", value1, value2, "accidentport");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidIsNull() {
            addCriterion("consignortypeid is null");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidIsNotNull() {
            addCriterion("consignortypeid is not null");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidEqualTo(String value) {
            addCriterion("consignortypeid =", value, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidNotEqualTo(String value) {
            addCriterion("consignortypeid <>", value, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidGreaterThan(String value) {
            addCriterion("consignortypeid >", value, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidGreaterThanOrEqualTo(String value) {
            addCriterion("consignortypeid >=", value, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidLessThan(String value) {
            addCriterion("consignortypeid <", value, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidLessThanOrEqualTo(String value) {
            addCriterion("consignortypeid <=", value, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidLike(String value) {
            addCriterion("consignortypeid like", value, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidNotLike(String value) {
            addCriterion("consignortypeid not like", value, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidIn(List<String> values) {
            addCriterion("consignortypeid in", values, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidNotIn(List<String> values) {
            addCriterion("consignortypeid not in", values, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidBetween(String value1, String value2) {
            addCriterion("consignortypeid between", value1, value2, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypeidNotBetween(String value1, String value2) {
            addCriterion("consignortypeid not between", value1, value2, "consignortypeid");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameIsNull() {
            addCriterion("consignortypename is null");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameIsNotNull() {
            addCriterion("consignortypename is not null");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameEqualTo(String value) {
            addCriterion("consignortypename =", value, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameNotEqualTo(String value) {
            addCriterion("consignortypename <>", value, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameGreaterThan(String value) {
            addCriterion("consignortypename >", value, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameGreaterThanOrEqualTo(String value) {
            addCriterion("consignortypename >=", value, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameLessThan(String value) {
            addCriterion("consignortypename <", value, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameLessThanOrEqualTo(String value) {
            addCriterion("consignortypename <=", value, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameLike(String value) {
            addCriterion("consignortypename like", value, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameNotLike(String value) {
            addCriterion("consignortypename not like", value, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameIn(List<String> values) {
            addCriterion("consignortypename in", values, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameNotIn(List<String> values) {
            addCriterion("consignortypename not in", values, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameBetween(String value1, String value2) {
            addCriterion("consignortypename between", value1, value2, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignortypenameNotBetween(String value1, String value2) {
            addCriterion("consignortypename not between", value1, value2, "consignortypename");
            return (Criteria) this;
        }

        public Criteria andConsignoridIsNull() {
            addCriterion("consignorid is null");
            return (Criteria) this;
        }

        public Criteria andConsignoridIsNotNull() {
            addCriterion("consignorid is not null");
            return (Criteria) this;
        }

        public Criteria andConsignoridEqualTo(String value) {
            addCriterion("consignorid =", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridNotEqualTo(String value) {
            addCriterion("consignorid <>", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridGreaterThan(String value) {
            addCriterion("consignorid >", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridGreaterThanOrEqualTo(String value) {
            addCriterion("consignorid >=", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridLessThan(String value) {
            addCriterion("consignorid <", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridLessThanOrEqualTo(String value) {
            addCriterion("consignorid <=", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridLike(String value) {
            addCriterion("consignorid like", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridNotLike(String value) {
            addCriterion("consignorid not like", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridIn(List<String> values) {
            addCriterion("consignorid in", values, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridNotIn(List<String> values) {
            addCriterion("consignorid not in", values, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridBetween(String value1, String value2) {
            addCriterion("consignorid between", value1, value2, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridNotBetween(String value1, String value2) {
            addCriterion("consignorid not between", value1, value2, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignornameIsNull() {
            addCriterion("consignorname is null");
            return (Criteria) this;
        }

        public Criteria andConsignornameIsNotNull() {
            addCriterion("consignorname is not null");
            return (Criteria) this;
        }

        public Criteria andConsignornameEqualTo(String value) {
            addCriterion("consignorname =", value, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameNotEqualTo(String value) {
            addCriterion("consignorname <>", value, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameGreaterThan(String value) {
            addCriterion("consignorname >", value, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameGreaterThanOrEqualTo(String value) {
            addCriterion("consignorname >=", value, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameLessThan(String value) {
            addCriterion("consignorname <", value, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameLessThanOrEqualTo(String value) {
            addCriterion("consignorname <=", value, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameLike(String value) {
            addCriterion("consignorname like", value, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameNotLike(String value) {
            addCriterion("consignorname not like", value, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameIn(List<String> values) {
            addCriterion("consignorname in", values, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameNotIn(List<String> values) {
            addCriterion("consignorname not in", values, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameBetween(String value1, String value2) {
            addCriterion("consignorname between", value1, value2, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignornameNotBetween(String value1, String value2) {
            addCriterion("consignorname not between", value1, value2, "consignorname");
            return (Criteria) this;
        }

        public Criteria andConsignorsnIsNull() {
            addCriterion("consignorsn is null");
            return (Criteria) this;
        }

        public Criteria andConsignorsnIsNotNull() {
            addCriterion("consignorsn is not null");
            return (Criteria) this;
        }

        public Criteria andConsignorsnEqualTo(String value) {
            addCriterion("consignorsn =", value, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnNotEqualTo(String value) {
            addCriterion("consignorsn <>", value, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnGreaterThan(String value) {
            addCriterion("consignorsn >", value, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnGreaterThanOrEqualTo(String value) {
            addCriterion("consignorsn >=", value, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnLessThan(String value) {
            addCriterion("consignorsn <", value, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnLessThanOrEqualTo(String value) {
            addCriterion("consignorsn <=", value, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnLike(String value) {
            addCriterion("consignorsn like", value, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnNotLike(String value) {
            addCriterion("consignorsn not like", value, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnIn(List<String> values) {
            addCriterion("consignorsn in", values, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnNotIn(List<String> values) {
            addCriterion("consignorsn not in", values, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnBetween(String value1, String value2) {
            addCriterion("consignorsn between", value1, value2, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andConsignorsnNotBetween(String value1, String value2) {
            addCriterion("consignorsn not between", value1, value2, "consignorsn");
            return (Criteria) this;
        }

        public Criteria andCasecontactIsNull() {
            addCriterion("casecontact is null");
            return (Criteria) this;
        }

        public Criteria andCasecontactIsNotNull() {
            addCriterion("casecontact is not null");
            return (Criteria) this;
        }

        public Criteria andCasecontactEqualTo(String value) {
            addCriterion("casecontact =", value, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactNotEqualTo(String value) {
            addCriterion("casecontact <>", value, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactGreaterThan(String value) {
            addCriterion("casecontact >", value, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactGreaterThanOrEqualTo(String value) {
            addCriterion("casecontact >=", value, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactLessThan(String value) {
            addCriterion("casecontact <", value, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactLessThanOrEqualTo(String value) {
            addCriterion("casecontact <=", value, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactLike(String value) {
            addCriterion("casecontact like", value, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactNotLike(String value) {
            addCriterion("casecontact not like", value, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactIn(List<String> values) {
            addCriterion("casecontact in", values, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactNotIn(List<String> values) {
            addCriterion("casecontact not in", values, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactBetween(String value1, String value2) {
            addCriterion("casecontact between", value1, value2, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCasecontactNotBetween(String value1, String value2) {
            addCriterion("casecontact not between", value1, value2, "casecontact");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyIsNull() {
            addCriterion("checkcompany is null");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyIsNotNull() {
            addCriterion("checkcompany is not null");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyEqualTo(String value) {
            addCriterion("checkcompany =", value, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyNotEqualTo(String value) {
            addCriterion("checkcompany <>", value, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyGreaterThan(String value) {
            addCriterion("checkcompany >", value, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyGreaterThanOrEqualTo(String value) {
            addCriterion("checkcompany >=", value, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyLessThan(String value) {
            addCriterion("checkcompany <", value, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyLessThanOrEqualTo(String value) {
            addCriterion("checkcompany <=", value, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyLike(String value) {
            addCriterion("checkcompany like", value, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyNotLike(String value) {
            addCriterion("checkcompany not like", value, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyIn(List<String> values) {
            addCriterion("checkcompany in", values, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyNotIn(List<String> values) {
            addCriterion("checkcompany not in", values, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyBetween(String value1, String value2) {
            addCriterion("checkcompany between", value1, value2, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andCheckcompanyNotBetween(String value1, String value2) {
            addCriterion("checkcompany not between", value1, value2, "checkcompany");
            return (Criteria) this;
        }

        public Criteria andBarristersIsNull() {
            addCriterion("barristers is null");
            return (Criteria) this;
        }

        public Criteria andBarristersIsNotNull() {
            addCriterion("barristers is not null");
            return (Criteria) this;
        }

        public Criteria andBarristersEqualTo(String value) {
            addCriterion("barristers =", value, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersNotEqualTo(String value) {
            addCriterion("barristers <>", value, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersGreaterThan(String value) {
            addCriterion("barristers >", value, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersGreaterThanOrEqualTo(String value) {
            addCriterion("barristers >=", value, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersLessThan(String value) {
            addCriterion("barristers <", value, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersLessThanOrEqualTo(String value) {
            addCriterion("barristers <=", value, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersLike(String value) {
            addCriterion("barristers like", value, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersNotLike(String value) {
            addCriterion("barristers not like", value, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersIn(List<String> values) {
            addCriterion("barristers in", values, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersNotIn(List<String> values) {
            addCriterion("barristers not in", values, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersBetween(String value1, String value2) {
            addCriterion("barristers between", value1, value2, "barristers");
            return (Criteria) this;
        }

        public Criteria andBarristersNotBetween(String value1, String value2) {
            addCriterion("barristers not between", value1, value2, "barristers");
            return (Criteria) this;
        }

        public Criteria andCasedesIsNull() {
            addCriterion("casedes is null");
            return (Criteria) this;
        }

        public Criteria andCasedesIsNotNull() {
            addCriterion("casedes is not null");
            return (Criteria) this;
        }

        public Criteria andCasedesEqualTo(String value) {
            addCriterion("casedes =", value, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesNotEqualTo(String value) {
            addCriterion("casedes <>", value, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesGreaterThan(String value) {
            addCriterion("casedes >", value, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesGreaterThanOrEqualTo(String value) {
            addCriterion("casedes >=", value, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesLessThan(String value) {
            addCriterion("casedes <", value, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesLessThanOrEqualTo(String value) {
            addCriterion("casedes <=", value, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesLike(String value) {
            addCriterion("casedes like", value, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesNotLike(String value) {
            addCriterion("casedes not like", value, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesIn(List<String> values) {
            addCriterion("casedes in", values, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesNotIn(List<String> values) {
            addCriterion("casedes not in", values, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesBetween(String value1, String value2) {
            addCriterion("casedes between", value1, value2, "casedes");
            return (Criteria) this;
        }

        public Criteria andCasedesNotBetween(String value1, String value2) {
            addCriterion("casedes not between", value1, value2, "casedes");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNull() {
            addCriterion("orgcode is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNotNull() {
            addCriterion("orgcode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeEqualTo(String value) {
            addCriterion("orgcode =", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotEqualTo(String value) {
            addCriterion("orgcode <>", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThan(String value) {
            addCriterion("orgcode >", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("orgcode >=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThan(String value) {
            addCriterion("orgcode <", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("orgcode <=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLike(String value) {
            addCriterion("orgcode like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotLike(String value) {
            addCriterion("orgcode not like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIn(List<String> values) {
            addCriterion("orgcode in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotIn(List<String> values) {
            addCriterion("orgcode not in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeBetween(String value1, String value2) {
            addCriterion("orgcode between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotBetween(String value1, String value2) {
            addCriterion("orgcode not between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOranameIsNull() {
            addCriterion("oraname is null");
            return (Criteria) this;
        }

        public Criteria andOranameIsNotNull() {
            addCriterion("oraname is not null");
            return (Criteria) this;
        }

        public Criteria andOranameEqualTo(String value) {
            addCriterion("oraname =", value, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameNotEqualTo(String value) {
            addCriterion("oraname <>", value, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameGreaterThan(String value) {
            addCriterion("oraname >", value, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameGreaterThanOrEqualTo(String value) {
            addCriterion("oraname >=", value, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameLessThan(String value) {
            addCriterion("oraname <", value, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameLessThanOrEqualTo(String value) {
            addCriterion("oraname <=", value, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameLike(String value) {
            addCriterion("oraname like", value, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameNotLike(String value) {
            addCriterion("oraname not like", value, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameIn(List<String> values) {
            addCriterion("oraname in", values, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameNotIn(List<String> values) {
            addCriterion("oraname not in", values, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameBetween(String value1, String value2) {
            addCriterion("oraname between", value1, value2, "oraname");
            return (Criteria) this;
        }

        public Criteria andOranameNotBetween(String value1, String value2) {
            addCriterion("oraname not between", value1, value2, "oraname");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andSetdateIsNull() {
            addCriterion("setdate is null");
            return (Criteria) this;
        }

        public Criteria andSetdateIsNotNull() {
            addCriterion("setdate is not null");
            return (Criteria) this;
        }

        public Criteria andSetdateEqualTo(Date value) {
            addCriterion("setdate =", value, "setdate");
            return (Criteria) this;
        }

        public Criteria andSetdateNotEqualTo(Date value) {
            addCriterion("setdate <>", value, "setdate");
            return (Criteria) this;
        }

        public Criteria andSetdateGreaterThan(Date value) {
            addCriterion("setdate >", value, "setdate");
            return (Criteria) this;
        }

        public Criteria andSetdateGreaterThanOrEqualTo(Date value) {
            addCriterion("setdate >=", value, "setdate");
            return (Criteria) this;
        }

        public Criteria andSetdateLessThan(Date value) {
            addCriterion("setdate <", value, "setdate");
            return (Criteria) this;
        }

        public Criteria andSetdateLessThanOrEqualTo(Date value) {
            addCriterion("setdate <=", value, "setdate");
            return (Criteria) this;
        }

        public Criteria andSetdateIn(List<Date> values) {
            addCriterion("setdate in", values, "setdate");
            return (Criteria) this;
        }

        public Criteria andSetdateNotIn(List<Date> values) {
            addCriterion("setdate not in", values, "setdate");
            return (Criteria) this;
        }

        public Criteria andSetdateBetween(Date value1, Date value2) {
            addCriterion("setdate between", value1, value2, "setdate");
            return (Criteria) this;
        }

        public Criteria andSetdateNotBetween(Date value1, Date value2) {
            addCriterion("setdate not between", value1, value2, "setdate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andCasestatusIsNull() {
            addCriterion("casestatus is null");
            return (Criteria) this;
        }

        public Criteria andCasestatusIsNotNull() {
            addCriterion("casestatus is not null");
            return (Criteria) this;
        }

        public Criteria andCasestatusEqualTo(String value) {
            addCriterion("casestatus =", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusNotEqualTo(String value) {
            addCriterion("casestatus <>", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusGreaterThan(String value) {
            addCriterion("casestatus >", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusGreaterThanOrEqualTo(String value) {
            addCriterion("casestatus >=", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusLessThan(String value) {
            addCriterion("casestatus <", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusLessThanOrEqualTo(String value) {
            addCriterion("casestatus <=", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusLike(String value) {
            addCriterion("casestatus like", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusNotLike(String value) {
            addCriterion("casestatus not like", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusIn(List<String> values) {
            addCriterion("casestatus in", values, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusNotIn(List<String> values) {
            addCriterion("casestatus not in", values, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusBetween(String value1, String value2) {
            addCriterion("casestatus between", value1, value2, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusNotBetween(String value1, String value2) {
            addCriterion("casestatus not between", value1, value2, "casestatus");
            return (Criteria) this;
        }

        public Criteria andFeecountIsNull() {
            addCriterion("feecount is null");
            return (Criteria) this;
        }

        public Criteria andFeecountIsNotNull() {
            addCriterion("feecount is not null");
            return (Criteria) this;
        }

        public Criteria andFeecountEqualTo(Long value) {
            addCriterion("feecount =", value, "feecount");
            return (Criteria) this;
        }

        public Criteria andFeecountNotEqualTo(Long value) {
            addCriterion("feecount <>", value, "feecount");
            return (Criteria) this;
        }

        public Criteria andFeecountGreaterThan(Long value) {
            addCriterion("feecount >", value, "feecount");
            return (Criteria) this;
        }

        public Criteria andFeecountGreaterThanOrEqualTo(Long value) {
            addCriterion("feecount >=", value, "feecount");
            return (Criteria) this;
        }

        public Criteria andFeecountLessThan(Long value) {
            addCriterion("feecount <", value, "feecount");
            return (Criteria) this;
        }

        public Criteria andFeecountLessThanOrEqualTo(Long value) {
            addCriterion("feecount <=", value, "feecount");
            return (Criteria) this;
        }

        public Criteria andFeecountIn(List<Long> values) {
            addCriterion("feecount in", values, "feecount");
            return (Criteria) this;
        }

        public Criteria andFeecountNotIn(List<Long> values) {
            addCriterion("feecount not in", values, "feecount");
            return (Criteria) this;
        }

        public Criteria andFeecountBetween(Long value1, Long value2) {
            addCriterion("feecount between", value1, value2, "feecount");
            return (Criteria) this;
        }

        public Criteria andFeecountNotBetween(Long value1, Long value2) {
            addCriterion("feecount not between", value1, value2, "feecount");
            return (Criteria) this;
        }

        public Criteria andAccflagIsNull() {
            addCriterion("accflag is null");
            return (Criteria) this;
        }

        public Criteria andAccflagIsNotNull() {
            addCriterion("accflag is not null");
            return (Criteria) this;
        }

        public Criteria andAccflagEqualTo(String value) {
            addCriterion("accflag =", value, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagNotEqualTo(String value) {
            addCriterion("accflag <>", value, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagGreaterThan(String value) {
            addCriterion("accflag >", value, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagGreaterThanOrEqualTo(String value) {
            addCriterion("accflag >=", value, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagLessThan(String value) {
            addCriterion("accflag <", value, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagLessThanOrEqualTo(String value) {
            addCriterion("accflag <=", value, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagLike(String value) {
            addCriterion("accflag like", value, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagNotLike(String value) {
            addCriterion("accflag not like", value, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagIn(List<String> values) {
            addCriterion("accflag in", values, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagNotIn(List<String> values) {
            addCriterion("accflag not in", values, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagBetween(String value1, String value2) {
            addCriterion("accflag between", value1, value2, "accflag");
            return (Criteria) this;
        }

        public Criteria andAccflagNotBetween(String value1, String value2) {
            addCriterion("accflag not between", value1, value2, "accflag");
            return (Criteria) this;
        }

        public Criteria andAlertdateIsNull() {
            addCriterion("alertdate is null");
            return (Criteria) this;
        }

        public Criteria andAlertdateIsNotNull() {
            addCriterion("alertdate is not null");
            return (Criteria) this;
        }

        public Criteria andAlertdateEqualTo(Date value) {
            addCriterion("alertdate =", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateNotEqualTo(Date value) {
            addCriterion("alertdate <>", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateGreaterThan(Date value) {
            addCriterion("alertdate >", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateGreaterThanOrEqualTo(Date value) {
            addCriterion("alertdate >=", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateLessThan(Date value) {
            addCriterion("alertdate <", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateLessThanOrEqualTo(Date value) {
            addCriterion("alertdate <=", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateIn(List<Date> values) {
            addCriterion("alertdate in", values, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateNotIn(List<Date> values) {
            addCriterion("alertdate not in", values, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateBetween(Date value1, Date value2) {
            addCriterion("alertdate between", value1, value2, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateNotBetween(Date value1, Date value2) {
            addCriterion("alertdate not between", value1, value2, "alertdate");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIsNull() {
            addCriterion("Create_Operator is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIsNotNull() {
            addCriterion("Create_Operator is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorEqualTo(Long value) {
            addCriterion("Create_Operator =", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotEqualTo(Long value) {
            addCriterion("Create_Operator <>", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorGreaterThan(Long value) {
            addCriterion("Create_Operator >", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorGreaterThanOrEqualTo(Long value) {
            addCriterion("Create_Operator >=", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLessThan(Long value) {
            addCriterion("Create_Operator <", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLessThanOrEqualTo(Long value) {
            addCriterion("Create_Operator <=", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIn(List<Long> values) {
            addCriterion("Create_Operator in", values, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotIn(List<Long> values) {
            addCriterion("Create_Operator not in", values, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorBetween(Long value1, Long value2) {
            addCriterion("Create_Operator between", value1, value2, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotBetween(Long value1, Long value2) {
            addCriterion("Create_Operator not between", value1, value2, "createOperator");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdIsNull() {
            addCriterion("Modify_Operator_Id is null");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdIsNotNull() {
            addCriterion("Modify_Operator_Id is not null");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdEqualTo(Long value) {
            addCriterion("Modify_Operator_Id =", value, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdNotEqualTo(Long value) {
            addCriterion("Modify_Operator_Id <>", value, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdGreaterThan(Long value) {
            addCriterion("Modify_Operator_Id >", value, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Modify_Operator_Id >=", value, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdLessThan(Long value) {
            addCriterion("Modify_Operator_Id <", value, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("Modify_Operator_Id <=", value, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdIn(List<Long> values) {
            addCriterion("Modify_Operator_Id in", values, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdNotIn(List<Long> values) {
            addCriterion("Modify_Operator_Id not in", values, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdBetween(Long value1, Long value2) {
            addCriterion("Modify_Operator_Id between", value1, value2, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("Modify_Operator_Id not between", value1, value2, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("Modify_Time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("Modify_Time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("Modify_Time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("Modify_Time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("Modify_Time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Modify_Time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("Modify_Time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("Modify_Time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("Modify_Time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("Modify_Time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("Modify_Time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("Modify_Time not between", value1, value2, "modifyTime");
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