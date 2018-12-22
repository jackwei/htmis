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

import com.git.business.assure.rewarranter.Rewarranter;
import com.git.business.assure.rewarranter.RewarranterServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.Jutil;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping(value="/client/rewarranter")
public class RewarranterController extends BaseController{
	@Autowired
	private RewarranterServiceMgr rs;
	
	@SuppressWarnings("unchecked")
	//获取反担保人信息
	@RequestMapping("")
	public String plist(HttpServletRequest request,BaseConditionVO vo,Model model){
		StringBuffer sf = new StringBuffer(16);
		String name = request.getParameter("name");
		String propertyname = request.getParameter("propertyname");
		System.out.println("name:"+name+"---"+"propertyname:"+propertyname);
		sf.append("select * from tbl_rewarranter where 1=1 ");
		if(name!=null && name!=""){
			sf.append("and name like '%"+name+"%' or names like '%"+name+"%' ");
		}
		if(propertyname!=null && propertyname!=""){
			sf.append("and propertyname like '%"+propertyname+"%' ");
		}
		sf.append(" order by name ");
		System.out.println(sf.toString());
		List<Rewarranter> rewarranterlist = Jutil.executeSQL(sf.toString(),vo.getStartIndex(),vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(sf.toString()).size());
		model.addAttribute("rewarranterlist", rewarranterlist);
		model.addAttribute("vo", vo);
		model.addAttribute("name", name);
		model.addAttribute("propertyname", propertyname);
		return "/client/rewarranter/list";
	}
	
	//进入添加反担保人信息页面
	@RequestMapping("/add")
	public String add(Model model){
		return "/client/rewarranter/add";
	}
	
	//添加反担保人信息
	@Log(message="{0}添加反担保人信息{1}。")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request,Rewarranter rewarranter) {
		Long dictid = Long.valueOf(request.getParameter("orgLookup.DictId"));
		String dictname = request.getParameter("orgLookup.DictName");
		String flag = request.getParameter("flag");
		String sort = request.getParameter("consignortype.DictName");
		rs.add(rewarranter,dictid,dictname,flag,sort);
		
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),rewarranter.getOid()}));
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	//查找带回反担保人评级
	@SuppressWarnings("unchecked")
	@RequestMapping("/property")
	public String searchback(HttpServletRequest request,BaseConditionVO vo,Model model){
		try{
		StringBuffer tSql = new StringBuffer(16);
		String pr = request.getParameter("keywords");
		tSql.append("select DictId,SortNo,DictName from sys_dict_entry where DictTypeId = 'propertyname' and Status = '1' ");
		if(pr != null){
			tSql.append("and DictName like '%"+pr+"%'");
		}
		tSql.append("order by DictName ");
		List<String> menuList=Jutil.executeSQL(tSql.toString(),vo.getStartIndex(),vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(tSql.toString()).size());
		model.addAttribute("menuList",menuList);
		model.addAttribute("vo", vo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/client/rewarranter/property";
	}
	
	
	//查找带回反担保人
	@SuppressWarnings("unchecked")
	@RequestMapping("/rewarrantersearch")
	public String rewarrantersearch(HttpServletRequest request,BaseConditionVO vo,Model model){
		try{
			StringBuffer rewarranter = new StringBuffer(16);
			String key =request.getParameter("keywords");
			rewarranter.append("select * from tbl_rewarranter ");
			if(key!=null){
				rewarranter.append("where name like '%"+key+"%' or names like '%"+key+"%' order by oid asc");
			}
			//按反担保人英文全称英文字母排序
			rewarranter.append(" order by name ");
			List<String> rlist =Jutil.executeSQL(rewarranter.toString(),vo.getStartIndex(),vo.getPageSize());
			vo.setTotalCount(Jutil.executeSQL(rewarranter.toString()).size());
			model.addAttribute("rlist",rlist);
			model.addAttribute("vo",vo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/client/rewarranter/rewarrantersearch";
	}
	
	
	//删除反担保人信息
	@Log(message="{0}删除反担保人信息{1}。")
	@RequestMapping("/delete/{oid}")
	public ModelAndView delete(@PathVariable("oid") long oid,HttpServletRequest request){
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		Rewarranter rewarranter = rs.getRewarranter(oid);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),rewarranter.getOid()}));
		rs.deleteByPrimaryKey(oid);
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	//进入反担保人编辑页面
	@RequestMapping("/edit/{oid}")
	public String update(@PathVariable("oid") int oid,Model model){
		Rewarranter rewarranter = rs.getRewarranter(oid);
		model.addAttribute("rewarranter",rewarranter);
	   return "/client/rewarranter/update";
	}
	
	//修改反担保人信息
	@Log(message="{0}修改反担保人信息{1}。")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,Rewarranter rewarranter){
		String sort = request.getParameter("orgLookup.DictName");
		rs.update(rewarranter,sort);
		
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),rewarranter.getOid()}));

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
