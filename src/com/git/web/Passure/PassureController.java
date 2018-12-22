package com.git.web.Passure;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

import com.git.business.PassureInfos.PassureInfos;
import com.git.business.PassureInfos.PassureInfosServiceMgr;
import com.git.business.Passurepayments.PassurePayMents;
import com.git.business.Passurepayments.PassurePayMentsServiceMgr;
import com.git.business.billService.BillCheckServiceMgr;
import com.git.business.caseService.CaseBillServiceMgr;
import com.git.business.caseService.CaseServiceMgr;
import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.handle.CaseHandleServiceMgr;
import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.ApplyInfos;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillCheckImpl;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseHandleImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.TblPassureInfos;
import com.git.db.beans.TblPassureInfosExample;
import com.git.db.beans.TblPassurePayMents;
import com.git.db.mapper.TblPassureInfosMapper;
import com.git.enums.AccFlagStatus;
import com.git.enums.AccStatus;
import com.git.enums.AssureStatus;
import com.git.enums.PClientStatus;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.CommonUtil;
import com.git.util.Jutil;
import com.git.util.MMap;
import com.git.web.BaseController;

import dwz.framework.config.Constants;
import dwz.framework.sys.exception.ServiceException;

@Controller
@RequestMapping(value = "/passure")
public class PassureController extends BaseController {

	// 担保管理Controller
	@Autowired
	private CaseServiceMgr caseServiceMgr;

	@Autowired
	private CaseBillServiceMgr caseBillServiceMgr;

	@Autowired
	private PassureInfosServiceMgr passureInfosServiceMgr;
	
	@Autowired
	private TblPassureInfosMapper passuremapper;

	@Autowired
	private CaseHandleServiceMgr caseHandleServiceMgr;

	@Autowired
	private PassurePayMentsServiceMgr passurePayMentsServiceMgr;
	
	@Autowired
	private BillCheckServiceMgr billCheckServiceMgr;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;
	
	@Autowired
	private ApplyInfoServiceMgr applyInfoServiceMgr;
	

	// 点击担保登记在此处理
	@SuppressWarnings("unchecked")
	@RequestMapping("")
	public String list(HttpServletRequest request, BaseConditionVO vo,Model model) {
		System.out.println("进入担保登记Controller了！");
		Map<Object, Object> criterias = new HashMap<Object, Object>();
        
		String casenumbers = request.getParameter("casenumbers");
		String shipnames = request.getParameter("shipnames");
		String excasenumber = request.getParameter("excasenumber");
		String billstatus = request.getParameter("billstatus");
		// 设置查询条件
		criterias.put("casenumber", casenumbers);
		criterias.put("shipname", shipnames);
		criterias.put("excasenumber", excasenumber);
		criterias.put("billstatus", billstatus);
		
		Map<Object, Object> caseinfomap = passureInfosServiceMgr.searchCase(criterias,vo);
		List<CaseInfoImpl> caseList = (List<CaseInfoImpl>) caseinfomap.get("caseList");
		vo.setTotalCount((Integer) caseinfomap.get("count"));
		model.addAttribute("vo", vo);
		model.addAttribute("caseList", caseList);
		model.addAttribute("casestatus", request.getParameter("casestatus"));
		
		model.addAttribute("casenumbers", casenumbers);
		model.addAttribute("shipnames", shipnames);
		model.addAttribute("excasenumber", excasenumber);
		model.addAttribute("billstatus", billstatus);
		return "/passure/pcaseList";
	}

	// 点击进入添加账单、中再担保、协办人选项卡页面,分页以三个vo显示
	@RequestMapping("/edit/{caseId}")
	public String elist(@PathVariable("caseId") String caseId,Model model, HttpServletRequest request) {
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);
		model.addAttribute("caseInfoImpl", caseInfoImpl);

		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("caseId", caseInfoImpl.getCaseId());

		// 查询该案件下的担保账单
		BaseConditionVO vo1 = new BaseConditionVO();
		vo1.setPageSize(20);
		
		//枚举类显示账单状态
		model.addAttribute("assurestatue", AssureStatus.values());
		
		// 判断账单类型为assurebill是担保账单
		criterias.put("assurefeeflag", 1);
		List<CaseBillImpl> caseBillList = caseBillServiceMgr.searchCaseBill(criterias, vo1);
		vo1.setTotalCount(caseBillList.size());
		model.addAttribute("caseBillList", caseBillList);
		model.addAttribute("vo", vo1);
		model.addAttribute("total1", caseBillList.size());

		// 中再担保
		BaseConditionVO vo2 = new BaseConditionVO();
		vo2.setPageSize(20);
		
		List<PassureInfos> passurelist = passureInfosServiceMgr.searchAllPassureInfos(vo2, criterias);
		TblPassureInfosExample example = new TblPassureInfosExample();
		int total = passureInfosServiceMgr.countPassureInfos(example, criterias);
		vo2.setTotalCount(total);
		model.addAttribute("passurelist", passurelist);
		model.addAttribute("vo", vo2);

		// 协办人
		BaseConditionVO vo3 = new BaseConditionVO();
		vo3.setPageSize(0);
		
		List<CaseHandleImpl> caseHandleList = caseHandleServiceMgr.searchCaseHandle(criterias, vo3);
		vo3.setTotalCount(caseHandleList.size());
		model.addAttribute("caseHandleList", caseHandleList);
		model.addAttribute("vo3", vo3);

		model.addAttribute("caseId", caseId);

		request.getSession().setAttribute("caseId", caseId);
		request.getSession().setAttribute("casenumber",caseInfoImpl.getCasenumber());

