/**
 * 
 */
package com.git.business.caseService;

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

import com.git.business.billService.BillCheckServiceMgr;
import com.git.business.claim.CaseClaimServiceMgr;
import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.claimRate.ClaimRateServiceMgr;
import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillCheckImpl;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillDetailImplExample;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseBillImplExample;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseBillImplExample.Criteria;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.mapper.CaseBillDetailImplMapper;
import com.git.db.mapper.CaseBillImplMapper;
import com.git.enums.AccFlagStatus;
import com.git.enums.AccStatus;
import com.git.enums.CaseStatus;
import com.git.enums.ClaimStatus;
import com.git.enums.PClientStatus;
import com.git.util.CommonUtil;
import com.git.util.MMap;
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
@Service("caseBillServiceMgr")
public class CaseBillServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements CaseBillServiceMgr{

	@Autowired
	private CaseBillImplMapper caseBillImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private CaseServiceMgr caseServiceMgr;
	
	@Autowired
	private BillCheckServiceMgr billCheckServiceMgr;
	
	@Autowired
	private CaseBillDetailServiceMgr caseBillDetailServiceMgr;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;
	
	@Autowired
	private ClaimRateServiceMgr claimRateServiceMgr;
	
	@Autowired
	private CaseClaimServiceMgr caseClaimServiceMgr;
	
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;
	
	/** 
	 * 添加账单
	 */
	public void addCaseBill(CaseBillImpl caseBillImpl){
		caseBillImplMapper.insert(caseBillImpl);
	}
	
	public int updateCaseBill(CaseBillImpl caseBillImpl){
		return caseBillImplMapper.updateByPrimaryKeySelective(caseBillImpl);
	} 
	
