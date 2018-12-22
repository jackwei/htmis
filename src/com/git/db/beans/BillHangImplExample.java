package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillHangImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillHangImplExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRemittancedateIsNull() {
            addCriterion("RemittanceDate is null");
            return (Criteria) this;
        }

        public Criteria andRemittancedateIsNotNull() {
            addCriterion("RemittanceDate is not null");
            return (Criteria) this;
        }

        public Criteria andRemittancedateEqualTo(Date value) {
            addCriterion("RemittanceDate =", value, "remittancedate");
            return (Criteria) this;
        }

        public Criteria andRemittancedateNotEqualTo(Date value) {
            addCriterion("RemittanceDate <>", value, "remittancedate");
            return (Criteria) this;
        }

        public Criteria andRemittancedateGreaterThan(Date value) {
            addCriterion("RemittanceDate >", value, "remittancedate");
            return (Criteria) this;
        }

        public Criteria andRemittancedateGreaterThanOrEqualTo(Date value) {
            addCriterion("RemittanceDate >=", value, "remittancedate");
            return (Criteria) this;
        }

        public Criteria andRemittancedateLessThan(Date value) {
            addCriterion("RemittanceDate <", value, "remittancedate");
            return (Criteria) this;
        }

        public Criteria andRemittancedateLessThanOrEqualTo(Date value) {
            addCriterion("RemittanceDate <=", value, "remittancedate");
            return (Criteria) this;
        }

        public Criteria andRemittancedateIn(List<Date> values) {
            addCriterion("RemittanceDate in", values, "remittancedate");
            return (Criteria) this;
        }

        public Criteria andRemittancedateNotIn(List<Date> values) {
            addCriterion("RemittanceDate not in", values, "remittancedate");
            return (Criteria) this;
        }

        public Criteria andRemittancedateBetween(Date value1, Date value2) {
            addCriterion("RemittanceDate between", value1, value2, "remittancedate");
            return (Criteria) this;
        }

        public Criteria andRemittancedateNotBetween(Date value1, Date value2) {
            addCriterion("RemittanceDate not between", value1, value2, "remittancedate");
            return (Criteria) this;
        }

        public Criteria andRemitterIsNull() {
            addCriterion("Remitter is null");
            return (Criteria) this;
        }

        public Criteria andRemitterIsNotNull() {
            addCriterion("Remitter is not null");
            return (Criteria) this;
        }

        public Criteria andRemitterEqualTo(String value) {
            addCriterion("Remitter =", value, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterNotEqualTo(String value) {
            addCriterion("Remitter <>", value, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterGreaterThan(String value) {
            addCriterion("Remitter >", value, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterGreaterThanOrEqualTo(String value) {
            addCriterion("Remitter >=", value, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterLessThan(String value) {
            addCriterion("Remitter <", value, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterLessThanOrEqualTo(String value) {
            addCriterion("Remitter <=", value, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterLike(String value) {
            addCriterion("Remitter like", value, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterNotLike(String value) {
            addCriterion("Remitter not like", value, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterIn(List<String> values) {
            addCriterion("Remitter in", values, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterNotIn(List<String> values) {
            addCriterion("Remitter not in", values, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterBetween(String value1, String value2) {
            addCriterion("Remitter between", value1, value2, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemitterNotBetween(String value1, String value2) {
            addCriterion("Remitter not between", value1, value2, "remitter");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersIsNull() {
            addCriterion("RemittanceCustomers is null");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersIsNotNull() {
            addCriterion("RemittanceCustomers is not null");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersEqualTo(String value) {
            addCriterion("RemittanceCustomers =", value, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersNotEqualTo(String value) {
            addCriterion("RemittanceCustomers <>", value, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersGreaterThan(String value) {
            addCriterion("RemittanceCustomers >", value, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersGreaterThanOrEqualTo(String value) {
            addCriterion("RemittanceCustomers >=", value, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersLessThan(String value) {
            addCriterion("RemittanceCustomers <", value, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersLessThanOrEqualTo(String value) {
            addCriterion("RemittanceCustomers <=", value, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersLike(String value) {
            addCriterion("RemittanceCustomers like", value, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersNotLike(String value) {
            addCriterion("RemittanceCustomers not like", value, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersIn(List<String> values) {
            addCriterion("RemittanceCustomers in", values, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersNotIn(List<String> values) {
            addCriterion("RemittanceCustomers not in", values, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersBetween(String value1, String value2) {
            addCriterion("RemittanceCustomers between", value1, value2, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemittancecustomersNotBetween(String value1, String value2) {
            addCriterion("RemittanceCustomers not between", value1, value2, "remittancecustomers");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyIsNull() {
            addCriterion("remitMoney is null");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyIsNotNull() {
            addCriterion("remitMoney is not null");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyEqualTo(Float value) {
            addCriterion("remitMoney =", value, "remitmoney");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyNotEqualTo(Float value) {
            addCriterion("remitMoney <>", value, "remitmoney");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyGreaterThan(Float value) {
            addCriterion("remitMoney >", value, "remitmoney");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("remitMoney >=", value, "remitmoney");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyLessThan(Float value) {
            addCriterion("remitMoney <", value, "remitmoney");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyLessThanOrEqualTo(Float value) {
            addCriterion("remitMoney <=", value, "remitmoney");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyIn(List<Float> values) {
            addCriterion("remitMoney in", values, "remitmoney");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyNotIn(List<Float> values) {
            addCriterion("remitMoney not in", values, "remitmoney");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyBetween(Float value1, Float value2) {
            addCriterion("remitMoney between", value1, value2, "remitmoney");
            return (Criteria) this;
        }

        public Criteria andRemitmoneyNotBetween(Float value1, Float value2) {
            addCriterion("remitMoney not between", value1, value2, "remitmoney");
            return (Criteria) this;
        }

        public Criteria andBankinfoIsNull() {
            addCriterion("bankInfo is null");
            return (Criteria) this;
        }

        public Criteria andBankinfoIsNotNull() {
            addCriterion("bankInfo is not null");
            return (Criteria) this;
        }

        public Criteria andBankinfoEqualTo(String value) {
            addCriterion("bankInfo =", value, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoNotEqualTo(String value) {
            addCriterion("bankInfo <>", value, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoGreaterThan(String value) {
            addCriterion("bankInfo >", value, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoGreaterThanOrEqualTo(String value) {
            addCriterion("bankInfo >=", value, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoLessThan(String value) {
            addCriterion("bankInfo <", value, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoLessThanOrEqualTo(String value) {
            addCriterion("bankInfo <=", value, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoLike(String value) {
            addCriterion("bankInfo like", value, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoNotLike(String value) {
            addCriterion("bankInfo not like", value, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoIn(List<String> values) {
            addCriterion("bankInfo in", values, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoNotIn(List<String> values) {
            addCriterion("bankInfo not in", values, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoBetween(String value1, String value2) {
            addCriterion("bankInfo between", value1, value2, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankinfoNotBetween(String value1, String value2) {
            addCriterion("bankInfo not between", value1, value2, "bankinfo");
            return (Criteria) this;
        }

        public Criteria andBankcodeIsNull() {
            addCriterion("bankCode is null");
            return (Criteria) this;
        }

        public Criteria andBankcodeIsNotNull() {
            addCriterion("bankCode is not null");
            return (Criteria) this;
        }

        public Criteria andBankcodeEqualTo(String value) {
            addCriterion("bankCode =", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotEqualTo(String value) {
            addCriterion("bankCode <>", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeGreaterThan(String value) {
            addCriterion("bankCode >", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeGreaterThanOrEqualTo(String value) {
            addCriterion("bankCode >=", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeLessThan(String value) {
            addCriterion("bankCode <", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeLessThanOrEqualTo(String value) {
            addCriterion("bankCode <=", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeLike(String value) {
            addCriterion("bankCode like", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotLike(String value) {
            addCriterion("bankCode not like", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeIn(List<String> values) {
            addCriterion("bankCode in", values, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotIn(List<String> values) {
            addCriterion("bankCode not in", values, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeBetween(String value1, String value2) {
            addCriterion("bankCode between", value1, value2, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotBetween(String value1, String value2) {
            addCriterion("bankCode not between", value1, value2, "bankcode");
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

        public Criteria andEntrypeopleIsNull() {
            addCriterion("entrypeople is null");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleIsNotNull() {
            addCriterion("entrypeople is not null");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleEqualTo(String value) {
            addCriterion("entrypeople =", value, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleNotEqualTo(String value) {
            addCriterion("entrypeople <>", value, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleGreaterThan(String value) {
            addCriterion("entrypeople >", value, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleGreaterThanOrEqualTo(String value) {
            addCriterion("entrypeople >=", value, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleLessThan(String value) {
            addCriterion("entrypeople <", value, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleLessThanOrEqualTo(String value) {
            addCriterion("entrypeople <=", value, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleLike(String value) {
            addCriterion("entrypeople like", value, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleNotLike(String value) {
            addCriterion("entrypeople not like", value, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleIn(List<String> values) {
            addCriterion("entrypeople in", values, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleNotIn(List<String> values) {
            addCriterion("entrypeople not in", values, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleBetween(String value1, String value2) {
            addCriterion("entrypeople between", value1, value2, "entrypeople");
            return (Criteria) this;
        }

        public Criteria andEntrypeopleNotBetween(String value1, String value2) {
            addCriterion("entrypeople not between", value1, value2, "entrypeople");
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

        public Criteria andOperatorIdIsNull() {
            addCriterion("Operator_Id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("Operator_Id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Long value) {
            addCriterion("Operator_Id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Long value) {
            addCriterion("Operator_Id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Long value) {
            addCriterion("Operator_Id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Operator_Id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Long value) {
            addCriterion("Operator_Id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("Operator_Id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Long> values) {
            addCriterion("Operator_Id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Long> values) {
            addCriterion("Operator_Id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Long value1, Long value2) {
            addCriterion("Operator_Id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("Operator_Id not between", value1, value2, "operatorId");
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