package com.git.business.caseService;

import java.util.List;
import java.util.Map;

import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillImpl;

import dwz.framework.sys.exception.ServiceException;

public interface CaseBillServiceMgr {

	@SuppressWarnings("rawtypes")
	public List<CaseBillImpl> searchCaseBill(Map criterias,	BaseConditionVO vo);
	
	public void addCaseBill(CaseBillImpl caseBillImpl);
	
	public int updateCaseBill(CaseBillImpl caseBillImpl);
	
	public int updCaseBill(CaseBillImpl caseBillImpl) throws ServiceException;
	
	public CaseBillImpl getCaseBill(String billId);
	
	public int processSendBill(CaseBillImpl caseBillImpl) throws ServiceException;
	
	public int delete(String billId);
	
	public List<CaseBillImpl> searchCaseBillByCaseId(String caseId);
	
}