
package com.git.web.searchcount;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import com.git.business.PassureInfos.PassureInfos;
import com.git.business.searchandcount.SearchAndCountServiceMgr;
import com.git.business.sys.Org;
import com.git.business.sys.OrgServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.util.Jutil;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping(value="/searchcount")
public class SearchCountController extends BaseController{
	
	@Autowired
	private SearchAndCountServiceMgr searchAndCountMgr;
	
	@Autowired
	private OrgServiceMgr orgMgr;
	
	//查询统计
	
/*	//下载
	@RequestMapping("/download")
	public String search(){
		return "/searchcount/download";
	}*/
	
	//综合查询
	@RequestMapping("/search")
	public String search(Model model){
		model.addAttribute("currency", Jutil.getDictEntry("pccurrency"));
		model.addAttribute("casetype",Jutil.getDictEntry("casetype"));
		model.addAttribute("timetype", Jutil.getDictEntry("timetype"));
		return "/searchcount/zhsearch" ;
	}
	
	//标准报表
	@RequestMapping("/count")
	public String count(Model model){
		model.addAttribute("bztimetype", Jutil.getDictEntry("bztimetype"));
		model.addAttribute("report", Jutil.getDictEntry("bzreport"));
		return "/searchcount/bzcount";
	}
	

	
	//所有查询条件汇总
	@RequestMapping(value = "/searchcondition")
	@ResponseBody
	public Map<String,String> searchcondition(HttpServletRequest request,BaseConditionVO vo){
		Map<String,String> map = new HashMap<String,String>();
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
        Org org = orgMgr.getOrg(Long.valueOf(user.getOrgId()));
		String orgtype = org.getOrgType().toString();
		String[] s = user.getExtend1().split(",");
		boolean flag = false;
		for(int i=0;i<s.length;i++){
			if(s[i]=="10003"){
				flag = true;
			}
		}
        
		System.out.println("进入查询汇总Controller！");
		StringBuffer sf = new StringBuffer(16);
		
		//查询标识判断
		String searchflag = request.getParameter("searchflag");
		System.out.println("查询标识判断："+searchflag);
		
//		//需要跳转的pageid
//		String pageid = request.getParameter("report");
//		System.out.println("pageID:"+pageid);;
		
//		//跳转的URL地址
//		String forwardUrl = request.getParameter("forwardUrl");
//		forwardUrl = forwardUrl.replace("{id}", pageid);
//		System.out.println("跳转链接："+forwardUrl);
		
		String radio = request.getParameter("groupname");
		//分组信息
		Map<String,String> gbmap = searchAndCountMgr.group(request);
		System.out.println("分组信息group:"+gbmap);
    	
		String group = gbmap.get("group");
		System.out.println("分组信息group:"+group);
		String gid = gbmap.get("gid");
		System.out.println("分组信息gid:"+gid);
		
		//查询条件
		String consql = searchAndCountMgr.condition(request, sf);
		System.out.println("查询条件:"+consql);
		
		if("casesearch".equals(searchflag) || "casecount".equals(searchflag)){
			//查询权限
			if(orgtype!="C"){
				if(flag==true){
					consql+=" and a.orgcode =" + user.getOrgCode() + " ";
				}else{
					consql+=" and (a.Create_Operator = "+ user.getId() +" or a.case_id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` ="+ user.getId() +" )) ";
				}
			}
		}
		
		try {
			consql=java.net.URLEncoder.encode(consql,"UTF-8");
			System.out.println("编码后的sonsql:"+consql);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		map.put("result", consql);
		map.put("group", group);
		map.put("gid", gid);
		
//		try{		
//			if (forwardUrl != null) {
//    			forwardUrl = forwardUrl.replace("{con}",consql);
//    			forwardUrl = forwardUrl + "&group="+group+"&gid="+gid;
//    			System.out.println("跳转链接casesearch："+forwardUrl);
//    			return ajaxDone(200, "", "", "", forwardUrl);
//    		}
//
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
      return map;

	}
	
	//外管局统计报表
	@RequestMapping("/outcount")
	public String outcount(Model model){
		model.addAttribute("bztimetype", Jutil.getDictEntry("bztimetype"));
		return "/searchcount/outcount";
	}
	
}
