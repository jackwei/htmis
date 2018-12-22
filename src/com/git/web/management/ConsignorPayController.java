package com.git.web.management;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.caseService.CaseBillDetailServiceMgr;
import com.git.business.caseService.CaseBillServiceMgr;
import com.git.business.consignorPay.ConsignorPayServiceMgr;
import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.DocInfos;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.ConsignorPayImpl;
import com.git.enums.DocInfoType;
import com.git.enums.PClientStatus;
import com.git.enums.PayStatus;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.CommonUtil;
import com.git.util.Jutil;
import com.git.util.MMap;
import com.git.util.PubDateUtil;
import com.git.web.BaseController;

import dwz.common.util.HtmlOperator;
import dwz.framework.config.Constants;
import dwz.framework.sys.exception.ServiceException;


@Controller
@RequestMapping(value="/management/consignorPay")
public class ConsignorPayController extends BaseController{
	
/*	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;*/
	
	@Autowired
	private ConsignorPayServiceMgr consignorPayServiceMgr;
	
	@Autowired
	private CaseBillDetailServiceMgr caseBillDetailServiceMgr;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;
	
	@Autowired
	private ApplyInfoServiceMgr applyInfoServiceMgr;
	
	@Autowired
	private CaseBillServiceMgr caseBillServiceMgr;
	
