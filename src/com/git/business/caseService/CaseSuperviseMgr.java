package com.git.business.caseService;

import java.util.Map;

import com.git.db.beans.CaseSuperviseImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface CaseSuperviseMgr extends BusinessObjectServiceMgr {

	public int addSupervise(CaseSuperviseImpl caseSuperviseImpl);
	
	public Map<Object, Object> searchSupervise(Map criterias);
}