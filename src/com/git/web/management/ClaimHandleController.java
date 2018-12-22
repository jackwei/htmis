package com.git.web.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.claim.CaseClaimServiceMgr;
import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.claimHandle.ClaimHandleServiceMgr;
import com.git.business.claimRate.ClaimRateServiceMgr;
import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.DocInfos;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.enums.ClaimStatus;
import com.git.enums.DocInfoType;
import com.git.enums.InComeStatus;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.Jutil;
import com.git.util.MMap;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping(value="/management/claimHandle")
public class ClaimHandleController extends BaseController{
	
	@Autowired
	private ClaimHandleServiceMgr claimHandleServiceMgr;
	
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;
	
	@Autowired
	private ClaimRateServiceMgr claimRateServiceMgr;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;
	
	@Autowired
	private ApplyInfoServiceMgr applyInfoServiceMgr;
	
	@Autowired
	private CaseClaimServiceMgr caseClaimServiceMgr;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("")
	public String list(HttpServletRequest request,BaseConditionVO vo,Model model){
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		
		criterias.put("casenumber", request.getParameter("casenumber"));
		criterias.put("shipname", request.getParameter("shipname"));
		criterias.put("clientname", request.getParameter("clientname"));
		criterias.put("recordtype", request.getParameter("recordtype"));
		
		if(null != request.getParameter("flag") && request.getParameter("flag").equals("nolock")){
			criterias.put("status",ClaimStatus.ClaimFee3.getCode());
		}else if(request.getParameter("flag").equals("lock")){
			criterias.put("status",ClaimStatus.ClaimFee4.getCode());
		}
		
		criterias.put("flag", request.getParameter("flag"));
		
		Map search = claimHandleServiceMgr.searchCaseClaim(criterias, vo);
		List<CaseClaimImpl> claimHandleList = (List<CaseClaimImpl>)search.get("caseClaimList");
		int count = (Integer)search.get("count");
		vo.setTotalCount(count);
		model.addAttribute("vo", vo);
		model.addAttribute("flag", request.getParameter("flag"));
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("claimHandleList",claimHandleList);
		return  "/management/claimHandle/claimHandleList";
	}
	
	/**
	 * 查询审核通过的赔款账单
	 * 
	 * */
	@RequestMapping("searchPay")
	public String searchPay(HttpServletRequest request,BaseConditionVO vo,Model model){
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		
		criterias.put("casenumber", request.getParameter("casenumber"));
		criterias.put("shipname", request.getParameter("shipname"));
		criterias.put("clientname", request.getParameter("clientname"));
		criterias.put("recordtype", request.getParameter("recordtype"));
		criterias.put("flag", request.getParameter("flag"));
		criterias.put("status",ClaimStatus.ClaimFee2.getCode());
		Map search = claimHandleServiceMgr.searchCaseClaim(criterias, vo);
		List<CaseClaimImpl> claimHandleList = (List<CaseClaimImpl>)search.get("caseClaimList");
		int count = (Integer)search.get("count");
		vo.setTotalCount(count);
		model.addAttribute("vo", vo);
		model.addAttribute("flag", request.getParameter("flag"));
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("claimHandleList",claimHandleList);
		return  "/management/claimHandle/claimPayList";
	}
	
	/**
	 * 赔款划付
	 * */
	@RequestMapping("/claimPay/{claimId}")
	public String claimPay(@PathVariable("claimId") String claimId, Model model,HttpServletRequest request) {
		CaseClaimImpl caseClaimImpl = claimHandleServiceMgr.getCaseClaim(claimId);
		
		//如果赔款币种等于划付币种，那么金额相等
		/*if(caseClaimImpl.getRecordcurrency()){
			caseClaimImpl.setRealamount(caseClaimImpl.getRecordmount());
		}*/
		
		List<DocInfos> docList=applyInfoServiceMgr.selectByApplyId(Long.valueOf(caseClaimImpl.getClaimId()),DocInfoType.claimPaydoc.getCode());
		model.addAttribute("docList", docList);
		
		model.addAttribute("caseClaimImpl", caseClaimImpl);
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		
		if(caseClaimImpl.getRecordtype().equals("D")){
			return "/management/claimHandle/balancePayInfo";
		}else{
			return "/management/claimHandle/advancePayInfo";
		}
		
	}
	
