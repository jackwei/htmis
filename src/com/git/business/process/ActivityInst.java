package com.git.business.process;


import java.util.Date;

import com.git.db.beans.TblActivityInst;

import dwz.framework.sys.business.AbstractBusinessObject;

/**
 * 流程节点实例
 * @author shona
 *
 */
public class ActivityInst extends AbstractBusinessObject {

	private static final long serialVersionUID = 1L;
	private TblActivityInst tblActivityInst;
	
	public ActivityInst(){
		this.tblActivityInst=new TblActivityInst();
	}
	
	public ActivityInst(TblActivityInst tblActivityInst){
		this.tblActivityInst=tblActivityInst;
	}
	
	public TblActivityInst getTblActivityInst(){
		return this.tblActivityInst;
	}
	public Long getId() {
		return this.getTblActivityInst().getActivityInstId();
	}
	
	public void setId(Long activityInstId){
		 this.getTblActivityInst().setActivityInstId(activityInstId);
	}
	 public Long getProcessInstId() {
	        return this.getTblActivityInst().getProcessInstId();
	    }

	    public void setProcessInstId(Long processInstId) {
	        this.getTblActivityInst().setProcessInstId(processInstId);
	    }

	    public Long getActivityDefId() {
	        return this.getTblActivityInst().getActivityDefId();
	    }

	    public void setActivityDefId(Long activityDefId) {
	        this.getTblActivityInst().setActivityDefId(activityDefId);
	    }

	    public String getCurrentState() {
	        return this.getTblActivityInst().getCurrentState();
	    }

	    public void setCurrentState(String currentState) {
	        this.getTblActivityInst().setCurrentState(currentState);
	    }

	    public Date getCreateTime() {
	        return this.getTblActivityInst().getCreateTime();
	    }

	    public void setCreateTime(Date createTime) {
	       this.getTblActivityInst().setCreateTime(createTime);
	    }

	    public Date getFinalTime() {
	        return this.getTblActivityInst().getFinalTime();
	    }

	    public void setFinalTime(Date finalTime) {
	       this.getTblActivityInst().setFinalTime(finalTime);
	    }

	    public String getAduitResult() {
	        return this.getTblActivityInst().getAduitResult();
	    }

	    public void setAduitResult(String aduitResult) {
	       this.getTblActivityInst().setAduitResult(aduitResult);
	    }

	    public String getAduit() {
	        return this.getTblActivityInst().getAduit();
	    }

	    public void setAduit(String aduit) {
	        this.getTblActivityInst().setAduit(aduit);
	    }

	    public Date getCheckdate() {
	        return this.getTblActivityInst().getCheckdate();
	    }

	    public void setCheckdate(Date checkdate) {
	        this.getTblActivityInst().setCheckdate(checkdate);
	    }

	    public String getCheckdes() {
	        return this.getTblActivityInst().getCheckdes();
	    }

	    public void setCheckdes(String checkdes) {
	        this.getTblActivityInst().setCheckdes(checkdes);
	    }

	    public String getRemark() {
	        return this.getTblActivityInst().getRemark();
	    }

	    public void setRemark(String remark) {
	        this.getTblActivityInst().setRemark(remark);
	    }

	    public String getRemark1() {
	        return this.getTblActivityInst().getRemark1();
	    }

	    public void setRemark1(String remark1) {
	    	 this.getTblActivityInst().setRemark1(remark1);
	    }

}
