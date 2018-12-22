package com.git.web.management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

import com.git.business.PassureInfos.PassureInfos;
import com.git.business.PassureInfos.PassureInfosServiceMgr;
import com.git.business.billService.BillCheckConditionVO;
import com.git.business.billService.BillCheckRecordsServiceMgr;
import com.git.business.billService.BillCheckServiceMgr;
import com.git.business.billService.BillServiceMgr;
import com.git.business.caseService.CaseBillDetailServiceMgr;
import com.git.business.caseService.CaseBillServiceMgr;
import com.git.business.caseService.CaseServiceMgr;
import com.git.business.claim.CaseClaimServiceMgr;
import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.claimRate.ClaimRateServiceMgr;
import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.sys.Org;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillCheckImpl;
import com.git.db.beans.BillCheckRecordsImpl;
import com.git.db.beans.BillIncomeImpl;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.ClaimRateSubImpl;
import com.git.db.beans.TblPassureInfos;
import com.git.db.mapper.TblPassureInfosMapper;
import com.git.enums.AccStatus;
import com.git.enums.AssureStatus;
import com.git.enums.ClaimStatus;
import com.git.enums.InComeStatus;
import com.git.enums.InComeType;
import com.git.enums.PClientStatus;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.CommonUtil;
import com.git.util.Jutil;
import com.git.util.MMap;
import com.git.util.NumberToEnglish;
import com.git.web.BaseController;

import dwz.common.util.HtmlOperator;
import dwz.framework.config.Constants;
import dwz.framework.sys.exception.ServiceException;

@Controller
@RequestMapping(value="/management/billCheck")
public class BillCheckController extends BaseController{

	@Autowired
	private BillServiceMgr billServiceMgr;
	
	@Autowired
	private BillCheckServiceMgr billCheckServiceMgr;
	
	@Autowired
	private BillCheckRecordsServiceMgr billCheckRecordsServiceMgr;
	
	@Autowired
	private CaseBillDetailServiceMgr caseBillDetailServiceMgr;
	
	@Autowired
	private CaseBillServiceMgr caseBillServiceMgr;
	
	@Autowired
	private CaseServiceMgr caseServiceMgr;
	
	@Autowired
	private ClaimRateServiceMgr claimRateServiceMgr;
	
	@Autowired
	private PassureInfosServiceMgr passureinfosServiceMgr;
	
	@Autowired
	private TblPassureInfosMapper passuremapper;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;
	
	@Autowired
	private CaseClaimServiceMgr caseClaimServiceMgr;
	
