package com.git.business.searchandcount;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.git.db.BaseConditionVO;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface SearchAndCountServiceMgr extends BusinessObjectServiceMgr{
	//查询统计报表
	
	//分组信息
	public Map<String, String> group(HttpServletRequest request);
	
	//condition所有查询条件
	public String condition(HttpServletRequest request, StringBuffer sf);

		
}