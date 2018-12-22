package com.git.business.assure.third;

import java.io.Serializable;
import java.util.Date;

import com.git.db.beans.TblThirdParty;

import dwz.framework.sys.business.AbstractBusinessObject;

public class Third extends AbstractBusinessObject{

	/**
	 * 第三方管理
	 */
	
	private TblThirdParty third;
	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Third(){
		this.third = new TblThirdParty();
	}
	
	public Third(TblThirdParty third){
		this.third = third;
	}
	
	public TblThirdParty getThird(){
		return this.third;
	}
	
	public Long getOid(){
		return this.third.getOid();
	}
	
	public void setOid(Long oid){
		this.third.setOid(oid);
	}
	
	public String getNameen(){
		return this.third.getNameen();
	}
	
	public void setNameen(String nameen){
		this.third.setNameen(nameen);
	}
	
	public String getNamecn(){
		return this.third.getNamecn();
	}
	
	public void setNamecn(String namecn){
		this.third.setNamecn(namecn);
	}
	
	public String getNameens(){
		return this.third.getNameens();
	}
	
	public void setNameens(String nameens){
		this.third.setNameens(nameens);
	}
	
	public String getNamecns(){
		return this.third.getNamecns();
	}
	
	public void setNamecns(String namecns){
		this.third.setNamecns(namecns);
	}
	
	public String getType(){
		return this.third.getType();
	}
	
	public void setType(String type){
		this.third.setType(type);
	}
	
	public String getProperty(){
		return this.third.getProperty();
	}
	
	public void setProperty(String property){
		this.third.setProperty(property);
	}
	
	public String getTelephone(){
		return this.third.getTelephone();
	}
	
	public void setTelephone(String telephone){
		this.third.setTelephone(telephone);
	}
	
	public String getAddress(){
		return this.third.getAddress();
	}
	
	public void setAddress(String address){
		this.third.setAddress(address);
	}
	
	public String getAccountname(){
		return this.third.getAccountname();
	}
	
	public void setAccountname(String accountname){
		this.third.setAccountname(accountname);
	}
	
	public String getAccountnum(){
		return this.third.getAccountnum();
	}
	
	public void setAccountnum(String accountnum){
		this.third.setAccountnum(accountnum);
	}
	
	public String getSort(){
		return this.third.getSort();
	}
	
	public void setSort(String sort){
		this.third.setSort(sort);
	}
	
	public String getSortname(){
		return this.third.getSortname();
	}
	
	public void setSortname(String sortname){
		this.third.setSortname(sortname);
	}
	
	public String getDeleted(){
		return this.third.getDeleted();
	}
	
	public void setDeleted(String deleted){
		this.third.setDeleted(deleted);
	}
	
	public String getCountry(){
		return this.third.getCountry();
	}
	
	public void setCountry(String country){
		this.third.setCountry(country);
	}
	
	public String getAccountcode(){
		return this.third.getAccountcode();
	}
	
	public void setAccountcode(String accountcode){
		this.third.setAccountcode(accountcode);
	}
	
	public String getCurrentcourse(){
		return this.third.getCurrentcourse();
	}
	
	public void setCurrentcourse(String currentcourse){
		this.third.setCurrentcourse(currentcourse);
	}
	
	public Long getCreateoperatorid(){
		return this.third.getCreateoperatorid();
	}
	
	public void setCreateoperatorid(Long createoperatorid){
		this.third.setCreateoperatorid(createoperatorid);
	}
	
	public Long getModifyoperatorid(){
		return this.third.getModifyoperatorid();
	}
	
	public void setModifyoperatorid(Long modifyoperatorid){
		this.third.setModifyoperatorid(modifyoperatorid);
	}
	
	public Date getCreatetime(){
		return this.third.getCreatetime();
	}
	
	public void setCreatetime(Date createtime){
		this.third.setCreatetime(createtime);
	}
	
	public Date getModifytime(){
		return this.third.getModifytime();
	}
	
	public void setModifytime(Date modifytime){
		this.third.setModifytime(modifytime);
	}
	

}
