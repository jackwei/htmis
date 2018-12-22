package com.git.business.process;


import com.git.db.beans.TblActivityDef;

import dwz.framework.sys.business.AbstractBusinessObject;

/**
 *  节点信息表
 * @author shona
 *
 */
public class ActivityDef extends AbstractBusinessObject {
	private static final long serialVersionUID = 1L;
	private TblActivityDef tblActivityDef;
	
	public ActivityDef(){
		this.tblActivityDef=new TblActivityDef();
	}
	
	public ActivityDef(TblActivityDef tblActivityDef){
		this.tblActivityDef=tblActivityDef;
	}
	
	public TblActivityDef getTblActivityDef(){
		return this.tblActivityDef;
	}
	
	public Long getId(){
		return this.getTblActivityDef().getActivityDefId();
	}
	
	public void setId(Long id){
	 this.getTblActivityDef().setActivityDefId(id);	
	}
	
	public Long getProcessId(){
		return this.getTblActivityDef().getProcessDefId();
	}
	public void setProcessId(Long processDefId){
		this.getTblActivityDef().setProcessDefId(processDefId);
	}
	
	public String getNo(){
		return this.getTblActivityDef().getActivityNo();
	}
	
	public void setNo(String activityNo){
		this.getTblActivityDef().setActivityNo(activityNo);
	}
	
	public String getName(){
		return this.getTblActivityDef().getActivityName();
	}
	
	public void setName(String activityName){
		this.getTblActivityDef().setActivityName(activityName);
	}
	
	public String getDesc(){
		return this.getTblActivityDef().getActivityDesc();
	}
	
	public void setDesc(String desc){
		this.getTblActivityDef().setActivityDesc(desc);
	}
	
	public String getStartType(){
		return this.getTblActivityDef().getStartType();
	}
	
	public void setStartType(String startType){
		this.getTblActivityDef().setStartType(startType);
	}
	
	public String getPreActivity(){
		return this.getTblActivityDef().getPreActivity();
	}
	
	public void setPreActivity(String preActivity){
		this.getTblActivityDef().setPreActivity(preActivity);
	}
	
	public Float getParam1() {
        return this.getTblActivityDef().getParam1();
    }

    public void setParam1(Float param1) {
        this.tblActivityDef.setParam1(param1);
    }

    public String getParam2() {
        return this.tblActivityDef.getParam2();
    }

    public void setParam2(String param2) {
        this.tblActivityDef.setParam2(param2);
    }

    public String getParam3() {
        return this.tblActivityDef.getParam3();
    }

    public void setParam3(String param3) {
        this.tblActivityDef.setParam3(param3);
    }
}
