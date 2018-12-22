package com.git.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.handle.CaseHandleServiceMgr;
import com.git.business.service.xml.ExchageRateMarshaller;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseHandleImpl;
import com.git.db.beans.ExchageRateImpl;
import com.git.db.beans.ExchageRateImplExample;
import com.git.db.mapper.ExchageRateImplMapper;
import com.git.util.Jutil;
import com.git.util.PubDateUtil;
import com.git.util.service.SequenceService;

@Controller
@RequestMapping(value="/rate")
public class ExchageRateController extends BaseController{
	
	@Autowired
	private ExchageRateImplMapper exchageRateImplMapper;
	
	@Autowired
	private SequenceService sequenceService;

	@RequestMapping("")
	public String searchRate(HttpServletRequest request,Model model,BaseConditionVO vo){
		ExchageRateMarshaller exchageRateMarshaller = new ExchageRateMarshaller();
		List<ExchageRateImpl> rateList = new ArrayList<ExchageRateImpl>();
		String searchDate = "";
		if(null == request.getParameter("searchDate") || "".equals(request.getParameter("searchDate"))){
			searchDate = PubDateUtil.dateFormat(new Date(), "yyyy-MM-dd");
		}else{
			searchDate =request.getParameter("searchDate");
		}
		String currency="";
		if(null != request.getParameter("shortname")){
			currency = request.getParameter("shortname");
		}
		
		
		ExchageRateImplExample example1 = new ExchageRateImplExample();
		example1.createCriteria().andModifyTimeEqualTo(PubDateUtil.stringToDate(searchDate, "yyyy-MM-dd"));
		int count = exchageRateImplMapper.selectByExample(example1).size();
		RowBounds rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		int rows = 0;
		if(count > 0){
			ExchageRateImplExample example = new ExchageRateImplExample();
			example.setOrderByClause(" Create_Time desc ");
			if(!"".equals(currency)){
				example.createCriteria().andShortnameEqualTo(currency);
			}
			rows = exchageRateImplMapper.countByExample(example);
			rateList = exchageRateImplMapper.selectByExampleWithRowbounds(example,rowBounds);
		}else{
			rateList =  exchageRateMarshaller.syncExchageRate(searchDate);
			if(rateList.size() > 0){
				for (ExchageRateImpl exchageRateImpl : rateList) {
					exchageRateImpl.setId(sequenceService.getSequence("exchageRate"));
					exchageRateImpl.setCreateTime(new Date());
					exchageRateImpl.setModifyTime(PubDateUtil.stringToDate(searchDate, "yyyy-MM-dd"));
					exchageRateImplMapper.insertSelective(exchageRateImpl);
				}
			}else{
				ExchageRateImplExample example = new ExchageRateImplExample();
				example.setOrderByClause(" Create_Time desc ");
				if(!"".equals(currency)){
					example.createCriteria().andCurrencyEqualTo(currency);
				}
				rows = exchageRateImplMapper.countByExample(example);
				rateList = exchageRateImplMapper.selectByExampleWithRowbounds(example, rowBounds);
			}
		}
		
		vo.setTotalCount(rows);
		model.addAttribute("rateList", rateList);
		model.addAttribute("vo", vo);
		return "/rate/rateList";
	}
	
}
