package com.git.business.Passurepayments;

import java.util.List;
import java.util.Map;


import com.git.business.PassureInfos.PassureInfos;
import com.git.db.BaseConditionVO;
import com.git.db.beans.TblPassurePayMents;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface PassurePayMentsServiceMgr extends BusinessObjectServiceMgr{
	@SuppressWarnings("rawtypes")
	List<TblPassurePayMents> searchPassurePayMents(BaseConditionVO vo,Map criterias,String orderField,
			int startIndex, int count);
	
	TblPassurePayMents selectpassurepayments(Long passurepayid);
	

	@SuppressWarnings("rawtypes")
	TblPassurePayMents createpayment(List list);
	
	void updatepayment(PassurePayMents ppm);
	void updpayment(TblPassurePayMents pm);
	
	public PassurePayMents getPassurePayMents(Long passurepayid);
	
	void sendpassureapply(PassurePayMents ppm, List<PassureInfos> list)throws ServiceException;
	
	int count();
	
	void backapply(String[] payid,PassurePayMents ppm);
	
	void sendapply(String[] payid,PassurePayMents ppm);


}
