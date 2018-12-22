package com.git.web.management;


import java.util.ArrayList;
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

import com.git.business.caseService.CaseServiceMgr;
import com.git.business.claim.CaseClaimServiceMgr;
import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.ApplyInfos;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.Jutil;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping(value="/management/claim")
public class CaseClaimController extends BaseController{
	
//	@Autowired
//	private ApplyInfoServiceMgr applyInfoServiceMgr;
	
	@Autowired
	private CaseServiceMgr caseServiceMgr;
	
	@Autowired
	private CaseClaimServiceMgr caseClaimServiceMgr;
	
	@Autowired
	private ApplyInfoServiceMgr applyInfoServiceMgr;
	
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;
	
	@RequestMapping("")
	public ModelAndView list(HttpServletRequest request,BaseConditionVO vo){
		ModelAndView modelAndView = new ModelAndView();
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("casenumber", request.getParameter("casenumber"));
		criterias.put("shipname", request.getParameter("shipname"));
		criterias.put("excasenumber", request.getParameter("excasenumber"));
		criterias.put("billstatus", request.getParameter("billstatus"));
		
		if(null != request.getParameter("casestatus")){
			criterias.put("casestatus", request.getParameter("casestatus").toString());
		}
		Map<Object, Object> caseInfoMap = caseServiceMgr.searchCase(criterias, vo);
		List<CaseInfoImpl> caseList = (List<CaseInfoImpl>)caseInfoMap.get("caseList");
		vo.setTotalCount(caseList.size());
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("caseList",caseList);
		modelAndView.addObject("casestatus",request.getParameter("casestatus"));
		modelAndView.setViewName("/common/caseListCommon");
		return  modelAndView;
	}
	
	@RequestMapping("/searchCase")
	public ModelAndView searchCase(HttpServletRequest request,BaseConditionVO vo){
		ModelAndView modelAndView = new ModelAndView();
//		searchCaseInfosCommon(modelAndView,vo);
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("casenumber", request.getParameter("casenumber"));
		criterias.put("shipname", request.getParameter("shipname"));
		criterias.put("excasenumber", request.getParameter("excasenumber"));
		criterias.put("billstatus", request.getParameter("billstatus"));
		try{
		if(null != request.getParameter("casestatus")){
			criterias.put("casestatus", request.getParameter("casestatus").toString());
		}
		Map<Object, Object> caseInfoMap = caseServiceMgr.searchCase(criterias, vo);
		List<CaseInfoImpl> caseList = (List<CaseInfoImpl>)caseInfoMap.get("caseList");
		vo.setTotalCount(caseList.size());
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("casenumber1",request.getParameter("casenumber"));
		modelAndView.addObject("shipname1",request.getParameter("shipname"));
		modelAndView.addObject("billstatus",request.getParameter("billstatus"));
		modelAndView.addObject("excasenumber",request.getParameter("excasenumber"));
		modelAndView.addObject("caseList",caseList);
		modelAndView.addObject("casestatus",request.getParameter("casestatus"));
		modelAndView.setViewName("/common/caseListCommon");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return  modelAndView;
	}
	/**
	 * 案件查询公共部分
	 * @param modelAndView
	 * @param vo
	 */
	public void searchCaseInfosCommon(ModelAndView modelAndView,BaseConditionVO vo){
//		int totalCount = caseServiceMgr.getCount();
//		vo.setTotalCount(totalCount);
		Map<Object, Object> criterias = new HashMap<Object,Object>();
//		List<CaseInfoImpl> caseList = (List<CaseInfoImpl>) caseServiceMgr.searchCase(criterias, vo);
	   
//		modelAndView.addObject("vo",vo);
//		modelAndView.addObject("caseList",caseList);
		Map<Object, Object> caseInfoMap = caseServiceMgr.searchCase(criterias, vo);
		List<CaseInfoImpl> caseList = (List<CaseInfoImpl>)caseInfoMap.get("caseList");
		vo.setTotalCount(caseList.size());
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("caseList",caseList);
	}
	
	@RequestMapping("/add/{caseId}")
	public String add(@PathVariable("caseId") String caseId, Model model,HttpServletRequest request) {
		model.addAttribute("caseId",caseId);
		model.addAttribute("casenumber",request.getSession().getAttribute("casenumber"));
		model.addAttribute("shipname",request.getSession().getAttribute("shipname"));
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("feetype",Jutil.getDictEntry("feetype"));
		model.addAttribute("backNav","caseClaimAddNav");
		model.addAttribute("status",1);
		model.addAttribute("flag", request.getParameter("flag"));
		model.addAttribute("caseClaimImpl",new CaseClaimImpl());
		return "/management/claim/caseClaimInfo";
	}
	
	@RequestMapping("/edit/{claimId},{caseId}")
	public String edit(@PathVariable("claimId") String claimId,@PathVariable("caseId") String caseId, Model model,HttpServletRequest request) {
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);
		model.addAttribute("caseInfoImpl", caseInfoImpl);
		
		CaseClaimImpl caseClaimImpl = caseClaimServiceMgr.getCaseClaim(claimId);
		//ApplyInfos applyInfos=applyInfoServiceMgr.selectByParentId(caseClaimImpl.getClaimId());
		model.addAttribute(caseClaimImpl); 
		model.addAttribute(caseClaimImpl.getStatus());
		//model.addAttribute(applyInfos);
		//model.addAttribute("applyInfos",applyInfos);
		model.addAttribute("caseClaimImpl", caseClaimImpl);
		model.addAttribute("status",caseClaimImpl.getStatus());
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("feetype",Jutil.getDictEntry("feetype"));
		model.addAttribute("backNav","caseEditNav");
		model.addAttribute("flag", request.getParameter("flag"));
		return "/management/claim/caseClaimInfo";
	}
	
