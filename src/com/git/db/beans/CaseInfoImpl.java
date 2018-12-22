package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class CaseInfoImpl implements Serializable {
    private Long caseId;

    private String casenumber;

    private String excasenumber;

    private String academynum;

    private String shipname;

    private String casetypeid;

    private String casetypename;

    private Date accidentdate;

    private String accidentportid;

    private String accidentport;

    private String consignortypeid;

    private String consignortypename;

    private String consignorid;

    private String consignorname;

    private String consignorsn;

    private String casecontact;

    private String checkcompany;

    private String barristers;

    private String casedes;

    private String orgcode;

    private String oraname;

    private String userid;

    private String username;

    private Date setdate;

    private Date enddate;

    private String casestatus;

    private Long feecount;

    private String accflag;

    private Date alertdate;

    private Long createOperator;

    private Long modifyOperatorId;

    private Date modifyTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

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

    public String getExcasenumber() {
        return excasenumber;
    }

    public void setExcasenumber(String excasenumber) {
        this.excasenumber = excasenumber == null ? null : excasenumber.trim();
    }

    public String getAcademynum() {
        return academynum;
    }

    public void setAcademynum(String academynum) {
        this.academynum = academynum == null ? null : academynum.trim();
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname == null ? null : shipname.trim();
    }

    public String getCasetypeid() {
        return casetypeid;
    }

    public void setCasetypeid(String casetypeid) {
        this.casetypeid = casetypeid == null ? null : casetypeid.trim();
    }

    public String getCasetypename() {
        return casetypename;
    }

    public void setCasetypename(String casetypename) {
        this.casetypename = casetypename == null ? null : casetypename.trim();
    }

    public Date getAccidentdate() {
        return accidentdate;
    }

    public void setAccidentdate(Date accidentdate) {
        this.accidentdate = accidentdate;
    }

    public String getAccidentportid() {
        return accidentportid;
    }

    public void setAccidentportid(String accidentportid) {
        this.accidentportid = accidentportid == null ? null : accidentportid.trim();
    }

    public String getAccidentport() {
        return accidentport;
    }

    public void setAccidentport(String accidentport) {
        this.accidentport = accidentport == null ? null : accidentport.trim();
    }

    public String getConsignortypeid() {
        return consignortypeid;
    }

    public void setConsignortypeid(String consignortypeid) {
        this.consignortypeid = consignortypeid == null ? null : consignortypeid.trim();
    }

    public String getConsignortypename() {
        return consignortypename;
    }

    public void setConsignortypename(String consignortypename) {
        this.consignortypename = consignortypename == null ? null : consignortypename.trim();
    }

    public String getConsignorid() {
        return consignorid;
    }

    public void setConsignorid(String consignorid) {
        this.consignorid = consignorid == null ? null : consignorid.trim();
    }

    public String getConsignorname() {
        return consignorname;
    }

    public void setConsignorname(String consignorname) {
        this.consignorname = consignorname == null ? null : consignorname.trim();
    }

    public String getConsignorsn() {
        return consignorsn;
    }

    public void setConsignorsn(String consignorsn) {
        this.consignorsn = consignorsn == null ? null : consignorsn.trim();
    }

    public String getCasecontact() {
        return casecontact;
    }

    public void setCasecontact(String casecontact) {
        this.casecontact = casecontact == null ? null : casecontact.trim();
    }

    public String getCheckcompany() {
        return checkcompany;
    }

    public void setCheckcompany(String checkcompany) {
        this.checkcompany = checkcompany == null ? null : checkcompany.trim();
    }

    public String getBarristers() {
        return barristers;
    }

    public void setBarristers(String barristers) {
        this.barristers = barristers == null ? null : barristers.trim();
    }

    public String getCasedes() {
        return casedes;
    }

    public void setCasedes(String casedes) {
        this.casedes = casedes == null ? null : casedes.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getOraname() {
        return oraname;
    }

    public void setOraname(String oraname) {
        this.oraname = oraname == null ? null : oraname.trim();
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

    public Date getSetdate() {
        return setdate;
    }

    public void setSetdate(Date setdate) {
        this.setdate = setdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getCasestatus() {
        return casestatus;
    }

    public void setCasestatus(String casestatus) {
        this.casestatus = casestatus == null ? null : casestatus.trim();
    }

    public Long getFeecount() {
        return feecount;
    }

    public void setFeecount(Long feecount) {
        this.feecount = feecount;
    }

    public String getAccflag() {
        return accflag;
    }

    public void setAccflag(String accflag) {
        this.accflag = accflag == null ? null : accflag.trim();
    }

    public Date getAlertdate() {
        return alertdate;
    }

    public void setAlertdate(Date alertdate) {
        this.alertdate = alertdate;
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
}