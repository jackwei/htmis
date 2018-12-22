package com.git.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.Passurepayments.PassurePayMents;
import com.git.business.Passurepayments.PassurePayMentsServiceMgr;
import com.git.business.assure.third.Third;
import com.git.business.assure.third.ThirdServiceMgr;
import com.git.business.caseService.CaseServiceMgr;
import com.git.business.claim.CaseClaimServiceMgr;
import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.process.ActivityInst;
import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.ApplyInfos;
import com.git.business.process.DocInfos;
import com.git.business.process.ParticInst;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.TblPassurePayMents;
import com.git.enums.DocInfoType;
import com.git.util.CommonUtil;
import com.git.util.Jutil;

import dwz.common.util.CommonUtils;
import dwz.common.util.HtmlOperator;
import dwz.framework.config.Constants;
import dwz.framework.sys.exception.ServiceException;

/**
 * 审核呈批信息的Controller
 * @author shona
 *
 */
@Controller
@RequestMapping(value="/auditApply")
public class AuditApplyController extends BaseController {

	@Autowired
	ApplyInfoServiceMgr applyInfoServiceMgr;
	
	@Autowired
	ThirdServiceMgr thirdServiceMgr;
	
	
	@Autowired
	private CaseClaimServiceMgr caseClaimServiceMgr;
	
	@Autowired
	private CaseServiceMgr caseServiceMgr;
	
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;
	
	@Autowired
	private PassurePayMentsServiceMgr passurePayMentsServiceMgr;
	
	/**
	 * 审核呈批信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(BaseConditionVO vo,HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		String flag=request.getParameter("flag");
		String name=request.getParameter("numname_s");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		try{
			String sql = applyInfoServiceMgr.searchApplyInfosCommon(name, flag ,user);
			List<Map> list=applyInfoServiceMgr.getList(sql,vo.getStartIndex(),vo.getPageSize());
			int totalCount = applyInfoServiceMgr.getCountList(sql);
		
		
			vo.setTotalCount(totalCount);
			model.addObject("list", list);
			model.addObject("flag", flag);
			model.addObject("numname_s", name);
			model.addObject("vo",vo);
			model.setViewName("/common/unsubmitApplyinfoList");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	/**
	 * 所有流程调整呈批件
	 * @param request
	 * @return
	 */
	@RequestMapping("/adjustmentList")
	public ModelAndView adjustmentList(BaseConditionVO vo,HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		String flag=request.getParameter("flag");
		String name=request.getParameter("numname_s");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		try{
			String sql = applyInfoServiceMgr.searchAdjustment(name, flag ,user);
			List<Map> list=applyInfoServiceMgr.getList(sql,vo.getStartIndex(),vo.getPageSize());
			int totalCount = applyInfoServiceMgr.getCountList(sql);
		
			vo.setTotalCount(totalCount);
			model.addObject("list", list);
			model.addObject("flag", flag);
			model.addObject("numname_s", name);
			model.addObject("vo",vo);
			model.setViewName("/common/adjustmentList");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * 查询附件列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/searchDocsInfos")
	public ModelAndView searchDocsInfos(HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		Long applyId=Long.valueOf(request.getParameter("applyId"));
		List<DocInfos> listDocs=applyInfoServiceMgr.selectByApplyId(Long.valueOf(applyId),DocInfoType.applydoc.getCode());
		model.addObject("listDocs", listDocs);
		model.addObject("applyId", applyId);
		model.setViewName("/common/FileList");
		return model;
	}
	
	/**
	 * 第三方呈批件的详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/searchApplyInfos")
	public ModelAndView searchApplyInfos(HttpServletRequest request){
		String applyId = request.getParameter("applyId");
		applyId = applyId == null ? "0" : applyId.trim();
		String flag = request.getParameter("flag");
		return searchApplyInfosCommon(request,Long.valueOf(applyId), flag);
	}
	
	/**
	 * 修改呈批件的详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifyApplyInfos")
	public ModelAndView modifyApplyInfos(HttpServletRequest request){
		String payid = request.getParameter("payid");
		String billDetailId= request.getParameter("detail_id");
		String claimId = request.getParameter("claimId");
		String incomeId=request.getParameter("incomeId");
		String applyId="";
		if(payid != null && !"".equals(payid)){
			//先修改呈批件年月后载入呈批件页面
/*			Long year = Long.valueOf(request.getParameter("year"));
			Long month = Long.valueOf(request.getParameter("month"));
			TblPassurePayMents tpm = passurePayMentsServiceMgr.selectpassurepayments(Long.valueOf(payid));
			tpm.setYear(year);
			tpm.setMonth(month);
			passurePayMentsServiceMgr.updpayment(tpm);*/
			PassurePayMents tppm = passurePayMentsServiceMgr.getPassurePayMents(Long.valueOf(payid));  
			applyId = String.valueOf(tppm.getCpid());
		}else if(billDetailId != null && !"".equals(billDetailId))
			applyId = applyInfoServiceMgr.getApplyIdByBillParentId(billDetailId,"thirdparty");
		else if(claimId!=null && !"".equals(claimId))
			applyId = applyInfoServiceMgr.getApplyIdByBillParentId(claimId,"caseClaim");
		else{
			CaseClaimImpl caseClaimInpl=claimInComeServiceMgr.searchcaseClaim(incomeId);
			applyId=applyInfoServiceMgr.getApplyIdByBillParentId(caseClaimInpl.getClaimId().toString(), "caseClaim");
		}
		if("".equals(applyId)){
			return ajaxDoneError("老系统已划付案件无法查询呈批件");
		}
		String flag =  request.getParameter("flag");
		return searchApplyInfosCommon(request,Long.valueOf(applyId), flag);
	}
	
