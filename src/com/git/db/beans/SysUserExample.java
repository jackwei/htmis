package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SysUserExample() {
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

		public Criteria andUserIdIsNull() {
			addCriterion("User_Id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("User_Id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("User_Id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("User_Id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("User_Id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("User_Id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("User_Id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("User_Id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("User_Id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("User_Id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("User_Id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("User_Id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserNoIsNull() {
			addCriterion("User_No is null");
			return (Criteria) this;
		}

		public Criteria andUserNoIsNotNull() {
			addCriterion("User_No is not null");
			return (Criteria) this;
		}

		public Criteria andUserNoEqualTo(String value) {
			addCriterion("User_No =", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoNotEqualTo(String value) {
			addCriterion("User_No <>", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoGreaterThan(String value) {
			addCriterion("User_No >", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoGreaterThanOrEqualTo(String value) {
			addCriterion("User_No >=", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoLessThan(String value) {
			addCriterion("User_No <", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoLessThanOrEqualTo(String value) {
			addCriterion("User_No <=", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoLike(String value) {
			addCriterion("User_No like", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoNotLike(String value) {
			addCriterion("User_No not like", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoIn(List<String> values) {
			addCriterion("User_No in", values, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoNotIn(List<String> values) {
			addCriterion("User_No not in", values, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoBetween(String value1, String value2) {
			addCriterion("User_No between", value1, value2, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoNotBetween(String value1, String value2) {
			addCriterion("User_No not between", value1, value2, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserCodeIsNull() {
			addCriterion("User_Code is null");
			return (Criteria) this;
		}

		public Criteria andUserCodeIsNotNull() {
			addCriterion("User_Code is not null");
			return (Criteria) this;
		}

		public Criteria andUserCodeEqualTo(String value) {
			addCriterion("User_Code =", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotEqualTo(String value) {
			addCriterion("User_Code <>", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeGreaterThan(String value) {
			addCriterion("User_Code >", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
			addCriterion("User_Code >=", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLessThan(String value) {
			addCriterion("User_Code <", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLessThanOrEqualTo(String value) {
			addCriterion("User_Code <=", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLike(String value) {
			addCriterion("User_Code like", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotLike(String value) {
			addCriterion("User_Code not like", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeIn(List<String> values) {
			addCriterion("User_Code in", values, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotIn(List<String> values) {
			addCriterion("User_Code not in", values, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeBetween(String value1, String value2) {
			addCriterion("User_Code between", value1, value2, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotBetween(String value1, String value2) {
			addCriterion("User_Code not between", value1, value2, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserPwdIsNull() {
			addCriterion("User_Pwd is null");
			return (Criteria) this;
		}

		public Criteria andUserPwdIsNotNull() {
			addCriterion("User_Pwd is not null");
			return (Criteria) this;
		}

		public Criteria andUserPwdEqualTo(String value) {
			addCriterion("User_Pwd =", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotEqualTo(String value) {
			addCriterion("User_Pwd <>", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdGreaterThan(String value) {
			addCriterion("User_Pwd >", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
			addCriterion("User_Pwd >=", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdLessThan(String value) {
			addCriterion("User_Pwd <", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdLessThanOrEqualTo(String value) {
			addCriterion("User_Pwd <=", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdLike(String value) {
			addCriterion("User_Pwd like", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotLike(String value) {
			addCriterion("User_Pwd not like", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdIn(List<String> values) {
			addCriterion("User_Pwd in", values, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotIn(List<String> values) {
			addCriterion("User_Pwd not in", values, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdBetween(String value1, String value2) {
			addCriterion("User_Pwd between", value1, value2, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotBetween(String value1, String value2) {
			addCriterion("User_Pwd not between", value1, value2, "userPwd");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("Name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("Name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("Name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("Name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("Name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("Name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("Name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("Name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("Name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("Name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("Name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("Name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("Name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("Name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andGenderIsNull() {
			addCriterion("Gender is null");
			return (Criteria) this;
		}

		public Criteria andGenderIsNotNull() {
			addCriterion("Gender is not null");
			return (Criteria) this;
		}

		public Criteria andGenderEqualTo(String value) {
			addCriterion("Gender =", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotEqualTo(String value) {
			addCriterion("Gender <>", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderGreaterThan(String value) {
			addCriterion("Gender >", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderGreaterThanOrEqualTo(String value) {
			addCriterion("Gender >=", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderLessThan(String value) {
			addCriterion("Gender <", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderLessThanOrEqualTo(String value) {
			addCriterion("Gender <=", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderLike(String value) {
			addCriterion("Gender like", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotLike(String value) {
			addCriterion("Gender not like", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderIn(List<String> values) {
			addCriterion("Gender in", values, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotIn(List<String> values) {
			addCriterion("Gender not in", values, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderBetween(String value1, String value2) {
			addCriterion("Gender between", value1, value2, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotBetween(String value1, String value2) {
			addCriterion("Gender not between", value1, value2, "gender");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("Email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("Email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("Email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("Email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("Email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("Email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("Email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("Email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("Email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("Email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("Email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("Email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("Email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("Email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNull() {
			addCriterion("Phone is null");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNotNull() {
			addCriterion("Phone is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneEqualTo(String value) {
			addCriterion("Phone =", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotEqualTo(String value) {
			addCriterion("Phone <>", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThan(String value) {
			addCriterion("Phone >", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("Phone >=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThan(String value) {
			addCriterion("Phone <", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThanOrEqualTo(String value) {
			addCriterion("Phone <=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLike(String value) {
			addCriterion("Phone like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotLike(String value) {
			addCriterion("Phone not like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneIn(List<String> values) {
			addCriterion("Phone in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotIn(List<String> values) {
			addCriterion("Phone not in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneBetween(String value1, String value2) {
			addCriterion("Phone between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotBetween(String value1, String value2) {
			addCriterion("Phone not between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andOrgIdIsNull() {
			addCriterion("Org_Id is null");
			return (Criteria) this;
		}

		public Criteria andOrgIdIsNotNull() {
			addCriterion("Org_Id is not null");
			return (Criteria) this;
		}

		public Criteria andOrgIdEqualTo(Long value) {
			addCriterion("Org_Id =", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdNotEqualTo(Long value) {
			addCriterion("Org_Id <>", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdGreaterThan(Long value) {
			addCriterion("Org_Id >", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
			addCriterion("Org_Id >=", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdLessThan(Long value) {
			addCriterion("Org_Id <", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdLessThanOrEqualTo(Long value) {
			addCriterion("Org_Id <=", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdIn(List<Long> values) {
			addCriterion("Org_Id in", values, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdNotIn(List<Long> values) {
			addCriterion("Org_Id not in", values, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdBetween(Long value1, Long value2) {
			addCriterion("Org_Id between", value1, value2, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdNotBetween(Long value1, Long value2) {
			addCriterion("Org_Id not between", value1, value2, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrderByIsNull() {
			addCriterion("Order_By is null");
			return (Criteria) this;
		}

		public Criteria andOrderByIsNotNull() {
			addCriterion("Order_By is not null");
			return (Criteria) this;
		}

		public Criteria andOrderByEqualTo(Integer value) {
			addCriterion("Order_By =", value, "orderBy");
			return (Criteria) this;
		}

		public Criteria andOrderByNotEqualTo(Integer value) {
			addCriterion("Order_By <>", value, "orderBy");
			return (Criteria) this;
		}

		public Criteria andOrderByGreaterThan(Integer value) {
			addCriterion("Order_By >", value, "orderBy");
			return (Criteria) this;
		}

		public Criteria andOrderByGreaterThanOrEqualTo(Integer value) {
			addCriterion("Order_By >=", value, "orderBy");
			return (Criteria) this;
		}

		public Criteria andOrderByLessThan(Integer value) {
			addCriterion("Order_By <", value, "orderBy");
			return (Criteria) this;
		}

		public Criteria andOrderByLessThanOrEqualTo(Integer value) {
			addCriterion("Order_By <=", value, "orderBy");
			return (Criteria) this;
		}

		public Criteria andOrderByIn(List<Integer> values) {
			addCriterion("Order_By in", values, "orderBy");
			return (Criteria) this;
		}

		public Criteria andOrderByNotIn(List<Integer> values) {
			addCriterion("Order_By not in", values, "orderBy");
			return (Criteria) this;
		}

		public Criteria andOrderByBetween(Integer value1, Integer value2) {
			addCriterion("Order_By between", value1, value2, "orderBy");
			return (Criteria) this;
		}

		public Criteria andOrderByNotBetween(Integer value1, Integer value2) {
			addCriterion("Order_By not between", value1, value2, "orderBy");
			return (Criteria) this;
		}

		public Criteria andUserStatusIsNull() {
			addCriterion("User_Status is null");
			return (Criteria) this;
		}

		public Criteria andUserStatusIsNotNull() {
			addCriterion("User_Status is not null");
			return (Criteria) this;
		}

		public Criteria andUserStatusEqualTo(String value) {
			addCriterion("User_Status =", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotEqualTo(String value) {
			addCriterion("User_Status <>", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusGreaterThan(String value) {
			addCriterion("User_Status >", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusGreaterThanOrEqualTo(String value) {
			addCriterion("User_Status >=", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusLessThan(String value) {
			addCriterion("User_Status <", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusLessThanOrEqualTo(String value) {
			addCriterion("User_Status <=", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusLike(String value) {
			addCriterion("User_Status like", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotLike(String value) {
			addCriterion("User_Status not like", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusIn(List<String> values) {
			addCriterion("User_Status in", values, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotIn(List<String> values) {
			addCriterion("User_Status not in", values, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusBetween(String value1, String value2) {
			addCriterion("User_Status between", value1, value2, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotBetween(String value1, String value2) {
			addCriterion("User_Status not between", value1, value2,
					"userStatus");
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
			addCriterion("Create_Time not between", value1, value2,
					"createTime");
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
			addCriterion("Modify_Operator_Id not in", values,
					"modifyOperatorId");
			return (Criteria) this;
		}

		public Criteria andModifyOperatorIdBetween(Long value1, Long value2) {
			addCriterion("Modify_Operator_Id between", value1, value2,
					"modifyOperatorId");
			return (Criteria) this;
		}

		public Criteria andModifyOperatorIdNotBetween(Long value1, Long value2) {
			addCriterion("Modify_Operator_Id not between", value1, value2,
					"modifyOperatorId");
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
			addCriterion("Modify_Time not between", value1, value2,
					"modifyTime");
			return (Criteria) this;
		}

		public Criteria andOperatorIdIsNull() {
			addCriterion("Operator_Id is null");
			return (Criteria) this;
		}

		public Criteria andOperatorIdIsNotNull() {
			addCriterion("Operator_Id is not null");
			return (Criteria) this;
		}

		public Criteria andOperatorIdEqualTo(Long value) {
			addCriterion("Operator_Id =", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdNotEqualTo(Long value) {
			addCriterion("Operator_Id <>", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdGreaterThan(Long value) {
			addCriterion("Operator_Id >", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdGreaterThanOrEqualTo(Long value) {
			addCriterion("Operator_Id >=", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdLessThan(Long value) {
			addCriterion("Operator_Id <", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdLessThanOrEqualTo(Long value) {
			addCriterion("Operator_Id <=", value, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdIn(List<Long> values) {
			addCriterion("Operator_Id in", values, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdNotIn(List<Long> values) {
			addCriterion("Operator_Id not in", values, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdBetween(Long value1, Long value2) {
			addCriterion("Operator_Id between", value1, value2, "operatorId");
			return (Criteria) this;
		}

		public Criteria andOperatorIdNotBetween(Long value1, Long value2) {
			addCriterion("Operator_Id not between", value1, value2,
					"operatorId");
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

		public Criteria andOrgNameIsNull() {
			addCriterion("Org_Name is null");
			return (Criteria) this;
		}

		public Criteria andOrgNameIsNotNull() {
			addCriterion("Org_Name is not null");
			return (Criteria) this;
		}

		public Criteria andOrgNameEqualTo(String value) {
			addCriterion("Org_Name =", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotEqualTo(String value) {
			addCriterion("Org_Name <>", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameGreaterThan(String value) {
			addCriterion("Org_Name >", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
			addCriterion("Org_Name >=", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameLessThan(String value) {
			addCriterion("Org_Name <", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameLessThanOrEqualTo(String value) {
			addCriterion("Org_Name <=", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameLike(String value) {
			addCriterion("Org_Name like", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotLike(String value) {
			addCriterion("Org_Name not like", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameIn(List<String> values) {
			addCriterion("Org_Name in", values, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotIn(List<String> values) {
			addCriterion("Org_Name not in", values, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameBetween(String value1, String value2) {
			addCriterion("Org_Name between", value1, value2, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotBetween(String value1, String value2) {
			addCriterion("Org_Name not between", value1, value2, "orgName");
			return (Criteria) this;
		}

		public Criteria andSNameIsNull() {
			addCriterion("S_Name is null");
			return (Criteria) this;
		}

		public Criteria andSNameIsNotNull() {
			addCriterion("S_Name is not null");
			return (Criteria) this;
		}

		public Criteria andSNameEqualTo(String value) {
			addCriterion("S_Name =", value, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameNotEqualTo(String value) {
			addCriterion("S_Name <>", value, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameGreaterThan(String value) {
			addCriterion("S_Name >", value, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameGreaterThanOrEqualTo(String value) {
			addCriterion("S_Name >=", value, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameLessThan(String value) {
			addCriterion("S_Name <", value, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameLessThanOrEqualTo(String value) {
			addCriterion("S_Name <=", value, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameLike(String value) {
			addCriterion("S_Name like", value, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameNotLike(String value) {
			addCriterion("S_Name not like", value, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameIn(List<String> values) {
			addCriterion("S_Name in", values, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameNotIn(List<String> values) {
			addCriterion("S_Name not in", values, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameBetween(String value1, String value2) {
			addCriterion("S_Name between", value1, value2, "sName");
			return (Criteria) this;
		}

		public Criteria andSNameNotBetween(String value1, String value2) {
			addCriterion("S_Name not between", value1, value2, "sName");
			return (Criteria) this;
		}

		public Criteria andEnNameIsNull() {
			addCriterion("En_Name is null");
			return (Criteria) this;
		}

		public Criteria andEnNameIsNotNull() {
			addCriterion("En_Name is not null");
			return (Criteria) this;
		}

		public Criteria andEnNameEqualTo(String value) {
			addCriterion("En_Name =", value, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameNotEqualTo(String value) {
			addCriterion("En_Name <>", value, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameGreaterThan(String value) {
			addCriterion("En_Name >", value, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameGreaterThanOrEqualTo(String value) {
			addCriterion("En_Name >=", value, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameLessThan(String value) {
			addCriterion("En_Name <", value, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameLessThanOrEqualTo(String value) {
			addCriterion("En_Name <=", value, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameLike(String value) {
			addCriterion("En_Name like", value, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameNotLike(String value) {
			addCriterion("En_Name not like", value, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameIn(List<String> values) {
			addCriterion("En_Name in", values, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameNotIn(List<String> values) {
			addCriterion("En_Name not in", values, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameBetween(String value1, String value2) {
			addCriterion("En_Name between", value1, value2, "enName");
			return (Criteria) this;
		}

		public Criteria andEnNameNotBetween(String value1, String value2) {
			addCriterion("En_Name not between", value1, value2, "enName");
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