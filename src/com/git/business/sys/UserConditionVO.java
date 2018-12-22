package com.git.business.sys;

import com.git.db.BaseConditionVO;

public class UserConditionVO extends BaseConditionVO {
	private String userStatus;
	private String orgCode;
	private String userGroup;

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getUserGroup() {
		return userGroup;
	}
	
}
