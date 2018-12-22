/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2012-09-10 08:51:33 by code generator
 */
package com.git.business.sys;

import com.git.db.beans.SysMenu;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.framework.sys.business.BusinessFactory;

public class Menu extends AbstractBusinessObject{
	private static final long serialVersionUID = 1L;
	private SysMenu sysMenu;
	
	/* generateConstructor */
	public Menu() {
		this.sysMenu = new SysMenu();
	}
	public Menu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}
	public SysMenu getSysMenu(){
		return this.sysMenu;
	}

	
	public Long getId() {
		return this.sysMenu.getMenuId();
	}

	public void setId(Long id) {
		this.sysMenu.setMenuId(id);
	}
	
	public String getMenuName() {
		return this.sysMenu.getMenuName();
	}

	public void setMenuName(String menuName) {
		this.sysMenu.setMenuName(menuName);
	}
	
	public Long getParentId() {
        return this.sysMenu.getParentId();
    }

    public void setParentId(Long parentId) {
    	this.sysMenu.setParentId(parentId);
    }
    
    public Menu getMenu() {
		Long parentMenuId = getParentId();
		if (parentMenuId > 0) {
			MenuServiceMgr menuServiceMgr = BusinessFactory.getInstance()
					.getService(MenuServiceMgr.SERVICE_NAME);
			return menuServiceMgr.getMenu(parentMenuId);
		}
		return null;
	}
    
    public String getIsLeaf() {
        return this.sysMenu.getIsLeaf();
    }

    public void setIsLeaf(String isLeaf) {
        this.sysMenu.setIsLeaf(isLeaf);
    }
    
    public String getUrl() {
        return this.sysMenu.getUrl();
    }

    public void setUrl(String url) {
        this.sysMenu.setUrl(url);
    }
	
	public String getMenuStatus() {
		return this.sysMenu.getMenuStatus();
	}

	public void setMenuStatus(String menuStatus) {
		this.sysMenu.setMenuStatus(menuStatus);
	}
	
	//External属性，true or false
	public String getExtend1() {
		return this.sysMenu.getExtend1();
	}

	public void setExtend1(String extend1) {
		this.sysMenu.setExtend2(extend1);
	}
	
	//rel属性，页面div的ID
	public String getExtend2() {
		return this.sysMenu.getExtend2();
	}

	public void setExtend2(String extend2) {
		this.sysMenu.setExtend1(extend2);
	}
	
	public String getExtend3() {
		return this.sysMenu.getExtend3();
	}

	public void setExtend3(String extend3) {
		this.sysMenu.setExtend1(extend3);
	}

}

