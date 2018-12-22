package com.git.db.beans;

import java.util.ArrayList;
import java.util.List;

public class SysDictEntryExample {
   
	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDictEntryExample() {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andDictidIsNull() {
			addCriterion("DictId is null");
			return (Criteria) this;
		}

		public Criteria andDictidIsNotNull() {
			addCriterion("DictId is not null");
			return (Criteria) this;
		}

		public Criteria andDictidEqualTo(String value) {
			addCriterion("DictId =", value, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidNotEqualTo(String value) {
			addCriterion("DictId <>", value, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidGreaterThan(String value) {
			addCriterion("DictId >", value, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidGreaterThanOrEqualTo(String value) {
			addCriterion("DictId >=", value, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidLessThan(String value) {
			addCriterion("DictId <", value, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidLessThanOrEqualTo(String value) {
			addCriterion("DictId <=", value, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidLike(String value) {
			addCriterion("DictId like", value, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidNotLike(String value) {
			addCriterion("DictId not like", value, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidIn(List<String> values) {
			addCriterion("DictId in", values, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidNotIn(List<String> values) {
			addCriterion("DictId not in", values, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidBetween(String value1, String value2) {
			addCriterion("DictId between", value1, value2, "dictid");
			return (Criteria) this;
		}

		public Criteria andDictidNotBetween(String value1, String value2) {
			addCriterion("DictId not between", value1, value2, "dictid");
			return (Criteria) this;
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

		public Criteria andDictnameIsNull() {
			addCriterion("DictName is null");
			return (Criteria) this;
		}

		public Criteria andDictnameIsNotNull() {
			addCriterion("DictName is not null");
			return (Criteria) this;
		}

		public Criteria andDictnameEqualTo(String value) {
			addCriterion("DictName =", value, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameNotEqualTo(String value) {
			addCriterion("DictName <>", value, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameGreaterThan(String value) {
			addCriterion("DictName >", value, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameGreaterThanOrEqualTo(String value) {
			addCriterion("DictName >=", value, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameLessThan(String value) {
			addCriterion("DictName <", value, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameLessThanOrEqualTo(String value) {
			addCriterion("DictName <=", value, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameLike(String value) {
			addCriterion("DictName like", value, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameNotLike(String value) {
			addCriterion("DictName not like", value, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameIn(List<String> values) {
			addCriterion("DictName in", values, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameNotIn(List<String> values) {
			addCriterion("DictName not in", values, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameBetween(String value1, String value2) {
			addCriterion("DictName between", value1, value2, "dictname");
			return (Criteria) this;
		}

		public Criteria andDictnameNotBetween(String value1, String value2) {
			addCriterion("DictName not between", value1, value2, "dictname");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("Status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("Status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("Status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("Status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("Status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("Status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("Status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("Status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("Status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("Status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("Status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("Status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("Status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("Status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andParentdictidIsNull() {
			addCriterion("ParentDictId is null");
			return (Criteria) this;
		}

		public Criteria andParentdictidIsNotNull() {
			addCriterion("ParentDictId is not null");
			return (Criteria) this;
		}

		public Criteria andParentdictidEqualTo(String value) {
			addCriterion("ParentDictId =", value, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidNotEqualTo(String value) {
			addCriterion("ParentDictId <>", value, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidGreaterThan(String value) {
			addCriterion("ParentDictId >", value, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidGreaterThanOrEqualTo(String value) {
			addCriterion("ParentDictId >=", value, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidLessThan(String value) {
			addCriterion("ParentDictId <", value, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidLessThanOrEqualTo(String value) {
			addCriterion("ParentDictId <=", value, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidLike(String value) {
			addCriterion("ParentDictId like", value, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidNotLike(String value) {
			addCriterion("ParentDictId not like", value, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidIn(List<String> values) {
			addCriterion("ParentDictId in", values, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidNotIn(List<String> values) {
			addCriterion("ParentDictId not in", values, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidBetween(String value1, String value2) {
			addCriterion("ParentDictId between", value1, value2, "parentdictid");
			return (Criteria) this;
		}

		public Criteria andParentdictidNotBetween(String value1, String value2) {
			addCriterion("ParentDictId not between", value1, value2,
					"parentdictid");
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

		public Criteria andBackup2IsNull() {
			addCriterion("BackUp2 is null");
			return (Criteria) this;
		}

		public Criteria andBackup2IsNotNull() {
			addCriterion("BackUp2 is not null");
			return (Criteria) this;
		}

		public Criteria andBackup2EqualTo(String value) {
			addCriterion("BackUp2 =", value, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2NotEqualTo(String value) {
			addCriterion("BackUp2 <>", value, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2GreaterThan(String value) {
			addCriterion("BackUp2 >", value, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2GreaterThanOrEqualTo(String value) {
			addCriterion("BackUp2 >=", value, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2LessThan(String value) {
			addCriterion("BackUp2 <", value, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2LessThanOrEqualTo(String value) {
			addCriterion("BackUp2 <=", value, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2Like(String value) {
			addCriterion("BackUp2 like", value, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2NotLike(String value) {
			addCriterion("BackUp2 not like", value, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2In(List<String> values) {
			addCriterion("BackUp2 in", values, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2NotIn(List<String> values) {
			addCriterion("BackUp2 not in", values, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2Between(String value1, String value2) {
			addCriterion("BackUp2 between", value1, value2, "backup2");
			return (Criteria) this;
		}

		public Criteria andBackup2NotBetween(String value1, String value2) {
			addCriterion("BackUp2 not between", value1, value2, "backup2");
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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