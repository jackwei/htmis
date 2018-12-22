package com.git.db.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillIncomeImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillIncomeImplExample() {
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

        public Criteria andStatementnumberIsNull() {
            addCriterion("statementnumber is null");
            return (Criteria) this;
        }

        public Criteria andStatementnumberIsNotNull() {
            addCriterion("statementnumber is not null");
            return (Criteria) this;
        }

        public Criteria andStatementnumberEqualTo(String value) {
            addCriterion("statementnumber =", value, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberNotEqualTo(String value) {
            addCriterion("statementnumber <>", value, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberGreaterThan(String value) {
            addCriterion("statementnumber >", value, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberGreaterThanOrEqualTo(String value) {
            addCriterion("statementnumber >=", value, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberLessThan(String value) {
            addCriterion("statementnumber <", value, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberLessThanOrEqualTo(String value) {
            addCriterion("statementnumber <=", value, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberLike(String value) {
            addCriterion("statementnumber like", value, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberNotLike(String value) {
            addCriterion("statementnumber not like", value, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberIn(List<String> values) {
            addCriterion("statementnumber in", values, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberNotIn(List<String> values) {
            addCriterion("statementnumber not in", values, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberBetween(String value1, String value2) {
            addCriterion("statementnumber between", value1, value2, "statementnumber");
            return (Criteria) this;
        }

        public Criteria andStatementnumberNotBetween(String value1, String value2) {
            addCriterion("statementnumber not between", value1, value2, "statementnumber");
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

        public Criteria andPayernameIsNull() {
            addCriterion("payername is null");
            return (Criteria) this;
        }

        public Criteria andPayernameIsNotNull() {
            addCriterion("payername is not null");
            return (Criteria) this;
        }

        public Criteria andPayernameEqualTo(String value) {
            addCriterion("payername =", value, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameNotEqualTo(String value) {
            addCriterion("payername <>", value, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameGreaterThan(String value) {
            addCriterion("payername >", value, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameGreaterThanOrEqualTo(String value) {
            addCriterion("payername >=", value, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameLessThan(String value) {
            addCriterion("payername <", value, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameLessThanOrEqualTo(String value) {
            addCriterion("payername <=", value, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameLike(String value) {
            addCriterion("payername like", value, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameNotLike(String value) {
            addCriterion("payername not like", value, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameIn(List<String> values) {
            addCriterion("payername in", values, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameNotIn(List<String> values) {
            addCriterion("payername not in", values, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameBetween(String value1, String value2) {
            addCriterion("payername between", value1, value2, "payername");
            return (Criteria) this;
        }

        public Criteria andPayernameNotBetween(String value1, String value2) {
            addCriterion("payername not between", value1, value2, "payername");
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

        public Criteria andPayamountIsNull() {
            addCriterion("payamount is null");
            return (Criteria) this;
        }

        public Criteria andPayamountIsNotNull() {
            addCriterion("payamount is not null");
            return (Criteria) this;
        }

        public Criteria andPayamountEqualTo(Float value) {
            addCriterion("payamount =", value, "payamount");
            return (Criteria) this;
        }

        public Criteria andPayamountNotEqualTo(Float value) {
            addCriterion("payamount <>", value, "payamount");
            return (Criteria) this;
        }

        public Criteria andPayamountGreaterThan(Float value) {
            addCriterion("payamount >", value, "payamount");
            return (Criteria) this;
        }

        public Criteria andPayamountGreaterThanOrEqualTo(Float value) {
            addCriterion("payamount >=", value, "payamount");
            return (Criteria) this;
        }

        public Criteria andPayamountLessThan(Float value) {
            addCriterion("payamount <", value, "payamount");
            return (Criteria) this;
        }

        public Criteria andPayamountLessThanOrEqualTo(Float value) {
            addCriterion("payamount <=", value, "payamount");
            return (Criteria) this;
        }

        public Criteria andPayamountIn(List<Float> values) {
            addCriterion("payamount in", values, "payamount");
            return (Criteria) this;
        }

        public Criteria andPayamountNotIn(List<Float> values) {
            addCriterion("payamount not in", values, "payamount");
            return (Criteria) this;
        }

        public Criteria andPayamountBetween(Float value1, Float value2) {
            addCriterion("payamount between", value1, value2, "payamount");
            return (Criteria) this;
        }

        public Criteria andPayamountNotBetween(Float value1, Float value2) {
            addCriterion("payamount not between", value1, value2, "payamount");
            return (Criteria) this;
        }

        public Criteria andLossamountIsNull() {
            addCriterion("lossamount is null");
            return (Criteria) this;
        }

        public Criteria andLossamountIsNotNull() {
            addCriterion("lossamount is not null");
            return (Criteria) this;
        }

        public Criteria andLossamountEqualTo(Float value) {
            addCriterion("lossamount =", value, "lossamount");
            return (Criteria) this;
        }

        public Criteria andLossamountNotEqualTo(Float value) {
            addCriterion("lossamount <>", value, "lossamount");
            return (Criteria) this;
        }

        public Criteria andLossamountGreaterThan(Float value) {
            addCriterion("lossamount >", value, "lossamount");
            return (Criteria) this;
        }

        public Criteria andLossamountGreaterThanOrEqualTo(Float value) {
            addCriterion("lossamount >=", value, "lossamount");
            return (Criteria) this;
        }

        public Criteria andLossamountLessThan(Float value) {
            addCriterion("lossamount <", value, "lossamount");
            return (Criteria) this;
        }

        public Criteria andLossamountLessThanOrEqualTo(Float value) {
            addCriterion("lossamount <=", value, "lossamount");
            return (Criteria) this;
        }

        public Criteria andLossamountIn(List<Float> values) {
            addCriterion("lossamount in", values, "lossamount");
            return (Criteria) this;
        }

        public Criteria andLossamountNotIn(List<Float> values) {
            addCriterion("lossamount not in", values, "lossamount");
            return (Criteria) this;
        }

        public Criteria andLossamountBetween(Float value1, Float value2) {
            addCriterion("lossamount between", value1, value2, "lossamount");
            return (Criteria) this;
        }

        public Criteria andLossamountNotBetween(Float value1, Float value2) {
            addCriterion("lossamount not between", value1, value2, "lossamount");
            return (Criteria) this;
        }

        public Criteria andChangeamountIsNull() {
            addCriterion("changeamount is null");
            return (Criteria) this;
        }

        public Criteria andChangeamountIsNotNull() {
            addCriterion("changeamount is not null");
            return (Criteria) this;
        }

        public Criteria andChangeamountEqualTo(Float value) {
            addCriterion("changeamount =", value, "changeamount");
            return (Criteria) this;
        }

        public Criteria andChangeamountNotEqualTo(Float value) {
            addCriterion("changeamount <>", value, "changeamount");
            return (Criteria) this;
        }

        public Criteria andChangeamountGreaterThan(Float value) {
            addCriterion("changeamount >", value, "changeamount");
            return (Criteria) this;
        }

        public Criteria andChangeamountGreaterThanOrEqualTo(Float value) {
            addCriterion("changeamount >=", value, "changeamount");
            return (Criteria) this;
        }

        public Criteria andChangeamountLessThan(Float value) {
            addCriterion("changeamount <", value, "changeamount");
            return (Criteria) this;
        }

        public Criteria andChangeamountLessThanOrEqualTo(Float value) {
            addCriterion("changeamount <=", value, "changeamount");
            return (Criteria) this;
        }

        public Criteria andChangeamountIn(List<Float> values) {
            addCriterion("changeamount in", values, "changeamount");
            return (Criteria) this;
        }

        public Criteria andChangeamountNotIn(List<Float> values) {
            addCriterion("changeamount not in", values, "changeamount");
            return (Criteria) this;
        }

        public Criteria andChangeamountBetween(Float value1, Float value2) {
            addCriterion("changeamount between", value1, value2, "changeamount");
            return (Criteria) this;
        }

        public Criteria andChangeamountNotBetween(Float value1, Float value2) {
            addCriterion("changeamount not between", value1, value2, "changeamount");
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

        public Criteria andIncometypeIsNull() {
            addCriterion("incometype is null");
            return (Criteria) this;
        }

        public Criteria andIncometypeIsNotNull() {
            addCriterion("incometype is not null");
            return (Criteria) this;
        }

        public Criteria andIncometypeEqualTo(String value) {
            addCriterion("incometype =", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeNotEqualTo(String value) {
            addCriterion("incometype <>", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeGreaterThan(String value) {
            addCriterion("incometype >", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeGreaterThanOrEqualTo(String value) {
            addCriterion("incometype >=", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeLessThan(String value) {
            addCriterion("incometype <", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeLessThanOrEqualTo(String value) {
            addCriterion("incometype <=", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeLike(String value) {
            addCriterion("incometype like", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeNotLike(String value) {
            addCriterion("incometype not like", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeIn(List<String> values) {
            addCriterion("incometype in", values, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeNotIn(List<String> values) {
            addCriterion("incometype not in", values, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeBetween(String value1, String value2) {
            addCriterion("incometype between", value1, value2, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeNotBetween(String value1, String value2) {
            addCriterion("incometype not between", value1, value2, "incometype");
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

        public Criteria andOrgnameIsNull() {
            addCriterion("orgname is null");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNotNull() {
            addCriterion("orgname is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnameEqualTo(String value) {
            addCriterion("orgname =", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotEqualTo(String value) {
            addCriterion("orgname <>", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThan(String value) {
            addCriterion("orgname >", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("orgname >=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThan(String value) {
            addCriterion("orgname <", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThanOrEqualTo(String value) {
            addCriterion("orgname <=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLike(String value) {
            addCriterion("orgname like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotLike(String value) {
            addCriterion("orgname not like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameIn(List<String> values) {
            addCriterion("orgname in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotIn(List<String> values) {
            addCriterion("orgname not in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameBetween(String value1, String value2) {
            addCriterion("orgname between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotBetween(String value1, String value2) {
            addCriterion("orgname not between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andIsTransformIsNull() {
            addCriterion("is_transform is null");
            return (Criteria) this;
        }

        public Criteria andIsTransformIsNotNull() {
            addCriterion("is_transform is not null");
            return (Criteria) this;
        }

        public Criteria andIsTransformEqualTo(String value) {
            addCriterion("is_transform =", value, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformNotEqualTo(String value) {
            addCriterion("is_transform <>", value, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformGreaterThan(String value) {
            addCriterion("is_transform >", value, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformGreaterThanOrEqualTo(String value) {
            addCriterion("is_transform >=", value, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformLessThan(String value) {
            addCriterion("is_transform <", value, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformLessThanOrEqualTo(String value) {
            addCriterion("is_transform <=", value, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformLike(String value) {
            addCriterion("is_transform like", value, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformNotLike(String value) {
            addCriterion("is_transform not like", value, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformIn(List<String> values) {
            addCriterion("is_transform in", values, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformNotIn(List<String> values) {
            addCriterion("is_transform not in", values, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformBetween(String value1, String value2) {
            addCriterion("is_transform between", value1, value2, "isTransform");
            return (Criteria) this;
        }

        public Criteria andIsTransformNotBetween(String value1, String value2) {
            addCriterion("is_transform not between", value1, value2, "isTransform");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyIsNull() {
            addCriterion("transformcurrency is null");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyIsNotNull() {
            addCriterion("transformcurrency is not null");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyEqualTo(String value) {
            addCriterion("transformcurrency =", value, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyNotEqualTo(String value) {
            addCriterion("transformcurrency <>", value, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyGreaterThan(String value) {
            addCriterion("transformcurrency >", value, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("transformcurrency >=", value, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyLessThan(String value) {
            addCriterion("transformcurrency <", value, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyLessThanOrEqualTo(String value) {
            addCriterion("transformcurrency <=", value, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyLike(String value) {
            addCriterion("transformcurrency like", value, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyNotLike(String value) {
            addCriterion("transformcurrency not like", value, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyIn(List<String> values) {
            addCriterion("transformcurrency in", values, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyNotIn(List<String> values) {
            addCriterion("transformcurrency not in", values, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyBetween(String value1, String value2) {
            addCriterion("transformcurrency between", value1, value2, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformcurrencyNotBetween(String value1, String value2) {
            addCriterion("transformcurrency not between", value1, value2, "transformcurrency");
            return (Criteria) this;
        }

        public Criteria andTransformrateIsNull() {
            addCriterion("transformrate is null");
            return (Criteria) this;
        }

        public Criteria andTransformrateIsNotNull() {
            addCriterion("transformrate is not null");
            return (Criteria) this;
        }

        public Criteria andTransformrateEqualTo(BigDecimal value) {
            addCriterion("transformrate =", value, "transformrate");
            return (Criteria) this;
        }

        public Criteria andTransformrateNotEqualTo(BigDecimal value) {
            addCriterion("transformrate <>", value, "transformrate");
            return (Criteria) this;
        }

        public Criteria andTransformrateGreaterThan(BigDecimal value) {
            addCriterion("transformrate >", value, "transformrate");
            return (Criteria) this;
        }

        public Criteria andTransformrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("transformrate >=", value, "transformrate");
            return (Criteria) this;
        }

        public Criteria andTransformrateLessThan(BigDecimal value) {
            addCriterion("transformrate <", value, "transformrate");
            return (Criteria) this;
        }

        public Criteria andTransformrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("transformrate <=", value, "transformrate");
            return (Criteria) this;
        }

        public Criteria andTransformrateIn(List<BigDecimal> values) {
            addCriterion("transformrate in", values, "transformrate");
            return (Criteria) this;
        }

        public Criteria andTransformrateNotIn(List<BigDecimal> values) {
            addCriterion("transformrate not in", values, "transformrate");
            return (Criteria) this;
        }

        public Criteria andTransformrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transformrate between", value1, value2, "transformrate");
            return (Criteria) this;
        }

        public Criteria andTransformrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transformrate not between", value1, value2, "transformrate");
            return (Criteria) this;
        }

        public Criteria andTransformamountIsNull() {
            addCriterion("transformamount is null");
            return (Criteria) this;
        }

        public Criteria andTransformamountIsNotNull() {
            addCriterion("transformamount is not null");
            return (Criteria) this;
        }

        public Criteria andTransformamountEqualTo(Float value) {
            addCriterion("transformamount =", value, "transformamount");
            return (Criteria) this;
        }

        public Criteria andTransformamountNotEqualTo(Float value) {
            addCriterion("transformamount <>", value, "transformamount");
            return (Criteria) this;
        }

        public Criteria andTransformamountGreaterThan(Float value) {
            addCriterion("transformamount >", value, "transformamount");
            return (Criteria) this;
        }

        public Criteria andTransformamountGreaterThanOrEqualTo(Float value) {
            addCriterion("transformamount >=", value, "transformamount");
            return (Criteria) this;
        }

        public Criteria andTransformamountLessThan(Float value) {
            addCriterion("transformamount <", value, "transformamount");
            return (Criteria) this;
        }

        public Criteria andTransformamountLessThanOrEqualTo(Float value) {
            addCriterion("transformamount <=", value, "transformamount");
            return (Criteria) this;
        }

        public Criteria andTransformamountIn(List<Float> values) {
            addCriterion("transformamount in", values, "transformamount");
            return (Criteria) this;
        }

        public Criteria andTransformamountNotIn(List<Float> values) {
            addCriterion("transformamount not in", values, "transformamount");
            return (Criteria) this;
        }

        public Criteria andTransformamountBetween(Float value1, Float value2) {
            addCriterion("transformamount between", value1, value2, "transformamount");
            return (Criteria) this;
        }

        public Criteria andTransformamountNotBetween(Float value1, Float value2) {
            addCriterion("transformamount not between", value1, value2, "transformamount");
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

        public Criteria andTradedateIsNull() {
            addCriterion("tradedate is null");
            return (Criteria) this;
        }

        public Criteria andTradedateIsNotNull() {
            addCriterion("tradedate is not null");
            return (Criteria) this;
        }

        public Criteria andTradedateEqualTo(Date value) {
            addCriterion("tradedate =", value, "tradedate");
            return (Criteria) this;
        }

        public Criteria andTradedateNotEqualTo(Date value) {
            addCriterion("tradedate <>", value, "tradedate");
            return (Criteria) this;
        }

        public Criteria andTradedateGreaterThan(Date value) {
            addCriterion("tradedate >", value, "tradedate");
            return (Criteria) this;
        }

        public Criteria andTradedateGreaterThanOrEqualTo(Date value) {
            addCriterion("tradedate >=", value, "tradedate");
            return (Criteria) this;
        }

        public Criteria andTradedateLessThan(Date value) {
            addCriterion("tradedate <", value, "tradedate");
            return (Criteria) this;
        }

        public Criteria andTradedateLessThanOrEqualTo(Date value) {
            addCriterion("tradedate <=", value, "tradedate");
            return (Criteria) this;
        }

        public Criteria andTradedateIn(List<Date> values) {
            addCriterion("tradedate in", values, "tradedate");
            return (Criteria) this;
        }

        public Criteria andTradedateNotIn(List<Date> values) {
            addCriterion("tradedate not in", values, "tradedate");
            return (Criteria) this;
        }

        public Criteria andTradedateBetween(Date value1, Date value2) {
            addCriterion("tradedate between", value1, value2, "tradedate");
            return (Criteria) this;
        }

        public Criteria andTradedateNotBetween(Date value1, Date value2) {
            addCriterion("tradedate not between", value1, value2, "tradedate");
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