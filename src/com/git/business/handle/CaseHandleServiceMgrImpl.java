/**
 * 
 */
package com.git.business.handle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.caseService.CaseServiceMgr;
import com.git.business.caseService.CaseServiceMgrImpl;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseHandleImpl;
import com.git.db.beans.CaseHandleImplExample;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.mapper.CaseHandleImplMapper;
import com.git.util.StrTool;
import com.git.util.service.SequenceService;
import com.wabacus.system.dataset.sqldataset.GetPartDataSetByPreparedSQL;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("caseHandleServiceMgr")
public class CaseHandleServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements CaseHandleServiceMgr{

	@Autowired
	private CaseHandleImplMapper caseHandleImplMapper;
	
	@Autowired
	private CaseServiceMgr caseServiceMgr;
	
	@Autowired
	private SequenceService sequenceService;
	
	/**
	 * 添加赔款登记
	 * */
	public int updCaseHandle(CaseHandleImpl caseHandleImpl,HttpServletRequest request ){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		
		if("".equals(request.getParameter("seqId")) || null==request.getParameter("seqId")){
			caseHandleImpl.setSeqId(sequenceService.getSequence("seq_id"));
			caseHandleImpl.setCreateTime(new Date());
			caseHandleImpl.setCreateOperator(user.getId());
		}else{
			caseHandleImpl.setSeqId(Long.valueOf(request.getParameter("seqId")));
			caseHandleImpl.setModifyTime(new Date());
			caseHandleImpl.setModifyOperatorId(user.getId());
		}
		caseHandleImpl.setCaseId(Long.valueOf(request.getParameter("caseId")));
		
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(request.getParameter("caseId"));
		
		String sname = request.getParameter("userLookup.sname");
		if(sname !=null && !"".equals(sname)){
			int ck = caseInfoImpl.getExcasenumber().indexOf(sname);
			String excasenumber = caseInfoImpl.getExcasenumber();
			if(ck == -1){
				excasenumber = caseInfoImpl.getExcasenumber().concat(sname);
			}
			caseInfoImpl.setExcasenumber(excasenumber);
			caseServiceMgr.updateCase(caseInfoImpl);
		}
		
		//查找带回
		String orgCode = request.getParameter("orgLookup.id");
		if(orgCode != null && !"".equals(orgCode))
		{
			caseHandleImpl.setOrgid(orgCode);
			caseHandleImpl.setOrgname(request.getParameter("orgLookup.extend1"));
		}
		
		//查找带回		
		String userId = request.getParameter("userLookup.id");
		if(userId !=null && !"".equals(userId))
		{
			caseHandleImpl.setUsername(request.getParameter("userLookup.name"));
			caseHandleImpl.setUserId(Long.valueOf(userId));
		}
		
		if("".equals(request.getParameter("seqId")) || null==request.getParameter("seqId")){
			return caseHandleImplMapper.insert(caseHandleImpl);
		}else{
			return caseHandleImplMapper.updateByPrimaryKeySelective(caseHandleImpl);
		}
	}
	
	/**
	 * 根据案件号查询协办人信息
	 * */
	@SuppressWarnings("rawtypes")
	public List<CaseHandleImpl> searchCaseHandle(Map criterias,BaseConditionVO vo){
		List<CaseHandleImpl> caseHandleList = new ArrayList<CaseHandleImpl>();
		CaseHandleImplExample example = new CaseHandleImplExample();
		example.createCriteria().andCaseIdEqualTo(StrTool.getLong(criterias.get("caseId")));
		
		RowBounds rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		caseHandleList = caseHandleImplMapper.selectByExampleWithRowbounds(example, rowBounds);
		
		return caseHandleList;
	}
	
	public CaseHandleImpl getCaseHandle(String claimId){
		CaseHandleImpl ch = caseHandleImplMapper.selectByPrimaryKey(Long.valueOf(claimId));
		return ch;
	}
	
	public int delCaseHandle(String seqId){
		return caseHandleImplMapper.deleteByPrimaryKey(Long.valueOf(seqId));
	}
	
	public int getCount(){
		CaseHandleImplExample exa = new CaseHandleImplExample();
		return caseHandleImplMapper.countByExample(exa);
	}


	
	
}
