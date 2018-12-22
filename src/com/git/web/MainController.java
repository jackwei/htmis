package com.git.web;

//import javax.inject.Inject;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.service.MainService;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.util.Jutil;
import com.git.util.PubDateUtil;
import com.ibm.icu.text.SimpleDateFormat;

import dwz.framework.config.Constants;

@Controller
@RequestMapping(value = "/") 
public class MainController extends BaseController{
	
	@Autowired
	private MainService mainService;

	@RequestMapping("")
	public String index() {
		return "/main";
	}
	
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest request,BaseConditionVO vo) throws JsonGenerationException, JsonMappingException, IOException, ParseException
	{
		User user = null;
		ModelAndView modelAndView = new ModelAndView();
		try 
		{
			user = (User) request.getSession()
					.getAttribute(Constants.AUTHENTICATION_KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("select distinct b.menu_id as menu_id, b.parent_id as parent_id,(select menu_name from sys_menu where menu_id=b.parent_id) as parent_name, ");
		tSql.append("b.menu_name as menu_name,b.url as url,IFNULL(Extend1,'false') external,IFNULL(Extend2,'') rel  ");
		tSql.append("from sys_role_menu a,sys_menu b,sys_user_role c ");
		tSql.append("where a.menu_id = b.menu_id and a.role_id = c.role_id and b.menu_status='1' and c.user_id =");
		tSql.append(user.getId());
		tSql.append(" order by b.parent_id,b.menu_id  ");
		
		List<Map> menuList=Jutil.executeSQL(tSql.toString());
		
		ObjectMapper mapper=new ObjectMapper();
		
		modelAndView.addObject("menuList",mapper.writeValueAsString(menuList));	
		
		//区分财务通知与业务通知不同
		String flag = "";
		if(user.getExtend2().indexOf("财务") >= 0){
			flag = "list2";
			
			//已发账单提醒
			BaseConditionVO vo5 = new BaseConditionVO();
			String sqlfive = "select a.case_id as caseid,a.shipname,a.casenumber,a.excasenumber,a.username,b.feenumber,b.currency,b.servicefee,b.expendses,b.assurefee,b.thirdpart,b.feeamount,b.accdate from tbl_case a,tbl_case_bill b where a.case_id = b.case_id and b.accdate is not null AND b.`feestatuse` <> 2 ";
			List<CaseInfoImpl> caselistfive = Jutil.executeSQL(sqlfive,vo5.getStartIndex(), vo5.getPageSize());
			String count5 = "select count(1) as count from ("+sqlfive+") one";
			int total5= Integer.valueOf(Jutil.getOneValue(count5.toString(), "count"));
			vo5.setTotalCount(total5);
			modelAndView.addObject("vo5", vo5);
			modelAndView.addObject("total5",total5);
			modelAndView.addObject("caselistfive", caselistfive);

		}else{
			flag = "list1";
			
			String condition = " and a.casestatus <> '9' AND (a.Create_Operator = "+user.getId()+" or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+" )";
			String condition1 = condition+" ) ";
			String condition2 = " ";
//			String condition3 = " ";
			
			//判断担保账单与案件账单区别
			if(user.getExtend2().indexOf("担保") >= 0){
				condition2 = condition + " or b.assurefee > 0 ) ";
//				condition3 = condition + " )";
			}else{
				condition2 = condition + " ) and b.assurefee = 0 ";
//				condition3 = condition + " ) and b.incometype <> 2 ";
			}
			
			//立案6个月未发账案件
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Calendar rightNow = Calendar.getInstance();
	        rightNow.setTime(new Date());
	        rightNow.add(Calendar.MONTH, -6);        
	        String sDate = sdf.format(rightNow.getTime());
	        
//			String date = PubDateUtil.getCurrentDateByMonth(-6).toString();
	        //第一部分立案六个月未生成账单
	        String one = "select a.case_id AS caseid,a.shipname,a.casenumber,a.excasenumber,'' currency,'' servicefee,'' expendses,'' assurefee,'' thirdpart, '' otherfee, '' compensationsub, '' feeamount from tbl_case a where a.`feecount` = 0 and a.`Create_Time` < '"+sDate+"' "+condition1;
	        //第二部分立案六个月有账单但未发账
	        one += " union all select a.case_id as caseid,a.shipname,a.casenumber,a.excasenumber,b.currency,b.servicefee,b.expendses,b.assurefee,b.thirdpart,b.otherfee,b.compensationsub,b.feeamount from tbl_case a, tbl_case_bill b WHERE a.case_id = b.case_id and b.bill_id is not null and a.`Create_Time` < '"+sDate+"' and b.accdate is null "+condition2;
	        //第三部分案件中最后一个账单为中期账单（非final账单）且六个月内未再发新账单
			one += " union all select a.case_id as caseid,a.shipname,a.casenumber,a.excasenumber,b.currency,b.servicefee,b.expendses,b.assurefee,b.thirdpart,b.otherfee,b.compensationsub,b.feeamount from tbl_case a, tbl_case_bill b WHERE a.case_id = b.case_id AND a.casestatus =1 "+condition2+" AND (a.case_id in (SELECT acc1.case_id from (SELECT a.case_id ,MAX(b.`Bill_Id`)FROM tbl_case a,tbl_case_bill b WHERE a.case_id = b.`Case_Id` and a.`Create_Operator` ="+user.getId()+" and  b.accdate is not null and b.accdate < '"+sDate+"'  GROUP BY a.case_id  )acc1))  ";
			List<CaseInfoImpl> caselistone = Jutil.executeSQL(one, vo.getStartIndex(), vo.getPageSize());
			String count1 = "select count(1) as count from ("+one+") one";
			int total1= Integer.valueOf(Jutil.getOneValue(count1.toString(), "count"));
			vo.setTotalCount(total1);
			modelAndView.addObject("vo", vo);
			modelAndView.addObject("total1", total1);
			modelAndView.addObject("caselistone",caselistone);
			modelAndView.addObject("divflag", "first");
			
			
			//待提交审批第三方费用案件
			/*BaseConditionVO vo2 = new BaseConditionVO();
	        String sql = "select distinct a.* from tbl_case_bill_detail d,tbl_case_bill b,tbl_case a where d.`Bill_Id` = b.`Bill_Id` and b.`Case_Id`=a.`Case_Id` AND b.`thirdpart` > 0 AND b.`arrdate` IS NOT NULL AND d.`paydate` IS NULL and d.status < 3 "+condition2;
			List<CaseInfoImpl> caseIdListtwo = Jutil.executeSQL(sql,vo2.getStartIndex(), vo2.getPageSize());
			String count2 = "select count(1) as count from ("+sql+") two";
			int total2= Integer.valueOf(Jutil.getOneValue(count2.toString(), "count"));
			vo2.setTotalCount(total2);
			modelAndView.addObject("total2", total2);
			modelAndView.addObject("caseIdListtwo",caseIdListtwo);
			
			
			//发账3个月未到账账单
			BaseConditionVO vo3 = new BaseConditionVO();
			rightNow.clear();
			rightNow.setTime(new Date());
			rightNow.add(Calendar.MONTH, -3);
			String tDate = sdf.format(rightNow.getTime());
			String sqlthree = "select a.case_id as caseid,a.shipname,a.excasenumber,b.* from tbl_case a, tbl_case_bill b where a.case_id = b.case_id and b.feestatuse <> 2 and b.accdate is not null and b.accdate < '"+ tDate +"' "+condition2;
			List<CaseInfoImpl> caselistthree = Jutil.executeSQL(sqlthree,vo3.getStartIndex(), vo3.getPageSize());
			String count3 = "select count(1) as count from ("+sqlthree+") three";
			int total3= Integer.valueOf(Jutil.getOneValue(count3.toString(), "count"));
			vo3.setTotalCount(total3);
			modelAndView.addObject("total3",total3);
			modelAndView.addObject("caselistthree",caselistthree);
			
			//已到账未登记账单
			BaseConditionVO vo4 = new BaseConditionVO();		
			String sql4 = "SELECT a.case_id AS caseid,a.shipname,a.casenumber,a.excasenumber,b.payername,b.currency,b.changeamount,b.differamount,b.tradedate,b.`Create_Time` FROM tbl_case a,tbl_bill_income b WHERE b.`differamount` > (SELECT IFNULL(sum(c.replaceamount),0) FROM tbl_case_bill c WHERE c.`casenumber` = b.`feenumber` and  c.`accdate` IS NOT NULL) AND a.casenumber=b.feenumber AND b.checkdate IS NULL "+condition3+" ORDER BY b.`Create_Time` DESC";

			List<CaseInfoImpl> caselistfour = Jutil.executeSQL(sql4,vo4.getStartIndex(), vo4.getPageSize());
			String count4 = "select count(1) as count from ("+sql4+") four";
			int total4= Integer.valueOf(Jutil.getOneValue(count4.toString(), "count"));
			vo4.setTotalCount(total4);
			modelAndView.addObject("total4",total4);
			modelAndView.addObject("caselistfour",caselistfour);*/

		}
		
		modelAndView.addObject("flag", flag);
		
		modelAndView.setViewName("/main");
		modelAndView.addObject("message", user.getName());
		modelAndView.addObject("baseUrl", request.getContextPath());
		modelAndView.addObject("now", new Date());
		//区分主页与案件监督查询
		modelAndView.addObject("supflag", "main");
		
		if(request.getParameter("n")!=null){
			modelAndView.addObject("jumpPage",request.getParameter("n"));
		}else{
			modelAndView.addObject("jumpPage","1");
		}
			
		return modelAndView;
	}
	
	@RequestMapping("/voucher")
	public ModelAndView searchVoucher(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/voucher/FinDataList");
		return modelAndView;
	}
	
	@RequestMapping("/editPwd")
	public String editPwd() {
		return "/editPwd";
	}
}