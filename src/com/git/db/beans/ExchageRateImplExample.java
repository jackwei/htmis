package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExchageRateImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExchageRateImplExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andShortnameIsNull() {
            addCriterion("shortName is null");
            return (Criteria) this;
        }

        public Criteria andShortnameIsNotNull() {
            addCriterion("shortName is not null");
            return (Criteria) this;
        }

        public Criteria andShortnameEqualTo(String value) {
            addCriterion("shortName =", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotEqualTo(String value) {
            addCriterion("shortName <>", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameGreaterThan(String value) {
            addCriterion("shortName >", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameGreaterThanOrEqualTo(String value) {
            addCriterion("shortName >=", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLessThan(String value) {
            addCriterion("shortName <", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLessThanOrEqualTo(String value) {
            addCriterion("shortName <=", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLike(String value) {
            addCriterion("shortName like", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotLike(String value) {
            addCriterion("shortName not like", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameIn(List<String> values) {
            addCriterion("shortName in", values, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotIn(List<String> values) {
            addCriterion("shortName not in", values, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameBetween(String value1, String value2) {
            addCriterion("shortName between", value1, value2, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotBetween(String value1, String value2) {
            addCriterion("shortName not between", value1, value2, "shortname");
            return (Criteria) this;
        }

        public Criteria andRate1IsNull() {
            addCriterion("rate1 is null");
            return (Criteria) this;
        }

        public Criteria andRate1IsNotNull() {
            addCriterion("rate1 is not null");
            return (Criteria) this;
        }

        public Criteria andRate1EqualTo(String value) {
            addCriterion("rate1 =", value, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1NotEqualTo(String value) {
            addCriterion("rate1 <>", value, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1GreaterThan(String value) {
            addCriterion("rate1 >", value, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1GreaterThanOrEqualTo(String value) {
            addCriterion("rate1 >=", value, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1LessThan(String value) {
            addCriterion("rate1 <", value, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1LessThanOrEqualTo(String value) {
            addCriterion("rate1 <=", value, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1Like(String value) {
            addCriterion("rate1 like", value, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1NotLike(String value) {
            addCriterion("rate1 not like", value, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1In(List<String> values) {
            addCriterion("rate1 in", values, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1NotIn(List<String> values) {
            addCriterion("rate1 not in", values, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1Between(String value1, String value2) {
            addCriterion("rate1 between", value1, value2, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate1NotBetween(String value1, String value2) {
            addCriterion("rate1 not between", value1, value2, "rate1");
            return (Criteria) this;
        }

        public Criteria andRate2IsNull() {
            addCriterion("rate2 is null");
            return (Criteria) this;
        }

        public Criteria andRate2IsNotNull() {
            addCriterion("rate2 is not null");
            return (Criteria) this;
        }

        public Criteria andRate2EqualTo(String value) {
            addCriterion("rate2 =", value, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2NotEqualTo(String value) {
            addCriterion("rate2 <>", value, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2GreaterThan(String value) {
            addCriterion("rate2 >", value, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2GreaterThanOrEqualTo(String value) {
            addCriterion("rate2 >=", value, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2LessThan(String value) {
            addCriterion("rate2 <", value, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2LessThanOrEqualTo(String value) {
            addCriterion("rate2 <=", value, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2Like(String value) {
            addCriterion("rate2 like", value, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2NotLike(String value) {
            addCriterion("rate2 not like", value, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2In(List<String> values) {
            addCriterion("rate2 in", values, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2NotIn(List<String> values) {
            addCriterion("rate2 not in", values, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2Between(String value1, String value2) {
            addCriterion("rate2 between", value1, value2, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate2NotBetween(String value1, String value2) {
            addCriterion("rate2 not between", value1, value2, "rate2");
            return (Criteria) this;
        }

        public Criteria andRate3IsNull() {
            addCriterion("rate3 is null");
            return (Criteria) this;
        }

        public Criteria andRate3IsNotNull() {
            addCriterion("rate3 is not null");
            return (Criteria) this;
        }

        public Criteria andRate3EqualTo(String value) {
            addCriterion("rate3 =", value, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3NotEqualTo(String value) {
            addCriterion("rate3 <>", value, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3GreaterThan(String value) {
            addCriterion("rate3 >", value, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3GreaterThanOrEqualTo(String value) {
            addCriterion("rate3 >=", value, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3LessThan(String value) {
            addCriterion("rate3 <", value, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3LessThanOrEqualTo(String value) {
            addCriterion("rate3 <=", value, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3Like(String value) {
            addCriterion("rate3 like", value, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3NotLike(String value) {
            addCriterion("rate3 not like", value, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3In(List<String> values) {
            addCriterion("rate3 in", values, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3NotIn(List<String> values) {
            addCriterion("rate3 not in", values, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3Between(String value1, String value2) {
            addCriterion("rate3 between", value1, value2, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate3NotBetween(String value1, String value2) {
            addCriterion("rate3 not between", value1, value2, "rate3");
            return (Criteria) this;
        }

        public Criteria andRate4IsNull() {
            addCriterion("rate4 is null");
            return (Criteria) this;
        }

        public Criteria andRate4IsNotNull() {
            addCriterion("rate4 is not null");
            return (Criteria) this;
        }

        public Criteria andRate4EqualTo(String value) {
            addCriterion("rate4 =", value, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4NotEqualTo(String value) {
            addCriterion("rate4 <>", value, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4GreaterThan(String value) {
            addCriterion("rate4 >", value, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4GreaterThanOrEqualTo(String value) {
            addCriterion("rate4 >=", value, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4LessThan(String value) {
            addCriterion("rate4 <", value, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4LessThanOrEqualTo(String value) {
            addCriterion("rate4 <=", value, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4Like(String value) {
            addCriterion("rate4 like", value, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4NotLike(String value) {
            addCriterion("rate4 not like", value, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4In(List<String> values) {
            addCriterion("rate4 in", values, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4NotIn(List<String> values) {
            addCriterion("rate4 not in", values, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4Between(String value1, String value2) {
            addCriterion("rate4 between", value1, value2, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate4NotBetween(String value1, String value2) {
            addCriterion("rate4 not between", value1, value2, "rate4");
            return (Criteria) this;
        }

        public Criteria andRate5IsNull() {
            addCriterion("rate5 is null");
            return (Criteria) this;
        }

        public Criteria andRate5IsNotNull() {
            addCriterion("rate5 is not null");
            return (Criteria) this;
        }

        public Criteria andRate5EqualTo(String value) {
            addCriterion("rate5 =", value, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5NotEqualTo(String value) {
            addCriterion("rate5 <>", value, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5GreaterThan(String value) {
            addCriterion("rate5 >", value, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5GreaterThanOrEqualTo(String value) {
            addCriterion("rate5 >=", value, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5LessThan(String value) {
            addCriterion("rate5 <", value, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5LessThanOrEqualTo(String value) {
            addCriterion("rate5 <=", value, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5Like(String value) {
            addCriterion("rate5 like", value, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5NotLike(String value) {
            addCriterion("rate5 not like", value, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5In(List<String> values) {
            addCriterion("rate5 in", values, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5NotIn(List<String> values) {
            addCriterion("rate5 not in", values, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5Between(String value1, String value2) {
            addCriterion("rate5 between", value1, value2, "rate5");
            return (Criteria) this;
        }

        public Criteria andRate5NotBetween(String value1, String value2) {
            addCriterion("rate5 not between", value1, value2, "rate5");
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