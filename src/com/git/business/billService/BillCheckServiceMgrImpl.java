/**
 * 
 */
package com.git.business.billService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillCheckImpl;
import com.git.db.beans.BillCheckImplExample;
import com.git.db.beans.BillCheckImplExample.Criteria;
import com.git.db.beans.BillIncomeImpl;
import com.git.db.beans.BillIncomeImplExample;
import com.git.db.mapper.BillCheckImplMapper;
import com.git.db.mapper.BillIncomeImplMapper;
import com.git.util.PubDateUtil;
import com.git.util.service.SequenceService;
import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("billCheckServiceMgr")
public class BillCheckServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements BillCheckServiceMgr{

	@Autowired
	private BillIncomeImplMapper billIncomeImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private BillCheckImplMapper billCheckImplMapper;
	
	public BillCheckImpl getBillCheck(String checkId){
		BillCheckImpl billCheckImpl = billCheckImplMapper.selectByPrimaryKey(Long.valueOf(checkId));
		return billCheckImpl;
	}
	
	public BillCheckImpl getBillCheckByBillId(String billId){
		BillCheckImplExample example = new BillCheckImplExample();
		com.git.db.beans.BillCheckImplExample.Criteria  criteria = example.createCriteria();
		criteria.andFeeidEqualTo(billId);
		BillCheckImpl billCheckImpl = null;
		if(billCheckImplMapper.selectByExample(example).size() > 0){
			billCheckImpl = billCheckImplMapper.selectByExample(example).get(0);
		}
		
		return billCheckImpl;
	}
	
	public int addBillCheck(BillCheckImpl billCheckImpl){
		return billCheckImplMapper.insertSelective(billCheckImpl);
		
	}
	
