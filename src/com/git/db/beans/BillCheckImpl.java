package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class BillCheckImpl implements Serializable {
    private Long checkId;

    private String payername;

    private Float payamount;

    private Float expends;

    private Float income;

    private Float replaceamount;

    private Float feeamount;

    private String currency;

    private String orgcode;

    private String orgname;

    private Float differamount;

    private Date checkdate;

    private String feenum;

    private String feeid;

    private String biztype;

    private String biztypeid;

    private Date accdate;

    private Date arrdate;

    private Date changedate;

    private Date printdate;

    private String flag;

    private String remark;

    private Long createOperator;

    private Long modifyOperatorId;

    private Date modifyTime;

    private Date createTime;

    private String extend1;

    private String extend2;

    private String extend3;

    private String statementnumber;

    private Float checkamount;

    private static final long serialVersionUID = 1L;

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public String getPayername() {
        return payername;
    }

    public void setPayername(String payername) {
        this.payername = payername == null ? null : payername.trim();
    }

    public Float getPayamount() {
        return payamount;
    }

    public void setPayamount(Float payamount) {
        this.payamount = payamount;
    }

    public Float getExpends() {
        return expends;
    }

    public void setExpends(Float expends) {
        this.expends = expends;
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public Float getReplaceamount() {
        return replaceamount;
    }

    public void setReplaceamount(Float replaceamount) {
        this.replaceamount = replaceamount;
    }

    public Float getFeeamount() {
        return feeamount;
    }

    public void setFeeamount(Float feeamount) {
        this.feeamount = feeamount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
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

    public Float getDifferamount() {
        return differamount;
    }

    public void setDifferamount(Float differamount) {
        this.differamount = differamount;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getFeenum() {
        return feenum;
    }

    public void setFeenum(String feenum) {
        this.feenum = feenum == null ? null : feenum.trim();
    }

    public String getFeeid() {
        return feeid;
    }

    public void setFeeid(String feeid) {
        this.feeid = feeid == null ? null : feeid.trim();
    }

    public String getBiztype() {
        return biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype == null ? null : biztype.trim();
    }

    public String getBiztypeid() {
        return biztypeid;
    }

    public void setBiztypeid(String biztypeid) {
        this.biztypeid = biztypeid == null ? null : biztypeid.trim();
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

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public Date getPrintdate() {
        return printdate;
    }

    public void setPrintdate(Date printdate) {
        this.printdate = printdate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
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
}