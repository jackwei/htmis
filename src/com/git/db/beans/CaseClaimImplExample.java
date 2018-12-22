package com.git.db.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseClaimImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaseClaimImplExample() {
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

        public Criteria andClaimIdIsNull() {
            addCriterion("Claim_Id is null");
            return (Criteria) this;
        }

        public Criteria andClaimIdIsNotNull() {
            addCriterion("Claim_Id is not null");
            return (Criteria) this;
        }

        public Criteria andClaimIdEqualTo(Long value) {
            addCriterion("Claim_Id =", value, "claimId");
            return (Criteria) this;
        }

        public Criteria andClaimIdNotEqualTo(Long value) {
            addCriterion("Claim_Id <>", value, "claimId");
            return (Criteria) this;
        }

        public Criteria andClaimIdGreaterThan(Long value) {
            addCriterion("Claim_Id >", value, "claimId");
            return (Criteria) this;
        }

        public Criteria andClaimIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Claim_Id >=", value, "claimId");
            return (Criteria) this;
        }

        public Criteria andClaimIdLessThan(Long value) {
            addCriterion("Claim_Id <", value, "claimId");
            return (Criteria) this;
        }

        public Criteria andClaimIdLessThanOrEqualTo(Long value) {
            addCriterion("Claim_Id <=", value, "claimId");
            return (Criteria) this;
        }

        public Criteria andClaimIdIn(List<Long> values) {
            addCriterion("Claim_Id in", values, "claimId");
            return (Criteria) this;
        }

        public Criteria andClaimIdNotIn(List<Long> values) {
            addCriterion("Claim_Id not in", values, "claimId");
            return (Criteria) this;
        }

        public Criteria andClaimIdBetween(Long value1, Long value2) {
            addCriterion("Claim_Id between", value1, value2, "claimId");
            return (Criteria) this;
        }

        public Criteria andClaimIdNotBetween(Long value1, Long value2) {
            addCriterion("Claim_Id not between", value1, value2, "claimId");
            return (Criteria) this;
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

        public Criteria andClientnameIsNull() {
            addCriterion("clientname is null");
            return (Criteria) this;
        }

        public Criteria andClientnameIsNotNull() {
            addCriterion("clientname is not null");
            return (Criteria) this;
        }

        public Criteria andClientnameEqualTo(String value) {
            addCriterion("clientname =", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotEqualTo(String value) {
            addCriterion("clientname <>", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameGreaterThan(String value) {
            addCriterion("clientname >", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameGreaterThanOrEqualTo(String value) {
            addCriterion("clientname >=", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLessThan(String value) {
            addCriterion("clientname <", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLessThanOrEqualTo(String value) {
            addCriterion("clientname <=", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLike(String value) {
            addCriterion("clientname like", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotLike(String value) {
            addCriterion("clientname not like", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameIn(List<String> values) {
            addCriterion("clientname in", values, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotIn(List<String> values) {
            addCriterion("clientname not in", values, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameBetween(String value1, String value2) {
            addCriterion("clientname between", value1, value2, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotBetween(String value1, String value2) {
            addCriterion("clientname not between", value1, value2, "clientname");
            return (Criteria) this;
        }

        public Criteria andRealamountIsNull() {
            addCriterion("realamount is null");
            return (Criteria) this;
        }

        public Criteria andRealamountIsNotNull() {
            addCriterion("realamount is not null");
            return (Criteria) this;
        }

        public Criteria andRealamountEqualTo(Float value) {
            addCriterion("realamount =", value, "realamount");
            return (Criteria) this;
        }

        public Criteria andRealamountNotEqualTo(Float value) {
            addCriterion("realamount <>", value, "realamount");
            return (Criteria) this;
        }

        public Criteria andRealamountGreaterThan(Float value) {
            addCriterion("realamount >", value, "realamount");
            return (Criteria) this;
        }

        public Criteria andRealamountGreaterThanOrEqualTo(Float value) {
            addCriterion("realamount >=", value, "realamount");
            return (Criteria) this;
        }

        public Criteria andRealamountLessThan(Float value) {
            addCriterion("realamount <", value, "realamount");
            return (Criteria) this;
        }

        public Criteria andRealamountLessThanOrEqualTo(Float value) {
            addCriterion("realamount <=", value, "realamount");
            return (Criteria) this;
        }

        public Criteria andRealamountIn(List<Float> values) {
            addCriterion("realamount in", values, "realamount");
            return (Criteria) this;
        }

        public Criteria andRealamountNotIn(List<Float> values) {
            addCriterion("realamount not in", values, "realamount");
            return (Criteria) this;
        }

        public Criteria andRealamountBetween(Float value1, Float value2) {
            addCriterion("realamount between", value1, value2, "realamount");
            return (Criteria) this;
        }

        public Criteria andRealamountNotBetween(Float value1, Float value2) {
            addCriterion("realamount not between", value1, value2, "realamount");
            return (Criteria) this;
        }

        public Criteria andApplyamountIsNull() {
            addCriterion("applyamount is null");
            return (Criteria) this;
        }

        public Criteria andApplyamountIsNotNull() {
            addCriterion("applyamount is not null");
            return (Criteria) this;
        }

        public Criteria andApplyamountEqualTo(Float value) {
            addCriterion("applyamount =", value, "applyamount");
            return (Criteria) this;
        }

        public Criteria andApplyamountNotEqualTo(Float value) {
            addCriterion("applyamount <>", value, "applyamount");
            return (Criteria) this;
        }

        public Criteria andApplyamountGreaterThan(Float value) {
            addCriterion("applyamount >", value, "applyamount");
            return (Criteria) this;
        }

        public Criteria andApplyamountGreaterThanOrEqualTo(Float value) {
            addCriterion("applyamount >=", value, "applyamount");
            return (Criteria) this;
        }

        public Criteria andApplyamountLessThan(Float value) {
            addCriterion("applyamount <", value, "applyamount");
            return (Criteria) this;
        }

        public Criteria andApplyamountLessThanOrEqualTo(Float value) {
            addCriterion("applyamount <=", value, "applyamount");
            return (Criteria) this;
        }

        public Criteria andApplyamountIn(List<Float> values) {
            addCriterion("applyamount in", values, "applyamount");
            return (Criteria) this;
        }

        public Criteria andApplyamountNotIn(List<Float> values) {
            addCriterion("applyamount not in", values, "applyamount");
            return (Criteria) this;
        }

        public Criteria andApplyamountBetween(Float value1, Float value2) {
            addCriterion("applyamount between", value1, value2, "applyamount");
            return (Criteria) this;
        }

        public Criteria andApplyamountNotBetween(Float value1, Float value2) {
            addCriterion("applyamount not between", value1, value2, "applyamount");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyIsNull() {
            addCriterion("applycurrency is null");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyIsNotNull() {
            addCriterion("applycurrency is not null");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyEqualTo(String value) {
            addCriterion("applycurrency =", value, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyNotEqualTo(String value) {
            addCriterion("applycurrency <>", value, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyGreaterThan(String value) {
            addCriterion("applycurrency >", value, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("applycurrency >=", value, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyLessThan(String value) {
            addCriterion("applycurrency <", value, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyLessThanOrEqualTo(String value) {
            addCriterion("applycurrency <=", value, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyLike(String value) {
            addCriterion("applycurrency like", value, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyNotLike(String value) {
            addCriterion("applycurrency not like", value, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyIn(List<String> values) {
            addCriterion("applycurrency in", values, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyNotIn(List<String> values) {
            addCriterion("applycurrency not in", values, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyBetween(String value1, String value2) {
            addCriterion("applycurrency between", value1, value2, "applycurrency");
            return (Criteria) this;
        }

        public Criteria andApplycurrencyNotBetween(String value1, String value2) {
            addCriterion("applycurrency not between", value1, value2, "applycurrency");
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

        public Criteria andBanknumIsNull() {
            addCriterion("banknum is null");
            return (Criteria) this;
        }

        public Criteria andBanknumIsNotNull() {
            addCriterion("banknum is not null");
            return (Criteria) this;
        }

        public Criteria andBanknumEqualTo(String value) {
            addCriterion("banknum =", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumNotEqualTo(String value) {
            addCriterion("banknum <>", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumGreaterThan(String value) {
            addCriterion("banknum >", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumGreaterThanOrEqualTo(String value) {
            addCriterion("banknum >=", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumLessThan(String value) {
            addCriterion("banknum <", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumLessThanOrEqualTo(String value) {
            addCriterion("banknum <=", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumLike(String value) {
            addCriterion("banknum like", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumNotLike(String value) {
            addCriterion("banknum not like", value, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumIn(List<String> values) {
            addCriterion("banknum in", values, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumNotIn(List<String> values) {
            addCriterion("banknum not in", values, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumBetween(String value1, String value2) {
            addCriterion("banknum between", value1, value2, "banknum");
            return (Criteria) this;
        }

        public Criteria andBanknumNotBetween(String value1, String value2) {
            addCriterion("banknum not between", value1, value2, "banknum");
            return (Criteria) this;
        }

        public Criteria andTreatdateIsNull() {
            addCriterion("treatdate is null");
            return (Criteria) this;
        }

        public Criteria andTreatdateIsNotNull() {
            addCriterion("treatdate is not null");
            return (Criteria) this;
        }

        public Criteria andTreatdateEqualTo(Date value) {
            addCriterion("treatdate =", value, "treatdate");
            return (Criteria) this;
        }

        public Criteria andTreatdateNotEqualTo(Date value) {
            addCriterion("treatdate <>", value, "treatdate");
            return (Criteria) this;
        }

        public Criteria andTreatdateGreaterThan(Date value) {
            addCriterion("treatdate >", value, "treatdate");
            return (Criteria) this;
        }

        public Criteria andTreatdateGreaterThanOrEqualTo(Date value) {
            addCriterion("treatdate >=", value, "treatdate");
            return (Criteria) this;
        }

        public Criteria andTreatdateLessThan(Date value) {
            addCriterion("treatdate <", value, "treatdate");
            return (Criteria) this;
        }

        public Criteria andTreatdateLessThanOrEqualTo(Date value) {
            addCriterion("treatdate <=", value, "treatdate");
            return (Criteria) this;
        }

        public Criteria andTreatdateIn(List<Date> values) {
            addCriterion("treatdate in", values, "treatdate");
            return (Criteria) this;
        }

        public Criteria andTreatdateNotIn(List<Date> values) {
            addCriterion("treatdate not in", values, "treatdate");
            return (Criteria) this;
        }

        public Criteria andTreatdateBetween(Date value1, Date value2) {
            addCriterion("treatdate between", value1, value2, "treatdate");
            return (Criteria) this;
        }

        public Criteria andTreatdateNotBetween(Date value1, Date value2) {
            addCriterion("treatdate not between", value1, value2, "treatdate");
            return (Criteria) this;
        }

        public Criteria andUsdrateIsNull() {
            addCriterion("usdrate is null");
            return (Criteria) this;
        }

        public Criteria andUsdrateIsNotNull() {
            addCriterion("usdrate is not null");
            return (Criteria) this;
        }

        public Criteria andUsdrateEqualTo(BigDecimal value) {
            addCriterion("usdrate =", value, "usdrate");
            return (Criteria) this;
        }

        public Criteria andUsdrateNotEqualTo(BigDecimal value) {
            addCriterion("usdrate <>", value, "usdrate");
            return (Criteria) this;
        }

        public Criteria andUsdrateGreaterThan(BigDecimal value) {
            addCriterion("usdrate >", value, "usdrate");
            return (Criteria) this;
        }

        public Criteria andUsdrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("usdrate >=", value, "usdrate");
            return (Criteria) this;
        }

        public Criteria andUsdrateLessThan(BigDecimal value) {
            addCriterion("usdrate <", value, "usdrate");
            return (Criteria) this;
        }

        public Criteria andUsdrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("usdrate <=", value, "usdrate");
            return (Criteria) this;
        }

        public Criteria andUsdrateIn(List<BigDecimal> values) {
            addCriterion("usdrate in", values, "usdrate");
            return (Criteria) this;
        }

        public Criteria andUsdrateNotIn(List<BigDecimal> values) {
            addCriterion("usdrate not in", values, "usdrate");
            return (Criteria) this;
        }

        public Criteria andUsdrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usdrate between", value1, value2, "usdrate");
            return (Criteria) this;
        }

        public Criteria andUsdrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usdrate not between", value1, value2, "usdrate");
            return (Criteria) this;
        }

        public Criteria andUsdamountIsNull() {
            addCriterion("usdamount is null");
            return (Criteria) this;
        }

        public Criteria andUsdamountIsNotNull() {
            addCriterion("usdamount is not null");
            return (Criteria) this;
        }

        public Criteria andUsdamountEqualTo(Float value) {
            addCriterion("usdamount =", value, "usdamount");
            return (Criteria) this;
        }

        public Criteria andUsdamountNotEqualTo(Float value) {
            addCriterion("usdamount <>", value, "usdamount");
            return (Criteria) this;
        }

        public Criteria andUsdamountGreaterThan(Float value) {
            addCriterion("usdamount >", value, "usdamount");
            return (Criteria) this;
        }

        public Criteria andUsdamountGreaterThanOrEqualTo(Float value) {
            addCriterion("usdamount >=", value, "usdamount");
            return (Criteria) this;
        }

        public Criteria andUsdamountLessThan(Float value) {
            addCriterion("usdamount <", value, "usdamount");
            return (Criteria) this;
        }

        public Criteria andUsdamountLessThanOrEqualTo(Float value) {
            addCriterion("usdamount <=", value, "usdamount");
            return (Criteria) this;
        }

        public Criteria andUsdamountIn(List<Float> values) {
            addCriterion("usdamount in", values, "usdamount");
            return (Criteria) this;
        }

        public Criteria andUsdamountNotIn(List<Float> values) {
            addCriterion("usdamount not in", values, "usdamount");
            return (Criteria) this;
        }

        public Criteria andUsdamountBetween(Float value1, Float value2) {
            addCriterion("usdamount between", value1, value2, "usdamount");
            return (Criteria) this;
        }

        public Criteria andUsdamountNotBetween(Float value1, Float value2) {
            addCriterion("usdamount not between", value1, value2, "usdamount");
            return (Criteria) this;
        }

        public Criteria andLockdateIsNull() {
            addCriterion("lockdate is null");
            return (Criteria) this;
        }

        public Criteria andLockdateIsNotNull() {
            addCriterion("lockdate is not null");
            return (Criteria) this;
        }

        public Criteria andLockdateEqualTo(Date value) {
            addCriterion("lockdate =", value, "lockdate");
            return (Criteria) this;
        }

        public Criteria andLockdateNotEqualTo(Date value) {
            addCriterion("lockdate <>", value, "lockdate");
            return (Criteria) this;
        }

        public Criteria andLockdateGreaterThan(Date value) {
            addCriterion("lockdate >", value, "lockdate");
            return (Criteria) this;
        }

        public Criteria andLockdateGreaterThanOrEqualTo(Date value) {
            addCriterion("lockdate >=", value, "lockdate");
            return (Criteria) this;
        }

        public Criteria andLockdateLessThan(Date value) {
            addCriterion("lockdate <", value, "lockdate");
            return (Criteria) this;
        }

        public Criteria andLockdateLessThanOrEqualTo(Date value) {
            addCriterion("lockdate <=", value, "lockdate");
            return (Criteria) this;
        }

        public Criteria andLockdateIn(List<Date> values) {
            addCriterion("lockdate in", values, "lockdate");
            return (Criteria) this;
        }

        public Criteria andLockdateNotIn(List<Date> values) {
            addCriterion("lockdate not in", values, "lockdate");
            return (Criteria) this;
        }

        public Criteria andLockdateBetween(Date value1, Date value2) {
            addCriterion("lockdate between", value1, value2, "lockdate");
            return (Criteria) this;
        }

        public Criteria andLockdateNotBetween(Date value1, Date value2) {
            addCriterion("lockdate not between", value1, value2, "lockdate");
            return (Criteria) this;
        }

        public Criteria andRecordtypeIsNull() {
            addCriterion("recordtype is null");
            return (Criteria) this;
        }

        public Criteria andRecordtypeIsNotNull() {
            addCriterion("recordtype is not null");
            return (Criteria) this;
        }

        public Criteria andRecordtypeEqualTo(String value) {
            addCriterion("recordtype =", value, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeNotEqualTo(String value) {
            addCriterion("recordtype <>", value, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeGreaterThan(String value) {
            addCriterion("recordtype >", value, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeGreaterThanOrEqualTo(String value) {
            addCriterion("recordtype >=", value, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeLessThan(String value) {
            addCriterion("recordtype <", value, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeLessThanOrEqualTo(String value) {
            addCriterion("recordtype <=", value, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeLike(String value) {
            addCriterion("recordtype like", value, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeNotLike(String value) {
            addCriterion("recordtype not like", value, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeIn(List<String> values) {
            addCriterion("recordtype in", values, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeNotIn(List<String> values) {
            addCriterion("recordtype not in", values, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeBetween(String value1, String value2) {
            addCriterion("recordtype between", value1, value2, "recordtype");
            return (Criteria) this;
        }

        public Criteria andRecordtypeNotBetween(String value1, String value2) {
            addCriterion("recordtype not between", value1, value2, "recordtype");
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

        public Criteria andApplybanknumIsNull() {
            addCriterion("applybanknum is null");
            return (Criteria) this;
        }

        public Criteria andApplybanknumIsNotNull() {
            addCriterion("applybanknum is not null");
            return (Criteria) this;
        }

        public Criteria andApplybanknumEqualTo(String value) {
            addCriterion("applybanknum =", value, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumNotEqualTo(String value) {
            addCriterion("applybanknum <>", value, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumGreaterThan(String value) {
            addCriterion("applybanknum >", value, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumGreaterThanOrEqualTo(String value) {
            addCriterion("applybanknum >=", value, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumLessThan(String value) {
            addCriterion("applybanknum <", value, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumLessThanOrEqualTo(String value) {
            addCriterion("applybanknum <=", value, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumLike(String value) {
            addCriterion("applybanknum like", value, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumNotLike(String value) {
            addCriterion("applybanknum not like", value, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumIn(List<String> values) {
            addCriterion("applybanknum in", values, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumNotIn(List<String> values) {
            addCriterion("applybanknum not in", values, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumBetween(String value1, String value2) {
            addCriterion("applybanknum between", value1, value2, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybanknumNotBetween(String value1, String value2) {
            addCriterion("applybanknum not between", value1, value2, "applybanknum");
            return (Criteria) this;
        }

        public Criteria andApplybankIsNull() {
            addCriterion("applybank is null");
            return (Criteria) this;
        }

        public Criteria andApplybankIsNotNull() {
            addCriterion("applybank is not null");
            return (Criteria) this;
        }

        public Criteria andApplybankEqualTo(String value) {
            addCriterion("applybank =", value, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankNotEqualTo(String value) {
            addCriterion("applybank <>", value, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankGreaterThan(String value) {
            addCriterion("applybank >", value, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankGreaterThanOrEqualTo(String value) {
            addCriterion("applybank >=", value, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankLessThan(String value) {
            addCriterion("applybank <", value, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankLessThanOrEqualTo(String value) {
            addCriterion("applybank <=", value, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankLike(String value) {
            addCriterion("applybank like", value, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankNotLike(String value) {
            addCriterion("applybank not like", value, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankIn(List<String> values) {
            addCriterion("applybank in", values, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankNotIn(List<String> values) {
            addCriterion("applybank not in", values, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankBetween(String value1, String value2) {
            addCriterion("applybank between", value1, value2, "applybank");
            return (Criteria) this;
        }

        public Criteria andApplybankNotBetween(String value1, String value2) {
            addCriterion("applybank not between", value1, value2, "applybank");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyIsNull() {
            addCriterion("transfercurrency is null");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyIsNotNull() {
            addCriterion("transfercurrency is not null");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyEqualTo(String value) {
            addCriterion("transfercurrency =", value, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyNotEqualTo(String value) {
            addCriterion("transfercurrency <>", value, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyGreaterThan(String value) {
            addCriterion("transfercurrency >", value, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("transfercurrency >=", value, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyLessThan(String value) {
            addCriterion("transfercurrency <", value, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyLessThanOrEqualTo(String value) {
            addCriterion("transfercurrency <=", value, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyLike(String value) {
            addCriterion("transfercurrency like", value, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyNotLike(String value) {
            addCriterion("transfercurrency not like", value, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyIn(List<String> values) {
            addCriterion("transfercurrency in", values, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyNotIn(List<String> values) {
            addCriterion("transfercurrency not in", values, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyBetween(String value1, String value2) {
            addCriterion("transfercurrency between", value1, value2, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfercurrencyNotBetween(String value1, String value2) {
            addCriterion("transfercurrency not between", value1, value2, "transfercurrency");
            return (Criteria) this;
        }

        public Criteria andTransfermountIsNull() {
            addCriterion("transfermount is null");
            return (Criteria) this;
        }

        public Criteria andTransfermountIsNotNull() {
            addCriterion("transfermount is not null");
            return (Criteria) this;
        }

        public Criteria andTransfermountEqualTo(Float value) {
            addCriterion("transfermount =", value, "transfermount");
            return (Criteria) this;
        }

        public Criteria andTransfermountNotEqualTo(Float value) {
            addCriterion("transfermount <>", value, "transfermount");
            return (Criteria) this;
        }

        public Criteria andTransfermountGreaterThan(Float value) {
            addCriterion("transfermount >", value, "transfermount");
            return (Criteria) this;
        }

        public Criteria andTransfermountGreaterThanOrEqualTo(Float value) {
            addCriterion("transfermount >=", value, "transfermount");
            return (Criteria) this;
        }

        public Criteria andTransfermountLessThan(Float value) {
            addCriterion("transfermount <", value, "transfermount");
            return (Criteria) this;
        }

        public Criteria andTransfermountLessThanOrEqualTo(Float value) {
            addCriterion("transfermount <=", value, "transfermount");
            return (Criteria) this;
        }

        public Criteria andTransfermountIn(List<Float> values) {
            addCriterion("transfermount in", values, "transfermount");
            return (Criteria) this;
        }

        public Criteria andTransfermountNotIn(List<Float> values) {
            addCriterion("transfermount not in", values, "transfermount");
            return (Criteria) this;
        }

        public Criteria andTransfermountBetween(Float value1, Float value2) {
            addCriterion("transfermount between", value1, value2, "transfermount");
            return (Criteria) this;
        }

        public Criteria andTransfermountNotBetween(Float value1, Float value2) {
            addCriterion("transfermount not between", value1, value2, "transfermount");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNull() {
            addCriterion("payee is null");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNotNull() {
            addCriterion("payee is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeEqualTo(String value) {
            addCriterion("payee =", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotEqualTo(String value) {
            addCriterion("payee <>", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThan(String value) {
            addCriterion("payee >", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThanOrEqualTo(String value) {
            addCriterion("payee >=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThan(String value) {
            addCriterion("payee <", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThanOrEqualTo(String value) {
            addCriterion("payee <=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLike(String value) {
            addCriterion("payee like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotLike(String value) {
            addCriterion("payee not like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeIn(List<String> values) {
            addCriterion("payee in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotIn(List<String> values) {
            addCriterion("payee not in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeBetween(String value1, String value2) {
            addCriterion("payee between", value1, value2, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotBetween(String value1, String value2) {
            addCriterion("payee not between", value1, value2, "payee");
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

        public Criteria andThingcauseIsNull() {
            addCriterion("thingcause is null");
            return (Criteria) this;
        }

        public Criteria andThingcauseIsNotNull() {
            addCriterion("thingcause is not null");
            return (Criteria) this;
        }

        public Criteria andThingcauseEqualTo(String value) {
            addCriterion("thingcause =", value, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseNotEqualTo(String value) {
            addCriterion("thingcause <>", value, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseGreaterThan(String value) {
            addCriterion("thingcause >", value, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseGreaterThanOrEqualTo(String value) {
            addCriterion("thingcause >=", value, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseLessThan(String value) {
            addCriterion("thingcause <", value, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseLessThanOrEqualTo(String value) {
            addCriterion("thingcause <=", value, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseLike(String value) {
            addCriterion("thingcause like", value, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseNotLike(String value) {
            addCriterion("thingcause not like", value, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseIn(List<String> values) {
            addCriterion("thingcause in", values, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseNotIn(List<String> values) {
            addCriterion("thingcause not in", values, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseBetween(String value1, String value2) {
            addCriterion("thingcause between", value1, value2, "thingcause");
            return (Criteria) this;
        }

        public Criteria andThingcauseNotBetween(String value1, String value2) {
            addCriterion("thingcause not between", value1, value2, "thingcause");
            return (Criteria) this;
        }

        public Criteria andBranchIsNull() {
            addCriterion("branch is null");
            return (Criteria) this;
        }

        public Criteria andBranchIsNotNull() {
            addCriterion("branch is not null");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("branch =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotEqualTo(String value) {
            addCriterion("branch <>", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchGreaterThan(String value) {
            addCriterion("branch >", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchGreaterThanOrEqualTo(String value) {
            addCriterion("branch >=", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLessThan(String value) {
            addCriterion("branch <", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLessThanOrEqualTo(String value) {
            addCriterion("branch <=", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLike(String value) {
            addCriterion("branch like", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotLike(String value) {
            addCriterion("branch not like", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchIn(List<String> values) {
            addCriterion("branch in", values, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotIn(List<String> values) {
            addCriterion("branch not in", values, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchBetween(String value1, String value2) {
            addCriterion("branch between", value1, value2, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotBetween(String value1, String value2) {
            addCriterion("branch not between", value1, value2, "branch");
            return (Criteria) this;
        }

        public Criteria andTransferdateIsNull() {
            addCriterion("transferdate is null");
            return (Criteria) this;
        }

        public Criteria andTransferdateIsNotNull() {
            addCriterion("transferdate is not null");
            return (Criteria) this;
        }

        public Criteria andTransferdateEqualTo(Date value) {
            addCriterion("transferdate =", value, "transferdate");
            return (Criteria) this;
        }

        public Criteria andTransferdateNotEqualTo(Date value) {
            addCriterion("transferdate <>", value, "transferdate");
            return (Criteria) this;
        }

        public Criteria andTransferdateGreaterThan(Date value) {
            addCriterion("transferdate >", value, "transferdate");
            return (Criteria) this;
        }

        public Criteria andTransferdateGreaterThanOrEqualTo(Date value) {
            addCriterion("transferdate >=", value, "transferdate");
            return (Criteria) this;
        }

        public Criteria andTransferdateLessThan(Date value) {
            addCriterion("transferdate <", value, "transferdate");
            return (Criteria) this;
        }

        public Criteria andTransferdateLessThanOrEqualTo(Date value) {
            addCriterion("transferdate <=", value, "transferdate");
            return (Criteria) this;
        }

        public Criteria andTransferdateIn(List<Date> values) {
            addCriterion("transferdate in", values, "transferdate");
            return (Criteria) this;
        }

        public Criteria andTransferdateNotIn(List<Date> values) {
            addCriterion("transferdate not in", values, "transferdate");
            return (Criteria) this;
        }

        public Criteria andTransferdateBetween(Date value1, Date value2) {
            addCriterion("transferdate between", value1, value2, "transferdate");
            return (Criteria) this;
        }

        public Criteria andTransferdateNotBetween(Date value1, Date value2) {
            addCriterion("transferdate not between", value1, value2, "transferdate");
            return (Criteria) this;
        }

        public Criteria andUnitnameIsNull() {
            addCriterion("unitname is null");
            return (Criteria) this;
        }

        public Criteria andUnitnameIsNotNull() {
            addCriterion("unitname is not null");
            return (Criteria) this;
        }

        public Criteria andUnitnameEqualTo(String value) {
            addCriterion("unitname =", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotEqualTo(String value) {
            addCriterion("unitname <>", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameGreaterThan(String value) {
            addCriterion("unitname >", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameGreaterThanOrEqualTo(String value) {
            addCriterion("unitname >=", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameLessThan(String value) {
            addCriterion("unitname <", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameLessThanOrEqualTo(String value) {
            addCriterion("unitname <=", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameLike(String value) {
            addCriterion("unitname like", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotLike(String value) {
            addCriterion("unitname not like", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameIn(List<String> values) {
            addCriterion("unitname in", values, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotIn(List<String> values) {
            addCriterion("unitname not in", values, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameBetween(String value1, String value2) {
            addCriterion("unitname between", value1, value2, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotBetween(String value1, String value2) {
            addCriterion("unitname not between", value1, value2, "unitname");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeIsNull() {
            addCriterion("advancefeetype is null");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeIsNotNull() {
            addCriterion("advancefeetype is not null");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeEqualTo(String value) {
            addCriterion("advancefeetype =", value, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeNotEqualTo(String value) {
            addCriterion("advancefeetype <>", value, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeGreaterThan(String value) {
            addCriterion("advancefeetype >", value, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeGreaterThanOrEqualTo(String value) {
            addCriterion("advancefeetype >=", value, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeLessThan(String value) {
            addCriterion("advancefeetype <", value, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeLessThanOrEqualTo(String value) {
            addCriterion("advancefeetype <=", value, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeLike(String value) {
            addCriterion("advancefeetype like", value, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeNotLike(String value) {
            addCriterion("advancefeetype not like", value, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeIn(List<String> values) {
            addCriterion("advancefeetype in", values, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeNotIn(List<String> values) {
            addCriterion("advancefeetype not in", values, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeBetween(String value1, String value2) {
            addCriterion("advancefeetype between", value1, value2, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andAdvancefeetypeNotBetween(String value1, String value2) {
            addCriterion("advancefeetype not between", value1, value2, "advancefeetype");
            return (Criteria) this;
        }

        public Criteria andIncasenoIsNull() {
            addCriterion("incaseno is null");
            return (Criteria) this;
        }

        public Criteria andIncasenoIsNotNull() {
            addCriterion("incaseno is not null");
            return (Criteria) this;
        }

        public Criteria andIncasenoEqualTo(String value) {
            addCriterion("incaseno =", value, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoNotEqualTo(String value) {
            addCriterion("incaseno <>", value, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoGreaterThan(String value) {
            addCriterion("incaseno >", value, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoGreaterThanOrEqualTo(String value) {
            addCriterion("incaseno >=", value, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoLessThan(String value) {
            addCriterion("incaseno <", value, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoLessThanOrEqualTo(String value) {
            addCriterion("incaseno <=", value, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoLike(String value) {
            addCriterion("incaseno like", value, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoNotLike(String value) {
            addCriterion("incaseno not like", value, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoIn(List<String> values) {
            addCriterion("incaseno in", values, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoNotIn(List<String> values) {
            addCriterion("incaseno not in", values, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoBetween(String value1, String value2) {
            addCriterion("incaseno between", value1, value2, "incaseno");
            return (Criteria) this;
        }

        public Criteria andIncasenoNotBetween(String value1, String value2) {
            addCriterion("incaseno not between", value1, value2, "incaseno");
            return (Criteria) this;
        }

        public Criteria andRecordmountIsNull() {
            addCriterion("recordmount is null");
            return (Criteria) this;
        }

        public Criteria andRecordmountIsNotNull() {
            addCriterion("recordmount is not null");
            return (Criteria) this;
        }

        public Criteria andRecordmountEqualTo(Float value) {
            addCriterion("recordmount =", value, "recordmount");
            return (Criteria) this;
        }

        public Criteria andRecordmountNotEqualTo(Float value) {
            addCriterion("recordmount <>", value, "recordmount");
            return (Criteria) this;
        }

        public Criteria andRecordmountGreaterThan(Float value) {
            addCriterion("recordmount >", value, "recordmount");
            return (Criteria) this;
        }

        public Criteria andRecordmountGreaterThanOrEqualTo(Float value) {
            addCriterion("recordmount >=", value, "recordmount");
            return (Criteria) this;
        }

        public Criteria andRecordmountLessThan(Float value) {
            addCriterion("recordmount <", value, "recordmount");
            return (Criteria) this;
        }

        public Criteria andRecordmountLessThanOrEqualTo(Float value) {
            addCriterion("recordmount <=", value, "recordmount");
            return (Criteria) this;
        }

        public Criteria andRecordmountIn(List<Float> values) {
            addCriterion("recordmount in", values, "recordmount");
            return (Criteria) this;
        }

        public Criteria andRecordmountNotIn(List<Float> values) {
            addCriterion("recordmount not in", values, "recordmount");
            return (Criteria) this;
        }

        public Criteria andRecordmountBetween(Float value1, Float value2) {
            addCriterion("recordmount between", value1, value2, "recordmount");
            return (Criteria) this;
        }

        public Criteria andRecordmountNotBetween(Float value1, Float value2) {
            addCriterion("recordmount not between", value1, value2, "recordmount");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyIsNull() {
            addCriterion("recordcurrency is null");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyIsNotNull() {
            addCriterion("recordcurrency is not null");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyEqualTo(String value) {
            addCriterion("recordcurrency =", value, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyNotEqualTo(String value) {
            addCriterion("recordcurrency <>", value, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyGreaterThan(String value) {
            addCriterion("recordcurrency >", value, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("recordcurrency >=", value, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyLessThan(String value) {
            addCriterion("recordcurrency <", value, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyLessThanOrEqualTo(String value) {
            addCriterion("recordcurrency <=", value, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyLike(String value) {
            addCriterion("recordcurrency like", value, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyNotLike(String value) {
            addCriterion("recordcurrency not like", value, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyIn(List<String> values) {
            addCriterion("recordcurrency in", values, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyNotIn(List<String> values) {
            addCriterion("recordcurrency not in", values, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyBetween(String value1, String value2) {
            addCriterion("recordcurrency between", value1, value2, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andRecordcurrencyNotBetween(String value1, String value2) {
            addCriterion("recordcurrency not between", value1, value2, "recordcurrency");
            return (Criteria) this;
        }

        public Criteria andPaymountIsNull() {
            addCriterion("paymount is null");
            return (Criteria) this;
        }

        public Criteria andPaymountIsNotNull() {
            addCriterion("paymount is not null");
            return (Criteria) this;
        }

        public Criteria andPaymountEqualTo(Float value) {
            addCriterion("paymount =", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountNotEqualTo(Float value) {
            addCriterion("paymount <>", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountGreaterThan(Float value) {
            addCriterion("paymount >", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountGreaterThanOrEqualTo(Float value) {
            addCriterion("paymount >=", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountLessThan(Float value) {
            addCriterion("paymount <", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountLessThanOrEqualTo(Float value) {
            addCriterion("paymount <=", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountIn(List<Float> values) {
            addCriterion("paymount in", values, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountNotIn(List<Float> values) {
            addCriterion("paymount not in", values, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountBetween(Float value1, Float value2) {
            addCriterion("paymount between", value1, value2, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountNotBetween(Float value1, Float value2) {
            addCriterion("paymount not between", value1, value2, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyIsNull() {
            addCriterion("paycurrency is null");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyIsNotNull() {
            addCriterion("paycurrency is not null");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyEqualTo(String value) {
            addCriterion("paycurrency =", value, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyNotEqualTo(String value) {
            addCriterion("paycurrency <>", value, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyGreaterThan(String value) {
            addCriterion("paycurrency >", value, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("paycurrency >=", value, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyLessThan(String value) {
            addCriterion("paycurrency <", value, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyLessThanOrEqualTo(String value) {
            addCriterion("paycurrency <=", value, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyLike(String value) {
            addCriterion("paycurrency like", value, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyNotLike(String value) {
            addCriterion("paycurrency not like", value, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyIn(List<String> values) {
            addCriterion("paycurrency in", values, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyNotIn(List<String> values) {
            addCriterion("paycurrency not in", values, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyBetween(String value1, String value2) {
            addCriterion("paycurrency between", value1, value2, "paycurrency");
            return (Criteria) this;
        }

        public Criteria andPaycurrencyNotBetween(String value1, String value2) {
            addCriterion("paycurrency not between", value1, value2, "paycurrency");
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

        public Criteria andRemark2IsNull() {
            addCriterion("remark2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("remark2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("remark2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("remark2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("remark2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("remark2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("remark2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("remark2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("remark2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("remark2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("remark2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("remark2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("remark2 not between", value1, value2, "remark2");
            return (Criteria) this;
        }
        
        public Criteria orBillId(String value1){
        	StringBuffer sb = new StringBuffer(" (bill_id = "+value1+" or bill_id = 0) ");
        	addCriterion(sb.toString());
        	return (Criteria) this;
        }

        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Long value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Long value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Long value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Long value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Long value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Long> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Long> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Long value1, Long value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Long value1, Long value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillnumberIsNull() {
            addCriterion("billnumber is null");
            return (Criteria) this;
        }

        public Criteria andBillnumberIsNotNull() {
            addCriterion("billnumber is not null");
            return (Criteria) this;
        }

        public Criteria andBillnumberEqualTo(String value) {
            addCriterion("billnumber =", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotEqualTo(String value) {
            addCriterion("billnumber <>", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberGreaterThan(String value) {
            addCriterion("billnumber >", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberGreaterThanOrEqualTo(String value) {
            addCriterion("billnumber >=", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLessThan(String value) {
            addCriterion("billnumber <", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLessThanOrEqualTo(String value) {
            addCriterion("billnumber <=", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLike(String value) {
            addCriterion("billnumber like", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotLike(String value) {
            addCriterion("billnumber not like", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberIn(List<String> values) {
            addCriterion("billnumber in", values, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotIn(List<String> values) {
            addCriterion("billnumber not in", values, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberBetween(String value1, String value2) {
            addCriterion("billnumber between", value1, value2, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotBetween(String value1, String value2) {
            addCriterion("billnumber not between", value1, value2, "billnumber");
            return (Criteria) this;
        }

        public Criteria andDifferamountIsNull() {
            addCriterion("differamount is null");
            return (Criteria) this;
        }

        public Criteria andDifferamountIsNotNull() {
            addCriterion("differamount is not null");
            return (Criteria) this;
        }

        public Criteria andDifferamountEqualTo(Float value) {
            addCriterion("differamount =", value, "differamount");
            return (Criteria) this;
        }

        public Criteria andDifferamountNotEqualTo(Float value) {
            addCriterion("differamount <>", value, "differamount");
            return (Criteria) this;
        }

        public Criteria andDifferamountGreaterThan(Float value) {
            addCriterion("differamount >", value, "differamount");
            return (Criteria) this;
        }

        public Criteria andDifferamountGreaterThanOrEqualTo(Float value) {
            addCriterion("differamount >=", value, "differamount");
            return (Criteria) this;
        }

        public Criteria andDifferamountLessThan(Float value) {
            addCriterion("differamount <", value, "differamount");
            return (Criteria) this;
        }

        public Criteria andDifferamountLessThanOrEqualTo(Float value) {
            addCriterion("differamount <=", value, "differamount");
            return (Criteria) this;
        }

        public Criteria andDifferamountIn(List<Float> values) {
            addCriterion("differamount in", values, "differamount");
            return (Criteria) this;
        }

        public Criteria andDifferamountNotIn(List<Float> values) {
            addCriterion("differamount not in", values, "differamount");
            return (Criteria) this;
        }

        public Criteria andDifferamountBetween(Float value1, Float value2) {
            addCriterion("differamount between", value1, value2, "differamount");
            return (Criteria) this;
        }

        public Criteria andDifferamountNotBetween(Float value1, Float value2) {
            addCriterion("differamount not between", value1, value2, "differamount");
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