	/**
	 * 第三方呈批件的详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/getApplyInfos")
	public ModelAndView getApplyInfos(HttpServletRequest request){
		String applyId=request.getParameter("applyId");
		return searchApplyInfosCommon(request,Long.valueOf(applyId), "apply");
	}
	
	/**
	 * 赔款登记呈批件的详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/claimApplyInfoDetail")
	public ModelAndView claimApplyInfoDetail(HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		String claimId=request.getParameter("claimId");
		String backNav=request.getParameter("backNav");
		try{
			if(claimId!=null && !"".equals(claimId)){
				return searchCaseClaimCommon(claimId,"apply",backNav);
			}else{
				String incomeId=request.getParameter("incomeId");
				CaseClaimImpl caseClaim=claimInComeServiceMgr.searchcaseClaim(incomeId);
				claimId=caseClaim.getClaimId().toString();
				return searchCaseClaimCommon(claimId,"apply",backNav);
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return model;
	}
	/**
	 * 赔款登记呈批件的详细信息的公共部分
	 * @param request
	 * @return
	 */
	public ModelAndView searchCaseClaimCommon(String claimId,String flag,String backNav){
		ModelAndView model=new ModelAndView();
		CaseClaimImpl caseClaim=caseClaimServiceMgr.getCaseClaim(claimId);
		CaseInfoImpl caseInfo=caseServiceMgr.getCaseInfo(caseClaim.getCaseId().toString());
		ApplyInfos applyInfos=applyInfoServiceMgr.selectByParentId(caseClaim.getClaimId());
		List<Map> list=applyInfoServiceMgr.searchProcessAct(applyInfos.getId());;
		model.addObject("list", list);
		model.addObject("caseClaim", caseClaim);
		model.addObject("caseInfo", caseInfo);
		model.addObject("applyInfos", applyInfos);
		model.addObject("flag", flag);
		model.addObject("backNav", backNav);

		if("none".equals(backNav))
		{
			if("A".equals(caseClaim.getRecordtype())){
				model.setViewName("/common/TransferDetail_out");//代收代付
			}else if("B".equals(caseClaim.getRecordtype())){
				model.setViewName("/common/advanceDetail_out");//垫付
			}else if("C".equals(caseClaim.getRecordtype())){
				model.setViewName("/common/toIncomeDetail");//暂无此呈批件类型，如有再增加
			}else{
				model.setViewName("/common/balanceReturnDetail_out");//余额退回
			}
		}
		else
		{
			if("A".equals(caseClaim.getRecordtype())){
				model.setViewName("/common/TransferDetail");
			}else if("B".equals(caseClaim.getRecordtype())){
				model.setViewName("/common/advanceDetail");
			}else if("C".equals(caseClaim.getRecordtype())){
				model.setViewName("/common/toIncomeDetail");
			}else{
				model.setViewName("/common/balanceReturnDetail");
			}
		}
		return model;
	}
	