	@RequestMapping("/edit/{claimId}")
	public String edit(@PathVariable("claimId") String claimId, Model model,HttpServletRequest request,BaseConditionVO vo) {
		CaseClaimImpl caseClaimImpl = claimHandleServiceMgr.getCaseClaim(claimId);
		//request.getSession().setAttribute("caseClaimImpl", caseClaimImpl);
		List<ClaimIncomeImpl> claimIncomeList = new ArrayList<ClaimIncomeImpl>();
		
		Map<Object,Object> criterias = new HashMap<Object,Object>();
		
		if("A".equals(caseClaimImpl.getRecordtype()) || "B".equals(caseClaimImpl.getRecordtype())){
			criterias.put("differamount", 0);
			claimIncomeList = claimInComeServiceMgr.searchClaimIncomeByCaseNum(criterias,caseClaimImpl.getCasenumber());
		}
		
		model.addAttribute("claimIncomeList", claimIncomeList);
		vo.setTotalCount(claimIncomeList.size());
		model.addAttribute("vo", vo);
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		
		//如果赔款币种等于划付币种，那么金额相等
		if(caseClaimImpl.getCurrency().equals(caseClaimImpl.getRecordcurrency())){
			caseClaimImpl.setRealamount(caseClaimImpl.getRecordmount());
		}
		
		model.addAttribute("caseClaimImpl", caseClaimImpl);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		
		return "/management/claimHandle/claimHandleInfo";
		
	}
	
	/**
	 * 赔款查询
	 * */
	@RequestMapping("/view/{claimId}")
	public String view(@PathVariable("claimId") String claimId, Model model,HttpServletRequest request,BaseConditionVO vo) {
		CaseClaimImpl caseClaimImpl = claimHandleServiceMgr.getCaseClaim(claimId);
		request.getSession().setAttribute("caseClaimImpl", caseClaimImpl);
		List<ClaimIncomeImpl> claimIncomeList = new ArrayList<ClaimIncomeImpl>();
		
		Map<Object,Object> criterias = new HashMap<Object,Object>();
		criterias.put("InComeStatus", InComeStatus.ClaimFee4.getCode());
		if(caseClaimImpl.getRecordtype().equals("D")){
			ClaimIncomeImpl  claimIncomeImpl = claimInComeServiceMgr.getClaimIncome(caseClaimImpl.getRemark1());
			claimIncomeList.add(claimIncomeImpl);
		}else{
			claimIncomeList = claimInComeServiceMgr.searchClaimIncomeByLock(criterias,caseClaimImpl.getCasenumber());
		}
		
		model.addAttribute("claimIncomeList", claimIncomeList);
		vo.setTotalCount(claimIncomeList.size());
		model.addAttribute("vo", vo);
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("caseClaimImpl", caseClaimImpl);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		if(request.getParameter("flag") != null){
			model.addAttribute("flag", request.getParameter("flag"));
		}
		
		return "/management/claimHandle/claimHandleInfo";
	}
	