		model.addAttribute("currency", Jutil.getDictEntry("currency"));
		model.addAttribute("casetype", Jutil.getDictEntry("casetype"));
		return "/passure/pcaseEdit";
	}

	// 点击搜索担保账单刷新
	@RequestMapping("/pmybillsearch")
	public String pmybillsearch(Model model, BaseConditionVO vo1,HttpServletRequest request) {
		
		System.out.println("进入担保账单刷新！vo1.pageSize="+vo1.getPageSize());
		
		//设置担保账单查询条件
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		String caseId = (String) request.getSession().getAttribute("caseId");
		criterias.put("caseId", caseId);

		String feenumber = request.getParameter("feenumber");
		criterias.put("feenumber", feenumber);

		String feestatuse = request.getParameter("feestatuse");
		criterias.put("feestatuse", feestatuse);

		String currency = request.getParameter("currency");
		criterias.put("currency", currency);

		String accdate1 = request.getParameter("accdate1");
		criterias.put("accdate1", accdate1);

		String accdate2 = request.getParameter("accdate2");
		criterias.put("accdate2", accdate2);

		//判断账单类型为assurebill的为担保账单
		criterias.put("assurefeeflag", 1);
		List<CaseBillImpl> caseBillList = caseBillServiceMgr.searchCaseBill(criterias, vo1);
		vo1.setTotalCount(caseBillList.size());

		model.addAttribute("caseBillList", caseBillList);
		model.addAttribute("vo", vo1);
		model.addAttribute("total1", caseBillList.size());

		return "/passure/pmyBillList";
	}

	// 点击搜索中再担保刷新
	@RequestMapping("/searchPassure")
	public String searchPassure(Model model,BaseConditionVO vo2,HttpServletRequest request) {
		
		System.out.println("进入担保刷新！vo2.pageSize="+vo2.getPageSize());

		//设置担保查询条件
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		String caseId = (String) request.getSession().getAttribute("caseId");
		criterias.put("caseId", caseId);

		String assurenum = request.getParameter("assurenum");
		criterias.put("assurenum", assurenum);

		String currency = request.getParameter("currency");
		criterias.put("currency", currency);

		String accdate1 = request.getParameter("accdate1");
		criterias.put("accdate1", accdate1);

		String accdate2 = request.getParameter("accdate2");
		criterias.put("accdate2", accdate2);

		List<PassureInfos> passurelist = passureInfosServiceMgr.searchAllPassureInfos(vo2, criterias);
		vo2.setTotalCount(passurelist.size());

		model.addAttribute("passurelist", passurelist);
		model.addAttribute("vo", vo2);

		return "/passure/dblist";
	}

	// 点击进入添加中再担保页面
	@RequestMapping("/passureadd")
	public String passureadd(Model model, HttpServletRequest request) {
		model.addAttribute("currency", Jutil.getDictEntry("pccurrency"));
		return "/passure/passureadd";
	}

	// 点击添加中再担保信息
	@Log(message="{0} 添加担保编号 {1}。")
	@RequestMapping("/insert")
	public ModelAndView passureinsert(HttpServletRequest request,PassureInfos passureInfos) {
		System.out.println("进入中再担保添加Controller了！");
		/**
		 * 担保编号可以重复方便按反担保人分类统计
		//先判断担保编号是否已存在
		TblPassureInfosExample example = new TblPassureInfosExample();
		List<PassureInfos> pi = passureInfosServiceMgr.searchall(example);
		for(int i=0;i<pi.size();i++){
			if(pi.get(i).getAssurenum().equals(passureInfos.getAssurenum())){
				return ajaxDoneError("担保编号已存在请重新输入！");
			}
		}
		**/
		String rs = String.valueOf(request.getSession().getAttribute("caseId"));
		passureInfos.setCaseid(Long.valueOf(rs));
		String oid = request.getParameter("rewarranter.oid");
		passureInfos.setRewarranterid(Long.valueOf(oid));
		String name = request.getParameter("rewarranter.name");
		passureInfos.setRewarranter(name);
		String names = request.getParameter("rewarranter.names");
		passureInfos.setRewarrantersn(names);
		Long propertyid = Long.valueOf(request.getParameter("rewarranter.propertyid"));
		passureInfos.setRewarranttypeid(propertyid);
		String propertyname = request.getParameter("rewarranter.propertyname");
		passureInfos.setRewarranttype(propertyname);
		passureInfos.setFeeid(Long.valueOf(0));
		passureInfos.setPaymentid(Long.valueOf(0));
		
		if (passureInfos.getReceiveflag() == null) {
			passureInfos.setReceiveflag("0");
		}
		if (passureInfos.getReportflag() == null) {
			passureInfos.setReportflag("0");
		}
		//设置担保状态为未发账
		passureInfos.setFeestatuse(AssureStatus.AssureStatus0.getCode());
		
		passureInfosServiceMgr.add(passureInfos);
		
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),passureInfos.getAssurenum()}));
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	// 点击进入修改中再担保页面
	@RequestMapping("/pedit/{seqId}")
	public String pedit(@PathVariable("seqId") String seqId, Model model) {
		PassureInfos passure = passureInfosServiceMgr.getPassureInfos(Long.valueOf(seqId));
		model.addAttribute("passure", passure);
		model.addAttribute("currency", Jutil.getDictEntry("pccurrency"));
		return "/passure/passureedit";
	}

	// 修改中再担保信息
	@RequestMapping("/update")
    @Log(message="{0} 修改担保编号 {1}。")
	public ModelAndView pupdate(PassureInfos passureInfos,HttpServletRequest request) {
		System.out.println("进入中再担保修改Controller了！");
		String oid = request.getParameter("rewarranter.oid");
		passureInfos.setRewarranterid(Long.valueOf(oid));
		String name = request.getParameter("rewarranter.name");
		passureInfos.setRewarranter(name);
		String names = request.getParameter("rewarranter.names");
		passureInfos.setRewarrantersn(names);
		String propertyname = request.getParameter("rewarranter.propertyname");
		passureInfos.setRewarranttype(propertyname);
		passureInfosServiceMgr.update(passureInfos);
		
		try{
			//添加日志信息
			User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),passureInfos.getAssurenum()}));
		}catch(Exception e){
			e.printStackTrace();
		}
				return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	// 删除中再担保信息
	@Log(message="{0} 删除担保编号 {1}。")
	@RequestMapping("/pdelete/{seqId}")
	public ModelAndView pdelete(@PathVariable("seqId") Long seqId,HttpServletRequest request) {
		
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		PassureInfos pif = passureInfosServiceMgr.getPassureInfos(seqId);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),pif.getAssurenum()}));

		passureInfosServiceMgr.deleteByPrimaryKey(seqId);
		return ajaxDone3(200, getMessage("msg.operation.success"), "passure");
	}

	// 点击进入添加担保账单页面
	@RequestMapping("/billadd")
	public String addpassurebill(HttpServletRequest request, Model model) {
		String caseId = String.valueOf(request.getSession().getAttribute("caseId"));
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("caseId", caseInfoImpl.getCaseId());

		//因为还未生成账单故不存在已生成账单的担保
		BaseConditionVO vo1 = new BaseConditionVO();
		vo1.setTotalCount(0);
		model.addAttribute("vo1", vo1);
		
		// 获取该案件下未生成账单的中再担保
		BaseConditionVO vo2 = new BaseConditionVO();
		vo2.setPageNum(1);

		criterias.put("bflag", "1");
		List<PassureInfos> unpassurelist = passureInfosServiceMgr.searchAllPassureInfos(vo2, criterias);
		model.addAttribute("unpassurelist", unpassurelist);

		vo2.setTotalCount(unpassurelist.size());
		model.addAttribute("vo2", vo2);

		model.addAttribute("caseInfoImpl", caseInfoImpl);
		model.addAttribute("caseBillImpl", new CaseBillImpl());
		model.addAttribute("currency", Jutil.getDictEntry("currency"));
		return "/passure/assurebillinfo";
	}

	// 未生成担保账单刷新
	@RequestMapping("/unarrbillsearch")
	public String unarrbillsearch(Model model, HttpServletRequest request) {
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		String caseId = (String) request.getSession().getAttribute("caseId");
		criterias.put("caseId", caseId);

		// 未生成担保账单判断
		criterias.put("bflag", "1");

		// 页面搜索条件判断
		String rewarranter = request.getParameter("rewarranter");
		criterias.put("rewarranter", rewarranter);

		String assurenum = request.getParameter("assurenum");
		criterias.put("assurenum", assurenum);

		String currency = request.getParameter("currency");
		criterias.put("currency", currency);

		String assurefee1 = request.getParameter("assurefee1");
		criterias.put("assurefee1", assurefee1);

		String assurefee2 = request.getParameter("assurefee2");
		criterias.put("assurefee2", assurefee2);

		BaseConditionVO vo2 = new BaseConditionVO();
		vo2.setPageNum(1);
		List<PassureInfos> unpassurelist = passureInfosServiceMgr.searchAllPassureInfos(vo2, criterias);
		vo2.setTotalCount(unpassurelist.size());

		model.addAttribute("unpassurelist", unpassurelist);
		model.addAttribute("vo2", vo2);

		return "/passure/unarrbill";
	}

	// 已生成担保账单刷新
	@RequestMapping("/arrbillsearch")
	public String arrbillsearch(Model model, HttpServletRequest request) {
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		
		//案件下判断
		String caseId = (String) request.getSession().getAttribute("caseId");
		criterias.put("caseId", caseId);
		
		//账单下判断
		String bid = request.getParameter("billId");
		if(!"".equals(bid) && null!=bid){
			criterias.put("feeid", bid);
			request.getSession().setAttribute("billId", bid);
		}

		// 已生成担保账单判断
		criterias.put("aflag", "1");

		// 页面搜索条件判断
		String rewarranter = request.getParameter("rewarranter");
		criterias.put("rewarranter", rewarranter);

		String assurenum = request.getParameter("assurenum");
		criterias.put("assurenum", assurenum);

		String currency = request.getParameter("currency");
		criterias.put("currency", currency);

		String assurefee1 = request.getParameter("assurefee1");
		criterias.put("assurefee1", assurefee1);

		String assurefee2 = request.getParameter("assurefee2");
		criterias.put("assurefee2", assurefee2);

		BaseConditionVO vo1 = new BaseConditionVO();
		vo1.setPageNum(1);
		List<PassureInfos> passurelist = passureInfosServiceMgr.searchAllPassureInfos(vo1, criterias);
		vo1.setTotalCount(passurelist.size());

		model.addAttribute("passurelist", passurelist);
		model.addAttribute("vo1", vo1);		

		return "/passure/arrbill";
	}

	// 添加担保账单
	@Log(message="{0} 添加担保账单 {1}。")
	@RequestMapping("/billinsert")
	public ModelAndView insertAndUpdate(HttpServletRequest request,CaseBillImpl caseBillImpl) throws ServiceException {
		System.out.println("进入添加担保账单Controller了");
		System.out.println("账单IDcasebill："+caseBillImpl.getBillId());
		System.out.println("账单IDrequest："+request.getParameter("billId"));
		if (CommonUtil.isEmpty(request.getParameter("billId"))) {
			if (CommonUtil.isEmpty(request.getParameter("passureid"))) {
				return ajaxDoneError("请选择未生成账单担保手续费！");
			} else {
				String[] pid = request.getParameter("passureid").split(",");
				passureInfosServiceMgr.addpassurebill(pid, caseBillImpl, request);
				String forwardUrl = request.getParameter("forwardUrl");
				if (forwardUrl != null) {
					forwardUrl = forwardUrl.replace("{billId}",String.valueOf(caseBillImpl.getBillId()));
					String message = getMessage("msg.operation.success");
					return ajaxDone(200, message,"","", forwardUrl);
				}
				//添加日志信息
				User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
				LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),caseBillImpl.getBillId()}));

			}
		} else {
//			caseBillImpl = caseBillServiceMgr.getCaseBill((String)request.getSession().getAttribute("billId"));
			caseBillImpl = caseBillServiceMgr.getCaseBill(request.getParameter("billId"));
			if ("1".equals(caseBillImpl.getFeestatuse())) {
				return ajaxDoneError("已提交财务不可修改！！");
			}
			if ("2".equals(caseBillImpl.getFeestatuse())) {
				return ajaxDoneError("已到账不可修改！！");
			}
			if ("3".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("已提交申请审批不可修改！！");
			}
			if ("4".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("审批中不可修改！！");
			}
			if ("5".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("划付确认中不可修改！！");
			}
			if ("6".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("已划付不可修改！！");
			}
			if (CommonUtil.isEmpty(request.getParameter("passureid"))) {
				return ajaxDoneError("请选择未生成账单担保手续费！");
			} else {
				String[] pid = request.getParameter("passureid").split(",");
				passureInfosServiceMgr.addpassurebill(pid, caseBillImpl, request);
				String forwardUrl = request.getParameter("forwardUrl");
				if (forwardUrl != null) {
					forwardUrl = forwardUrl.replace("{billId}",String.valueOf(caseBillImpl.getBillId()));
					String message = getMessage("msg.operation.success");
					return ajaxDone(200, message,"","", forwardUrl);
				}
			}
		}		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	// 去除担保
	@RequestMapping("/billcut")
	public ModelAndView billcut(HttpServletRequest request,CaseBillImpl caseBillImpl) throws ServiceException {
		System.out.println("进入去除担保Controller了");
		System.out.println("账单ID："+caseBillImpl.getBillId()+request.getSession().getAttribute("billId"));
		caseBillImpl = caseBillServiceMgr.getCaseBill(request.getParameter("billId"));
		if (CommonUtil.isEmpty(caseBillImpl.getBillId())) {			
				return ajaxDoneError("请先生成担保账单！");
		} else {
			if ("1".equals(caseBillImpl.getFeestatuse())) {
				return ajaxDoneError("已提交财务不可修改！！");
			}
			if ("2".equals(caseBillImpl.getFeestatuse())) {
				return ajaxDoneError("已到账不可修改！！");
			}
			if ("3".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("已提交申请审批不可修改！！");
			}
			if ("4".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("审批中不可修改！！");
			}
			if ("5".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("划付确认中不可修改！！");
			}
			if ("6".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("已划付不可修改！！");
			}
			if (CommonUtil.isEmpty(request.getParameter("pid"))) {
				return ajaxDoneError("请选择已生成账单担保手续费！");
			} else {
				String[] pid = request.getParameter("pid").split(",");
				passureInfosServiceMgr.cutpassurebill(pid, caseBillImpl, request);
				String forwardUrl = request.getParameter("forwardUrl");
				if (forwardUrl != null) {
					forwardUrl = forwardUrl.replace("{billId}",String.valueOf(caseBillImpl.getBillId()));
					String message = getMessage("msg.operation.success");
					return ajaxDone(200, message,"","", forwardUrl);
				}
			}
		}	
	    return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	// 点击保存担保账单按钮
	@RequestMapping("/billsave")
	public ModelAndView billsave(HttpServletRequest request,CaseBillImpl caseBillImpl) {
		System.out.println("进入保存担保账单Controller了");
		if (CommonUtil.isEmpty(request.getParameter("billId"))) {
			return ajaxDoneError("请先生成担保账单！");
		} else {
			if ("1".equals(caseBillImpl.getFeestatuse())) {
				return ajaxDoneError("已提交财务不可修改！！");
			}
			if ("2".equals(caseBillImpl.getFeestatuse())) {
				return ajaxDoneError("已到账不可修改！！");
			}
			if ("3".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("已提交申请审批不可修改！！");
			}
			if ("4".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("审批中不可修改！！");
			}
			if ("5".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("划付确认中不可修改！！");
			}
			if ("6".equals(caseBillImpl.getFeestatuse())){
				return ajaxDoneError("已划付不可修改！！");
			}
			caseBillServiceMgr.updateCaseBill(caseBillImpl);
			String forwardUrl = request.getParameter("forwardUrl");
			if (forwardUrl != null) {
				forwardUrl = forwardUrl.replace("{billId}",String.valueOf(caseBillImpl.getBillId()));
				String message = getMessage("msg.operation.success");
				return ajaxDone(200, message, "", "", forwardUrl);
			}
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	// 点击进入编辑担保账单
	@RequestMapping("/assurebilledit/{billId}")
	public String billedit(@PathVariable("billId") String billId, Model model,HttpServletRequest request) {
		System.out.println("进入编辑担保账单Controller!");
		BaseConditionVO vo = new BaseConditionVO();
		vo.setPageNum(1);
		vo.setPageSize(20);
		String caseId = request.getSession().getAttribute("caseId").toString();
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);
		Map<Object, Object> criteria = new HashMap<Object, Object>();
		try {		
			// 获取该案件下已生成账单的中再担保
			BaseConditionVO vo1 = new BaseConditionVO();
			criteria.put("caseId", caseInfoImpl.getCaseId());
			criteria.put("aflag", "1");
			criteria.put("feeid", billId);
			List<PassureInfos> passurelist = passureInfosServiceMgr.searchAllPassureInfos(vo, criteria);
			vo1.setTotalCount(passurelist.size());
			model.addAttribute("passurelist", passurelist);
			model.addAttribute("vo1", vo1);

			// 获取该案件下未生成账单的中再担保
			BaseConditionVO vo2 = new BaseConditionVO();
			criteria.clear();
			criteria.put("caseId", caseInfoImpl.getCaseId());
			criteria.put("bflag", "1");
			List<PassureInfos> unpassurelist = passureInfosServiceMgr.searchAllPassureInfos(vo, criteria);
			vo2.setTotalCount(unpassurelist.size());
			model.addAttribute("unpassurelist", unpassurelist);
			model.addAttribute("vo2", vo2);

			model.addAttribute("caseInfoImpl", caseInfoImpl);
			CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(billId);
			model.addAttribute("caseBillImpl", caseBillImpl);

//			request.getSession().setAttribute("billId", billId);
			request.getSession().setAttribute("feenumber",caseBillImpl.getFeenumber());
			model.addAttribute("currency", Jutil.getDictEntry("currency"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/passure/assurebillinfo";
	}


//	  //删除担保账单
//	 
//	  @RequestMapping("billdelete/{billId ") public ModelAndView billdelete(@PathVariable("billId") Long billId){ 
//	        caseBillServiceMgr.delete(billId); 
//	        return ajaxDone3(200,getMessage("msg.operation.success"),"passure");
//	 }
	 

	// 担保账单提交财务
	@Log(message="{0} 将担保账单  {1} 提交财务。")
	@RequestMapping("/assurebillsend")
	public ModelAndView assurebillsend(HttpServletRequest request) throws ServiceException {
		System.out.println("进入账单提交财务Controller了！");
		String billId = request.getParameter("billId");
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(billId);
		System.out.println("账单状态"+caseBillImpl.getFeestatuse());
		if ("2".equals(caseBillImpl.getFeestatuse())) {
			return ajaxDoneError("账单已到账!");
		}

		if ("1".equals(caseBillImpl.getFeestatuse())) {
			return ajaxDoneError("不用重复发账!");
		}
		
		if(caseBillImpl.getFeeamount() <= 0){
			return ajaxDoneError("发账金额必须大于0!");
		}
		
		try{
			passureInfosServiceMgr.assureSendBill(caseBillImpl);
		}catch(Exception e){
			return ajaxDoneError(e.getMessage());
		}
		
		String forwardUrl = request.getParameter("forwardUrl");
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{billId}",String.valueOf(caseBillImpl.getBillId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message, "", "", forwardUrl);
		}
		
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),caseBillImpl.getBillId()}));

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	//撤回担保账单
	@RequestMapping("/cancelbill")
	public ModelAndView cancelbill(HttpServletRequest request) throws ServiceException {
		System.out.println("进入撤销账单Controller了！");
		String billId = request.getParameter("billId");
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(billId);
		caseBillImpl.setFeestatuse(AccStatus.AccNew.getCode());
		caseBillServiceMgr.updateCaseBill(caseBillImpl);
		
		BillCheckImpl billCheckImpl =billCheckServiceMgr.getBillCheckByBillId(caseBillImpl.getBillId().toString());
		billCheckImpl.setFlag("0"); //0 失效,1 有效
		billCheckServiceMgr.updBillCheck(billCheckImpl);
		
		
		// 修改tbl_passureinfos发账时间
		Long billid = caseBillImpl.getBillId();
		System.out.println("billid:"+billid);
		Long caseid = caseBillImpl.getCaseId();
		System.out.println("caseid:"+caseid);

		StringBuffer tp = new StringBuffer(16);
		tp.append("select passureid from tbl_passureinfos where caseid = '"+caseid+"' and feeid = '"+billid+"'  ");
		List tplist = Jutil.executeSQL(tp.toString());
		//对list进行迭代取出passureid
		Iterator  it = tplist.iterator();
		while(it.hasNext()){
			Map ss = (Map)it.next();
			System.out.println("是否取到值？："+ss.get("passureid"));
			TblPassureInfos pif = passuremapper.selectByPrimaryKey((Long) ss.get("passureid"));
			System.out.println("pif是什么？"+pif);
        	pif.setAccdate(null);
        	pif.setFeestatuse(AssureStatus.AssureStatus0.getCode());
        	passuremapper.updateByPrimaryKeySelective(pif);
    		System.out.println("更新担保信息完毕！");
    		
			if(!"HTPI1300".equals(caseBillImpl.getCasenumber().substring(0, 8))){
				/*添加财务凭证 start */
				MMap mmap = new MMap();
				mmap.put("bill_id", caseBillImpl.getBillId());
				mmap.put("passureid",pif.getPassureid());
				calFinItemServiceMgr.dealFinItem("112", mmap,-1);
				/*end*/
			}
		}
		
        System.out.println("修改tbl_passureinfos状态完毕！");
		
		String forwardUrl = request.getParameter("forwardUrl");
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{billId}",String.valueOf(caseBillImpl.getBillId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message, "", "", forwardUrl);
		}
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	// 担保划付
	@RequestMapping("/payment")
	public String paymentlist(BaseConditionVO vo, Model model) {	
		Map<Object, Object> criterias = new HashMap<Object, Object>();	
		criterias.put("chflag", 1);
		criterias.put("payflag", 1);
//		criterias.put("feestatuse", 2);
		List<PassureInfos> piflist = passureInfosServiceMgr.searchAllPassureInfos(vo, criterias); 
		int total = passureInfosServiceMgr.countPassureInfos(criterias);
		vo.setTotalCount(total);
		model.addAttribute("piflist", piflist);
		model.addAttribute("vo", vo);
		//枚举类显示账单状态
		model.addAttribute("assurestatue", AssureStatus.values());
		return "/passure/chplist";
	}
	
	
	
	//点击担保手续费呈批
	@SuppressWarnings("rawtypes")
	@RequestMapping("/dbcplist")
	public ModelAndView chpcplist(BaseConditionVO vo,HttpServletRequest request) {	
		try{
		ModelAndView model = new ModelAndView();
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		
		//先生成划付列表
			List list = passureInfosServiceMgr.searchunapply();
						/*if (list.size() == 0 && lt.size() == 0) {
				return ajaxDoneError("没有要申请呈批的担保");
			}else*/ 
			if (list.size() > 0) {
				System.out.println("有需要申请呈批的担保");
				TblPassurePayMents	tp = passurePayMentsServiceMgr.createpayment(list);
//			model.addObject("tp", tp);
			}
			
			/*//当天有到账担保同时系统中无已申请呈批的担保则直接进入提交呈批页面
			System.out.println("进入提交呈批页面！");	

			// 已申请呈批担保，担保状态为3
			vo.setPageNum(1);
			criterias.put("statusflag", AssureStatus.AssureStatus3.getCode());
			criterias.put("paymentid", tp.getPassurepayid());
			List<PassureInfos> piflist = passureInfosServiceMgr.searchAllPassureInfos(vo, criterias);

			// 未提交呈批担保，担保状态为2
			BaseConditionVO vo1 = new BaseConditionVO();
			vo1.setPageNum(1);
			criterias.clear();
			criterias.put("statusflag", AssureStatus.AssureStatus2.getCode());
			List<PassureInfos> plist = passureInfosServiceMgr.searchAllPassureInfos(vo1, criterias);
			vo1.setTotalCount(plist.size());
			
			// 添加入model
			model.addObject("piflist", piflist);
			model.addObject("plist", plist);
			model.addObject("vo", vo);
			model.addObject("total", piflist.size());
			model.addObject("vo1", vo1);
			model.setViewName("/passure/psubmitlistinfo");

			return model;				
			} else {*/
//				criterias.put("reportflag", "yes");
			    criterias.put("onlyflag", "yes");
				List<TblPassurePayMents> pylist = passurePayMentsServiceMgr.searchPassurePayMents(vo, criterias, null, vo.getStartIndex(),vo.getPageSize());
				vo.setTotalCount(pylist.size());
				model.addObject("pylist", pylist);
				model.addObject("vo", vo);
				model.setViewName("/passure/paymentlist");
				return model;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;	

	}

	
/*	//担保呈批
	@RequestMapping("/chp")
	public String chplist(BaseConditionVO vo, Model model) {
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("reportflag", "no");
		List<TblPassurePayMents> pylist = passurePayMentsServiceMgr.searchPassurePayMents(vo, criterias, null, vo.getStartIndex(),vo.getPageSize());
		vo.setTotalCount(pylist.size());
		model.addAttribute("pylist", pylist);
		model.addAttribute("vo", vo);
		return "/passure/paymentlist";
}*/
	
	//保存担保呈批件
	@RequestMapping("/saveApplyInfos")
	public ModelAndView insertApplyInfos(ApplyInfos applyInfos,HttpServletRequest request){
		System.out.println("进入保存呈批件！");
	     try
		   {
		 	   User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
			  //增加担保审批流程
		 	   List<Map> ls=applyInfoServiceMgr.getProcessDefByNo("0003");
				
			if(ls!=null && ls.size()!=0){
				Map mp=ls.get(0);
				
				Long payId = Long.valueOf(request.getParameter("payId"));
				Long year = Long.valueOf(request.getParameter("year"));
				Long month = Long.valueOf(request.getParameter("month"));
				TblPassurePayMents tpm = passurePayMentsServiceMgr.selectpassurepayments(payId);
				tpm.setYear(year);
				tpm.setMonth(month);
				passurePayMentsServiceMgr.updpayment(tpm);
				if(null!=tpm.getCpid()&&!"".equals(tpm.getCpid())){
					applyInfos = applyInfoServiceMgr.searchApplyInfosByOid(tpm.getCpid());
					applyInfos.setProcessdefid(Long.valueOf(mp.get("Process_Def_Id").toString()));
					applyInfos.setProcessname(mp.get("Process_Name").toString());
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String time = format.format(tpm.getCreatedate());
					applyInfos.setName(time);
					applyInfos.setParentid(tpm.getPassurepayid());
//					applyInfos.setName("("+caseInfoImpl.getCasenumber()+")"+shipname);
					applyInfos.setApplydes(tpm.getReceivedetail());
					applyInfos.setCurrency("USD");
					applyInfos.setAmounta(tpm.getFeemount());
					
					
					applyInfos.setStatus("new");
					applyInfos.setApplytype("assure");
					applyInfos.setCreatdate(new Date());
					applyInfoServiceMgr.updateApplyInfosById(applyInfos);
				}else{
					applyInfos.setProcessdefid(Long.valueOf(mp.get("Process_Def_Id").toString()));
					applyInfos.setProcessname(mp.get("Process_Name").toString());
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String time = format.format(tpm.getCreatedate());
					applyInfos.setName(time);
					applyInfos.setParentid(tpm.getPassurepayid());
//					applyInfos.setName("("+caseInfoImpl.getCasenumber()+")"+shipname);
					applyInfos.setApplydes(tpm.getReceivedetail());
					applyInfos.setCurrency("USD");
					applyInfos.setAmounta(tpm.getFeemount());
					
					
					applyInfos.setStatus("new");
					applyInfos.setApplytype("assure");
					
					applyInfoServiceMgr.addOrUpdApplyInfos(applyInfos, request);
				}

				
				tpm.setReportflag("save");
				tpm.setCpid(applyInfos.getId());
				passurePayMentsServiceMgr.updpayment(tpm);
				
				
/*	        	//跳转刷新直接进入呈批件内容页面
	        	String forwardUrl = request.getParameter("forwardUrl");
//	        	String payid = request.getParameter("payid");
	    		if (forwardUrl != null) {
//					forwardUrl = forwardUrl.replace("{payid}",payid);
	    			String message = getMessage("msg.operation.success");
	    			return ajaxDone(200, message,"","", forwardUrl);
	    		}*/
	    		
	        	//跳转刷新本页面
	        	String forwardUrl = request.getParameter("forwardUrl");
	        	String payid = request.getParameter("payid");                                                                                       
	    		if (forwardUrl != null) {
					forwardUrl = forwardUrl.replace("{payid}",payid);
	    			String message = getMessage("msg.operation.success");
	    			return ajaxDone(200, message,"","", forwardUrl);
	    		}

				LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"新增",applyInfos.getName()}));

			}else{
				return ajaxDoneError(getMessage("passurepayments.error"));
			}
			  return ajaxDoneSuccess(getMessage("msg.operation.success"));
			}catch (Exception e) 
			{
				e.printStackTrace();
				return ajaxDoneError(getMessage("msg.operation.failure"));
			}
		}
	
	

