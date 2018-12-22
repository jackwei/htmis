package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseBillImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaseBillImplExample() {
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

        public Criteria andBillIdIsNull() {
            addCriterion("Bill_Id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("Bill_Id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Long value) {
            addCriterion("Bill_Id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Long value) {
            addCriterion("Bill_Id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Long value) {
            addCriterion("Bill_Id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Bill_Id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Long value) {
            addCriterion("Bill_Id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Long value) {
            addCriterion("Bill_Id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Long> values) {
            addCriterion("Bill_Id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Long> values) {
            addCriterion("Bill_Id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Long value1, Long value2) {
            addCriterion("Bill_Id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Long value1, Long value2) {
            addCriterion("Bill_Id not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andFeenumberIsNull() {
            addCriterion("feenumber is null");
            return (Criteria) this;
        }

        public Criteria andFeenumberIsNotNull() {
            addCriterion("feenumber is not null");
            return (Criteria) this;
        }

        public Criteria andFeenumberEqualTo(String value) {
            addCriterion("feenumber =", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberNotEqualTo(String value) {
            addCriterion("feenumber <>", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberGreaterThan(String value) {
            addCriterion("feenumber >", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberGreaterThanOrEqualTo(String value) {
            addCriterion("feenumber >=", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberLessThan(String value) {
            addCriterion("feenumber <", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberLessThanOrEqualTo(String value) {
            addCriterion("feenumber <=", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberLike(String value) {
            addCriterion("feenumber like", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberNotLike(String value) {
            addCriterion("feenumber not like", value, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberIn(List<String> values) {
            addCriterion("feenumber in", values, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberNotIn(List<String> values) {
            addCriterion("feenumber not in", values, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberBetween(String value1, String value2) {
            addCriterion("feenumber between", value1, value2, "feenumber");
            return (Criteria) this;
        }

        public Criteria andFeenumberNotBetween(String value1, String value2) {
            addCriterion("feenumber not between", value1, value2, "feenumber");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNull() {
            addCriterion("Case_Id is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("Case_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(Long value) {
            addCriterion("Case_Id =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(Long value) {
            addCriterion("Case_Id <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(Long value) {
            addCriterion("Case_Id >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Case_Id >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(Long value) {
            addCriterion("Case_Id <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(Long value) {
            addCriterion("Case_Id <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<Long> values) {
            addCriterion("Case_Id in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<Long> values) {
            addCriterion("Case_Id not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(Long value1, Long value2) {
            addCriterion("Case_Id between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(Long value1, Long value2) {
            addCriterion("Case_Id not between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCasenumberIsNull() {
            addCriterion("casenumber is null");
            return (Criteria) this;
        }

        public Criteria andCasenumberIsNotNull() {
            addCriterion("casenumber is not null");
            return (Criteria) this;
        }

        public Criteria andCasenumberEqualTo(String value) {
            addCriterion("casenumber =", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberNotEqualTo(String value) {
            addCriterion("casenumber <>", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberGreaterThan(String value) {
            addCriterion("casenumber >", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberGreaterThanOrEqualTo(String value) {
            addCriterion("casenumber >=", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberLessThan(String value) {
            addCriterion("casenumber <", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberLessThanOrEqualTo(String value) {
            addCriterion("casenumber <=", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberLike(String value) {
            addCriterion("casenumber like", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberNotLike(String value) {
            addCriterion("casenumber not like", value, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberIn(List<String> values) {
            addCriterion("casenumber in", values, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberNotIn(List<String> values) {
            addCriterion("casenumber not in", values, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberBetween(String value1, String value2) {
            addCriterion("casenumber between", value1, value2, "casenumber");
            return (Criteria) this;
        }

        public Criteria andCasenumberNotBetween(String value1, String value2) {
            addCriterion("casenumber not between", value1, value2, "casenumber");
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

        public Criteria andServicefeeEqualTo(Float value) {
            addCriterion("servicefee =", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotEqualTo(Float value) {
            addCriterion("servicefee <>", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeGreaterThan(Float value) {
            addCriterion("servicefee >", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeGreaterThanOrEqualTo(Float value) {
            addCriterion("servicefee >=", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeLessThan(Float value) {
            addCriterion("servicefee <", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeLessThanOrEqualTo(Float value) {
            addCriterion("servicefee <=", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeIn(List<Float> values) {
            addCriterion("servicefee in", values, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotIn(List<Float> values) {
            addCriterion("servicefee not in", values, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeBetween(Float value1, Float value2) {
            addCriterion("servicefee between", value1, value2, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotBetween(Float value1, Float value2) {
            addCriterion("servicefee not between", value1, value2, "servicefee");
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

        public Criteria andAssurefeeEqualTo(Float value) {
            addCriterion("assurefee =", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeNotEqualTo(Float value) {
            addCriterion("assurefee <>", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeGreaterThan(Float value) {
            addCriterion("assurefee >", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeGreaterThanOrEqualTo(Float value) {
            addCriterion("assurefee >=", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeLessThan(Float value) {
            addCriterion("assurefee <", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeLessThanOrEqualTo(Float value) {
            addCriterion("assurefee <=", value, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeIn(List<Float> values) {
            addCriterion("assurefee in", values, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeNotIn(List<Float> values) {
            addCriterion("assurefee not in", values, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeBetween(Float value1, Float value2) {
            addCriterion("assurefee between", value1, value2, "assurefee");
            return (Criteria) this;
        }

        public Criteria andAssurefeeNotBetween(Float value1, Float value2) {
            addCriterion("assurefee not between", value1, value2, "assurefee");
            return (Criteria) this;
        }

        public Criteria andThirdpartIsNull() {
            addCriterion("thirdpart is null");
            return (Criteria) this;
        }

        public Criteria andThirdpartIsNotNull() {
            addCriterion("thirdpart is not null");
            return (Criteria) this;
        }

        public Criteria andThirdpartEqualTo(Float value) {
            addCriterion("thirdpart =", value, "thirdpart");
            return (Criteria) this;
        }

        public Criteria andThirdpartNotEqualTo(Float value) {
            addCriterion("thirdpart <>", value, "thirdpart");
            return (Criteria) this;
        }

        public Criteria andThirdpartGreaterThan(Float value) {
            addCriterion("thirdpart >", value, "thirdpart");
            return (Criteria) this;
        }

        public Criteria andThirdpartGreaterThanOrEqualTo(Float value) {
            addCriterion("thirdpart >=", value, "thirdpart");
            return (Criteria) this;
        }

        public Criteria andThirdpartLessThan(Float value) {
            addCriterion("thirdpart <", value, "thirdpart");
            return (Criteria) this;
        }

        public Criteria andThirdpartLessThanOrEqualTo(Float value) {
            addCriterion("thirdpart <=", value, "thirdpart");
            return (Criteria) this;
        }

        public Criteria andThirdpartIn(List<Float> values) {
            addCriterion("thirdpart in", values, "thirdpart");
            return (Criteria) this;
        }

        public Criteria andThirdpartNotIn(List<Float> values) {
            addCriterion("thirdpart not in", values, "thirdpart");
            return (Criteria) this;
        }

        public Criteria andThirdpartBetween(Float value1, Float value2) {
            addCriterion("thirdpart between", value1, value2, "thirdpart");
            return (Criteria) this;
        }

        public Criteria andThirdpartNotBetween(Float value1, Float value2) {
            addCriterion("thirdpart not between", value1, value2, "thirdpart");
            return (Criteria) this;
        }

        public Criteria andCompensationsubIsNull() {
            addCriterion("compensationsub is null");
            return (Criteria) this;
        }

        public Criteria andCompensationsubIsNotNull() {
            addCriterion("compensationsub is not null");
            return (Criteria) this;
        }

        public Criteria andCompensationsubEqualTo(Float value) {
            addCriterion("compensationsub =", value, "compensationsub");
            return (Criteria) this;
        }

        public Criteria andCompensationsubNotEqualTo(Float value) {
            addCriterion("compensationsub <>", value, "compensationsub");
            return (Criteria) this;
        }

        public Criteria andCompensationsubGreaterThan(Float value) {
            addCriterion("compensationsub >", value, "compensationsub");
            return (Criteria) this;
        }

        public Criteria andCompensationsubGreaterThanOrEqualTo(Float value) {
            addCriterion("compensationsub >=", value, "compensationsub");
            return (Criteria) this;
        }

        public Criteria andCompensationsubLessThan(Float value) {
            addCriterion("compensationsub <", value, "compensationsub");
            return (Criteria) this;
        }

        public Criteria andCompensationsubLessThanOrEqualTo(Float value) {
            addCriterion("compensationsub <=", value, "compensationsub");
            return (Criteria) this;
        }

        public Criteria andCompensationsubIn(List<Float> values) {
            addCriterion("compensationsub in", values, "compensationsub");
            return (Criteria) this;
        }

        public Criteria andCompensationsubNotIn(List<Float> values) {
            addCriterion("compensationsub not in", values, "compensationsub");
            return (Criteria) this;
        }

        public Criteria andCompensationsubBetween(Float value1, Float value2) {
            addCriterion("compensationsub between", value1, value2, "compensationsub");
            return (Criteria) this;
        }

        public Criteria andCompensationsubNotBetween(Float value1, Float value2) {
            addCriterion("compensationsub not between", value1, value2, "compensationsub");
            return (Criteria) this;
        }

        public Criteria andReplaceamountIsNull() {
            addCriterion("replaceamount is null");
            return (Criteria) this;
        }

        public Criteria andReplaceamountIsNotNull() {
            addCriterion("replaceamount is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceamountEqualTo(Float value) {
            addCriterion("replaceamount =", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountNotEqualTo(Float value) {
            addCriterion("replaceamount <>", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountGreaterThan(Float value) {
            addCriterion("replaceamount >", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountGreaterThanOrEqualTo(Float value) {
            addCriterion("replaceamount >=", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountLessThan(Float value) {
            addCriterion("replaceamount <", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountLessThanOrEqualTo(Float value) {
            addCriterion("replaceamount <=", value, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountIn(List<Float> values) {
            addCriterion("replaceamount in", values, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountNotIn(List<Float> values) {
            addCriterion("replaceamount not in", values, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountBetween(Float value1, Float value2) {
            addCriterion("replaceamount between", value1, value2, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andReplaceamountNotBetween(Float value1, Float value2) {
            addCriterion("replaceamount not between", value1, value2, "replaceamount");
            return (Criteria) this;
        }

        public Criteria andOtherfeeIsNull() {
            addCriterion("otherfee is null");
            return (Criteria) this;
        }

        public Criteria andOtherfeeIsNotNull() {
            addCriterion("otherfee is not null");
            return (Criteria) this;
        }

        public Criteria andOtherfeeEqualTo(Float value) {
            addCriterion("otherfee =", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeNotEqualTo(Float value) {
            addCriterion("otherfee <>", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeGreaterThan(Float value) {
            addCriterion("otherfee >", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("otherfee >=", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeLessThan(Float value) {
            addCriterion("otherfee <", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeLessThanOrEqualTo(Float value) {
            addCriterion("otherfee <=", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeIn(List<Float> values) {
            addCriterion("otherfee in", values, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeNotIn(List<Float> values) {
            addCriterion("otherfee not in", values, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeBetween(Float value1, Float value2) {
            addCriterion("otherfee between", value1, value2, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeNotBetween(Float value1, Float value2) {
            addCriterion("otherfee not between", value1, value2, "otherfee");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeIsNull() {
            addCriterion("advancefee is null");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeIsNotNull() {
            addCriterion("advancefee is not null");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeEqualTo(Float value) {
            addCriterion("advancefee =", value, "advancefee");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeNotEqualTo(Float value) {
            addCriterion("advancefee <>", value, "advancefee");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeGreaterThan(Float value) {
            addCriterion("advancefee >", value, "advancefee");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeGreaterThanOrEqualTo(Float value) {
            addCriterion("advancefee >=", value, "advancefee");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeLessThan(Float value) {
            addCriterion("advancefee <", value, "advancefee");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeLessThanOrEqualTo(Float value) {
            addCriterion("advancefee <=", value, "advancefee");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeIn(List<Float> values) {
            addCriterion("advancefee in", values, "advancefee");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeNotIn(List<Float> values) {
            addCriterion("advancefee not in", values, "advancefee");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeBetween(Float value1, Float value2) {
            addCriterion("advancefee between", value1, value2, "advancefee");
            return (Criteria) this;
        }

        public Criteria andAdvancefeeNotBetween(Float value1, Float value2) {
            addCriterion("advancefee not between", value1, value2, "advancefee");
            return (Criteria) this;
        }

        public Criteria andFeeamountIsNull() {
            addCriterion("feeamount is null");
            return (Criteria) this;
        }

        public Criteria andFeeamountIsNotNull() {
            addCriterion("feeamount is not null");
            return (Criteria) this;
        }

        public Criteria andFeeamountEqualTo(Float value) {
            addCriterion("feeamount =", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountNotEqualTo(Float value) {
            addCriterion("feeamount <>", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountGreaterThan(Float value) {
            addCriterion("feeamount >", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountGreaterThanOrEqualTo(Float value) {
            addCriterion("feeamount >=", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountLessThan(Float value) {
            addCriterion("feeamount <", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountLessThanOrEqualTo(Float value) {
            addCriterion("feeamount <=", value, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountIn(List<Float> values) {
            addCriterion("feeamount in", values, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountNotIn(List<Float> values) {
            addCriterion("feeamount not in", values, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountBetween(Float value1, Float value2) {
            addCriterion("feeamount between", value1, value2, "feeamount");
            return (Criteria) this;
        }

        public Criteria andFeeamountNotBetween(Float value1, Float value2) {
            addCriterion("feeamount not between", value1, value2, "feeamount");
            return (Criteria) this;
        }

        public Criteria andExpendsesIsNull() {
            addCriterion("expendses is null");
            return (Criteria) this;
        }

        public Criteria andExpendsesIsNotNull() {
            addCriterion("expendses is not null");
            return (Criteria) this;
        }

        public Criteria andExpendsesEqualTo(Float value) {
            addCriterion("expendses =", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesNotEqualTo(Float value) {
            addCriterion("expendses <>", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesGreaterThan(Float value) {
            addCriterion("expendses >", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesGreaterThanOrEqualTo(Float value) {
            addCriterion("expendses >=", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesLessThan(Float value) {
            addCriterion("expendses <", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesLessThanOrEqualTo(Float value) {
            addCriterion("expendses <=", value, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesIn(List<Float> values) {
            addCriterion("expendses in", values, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesNotIn(List<Float> values) {
            addCriterion("expendses not in", values, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesBetween(Float value1, Float value2) {
            addCriterion("expendses between", value1, value2, "expendses");
            return (Criteria) this;
        }

        public Criteria andExpendsesNotBetween(Float value1, Float value2) {
            addCriterion("expendses not between", value1, value2, "expendses");
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

        public Criteria andServicedesIsNull() {
            addCriterion("servicedes is null");
            return (Criteria) this;
        }

        public Criteria andServicedesIsNotNull() {
            addCriterion("servicedes is not null");
            return (Criteria) this;
        }

        public Criteria andServicedesEqualTo(String value) {
            addCriterion("servicedes =", value, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesNotEqualTo(String value) {
            addCriterion("servicedes <>", value, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesGreaterThan(String value) {
            addCriterion("servicedes >", value, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesGreaterThanOrEqualTo(String value) {
            addCriterion("servicedes >=", value, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesLessThan(String value) {
            addCriterion("servicedes <", value, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesLessThanOrEqualTo(String value) {
            addCriterion("servicedes <=", value, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesLike(String value) {
            addCriterion("servicedes like", value, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesNotLike(String value) {
            addCriterion("servicedes not like", value, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesIn(List<String> values) {
            addCriterion("servicedes in", values, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesNotIn(List<String> values) {
            addCriterion("servicedes not in", values, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesBetween(String value1, String value2) {
            addCriterion("servicedes between", value1, value2, "servicedes");
            return (Criteria) this;
        }

        public Criteria andServicedesNotBetween(String value1, String value2) {
            addCriterion("servicedes not between", value1, value2, "servicedes");
            return (Criteria) this;
        }

        public Criteria andPayerIsNull() {
            addCriterion("payer is null");
            return (Criteria) this;
        }

        public Criteria andPayerIsNotNull() {
            addCriterion("payer is not null");
            return (Criteria) this;
        }

        public Criteria andPayerEqualTo(String value) {
            addCriterion("payer =", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotEqualTo(String value) {
            addCriterion("payer <>", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerGreaterThan(String value) {
            addCriterion("payer >", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerGreaterThanOrEqualTo(String value) {
            addCriterion("payer >=", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerLessThan(String value) {
            addCriterion("payer <", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerLessThanOrEqualTo(String value) {
            addCriterion("payer <=", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerLike(String value) {
            addCriterion("payer like", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotLike(String value) {
            addCriterion("payer not like", value, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerIn(List<String> values) {
            addCriterion("payer in", values, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotIn(List<String> values) {
            addCriterion("payer not in", values, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerBetween(String value1, String value2) {
            addCriterion("payer between", value1, value2, "payer");
            return (Criteria) this;
        }

        public Criteria andPayerNotBetween(String value1, String value2) {
            addCriterion("payer not between", value1, value2, "payer");
            return (Criteria) this;
        }

        public Criteria andConameIsNull() {
            addCriterion("coname is null");
            return (Criteria) this;
        }

        public Criteria andConameIsNotNull() {
            addCriterion("coname is not null");
            return (Criteria) this;
        }

        public Criteria andConameEqualTo(String value) {
            addCriterion("coname =", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotEqualTo(String value) {
            addCriterion("coname <>", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameGreaterThan(String value) {
            addCriterion("coname >", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameGreaterThanOrEqualTo(String value) {
            addCriterion("coname >=", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameLessThan(String value) {
            addCriterion("coname <", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameLessThanOrEqualTo(String value) {
            addCriterion("coname <=", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameLike(String value) {
            addCriterion("coname like", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotLike(String value) {
            addCriterion("coname not like", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameIn(List<String> values) {
            addCriterion("coname in", values, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotIn(List<String> values) {
            addCriterion("coname not in", values, "coname");
            return (Criteria) this;
        }

        public Criteria andConameBetween(String value1, String value2) {
            addCriterion("coname between", value1, value2, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotBetween(String value1, String value2) {
            addCriterion("coname not between", value1, value2, "coname");
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

        public Criteria andFeetypeIsNull() {
            addCriterion("feetype is null");
            return (Criteria) this;
        }

        public Criteria andFeetypeIsNotNull() {
            addCriterion("feetype is not null");
            return (Criteria) this;
        }

        public Criteria andFeetypeEqualTo(String value) {
            addCriterion("feetype =", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotEqualTo(String value) {
            addCriterion("feetype <>", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeGreaterThan(String value) {
            addCriterion("feetype >", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeGreaterThanOrEqualTo(String value) {
            addCriterion("feetype >=", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeLessThan(String value) {
            addCriterion("feetype <", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeLessThanOrEqualTo(String value) {
            addCriterion("feetype <=", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeLike(String value) {
            addCriterion("feetype like", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotLike(String value) {
            addCriterion("feetype not like", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeIn(List<String> values) {
            addCriterion("feetype in", values, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotIn(List<String> values) {
            addCriterion("feetype not in", values, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeBetween(String value1, String value2) {
            addCriterion("feetype between", value1, value2, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotBetween(String value1, String value2) {
            addCriterion("feetype not between", value1, value2, "feetype");
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
            addCriterion("Operator_Id not between", value1, value2, "operatorId");
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
            addCriterion("Create_Time not between", value1, value2, "createTime");
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
            addCriterion("Modify_Time not between", value1, value2, "modifyTime");
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
            addCriterion("Modify_Operator_Id not in", values, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdBetween(Long value1, Long value2) {
            addCriterion("Modify_Operator_Id between", value1, value2, "modifyOperatorId");
            return (Criteria) this;
        }

        public Criteria andModifyOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("Modify_Operator_Id not between", value1, value2, "modifyOperatorId");
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