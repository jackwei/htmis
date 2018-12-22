package com.git.web.management;

import java.util.HashMap;
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

import com.git.business.billHangService.BillHangServiceMgr;
import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.DocInfos;
import com.git.business.sys.Org;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillHangImpl;
import com.git.enums.DocInfoType;
import com.git.enums.Status;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.Jutil;
import com.git.util.MMap;
import com.git.web.BaseController;

import dwz.framework.config.Constants;
import dwz.framework.sys.exception.ServiceException;

@Controller
@RequestMapping(value="/management/billHang")
public class BillHangController extends BaseController{

	@Autowired
	private BillHangServiceMgr billHangServiceMgr;
	
	@Autowired
	private ApplyInfoServiceMgr applyInfoServiceMgr;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("")
	public String list(HttpServletRequest request,BaseConditionVO vo,Model model){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		Org org = (Org)request.getSession().getAttribute(Constants.ORGCODE_KEY);
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		
		criterias.put("remitter", request.getParameter("remitter"));
		criterias.put("remittancecustomers", request.getParameter("remittancecustomers"));
		criterias.put("remittancedate", request.getParameter("remittancedate"));
		Map search = billHangServiceMgr.searchBillHang(criterias, vo);
		
		
		List<BillHangImpl> billHangList = (List<BillHangImpl>)search.get("billHangList");
		int totalCount = (Integer)search.get("count");
		vo.setTotalCount(totalCount);
		model.addAttribute("vo",vo);
		model.addAttribute("orgType", org.getOrgType());
		model.addAttribute("billHangList",billHangList);
		return  "/management/billHang/billHangList";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("banktype",Jutil.getDictEntry("banktype"));
		model.addAttribute("yesno",Jutil.getDictEntry("yesno"));
		model.addAttribute("flag", true);
		model.addAttribute("billHangImpl",new BillHangImpl());
		return "/management/billHang/billHangInfo";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, Model model,HttpServletRequest request) {
		BillHangImpl billHangImpl = billHangServiceMgr.getBillHang(id);
		model.addAttribute("billHangImpl", billHangImpl);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("banktype",Jutil.getDictEntry("banktype"));
		model.addAttribute("yesno",Jutil.getDictEntry("yesno"));
		
		List<DocInfos> docList=applyInfoServiceMgr.selectByApplyId(Long.valueOf(billHangImpl.getId()),DocInfoType.bangdoc.getCode());
		model.addAttribute("docList", docList);
		
		if(request.getParameter("flag") != null && "select".equals(request.getParameter("flag"))){
			model.addAttribute("flag", false);
		}else{
			model.addAttribute("flag", true);
		}
		
		return "/management/billHang/billHangInfo";
	}
	
	@Log(message="用户 {0} {1}挂账单  {2}。")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertAndUpdate(BillHangImpl billHangImpl,HttpServletRequest request,Model model){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		
		try {
			billHangServiceMgr.updBillHang(billHangImpl, request);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		System.out.println("ID:"+billHangImpl.getId());
		
		/*添加财务凭证 start 
		MMap mmap = new MMap();
		mmap.put("id", billHangImpl.getId());
		calFinItemServiceMgr.dealFinItem("105", mmap);
		/*end*/
		
		if("".equals(request.getParameter("inComeId")) || null==request.getParameter("inComeId")){
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"新增",billHangImpl.getId()}));
		}else{
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"修改",billHangImpl.getId()}));

		}
		
		String forwardUrl = request.getParameter("forwardUrl");
		
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{id}", String.valueOf(billHangImpl.getId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id) {
		billHangServiceMgr.delBillHang(id);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/finish/{id}")
	public ModelAndView finishBillHang(@PathVariable("id") String id){
		BillHangImpl billHangImpl = billHangServiceMgr.getBillHang(id);
		billHangImpl.setStatus(Status.Invalid.getCode());
		try {
			billHangImpl.setStatus(Status.Invalid.getCode());
			billHangServiceMgr.updateBillHang(billHangImpl);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
}
