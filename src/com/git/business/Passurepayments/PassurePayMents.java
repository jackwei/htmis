package com.git.business.Passurepayments;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.git.db.beans.TblPassurePayMents;

import dwz.framework.sys.business.AbstractBusinessObject;

@SuppressWarnings("serial")
public class PassurePayMents extends AbstractBusinessObject{

	private TblPassurePayMents tpp;
	
	@Override
	public Serializable getId() {
		return null;
	}
	
	public PassurePayMents(){
		this.tpp = new TblPassurePayMents();
	}
	
	public PassurePayMents(TblPassurePayMents tp){
		this.tpp = tp;
	}
	
	public TblPassurePayMents getPassurePayMents(){
		return this.tpp;
	}
	
	public Long getPassurepayid(){
		return this.tpp.getPassurepayid();
	}
	
	public void setPassurepayid(Long passurepayid){
		this.tpp.setPassurepayid(passurepayid);
	}
	
	public Date getCreatedate(){
		return this.tpp.getCreatedate();
	}
	
	public void setCreatedate(Date createdate){
		this.tpp.setCreatedate(createdate);
	}
	
	public Long getUserid(){
		return this.tpp.getUserid();
	}
	
	public void setUserid(Long userid){
		this.tpp.setUserid(userid);
	}
	
	public String getUsername(){
		return this.tpp.getUsername();
	}
	
	public void setUsername(String username){
		this.tpp.setUsername(username);
	}
	
	public String getReportflag(){
		return this.tpp.getReportflag();
	}
	
	public void setReportflag(String reportflag){
		this.tpp.setReportflag(reportflag);
	}
	
	public Date getPaydate(){
		return this.tpp.getPaydate();
	}
	
	public void setPaydate(Date paydate){
		this.tpp.setPaydate(paydate);
	}
	
	public String getOrgcode(){
		return this.tpp.getOrgcode();
	}
	
	public void setOrgcode(String orgcode){
		this.tpp.setOrgcode(orgcode);
	}
	
	public String getOrgname(){
		return this.tpp.getOrgname();
	}
	
	public void setOrgname(String orgname){
		this.tpp.setOrgname(orgname);
	}
	
	public Long getTotal(){
		return this.tpp.getTotal();
	}
	
	public void setTotal(Long total){
		this.tpp.setTotal(total);
	}
	
	public BigDecimal getFeemount(){
    	return this.tpp.getFeemount();
    }
    
    public void setFeemount(BigDecimal feemount){
    	this.tpp.setFeemount(feemount);
    }
	
	public String getReceivedetail(){
		return this.tpp.getReceivedetail();
	}
	
	public void setReceivedetail(String receivedetail){
		this.tpp.setReceivedetail(receivedetail);
	}
	
	public String getPaydetail(){
		return this.tpp.getPaydetail();
	}
	
	public void setPaydetail(String paydetail){
		this.tpp.setPaydetail(paydetail);
	}
	
	public Long getCreateOperatorId(){
		return this.tpp.getCreateoperatorid();
	}
	
	public void setCreateOperatorId(Long createoperatorid){
		this.tpp.setCreateoperatorid(createoperatorid);
	}
	
	public Long getModifyOperatorId(){
		return this.tpp.getModifyoperatorid();
	}
	
	public void setModifyOperatorId(Long modifyoperatorid){
		this.tpp.setModifyoperatorid(modifyoperatorid);
	}
	
	public Date getCreateTime(){
		return this.tpp.getCreatetime();
	}
	
	public void setCreateTime(Date createtime){
		this.tpp.setCreatetime(createtime);
	}
	
	public Date getModifyTime(){
		return this.tpp.getModifytime();
	}
	
	public void setModifyTime(Date modifytime){
		this.tpp.setModifytime(modifytime);
	}
	
	public Long getCpid(){
		return this.tpp.getCpid();
	}
	
	public void setCpid(Long cpid){
		this.tpp.setCpid(cpid);
	}
	
	public Long getYear(){
		return this.tpp.getYear();
	}
	
	public void setYear(Long year){
		this.tpp.setYear(year);
	}
	
	public Long getMonth(){
		return this.tpp.getMonth();
	}
	
	public void setMonth(Long month){
		this.tpp.setMonth(month);
	}

}
