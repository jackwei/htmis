package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.git.db.beans.CaseClaimImplExample.Criteria;

public class ClaimRateSubImplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClaimRateSubImplExample() {
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

        public Criteria andRateIdIsNull() {
            addCriterion("rate_id is null");
            return (Criteria) this;
        }

        public Criteria andRateIdIsNotNull() {
            addCriterion("rate_id is not null");
            return (Criteria) this;
        }

        public Criteria andRateIdEqualTo(Long value) {
            addCriterion("rate_id =", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotEqualTo(Long value) {
            addCriterion("rate_id <>", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdGreaterThan(Long value) {
            addCriterion("rate_id >", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rate_id >=", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdLessThan(Long value) {
            addCriterion("rate_id <", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdLessThanOrEqualTo(Long value) {
            addCriterion("rate_id <=", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdIn(List<Long> values) {
            addCriterion("rate_id in", values, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotIn(List<Long> values) {
            addCriterion("rate_id not in", values, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdBetween(Long value1, Long value2) {
            addCriterion("rate_id between", value1, value2, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotBetween(Long value1, Long value2) {
            addCriterion("rate_id not between", value1, value2, "rateId");
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
        
        public Criteria orBillId(String value1){
        	StringBuffer sb = new StringBuffer(" (bill_id = "+value1+" or bill_id = 0) ");
        	addCriterion(sb.toString());
        	return (Criteria) this;
        }
        
        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Long value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Long value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Long value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Long value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Long value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Long> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Long> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Long value1, Long value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Long value1, Long value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andCratesubIsNull() {
            addCriterion("cratesub is null");
            return (Criteria) this;
        }

        public Criteria andCratesubIsNotNull() {
            addCriterion("cratesub is not null");
            return (Criteria) this;
        }

        public Criteria andCratesubEqualTo(Float value) {
            addCriterion("cratesub =", value, "cratesub");
            return (Criteria) this;
        }

        public Criteria andCratesubNotEqualTo(Float value) {
            addCriterion("cratesub <>", value, "cratesub");
            return (Criteria) this;
        }

        public Criteria andCratesubGreaterThan(Float value) {
            addCriterion("cratesub >", value, "cratesub");
            return (Criteria) this;
        }

        public Criteria andCratesubGreaterThanOrEqualTo(Float value) {
            addCriterion("cratesub >=", value, "cratesub");
            return (Criteria) this;
        }

        public Criteria andCratesubLessThan(Float value) {
            addCriterion("cratesub <", value, "cratesub");
            return (Criteria) this;
        }

        public Criteria andCratesubLessThanOrEqualTo(Float value) {
            addCriterion("cratesub <=", value, "cratesub");
            return (Criteria) this;
        }

        public Criteria andCratesubIn(List<Float> values) {
            addCriterion("cratesub in", values, "cratesub");
            return (Criteria) this;
        }

        public Criteria andCratesubNotIn(List<Float> values) {
            addCriterion("cratesub not in", values, "cratesub");
            return (Criteria) this;
        }

        public Criteria andCratesubBetween(Float value1, Float value2) {
            addCriterion("cratesub between", value1, value2, "cratesub");
            return (Criteria) this;
        }

        public Criteria andCratesubNotBetween(Float value1, Float value2) {
            addCriterion("cratesub not between", value1, value2, "cratesub");
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

        public Criteria andAccrateEqualTo(Float value) {
            addCriterion("accrate =", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateNotEqualTo(Float value) {
            addCriterion("accrate <>", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateGreaterThan(Float value) {
            addCriterion("accrate >", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateGreaterThanOrEqualTo(Float value) {
            addCriterion("accrate >=", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateLessThan(Float value) {
            addCriterion("accrate <", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateLessThanOrEqualTo(Float value) {
            addCriterion("accrate <=", value, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateIn(List<Float> values) {
            addCriterion("accrate in", values, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateNotIn(List<Float> values) {
            addCriterion("accrate not in", values, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateBetween(Float value1, Float value2) {
            addCriterion("accrate between", value1, value2, "accrate");
            return (Criteria) this;
        }

        public Criteria andAccrateNotBetween(Float value1, Float value2) {
            addCriterion("accrate not between", value1, value2, "accrate");
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

        public Criteria andAccamountIsNull() {
            addCriterion("accamount is null");
            return (Criteria) this;
        }

        public Criteria andAccamountIsNotNull() {
            addCriterion("accamount is not null");
            return (Criteria) this;
        }

        public Criteria andAccamountEqualTo(Float value) {
            addCriterion("accamount =", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountNotEqualTo(Float value) {
            addCriterion("accamount <>", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountGreaterThan(Float value) {
            addCriterion("accamount >", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountGreaterThanOrEqualTo(Float value) {
            addCriterion("accamount >=", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountLessThan(Float value) {
            addCriterion("accamount <", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountLessThanOrEqualTo(Float value) {
            addCriterion("accamount <=", value, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountIn(List<Float> values) {
            addCriterion("accamount in", values, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountNotIn(List<Float> values) {
            addCriterion("accamount not in", values, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountBetween(Float value1, Float value2) {
            addCriterion("accamount between", value1, value2, "accamount");
            return (Criteria) this;
        }

        public Criteria andAccamountNotBetween(Float value1, Float value2) {
            addCriterion("accamount not between", value1, value2, "accamount");
            return (Criteria) this;
        }

        public Criteria andIncomeidIsNull() {
            addCriterion("inComeId is null");
            return (Criteria) this;
        }

        public Criteria andIncomeidIsNotNull() {
            addCriterion("inComeId is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeidEqualTo(Long value) {
            addCriterion("inComeId =", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidNotEqualTo(Long value) {
            addCriterion("inComeId <>", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidGreaterThan(Long value) {
            addCriterion("inComeId >", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidGreaterThanOrEqualTo(Long value) {
            addCriterion("inComeId >=", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidLessThan(Long value) {
            addCriterion("inComeId <", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidLessThanOrEqualTo(Long value) {
            addCriterion("inComeId <=", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidIn(List<Long> values) {
            addCriterion("inComeId in", values, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidNotIn(List<Long> values) {
            addCriterion("inComeId not in", values, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidBetween(Long value1, Long value2) {
            addCriterion("inComeId between", value1, value2, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidNotBetween(Long value1, Long value2) {
            addCriterion("inComeId not between", value1, value2, "incomeid");
            return (Criteria) this;
        }

        public Criteria andClaimidIsNull() {
            addCriterion("claimId is null");
            return (Criteria) this;
        }

        public Criteria andClaimidIsNotNull() {
            addCriterion("claimId is not null");
            return (Criteria) this;
        }

        public Criteria andClaimidEqualTo(Long value) {
            addCriterion("claimId =", value, "claimid");
            return (Criteria) this;
        }

        public Criteria andClaimidNotEqualTo(Long value) {
            addCriterion("claimId <>", value, "claimid");
            return (Criteria) this;
        }

        public Criteria andClaimidGreaterThan(Long value) {
            addCriterion("claimId >", value, "claimid");
            return (Criteria) this;
        }

        public Criteria andClaimidGreaterThanOrEqualTo(Long value) {
            addCriterion("claimId >=", value, "claimid");
            return (Criteria) this;
        }

        public Criteria andClaimidLessThan(Long value) {
            addCriterion("claimId <", value, "claimid");
            return (Criteria) this;
        }

        public Criteria andClaimidLessThanOrEqualTo(Long value) {
            addCriterion("claimId <=", value, "claimid");
            return (Criteria) this;
        }

        public Criteria andClaimidIn(List<Long> values) {
            addCriterion("claimId in", values, "claimid");
            return (Criteria) this;
        }

        public Criteria andClaimidNotIn(List<Long> values) {
            addCriterion("claimId not in", values, "claimid");
            return (Criteria) this;
        }

        public Criteria andClaimidBetween(Long value1, Long value2) {
            addCriterion("claimId between", value1, value2, "claimid");
            return (Criteria) this;
        }

        public Criteria andClaimidNotBetween(Long value1, Long value2) {
            addCriterion("claimId not between", value1, value2, "claimid");
            return (Criteria) this;
        }

        public Criteria andClientnameIsNull() {
            addCriterion("clientname is null");
            return (Criteria) this;
        }

        public Criteria andClientnameIsNotNull() {
            addCriterion("clientname is not null");
            return (Criteria) this;
        }

        public Criteria andClientnameEqualTo(String value) {
            addCriterion("clientname =", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotEqualTo(String value) {
            addCriterion("clientname <>", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameGreaterThan(String value) {
            addCriterion("clientname >", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameGreaterThanOrEqualTo(String value) {
            addCriterion("clientname >=", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLessThan(String value) {
            addCriterion("clientname <", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLessThanOrEqualTo(String value) {
            addCriterion("clientname <=", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLike(String value) {
            addCriterion("clientname like", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotLike(String value) {
            addCriterion("clientname not like", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameIn(List<String> values) {
            addCriterion("clientname in", values, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotIn(List<String> values) {
            addCriterion("clientname not in", values, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameBetween(String value1, String value2) {
            addCriterion("clientname between", value1, value2, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotBetween(String value1, String value2) {
            addCriterion("clientname not between", value1, value2, "clientname");
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

        public Criteria andCreateOperatorIsNull() {
            addCriterion("Create_Operator is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIsNotNull() {
            addCriterion("Create_Operator is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorEqualTo(Long value) {
            addCriterion("Create_Operator =", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotEqualTo(Long value) {
            addCriterion("Create_Operator <>", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorGreaterThan(Long value) {
            addCriterion("Create_Operator >", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorGreaterThanOrEqualTo(Long value) {
            addCriterion("Create_Operator >=", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLessThan(Long value) {
            addCriterion("Create_Operator <", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLessThanOrEqualTo(Long value) {
            addCriterion("Create_Operator <=", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIn(List<Long> values) {
            addCriterion("Create_Operator in", values, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotIn(List<Long> values) {
            addCriterion("Create_Operator not in", values, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorBetween(Long value1, Long value2) {
            addCriterion("Create_Operator between", value1, value2, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotBetween(Long value1, Long value2) {
            addCriterion("Create_Operator not between", value1, value2, "createOperator");
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

        public Criteria andBillnumberIsNull() {
            addCriterion("billnumber is null");
            return (Criteria) this;
        }

        public Criteria andBillnumberIsNotNull() {
            addCriterion("billnumber is not null");
            return (Criteria) this;
        }

        public Criteria andBillnumberEqualTo(String value) {
            addCriterion("billnumber =", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotEqualTo(String value) {
            addCriterion("billnumber <>", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberGreaterThan(String value) {
            addCriterion("billnumber >", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberGreaterThanOrEqualTo(String value) {
            addCriterion("billnumber >=", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLessThan(String value) {
            addCriterion("billnumber <", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLessThanOrEqualTo(String value) {
            addCriterion("billnumber <=", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLike(String value) {
            addCriterion("billnumber like", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotLike(String value) {
            addCriterion("billnumber not like", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberIn(List<String> values) {
            addCriterion("billnumber in", values, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotIn(List<String> values) {
            addCriterion("billnumber not in", values, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberBetween(String value1, String value2) {
            addCriterion("billnumber between", value1, value2, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotBetween(String value1, String value2) {
            addCriterion("billnumber not between", value1, value2, "billnumber");
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