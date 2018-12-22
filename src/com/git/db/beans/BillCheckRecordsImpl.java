package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class BillCheckRecordsImpl implements Serializable {
    private Long recordsId;

    private Long billId;

    private String feenumber;

    private Long incomeId;

    private String statementnumber;

    private Float checkamount;

    private String remark;

    private Long createOperator;

    private Long modifyOperatorId;

    private Date modifyTime;

    private Date createTime;

    private String extend1;

    private String extend2;

    private String extend3;

    private static final long serialVersionUID = 1L;

    public Long getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(Long recordsId) {
        this.recordsId = recordsId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getFeenumber() {
        return feenumber;
    }

    public void setFeenumber(String feenumber) {
        this.feenumber = feenumber == null ? null : feenumber.trim();
    }

    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }

    public String getStatementnumber() {
        return statementnumber;
    }

    public void setStatementnumber(String statementnumber) {
        this.statementnumber = statementnumber == null ? null : statementnumber.trim();
    }

    public Float getCheckamount() {
        return checkamount;
    }

    public void setCheckamount(Float checkamount) {
        this.checkamount = checkamount;
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