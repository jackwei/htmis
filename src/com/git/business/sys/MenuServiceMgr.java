package com.git.business.sys;

import java.util.List;

import com.git.business.book.Book;
import com.git.db.BaseConditionVO;


import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface MenuServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "menuServiceMgr";
	
	/**
	 * 后台编辑菜单信息（增加、删除、修改）
	 * 
	 * @param user
	 */
	void addMenu(Menu menu);

	void updMenu(Menu menu);
	
	void delMenu(Long id);

	Menu getMenu(Long id);
   
	List<Menu> searchMenu(Long parentMenuId);
}
