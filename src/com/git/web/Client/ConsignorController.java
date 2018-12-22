package com.git.web.Client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.assure.consignor.Consignor;
import com.git.business.assure.consignor.ConsignorServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.Jutil;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping(value="/client/consignor")
public class ConsignorController extends BaseController{

	@Autowired
	private ConsignorServiceMgr csm;
	
	
	//按条件查找委托人信息
	@SuppressWarnings("unchecked")
	@RequestMapping("")
	public String list(HttpServletRequest request,BaseConditionVO vo,Model model){
		String name = request.getParameter("name");
		String sort = request.getParameter("sort");
		StringBuffer sf = new StringBuffer(16);
		sf.append("select * from tbl_consignor where 1=1 ");
		if(name!=null && name!=""){
			sf.append("and  name like '%"+name+"%' or names like '%"+name+"%' ");
		}
		if(sort!=null && sort!=""){
			sf.append("and  sort like '%"+sort+"%' ");
		}
		//按委托人英文全称英文字母排序
		sf.append(" order by name ");
		List<Consignor> consignorlist = Jutil.executeSQL(sf.toString(),vo.getStartIndex(), vo.getPageSize());
		model.addAttribute("consignorlist", consignorlist);
		vo.setTotalCount(Jutil.executeSQL(sf.toString()).size());
		model.addAttribute("vo",vo);
		model.addAttribute("consignorsort",Jutil.getDictEntry("consignorsort"));
		model.addAttribute("name", name);
		model.addAttribute("sort", sort);
		return "/client/consignor/list";
	}
	
	//进入添加委托人信息页面
	@RequestMapping("/add")
	public String add(Model model){
		return "/client/consignor/add";
	}
	
	//添加委托人信息
	@Log(message="{0}添加委托人信息{1} 。")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request,Consignor consignor) {

		csm.add(consignor,request);
		
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),consignor.getOid()}));

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	//查找带回委托人分类
	@SuppressWarnings("unchecked")
	@RequestMapping("/sortsearch")
	public String sortsearchback(HttpServletRequest request,BaseConditionVO vo,Model model){
		try{
			StringBuffer tSql = new StringBuffer(16);
			String pr = request.getParameter("keywords");
			tSql.append("select DictId,DictName,SortNo from sys_dict_entry where DictTypeId = 'consignorsort' and Status = '1' ");
			if(pr != null){
				tSql.append("and DictName like '%"+pr+"%' ");
			}
			tSql.append("order by DictName");
			List<String> menuList=Jutil.executeSQL(tSql.toString(),vo.getStartIndex(),vo.getPageSize());
			vo.setTotalCount(Jutil.executeSQL(tSql.toString()).size());
			model.addAttribute("menuList",menuList);
			model.addAttribute("vo", vo);
			}catch(Exception e){
				e.printStackTrace();
			}
			return "/client/consignor/searchlist";
	}
	
	
	//查找带回委托人
	@SuppressWarnings("unchecked")
	@RequestMapping("/search")
	public String searchback( HttpServletRequest request,BaseConditionVO vo,Model model){
		try{
			StringBuffer tSql = new StringBuffer(16);
			String pr = request.getParameter("keywords");
			String st = request.getParameter("st");
			tSql.append(" select c.* from tbl_consignor c ,sys_dict_entry e  where c.`sort`=e.`DictName` and e.`DictId` = '"+st+"' ");
			if(pr != null){
				tSql.append(" and (name like '%"+pr+"%' or names like '%"+pr+"%') ");
			}
			tSql.append("order by name ");
			List<String> menuList=Jutil.executeSQL(tSql.toString(),vo.getStartIndex(),vo.getPageSize());
			vo.setTotalCount(Jutil.executeSQL(tSql.toString()).size());
			model.addAttribute("menuList",menuList);
			model.addAttribute("vo", vo);
			request.setAttribute("st", st);
			}catch(Exception e){
				e.printStackTrace();
			}
			return "/client/consignor/slist";
	}
	
	//查找带回委托人归属地国家
	@SuppressWarnings("unchecked")
	@RequestMapping("/countrysearch")
	public String countrysearch( HttpServletRequest request,BaseConditionVO vo,Model model){
		try{
			StringBuffer tSql = new StringBuffer(16);
			String country = request.getParameter("country");
			String warea = request.getParameter("warea");
			tSql.append("select distinct(country) from tbl_consignor where area = '" + warea + "' ");
			if(country != null){
				tSql.append(" and country like '%"+country+"%' ");
			}
			tSql.append(" order by country ");
			List<String> menuList=Jutil.executeSQL(tSql.toString(),vo.getStartIndex(),vo.getPageSize());
			vo.setTotalCount(Jutil.executeSQL(tSql.toString()).size());
			model.addAttribute("menuList",menuList);
			model.addAttribute("vo", vo);
			}catch(Exception e){
				e.printStackTrace();
			}
			return "/client/consignor/wcountrylist";
	}
	
	//查找带回委托人归属地区域
	@SuppressWarnings("unchecked")
	@RequestMapping("/areasearch")
	public String areasearch( HttpServletRequest request,BaseConditionVO vo,Model model){
		try{
			StringBuffer tSql = new StringBuffer(16);
			String area = request.getParameter("area");
			tSql.append("select distinct(area) from tbl_consignor where 1=1 ");
			if(area != null){
				tSql.append(" and name like '%"+area+"%' ");
			}
			tSql.append(" order by area ");
			List<String> menuList=Jutil.executeSQL(tSql.toString(),vo.getStartIndex(),vo.getPageSize());
			vo.setTotalCount(Jutil.executeSQL(tSql.toString()).size());
			model.addAttribute("menuList",menuList);
			model.addAttribute("vo", vo);
			}catch(Exception e){
				e.printStackTrace();
			}
			return "/client/consignor/warealist";
	}
	
	//删除委托人信息
	@Log(message="{0}删除委托人信息{1} 。")
	@RequestMapping("/delete/{oid}")
	public ModelAndView delete(@PathVariable("oid") long oid,HttpServletRequest request){
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		Consignor consignor = csm.getconsignor(oid);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),consignor.getOid()}));

		csm.deleteByPrimaryKey(oid);
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	//进入委托人编辑页面
	@RequestMapping("/edit/{oid}")
	public String update(@PathVariable("oid") int oid,Model model){
		Consignor consignor = csm.getconsignor(oid);
		model.addAttribute("consignor",consignor);
	   return "/client/consignor/update";
	}
	
	//修改委托人信息
	@Log(message="{0}修改委托人信息{1} 。")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,Consignor consignor){
		String sort = request.getParameter("orgLookup.DictName");
		csm.update(sort,consignor);
		
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),consignor.getOid()}));

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
