package com.git.db.beans;

public class TblActivityDef {
	private Long activityDefId;

    private Long processDefId;

    private String activityNo;

    private String activityName;

    private String activityDesc;

    private String startType;

    private String preActivity;

    private Float param1;

    private String param2;

    private String param3;

    private static final long serialVersionUID = 1L;

    public Long getActivityDefId() {
        return activityDefId;
    }

    public void setActivityDefId(Long activityDefId) {
        this.activityDefId = activityDefId;
    }

    public Long getProcessDefId() {
        return processDefId;
    }

    public void setProcessDefId(Long processDefId) {
        this.processDefId = processDefId;
    }

    public String getActivityNo() {
        return activityNo;
    }

    public void setActivityNo(String activityNo) {
        this.activityNo = activityNo == null ? null : activityNo.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc == null ? null : activityDesc.trim();
    }

    public String getStartType() {
        return startType;
    }

    public void setStartType(String startType) {
        this.startType = startType == null ? null : startType.trim();
    }

    public String getPreActivity() {
        return preActivity;
    }

    public void setPreActivity(String preActivity) {
        this.preActivity = preActivity == null ? null : preActivity.trim();
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
}