	public int updBillCheck(BillCheckImpl billCheckImpl){
		return billCheckImplMapper.updateByPrimaryKeySelective(billCheckImpl);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map search(Map criterias,BaseConditionVO vo){
		Map search = new HashMap();
		List<BillCheckImpl> billCheckList = new ArrayList<BillCheckImpl>();
		BillCheckImplExample example = new BillCheckImplExample();
		example.setOrderByClause("feenum desc");
		Criteria criteria = example.createCriteria();
		
		if(null != criterias.get("feenum") && !"".equals(criterias.get("feenum"))){
			criteria.andFeenumLike("%"+criterias.get("feenum").toString()+"%");
		}
		if(null != criterias.get("feeamount_start") && !"".equals(criterias.get("feeamount_start"))){
			criteria.andFeeamountGreaterThanOrEqualTo(Float.valueOf(criterias.get("feeamount_start").toString()));
		}
		if(null != criterias.get("feeamount_end") && !"".equals(criterias.get("feeamount_end"))){
			criteria.andFeeamountLessThanOrEqualTo(Float.valueOf(criterias.get("feeamount_end").toString()));
		}
		if(null != criterias.get("payername") && !"".equals(criterias.get("payername"))){
			criteria.andPayernameLike("%"+criterias.get("payername").toString()+"%");
		}
		
		if(null != criterias.get("printBill") && !"".equals(criterias.get("printBill"))){
			if("1".equals(criterias.get("printBill"))){
				criteria.andPrintdateIsNull();
			}else{
				criteria.andPrintdateIsNotNull();
			}
		}
		int count = billCheckImplMapper.countByExample(example);
		RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		billCheckList = billCheckImplMapper.selectByExampleWithRowbounds(example, rb);
		search.put("billCheckList", billCheckList);
		search.put("count", count);
		
		return search;
	}
	
	@SuppressWarnings("rawtypes")
	public List<BillCheckImpl> searchBillCheck(Map criterias,BaseConditionVO vo){
		List<BillCheckImpl> billCheckList = new ArrayList<BillCheckImpl>();
		BillCheckImplExample example = new BillCheckImplExample();
		example.setOrderByClause("feenum desc");
		Criteria criteria = example.createCriteria();
		criteria.andOrgcodeLike(criterias.get("orgCode").toString()+"%");
		criteria.andCurrencyEqualTo(criterias.get("currency").toString());
		//criteria.andArrdateIsNull();
		criteria.andDifferamountGreaterThan(Float.valueOf(0));
		
		criteria.andFlagEqualTo("1");//0 失效,1 有效
		
		if(null != criterias.get("feenumber") && !"".equals(criterias.get("feenumber"))){
			criteria.andFeenumLike("%"+criterias.get("feenumber").toString()+"_%");
		}
		if(null != criterias.get("feeamount_start") && !"".equals(criterias.get("feeamount_start"))){
			criteria.andFeeamountGreaterThanOrEqualTo(Float.valueOf(criterias.get("feeamount_start").toString()));
		}
		if(null != criterias.get("feeamount_end") && !"".equals(criterias.get("feeamount_end"))){
			criteria.andFeeamountLessThanOrEqualTo(Float.valueOf(criterias.get("feeamount_end").toString()));
		}
		if(null != criterias.get("payername") && !"".equals(criterias.get("payername"))){
			criteria.andPayernameEqualTo(criterias.get("payername").toString());
		}
		
		RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		billCheckList = billCheckImplMapper.selectByExampleWithRowbounds(example, rb);
		return billCheckList;
	}
	
	@SuppressWarnings("rawtypes")
	public List<BillCheckImpl> searchBillCheckedByStatement(Map criterias,BaseConditionVO vo){
		List<BillCheckImpl> billCheckList = new ArrayList<BillCheckImpl>();
		BillCheckImplExample example = new BillCheckImplExample();
		Criteria criteria = example.createCriteria();
		
		if(null != criterias.get("feenum") && !"".equals(criterias.get("feenum"))){
			criteria.andFeenumEqualTo(criterias.get("feenum").toString());
		}
		if(null != criterias.get("feeamount_start") && !"".equals(criterias.get("feeamount_start"))){
			criteria.andFeeamountGreaterThanOrEqualTo(Float.valueOf(criterias.get("feeamount_start").toString()));
		}
		if(null != criterias.get("feeamount_end") && !"".equals(criterias.get("feeamount_end"))){
			criteria.andFeeamountLessThanOrEqualTo(Float.valueOf(criterias.get("feeamount_end").toString()));
		}
		if(null != criterias.get("payername") && !"".equals(criterias.get("payername"))){
			criteria.andPayernameEqualTo(criterias.get("payername").toString());
		}
		
		criteria.andStatementnumberEqualTo(criterias.get("statementnumber").toString());
		
		RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		billCheckList = billCheckImplMapper.selectByExampleWithRowbounds(example, rb);
		return billCheckList;
	}
		
	public int updBillInCome(BillIncomeImpl billIncomeImpl,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		
		if("".equals(request.getParameter("inComeId")) || null==request.getParameter("inComeId")){
			SimpleDateFormat sd = new SimpleDateFormat("yy");
			Date date = new Date();
			String yearstr = sd.format(date);
			String statementnumber = sequenceService.getSequence("statementnumber", "HTFS", yearstr, "", 6, '0', 'L');
			billIncomeImpl.setIncomeId(sequenceService.getSequence("inCome_id"));
			billIncomeImpl.setStatementnumber(statementnumber);
			//billIncomeImpl.setOrgcode(user.getOrgId().toString());
			//billIncomeImpl.setOrgname(user.getOrgName());
			billIncomeImpl.setCreateTime(new Date());
			
		}else{
			billIncomeImpl.setStatementnumber(request.getParameter("statementnumber"));
			billIncomeImpl.setModifyTime(new Date());
		}
		
		billIncomeImpl.setFeenumber(request.getParameter("feenumber"));
		billIncomeImpl.setPayername(request.getParameter("payername"));
		billIncomeImpl.setCurrency(request.getParameter("currency"));
		billIncomeImpl.setTradedate(PubDateUtil.stringToDate(request.getParameter("tradedate"),"yyyy-MM-dd"));
		billIncomeImpl.setPayamount(Float.valueOf(request.getParameter("payamount")));
		billIncomeImpl.setLossamount(Float.valueOf(request.getParameter("lossamount")));
		billIncomeImpl.setChangeamount(Float.valueOf(request.getParameter("changeamount")));
		billIncomeImpl.setRemark(request.getParameter("remark"));
		
		if("".equals(request.getParameter("inComeId")) || null==request.getParameter("inComeId")){
			return billIncomeImplMapper.insert(billIncomeImpl);
		}else{
			return billIncomeImplMapper.updateByPrimaryKeySelective(billIncomeImpl);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List<BillIncomeImpl> searchBillInCome(Map criterias,BaseConditionVO vo){
		List<BillIncomeImpl> billInComeList = new ArrayList<BillIncomeImpl>();
		BillIncomeImplExample example = new BillIncomeImplExample();
		RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		billInComeList = billIncomeImplMapper.selectByExampleWithRowbounds(example, rb);
		return billInComeList;
	}
	
	public BillIncomeImpl getBillIncome(String inComeId){
		BillIncomeImpl ci = billIncomeImplMapper.selectByPrimaryKey(Long.valueOf(inComeId));
		return ci;
	}
	
	public void delBillIncome(String inComeId){
		billIncomeImplMapper.deleteByPrimaryKey(Long.valueOf(inComeId));
	}
	
	public int getCount(){
		BillIncomeImplExample exa = new BillIncomeImplExample();
		return billIncomeImplMapper.countByExample(exa);
	}
	
}
