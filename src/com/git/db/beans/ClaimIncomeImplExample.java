package com.git.db.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClaimIncomeImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClaimIncomeImplExample() {
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

        public Criteria andIncomeIdIsNull() {
            addCriterion("Income_Id is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIdIsNotNull() {
            addCriterion("Income_Id is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeIdEqualTo(Long value) {
            addCriterion("Income_Id =", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdNotEqualTo(Long value) {
            addCriterion("Income_Id <>", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdGreaterThan(Long value) {
            addCriterion("Income_Id >", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Income_Id >=", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdLessThan(Long value) {
            addCriterion("Income_Id <", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdLessThanOrEqualTo(Long value) {
            addCriterion("Income_Id <=", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdIn(List<Long> values) {
            addCriterion("Income_Id in", values, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdNotIn(List<Long> values) {
            addCriterion("Income_Id not in", values, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdBetween(Long value1, Long value2) {
            addCriterion("Income_Id between", value1, value2, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdNotBetween(Long value1, Long value2) {
            addCriterion("Income_Id not between", value1, value2, "incomeId");
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

        public Criteria andPayerIsNull() {
            addCriterion("payer is null");
            return (Criteria) this;
        }

        public Criteria andPayerIsNotNull() {
            addCriterion("payer is not null");
            return (Criteria) this;
        }

        public Criteria andPayerEqualTo(String value) {
            addCriterion("payer =", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotEqualTo(String value) {
            addCriterion("payer <>", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerGreaterThan(String value) {
            addCriterion("payer >", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerGreaterThanOrEqualTo(String value) {
            addCriterion("payer >=", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerLessThan(String value) {
            addCriterion("payer <", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerLessThanOrEqualTo(String value) {
            addCriterion("payer <=", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerLike(String value) {
            addCriterion("payer like", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotLike(String value) {
            addCriterion("payer not like", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerIn(List<String> values) {
            addCriterion("payer in", values, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotIn(List<String> values) {
            addCriterion("payer not in", values, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerBetween(String value1, String value2) {
            addCriterion("payer between", value1, value2, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotBetween(String value1, String value2) {
            addCriterion("payer not between", value1, value2, "payer");
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

        public Criteria andReceiveamountIsNull() {
            addCriterion("receiveamount is null");
            return (Criteria) this;
        }

        public Criteria andReceiveamountIsNotNull() {
            addCriterion("receiveamount is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveamountEqualTo(Float value) {
            addCriterion("receiveamount =", value, "receiveamount");
            return (Criteria) this;
        }

        public Criteria andReceiveamountNotEqualTo(Float value) {
            addCriterion("receiveamount <>", value, "receiveamount");
            return (Criteria) this;
        }

        public Criteria andReceiveamountGreaterThan(Float value) {
            addCriterion("receiveamount >", value, "receiveamount");
            return (Criteria) this;
        }

        public Criteria andReceiveamountGreaterThanOrEqualTo(Float value) {
            addCriterion("receiveamount >=", value, "receiveamount");
            return (Criteria) this;
        }

        public Criteria andReceiveamountLessThan(Float value) {
            addCriterion("receiveamount <", value, "receiveamount");
            return (Criteria) this;
        }

        public Criteria andReceiveamountLessThanOrEqualTo(Float value) {
            addCriterion("receiveamount <=", value, "receiveamount");
            return (Criteria) this;
        }

        public Criteria andReceiveamountIn(List<Float> values) {
            addCriterion("receiveamount in", values, "receiveamount");
            return (Criteria) this;
        }

        public Criteria andReceiveamountNotIn(List<Float> values) {
            addCriterion("receiveamount not in", values, "receiveamount");
            return (Criteria) this;
        }

        public Criteria andReceiveamountBetween(Float value1, Float value2) {
            addCriterion("receiveamount between", value1, value2, "receiveamount");
            return (Criteria) this;
        }

        public Criteria andReceiveamountNotBetween(Float value1, Float value2) {
            addCriterion("receiveamount not between", value1, value2, "receiveamount");
            return (Criteria) this;
        }

        public Criteria andBankfeeIsNull() {
            addCriterion("bankfee is null");
            return (Criteria) this;
        }

        public Criteria andBankfeeIsNotNull() {
            addCriterion("bankfee is not null");
            return (Criteria) this;
        }

        public Criteria andBankfeeEqualTo(Float value) {
            addCriterion("bankfee =", value, "bankfee");
            return (Criteria) this;
        }

        public Criteria andBankfeeNotEqualTo(Float value) {
            addCriterion("bankfee <>", value, "bankfee");
            return (Criteria) this;
        }

        public Criteria andBankfeeGreaterThan(Float value) {
            addCriterion("bankfee >", value, "bankfee");
            return (Criteria) this;
        }

        public Criteria andBankfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("bankfee >=", value, "bankfee");
            return (Criteria) this;
        }

        public Criteria andBankfeeLessThan(Float value) {
            addCriterion("bankfee <", value, "bankfee");
            return (Criteria) this;
        }

        public Criteria andBankfeeLessThanOrEqualTo(Float value) {
            addCriterion("bankfee <=", value, "bankfee");
            return (Criteria) this;
        }

        public Criteria andBankfeeIn(List<Float> values) {
            addCriterion("bankfee in", values, "bankfee");
            return (Criteria) this;
        }

        public Criteria andBankfeeNotIn(List<Float> values) {
            addCriterion("bankfee not in", values, "bankfee");
            return (Criteria) this;
        }

        public Criteria andBankfeeBetween(Float value1, Float value2) {
            addCriterion("bankfee between", value1, value2, "bankfee");
            return (Criteria) this;
        }

        public Criteria andBankfeeNotBetween(Float value1, Float value2) {
            addCriterion("bankfee not between", value1, value2, "bankfee");
            return (Criteria) this;
        }

        public Criteria andTotalamountIsNull() {
            addCriterion("totalamount is null");
            return (Criteria) this;
        }

        public Criteria andTotalamountIsNotNull() {
            addCriterion("totalamount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalamountEqualTo(Float value) {
            addCriterion("totalamount =", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotEqualTo(Float value) {
            addCriterion("totalamount <>", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountGreaterThan(Float value) {
            addCriterion("totalamount >", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountGreaterThanOrEqualTo(Float value) {
            addCriterion("totalamount >=", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountLessThan(Float value) {
            addCriterion("totalamount <", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountLessThanOrEqualTo(Float value) {
            addCriterion("totalamount <=", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountIn(List<Float> values) {
            addCriterion("totalamount in", values, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotIn(List<Float> values) {
            addCriterion("totalamount not in", values, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountBetween(Float value1, Float value2) {
            addCriterion("totalamount between", value1, value2, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotBetween(Float value1, Float value2) {
            addCriterion("totalamount not between", value1, value2, "totalamount");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
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

        public Criteria andReceivedateIsNull() {
            addCriterion("receivedate is null");
            return (Criteria) this;
        }

        public Criteria andReceivedateIsNotNull() {
            addCriterion("receivedate is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedateEqualTo(Date value) {
            addCriterion("receivedate =", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateNotEqualTo(Date value) {
            addCriterion("receivedate <>", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateGreaterThan(Date value) {
            addCriterion("receivedate >", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateGreaterThanOrEqualTo(Date value) {
            addCriterion("receivedate >=", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateLessThan(Date value) {
            addCriterion("receivedate <", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateLessThanOrEqualTo(Date value) {
            addCriterion("receivedate <=", value, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateIn(List<Date> values) {
            addCriterion("receivedate in", values, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateNotIn(List<Date> values) {
            addCriterion("receivedate not in", values, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateBetween(Date value1, Date value2) {
            addCriterion("receivedate between", value1, value2, "receivedate");
            return (Criteria) this;
        }

        public Criteria andReceivedateNotBetween(Date value1, Date value2) {
            addCriterion("receivedate not between", value1, value2, "receivedate");
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

        public Criteria andIslockedIsNull() {
            addCriterion("Islocked is null");
            return (Criteria) this;
        }

        public Criteria andIslockedIsNotNull() {
            addCriterion("Islocked is not null");
            return (Criteria) this;
        }

        public Criteria andIslockedEqualTo(String value) {
            addCriterion("Islocked =", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedNotEqualTo(String value) {
            addCriterion("Islocked <>", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedGreaterThan(String value) {
            addCriterion("Islocked >", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedGreaterThanOrEqualTo(String value) {
            addCriterion("Islocked >=", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedLessThan(String value) {
            addCriterion("Islocked <", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedLessThanOrEqualTo(String value) {
            addCriterion("Islocked <=", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedLike(String value) {
            addCriterion("Islocked like", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedNotLike(String value) {
            addCriterion("Islocked not like", value, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedIn(List<String> values) {
            addCriterion("Islocked in", values, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedNotIn(List<String> values) {
            addCriterion("Islocked not in", values, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedBetween(String value1, String value2) {
            addCriterion("Islocked between", value1, value2, "islocked");
            return (Criteria) this;
        }

        public Criteria andIslockedNotBetween(String value1, String value2) {
            addCriterion("Islocked not between", value1, value2, "islocked");
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

        public Criteria andRemark3IsNull() {
            addCriterion("remark3 is null");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNotNull() {
            addCriterion("remark3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark3EqualTo(String value) {
            addCriterion("remark3 =", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            addCriterion("remark3 <>", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            addCriterion("remark3 >", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            addCriterion("remark3 >=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThan(String value) {
            addCriterion("remark3 <", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            addCriterion("remark3 <=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Like(String value) {
            addCriterion("remark3 like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotLike(String value) {
            addCriterion("remark3 not like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3In(List<String> values) {
            addCriterion("remark3 in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            addCriterion("remark3 not in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            addCriterion("remark3 between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            addCriterion("remark3 not between", value1, value2, "remark3");
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