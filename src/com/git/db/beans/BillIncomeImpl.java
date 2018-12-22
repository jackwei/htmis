package com.git.db.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BillIncomeImpl implements Serializable {
    private Long incomeId;

    private Long caseId;

    private String statementnumber;

    private String feenumber;

    private String payername;

    private String currency;

    private Float payamount;

    private Float lossamount;

    private Float changeamount;

    private Float differamount;

    private String bank;

    private String banknum;

    private String incometype;

    private String orgcode;

    private String orgname;

    private String isTransform;

    private String transformcurrency;

    private BigDecimal transformrate;

    private Float transformamount;

    private String remark;

    private Date tradedate;

    private Date checkdate;

    private String entrypeople;

    private Date createTime;

    private Date modifyTime;

    private Long operatorId;

    private Long modifyOperatorId;

    private static final long serialVersionUID = 1L;

    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getStatementnumber() {
        return statementnumber;
    }

    public void setStatementnumber(String statementnumber) {
        this.statementnumber = statementnumber == null ? null : statementnumber.trim();
    }

    public String getFeenumber() {
        return feenumber;
    }

    public void setFeenumber(String feenumber) {
        this.feenumber = feenumber == null ? null : feenumber.trim();
    }

    public String getPayername() {
        return payername;
    }

    public void setPayername(String payername) {
        this.payername = payername == null ? null : payername.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Float getPayamount() {
        return payamount;
    }

    public void setPayamount(Float payamount) {
        this.payamount = payamount;
    }

    public Float getLossamount() {
        return lossamount;
    }

    public void setLossamount(Float lossamount) {
        this.lossamount = lossamount;
    }

    public Float getChangeamount() {
        return changeamount;
    }

    public void setChangeamount(Float changeamount) {
        this.changeamount = changeamount;
    }

    public Float getDifferamount() {
        return differamount;
    }

    public void setDifferamount(Float differamount) {
        this.differamount = differamount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBanknum() {
        return banknum;
    }

    public void setBanknum(String banknum) {
        this.banknum = banknum == null ? null : banknum.trim();
    }

    public String getIncometype() {
        return incometype;
    }

    public void setIncometype(String incometype) {
        this.incometype = incometype == null ? null : incometype.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getIsTransform() {
        return isTransform;
    }

    public void setIsTransform(String isTransform) {
        this.isTransform = isTransform == null ? null : isTransform.trim();
    }

    public String getTransformcurrency() {
        return transformcurrency;
    }

    public void setTransformcurrency(String transformcurrency) {
        this.transformcurrency = transformcurrency == null ? null : transformcurrency.trim();
    }

    public BigDecimal getTransformrate() {
        return transformrate;
    }

    public void setTransformrate(BigDecimal transformrate) {
        this.transformrate = transformrate;
    }

    public Float getTransformamount() {
        return transformamount;
    }

    public void setTransformamount(Float transformamount) {
        this.transformamount = transformamount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getTradedate() {
        return tradedate;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getEntrypeople() {
        return entrypeople;
    }

    public void setEntrypeople(String entrypeople) {
        this.entrypeople = entrypeople == null ? null : entrypeople.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getModifyOperatorId() {
        return modifyOperatorId;
    }

    public void setModifyOperatorId(Long modifyOperatorId) {
        this.modifyOperatorId = modifyOperatorId;
    }
}