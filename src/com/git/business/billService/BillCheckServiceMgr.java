package com.git.business.billService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.BillCheckImpl;
import com.git.db.beans.BillIncomeImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface BillCheckServiceMgr extends BusinessObjectServiceMgr {

	@SuppressWarnings("rawtypes")
	public List<BillIncomeImpl> searchBillInCome(Map criterias,BaseConditionVO vo);
	
	public BillIncomeImpl getBillIncome(String inComeId);
	
	public void delBillIncome(String inComeId);
	
	public int updBillInCome(BillIncomeImpl billIncomeImpl,HttpServletRequest request);
	
	public int getCount();
	
	@SuppressWarnings("rawtypes")
	public List<BillCheckImpl> searchBillCheck(Map criterias,BaseConditionVO vo);
	
	@SuppressWarnings("rawtypes")
	public Map search(Map criterias,BaseConditionVO vo);
	
	public List<BillCheckImpl> searchBillCheckedByStatement(Map criterias,BaseConditionVO vo);
	
	public BillCheckImpl getBillCheckByBillId(String billId);
	
	public int addBillCheck(BillCheckImpl billCheckImpl);
	
	public int updBillCheck(BillCheckImpl billCheckImpl);
	
	public BillCheckImpl getBillCheck(String checkId);
	
}