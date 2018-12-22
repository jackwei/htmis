package com.git.business.process;


import com.git.db.beans.TblParticInst;

import dwz.framework.sys.business.AbstractBusinessObject;

/**
 * 流程节点参与者
 * @author shona
 *
 */
public class ParticInst extends AbstractBusinessObject {

	private static final long serialVersionUID = 1L;
	private TblParticInst tblParticInst; 
	
	public ParticInst(){
		this.tblParticInst=new TblParticInst();
	}
	
	public ParticInst(TblParticInst tblParticInst){
		this.tblParticInst=tblParticInst;
	}
	
	public TblParticInst getTblParticInst(){
		return this.tblParticInst;
	}
	
	public Long getId() {
		return this.getTblParticInst().getActivityInstId();
	}

	public void setId(Long particInstId){
		this.getTblParticInst().setParticInstId(particInstId);
	}
	
	 public Long getProcessInstId() {
	        return this.getTblParticInst().getProcessInstId();
	    }

	    public void setProcessInstId(Long processInstId) {
	       this.getTblParticInst().setProcessInstId(processInstId);
	    }

	    public Long getActivityInstId() {
	        return this.getTblParticInst().getActivityInstId();
	    }

	    public void setActivityInstId(Long activityInstId) {
	        this.getTblParticInst().setActivityInstId(activityInstId);
	    }

	    public Long getParticUserId() {
	        return this.getTblParticInst().getParticUserId();
	    }

	    public void setParticUserId(Long particUserId) {
	       this.getTblParticInst().setParticUserId(particUserId);
	    }

	    public String getParticUserValue() {
	        return this.getTblParticInst().getParticUserValue();
	    }

	    public void setParticUserValue(String particUserValue) {
	       this.getTblParticInst().setParticUserValue(particUserValue);
	    }

	    public String getExcuteState() {
	        return this.getTblParticInst().getExcuteState();
	    }

	    public void setExcuteState(String excuteState) {
	       this.getTblParticInst().setExcuteState(excuteState);
	    }

	    public String getPartiinType() {
	        return this.getTblParticInst().getPartiinType();
	    }

	    public void setPartiinType(String partiinType) {
	       this.getTblParticInst().setPartiinType(partiinType);
	    }

	    public String getRemark() {
	        return this.getTblParticInst().getRemark();
	    }

	    public void setRemark(String remark) {
	        this.getTblParticInst().setRemark(remark);
	    }
}
