/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2012-09-10 08:51:33 by code generator
 */
package com.git.business.process;



import com.git.db.beans.TblProcessDef;

import dwz.framework.sys.business.AbstractBusinessObject;

/**
 *流程定义信息
 * @author shona
 *
 */
public class ProcessDef extends AbstractBusinessObject{
	private static final long serialVersionUID = 1L;
	private TblProcessDef tblProcessDef;
	
	/* generateConstructor */
	public ProcessDef() {
		this.tblProcessDef = new TblProcessDef();
	}
	public ProcessDef(TblProcessDef tblProcessDef) {
		this.tblProcessDef = tblProcessDef;
	}
	
	public TblProcessDef gettblProcessDef(){
		return this.tblProcessDef;
	}
	
	public Long getId() {
		return this.gettblProcessDef().getProcessDefId();
	}

	public void setId(Long id) {
	    this.gettblProcessDef().setProcessDefId(id);
	}

   public String getNo(){
	  return this.gettblProcessDef().getProcessNo();
   }
   
   public void setNo(String processNo){
       this.gettblProcessDef().setProcessNo(processNo);	   
   }
   
  public String getName(){
	  return this.gettblProcessDef().getProcessName();
  }
  	
  public  void setName(String processName){
	  this.gettblProcessDef().setProcessName(processName);
  }
  
  public String getDesc(){
	  return this.gettblProcessDef().getProcessDesc();
  }
  
  public void setDesc(String desc){
	  this.gettblProcessDef().setProcessDesc(desc);
  }
  
  public String getCurrentState(){
	  return this.gettblProcessDef().getCurrentState();
  }
  
  public void setCurrentState(String currentState){
	  this.gettblProcessDef().setCurrentState(currentState);
  }
  
}

