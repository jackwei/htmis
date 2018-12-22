package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblRewarranterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblRewarranterExample() {
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

        public Criteria andNamesIsNull() {
            addCriterion("names is null");
            return (Criteria) this;
        }

        public Criteria andNamesIsNotNull() {
            addCriterion("names is not null");
            return (Criteria) this;
        }

        public Criteria andNamesEqualTo(String value) {
            addCriterion("names =", value, "names");
            return (Criteria) this;
        }

        public Criteria andNamesNotEqualTo(String value) {
            addCriterion("names <>", value, "names");
            return (Criteria) this;
        }

        public Criteria andNamesGreaterThan(String value) {
            addCriterion("names >", value, "names");
            return (Criteria) this;
        }

        public Criteria andNamesGreaterThanOrEqualTo(String value) {
            addCriterion("names >=", value, "names");
            return (Criteria) this;
        }

        public Criteria andNamesLessThan(String value) {
            addCriterion("names <", value, "names");
            return (Criteria) this;
        }

        public Criteria andNamesLessThanOrEqualTo(String value) {
            addCriterion("names <=", value, "names");
            return (Criteria) this;
        }

        public Criteria andNamesLike(String value) {
            addCriterion("names like", value, "names");
            return (Criteria) this;
        }

        public Criteria andNamesNotLike(String value) {
            addCriterion("names not like", value, "names");
            return (Criteria) this;
        }

        public Criteria andNamesIn(List<String> values) {
            addCriterion("names in", values, "names");
            return (Criteria) this;
        }

        public Criteria andNamesNotIn(List<String> values) {
            addCriterion("names not in", values, "names");
            return (Criteria) this;
        }

        public Criteria andNamesBetween(String value1, String value2) {
            addCriterion("names between", value1, value2, "names");
            return (Criteria) this;
        }

        public Criteria andNamesNotBetween(String value1, String value2) {
            addCriterion("names not between", value1, value2, "names");
            return (Criteria) this;
        }

        public Criteria andPropertyidIsNull() {
            addCriterion("propertyid is null");
            return (Criteria) this;
        }

        public Criteria andPropertyidIsNotNull() {
            addCriterion("propertyid is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyidEqualTo(Long value) {
            addCriterion("propertyid =", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidNotEqualTo(Long value) {
            addCriterion("propertyid <>", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidGreaterThan(Long value) {
            addCriterion("propertyid >", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidGreaterThanOrEqualTo(Long value) {
            addCriterion("propertyid >=", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidLessThan(Long value) {
            addCriterion("propertyid <", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidLessThanOrEqualTo(Long value) {
            addCriterion("propertyid <=", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidIn(List<Long> values) {
            addCriterion("propertyid in", values, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidNotIn(List<Long> values) {
            addCriterion("propertyid not in", values, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidBetween(Long value1, Long value2) {
            addCriterion("propertyid between", value1, value2, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidNotBetween(Long value1, Long value2) {
            addCriterion("propertyid not between", value1, value2, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertynameIsNull() {
            addCriterion("propertyname is null");
            return (Criteria) this;
        }

        public Criteria andPropertynameIsNotNull() {
            addCriterion("propertyname is not null");
            return (Criteria) this;
        }

        public Criteria andPropertynameEqualTo(String value) {
            addCriterion("propertyname =", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameNotEqualTo(String value) {
            addCriterion("propertyname <>", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameGreaterThan(String value) {
            addCriterion("propertyname >", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameGreaterThanOrEqualTo(String value) {
            addCriterion("propertyname >=", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameLessThan(String value) {
            addCriterion("propertyname <", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameLessThanOrEqualTo(String value) {
            addCriterion("propertyname <=", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameLike(String value) {
            addCriterion("propertyname like", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameNotLike(String value) {
            addCriterion("propertyname not like", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameIn(List<String> values) {
            addCriterion("propertyname in", values, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameNotIn(List<String> values) {
            addCriterion("propertyname not in", values, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameBetween(String value1, String value2) {
            addCriterion("propertyname between", value1, value2, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameNotBetween(String value1, String value2) {
            addCriterion("propertyname not between", value1, value2, "propertyname");
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

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
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