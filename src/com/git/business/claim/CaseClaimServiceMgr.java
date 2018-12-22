package com.git.business.claim;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.business.process.ApplyInfos;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface CaseClaimServiceMgr extends BusinessObjectServiceMgr {

	@SuppressWarnings("rawtypes")
	public List<CaseClaimImpl> searchCaseClaim(Map criterias,BaseConditionVO vo);
	
	public List<CaseClaimImpl> searchCaseClaimByCaseId(String caseId);
	
	@SuppressWarnings("rawtypes")
	public Map searchCaseClaimByCondition(Map criterias,BaseConditionVO vo);
	
	public CaseClaimImpl getCaseClaim(String claimId);
	
	public void delCaseClaimInfo(String claimId);
	
	public void delCaseClaimByIncomeId(String incomeId);
	
	public boolean updCaseClaim(CaseClaimImpl caseClaimImpl,HttpServletRequest request ,ApplyInfos applyInfos);
	
	public int updateCaseClaim(CaseClaimImpl caseClaimImpl);
	
	public int getCount();
	
	public Map searchCaseClaimByStatus(Map criterias,BaseConditionVO vo);
	
	public List<CaseClaimImpl> searchCaseClaimByBillId(String billId,BaseConditionVO vo);

}