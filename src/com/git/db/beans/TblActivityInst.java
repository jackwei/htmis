package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class TblActivityInst implements Serializable {
    private Long activityInstId;

    private Long processInstId;

    private Long activityDefId;

    private String currentState;

    private Date createTime;

    private Date finalTime;

    private String aduitResult;

    private String aduit;

    private Date checkdate;

    private String checkdes;

    private String remark;

    private String remark1;

    private static final long serialVersionUID = 1L;

    public Long getActivityInstId() {
        return activityInstId;
    }

    public void setActivityInstId(Long activityInstId) {
        this.activityInstId = activityInstId;
    }

    public Long getProcessInstId() {
        return processInstId;
    }

    public void setProcessInstId(Long processInstId) {
        this.processInstId = processInstId;
    }

    public Long getActivityDefId() {
        return activityDefId;
    }

    public void setActivityDefId(Long activityDefId) {
        this.activityDefId = activityDefId;
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

    public String getAduitResult() {
        return aduitResult;
    }

    public void setAduitResult(String aduitResult) {
        this.aduitResult = aduitResult == null ? null : aduitResult.trim();
    }

    public String getAduit() {
        return aduit;
    }

    public void setAduit(String aduit) {
        this.aduit = aduit == null ? null : aduit.trim();
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getCheckdes() {
        return checkdes;
    }

    public void setCheckdes(String checkdes) {
        this.checkdes = checkdes == null ? null : checkdes.trim();
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
}