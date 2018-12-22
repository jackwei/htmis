package com.git.db.beans;

import java.util.ArrayList;
import java.util.List;

public class SysCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysCodeExample() {
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

        public Criteria andCodeidIsNull() {
            addCriterion("CodeId is null");
            return (Criteria) this;
        }

        public Criteria andCodeidIsNotNull() {
            addCriterion("CodeId is not null");
            return (Criteria) this;
        }

        public Criteria andCodeidEqualTo(String value) {
            addCriterion("CodeId =", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidNotEqualTo(String value) {
            addCriterion("CodeId <>", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidGreaterThan(String value) {
            addCriterion("CodeId >", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidGreaterThanOrEqualTo(String value) {
            addCriterion("CodeId >=", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidLessThan(String value) {
            addCriterion("CodeId <", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidLessThanOrEqualTo(String value) {
            addCriterion("CodeId <=", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidLike(String value) {
            addCriterion("CodeId like", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidNotLike(String value) {
            addCriterion("CodeId not like", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidIn(List<String> values) {
            addCriterion("CodeId in", values, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidNotIn(List<String> values) {
            addCriterion("CodeId not in", values, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidBetween(String value1, String value2) {
            addCriterion("CodeId between", value1, value2, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidNotBetween(String value1, String value2) {
            addCriterion("CodeId not between", value1, value2, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodenameIsNull() {
            addCriterion("CodeName is null");
            return (Criteria) this;
        }

        public Criteria andCodenameIsNotNull() {
            addCriterion("CodeName is not null");
            return (Criteria) this;
        }

        public Criteria andCodenameEqualTo(String value) {
            addCriterion("CodeName =", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameNotEqualTo(String value) {
            addCriterion("CodeName <>", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameGreaterThan(String value) {
            addCriterion("CodeName >", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameGreaterThanOrEqualTo(String value) {
            addCriterion("CodeName >=", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameLessThan(String value) {
            addCriterion("CodeName <", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameLessThanOrEqualTo(String value) {
            addCriterion("CodeName <=", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameLike(String value) {
            addCriterion("CodeName like", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameNotLike(String value) {
            addCriterion("CodeName not like", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameIn(List<String> values) {
            addCriterion("CodeName in", values, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameNotIn(List<String> values) {
            addCriterion("CodeName not in", values, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameBetween(String value1, String value2) {
            addCriterion("CodeName between", value1, value2, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameNotBetween(String value1, String value2) {
            addCriterion("CodeName not between", value1, value2, "codename");
            return (Criteria) this;
        }

        public Criteria andCodevalueIsNull() {
            addCriterion("CodeValue is null");
            return (Criteria) this;
        }

        public Criteria andCodevalueIsNotNull() {
            addCriterion("CodeValue is not null");
            return (Criteria) this;
        }

        public Criteria andCodevalueEqualTo(String value) {
            addCriterion("CodeValue =", value, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueNotEqualTo(String value) {
            addCriterion("CodeValue <>", value, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueGreaterThan(String value) {
            addCriterion("CodeValue >", value, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueGreaterThanOrEqualTo(String value) {
            addCriterion("CodeValue >=", value, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueLessThan(String value) {
            addCriterion("CodeValue <", value, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueLessThanOrEqualTo(String value) {
            addCriterion("CodeValue <=", value, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueLike(String value) {
            addCriterion("CodeValue like", value, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueNotLike(String value) {
            addCriterion("CodeValue not like", value, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueIn(List<String> values) {
            addCriterion("CodeValue in", values, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueNotIn(List<String> values) {
            addCriterion("CodeValue not in", values, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueBetween(String value1, String value2) {
            addCriterion("CodeValue between", value1, value2, "codevalue");
            return (Criteria) this;
        }

        public Criteria andCodevalueNotBetween(String value1, String value2) {
            addCriterion("CodeValue not between", value1, value2, "codevalue");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("Property is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("Property is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(String value) {
            addCriterion("Property =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(String value) {
            addCriterion("Property <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(String value) {
            addCriterion("Property >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("Property >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(String value) {
            addCriterion("Property <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(String value) {
            addCriterion("Property <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLike(String value) {
            addCriterion("Property like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotLike(String value) {
            addCriterion("Property not like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<String> values) {
            addCriterion("Property in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<String> values) {
            addCriterion("Property not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(String value1, String value2) {
            addCriterion("Property between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(String value1, String value2) {
            addCriterion("Property not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andBackupIsNull() {
            addCriterion("Backup is null");
            return (Criteria) this;
        }

        public Criteria andBackupIsNotNull() {
            addCriterion("Backup is not null");
            return (Criteria) this;
        }

        public Criteria andBackupEqualTo(String value) {
            addCriterion("Backup =", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotEqualTo(String value) {
            addCriterion("Backup <>", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupGreaterThan(String value) {
            addCriterion("Backup >", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupGreaterThanOrEqualTo(String value) {
            addCriterion("Backup >=", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLessThan(String value) {
            addCriterion("Backup <", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLessThanOrEqualTo(String value) {
            addCriterion("Backup <=", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLike(String value) {
            addCriterion("Backup like", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotLike(String value) {
            addCriterion("Backup not like", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupIn(List<String> values) {
            addCriterion("Backup in", values, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotIn(List<String> values) {
            addCriterion("Backup not in", values, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupBetween(String value1, String value2) {
            addCriterion("Backup between", value1, value2, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotBetween(String value1, String value2) {
            addCriterion("Backup not between", value1, value2, "backup");
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