/*	// 点击生成划付列表
	@SuppressWarnings("rawtypes")
	@RequestMapping("/createpaymentlist")
	public ModelAndView creatpaymentlist(HttpServletRequest request,BaseConditionVO vo) throws ServiceException {
		System.out.println("进入生成划付列表Controller！");
		ModelAndView model = new ModelAndView();
		//查询所有未提交划付申请的担保信息
		List list = passureInfosServiceMgr.searchunapply();
				
		if (list.size() == 0) {
			return ajaxDoneError("没有要划付的担保");
		} else {
			System.out.println("有需要划付的担保");
			TblPassurePayMents tpp = passurePayMentsServiceMgr.createpayment(list);

			// 生成划付申请单后返回刷新本页面
			Map<Object, Object> criteria = new HashMap<Object, Object>();
			criteria.put("aflag", 1);
			List<PassurePayMents> pylist = passurePayMentsServiceMgr.searchPassurePayMents(vo, criteria, null,vo.getStartIndex(), vo.getPageSize());
			vo.setTotalCount(pylist.size());
			model.addObject("pylist", pylist);
			model.addObject("vo", vo);
			model.setViewName("/passure/paymentlist");
			
			return model;
		}

	}*/

	// 点击进入提交担保呈批页面
	@RequestMapping("/passuresubmit/{payid}")
	public String assuresubmit(@PathVariable("payid") String payid,Model model, HttpServletRequest request) {
		System.out.println("进入提交担保呈批页面了！");
		Long paymentid = Long.valueOf(payid);
		TblPassurePayMents tp = passurePayMentsServiceMgr.selectpassurepayments(paymentid);		
		Map<Object, Object> criterias = new HashMap<Object, Object>();

		// 对应已提交划付申请未提交审批担保
		criterias.put("paymentid", paymentid);
		BaseConditionVO vo = new BaseConditionVO();
		vo.setPageNum(1);
		List<PassureInfos> piflist = passureInfosServiceMgr.searchAllPassureInfos(vo, criterias);

		// 未提交划付申请担保
		BaseConditionVO vo1 = new BaseConditionVO();
		vo1.setPageNum(1);
		criterias.clear();
		criterias.put("paflag", 1);
		criterias.put("pbflag", 1);
		List<PassureInfos> plist = passureInfosServiceMgr.searchAllPassureInfos(vo1, criterias);

		// 添加入model
		model.addAttribute("tp", tp);
		model.addAttribute("payid", payid);
		model.addAttribute("piflist", piflist);
		model.addAttribute("plist", plist);
		model.addAttribute("vo", vo);
		model.addAttribute("total", piflist.size());
		model.addAttribute("vo1", vo1);
		
		request.getSession().setAttribute("paymentid", payid);

		return "/passure/psubmitlistinfo";
	}
	
	//对应已申请呈批搜索刷新
	@RequestMapping("/applysearch")
	public String applysearch(Model model,HttpServletRequest request){
		
        Map<Object, Object> criterias = new HashMap<Object, Object>();

		// 页面搜索条件判断
		String rewarranter = request.getParameter("rewarranter");
		criterias.put("rewarranter", rewarranter);

		String assurenum = request.getParameter("assurenum");
		criterias.put("assurenum", assurenum);

		String currency = request.getParameter("currency");
		criterias.put("currency", currency);

		String assurefee1 = request.getParameter("assurefee1");
		criterias.put("assurefee1", assurefee1);

		String assurefee2 = request.getParameter("assurefee2");
		criterias.put("assurefee2", assurefee2);

        String paymentid = (String)request.getSession().getAttribute("paymentid");
        
		// 对应已提交划付申请未提交审批担保
		criterias.put("paymentid", paymentid);
		BaseConditionVO vo = new BaseConditionVO();
		vo.setPageNum(1);
		List<PassureInfos> piflist = passureInfosServiceMgr.searchAllPassureInfos(vo, criterias);
		
		vo.setTotalCount(piflist.size());
		model.addAttribute("piflist", piflist);
		model.addAttribute("vo", vo);
			
		return "/passure/passurepaymentlist";
	}
	
	//退回呈批
	@RequestMapping("/backapply")
	public ModelAndView backapply(HttpServletRequest request,PassurePayMents ppm){
        try{
    		PassurePayMents pm = passurePayMentsServiceMgr.getPassurePayMents(ppm.getPassurepayid());
    		String[] pid = request.getParameter("payid").split(",");
    		System.out.println(Arrays.toString(pid));
    		if("yes".equals(String.valueOf(pm.getReportflag()))){
    			System.out.println("判断flag为yes");
        		return ajaxDoneError("已划付不可修改！");
    		}else if("pass".equals(String.valueOf(pm.getReportflag()))){
    			System.out.println("判断flag为pass");
        		return ajaxDoneError("已审批通过不可修改！");
    		}else if("submit".equals(String.valueOf(pm.getReportflag()))){
        		System.out.println("判断flag为submit");
        		return ajaxDoneError("已提交审批不可修改！");
        	}else{
        		System.out.println("判断flag为no");
        		if (CommonUtil.isEmpty(request.getParameter("payid"))) {
    				return ajaxDoneError("请选择已申请呈批担保手续费！");
    			}else{
    				passurePayMentsServiceMgr.backapply(pid,pm);
    			}
        	}
//        	//跳转刷新
//        	String forwardUrl = request.getParameter("forwardUrl");
//        	String payid = String.valueOf(ppm.getPassurepayid());
////    		String payid = (String)request.getSession().getAttribute("paymentid");
//    		if (forwardUrl != null) {
//    			forwardUrl = forwardUrl.replace("{payid}",payid);
//    			String message = getMessage("msg.operation.success");
//    			return ajaxDone(200, message,"","", forwardUrl);
//    		}
        }catch(Exception e){
        	e.printStackTrace();
        }		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	//申请呈批
	@RequestMapping("/sendapply")
	public ModelAndView sendapply(HttpServletRequest request,PassurePayMents ppm){
    		PassurePayMents pm = passurePayMentsServiceMgr.getPassurePayMents(ppm.getPassurepayid());
    		String[] pid = request.getParameter("pid").split(",");
    		if("yes".equals(String.valueOf(pm.getReportflag()))){
    			System.out.println("判断flag为yes");
        		return ajaxDoneError("已划付不可修改！");
    		}else if("pass".equals(String.valueOf(pm.getReportflag()))){
    			System.out.println("判断flag为pass");
        		return ajaxDoneError("已审批通过不可修改！");
    		}else if("submit".equals(String.valueOf(pm.getReportflag()))){
        		return ajaxDoneError("已提交审批不可修改！");
        	}else{
        		if (CommonUtil.isEmpty(request.getParameter("pid"))) {
    				return ajaxDoneError("请选择未申请呈批担保手续费！");
    			}else{
    				passurePayMentsServiceMgr.sendapply(pid, pm);
//    				//跳转刷新
//    	        	String forwardUrl = request.getParameter("forwardUrl");
//    	        	String payid = String.valueOf(ppm.getPassurepayid());
//    	    		if (forwardUrl != null) {
//    	    			forwardUrl = forwardUrl.replace("{payid}",payid);
//    	    			String message = getMessage("msg.operation.success");
//    	    			return ajaxDone(200, message,"","", forwardUrl);
//    			}
        	}
    		}
	
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	//未申请划付担保搜索刷新
	@RequestMapping("/unapplysearch")
	public String unapplysearch(Model model,HttpServletRequest request){
		System.out.println("进入未申请划付担保Controller了！");
        Map<Object, Object> criterias = new HashMap<Object, Object>();

		// 页面搜索条件判断
		String rewarranter = request.getParameter("rewarranter");
		criterias.put("rewarranter", rewarranter);

		String assurenum = request.getParameter("assurenum");
		criterias.put("assurenum", assurenum);

		String currency = request.getParameter("currency");
		criterias.put("currency", currency);

		String assurefee1 = request.getParameter("assurefee1");
		criterias.put("assurefee1", assurefee1);

		String assurefee2 = request.getParameter("assurefee2");
		criterias.put("assurefee2", assurefee2);
        
		// 未提交划付申请未提交审批担保
        criterias.put("paflag", 1);
		criterias.put("pbflag", 1);
		BaseConditionVO vo1 = new BaseConditionVO();
		vo1.setPageNum(1);
		List<PassureInfos> plist = passureInfosServiceMgr.searchAllPassureInfos(vo1, criterias);
		
		vo1.setTotalCount(plist.size());
		model.addAttribute("plist", plist);
		model.addAttribute("vo1", vo1);
			
		return "/passure/unpassurepaymentlist";
	}
	
	
	// 提交划付申请并保存呈批件
	@RequestMapping(value = "/sendpassureapply")
	public ModelAndView sendpassureapply(HttpServletRequest request) throws ServiceException {
		Long passurepayid = Long.valueOf(request.getParameter("passurepayid"));
		System.out.println("id:"+passurepayid);
		PassurePayMents ppm = passurePayMentsServiceMgr.getPassurePayMents(Long.valueOf(passurepayid));
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("paymentid", ppm.getPassurepayid());
		criterias.put("feestatuse", "3");
		BaseConditionVO vo = new BaseConditionVO();
		vo.setPageNum(1);
		List<PassureInfos> plist = passureInfosServiceMgr.searchAllPassureInfos(vo, criterias);
		
		System.out.println("是否提交：" + ppm.getReportflag());
		if (ppm.getReportflag().equals("yes")) {
			return ajaxDoneError("请不要重复提交！");
		} else {
			passurePayMentsServiceMgr.sendpassureapply(ppm,plist);
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		}
	}

	// 担保待划付
	@SuppressWarnings("unchecked")
	@RequestMapping("/unpayment")
	public String unpaymentlist(BaseConditionVO vo, Model model) {
		StringBuffer pm = new StringBuffer(16);
		pm.append("select passurepayid,TRIM(DATE(createdate)) as createdate,userid,username,reportflag,TRIM(DATE(paydate)) as paydate,orgcode,orgname,receivedetail,paydetail from tbl_passurepayments where  paydate IS NULL and reportflag = 'pass' order by createdate DESC");
		List<String> pylist = Jutil.executeSQL(pm.toString(),vo.getStartIndex(), vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(pm.toString()).size());
		model.addAttribute("pylist", pylist);
		model.addAttribute("vo", vo);
		return "/passure/unpaymentlist";
	}

	// 进入担保划付确认页面
	@SuppressWarnings("unchecked")
	@RequestMapping("/unpaysubmit/{payid}")
	public String paysubmit(@PathVariable("payid") String payid, Model model,BaseConditionVO vo) {
		System.out.println("进入担保划付确认页面了！");
		Long paymentid = Long.valueOf(payid);
		TblPassurePayMents tpp = passurePayMentsServiceMgr.selectpassurepayments(paymentid);

		StringBuffer pb = new StringBuffer(16);
//		pb.append("select * from tbl_passureinfos where paymentid = '" + paymentid + "' and feestatuse = '5' ");
		pb.append("select * from tbl_passureinfos where paymentid = '" + paymentid + "' ");

		List<String> paysublist = Jutil.executeSQL(pb.toString(),vo.getStartIndex(), vo.getPageSize());

		vo.setTotalCount(Jutil.executeSQL(pb.toString()).size());
		model.addAttribute("paysublist", paysublist);
		model.addAttribute("tpp", tpp);
		model.addAttribute("vo", vo);
		return "/passure/pasublist";
	}

	// 确认划付
	@Log(message="{0}确认划付担保申请 {1}。")
	@RequestMapping("/paymentupdate")
	public ModelAndView payupdate(PassurePayMents tppm, BaseConditionVO vo,Model model,HttpServletRequest request) {
		System.out.println("进入确认划付Controller了！");
		try {
			// 修改担保划付时间及状态
			Map<Object, Object> criterias = new HashMap<Object, Object>();
			criterias.put("paymentid", tppm.getPassurepayid());
//			criterias.put("feestatuse", "5");
			List<PassureInfos> passurelist = passureInfosServiceMgr.searchPassureInfos(vo, criterias, null,vo.getStartIndex(), vo.getPageSize());

			for (Object oj : passurelist) {
				PassureInfos pif = (PassureInfos) oj;
				if ("5".equals(pif.getFeestatuse())) {
					pif.setPaydate(tppm.getPaydate());
					pif.setFeestatuse(AssureStatus.AssureStatus6.getCode());
					passureInfosServiceMgr.update(pif);
					
					CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(pif.getCaseid().toString());
					if(!"HTPI1300".equals(caseInfoImpl.getCasenumber().substring(0, 8))){
						/*添加财务凭证 start */
						MMap mmap = new MMap();
						mmap.put("passureid", pif.getPassureid());
						calFinItemServiceMgr.dealFinItem("115", mmap,1);
						/*end*/
					}
//					CaseBillImpl cbi = caseBillServiceMgr.getCaseBill(String.valueOf(pif.getFeeid()));
//					cbi.setFeestatuse(AssureStatus.AssureStatus5.getCode());
//					caseBillServiceMgr.updateCaseBill(cbi);
				} else {
					return ajaxDoneError("无此权限进行操作！");
				}
			}
			// 修改划付申请单信息
			TblPassurePayMents tpp = passurePayMentsServiceMgr.selectpassurepayments(tppm.getPassurepayid());
			tpp.setPaydetail(tppm.getPaydetail());
			tpp.setPaydate(tppm.getPaydate());
			User u = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
			//修改人通过Session中取得用户ID来进行修改
			tpp.setModifyoperatorid(u.getId());
			tpp.setModifytime(new Date());
			tpp.setReportflag("yes");
//			passurePayMentsServiceMgr.updatepayment(tppm);
			passurePayMentsServiceMgr.updpayment(tpp);
			
			//跳转刷新本页面
			String forwardUrl = request.getParameter("forwardUrl");
			if (forwardUrl != null) {
				forwardUrl = forwardUrl.replace("{payid}",String.valueOf(tppm.getPassurepayid()));
				String message = getMessage("msg.operation.success");
				return ajaxDone(200, message,"","", forwardUrl);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),tppm.getPassurepayid()}));

		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}

	// 划付查询
	@SuppressWarnings("unchecked")
	@RequestMapping("/pay")
	public String paylist(BaseConditionVO vo, Model model) {
		StringBuffer pa = new StringBuffer(16);
//		pa.append("select passurepayid,TRIM(DATE(createdate)) as createdate,userid,username,reportflag,TRIM(DATE(paydate)) as paydate,orgcode,orgname,receivedetail,paydetail from tbl_passurepayments where reportflag = 'yes' and (paydate IS NOT NULL) order by createdate DESC");
		pa.append("select passurepayid,TRIM(DATE(createdate)) as createdate,userid,username,reportflag,TRIM(DATE(paydate)) as paydate,orgcode,orgname,receivedetail,paydetail from tbl_passurepayments where reportflag <> 'no' order by createdate DESC");
		List<String> plist = Jutil.executeSQL(pa.toString(),vo.getStartIndex(), vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(pa.toString()).size());
		model.addAttribute("plist", plist);
		model.addAttribute("vo", vo);
		return "/passure/paylist";
	}

	// 担保划付详细信息
	@SuppressWarnings("unchecked")
	@RequestMapping("/paysearch/{payid}")
	public String paydetail(@PathVariable("payid") String payid, Model model,BaseConditionVO vo) {
		Long pid = Long.valueOf(payid);
		TblPassurePayMents tpm = passurePayMentsServiceMgr.selectpassurepayments(pid);

		StringBuffer passuredetail = new StringBuffer(16);
		passuredetail.append("select * from tbl_passureinfos where paymentid = '" + pid + "' ");
		List<String> passuredlist = Jutil.executeSQL(passuredetail.toString(),vo.getStartIndex(), vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(passuredetail.toString()).size());
		model.addAttribute("vo", vo);
		model.addAttribute("TblPassurePayMents", tpm);
		model.addAttribute("passuredlist", passuredlist);
		model.addAttribute("payid", payid);
		return "/passure/paydetail";
	}

	// 担保详细信息分页刷新查询
	@SuppressWarnings("unchecked")
	@RequestMapping("/paysearch")
	public String searchpay(HttpServletRequest request, BaseConditionVO vo,Model model) {
		Long payid = Long.valueOf(request.getParameter("payid"));
		TblPassurePayMents tpm = passurePayMentsServiceMgr.selectpassurepayments(payid);

		StringBuffer passuredetail = new StringBuffer(16);
		passuredetail.append("select * from tbl_passureinfos where paymentid = '" + payid + "' ");
	 	List<String> passuredlist = Jutil.executeSQL(passuredetail.toString(),vo.getStartIndex(), vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(passuredetail.toString()).size());
		model.addAttribute("vo", vo);
		model.addAttribute("TblPassurePayMents", tpm);
		model.addAttribute("passuredlist", passuredlist);
		model.addAttribute("payid", payid);
		return "/passure/paydetail";
	}

	// 担保速查
	@SuppressWarnings("unchecked")
	@RequestMapping("/search")
	public String passoue(HttpServletRequest request, BaseConditionVO vo,Model model) {
		StringBuffer sb = new StringBuffer(16);
		String rewarrantersn = request.getParameter("rewarrantersn");
		String assurenum = request.getParameter("assurenum");
		String shipnameb = request.getParameter("shipnameb");
		String remark = request.getParameter("remark");
		String accflag = request.getParameter("accflag");
		String issuedate1 = request.getParameter("issuedate1");
		String issuedate2 = request.getParameter("issuedate2");
		String backdate1 = request.getParameter("backdate1");
		String backdate2 = request.getParameter("backdate2");
		sb.append("select t.passureid,t.caseid,trim(f.casenumber)casenumber,trim(f.excasenumber)excasenumber,f.shipname,t.rewarranter,t.rewarrantersn,t.assurenum,t.issuedate,t.currency,t.assurefee,t.acccurrency,t.accamount,t.remark,t.feestatuse from tbl_passureinfos t,tbl_case f where t.caseid = f.Case_Id  ");
		if (rewarrantersn != null && rewarrantersn != "") {
			sb.append("and t.rewarrantersn like '%" + rewarrantersn + "%' ");
		}
		if (assurenum != null && assurenum != "") {
			sb.append("and t.assurenum like '%" + assurenum + "%' ");
		}
		if (shipnameb != null && shipnameb != "") {
			sb.append("and f.shipname like '%" + shipnameb + "%' ");
		}
		if (remark != null && remark != "") {
			sb.append("and t.remark like '%" + remark + "%' ");
		}
		if("1".equals(accflag)){
			sb.append("and t.accdate is null ");
		}
		if (issuedate1 != null && issuedate1 != "") {
			sb.append("and t.issuedate >= '" + issuedate1 + "' ");
		}
		if (issuedate2 != null && issuedate2 != "") {
			sb.append("and t.issuedate <= '" + issuedate2 + "' ");
		}
		if (backdate1 != null && backdate1 != "") {
			sb.append("and t.backdate >= '" + backdate1 + "' ");
		}
		if (backdate2 != null && backdate2 != "") {
			sb.append("and t.ibackdate <= '" + backdate2 + "' ");
		}
		sb.append("order by t.passureid ");
		List<String> slist = Jutil.executeSQL(sb.toString(),vo.getStartIndex(), vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(sb.toString()).size());
		model.addAttribute("slist", slist);
		model.addAttribute("vo", vo);
		
		model.addAttribute("rewarrantersn", rewarrantersn);
		model.addAttribute("assurenum", assurenum);
		model.addAttribute("shipnameb", shipnameb);
		model.addAttribute("remark", remark);
		model.addAttribute("accflag", accflag);
		model.addAttribute("issuedate1", issuedate1);
		model.addAttribute("issuedate2", issuedate2);
		model.addAttribute("backdate1", backdate1);
		model.addAttribute("backdate2", backdate2);
		//枚举类显示账单状态
		model.addAttribute("assurestatue", AssureStatus.values());
		
		return "/passure/searchlist";
	}

	// 超期未到账
	@SuppressWarnings("unchecked")
	@RequestMapping("/chaoqi")
	public String pfeelist(HttpServletRequest request, BaseConditionVO vo,Model model) {
		StringBuffer cq = new StringBuffer(16);
		String casenumbera = request.getParameter("casenumbera");
		String shipnamec = request.getParameter("shipnamec");
		String accdate1 = request.getParameter("accdate1");
		String accdate2 = request.getParameter("accdate2");
		
		// 日期处理
		Date date = new Date();
		long time = date.getTime();
		time -= (long) 30 * 24 * 60 * 60 * 1000;
		date.setTime(time);
		String fldDATE = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if (date != null) {
				fldDATE = df.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		cq.append("select a.Case_Id as caseid,b.Bill_Id,trim(a.casenumber)casenumber,trim(a.excasenumber)excasenumber,a.shipname,a.casedes,a.consignorsn,b.feenumber,DATE(b.accdate) as accdate,b.currency,b.feeamount from tbl_case a,tbl_case_bill b where a.Case_Id = b.Case_Id and b.arrdate is null and b.feetype = 'assurebill' and b.accdate < '" + fldDATE + "'  ");
		if (casenumbera != null && casenumbera != "") {
			cq.append("and a.casenumber like '%" + casenumbera + "%' ");
		}
		if (shipnamec != null && shipnamec != "") {
			cq.append("and a.shipname like '%" + shipnamec + "%' ");
		}
		if (accdate1 != null && accdate1 != "") {
			cq.append("and b.accdate >= '" + accdate1 + "' ");
		}
		if (accdate2 != null && accdate2 != "") {
			cq.append("and b.accdate <= '" + accdate2 + "' ");
		}
		List<String> clist = Jutil.executeSQL(cq.toString(),
				vo.getStartIndex(), vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(cq.toString()).size());
		model.addAttribute("clist", clist);
		model.addAttribute("vo", vo);
		
		model.addAttribute("casenumbera", casenumbera);
		model.addAttribute("shipnamec", shipnamec);
		model.addAttribute("accdate1", accdate1);
		model.addAttribute("accdate2", accdate2);
		return "/passure/cqlist";
	}

	// 未收正本
	@SuppressWarnings("unchecked")
	@RequestMapping("/weishou")
	public String wslist(HttpServletRequest request, BaseConditionVO vo,Model model) {
		StringBuffer wshou = new StringBuffer(16);
		String assurenum = request.getParameter("assurenum");
		String shipnamed = request.getParameter("shipnamed");
		String issuedate1 = request.getParameter("issuedate1");
		String issuedate2 = request.getParameter("issuedate2");
		
		// 日期规则处理
		Date date = new Date();
		long time = date.getTime();
		time -= (long) 14 * 24 * 60 * 60 * 1000;
		date.setTime(time);
		String fldDATE = "";
		try {
			SimpleDateFormat ws = new SimpleDateFormat("yyyy-MM-dd");
			if (date != null) {
				fldDATE = ws.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		wshou.append("SELECT a.Case_Id as caseid,b.assurenum,a.shipname,a.casedes,b.issuedate,b.currency,b.assurefee,b.rewarrantersn,a.consignorsn,trim(a.casenumber)casenumber,trim(a.excasenumber)excasenumber FROM tbl_case a,tbl_passureinfos b WHERE a.Case_Id = b.caseid AND b.receiveflag = '0' AND b.issuedate < '" + fldDATE + "' ");
		if (assurenum != null && assurenum != "") {
			wshou.append("and assurenum like '%" + assurenum + "%' ");
		}
		if (shipnamed != null && shipnamed != "") {
			wshou.append("and shipname like '%" + shipnamed + "%' ");
		}
		if (issuedate1 != null && issuedate1 != "") {
			wshou.append("and issuedate >= '" + issuedate1 + "' ");
		}
		if (issuedate2 != null && issuedate2 != "") {
			wshou.append("and issuedate <= '" + issuedate2 + "' ");
		}
		List<String> wlist = Jutil.executeSQL(wshou.toString(),
				vo.getStartIndex(), vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(wshou.toString()).size());
		model.addAttribute("wlist", wlist);
		model.addAttribute("vo", vo);
		model.addAttribute("assurenum", assurenum);
		model.addAttribute("shipnamed", shipnamed);
		model.addAttribute("issuedate1", issuedate1);
		model.addAttribute("issuedate2", issuedate2);
		return "/passure/wslist";

	}

}