	/**
	 * 修改账单
	 * */
	public int updCaseBill(CaseBillImpl caseBillImpl) throws ServiceException{
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(request.getParameter("caseId"));
		if(null == request.getParameter("billId") || "".equals(request.getParameter("billId"))){
			caseBillImpl.setBillId(sequenceService.getSequence("Bill_Id"));
			
			//账单号生成规则
			long feecount = caseInfoImpl.getFeecount();
			feecount++;
			String feeNumber= caseInfoImpl.getCasenumber()+"_"+feecount;
			caseBillImpl.setFeenumber(feeNumber);
			caseInfoImpl.setFeecount(feecount);
			caseBillImpl.setFeestatuse(AccStatus.AccNew.getCode());
			caseBillImpl.setFeetype("service");
			caseBillImpl.setCasenumber(caseInfoImpl.getCasenumber());
			caseBillImpl.setCaseId(caseInfoImpl.getCaseId());
			caseBillImpl.setServicefee(Float.valueOf(request.getParameter("servicefee")));
			caseBillImpl.setExpendses(Float.valueOf(request.getParameter("expendses")));
			caseBillImpl.setAssurefee(Float.valueOf(0));
			caseBillImpl.setOperatorId(user.getId());
			caseBillImpl.setCreateTime(new Date());
			
			//未到账金额
//			BigDecimal replaceAmount = new BigDecimal(0);
//			replaceAmount = BigDecimal.valueOf(caseBillImpl.getCompensationsub()).add(BigDecimal.valueOf(caseBillImpl.getThirdpart()).add(BigDecimal.valueOf(caseBillImpl.getOtherfee())));
			caseBillImpl.setReplaceamount(Float.valueOf(request.getParameter("feeamount")));
			
			caseServiceMgr.updateCase(caseInfoImpl);
			
		}else{
			
			if("2".equals(caseBillImpl.getFeestatuse())) {
				throw new ServiceException("已到账不可修改！！");
			}
			
			if("1".equals(caseBillImpl.getFeestatuse())) {
				
				BillCheckImpl billCheckImpl =billCheckServiceMgr.getBillCheckByBillId(caseBillImpl.getBillId().toString());
				
				billCheckImpl.setFeenum(caseBillImpl.getFeenumber());
				billCheckImpl.setCurrency(caseBillImpl.getCurrency());
				billCheckImpl.setExpends(caseBillImpl.getExpendses());
				billCheckImpl.setIncome(caseBillImpl.getServicefee());
				BigDecimal replaceAmount = new BigDecimal(0);
				replaceAmount = BigDecimal.valueOf(caseBillImpl.getAssurefee()).add(BigDecimal.valueOf(caseBillImpl.getCompensationsub())).add(BigDecimal.valueOf(caseBillImpl.getThirdpart()).add(BigDecimal.valueOf(caseBillImpl.getOtherfee())));
				billCheckImpl.setReplaceamount(replaceAmount.floatValue());
				billCheckImpl.setFeeamount(caseBillImpl.getFeeamount());
				billCheckImpl.setDifferamount(caseBillImpl.getFeeamount());
				billCheckImpl.setChangedate(new Date());
				
				billCheckServiceMgr.updBillCheck(billCheckImpl);

			}
			
			caseBillImpl.setBillId(Long.valueOf(request.getParameter("billId")));
			caseBillImpl.setFeenumber(request.getParameter("feenumber"));
			caseBillImpl.setModifyOperatorId(user.getId());
			caseBillImpl.setModifyTime(new Date());
			caseBillImpl.setServicefee(Float.valueOf(request.getParameter("servicefee")));
			caseBillImpl.setExpendses(Float.valueOf(request.getParameter("expendses")));
			
			caseBillImpl.getFeestatuse();
			float allfee = caseBillImpl.getServicefee()+caseBillImpl.getAdvancefee()+caseBillImpl.getOtherfee()+caseBillImpl.getExpendses()+caseBillImpl.getThirdpart();
			List<Map> claimList = claimInComeServiceMgr.searchClaimIncomeByBillId(caseBillImpl.getBillId().toString());
			Float diffamount = (float)0.0; //获取当前账单总赔款余额
			Float remark1 = (float)0.0; //获取未使用的赔款余额
			
			for (Map map : claimList) {
				map.get("Income_Id");
				diffamount += Float.valueOf(map.get("differamount").toString());
				remark1 +=map.get("remark1") == null ? Float.valueOf("0"): Float.valueOf(map.get("remark1").toString());
			}
			
			if(diffamount > allfee){
				caseBillImpl.setCompensationsub(allfee*-1);
				caseBillImpl.setFeeamount(Float.valueOf("0"));
				caseBillImpl.setReplaceamount(Float.valueOf("0"));
			}else if(diffamount < allfee){
				caseBillImpl.setCompensationsub(diffamount*-1);
				caseBillImpl.setFeeamount(allfee-diffamount);
				caseBillImpl.setReplaceamount(allfee-diffamount);
			}
			
		}
		
		caseBillImpl.setPayer(request.getParameter("payer"));
		caseBillImpl.setConame(request.getParameter("coname"));
		caseBillImpl.setAddress(request.getParameter("address"));
		
		//担保费用
		//caseBillImpl.setAssurefee(Float.valueOf(request.getParameter("assurefee"))); 
		
		caseBillImpl.setOtherfee(Float.valueOf(request.getParameter("otherfee")));
		caseBillImpl.setThirdpart(Float.valueOf(request.getParameter("thirdpart")));
		
		caseBillImpl.setAdvancefee(Float.valueOf(request.getParameter("advancefee")));
		
		
		caseBillImpl.setCurrency(request.getParameter("currency"));
		caseBillImpl.setServicedes(request.getParameter("servicedes"));
		
		/*if(Float.valueOf(request.getParameter("feeamount")) ==0){
			throw new ServiceException("总金额不能为0");
		}*/
		
		//caseBillImpl.setFeeamount(Float.valueOf(request.getParameter("feeamount")));
		caseBillImpl.setOrgcode(caseInfoImpl.getOrgcode());
		caseBillImpl.setOrgname(caseInfoImpl.getOraname());
		
		caseBillImpl.setRemark(request.getParameter("remark"));
		
		if(null == request.getParameter("billId") || "".equals(request.getParameter("billId"))){
			return caseBillImplMapper.insert(caseBillImpl);
		}else{
			return caseBillImplMapper.updateByPrimaryKeySelective(caseBillImpl);
		}
	}
	