	/**
	 * 添加赔款登记信息和呈批件信息
	 * @param request
	 * @param applyInfo
	 * @return
	 */
	@Log(message="{0}{1}{2}呈批件")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertAndUpdate(HttpServletRequest request,BaseConditionVO vo){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		ModelAndView model=new ModelAndView();
		String type=request.getParameter("recordtype");
		List<Map> ls=null;
	  	if(type.equals("B")){
	  		 ls=applyInfoServiceMgr.getProcessDefByNo("0002");
	  	}else{
	  		 ls=applyInfoServiceMgr.getProcessDefByNo("0001");
	  	}
	  	if(ls!=null && ls.size()!=0){
	  		ApplyInfos applyInfos=new ApplyInfos();
	  		Map mp=ls.get(0);
			applyInfos.setProcessdefid(Long.valueOf(mp.get("Process_Def_Id").toString()));
			applyInfos.setProcessname(mp.get("Process_Name").toString());
	  		CaseClaimImpl  caseClaimImpl = new CaseClaimImpl();
			boolean bool= caseClaimServiceMgr.updCaseClaim(caseClaimImpl, request,applyInfos);
			if(bool==true){
				if(type.equals("A")){
					type="代收代付";
				}else if(type.equals("B")){
					type="垫付费用";
				}else if(type.equals("C")){
					type="转为收入";
				}else if(type.equals("D")){
					type="余款退回";
				}
				if(null==request.getParameter("claimId") || "".equals(request.getParameter("claimId"))){
					LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"新增",type,applyInfos.getProcessname()}));
				}else{
					LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"修改",type,applyInfos.getProcessname()}));
				}
			}
	  	}else{
	  		return ajaxDoneError(getMessage("billDetail.error"));
	  	}
	
	  	if(request.getParameter("recordtype").equals("D")){
			Map<Object, Object> criterias = new HashMap<Object, Object>();
	  		criterias.clear();
			criterias.put("differamount", 1);
			criterias.put("Islocked", "no");
			List<ClaimIncomeImpl> claimIncomeList = claimInComeServiceMgr.searchClaimIncomeByBill(criterias, request.getParameter("casenumber"));
			model.addObject("vo", vo);
			model.addObject("claimIncomeList", claimIncomeList);
			
			/*
			List<ClaimIncomeImpl> claimIncomels = claimInComeServiceMgr.searchClaimIncomeByCaseNum(null,request.getParameter("casenumber"));
			List<ClaimIncomeImpl> claimIncomeList=new  ArrayList<ClaimIncomeImpl>();
			if(claimIncomels!=null && claimIncomels.size()!=0){
				for(int i=0;i<claimIncomels.size();i++){
			        ClaimIncomeImpl claimIncomeImpl=claimIncomels.get(i);
			        CaseClaimImpl caseClaim=claimInComeServiceMgr.searchcaseClaim(claimIncomeImpl.getIncomeId().toString());
			        if(caseClaim!=null){
			        	claimIncomeImpl.setCaseId(caseClaim.getClaimId());
			        }
			        claimIncomeList.add(claimIncomeImpl);
				}
			}
			vo.setTotalCount(claimIncomeList.size());
			model.addObject("vo", vo);
			model.addObject("claimIncomeList", claimIncomeList);*/
			model.setViewName("/management/claim/caseBalanceList");
	  	}else{
		  	List<CaseClaimImpl> caseClaimList = caseClaimServiceMgr.searchCaseClaimByCaseId(request.getSession().getAttribute("caseId").toString());
			model.addObject("caseClaimList", caseClaimList);
			model.addObject("recordtype",Jutil.getDictEntry("recordtype"));
			model.setViewName("/management/claim/caseClaimList");
	  	}
		return model;
	}
	
	/**
	 * 查询赔款登记信息
	 * @param request
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping("/searchCaseClaim")
	public String searchCaseClaim(HttpServletRequest request,Model model,BaseConditionVO vo){
		List<CaseClaimImpl> caseClaimList = caseClaimServiceMgr.searchCaseClaimByCaseId(request.getSession().getAttribute("caseId").toString());
		/*Map<Object,Object> criterias = new HashMap<Object, Object>();
		criterias.put("caseId", request.getSession().getAttribute("caseId"));
		List<CaseClaimImpl> caseClaimList1 =  caseClaimServiceMgr.searchCaseClaim(criterias,vo );
		List<CaseClaimImpl> caseClaimList=new ArrayList<CaseClaimImpl>();
		for(int i=0;i<caseClaimList1.size();i++){
			CaseClaimImpl caseClaim=caseClaimList1.get(i);
			caseClaim.setRecordtype(Jutil.getDictName("recordtype", caseClaim.getRecordtype()));
			caseClaimList.add(caseClaim);
		}*/
		model.addAttribute("caseClaimList", caseClaimList);
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		//vo.setTotalCount(caseClaimList.size());
		//model.addAttribute("vo", vo);
		return "/management/claim/caseClaimList";
	}
	
	/**
	 * 查找带回垫付账单
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/searchAdvance")
	public String searchAdvance(HttpServletRequest request,Model model,BaseConditionVO vo){
		Map<Object,Object> criterias = new HashMap<Object, Object>();
		criterias.put("casenumber", request.getParameter("casenumber"));
		criterias.put("recordtype", "B");
		Map search = caseClaimServiceMgr.searchCaseClaimByCondition(criterias, vo);
		List<CaseClaimImpl> caseClaimList = (List<CaseClaimImpl>)search.get("caseClaimList");
		int count = (Integer)search.get("count");
		vo.setTotalCount(count);
		model.addAttribute("vo", vo);
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("caseClaimList", caseClaimList);
		return "/management/claim/searchAdvanceList";
	}
	

	
	
	/**
	 * 删除赔款登记信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete/{caseId}")
	public ModelAndView delete(@PathVariable("caseId") String caseId) {
		ApplyInfos applyInfo=applyInfoServiceMgr.selectByParentId(Long.valueOf(caseId));
		if(applyInfo.getRemarkc()!=null && !"".equals(applyInfo.getRemarkc())){
			applyInfoServiceMgr.delAllProcess(Long.valueOf(applyInfo.getRemarkc()));
		}
		applyInfoServiceMgr.delApplyInfos(applyInfo.getId());
		caseClaimServiceMgr.delCaseClaimInfo(caseId);
	    return ajaxDoneSuccess(getMessage("msg.operation.success"));
		//return ajaxDone3(200, getMessage("msg.operation.success"), "caseClaimNav");
	}
	
}
