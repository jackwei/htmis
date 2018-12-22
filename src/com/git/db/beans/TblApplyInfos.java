package com.git.db.beans;

import java.math.BigDecimal;
import java.util.Date;

public class TblApplyInfos {
    private Long oid;

    private String applytype;

    private String status;

    private String name;

    private Long processdefid;

    private String processname;

    private Long parentid;

    private String parentname;

    private String applydes;

    private String deleted;

    private String userid;

    private String username;

    private String orgid;

    private String orgname;

    private Integer step;

    private String sqnumber;

    private String currency;

    private BigDecimal amounta;

    private BigDecimal amountb;

    private BigDecimal amountc;

    private String remarka;

    private String remarkb;

    private String remarkc;

    private Date applydate;

    private Date creatdate;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype == null ? null : applytype.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getProcessdefid() {
        return processdefid;
    }

    public void setProcessdefid(Long processdefid) {
        this.processdefid = processdefid;
    }

    public String getProcessname() {
        return processname;
    }

    public void setProcessname(String processname) {
        this.processname = processname == null ? null : processname.trim();
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname == null ? null : parentname.trim();
    }

    public String getApplydes() {
        return applydes;
    }

    public void setApplydes(String applydes) {
        this.applydes = applydes == null ? null : applydes.trim();
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getSqnumber() {
        return sqnumber;
    }

    public void setSqnumber(String sqnumber) {
        this.sqnumber = sqnumber == null ? null : sqnumber.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getAmounta() {
        return amounta;
    }

    public void setAmounta(BigDecimal amounta) {
        this.amounta = amounta;
    }

    public BigDecimal getAmountb() {
        return amountb;
    }

    public void setAmountb(BigDecimal amountb) {
        this.amountb = amountb;
    }

    public BigDecimal getAmountc() {
        return amountc;
    }

    public void setAmountc(BigDecimal amountc) {
        this.amountc = amountc;
    }

    public String getRemarka() {
        return remarka;
    }

    public void setRemarka(String remarka) {
        this.remarka = remarka == null ? null : remarka.trim();
    }

    public String getRemarkb() {
        return remarkb;
    }

    public void setRemarkb(String remarkb) {
        this.remarkb = remarkb == null ? null : remarkb.trim();
    }

    public String getRemarkc() {
        return remarkc;
    }

    public void setRemarkc(String remarkc) {
        this.remarkc = remarkc == null ? null : remarkc.trim();
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }
}