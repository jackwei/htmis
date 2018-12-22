package com.git.db.beans;

import java.util.ArrayList;
import java.util.List;

public class FinTransInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinTransInfoExample() {
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

        public Criteria andDistillModeIsNull() {
            addCriterion("Distill_Mode is null");
            return (Criteria) this;
        }

        public Criteria andDistillModeIsNotNull() {
            addCriterion("Distill_Mode is not null");
            return (Criteria) this;
        }

        public Criteria andDistillModeEqualTo(String value) {
            addCriterion("Distill_Mode =", value, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeNotEqualTo(String value) {
            addCriterion("Distill_Mode <>", value, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeGreaterThan(String value) {
            addCriterion("Distill_Mode >", value, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeGreaterThanOrEqualTo(String value) {
            addCriterion("Distill_Mode >=", value, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeLessThan(String value) {
            addCriterion("Distill_Mode <", value, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeLessThanOrEqualTo(String value) {
            addCriterion("Distill_Mode <=", value, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeLike(String value) {
            addCriterion("Distill_Mode like", value, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeNotLike(String value) {
            addCriterion("Distill_Mode not like", value, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeIn(List<String> values) {
            addCriterion("Distill_Mode in", values, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeNotIn(List<String> values) {
            addCriterion("Distill_Mode not in", values, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeBetween(String value1, String value2) {
            addCriterion("Distill_Mode between", value1, value2, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillModeNotBetween(String value1, String value2) {
            addCriterion("Distill_Mode not between", value1, value2, "distillMode");
            return (Criteria) this;
        }

        public Criteria andDistillClassIsNull() {
            addCriterion("Distill_Class is null");
            return (Criteria) this;
        }

        public Criteria andDistillClassIsNotNull() {
            addCriterion("Distill_Class is not null");
            return (Criteria) this;
        }

        public Criteria andDistillClassEqualTo(String value) {
            addCriterion("Distill_Class =", value, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassNotEqualTo(String value) {
            addCriterion("Distill_Class <>", value, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassGreaterThan(String value) {
            addCriterion("Distill_Class >", value, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassGreaterThanOrEqualTo(String value) {
            addCriterion("Distill_Class >=", value, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassLessThan(String value) {
            addCriterion("Distill_Class <", value, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassLessThanOrEqualTo(String value) {
            addCriterion("Distill_Class <=", value, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassLike(String value) {
            addCriterion("Distill_Class like", value, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassNotLike(String value) {
            addCriterion("Distill_Class not like", value, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassIn(List<String> values) {
            addCriterion("Distill_Class in", values, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassNotIn(List<String> values) {
            addCriterion("Distill_Class not in", values, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassBetween(String value1, String value2) {
            addCriterion("Distill_Class between", value1, value2, "distillClass");
            return (Criteria) this;
        }

        public Criteria andDistillClassNotBetween(String value1, String value2) {
            addCriterion("Distill_Class not between", value1, value2, "distillClass");
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