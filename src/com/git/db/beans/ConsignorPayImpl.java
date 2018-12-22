package com.git.db.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ConsignorPayImpl implements Serializable {
    private Long payId;

    private String payeename;

    private String payeeid;

    private Float payamount;

    private Date paydate;

    private String payeeaccountnum;

    private String payeeaccountname;

    private Float bankfee;

    private String banknum;

    private Float feeamount;

    private String paycurrency;

    private String orgid;

    private String orgname;

    private String orgidb;

    private String orgnameb;

    private String userid;

    private String useridname;

    private Date checkdate;

    private String binddetail;

    private String remark;

    private Long createOperator;

    private Long modifyOperatorId;

    private Date modifyTime;

    private Date createTime;

    private String paystatus;

    private BigDecimal rmbrate;

    private Float rmbamount;

    private String remark1;

    private String remark2;

    private String remark3;

    private static final long serialVersionUID = 1L;

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public String getPayeename() {
        return payeename;
    }

    public void setPayeename(String payeename) {
        this.payeename = payeename == null ? null : payeename.trim();
    }

    public String getPayeeid() {
        return payeeid;
    }

    public void setPayeeid(String payeeid) {
        this.payeeid = payeeid == null ? null : payeeid.trim();
    }

    public Float getPayamount() {
        return payamount;
    }

    public void setPayamount(Float payamount) {
        this.payamount = payamount;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public String getPayeeaccountnum() {
        return payeeaccountnum;
    }

    public void setPayeeaccountnum(String payeeaccountnum) {
        this.payeeaccountnum = payeeaccountnum == null ? null : payeeaccountnum.trim();
    }

    public String getPayeeaccountname() {
        return payeeaccountname;
    }

    public void setPayeeaccountname(String payeeaccountname) {
        this.payeeaccountname = payeeaccountname == null ? null : payeeaccountname.trim();
    }

    public Float getBankfee() {
        return bankfee;
    }

    public void setBankfee(Float bankfee) {
        this.bankfee = bankfee;
    }

    public String getBanknum() {
        return banknum;
    }

    public void setBanknum(String banknum) {
        this.banknum = banknum == null ? null : banknum.trim();
    }

    public Float getFeeamount() {
        return feeamount;
    }

    public void setFeeamount(Float feeamount) {
        this.feeamount = feeamount;
    }

    public String getPaycurrency() {
        return paycurrency;
    }

    public void setPaycurrency(String paycurrency) {
        this.paycurrency = paycurrency == null ? null : paycurrency.trim();
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getOrgidb() {
        return orgidb;
    }

    public void setOrgidb(String orgidb) {
        this.orgidb = orgidb == null ? null : orgidb.trim();
    }

    public String getOrgnameb() {
        return orgnameb;
    }

    public void setOrgnameb(String orgnameb) {
        this.orgnameb = orgnameb == null ? null : orgnameb.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUseridname() {
        return useridname;
    }

    public void setUseridname(String useridname) {
        this.useridname = useridname == null ? null : useridname.trim();
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getBinddetail() {
        return binddetail;
    }

    public void setBinddetail(String binddetail) {
        this.binddetail = binddetail == null ? null : binddetail.trim();
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

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus == null ? null : paystatus.trim();
    }

    public BigDecimal getRmbrate() {
        return rmbrate;
    }

    public void setRmbrate(BigDecimal rmbrate) {
        this.rmbrate = rmbrate;
    }

    public Float getRmbamount() {
        return rmbamount;
    }

    public void setRmbamount(Float rmbamount) {
        this.rmbamount = rmbamount;
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