	@Autowired
	private PassureInfosServiceMgr passureInfosServiceMgr;
	
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("")
	public ModelAndView list(HttpServletRequest request,BaseConditionVO vo){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		Org org = (Org)request.getSession().getAttribute(Constants.ORGCODE_KEY);

		ModelAndView modelAndView = new ModelAndView();
		
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("statementnumber", request.getParameter("statementnumber"));
		criterias.put("payername", request.getParameter("payername"));
		criterias.put("feenumber", request.getParameter("feenumber"));
		criterias.put("tradedate", request.getParameter("tradedate"));
		criterias.put("changeamount", request.getParameter("changeamount"));
		
		if(String.valueOf(org.getOrgType())!="C"){
			criterias.put("userId", user.getId());
		}
		
		criterias.put("flag", request.getParameter("flag"));
		Map search = billServiceMgr.searchBillInCome(criterias, vo);
		List<BillIncomeImpl> billIncomeList = (List<BillIncomeImpl>)search.get("billInComeList");
		int totalCount = (Integer)search.get("count");
		vo.setTotalCount(totalCount);
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("flag",request.getParameter("flag"));
		modelAndView.addObject("billIncomeList",billIncomeList);
		modelAndView.setViewName("/management/billCheck/billInComeList");
		return  modelAndView;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/check/{inComeId}")
	public String check(@PathVariable("inComeId") String inComeId, Model model,BaseConditionVO vo,HttpServletRequest request){
		BillIncomeImpl billIncomeImpl = billServiceMgr.getBillIncome(inComeId);
		//model.addAttribute("billIncomeImpl", billIncomeImpl);
		request.getSession().setAttribute("billIncomeImpl",billIncomeImpl );
		Map criterias = new HashMap();
		criterias.put("feenumber", billIncomeImpl.getFeenumber());
		criterias.put("orgCode", billIncomeImpl.getOrgcode());
		criterias.put("currency", billIncomeImpl.getCurrency());
		List<BillCheckImpl> billCheckList = billCheckServiceMgr.searchBillCheck(criterias, vo);
		vo.setTotalCount(billCheckList.size());
		model.addAttribute("vo", vo);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("billCheckList", billCheckList);
		model.addAttribute("flag", "check");
		return "/management/billCheck/billCheckInfo";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/checked/{inComeId}")
	public String checked(@PathVariable("inComeId") String inComeId, Model model,BaseConditionVO vo,HttpServletRequest request){
		BillIncomeImpl billIncomeImpl = billServiceMgr.getBillIncome(inComeId);
		request.getSession().setAttribute("billIncomeImpl",billIncomeImpl );
		
		Map criterias = new HashMap();
		criterias.put("statementnumber", billIncomeImpl.getStatementnumber());
		
		List<BillCheckImpl> billCheckList = billCheckServiceMgr.searchBillCheckedByStatement(criterias, vo);

		vo.setTotalCount(billCheckList.size());
		model.addAttribute("vo", vo);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("billCheckList", billCheckList);
		model.addAttribute("flag", "checked");
		return "/management/billCheck/billCheckInfo";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/search")
	public String search(Model model,BillCheckConditionVO vo,HttpServletRequest request){
		Map criterias = new HashMap();
		
		criterias.put("feenum", vo.getFeenum());
		criterias.put("feeamount_start",vo.getFeeamount_start());
		criterias.put("feeamount_end", vo.getFeeamount_end());
		criterias.put("payername", vo.getPayername());
		if("1".equals(request.getParameter("billflag"))){
			criterias.put("printBill", "1");
		}else{
			criterias.put("printBill", vo.getPrintBill());
		}
		
		Map search = billCheckServiceMgr.search(criterias, vo);
		List<BillCheckImpl> billCheckList = (List<BillCheckImpl>)search.get("billCheckList");
		int count = (Integer)search.get("count");
		vo.setTotalCount(count);
		model.addAttribute("vo", vo);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("billCheckList", billCheckList);
		return "/management/billCheck/billCheckPrintList";
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/searchCheck")
	public String searchCheck(HttpServletRequest request,Model model,BaseConditionVO vo){
		BillIncomeImpl billIncomeImpl = (BillIncomeImpl)request.getSession().getAttribute("billIncomeImpl");
		Map criterias = new HashMap();
		criterias.put("feenum", request.getParameter("feenum"));
		criterias.put("feeamount_start", request.getParameter("feeamount_start"));
		criterias.put("feeamount_end", request.getParameter("feeamount_end"));
		criterias.put("payername", request.getParameter("payername"));
		//criterias.put("feenumber", billIncomeImpl.getFeenumber());
		criterias.put("orgCode", billIncomeImpl.getOrgcode());
		criterias.put("currency", billIncomeImpl.getCurrency());
		List<BillCheckImpl> billCheckList = billCheckServiceMgr.searchBillCheck(criterias, vo);
		vo.setTotalCount(billCheckList.size());
		model.addAttribute("vo", vo);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("billCheckList", billCheckList);
		model.addAttribute("flag", "check");
		return "/management/billCheck/billCheckList";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/searchChecked")
	public String searchChecked(HttpServletRequest request,Model model,BaseConditionVO vo){
		BillIncomeImpl billIncomeImpl = (BillIncomeImpl)request.getSession().getAttribute("billIncomeImpl");
		
		Map criterias = new HashMap();
		criterias.put("feenum", request.getParameter("feenum"));
		criterias.put("feeamount_start", request.getParameter("feeamount_start"));
		criterias.put("feeamount_end", request.getParameter("feeamount_end"));
		criterias.put("payername", request.getParameter("payername"));
		criterias.put("statementnumber", billIncomeImpl.getStatementnumber());
		
		List<BillCheckImpl> billCheckList = billCheckServiceMgr.searchBillCheckedByStatement(criterias, vo);
		vo.setTotalCount(billCheckList.size());
		model.addAttribute("vo", vo);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("billCheckList", billCheckList);
		model.addAttribute("flag", "checked");
		return "/management/billCheck/billCheckedList";
	}
	
	@SuppressWarnings("rawtypes")
	@Log(message="用户 {0} 确认对账，进账单编号 {1}。")
	@RequestMapping("/process")
	public ModelAndView processCheck(HttpServletRequest request) throws ServiceException{
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		String[] checkIds = request.getParameterValues("checkIds");
		
		BigDecimal sumFee = new BigDecimal(0);
		List<BillCheckImpl> billCheckList = new ArrayList<BillCheckImpl>();
		
		for (int i = 0; i < checkIds.length; i++) {
			String checkId = checkIds[i];
			BillCheckImpl billCheckImpl = billCheckServiceMgr.getBillCheck(checkId);
			sumFee = sumFee.add(BigDecimal.valueOf(billCheckImpl.getDifferamount()));
			billCheckList.add(billCheckImpl);
		}
		
		//String sql = "select SUM(tf.differamount) from tbl_bill_check tf where tf.`Check_Id` in("+checkId+") and tf.differamount != 0";
		BillIncomeImpl billIncomeImpl = (BillIncomeImpl)request.getSession().getAttribute("billIncomeImpl");
		int rs = BigDecimal.valueOf(billIncomeImpl.getDifferamount()).compareTo(sumFee);
		
		if(rs < 0){ //部分到账
			if(billCheckList.size()>1){
				return ajaxDoneError("进账单金额小账单合计金额，不可进行对账!");
			}
			
			for (Iterator<BillCheckImpl> iterator = billCheckList.iterator(); iterator.hasNext();) {
				BillCheckImpl billCheckImpl = (BillCheckImpl) iterator.next();
				billCheckImpl.setArrdate(billIncomeImpl.getTradedate());
				billCheckImpl.setCheckdate(new Date());
				billCheckImpl.setStatementnumber(billIncomeImpl.getStatementnumber());
				billCheckImpl.setCheckamount(billIncomeImpl.getDifferamount());
				
				//发账余额减去进账单余额
				billCheckImpl.setDifferamount(BigDecimal.valueOf(billCheckImpl.getDifferamount()).subtract(BigDecimal.valueOf(billIncomeImpl.getDifferamount())).floatValue());
				billCheckServiceMgr.updBillCheck(billCheckImpl);
				
				CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(billCheckImpl.getFeeid());
				caseBillImpl.setArrdate(new Date());
				caseBillImpl.setFeestatuse(AccStatus.AccPart.getCode());
				caseBillImpl.setReplaceamount(billCheckImpl.getDifferamount());
				caseBillServiceMgr.updateCaseBill(caseBillImpl);
				
				BillCheckRecordsImpl billCheckRecordsImpl = new BillCheckRecordsImpl();
				billCheckRecordsImpl.setCreateTime(new Date());
				billCheckRecordsImpl.setFeenumber(billCheckImpl.getFeenum());
				billCheckRecordsImpl.setBillId(Long.valueOf(billCheckImpl.getFeeid()));
				billCheckRecordsImpl.setStatementnumber(billIncomeImpl.getStatementnumber());
				billCheckRecordsImpl.setIncomeId(billIncomeImpl.getIncomeId());
				billCheckRecordsImpl.setCheckamount(billIncomeImpl.getDifferamount());
				billCheckRecordsServiceMgr.addBillCheckRecords(billCheckRecordsImpl);
			}
			billIncomeImpl.setDifferamount(Float.valueOf(0));
			billIncomeImpl.setCheckdate(new Date());
			billServiceMgr.updateBillInCome(billIncomeImpl);
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),billIncomeImpl.getStatementnumber()}));
			
			/*添加财务凭证 start 
			MMap mmap = new MMap();
			mmap.put("bill_id", billIncomeImpl.getIncomeId());
			calFinItemServiceMgr.dealFinItem("104", mmap);
			/*end*/
			
		}else{ //全部到账
			for (Iterator<BillCheckImpl> iterator = billCheckList.iterator(); iterator.hasNext();) {
				
				BillCheckImpl billCheckImpl = (BillCheckImpl) iterator.next();
				
				//对账记录表
				BillCheckRecordsImpl billCheckRecordsImpl = new BillCheckRecordsImpl();
				billCheckRecordsImpl.setCreateTime(new Date());
				billCheckRecordsImpl.setFeenumber(billCheckImpl.getFeenum());
				billCheckRecordsImpl.setBillId(Long.valueOf(billCheckImpl.getFeeid()));
				billCheckRecordsImpl.setStatementnumber(billIncomeImpl.getStatementnumber());
				billCheckRecordsImpl.setIncomeId(billIncomeImpl.getIncomeId());
				billCheckRecordsImpl.setCheckamount(billCheckImpl.getDifferamount());
				billCheckRecordsServiceMgr.addBillCheckRecords(billCheckRecordsImpl);
				
				//发账信息表
				billCheckImpl.setArrdate(billIncomeImpl.getTradedate());
				billCheckImpl.setCheckamount(billCheckImpl.getDifferamount());
				billCheckImpl.setDifferamount(Float.valueOf(0));
				billCheckImpl.setCheckdate(new Date());
				billCheckImpl.setStatementnumber(billIncomeImpl.getStatementnumber());
				billCheckServiceMgr.updBillCheck(billCheckImpl);

				CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(billCheckImpl.getFeeid());
				caseBillImpl.setArrdate(new Date());
				caseBillImpl.setReplaceamount(Float.valueOf(0));
				String feetype = caseBillImpl.getFeetype();
				
				if("assure".equals(feetype)){
					caseBillImpl.setFeestatuse(AssureStatus.AssureStatus2.getCode());
					//为相关担保添加发账时间及修改担保状态
					List list = passureinfosServiceMgr.searchpassurebybillid(caseBillImpl.getBillId());
					
					for(int i=0;i<list.size();i++){
						Map a = (Map) list.get(i);
						Long pid = (Long) a.get("passureid");			
						TblPassureInfos tp = passuremapper.selectByPrimaryKey(pid);
						tp.setArrdate(new Date());
						tp.setFeestatuse(AssureStatus.AssureStatus2.getCode());
						passuremapper.updateByPrimaryKey(tp);
					}
					
				}else{					
					caseBillImpl.setFeestatuse(AccStatus.AccNut.getCode());
				}
				
				caseBillServiceMgr.updateCaseBill(caseBillImpl);
				
				//查询账单下的第三方费用及其他费用
				Map<String, String> criterias = new HashMap<String, String>();
				criterias.put("billId",caseBillImpl.getBillId().toString());
				List<CaseBillDetailImpl> caseBillDetailList = caseBillDetailServiceMgr.searchCaseBillDetailByBillId(caseBillImpl.getBillId().toString(), "");
				
				for (CaseBillDetailImpl caseBillDetailImpl : caseBillDetailList) {
					caseBillDetailImpl.setArrdate(new Date());
					caseBillDetailImpl.setStatus(PClientStatus.ClientFee1.getCode());
					caseBillDetailServiceMgr.updateCaseBillDetail(caseBillDetailImpl);
				}
				
				
				//查询账单下的赔款汇差
				List<ClaimRateSubImpl> claimRateSub = claimRateServiceMgr.searchClaimRateByCaseNumber(caseBillImpl.getCasenumber());
				
				for (ClaimRateSubImpl claimRateSubImpl : claimRateSub) {
					claimRateSubImpl.setArrdate(new Date());
					claimRateServiceMgr.updateClaimRateSub(claimRateSubImpl);
				}
				
				//查询账单下的垫付费用
				List<CaseClaimImpl> caseClaimList = caseClaimServiceMgr.searchCaseClaimByBillId(caseBillImpl.getBillId().toString(), null);
				
				for (CaseClaimImpl caseClaimImpl : caseClaimList) {
					caseClaimImpl.setStatus(ClaimStatus.ClaimFee4.getCode());
					caseClaimImpl.setLockdate(new Date());
					caseClaimImpl.setTreatdate(new Date());
					caseClaimServiceMgr.updateCaseClaim(caseClaimImpl);
				}
				
				System.out.println("账单类型："+billIncomeImpl.getIncometype());
				if(!"HTPI1300".equals(caseBillImpl.getCasenumber().substring(0, 8))){
					if(billIncomeImpl.getIncometype().equals(InComeType.InComeType2.getCode())){
						/*添加担保财务凭证 start */
						System.out.println("进账单ID："+billIncomeImpl.getIncomeId());
						System.out.println("账单ID："+caseBillImpl.getBillId());
						MMap mmap = new MMap();
						mmap.put("income_id", billIncomeImpl.getIncomeId());
						mmap.put("bill_id", caseBillImpl.getBillId());
						calFinItemServiceMgr.dealFinItem("114", mmap,1);
						/*end*/
					}else{
						/*添加财务凭证 start */
						MMap mmap = new MMap();
						mmap.put("income_id", billIncomeImpl.getIncomeId());
						mmap.put("bill_id", caseBillImpl.getBillId());
						calFinItemServiceMgr.dealFinItem("104", mmap,1);
					}
				}
				
			}
			
			if(rs == 0){
				billIncomeImpl.setCheckdate(new Date());
				billIncomeImpl.setDifferamount((float)0);
			}else{
				billIncomeImpl.setDifferamount(BigDecimal.valueOf(billIncomeImpl.getDifferamount()).subtract(sumFee).floatValue());
			}
			billServiceMgr.updateBillInCome(billIncomeImpl);
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),billIncomeImpl.getStatementnumber()}));
			
			
			 
		}
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("casetype",Jutil.getDictEntry("casetype"));
		model.addAttribute("billIncomeImpl",new BillIncomeImpl());
		return "/management/inCome/inComeInfo";
	}
	
	@RequestMapping("/edit/{inComeId}")
	public String edit(@PathVariable("inComeId") String inComeId, Model model,BaseConditionVO vo) {
		BillIncomeImpl billIncomeImpl = billServiceMgr.getBillIncome(inComeId);
		model.addAttribute("billIncomeImpl", billIncomeImpl);
		
		model.addAttribute("vo", vo);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("casetype",Jutil.getDictEntry("casetype"));
		return "/management/inCome/inComeInfo";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertAndUpdate(HttpServletRequest request) throws ServiceException{
		BillIncomeImpl billIncomeImpl = new BillIncomeImpl();
		billServiceMgr.updBillInCome(billIncomeImpl,request);
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	
	@RequestMapping("/delete/{inComeId}")
	public ModelAndView delete(@PathVariable("inComeId") String inComeId) {
		billServiceMgr.delBillIncome(inComeId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	/**
	 * 打印账单
	 * */
	@RequestMapping("/printBillNote")
	public ModelAndView printBillNote(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//String feeid = ai.getStringParam("feeid");
		String checkId = request.getParameter("checkId");
		BillCheckImpl billCheckImpl = billCheckServiceMgr.getBillCheck(checkId);
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(billCheckImpl.getFeeid());
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseBillImpl.getCaseId().toString());
		
		HtmlOperator ho = new HtmlOperator();
		Date date = new Date();
		List<Object[]> list = null;
		/*String sql = "from TblFfeelist tf,TblPfeelist tb,TblPcaseinfos tp where tp.oid = tb.caseid and tf.feeid = tb.oid and tb.oid ='"
			+ feeid + "'";
		List<Object[]> list = ht.find(sql);
		List<Object[]> tolList = null; 
		Object[] obs = null;
		TblFfeelist tf = null;
		TblPfeelist tb = null;
		TblPcaseinfos tpi=null;*/
		
		if (billCheckImpl != null) {
			ho.loadTemplate("template/pnifeenote.html", request);
			/*obs = list.get(0);
			tf = (TblFfeelist) obs[0];
			tb = (TblPfeelist) obs[1];
			tpi = (TblPcaseinfos) obs[2];*/
			
			if(CommonUtil.isEmpty(caseBillImpl.getPayer())){
				ho.setVar("PAYER", caseInfoImpl.getConsignorname());
			}else {
				ho.setVar("PAYER",caseBillImpl.getPayer());
			}
			ho.setVar("FEENUMBER", caseBillImpl.getFeenumber());
			ho.setVar("OFFICENAME", caseInfoImpl.getOraname());
			ho.setVar("USERNAME", caseInfoImpl.getUsername());
			ho.setVar("CREATEDATE", CommonUtil.formatDate(caseBillImpl.getCreateTime(),
					"yyyy-MM-dd"));
			ho.setVar("CLAIMAMOUNT", caseBillImpl.getCurrency()
					+ CommonUtil.FormatDoubleDoc(billCheckImpl.getReplaceamount()));
			ho.setVar("EXPENDS", caseBillImpl.getCurrency()
					+ CommonUtil.FormatDoubleDoc(billCheckImpl.getExpends()));
			ho.setVar("INCOME",caseBillImpl.getCurrency()
					+ CommonUtil.FormatDoubleDoc(billCheckImpl.getIncome()));
			ho.setVar("FEEAMOUNT", caseBillImpl.getCurrency()
					+ CommonUtil.FormatDoubleDoc(billCheckImpl.getFeeamount()));
			
			
			Map<Object, Object> criterias = new HashMap<Object, Object>();
			criterias.put("billId", caseBillImpl.getBillId());
			criterias.put("feeType", "thirdPart");
			List<CaseBillDetailImpl> consignorBillList = caseBillDetailServiceMgr.searchCaseBillDetail(criterias, null);

			/*sql = "from TblPconsignor tp where tp.feeid = '"+caseBillImpl.getOid()+"'";
			List<TblPconsignor> tpList = ht.find(sql);*/
			CaseBillDetailImpl caseBillDetailImpl = null;
			boolean flag = false;
			for(int i=0;i<consignorBillList.size();i++){
				caseBillDetailImpl = consignorBillList.get(i);
				ho.setVar("INSPECTIONNAME", caseBillDetailImpl.getConsignorname());
				ho.setVar("THIRDPART", caseBillDetailImpl.getCurrency()+CommonUtil.FormatDoubleDoc(caseBillDetailImpl.getFeeamount())+"@"+caseBillDetailImpl.getChangerate().toString()+caseBillDetailImpl.getCurrency()+CommonUtil.FormatDoubleDoc(caseBillDetailImpl.getAccamount()));;
				ho.parse("THIRDPARTFORM", true);
				flag = true;
			}
			if(!flag){
				ho.setVar("THIRDPARTFORM", "");
			}
			flag = false;
			
			/*sql = "from TblPassureinfos tpa where tpa.feeid = '"+tb.getOid()+"'";
			List<TblPassureinfos> tpaList = ht.find(sql);*/
			 PassureInfos passure = null;
			List pif = passureInfosServiceMgr.searchpassurebybillid(caseBillImpl.getBillId());
			//TblPassureinfos tpa = null;
			
			for(int i=0;i<pif.size();i++){
				Map a = (Map) pif.get(i);
				Long pid = (Long) a.get("passureid");			
				passure = passureInfosServiceMgr.getPassureInfos(pid);
				
				ho.setVar("ASSURENUM", passure.getAssurenum());
				ho.setVar("ASSUREFEE", passure.getCurrency()+CommonUtil.FormatDoubleDoc(passure.getAssurefee())+"*1%="+CommonUtil.FormatDoubleDoc(passure.getServicefee())+"@"+passure.getAccrate().toString()+passure.getCurrency()+CommonUtil.FormatDoubleDoc(passure.getAccamount()));;
				ho.parse("ASSUREFEEFORM", true);
				flag = true;
				
			}
			
			if(!flag){
				ho.setVar("ASSUREFEEFORM", "");
			}
			flag = false;
			
			ho.setVar("SERVICEFEE", caseBillImpl.getCurrency()+" "+ CommonUtil.FormatDoubleDoc(caseBillImpl.getServicefee()));
			ho.setVar("SERVICEDES", caseBillImpl.getServicedes());
			ho.setVar("EXPENSES", caseBillImpl.getCurrency()+" "+ CommonUtil.FormatDoubleDoc(caseBillImpl.getExpendses()));
			
			
			criterias.clear();
			criterias.put("billId", caseBillImpl.getBillId());
			criterias.put("feeType", "other");
			List<CaseBillDetailImpl> otherBillList = caseBillDetailServiceMgr.searchCaseBillDetail(criterias, null);
			
			CaseBillDetailImpl otherBillImpl = null;
			/*sql = "from TblPotherfee tpo where tpo.feeid = '"+tb.getOid()+"'";
			List<TblPotherfee> tpoList = ht.find(sql);
			TblPotherfee tpo = null;*/
			for(int i=0;i<otherBillList.size();i++){
				otherBillImpl = otherBillList.get(i);
				ho.setVar("OTHERDES", otherBillImpl.getRemark());
				ho.setVar("OTHERFEE", otherBillImpl.getCurrency()+otherBillImpl.getFeeamount()+"@"+otherBillImpl.getChangerate()+caseBillImpl.getCurrency()+ CommonUtil.FormatDoubleDoc(otherBillImpl.getAccamount()));;
				ho.parse("OTHERFEEFORM", true);
				flag = true;
				
			}
			if(!flag){
				ho.setVar("OTHERFEEFORM", "");
			}
			flag = false;
			
			criterias.clear();
			criterias.put("billId", caseBillImpl.getBillId());
			criterias.put("status", InComeStatus.ClaimFee4.getCode());
			criterias.put("Islocked", "yes");
			criterias.put("differamount", 0);
			
			List<ClaimIncomeImpl> balanceBillList = claimInComeServiceMgr.searchClaimIncomeByBill(criterias, caseInfoImpl.getCasenumber());
			
			/*sql = "from TblPcopensation tpc where tpc.feeid = '"+tb.getOid()+"'";
			List<TblPcopensation> tpcList = ht.find(sql);
			TblPcopensation tpc = null;*/
			ClaimIncomeImpl claimIncomeImpl = null;
			for(int i=0;i<balanceBillList.size();i++){
				claimIncomeImpl = balanceBillList.get(i);
				ho.setVar("COPENSATIONSUB", claimIncomeImpl.getCurrency()+claimIncomeImpl.getDifferamount()+"@"+claimIncomeImpl.getUsdrate()+caseBillImpl.getCurrency()+" "+ CommonUtil.FormatDoubleDoc(claimIncomeImpl.getTotalamount()));;
				ho.parse("COPENSATIONSUBFORM", true);
				flag = true;
				
			}
			if(!flag){
				ho.setVar("COPENSATIONSUBFORM", "");
			}
			flag = false;
			ho.setVar("FEEAMOUNT",caseBillImpl.getCurrency()+" "+ CommonUtil.FormatDoubleDoc(caseBillImpl.getFeeamount()) );
			ho.setVar("FEEAMOUNTEN",NumberToEnglish.n2e(caseBillImpl.getFeeamount().toString()) );
			
			
			
			ho.setVar("PRINTDATE", CommonUtil.formatDate(date,
			"yyyy-MM-dd"));
			ho.setVar("PREPRINTDATE", CommonUtil.formatDate(billCheckImpl.getPrintdate(),
			"yyyy-MM-dd"));
			ho.setVar("CHANGEDATE", CommonUtil.formatDate(billCheckImpl.getChangedate(),
			"yyyy-MM-dd"));
			if(!billCheckImpl.getAccdate().equals(billCheckImpl.getChangedate())){
				ho.setVar("CHANGDES", "修改账单");
			}
			
			billCheckImpl.setPrintdate(date);
			
			billCheckServiceMgr.updBillCheck(billCheckImpl);
			
			ho.setVar("REMARK", caseBillImpl.getRemark());
			/*if(CommonUtil.checkPrivilege("psysprint", request)){
				billCheckImpl.setPrintdate(date);
			}else {
				ho.setVar("CHECKPRIVDES", "您没有打印海旅账单的权限！");
			}*/
			
			//ht.saveOrUpdate(tf);
			ho.parse("main", false);
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma", "No-Cache");
			response.setHeader("Cache-Control", "No-Cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(ho.printVar("main"));
		} else {
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma", "No-Cache");
			response.setHeader("Cache-Control", "No-Cache");
			response.setDateHeader("Expires", 0);
			response.getWriter()
					.write(
							"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"
									+ "<html xmlns='http://www.w3.org/1999/xhtml'><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' />"
									+ "<title>生成文件</title></head><body>账单不存请查正后再生成文件！</body></html>'");
		}
		return null;
	
	}

	
}
