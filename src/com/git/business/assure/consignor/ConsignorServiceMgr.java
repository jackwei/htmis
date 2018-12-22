package com.git.business.assure.consignor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.TblConsignorExample;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface ConsignorServiceMgr extends BusinessObjectServiceMgr{
	List<Consignor> searchConsignor(BaseConditionVO vo, String orderField,
			int startIndex, int count);
	
	void deleteByPrimaryKey(long oid);
	
	int countByExample(TblConsignorExample example);
	
	
	void update(String string,Consignor consignor);
	
	Consignor getconsignor(long oid);
	
	int count(BaseConditionVO vo);

	void add(Consignor consignor, HttpServletRequest request);


}
