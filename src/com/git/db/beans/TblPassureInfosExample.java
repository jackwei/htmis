package com.git.db.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TblPassureInfosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblPassureInfosExample() {
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

        public Criteria andPassureidIsNull() {
            addCriterion("passureid is null");
            return (Criteria) this;
        }

        public Criteria andPassureidIsNotNull() {
            addCriterion("passureid is not null");
            return (Criteria) this;
        }

        public Criteria andPassureidEqualTo(Long value) {
            addCriterion("passureid =", value, "passureid");
            return (Criteria) this;
        }

        public Criteria andPassureidNotEqualTo(Long value) {
            addCriterion("passureid <>", value, "passureid");
            return (Criteria) this;
        }

        public Criteria andPassureidGreaterThan(Long value) {
            addCriterion("passureid >", value, "passureid");
            return (Criteria) this;
        }

        public Criteria andPassureidGreaterThanOrEqualTo(Long value) {
            addCriterion("passureid >=", value, "passureid");
            return (Criteria) this;
        }

        public Criteria andPassureidLessThan(Long value) {
            addCriterion("passureid <", value, "passureid");
            return (Criteria) this;
        }

        public Criteria andPassureidLessThanOrEqualTo(Long value) {
            addCriterion("passureid <=", value, "passureid");
            return (Criteria) this;
        }

        public Criteria andPassureidIn(List<Long> values) {
            addCriterion("passureid in", values, "passureid");
            return (Criteria) this;
        }

        public Criteria andPassureidNotIn(List<Long> values) {
            addCriterion("passureid not in", values, "passureid");
            return (Criteria) this;
        }

        public Criteria andPassureidBetween(Long value1, Long value2) {
            addCriterion("passureid between", value1, value2, "passureid");
            return (Criteria) this;
        }

        public Criteria andPassureidNotBetween(Long value1, Long value2) {
            addCriterion("passureid not between", value1, value2, "passureid");
            return (Criteria) this;
        }

        public Criteria andAssurenumIsNull() {
            addCriterion("assurenum is null");
            return (Criteria) this;
        }

        public Criteria andAssurenumIsNotNull() {
            addCriterion("assurenum is not null");
            return (Criteria) this;
        }

        public Criteria andAssurenumEqualTo(String value) {
            addCriterion("assurenum =", value, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumNotEqualTo(String value) {
            addCriterion("assurenum <>", value, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumGreaterThan(String value) {
            addCriterion("assurenum >", value, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumGreaterThanOrEqualTo(String value) {
            addCriterion("assurenum >=", value, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumLessThan(String value) {
            addCriterion("assurenum <", value, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumLessThanOrEqualTo(String value) {
            addCriterion("assurenum <=", value, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumLike(String value) {
            addCriterion("assurenum like", value, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumNotLike(String value) {
            addCriterion("assurenum not like", value, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumIn(List<String> values) {
            addCriterion("assurenum in", values, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumNotIn(List<String> values) {
            addCriterion("assurenum not in", values, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumBetween(String value1, String value2) {
            addCriterion("assurenum between", value1, value2, "assurenum");
            return (Criteria) this;
        }

        public Criteria andAssurenumNotBetween(String value1, String value2) {
            addCriterion("assurenum not between", value1, value2, "assurenum");
            return (Criteria) this;
        }

        public Criteria andCaseidIsNull() {
            addCriterion("caseid is null");
            return (Criteria) this;
        }

        public Criteria andCaseidIsNotNull() {
            addCriterion("caseid is not null");
            return (Criteria) this;
        }

        public Criteria andCaseidEqualTo(Long value) {
            addCriterion("caseid =", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotEqualTo(Long value) {
            addCriterion("caseid <>", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidGreaterThan(Long value) {
            addCriterion("caseid >", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidGreaterThanOrEqualTo(Long value) {
            addCriterion("caseid >=", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLessThan(Long value) {
            addCriterion("caseid <", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLessThanOrEqualTo(Long value) {
            addCriterion("caseid <=", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidIn(List<Long> values) {
            addCriterion("caseid in", values, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotIn(List<Long> values) {
            addCriterion("caseid not in", values, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidBetween(Long value1, Long value2) {
            addCriterion("caseid between", value1, value2, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotBetween(Long value1, Long value2) {
            addCriterion("caseid not between", value1, value2, "caseid");
            return (Criteria) this;
        }

        public Criteria andFeeidIsNull() {
            addCriterion("feeid is null");
            return (Criteria) this;
        }

        public Criteria andFeeidIsNotNull() {
            addCriterion("feeid is not null");
            return (Criteria) this;
        }

        public Criteria andFeeidEqualTo(Long value) {
            addCriterion("feeid =", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidNotEqualTo(Long value) {
            addCriterion("feeid <>", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidGreaterThan(Long value) {
            addCriterion("feeid >", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidGreaterThanOrEqualTo(Long value) {
            addCriterion("feeid >=", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidLessThan(Long value) {
            addCriterion("feeid <", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidLessThanOrEqualTo(Long value) {
            addCriterion("feeid <=", value, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidIn(List<Long> values) {
            addCriterion("feeid in", values, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidNotIn(List<Long> values) {
            addCriterion("feeid not in", values, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidBetween(Long value1, Long value2) {
            addCriterion("feeid between", value1, value2, "feeid");
            return (Criteria) this;
        }

        public Criteria andFeeidNotBetween(Long value1, Long value2) {
            addCriterion("feeid not between", value1, value2, "feeid");
            return (Criteria) this;
        }

        public Criteria andRewarranteridIsNull() {
            addCriterion("rewarranterid is null");
            return (Criteria) this;
        }

        public Criteria andRewarranteridIsNotNull() {
            addCriterion("rewarranterid is not null");
            return (Criteria) this;
        }

        public Criteria andRewarranteridEqualTo(Long value) {
            addCriterion("rewarranterid =", value, "rewarranterid");
            return (Criteria) this;
        }

        public Criteria andRewarranteridNotEqualTo(Long value) {
            addCriterion("rewarranterid <>", value, "rewarranterid");
            return (Criteria) this;
        }

        public Criteria andRewarranteridGreaterThan(Long value) {
            addCriterion("rewarranterid >", value, "rewarranterid");
            return (Criteria) this;
        }

        public Criteria andRewarranteridGreaterThanOrEqualTo(Long value) {
            addCriterion("rewarranterid >=", value, "rewarranterid");
            return (Criteria) this;
        }

        public Criteria andRewarranteridLessThan(Long value) {
            addCriterion("rewarranterid <", value, "rewarranterid");
            return (Criteria) this;
        }

        public Criteria andRewarranteridLessThanOrEqualTo(Long value) {
            addCriterion("rewarranterid <=", value, "rewarranterid");
            return (Criteria) this;
        }

        public Criteria andRewarranteridIn(List<Long> values) {
            addCriterion("rewarranterid in", values, "rewarranterid");
            return (Criteria) this;
        }

        public Criteria andRewarranteridNotIn(List<Long> values) {
            addCriterion("rewarranterid not in", values, "rewarranterid");
            return (Criteria) this;
        }

        public Criteria andRewarranteridBetween(Long value1, Long value2) {
            addCriterion("rewarranterid between", value1, value2, "rewarranterid");
            return (Criteria) this;
        }

        public Criteria andRewarranteridNotBetween(Long value1, Long value2) {
            addCriterion("rewarranterid not between", value1, value2, "rewarranterid");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnIsNull() {
            addCriterion("rewarrantersn is null");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnIsNotNull() {
            addCriterion("rewarrantersn is not null");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnEqualTo(String value) {
            addCriterion("rewarrantersn =", value, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnNotEqualTo(String value) {
            addCriterion("rewarrantersn <>", value, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnGreaterThan(String value) {
            addCriterion("rewarrantersn >", value, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnGreaterThanOrEqualTo(String value) {
            addCriterion("rewarrantersn >=", value, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnLessThan(String value) {
            addCriterion("rewarrantersn <", value, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnLessThanOrEqualTo(String value) {
            addCriterion("rewarrantersn <=", value, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnLike(String value) {
            addCriterion("rewarrantersn like", value, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnNotLike(String value) {
            addCriterion("rewarrantersn not like", value, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnIn(List<String> values) {
            addCriterion("rewarrantersn in", values, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnNotIn(List<String> values) {
            addCriterion("rewarrantersn not in", values, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnBetween(String value1, String value2) {
            addCriterion("rewarrantersn between", value1, value2, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarrantersnNotBetween(String value1, String value2) {
            addCriterion("rewarrantersn not between", value1, value2, "rewarrantersn");
            return (Criteria) this;
        }

        public Criteria andRewarranterIsNull() {
            addCriterion("rewarranter is null");
            return (Criteria) this;
        }

        public Criteria andRewarranterIsNotNull() {
            addCriterion("rewarranter is not null");
            return (Criteria) this;
        }

        public Criteria andRewarranterEqualTo(String value) {
            addCriterion("rewarranter =", value, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterNotEqualTo(String value) {
            addCriterion("rewarranter <>", value, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterGreaterThan(String value) {
            addCriterion("rewarranter >", value, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterGreaterThanOrEqualTo(String value) {
            addCriterion("rewarranter >=", value, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterLessThan(String value) {
            addCriterion("rewarranter <", value, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterLessThanOrEqualTo(String value) {
            addCriterion("rewarranter <=", value, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterLike(String value) {
            addCriterion("rewarranter like", value, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterNotLike(String value) {
            addCriterion("rewarranter not like", value, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterIn(List<String> values) {
            addCriterion("rewarranter in", values, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterNotIn(List<String> values) {
            addCriterion("rewarranter not in", values, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterBetween(String value1, String value2) {
            addCriterion("rewarranter between", value1, value2, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranterNotBetween(String value1, String value2) {
            addCriterion("rewarranter not between", value1, value2, "rewarranter");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidIsNull() {
            addCriterion("rewarranttypeid is null");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidIsNotNull() {
            addCriterion("rewarranttypeid is not null");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidEqualTo(Long value) {
            addCriterion("rewarranttypeid =", value, "rewarranttypeid");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidNotEqualTo(Long value) {
            addCriterion("rewarranttypeid <>", value, "rewarranttypeid");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidGreaterThan(Long value) {
            addCriterion("rewarranttypeid >", value, "rewarranttypeid");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidGreaterThanOrEqualTo(Long value) {
            addCriterion("rewarranttypeid >=", value, "rewarranttypeid");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidLessThan(Long value) {
            addCriterion("rewarranttypeid <", value, "rewarranttypeid");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidLessThanOrEqualTo(Long value) {
            addCriterion("rewarranttypeid <=", value, "rewarranttypeid");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidIn(List<Long> values) {
            addCriterion("rewarranttypeid in", values, "rewarranttypeid");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidNotIn(List<Long> values) {
            addCriterion("rewarranttypeid not in", values, "rewarranttypeid");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidBetween(Long value1, Long value2) {
            addCriterion("rewarranttypeid between", value1, value2, "rewarranttypeid");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeidNotBetween(Long value1, Long value2) {
            addCriterion("rewarranttypeid not between", value1, value2, "rewarranttypeid");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeIsNull() {
            addCriterion("rewarranttype is null");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeIsNotNull() {
            addCriterion("rewarranttype is not null");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeEqualTo(String value) {
            addCriterion("rewarranttype =", value, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeNotEqualTo(String value) {
            addCriterion("rewarranttype <>", value, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeGreaterThan(String value) {
            addCriterion("rewarranttype >", value, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeGreaterThanOrEqualTo(String value) {
            addCriterion("rewarranttype >=", value, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeLessThan(String value) {
            addCriterion("rewarranttype <", value, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeLessThanOrEqualTo(String value) {
            addCriterion("rewarranttype <=", value, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeLike(String value) {
            addCriterion("rewarranttype like", value, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeNotLike(String value) {
            addCriterion("rewarranttype not like", value, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeIn(List<String> values) {
            addCriterion("rewarranttype in", values, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeNotIn(List<String> values) {
            addCriterion("rewarranttype not in", values, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeBetween(String value1, String value2) {
            addCriterion("rewarranttype between", value1, value2, "rewarranttype");
            return (Criteria) this;
        }

        public Criteria andRewarranttypeNotBetween(String value1, String value2) {
            addCriterion("rewarranttype not between", value1, value2, "rewarranttype");
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

        public Criteria andRmbfeeIsNull() {
            addCriterion("rmbfee is null");
            return (Criteria) this;
        }

        public Criteria andRmbfeeIsNotNull() {
            addCriterion("rmbfee is not null");
            return (Criteria) this;
        }

        public Criteria andRmbfeeEqualTo(BigDecimal value) {
            addCriterion("rmbfee =", value, "rmbfee");
            return (Criteria) this;
        }

        public Criteria andRmbfeeNotEqualTo(BigDecimal value) {
            addCriterion("rmbfee <>", value, "rmbfee");
            return (Criteria) this;
        }

        public Criteria andRmbfeeGreaterThan(BigDecimal value) {
            addCriterion("rmbfee >", value, "rmbfee");
            return (Criteria) this;
        }

        public Criteria andRmbfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rmbfee >=", value, "rmbfee");
            return (Criteria) this;
        }

        public Criteria andRmbfeeLessThan(BigDecimal value) {
            addCriterion("rmbfee <", value, "rmbfee");
            return (Criteria) this;
        }

        public Criteria andRmbfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rmbfee <=", value, "rmbfee");
            return (Criteria) this;
        }

        public Criteria andRmbfeeIn(List<BigDecimal> values) {
            addCriterion("rmbfee in", values, "rmbfee");
            return (Criteria) this;
        }

        public Criteria andRmbfeeNotIn(List<BigDecimal> values) {
            addCriterion("rmbfee not in", values, "rmbfee");
            return (Criteria) this;
        }

        public Criteria andRmbfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rmbfee between", value1, value2, "rmbfee");
            return (Criteria) this;
        }

        public Criteria andRmbfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rmbfee not between", value1, value2, "rmbfee");
            return (Criteria) this;
        }

        public Criteria andUsdfeeIsNull() {
            addCriterion("usdfee is null");
            return (Criteria) this;
        }

        public Criteria andUsdfeeIsNotNull() {
            addCriterion("usdfee is not null");
            return (Criteria) this;
        }

        public Criteria andUsdfeeEqualTo(BigDecimal value) {
            addCriterion("usdfee =", value, "usdfee");
            return (Criteria) this;
        }

        public Criteria andUsdfeeNotEqualTo(BigDecimal value) {
            addCriterion("usdfee <>", value, "usdfee");
            return (Criteria) this;
        }

        public Criteria andUsdfeeGreaterThan(BigDecimal value) {
            addCriterion("usdfee >", value, "usdfee");
            return (Criteria) this;
        }

        public Criteria andUsdfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("usdfee >=", value, "usdfee");
            return (Criteria) this;
        }

        public Criteria andUsdfeeLessThan(BigDecimal value) {
            addCriterion("usdfee <", value, "usdfee");
            return (Criteria) this;
        }

        public Criteria andUsdfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("usdfee <=", value, "usdfee");
            return (Criteria) this;
        }

        public Criteria andUsdfeeIn(List<BigDecimal> values) {
            addCriterion("usdfee in", values, "usdfee");
            return (Criteria) this;
        }

        public Criteria andUsdfeeNotIn(List<BigDecimal> values) {
            addCriterion("usdfee not in", values, "usdfee");
            return (Criteria) this;
        }

        public Criteria andUsdfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usdfee between", value1, value2, "usdfee");
            return (Criteria) this;
        }

        public Criteria andUsdfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usdfee not between", value1, value2, "usdfee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeIsNull() {
            addCriterion("assurefee is null");
            return (Criteria) this;
        }

        public Criteria andAssurefeeIsNotNull() {
            addCriterion("assurefee is not null");
            return (Criteria) this;
        }

        public Criteria andAssurefeeEqualTo(BigDecimal value) {
            addCriterion("assurefee =", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeNotEqualTo(BigDecimal value) {
            addCriterion("assurefee <>", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeGreaterThan(BigDecimal value) {
            addCriterion("assurefee >", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("assurefee >=", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeLessThan(BigDecimal value) {
            addCriterion("assurefee <", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("assurefee <=", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeIn(List<BigDecimal> values) {
            addCriterion("assurefee in", values, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeNotIn(List<BigDecimal> values) {
            addCriterion("assurefee not in", values, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("assurefee between", value1, value2, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("assurefee not between", value1, value2, "assurefee");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberIsNull() {
            addCriterion("guaranteeExpressNumber is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberIsNotNull() {
            addCriterion("guaranteeExpressNumber is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberEqualTo(String value) {
            addCriterion("guaranteeExpressNumber =", value, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberNotEqualTo(String value) {
            addCriterion("guaranteeExpressNumber <>", value, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberGreaterThan(String value) {
            addCriterion("guaranteeExpressNumber >", value, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberGreaterThanOrEqualTo(String value) {
            addCriterion("guaranteeExpressNumber >=", value, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberLessThan(String value) {
            addCriterion("guaranteeExpressNumber <", value, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberLessThanOrEqualTo(String value) {
            addCriterion("guaranteeExpressNumber <=", value, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberLike(String value) {
            addCriterion("guaranteeExpressNumber like", value, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberNotLike(String value) {
            addCriterion("guaranteeExpressNumber not like", value, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberIn(List<String> values) {
            addCriterion("guaranteeExpressNumber in", values, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberNotIn(List<String> values) {
            addCriterion("guaranteeExpressNumber not in", values, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberBetween(String value1, String value2) {
            addCriterion("guaranteeExpressNumber between", value1, value2, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeexpressnumberNotBetween(String value1, String value2) {
            addCriterion("guaranteeExpressNumber not between", value1, value2, "guaranteeexpressnumber");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeIsNull() {
            addCriterion("cancelTheGuarantee is null");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeIsNotNull() {
            addCriterion("cancelTheGuarantee is not null");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeEqualTo(String value) {
            addCriterion("cancelTheGuarantee =", value, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeNotEqualTo(String value) {
            addCriterion("cancelTheGuarantee <>", value, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeGreaterThan(String value) {
            addCriterion("cancelTheGuarantee >", value, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeGreaterThanOrEqualTo(String value) {
            addCriterion("cancelTheGuarantee >=", value, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeLessThan(String value) {
            addCriterion("cancelTheGuarantee <", value, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeLessThanOrEqualTo(String value) {
            addCriterion("cancelTheGuarantee <=", value, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeLike(String value) {
            addCriterion("cancelTheGuarantee like", value, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeNotLike(String value) {
            addCriterion("cancelTheGuarantee not like", value, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeIn(List<String> values) {
            addCriterion("cancelTheGuarantee in", values, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeNotIn(List<String> values) {
            addCriterion("cancelTheGuarantee not in", values, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeBetween(String value1, String value2) {
            addCriterion("cancelTheGuarantee between", value1, value2, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andCanceltheguaranteeNotBetween(String value1, String value2) {
            addCriterion("cancelTheGuarantee not between", value1, value2, "canceltheguarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderIsNull() {
            addCriterion("guaranteeSender is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderIsNotNull() {
            addCriterion("guaranteeSender is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderEqualTo(String value) {
            addCriterion("guaranteeSender =", value, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderNotEqualTo(String value) {
            addCriterion("guaranteeSender <>", value, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderGreaterThan(String value) {
            addCriterion("guaranteeSender >", value, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderGreaterThanOrEqualTo(String value) {
            addCriterion("guaranteeSender >=", value, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderLessThan(String value) {
            addCriterion("guaranteeSender <", value, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderLessThanOrEqualTo(String value) {
            addCriterion("guaranteeSender <=", value, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderLike(String value) {
            addCriterion("guaranteeSender like", value, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderNotLike(String value) {
            addCriterion("guaranteeSender not like", value, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderIn(List<String> values) {
            addCriterion("guaranteeSender in", values, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderNotIn(List<String> values) {
            addCriterion("guaranteeSender not in", values, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderBetween(String value1, String value2) {
            addCriterion("guaranteeSender between", value1, value2, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteesenderNotBetween(String value1, String value2) {
            addCriterion("guaranteeSender not between", value1, value2, "guaranteesender");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateIsNull() {
            addCriterion("guaranteeReturnDate is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateIsNotNull() {
            addCriterion("guaranteeReturnDate is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateEqualTo(Date value) {
            addCriterionForJDBCDate("guaranteeReturnDate =", value, "guaranteereturndate");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateNotEqualTo(Date value) {
            addCriterionForJDBCDate("guaranteeReturnDate <>", value, "guaranteereturndate");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateGreaterThan(Date value) {
            addCriterionForJDBCDate("guaranteeReturnDate >", value, "guaranteereturndate");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("guaranteeReturnDate >=", value, "guaranteereturndate");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateLessThan(Date value) {
            addCriterionForJDBCDate("guaranteeReturnDate <", value, "guaranteereturndate");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("guaranteeReturnDate <=", value, "guaranteereturndate");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateIn(List<Date> values) {
            addCriterionForJDBCDate("guaranteeReturnDate in", values, "guaranteereturndate");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateNotIn(List<Date> values) {
            addCriterionForJDBCDate("guaranteeReturnDate not in", values, "guaranteereturndate");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("guaranteeReturnDate between", value1, value2, "guaranteereturndate");
            return (Criteria) this;
        }

        public Criteria andGuaranteereturndateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("guaranteeReturnDate not between", value1, value2, "guaranteereturndate");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberIsNull() {
            addCriterion("trackingNumber is null");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberIsNotNull() {
            addCriterion("trackingNumber is not null");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberEqualTo(String value) {
            addCriterion("trackingNumber =", value, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberNotEqualTo(String value) {
            addCriterion("trackingNumber <>", value, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberGreaterThan(String value) {
            addCriterion("trackingNumber >", value, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberGreaterThanOrEqualTo(String value) {
            addCriterion("trackingNumber >=", value, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberLessThan(String value) {
            addCriterion("trackingNumber <", value, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberLessThanOrEqualTo(String value) {
            addCriterion("trackingNumber <=", value, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberLike(String value) {
            addCriterion("trackingNumber like", value, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberNotLike(String value) {
            addCriterion("trackingNumber not like", value, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberIn(List<String> values) {
            addCriterion("trackingNumber in", values, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberNotIn(List<String> values) {
            addCriterion("trackingNumber not in", values, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberBetween(String value1, String value2) {
            addCriterion("trackingNumber between", value1, value2, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andTrackingnumberNotBetween(String value1, String value2) {
            addCriterion("trackingNumber not between", value1, value2, "trackingnumber");
            return (Criteria) this;
        }

        public Criteria andSecuritydateIsNull() {
            addCriterion("securityDate is null");
            return (Criteria) this;
        }

        public Criteria andSecuritydateIsNotNull() {
            addCriterion("securityDate is not null");
            return (Criteria) this;
        }

        public Criteria andSecuritydateEqualTo(Date value) {
            addCriterionForJDBCDate("securityDate =", value, "securitydate");
            return (Criteria) this;
        }

        public Criteria andSecuritydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("securityDate <>", value, "securitydate");
            return (Criteria) this;
        }

        public Criteria andSecuritydateGreaterThan(Date value) {
            addCriterionForJDBCDate("securityDate >", value, "securitydate");
            return (Criteria) this;
        }

        public Criteria andSecuritydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("securityDate >=", value, "securitydate");
            return (Criteria) this;
        }

        public Criteria andSecuritydateLessThan(Date value) {
            addCriterionForJDBCDate("securityDate <", value, "securitydate");
            return (Criteria) this;
        }

        public Criteria andSecuritydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("securityDate <=", value, "securitydate");
            return (Criteria) this;
        }

        public Criteria andSecuritydateIn(List<Date> values) {
            addCriterionForJDBCDate("securityDate in", values, "securitydate");
            return (Criteria) this;
        }

        public Criteria andSecuritydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("securityDate not in", values, "securitydate");
            return (Criteria) this;
        }

        public Criteria andSecuritydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("securityDate between", value1, value2, "securitydate");
            return (Criteria) this;
        }

        public Criteria andSecuritydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("securityDate not between", value1, value2, "securitydate");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeIsNull() {
            addCriterion("zbsendTime is null");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeIsNotNull() {
            addCriterion("zbsendTime is not null");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeEqualTo(Date value) {
            addCriterionForJDBCDate("zbsendTime =", value, "zbsendtime");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("zbsendTime <>", value, "zbsendtime");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("zbsendTime >", value, "zbsendtime");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("zbsendTime >=", value, "zbsendtime");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeLessThan(Date value) {
            addCriterionForJDBCDate("zbsendTime <", value, "zbsendtime");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("zbsendTime <=", value, "zbsendtime");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeIn(List<Date> values) {
            addCriterionForJDBCDate("zbsendTime in", values, "zbsendtime");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("zbsendTime not in", values, "zbsendtime");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("zbsendTime between", value1, value2, "zbsendtime");
            return (Criteria) this;
        }

        public Criteria andZbsendtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("zbsendTime not between", value1, value2, "zbsendtime");
            return (Criteria) this;
        }

        public Criteria andRecognizornameIsNull() {
            addCriterion("recognizorName is null");
            return (Criteria) this;
        }

        public Criteria andRecognizornameIsNotNull() {
            addCriterion("recognizorName is not null");
            return (Criteria) this;
        }

        public Criteria andRecognizornameEqualTo(String value) {
            addCriterion("recognizorName =", value, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameNotEqualTo(String value) {
            addCriterion("recognizorName <>", value, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameGreaterThan(String value) {
            addCriterion("recognizorName >", value, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameGreaterThanOrEqualTo(String value) {
            addCriterion("recognizorName >=", value, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameLessThan(String value) {
            addCriterion("recognizorName <", value, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameLessThanOrEqualTo(String value) {
            addCriterion("recognizorName <=", value, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameLike(String value) {
            addCriterion("recognizorName like", value, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameNotLike(String value) {
            addCriterion("recognizorName not like", value, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameIn(List<String> values) {
            addCriterion("recognizorName in", values, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameNotIn(List<String> values) {
            addCriterion("recognizorName not in", values, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameBetween(String value1, String value2) {
            addCriterion("recognizorName between", value1, value2, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andRecognizornameNotBetween(String value1, String value2) {
            addCriterion("recognizorName not between", value1, value2, "recognizorname");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateIsNull() {
            addCriterion("zbgatherDate is null");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateIsNotNull() {
            addCriterion("zbgatherDate is not null");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateEqualTo(Date value) {
            addCriterionForJDBCDate("zbgatherDate =", value, "zbgatherdate");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("zbgatherDate <>", value, "zbgatherdate");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateGreaterThan(Date value) {
            addCriterionForJDBCDate("zbgatherDate >", value, "zbgatherdate");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("zbgatherDate >=", value, "zbgatherdate");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateLessThan(Date value) {
            addCriterionForJDBCDate("zbgatherDate <", value, "zbgatherdate");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("zbgatherDate <=", value, "zbgatherdate");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateIn(List<Date> values) {
            addCriterionForJDBCDate("zbgatherDate in", values, "zbgatherdate");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("zbgatherDate not in", values, "zbgatherdate");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("zbgatherDate between", value1, value2, "zbgatherdate");
            return (Criteria) this;
        }

        public Criteria andZbgatherdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("zbgatherDate not between", value1, value2, "zbgatherdate");
            return (Criteria) this;
        }

        public Criteria andPaymentidIsNull() {
            addCriterion("paymentid is null");
            return (Criteria) this;
        }

        public Criteria andPaymentidIsNotNull() {
            addCriterion("paymentid is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentidEqualTo(Long value) {
            addCriterion("paymentid =", value, "paymentid");
            return (Criteria) this;
        }

        public Criteria andPaymentidNotEqualTo(Long value) {
            addCriterion("paymentid <>", value, "paymentid");
            return (Criteria) this;
        }

        public Criteria andPaymentidGreaterThan(Long value) {
            addCriterion("paymentid >", value, "paymentid");
            return (Criteria) this;
        }

        public Criteria andPaymentidGreaterThanOrEqualTo(Long value) {
            addCriterion("paymentid >=", value, "paymentid");
            return (Criteria) this;
        }

        public Criteria andPaymentidLessThan(Long value) {
            addCriterion("paymentid <", value, "paymentid");
            return (Criteria) this;
        }

        public Criteria andPaymentidLessThanOrEqualTo(Long value) {
            addCriterion("paymentid <=", value, "paymentid");
            return (Criteria) this;
        }

        public Criteria andPaymentidIn(List<Long> values) {
            addCriterion("paymentid in", values, "paymentid");
            return (Criteria) this;
        }

        public Criteria andPaymentidNotIn(List<Long> values) {
            addCriterion("paymentid not in", values, "paymentid");
            return (Criteria) this;
        }

        public Criteria andPaymentidBetween(Long value1, Long value2) {
            addCriterion("paymentid between", value1, value2, "paymentid");
            return (Criteria) this;
        }

        public Criteria andPaymentidNotBetween(Long value1, Long value2) {
            addCriterion("paymentid not between", value1, value2, "paymentid");
            return (Criteria) this;
        }

        public Criteria andReplaceidIsNull() {
            addCriterion("replaceid is null");
            return (Criteria) this;
        }

        public Criteria andReplaceidIsNotNull() {
            addCriterion("replaceid is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceidEqualTo(Long value) {
            addCriterion("replaceid =", value, "replaceid");
            return (Criteria) this;
        }

        public Criteria andReplaceidNotEqualTo(Long value) {
            addCriterion("replaceid <>", value, "replaceid");
            return (Criteria) this;
        }

        public Criteria andReplaceidGreaterThan(Long value) {
            addCriterion("replaceid >", value, "replaceid");
            return (Criteria) this;
        }

        public Criteria andReplaceidGreaterThanOrEqualTo(Long value) {
            addCriterion("replaceid >=", value, "replaceid");
            return (Criteria) this;
        }

        public Criteria andReplaceidLessThan(Long value) {
            addCriterion("replaceid <", value, "replaceid");
            return (Criteria) this;
        }

        public Criteria andReplaceidLessThanOrEqualTo(Long value) {
            addCriterion("replaceid <=", value, "replaceid");
            return (Criteria) this;
        }

        public Criteria andReplaceidIn(List<Long> values) {
            addCriterion("replaceid in", values, "replaceid");
            return (Criteria) this;
        }

        public Criteria andReplaceidNotIn(List<Long> values) {
            addCriterion("replaceid not in", values, "replaceid");
            return (Criteria) this;
        }

        public Criteria andReplaceidBetween(Long value1, Long value2) {
            addCriterion("replaceid between", value1, value2, "replaceid");
            return (Criteria) this;
        }

        public Criteria andReplaceidNotBetween(Long value1, Long value2) {
            addCriterion("replaceid not between", value1, value2, "replaceid");
            return (Criteria) this;
        }

        public Criteria andReplacedidIsNull() {
            addCriterion("replacedid is null");
            return (Criteria) this;
        }

        public Criteria andReplacedidIsNotNull() {
            addCriterion("replacedid is not null");
            return (Criteria) this;
        }

        public Criteria andReplacedidEqualTo(Long value) {
            addCriterion("replacedid =", value, "replacedid");
            return (Criteria) this;
        }

        public Criteria andReplacedidNotEqualTo(Long value) {
            addCriterion("replacedid <>", value, "replacedid");
            return (Criteria) this;
        }

        public Criteria andReplacedidGreaterThan(Long value) {
            addCriterion("replacedid >", value, "replacedid");
            return (Criteria) this;
        }

        public Criteria andReplacedidGreaterThanOrEqualTo(Long value) {
            addCriterion("replacedid >=", value, "replacedid");
            return (Criteria) this;
        }

        public Criteria andReplacedidLessThan(Long value) {
            addCriterion("replacedid <", value, "replacedid");
            return (Criteria) this;
        }

        public Criteria andReplacedidLessThanOrEqualTo(Long value) {
            addCriterion("replacedid <=", value, "replacedid");
            return (Criteria) this;
        }

        public Criteria andReplacedidIn(List<Long> values) {
            addCriterion("replacedid in", values, "replacedid");
            return (Criteria) this;
        }

        public Criteria andReplacedidNotIn(List<Long> values) {
            addCriterion("replacedid not in", values, "replacedid");
            return (Criteria) this;
        }

        public Criteria andReplacedidBetween(Long value1, Long value2) {
            addCriterion("replacedid between", value1, value2, "replacedid");
            return (Criteria) this;
        }

        public Criteria andReplacedidNotBetween(Long value1, Long value2) {
            addCriterion("replacedid not between", value1, value2, "replacedid");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNull() {
            addCriterion("ordernum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("ordernum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(String value) {
            addCriterion("ordernum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(String value) {
            addCriterion("ordernum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(String value) {
            addCriterion("ordernum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(String value) {
            addCriterion("ordernum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(String value) {
            addCriterion("ordernum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(String value) {
            addCriterion("ordernum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLike(String value) {
            addCriterion("ordernum like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotLike(String value) {
            addCriterion("ordernum not like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<String> values) {
            addCriterion("ordernum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<String> values) {
            addCriterion("ordernum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(String value1, String value2) {
            addCriterion("ordernum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(String value1, String value2) {
            addCriterion("ordernum not between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andReplacednumIsNull() {
            addCriterion("replacednum is null");
            return (Criteria) this;
        }

        public Criteria andReplacednumIsNotNull() {
            addCriterion("replacednum is not null");
            return (Criteria) this;
        }

        public Criteria andReplacednumEqualTo(String value) {
            addCriterion("replacednum =", value, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumNotEqualTo(String value) {
            addCriterion("replacednum <>", value, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumGreaterThan(String value) {
            addCriterion("replacednum >", value, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumGreaterThanOrEqualTo(String value) {
            addCriterion("replacednum >=", value, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumLessThan(String value) {
            addCriterion("replacednum <", value, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumLessThanOrEqualTo(String value) {
            addCriterion("replacednum <=", value, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumLike(String value) {
            addCriterion("replacednum like", value, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumNotLike(String value) {
            addCriterion("replacednum not like", value, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumIn(List<String> values) {
            addCriterion("replacednum in", values, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumNotIn(List<String> values) {
            addCriterion("replacednum not in", values, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumBetween(String value1, String value2) {
            addCriterion("replacednum between", value1, value2, "replacednum");
            return (Criteria) this;
        }

        public Criteria andReplacednumNotBetween(String value1, String value2) {
            addCriterion("replacednum not between", value1, value2, "replacednum");
            return (Criteria) this;
        }

        public Criteria andAlertdateIsNull() {
            addCriterion("alertdate is null");
            return (Criteria) this;
        }

        public Criteria andAlertdateIsNotNull() {
            addCriterion("alertdate is not null");
            return (Criteria) this;
        }

        public Criteria andAlertdateEqualTo(Date value) {
            addCriterion("alertdate =", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateNotEqualTo(Date value) {
            addCriterion("alertdate <>", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateGreaterThan(Date value) {
            addCriterion("alertdate >", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateGreaterThanOrEqualTo(Date value) {
            addCriterion("alertdate >=", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateLessThan(Date value) {
            addCriterion("alertdate <", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateLessThanOrEqualTo(Date value) {
            addCriterion("alertdate <=", value, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateIn(List<Date> values) {
            addCriterion("alertdate in", values, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateNotIn(List<Date> values) {
            addCriterion("alertdate not in", values, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateBetween(Date value1, Date value2) {
            addCriterion("alertdate between", value1, value2, "alertdate");
            return (Criteria) this;
        }

        public Criteria andAlertdateNotBetween(Date value1, Date value2) {
            addCriterion("alertdate not between", value1, value2, "alertdate");
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

        public Criteria andServicefeeIsNull() {
            addCriterion("servicefee is null");
            return (Criteria) this;
        }

        public Criteria andServicefeeIsNotNull() {
            addCriterion("servicefee is not null");
            return (Criteria) this;
        }

        public Criteria andServicefeeEqualTo(BigDecimal value) {
            addCriterion("servicefee =", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotEqualTo(BigDecimal value) {
            addCriterion("servicefee <>", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeGreaterThan(BigDecimal value) {
            addCriterion("servicefee >", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("servicefee >=", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeLessThan(BigDecimal value) {
            addCriterion("servicefee <", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("servicefee <=", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeIn(List<BigDecimal> values) {
            addCriterion("servicefee in", values, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotIn(List<BigDecimal> values) {
            addCriterion("servicefee not in", values, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("servicefee between", value1, value2, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("servicefee not between", value1, value2, "servicefee");
            return (Criteria) this;
        }

        public Criteria andReceiveflagIsNull() {
            addCriterion("receiveflag is null");
            return (Criteria) this;
        }

        public Criteria andReceiveflagIsNotNull() {
            addCriterion("receiveflag is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveflagEqualTo(String value) {
            addCriterion("receiveflag =", value, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagNotEqualTo(String value) {
            addCriterion("receiveflag <>", value, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagGreaterThan(String value) {
            addCriterion("receiveflag >", value, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagGreaterThanOrEqualTo(String value) {
            addCriterion("receiveflag >=", value, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagLessThan(String value) {
            addCriterion("receiveflag <", value, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagLessThanOrEqualTo(String value) {
            addCriterion("receiveflag <=", value, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagLike(String value) {
            addCriterion("receiveflag like", value, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagNotLike(String value) {
            addCriterion("receiveflag not like", value, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagIn(List<String> values) {
            addCriterion("receiveflag in", values, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagNotIn(List<String> values) {
            addCriterion("receiveflag not in", values, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagBetween(String value1, String value2) {
            addCriterion("receiveflag between", value1, value2, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andReceiveflagNotBetween(String value1, String value2) {
            addCriterion("receiveflag not between", value1, value2, "receiveflag");
            return (Criteria) this;
        }

        public Criteria andAssurederIsNull() {
            addCriterion("assureder is null");
            return (Criteria) this;
        }

        public Criteria andAssurederIsNotNull() {
            addCriterion("assureder is not null");
            return (Criteria) this;
        }

        public Criteria andAssurederEqualTo(String value) {
            addCriterion("assureder =", value, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederNotEqualTo(String value) {
            addCriterion("assureder <>", value, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederGreaterThan(String value) {
            addCriterion("assureder >", value, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederGreaterThanOrEqualTo(String value) {
            addCriterion("assureder >=", value, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederLessThan(String value) {
            addCriterion("assureder <", value, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederLessThanOrEqualTo(String value) {
            addCriterion("assureder <=", value, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederLike(String value) {
            addCriterion("assureder like", value, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederNotLike(String value) {
            addCriterion("assureder not like", value, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederIn(List<String> values) {
            addCriterion("assureder in", values, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederNotIn(List<String> values) {
            addCriterion("assureder not in", values, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederBetween(String value1, String value2) {
            addCriterion("assureder between", value1, value2, "assureder");
            return (Criteria) this;
        }

        public Criteria andAssurederNotBetween(String value1, String value2) {
            addCriterion("assureder not between", value1, value2, "assureder");
            return (Criteria) this;
        }

        public Criteria andBackdateIsNull() {
            addCriterion("backdate is null");
            return (Criteria) this;
        }

        public Criteria andBackdateIsNotNull() {
            addCriterion("backdate is not null");
            return (Criteria) this;
        }

        public Criteria andBackdateEqualTo(Date value) {
            addCriterionForJDBCDate("backdate =", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("backdate <>", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateGreaterThan(Date value) {
            addCriterionForJDBCDate("backdate >", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("backdate >=", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateLessThan(Date value) {
            addCriterionForJDBCDate("backdate <", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("backdate <=", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateIn(List<Date> values) {
            addCriterionForJDBCDate("backdate in", values, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("backdate not in", values, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("backdate between", value1, value2, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("backdate not between", value1, value2, "backdate");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNull() {
            addCriterion("issuedate is null");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNotNull() {
            addCriterion("issuedate is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedateEqualTo(Date value) {
            addCriterionForJDBCDate("issuedate =", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("issuedate <>", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThan(Date value) {
            addCriterionForJDBCDate("issuedate >", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("issuedate >=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThan(Date value) {
            addCriterionForJDBCDate("issuedate <", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("issuedate <=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateIn(List<Date> values) {
            addCriterionForJDBCDate("issuedate in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("issuedate not in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("issuedate between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("issuedate not between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andReplacenumIsNull() {
            addCriterion("replacenum is null");
            return (Criteria) this;
        }

        public Criteria andReplacenumIsNotNull() {
            addCriterion("replacenum is not null");
            return (Criteria) this;
        }

        public Criteria andReplacenumEqualTo(String value) {
            addCriterion("replacenum =", value, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumNotEqualTo(String value) {
            addCriterion("replacenum <>", value, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumGreaterThan(String value) {
            addCriterion("replacenum >", value, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumGreaterThanOrEqualTo(String value) {
            addCriterion("replacenum >=", value, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumLessThan(String value) {
            addCriterion("replacenum <", value, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumLessThanOrEqualTo(String value) {
            addCriterion("replacenum <=", value, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumLike(String value) {
            addCriterion("replacenum like", value, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumNotLike(String value) {
            addCriterion("replacenum not like", value, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumIn(List<String> values) {
            addCriterion("replacenum in", values, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumNotIn(List<String> values) {
            addCriterion("replacenum not in", values, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumBetween(String value1, String value2) {
            addCriterion("replacenum between", value1, value2, "replacenum");
            return (Criteria) this;
        }

        public Criteria andReplacenumNotBetween(String value1, String value2) {
            addCriterion("replacenum not between", value1, value2, "replacenum");
            return (Criteria) this;
        }

        public Criteria andAccrateIsNull() {
            addCriterion("accrate is null");
            return (Criteria) this;
        }

        public Criteria andAccrateIsNotNull() {
            addCriterion("accrate is not null");
            return (Criteria) this;
        }

        public Criteria andAccrateEqualTo(BigDecimal value) {
            addCriterion("accrate =", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateNotEqualTo(BigDecimal value) {
            addCriterion("accrate <>", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateGreaterThan(BigDecimal value) {
            addCriterion("accrate >", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accrate >=", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateLessThan(BigDecimal value) {
            addCriterion("accrate <", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accrate <=", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateIn(List<BigDecimal> values) {
            addCriterion("accrate in", values, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateNotIn(List<BigDecimal> values) {
            addCriterion("accrate not in", values, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accrate between", value1, value2, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accrate not between", value1, value2, "accrate");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyIsNull() {
            addCriterion("acccurrency is null");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyIsNotNull() {
            addCriterion("acccurrency is not null");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyEqualTo(String value) {
            addCriterion("acccurrency =", value, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyNotEqualTo(String value) {
            addCriterion("acccurrency <>", value, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyGreaterThan(String value) {
            addCriterion("acccurrency >", value, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("acccurrency >=", value, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyLessThan(String value) {
            addCriterion("acccurrency <", value, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyLessThanOrEqualTo(String value) {
            addCriterion("acccurrency <=", value, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyLike(String value) {
            addCriterion("acccurrency like", value, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyNotLike(String value) {
            addCriterion("acccurrency not like", value, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyIn(List<String> values) {
            addCriterion("acccurrency in", values, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyNotIn(List<String> values) {
            addCriterion("acccurrency not in", values, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyBetween(String value1, String value2) {
            addCriterion("acccurrency between", value1, value2, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAcccurrencyNotBetween(String value1, String value2) {
            addCriterion("acccurrency not between", value1, value2, "acccurrency");
            return (Criteria) this;
        }

        public Criteria andAccamountIsNull() {
            addCriterion("accamount is null");
            return (Criteria) this;
        }

        public Criteria andAccamountIsNotNull() {
            addCriterion("accamount is not null");
            return (Criteria) this;
        }

        public Criteria andAccamountEqualTo(BigDecimal value) {
            addCriterion("accamount =", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountNotEqualTo(BigDecimal value) {
            addCriterion("accamount <>", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountGreaterThan(BigDecimal value) {
            addCriterion("accamount >", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accamount >=", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountLessThan(BigDecimal value) {
            addCriterion("accamount <", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accamount <=", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountIn(List<BigDecimal> values) {
            addCriterion("accamount in", values, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountNotIn(List<BigDecimal> values) {
            addCriterion("accamount not in", values, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accamount between", value1, value2, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accamount not between", value1, value2, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccdateIsNull() {
            addCriterion("accdate is null");
            return (Criteria) this;
        }

        public Criteria andAccdateIsNotNull() {
            addCriterion("accdate is not null");
            return (Criteria) this;
        }

        public Criteria andAccdateEqualTo(Date value) {
            addCriterion("accdate =", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateNotEqualTo(Date value) {
            addCriterion("accdate <>", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateGreaterThan(Date value) {
            addCriterion("accdate >", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateGreaterThanOrEqualTo(Date value) {
            addCriterion("accdate >=", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateLessThan(Date value) {
            addCriterion("accdate <", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateLessThanOrEqualTo(Date value) {
            addCriterion("accdate <=", value, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateIn(List<Date> values) {
            addCriterion("accdate in", values, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateNotIn(List<Date> values) {
            addCriterion("accdate not in", values, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateBetween(Date value1, Date value2) {
            addCriterion("accdate between", value1, value2, "accdate");
            return (Criteria) this;
        }

        public Criteria andAccdateNotBetween(Date value1, Date value2) {
            addCriterion("accdate not between", value1, value2, "accdate");
            return (Criteria) this;
        }

        public Criteria andArrdateIsNull() {
            addCriterion("arrdate is null");
            return (Criteria) this;
        }

        public Criteria andArrdateIsNotNull() {
            addCriterion("arrdate is not null");
            return (Criteria) this;
        }

        public Criteria andArrdateEqualTo(Date value) {
            addCriterion("arrdate =", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateNotEqualTo(Date value) {
            addCriterion("arrdate <>", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateGreaterThan(Date value) {
            addCriterion("arrdate >", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateGreaterThanOrEqualTo(Date value) {
            addCriterion("arrdate >=", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateLessThan(Date value) {
            addCriterion("arrdate <", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateLessThanOrEqualTo(Date value) {
            addCriterion("arrdate <=", value, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateIn(List<Date> values) {
            addCriterion("arrdate in", values, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateNotIn(List<Date> values) {
            addCriterion("arrdate not in", values, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateBetween(Date value1, Date value2) {
            addCriterion("arrdate between", value1, value2, "arrdate");
            return (Criteria) this;
        }

        public Criteria andArrdateNotBetween(Date value1, Date value2) {
            addCriterion("arrdate not between", value1, value2, "arrdate");
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

        public Criteria andBillidIsNull() {
            addCriterion("billId is null");
            return (Criteria) this;
        }

        public Criteria andBillidIsNotNull() {
            addCriterion("billId is not null");
            return (Criteria) this;
        }

        public Criteria andBillidEqualTo(Long value) {
            addCriterion("billId =", value, "billid");
            return (Criteria) this;
        }

        public Criteria andBillidNotEqualTo(Long value) {
            addCriterion("billId <>", value, "billid");
            return (Criteria) this;
        }

        public Criteria andBillidGreaterThan(Long value) {
            addCriterion("billId >", value, "billid");
            return (Criteria) this;
        }

        public Criteria andBillidGreaterThanOrEqualTo(Long value) {
            addCriterion("billId >=", value, "billid");
            return (Criteria) this;
        }

        public Criteria andBillidLessThan(Long value) {
            addCriterion("billId <", value, "billid");
            return (Criteria) this;
        }

        public Criteria andBillidLessThanOrEqualTo(Long value) {
            addCriterion("billId <=", value, "billid");
            return (Criteria) this;
        }

        public Criteria andBillidIn(List<Long> values) {
            addCriterion("billId in", values, "billid");
            return (Criteria) this;
        }

        public Criteria andBillidNotIn(List<Long> values) {
            addCriterion("billId not in", values, "billid");
            return (Criteria) this;
        }

        public Criteria andBillidBetween(Long value1, Long value2) {
            addCriterion("billId between", value1, value2, "billid");
            return (Criteria) this;
        }

        public Criteria andBillidNotBetween(Long value1, Long value2) {
            addCriterion("billId not between", value1, value2, "billid");
            return (Criteria) this;
        }

        public Criteria andFeestatuseIsNull() {
            addCriterion("feestatuse is null");
            return (Criteria) this;
        }

        public Criteria andFeestatuseIsNotNull() {
            addCriterion("feestatuse is not null");
            return (Criteria) this;
        }

        public Criteria andFeestatuseEqualTo(String value) {
            addCriterion("feestatuse =", value, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseNotEqualTo(String value) {
            addCriterion("feestatuse <>", value, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseGreaterThan(String value) {
            addCriterion("feestatuse >", value, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseGreaterThanOrEqualTo(String value) {
            addCriterion("feestatuse >=", value, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseLessThan(String value) {
            addCriterion("feestatuse <", value, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseLessThanOrEqualTo(String value) {
            addCriterion("feestatuse <=", value, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseLike(String value) {
            addCriterion("feestatuse like", value, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseNotLike(String value) {
            addCriterion("feestatuse not like", value, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseIn(List<String> values) {
            addCriterion("feestatuse in", values, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseNotIn(List<String> values) {
            addCriterion("feestatuse not in", values, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseBetween(String value1, String value2) {
            addCriterion("feestatuse between", value1, value2, "feestatuse");
            return (Criteria) this;
        }

        public Criteria andFeestatuseNotBetween(String value1, String value2) {
            addCriterion("feestatuse not between", value1, value2, "feestatuse");
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