	/**
	 * 呈批件详细信息公共部分
	 * @param applyId
	 * @param flag
	 * @return
	 */
	public ModelAndView searchApplyInfosCommon(HttpServletRequest request,Long applyId,String flag){
		ModelAndView model=new ModelAndView();
		try{
		ApplyInfos applyInfos=applyInfoServiceMgr.searchApplyInfosByOid(Long.valueOf(applyId));
		model.addObject("applyInfos", applyInfos);
		
		String backNav=request.getParameter("backNav");
		model.addObject("backNav", backNav);
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		
		if("audit".equals(flag))
		{
			//如果是审批操作，则先更新活动节点和参与者的执行状态，由待处理（‘1’）变为处理中（‘3’）；
//			StringBuffer tSql1 = new StringBuffer(16);
//			tSql1.append("SELECT partic_inst_id particId FROM tbl_partic_inst WHERE activity_inst_id IN ");
//			tSql1.append("(SELECT activity_inst_id FROM tbl_activity_inst WHERE process_inst_id IN (SELECT IFNULL(remarkc,'0') FROM tbl_applyinfos WHERE oid="+applyId+") AND current_state = '1') ");
//			tSql1.append(" AND partic_user_id = '"+user.getId()+"'");
//			
//			String particId = Jutil.getOneValue(tSql1.toString(),"particId");//获取particId
			//获取particId
			String particId =applyInfoServiceMgr.getParticIdByUserId(applyId, user.getId());
			if(particId != null && !"".equals(particId))
			{
				ParticInst particInst=new ParticInst();
				particInst.setExcuteState("3");
				particInst.setId(Long.valueOf(particId));
				applyInfoServiceMgr.updateParticInst(particInst);
			}			
			
//			tSql1 = new StringBuffer(16);
//			tSql1.append("SELECT activity_inst_id activityId FROM tbl_activity_inst WHERE current_state = '1' AND process_inst_id IN (SELECT IFNULL(remarkc,'0') FROM tbl_applyinfos WHERE oid="+applyId+")");
			
//			String activityId = Jutil.getOneValue(tSql1.toString(),"activityId");//获取activityId
			
			String activityId =applyInfoServiceMgr.getActivityIdByApplyId(applyId);
			if(activityId != null && !"".equals(activityId))
			{
				ActivityInst activityInst=new ActivityInst();
				activityInst.setCurrentState("3");
				activityInst.setId(Long.valueOf(activityId));
				applyInfoServiceMgr.updateActivityInst(activityInst);
			}
		}
		else if("apply".equals(flag))
		{
			if(!"new".equals(applyInfos.getStatus())&&!"refused".equals(applyInfos.getStatus()))//如果不是新建状态，则需要隐藏界面相应操作按钮
			{
				flag="audited";
			}
		}
		
		if("thirdparty".equals(applyInfos.getApplytype()))
		{
			List<Map> list=applyInfoServiceMgr.searchProcessAct(applyInfos.getId());
			CaseBillDetailImpl caseBillDetail=applyInfoServiceMgr.searchCaseBillDetail(applyInfos.getParentid());
			//呈批件对应附件信息
			List<DocInfos> listDocs=applyInfoServiceMgr.selectByApplyId(caseBillDetail.getDetailId(),DocInfoType.thirdparty.getCode());
			CaseBillImpl caseBill=applyInfoServiceMgr.selectCaseBillByBillId(caseBillDetail.getBillId());
			CaseInfoImpl caseInfo=applyInfoServiceMgr.selectCaseInfoById(caseBill.getCaseId());
			model.addObject("listDocs", listDocs);
			model.addObject("list", list);
			model.addObject("casenumber", caseInfo.getCasenumber());
			model.addObject("shipname", caseInfo.getShipname());
			model.addObject("consignorname", caseInfo.getConsignorname());
			model.addObject("caseId",caseInfo.getCaseId());
			Third third=thirdServiceMgr.getthird(caseBillDetail.getConsignorid());
			model.addObject("inspection",third.getNamecn());
			model.addObject("flag", flag);
			if("none".equals(backNav))
			{
				model.setViewName("/common/auditDetail_out");
			}
			else
			{
				model.setViewName("/common/auditDetail");
			}
			
		}else if("assure".equals(applyInfos.getApplytype())){
			//根据呈批件ID查询对应审批节点信息
			List<Map> list=applyInfoServiceMgr.searchProcessAct(applyInfos.getId());
			//呈批件对应附件信息
			List<DocInfos> listDocs=applyInfoServiceMgr.selectByApplyId(applyInfos.getParentid(),DocInfoType.assure.getCode());
			PassurePayMents tppm = passurePayMentsServiceMgr.getPassurePayMents(applyInfos.getParentid());
			String year = new SimpleDateFormat("yyyy").format(applyInfos.getCreatdate());
			String month = new SimpleDateFormat("MM").format(applyInfos.getCreatdate());
			model.addObject("listDocs", listDocs);
			model.addObject("list", list);
			/*model.addObject("year", year);
			model.addObject("month", month);*/
			model.addObject("year", tppm.getYear());
			model.addObject("month", tppm.getMonth());
			model.addObject("total", tppm.getTotal());
			model.addObject("feemount", tppm.getFeemount());
			model.addObject("flag", flag);
			if("none".equals(backNav))
			{
				model.setViewName("/common/assuredetail_out");
			}
			else
			{
				model.setViewName("/common/assuredetail");
			}
		}
		else
		{
           return searchCaseClaimCommon(applyInfos.getParentid().toString(),flag,backNav);
		}
		 
		}catch (Exception e) {
          e.printStackTrace();
        }
		return model;
	}
	
