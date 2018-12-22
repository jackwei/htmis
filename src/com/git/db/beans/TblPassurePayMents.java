package com.git.db.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TblPassurePayMents implements Serializable {
    private Long passurepayid;

    private Date createdate;

    private Long userid;

    private String username;

    private String reportflag;

    private Date paydate;

    private String orgcode;

    private String orgname;

    private Long total;

    private BigDecimal feemount;

    private String receivedetail;

    private String paydetail;

    private Long createoperatorid;

    private Long modifyoperatorid;

    private Date createtime;

    private Date modifytime;

    private Long cpid;

    private Long year;

    private Long month;

    private static final long serialVersionUID = 1L;

    public Long getPassurepayid() {
        return passurepayid;
    }

    public void setPassurepayid(Long passurepayid) {
        this.passurepayid = passurepayid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getReportflag() {
        return reportflag;
    }

    public void setReportflag(String reportflag) {
        this.reportflag = reportflag == null ? null : reportflag.trim();
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public BigDecimal getFeemount() {
        return feemount;
    }

    public void setFeemount(BigDecimal feemount) {
        this.feemount = feemount;
    }

    public String getReceivedetail() {
        return receivedetail;
    }

    public void setReceivedetail(String receivedetail) {
        this.receivedetail = receivedetail == null ? null : receivedetail.trim();
    }

    public String getPaydetail() {
        return paydetail;
    }

    public void setPaydetail(String paydetail) {
        this.paydetail = paydetail == null ? null : paydetail.trim();
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

    public Long getCpid() {
        return cpid;
    }

    public void setCpid(Long cpid) {
        this.cpid = cpid;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }
}