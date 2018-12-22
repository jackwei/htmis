package com.git.business.PassureInfos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.git.db.beans.TblPassureInfos;

import dwz.framework.sys.business.AbstractBusinessObject;

public class PassureInfos extends AbstractBusinessObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TblPassureInfos tpi;	

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PassureInfos(){
		this.tpi=new TblPassureInfos();
	}
	
	public PassureInfos(TblPassureInfos t){
			this.tpi=t;
    }
	
	public TblPassureInfos getPassureInofs(){
		return this.tpi;
	}
	
	public Long getPassureid(){
		return this.tpi.getPassureid();
	}
	
	public void setPassureid(Long passureid){
		this.tpi.setPassureid(passureid);
	}
	
	public String getAssurenum(){
		return this.tpi.getAssurenum();
	}
	
	public void setAssurenum(String assurenum){
		this.tpi.setAssurenum(assurenum);
	}
	
	public Long getCaseid(){
		return this.tpi.getCaseid();
	}
	
	public void setCaseid(Long caseid){
		this.tpi.setCaseid(caseid);
	}
	
	public Long getFeeid(){
		return this.tpi.getFeeid();
	}
	
	public void setFeeid(Long feeid){
		this.tpi.setFeeid(feeid);
	}
	
	public Long getPaymentid(){
		return this.tpi.getPaymentid();
	}
	
	public void setPaymentid(Long paymentid){
		this.tpi.setPaymentid(paymentid);
	}
	
	public Long getRewarranterid(){
		return this.tpi.getRewarranterid();
	}
	
	public void setRewarranterid(Long rewarranterid){
		this.tpi.setRewarranterid(rewarranterid);
	}
	
	public String getRewarrantersn(){
		return this.tpi.getRewarrantersn();
	}
	
	public void setRewarrantersn(String rewarrantersn){
		this.tpi.setRewarrantersn(rewarrantersn);
	}
	
	public String getRewarranter(){
		return this.tpi.getRewarranter();
	}
	
	public void setRewarranter(String rewarranter){
		this.tpi.setRewarranter(rewarranter);
	}

    public Long getRewarranttypeid(){
    	return this.tpi.getRewarranttypeid();
    }
    
    public void setRewarranttypeid(Long rewarranttypeid){
    	this.tpi.setRewarranttypeid(rewarranttypeid);
    }
    
    public String getRewarranttype(){
    	return this.tpi.getRewarranttype();
    }
    
    public void setRewarranttype(String rewarranttype){
    	this.tpi.setRewarranttype(rewarranttype);
    }
    
    public String getCurrency(){
    	return this.tpi.getCurrency();
    }
    
    public void setCurrency(String currency){
    	this.tpi.setCurrency(currency);
    }
    
    public BigDecimal getRmbfee(){
    	return this.tpi.getRmbfee();
    }
    
    public void setRmbfee(BigDecimal rmbfee){
    	this.tpi.setRmbfee(rmbfee);
    }
    
    public BigDecimal getUsdfee(){
    	return this.tpi.getUsdfee();
    }
    
    public void setUsdfee(BigDecimal usdfee){
    	this.tpi.setUsdfee(usdfee);
    }
    
    public BigDecimal getAssurefee(){
    	return this.tpi.getAssurefee();
    }
    
    public void setAssurefee(BigDecimal assurefee){
    	this.tpi.setAssurefee(assurefee);
    }
    
    public String getRemark(){
    	return this.tpi.getRemark();
    }
    
    public void setRemark(String remark){
    	this.tpi.setRemark(remark);
    }
    
    public String getGuaranteeexpressnumber(){
    	return this.tpi.getGuaranteeexpressnumber();
    }
    
    public void setGuaranteeexpressnumber(String guaranteeexpressnumber){
    	this.tpi.setGuaranteeexpressnumber(guaranteeexpressnumber);
    }
    
    public String getCanceltheguarantee(){
    	return this.tpi.getCanceltheguarantee();
    }
    
    public void setCanceltheguarantee(String canceltheguarantee){
    	this.tpi.setCanceltheguarantee(canceltheguarantee);
    }
    
    public String getGuaranteesender(){
    	return this.tpi.getGuaranteesender();
    }
    
    public void setGuaranteesender(String guaranteesender){
    	this.tpi.setGuaranteesender(guaranteesender);
    }
    
    public Date getGuaranteereturndate(){
    	return this.tpi.getGuaranteereturndate();
    }
    
    public void setGuaranteereturndate(Date guaranteereturndate){
    	this.tpi.setGuaranteereturndate(guaranteereturndate);
    }
    
    public String getTrackingnumber(){
    	return this.tpi.getTrackingnumber();
    }
    
    public void setTrackingnumber(String trackingnumber){
    	this.tpi.setTrackingnumber(trackingnumber);
    }
    
    public Date getSecuritydate(){
    	return this.tpi.getSecuritydate();
    }
    
    public void setSecuritydate(Date securitydate){
    	this.tpi.setSecuritydate(securitydate);
    }
    
    public String getReceiver(){
    	return this.tpi.getReceiver();
    }
    
    public void setReceiver(String receiver){
    	this.tpi.setReceiver(receiver);
    }
    
    public Date getZbsendtime(){
    	return this.tpi.getZbsendtime();
    }
    
    public void setZbsendtime(Date zbsendtime){
    	this.tpi.setZbsendtime(zbsendtime);
    }
    
    public String getRecognizorname(){
    	return this.tpi.getRecognizorname();
    }
    
    public void setRecognizorname(String recognizorname){
    	this.tpi.setRecognizorname(recognizorname);
    }
    
    public Date getZbgatherdate(){
    	return this.tpi.getZbgatherdate();
    }
    
    public void setZbgatherdate(Date zbgatherdate){
    	this.tpi.setZbgatherdate(zbgatherdate);
    }
    
    public String getReportflag(){
    	return this.tpi.getReportflag();
    }
    
    public void setReportflag(String reportflag){
    	this.tpi.setReportflag(reportflag);
    }
    
    public BigDecimal getServicefee(){
    	return this.tpi.getServicefee();
    }
    
    public void setServicefee(BigDecimal servicefee){
    	this.tpi.setServicefee(servicefee);
    }
    
    public String getReceiveflag(){
    	return this.tpi.getReceiveflag();
    }
    
    public void setReceiveflag(String receiveflag){
    	this.tpi.setReceiveflag(receiveflag);
    }
    
    public String getAssureder(){
    	return this.tpi.getAssureder();
    }
    
    public void setAssureder(String assureder){
    	this.tpi.setAssureder(assureder);
    }
    
    public Date getBackdate(){
    	return this.tpi.getBackdate();
    }
    
    public void setBackdate(Date backdate){
    	this.tpi.setBackdate(backdate);
    }
    
    public Date getIssuedate(){
    	return this.tpi.getIssuedate();
    }
    
    public void setIssuedate(Date issuedate){
    	this.tpi.setIssuedate(issuedate);
    }
    
    public String getReplacenum(){
    	return this.tpi.getReplacenum();
    }
    
    public void setReplacenum(String replacenum){
    	this.tpi.setReplacenum(replacenum);
    }
    
    public BigDecimal getAccrate(){
    	return this.tpi.getAccrate();
    }
    
    public void setAccrate(BigDecimal accrate){
    	this.tpi.setAccrate(accrate);
    }
    
    public String getAcccurrency(){
    	return this.tpi.getAcccurrency();
    }
    
    public void setAcccurrency(String acccurrency){
    	this.tpi.setAcccurrency(acccurrency);
    }
    
    public BigDecimal getAccamount(){
    	return this.tpi.getAccamount();
    }
    
    public void setAccamount(BigDecimal accamount){
    	this.tpi.setAccamount(accamount);
    }

    public Date getAccdate(){
    	return this.tpi.getAccdate();
    }
    
    public void setAccdate(Date accdate){
    	this.tpi.setAccdate(accdate);
    }
    
    public Date getArrdate(){
    	return this.tpi.getArrdate();
    }
    
    public void setArrdate(Date arrdate){
    	this.tpi.setArrdate(arrdate);
    }
    
    public Date getPaydate(){
    	return this.tpi.getPaydate();
    }
    
    public void setPaydate(Date paydate){
    	this.tpi.setPaydate(paydate);
    }
    
    public Long getReplaceid(){
    	return this.tpi.getReplaceid();
    }
    
    public void setReplaceid(Long replaceid){
    	this.tpi.setReplaceid(replaceid);
    }
    
    public Long getReplacedid(){
    	return this.tpi.getReplacedid();
    }
    
    public void setReplacedid(Long replacedid){
    	this.tpi.setReplacedid(replacedid);
    }
    
    public String getOrdernum(){
    	return this.getOrdernum();
    }
    
    public void setOrdernum(String ordernum){
    	this.tpi.setOrdernum(ordernum);
    }
    
    public String getReplacednum(){
    	return this.tpi.getReplacednum();
    }
    
    public void setReplacednum(String replacednum){
    	this.tpi.setReplacednum(replacednum);
    }
    
    public Date getAlertdate(){
    	return this.getAlertdate();
    }
    
    public void setAlertdate(Date alertdate){
    	this.tpi.setAlertdate(alertdate);
    }
    
    public Long getCreateoperatorid(){
    	return this.tpi.getCreateoperatorid();
    }
    
    public void setCreateoperatorid(Long createoperatorid){
    	this.tpi.setCreateoperatorid(createoperatorid);
    }
    
    public Long getModifyoperatorid(){
    	return this.tpi.getModifyoperatorid();
    }
    
    public void setModifyoperatorid(Long modifyoperatorid){
    	this.tpi.setModifyoperatorid(modifyoperatorid);
    }
    
    public Date getCreatetime(){
    	return this.tpi.getCreatetime();
    }
    
    public void setCreatetime(Date createtime){
    	this.tpi.setCreatetime(createtime);
    }
    
    public Date getModifytime(){
    	return this.tpi.getModifytime();
    }
    
    public void setModifytime(Date modifytime){
    	this.tpi.setModifytime(modifytime);
    }
    
    public  Long getBillId(){
    	return this.tpi.getBillid();
    }
    
    public void setBillId(Long billid){
    	this.tpi.setBillid(billid);
    }
    
    public String getFeestatuse(){
    	return this.tpi.getFeestatuse();
    }
    
    public void setFeestatuse(String feestatuse){
    	this.tpi.setFeestatuse(feestatuse);	
    }

}
