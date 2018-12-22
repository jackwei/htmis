package com.git.util.service;

import java.util.List;

import com.git.db.beans.SysDictEntry;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface CommonService extends BusinessObjectServiceMgr{
	
	List getDict(String tDictTypeId);
	List getDict(String tDictTypeId,String tParentDictTypeId);
}
