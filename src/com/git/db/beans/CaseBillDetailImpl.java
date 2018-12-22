package com.git.db.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CaseBillDetailImpl implements Serializable {
    private Long detailId;

    private Long billId;

    private Long consignorid;

    private String consignorname;

    private String feenumber;

    private String feetype;

    private String bussno;

    private Date happendate;

    private String currency;

    private String remark;

    private Date accdate;

    private Date arrdate;

    private BigDecimal changerate;

    private Float servicefee;

    private Float expendses;

    private Float replacefee;

    private Float accamount;

    private Float feeamount;

    private String status;

    private String payid;

    private Date paydate;

    private String casenumber;

    private Date reportdate;

    private Date applydate;

    private Long createOperator;

    private Long modifyOperatorId;

    private Date modifyTime;

    private Date createTime;

    private String extend1;

    private String extend2;

    private String extend3;

    private static final long serialVersionUID = 1L;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getConsignorid() {
        return consignorid;
    }

    public void setConsignorid(Long consignorid) {
        this.consignorid = consignorid;
    }

    public String getConsignorname() {
        return consignorname;
    }

    public void setConsignorname(String consignorname) {
        this.consignorname = consignorname == null ? null : consignorname.trim();
    }

    public String getFeenumber() {
        return feenumber;
    }

    public void setFeenumber(String feenumber) {
        this.feenumber = feenumber == null ? null : feenumber.trim();
    }

    public String getFeetype() {
        return feetype;
    }

    public void setFeetype(String feetype) {
        this.feetype = feetype == null ? null : feetype.trim();
    }

    public String getBussno() {
        return bussno;
    }

    public void setBussno(String bussno) {
        this.bussno = bussno == null ? null : bussno.trim();
    }

    public Date getHappendate() {
        return happendate;
    }

    public void setHappendate(Date happendate) {
        this.happendate = happendate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public BigDecimal getChangerate() {
        return changerate;
    }

    public void setChangerate(BigDecimal changerate) {
        this.changerate = changerate;
    }

    public Float getServicefee() {
        return servicefee;
    }

    public void setServicefee(Float servicefee) {
        this.servicefee = servicefee;
    }

    public Float getExpendses() {
        return expendses;
    }

    public void setExpendses(Float expendses) {
        this.expendses = expendses;
    }

    public Float getReplacefee() {
        return replacefee;
    }

    public void setReplacefee(Float replacefee) {
        this.replacefee = replacefee;
    }

    public Float getAccamount() {
        return accamount;
    }

    public void setAccamount(Float accamount) {
        this.accamount = accamount;
    }

    public Float getFeeamount() {
        return feeamount;
    }

    public void setFeeamount(Float feeamount) {
        this.feeamount = feeamount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid == null ? null : payid.trim();
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber == null ? null : casenumber.trim();
    }

    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
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
}