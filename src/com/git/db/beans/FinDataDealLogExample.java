package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinDataDealLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinDataDealLogExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("Log_Id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("Log_Id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Long value) {
            addCriterion("Log_Id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Long value) {
            addCriterion("Log_Id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Long value) {
            addCriterion("Log_Id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Log_Id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Long value) {
            addCriterion("Log_Id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Long value) {
            addCriterion("Log_Id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Long> values) {
            addCriterion("Log_Id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Long> values) {
            addCriterion("Log_Id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Long value1, Long value2) {
            addCriterion("Log_Id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Long value1, Long value2) {
            addCriterion("Log_Id not between", value1, value2, "logId");
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