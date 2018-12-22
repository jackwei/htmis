package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class ExchageRateImpl implements Serializable {
    private Long id;

    private String code;

    private String status;

    private String currency;

    private String shortname;

    private String rate1;

    private String rate2;

    private String rate3;

    private String rate4;

    private String rate5;

    private Long createOperator;

    private Long modifyOperatorId;

    private Date modifyTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public String getRate1() {
        return rate1;
    }

    public void setRate1(String rate1) {
        this.rate1 = rate1 == null ? null : rate1.trim();
    }

    public String getRate2() {
        return rate2;
    }

    public void setRate2(String rate2) {
        this.rate2 = rate2 == null ? null : rate2.trim();
    }

    public String getRate3() {
        return rate3;
    }

    public void setRate3(String rate3) {
        this.rate3 = rate3 == null ? null : rate3.trim();
    }

    public String getRate4() {
        return rate4;
    }

    public void setRate4(String rate4) {
        this.rate4 = rate4 == null ? null : rate4.trim();
    }

    public String getRate5() {
        return rate5;
    }

    public void setRate5(String rate5) {
        this.rate5 = rate5 == null ? null : rate5.trim();
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