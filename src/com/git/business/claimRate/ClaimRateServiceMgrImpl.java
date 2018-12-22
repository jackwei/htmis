/**
 * 
 */
package com.git.business.claimRate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseClaimImplExample;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.ClaimIncomeImplExample;
import com.git.db.beans.ClaimRateSubImpl;
import com.git.db.beans.ClaimRateSubImplExample;
import com.git.db.beans.ClaimRateSubImplExample.Criteria;
import com.git.db.mapper.CaseClaimImplMapper;
import com.git.db.mapper.ClaimIncomeImplMapper;
import com.git.db.mapper.ClaimRateSubImplMapper;
import com.git.util.Jutil;
import com.git.util.service.SequenceService;


import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("claimRateServiceMgr")
public class ClaimRateServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements ClaimRateServiceMgr{

	@Autowired
	private ClaimIncomeImplMapper claimIncomeImplMapper;

	@Autowired
	private CaseClaimImplMapper caseClaimImplMapper;

	@Autowired
	private ClaimRateSubImplMapper claimRateSubImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	
	/**
	 * 根据案件号查询赔款信息
	 * */
	@SuppressWarnings("rawtypes")
	public Map<String,List> processClaimRate(Map criterias,BaseConditionVO vo) throws ServiceException{
		
		Map<String,List> map = new HashMap<String, List>();
		
		String casenumber = criterias.get("casenumber")== null ? "":criterias.get("casenumber").toString();
		
		if("".equals(casenumber)){
			return map;
		}else{
			List<ClaimIncomeImpl> ClaimIncomeList = this.searchClaimInCome(casenumber, true); 
			BigDecimal receivebd = BigDecimal.valueOf(0);
			
			for (ClaimIncomeImpl claimIncomeImpl : ClaimIncomeList) {
				receivebd = receivebd.add(BigDecimal.valueOf(claimIncomeImpl.getUsdamount()));
				String sql = "update tbl_claim_income set lockdate=NOW() where Income_Id="+claimIncomeImpl.getIncomeId();
				Jutil.updateSQL(sql);
			}
			
			List<CaseClaimImpl> CaseClaimList = this.searchCaseClaim(casenumber, true);  
			BigDecimal paybd = BigDecimal.valueOf(0);
			
			for (CaseClaimImpl caseClaimImpl : CaseClaimList) {
				paybd = paybd.add(BigDecimal.valueOf(caseClaimImpl.getUsdamount()));
				String sql = "update tbl_case_claim set lockdate=NOW() where Claim_Id="+caseClaimImpl.getClaimId();
				Jutil.updateSQL(sql);
			}
			
			if(paybd.subtract(receivebd).compareTo(BigDecimal.valueOf(0))!=0 ){
				ClaimRateSubImpl claimRateSubImpl =  new  ClaimRateSubImpl();
				claimRateSubImpl.setRateId(sequenceService.getSequence("rate_id"));
				claimRateSubImpl.setCasenumber(casenumber);
				claimRateSubImpl.setCurrency("USD");
				claimRateSubImpl.setCreateTime(new Date());
				claimRateSubImpl.setCratesub(paybd.subtract(receivebd).floatValue());
				claimRateSubImplMapper.insert(claimRateSubImpl);
			}else{
				throw new ServiceException("无汇差计录生成"); 
			}
			
			List<ClaimRateSubImpl> claimRateSubImplList = searchClaimRateByCaseNumber(casenumber);
			map.put("claimRateSubImplList", claimRateSubImplList);
			return map;
		}
		
	}
	
	public int updateClaimRateSub(ClaimRateSubImpl claimRateSubImpl){
		return claimRateSubImplMapper.updateByPrimaryKeySelective(claimRateSubImpl);
	}
	
