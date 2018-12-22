package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class ClaimRateSubImpl implements Serializable {
    private Long rateId;

    private String casenumber;

    private Long billId;

    private Float cratesub;

    private Float accrate;

    private Date arrdate;

    private Date accdate;

    private Float accamount;

    private Long incomeid;

    private Long claimid;

    private String clientname;

    private String payer;

    private Long createOperator;

    private Long modifyOperatorId;

    private Date modifyTime;

    private Date createTime;

    private String billnumber;

    private String currency;

    private static final long serialVersionUID = 1L;

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber == null ? null : casenumber.trim();
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Float getCratesub() {
        return cratesub;
    }

    public void setCratesub(Float cratesub) {
        this.cratesub = cratesub;
    }

    public Float getAccrate() {
        return accrate;
    }

    public void setAccrate(Float accrate) {
        this.accrate = accrate;
    }

    public Date getArrdate() {
        return arrdate;
    }

    public void setArrdate(Date arrdate) {
        this.arrdate = arrdate;
    }

    public Date getAccdate() {
        return accdate;
    }

    public void setAccdate(Date accdate) {
        this.accdate = accdate;
    }

    public Float getAccamount() {
        return accamount;
    }

    public void setAccamount(Float accamount) {
        this.accamount = accamount;
    }

    public Long getIncomeid() {
        return incomeid;
    }

    public void setIncomeid(Long incomeid) {
        this.incomeid = incomeid;
    }

    public Long getClaimid() {
        return claimid;
    }

    public void setClaimid(Long claimid) {
        this.claimid = claimid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname == null ? null : clientname.trim();
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
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

    public String getBillnumber() {
        return billnumber;
    }

    public void setBillnumber(String billnumber) {
        this.billnumber = billnumber == null ? null : billnumber.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }
}