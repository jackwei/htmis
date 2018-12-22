package com.git.business.assure.rewarranter;

import java.util.List;

import com.git.db.BaseConditionVO;
import com.git.db.beans.TblRewarranterExample;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface RewarranterServiceMgr extends BusinessObjectServiceMgr {
	List<Rewarranter> searchRewarranter(BaseConditionVO vo, 
			String orderField,int startIndex, int count);

	void deleteByPrimaryKey(long oid);

	int countByExample(TblRewarranterExample example);

	void add(Rewarranter rewarranter,Long dictid,String string,String flag,String sort);

	void update(Rewarranter rewarranter,String string);

	Rewarranter getRewarranter(long oid);
	
	int count(BaseConditionVO vo);
}
