/**
 * 
 */
package com.git.business.caseService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.sys.User;
import com.git.db.beans.CaseSuperviseImpl;
import com.git.db.beans.CaseSuperviseImplExample;
import com.git.db.beans.CaseSuperviseImplExample.Criteria;
import com.git.db.mapper.CaseSuperviseImplMapper;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("caseSuperviseMgr")
public class CaseSuperviseMgrImpl extends AbstractBusinessObjectServiceMgr implements CaseSuperviseMgr{

	@Autowired
	private CaseSuperviseImplMapper caseSuperviseImplMapper;
	
	@Autowired
	private SequenceService sequenceService;

	
	public int addSupervise(CaseSuperviseImpl caseSuperviseImpl){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		caseSuperviseImpl.setId(sequenceService.getSequence("Supervise"));
		caseSuperviseImpl.setName(user.getName());
		caseSuperviseImpl.setCreateTime(new Date());
		caseSuperviseImpl.setOperatorId(user.getId());
		return caseSuperviseImplMapper.insert(caseSuperviseImpl);
	}
	
	@SuppressWarnings("rawtypes")
	public Map<Object, Object> searchSupervise(Map criterias){
		Map<Object, Object> search = new HashMap<Object, Object>();
		
		//User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		CaseSuperviseImplExample example = new CaseSuperviseImplExample();
		Criteria  criteria = example.createCriteria();
		
		criteria.andCaseidEqualTo(Long.valueOf(criterias.get("caseId").toString()));
		
		int count = caseSuperviseImplMapper.countByExample(example);
		search.put("count", count);
		//RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		//example.or(criteria);
		List<CaseSuperviseImpl> CaseSuperviseImplList = caseSuperviseImplMapper.selectByExample(example);
		search.put("caseSuperviseImplList", CaseSuperviseImplList);
		return search;
	}
	
}