	/** 
	 * 获取所有案件账单
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List<CaseBillImpl> searchCaseBill(Map criterias,	BaseConditionVO vo){
		List<CaseBillImpl> caseBillList = new ArrayList<CaseBillImpl>();
		CaseBillImplExample example = new CaseBillImplExample();
		Criteria criteria = example.createCriteria();
		//判断该案件下账单
		if(null != criterias.get("caseId") && !"".equals(criterias.get("caseId"))){
			criteria.andCaseIdEqualTo(StrTool.getLong(criterias.get("caseId")));
		}
		
		//搜索查询条件
		if(null != criterias.get("feenumber") && !"".equals(criterias.get("feenumber"))){
			criteria.andFeenumberLike("%"+String.valueOf(criterias.get("feenumber"))+"%");
		}
		
		if(null != criterias.get("feestatuse") && !"".equals(criterias.get("feestatuse"))){
			criteria.andFeestatuseEqualTo(String.valueOf(criterias.get("feestatuse")));
		}
		
		if(null != criterias.get("currency") && !"".equals(criterias.get("currency"))){
			criteria.andCurrencyEqualTo(String.valueOf(criterias.get("caseId")));
		}
		
		if(null != criterias.get("accdate1") && !"".equals(criterias.get("accdate1"))){
			criteria.andAccdateGreaterThanOrEqualTo(PubDateUtil.stringToDate(criterias.get("accdate1").toString(), "yyyy-MM-dd"));
		}
		
		if(null != criterias.get("accdate2") && !"".equals(criterias.get("accdate2"))){
			criteria.andAccdateLessThanOrEqualTo(PubDateUtil.stringToDate(criterias.get("accdate2").toString(), "yyyy-MM-dd"));		
		}
		
//		//判断担保费用大于0为账单
////		System.out.println("担保标识："+criterias.get("assurefeeflag"));
//		if("1".equals(String.valueOf(criterias.get("assurefeeflag")))){
////			System.out.println("判断成功！");
//			criteria.andAssurefeeGreaterThan(Float.valueOf("0.0"));
//		}
		
		//判断账单类型为assurebill的为担保账单
		if("1".equals(String.valueOf(criterias.get("assurefeeflag")))){
//			criteria.andFeetypeEqualTo("assurebill");
			criteria.andFeetypeEqualTo("assure");
		}
		
		RowBounds rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize());
		caseBillList = caseBillImplMapper.selectByExampleWithRowbounds(example, rowBounds);
		
		return caseBillList;
	}
	
	
	public List<CaseBillImpl> searchCaseBillByCaseId(String caseId){
		CaseBillImplExample cbi = new CaseBillImplExample();
		Criteria criteria = cbi.createCriteria();
		criteria.andCaseIdEqualTo(Long.valueOf(caseId));
		return caseBillImplMapper.selectByExample(cbi);
	}
	
	/**
	 * 获取当前案件账单
	 * */
	public CaseBillImpl getCaseBill(String billId){
		CaseBillImpl caseBillImpl = caseBillImplMapper.selectByPrimaryKey(Long.valueOf(billId));
		return caseBillImpl;
		
	}
	
	public int processSendBill(CaseBillImpl caseBillImpl) throws ServiceException{
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		
		if(!CommonUtil.isEmpty(caseBillImpl.getArrdate())){
			throw new ServiceException("账单已到账!"); 
		}
		
		if(caseBillImpl.getFeestatuse().equals(AccStatus.AccSubmit.getCode())){
			throw new ServiceException("不用重复发账!");
		}
		
		List<Map> claimList = claimInComeServiceMgr.searchClaimIncomeByBillId(caseBillImpl.getBillId().toString());

		if(caseBillImpl.getFeeamount() < 0 ){
			if(claimList.size() < 0){
				throw new ServiceException("该账单为负账单，必须包含汇款余额 !");
			}
			
		}
		
		if(caseBillImpl.getFeeamount() == 0 && claimList.size() <=0 ){
			throw new ServiceException("该账单为金额为0，必须包含汇款余额 !");
		}
		
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseBillImpl.getCaseId().toString());
		
		caseInfoImpl.setAccflag(AccFlagStatus.AccFlag2.getCode());
		if("AccPart".equals(request.getParameter("caseStatus"))){
			caseInfoImpl.setCasestatus(CaseStatus.CaseAccPart.getCode());
		}else if("AccFinal".equals(request.getParameter("caseStatus"))){
			caseInfoImpl.setCasestatus(CaseStatus.CaseAccFinal.getCode());
		}
		
