package com.git.db.beans;

import java.util.ArrayList;
import java.util.List;

public class SysDictTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDictTypeExample() {
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

        public Criteria andDicttypeidIsNull() {
            addCriterion("DictTypeId is null");
            return (Criteria) this;
        }

        public Criteria andDicttypeidIsNotNull() {
            addCriterion("DictTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andDicttypeidEqualTo(String value) {
            addCriterion("DictTypeId =", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidNotEqualTo(String value) {
            addCriterion("DictTypeId <>", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidGreaterThan(String value) {
            addCriterion("DictTypeId >", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidGreaterThanOrEqualTo(String value) {
            addCriterion("DictTypeId >=", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidLessThan(String value) {
            addCriterion("DictTypeId <", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidLessThanOrEqualTo(String value) {
            addCriterion("DictTypeId <=", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidLike(String value) {
            addCriterion("DictTypeId like", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidNotLike(String value) {
            addCriterion("DictTypeId not like", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidIn(List<String> values) {
            addCriterion("DictTypeId in", values, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidNotIn(List<String> values) {
            addCriterion("DictTypeId not in", values, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidBetween(String value1, String value2) {
            addCriterion("DictTypeId between", value1, value2, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidNotBetween(String value1, String value2) {
            addCriterion("DictTypeId not between", value1, value2, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypenameIsNull() {
            addCriterion("DictTypeName is null");
            return (Criteria) this;
        }

        public Criteria andDicttypenameIsNotNull() {
            addCriterion("DictTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andDicttypenameEqualTo(String value) {
            addCriterion("DictTypeName =", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameNotEqualTo(String value) {
            addCriterion("DictTypeName <>", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameGreaterThan(String value) {
            addCriterion("DictTypeName >", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameGreaterThanOrEqualTo(String value) {
            addCriterion("DictTypeName >=", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameLessThan(String value) {
            addCriterion("DictTypeName <", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameLessThanOrEqualTo(String value) {
            addCriterion("DictTypeName <=", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameLike(String value) {
            addCriterion("DictTypeName like", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameNotLike(String value) {
            addCriterion("DictTypeName not like", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameIn(List<String> values) {
            addCriterion("DictTypeName in", values, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameNotIn(List<String> values) {
            addCriterion("DictTypeName not in", values, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameBetween(String value1, String value2) {
            addCriterion("DictTypeName between", value1, value2, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameNotBetween(String value1, String value2) {
            addCriterion("DictTypeName not between", value1, value2, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidIsNull() {
            addCriterion("ParentDictTypeId is null");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidIsNotNull() {
            addCriterion("ParentDictTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidEqualTo(String value) {
            addCriterion("ParentDictTypeId =", value, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidNotEqualTo(String value) {
            addCriterion("ParentDictTypeId <>", value, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidGreaterThan(String value) {
            addCriterion("ParentDictTypeId >", value, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidGreaterThanOrEqualTo(String value) {
            addCriterion("ParentDictTypeId >=", value, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidLessThan(String value) {
            addCriterion("ParentDictTypeId <", value, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidLessThanOrEqualTo(String value) {
            addCriterion("ParentDictTypeId <=", value, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidLike(String value) {
            addCriterion("ParentDictTypeId like", value, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidNotLike(String value) {
            addCriterion("ParentDictTypeId not like", value, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidIn(List<String> values) {
            addCriterion("ParentDictTypeId in", values, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidNotIn(List<String> values) {
            addCriterion("ParentDictTypeId not in", values, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidBetween(String value1, String value2) {
            addCriterion("ParentDictTypeId between", value1, value2, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andParentdicttypeidNotBetween(String value1, String value2) {
            addCriterion("ParentDictTypeId not between", value1, value2, "parentdicttypeid");
            return (Criteria) this;
        }

        public Criteria andSortnoIsNull() {
            addCriterion("SortNo is null");
            return (Criteria) this;
        }

        public Criteria andSortnoIsNotNull() {
            addCriterion("SortNo is not null");
            return (Criteria) this;
        }

        public Criteria andSortnoEqualTo(Integer value) {
            addCriterion("SortNo =", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotEqualTo(Integer value) {
            addCriterion("SortNo <>", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoGreaterThan(Integer value) {
            addCriterion("SortNo >", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SortNo >=", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLessThan(Integer value) {
            addCriterion("SortNo <", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLessThanOrEqualTo(Integer value) {
            addCriterion("SortNo <=", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoIn(List<Integer> values) {
            addCriterion("SortNo in", values, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotIn(List<Integer> values) {
            addCriterion("SortNo not in", values, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoBetween(Integer value1, Integer value2) {
            addCriterion("SortNo between", value1, value2, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotBetween(Integer value1, Integer value2) {
            addCriterion("SortNo not between", value1, value2, "sortno");
            return (Criteria) this;
        }

        public Criteria andBackup1IsNull() {
            addCriterion("BackUp1 is null");
            return (Criteria) this;
        }

        public Criteria andBackup1IsNotNull() {
            addCriterion("BackUp1 is not null");
            return (Criteria) this;
        }

        public Criteria andBackup1EqualTo(String value) {
            addCriterion("BackUp1 =", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotEqualTo(String value) {
            addCriterion("BackUp1 <>", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1GreaterThan(String value) {
            addCriterion("BackUp1 >", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1GreaterThanOrEqualTo(String value) {
            addCriterion("BackUp1 >=", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1LessThan(String value) {
            addCriterion("BackUp1 <", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1LessThanOrEqualTo(String value) {
            addCriterion("BackUp1 <=", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1Like(String value) {
            addCriterion("BackUp1 like", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotLike(String value) {
            addCriterion("BackUp1 not like", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1In(List<String> values) {
            addCriterion("BackUp1 in", values, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotIn(List<String> values) {
            addCriterion("BackUp1 not in", values, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1Between(String value1, String value2) {
            addCriterion("BackUp1 between", value1, value2, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotBetween(String value1, String value2) {
            addCriterion("BackUp1 not between", value1, value2, "backup1");
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