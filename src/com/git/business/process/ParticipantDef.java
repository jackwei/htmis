/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2012-09-10 08:51:33 by code generator
 */
package com.git.business.process;



import com.git.db.beans.TblParticipantDef;

import dwz.framework.sys.business.AbstractBusinessObject;
/**
 * 节点参与者信息
 * @author shona
 *
 */
public class ParticipantDef extends AbstractBusinessObject{
	private static final long serialVersionUID = 1L;
	private TblParticipantDef tblParticipantDef;
	
	/* generateConstructor */
	public ParticipantDef() {
		this.tblParticipantDef = new TblParticipantDef();
	}
	public ParticipantDef(TblParticipantDef tblParticipantDef) {
		this.tblParticipantDef = tblParticipantDef;
	}
	
	public TblParticipantDef gettblParticipantDef(){
		return this.tblParticipantDef;
	}
	
	public Long getId() {
		return this.gettblParticipantDef().getParticDefId();
	}

	public void setId(Long id) {
	    this.gettblParticipantDef().setParticDefId(id);
	}

   public String getType(){
	  return this.gettblParticipantDef().getParticType();
   }
   
   public void setType(String particType){
     this.gettblParticipantDef().setParticType(particType);
   }
   
  public String getParticValue(){
	  return this.gettblParticipantDef().getParticValue();
  }
  	
  public  void setParticValue(String particValue){
	  this.gettblParticipantDef().setParticValue(particValue);
	  
  }
  
  
  public String getValue2(){
	  return this.gettblParticipantDef().getParticValue2();
  }
  	
  public  void setValue2(String particValue2){
	  this.gettblParticipantDef().setParticValue2(particValue2);
  }
  
  public Long getProcessId(){
	 return this.gettblParticipantDef().getProcessDefId();
  }
  
  public void setProcessId(Long processDefId){
	  this.gettblParticipantDef().setProcessDefId(processDefId);
  }
  
  
  public Long getActivityId(){
	 return this.gettblParticipantDef().getActivityDefId();
  }
  
  public void setActivityiId(Long activityDefId){
	  this.gettblParticipantDef().setActivityDefId(activityDefId);
  }
  
  public Long getParticValueId(){
	  return this.gettblParticipantDef().getParticValueId();
  }
  
  public void setParticValueId(Long particValueId){
	  this.gettblParticipantDef().setParticValueId(particValueId);
  }
}

