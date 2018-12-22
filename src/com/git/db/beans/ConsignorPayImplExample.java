package com.git.db.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsignorPayImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsignorPayImplExample() {
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

        public Criteria andPayIdIsNull() {
            addCriterion("Pay_Id is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("Pay_Id is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(Long value) {
            addCriterion("Pay_Id =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(Long value) {
            addCriterion("Pay_Id <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(Long value) {
            addCriterion("Pay_Id >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Pay_Id >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(Long value) {
            addCriterion("Pay_Id <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(Long value) {
            addCriterion("Pay_Id <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<Long> values) {
            addCriterion("Pay_Id in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<Long> values) {
            addCriterion("Pay_Id not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(Long value1, Long value2) {
            addCriterion("Pay_Id between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(Long value1, Long value2) {
            addCriterion("Pay_Id not between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayeenameIsNull() {
            addCriterion("payeename is null");
            return (Criteria) this;
        }

        public Criteria andPayeenameIsNotNull() {
            addCriterion("payeename is not null");
            return (Criteria) this;
        }

        public Criteria andPayeenameEqualTo(String value) {
            addCriterion("payeename =", value, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameNotEqualTo(String value) {
            addCriterion("payeename <>", value, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameGreaterThan(String value) {
            addCriterion("payeename >", value, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameGreaterThanOrEqualTo(String value) {
            addCriterion("payeename >=", value, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameLessThan(String value) {
            addCriterion("payeename <", value, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameLessThanOrEqualTo(String value) {
            addCriterion("payeename <=", value, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameLike(String value) {
            addCriterion("payeename like", value, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameNotLike(String value) {
            addCriterion("payeename not like", value, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameIn(List<String> values) {
            addCriterion("payeename in", values, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameNotIn(List<String> values) {
            addCriterion("payeename not in", values, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameBetween(String value1, String value2) {
            addCriterion("payeename between", value1, value2, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeenameNotBetween(String value1, String value2) {
            addCriterion("payeename not between", value1, value2, "payeename");
            return (Criteria) this;
        }

        public Criteria andPayeeidIsNull() {
            addCriterion("payeeid is null");
            return (Criteria) this;
        }

        public Criteria andPayeeidIsNotNull() {
            addCriterion("payeeid is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeidEqualTo(String value) {
            addCriterion("payeeid =", value, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidNotEqualTo(String value) {
            addCriterion("payeeid <>", value, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidGreaterThan(String value) {
            addCriterion("payeeid >", value, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidGreaterThanOrEqualTo(String value) {
            addCriterion("payeeid >=", value, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidLessThan(String value) {
            addCriterion("payeeid <", value, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidLessThanOrEqualTo(String value) {
            addCriterion("payeeid <=", value, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidLike(String value) {
            addCriterion("payeeid like", value, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidNotLike(String value) {
            addCriterion("payeeid not like", value, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidIn(List<String> values) {
            addCriterion("payeeid in", values, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidNotIn(List<String> values) {
            addCriterion("payeeid not in", values, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidBetween(String value1, String value2) {
            addCriterion("payeeid between", value1, value2, "payeeid");
            return (Criteria) this;
        }

        public Criteria andPayeeidNotBetween(String value1, String value2) {
            addCriterion("payeeid not between", value1, value2, "payeeid");
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

        public Criteria andPayeeaccountnumIsNull() {
            addCriterion("payeeaccountnum is null");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumIsNotNull() {
            addCriterion("payeeaccountnum is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumEqualTo(String value) {
            addCriterion("payeeaccountnum =", value, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumNotEqualTo(String value) {
            addCriterion("payeeaccountnum <>", value, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumGreaterThan(String value) {
            addCriterion("payeeaccountnum >", value, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumGreaterThanOrEqualTo(String value) {
            addCriterion("payeeaccountnum >=", value, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumLessThan(String value) {
            addCriterion("payeeaccountnum <", value, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumLessThanOrEqualTo(String value) {
            addCriterion("payeeaccountnum <=", value, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumLike(String value) {
            addCriterion("payeeaccountnum like", value, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumNotLike(String value) {
            addCriterion("payeeaccountnum not like", value, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumIn(List<String> values) {
            addCriterion("payeeaccountnum in", values, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumNotIn(List<String> values) {
            addCriterion("payeeaccountnum not in", values, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumBetween(String value1, String value2) {
            addCriterion("payeeaccountnum between", value1, value2, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnumNotBetween(String value1, String value2) {
            addCriterion("payeeaccountnum not between", value1, value2, "payeeaccountnum");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameIsNull() {
            addCriterion("payeeaccountname is null");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameIsNotNull() {
            addCriterion("payeeaccountname is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameEqualTo(String value) {
            addCriterion("payeeaccountname =", value, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameNotEqualTo(String value) {
            addCriterion("payeeaccountname <>", value, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameGreaterThan(String value) {
            addCriterion("payeeaccountname >", value, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameGreaterThanOrEqualTo(String value) {
            addCriterion("payeeaccountname >=", value, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameLessThan(String value) {
            addCriterion("payeeaccountname <", value, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameLessThanOrEqualTo(String value) {
            addCriterion("payeeaccountname <=", value, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameLike(String value) {
            addCriterion("payeeaccountname like", value, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameNotLike(String value) {
            addCriterion("payeeaccountname not like", value, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameIn(List<String> values) {
            addCriterion("payeeaccountname in", values, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameNotIn(List<String> values) {
            addCriterion("payeeaccountname not in", values, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameBetween(String value1, String value2) {
            addCriterion("payeeaccountname between", value1, value2, "payeeaccountname");
            return (Criteria) this;
        }

        public Criteria andPayeeaccountnameNotBetween(String value1, String value2) {
            addCriterion("payeeaccountname not between", value1, value2, "payeeaccountname");
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

        public Criteria andOrgidIsNull() {
            addCriterion("orgid is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("orgid is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(String value) {
            addCriterion("orgid =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(String value) {
            addCriterion("orgid <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(String value) {
            addCriterion("orgid >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(String value) {
            addCriterion("orgid >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(String value) {
            addCriterion("orgid <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(String value) {
            addCriterion("orgid <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLike(String value) {
            addCriterion("orgid like", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotLike(String value) {
            addCriterion("orgid not like", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(List<String> values) {
            addCriterion("orgid in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(List<String> values) {
            addCriterion("orgid not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(String value1, String value2) {
            addCriterion("orgid between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(String value1, String value2) {
            addCriterion("orgid not between", value1, value2, "orgid");
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

        public Criteria andOrgidbIsNull() {
            addCriterion("orgidb is null");
            return (Criteria) this;
        }

        public Criteria andOrgidbIsNotNull() {
            addCriterion("orgidb is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidbEqualTo(String value) {
            addCriterion("orgidb =", value, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbNotEqualTo(String value) {
            addCriterion("orgidb <>", value, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbGreaterThan(String value) {
            addCriterion("orgidb >", value, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbGreaterThanOrEqualTo(String value) {
            addCriterion("orgidb >=", value, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbLessThan(String value) {
            addCriterion("orgidb <", value, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbLessThanOrEqualTo(String value) {
            addCriterion("orgidb <=", value, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbLike(String value) {
            addCriterion("orgidb like", value, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbNotLike(String value) {
            addCriterion("orgidb not like", value, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbIn(List<String> values) {
            addCriterion("orgidb in", values, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbNotIn(List<String> values) {
            addCriterion("orgidb not in", values, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbBetween(String value1, String value2) {
            addCriterion("orgidb between", value1, value2, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgidbNotBetween(String value1, String value2) {
            addCriterion("orgidb not between", value1, value2, "orgidb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebIsNull() {
            addCriterion("orgnameb is null");
            return (Criteria) this;
        }

        public Criteria andOrgnamebIsNotNull() {
            addCriterion("orgnameb is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnamebEqualTo(String value) {
            addCriterion("orgnameb =", value, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebNotEqualTo(String value) {
            addCriterion("orgnameb <>", value, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebGreaterThan(String value) {
            addCriterion("orgnameb >", value, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebGreaterThanOrEqualTo(String value) {
            addCriterion("orgnameb >=", value, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebLessThan(String value) {
            addCriterion("orgnameb <", value, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebLessThanOrEqualTo(String value) {
            addCriterion("orgnameb <=", value, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebLike(String value) {
            addCriterion("orgnameb like", value, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebNotLike(String value) {
            addCriterion("orgnameb not like", value, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebIn(List<String> values) {
            addCriterion("orgnameb in", values, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebNotIn(List<String> values) {
            addCriterion("orgnameb not in", values, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebBetween(String value1, String value2) {
            addCriterion("orgnameb between", value1, value2, "orgnameb");
            return (Criteria) this;
        }

        public Criteria andOrgnamebNotBetween(String value1, String value2) {
            addCriterion("orgnameb not between", value1, value2, "orgnameb");
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

        public Criteria andUseridnameIsNull() {
            addCriterion("useridname is null");
            return (Criteria) this;
        }

        public Criteria andUseridnameIsNotNull() {
            addCriterion("useridname is not null");
            return (Criteria) this;
        }

        public Criteria andUseridnameEqualTo(String value) {
            addCriterion("useridname =", value, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameNotEqualTo(String value) {
            addCriterion("useridname <>", value, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameGreaterThan(String value) {
            addCriterion("useridname >", value, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameGreaterThanOrEqualTo(String value) {
            addCriterion("useridname >=", value, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameLessThan(String value) {
            addCriterion("useridname <", value, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameLessThanOrEqualTo(String value) {
            addCriterion("useridname <=", value, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameLike(String value) {
            addCriterion("useridname like", value, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameNotLike(String value) {
            addCriterion("useridname not like", value, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameIn(List<String> values) {
            addCriterion("useridname in", values, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameNotIn(List<String> values) {
            addCriterion("useridname not in", values, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameBetween(String value1, String value2) {
            addCriterion("useridname between", value1, value2, "useridname");
            return (Criteria) this;
        }

        public Criteria andUseridnameNotBetween(String value1, String value2) {
            addCriterion("useridname not between", value1, value2, "useridname");
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

        public Criteria andBinddetailIsNull() {
            addCriterion("binddetail is null");
            return (Criteria) this;
        }

        public Criteria andBinddetailIsNotNull() {
            addCriterion("binddetail is not null");
            return (Criteria) this;
        }

        public Criteria andBinddetailEqualTo(String value) {
            addCriterion("binddetail =", value, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailNotEqualTo(String value) {
            addCriterion("binddetail <>", value, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailGreaterThan(String value) {
            addCriterion("binddetail >", value, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailGreaterThanOrEqualTo(String value) {
            addCriterion("binddetail >=", value, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailLessThan(String value) {
            addCriterion("binddetail <", value, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailLessThanOrEqualTo(String value) {
            addCriterion("binddetail <=", value, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailLike(String value) {
            addCriterion("binddetail like", value, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailNotLike(String value) {
            addCriterion("binddetail not like", value, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailIn(List<String> values) {
            addCriterion("binddetail in", values, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailNotIn(List<String> values) {
            addCriterion("binddetail not in", values, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailBetween(String value1, String value2) {
            addCriterion("binddetail between", value1, value2, "binddetail");
            return (Criteria) this;
        }

        public Criteria andBinddetailNotBetween(String value1, String value2) {
            addCriterion("binddetail not between", value1, value2, "binddetail");
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

        public Criteria andPaystatusIsNull() {
            addCriterion("paystatus is null");
            return (Criteria) this;
        }

        public Criteria andPaystatusIsNotNull() {
            addCriterion("paystatus is not null");
            return (Criteria) this;
        }

        public Criteria andPaystatusEqualTo(String value) {
            addCriterion("paystatus =", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotEqualTo(String value) {
            addCriterion("paystatus <>", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusGreaterThan(String value) {
            addCriterion("paystatus >", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusGreaterThanOrEqualTo(String value) {
            addCriterion("paystatus >=", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLessThan(String value) {
            addCriterion("paystatus <", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLessThanOrEqualTo(String value) {
            addCriterion("paystatus <=", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLike(String value) {
            addCriterion("paystatus like", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotLike(String value) {
            addCriterion("paystatus not like", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusIn(List<String> values) {
            addCriterion("paystatus in", values, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotIn(List<String> values) {
            addCriterion("paystatus not in", values, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusBetween(String value1, String value2) {
            addCriterion("paystatus between", value1, value2, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotBetween(String value1, String value2) {
            addCriterion("paystatus not between", value1, value2, "paystatus");
            return (Criteria) this;
        }

        public Criteria andRmbrateIsNull() {
            addCriterion("rmbrate is null");
            return (Criteria) this;
        }

        public Criteria andRmbrateIsNotNull() {
            addCriterion("rmbrate is not null");
            return (Criteria) this;
        }

        public Criteria andRmbrateEqualTo(BigDecimal value) {
            addCriterion("rmbrate =", value, "rmbrate");
            return (Criteria) this;
        }

        public Criteria andRmbrateNotEqualTo(BigDecimal value) {
            addCriterion("rmbrate <>", value, "rmbrate");
            return (Criteria) this;
        }

        public Criteria andRmbrateGreaterThan(BigDecimal value) {
            addCriterion("rmbrate >", value, "rmbrate");
            return (Criteria) this;
        }

        public Criteria andRmbrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rmbrate >=", value, "rmbrate");
            return (Criteria) this;
        }

        public Criteria andRmbrateLessThan(BigDecimal value) {
            addCriterion("rmbrate <", value, "rmbrate");
            return (Criteria) this;
        }

        public Criteria andRmbrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rmbrate <=", value, "rmbrate");
            return (Criteria) this;
        }

        public Criteria andRmbrateIn(List<BigDecimal> values) {
            addCriterion("rmbrate in", values, "rmbrate");
            return (Criteria) this;
        }

        public Criteria andRmbrateNotIn(List<BigDecimal> values) {
            addCriterion("rmbrate not in", values, "rmbrate");
            return (Criteria) this;
        }

        public Criteria andRmbrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rmbrate between", value1, value2, "rmbrate");
            return (Criteria) this;
        }

        public Criteria andRmbrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rmbrate not between", value1, value2, "rmbrate");
            return (Criteria) this;
        }

        public Criteria andRmbamountIsNull() {
            addCriterion("rmbamount is null");
            return (Criteria) this;
        }

        public Criteria andRmbamountIsNotNull() {
            addCriterion("rmbamount is not null");
            return (Criteria) this;
        }

        public Criteria andRmbamountEqualTo(Float value) {
            addCriterion("rmbamount =", value, "rmbamount");
            return (Criteria) this;
        }

        public Criteria andRmbamountNotEqualTo(Float value) {
            addCriterion("rmbamount <>", value, "rmbamount");
            return (Criteria) this;
        }

        public Criteria andRmbamountGreaterThan(Float value) {
            addCriterion("rmbamount >", value, "rmbamount");
            return (Criteria) this;
        }

        public Criteria andRmbamountGreaterThanOrEqualTo(Float value) {
            addCriterion("rmbamount >=", value, "rmbamount");
            return (Criteria) this;
        }

        public Criteria andRmbamountLessThan(Float value) {
            addCriterion("rmbamount <", value, "rmbamount");
            return (Criteria) this;
        }

        public Criteria andRmbamountLessThanOrEqualTo(Float value) {
            addCriterion("rmbamount <=", value, "rmbamount");
            return (Criteria) this;
        }

        public Criteria andRmbamountIn(List<Float> values) {
            addCriterion("rmbamount in", values, "rmbamount");
            return (Criteria) this;
        }

        public Criteria andRmbamountNotIn(List<Float> values) {
            addCriterion("rmbamount not in", values, "rmbamount");
            return (Criteria) this;
        }

        public Criteria andRmbamountBetween(Float value1, Float value2) {
            addCriterion("rmbamount between", value1, value2, "rmbamount");
            return (Criteria) this;
        }

        public Criteria andRmbamountNotBetween(Float value1, Float value2) {
            addCriterion("rmbamount not between", value1, value2, "rmbamount");
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