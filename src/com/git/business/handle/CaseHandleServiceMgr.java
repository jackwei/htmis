package com.git.business.handle;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseHandleImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.mapper.CaseInfoImplMapper;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface CaseHandleServiceMgr extends BusinessObjectServiceMgr {

	public List<CaseHandleImpl> searchCaseHandle(Map criterias,BaseConditionVO vo);
	
	public CaseHandleImpl getCaseHandle(String claimId);
	
	public int delCaseHandle(String seqId);
	
	public int updCaseHandle(CaseHandleImpl caseHandleImpl,HttpServletRequest request );
	
	public int getCount();

}