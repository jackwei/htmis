package com.git.db.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblPassurePayMentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblPassurePayMentsExample() {
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

        public Criteria andPassurepayidIsNull() {
            addCriterion("passurepayid is null");
            return (Criteria) this;
        }

        public Criteria andPassurepayidIsNotNull() {
            addCriterion("passurepayid is not null");
            return (Criteria) this;
        }

        public Criteria andPassurepayidEqualTo(Long value) {
            addCriterion("passurepayid =", value, "passurepayid");
            return (Criteria) this;
        }

        public Criteria andPassurepayidNotEqualTo(Long value) {
            addCriterion("passurepayid <>", value, "passurepayid");
            return (Criteria) this;
        }

        public Criteria andPassurepayidGreaterThan(Long value) {
            addCriterion("passurepayid >", value, "passurepayid");
            return (Criteria) this;
        }

        public Criteria andPassurepayidGreaterThanOrEqualTo(Long value) {
            addCriterion("passurepayid >=", value, "passurepayid");
            return (Criteria) this;
        }

        public Criteria andPassurepayidLessThan(Long value) {
            addCriterion("passurepayid <", value, "passurepayid");
            return (Criteria) this;
        }

        public Criteria andPassurepayidLessThanOrEqualTo(Long value) {
            addCriterion("passurepayid <=", value, "passurepayid");
            return (Criteria) this;
        }

        public Criteria andPassurepayidIn(List<Long> values) {
            addCriterion("passurepayid in", values, "passurepayid");
            return (Criteria) this;
        }

        public Criteria andPassurepayidNotIn(List<Long> values) {
            addCriterion("passurepayid not in", values, "passurepayid");
            return (Criteria) this;
        }

        public Criteria andPassurepayidBetween(Long value1, Long value2) {
            addCriterion("passurepayid between", value1, value2, "passurepayid");
            return (Criteria) this;
        }

        public Criteria andPassurepayidNotBetween(Long value1, Long value2) {
            addCriterion("passurepayid not between", value1, value2, "passurepayid");
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
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

        public Criteria andReportflagIsNull() {
            addCriterion("reportflag is null");
            return (Criteria) this;
        }

        public Criteria andReportflagIsNotNull() {
            addCriterion("reportflag is not null");
            return (Criteria) this;
        }

        public Criteria andReportflagEqualTo(String value) {
            addCriterion("reportflag =", value, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagNotEqualTo(String value) {
            addCriterion("reportflag <>", value, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagGreaterThan(String value) {
            addCriterion("reportflag >", value, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagGreaterThanOrEqualTo(String value) {
            addCriterion("reportflag >=", value, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagLessThan(String value) {
            addCriterion("reportflag <", value, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagLessThanOrEqualTo(String value) {
            addCriterion("reportflag <=", value, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagLike(String value) {
            addCriterion("reportflag like", value, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagNotLike(String value) {
            addCriterion("reportflag not like", value, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagIn(List<String> values) {
            addCriterion("reportflag in", values, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagNotIn(List<String> values) {
            addCriterion("reportflag not in", values, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagBetween(String value1, String value2) {
            addCriterion("reportflag between", value1, value2, "reportflag");
            return (Criteria) this;
        }

        public Criteria andReportflagNotBetween(String value1, String value2) {
            addCriterion("reportflag not between", value1, value2, "reportflag");
            return (Criteria) this;
        }

        public Criteria andPaydateIsNull() {
            addCriterion("paydate is null");
            return (Criteria) this;
        }

        public Criteria andPaydateIsNotNull() {
            addCriterion("paydate is not null");
            return (Criteria) this;
        }

        public Criteria andPaydateEqualTo(Date value) {
            addCriterion("paydate =", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotEqualTo(Date value) {
            addCriterion("paydate <>", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateGreaterThan(Date value) {
            addCriterion("paydate >", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateGreaterThanOrEqualTo(Date value) {
            addCriterion("paydate >=", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLessThan(Date value) {
            addCriterion("paydate <", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLessThanOrEqualTo(Date value) {
            addCriterion("paydate <=", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateIn(List<Date> values) {
            addCriterion("paydate in", values, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotIn(List<Date> values) {
            addCriterion("paydate not in", values, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateBetween(Date value1, Date value2) {
            addCriterion("paydate between", value1, value2, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotBetween(Date value1, Date value2) {
            addCriterion("paydate not between", value1, value2, "paydate");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNull() {
            addCriterion("orgcode is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNotNull() {
            addCriterion("orgcode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeEqualTo(String value) {
            addCriterion("orgcode =", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotEqualTo(String value) {
            addCriterion("orgcode <>", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThan(String value) {
            addCriterion("orgcode >", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("orgcode >=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThan(String value) {
            addCriterion("orgcode <", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("orgcode <=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLike(String value) {
            addCriterion("orgcode like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotLike(String value) {
            addCriterion("orgcode not like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIn(List<String> values) {
            addCriterion("orgcode in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotIn(List<String> values) {
            addCriterion("orgcode not in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeBetween(String value1, String value2) {
            addCriterion("orgcode between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotBetween(String value1, String value2) {
            addCriterion("orgcode not between", value1, value2, "orgcode");
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

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Long value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Long value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Long value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Long value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Long value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Long> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Long> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Long value1, Long value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Long value1, Long value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andFeemountIsNull() {
            addCriterion("feemount is null");
            return (Criteria) this;
        }

        public Criteria andFeemountIsNotNull() {
            addCriterion("feemount is not null");
            return (Criteria) this;
        }

        public Criteria andFeemountEqualTo(BigDecimal value) {
            addCriterion("feemount =", value, "feemount");
            return (Criteria) this;
        }

        public Criteria andFeemountNotEqualTo(BigDecimal value) {
            addCriterion("feemount <>", value, "feemount");
            return (Criteria) this;
        }

        public Criteria andFeemountGreaterThan(BigDecimal value) {
            addCriterion("feemount >", value, "feemount");
            return (Criteria) this;
        }

        public Criteria andFeemountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("feemount >=", value, "feemount");
            return (Criteria) this;
        }

        public Criteria andFeemountLessThan(BigDecimal value) {
            addCriterion("feemount <", value, "feemount");
            return (Criteria) this;
        }

        public Criteria andFeemountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("feemount <=", value, "feemount");
            return (Criteria) this;
        }

        public Criteria andFeemountIn(List<BigDecimal> values) {
            addCriterion("feemount in", values, "feemount");
            return (Criteria) this;
        }

        public Criteria andFeemountNotIn(List<BigDecimal> values) {
            addCriterion("feemount not in", values, "feemount");
            return (Criteria) this;
        }

        public Criteria andFeemountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("feemount between", value1, value2, "feemount");
            return (Criteria) this;
        }

        public Criteria andFeemountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("feemount not between", value1, value2, "feemount");
            return (Criteria) this;
        }

        public Criteria andReceivedetailIsNull() {
            addCriterion("receivedetail is null");
            return (Criteria) this;
        }

        public Criteria andReceivedetailIsNotNull() {
            addCriterion("receivedetail is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedetailEqualTo(String value) {
            addCriterion("receivedetail =", value, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailNotEqualTo(String value) {
            addCriterion("receivedetail <>", value, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailGreaterThan(String value) {
            addCriterion("receivedetail >", value, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailGreaterThanOrEqualTo(String value) {
            addCriterion("receivedetail >=", value, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailLessThan(String value) {
            addCriterion("receivedetail <", value, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailLessThanOrEqualTo(String value) {
            addCriterion("receivedetail <=", value, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailLike(String value) {
            addCriterion("receivedetail like", value, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailNotLike(String value) {
            addCriterion("receivedetail not like", value, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailIn(List<String> values) {
            addCriterion("receivedetail in", values, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailNotIn(List<String> values) {
            addCriterion("receivedetail not in", values, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailBetween(String value1, String value2) {
            addCriterion("receivedetail between", value1, value2, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andReceivedetailNotBetween(String value1, String value2) {
            addCriterion("receivedetail not between", value1, value2, "receivedetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailIsNull() {
            addCriterion("paydetail is null");
            return (Criteria) this;
        }

        public Criteria andPaydetailIsNotNull() {
            addCriterion("paydetail is not null");
            return (Criteria) this;
        }

        public Criteria andPaydetailEqualTo(String value) {
            addCriterion("paydetail =", value, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailNotEqualTo(String value) {
            addCriterion("paydetail <>", value, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailGreaterThan(String value) {
            addCriterion("paydetail >", value, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailGreaterThanOrEqualTo(String value) {
            addCriterion("paydetail >=", value, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailLessThan(String value) {
            addCriterion("paydetail <", value, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailLessThanOrEqualTo(String value) {
            addCriterion("paydetail <=", value, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailLike(String value) {
            addCriterion("paydetail like", value, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailNotLike(String value) {
            addCriterion("paydetail not like", value, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailIn(List<String> values) {
            addCriterion("paydetail in", values, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailNotIn(List<String> values) {
            addCriterion("paydetail not in", values, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailBetween(String value1, String value2) {
            addCriterion("paydetail between", value1, value2, "paydetail");
            return (Criteria) this;
        }

        public Criteria andPaydetailNotBetween(String value1, String value2) {
            addCriterion("paydetail not between", value1, value2, "paydetail");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridIsNull() {
            addCriterion("CreateOperatorId is null");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridIsNotNull() {
            addCriterion("CreateOperatorId is not null");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridEqualTo(Long value) {
            addCriterion("CreateOperatorId =", value, "createoperatorid");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridNotEqualTo(Long value) {
            addCriterion("CreateOperatorId <>", value, "createoperatorid");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridGreaterThan(Long value) {
            addCriterion("CreateOperatorId >", value, "createoperatorid");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridGreaterThanOrEqualTo(Long value) {
            addCriterion("CreateOperatorId >=", value, "createoperatorid");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridLessThan(Long value) {
            addCriterion("CreateOperatorId <", value, "createoperatorid");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridLessThanOrEqualTo(Long value) {
            addCriterion("CreateOperatorId <=", value, "createoperatorid");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridIn(List<Long> values) {
            addCriterion("CreateOperatorId in", values, "createoperatorid");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridNotIn(List<Long> values) {
            addCriterion("CreateOperatorId not in", values, "createoperatorid");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridBetween(Long value1, Long value2) {
            addCriterion("CreateOperatorId between", value1, value2, "createoperatorid");
            return (Criteria) this;
        }

        public Criteria andCreateoperatoridNotBetween(Long value1, Long value2) {
            addCriterion("CreateOperatorId not between", value1, value2, "createoperatorid");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridIsNull() {
            addCriterion("ModifyOperatorId is null");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridIsNotNull() {
            addCriterion("ModifyOperatorId is not null");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridEqualTo(Long value) {
            addCriterion("ModifyOperatorId =", value, "modifyoperatorid");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridNotEqualTo(Long value) {
            addCriterion("ModifyOperatorId <>", value, "modifyoperatorid");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridGreaterThan(Long value) {
            addCriterion("ModifyOperatorId >", value, "modifyoperatorid");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridGreaterThanOrEqualTo(Long value) {
            addCriterion("ModifyOperatorId >=", value, "modifyoperatorid");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridLessThan(Long value) {
            addCriterion("ModifyOperatorId <", value, "modifyoperatorid");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridLessThanOrEqualTo(Long value) {
            addCriterion("ModifyOperatorId <=", value, "modifyoperatorid");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridIn(List<Long> values) {
            addCriterion("ModifyOperatorId in", values, "modifyoperatorid");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridNotIn(List<Long> values) {
            addCriterion("ModifyOperatorId not in", values, "modifyoperatorid");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridBetween(Long value1, Long value2) {
            addCriterion("ModifyOperatorId between", value1, value2, "modifyoperatorid");
            return (Criteria) this;
        }

        public Criteria andModifyoperatoridNotBetween(Long value1, Long value2) {
            addCriterion("ModifyOperatorId not between", value1, value2, "modifyoperatorid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("ModifyTime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("ModifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterion("ModifyTime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterion("ModifyTime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterion("ModifyTime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ModifyTime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterion("ModifyTime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("ModifyTime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterion("ModifyTime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterion("ModifyTime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterion("ModifyTime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("ModifyTime not between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andCpidIsNull() {
            addCriterion("cpid is null");
            return (Criteria) this;
        }

        public Criteria andCpidIsNotNull() {
            addCriterion("cpid is not null");
            return (Criteria) this;
        }

        public Criteria andCpidEqualTo(Long value) {
            addCriterion("cpid =", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidNotEqualTo(Long value) {
            addCriterion("cpid <>", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidGreaterThan(Long value) {
            addCriterion("cpid >", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidGreaterThanOrEqualTo(Long value) {
            addCriterion("cpid >=", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidLessThan(Long value) {
            addCriterion("cpid <", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidLessThanOrEqualTo(Long value) {
            addCriterion("cpid <=", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidIn(List<Long> values) {
            addCriterion("cpid in", values, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidNotIn(List<Long> values) {
            addCriterion("cpid not in", values, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidBetween(Long value1, Long value2) {
            addCriterion("cpid between", value1, value2, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidNotBetween(Long value1, Long value2) {
            addCriterion("cpid not between", value1, value2, "cpid");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Long value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Long value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Long value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Long value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Long value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Long value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Long> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Long> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Long value1, Long value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Long value1, Long value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Long value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Long value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Long value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Long value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Long value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Long value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Long> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Long> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Long value1, Long value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Long value1, Long value2) {
            addCriterion("month not between", value1, value2, "month");
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