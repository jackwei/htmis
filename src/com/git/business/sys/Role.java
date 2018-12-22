/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2012-09-10 08:51:33 by code generator
 */
package com.git.business.sys;

import com.git.db.beans.SysRole;
import com.git.enums.Status;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.framework.sys.lang.enums.ExtEnumUtils;

public class Role extends AbstractBusinessObject{
	private static final long serialVersionUID = 1L;
	private SysRole sysRole;
	
	/* generateConstructor */
	public Role() {
		this.sysRole = new SysRole();
	}
	public Role(SysRole sysRole) {
		this.sysRole = sysRole;
	}
	public SysRole getSysRole(){
		return this.sysRole;
	}

	
	public Long getId() {
		return this.sysRole.getRoleId();
	}

	public void setId(Long id) {
		this.sysRole.setRoleId(id);
	}
	
	public String getRoleName() {
		return this.sysRole.getRoleName();
	}

	public void setRoleName(String roleName) {
		this.sysRole.setRoleName(roleName);
	}
	
	public Status getRoleStatus() {
		//return this.sysRole.getRoleStatus();
		return ExtEnumUtils.getRequiredByCode(this.sysRole.getRoleStatus(), Status.values());
	}

	public void setRoleStatus(String roleStatus) {
		this.sysRole.setRoleStatus(roleStatus);
	}
	
	public String getExtend1() {
		return this.sysRole.getExtend1();
	}

	public void setExtend1(String extend1) {
		this.sysRole.setExtend1(extend1);
	}
	
	public String getExtend2() {
		return this.sysRole.getExtend2();
	}

	public void setExtend2(String extend2) {
		this.sysRole.setExtend2(extend2);
	}
	
	public String getExtend3() {
		return this.sysRole.getExtend3();
	}

	public void setExtend3(String extend3) {
		this.sysRole.setExtend3(extend3);
	}

}

