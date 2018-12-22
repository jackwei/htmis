package com.git.business.sys.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.sys.Menu;
import com.git.business.sys.MenuServiceMgr;
import com.git.business.sys.OrgServiceMgr;
import com.git.db.beans.SysMenu;
import com.git.db.beans.SysMenuExample;
import com.git.db.mapper.SysMenuMapper;
import com.git.util.service.SequenceService;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service(MenuServiceMgr.SERVICE_NAME)
public class MenuServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements MenuServiceMgr {
	
	@Autowired
	private SysMenuMapper menuMapper;
	
	@Autowired
	private SequenceService sequenceService;
		
	public void addMenu(Menu menu){
	
		
		Date now = new Date();
		SysMenu po = menu.getSysMenu();
						
		menuMapper.insert(po);
	}

	public void updMenu(Menu menu) {

		Date now = new Date();
		SysMenu po = menu.getSysMenu();
		
		menuMapper.updateByPrimaryKey(po);
	}
	
	public void delMenu(Long id){
		menuMapper.deleteByPrimaryKey(id);
	}

	public Menu getMenu(Long id) {
		SysMenu po = menuMapper.selectByPrimaryKey(id);
		if (po == null) return null;
		
		return new Menu(po);
	}
	
	public List<Menu> searchMenu(Long parentMenuId)
	{
		List<Menu> menuResult = new ArrayList<Menu>();		
		SysMenuExample example = new SysMenuExample();
		
		if(parentMenuId == null || parentMenuId < 0)
			parentMenuId = (long)0;
		
		example.createCriteria().andParentIdEqualTo(parentMenuId);//根据父节点查询子菜单
		
		try
		{
			List<SysMenu> pos = menuMapper.selectByExample(example);
			for (SysMenu po : pos) 
			{
				menuResult.add(new Menu(po));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return menuResult;
	}
	
}
