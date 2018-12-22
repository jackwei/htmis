package com.git.business.service;

import java.util.List;
import java.util.Map;

import com.git.db.beans.CaseBillImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface MainService extends BusinessObjectServiceMgr{
	
	public List<CaseBillImpl> getCaseBillByOne(Map<Object, Object> criterias);
	
	public List<CaseBillImpl> getCaseBillByTwo(Map<Object, Object> criterias);
	
	public List<CaseBillImpl> getCaseBillByThree(Map<Object, Object> criterias);

}
