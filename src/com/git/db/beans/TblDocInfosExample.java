package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblDocInfosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblDocInfosExample() {
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

        public Criteria andApplyidIsNull() {
            addCriterion("applyid is null");
            return (Criteria) this;
        }

        public Criteria andApplyidIsNotNull() {
            addCriterion("applyid is not null");
            return (Criteria) this;
        }

        public Criteria andApplyidEqualTo(Long value) {
            addCriterion("applyid =", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotEqualTo(Long value) {
            addCriterion("applyid <>", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThan(Long value) {
            addCriterion("applyid >", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThanOrEqualTo(Long value) {
            addCriterion("applyid >=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThan(Long value) {
            addCriterion("applyid <", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThanOrEqualTo(Long value) {
            addCriterion("applyid <=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidIn(List<Long> values) {
            addCriterion("applyid in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotIn(List<Long> values) {
            addCriterion("applyid not in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidBetween(Long value1, Long value2) {
            addCriterion("applyid between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotBetween(Long value1, Long value2) {
            addCriterion("applyid not between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andDoctypeIsNull() {
            addCriterion("doctype is null");
            return (Criteria) this;
        }

        public Criteria andDoctypeIsNotNull() {
            addCriterion("doctype is not null");
            return (Criteria) this;
        }

        public Criteria andDoctypeEqualTo(String value) {
            addCriterion("doctype =", value, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeNotEqualTo(String value) {
            addCriterion("doctype <>", value, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeGreaterThan(String value) {
            addCriterion("doctype >", value, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeGreaterThanOrEqualTo(String value) {
            addCriterion("doctype >=", value, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeLessThan(String value) {
            addCriterion("doctype <", value, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeLessThanOrEqualTo(String value) {
            addCriterion("doctype <=", value, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeLike(String value) {
            addCriterion("doctype like", value, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeNotLike(String value) {
            addCriterion("doctype not like", value, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeIn(List<String> values) {
            addCriterion("doctype in", values, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeNotIn(List<String> values) {
            addCriterion("doctype not in", values, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeBetween(String value1, String value2) {
            addCriterion("doctype between", value1, value2, "doctype");
            return (Criteria) this;
        }

        public Criteria andDoctypeNotBetween(String value1, String value2) {
            addCriterion("doctype not between", value1, value2, "doctype");
            return (Criteria) this;
        }

        public Criteria andDocnameIsNull() {
            addCriterion("docname is null");
            return (Criteria) this;
        }

        public Criteria andDocnameIsNotNull() {
            addCriterion("docname is not null");
            return (Criteria) this;
        }

        public Criteria andDocnameEqualTo(String value) {
            addCriterion("docname =", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotEqualTo(String value) {
            addCriterion("docname <>", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameGreaterThan(String value) {
            addCriterion("docname >", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameGreaterThanOrEqualTo(String value) {
            addCriterion("docname >=", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameLessThan(String value) {
            addCriterion("docname <", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameLessThanOrEqualTo(String value) {
            addCriterion("docname <=", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameLike(String value) {
            addCriterion("docname like", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotLike(String value) {
            addCriterion("docname not like", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameIn(List<String> values) {
            addCriterion("docname in", values, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotIn(List<String> values) {
            addCriterion("docname not in", values, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameBetween(String value1, String value2) {
            addCriterion("docname between", value1, value2, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotBetween(String value1, String value2) {
            addCriterion("docname not between", value1, value2, "docname");
            return (Criteria) this;
        }

        public Criteria andDocdesIsNull() {
            addCriterion("docdes is null");
            return (Criteria) this;
        }

        public Criteria andDocdesIsNotNull() {
            addCriterion("docdes is not null");
            return (Criteria) this;
        }

        public Criteria andDocdesEqualTo(String value) {
            addCriterion("docdes =", value, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesNotEqualTo(String value) {
            addCriterion("docdes <>", value, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesGreaterThan(String value) {
            addCriterion("docdes >", value, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesGreaterThanOrEqualTo(String value) {
            addCriterion("docdes >=", value, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesLessThan(String value) {
            addCriterion("docdes <", value, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesLessThanOrEqualTo(String value) {
            addCriterion("docdes <=", value, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesLike(String value) {
            addCriterion("docdes like", value, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesNotLike(String value) {
            addCriterion("docdes not like", value, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesIn(List<String> values) {
            addCriterion("docdes in", values, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesNotIn(List<String> values) {
            addCriterion("docdes not in", values, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesBetween(String value1, String value2) {
            addCriterion("docdes between", value1, value2, "docdes");
            return (Criteria) this;
        }

        public Criteria andDocdesNotBetween(String value1, String value2) {
            addCriterion("docdes not between", value1, value2, "docdes");
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

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilelocationIsNull() {
            addCriterion("filelocation is null");
            return (Criteria) this;
        }

        public Criteria andFilelocationIsNotNull() {
            addCriterion("filelocation is not null");
            return (Criteria) this;
        }

        public Criteria andFilelocationEqualTo(String value) {
            addCriterion("filelocation =", value, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationNotEqualTo(String value) {
            addCriterion("filelocation <>", value, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationGreaterThan(String value) {
            addCriterion("filelocation >", value, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationGreaterThanOrEqualTo(String value) {
            addCriterion("filelocation >=", value, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationLessThan(String value) {
            addCriterion("filelocation <", value, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationLessThanOrEqualTo(String value) {
            addCriterion("filelocation <=", value, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationLike(String value) {
            addCriterion("filelocation like", value, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationNotLike(String value) {
            addCriterion("filelocation not like", value, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationIn(List<String> values) {
            addCriterion("filelocation in", values, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationNotIn(List<String> values) {
            addCriterion("filelocation not in", values, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationBetween(String value1, String value2) {
            addCriterion("filelocation between", value1, value2, "filelocation");
            return (Criteria) this;
        }

        public Criteria andFilelocationNotBetween(String value1, String value2) {
            addCriterion("filelocation not between", value1, value2, "filelocation");
            return (Criteria) this;
        }

        public Criteria andSecretflagIsNull() {
            addCriterion("secretflag is null");
            return (Criteria) this;
        }

        public Criteria andSecretflagIsNotNull() {
            addCriterion("secretflag is not null");
            return (Criteria) this;
        }

        public Criteria andSecretflagEqualTo(String value) {
            addCriterion("secretflag =", value, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagNotEqualTo(String value) {
            addCriterion("secretflag <>", value, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagGreaterThan(String value) {
            addCriterion("secretflag >", value, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagGreaterThanOrEqualTo(String value) {
            addCriterion("secretflag >=", value, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagLessThan(String value) {
            addCriterion("secretflag <", value, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagLessThanOrEqualTo(String value) {
            addCriterion("secretflag <=", value, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagLike(String value) {
            addCriterion("secretflag like", value, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagNotLike(String value) {
            addCriterion("secretflag not like", value, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagIn(List<String> values) {
            addCriterion("secretflag in", values, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagNotIn(List<String> values) {
            addCriterion("secretflag not in", values, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagBetween(String value1, String value2) {
            addCriterion("secretflag between", value1, value2, "secretflag");
            return (Criteria) this;
        }

        public Criteria andSecretflagNotBetween(String value1, String value2) {
            addCriterion("secretflag not between", value1, value2, "secretflag");
            return (Criteria) this;
        }

        public Criteria andContenttypeIsNull() {
            addCriterion("contenttype is null");
            return (Criteria) this;
        }

        public Criteria andContenttypeIsNotNull() {
            addCriterion("contenttype is not null");
            return (Criteria) this;
        }

        public Criteria andContenttypeEqualTo(String value) {
            addCriterion("contenttype =", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotEqualTo(String value) {
            addCriterion("contenttype <>", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeGreaterThan(String value) {
            addCriterion("contenttype >", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("contenttype >=", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLessThan(String value) {
            addCriterion("contenttype <", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLessThanOrEqualTo(String value) {
            addCriterion("contenttype <=", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLike(String value) {
            addCriterion("contenttype like", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotLike(String value) {
            addCriterion("contenttype not like", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeIn(List<String> values) {
            addCriterion("contenttype in", values, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotIn(List<String> values) {
            addCriterion("contenttype not in", values, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeBetween(String value1, String value2) {
            addCriterion("contenttype between", value1, value2, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotBetween(String value1, String value2) {
            addCriterion("contenttype not between", value1, value2, "contenttype");
            return (Criteria) this;
        }

        public Criteria andParent2idIsNull() {
            addCriterion("parent2id is null");
            return (Criteria) this;
        }

        public Criteria andParent2idIsNotNull() {
            addCriterion("parent2id is not null");
            return (Criteria) this;
        }

        public Criteria andParent2idEqualTo(String value) {
            addCriterion("parent2id =", value, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idNotEqualTo(String value) {
            addCriterion("parent2id <>", value, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idGreaterThan(String value) {
            addCriterion("parent2id >", value, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idGreaterThanOrEqualTo(String value) {
            addCriterion("parent2id >=", value, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idLessThan(String value) {
            addCriterion("parent2id <", value, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idLessThanOrEqualTo(String value) {
            addCriterion("parent2id <=", value, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idLike(String value) {
            addCriterion("parent2id like", value, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idNotLike(String value) {
            addCriterion("parent2id not like", value, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idIn(List<String> values) {
            addCriterion("parent2id in", values, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idNotIn(List<String> values) {
            addCriterion("parent2id not in", values, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idBetween(String value1, String value2) {
            addCriterion("parent2id between", value1, value2, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2idNotBetween(String value1, String value2) {
            addCriterion("parent2id not between", value1, value2, "parent2id");
            return (Criteria) this;
        }

        public Criteria andParent2nameIsNull() {
            addCriterion("parent2name is null");
            return (Criteria) this;
        }

        public Criteria andParent2nameIsNotNull() {
            addCriterion("parent2name is not null");
            return (Criteria) this;
        }

        public Criteria andParent2nameEqualTo(String value) {
            addCriterion("parent2name =", value, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameNotEqualTo(String value) {
            addCriterion("parent2name <>", value, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameGreaterThan(String value) {
            addCriterion("parent2name >", value, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameGreaterThanOrEqualTo(String value) {
            addCriterion("parent2name >=", value, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameLessThan(String value) {
            addCriterion("parent2name <", value, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameLessThanOrEqualTo(String value) {
            addCriterion("parent2name <=", value, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameLike(String value) {
            addCriterion("parent2name like", value, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameNotLike(String value) {
            addCriterion("parent2name not like", value, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameIn(List<String> values) {
            addCriterion("parent2name in", values, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameNotIn(List<String> values) {
            addCriterion("parent2name not in", values, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameBetween(String value1, String value2) {
            addCriterion("parent2name between", value1, value2, "parent2name");
            return (Criteria) this;
        }

        public Criteria andParent2nameNotBetween(String value1, String value2) {
            addCriterion("parent2name not between", value1, value2, "parent2name");
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