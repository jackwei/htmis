package com.git.business.sys.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.sys.Role;
import com.git.business.sys.RoleServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.SysRole;
import com.git.db.beans.SysRoleMenu;
import com.git.db.beans.SysRoleMenuExample;
import com.git.db.beans.SysUser;
import com.git.db.mapper.SysRoleMapper;
import com.git.db.mapper.SysRoleMenuMapper;
import com.git.enums.Status;
import com.git.util.Jutil;
import com.git.util.service.SequenceService;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service(RoleServiceMgr.SERVICE_NAME)
public class RoleServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements RoleServiceMgr {
	
	@Autowired
	private SysRoleMapper roleMapper;
	
	@Autowired
	private SysRoleMenuMapper roleMenuMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	public void addRole(Role role){
		
		SysRole sysRole = new SysRole();
		Long roleId = sequenceService.getSequence("role_id");
		
		sysRole.setRoleId(roleId);
		sysRole.setRoleName(role.getRoleName());
		sysRole.setRoleStatus(String.valueOf(Status.Normal.getCode()));
		
		roleMapper.insert(sysRole);
		
		String tSelectMenu = role.getExtend1();
		if(tSelectMenu != null && !"".equals(tSelectMenu))
		{
			String [] menuArray = tSelectMenu.split(",");
			SysRoleMenu record;
			for(int i=0; i<menuArray.length;i++)
			{
				if(menuArray[i] == null || "".equals(menuArray[i]))
					continue;
				else
				{
					record = new SysRoleMenu();
					
					record.setRoleId(roleId);
					record.setMenuId(Long.valueOf(menuArray[i]));
					
					roleMenuMapper.insert(record);
				}
			}
		}		
	}

	public void updRole(Role role){
		SysRole sysRole = new SysRole();
				
		sysRole.setRoleId(role.getId());
		sysRole.setRoleName(role.getRoleName());
		sysRole.setRoleStatus(String.valueOf(role.getRoleStatus().getCode()));
		
		roleMapper.updateByPrimaryKey(sysRole);
		
		String tSelectMenu = role.getExtend1();
		if(tSelectMenu != null && !"".equals(tSelectMenu))
		{
			SysRoleMenuExample example = new SysRoleMenuExample();
			example.createCriteria().andRoleIdEqualTo(role.getId());
			roleMenuMapper.deleteByExample(example);
			
			String [] menuArray = tSelectMenu.split(",");
			SysRoleMenu record;
			for(int i=0; i<menuArray.length;i++)
			{
				if(menuArray[i] == null || "".equals(menuArray[i]))
					continue;
				else
				{
					record = new SysRoleMenu();
					
					record.setRoleId(role.getId());
					record.setMenuId(Long.valueOf(menuArray[i]));
					
					roleMenuMapper.insert(record);
				}
			}
		}
	}
	
	public void delRole(Long id){
		
	}

	public Role getRole(Long id){
		
		SysRole po = roleMapper.selectByPrimaryKey(id);
		if (po == null) return null;
		
		return new Role(po);
	}
	
	public List<Role> searchRole(BaseConditionVO vo){
		
		List<Role> roleResult = new ArrayList<Role>();		
		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		SysRole sysRole = new SysRole();
		//sysRole.setRoleStatus(String.valueOf(Status.Normal.getCode()));
		
		if(vo.getKeywords() != null && !"".equals(vo.getKeywords()))
		{
			sysRole.setRoleName(vo.getKeywords());
		}
		
		
		try
		{
			List<SysRole> pos = roleMapper.selectByCondition(sysRole, rb);
			for (SysRole po : pos) 
			{
				roleResult.add(new Role(po));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return roleResult;
	}

	public int searchRoleNum(BaseConditionVO vo){
		
		SysRole sysRole = new SysRole();
		sysRole.setRoleStatus(String.valueOf(Status.Normal.getCode()));
		
		if(vo.getKeywords() != null && !"".equals(vo.getKeywords()))
		{
			sysRole.setRoleName(vo.getKeywords());
		}
				
		return roleMapper.countByCondition(sysRole);
	}
	
	public List<Map> getMenuList()
	{
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("select b.parent_id as parent_id,(select menu_name from sys_menu where menu_id=b.parent_id) as parent_name, ");
		tSql.append("b.menu_id as menu_id,b.menu_name as menu_name  ");
		tSql.append("from sys_menu b ");
		tSql.append("where b.menu_status='1' AND b.is_leaf='1' ");
		tSql.append(" order by b.parent_id,b.menu_id  ");
		
		List<Map> menuList=Jutil.executeSQL(tSql.toString());
		
		return menuList;
	}
	
	public List<Map> getRoleMenuList(Role role)
	{
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("SELECT menu_id FROM sys_role_menu WHERE role_id = ");
		tSql.append(role.getId());
		
		List<Map> menuList=Jutil.executeSQL(tSql.toString());
		
		return menuList;
	}
	
	public boolean isUniqueRoleName(Role role)
	{
		Long id = role.getId() != null ? role.getId() : 0;
		return roleMapper.isUniqueRoleName(id, role.getRoleName()) < 1;
	}
}
