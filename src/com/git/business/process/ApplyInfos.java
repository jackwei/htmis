package com.git.business.process;

import java.math.BigDecimal;
import java.util.Date;

import com.git.db.beans.TblApplyInfos;

import dwz.framework.sys.business.AbstractBusinessObject;

/**
 * 呈批件
 * @author shona
 *
 */
public class ApplyInfos extends AbstractBusinessObject {
  
	private static final long serialVersionUID = 1L;
	private TblApplyInfos tblApplyInfos;
	
	public ApplyInfos(){
		this.tblApplyInfos=new TblApplyInfos();
	}
	
	public ApplyInfos(TblApplyInfos tblApplyInfos){
		this.tblApplyInfos=tblApplyInfos;
	}
	
	public TblApplyInfos getTblApplyInfos(){
		return this.tblApplyInfos;
	}
	
	public Long getId() {
		return this.tblApplyInfos.getOid();
	}
	
	public void setId(Long id){
		this.getTblApplyInfos().setOid(id);
	}
	
	public String getApplytype(){
		return this.getTblApplyInfos().getApplytype();
	}

	public void setApplytype(String applytype){
		this.getTblApplyInfos().setApplytype(applytype);
	}
	
	public String getStatus(){
		return this.getTblApplyInfos().getStatus();
	}
	
	public void setStatus(String status){
		this.getTblApplyInfos().setStatus(status);
	}
	
	public String getName(){
		return this.getTblApplyInfos().getName();
	}
	
	public void setName(String name){
		this.getTblApplyInfos().setName(name);
	}
	
	public Long getProcessdefid() {
        return this.getTblApplyInfos().getProcessdefid();
    }

    public void setProcessdefid(Long processdefid) {
        this.getTblApplyInfos().setProcessdefid(processdefid);
    }

    public String getProcessname() {
        return this.getTblApplyInfos().getProcessname();
    }

    public void setProcessname(String processname) {
       this.getTblApplyInfos().setProcessname(processname);
    }

    public Long getParentid() {
        return this.getTblApplyInfos().getParentid();
    }

    public void setParentid(Long parentid) {
       this.getTblApplyInfos().setParentid(parentid);
    }

    public String getParentname() {
        return this.getTblApplyInfos().getParentname();
    }

    public void setParentname(String parentname) {
       this.getTblApplyInfos().setParentname(parentname);
    }

    public String getApplydes() {
        return this.getTblApplyInfos().getApplydes();
    }

    public void setApplydes(String applydes) {
       this.getTblApplyInfos().setApplydes(applydes);
    }

    public String getDeleted() {
        return this.getTblApplyInfos().getDeleted();
    }

    public void setDeleted(String deleted) {
       this.getTblApplyInfos().setDeleted(deleted);
    }

    public String getUserid() {
        return this.getTblApplyInfos().getUserid();
    }

    public void setUserid(String userid) {
        this.getTblApplyInfos().setUserid(userid);
    }

    public String getUsername() {
        return this.getTblApplyInfos().getUsername();
    }

    public void setUsername(String username) {
       this.getTblApplyInfos().setUsername(username);
    }

    public String getOrgid() {
        return this.getTblApplyInfos().getOrgid();
    }

    public void setOrgid(String orgid) {
       this.getTblApplyInfos().setOrgid(orgid);
    }

    public String getOrgname() {
        return this.getTblApplyInfos().getOrgname();
    }

    public void setOrgname(String orgname) {
        this.getTblApplyInfos().setOrgname(orgname);
    }

    public Integer getStep() {
        return this.getTblApplyInfos().getStep();
    }

    public void setStep(Integer step) {
        this.getTblApplyInfos().setStep(step);
    }

    public String getSqnumber() {
        return this.getTblApplyInfos().getSqnumber();
    }

    public void setSqnumber(String sqnumber) {
       this.getTblApplyInfos().setSqnumber(sqnumber);
    }

    public String getCurrency() {
        return this.getTblApplyInfos().getCurrency();
    }

    public void setCurrency(String currency) {
           this.getTblApplyInfos().setCurrency(currency);
    }

    public BigDecimal getAmounta() {
        return this.getTblApplyInfos().getAmounta();
    }

    public void setAmounta(BigDecimal amounta) {
        this.getTblApplyInfos().setAmounta(amounta);
    }

    public BigDecimal getAmountb() {
        return this.getTblApplyInfos().getAmountb();
    }

    public void setAmountb(BigDecimal amountb) {
        this.getTblApplyInfos().setAmountb(amountb);
    }

    public BigDecimal getAmountc() {
        return this.getTblApplyInfos().getAmountc();
    }

    public void setAmountc(BigDecimal amountc) {
        this.getTblApplyInfos().setAmountc(amountc);
    }

    public String getRemarka() {
        return this.getTblApplyInfos().getRemarka();
    }

    public void setRemarka(String remarka) {
        this.getTblApplyInfos().setRemarka(remarka);
    }

    public String getRemarkb() {
    	 return this.getTblApplyInfos().getRemarkb();
    }

    public void setRemarkb(String remarkb) {
    	this.getTblApplyInfos().setRemarkb(remarkb);
    }

    public String getRemarkc() {
    	return this.getTblApplyInfos().getRemarkc();
    }

    public void setRemarkc(String remarkc) {
    	this.getTblApplyInfos().setRemarkc(remarkc);
    }

    public Date getApplydate() {
        return this.getTblApplyInfos().getApplydate();
    }

    public void setApplydate(Date applydate) {
       this.getTblApplyInfos().setApplydate(applydate);
    }

    public Date getCreatdate() {
        return this.getTblApplyInfos().getCreatdate();
    }

    public void setCreatdate(Date creatdate) {
        this.getTblApplyInfos().setCreatdate(creatdate);
    }
}
