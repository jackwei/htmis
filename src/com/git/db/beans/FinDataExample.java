package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FinDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinDataExample() {
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

        public Criteria andBatchNoIsNull() {
            addCriterion("Batch_No is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("Batch_No is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("Batch_No =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("Batch_No <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("Batch_No >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("Batch_No >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("Batch_No <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("Batch_No <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("Batch_No like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("Batch_No not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("Batch_No in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("Batch_No not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("Batch_No between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("Batch_No not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBussIdIsNull() {
            addCriterion("Buss_Id is null");
            return (Criteria) this;
        }

        public Criteria andBussIdIsNotNull() {
            addCriterion("Buss_Id is not null");
            return (Criteria) this;
        }

        public Criteria andBussIdEqualTo(String value) {
            addCriterion("Buss_Id =", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdNotEqualTo(String value) {
            addCriterion("Buss_Id <>", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdGreaterThan(String value) {
            addCriterion("Buss_Id >", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdGreaterThanOrEqualTo(String value) {
            addCriterion("Buss_Id >=", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdLessThan(String value) {
            addCriterion("Buss_Id <", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdLessThanOrEqualTo(String value) {
            addCriterion("Buss_Id <=", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdLike(String value) {
            addCriterion("Buss_Id like", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdNotLike(String value) {
            addCriterion("Buss_Id not like", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdIn(List<String> values) {
            addCriterion("Buss_Id in", values, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdNotIn(List<String> values) {
            addCriterion("Buss_Id not in", values, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdBetween(String value1, String value2) {
            addCriterion("Buss_Id between", value1, value2, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdNotBetween(String value1, String value2) {
            addCriterion("Buss_Id not between", value1, value2, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoIsNull() {
            addCriterion("Buss_Key_No is null");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoIsNotNull() {
            addCriterion("Buss_Key_No is not null");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoEqualTo(String value) {
            addCriterion("Buss_Key_No =", value, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoNotEqualTo(String value) {
            addCriterion("Buss_Key_No <>", value, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoGreaterThan(String value) {
            addCriterion("Buss_Key_No >", value, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoGreaterThanOrEqualTo(String value) {
            addCriterion("Buss_Key_No >=", value, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoLessThan(String value) {
            addCriterion("Buss_Key_No <", value, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoLessThanOrEqualTo(String value) {
            addCriterion("Buss_Key_No <=", value, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoLike(String value) {
            addCriterion("Buss_Key_No like", value, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoNotLike(String value) {
            addCriterion("Buss_Key_No not like", value, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoIn(List<String> values) {
            addCriterion("Buss_Key_No in", values, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoNotIn(List<String> values) {
            addCriterion("Buss_Key_No not in", values, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoBetween(String value1, String value2) {
            addCriterion("Buss_Key_No between", value1, value2, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andBussKeyNoNotBetween(String value1, String value2) {
            addCriterion("Buss_Key_No not between", value1, value2, "bussKeyNo");
            return (Criteria) this;
        }

        public Criteria andFinNoIsNull() {
            addCriterion("Fin_No is null");
            return (Criteria) this;
        }

        public Criteria andFinNoIsNotNull() {
            addCriterion("Fin_No is not null");
            return (Criteria) this;
        }

        public Criteria andFinNoEqualTo(String value) {
            addCriterion("Fin_No =", value, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoNotEqualTo(String value) {
            addCriterion("Fin_No <>", value, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoGreaterThan(String value) {
            addCriterion("Fin_No >", value, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoGreaterThanOrEqualTo(String value) {
            addCriterion("Fin_No >=", value, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoLessThan(String value) {
            addCriterion("Fin_No <", value, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoLessThanOrEqualTo(String value) {
            addCriterion("Fin_No <=", value, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoLike(String value) {
            addCriterion("Fin_No like", value, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoNotLike(String value) {
            addCriterion("Fin_No not like", value, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoIn(List<String> values) {
            addCriterion("Fin_No in", values, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoNotIn(List<String> values) {
            addCriterion("Fin_No not in", values, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoBetween(String value1, String value2) {
            addCriterion("Fin_No between", value1, value2, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNoNotBetween(String value1, String value2) {
            addCriterion("Fin_No not between", value1, value2, "finNo");
            return (Criteria) this;
        }

        public Criteria andFinNameIsNull() {
            addCriterion("Fin_Name is null");
            return (Criteria) this;
        }

        public Criteria andFinNameIsNotNull() {
            addCriterion("Fin_Name is not null");
            return (Criteria) this;
        }

        public Criteria andFinNameEqualTo(String value) {
            addCriterion("Fin_Name =", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameNotEqualTo(String value) {
            addCriterion("Fin_Name <>", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameGreaterThan(String value) {
            addCriterion("Fin_Name >", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameGreaterThanOrEqualTo(String value) {
            addCriterion("Fin_Name >=", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameLessThan(String value) {
            addCriterion("Fin_Name <", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameLessThanOrEqualTo(String value) {
            addCriterion("Fin_Name <=", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameLike(String value) {
            addCriterion("Fin_Name like", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameNotLike(String value) {
            addCriterion("Fin_Name not like", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameIn(List<String> values) {
            addCriterion("Fin_Name in", values, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameNotIn(List<String> values) {
            addCriterion("Fin_Name not in", values, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameBetween(String value1, String value2) {
            addCriterion("Fin_Name between", value1, value2, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameNotBetween(String value1, String value2) {
            addCriterion("Fin_Name not between", value1, value2, "finName");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("Money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("Money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Float value) {
            addCriterion("Money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Float value) {
            addCriterion("Money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Float value) {
            addCriterion("Money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("Money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Float value) {
            addCriterion("Money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Float value) {
            addCriterion("Money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Float> values) {
            addCriterion("Money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Float> values) {
            addCriterion("Money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Float value1, Float value2) {
            addCriterion("Money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Float value1, Float value2) {
            addCriterion("Money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("Currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("Currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("Currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("Currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("Currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("Currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("Currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("Currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("Currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("Currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("Currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("Currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("Currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("Currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andFinDateIsNull() {
            addCriterion("Fin_Date is null");
            return (Criteria) this;
        }

        public Criteria andFinDateIsNotNull() {
            addCriterion("Fin_Date is not null");
            return (Criteria) this;
        }

        public Criteria andFinDateEqualTo(Date value) {
            addCriterionForJDBCDate("Fin_Date =", value, "finDate");
            return (Criteria) this;
        }

        public Criteria andFinDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("Fin_Date <>", value, "finDate");
            return (Criteria) this;
        }

        public Criteria andFinDateGreaterThan(Date value) {
            addCriterionForJDBCDate("Fin_Date >", value, "finDate");
            return (Criteria) this;
        }

        public Criteria andFinDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Fin_Date >=", value, "finDate");
            return (Criteria) this;
        }

        public Criteria andFinDateLessThan(Date value) {
            addCriterionForJDBCDate("Fin_Date <", value, "finDate");
            return (Criteria) this;
        }

        public Criteria andFinDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Fin_Date <=", value, "finDate");
            return (Criteria) this;
        }

        public Criteria andFinDateIn(List<Date> values) {
            addCriterionForJDBCDate("Fin_Date in", values, "finDate");
            return (Criteria) this;
        }

        public Criteria andFinDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("Fin_Date not in", values, "finDate");
            return (Criteria) this;
        }

        public Criteria andFinDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Fin_Date between", value1, value2, "finDate");
            return (Criteria) this;
        }

        public Criteria andFinDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Fin_Date not between", value1, value2, "finDate");
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

        public Criteria andMakeUserIsNull() {
            addCriterion("Make_User is null");
            return (Criteria) this;
        }

        public Criteria andMakeUserIsNotNull() {
            addCriterion("Make_User is not null");
            return (Criteria) this;
        }

        public Criteria andMakeUserEqualTo(String value) {
            addCriterion("Make_User =", value, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserNotEqualTo(String value) {
            addCriterion("Make_User <>", value, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserGreaterThan(String value) {
            addCriterion("Make_User >", value, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserGreaterThanOrEqualTo(String value) {
            addCriterion("Make_User >=", value, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserLessThan(String value) {
            addCriterion("Make_User <", value, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserLessThanOrEqualTo(String value) {
            addCriterion("Make_User <=", value, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserLike(String value) {
            addCriterion("Make_User like", value, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserNotLike(String value) {
            addCriterion("Make_User not like", value, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserIn(List<String> values) {
            addCriterion("Make_User in", values, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserNotIn(List<String> values) {
            addCriterion("Make_User not in", values, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserBetween(String value1, String value2) {
            addCriterion("Make_User between", value1, value2, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeUserNotBetween(String value1, String value2) {
            addCriterion("Make_User not between", value1, value2, "makeUser");
            return (Criteria) this;
        }

        public Criteria andMakeTimeIsNull() {
            addCriterion("Make_Time is null");
            return (Criteria) this;
        }

        public Criteria andMakeTimeIsNotNull() {
            addCriterion("Make_Time is not null");
            return (Criteria) this;
        }

        public Criteria andMakeTimeEqualTo(Date value) {
            addCriterion("Make_Time =", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeNotEqualTo(Date value) {
            addCriterion("Make_Time <>", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeGreaterThan(Date value) {
            addCriterion("Make_Time >", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Make_Time >=", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeLessThan(Date value) {
            addCriterion("Make_Time <", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeLessThanOrEqualTo(Date value) {
            addCriterion("Make_Time <=", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeIn(List<Date> values) {
            addCriterion("Make_Time in", values, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeNotIn(List<Date> values) {
            addCriterion("Make_Time not in", values, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeBetween(Date value1, Date value2) {
            addCriterion("Make_Time between", value1, value2, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeNotBetween(Date value1, Date value2) {
            addCriterion("Make_Time not between", value1, value2, "makeTime");
            return (Criteria) this;
        }

        public Criteria andDealFlagIsNull() {
            addCriterion("Deal_Flag is null");
            return (Criteria) this;
        }

        public Criteria andDealFlagIsNotNull() {
            addCriterion("Deal_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andDealFlagEqualTo(String value) {
            addCriterion("Deal_Flag =", value, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagNotEqualTo(String value) {
            addCriterion("Deal_Flag <>", value, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagGreaterThan(String value) {
            addCriterion("Deal_Flag >", value, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagGreaterThanOrEqualTo(String value) {
            addCriterion("Deal_Flag >=", value, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagLessThan(String value) {
            addCriterion("Deal_Flag <", value, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagLessThanOrEqualTo(String value) {
            addCriterion("Deal_Flag <=", value, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagLike(String value) {
            addCriterion("Deal_Flag like", value, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagNotLike(String value) {
            addCriterion("Deal_Flag not like", value, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagIn(List<String> values) {
            addCriterion("Deal_Flag in", values, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagNotIn(List<String> values) {
            addCriterion("Deal_Flag not in", values, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagBetween(String value1, String value2) {
            addCriterion("Deal_Flag between", value1, value2, "dealFlag");
            return (Criteria) this;
        }

        public Criteria andDealFlagNotBetween(String value1, String value2) {
            addCriterion("Deal_Flag not between", value1, value2, "dealFlag");
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