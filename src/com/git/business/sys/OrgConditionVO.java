package com.git.business.sys;

import com.git.db.BaseConditionVO;

public class OrgConditionVO extends BaseConditionVO {
	private String orgType;
	
	private String orgStatus;

	public String getOrgStatus() {
		return orgStatus;
	}

	public void setOrgStatus(String orgStatus) {
		this.orgStatus = orgStatus;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	
}
