package com.git.web.Params;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.git.business.params.Params;
import com.git.business.params.ParamsServiceMgr;
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
@RequestMapping(value = "/params")
public class ParamsController extends BaseController {

	@Autowired
	private ParamsServiceMgr tsm;

//	// 获取事发口岸信息
//	@RequestMapping("")
//	public String list(BaseConditionVO vo, Model model) {
//		List<Params> paramslist = tsm.searchParams(vo, null, vo.getStartIndex(),
//				vo.getPageSize());
//		model.addAttribute("paramslist", paramslist);
//		int totalCount = tsm.count(vo);
//		vo.setTotalCount(totalCount);
//		model.addAttribute("vo", vo);
//		return "/params/list";
//	}
//    
	//获取所有事发口岸信息并按英文排序
	@RequestMapping("")
	public String list(HttpServletRequest request,BaseConditionVO vo,Model model){
		try{
			StringBuffer tSql = new StringBuffer(16);
			String pr = request.getParameter("keywords");
			tSql.append("select oid,paramtexta,paramtextb from tbl_params ");
			if(pr != null){
				tSql.append("where paramtexta like '%"+pr+"%' or paramtextb like '%"+pr+"%'");
			}
			//事发口岸按英文字母排序
			tSql.append(" order by paramtextb ");
				List<String> paramslist=Jutil.executeSQL(tSql.toString(),vo.getStartIndex(),vo.getPageSize());
				vo.setTotalCount(Jutil.executeSQL(tSql.toString()).size());
				model.addAttribute("paramslist",paramslist);
				model.addAttribute("vo", vo);
			}catch(Exception e){
				e.printStackTrace();
			}
		return "/params/list";
	}
	
	// 进入添加事发口岸信息页面
	@RequestMapping("/add")
	public String add(Model model) {
		return "/params/add";
	}

	// 添加事发口岸信息
	@Log(message="{0}添加事发口岸信息{1}。")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Params params,HttpServletRequest request) {
		tsm.add(params);
		
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),params.getOid()}));

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	//查找带回事发口岸
	@SuppressWarnings("unchecked")
	@RequestMapping("/search")
	public String searchback(HttpServletRequest request,BaseConditionVO vo,Model model){
		try{
		StringBuffer tSql = new StringBuffer(16);
		String pr = request.getParameter("keywords");
		tSql.append("select oid,paramtexta,paramtextb from tbl_params ");
		if(pr != null){
			tSql.append("where paramtexta like '%"+pr+"%' or paramtextb like '%"+pr+"%'");
		}
		//事发口岸按英文字母排序
		tSql.append(" order by paramtextb ");
			List<String> menuList=Jutil.executeSQL(tSql.toString(),vo.getStartIndex(),vo.getPageSize());
			vo.setTotalCount(Jutil.executeSQL(tSql.toString()).size());
			model.addAttribute("menuList",menuList);
			model.addAttribute("vo", vo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/params/param";
	}

	// 删除事发口岸信息
	@Log(message="{0}删除事发口岸信息{1}。")
	@RequestMapping("/delete/{oid}")
	public ModelAndView delete(@PathVariable("oid") long oid,HttpServletRequest request) {
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		Params params = tsm.getParams(oid);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),params.getOid()}));

		tsm.deleteByPrimaryKey(oid);

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	// 进入事发口岸编辑页面
	@RequestMapping("/edit/{oid}")
	public String update(@PathVariable("oid") int oid, Model model) {
		Params params = tsm.getParams(oid);
		model.addAttribute("params", params);
		return "/params/update";
	}

	// 修改事发口岸信息
	@Log(message="{0}修改事发口岸信息{1}。")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Params params,HttpServletRequest request) {
		tsm.update(params);
		//添加日志信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),params.getOid()}));

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
