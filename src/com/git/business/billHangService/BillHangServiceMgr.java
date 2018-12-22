package com.git.business.billHangService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.BillHangImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface BillHangServiceMgr extends BusinessObjectServiceMgr {

	public int updateBillHang(BillHangImpl billHangImpl);
	
	public int updBillHang(BillHangImpl billHangImpl,HttpServletRequest request) throws ServiceException;
	
	public Map searchBillHang(Map criterias,BaseConditionVO vo);
	
	public BillHangImpl getBillHang(String id);
	
	public void delBillHang(String id);
	
	public int insertBillHang(BillHangImpl billHangImpl);
	
}