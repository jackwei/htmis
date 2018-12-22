package com.git.web.management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.service.LogEntityService;
import com.git.business.sys.User;
import com.git.business.voucher.VoucherServiceMgr;
import com.git.db.BaseConditionVO;
import com.git.db.beans.FinData;
import com.git.db.beans.FinDataResult;
import com.git.db.beans.LogEntity;
import com.git.enums.VoucherStatus;
import com.git.log.Log;
import com.git.log.LogLevel;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.Jutil;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping("/voucher")
public class VoucherController extends BaseController{
	
	@Autowired
	private VoucherServiceMgr voucherServiceMgr;
	
	private User user;
	
	@RequestMapping("/searchFinData")
	public String searchFinData(HttpServletRequest request,BaseConditionVO vo,Model model){
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("bussId", request.getParameter("bussId"));
		criterias.put("bussKeyNo", request.getParameter("bussKeyNo"));
		criterias.put("makeTime", request.getParameter("makeTime"));
		
		Map search = voucherServiceMgr.searchFinData(criterias, vo);
		List<FinData> FinDataList = (List<FinData>)search.get("FinDataList");
		int count = (Integer)search.get("count");
		vo.setTotalCount(count);
		model.addAttribute("vo", vo);
		
		List bussType = Jutil.executeSQL("select d.`Buss_Id`,d.`Buss_Name` from t_fin_buss_type_def d ");
		model.addAttribute("bussType", bussType);
		
		model.addAttribute("voucherStatus", VoucherStatus.values());
		model.addAttribute("FinDataList", FinDataList);
		return "/voucher/FinDataList";
		
	}
	
	@RequestMapping("/searchFinDataResult/{batchNo}")
	public String searchFinDataResult(@PathVariable("batchNo") String batchNo, HttpServletRequest request,BaseConditionVO vo,Model model){
		
		FinData finData = voucherServiceMgr.getFinData(batchNo);
		model.addAttribute("finData", finData);
		
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("batchNo", finData.getBatchNo());
		Map search = voucherServiceMgr.searchFinDataResult(criterias);
		List<FinDataResult> FinDataResultList = (List<FinDataResult>)search.get("FinDataResultList");
		vo.setTotalCount(FinDataResultList.size());
		model.addAttribute("vo", vo);
		
		List bussType = Jutil.executeSQL("select d.`Buss_Id`,d.`Buss_Name` from t_fin_buss_type_def d ");
		model.addAttribute("bussType", bussType);
		
		model.addAttribute("voucherStatus", VoucherStatus.values());
		model.addAttribute("FinDataResultList", FinDataResultList);
		return "/voucher/FinDataResultList";
	}
	
	@RequestMapping("/view")
	public String list(){
		
		return "";
	}
	
	@Log(message="{0} 删除了 {1} 条凭证 {2}。")
	@RequestMapping("/delete/{batchNo}")
	public ModelAndView delete(@PathVariable("batchNo") String batchNo,HttpServletRequest request){
		user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		//String[] ids = request.getParameterValues("ids");
		int count = voucherServiceMgr.deleteFinDataResult(batchNo);
		voucherServiceMgr.deleteFinData(batchNo);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),count,batchNo}));
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

}
