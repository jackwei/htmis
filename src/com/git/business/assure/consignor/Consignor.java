package com.git.business.assure.consignor;

import java.io.Serializable;
import java.util.Date;

import com.git.db.beans.TblConsignor;

import dwz.framework.sys.business.AbstractBusinessObject;

public class Consignor extends AbstractBusinessObject{

	/**
	 * 委托人管理
	 */
	private static final long serialVersionUID = 1L;
	
	private TblConsignor tcg;

	@Override
	public Serializable getId() {
		return null;
	}
	
	public Consignor(){
		this.tcg = new TblConsignor();
	}
	
	public Consignor(TblConsignor tc){
		this.tcg = tc;
	}
	
	public TblConsignor getConsignor(){
		return this.tcg;
	}
	
	public Long getOid(){
		return this.tcg.getOid();
	}
	
	public void setOid(Long oid){
		this.tcg.setOid(oid);
	}
	
	public String getName(){
		return this.tcg.getName();
	}
	
	public void setName(String name){
		this.tcg.setName(name);
	}
	
	public String getNames(){
		return this.tcg.getNames();
	}
	
	public void setNames(String names){
		this.tcg.setNames(names);
	}
	
	public String getAddress(){
		return this.tcg.getAddress();
	}
	
	public void setAddress(String address){
		this.tcg.setAddress(address);
	}
	
	public String getSort(){
		return this.tcg.getSort();
	}
	
	public void setSort(String sort){
		this.tcg.setSort(sort);
	}
	
	public String getCountry(){
		return this.tcg.getCountry();
	}
	
	public void setCountry(String country){
		this.tcg.setCountry(country);
	}
	
	public String getArea(){
		return this.tcg.getArea();
	}
	
	public void setArea(String area){
		this.tcg.setArea(area);
	}
	
	public Long getCreateOperatorId(){
		return this.tcg.getCreateoperatorid();
	}
	
	public void setCreateOperatorId(Long coi){
		this.tcg.setCreateoperatorid(coi);
	}
	
	public Long getModifyOperatorId(){
		return this.tcg.getModifyoperatorid();
	}
	
	public void setModifyOperatorId(Long moi){
		this.tcg.setModifyoperatorid(moi);
	}
	
	public Date getCreateTime(){
		return this.tcg.getCreatetime();
	}
	
	public void setCreateTime(Date ct){
		this.tcg.setCreatetime(ct);
	}
	
	public Date getModifyTime(){
		return this.tcg.getModifytime();
	}
	
	public void setModifyTime(Date mt){
		this.tcg.setModifytime(mt);
	}
	
	public String getAccountcode(){
		return this.tcg.getAccountcode();
	}
	
	public void setAccountcode(String accountcode){
		this.tcg.setAccountcode(accountcode);
	}
	
	public String getCurrentcourse(){
		return this.tcg.getCurrentcourse();
	}
	
	public void setCurrentcourse(String currentcourse){
		this.tcg.setCurrentcourse(currentcourse);
	}

}
