package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class TblProcessInst implements Serializable {
	private Long processInstId;

    private String bussNo;

    private String processinstname;

    private String processinstdesc;

    private String creator;

    private String currentState;

    private Date createTime;

    private Date finalTime;

    private Long processDefId;

    private String remark;

    private String remark1;

    private Float param1;

    private String param2;

    private String param3;

    private Long param4;

    private Date param5;

    private static final long serialVersionUID = 1L;

    public Long getProcessInstId() {
        return processInstId;
    }

    public void setProcessInstId(Long processInstId) {
        this.processInstId = processInstId;
    }

    public String getBussNo() {
        return bussNo;
    }

    public void setBussNo(String bussNo) {
        this.bussNo = bussNo == null ? null : bussNo.trim();
    }

    public String getProcessinstname() {
        return processinstname;
    }

    public void setProcessinstname(String processinstname) {
        this.processinstname = processinstname == null ? null : processinstname.trim();
    }

    public String getProcessinstdesc() {
        return processinstdesc;
    }

    public void setProcessinstdesc(String processinstdesc) {
        this.processinstdesc = processinstdesc == null ? null : processinstdesc.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState == null ? null : currentState.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(Date finalTime) {
        this.finalTime = finalTime;
    }

    public Long getProcessDefId() {
        return processDefId;
    }

    public void setProcessDefId(Long processDefId) {
        this.processDefId = processDefId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public Float getParam1() {
        return param1;
    }

    public void setParam1(Float param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2 == null ? null : param2.trim();
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3 == null ? null : param3.trim();
    }

    public Long getParam4() {
        return param4;
    }

    public void setParam4(Long param4) {
        this.param4 = param4;
    }

    public Date getParam5() {
        return param5;
    }

    public void setParam5(Date param5) {
        this.param5 = param5;
    }
}