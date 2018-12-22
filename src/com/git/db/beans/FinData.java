package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class FinData implements Serializable {
    private String batchNo;

    private String bussId;

    private String bussKeyNo;

    private String finNo;

    private String finName;

    private Float money;

    private String currency;

    private Date finDate;

    private String extend1;

    private String extend2;

    private String extend3;

    private String makeUser;

    private Date makeTime;

    private String dealFlag;

    private static final long serialVersionUID = 1L;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getBussId() {
        return bussId;
    }

    public void setBussId(String bussId) {
        this.bussId = bussId == null ? null : bussId.trim();
    }

    public String getBussKeyNo() {
        return bussKeyNo;
    }

    public void setBussKeyNo(String bussKeyNo) {
        this.bussKeyNo = bussKeyNo == null ? null : bussKeyNo.trim();
    }

    public String getFinNo() {
        return finNo;
    }

    public void setFinNo(String finNo) {
        this.finNo = finNo == null ? null : finNo.trim();
    }

    public String getFinName() {
        return finName;
    }

    public void setFinName(String finName) {
        this.finName = finName == null ? null : finName.trim();
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Date getFinDate() {
        return finDate;
    }

    public void setFinDate(Date finDate) {
        this.finDate = finDate;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1 == null ? null : extend1.trim();
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2 == null ? null : extend2.trim();
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
    }

    public String getMakeUser() {
        return makeUser;
    }

    public void setMakeUser(String makeUser) {
        this.makeUser = makeUser == null ? null : makeUser.trim();
    }

    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }

    public String getDealFlag() {
        return dealFlag;
    }

    public void setDealFlag(String dealFlag) {
        this.dealFlag = dealFlag == null ? null : dealFlag.trim();
    }
}