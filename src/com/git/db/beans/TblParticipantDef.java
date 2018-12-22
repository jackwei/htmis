package com.git.db.beans;

public class TblParticipantDef {
    private Long particDefId;

    private String particType;

    private String particValue;

    private String particValue2;

    private Long processDefId;

    private Long activityDefId;

    private Long particValueId;

    public Long getParticDefId() {
        return particDefId;
    }

    public void setParticDefId(Long particDefId) {
        this.particDefId = particDefId;
    }

    public String getParticType() {
        return particType;
    }

    public void setParticType(String particType) {
        this.particType = particType == null ? null : particType.trim();
    }

    public String getParticValue() {
        return particValue;
    }

    public void setParticValue(String particValue) {
        this.particValue = particValue == null ? null : particValue.trim();
    }

    public String getParticValue2() {
        return particValue2;
    }

    public void setParticValue2(String particValue2) {
        this.particValue2 = particValue2 == null ? null : particValue2.trim();
    }

    public Long getProcessDefId() {
        return processDefId;
    }

    public void setProcessDefId(Long processDefId) {
        this.processDefId = processDefId;
    }

    public Long getActivityDefId() {
        return activityDefId;
    }

    public void setActivityDefId(Long activityDefId) {
        this.activityDefId = activityDefId;
    }

    public Long getParticValueId() {
        return particValueId;
    }

    public void setParticValueId(Long particValueId) {
        this.particValueId = particValueId;
    }
}