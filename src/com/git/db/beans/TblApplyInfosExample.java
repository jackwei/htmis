package com.git.db.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblApplyInfosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblApplyInfosExample() {
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

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Long value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Long value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Long value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Long> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNull() {
            addCriterion("applytype is null");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNotNull() {
            addCriterion("applytype is not null");
            return (Criteria) this;
        }

        public Criteria andApplytypeEqualTo(String value) {
            addCriterion("applytype =", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotEqualTo(String value) {
            addCriterion("applytype <>", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThan(String value) {
            addCriterion("applytype >", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThanOrEqualTo(String value) {
            addCriterion("applytype >=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThan(String value) {
            addCriterion("applytype <", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThanOrEqualTo(String value) {
            addCriterion("applytype <=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLike(String value) {
            addCriterion("applytype like", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotLike(String value) {
            addCriterion("applytype not like", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeIn(List<String> values) {
            addCriterion("applytype in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotIn(List<String> values) {
            addCriterion("applytype not in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeBetween(String value1, String value2) {
            addCriterion("applytype between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotBetween(String value1, String value2) {
            addCriterion("applytype not between", value1, value2, "applytype");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andProcessdefidIsNull() {
            addCriterion("processDefId is null");
            return (Criteria) this;
        }

        public Criteria andProcessdefidIsNotNull() {
            addCriterion("processDefId is not null");
            return (Criteria) this;
        }

        public Criteria andProcessdefidEqualTo(Long value) {
            addCriterion("processDefId =", value, "processdefid");
            return (Criteria) this;
        }

        public Criteria andProcessdefidNotEqualTo(Long value) {
            addCriterion("processDefId <>", value, "processdefid");
            return (Criteria) this;
        }

        public Criteria andProcessdefidGreaterThan(Long value) {
            addCriterion("processDefId >", value, "processdefid");
            return (Criteria) this;
        }

        public Criteria andProcessdefidGreaterThanOrEqualTo(Long value) {
            addCriterion("processDefId >=", value, "processdefid");
            return (Criteria) this;
        }

        public Criteria andProcessdefidLessThan(Long value) {
            addCriterion("processDefId <", value, "processdefid");
            return (Criteria) this;
        }

        public Criteria andProcessdefidLessThanOrEqualTo(Long value) {
            addCriterion("processDefId <=", value, "processdefid");
            return (Criteria) this;
        }

        public Criteria andProcessdefidIn(List<Long> values) {
            addCriterion("processDefId in", values, "processdefid");
            return (Criteria) this;
        }

        public Criteria andProcessdefidNotIn(List<Long> values) {
            addCriterion("processDefId not in", values, "processdefid");
            return (Criteria) this;
        }

        public Criteria andProcessdefidBetween(Long value1, Long value2) {
            addCriterion("processDefId between", value1, value2, "processdefid");
            return (Criteria) this;
        }

        public Criteria andProcessdefidNotBetween(Long value1, Long value2) {
            addCriterion("processDefId not between", value1, value2, "processdefid");
            return (Criteria) this;
        }

        public Criteria andProcessnameIsNull() {
            addCriterion("processName is null");
            return (Criteria) this;
        }

        public Criteria andProcessnameIsNotNull() {
            addCriterion("processName is not null");
            return (Criteria) this;
        }

        public Criteria andProcessnameEqualTo(String value) {
            addCriterion("processName =", value, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameNotEqualTo(String value) {
            addCriterion("processName <>", value, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameGreaterThan(String value) {
            addCriterion("processName >", value, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameGreaterThanOrEqualTo(String value) {
            addCriterion("processName >=", value, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameLessThan(String value) {
            addCriterion("processName <", value, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameLessThanOrEqualTo(String value) {
            addCriterion("processName <=", value, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameLike(String value) {
            addCriterion("processName like", value, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameNotLike(String value) {
            addCriterion("processName not like", value, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameIn(List<String> values) {
            addCriterion("processName in", values, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameNotIn(List<String> values) {
            addCriterion("processName not in", values, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameBetween(String value1, String value2) {
            addCriterion("processName between", value1, value2, "processname");
            return (Criteria) this;
        }

        public Criteria andProcessnameNotBetween(String value1, String value2) {
            addCriterion("processName not between", value1, value2, "processname");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Long value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Long value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Long value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Long value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Long value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Long value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Long> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Long> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Long value1, Long value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Long value1, Long value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentnameIsNull() {
            addCriterion("parentname is null");
            return (Criteria) this;
        }

        public Criteria andParentnameIsNotNull() {
            addCriterion("parentname is not null");
            return (Criteria) this;
        }

        public Criteria andParentnameEqualTo(String value) {
            addCriterion("parentname =", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameNotEqualTo(String value) {
            addCriterion("parentname <>", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameGreaterThan(String value) {
            addCriterion("parentname >", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameGreaterThanOrEqualTo(String value) {
            addCriterion("parentname >=", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameLessThan(String value) {
            addCriterion("parentname <", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameLessThanOrEqualTo(String value) {
            addCriterion("parentname <=", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameLike(String value) {
            addCriterion("parentname like", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameNotLike(String value) {
            addCriterion("parentname not like", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameIn(List<String> values) {
            addCriterion("parentname in", values, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameNotIn(List<String> values) {
            addCriterion("parentname not in", values, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameBetween(String value1, String value2) {
            addCriterion("parentname between", value1, value2, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameNotBetween(String value1, String value2) {
            addCriterion("parentname not between", value1, value2, "parentname");
            return (Criteria) this;
        }

        public Criteria andApplydesIsNull() {
            addCriterion("applydes is null");
            return (Criteria) this;
        }

        public Criteria andApplydesIsNotNull() {
            addCriterion("applydes is not null");
            return (Criteria) this;
        }

        public Criteria andApplydesEqualTo(String value) {
            addCriterion("applydes =", value, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesNotEqualTo(String value) {
            addCriterion("applydes <>", value, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesGreaterThan(String value) {
            addCriterion("applydes >", value, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesGreaterThanOrEqualTo(String value) {
            addCriterion("applydes >=", value, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesLessThan(String value) {
            addCriterion("applydes <", value, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesLessThanOrEqualTo(String value) {
            addCriterion("applydes <=", value, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesLike(String value) {
            addCriterion("applydes like", value, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesNotLike(String value) {
            addCriterion("applydes not like", value, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesIn(List<String> values) {
            addCriterion("applydes in", values, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesNotIn(List<String> values) {
            addCriterion("applydes not in", values, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesBetween(String value1, String value2) {
            addCriterion("applydes between", value1, value2, "applydes");
            return (Criteria) this;
        }

        public Criteria andApplydesNotBetween(String value1, String value2) {
            addCriterion("applydes not between", value1, value2, "applydes");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
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

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Integer value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Integer value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Integer value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Integer value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Integer value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Integer> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Integer> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Integer value1, Integer value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Integer value1, Integer value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andSqnumberIsNull() {
            addCriterion("sqnumber is null");
            return (Criteria) this;
        }

        public Criteria andSqnumberIsNotNull() {
            addCriterion("sqnumber is not null");
            return (Criteria) this;
        }

        public Criteria andSqnumberEqualTo(String value) {
            addCriterion("sqnumber =", value, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberNotEqualTo(String value) {
            addCriterion("sqnumber <>", value, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberGreaterThan(String value) {
            addCriterion("sqnumber >", value, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberGreaterThanOrEqualTo(String value) {
            addCriterion("sqnumber >=", value, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberLessThan(String value) {
            addCriterion("sqnumber <", value, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberLessThanOrEqualTo(String value) {
            addCriterion("sqnumber <=", value, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberLike(String value) {
            addCriterion("sqnumber like", value, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberNotLike(String value) {
            addCriterion("sqnumber not like", value, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberIn(List<String> values) {
            addCriterion("sqnumber in", values, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberNotIn(List<String> values) {
            addCriterion("sqnumber not in", values, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberBetween(String value1, String value2) {
            addCriterion("sqnumber between", value1, value2, "sqnumber");
            return (Criteria) this;
        }

        public Criteria andSqnumberNotBetween(String value1, String value2) {
            addCriterion("sqnumber not between", value1, value2, "sqnumber");
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

        public Criteria andAmountaIsNull() {
            addCriterion("amounta is null");
            return (Criteria) this;
        }

        public Criteria andAmountaIsNotNull() {
            addCriterion("amounta is not null");
            return (Criteria) this;
        }

        public Criteria andAmountaEqualTo(BigDecimal value) {
            addCriterion("amounta =", value, "amounta");
            return (Criteria) this;
        }

        public Criteria andAmountaNotEqualTo(BigDecimal value) {
            addCriterion("amounta <>", value, "amounta");
            return (Criteria) this;
        }

        public Criteria andAmountaGreaterThan(BigDecimal value) {
            addCriterion("amounta >", value, "amounta");
            return (Criteria) this;
        }

        public Criteria andAmountaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amounta >=", value, "amounta");
            return (Criteria) this;
        }

        public Criteria andAmountaLessThan(BigDecimal value) {
            addCriterion("amounta <", value, "amounta");
            return (Criteria) this;
        }

        public Criteria andAmountaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amounta <=", value, "amounta");
            return (Criteria) this;
        }

        public Criteria andAmountaIn(List<BigDecimal> values) {
            addCriterion("amounta in", values, "amounta");
            return (Criteria) this;
        }

        public Criteria andAmountaNotIn(List<BigDecimal> values) {
            addCriterion("amounta not in", values, "amounta");
            return (Criteria) this;
        }

        public Criteria andAmountaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amounta between", value1, value2, "amounta");
            return (Criteria) this;
        }

        public Criteria andAmountaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amounta not between", value1, value2, "amounta");
            return (Criteria) this;
        }

        public Criteria andAmountbIsNull() {
            addCriterion("amountb is null");
            return (Criteria) this;
        }

        public Criteria andAmountbIsNotNull() {
            addCriterion("amountb is not null");
            return (Criteria) this;
        }

        public Criteria andAmountbEqualTo(BigDecimal value) {
            addCriterion("amountb =", value, "amountb");
            return (Criteria) this;
        }

        public Criteria andAmountbNotEqualTo(BigDecimal value) {
            addCriterion("amountb <>", value, "amountb");
            return (Criteria) this;
        }

        public Criteria andAmountbGreaterThan(BigDecimal value) {
            addCriterion("amountb >", value, "amountb");
            return (Criteria) this;
        }

        public Criteria andAmountbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amountb >=", value, "amountb");
            return (Criteria) this;
        }

        public Criteria andAmountbLessThan(BigDecimal value) {
            addCriterion("amountb <", value, "amountb");
            return (Criteria) this;
        }

        public Criteria andAmountbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amountb <=", value, "amountb");
            return (Criteria) this;
        }

        public Criteria andAmountbIn(List<BigDecimal> values) {
            addCriterion("amountb in", values, "amountb");
            return (Criteria) this;
        }

        public Criteria andAmountbNotIn(List<BigDecimal> values) {
            addCriterion("amountb not in", values, "amountb");
            return (Criteria) this;
        }

        public Criteria andAmountbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amountb between", value1, value2, "amountb");
            return (Criteria) this;
        }

        public Criteria andAmountbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amountb not between", value1, value2, "amountb");
            return (Criteria) this;
        }

        public Criteria andAmountcIsNull() {
            addCriterion("amountc is null");
            return (Criteria) this;
        }

        public Criteria andAmountcIsNotNull() {
            addCriterion("amountc is not null");
            return (Criteria) this;
        }

        public Criteria andAmountcEqualTo(BigDecimal value) {
            addCriterion("amountc =", value, "amountc");
            return (Criteria) this;
        }

        public Criteria andAmountcNotEqualTo(BigDecimal value) {
            addCriterion("amountc <>", value, "amountc");
            return (Criteria) this;
        }

        public Criteria andAmountcGreaterThan(BigDecimal value) {
            addCriterion("amountc >", value, "amountc");
            return (Criteria) this;
        }

        public Criteria andAmountcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amountc >=", value, "amountc");
            return (Criteria) this;
        }

        public Criteria andAmountcLessThan(BigDecimal value) {
            addCriterion("amountc <", value, "amountc");
            return (Criteria) this;
        }

        public Criteria andAmountcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amountc <=", value, "amountc");
            return (Criteria) this;
        }

        public Criteria andAmountcIn(List<BigDecimal> values) {
            addCriterion("amountc in", values, "amountc");
            return (Criteria) this;
        }

        public Criteria andAmountcNotIn(List<BigDecimal> values) {
            addCriterion("amountc not in", values, "amountc");
            return (Criteria) this;
        }

        public Criteria andAmountcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amountc between", value1, value2, "amountc");
            return (Criteria) this;
        }

        public Criteria andAmountcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amountc not between", value1, value2, "amountc");
            return (Criteria) this;
        }

        public Criteria andRemarkaIsNull() {
            addCriterion("remarka is null");
            return (Criteria) this;
        }

        public Criteria andRemarkaIsNotNull() {
            addCriterion("remarka is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkaEqualTo(String value) {
            addCriterion("remarka =", value, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaNotEqualTo(String value) {
            addCriterion("remarka <>", value, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaGreaterThan(String value) {
            addCriterion("remarka >", value, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaGreaterThanOrEqualTo(String value) {
            addCriterion("remarka >=", value, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaLessThan(String value) {
            addCriterion("remarka <", value, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaLessThanOrEqualTo(String value) {
            addCriterion("remarka <=", value, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaLike(String value) {
            addCriterion("remarka like", value, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaNotLike(String value) {
            addCriterion("remarka not like", value, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaIn(List<String> values) {
            addCriterion("remarka in", values, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaNotIn(List<String> values) {
            addCriterion("remarka not in", values, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaBetween(String value1, String value2) {
            addCriterion("remarka between", value1, value2, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkaNotBetween(String value1, String value2) {
            addCriterion("remarka not between", value1, value2, "remarka");
            return (Criteria) this;
        }

        public Criteria andRemarkbIsNull() {
            addCriterion("remarkb is null");
            return (Criteria) this;
        }

        public Criteria andRemarkbIsNotNull() {
            addCriterion("remarkb is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkbEqualTo(String value) {
            addCriterion("remarkb =", value, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbNotEqualTo(String value) {
            addCriterion("remarkb <>", value, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbGreaterThan(String value) {
            addCriterion("remarkb >", value, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbGreaterThanOrEqualTo(String value) {
            addCriterion("remarkb >=", value, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbLessThan(String value) {
            addCriterion("remarkb <", value, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbLessThanOrEqualTo(String value) {
            addCriterion("remarkb <=", value, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbLike(String value) {
            addCriterion("remarkb like", value, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbNotLike(String value) {
            addCriterion("remarkb not like", value, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbIn(List<String> values) {
            addCriterion("remarkb in", values, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbNotIn(List<String> values) {
            addCriterion("remarkb not in", values, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbBetween(String value1, String value2) {
            addCriterion("remarkb between", value1, value2, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkbNotBetween(String value1, String value2) {
            addCriterion("remarkb not between", value1, value2, "remarkb");
            return (Criteria) this;
        }

        public Criteria andRemarkcIsNull() {
            addCriterion("remarkc is null");
            return (Criteria) this;
        }

        public Criteria andRemarkcIsNotNull() {
            addCriterion("remarkc is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkcEqualTo(String value) {
            addCriterion("remarkc =", value, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcNotEqualTo(String value) {
            addCriterion("remarkc <>", value, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcGreaterThan(String value) {
            addCriterion("remarkc >", value, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcGreaterThanOrEqualTo(String value) {
            addCriterion("remarkc >=", value, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcLessThan(String value) {
            addCriterion("remarkc <", value, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcLessThanOrEqualTo(String value) {
            addCriterion("remarkc <=", value, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcLike(String value) {
            addCriterion("remarkc like", value, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcNotLike(String value) {
            addCriterion("remarkc not like", value, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcIn(List<String> values) {
            addCriterion("remarkc in", values, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcNotIn(List<String> values) {
            addCriterion("remarkc not in", values, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcBetween(String value1, String value2) {
            addCriterion("remarkc between", value1, value2, "remarkc");
            return (Criteria) this;
        }

        public Criteria andRemarkcNotBetween(String value1, String value2) {
            addCriterion("remarkc not between", value1, value2, "remarkc");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNull() {
            addCriterion("applydate is null");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNotNull() {
            addCriterion("applydate is not null");
            return (Criteria) this;
        }

        public Criteria andApplydateEqualTo(Date value) {
            addCriterion("applydate =", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotEqualTo(Date value) {
            addCriterion("applydate <>", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThan(Date value) {
            addCriterion("applydate >", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThanOrEqualTo(Date value) {
            addCriterion("applydate >=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThan(Date value) {
            addCriterion("applydate <", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThanOrEqualTo(Date value) {
            addCriterion("applydate <=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateIn(List<Date> values) {
            addCriterion("applydate in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotIn(List<Date> values) {
            addCriterion("applydate not in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateBetween(Date value1, Date value2) {
            addCriterion("applydate between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotBetween(Date value1, Date value2) {
            addCriterion("applydate not between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andCreatdateIsNull() {
            addCriterion("creatdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatdateIsNotNull() {
            addCriterion("creatdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatdateEqualTo(Date value) {
            addCriterion("creatdate =", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotEqualTo(Date value) {
            addCriterion("creatdate <>", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateGreaterThan(Date value) {
            addCriterion("creatdate >", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateGreaterThanOrEqualTo(Date value) {
            addCriterion("creatdate >=", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateLessThan(Date value) {
            addCriterion("creatdate <", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateLessThanOrEqualTo(Date value) {
            addCriterion("creatdate <=", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateIn(List<Date> values) {
            addCriterion("creatdate in", values, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotIn(List<Date> values) {
            addCriterion("creatdate not in", values, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateBetween(Date value1, Date value2) {
            addCriterion("creatdate between", value1, value2, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotBetween(Date value1, Date value2) {
            addCriterion("creatdate not between", value1, value2, "creatdate");
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