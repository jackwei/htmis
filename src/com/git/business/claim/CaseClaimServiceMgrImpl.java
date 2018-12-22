/**
 * 
 */
package com.git.business.claim;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.ApplyInfos;
import com.git.business.sys.Org;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillCheckImplExample.Criterion;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseClaimImplExample;
import com.git.db.beans.CaseClaimImplExample.Criteria;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.mapper.CaseClaimImplMapper;
import com.git.db.mapper.CaseInfoImplMapper;
import com.git.db.mapper.ClaimIncomeImplMapper;
import com.git.enums.ClaimStatus;
import com.git.enums.InComeStatus;
import com.git.util.Jutil;
import com.git.util.PubDateUtil;
import com.git.util.StrTool;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("caseClaimServiceMgr")
public class CaseClaimServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements CaseClaimServiceMgr{

	@Autowired
	private CaseInfoImplMapper caseInfoImplMapper;
	
	@Autowired
	private CaseClaimImplMapper caseClaimImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private ApplyInfoServiceMgr applyInfoServiceMgr;
	
	@Autowired
	private ClaimIncomeImplMapper claimIncomeImplMapper;
	
	public int updateCaseClaim(CaseClaimImpl caseClaimImpl){
		 return caseClaimImplMapper.updateByPrimaryKeySelective(caseClaimImpl);
	}
	/**
	 * 添加/修改赔款登记
	 * */
	public boolean updCaseClaim(CaseClaimImpl caseClaimImpl,HttpServletRequest request,ApplyInfos applyInfos){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		Org org = (Org)request.getSession().getAttribute(Constants.ORGCODE_KEY);
		try
		{
			if(null==request.getParameter("claimId") || "".equals(request.getParameter("claimId"))){
				caseClaimImpl.setClaimId(sequenceService.getSequence("claim_id"));
				caseClaimImpl.setCreateTime(new Date());
				caseClaimImpl.setCreateOperator(user.getId());
				caseClaimImpl.setModifyTime(new Date());
				caseClaimImpl.setModifyOperatorId(user.getId());
				
			}else{
				caseClaimImpl.setClaimId(Long.valueOf(request.getParameter("claimId")));
				caseClaimImpl.setModifyTime(new Date());
				caseClaimImpl.setModifyOperatorId(user.getId());
			}
			caseClaimImpl.setStatus(ClaimStatus.ClaimFee0.getCode());
			caseClaimImpl.setCaseId(Long.valueOf(request.getParameter("caseId")));
			caseClaimImpl.setCasenumber(request.getParameter("casenumber"));
			caseClaimImpl.setShipname(request.getParameter("shipname"));
			caseClaimImpl.setClientname(request.getParameter("clientname"));
//			caseClaimImpl.setApplycurrency(request.getParameter("applycurrency"));
			caseClaimImpl.setRecordtype(request.getParameter("recordtype"));
//			caseClaimImpl.setApplyamount(Float.valueOf(request.getParameter("applyamount")));
			caseClaimImpl.setRemark(request.getParameter("remark"));	
			caseClaimImpl.setRemark1(request.getParameter("IncomeId"));
			caseClaimImpl.setApplybanknum(request.getParameter("applybanknum"));
			caseClaimImpl.setApplybank(request.getParameter("applybank"));
			caseClaimImpl.setBranch(request.getParameter("branch"));
			caseClaimImpl.setPayee(request.getParameter("payee"));
			caseClaimImpl.setThingcause(request.getParameter("thingcause"));
			caseClaimImpl.setIncaseno(request.getParameter("orgLookup.caseno"));
			String feetype=request.getParameter("advancefeetype");
			if("0".equals(feetype)){
				feetype="";
			}
			
			//到账金额币种
			caseClaimImpl.setAdvancefeetype(feetype);
			if(request.getParameter("transfermount")!=null && !"".equals(request.getParameter("transfermount"))){
				caseClaimImpl.setTransfermount(Float.valueOf(request.getParameter("transfermount")));
			}
			caseClaimImpl.setTransfercurrency(request.getParameter("transfercurrency"));
			
			//赔偿/垫付款/转为收入金额
			if(request.getParameter("recordmount")!=null && !"".equals(request.getParameter("recordmount"))){
				caseClaimImpl.setRecordmount(Float.valueOf(request.getParameter("recordmount")));
				caseClaimImpl.setDifferamount(Float.valueOf(request.getParameter("recordmount")));
			}
			caseClaimImpl.setRecordcurrency(request.getParameter("recordcurrency"));
			
			//划付金额
			if(request.getParameter("realamount")!=null && !"".equals(request.getParameter("realamount"))){
				caseClaimImpl.setRealamount(Float.valueOf(request.getParameter("realamount")));
			}
			//划付币种
			caseClaimImpl.setCurrency(request.getParameter("currency"));
			
			String type=request.getParameter("recordtype");
			
			if(null==request.getParameter("claimId") || "".equals(request.getParameter("claimId"))){//新增操作
			  	 caseClaimImplMapper.insert(caseClaimImpl);
			  	 
				//创建呈批件编号生成规则
				SimpleDateFormat sd = new SimpleDateFormat("yy");
				Date date = new Date();
				String yearstr = sd.format(date);
				String	applynumber = sequenceService.getSequence("applynumber", "HTRC", yearstr, "", 6, '0', 'L');
				
				applyInfos.setApplytype("caseClaim");
				applyInfos.setSqnumber(applynumber);				
				applyInfos.setParentid(caseClaimImpl.getClaimId());//赔款登记ID
				applyInfos.setCreatdate(new Date());
				applyInfos.setStatus("new");
				applyInfos.setName("("+caseClaimImpl.getCasenumber()+")"+caseClaimImpl.getShipname());
				applyInfos.setOrgname(org.getOrgName());
				applyInfos.setUserid(String.valueOf(user.getId()));
				applyInfos.setUsername(user.getName());
				//如果币种不是人民币需转换 
				//取赔偿（垫付款）币种和赔偿（垫付款）金额  --1210 lw
				
				applyInfos.setAmounta(BigDecimal.valueOf(caseClaimImpl.getRecordmount()==null?0:caseClaimImpl.getRecordmount()));
				applyInfos.setApplydes(caseClaimImpl.getClientname()+"("+caseClaimImpl.getRecordcurrency()+":"+caseClaimImpl.getRecordmount()+")");
				applyInfos.setCurrency(caseClaimImpl.getRecordcurrency());
				
				applyInfos.setOrgid(Jutil.getOrgCodeByCaseId(caseClaimImpl.getCaseId()));
				applyInfos.setDeleted("0");
				applyInfos.setStep(0);
				applyInfos.setRemarkb("0");
								
				applyInfoServiceMgr.addApplyInfos(applyInfos);
				
				if(request.getParameter("recordtype").equals("D")){
					ClaimIncomeImpl claimIncomeImpl=new ClaimIncomeImpl();
					claimIncomeImpl.setIncomeId(Long.valueOf(request.getParameter("IncomeId")));
					claimIncomeImpl.setStatus(InComeStatus.ClaimFee0.getCode());
					claimIncomeImpl.setIslocked("yes");
					claimIncomeImplMapper.updateByPrimaryKeySelective(claimIncomeImpl);
				}
//			  }else{
//				  return false;
//			  }
			}else{//修改操作
				
				applyInfos = applyInfoServiceMgr.selectByParentId(caseClaimImpl.getClaimId());
				//取赔偿（垫付款）币种和赔偿（垫付款）金额  ----1210 lw
				
				applyInfos.setAmounta(BigDecimal.valueOf(caseClaimImpl.getRecordmount()==null?0:caseClaimImpl.getRecordmount()));
				applyInfos.setApplydes(caseClaimImpl.getClientname()+"("+caseClaimImpl.getRecordcurrency()+":"+caseClaimImpl.getRecordmount()+")");
				applyInfos.setCurrency(caseClaimImpl.getRecordcurrency());
			
				applyInfos.setOrgname(org.getOrgName());
				applyInfos.setUserid(String.valueOf(user.getId()));
				applyInfos.setUsername(user.getName());
				applyInfoServiceMgr.updateApplyInfosById(applyInfos);
				
				caseClaimImplMapper.updateByPrimaryKeySelective(caseClaimImpl);			 
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 根据案件号查询赔款信息
	 * */
	@SuppressWarnings("rawtypes")
	public List<CaseClaimImpl> searchCaseClaim(Map criterias,BaseConditionVO vo){
		List<CaseClaimImpl> caseClaimList = new ArrayList<CaseClaimImpl>();
		CaseClaimImplExample example = new CaseClaimImplExample();
		Criteria  criteria = example.createCriteria();
		criteria.andCaseIdEqualTo(StrTool.getLong(criterias.get("caseId")));
		RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		caseClaimList = caseClaimImplMapper.selectByExample(example);
		return caseClaimList;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map searchCaseClaimByCondition(Map criterias,BaseConditionVO vo){
		Map search = new HashMap();
		List<CaseClaimImpl> caseClaimList = new ArrayList<CaseClaimImpl>();
		CaseClaimImplExample example = new CaseClaimImplExample();
		example.setOrderByClause("casenumber desc");
		Criteria  criteria = example.createCriteria();
		if(null != criterias.get("casenumber") && !"".equals(criterias.get("casenumber"))){
			criteria.andCasenumberEqualTo(criterias.get("casenumber").toString());
		}
		if(null != criterias.get("shipname") && !"".equals(criterias.get("shipname"))){
			criteria.andShipnameEqualTo(criterias.get("shipname").toString());
		}
		if(null != criterias.get("clientname") && !"".equals(criterias.get("clientname"))){
			criteria.andClientnameEqualTo(criterias.get("clientname").toString());
		}
		if(null != criterias.get("recordtype") && !"".equals(criterias.get("recordtype"))){
			criteria.andRecordtypeEqualTo(criterias.get("recordtype").toString());
		}
		
		if(null != criterias.get("billId") && !"".equals(criterias.get("billId"))){
			criteria.orBillId(criterias.get("billId").toString());
		}
		
		if(null != criterias.get("flag") && "nolock".equals(criterias.get("flag"))){
			criteria.andLockdateIsNull();
		}else if(null != criterias.get("flag") && "lock".equals(criterias.get("flag"))){
			criteria.andLockdateIsNotNull();
		}
		int count = caseClaimImplMapper.countByExample(example);
		RowBounds rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		//caseClaimList = caseClaimImplMapper.selectByExampleWithRowbounds(example, rowBounds);
		caseClaimList = caseClaimImplMapper.selectByExample(example);
		search.put("caseClaimList", caseClaimList);
		search.put("count", count);
		
		return search;
	}
	
	/**查询*/
	public List<CaseClaimImpl> searchCaseClaimByBillId(String billId,BaseConditionVO vo){
		CaseClaimImplExample example = new CaseClaimImplExample();
		example.setOrderByClause("casenumber desc");
		Criteria  criteria = example.createCriteria();
		criteria.orBillId(billId);
		criteria.andStatusEqualTo(ClaimStatus.ClaimFee3.getCode());
		List<CaseClaimImpl> caseClaimList = caseClaimImplMapper.selectByExample(example);
		
		return caseClaimList;
	}
	
	/**
	 * 查询已审批通过并划付完成的垫付费用
	 * */
	public Map searchCaseClaimByStatus(Map criterias,BaseConditionVO vo){
		Map search = new HashMap();
		List<CaseClaimImpl> caseClaimList = new ArrayList<CaseClaimImpl>();
		CaseClaimImplExample example = new CaseClaimImplExample();
		example.setOrderByClause("casenumber desc");
		Criteria  criteria = example.createCriteria();
		if(null != criterias.get("casenumber") && !"".equals(criterias.get("casenumber"))){
			criteria.andCasenumberEqualTo(criterias.get("casenumber").toString());
		}
		
		if(null != criterias.get("recordtype") && !"".equals(criterias.get("recordtype"))){
			criteria.andRecordtypeEqualTo(criterias.get("recordtype").toString());
		}
		
		if(null != criterias.get("billId") && !"".equals(criterias.get("billId"))){
			if(criterias.get("billId").toString().equals("0")){
				criteria.andBillIdEqualTo(Long.valueOf(criterias.get("billId").toString()));
			}else{
				criteria.orBillId(criterias.get("billId").toString());
			}
		}
		
		criteria.andStatusEqualTo(ClaimStatus.ClaimFee3.getCode());
		
		int count = caseClaimImplMapper.countByExample(example);
		//RowBounds rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		//caseClaimList = caseClaimImplMapper.selectByExampleWithRowbounds(example, rowBounds);
		caseClaimList = caseClaimImplMapper.selectByExample(example);
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
		return caseClaimImplMapper.countByExample(exa);
	}

	/**
	 * 删除赔款登记信息
	 */
	public void delCaseClaimInfo(String claimId) {
		caseClaimImplMapper.deleteByPrimaryKey(Long.valueOf(claimId));
	}
	
	/**
	 * 根据案件id查询赔款信息
	 */
	@Override
	public List<CaseClaimImpl> searchCaseClaimByCaseId(String caseId) {
		
		CaseClaimImplExample example = new CaseClaimImplExample();
		Criteria  criteria = example.createCriteria();
		criteria.andCaseIdEqualTo(Long.valueOf(caseId));
		criteria.andRecordtypeNotEqualTo("D");
		List<CaseClaimImpl> caseClaimList =  caseClaimImplMapper.selectByExample(example);
		
		/*List caseClaimList1 = new ArrayList();
		String sql="SELECT Claim_Id,Case_Id,casenumber,shipname,clientname,recordtype,currency,realamount,treatdate,status FROM tbl_case_claim WHERE  Case_Id='"+caseId+"' AND recordtype not in('D') ";
		caseClaimList1=Jutil.executeSQL(sql.toString());
		List<CaseClaimImpl> caseClaimList=new ArrayList<CaseClaimImpl>();
		for(int i=0;i<caseClaimList1.size();i++){
			Map map=(Map) caseClaimList1.get(i);
			CaseClaimImpl caseClaim=new CaseClaimImpl();
			caseClaim.setStatus(map.get("status").toString());
			caseClaim.setRecordtype(Jutil.getDictName("recordtype", map.get("recordtype").toString()));
			caseClaim.setCaseId(Long.valueOf(map.get("Case_Id").toString()));
			caseClaim.setCasenumber(map.get("casenumber").toString());
			caseClaim.setClaimId(Long.valueOf(map.get("Claim_Id").toString()));
			caseClaim.setClientname(map.get("clientname").toString());
			caseClaim.setCurrency(map.get("currency").toString());
			caseClaim.setShipname(map.get("shipname").toString());
			caseClaim.setRealamount(map.get("realamount") == null ? 0:Float.valueOf(map.get("realamount").toString()));
			if(map.get("treatdate")!=null){
				caseClaim.setTreatdate(PubDateUtil.stringToDate(map.get("treatdate").toString(), "yyyy-MM-dd"));
			}
			caseClaimList.add(caseClaim);
		}*/
		
		return caseClaimList;
	}
	
	public void delCaseClaimByIncomeId(String incomeId) {
		caseClaimImplMapper.deleteByIncomeId(incomeId);
	}
}
