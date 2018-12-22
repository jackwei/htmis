package com.git.web.Client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.git.business.assure.third.Third;
import com.git.business.assure.third.ThirdServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.Jutil;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/client/thirdparty")
public class ThirdController extends BaseController {

	@Autowired
	private ThirdServiceMgr tsm;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("")
	public String plist(HttpServletRequest request,BaseConditionVO vo, Model model) {
		StringBuffer sf = new StringBuffer(16);
		String keywords = request.getParameter("keywords");
		String status = request.getParameter("status");
		String property = request.getParameter("property");
		System.out.println("keywords:"+keywords+"---"+"status:"+status+"----"+"property:"+property);
		sf.append("select * from tbl_thirdparty where 1=1 ");
		if(keywords!=null && keywords!=""){
			sf.append("and nameen like '%"+keywords+"%' or namecn like '%"+keywords+"%' or nameens like '%"+keywords+"%' or namecns like '%"+keywords+"%' ");
		}
		/*if(status!=null && status!=""){
			sf.append("and type = '"+status+"' ");
		}
		if(property!=null && property!=""){
			sf.append("and property = '"+property+"' ");
		}
		*/
		sf.append(" order by nameen ");
		System.out.println(sf.toString());
		List<Third> thirdlist = Jutil.executeSQL(sf.toString(),vo.getStartIndex(),vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(sf.toString()).size());
		model.addAttribute("thirdlist", thirdlist);
		model.addAttribute("vo", vo);
		model.addAttribute("keywords", keywords);
		return "/client/third/list";
	}

	
	//查找带回第三方信息
	@SuppressWarnings("unchecked")
	@RequestMapping("thirdsearch")
	public String thirdsearch(HttpServletRequest request,BaseConditionVO vo,Model model){
		StringBuffer sbf = new StringBuffer(16);
		String kw = request.getParameter("keywords");
		sbf.append("select * from tbl_thirdparty ");
		if(kw!=null){
			sbf.append("where nameen like '%"+kw+"%' or namecn like '%"+kw+"%' ");
		}
		//按第三方英文全称英文字母排序
		sbf.append("order by nameen");
		List<String> tdlist = Jutil.executeSQL(sbf.toString(),vo.getStartIndex(),vo.getPageSize());
		vo.setTotalCount(Jutil.executeSQL(sbf.toString()).size());	
		model.addAttribute("tdlist",tdlist);
		model.addAttribute("vo",vo);
		return "/client/third/thirdsearch";
	}
	
	
	// 进入添加第三方信息页面
	@RequestMapping("/add")
	public String add(Model model) {
		return "/client/third/add";
	}

	// 添加第三方信息
	@Log(message="{0}添加第三方信息{1}。")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Third third,HttpServletRequest request) {
		tsm.add(third);
		
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),String.valueOf(third.getOid())}));

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	// 删除第三方信息
	@Log(message="{0}删除第三方信息{1} 。")
	@RequestMapping("/delete/{oid}")
	public ModelAndView delete(@PathVariable("oid") Long oid,HttpServletRequest request) {
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		Third third =tsm.getthird(oid);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),String.valueOf(third.getOid())}));

		tsm.deleteByPrimaryKey(oid);
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	// 进入第三方编辑页面
	@RequestMapping("/edit/{oid}")
	public String update(@PathVariable("oid") Long oid, Model model) {
		Third third = tsm.getthird(oid);
		model.addAttribute("third", third);
		return "/client/third/update";
	}

	// 修改第三方信息
	@Log(message="{0}修改第三方信息 {1}。")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Third third,HttpServletRequest request) {
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),third.getOid()}));

		tsm.update(third);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
