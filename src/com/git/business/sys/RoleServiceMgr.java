package com.git.business.sys;

import java.util.List;
import java.util.Map;

import com.git.db.BaseConditionVO;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface RoleServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "roleServiceMgr";
	
	/**
	 * 后台添加用户
	 * 
	 * @param Role
	 */
	void addRole(Role Role);

	void updRole(Role Role);
	
	void delRole(Long id);

	Role getRole(Long id);
	
	List<Role> searchRole(BaseConditionVO vo);

	int searchRoleNum(BaseConditionVO vo);
	
	List<Map> getMenuList();
	
	List<Map> getRoleMenuList(Role role);
	
	boolean isUniqueRoleName(Role role);
}