	@Log(message="用户 {0} 处理赔款  {1}。")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertAndUpdate(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		CaseClaimImpl  caseClaimImpl = new CaseClaimImpl();
		claimHandleServiceMgr.updCaseClaim(caseClaimImpl, request);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),caseClaimImpl.getCasenumber()}));
		
		if(!"HTPI1300".equals(caseClaimImpl.getCasenumber().substring(0, 8))){
			MMap mmap = new MMap();
			mmap.put("Claim_Id", caseClaimImpl.getClaimId());
			calFinItemServiceMgr.dealFinItem("110", mmap,1);
		}
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/verification/{inComeId},{claimId}")
	public ModelAndView verification(@PathVariable("inComeId") String inComeId,@PathVariable("claimId") String claimId, HttpServletRequest request){
		
		CaseClaimImpl caseClaimImpl = caseClaimServiceMgr.getCaseClaim(claimId);
		
		ClaimIncomeImpl claimIncomeImpl = claimInComeServiceMgr.getClaimIncome(inComeId);
		
		float rate = caseClaimImpl.getUsdrate().floatValue();
		
		if(!claimIncomeImpl.getCurrency().equals(caseClaimImpl.getCurrency())){ //有汇差
			if(rate == 0){
				return ajaxDoneError("币种不一致，请录入赔款汇率!");
			}
			Float usdamount = (float)0.0;
			float  num = (float)2.0;
			
			//支付金额
			usdamount = caseClaimImpl.getRealamount()/rate; 
			num =  usdamount.compareTo(claimIncomeImpl.getTotalamount()); 
			
		    /** 当到账金额等于支付金额，无汇差  */
		    if(num == 0){
		    	float checkamount = claimIncomeImpl.getDifferamount();
		    	claimIncomeImpl.setLockdate(new Date());
		    	claimIncomeImpl.setDifferamount((float)0);
		    	claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
		    	caseClaimImpl.setTreatdate(new Date());
				caseClaimImpl.setLockdate(new Date());
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);
		    }
		    
		    /** 当支付金额小于到账金额  产生负汇差--- 正余额 */
		    if(num == -1){
		    	
		    	//正余额
		    	float differamount = claimIncomeImpl.getDifferamount() - usdamount ;
		    	
		    	//核销金额
		    	float checkamount = caseClaimImpl.getRealamount();
	    		claimIncomeImpl.setDifferamount((float)(Math.round(differamount*100))/100);
	    		claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
	    		claimIncomeImpl.setBillId(Long.valueOf("0"));
	    		
	    		caseClaimImpl.setTreatdate(new Date());
				caseClaimImpl.setLockdate(new Date());
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
					
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);

		    }
		    
		    /** 当支付金额大于到账金额 产生正汇差 --- 负余额 */
		    if(num == 1){
		    	
		    	//负余额
		    	float differamount = claimIncomeImpl.getDifferamount() - usdamount ;
		    	//核销金额
		    	float checkamount = claimIncomeImpl.getDifferamount();
		    	
		    	claimIncomeImpl.setDifferamount(differamount);
		    	claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
		    	claimIncomeImpl.setBillId(Long.valueOf("0"));
		    	
		    	caseClaimImpl.setTreatdate(new Date());
				caseClaimImpl.setLockdate(new Date());
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);

		    }
		    
		}else{ //无汇差
			
			float num = claimIncomeImpl.getDifferamount().compareTo(caseClaimImpl.getDifferamount());
			
			 /** 当到账金额大于支付金额  */
			if(num == 1){
				float checkamount = caseClaimImpl.getDifferamount();
				claimIncomeImpl.setDifferamount(claimIncomeImpl.getDifferamount()-caseClaimImpl.getDifferamount());
				claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
				claimIncomeImpl.setBillId(Long.valueOf("0"));
				
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
				caseClaimImpl.setLockdate(new Date());
				caseClaimImpl.setTreatdate(new Date());
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);
			}
			
			 /** 当到账金额等于支付金额  */
			if(num == 0){
				float checkamount = claimIncomeImpl.getDifferamount();
				claimIncomeImpl.setDifferamount((float)0);
				claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
				claimIncomeImpl.setLockdate(new Date());
				
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
				caseClaimImpl.setTreatdate(new Date());
				caseClaimImpl.setLockdate(new Date());
				
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);
			}
			
			 /** 当到账金额小于支付金额  */
			if(num == -1){
				
				return ajaxDoneError("划付金额不能大于到账金额!");
				
				/*float checkamount = claimIncomeImpl.getDifferamount();
				caseClaimImpl.setDifferamount(caseClaimImpl.getDifferamount()-claimIncomeImpl.getDifferamount());
				claimIncomeImpl.setDifferamount((float)0);
				claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);*/
			}
			
		}
		
		claimHandleServiceMgr.updateCaseClaim(caseClaimImpl);
		claimInComeServiceMgr.updateClaimIncome(claimIncomeImpl);
		
		if(!"HTPI1300".equals(caseClaimImpl.getCasenumber().substring(0, 8))){
			if(caseClaimImpl.getRecordtype().equals("A")){
				/*添加代收代付财务凭证 start */
				MMap mmap = new MMap();
				//确认赔款
				mmap.put("Claim_Id", caseClaimImpl.getClaimId());
				mmap.put("Income_Id", claimIncomeImpl.getIncomeId());
				calFinItemServiceMgr.dealFinItem("108", mmap,1);
				//代收付赔款划付确认
				calFinItemServiceMgr.dealFinItem("109", mmap,1);
				/*end*/
			}else if(caseClaimImpl.getRecordtype().equals("B")){
				/*添加垫付财务凭证 start */
				MMap mmap = new MMap();
				mmap.put("Income_Id", claimIncomeImpl.getIncomeId());
				mmap.put("Claim_Id", caseClaimImpl.getClaimId());
				
				calFinItemServiceMgr.dealFinItem("111", mmap,1);
				/*end*/
			}
		}
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	
	/**
	 * 1230 启用新方法 此方法备用
	 * 赔款（代收代付，垫付费用）核销及赔款汇差处理
	 * */
	@RequestMapping("/process/{inComeId},{usdrate},{isSubRate},{realamount},{currency}")
	public ModelAndView process(@PathVariable("inComeId") String inComeId,@PathVariable("usdrate") String usdrate,@PathVariable("isSubRate") String isSubRate,@PathVariable("realamount") String realamount,@PathVariable("currency") String currency, HttpServletRequest request){
		CaseClaimImpl caseClaimImpl = (CaseClaimImpl)request.getSession().getAttribute("caseClaimImpl");
		
		if(Float.valueOf(realamount) == 0 || realamount.equals("")){
			return ajaxDoneError("划付金额不能为0，请录入划付金额!");
		}else{
			caseClaimImpl.setRealamount(Float.valueOf(realamount));
		}
		
		caseClaimImpl.setCurrency(currency);
		
		ClaimIncomeImpl claimIncomeImpl = claimInComeServiceMgr.getClaimIncome(inComeId);
		
		float rate = Float.valueOf(usdrate);
		if(!claimIncomeImpl.getCurrency().equals(caseClaimImpl.getCurrency())){ //有汇差
			if(rate == 0){
				return ajaxDoneError("币种不一致，请录入赔款汇率!");
			}
			Float usdamount = (float)0.0;
			float  num = (float)2.0;
			
			usdamount = caseClaimImpl.getRealamount()/rate; //支付金额
			num =  usdamount.compareTo(claimIncomeImpl.getTotalamount()); 
			
			/*if("B".equals(caseClaimImpl.getRecordtype())){
				usdamount = caseClaimImpl.getRealamount()*rate;
				num =  usdamount.compareTo(claimIncomeImpl.getTotalamount()); 
			}else if("A".equals(caseClaimImpl.getRecordtype())){
				usdamount = claimIncomeImpl.getTotalamount()*rate;
				num =  usdamount.compareTo(claimIncomeImpl.getTotalamount()); 
			}*/
		    
		    /** 当到账金额等于支付金额，无汇差  */
		    if(num == 0){
		    	float checkamount = claimIncomeImpl.getDifferamount();
		    	claimIncomeImpl.setLockdate(new Date());
		    	claimIncomeImpl.setDifferamount((float)0);
		    	claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
		    	caseClaimImpl.setTreatdate(new Date());
				caseClaimImpl.setLockdate(new Date());
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);
		    }
		    
		    /** 当支付金额小于到账金额  产生负汇差 */
		    if(num == -1){
		    	float differamount = claimIncomeImpl.getDifferamount() - usdamount ;
		    	float checkamount = 0;
		    	if(isSubRate.equals("0")){//转余额
		    		checkamount = caseClaimImpl.getDifferamount();
		    		claimIncomeImpl.setDifferamount((float)(Math.round(differamount*100))/100);
		    		caseClaimImpl.setTreatdate(new Date());
					caseClaimImpl.setLockdate(new Date());
					caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
		    	}else{//转汇差
		    		float huicha = usdamount - claimIncomeImpl.getDifferamount();
		    		checkamount = caseClaimImpl.getDifferamount();
		    		claimRateServiceMgr.insertClaimRateSub(claimIncomeImpl, caseClaimImpl, huicha, rate, usdamount);
		    		claimIncomeImpl.setLockdate(new Date());
			    	claimIncomeImpl.setDifferamount((float)0);
			    	claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
			    	caseClaimImpl.setTreatdate(new Date());
					caseClaimImpl.setLockdate(new Date());
					caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
		    	}
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);

		    }
		    
		    /** 当支付金额大于到账金额 产生正汇差*/
		    if(num == 1){
		    	if(isSubRate.equals("0")){
		    		return ajaxDoneError("当到账金额小于支付金额时，请选择转汇差");
		    	}
		    	float differamount = usdamount - claimIncomeImpl.getDifferamount();
		    	float checkamount = caseClaimImpl.getRealamount();
	    		claimRateServiceMgr.insertClaimRateSub(claimIncomeImpl, caseClaimImpl, differamount, rate, usdamount);
	    		claimIncomeImpl.setLockdate(new Date());
		    	claimIncomeImpl.setDifferamount((float)0);
		    	claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
		    	caseClaimImpl.setTreatdate(new Date());
				caseClaimImpl.setLockdate(new Date());
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);

		    }
		    
		}else{ //无汇差
			
			float num = claimIncomeImpl.getDifferamount().compareTo(caseClaimImpl.getDifferamount());
			
			 /** 当到账金额大于支付金额  */
			if(num == 1){
				float checkamount = caseClaimImpl.getDifferamount();
				claimIncomeImpl.setDifferamount(claimIncomeImpl.getDifferamount()-caseClaimImpl.getDifferamount());
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
				caseClaimImpl.setLockdate(new Date());
				caseClaimImpl.setTreatdate(new Date());
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);
			}
			
			 /** 当到账金额等于支付金额  */
			if(num == 0){
				float checkamount = claimIncomeImpl.getDifferamount();
				claimIncomeImpl.setDifferamount((float)0);
				claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
				claimIncomeImpl.setLockdate(new Date());
				caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
				caseClaimImpl.setTreatdate(new Date());
				caseClaimImpl.setLockdate(new Date());
				
				//caseClaimImpl.setDifferamount(differamount);
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);
			}
			
			 /** 当到账金额小于支付金额  */
			if(num == -1){
				
				return ajaxDoneError("划付金额不能大于到账金额!");
				
				/*float checkamount = claimIncomeImpl.getDifferamount();
				caseClaimImpl.setDifferamount(caseClaimImpl.getDifferamount()-claimIncomeImpl.getDifferamount());
				claimIncomeImpl.setDifferamount((float)0);
				claimIncomeImpl.setStatus(InComeStatus.ClaimFee4.getCode());
				claimHandleServiceMgr.insertClaimInComeDetail(claimIncomeImpl, caseClaimImpl, checkamount);*/
			}
			
		}
		
		claimHandleServiceMgr.updateCaseClaim(caseClaimImpl);
		claimInComeServiceMgr.updateClaimIncome(claimIncomeImpl);
		
		if(!"HTPI1300".equals(caseClaimImpl.getCasenumber().substring(0, 8))){
			if(caseClaimImpl.getRecordtype().equals("A")){
				/*添加代收代付财务凭证 start */
				MMap mmap = new MMap();
				//确认赔款
				mmap.put("Claim_Id", caseClaimImpl.getClaimId());
				mmap.put("Income_Id", claimIncomeImpl.getIncomeId());
				calFinItemServiceMgr.dealFinItem("108", mmap,1);
				//代收付赔款划付确认
				calFinItemServiceMgr.dealFinItem("109", mmap,1);
				/*end*/
			}else if(caseClaimImpl.getRecordtype().equals("B")){
				/*添加垫付财务凭证 start */
				MMap mmap = new MMap();
				mmap.put("Income_Id", claimIncomeImpl.getIncomeId());
				mmap.put("Claim_Id", caseClaimImpl.getClaimId());
				
				calFinItemServiceMgr.dealFinItem("111", mmap,1);
				/*end*/
			}
		}
		
		
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
}
