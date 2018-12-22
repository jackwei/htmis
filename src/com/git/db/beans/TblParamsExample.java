package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblParamsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblParamsExample() {
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

        public Criteria andBiztypeIsNull() {
            addCriterion("biztype is null");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNotNull() {
            addCriterion("biztype is not null");
            return (Criteria) this;
        }

        public Criteria andBiztypeEqualTo(String value) {
            addCriterion("biztype =", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotEqualTo(String value) {
            addCriterion("biztype <>", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThan(String value) {
            addCriterion("biztype >", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThanOrEqualTo(String value) {
            addCriterion("biztype >=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThan(String value) {
            addCriterion("biztype <", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThanOrEqualTo(String value) {
            addCriterion("biztype <=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLike(String value) {
            addCriterion("biztype like", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotLike(String value) {
            addCriterion("biztype not like", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeIn(List<String> values) {
            addCriterion("biztype in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotIn(List<String> values) {
            addCriterion("biztype not in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeBetween(String value1, String value2) {
            addCriterion("biztype between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotBetween(String value1, String value2) {
            addCriterion("biztype not between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypenameIsNull() {
            addCriterion("biztypename is null");
            return (Criteria) this;
        }

        public Criteria andBiztypenameIsNotNull() {
            addCriterion("biztypename is not null");
            return (Criteria) this;
        }

        public Criteria andBiztypenameEqualTo(String value) {
            addCriterion("biztypename =", value, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameNotEqualTo(String value) {
            addCriterion("biztypename <>", value, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameGreaterThan(String value) {
            addCriterion("biztypename >", value, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameGreaterThanOrEqualTo(String value) {
            addCriterion("biztypename >=", value, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameLessThan(String value) {
            addCriterion("biztypename <", value, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameLessThanOrEqualTo(String value) {
            addCriterion("biztypename <=", value, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameLike(String value) {
            addCriterion("biztypename like", value, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameNotLike(String value) {
            addCriterion("biztypename not like", value, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameIn(List<String> values) {
            addCriterion("biztypename in", values, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameNotIn(List<String> values) {
            addCriterion("biztypename not in", values, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameBetween(String value1, String value2) {
            addCriterion("biztypename between", value1, value2, "biztypename");
            return (Criteria) this;
        }

        public Criteria andBiztypenameNotBetween(String value1, String value2) {
            addCriterion("biztypename not between", value1, value2, "biztypename");
            return (Criteria) this;
        }

        public Criteria andParamtypeIsNull() {
            addCriterion("paramtype is null");
            return (Criteria) this;
        }

        public Criteria andParamtypeIsNotNull() {
            addCriterion("paramtype is not null");
            return (Criteria) this;
        }

        public Criteria andParamtypeEqualTo(String value) {
            addCriterion("paramtype =", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotEqualTo(String value) {
            addCriterion("paramtype <>", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeGreaterThan(String value) {
            addCriterion("paramtype >", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeGreaterThanOrEqualTo(String value) {
            addCriterion("paramtype >=", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeLessThan(String value) {
            addCriterion("paramtype <", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeLessThanOrEqualTo(String value) {
            addCriterion("paramtype <=", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeLike(String value) {
            addCriterion("paramtype like", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotLike(String value) {
            addCriterion("paramtype not like", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeIn(List<String> values) {
            addCriterion("paramtype in", values, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotIn(List<String> values) {
            addCriterion("paramtype not in", values, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeBetween(String value1, String value2) {
            addCriterion("paramtype between", value1, value2, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotBetween(String value1, String value2) {
            addCriterion("paramtype not between", value1, value2, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtextaIsNull() {
            addCriterion("paramtexta is null");
            return (Criteria) this;
        }

        public Criteria andParamtextaIsNotNull() {
            addCriterion("paramtexta is not null");
            return (Criteria) this;
        }

        public Criteria andParamtextaEqualTo(String value) {
            addCriterion("paramtexta =", value, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaNotEqualTo(String value) {
            addCriterion("paramtexta <>", value, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaGreaterThan(String value) {
            addCriterion("paramtexta >", value, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaGreaterThanOrEqualTo(String value) {
            addCriterion("paramtexta >=", value, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaLessThan(String value) {
            addCriterion("paramtexta <", value, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaLessThanOrEqualTo(String value) {
            addCriterion("paramtexta <=", value, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaLike(String value) {
            addCriterion("paramtexta like", value, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaNotLike(String value) {
            addCriterion("paramtexta not like", value, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaIn(List<String> values) {
            addCriterion("paramtexta in", values, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaNotIn(List<String> values) {
            addCriterion("paramtexta not in", values, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaBetween(String value1, String value2) {
            addCriterion("paramtexta between", value1, value2, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextaNotBetween(String value1, String value2) {
            addCriterion("paramtexta not between", value1, value2, "paramtexta");
            return (Criteria) this;
        }

        public Criteria andParamtextbIsNull() {
            addCriterion("paramtextb is null");
            return (Criteria) this;
        }

        public Criteria andParamtextbIsNotNull() {
            addCriterion("paramtextb is not null");
            return (Criteria) this;
        }

        public Criteria andParamtextbEqualTo(String value) {
            addCriterion("paramtextb =", value, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbNotEqualTo(String value) {
            addCriterion("paramtextb <>", value, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbGreaterThan(String value) {
            addCriterion("paramtextb >", value, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbGreaterThanOrEqualTo(String value) {
            addCriterion("paramtextb >=", value, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbLessThan(String value) {
            addCriterion("paramtextb <", value, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbLessThanOrEqualTo(String value) {
            addCriterion("paramtextb <=", value, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbLike(String value) {
            addCriterion("paramtextb like", value, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbNotLike(String value) {
            addCriterion("paramtextb not like", value, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbIn(List<String> values) {
            addCriterion("paramtextb in", values, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbNotIn(List<String> values) {
            addCriterion("paramtextb not in", values, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbBetween(String value1, String value2) {
            addCriterion("paramtextb between", value1, value2, "paramtextb");
            return (Criteria) this;
        }

        public Criteria andParamtextbNotBetween(String value1, String value2) {
            addCriterion("paramtextb not between", value1, value2, "paramtextb");
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