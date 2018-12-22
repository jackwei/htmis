package com.git.business.process;

import java.math.BigDecimal;
import java.util.Date;

import com.git.db.beans.CaseBillDetailImpl;
import com.git.enums.PClientStatus;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.framework.sys.lang.enums.ExtEnumUtils;

public class CaseBillDetail extends AbstractBusinessObject {
	
	private CaseBillDetailImpl caseBillDetailImpl;    

    private static final long serialVersionUID = 1L;
    
    public CaseBillDetail(){
		this.caseBillDetailImpl=new CaseBillDetailImpl();
	}
	
	public CaseBillDetail(CaseBillDetailImpl caseBillDetailImpl){
		this.caseBillDetailImpl=caseBillDetailImpl;
	}
	
	public CaseBillDetailImpl getCaseBillDetailImpl(){
		return this.caseBillDetailImpl;
	}
	
    public Long getId() {
        return caseBillDetailImpl.getDetailId();
    }

    public void setId(Long detailId) {
        this.caseBillDetailImpl.setDetailId(detailId);
    }

    public Long getBillId() {
        return caseBillDetailImpl.getBillId();
    }

    public void setBillId(Long billId) {
        this.caseBillDetailImpl.setBillId(billId);
    }

    public Long getConsignorid() {
        return caseBillDetailImpl.getConsignorid();
    }

    public void setConsignorid(Long consignorid) {
        this.caseBillDetailImpl.setConsignorid(consignorid);
    }

    public String getConsignorname() {
        return caseBillDetailImpl.getConsignorname();
    }

    public void setConsignorname(String consignorname) {
        this.caseBillDetailImpl.setConsignorname(consignorname);
    }

    public String getFeenumber() {
        return caseBillDetailImpl.getFeenumber();
    }

    public void setFeenumber(String feenumber) {
        this.caseBillDetailImpl.setFeenumber(feenumber);
    }

    public String getFeetype() {
        return caseBillDetailImpl.getFeetype();
    }

    public void setFeetype(String feetype) {
        this.caseBillDetailImpl.setFeetype(feetype);
    }

    public String getBussno() {
        return caseBillDetailImpl.getBussno();
    }

    public void setBussno(String bussno) {
        this.caseBillDetailImpl.setBussno(bussno);
    }

    public Date getHappendate() {
        return caseBillDetailImpl.getHappendate();
    }

    public void setHappendate(Date happendate) {
        this.caseBillDetailImpl.setHappendate(happendate);
    }

    public String getCurrency() {
        return caseBillDetailImpl.getCurrency();
    }

    public void setCurrency(String currency) {
        this.caseBillDetailImpl.setCurrency(currency);
    }

    public String getRemark() {
        return caseBillDetailImpl.getRemark();
    }

    public void setRemark(String remark) {
        this.caseBillDetailImpl.setRemark(remark);
    }

    public Date getAccdate() {
        return caseBillDetailImpl.getAccdate();
    }

    public void setAccdate(Date accdate) {
        this.caseBillDetailImpl.setAccdate(accdate);
    }

    public Date getArrdate() {
        return caseBillDetailImpl.getArrdate();
    }

    public void setArrdate(Date arrdate) {
        this.caseBillDetailImpl.setArrdate(arrdate);        
    }

    public BigDecimal getChangerate() {
        return caseBillDetailImpl.getChangerate();
    }

    public void setChangerate(BigDecimal changerate) {
        this.caseBillDetailImpl.setChangerate(changerate);
    }

    public Float getServicefee() {
        return caseBillDetailImpl.getServicefee();
    }

    public void setServicefee(Float servicefee) {
        this.caseBillDetailImpl.setServicefee(servicefee);
    }

    public Float getExpendses() {
        return caseBillDetailImpl.getExpendses();
    }

    public void setExpendses(Float expendses) {
        this.caseBillDetailImpl.setExpendses(expendses);
    }

    public Float getReplacefee() {
        return caseBillDetailImpl.getReplacefee();
    }

    public void setReplacefee(Float replacefee) {
        this.caseBillDetailImpl.setReplacefee(replacefee);
    }

    public Float getAccamount() {
        return caseBillDetailImpl.getAccamount();
    }

    public void setAccamount(Float accamount) {
        this.caseBillDetailImpl.setAccamount(accamount);
    }

    public Float getFeeamount() {
        return caseBillDetailImpl.getFeeamount();
    }

    public void setFeeamount(Float feeamount) {
        this.caseBillDetailImpl.setFeeamount(feeamount);
    }

    
    public PClientStatus getStatus() {
        return ExtEnumUtils.getRequiredByCode(this.caseBillDetailImpl.getStatus(), PClientStatus.values());
    }
    

    public void setStatus(String status) {
        this.caseBillDetailImpl.setStatus(status);
    }

    public String getPayid() {
        return caseBillDetailImpl.getPayid();
    }

    public void setPayid(String payid) {
        this.caseBillDetailImpl.setPayid(payid);
    }

    public Date getPaydate() {
        return caseBillDetailImpl.getPaydate();
    }

    public void setPaydate(Date paydate) {
        this.caseBillDetailImpl.setPaydate(paydate);
    }

    public String getCasenumber() {
        return caseBillDetailImpl.getCasenumber();
    }

    public void setCasenumber(String casenumber) {
        this.caseBillDetailImpl.setCasenumber(casenumber);
    }

    public Date getReportdate() {
        return caseBillDetailImpl.getReportdate();
    }

    public void setReportdate(Date reportdate) {
        this.caseBillDetailImpl.setReportdate(reportdate);
    }

    public Date getApplydate() {
        return caseBillDetailImpl.getApplydate();
    }

    public void setApplydate(Date applydate) {
        this.caseBillDetailImpl.setApplydate(applydate);
    }

    public String getExtend1() {
        return caseBillDetailImpl.getExtend1();
    }

    public void setExtend1(String extend1) {
        this.caseBillDetailImpl.setExtend1(extend1);
    }

    public String getExtend2() {
        return caseBillDetailImpl.getExtend2();
    }

    public void setExtend2(String extend2) {
        this.caseBillDetailImpl.setExtend2(extend2);
    }

    public String getExtend3() {
        return caseBillDetailImpl.getExtend3();
    }

    public void setExtend3(String extend3) {
        this.caseBillDetailImpl.setExtend3(extend3);
    }
}