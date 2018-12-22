package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class CaseBillImpl implements Serializable {
    private Long billId;

    private String feenumber;

    private Long caseId;

    private String casenumber;

    private Float servicefee;

    private Float assurefee;

    private Float thirdpart;

    private Float compensationsub;

    private Float replaceamount;

    private Float otherfee;

    private Float advancefee;

    private Float feeamount;

    private Float expendses;

    private String currency;

    private Date arrdate;

    private String address;

    private String servicedes;

    private String payer;

    private String coname;

    private Date accdate;

    private String feestatuse;

    private String feetype;

    private String orgcode;

    private String orgname;

    private String remark;

    private Long operatorId;

    private Date createTime;

    private Date modifyTime;

    private Long modifyOperatorId;

    private static final long serialVersionUID = 1L;

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getFeenumber() {
        return feenumber;
    }

    public void setFeenumber(String feenumber) {
        this.feenumber = feenumber == null ? null : feenumber.trim();
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

    public Float getServicefee() {
        return servicefee;
    }

    public void setServicefee(Float servicefee) {
        this.servicefee = servicefee;
    }

    public Float getAssurefee() {
        return assurefee;
    }

    public void setAssurefee(Float assurefee) {
        this.assurefee = assurefee;
    }

    public Float getThirdpart() {
        return thirdpart;
    }

    public void setThirdpart(Float thirdpart) {
        this.thirdpart = thirdpart;
    }

    public Float getCompensationsub() {
        return compensationsub;
    }

    public void setCompensationsub(Float compensationsub) {
        this.compensationsub = compensationsub;
    }

    public Float getReplaceamount() {
        return replaceamount;
    }

    public void setReplaceamount(Float replaceamount) {
        this.replaceamount = replaceamount;
    }

    public Float getOtherfee() {
        return otherfee;
    }

    public void setOtherfee(Float otherfee) {
        this.otherfee = otherfee;
    }

    public Float getAdvancefee() {
        return advancefee;
    }

    public void setAdvancefee(Float advancefee) {
        this.advancefee = advancefee;
    }

    public Float getFeeamount() {
        return feeamount;
    }

    public void setFeeamount(Float feeamount) {
        this.feeamount = feeamount;
    }

    public Float getExpendses() {
        return expendses;
    }

    public void setExpendses(Float expendses) {
        this.expendses = expendses;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Date getArrdate() {
        return arrdate;
    }

    public void setArrdate(Date arrdate) {
        this.arrdate = arrdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getServicedes() {
        return servicedes;
    }

    public void setServicedes(String servicedes) {
        this.servicedes = servicedes == null ? null : servicedes.trim();
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname == null ? null : coname.trim();
    }

    public Date getAccdate() {
        return accdate;
    }

    public void setAccdate(Date accdate) {
        this.accdate = accdate;
    }

    public String getFeestatuse() {
        return feestatuse;
    }

    public void setFeestatuse(String feestatuse) {
        this.feestatuse = feestatuse == null ? null : feestatuse.trim();
    }

    public String getFeetype() {
        return feetype;
    }

    public void setFeetype(String feetype) {
        this.feetype = feetype == null ? null : feetype.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
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

    public Long getModifyOperatorId() {
        return modifyOperatorId;
    }

    public void setModifyOperatorId(Long modifyOperatorId) {
        this.modifyOperatorId = modifyOperatorId;
    }
}