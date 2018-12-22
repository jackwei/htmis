package com.git.business.service;


import java.util.Map;

import com.git.db.BaseConditionVO;
import com.git.db.beans.LogEntity;
import dwz.framework.sys.business.BusinessObjectServiceMgr;


public interface LogEntityService extends BusinessObjectServiceMgr{
	void save(LogEntity logEntity);
	
	LogEntity get(Long id);
	
	void update(LogEntity logEntity);
	
	void delete(Long id);
	
	@SuppressWarnings("rawtypes")
	public Map<Object, Object> search(Map criterias,BaseConditionVO vo);
	
}
