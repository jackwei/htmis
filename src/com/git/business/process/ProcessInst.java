package com.git.business.process;

import java.util.Date;

import com.git.db.beans.TblProcessInst;

import dwz.framework.sys.business.AbstractBusinessObject;

/**
 * 流程实例
 * @author shona
 *
 */
public class ProcessInst extends AbstractBusinessObject {
	
	private static final long serialVersionUID = 1L;
	private TblProcessInst tblProcessInst;
	
	public ProcessInst(){
		tblProcessInst=new TblProcessInst();
	}
	
	public ProcessInst(TblProcessInst tblProcessInst){
		this.tblProcessInst=tblProcessInst;
	}
	
	public TblProcessInst getTblProcessInst(){
		return this.tblProcessInst;
	}
	
	public Long getId() {
		return tblProcessInst.getProcessInstId();
	}
	
	public void setId(Long processInstId){
		tblProcessInst.setProcessInstId(processInstId);
	}
	public String getBussNo() {
        return tblProcessInst.getBussNo();
    }

    public void setBussNo(String bussNo) {
        tblProcessInst.setBussNo(bussNo);
    }

    public String getProcessinstname() {
        return this.getTblProcessInst().getProcessinstname();
    }

    public void setProcessinstname(String processinstname) {
        this.getTblProcessInst().setProcessinstname(processinstname);
    }

    public String getProcessinstdesc() {
        return this.getTblProcessInst().getProcessinstdesc();
    }

    public void setProcessinstdesc(String processinstdesc) {
    	this.getTblProcessInst().setProcessinstdesc(processinstdesc);
    }

    public String getCreator() {
        return this.getTblProcessInst().getCreator();
    }

    public void setCreator(String creator) {
       this.getTblProcessInst().setCreator(creator);
    }

    public String getCurrentState() {
        return this.getTblProcessInst().getCurrentState();
    }

    public void setCurrentState(String currentState) {
       this.getTblProcessInst().setCurrentState(currentState);
    }

    public Date getCreateTime() {
        return this.getTblProcessInst().getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.getTblProcessInst().setCreateTime(createTime);
    }

    public Date getFinalTime() {
        return this.getTblProcessInst().getFinalTime();
    }

    public void setFinalTime(Date finalTime) {
       this.getTblProcessInst().setFinalTime(finalTime);
    }

    public Long getProcessDefId() {
        return this.getTblProcessInst().getProcessDefId();
    }

    public void setProcessDefId(Long processDefId) {
      this.getTblProcessInst().setProcessDefId(processDefId);
    }

    public String getRemark() {
        return this.getTblProcessInst().getRemark();
    }

    public void setRemark(String remark) {
    	this.getTblProcessInst().setRemark(remark);
    }

    public String getRemark1() {
        return this.getTblProcessInst().getRemark1();
    }

    public void setRemark1(String remark1) {
    	this.getTblProcessInst().setRemark1(remark1);
    }
    
    public Float getParam1() {
        return this.tblProcessInst.getParam1();
    }

    public void setParam1(Float param1) {
        this.tblProcessInst.setParam1(param1);
    }

    public String getParam2() {
        return this.tblProcessInst.getParam2();
    }

    public void setParam2(String param2) {
        this.tblProcessInst.setParam2(param2);
    }

    public String getParam3() {
        return this.tblProcessInst.getParam3();
    }

    public void setParam3(String param3) {
        this.tblProcessInst.setParam3(param3);
    }

    public Long getParam4() {
        return this.tblProcessInst.getParam4();
    }

    public void setParam4(Long param4) {
        this.tblProcessInst.setParam4(param4);
    }

    public Date getParam5() {
        return this.tblProcessInst.getParam5();
    }

    public void setParam5(Date param5) {
        this.tblProcessInst.setParam5(param5);
    }

}
