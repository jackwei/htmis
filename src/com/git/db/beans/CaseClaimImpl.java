package com.git.db.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CaseClaimImpl implements Serializable {
    private Long claimId;

    private Long caseId;

    private String casenumber;

    private String shipname;

    private String clientname;

    private Float realamount;

    private Float applyamount;

    private String applycurrency;

    private String currency;

    private String banknum;

    private Date treatdate;

    private BigDecimal usdrate;

    private Float usdamount;

    private Date lockdate;

    private String recordtype;

    private String remark;

    private Long createOperator;

    private Long modifyOperatorId;

    private Date modifyTime;

    private Date createTime;

    private String applybanknum;

    private String applybank;

    private String transfercurrency;

    private Float transfermount;

    private String payee;

    private String status;

    private String thingcause;

    private String branch;

    private Date transferdate;

    private String unitname;

    private String advancefeetype;

    private String incaseno;

    private Float recordmount;

    private String recordcurrency;

    private Float paymount;

    private String paycurrency;

    private String remark1;

    private String remark2;

    private Long billId;

    private String billnumber;

    private Float differamount;

    private static final long serialVersionUID = 1L;

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
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

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname == null ? null : clientname.trim();
    }

    public Float getRealamount() {
        return realamount;
    }

    public void setRealamount(Float realamount) {
        this.realamount = realamount;
    }

    public Float getApplyamount() {
        return applyamount;
    }

    public void setApplyamount(Float applyamount) {
        this.applyamount = applyamount;
    }

    public String getApplycurrency() {
        return applycurrency;
    }

    public void setApplycurrency(String applycurrency) {
        this.applycurrency = applycurrency == null ? null : applycurrency.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getBanknum() {
        return banknum;
    }

    public void setBanknum(String banknum) {
        this.banknum = banknum == null ? null : banknum.trim();
    }

    public Date getTreatdate() {
        return treatdate;
    }

    public void setTreatdate(Date treatdate) {
        this.treatdate = treatdate;
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

    public Date getLockdate() {
        return lockdate;
    }

    public void setLockdate(Date lockdate) {
        this.lockdate = lockdate;
    }

    public String getRecordtype() {
        return recordtype;
    }

    public void setRecordtype(String recordtype) {
        this.recordtype = recordtype == null ? null : recordtype.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCreateOperator() {
        return createOperator;
    }

    public void setCreateOperator(Long createOperator) {
        this.createOperator = createOperator;
    }

    public Long getModifyOperatorId() {
        return modifyOperatorId;
    }

    public void setModifyOperatorId(Long modifyOperatorId) {
        this.modifyOperatorId = modifyOperatorId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getApplybanknum() {
        return applybanknum;
    }

    public void setApplybanknum(String applybanknum) {
        this.applybanknum = applybanknum == null ? null : applybanknum.trim();
    }

    public String getApplybank() {
        return applybank;
    }

    public void setApplybank(String applybank) {
        this.applybank = applybank == null ? null : applybank.trim();
    }

    public String getTransfercurrency() {
        return transfercurrency;
    }

    public void setTransfercurrency(String transfercurrency) {
        this.transfercurrency = transfercurrency == null ? null : transfercurrency.trim();
    }

    public Float getTransfermount() {
        return transfermount;
    }

    public void setTransfermount(Float transfermount) {
        this.transfermount = transfermount;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee == null ? null : payee.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getThingcause() {
        return thingcause;
    }

    public void setThingcause(String thingcause) {
        this.thingcause = thingcause == null ? null : thingcause.trim();
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch == null ? null : branch.trim();
    }

    public Date getTransferdate() {
        return transferdate;
    }

    public void setTransferdate(Date transferdate) {
        this.transferdate = transferdate;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public String getAdvancefeetype() {
        return advancefeetype;
    }

    public void setAdvancefeetype(String advancefeetype) {
        this.advancefeetype = advancefeetype == null ? null : advancefeetype.trim();
    }

    public String getIncaseno() {
        return incaseno;
    }

    public void setIncaseno(String incaseno) {
        this.incaseno = incaseno == null ? null : incaseno.trim();
    }

    public Float getRecordmount() {
        return recordmount;
    }

    public void setRecordmount(Float recordmount) {
        this.recordmount = recordmount;
    }

    public String getRecordcurrency() {
        return recordcurrency;
    }

    public void setRecordcurrency(String recordcurrency) {
        this.recordcurrency = recordcurrency == null ? null : recordcurrency.trim();
    }

    public Float getPaymount() {
        return paymount;
    }

    public void setPaymount(Float paymount) {
        this.paymount = paymount;
    }

    public String getPaycurrency() {
        return paycurrency;
    }

    public void setPaycurrency(String paycurrency) {
        this.paycurrency = paycurrency == null ? null : paycurrency.trim();
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

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getBillnumber() {
        return billnumber;
    }

    public void setBillnumber(String billnumber) {
        this.billnumber = billnumber == null ? null : billnumber.trim();
    }

    public Float getDifferamount() {
        return differamount;
    }

    public void setDifferamount(Float differamount) {
        this.differamount = differamount;
    }
}