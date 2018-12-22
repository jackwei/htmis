package com.git.db.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseBillDetailImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaseBillDetailImplExample() {
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

        public Criteria andDetailIdIsNull() {
            addCriterion("Detail_Id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("Detail_Id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Long value) {
            addCriterion("Detail_Id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Long value) {
            addCriterion("Detail_Id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Long value) {
            addCriterion("Detail_Id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Detail_Id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Long value) {
            addCriterion("Detail_Id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("Detail_Id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Long> values) {
            addCriterion("Detail_Id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Long> values) {
            addCriterion("Detail_Id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Long value1, Long value2) {
            addCriterion("Detail_Id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("Detail_Id not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNull() {
            addCriterion("Bill_Id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("Bill_Id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Long value) {
            addCriterion("Bill_Id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Long value) {
            addCriterion("Bill_Id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Long value) {
            addCriterion("Bill_Id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Bill_Id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Long value) {
            addCriterion("Bill_Id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Long value) {
            addCriterion("Bill_Id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Long> values) {
            addCriterion("Bill_Id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Long> values) {
            addCriterion("Bill_Id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Long value1, Long value2) {
            addCriterion("Bill_Id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Long value1, Long value2) {
            addCriterion("Bill_Id not between", value1, value2, "billId");
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

        public Criteria andConsignoridEqualTo(Long value) {
            addCriterion("consignorid =", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridNotEqualTo(Long value) {
            addCriterion("consignorid <>", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridGreaterThan(Long value) {
            addCriterion("consignorid >", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridGreaterThanOrEqualTo(Long value) {
            addCriterion("consignorid >=", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridLessThan(Long value) {
            addCriterion("consignorid <", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridLessThanOrEqualTo(Long value) {
            addCriterion("consignorid <=", value, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridIn(List<Long> values) {
            addCriterion("consignorid in", values, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridNotIn(List<Long> values) {
            addCriterion("consignorid not in", values, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridBetween(Long value1, Long value2) {
            addCriterion("consignorid between", value1, value2, "consignorid");
            return (Criteria) this;
        }

        public Criteria andConsignoridNotBetween(Long value1, Long value2) {
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

        public Criteria andFeenumberIsNull() {
            addCriterion("feenumber is null");
            return (Criteria) this;
        }

        public Criteria andFeenumberIsNotNull() {
            addCriterion("feenumber is not null");
            return (Criteria) this;
        }

        public Criteria andFeenumberEqualTo(String value) {
            addCriterion("feenumber =", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberNotEqualTo(String value) {
            addCriterion("feenumber <>", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberGreaterThan(String value) {
            addCriterion("feenumber >", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberGreaterThanOrEqualTo(String value) {
            addCriterion("feenumber >=", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberLessThan(String value) {
            addCriterion("feenumber <", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberLessThanOrEqualTo(String value) {
            addCriterion("feenumber <=", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberLike(String value) {
            addCriterion("feenumber like", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberNotLike(String value) {
            addCriterion("feenumber not like", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberIn(List<String> values) {
            addCriterion("feenumber in", values, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberNotIn(List<String> values) {
            addCriterion("feenumber not in", values, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberBetween(String value1, String value2) {
            addCriterion("feenumber between", value1, value2, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberNotBetween(String value1, String value2) {
            addCriterion("feenumber not between", value1, value2, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeetypeIsNull() {
            addCriterion("feetype is null");
            return (Criteria) this;
        }

        public Criteria andFeetypeIsNotNull() {
            addCriterion("feetype is not null");
            return (Criteria) this;
        }

        public Criteria andFeetypeEqualTo(String value) {
            addCriterion("feetype =", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotEqualTo(String value) {
            addCriterion("feetype <>", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeGreaterThan(String value) {
            addCriterion("feetype >", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeGreaterThanOrEqualTo(String value) {
            addCriterion("feetype >=", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeLessThan(String value) {
            addCriterion("feetype <", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeLessThanOrEqualTo(String value) {
            addCriterion("feetype <=", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeLike(String value) {
            addCriterion("feetype like", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotLike(String value) {
            addCriterion("feetype not like", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeIn(List<String> values) {
            addCriterion("feetype in", values, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotIn(List<String> values) {
            addCriterion("feetype not in", values, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeBetween(String value1, String value2) {
            addCriterion("feetype between", value1, value2, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotBetween(String value1, String value2) {
            addCriterion("feetype not between", value1, value2, "feetype");
            return (Criteria) this;
        }

        public Criteria andBussnoIsNull() {
            addCriterion("bussno is null");
            return (Criteria) this;
        }

        public Criteria andBussnoIsNotNull() {
            addCriterion("bussno is not null");
            return (Criteria) this;
        }

        public Criteria andBussnoEqualTo(String value) {
            addCriterion("bussno =", value, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoNotEqualTo(String value) {
            addCriterion("bussno <>", value, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoGreaterThan(String value) {
            addCriterion("bussno >", value, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoGreaterThanOrEqualTo(String value) {
            addCriterion("bussno >=", value, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoLessThan(String value) {
            addCriterion("bussno <", value, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoLessThanOrEqualTo(String value) {
            addCriterion("bussno <=", value, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoLike(String value) {
            addCriterion("bussno like", value, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoNotLike(String value) {
            addCriterion("bussno not like", value, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoIn(List<String> values) {
            addCriterion("bussno in", values, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoNotIn(List<String> values) {
            addCriterion("bussno not in", values, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoBetween(String value1, String value2) {
            addCriterion("bussno between", value1, value2, "bussno");
            return (Criteria) this;
        }

        public Criteria andBussnoNotBetween(String value1, String value2) {
            addCriterion("bussno not between", value1, value2, "bussno");
            return (Criteria) this;
        }

        public Criteria andHappendateIsNull() {
            addCriterion("happendate is null");
            return (Criteria) this;
        }

        public Criteria andHappendateIsNotNull() {
            addCriterion("happendate is not null");
            return (Criteria) this;
        }

        public Criteria andHappendateEqualTo(Date value) {
            addCriterion("happendate =", value, "happendate");
            return (Criteria) this;
        }

        public Criteria andHappendateNotEqualTo(Date value) {
            addCriterion("happendate <>", value, "happendate");
            return (Criteria) this;
        }

        public Criteria andHappendateGreaterThan(Date value) {
            addCriterion("happendate >", value, "happendate");
            return (Criteria) this;
        }

        public Criteria andHappendateGreaterThanOrEqualTo(Date value) {
            addCriterion("happendate >=", value, "happendate");
            return (Criteria) this;
        }

        public Criteria andHappendateLessThan(Date value) {
            addCriterion("happendate <", value, "happendate");
            return (Criteria) this;
        }

        public Criteria andHappendateLessThanOrEqualTo(Date value) {
            addCriterion("happendate <=", value, "happendate");
            return (Criteria) this;
        }

        public Criteria andHappendateIn(List<Date> values) {
            addCriterion("happendate in", values, "happendate");
            return (Criteria) this;
        }

        public Criteria andHappendateNotIn(List<Date> values) {
            addCriterion("happendate not in", values, "happendate");
            return (Criteria) this;
        }

        public Criteria andHappendateBetween(Date value1, Date value2) {
            addCriterion("happendate between", value1, value2, "happendate");
            return (Criteria) this;
        }

        public Criteria andHappendateNotBetween(Date value1, Date value2) {
            addCriterion("happendate not between", value1, value2, "happendate");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
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

        public Criteria andAccdateIsNull() {
            addCriterion("accdate is null");
            return (Criteria) this;
        }

        public Criteria andAccdateIsNotNull() {
            addCriterion("accdate is not null");
            return (Criteria) this;
        }

        public Criteria andAccdateEqualTo(Date value) {
            addCriterion("accdate =", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateNotEqualTo(Date value) {
            addCriterion("accdate <>", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateGreaterThan(Date value) {
            addCriterion("accdate >", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateGreaterThanOrEqualTo(Date value) {
            addCriterion("accdate >=", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateLessThan(Date value) {
            addCriterion("accdate <", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateLessThanOrEqualTo(Date value) {
            addCriterion("accdate <=", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateIn(List<Date> values) {
            addCriterion("accdate in", values, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateNotIn(List<Date> values) {
            addCriterion("accdate not in", values, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateBetween(Date value1, Date value2) {
            addCriterion("accdate between", value1, value2, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateNotBetween(Date value1, Date value2) {
            addCriterion("accdate not between", value1, value2, "accdate");
            return (Criteria) this;
        }

        public Criteria andArrdateIsNull() {
            addCriterion("arrdate is null");
            return (Criteria) this;
        }

        public Criteria andArrdateIsNotNull() {
            addCriterion("arrdate is not null");
            return (Criteria) this;
        }

        public Criteria andArrdateEqualTo(Date value) {
            addCriterion("arrdate =", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateNotEqualTo(Date value) {
            addCriterion("arrdate <>", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateGreaterThan(Date value) {
            addCriterion("arrdate >", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateGreaterThanOrEqualTo(Date value) {
            addCriterion("arrdate >=", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateLessThan(Date value) {
            addCriterion("arrdate <", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateLessThanOrEqualTo(Date value) {
            addCriterion("arrdate <=", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateIn(List<Date> values) {
            addCriterion("arrdate in", values, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateNotIn(List<Date> values) {
            addCriterion("arrdate not in", values, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateBetween(Date value1, Date value2) {
            addCriterion("arrdate between", value1, value2, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateNotBetween(Date value1, Date value2) {
            addCriterion("arrdate not between", value1, value2, "arrdate");
            return (Criteria) this;
        }

        public Criteria andChangerateIsNull() {
            addCriterion("changerate is null");
            return (Criteria) this;
        }

        public Criteria andChangerateIsNotNull() {
            addCriterion("changerate is not null");
            return (Criteria) this;
        }

        public Criteria andChangerateEqualTo(BigDecimal value) {
            addCriterion("changerate =", value, "changerate");
            return (Criteria) this;
        }

        public Criteria andChangerateNotEqualTo(BigDecimal value) {
            addCriterion("changerate <>", value, "changerate");
            return (Criteria) this;
        }

        public Criteria andChangerateGreaterThan(BigDecimal value) {
            addCriterion("changerate >", value, "changerate");
            return (Criteria) this;
        }

        public Criteria andChangerateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("changerate >=", value, "changerate");
            return (Criteria) this;
        }

        public Criteria andChangerateLessThan(BigDecimal value) {
            addCriterion("changerate <", value, "changerate");
            return (Criteria) this;
        }

        public Criteria andChangerateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("changerate <=", value, "changerate");
            return (Criteria) this;
        }

        public Criteria andChangerateIn(List<BigDecimal> values) {
            addCriterion("changerate in", values, "changerate");
            return (Criteria) this;
        }

        public Criteria andChangerateNotIn(List<BigDecimal> values) {
            addCriterion("changerate not in", values, "changerate");
            return (Criteria) this;
        }

        public Criteria andChangerateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("changerate between", value1, value2, "changerate");
            return (Criteria) this;
        }

        public Criteria andChangerateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("changerate not between", value1, value2, "changerate");
            return (Criteria) this;
        }

        public Criteria andServicefeeIsNull() {
            addCriterion("servicefee is null");
            return (Criteria) this;
        }

        public Criteria andServicefeeIsNotNull() {
            addCriterion("servicefee is not null");
            return (Criteria) this;
        }

        public Criteria andServicefeeEqualTo(Float value) {
            addCriterion("servicefee =", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotEqualTo(Float value) {
            addCriterion("servicefee <>", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeGreaterThan(Float value) {
            addCriterion("servicefee >", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeGreaterThanOrEqualTo(Float value) {
            addCriterion("servicefee >=", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeLessThan(Float value) {
            addCriterion("servicefee <", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeLessThanOrEqualTo(Float value) {
            addCriterion("servicefee <=", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeIn(List<Float> values) {
            addCriterion("servicefee in", values, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotIn(List<Float> values) {
            addCriterion("servicefee not in", values, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeBetween(Float value1, Float value2) {
            addCriterion("servicefee between", value1, value2, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotBetween(Float value1, Float value2) {
            addCriterion("servicefee not between", value1, value2, "servicefee");
            return (Criteria) this;
        }

        public Criteria andExpendsesIsNull() {
            addCriterion("expendses is null");
            return (Criteria) this;
        }

        public Criteria andExpendsesIsNotNull() {
            addCriterion("expendses is not null");
            return (Criteria) this;
        }

        public Criteria andExpendsesEqualTo(Float value) {
            addCriterion("expendses =", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesNotEqualTo(Float value) {
            addCriterion("expendses <>", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesGreaterThan(Float value) {
            addCriterion("expendses >", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesGreaterThanOrEqualTo(Float value) {
            addCriterion("expendses >=", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesLessThan(Float value) {
            addCriterion("expendses <", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesLessThanOrEqualTo(Float value) {
            addCriterion("expendses <=", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesIn(List<Float> values) {
            addCriterion("expendses in", values, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesNotIn(List<Float> values) {
            addCriterion("expendses not in", values, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesBetween(Float value1, Float value2) {
            addCriterion("expendses between", value1, value2, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesNotBetween(Float value1, Float value2) {
            addCriterion("expendses not between", value1, value2, "expendses");
            return (Criteria) this;
        }

        public Criteria andReplacefeeIsNull() {
            addCriterion("replacefee is null");
            return (Criteria) this;
        }

        public Criteria andReplacefeeIsNotNull() {
            addCriterion("replacefee is not null");
            return (Criteria) this;
        }

        public Criteria andReplacefeeEqualTo(Float value) {
            addCriterion("replacefee =", value, "replacefee");
            return (Criteria) this;
        }

        public Criteria andReplacefeeNotEqualTo(Float value) {
            addCriterion("replacefee <>", value, "replacefee");
            return (Criteria) this;
        }

        public Criteria andReplacefeeGreaterThan(Float value) {
            addCriterion("replacefee >", value, "replacefee");
            return (Criteria) this;
        }

        public Criteria andReplacefeeGreaterThanOrEqualTo(Float value) {
            addCriterion("replacefee >=", value, "replacefee");
            return (Criteria) this;
        }

        public Criteria andReplacefeeLessThan(Float value) {
            addCriterion("replacefee <", value, "replacefee");
            return (Criteria) this;
        }

        public Criteria andReplacefeeLessThanOrEqualTo(Float value) {
            addCriterion("replacefee <=", value, "replacefee");
            return (Criteria) this;
        }

        public Criteria andReplacefeeIn(List<Float> values) {
            addCriterion("replacefee in", values, "replacefee");
            return (Criteria) this;
        }

        public Criteria andReplacefeeNotIn(List<Float> values) {
            addCriterion("replacefee not in", values, "replacefee");
            return (Criteria) this;
        }

        public Criteria andReplacefeeBetween(Float value1, Float value2) {
            addCriterion("replacefee between", value1, value2, "replacefee");
            return (Criteria) this;
        }

        public Criteria andReplacefeeNotBetween(Float value1, Float value2) {
            addCriterion("replacefee not between", value1, value2, "replacefee");
            return (Criteria) this;
        }

        public Criteria andAccamountIsNull() {
            addCriterion("accamount is null");
            return (Criteria) this;
        }

        public Criteria andAccamountIsNotNull() {
            addCriterion("accamount is not null");
            return (Criteria) this;
        }

        public Criteria andAccamountEqualTo(Float value) {
            addCriterion("accamount =", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountNotEqualTo(Float value) {
            addCriterion("accamount <>", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountGreaterThan(Float value) {
            addCriterion("accamount >", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountGreaterThanOrEqualTo(Float value) {
            addCriterion("accamount >=", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountLessThan(Float value) {
            addCriterion("accamount <", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountLessThanOrEqualTo(Float value) {
            addCriterion("accamount <=", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountIn(List<Float> values) {
            addCriterion("accamount in", values, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountNotIn(List<Float> values) {
            addCriterion("accamount not in", values, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountBetween(Float value1, Float value2) {
            addCriterion("accamount between", value1, value2, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountNotBetween(Float value1, Float value2) {
            addCriterion("accamount not between", value1, value2, "accamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountIsNull() {
            addCriterion("feeamount is null");
            return (Criteria) this;
        }

        public Criteria andFeeamountIsNotNull() {
            addCriterion("feeamount is not null");
            return (Criteria) this;
        }

        public Criteria andFeeamountEqualTo(Float value) {
            addCriterion("feeamount =", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountNotEqualTo(Float value) {
            addCriterion("feeamount <>", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountGreaterThan(Float value) {
            addCriterion("feeamount >", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountGreaterThanOrEqualTo(Float value) {
            addCriterion("feeamount >=", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountLessThan(Float value) {
            addCriterion("feeamount <", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountLessThanOrEqualTo(Float value) {
            addCriterion("feeamount <=", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountIn(List<Float> values) {
            addCriterion("feeamount in", values, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountNotIn(List<Float> values) {
            addCriterion("feeamount not in", values, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountBetween(Float value1, Float value2) {
            addCriterion("feeamount between", value1, value2, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountNotBetween(Float value1, Float value2) {
            addCriterion("feeamount not between", value1, value2, "feeamount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPayidIsNull() {
            addCriterion("payid is null");
            return (Criteria) this;
        }

        public Criteria andPayidIsNotNull() {
            addCriterion("payid is not null");
            return (Criteria) this;
        }

        public Criteria andPayidEqualTo(String value) {
            addCriterion("payid =", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotEqualTo(String value) {
            addCriterion("payid <>", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThan(String value) {
            addCriterion("payid >", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThanOrEqualTo(String value) {
            addCriterion("payid >=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThan(String value) {
            addCriterion("payid <", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThanOrEqualTo(String value) {
            addCriterion("payid <=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLike(String value) {
            addCriterion("payid like", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotLike(String value) {
            addCriterion("payid not like", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidIn(List<String> values) {
            addCriterion("payid in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotIn(List<String> values) {
            addCriterion("payid not in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidBetween(String value1, String value2) {
            addCriterion("payid between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotBetween(String value1, String value2) {
            addCriterion("payid not between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPaydateIsNull() {
            addCriterion("paydate is null");
            return (Criteria) this;
        }

        public Criteria andPaydateIsNotNull() {
            addCriterion("paydate is not null");
            return (Criteria) this;
        }

        public Criteria andPaydateEqualTo(Date value) {
            addCriterion("paydate =", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotEqualTo(Date value) {
            addCriterion("paydate <>", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateGreaterThan(Date value) {
            addCriterion("paydate >", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateGreaterThanOrEqualTo(Date value) {
            addCriterion("paydate >=", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLessThan(Date value) {
            addCriterion("paydate <", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLessThanOrEqualTo(Date value) {
            addCriterion("paydate <=", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateIn(List<Date> values) {
            addCriterion("paydate in", values, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotIn(List<Date> values) {
            addCriterion("paydate not in", values, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateBetween(Date value1, Date value2) {
            addCriterion("paydate between", value1, value2, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotBetween(Date value1, Date value2) {
            addCriterion("paydate not between", value1, value2, "paydate");
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

        public Criteria andReportdateIsNull() {
            addCriterion("reportdate is null");
            return (Criteria) this;
        }

        public Criteria andReportdateIsNotNull() {
            addCriterion("reportdate is not null");
            return (Criteria) this;
        }

        public Criteria andReportdateEqualTo(Date value) {
            addCriterion("reportdate =", value, "reportdate");
            return (Criteria) this;
        }

        public Criteria andReportdateNotEqualTo(Date value) {
            addCriterion("reportdate <>", value, "reportdate");
            return (Criteria) this;
        }

        public Criteria andReportdateGreaterThan(Date value) {
            addCriterion("reportdate >", value, "reportdate");
            return (Criteria) this;
        }

        public Criteria andReportdateGreaterThanOrEqualTo(Date value) {
            addCriterion("reportdate >=", value, "reportdate");
            return (Criteria) this;
        }

        public Criteria andReportdateLessThan(Date value) {
            addCriterion("reportdate <", value, "reportdate");
            return (Criteria) this;
        }

        public Criteria andReportdateLessThanOrEqualTo(Date value) {
            addCriterion("reportdate <=", value, "reportdate");
            return (Criteria) this;
        }

        public Criteria andReportdateIn(List<Date> values) {
            addCriterion("reportdate in", values, "reportdate");
            return (Criteria) this;
        }

        public Criteria andReportdateNotIn(List<Date> values) {
            addCriterion("reportdate not in", values, "reportdate");
            return (Criteria) this;
        }

        public Criteria andReportdateBetween(Date value1, Date value2) {
            addCriterion("reportdate between", value1, value2, "reportdate");
            return (Criteria) this;
        }

        public Criteria andReportdateNotBetween(Date value1, Date value2) {
            addCriterion("reportdate not between", value1, value2, "reportdate");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNull() {
            addCriterion("applydate is null");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNotNull() {
            addCriterion("applydate is not null");
            return (Criteria) this;
        }

        public Criteria andApplydateEqualTo(Date value) {
            addCriterion("applydate =", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotEqualTo(Date value) {
            addCriterion("applydate <>", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThan(Date value) {
            addCriterion("applydate >", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThanOrEqualTo(Date value) {
            addCriterion("applydate >=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThan(Date value) {
            addCriterion("applydate <", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThanOrEqualTo(Date value) {
            addCriterion("applydate <=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateIn(List<Date> values) {
            addCriterion("applydate in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotIn(List<Date> values) {
            addCriterion("applydate not in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateBetween(Date value1, Date value2) {
            addCriterion("applydate between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotBetween(Date value1, Date value2) {
            addCriterion("applydate not between", value1, value2, "applydate");
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

        public Criteria andExtend1IsNull() {
            addCriterion("Extend1 is null");
            return (Criteria) this;
        }

        public Criteria andExtend1IsNotNull() {
            addCriterion("Extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend1EqualTo(String value) {
            addCriterion("Extend1 =", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotEqualTo(String value) {
            addCriterion("Extend1 <>", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThan(String value) {
            addCriterion("Extend1 >", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("Extend1 >=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThan(String value) {
            addCriterion("Extend1 <", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThanOrEqualTo(String value) {
            addCriterion("Extend1 <=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Like(String value) {
            addCriterion("Extend1 like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotLike(String value) {
            addCriterion("Extend1 not like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1In(List<String> values) {
            addCriterion("Extend1 in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotIn(List<String> values) {
            addCriterion("Extend1 not in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Between(String value1, String value2) {
            addCriterion("Extend1 between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotBetween(String value1, String value2) {
            addCriterion("Extend1 not between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNull() {
            addCriterion("Extend2 is null");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNotNull() {
            addCriterion("Extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend2EqualTo(String value) {
            addCriterion("Extend2 =", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotEqualTo(String value) {
            addCriterion("Extend2 <>", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThan(String value) {
            addCriterion("Extend2 >", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("Extend2 >=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThan(String value) {
            addCriterion("Extend2 <", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThanOrEqualTo(String value) {
            addCriterion("Extend2 <=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Like(String value) {
            addCriterion("Extend2 like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotLike(String value) {
            addCriterion("Extend2 not like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2In(List<String> values) {
            addCriterion("Extend2 in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotIn(List<String> values) {
            addCriterion("Extend2 not in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Between(String value1, String value2) {
            addCriterion("Extend2 between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotBetween(String value1, String value2) {
            addCriterion("Extend2 not between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNull() {
            addCriterion("Extend3 is null");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNotNull() {
            addCriterion("Extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend3EqualTo(String value) {
            addCriterion("Extend3 =", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotEqualTo(String value) {
            addCriterion("Extend3 <>", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThan(String value) {
            addCriterion("Extend3 >", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("Extend3 >=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThan(String value) {
            addCriterion("Extend3 <", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThanOrEqualTo(String value) {
            addCriterion("Extend3 <=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Like(String value) {
            addCriterion("Extend3 like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotLike(String value) {
            addCriterion("Extend3 not like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3In(List<String> values) {
            addCriterion("Extend3 in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotIn(List<String> values) {
            addCriterion("Extend3 not in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Between(String value1, String value2) {
            addCriterion("Extend3 between", value1, value2, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotBetween(String value1, String value2) {
            addCriterion("Extend3 not between", value1, value2, "extend3");
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