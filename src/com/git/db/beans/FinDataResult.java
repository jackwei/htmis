package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class FinDataResult implements Serializable {
    private Long seqId;

    private String batchNo;

    private String bussId;

    private String bussKeyNo;

    private String itemId;

    private String itemName;

    private String itemType;

    private Float money;

    private String currency;

    private Date finDate;

    private String orgCode;

    private String comCode;

    private String deptCode;

    private String bankCode;

    private String bussCode;

    private String productCode;

    private String transCode;

    private String backupCode;

    private String extend1;

    private String extend2;

    private String extend3;

    private Date makeTime;

    private String dealFlag;

    private Float standbynum1;

    private Float standbynum2;

    private Date standbydate1;

    private Date standbydate2;

    private String summary;

    private String documentId;

    private Date documentDate;

    private String exchangeRate1;

    private Float amount;

    private String operator;

    private static final long serialVersionUID = 1L;

    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getBussCode() {
        return bussCode;
    }

    public void setBussCode(String bussCode) {
        this.bussCode = bussCode == null ? null : bussCode.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode == null ? null : transCode.trim();
    }

    public String getBackupCode() {
        return backupCode;
    }

    public void setBackupCode(String backupCode) {
        this.backupCode = backupCode == null ? null : backupCode.trim();
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

    public Float getStandbynum1() {
        return standbynum1;
    }

    public void setStandbynum1(Float standbynum1) {
        this.standbynum1 = standbynum1;
    }

    public Float getStandbynum2() {
        return standbynum2;
    }

    public void setStandbynum2(Float standbynum2) {
        this.standbynum2 = standbynum2;
    }

    public Date getStandbydate1() {
        return standbydate1;
    }

    public void setStandbydate1(Date standbydate1) {
        this.standbydate1 = standbydate1;
    }

    public Date getStandbydate2() {
        return standbydate2;
    }

    public void setStandbydate2(Date standbydate2) {
        this.standbydate2 = standbydate2;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public String getExchangeRate1() {
        return exchangeRate1;
    }

    public void setExchangeRate1(String exchangeRate1) {
        this.exchangeRate1 = exchangeRate1 == null ? null : exchangeRate1.trim();
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}