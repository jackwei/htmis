package com.git.business.claim;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.ClaimIncomeImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface ClaimInComeServiceMgr extends BusinessObjectServiceMgr {

	@SuppressWarnings("rawtypes")
	public Map searchClaimIncome(Map criterias,BaseConditionVO vo);
	
	public ClaimIncomeImpl getClaimIncome(String inComeId);
	
	public void del(String inComeId);
	
	public int updClaimIncome(ClaimIncomeImpl claimIncomeImpl,HttpServletRequest request ) throws ServiceException;

	public int updateClaimIncome(ClaimIncomeImpl claimIncomeImpl);
	
	public int getCount();
	
	public List<ClaimIncomeImpl> searchClaimIncomeByCaseNum(Map criterias,String caseNumber);
    
	/**
	 * 根据到账id查询赔款登记信息
	 * @param claimIncomeId
	 * @return
	 */
	public CaseClaimImpl searchcaseClaim(String claimIncomeId);
	/**
	 * 根据案号id查询赔款到账信息以及赔款登记信息
	 * @param caseNumber
	 * @return
	 */
	public List<Map> searchClaimIncomeByNum(String caseNumber);
	
	public List<ClaimIncomeImpl> searchClaimIncomeByLock(Map criterias,String caseNumber);
	
	public List<ClaimIncomeImpl> searchClaimIncomeByBill(Map criterias,String caseNumber);
	
	public List<Map> searchClaimIncomeByBillId(String billId);

}