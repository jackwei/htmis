package com.git.business.voucher;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.ConsignorPayImpl;
import com.git.db.beans.FinData;
import com.git.db.beans.FinDataResult;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface VoucherServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "voucherServiceMgr";
	
	public Map<Object,Object> searchFinData(Map criterias,BaseConditionVO vo);
	
	public Map<Object,Object> searchFinDataResult(Map criterias);
	
	public FinData getFinData(String batchNo);
	
	public FinDataResult getFinDataResult(String seqId);
	
	public int deleteFinData(String batchNo);
	
	public int deleteFinDataResult(String batchNo);
	
	public int updateFindata(FinData finData);
	
	public int updateFinDataResult(FinDataResult finDataResult );

}