	/**
	 * 审批呈批件信息（系统内审批）
	 * @param request
	 * @return
	 */
	@RequestMapping("/passApplyInfos")
	public ModelAndView passApplyInfos(HttpServletRequest request){
		String applyId=request.getParameter("applyId");
		String checkdes=request.getParameter("checkdes");
		String result = request.getParameter("result");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		
		try{
			if(applyId!=null && !"".equals(applyId))
			{				
				try 
				{
					ApplyInfos applyInfos=applyInfoServiceMgr.searchApplyInfosByOid(Long.valueOf(applyId));
					if(applyInfos !=null && "finish".equals(applyInfos.getStatus())){
					}
					if("1".equals(result))
					{
						applyInfoServiceMgr.passProcess(applyInfos, checkdes,user.getId());
					}
					else if("0".equals(result))
					{
						applyInfoServiceMgr.refuseProcess(applyInfos, checkdes,user.getId());
					}
					else
					{
						return ajaxDoneError("没有审批结论，无法提交审批结果！");
					}
									
				} 
				catch (ServiceException e) 
				{					
					return ajaxDoneError(e.getMessage());
				}				
			}
			else
			{
				return ajaxDoneError("获取呈批件信息错误，无法进行审批，请联系管理员！");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError("处理时发生异常错误，请联系管理员！");
		}
		return ajaxDone(200, "提交成功!");
	}
	
	/**
	 * 审批呈批件信息(统一平台中审批)
	 * @param request
	 * @return
	 */
	@RequestMapping("/passApplyInfosOut")
	@ResponseBody
	public Map<String,String> passApplyInfosOut(HttpServletRequest request){
		Map<String,String> map = new HashMap<String,String>();
		String applyId=request.getParameter("applyId");
		String checkdes=request.getParameter("checkdes");
		String result = request.getParameter("result");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		
		try{
			if(applyId!=null && !"".equals(applyId))
			{				
				try 
				{
					ApplyInfos applyInfos=applyInfoServiceMgr.searchApplyInfosByOid(Long.valueOf(applyId));
					if(applyInfos !=null && "finish".equals(applyInfos.getStatus())){
						map.put("result", "false");
						map.put("msg", "该呈批件已审批完成，无需再次审批！");
						
						return map;
					}
					
					if("1".equals(result))
					{
						applyInfoServiceMgr.passProcess(applyInfos, checkdes,user.getId());
					}
					else if("0".equals(result))
					{
						applyInfoServiceMgr.refuseProcess(applyInfos, checkdes,user.getId());
					}
					else
					{
						map.put("result", "false");
						map.put("msg", "没有审批结论，无法提交审批结果！");
						
						return map;
					}
									
				} 
				catch (ServiceException e) 
				{	
					map.put("result", "false");
					map.put("msg", e.getMessage());
					
					return map;
				}				
			}
			else
			{
				map.put("result", "false");
				map.put("msg", "获取呈批件信息错误，无法进行审批，请联系管理员！");
				return map;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			map.put("result", "false");
			map.put("msg", e.getMessage());
			return map;
		}
		
		map.put("result", "true");
		map.put("msg", "审批处理成功！");
		
		return map;
	}	
	
	 /**
	 * 进入调整流程页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toadjustmentProcess")
	public ModelAndView toadjustmentProcess(HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		String applyId=request.getParameter("applyId");
		ApplyInfos applyInfos=applyInfoServiceMgr.searchApplyInfosByOid(Long.valueOf(applyId));
	    List ls=applyInfoServiceMgr.searchParticInstByCondition(applyInfos.getRemarkc(), applyInfos.getProcessdefid(), applyInfos.getStep().toString());
		model.addObject("ls", ls);
		model.setViewName("/common/adjustmentProcess");
	    return model;
	}
	
	/**
	 * 调整流程参与者信息
	 * @return
	 */
	@RequestMapping("/adjustmentPartic")
	public ModelAndView adjustmentPartic(HttpServletRequest request){
		String processInstId=request.getParameter("processInstId");
		String activityInstId=request.getParameter("activityInstId");
		String userId=request.getParameter("userLookup.id");
		String username=request.getParameter("userLookup.name");
		String[] particInstId=request.getParameterValues("particInstId");
		if(particInstId!=null && !"".equals(particInstId)){
			for(int i=0;i<particInstId.length;i++){
				//修改以前参与者的状态为4：失效
				ParticInst pi=new ParticInst();
				pi.setExcuteState("4");
				pi.setId(Long.valueOf(particInstId[i]));
				applyInfoServiceMgr.updateParticInstByCondition(pi);
			}
			//添加参与者
			ParticInst particInst=new ParticInst();
			particInst.setExcuteState("1");
			particInst.setActivityInstId(Long.valueOf(activityInstId));
			particInst.setParticUserId(Long.valueOf(userId));
			particInst.setParticUserValue(username);
			particInst.setProcessInstId(Long.valueOf(processInstId));
			particInst.setPartiinType("2");
			applyInfoServiceMgr.addParticInst(particInst);
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
		
	/**
	 * 呈批件打印功能
	 * @param request
	 * @param respnose
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@RequestMapping("/printApplyInfos")
	public ModelAndView printApplyInfos(HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException{
	  Long applyId=Long.valueOf(request.getParameter("applyId"));
	  String type=request.getParameter("type");
	  HtmlOperator ho = new HtmlOperator();
	  ApplyInfos applyInfos=applyInfoServiceMgr.searchApplyInfosByOid(applyId);
	  if(type==null || "".equals(type)){
		  if("assure".equals(applyInfos.getApplytype())){
			  ho.loadTemplate("template/assureapply.html",request);
			  PassurePayMents tppm = passurePayMentsServiceMgr.getPassurePayMents(applyInfos.getParentid());
			  String year = new SimpleDateFormat("yyyy").format(applyInfos.getCreatdate());
			  String month = new SimpleDateFormat("MM").format(applyInfos.getCreatdate());
			  /*ho.setVar("YEAR", year);
			  ho.setVar("MONTH", month);*/
			  ho.setVar("YEAR", tppm.getYear().toString());
			  ho.setVar("MONTH", tppm.getMonth().toString());
			  ho.setVar("TOTAL", tppm.getTotal().toString());
			  ho.setVar("FEEMOUNT", tppm.getFeemount().toString());
			  ho.setVar("USERNAME", tppm.getUsername());
			  ho.setVar("ORGNAME", tppm.getOrgname());
			  
		  }else{
		  ho.loadTemplate("template/dsfapplyinfo.html", request);
		  CaseBillDetailImpl caseBillDetail=applyInfoServiceMgr.searchCaseBillDetail(applyInfos.getParentid());
		  CaseBillImpl caseBill=applyInfoServiceMgr.selectCaseBillByBillId(caseBillDetail.getBillId());
		  CaseInfoImpl caseInfo=applyInfoServiceMgr.selectCaseInfoById(caseBill.getCaseId());
		  ho.setVar("CASENUBMER", caseInfo.getCasenumber());
		  ho.setVar("SHIPNAME", caseInfo.getShipname());
		  ho.setVar("CONSINORNAME",caseInfo.getConsignorname());
		  Third third=thirdServiceMgr.getthird(caseBillDetail.getConsignorid());
		  ho.setVar("INSPECTION", third.getNamecn());
		  ho.setVar("CURRENCY", applyInfos.getCurrency());
//		  ho.setVar("AMOUNTA", caseBillDetail.getCurrency()+CommonUtils.nullToEmpty(caseBillDetail.getFeeamount()));
		  ho.setVar("AMOUNTA", CommonUtils.nullToEmpty(applyInfos.getAmounta()));
		  }
	  }else{
		  CaseClaimImpl caseClaim=caseClaimServiceMgr.getCaseClaim(applyInfos.getParentid().toString());
		  CaseInfoImpl caseInfos=caseServiceMgr.getCaseInfo(caseClaim.getCaseId().toString());
		  ho.setVar("SHIPNAME", caseInfos.getShipname());
		  ho.setVar("ACCIDENTDATE",CommonUtil.formatDate(caseInfos.getAccidentdate(),"yyyy-MM-dd"));
		  ho.setVar("ACCIDENTPORT", caseInfos.getAccidentport());
		  ho.setVar("CASEDES", caseInfos.getCasedes());
		  ho.setVar("RECORDCURRENCY", CommonUtils.nullToEmpty(caseClaim.getRecordcurrency()));
		  ho.setVar("RECORDMOUNT", CommonUtils.nullToEmpty(caseClaim.getRecordmount()));
		  ho.setVar("REALAMOUNT", CommonUtils.nullToEmpty(caseClaim.getRealamount()));
		  ho.setVar("CASENUMBER", caseClaim.getCasenumber()+caseInfos.getExcasenumber());
		  if("A".equals(type)){
			  ho.loadTemplate("template/transferinfo.html", request);
			  ho.setVar("CONSINORNAME", caseInfos.getConsignorname());
			  ho.setVar("TRANSFERMOUNT", CommonUtils.nullToEmpty(caseClaim.getTransfermount()));
			  ho.setVar("TRANSFERCURRENCY", CommonUtils.nullToEmpty(caseClaim.getTransfercurrency()));
		  }else if("B".equals(type)){
			  ho.loadTemplate("template/advanceinfo.html", request);
			  ho.setVar("THINGCAUSE", caseClaim.getThingcause());
			  ho.setVar("CONSIGNORNAME", caseInfos.getConsignorname());
			  ho.setVar("UNITNAME", caseClaim.getUnitname());
			  ho.setVar("PAYEE", caseClaim.getPayee());
			  ho.setVar("UNITNAME", caseClaim.getUnitname());
			  ho.setVar("TRANSFERDATE",CommonUtil.formatDate(caseClaim.getTransferdate(),"yyyy-MM-dd"));
		  }else if("C".equals(type)){
			  ho.loadTemplate("template/toIncomeinfo.html", request);
			  ho.setVar("THINGCAUSE", caseClaim.getThingcause());
			  ho.setVar("INCASENO", caseClaim.getIncaseno());
		  }else{
			  ho.loadTemplate("template/balanceReturninfo.html", request);
			  ho.setVar("THINGCAUSE", caseClaim.getThingcause());
			  ho.setVar("CONSIGNORNAME", caseInfos.getConsignorname());
		  }
		  ho.setVar("CLIENTNAME", caseClaim.getClientname());
		  ho.setVar("APPLYBANK", caseClaim.getApplybank());
		  ho.setVar("APPLYBANKNUM", caseClaim.getApplybanknum());
		  ho.setVar("CURRENCY", caseClaim.getCurrency());
	  }
	  ho.setVar("ORGNAME", applyInfos.getOrgname());
	  ho.setVar("USERNAME", applyInfos.getUsername());
	  ho.setVar("APPLYDATE", CommonUtil.formatDate(applyInfos.getCreatdate(),"yyyy-MM-dd"));
	  List<Map> list=applyInfoServiceMgr.searchProcessAct(applyInfos.getId());
	  if(list!=null && list.size()!=0){
		  for(int i=0;i<list.size();i++){
			  Map p=list.get(i);
			  if(p.get("checkdes")!=null && !"".equals(p.get("checkdes"))){
				  ho.setVar("CHECKDES", p.get("checkdes").toString());
				  ho.setVar("CHECKNUSERNAME",p.get("Partic_User_Value").toString());
				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				  Date date=sdf.parse(p.get("checkdate").toString());
				  ho.setVar("CHECKDATE", CommonUtil.formatDate(date,"yyyy-MM-dd"));
			  }
			  ho.parse("CHECKLIST", true); 
		  }
	  }
	  List<DocInfos> ls=applyInfoServiceMgr.selectByApplyId(applyId,DocInfoType.applydoc.getCode());
	  if(ls!=null && ls.size()!=0){
		  for(int i=0;i<ls.size();i++){
			  DocInfos docs=ls.get(i);
			  ho.setVar("ATTACHNAME", docs.getDocname());
			  ho.setVar("FILETYPE", Jutil.getDictName("filetype", docs.getParent2id()));
			  ho.setVar("ATTACHPATH", docs.getId().toString());
			  ho.setVar("FILENAME", docs.getFilename());
			  ho.setVar("FILELOCATION", docs.getFilelocation());
			  ho.parse("ATTACHNAMELIST", true);
			  ho.parse("ATTACHLIST", true);
		  }
		  }
	  if(ls.size()==0){
			ho.setVar("ATTACHLIST", "");
		}
		ho.parse("main", false);
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma", "No-Cache");
		response.setHeader("Cache-Control", "No-Cache");
		response.setDateHeader("Expires", 0);
		response.getWriter().write(ho.printVar("main"));
	    return null;
	}
	
	@RequestMapping(value = "/auditBack", method = RequestMethod.POST)
	public ModelAndView auditBack(HttpServletRequest request) throws ServiceException {
		
		String forwardUrl = request.getParameter("forwardUrl");
		
		return ajaxDone(200, "","","", forwardUrl);
		
	}
}
