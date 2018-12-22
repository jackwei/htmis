package com.git.business.assure.third;

import java.util.List;
import java.util.Map;

import com.git.db.BaseConditionVO;
import com.git.db.beans.TblThirdPartyExample;


import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface ThirdServiceMgr extends BusinessObjectServiceMgr{
	
	List<Third> searchThird(BaseConditionVO vo, String orderField,
			int startIndex, int count);
	
	void deleteByPrimaryKey(long oid);
	
	int countByExample(TblThirdPartyExample example);
	
	void add(Third third);
	
	void update(Third third);
	
	Third getthird(long oid);
	
	int count(BaseConditionVO vo);
	
	
}
