package com.git.business.params;

import java.util.List;

import com.git.db.BaseConditionVO;
import com.git.db.beans.TblParamsExample;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface ParamsServiceMgr extends BusinessObjectServiceMgr{
	List<Params> searchParams(BaseConditionVO vo, String orderField,
			int startIndex, int count);

	void deleteByPrimaryKey(long oid);

	int countByExample(TblParamsExample example);

	void add(Params params);

	void update(Params params);

	Params getParams(long oid);

	int count(BaseConditionVO vo);

}
