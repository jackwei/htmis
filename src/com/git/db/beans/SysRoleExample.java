package com.git.db.beans;

import java.util.ArrayList;
import java.util.List;

public class SysRoleExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SysRoleExample() {
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

		public Criteria andRoleIdIsNull() {
			addCriterion("Role_Id is null");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNotNull() {
			addCriterion("Role_Id is not null");
			return (Criteria) this;
		}

		public Criteria andRoleIdEqualTo(Long value) {
			addCriterion("Role_Id =", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotEqualTo(Long value) {
			addCriterion("Role_Id <>", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThan(Long value) {
			addCriterion("Role_Id >", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
			addCriterion("Role_Id >=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThan(Long value) {
			addCriterion("Role_Id <", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThanOrEqualTo(Long value) {
			addCriterion("Role_Id <=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdIn(List<Long> values) {
			addCriterion("Role_Id in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotIn(List<Long> values) {
			addCriterion("Role_Id not in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdBetween(Long value1, Long value2) {
			addCriterion("Role_Id between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotBetween(Long value1, Long value2) {
			addCriterion("Role_Id not between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleNameIsNull() {
			addCriterion("Role_Name is null");
			return (Criteria) this;
		}

		public Criteria andRoleNameIsNotNull() {
			addCriterion("Role_Name is not null");
			return (Criteria) this;
		}

		public Criteria andRoleNameEqualTo(String value) {
			addCriterion("Role_Name =", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotEqualTo(String value) {
			addCriterion("Role_Name <>", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameGreaterThan(String value) {
			addCriterion("Role_Name >", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
			addCriterion("Role_Name >=", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameLessThan(String value) {
			addCriterion("Role_Name <", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameLessThanOrEqualTo(String value) {
			addCriterion("Role_Name <=", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameLike(String value) {
			addCriterion("Role_Name like", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotLike(String value) {
			addCriterion("Role_Name not like", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameIn(List<String> values) {
			addCriterion("Role_Name in", values, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotIn(List<String> values) {
			addCriterion("Role_Name not in", values, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameBetween(String value1, String value2) {
			addCriterion("Role_Name between", value1, value2, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotBetween(String value1, String value2) {
			addCriterion("Role_Name not between", value1, value2, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleStatusIsNull() {
			addCriterion("Role_Status is null");
			return (Criteria) this;
		}

		public Criteria andRoleStatusIsNotNull() {
			addCriterion("Role_Status is not null");
			return (Criteria) this;
		}

		public Criteria andRoleStatusEqualTo(String value) {
			addCriterion("Role_Status =", value, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusNotEqualTo(String value) {
			addCriterion("Role_Status <>", value, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusGreaterThan(String value) {
			addCriterion("Role_Status >", value, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusGreaterThanOrEqualTo(String value) {
			addCriterion("Role_Status >=", value, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusLessThan(String value) {
			addCriterion("Role_Status <", value, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusLessThanOrEqualTo(String value) {
			addCriterion("Role_Status <=", value, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusLike(String value) {
			addCriterion("Role_Status like", value, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusNotLike(String value) {
			addCriterion("Role_Status not like", value, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusIn(List<String> values) {
			addCriterion("Role_Status in", values, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusNotIn(List<String> values) {
			addCriterion("Role_Status not in", values, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusBetween(String value1, String value2) {
			addCriterion("Role_Status between", value1, value2, "roleStatus");
			return (Criteria) this;
		}

		public Criteria andRoleStatusNotBetween(String value1, String value2) {
			addCriterion("Role_Status not between", value1, value2,
					"roleStatus");
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