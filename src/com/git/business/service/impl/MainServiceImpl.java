package com.git.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.git.business.service.MainService;
import com.git.business.sys.User;
import com.git.db.beans.BillIncomeImpl;
import com.git.db.beans.BillIncomeImplExample;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseBillImplExample;
import com.git.db.beans.CaseBillImplExample.Criteria;
import com.git.db.mapper.BillIncomeImplMapper;
import com.git.db.mapper.CaseBillImplMapper;
import com.git.util.Jutil;
import com.git.util.PubDateUtil;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Service
@Transactional
public class MainServiceImpl extends AbstractBusinessObjectServiceMgr implements MainService {
	
	@Autowired
	private CaseBillImplMapper caseBillImplMapper;
	
	@Autowired
	private BillIncomeImplMapper billIncomeImplMapper;
	
	/**
	 * 案件6个月还未发账
	 * */
	public List<CaseBillImpl> getCaseBillByOne(Map<Object, Object> criterias){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);

		CaseBillImplExample example = new CaseBillImplExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andAccdateIsNull();
		criteria.andCreateTimeLessThan(PubDateUtil.getCurrentDateByMonth(-6));
		criteria.andOperatorIdEqualTo(user.getId());
		
		List<CaseBillImpl> caseBillList = caseBillImplMapper.selectByExample(example);
		
		return caseBillList;
	}
	
	/**
	 * 已到账还未发账
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CaseBillImpl> getCaseBillByTwo(Map<Object, Object> criterias){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);

		List<CaseBillImpl> caseBillList = new ArrayList<CaseBillImpl>();
		List<Map> feenumberList = Jutil.executeSQL("select distinct b.`feenumber` from tbl_bill_income b where b.`checkdate` is null ");
		
		for (Map map : feenumberList) {
			String feenumber = map.get("feenumber").toString();
			CaseBillImplExample example = new CaseBillImplExample();
			Criteria criteria = example.createCriteria();
			criteria.andCasenumberEqualTo(feenumber);
			criteria.andAccdateIsNull();
			criteria.andOperatorIdEqualTo(user.getId());
			if(caseBillImplMapper.selectByExample(example).size() > 0){
				caseBillList.add(caseBillImplMapper.selectByExample(example).get(0));
			}
		}
	
		return caseBillList;
	}
	
	
	/**
	 * 发账3个月未到账
	 * */
	public List<CaseBillImpl> getCaseBillByThree(Map<Object, Object> criterias){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);

		List<CaseBillImpl> billList = new ArrayList<CaseBillImpl>();
		CaseBillImplExample example = new CaseBillImplExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccdateGreaterThan(PubDateUtil.getCurrentDateByMonth(-3));
		criteria.andOperatorIdEqualTo(user.getId());
		List<CaseBillImpl> caseBillList = caseBillImplMapper.selectByExample(example);
		
		for (CaseBillImpl caseBillImpl : caseBillList) {
			String casenumber = caseBillImpl.getCasenumber();
			if(casenumber != null && "".equals(casenumber)){
				BillIncomeImplExample be = new BillIncomeImplExample();
				com.git.db.beans.BillIncomeImplExample.Criteria ca =  be.createCriteria();
				ca.andFeenumberEqualTo(casenumber);
				List<BillIncomeImpl> billInComeList = billIncomeImplMapper.selectByExample(be);
				if(billInComeList.size() <= 0){
					billList.add(caseBillImpl);
				}
			}
		}
		
		return billList;
	}
	
}
