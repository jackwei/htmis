package com.git.business.assure.rewarranter;

import java.io.Serializable;
import java.util.Date;

import com.git.db.beans.TblRewarranter;

import dwz.framework.sys.business.AbstractBusinessObject;

public class Rewarranter extends AbstractBusinessObject{

	/**
	 * 反担保人管理
	 */
	private static final long serialVersionUID = 1L;
	
	private TblRewarranter tr;

	@Override
	public Serializable getId() {
		return null;
	}
	
	public Rewarranter(){
		this.tr = new TblRewarranter();
	}
	
	public Rewarranter(TblRewarranter t){
		this.tr = t;
	}
	
	public TblRewarranter getRewarranter(){
		return this.tr;
	}
	
	public Long getOid(){
		return this.tr.getOid();
	}
	
	public void setOid(Long oid){
		this.tr.setOid(oid);
	}
	
	public String getName(){
		return this.tr.getName();
	}
	
	public void setName(String name){
		this.tr.setName(name);
	}
	
	public String getNames(){
		return this.tr.getNames();
	}
	
	public void setNames(String names){
		this.tr.setNames(names);
	}
	
	public Long getPropertyid(){
		return this.tr.getPropertyid();
	}
	
	public void setPropertyname(Long propertyid){
		this.tr.setPropertyid(propertyid);
	}
	
	public String getPropertyname(){
		return this.tr.getPropertyname();
	}
	
	public void setPropertyname(String propertyname){
		this.tr.setPropertyname(propertyname);
	}
	
	public String getAddress(){
		return this.tr.getAddress();
	}
	
	public void setAddress(String address){
		this.tr.setAddress(address);
	}
	
	public String getCountry(){
		return this.tr.getCountry();
	}
	
	public void setCountry(String country){
		this.tr.setCountry(country);
	}
	
	public String getArea(){
		return this.tr.getArea();
	}
	
	public void setArea(String area){
		this.tr.setArea(area);
	}
	
	public Long getCreateOperatorId(){
		return this.tr.getCreateoperatorid();
	}
	
	public void setCreateOperatorId(Long createoperatorid){
		this.tr.setCreateoperatorid(createoperatorid);
	}
	
	public Long getModifyOperatorId(){
		return this.tr.getModifyoperatorid();
	}
	
	public void setModifyOperatorId(Long modifyoperatorid){
		this.tr.setModifyoperatorid(modifyoperatorid);
	}
	
	public Date getCreateTime(){
		return this.tr.getCreatetime();
	}
	
	public void setCreateTime(Date createtime){
		this.tr.setCreatetime(createtime);
	}
	
	public Date getModifyTime(){
		return this.tr.getModifytime();
	}
	
	public void setModifyTime(Date modifytime){
		this.tr.setModifytime(modifytime);
	}

}
