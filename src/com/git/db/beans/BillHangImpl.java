package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class BillHangImpl implements Serializable {
    private Long id;

    private Date remittancedate;

    private String remitter;

    private String remittancecustomers;

    private Float remitmoney;

    private String bankinfo;

    private String bankcode;

    private String currency;

    private String status;

    private String entrypeople;

    private String remark;

    private Date createTime;

    private Date modifyTime;

    private Long operatorId;

    private Long modifyOperatorId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRemittancedate() {
        return remittancedate;
    }

    public void setRemittancedate(Date remittancedate) {
        this.remittancedate = remittancedate;
    }

    public String getRemitter() {
        return remitter;
    }

    public void setRemitter(String remitter) {
        this.remitter = remitter == null ? null : remitter.trim();
    }

    public String getRemittancecustomers() {
        return remittancecustomers;
    }

    public void setRemittancecustomers(String remittancecustomers) {
        this.remittancecustomers = remittancecustomers == null ? null : remittancecustomers.trim();
    }

    public Float getRemitmoney() {
        return remitmoney;
    }

    public void setRemitmoney(Float remitmoney) {
        this.remitmoney = remitmoney;
    }

    public String getBankinfo() {
        return bankinfo;
    }

    public void setBankinfo(String bankinfo) {
        this.bankinfo = bankinfo == null ? null : bankinfo.trim();
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode == null ? null : bankcode.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEntrypeople() {
        return entrypeople;
    }

    public void setEntrypeople(String entrypeople) {
        this.entrypeople = entrypeople == null ? null : entrypeople.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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