	public int insertClaimRateSub(ClaimIncomeImpl claimIncomeImpl,CaseClaimImpl caseClaimImpl,float differamount,float rate,float usdamount){
		ClaimRateSubImpl claimRateSubImpl = new ClaimRateSubImpl();
		claimRateSubImpl.setRateId(sequenceService.getSequence("rate_id"));
		claimRateSubImpl.setCasenumber(claimIncomeImpl.getCasenumber());
		claimRateSubImpl.setBillId(Long.valueOf("0"));
		claimRateSubImpl.setBillnumber(caseClaimImpl.getBillnumber());
		claimRateSubImpl.setCurrency(caseClaimImpl.getRecordcurrency());
		claimRateSubImpl.setCratesub(differamount);
		claimRateSubImpl.setAccrate(rate);
		claimRateSubImpl.setAccamount(usdamount);
		claimRateSubImpl.setClaimid(caseClaimImpl.getClaimId());
		claimRateSubImpl.setIncomeid(claimIncomeImpl.getIncomeId());
		claimRateSubImpl.setClientname(caseClaimImpl.getClientname());
		claimRateSubImpl.setPayer(claimIncomeImpl.getPayer());
		claimRateSubImpl.setArrdate(claimIncomeImpl.getReceivedate());
		claimRateSubImpl.setAccdate(caseClaimImpl.getCreateTime());
		
		claimRateSubImpl.setCreateTime(new Date());
		return claimRateSubImplMapper.insertSelective(claimRateSubImpl);
	}
	
	public List<ClaimRateSubImpl> searchClaimRateByCaseNumber(String casenumber){
		List<ClaimRateSubImpl> claimRateSubImplList = new ArrayList<ClaimRateSubImpl>();
		ClaimRateSubImplExample example = new ClaimRateSubImplExample();
		Criteria criteria = example.createCriteria();
		criteria.andCasenumberEqualTo(casenumber);
		claimRateSubImplList = claimRateSubImplMapper.selectByExample(example);
		return claimRateSubImplList;
	}
	
	public List<ClaimRateSubImpl> searchClaimRate(Map criterias,BaseConditionVO vo){
		List<ClaimRateSubImpl> claimRateSubList = new ArrayList<ClaimRateSubImpl>();
		ClaimRateSubImplExample example = new ClaimRateSubImplExample();
		example.setOrderByClause(" rate_id desc ");
		Criteria criteria = example.createCriteria();
		if(null != criterias.get("casenumber") && !"".equals(criterias.get("casenumber"))){
			criteria.andCasenumberEqualTo(criterias.get("casenumber").toString());
		}
		
		if(criterias.get("billId") != null && !"".equals(criterias.get("billId"))){
			criteria.orBillId(criterias.get("billId").toString());
		}
		//int count = claimRateSubImplMapper.countByExample(example);
		//RowBounds rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		claimRateSubList = claimRateSubImplMapper.selectByExample(example);
		return claimRateSubList;
	}
	
	public List<CaseClaimImpl> searchCaseClaim(String casenumber,boolean isNull){
		CaseClaimImplExample cciExample = new CaseClaimImplExample();
		com.git.db.beans.CaseClaimImplExample.Criteria claim = cciExample.createCriteria();
		claim.andCasenumberEqualTo(casenumber);
		if(isNull==true){
			claim.andLockdateIsNull();
		}
		List<CaseClaimImpl> CaseClaimList =  caseClaimImplMapper.selectByExample(cciExample);
		return CaseClaimList;
	}
	
	public List<ClaimIncomeImpl> searchClaimInCome(String casenumber,boolean isNull){
		ClaimIncomeImplExample ciiExample = new ClaimIncomeImplExample();
		com.git.db.beans.ClaimIncomeImplExample.Criteria  inCome =ciiExample.createCriteria();
		inCome.andCasenumberEqualTo(casenumber);
		if(isNull==true){
			inCome.andLockdateIsNull();
		}
		List<ClaimIncomeImpl> ClaimIncomeList = claimIncomeImplMapper.selectByExample(ciiExample);
		return ClaimIncomeList;
	}
	
	public ClaimRateSubImpl getClaimRate(String rateId){
		ClaimRateSubImpl cc = claimRateSubImplMapper.selectByPrimaryKey(Long.valueOf(rateId));
		return cc;
	}
	
	public void del(String rateId){
		claimRateSubImplMapper.deleteByPrimaryKey(Long.valueOf(rateId));
	}
	
	public int getCount(){
		ClaimRateSubImplExample exa = new ClaimRateSubImplExample();
		return claimRateSubImplMapper.countByExample(exa);
	}


	
	
}
