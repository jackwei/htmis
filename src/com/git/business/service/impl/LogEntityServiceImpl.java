package com.git.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.db.BaseConditionVO;
import com.git.db.beans.LogEntity;
import com.git.db.beans.LogEntityExample;
import com.git.db.beans.LogEntityExample.Criteria;
import com.git.db.mapper.LogEntityMapper;
import com.git.business.service.LogEntityService;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

/** 
 * 	
 * @author 	<a href="mailto:ketayao@gmail.com">ketayao</a>
 * Version  2.1.0
 * @since   2013-5-3 下午5:08:05 
 */
@Service
@Transactional
public class LogEntityServiceImpl  extends AbstractBusinessObjectServiceMgr implements LogEntityService {
	
	@Autowired
	private LogEntityMapper logEntityMapper;
	
	@SuppressWarnings("rawtypes")
	public Map<Object, Object> search(Map criterias,BaseConditionVO vo){
		Map<Object, Object> search = new HashMap<Object, Object>();
		LogEntityExample example = new LogEntityExample();
		example.setOrderByClause(" id desc ");
		Criteria criteria = example.createCriteria();
		if(criterias.get("username") != null && !"".equals(criterias.get("username"))){
			criteria.andUsernameLike(criterias.get("username").toString());
		}
		if(criterias.get("ipAddress") != null && !"".equals(criterias.get("ipAddress"))){
			criteria.andIpAddressEqualTo(criterias.get("ipAddress").toString());
		}
		if(criterias.get("logLevel") != null && !"".equals(criterias.get("logLevel"))){
			criteria.andLogLevelEqualTo(criterias.get("logLevel").toString());
		}
		int count = logEntityMapper.countByExample(example);
		RowBounds rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		List<LogEntity> logEntityList = logEntityMapper.selectByExampleWithRowbounds(example, rowBounds);
		search.put("logEntityList", logEntityList);
		search.put("count", count);
		return search;
	}
	
	/**   
	 * @param logEntity  
	 * @see com.ketayao.ketacustom.service.LogEntityService#save(com.ketayao.ketacustom.entity.main.LogEntity)  
	 */
	@Override
	public void save(LogEntity logEntity) {
		logEntityMapper.insertSelective(logEntity);
	}

	/**   
	 * @param id
	 * @return  
	 * @see com.ketayao.ketacustom.service.LogEntityService#get(java.lang.Long)  
	 */
	@Override
	public LogEntity get(Long id) {
		return logEntityMapper.selectByPrimaryKey(id);
	}

	/**   
	 * @param logEntity  
	 * @see com.ketayao.ketacustom.service.LogEntityService#update(com.ketayao.ketacustom.entity.main.LogEntity)  
	 */
	@Override
	public void update(LogEntity logEntity) {
		logEntityMapper.updateByPrimaryKeySelective(logEntity);
	}

	/**   
	 * @param id  
	 * @see com.ketayao.ketacustom.service.LogEntityService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		logEntityMapper.deleteByPrimaryKey(id);
	}

}
