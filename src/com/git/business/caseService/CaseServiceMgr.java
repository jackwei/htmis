package com.git.business.caseService;

import java.util.List;
import java.util.Map;

import com.git.business.process.CaseBillDetail;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseInfoImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface CaseServiceMgr extends BusinessObjectServiceMgr {

	public abstract void addCase(CaseInfoImpl caseInfoImpl);
	
	@SuppressWarnings("rawtypes")
	public Map<Object, Object> searchCase(Map criterias,BaseConditionVO vo);
	
	public CaseInfoImpl getCaseInfo(String caseId);
	
	public void delCaseInfo(String caseId);
	
	public CaseInfoImpl updCase(CaseInfoImpl caseInfoImpl);
	
	public int updateCase(CaseInfoImpl caseInfoImpl);
	
	public int getCount();
	
	public List<CaseBillDetailImpl> getCaseConsignor(String caseId);
	
	public String getCaseInfoByCaseNumber(String casenumber);
	
	public List<CaseBillDetail> getCaseBillDetail(String caseId);
	
	public CaseInfoImpl searchCaseInfoByCaseNumber(String casenumber);
}