package com.git.business.billService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.BillIncomeImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface BillServiceMgr extends BusinessObjectServiceMgr {

	@SuppressWarnings("rawtypes")
	public Map searchBillInCome(Map criterias,BaseConditionVO vo);
	
	public BillIncomeImpl getBillIncome(String inComeId);
	
	public void delBillIncome(String inComeId);
	
	public int updBillInCome(BillIncomeImpl billIncomeImpl,HttpServletRequest request) throws ServiceException;
	
	public int updateBillInCome(BillIncomeImpl billIncomeImpl);
	
	public int getCount();
	
}