		if(caseBillImpl.getFeeamount() == 0 && claimList.size() >0){
			caseBillImpl.setAccdate(new Date());
			caseBillImpl.setArrdate(new Date());
			caseBillImpl.setFeestatuse(AccStatus.AccNut.getCode());
			
			float allfee = caseBillImpl.getServicefee()+caseBillImpl.getAdvancefee()+caseBillImpl.getOtherfee()+caseBillImpl.getExpendses()+caseBillImpl.getThirdpart();

			for (Map map : claimList) {
				String inComeId = map.get("Income_Id").toString();
				ClaimIncomeImpl claimIncomeImpl = claimInComeServiceMgr.getClaimIncome(inComeId);
				if(claimIncomeImpl.getDifferamount() >  caseBillImpl.getCompensationsub()*-1){
					claimIncomeImpl.setDifferamount(claimIncomeImpl.getDifferamount() - caseBillImpl.getCompensationsub()*-1);
					claimIncomeImpl.setBillId(Long.valueOf("0"));
				}else{
					claimIncomeImpl.setDifferamount(Float.valueOf("0"));
				}
				claimIncomeImpl.setIslocked("no");
				claimInComeServiceMgr.updateClaimIncome(claimIncomeImpl);
			}
			
			List<CaseBillDetailImpl> caseBillDetailList = caseBillDetailServiceMgr.searchCaseBillDetailByBillId(caseBillImpl.getBillId().toString(), "");
			
			for (CaseBillDetailImpl caseBillDetailImpl : caseBillDetailList) {
				caseBillDetailImpl.setAccdate(new Date());
				caseBillDetailImpl.setArrdate(new Date());
				caseBillDetailImpl.setStatus(PClientStatus.ClientFee1.getCode());
				caseBillDetailServiceMgr.updateCaseBillDetail(caseBillDetailImpl);
			}
			
			//查询账单下的垫付费用
			List<CaseClaimImpl> caseClaimList = caseClaimServiceMgr.searchCaseClaimByBillId(caseBillImpl.getBillId().toString(), null);
			
			for (CaseClaimImpl caseClaimImpl : caseClaimList) {
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
				caseClaimServiceMgr.updateCaseClaim(caseClaimImpl);
			}
			
			
			
		}else if(caseBillImpl.getFeeamount() < 0){
			caseBillImpl.setAccdate(new Date());
			caseBillImpl.setArrdate(new Date());
			caseBillImpl.setFeestatuse(AccStatus.AccNut.getCode());
			float allfee = caseBillImpl.getServicefee()+caseBillImpl.getAdvancefee()+caseBillImpl.getOtherfee()+caseBillImpl.getExpendses()+caseBillImpl.getThirdpart();
			
			for (Map map : claimList) {
				String inComeId = map.get("Income_Id").toString();
				ClaimIncomeImpl claimIncomeImpl = claimInComeServiceMgr.getClaimIncome(inComeId);
				claimIncomeImpl.setDifferamount(allfee*-1);
				claimIncomeImpl.setBillId(Long.valueOf("0"));
				claimIncomeImpl.setIslocked("no");
				claimInComeServiceMgr.updateClaimIncome(claimIncomeImpl);
			}
			
		}else{
			
			caseBillImpl.setAccdate(new Date());
			caseBillImpl.setFeestatuse(AccStatus.AccSubmit.getCode());
			
			List<CaseBillDetailImpl> caseBillDetailList = caseBillDetailServiceMgr.searchCaseBillDetailByBillId(caseBillImpl.getBillId().toString(), "");
			
			for (CaseBillDetailImpl caseBillDetailImpl : caseBillDetailList) {
				caseBillDetailImpl.setAccdate(new Date());
				caseBillDetailImpl.setStatus(PClientStatus.ClientFee0.getCode());
				caseBillDetailServiceMgr.updateCaseBillDetail(caseBillDetailImpl);
			}
			
			//查询账单下的垫付费用
			List<CaseClaimImpl> caseClaimList = caseClaimServiceMgr.searchCaseClaimByBillId(caseBillImpl.getBillId().toString(), null);
			
			for (CaseClaimImpl caseClaimImpl : caseClaimList) {
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
				caseClaimServiceMgr.updateCaseClaim(caseClaimImpl);
			}
			
			if(!"HTPI1300".equals(caseBillImpl.getCasenumber().substring(0, 8))){
				/*添加财务凭证 start */
				MMap mmap = new MMap();
				mmap.put("bill_id", caseBillImpl.getBillId());
				calFinItemServiceMgr.dealFinItem("101", mmap,1);
				if(!caseInfoImpl.getOrgcode().equals("859")){
					calFinItemServiceMgr.dealFinItem("101001", mmap,1);
				}
				/*end*/
			}
			
			BillCheckImpl billCheckImpl = billCheckServiceMgr.getBillCheckByBillId(caseBillImpl.getBillId().toString());
			
			if(billCheckImpl == null && caseBillImpl.getFeeamount() > 0 ){
				billCheckImpl = new BillCheckImpl();
				billCheckImpl.setCheckId(sequenceService.getSequence("check_id"));
				billCheckImpl.setFeeid(caseBillImpl.getBillId().toString());
				billCheckImpl.setAccdate(new Date());
				billCheckImpl.setBiztypeid("psys");
				billCheckImpl.setBiztype("海事");
				billCheckImpl.setFeenum(caseBillImpl.getFeenumber());
				billCheckImpl.setCurrency(caseBillImpl.getCurrency());
				billCheckImpl.setExpends(caseBillImpl.getExpendses());
				billCheckImpl.setIncome(caseBillImpl.getServicefee());
				billCheckImpl.setFlag("1");
				
//				BigDecimal replaceAmount = new BigDecimal(0);
//				replaceAmount = BigDecimal.valueOf(caseBillImpl.getCompensationsub()).add(BigDecimal.valueOf(caseBillImpl.getThirdpart()).add(BigDecimal.valueOf(caseBillImpl.getOtherfee()))).add(BigDecimal.valueOf(caseBillImpl.getAdvancefee()));
//				billCheckImpl.setReplaceamount(replaceAmount.floatValue());
			
				billCheckImpl.setFeeamount(caseBillImpl.getFeeamount());
				billCheckImpl.setDifferamount(caseBillImpl.getFeeamount());
				billCheckImpl.setOrgcode(caseBillImpl.getOrgcode());
				billCheckImpl.setOrgname(caseBillImpl.getOrgname());
				billCheckImpl.setPayername(caseBillImpl.getPayer());
				billCheckImpl.setChangedate(new Date());
				billCheckImpl.setCreateTime(new Date());
				billCheckImpl.setCreateOperator(user.getId());
				billCheckImpl.setPayamount(caseBillImpl.getThirdpart()); //添加第三方费用 1127
				//添加担保费用
				//billCheckImpl.setExtend1(caseBillImpl.getAssurefee().toString()); 
				//收入 （费用+服务费）
				billCheckImpl.setExtend2(String.valueOf(caseBillImpl.getServicefee()+caseBillImpl.getExpendses()));

				billCheckServiceMgr.addBillCheck(billCheckImpl);
			}else if(null != billCheckImpl){
				billCheckImpl.setCheckId(billCheckImpl.getCheckId());
				billCheckImpl.setFeeid(caseBillImpl.getBillId().toString());
				billCheckImpl.setAccdate(new Date());
				billCheckImpl.setBiztypeid("psys");
				billCheckImpl.setBiztype("海事");
				billCheckImpl.setFeenum(caseBillImpl.getFeenumber());
				billCheckImpl.setCurrency(caseBillImpl.getCurrency());
				billCheckImpl.setExpends(caseBillImpl.getExpendses());
				billCheckImpl.setIncome(caseBillImpl.getServicefee());
				billCheckImpl.setFlag("1");
				
				BigDecimal replaceAmount = new BigDecimal(0);
				replaceAmount = BigDecimal.valueOf(caseBillImpl.getCompensationsub()).add(BigDecimal.valueOf(caseBillImpl.getThirdpart()).add(BigDecimal.valueOf(caseBillImpl.getOtherfee()))).add(BigDecimal.valueOf(caseBillImpl.getAdvancefee()));
				
				billCheckImpl.setReplaceamount(replaceAmount.floatValue());
				billCheckImpl.setFeeamount(caseBillImpl.getFeeamount());
				billCheckImpl.setDifferamount(caseBillImpl.getFeeamount());
				billCheckImpl.setOrgcode(caseBillImpl.getOrgcode());
				billCheckImpl.setOrgname(caseBillImpl.getOrgname());
				billCheckImpl.setPayername(caseBillImpl.getPayer());
				
				//添加第三方费用 1127
				billCheckImpl.setPayamount(caseBillImpl.getThirdpart()); 
				//添加担保费用 1202
				//billCheckImpl.setExtend1(caseBillImpl.getAssurefee().toString());
				//收入 （费用+服务费）1203
				billCheckImpl.setExtend2(String.valueOf(caseBillImpl.getServicefee()+caseBillImpl.getExpendses()));
				
				billCheckImpl.setChangedate(new Date());
				billCheckImpl.setModifyOperatorId(user.getId());
				billCheckImpl.setModifyTime(new Date());
				billCheckServiceMgr.updBillCheck(billCheckImpl);
			}
			
		}
		caseBillImpl.setReplaceamount(caseBillImpl.getFeeamount());
		caseBillImplMapper.updateByPrimaryKeySelective(caseBillImpl);
		caseServiceMgr.updateCase(caseInfoImpl);
		
		//List ss = claimRateServiceMgr.searchClaimRateByCaseNumber("");
		
		return 1;
		
	}
	
	public int delete(String billId){
		return caseBillImplMapper.deleteByPrimaryKey(Long.valueOf(billId));
	}
	
}
