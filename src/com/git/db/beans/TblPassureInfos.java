package com.git.db.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TblPassureInfos implements Serializable {
    private Long passureid;

    private String assurenum;

    private Long caseid;

    private Long feeid;

    private Long rewarranterid;

    private String rewarrantersn;

    private String rewarranter;

    private Long rewarranttypeid;

    private String rewarranttype;

    private String currency;

    private BigDecimal rmbfee;

    private BigDecimal usdfee;

    private BigDecimal assurefee;

    private String remark;

    private String guaranteeexpressnumber;

    private String canceltheguarantee;

    private String guaranteesender;

    private Date guaranteereturndate;

    private String trackingnumber;

    private Date securitydate;

    private String receiver;

    private Date zbsendtime;

    private String recognizorname;

    private Date zbgatherdate;

    private Long paymentid;

    private Long replaceid;

    private Long replacedid;

    private String ordernum;

    private String replacednum;

    private Date alertdate;

    private String reportflag;

    private BigDecimal servicefee;

    private String receiveflag;

    private String assureder;

    private Date backdate;

    private Date issuedate;

    private String replacenum;

    private BigDecimal accrate;

    private String acccurrency;

    private BigDecimal accamount;

    private Date accdate;

    private Date arrdate;

    private Date paydate;

    private Long createoperatorid;

    private Long modifyoperatorid;

    private Date createtime;

    private Date modifytime;

    private Long billid;

    private String feestatuse;

    private static final long serialVersionUID = 1L;

    public Long getPassureid() {
        return passureid;
    }

    public void setPassureid(Long passureid) {
        this.passureid = passureid;
    }

    public String getAssurenum() {
        return assurenum;
    }

    public void setAssurenum(String assurenum) {
        this.assurenum = assurenum == null ? null : assurenum.trim();
    }

    public Long getCaseid() {
        return caseid;
    }

    public void setCaseid(Long caseid) {
        this.caseid = caseid;
    }

    public Long getFeeid() {
        return feeid;
    }

    public void setFeeid(Long feeid) {
        this.feeid = feeid;
    }

    public Long getRewarranterid() {
        return rewarranterid;
    }

    public void setRewarranterid(Long rewarranterid) {
        this.rewarranterid = rewarranterid;
    }

    public String getRewarrantersn() {
        return rewarrantersn;
    }

    public void setRewarrantersn(String rewarrantersn) {
        this.rewarrantersn = rewarrantersn == null ? null : rewarrantersn.trim();
    }

    public String getRewarranter() {
        return rewarranter;
    }

    public void setRewarranter(String rewarranter) {
        this.rewarranter = rewarranter == null ? null : rewarranter.trim();
    }

    public Long getRewarranttypeid() {
        return rewarranttypeid;
    }

    public void setRewarranttypeid(Long rewarranttypeid) {
        this.rewarranttypeid = rewarranttypeid;
    }

    public String getRewarranttype() {
        return rewarranttype;
    }

    public void setRewarranttype(String rewarranttype) {
        this.rewarranttype = rewarranttype == null ? null : rewarranttype.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getRmbfee() {
        return rmbfee;
    }

    public void setRmbfee(BigDecimal rmbfee) {
        this.rmbfee = rmbfee;
    }

    public BigDecimal getUsdfee() {
        return usdfee;
    }

    public void setUsdfee(BigDecimal usdfee) {
        this.usdfee = usdfee;
    }

    public BigDecimal getAssurefee() {
        return assurefee;
    }

    public void setAssurefee(BigDecimal assurefee) {
        this.assurefee = assurefee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getGuaranteeexpressnumber() {
        return guaranteeexpressnumber;
    }

    public void setGuaranteeexpressnumber(String guaranteeexpressnumber) {
        this.guaranteeexpressnumber = guaranteeexpressnumber == null ? null : guaranteeexpressnumber.trim();
    }

    public String getCanceltheguarantee() {
        return canceltheguarantee;
    }

    public void setCanceltheguarantee(String canceltheguarantee) {
        this.canceltheguarantee = canceltheguarantee == null ? null : canceltheguarantee.trim();
    }

    public String getGuaranteesender() {
        return guaranteesender;
    }

    public void setGuaranteesender(String guaranteesender) {
        this.guaranteesender = guaranteesender == null ? null : guaranteesender.trim();
    }

    public Date getGuaranteereturndate() {
        return guaranteereturndate;
    }

    public void setGuaranteereturndate(Date guaranteereturndate) {
        this.guaranteereturndate = guaranteereturndate;
    }

    public String getTrackingnumber() {
        return trackingnumber;
    }

    public void setTrackingnumber(String trackingnumber) {
        this.trackingnumber = trackingnumber == null ? null : trackingnumber.trim();
    }

    public Date getSecuritydate() {
        return securitydate;
    }

    public void setSecuritydate(Date securitydate) {
        this.securitydate = securitydate;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public Date getZbsendtime() {
        return zbsendtime;
    }

    public void setZbsendtime(Date zbsendtime) {
        this.zbsendtime = zbsendtime;
    }

    public String getRecognizorname() {
        return recognizorname;
    }

    public void setRecognizorname(String recognizorname) {
        this.recognizorname = recognizorname == null ? null : recognizorname.trim();
    }

    public Date getZbgatherdate() {
        return zbgatherdate;
    }

    public void setZbgatherdate(Date zbgatherdate) {
        this.zbgatherdate = zbgatherdate;
    }

    public Long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Long paymentid) {
        this.paymentid = paymentid;
    }

    public Long getReplaceid() {
        return replaceid;
    }

    public void setReplaceid(Long replaceid) {
        this.replaceid = replaceid;
    }

    public Long getReplacedid() {
        return replacedid;
    }

    public void setReplacedid(Long replacedid) {
        this.replacedid = replacedid;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getReplacednum() {
        return replacednum;
    }

    public void setReplacednum(String replacednum) {
        this.replacednum = replacednum == null ? null : replacednum.trim();
    }

    public Date getAlertdate() {
        return alertdate;
    }

    public void setAlertdate(Date alertdate) {
        this.alertdate = alertdate;
    }

    public String getReportflag() {
        return reportflag;
    }

    public void setReportflag(String reportflag) {
        this.reportflag = reportflag == null ? null : reportflag.trim();
    }

    public BigDecimal getServicefee() {
        return servicefee;
    }

    public void setServicefee(BigDecimal servicefee) {
        this.servicefee = servicefee;
    }

    public String getReceiveflag() {
        return receiveflag;
    }

    public void setReceiveflag(String receiveflag) {
        this.receiveflag = receiveflag == null ? null : receiveflag.trim();
    }

    public String getAssureder() {
        return assureder;
    }

    public void setAssureder(String assureder) {
        this.assureder = assureder == null ? null : assureder.trim();
    }

    public Date getBackdate() {
        return backdate;
    }

    public void setBackdate(Date backdate) {
        this.backdate = backdate;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public String getReplacenum() {
        return replacenum;
    }

    public void setReplacenum(String replacenum) {
        this.replacenum = replacenum == null ? null : replacenum.trim();
    }

    public BigDecimal getAccrate() {
        return accrate;
    }

    public void setAccrate(BigDecimal accrate) {
        this.accrate = accrate;
    }

    public String getAcccurrency() {
        return acccurrency;
    }

    public void setAcccurrency(String acccurrency) {
        this.acccurrency = acccurrency == null ? null : acccurrency.trim();
    }

    public BigDecimal getAccamount() {
        return accamount;
    }

    public void setAccamount(BigDecimal accamount) {
        this.accamount = accamount;
    }

    public Date getAccdate() {
        return accdate;
    }

    public void setAccdate(Date accdate) {
        this.accdate = accdate;
    }

    public Date getArrdate() {
        return arrdate;
    }

    public void setArrdate(Date arrdate) {
        this.arrdate = arrdate;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public Long getCreateoperatorid() {
        return createoperatorid;
    }

    public void setCreateoperatorid(Long createoperatorid) {
        this.createoperatorid = createoperatorid;
    }

    public Long getModifyoperatorid() {
        return modifyoperatorid;
    }

    public void setModifyoperatorid(Long modifyoperatorid) {
        this.modifyoperatorid = modifyoperatorid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Long getBillid() {
        return billid;
    }

    public void setBillid(Long billid) {
        this.billid = billid;
    }

    public String getFeestatuse() {
        return feestatuse;
    }

    public void setFeestatuse(String feestatuse) {
        this.feestatuse = feestatuse == null ? null : feestatuse.trim();
    }
}