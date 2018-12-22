package com.git.business.PassureInfos;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.TblPassureInfosExample;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface PassureInfosServiceMgr extends BusinessObjectServiceMgr{
	@SuppressWarnings("rawtypes")
	List<PassureInfos> searchPassureInfos(BaseConditionVO vo,Map criterias,String orderField,int startIndex, int count);
	
	@SuppressWarnings("rawtypes")
	List<PassureInfos> searchAllPassureInfos(BaseConditionVO vo,Map criterias);
	
	int countPassureInfos(Map criterias);
	
	@SuppressWarnings("rawtypes")
	int countPassureInfos(TblPassureInfosExample example,Map criterias);
	
	void deleteByPrimaryKey(Long passureid);
	
	int countByExample(TblPassureInfosExample example);
	
	List<PassureInfos> searchall(TblPassureInfosExample example);
	
	void update(PassureInfos passureInfos);
	
	PassureInfos getPassureInfos(Long passureid);
	
	void addpassurebill(String[] aids, CaseBillImpl caseBillImpl, HttpServletRequest request);
	
	void cutpassurebill(String[] aids, CaseBillImpl caseBillImpl, HttpServletRequest request);
   
	void add(PassureInfos passureInfos);

	String createpayment();

	void assureSendBill(CaseBillImpl caseBillImpl)throws ServiceException;
	
	@SuppressWarnings("rawtypes")
	List searchunapply();
	
	@SuppressWarnings("rawtypes")
	List searchpassurebybillid(Long billid);
	
	@SuppressWarnings("rawtypes")
	public Map<Object, Object> searchCase(Map criterias,BaseConditionVO vo);

}
