package com.git.db.beans;

import java.io.Serializable;

public class TblParticInst implements Serializable {
    private Long particInstId;

    private Long processInstId;

    private Long activityInstId;

    private Long particUserId;

    private String particUserValue;

    private String excuteState;

    private String partiinType;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getParticInstId() {
        return particInstId;
    }

    public void setParticInstId(Long particInstId) {
        this.particInstId = particInstId;
    }

    public Long getProcessInstId() {
        return processInstId;
    }

    public void setProcessInstId(Long processInstId) {
        this.processInstId = processInstId;
    }

    public Long getActivityInstId() {
        return activityInstId;
    }

    public void setActivityInstId(Long activityInstId) {
        this.activityInstId = activityInstId;
    }

    public Long getParticUserId() {
        return particUserId;
    }

    public void setParticUserId(Long particUserId) {
        this.particUserId = particUserId;
    }

    public String getParticUserValue() {
        return particUserValue;
    }

    public void setParticUserValue(String particUserValue) {
        this.particUserValue = particUserValue == null ? null : particUserValue.trim();
    }

    public String getExcuteState() {
        return excuteState;
    }

    public void setExcuteState(String excuteState) {
        this.excuteState = excuteState == null ? null : excuteState.trim();
    }

    public String getPartiinType() {
        return partiinType;
    }

    public void setPartiinType(String partiinType) {
        this.partiinType = partiinType == null ? null : partiinType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}