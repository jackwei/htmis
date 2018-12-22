package com.git.business.claimRate;

import java.util.List;
import java.util.Map;


import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.ClaimRateSubImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface ClaimRateServiceMgr extends BusinessObjectServiceMgr {

	
	public ClaimRateSubImpl getClaimRate(String rateId);
	
	@SuppressWarnings("rawtypes")
	public Map<String,List> processClaimRate(Map criterias,BaseConditionVO vo) throws ServiceException;
	
	public List<ClaimRateSubImpl> searchClaimRate(Map criterias,BaseConditionVO vo);
	
	public List<ClaimRateSubImpl> searchClaimRateByCaseNumber(String casenumber);
	
	public void del(String caseId);
	
	public int getCount();
	
	public List<CaseClaimImpl> searchCaseClaim(String casenumber,boolean isNull);
	
	public List<ClaimIncomeImpl> searchClaimInCome(String casenumber,boolean isNull);
	
	public int updateClaimRateSub(ClaimRateSubImpl claimRateSubImpl);
	
	public int insertClaimRateSub(ClaimIncomeImpl claimIncomeImpl,CaseClaimImpl caseClaimImpl,float differamount,float rate,float usdamount);

}