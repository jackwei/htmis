package com.git.business.params;

import java.io.Serializable;
import java.util.Date;

import com.git.db.beans.TblParams;

import dwz.framework.sys.business.AbstractBusinessObject;

public class Params extends AbstractBusinessObject{

	/**
	 * 事发口岸配置
	 */
	private TblParams tp;
	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Params(){
		this.tp = new TblParams();
	}
	
	public Params(TblParams t){
		this.tp = t;
	}
	
	public TblParams getParams(){
		return this.tp;
	}
	
	public Long getOid(){
		return this.tp.getOid();
	}
	
	public void setOid(Long oid){
		this.tp.setOid(oid);
	}
	
	public String getBiztype(){
		return this.tp.getBiztype();
	}
	
	public void setBiztype(String bt){
		this.tp.setBiztype(bt);
	}
	
	public String getBiztypename(){
		return this.tp.getBiztypename();
	}
	
	public void setBiztypename(String sb){
		this.tp.setBiztypename(sb);
	}
	
	public String getParamtype(){
		return this.tp.getParamtype();
	}
	
	public void setParamtype(String sp){
		this.tp.setParamtype(sp);
	}
	
	public String getParamtexta(){
		return this.tp.getParamtexta();
	}
	
	public void setParamtexta(String st){
		this.tp.setParamtexta(st);
	}
	
	public String getParamtextb(){
		return this.tp.getParamtextb();
	}

	public void setParamtextb(String s){
		this.tp.setParamtextb(s);
	}
	
	public Long getCreateOperatorId(){
		return this.tp.getCreateoperatorid();
	}
	
	public void setCreateOperatorId(Long createoperatorid){
		this.tp.setCreateoperatorid(createoperatorid);
	}
	
	public Long getModifyOperatorId(){
		return this.tp.getModifyoperatorid();
	}
	
	public void setModifyOperatorId(Long modifyoperatorid){
		this.tp.setModifyoperatorid(modifyoperatorid);
	}
	
	public Date getCreateTime(){
		return this.tp.getCreatetime();
	}
	
	public void setCreateTime(Date createtime){
		this.tp.setCreatetime(createtime);
	}
	
	public Date getModifyTime(){
		return this.tp.getModifytime();
	}
	
	public void setModifyTime(Date modifytime){
		this.tp.setModifytime(modifytime);
	}
}
