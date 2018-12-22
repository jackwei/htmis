package com.git.business.sys;

import java.util.List;
import java.util.Map;

import com.git.business.book.Book;
import com.git.db.BaseConditionVO;
import com.git.db.beans.SysCode;
import com.git.db.beans.SysGroup;


import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface OrgServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "orgServiceMgr";
	
	/**
	 * 后台编辑组织机构（增加、删除、修改）
	 * 
	 * @param user
	 */
	void addOrg(Org org);
	
	public int syncAddOrg(SysGroup sysGroup);
	
	public int sysUpdOrg(SysGroup sysGroup);

	void updOrg(Org org);
	
	void delOrg(Long id);

	Org getOrg(Long id);
   
	/**
	 * 查询机构信息
	 * 
	 * @param id
	 */
	List<Org> searchOrg(OrgConditionVO vo,
			int startIndex, int count);

	int searchOrgNum(OrgConditionVO vo);
	
	public SysCode getSysCode(String codeid);
	
	public int updateSysCode(SysCode sysCode);
	
	public List<SysGroup> searchOrg(OrgConditionVO vo);
	
	public int searchOrgNum();
	
	public Map searchOrg(Map criterias,OrgConditionVO vo);

	/**
	 * 禁用一个用户
	 * 
	 * @param id
	 */
	//void inActiveUsesr(int id);

}
