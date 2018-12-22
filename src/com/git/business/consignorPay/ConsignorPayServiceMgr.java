package com.git.business.consignorPay;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.ConsignorPayImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface ConsignorPayServiceMgr extends BusinessObjectServiceMgr {

	@SuppressWarnings("rawtypes")
	public Map<Object,Object> searchConsignorPay(Map criterias,BaseConditionVO vo);
	
	public ConsignorPayImpl getConsignorPay(String payId);	
	
	public int del(String inComeId);
	
	public int updConsignorPay(ConsignorPayImpl consignorPayImpl,HttpServletRequest request ) throws ServiceException;
	
	public int getCount();
	
	public int updateConsignorPay(ConsignorPayImpl consignorPayImpl);

}