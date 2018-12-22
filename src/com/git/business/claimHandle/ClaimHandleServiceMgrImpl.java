/**
 * 
 */
package com.git.business.claimHandle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseClaimImplExample;
import com.git.db.beans.ClaimInComeDetailImpl;
import com.git.db.beans.CaseClaimImplExample.Criteria;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.mapper.CaseClaimImplMapper;
import com.git.db.mapper.CaseInfoImplMapper;
import com.git.db.mapper.ClaimInComeDetailImplMapper;
import com.git.enums.ClaimStatus;
import com.git.enums.InComeStatus;
import com.git.util.PubDateUtil;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("claimHandleServiceMgr")
public class ClaimHandleServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements ClaimHandleServiceMgr{

	@Autowired
	private CaseInfoImplMapper caseInfoImplMapper;
	
	@Autowired
	private CaseClaimImplMapper caseClaimImplMapper;
	
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;
	
	@Autowired
	private ClaimInComeDetailImplMapper claimInComeDetailImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	/**
	 * 垫付赔款划付操作
	 * */
	public int updCaseClaim(CaseClaimImpl caseClaimImpl,HttpServletRequest request ){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);

		caseClaimImpl.setClaimId(Long.valueOf(request.getParameter("claimId")));
		caseClaimImpl.setTreatdate(PubDateUtil.stringToDate(request.getParameter("treatdate"), "yyyy-MM-dd"));

		if(request.getParameter("recordtype").equals("余款退回")){
			caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
			caseClaimImpl.setLockdate(new Date());
			caseClaimImpl.setTreatdate(new Date());
			
			ClaimIncomeImpl claimIncomeImpl=new ClaimIncomeImpl();
			claimIncomeImpl.setIncomeId(Long.valueOf(request.getParameter("remark1")));
			claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
			claimInComeServiceMgr.updateClaimIncome(claimIncomeImpl);
			
		}else{
			caseClaimImpl.setStatus(ClaimStatus.ClaimFee3.getCode());
		}
		
		caseClaimImpl.setBillId((long)0);
		caseClaimImpl.setRemark(request.getParameter("remark"));
		caseClaimImpl.setModifyTime(new Date());
		caseClaimImpl.setModifyOperatorId(user.getId());
		
		//登记时间为赔款划付时的当前时间。
		caseClaimImpl.setTransferdate(new Date());
		
		//添加划付币种及金额 1210
		caseClaimImpl.setCurrency(request.getParameter("currency"));
		if(request.getParameter("currency").equals("RMB")){
			caseClaimImpl.setUsdamount(Float.valueOf(request.getParameter("realamount"))/Float.valueOf(request.getParameter("usdrate")));
		}else{
			caseClaimImpl.setUsdamount(Float.valueOf(request.getParameter("realamount")));
		}
		caseClaimImpl.setRealamount(Float.valueOf(request.getParameter("realamount")));
		caseClaimImpl.setUsdrate(new BigDecimal(request.getParameter("usdrate")));
		
		return caseClaimImplMapper.updateByPrimaryKeySelective(caseClaimImpl);
	}
	
	public int updateCaseClaim(CaseClaimImpl caseClaimImpl){
		return caseClaimImplMapper.updateByPrimaryKeySelective(caseClaimImpl);
	}
	
	public int insertClaimInComeDetail(ClaimIncomeImpl claimIncomeImpl,CaseClaimImpl caseClaimImpl,float checkamount){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		
		ClaimInComeDetailImpl claimInComeDetailImpl = new ClaimInComeDetailImpl();
		claimInComeDetailImpl.setDetailId(sequenceService.getSequence("ClaimInComeDetailImpl"));
		claimInComeDetailImpl.setCasenumber(claimIncomeImpl.getCasenumber());
		claimInComeDetailImpl.setCheckamount(checkamount);
		claimInComeDetailImpl.setClaimId(caseClaimImpl.getClaimId());
		claimInComeDetailImpl.setClientname(caseClaimImpl.getClientname());
		claimInComeDetailImpl.setPayer(claimIncomeImpl.getPayer());
		claimInComeDetailImpl.setIncomeId(claimIncomeImpl.getIncomeId());
		claimInComeDetailImpl.setRealamount(caseClaimImpl.getRealamount());
		claimInComeDetailImpl.setRecordtype(caseClaimImpl.getRecordtype());
		claimInComeDetailImpl.setTotalamount(claimIncomeImpl.getTotalamount());
		claimInComeDetailImpl.setCreateOperator(user.getId());
		claimInComeDetailImpl.setCreateTime(new Date());
		
		return claimInComeDetailImplMapper.insert(claimInComeDetailImpl);
	}
	
	/**
	 * 根据案件号查询赔款信息
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map searchCaseClaim(Map criterias,BaseConditionVO vo){
		Map search = new HashMap();
		List<CaseClaimImpl> caseClaimList = new ArrayList<CaseClaimImpl>();
		CaseClaimImplExample example = new CaseClaimImplExample();
		example.setOrderByClause("casenumber desc");
		Criteria  criteria = example.createCriteria();
		
		if(null != criterias.get("casenumber") && !"".equals(criterias.get("casenumber"))){
			criteria.andCasenumberLike("%"+criterias.get("casenumber").toString()+"%");
		}
		if(null != criterias.get("shipname") && !"".equals(criterias.get("shipname"))){
			criteria.andShipnameLike("%"+criterias.get("shipname").toString()+"%");
		}
		if(null != criterias.get("clientname") && !"".equals(criterias.get("clientname"))){
			criteria.andClientnameLike("%"+criterias.get("clientname").toString()+"%");
		}
		if(null != criterias.get("recordtype") && !"".equals(criterias.get("recordtype"))){
			criteria.andRecordtypeEqualTo(criterias.get("recordtype").toString());
		}
		
		if(null != criterias.get("status") && !"".equals(criterias.get("status"))){
			criteria.andStatusEqualTo(criterias.get("status").toString());
		}
		
		int count = caseClaimImplMapper.countByExample(example);
		RowBounds rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		caseClaimList = caseClaimImplMapper.selectByExampleWithRowbounds(example, rowBounds);
		search.put("caseClaimList", caseClaimList);
		search.put("count", count);
		
		return search;
	}
	
	public CaseClaimImpl getCaseClaim(String claimId){
		CaseClaimImpl cc = caseClaimImplMapper.selectByPrimaryKey(Long.valueOf(claimId));
		return cc;
	}
	
	public void delCaseInfo(String caseId){
		caseInfoImplMapper.deleteByPrimaryKey(Long.valueOf(caseId));
	}
	
	public int getCount(){
		CaseClaimImplExample exa = new CaseClaimImplExample();
		Criteria critera = exa.createCriteria();
		critera.andLockdateIsNull();
		return caseClaimImplMapper.countByExample(exa);
	}


	
	
}
