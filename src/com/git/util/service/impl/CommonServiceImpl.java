package com.git.util.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.db.beans.SysDictEntry;
import com.git.db.mapper.SysDictEntryMapper;
import com.git.util.service.CommonService;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service("commonService")
public class CommonServiceImpl extends AbstractBusinessObjectServiceMgr
	implements CommonService {
	
	@Autowired
	private SysDictEntryMapper dictMapper;
	
	public List getDict(String tDictTypeId)
	{
		List resultList = dictMapper.getDictEntryByTypeId(tDictTypeId);
		return resultList;
	}
	
	
	public List getDict(String tDictTypeId,String tParentDictId)
	{
		List resultList = dictMapper.getDictEntryByParentId(tDictTypeId, tParentDictId);
		return resultList;
	}
}
