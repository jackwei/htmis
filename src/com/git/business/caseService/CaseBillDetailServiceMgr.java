package com.git.business.caseService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillDetailImpl;

import dwz.framework.sys.exception.ServiceException;

public interface CaseBillDetailServiceMgr {

	@SuppressWarnings("rawtypes")
	public List<CaseBillDetailImpl> searchCaseBillDetail(Map criterias,BaseConditionVO vo);

	public CaseBillDetailImpl searchCaseBillDetail(String detailId);
	
	public int updConsignor(CaseBillDetailImpl caseBillDetailImpl,HttpServletRequest request) throws ServiceException;
	
	public int updOther(CaseBillDetailImpl caseBillDetailImpl,HttpServletRequest request) throws ServiceException;
	
	public int getTotalConunt(String feeType);
	
	public int updateCaseBillDetail(CaseBillDetailImpl caseBillDetailImpl);
	
	public List<CaseBillDetailImpl> searchCaseBillDetail(String orgCode,String consignorid,String payId,String status,String currency);	

	public List<CaseBillDetailImpl> searchCaseBillDetailByPayId(String payId);
	
	public List<CaseBillDetailImpl> searchCaseBillDetailByBillId(String billId,String feeType);
	
	public int delete(String detailId);
	
	public List<String> getCaseBillDetail(String caseId,String feeType,BaseConditionVO vo);
	
	public int getCaseBillDetailCount(String caseId,String feeType);
}