	@RequestMapping("/checkPay")
	public ModelAndView checkPay(HttpServletRequest request) throws ServiceException{
		
		ConsignorPayImpl consignorPayImpl = (ConsignorPayImpl)request.getSession().getAttribute("consignorPayImpl");
		
		if(!CommonUtil.isEmpty(consignorPayImpl.getCheckdate())){
			return ajaxDoneError("已经确认支付，不能修改");
		}
		
		String flag = request.getParameter("flag");
		String[] detailIds = request.getParameterValues("detailIds");
		
		for (String detailId : detailIds) {
			CaseBillDetailImpl caseBillDetailImpl = caseBillDetailServiceMgr.searchCaseBillDetail(detailId);
			if("bind".equals(flag) && "null".equals(caseBillDetailImpl.getPayid())){
				caseBillDetailImpl.setStatus(PClientStatus.ClientFee5.getCode());
				caseBillDetailImpl.setPayid(consignorPayImpl.getPayId().toString());
			}else{
				caseBillDetailImpl.setStatus(PClientStatus.ClientFee4.getCode());
				caseBillDetailImpl.setPayid("null");
			}
			
			caseBillDetailServiceMgr.updateCaseBillDetail(caseBillDetailImpl);
		}
		
		List<CaseBillDetailImpl> caseBillDetailList =  caseBillDetailServiceMgr.searchCaseBillDetailByPayId(consignorPayImpl.getPayId().toString());
		
		BigDecimal amount = new BigDecimal(0);
		String currency = "";
		
		for (CaseBillDetailImpl caseBillDetailImpl : caseBillDetailList) {
			amount = amount.add(BigDecimal.valueOf(caseBillDetailImpl.getAccamount()));
			currency = caseBillDetailImpl.getCurrency();
		}
		
		consignorPayImpl.setBinddetail(currency+amount.toString());
		consignorPayImpl.setPayamount(amount.floatValue());
		consignorPayServiceMgr.updateConsignorPay(consignorPayImpl);
		
		String forwardUrl = request.getParameter("forwardUrl");
		
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{payId}", String.valueOf(consignorPayImpl.getPayId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}
		
/*		if("bind".equals(flag)){
			String message = getMessage("msg.operation.success");
			return ajaxDone3(200, message, "unbind");
		}else{
			String message = getMessage("msg.operation.success");
			return ajaxDone3(200, message, "bind");
		}*/
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	@Log(message="用户 {0} 确认第三方划付。")
	@RequestMapping("/payProcess")
	public ModelAndView payProcess(HttpServletRequest request) throws ServiceException{
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);

		ConsignorPayImpl consignorPayImpl = consignorPayServiceMgr.getConsignorPay(request.getParameter("payId"));
		Float usdmoney = consignorPayImpl.getFeeamount();
		Float rmbrate = Float.valueOf(request.getParameter("rmbrate"));
		List<CaseBillDetailImpl> caseBillDetailList =  caseBillDetailServiceMgr.searchCaseBillDetailByPayId(consignorPayImpl.getPayId().toString());
		if(caseBillDetailList.size() < 0){
			return ajaxDoneError("没有绑定任何第三方，不能确认支付");
		}
		
		if(!CommonUtil.isEmpty(consignorPayImpl.getCheckdate())){
			return ajaxDoneError("已经确认支付，不须重复确认");
		}
		
		consignorPayImpl.setPaydate(PubDateUtil.stringToDate(request.getParameter("paydate"),"yyyy-MM-dd"));
		consignorPayImpl.setCheckdate(new Date());
		consignorPayImpl.setBankfee(Float.valueOf(request.getParameter("bankfee")));
		consignorPayImpl.setBanknum(request.getParameter("banknum"));
		consignorPayImpl.setPaystatus(PayStatus.PayEnd.getCode());
		consignorPayImpl.setRmbrate(new BigDecimal(request.getParameter("rmbrate")));
		consignorPayImpl.setRmbamount(Float.valueOf(usdmoney*rmbrate));
		
		consignorPayServiceMgr.updateConsignorPay(consignorPayImpl);
		
		String feenumber = "";
		
		for (CaseBillDetailImpl caseBillDetailImpl : caseBillDetailList) {
			caseBillDetailImpl.setPaydate(new Date());
			caseBillDetailImpl.setStatus(PClientStatus.ClientFee6.getCode());
			feenumber = caseBillDetailImpl.getFeenumber();
			caseBillDetailServiceMgr.updateCaseBillDetail(caseBillDetailImpl);
			
			//如果币种不一致则产生货币兑换
			if(!consignorPayImpl.getPaycurrency().equals(caseBillDetailImpl.getCurrency())){
				
				CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(caseBillDetailImpl.getBillId().toString());
				if(!"HTPI1300".equals(caseBillImpl.getCasenumber().substring(0, 8))){
					MMap mmap = new MMap();
					mmap.put("feenumber", feenumber);
					mmap.put("Pay_Id", consignorPayImpl.getPayId());
					calFinItemServiceMgr.dealFinItem("106001", mmap,1);
				}
				
			}
		}
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName()}));
		
		/*添加财务凭证 start */
		MMap mmap = new MMap();
		mmap.put("feenumber", feenumber);
		mmap.put("Pay_Id", consignorPayImpl.getPayId());
		calFinItemServiceMgr.dealFinItem("106", mmap,1);
		/*end*/
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
		
	}
	
	@RequestMapping("/searchUnBind")
	public String searchUnBind(HttpServletRequest request,Model model){
		ConsignorPayImpl consignorPayImpl = (ConsignorPayImpl)request.getSession().getAttribute("consignorPayImpl");
		List<CaseBillDetailImpl> billDetailList = caseBillDetailServiceMgr.searchCaseBillDetail(consignorPayImpl.getOrgidb(), consignorPayImpl.getPayeeid(),consignorPayImpl.getPayId().toString(), "4",consignorPayImpl.getPaycurrency());

		List<CaseBillDetailImpl> unbindBillDetailList = new ArrayList<CaseBillDetailImpl>();
		
		if(!"".equals(request.getParameter("feenumber")) && null != request.getParameter("feenumber") ){
			for (CaseBillDetailImpl caseBillDetailImpl : billDetailList) {
				if(request.getParameter("feenumber").equals(caseBillDetailImpl.getFeenumber())){
					unbindBillDetailList.add(caseBillDetailImpl);
				}
			}
			model.addAttribute("unbindBillDetailList", unbindBillDetailList);
		}else{
			model.addAttribute("unbindBillDetailList", billDetailList);
		}
		
		return "/management/consignorPay/unBindList";
	}
	
	@RequestMapping("/searchBind")
	public String searchBind(HttpServletRequest request,Model model){
		ConsignorPayImpl consignorPayImpl = (ConsignorPayImpl)request.getSession().getAttribute("consignorPayImpl");
		List<CaseBillDetailImpl> bindBillDetailList = caseBillDetailServiceMgr.searchCaseBillDetail(consignorPayImpl.getOrgidb(), "",consignorPayImpl.getPayId().toString(), "",consignorPayImpl.getPaycurrency());
		model.addAttribute("bindBillDetailList", bindBillDetailList);
		return "/management/consignorPay/bindList";
	}
	
	@RequestMapping("/apply")
	public String apply(HttpServletRequest request,Model model){
		ConsignorPayImpl consignorPayImpl = consignorPayServiceMgr.getConsignorPay(request.getParameter("payId"));
		//model.addAttribute("consignorPayImpl", consignorPayImpl);
		request.getSession().setAttribute("consignorPayImpl", consignorPayImpl);
		
		List<CaseBillDetailImpl> unbindBillDetailList = caseBillDetailServiceMgr.searchCaseBillDetail(consignorPayImpl.getOrgidb(), consignorPayImpl.getPayeeid(),consignorPayImpl.getPayId().toString(), "4",consignorPayImpl.getPaycurrency());
		model.addAttribute("unbindBillDetailList", unbindBillDetailList);
		
		List<CaseBillDetailImpl> bindBillDetailList = caseBillDetailServiceMgr.searchCaseBillDetail(consignorPayImpl.getOrgidb(), "",consignorPayImpl.getPayId().toString(), "",consignorPayImpl.getPaycurrency());
		model.addAttribute("bindBillDetailList", bindBillDetailList);
		
		model.addAttribute("currency",Jutil.getDictEntry("currency"));

		return "/management/consignorPay/consignorPayApply";
	}
	
	@RequestMapping("/applyEnd")
	public ModelAndView applyEnd(HttpServletRequest request,Model model){
		ConsignorPayImpl consignorPayImpl = consignorPayServiceMgr.getConsignorPay(request.getParameter("payId"));
		consignorPayImpl.setPaystatus(PayStatus.PayApply.getCode());
		consignorPayServiceMgr.updateConsignorPay(consignorPayImpl);
		
		/*添加财务凭证 start 
		MMap mmap = new MMap();
		mmap.put("Pay_Id", consignorPayImpl.getPayId());
		calFinItemServiceMgr.dealFinItem("106", mmap);
		/*end*/
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("")
	public String list(HttpServletRequest request,BaseConditionVO vo,Model model){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		
		criterias.put("payeename", request.getParameter("payeename"));
		criterias.put("payamount", request.getParameter("payamount"));
		/*String[] role = user.getExtend1().split(",");
		boolean flag = false;
		for(int i=0;i<role.length;i++){
			if(role[i].equals("10002")){
				flag=true;
			}else{
				flag=false;
			}
		}
		if(flag==false){
			criterias.put("userId", user.getId());
		}*/
		if(null != request.getParameter("paystatus")){
			criterias.put("paystatus", request.getParameter("paystatus"));
		}
		
		Map search = consignorPayServiceMgr.searchConsignorPay(criterias, vo);
		
		List<ConsignorPayImpl> consignorPayList = (List<ConsignorPayImpl>)search.get("consignorPayList");
		vo.setTotalCount((Integer)search.get("count"));
		model.addAttribute("vo", vo);
		model.addAttribute("paystatus", request.getParameter("paystatus"));
		model.addAttribute("consignorPayList",consignorPayList);
		return  "/management/consignorPay/consignorPayList";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("consignorPayImpl",new ConsignorPayImpl());
		return "/management/consignorPay/consignorPayInfo";
	}
	
	@RequestMapping("/edit/{payId}")
	public String edit(@PathVariable("payId") String payId, Model model) {
		ConsignorPayImpl consignorPayImpl = consignorPayServiceMgr.getConsignorPay(payId);
		model.addAttribute(consignorPayImpl); 
		model.addAttribute("consignorPayImpl", consignorPayImpl);
		
		List<DocInfos> docList=applyInfoServiceMgr.selectByApplyId(Long.valueOf(consignorPayImpl.getPayId()),DocInfoType.thirdApply.getCode());
		model.addAttribute("docList", docList);
		
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		return "/management/consignorPay/consignorPayInfo";
	}
	
	/**
	 * 第三方划付确认及查询
	 * */
	@RequestMapping("/editPay/{payId}")
	public String editPay(@PathVariable("payId") String payId, Model model) {
		ConsignorPayImpl consignorPayImpl = consignorPayServiceMgr.getConsignorPay(payId);
		model.addAttribute(consignorPayImpl); 
		model.addAttribute("consignorPayImpl", consignorPayImpl);
		
		List<CaseBillDetailImpl> bindBillDetailList = caseBillDetailServiceMgr.searchCaseBillDetail(consignorPayImpl.getOrgidb(), "",consignorPayImpl.getPayId().toString(), "",consignorPayImpl.getPaycurrency());
		model.addAttribute("bindBillDetailList", bindBillDetailList);
		
		List<DocInfos> docList=applyInfoServiceMgr.selectByApplyId(Long.valueOf(consignorPayImpl.getPayId()),DocInfoType.thirdPay.getCode());
		model.addAttribute("docList", docList);
		
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("flag","view");
		
		return "/management/consignorPay/consignorPayEdit";
	}
	
	//第三方付款通知
	@RequestMapping("/notice")
	public ModelAndView notice(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String PayId = request.getParameter("PayId");
		ConsignorPayImpl tp = consignorPayServiceMgr.getConsignorPay(PayId);
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		HtmlOperator ho = new HtmlOperator();
		if (!CommonUtil.isEmpty(tp)) {
			ho.loadTemplate("template/thirdpartyPayDetail.doc", request);
			ho.setVar("THIRDPARTY"," "+CommonUtil.jasperEncode(tp.getPayeename()));
			ho.setVar("ORGNAME",CommonUtil.jasperEncode(tp.getOrgnameb()));
			ho.setVar("USERNAME",CommonUtil.jasperEncode(user.getName()));
			ho.setVar("RECEIVEDETAIL", tp.getBinddetail());
			ho.setVar("PRINTDATE", CommonUtil.formatDate(new Date(),"yyyy-MM-dd"));
			ho.setVar("PAYDETAIL", "RMB:"+tp.getRmbamount());
			
			String sql = "select a.shipname,b.feenumber,c.casenumber,c.currency,c.accamount from tbl_case a,tbl_case_bill b,tbl_case_bill_detail c where a.case_id = b.case_id and b.bill_id = c.bill_id and c.payid ='"
				+ tp.getPayId()+ "' ";
			
			List<Map> cp = Jutil.executeSQL(sql);
			for(int i=0;i<cp.size();i++){ 
				Map paymap = cp.get(i);
				ho.setVar("NO", String.valueOf(i+1));
				ho.setVar("SHIPNAME", paymap.get("shipname").toString());
				ho.setVar("FEENUMBER",paymap.get("feenumber").toString());
				ho.setVar("THIRDPARTYNO", paymap.get("casenumber").toString());
				ho.setVar("CURRENCY", paymap.get("currency").toString());
				ho.setVar("AMOUNT",  CommonUtil.FormatDoubleDoc(paymap.get("accamount")));
				
				ho.parse("RECORDFORM", true);
			}
			
			ho.parse("main",false);
			response.setContentType("application/msword; charset=UTF-8");
			
			String filename = CommonUtil.formatDate(tp.getPaydate(),"yyyy-MM-dd")+"_"+tp.getPayeename().substring(0, 6)+"_RMB"+tp.getRmbamount() ;
			filename = URLEncoder.encode(filename, "UTF-8");
			
			response.setHeader("Content-disposition", "attachment; filename="+ filename);
			response.getWriter().write(ho.printVar("main"));
			
			return null;
		} else {
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma", "No-Cache");
			response.setHeader("Cache-Control", "No-Cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(
							"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"
									+ "<html xmlns='http://www.w3.org/1999/xhtml'><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' />"
									+ "<title>生成文件</title></head><body>账单不存请查正后再生成文件！</body></html>'");
		}
		
		return null;
	}
	
	@Log(message="用户 {0} {1} 第三方划付。")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertAndUpdate(ConsignorPayImpl  consignorPayImpl,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);

		try {
			consignorPayServiceMgr.updConsignorPay(consignorPayImpl, request);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		if("".equals(request.getParameter("payId")) || null==request.getParameter("payId")){
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"新增"}));
		}else{
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"修改"}));
		}
		
		String forwardUrl = request.getParameter("forwardUrl");
		
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{payId}", String.valueOf(consignorPayImpl.getPayId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@Log(message="用户 {0} 删除第三方划付{1}。")
	@RequestMapping("/delete/{payId}")
	public ModelAndView delete(@PathVariable("payId") String payId,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);

		consignorPayServiceMgr.del(payId);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),payId}));

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
}
