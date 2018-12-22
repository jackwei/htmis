package com.git.db.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ClaimIncomeImpl implements Serializable {
    private Long incomeId;

    private Long caseId;

    private String casenumber;

    private String shipname;

    private String payer;

    private String currency;

    private Float receiveamount;

    private Float bankfee;

    private Float totalamount;

    private String bank;

    private String banknum;

    private BigDecimal usdrate;

    private Float usdamount;

    private String remark;

    private Date receivedate;

    private Float differamount;

    private String status;

    private Date lockdate;

    private Long modifyOperatorId;

    private Long createOperator;

    private Date createTime;

    private Date modifyTime;

    private String clientname;

    private String applybank;

    private String applybanknum;

    private Long billId;

    private String islocked;

    private String remark1;

    private String remark2;

    private String remark3;

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

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber == null ? null : casenumber.trim();
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname == null ? null : shipname.trim();
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Float getReceiveamount() {
        return receiveamount;
    }

    public void setReceiveamount(Float receiveamount) {
        this.receiveamount = receiveamount;
    }

    public Float getBankfee() {
        return bankfee;
    }

    public void setBankfee(Float bankfee) {
        this.bankfee = bankfee;
    }

    public Float getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Float totalamount) {
        this.totalamount = totalamount;
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

    public BigDecimal getUsdrate() {
        return usdrate;
    }

    public void setUsdrate(BigDecimal usdrate) {
        this.usdrate = usdrate;
    }

    public Float getUsdamount() {
        return usdamount;
    }

    public void setUsdamount(Float usdamount) {
        this.usdamount = usdamount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public Float getDifferamount() {
        return differamount;
    }

    public void setDifferamount(Float differamount) {
        this.differamount = differamount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getLockdate() {
        return lockdate;
    }

    public void setLockdate(Date lockdate) {
        this.lockdate = lockdate;
    }

    public Long getModifyOperatorId() {
        return modifyOperatorId;
    }

    public void setModifyOperatorId(Long modifyOperatorId) {
        this.modifyOperatorId = modifyOperatorId;
    }

    public Long getCreateOperator() {
        return createOperator;
    }

    public void setCreateOperator(Long createOperator) {
        this.createOperator = createOperator;
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

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname == null ? null : clientname.trim();
    }

    public String getApplybank() {
        return applybank;
    }

    public void setApplybank(String applybank) {
        this.applybank = applybank == null ? null : applybank.trim();
    }

    public String getApplybanknum() {
        return applybanknum;
    }

    public void setApplybanknum(String applybanknum) {
        this.applybanknum = applybanknum == null ? null : applybanknum.trim();
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getIslocked() {
        return islocked;
    }

    public void setIslocked(String islocked) {
        this.islocked = islocked == null ? null : islocked.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }
}