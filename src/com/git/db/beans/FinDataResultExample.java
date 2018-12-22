package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FinDataResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinDataResultExample() {
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

        public Criteria andSeqIdIsNull() {
            addCriterion("Seq_Id is null");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNotNull() {
            addCriterion("Seq_Id is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIdEqualTo(Long value) {
            addCriterion("Seq_Id =", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotEqualTo(Long value) {
            addCriterion("Seq_Id <>", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThan(Long value) {
            addCriterion("Seq_Id >", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Seq_Id >=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThan(Long value) {
            addCriterion("Seq_Id <", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThanOrEqualTo(Long value) {
            addCriterion("Seq_Id <=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdIn(List<Long> values) {
            addCriterion("Seq_Id in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotIn(List<Long> values) {
            addCriterion("Seq_Id not in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdBetween(Long value1, Long value2) {
            addCriterion("Seq_Id between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotBetween(Long value1, Long value2) {
            addCriterion("Seq_Id not between", value1, value2, "seqId");
            return (Criteria) this;
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

        public Criteria andItemIdIsNull() {
            addCriterion("Item_Id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("Item_Id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("Item_Id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("Item_Id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("Item_Id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("Item_Id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("Item_Id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("Item_Id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("Item_Id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("Item_Id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("Item_Id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("Item_Id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("Item_Id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("Item_Id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("Item_Name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("Item_Name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("Item_Name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("Item_Name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("Item_Name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("Item_Name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("Item_Name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("Item_Name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("Item_Name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("Item_Name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("Item_Name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("Item_Name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("Item_Name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("Item_Name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("Item_Type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("Item_Type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(String value) {
            addCriterion("Item_Type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(String value) {
            addCriterion("Item_Type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(String value) {
            addCriterion("Item_Type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Item_Type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(String value) {
            addCriterion("Item_Type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(String value) {
            addCriterion("Item_Type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLike(String value) {
            addCriterion("Item_Type like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotLike(String value) {
            addCriterion("Item_Type not like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<String> values) {
            addCriterion("Item_Type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<String> values) {
            addCriterion("Item_Type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(String value1, String value2) {
            addCriterion("Item_Type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(String value1, String value2) {
            addCriterion("Item_Type not between", value1, value2, "itemType");
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

        public Criteria andOrgCodeIsNull() {
            addCriterion("Org_Code is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("Org_Code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("Org_Code =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("Org_Code <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("Org_Code >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Org_Code >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("Org_Code <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("Org_Code <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("Org_Code like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("Org_Code not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("Org_Code in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("Org_Code not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("Org_Code between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("Org_Code not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andComCodeIsNull() {
            addCriterion("Com_Code is null");
            return (Criteria) this;
        }

        public Criteria andComCodeIsNotNull() {
            addCriterion("Com_Code is not null");
            return (Criteria) this;
        }

        public Criteria andComCodeEqualTo(String value) {
            addCriterion("Com_Code =", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotEqualTo(String value) {
            addCriterion("Com_Code <>", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeGreaterThan(String value) {
            addCriterion("Com_Code >", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Com_Code >=", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLessThan(String value) {
            addCriterion("Com_Code <", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLessThanOrEqualTo(String value) {
            addCriterion("Com_Code <=", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLike(String value) {
            addCriterion("Com_Code like", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotLike(String value) {
            addCriterion("Com_Code not like", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeIn(List<String> values) {
            addCriterion("Com_Code in", values, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotIn(List<String> values) {
            addCriterion("Com_Code not in", values, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeBetween(String value1, String value2) {
            addCriterion("Com_Code between", value1, value2, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotBetween(String value1, String value2) {
            addCriterion("Com_Code not between", value1, value2, "comCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIsNull() {
            addCriterion("Dept_Code is null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIsNotNull() {
            addCriterion("Dept_Code is not null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeEqualTo(String value) {
            addCriterion("Dept_Code =", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotEqualTo(String value) {
            addCriterion("Dept_Code <>", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThan(String value) {
            addCriterion("Dept_Code >", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Dept_Code >=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThan(String value) {
            addCriterion("Dept_Code <", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThanOrEqualTo(String value) {
            addCriterion("Dept_Code <=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLike(String value) {
            addCriterion("Dept_Code like", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotLike(String value) {
            addCriterion("Dept_Code not like", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIn(List<String> values) {
            addCriterion("Dept_Code in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotIn(List<String> values) {
            addCriterion("Dept_Code not in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeBetween(String value1, String value2) {
            addCriterion("Dept_Code between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotBetween(String value1, String value2) {
            addCriterion("Dept_Code not between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNull() {
            addCriterion("Bank_Code is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("Bank_Code is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("Bank_Code =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("Bank_Code <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("Bank_Code >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Bank_Code >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("Bank_Code <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("Bank_Code <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("Bank_Code like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("Bank_Code not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("Bank_Code in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("Bank_Code not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("Bank_Code between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("Bank_Code not between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeIsNull() {
            addCriterion("Buss_Code is null");
            return (Criteria) this;
        }

        public Criteria andBussCodeIsNotNull() {
            addCriterion("Buss_Code is not null");
            return (Criteria) this;
        }

        public Criteria andBussCodeEqualTo(String value) {
            addCriterion("Buss_Code =", value, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeNotEqualTo(String value) {
            addCriterion("Buss_Code <>", value, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeGreaterThan(String value) {
            addCriterion("Buss_Code >", value, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Buss_Code >=", value, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeLessThan(String value) {
            addCriterion("Buss_Code <", value, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeLessThanOrEqualTo(String value) {
            addCriterion("Buss_Code <=", value, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeLike(String value) {
            addCriterion("Buss_Code like", value, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeNotLike(String value) {
            addCriterion("Buss_Code not like", value, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeIn(List<String> values) {
            addCriterion("Buss_Code in", values, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeNotIn(List<String> values) {
            addCriterion("Buss_Code not in", values, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeBetween(String value1, String value2) {
            addCriterion("Buss_Code between", value1, value2, "bussCode");
            return (Criteria) this;
        }

        public Criteria andBussCodeNotBetween(String value1, String value2) {
            addCriterion("Buss_Code not between", value1, value2, "bussCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("Product_Code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("Product_Code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("Product_Code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("Product_Code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("Product_Code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Product_Code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("Product_Code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("Product_Code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("Product_Code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("Product_Code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("Product_Code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("Product_Code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("Product_Code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("Product_Code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeIsNull() {
            addCriterion("Trans_Code is null");
            return (Criteria) this;
        }

        public Criteria andTransCodeIsNotNull() {
            addCriterion("Trans_Code is not null");
            return (Criteria) this;
        }

        public Criteria andTransCodeEqualTo(String value) {
            addCriterion("Trans_Code =", value, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeNotEqualTo(String value) {
            addCriterion("Trans_Code <>", value, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeGreaterThan(String value) {
            addCriterion("Trans_Code >", value, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Trans_Code >=", value, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeLessThan(String value) {
            addCriterion("Trans_Code <", value, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeLessThanOrEqualTo(String value) {
            addCriterion("Trans_Code <=", value, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeLike(String value) {
            addCriterion("Trans_Code like", value, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeNotLike(String value) {
            addCriterion("Trans_Code not like", value, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeIn(List<String> values) {
            addCriterion("Trans_Code in", values, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeNotIn(List<String> values) {
            addCriterion("Trans_Code not in", values, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeBetween(String value1, String value2) {
            addCriterion("Trans_Code between", value1, value2, "transCode");
            return (Criteria) this;
        }

        public Criteria andTransCodeNotBetween(String value1, String value2) {
            addCriterion("Trans_Code not between", value1, value2, "transCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeIsNull() {
            addCriterion("Backup_Code is null");
            return (Criteria) this;
        }

        public Criteria andBackupCodeIsNotNull() {
            addCriterion("Backup_Code is not null");
            return (Criteria) this;
        }

        public Criteria andBackupCodeEqualTo(String value) {
            addCriterion("Backup_Code =", value, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeNotEqualTo(String value) {
            addCriterion("Backup_Code <>", value, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeGreaterThan(String value) {
            addCriterion("Backup_Code >", value, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Backup_Code >=", value, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeLessThan(String value) {
            addCriterion("Backup_Code <", value, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeLessThanOrEqualTo(String value) {
            addCriterion("Backup_Code <=", value, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeLike(String value) {
            addCriterion("Backup_Code like", value, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeNotLike(String value) {
            addCriterion("Backup_Code not like", value, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeIn(List<String> values) {
            addCriterion("Backup_Code in", values, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeNotIn(List<String> values) {
            addCriterion("Backup_Code not in", values, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeBetween(String value1, String value2) {
            addCriterion("Backup_Code between", value1, value2, "backupCode");
            return (Criteria) this;
        }

        public Criteria andBackupCodeNotBetween(String value1, String value2) {
            addCriterion("Backup_Code not between", value1, value2, "backupCode");
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

        public Criteria andStandbynum1IsNull() {
            addCriterion("StandByNum1 is null");
            return (Criteria) this;
        }

        public Criteria andStandbynum1IsNotNull() {
            addCriterion("StandByNum1 is not null");
            return (Criteria) this;
        }

        public Criteria andStandbynum1EqualTo(Float value) {
            addCriterion("StandByNum1 =", value, "standbynum1");
            return (Criteria) this;
        }

        public Criteria andStandbynum1NotEqualTo(Float value) {
            addCriterion("StandByNum1 <>", value, "standbynum1");
            return (Criteria) this;
        }

        public Criteria andStandbynum1GreaterThan(Float value) {
            addCriterion("StandByNum1 >", value, "standbynum1");
            return (Criteria) this;
        }

        public Criteria andStandbynum1GreaterThanOrEqualTo(Float value) {
            addCriterion("StandByNum1 >=", value, "standbynum1");
            return (Criteria) this;
        }

        public Criteria andStandbynum1LessThan(Float value) {
            addCriterion("StandByNum1 <", value, "standbynum1");
            return (Criteria) this;
        }

        public Criteria andStandbynum1LessThanOrEqualTo(Float value) {
            addCriterion("StandByNum1 <=", value, "standbynum1");
            return (Criteria) this;
        }

        public Criteria andStandbynum1In(List<Float> values) {
            addCriterion("StandByNum1 in", values, "standbynum1");
            return (Criteria) this;
        }

        public Criteria andStandbynum1NotIn(List<Float> values) {
            addCriterion("StandByNum1 not in", values, "standbynum1");
            return (Criteria) this;
        }

        public Criteria andStandbynum1Between(Float value1, Float value2) {
            addCriterion("StandByNum1 between", value1, value2, "standbynum1");
            return (Criteria) this;
        }

        public Criteria andStandbynum1NotBetween(Float value1, Float value2) {
            addCriterion("StandByNum1 not between", value1, value2, "standbynum1");
            return (Criteria) this;
        }

        public Criteria andStandbynum2IsNull() {
            addCriterion("StandByNum2 is null");
            return (Criteria) this;
        }

        public Criteria andStandbynum2IsNotNull() {
            addCriterion("StandByNum2 is not null");
            return (Criteria) this;
        }

        public Criteria andStandbynum2EqualTo(Float value) {
            addCriterion("StandByNum2 =", value, "standbynum2");
            return (Criteria) this;
        }

        public Criteria andStandbynum2NotEqualTo(Float value) {
            addCriterion("StandByNum2 <>", value, "standbynum2");
            return (Criteria) this;
        }

        public Criteria andStandbynum2GreaterThan(Float value) {
            addCriterion("StandByNum2 >", value, "standbynum2");
            return (Criteria) this;
        }

        public Criteria andStandbynum2GreaterThanOrEqualTo(Float value) {
            addCriterion("StandByNum2 >=", value, "standbynum2");
            return (Criteria) this;
        }

        public Criteria andStandbynum2LessThan(Float value) {
            addCriterion("StandByNum2 <", value, "standbynum2");
            return (Criteria) this;
        }

        public Criteria andStandbynum2LessThanOrEqualTo(Float value) {
            addCriterion("StandByNum2 <=", value, "standbynum2");
            return (Criteria) this;
        }

        public Criteria andStandbynum2In(List<Float> values) {
            addCriterion("StandByNum2 in", values, "standbynum2");
            return (Criteria) this;
        }

        public Criteria andStandbynum2NotIn(List<Float> values) {
            addCriterion("StandByNum2 not in", values, "standbynum2");
            return (Criteria) this;
        }

        public Criteria andStandbynum2Between(Float value1, Float value2) {
            addCriterion("StandByNum2 between", value1, value2, "standbynum2");
            return (Criteria) this;
        }

        public Criteria andStandbynum2NotBetween(Float value1, Float value2) {
            addCriterion("StandByNum2 not between", value1, value2, "standbynum2");
            return (Criteria) this;
        }

        public Criteria andStandbydate1IsNull() {
            addCriterion("StandByDate1 is null");
            return (Criteria) this;
        }

        public Criteria andStandbydate1IsNotNull() {
            addCriterion("StandByDate1 is not null");
            return (Criteria) this;
        }

        public Criteria andStandbydate1EqualTo(Date value) {
            addCriterionForJDBCDate("StandByDate1 =", value, "standbydate1");
            return (Criteria) this;
        }

        public Criteria andStandbydate1NotEqualTo(Date value) {
            addCriterionForJDBCDate("StandByDate1 <>", value, "standbydate1");
            return (Criteria) this;
        }

        public Criteria andStandbydate1GreaterThan(Date value) {
            addCriterionForJDBCDate("StandByDate1 >", value, "standbydate1");
            return (Criteria) this;
        }

        public Criteria andStandbydate1GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StandByDate1 >=", value, "standbydate1");
            return (Criteria) this;
        }

        public Criteria andStandbydate1LessThan(Date value) {
            addCriterionForJDBCDate("StandByDate1 <", value, "standbydate1");
            return (Criteria) this;
        }

        public Criteria andStandbydate1LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StandByDate1 <=", value, "standbydate1");
            return (Criteria) this;
        }

        public Criteria andStandbydate1In(List<Date> values) {
            addCriterionForJDBCDate("StandByDate1 in", values, "standbydate1");
            return (Criteria) this;
        }

        public Criteria andStandbydate1NotIn(List<Date> values) {
            addCriterionForJDBCDate("StandByDate1 not in", values, "standbydate1");
            return (Criteria) this;
        }

        public Criteria andStandbydate1Between(Date value1, Date value2) {
            addCriterionForJDBCDate("StandByDate1 between", value1, value2, "standbydate1");
            return (Criteria) this;
        }

        public Criteria andStandbydate1NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StandByDate1 not between", value1, value2, "standbydate1");
            return (Criteria) this;
        }

        public Criteria andStandbydate2IsNull() {
            addCriterion("StandByDate2 is null");
            return (Criteria) this;
        }

        public Criteria andStandbydate2IsNotNull() {
            addCriterion("StandByDate2 is not null");
            return (Criteria) this;
        }

        public Criteria andStandbydate2EqualTo(Date value) {
            addCriterionForJDBCDate("StandByDate2 =", value, "standbydate2");
            return (Criteria) this;
        }

        public Criteria andStandbydate2NotEqualTo(Date value) {
            addCriterionForJDBCDate("StandByDate2 <>", value, "standbydate2");
            return (Criteria) this;
        }

        public Criteria andStandbydate2GreaterThan(Date value) {
            addCriterionForJDBCDate("StandByDate2 >", value, "standbydate2");
            return (Criteria) this;
        }

        public Criteria andStandbydate2GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StandByDate2 >=", value, "standbydate2");
            return (Criteria) this;
        }

        public Criteria andStandbydate2LessThan(Date value) {
            addCriterionForJDBCDate("StandByDate2 <", value, "standbydate2");
            return (Criteria) this;
        }

        public Criteria andStandbydate2LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StandByDate2 <=", value, "standbydate2");
            return (Criteria) this;
        }

        public Criteria andStandbydate2In(List<Date> values) {
            addCriterionForJDBCDate("StandByDate2 in", values, "standbydate2");
            return (Criteria) this;
        }

        public Criteria andStandbydate2NotIn(List<Date> values) {
            addCriterionForJDBCDate("StandByDate2 not in", values, "standbydate2");
            return (Criteria) this;
        }

        public Criteria andStandbydate2Between(Date value1, Date value2) {
            addCriterionForJDBCDate("StandByDate2 between", value1, value2, "standbydate2");
            return (Criteria) this;
        }

        public Criteria andStandbydate2NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StandByDate2 not between", value1, value2, "standbydate2");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNull() {
            addCriterion("document_id is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNotNull() {
            addCriterion("document_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(String value) {
            addCriterion("document_id =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotEqualTo(String value) {
            addCriterion("document_id <>", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThan(String value) {
            addCriterion("document_id >", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThanOrEqualTo(String value) {
            addCriterion("document_id >=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThan(String value) {
            addCriterion("document_id <", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThanOrEqualTo(String value) {
            addCriterion("document_id <=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLike(String value) {
            addCriterion("document_id like", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotLike(String value) {
            addCriterion("document_id not like", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIn(List<String> values) {
            addCriterion("document_id in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotIn(List<String> values) {
            addCriterion("document_id not in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdBetween(String value1, String value2) {
            addCriterion("document_id between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotBetween(String value1, String value2) {
            addCriterion("document_id not between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentDateIsNull() {
            addCriterion("document_date is null");
            return (Criteria) this;
        }

        public Criteria andDocumentDateIsNotNull() {
            addCriterion("document_date is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentDateEqualTo(Date value) {
            addCriterion("document_date =", value, "documentDate");
            return (Criteria) this;
        }

        public Criteria andDocumentDateNotEqualTo(Date value) {
            addCriterion("document_date <>", value, "documentDate");
            return (Criteria) this;
        }

        public Criteria andDocumentDateGreaterThan(Date value) {
            addCriterion("document_date >", value, "documentDate");
            return (Criteria) this;
        }

        public Criteria andDocumentDateGreaterThanOrEqualTo(Date value) {
            addCriterion("document_date >=", value, "documentDate");
            return (Criteria) this;
        }

        public Criteria andDocumentDateLessThan(Date value) {
            addCriterion("document_date <", value, "documentDate");
            return (Criteria) this;
        }

        public Criteria andDocumentDateLessThanOrEqualTo(Date value) {
            addCriterion("document_date <=", value, "documentDate");
            return (Criteria) this;
        }

        public Criteria andDocumentDateIn(List<Date> values) {
            addCriterion("document_date in", values, "documentDate");
            return (Criteria) this;
        }

        public Criteria andDocumentDateNotIn(List<Date> values) {
            addCriterion("document_date not in", values, "documentDate");
            return (Criteria) this;
        }

        public Criteria andDocumentDateBetween(Date value1, Date value2) {
            addCriterion("document_date between", value1, value2, "documentDate");
            return (Criteria) this;
        }

        public Criteria andDocumentDateNotBetween(Date value1, Date value2) {
            addCriterion("document_date not between", value1, value2, "documentDate");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1IsNull() {
            addCriterion("exchange_rate1 is null");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1IsNotNull() {
            addCriterion("exchange_rate1 is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1EqualTo(String value) {
            addCriterion("exchange_rate1 =", value, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1NotEqualTo(String value) {
            addCriterion("exchange_rate1 <>", value, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1GreaterThan(String value) {
            addCriterion("exchange_rate1 >", value, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1GreaterThanOrEqualTo(String value) {
            addCriterion("exchange_rate1 >=", value, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1LessThan(String value) {
            addCriterion("exchange_rate1 <", value, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1LessThanOrEqualTo(String value) {
            addCriterion("exchange_rate1 <=", value, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1Like(String value) {
            addCriterion("exchange_rate1 like", value, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1NotLike(String value) {
            addCriterion("exchange_rate1 not like", value, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1In(List<String> values) {
            addCriterion("exchange_rate1 in", values, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1NotIn(List<String> values) {
            addCriterion("exchange_rate1 not in", values, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1Between(String value1, String value2) {
            addCriterion("exchange_rate1 between", value1, value2, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andExchangeRate1NotBetween(String value1, String value2) {
            addCriterion("exchange_rate1 not between", value1, value2, "exchangeRate1");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Float value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Float value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Float value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Float value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Float value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Float> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Float> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Float value1, Float value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Float value1, Float value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
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