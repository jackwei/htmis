package com.git.business.claimHandle;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.ClaimIncomeImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface ClaimHandleServiceMgr extends BusinessObjectServiceMgr {

	@SuppressWarnings("rawtypes")
	public Map searchCaseClaim(Map criterias,BaseConditionVO vo);
	
	public CaseClaimImpl getCaseClaim(String claimId);
	
	public void delCaseInfo(String caseId);
	
	public int updCaseClaim(CaseClaimImpl caseClaimImpl,HttpServletRequest request );
	
	public int insertClaimInComeDetail(ClaimIncomeImpl claimIncomeImpl,CaseClaimImpl caseClaimImpl,float checkamount);
	
	public int updateCaseClaim(CaseClaimImpl caseClaimImpl);
	
	public int getCount();

}