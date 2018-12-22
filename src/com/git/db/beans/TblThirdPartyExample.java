package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblThirdPartyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblThirdPartyExample() {
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

        public Criteria andNameenIsNull() {
            addCriterion("nameen is null");
            return (Criteria) this;
        }

        public Criteria andNameenIsNotNull() {
            addCriterion("nameen is not null");
            return (Criteria) this;
        }

        public Criteria andNameenEqualTo(String value) {
            addCriterion("nameen =", value, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenNotEqualTo(String value) {
            addCriterion("nameen <>", value, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenGreaterThan(String value) {
            addCriterion("nameen >", value, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenGreaterThanOrEqualTo(String value) {
            addCriterion("nameen >=", value, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenLessThan(String value) {
            addCriterion("nameen <", value, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenLessThanOrEqualTo(String value) {
            addCriterion("nameen <=", value, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenLike(String value) {
            addCriterion("nameen like", value, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenNotLike(String value) {
            addCriterion("nameen not like", value, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenIn(List<String> values) {
            addCriterion("nameen in", values, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenNotIn(List<String> values) {
            addCriterion("nameen not in", values, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenBetween(String value1, String value2) {
            addCriterion("nameen between", value1, value2, "nameen");
            return (Criteria) this;
        }

        public Criteria andNameenNotBetween(String value1, String value2) {
            addCriterion("nameen not between", value1, value2, "nameen");
            return (Criteria) this;
        }

        public Criteria andNamecnIsNull() {
            addCriterion("namecn is null");
            return (Criteria) this;
        }

        public Criteria andNamecnIsNotNull() {
            addCriterion("namecn is not null");
            return (Criteria) this;
        }

        public Criteria andNamecnEqualTo(String value) {
            addCriterion("namecn =", value, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnNotEqualTo(String value) {
            addCriterion("namecn <>", value, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnGreaterThan(String value) {
            addCriterion("namecn >", value, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnGreaterThanOrEqualTo(String value) {
            addCriterion("namecn >=", value, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnLessThan(String value) {
            addCriterion("namecn <", value, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnLessThanOrEqualTo(String value) {
            addCriterion("namecn <=", value, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnLike(String value) {
            addCriterion("namecn like", value, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnNotLike(String value) {
            addCriterion("namecn not like", value, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnIn(List<String> values) {
            addCriterion("namecn in", values, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnNotIn(List<String> values) {
            addCriterion("namecn not in", values, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnBetween(String value1, String value2) {
            addCriterion("namecn between", value1, value2, "namecn");
            return (Criteria) this;
        }

        public Criteria andNamecnNotBetween(String value1, String value2) {
            addCriterion("namecn not between", value1, value2, "namecn");
            return (Criteria) this;
        }

        public Criteria andNameensIsNull() {
            addCriterion("nameens is null");
            return (Criteria) this;
        }

        public Criteria andNameensIsNotNull() {
            addCriterion("nameens is not null");
            return (Criteria) this;
        }

        public Criteria andNameensEqualTo(String value) {
            addCriterion("nameens =", value, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensNotEqualTo(String value) {
            addCriterion("nameens <>", value, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensGreaterThan(String value) {
            addCriterion("nameens >", value, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensGreaterThanOrEqualTo(String value) {
            addCriterion("nameens >=", value, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensLessThan(String value) {
            addCriterion("nameens <", value, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensLessThanOrEqualTo(String value) {
            addCriterion("nameens <=", value, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensLike(String value) {
            addCriterion("nameens like", value, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensNotLike(String value) {
            addCriterion("nameens not like", value, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensIn(List<String> values) {
            addCriterion("nameens in", values, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensNotIn(List<String> values) {
            addCriterion("nameens not in", values, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensBetween(String value1, String value2) {
            addCriterion("nameens between", value1, value2, "nameens");
            return (Criteria) this;
        }

        public Criteria andNameensNotBetween(String value1, String value2) {
            addCriterion("nameens not between", value1, value2, "nameens");
            return (Criteria) this;
        }

        public Criteria andNamecnsIsNull() {
            addCriterion("namecns is null");
            return (Criteria) this;
        }

        public Criteria andNamecnsIsNotNull() {
            addCriterion("namecns is not null");
            return (Criteria) this;
        }

        public Criteria andNamecnsEqualTo(String value) {
            addCriterion("namecns =", value, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsNotEqualTo(String value) {
            addCriterion("namecns <>", value, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsGreaterThan(String value) {
            addCriterion("namecns >", value, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsGreaterThanOrEqualTo(String value) {
            addCriterion("namecns >=", value, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsLessThan(String value) {
            addCriterion("namecns <", value, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsLessThanOrEqualTo(String value) {
            addCriterion("namecns <=", value, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsLike(String value) {
            addCriterion("namecns like", value, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsNotLike(String value) {
            addCriterion("namecns not like", value, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsIn(List<String> values) {
            addCriterion("namecns in", values, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsNotIn(List<String> values) {
            addCriterion("namecns not in", values, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsBetween(String value1, String value2) {
            addCriterion("namecns between", value1, value2, "namecns");
            return (Criteria) this;
        }

        public Criteria andNamecnsNotBetween(String value1, String value2) {
            addCriterion("namecns not between", value1, value2, "namecns");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("property is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("property is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(String value) {
            addCriterion("property =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(String value) {
            addCriterion("property <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(String value) {
            addCriterion("property >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("property >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(String value) {
            addCriterion("property <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(String value) {
            addCriterion("property <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLike(String value) {
            addCriterion("property like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotLike(String value) {
            addCriterion("property not like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<String> values) {
            addCriterion("property in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<String> values) {
            addCriterion("property not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(String value1, String value2) {
            addCriterion("property between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(String value1, String value2) {
            addCriterion("property not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAccountnameIsNull() {
            addCriterion("accountname is null");
            return (Criteria) this;
        }

        public Criteria andAccountnameIsNotNull() {
            addCriterion("accountname is not null");
            return (Criteria) this;
        }

        public Criteria andAccountnameEqualTo(String value) {
            addCriterion("accountname =", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotEqualTo(String value) {
            addCriterion("accountname <>", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameGreaterThan(String value) {
            addCriterion("accountname >", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameGreaterThanOrEqualTo(String value) {
            addCriterion("accountname >=", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameLessThan(String value) {
            addCriterion("accountname <", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameLessThanOrEqualTo(String value) {
            addCriterion("accountname <=", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameLike(String value) {
            addCriterion("accountname like", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotLike(String value) {
            addCriterion("accountname not like", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameIn(List<String> values) {
            addCriterion("accountname in", values, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotIn(List<String> values) {
            addCriterion("accountname not in", values, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameBetween(String value1, String value2) {
            addCriterion("accountname between", value1, value2, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotBetween(String value1, String value2) {
            addCriterion("accountname not between", value1, value2, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnumIsNull() {
            addCriterion("accountnum is null");
            return (Criteria) this;
        }

        public Criteria andAccountnumIsNotNull() {
            addCriterion("accountnum is not null");
            return (Criteria) this;
        }

        public Criteria andAccountnumEqualTo(String value) {
            addCriterion("accountnum =", value, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumNotEqualTo(String value) {
            addCriterion("accountnum <>", value, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumGreaterThan(String value) {
            addCriterion("accountnum >", value, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumGreaterThanOrEqualTo(String value) {
            addCriterion("accountnum >=", value, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumLessThan(String value) {
            addCriterion("accountnum <", value, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumLessThanOrEqualTo(String value) {
            addCriterion("accountnum <=", value, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumLike(String value) {
            addCriterion("accountnum like", value, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumNotLike(String value) {
            addCriterion("accountnum not like", value, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumIn(List<String> values) {
            addCriterion("accountnum in", values, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumNotIn(List<String> values) {
            addCriterion("accountnum not in", values, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumBetween(String value1, String value2) {
            addCriterion("accountnum between", value1, value2, "accountnum");
            return (Criteria) this;
        }

        public Criteria andAccountnumNotBetween(String value1, String value2) {
            addCriterion("accountnum not between", value1, value2, "accountnum");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(String value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(String value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(String value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(String value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(String value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(String value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLike(String value) {
            addCriterion("sort like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotLike(String value) {
            addCriterion("sort not like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<String> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<String> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(String value1, String value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(String value1, String value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortnameIsNull() {
            addCriterion("sortname is null");
            return (Criteria) this;
        }

        public Criteria andSortnameIsNotNull() {
            addCriterion("sortname is not null");
            return (Criteria) this;
        }

        public Criteria andSortnameEqualTo(String value) {
            addCriterion("sortname =", value, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameNotEqualTo(String value) {
            addCriterion("sortname <>", value, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameGreaterThan(String value) {
            addCriterion("sortname >", value, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameGreaterThanOrEqualTo(String value) {
            addCriterion("sortname >=", value, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameLessThan(String value) {
            addCriterion("sortname <", value, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameLessThanOrEqualTo(String value) {
            addCriterion("sortname <=", value, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameLike(String value) {
            addCriterion("sortname like", value, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameNotLike(String value) {
            addCriterion("sortname not like", value, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameIn(List<String> values) {
            addCriterion("sortname in", values, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameNotIn(List<String> values) {
            addCriterion("sortname not in", values, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameBetween(String value1, String value2) {
            addCriterion("sortname between", value1, value2, "sortname");
            return (Criteria) this;
        }

        public Criteria andSortnameNotBetween(String value1, String value2) {
            addCriterion("sortname not between", value1, value2, "sortname");
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

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
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

        public Criteria andAccountcodeIsNull() {
            addCriterion("accountcode is null");
            return (Criteria) this;
        }

        public Criteria andAccountcodeIsNotNull() {
            addCriterion("accountcode is not null");
            return (Criteria) this;
        }

        public Criteria andAccountcodeEqualTo(String value) {
            addCriterion("accountcode =", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeNotEqualTo(String value) {
            addCriterion("accountcode <>", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeGreaterThan(String value) {
            addCriterion("accountcode >", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeGreaterThanOrEqualTo(String value) {
            addCriterion("accountcode >=", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeLessThan(String value) {
            addCriterion("accountcode <", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeLessThanOrEqualTo(String value) {
            addCriterion("accountcode <=", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeLike(String value) {
            addCriterion("accountcode like", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeNotLike(String value) {
            addCriterion("accountcode not like", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeIn(List<String> values) {
            addCriterion("accountcode in", values, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeNotIn(List<String> values) {
            addCriterion("accountcode not in", values, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeBetween(String value1, String value2) {
            addCriterion("accountcode between", value1, value2, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeNotBetween(String value1, String value2) {
            addCriterion("accountcode not between", value1, value2, "accountcode");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseIsNull() {
            addCriterion("currentcourse is null");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseIsNotNull() {
            addCriterion("currentcourse is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseEqualTo(String value) {
            addCriterion("currentcourse =", value, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseNotEqualTo(String value) {
            addCriterion("currentcourse <>", value, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseGreaterThan(String value) {
            addCriterion("currentcourse >", value, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseGreaterThanOrEqualTo(String value) {
            addCriterion("currentcourse >=", value, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseLessThan(String value) {
            addCriterion("currentcourse <", value, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseLessThanOrEqualTo(String value) {
            addCriterion("currentcourse <=", value, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseLike(String value) {
            addCriterion("currentcourse like", value, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseNotLike(String value) {
            addCriterion("currentcourse not like", value, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseIn(List<String> values) {
            addCriterion("currentcourse in", values, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseNotIn(List<String> values) {
            addCriterion("currentcourse not in", values, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseBetween(String value1, String value2) {
            addCriterion("currentcourse between", value1, value2, "currentcourse");
            return (Criteria) this;
        }

        public Criteria andCurrentcourseNotBetween(String value1, String value2) {
            addCriterion("currentcourse not between", value1, value2, "currentcourse");
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