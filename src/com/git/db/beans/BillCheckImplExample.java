package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillCheckImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillCheckImplExample() {
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

        public Criteria andCheckIdIsNull() {
            addCriterion("Check_Id is null");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNotNull() {
            addCriterion("Check_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckIdEqualTo(Long value) {
            addCriterion("Check_Id =", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotEqualTo(Long value) {
            addCriterion("Check_Id <>", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThan(Long value) {
            addCriterion("Check_Id >", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Check_Id >=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThan(Long value) {
            addCriterion("Check_Id <", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThanOrEqualTo(Long value) {
            addCriterion("Check_Id <=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdIn(List<Long> values) {
            addCriterion("Check_Id in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotIn(List<Long> values) {
            addCriterion("Check_Id not in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdBetween(Long value1, Long value2) {
            addCriterion("Check_Id between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotBetween(Long value1, Long value2) {
            addCriterion("Check_Id not between", value1, value2, "checkId");
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

        public Criteria andExpendsIsNull() {
            addCriterion("expends is null");
            return (Criteria) this;
        }

        public Criteria andExpendsIsNotNull() {
            addCriterion("expends is not null");
            return (Criteria) this;
        }

        public Criteria andExpendsEqualTo(Float value) {
            addCriterion("expends =", value, "expends");
            return (Criteria) this;
        }

        public Criteria andExpendsNotEqualTo(Float value) {
            addCriterion("expends <>", value, "expends");
            return (Criteria) this;
        }

        public Criteria andExpendsGreaterThan(Float value) {
            addCriterion("expends >", value, "expends");
            return (Criteria) this;
        }

        public Criteria andExpendsGreaterThanOrEqualTo(Float value) {
            addCriterion("expends >=", value, "expends");
            return (Criteria) this;
        }

        public Criteria andExpendsLessThan(Float value) {
            addCriterion("expends <", value, "expends");
            return (Criteria) this;
        }

        public Criteria andExpendsLessThanOrEqualTo(Float value) {
            addCriterion("expends <=", value, "expends");
            return (Criteria) this;
        }

        public Criteria andExpendsIn(List<Float> values) {
            addCriterion("expends in", values, "expends");
            return (Criteria) this;
        }

        public Criteria andExpendsNotIn(List<Float> values) {
            addCriterion("expends not in", values, "expends");
            return (Criteria) this;
        }

        public Criteria andExpendsBetween(Float value1, Float value2) {
            addCriterion("expends between", value1, value2, "expends");
            return (Criteria) this;
        }

        public Criteria andExpendsNotBetween(Float value1, Float value2) {
            addCriterion("expends not between", value1, value2, "expends");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(Float value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(Float value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(Float value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(Float value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(Float value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(Float value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<Float> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<Float> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(Float value1, Float value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(Float value1, Float value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andReplaceamountIsNull() {
            addCriterion("replaceamount is null");
            return (Criteria) this;
        }

        public Criteria andReplaceamountIsNotNull() {
            addCriterion("replaceamount is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceamountEqualTo(Float value) {
            addCriterion("replaceamount =", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountNotEqualTo(Float value) {
            addCriterion("replaceamount <>", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountGreaterThan(Float value) {
            addCriterion("replaceamount >", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountGreaterThanOrEqualTo(Float value) {
            addCriterion("replaceamount >=", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountLessThan(Float value) {
            addCriterion("replaceamount <", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountLessThanOrEqualTo(Float value) {
            addCriterion("replaceamount <=", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountIn(List<Float> values) {
            addCriterion("replaceamount in", values, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountNotIn(List<Float> values) {
            addCriterion("replaceamount not in", values, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountBetween(Float value1, Float value2) {
            addCriterion("replaceamount between", value1, value2, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountNotBetween(Float value1, Float value2) {
            addCriterion("replaceamount not between", value1, value2, "replaceamount");
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

        public Criteria andFeenumIsNull() {
            addCriterion("feenum is null");
            return (Criteria) this;
        }

        public Criteria andFeenumIsNotNull() {
            addCriterion("feenum is not null");
            return (Criteria) this;
        }

        public Criteria andFeenumEqualTo(String value) {
            addCriterion("feenum =", value, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumNotEqualTo(String value) {
            addCriterion("feenum <>", value, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumGreaterThan(String value) {
            addCriterion("feenum >", value, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumGreaterThanOrEqualTo(String value) {
            addCriterion("feenum >=", value, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumLessThan(String value) {
            addCriterion("feenum <", value, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumLessThanOrEqualTo(String value) {
            addCriterion("feenum <=", value, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumLike(String value) {
            addCriterion("feenum like", value, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumNotLike(String value) {
            addCriterion("feenum not like", value, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumIn(List<String> values) {
            addCriterion("feenum in", values, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumNotIn(List<String> values) {
            addCriterion("feenum not in", values, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumBetween(String value1, String value2) {
            addCriterion("feenum between", value1, value2, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeenumNotBetween(String value1, String value2) {
            addCriterion("feenum not between", value1, value2, "feenum");
            return (Criteria) this;
        }

        public Criteria andFeeidIsNull() {
            addCriterion("feeid is null");
            return (Criteria) this;
        }

        public Criteria andFeeidIsNotNull() {
            addCriterion("feeid is not null");
            return (Criteria) this;
        }

        public Criteria andFeeidEqualTo(String value) {
            addCriterion("feeid =", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidNotEqualTo(String value) {
            addCriterion("feeid <>", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidGreaterThan(String value) {
            addCriterion("feeid >", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidGreaterThanOrEqualTo(String value) {
            addCriterion("feeid >=", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidLessThan(String value) {
            addCriterion("feeid <", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidLessThanOrEqualTo(String value) {
            addCriterion("feeid <=", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidLike(String value) {
            addCriterion("feeid like", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidNotLike(String value) {
            addCriterion("feeid not like", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidIn(List<String> values) {
            addCriterion("feeid in", values, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidNotIn(List<String> values) {
            addCriterion("feeid not in", values, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidBetween(String value1, String value2) {
            addCriterion("feeid between", value1, value2, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidNotBetween(String value1, String value2) {
            addCriterion("feeid not between", value1, value2, "feeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNull() {
            addCriterion("biztype is null");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNotNull() {
            addCriterion("biztype is not null");
            return (Criteria) this;
        }

        public Criteria andBiztypeEqualTo(String value) {
            addCriterion("biztype =", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotEqualTo(String value) {
            addCriterion("biztype <>", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThan(String value) {
            addCriterion("biztype >", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThanOrEqualTo(String value) {
            addCriterion("biztype >=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThan(String value) {
            addCriterion("biztype <", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThanOrEqualTo(String value) {
            addCriterion("biztype <=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLike(String value) {
            addCriterion("biztype like", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotLike(String value) {
            addCriterion("biztype not like", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeIn(List<String> values) {
            addCriterion("biztype in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotIn(List<String> values) {
            addCriterion("biztype not in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeBetween(String value1, String value2) {
            addCriterion("biztype between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotBetween(String value1, String value2) {
            addCriterion("biztype not between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeidIsNull() {
            addCriterion("biztypeid is null");
            return (Criteria) this;
        }

        public Criteria andBiztypeidIsNotNull() {
            addCriterion("biztypeid is not null");
            return (Criteria) this;
        }

        public Criteria andBiztypeidEqualTo(String value) {
            addCriterion("biztypeid =", value, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidNotEqualTo(String value) {
            addCriterion("biztypeid <>", value, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidGreaterThan(String value) {
            addCriterion("biztypeid >", value, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidGreaterThanOrEqualTo(String value) {
            addCriterion("biztypeid >=", value, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidLessThan(String value) {
            addCriterion("biztypeid <", value, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidLessThanOrEqualTo(String value) {
            addCriterion("biztypeid <=", value, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidLike(String value) {
            addCriterion("biztypeid like", value, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidNotLike(String value) {
            addCriterion("biztypeid not like", value, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidIn(List<String> values) {
            addCriterion("biztypeid in", values, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidNotIn(List<String> values) {
            addCriterion("biztypeid not in", values, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidBetween(String value1, String value2) {
            addCriterion("biztypeid between", value1, value2, "biztypeid");
            return (Criteria) this;
        }

        public Criteria andBiztypeidNotBetween(String value1, String value2) {
            addCriterion("biztypeid not between", value1, value2, "biztypeid");
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

        public Criteria andChangedateIsNull() {
            addCriterion("changedate is null");
            return (Criteria) this;
        }

        public Criteria andChangedateIsNotNull() {
            addCriterion("changedate is not null");
            return (Criteria) this;
        }

        public Criteria andChangedateEqualTo(Date value) {
            addCriterion("changedate =", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateNotEqualTo(Date value) {
            addCriterion("changedate <>", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateGreaterThan(Date value) {
            addCriterion("changedate >", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateGreaterThanOrEqualTo(Date value) {
            addCriterion("changedate >=", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateLessThan(Date value) {
            addCriterion("changedate <", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateLessThanOrEqualTo(Date value) {
            addCriterion("changedate <=", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateIn(List<Date> values) {
            addCriterion("changedate in", values, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateNotIn(List<Date> values) {
            addCriterion("changedate not in", values, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateBetween(Date value1, Date value2) {
            addCriterion("changedate between", value1, value2, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateNotBetween(Date value1, Date value2) {
            addCriterion("changedate not between", value1, value2, "changedate");
            return (Criteria) this;
        }

        public Criteria andPrintdateIsNull() {
            addCriterion("printdate is null");
            return (Criteria) this;
        }

        public Criteria andPrintdateIsNotNull() {
            addCriterion("printdate is not null");
            return (Criteria) this;
        }

        public Criteria andPrintdateEqualTo(Date value) {
            addCriterion("printdate =", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateNotEqualTo(Date value) {
            addCriterion("printdate <>", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateGreaterThan(Date value) {
            addCriterion("printdate >", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateGreaterThanOrEqualTo(Date value) {
            addCriterion("printdate >=", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateLessThan(Date value) {
            addCriterion("printdate <", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateLessThanOrEqualTo(Date value) {
            addCriterion("printdate <=", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateIn(List<Date> values) {
            addCriterion("printdate in", values, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateNotIn(List<Date> values) {
            addCriterion("printdate not in", values, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateBetween(Date value1, Date value2) {
            addCriterion("printdate between", value1, value2, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateNotBetween(Date value1, Date value2) {
            addCriterion("printdate not between", value1, value2, "printdate");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
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

        public Criteria andCheckamountIsNull() {
            addCriterion("checkamount is null");
            return (Criteria) this;
        }

        public Criteria andCheckamountIsNotNull() {
            addCriterion("checkamount is not null");
            return (Criteria) this;
        }

        public Criteria andCheckamountEqualTo(Float value) {
            addCriterion("checkamount =", value, "checkamount");
            return (Criteria) this;
        }

        public Criteria andCheckamountNotEqualTo(Float value) {
            addCriterion("checkamount <>", value, "checkamount");
            return (Criteria) this;
        }

        public Criteria andCheckamountGreaterThan(Float value) {
            addCriterion("checkamount >", value, "checkamount");
            return (Criteria) this;
        }

        public Criteria andCheckamountGreaterThanOrEqualTo(Float value) {
            addCriterion("checkamount >=", value, "checkamount");
            return (Criteria) this;
        }

        public Criteria andCheckamountLessThan(Float value) {
            addCriterion("checkamount <", value, "checkamount");
            return (Criteria) this;
        }

        public Criteria andCheckamountLessThanOrEqualTo(Float value) {
            addCriterion("checkamount <=", value, "checkamount");
            return (Criteria) this;
        }

        public Criteria andCheckamountIn(List<Float> values) {
            addCriterion("checkamount in", values, "checkamount");
            return (Criteria) this;
        }

        public Criteria andCheckamountNotIn(List<Float> values) {
            addCriterion("checkamount not in", values, "checkamount");
            return (Criteria) this;
        }

        public Criteria andCheckamountBetween(Float value1, Float value2) {
            addCriterion("checkamount between", value1, value2, "checkamount");
            return (Criteria) this;
        }

        public Criteria andCheckamountNotBetween(Float value1, Float value2) {
            addCriterion("checkamount not between", value1, value2, "checkamount");
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