/**
 * 
 */
package com.git.business.billService;

import java.math.BigDecimal;
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

import com.git.business.caseService.CaseServiceMgr;
import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillIncomeImpl;
import com.git.db.beans.BillIncomeImplExample;
import com.git.db.beans.BillIncomeImplExample.Criteria;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.mapper.BillIncomeImplMapper;
import com.git.enums.InComeType;
import com.git.util.MMap;
import com.git.util.PubDateUtil;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

/**
 * @author Administrator
 *
 */
@Service("billServiceMgr")
public class BillServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements BillServiceMgr{

	@Autowired
	private BillIncomeImplMapper billIncomeImplMapper;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;
	
	@Autowired
	private CaseServiceMgr caseServiceMgr;
	
	@Autowired
	private SequenceService sequenceService;
	
	public int updateBillInCome(BillIncomeImpl billIncomeImpl){
		return billIncomeImplMapper.updateByPrimaryKeySelective(billIncomeImpl);
	}
		
	public int updBillInCome(BillIncomeImpl billIncomeImpl,HttpServletRequest request) throws ServiceException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		CaseInfoImpl caseInfoImpl =  caseServiceMgr.searchCaseInfoByCaseNumber(request.getParameter("feenumber"));
		
		if("".equals(request.getParameter("inComeId")) || null==request.getParameter("inComeId")){
			SimpleDateFormat sd = new SimpleDateFormat("yy");
			Date date = new Date();
			String yearstr = sd.format(date);
			String statementnumber = sequenceService.getSequence("statementnumber", "HTFS", yearstr, "", 6, '0', 'L');
			billIncomeImpl.setIncomeId(sequenceService.getSequence("inCome_id"));
			billIncomeImpl.setStatementnumber(statementnumber);
			billIncomeImpl.setOrgcode(caseInfoImpl.getOrgcode());
			billIncomeImpl.setOrgname(caseInfoImpl.getOraname());
			billIncomeImpl.setCreateTime(new Date());
			billIncomeImpl.setOperatorId(user.getId());
			billIncomeImpl.setEntrypeople(user.getName());
		}else{
			if(!"HTPI1300".equals(billIncomeImpl.getFeenumber().substring(0, 8))){
				if(billIncomeImpl.getIncometype().equals(InComeType.InComeType2.getCode())){
					/*添加担保财务凭证 start */
					MMap mmap = new MMap();
					mmap.put("income_id", billIncomeImpl.getIncomeId());
					calFinItemServiceMgr.dealFinItem("113", mmap,-1);
					/*end*/
				}else{
					/*添加财务凭证 start */
					MMap mmap = new MMap();
					mmap.put("income_id", billIncomeImpl.getIncomeId());
					calFinItemServiceMgr.dealFinItem("103", mmap,-1);
					/*end*/
				}
			}
			
			billIncomeImpl.setIncomeId(Long.valueOf(request.getParameter("inComeId")));
			billIncomeImpl.setStatementnumber(request.getParameter("statementnumber"));
			billIncomeImpl.setModifyTime(new Date());
			billIncomeImpl.setModifyOperatorId(user.getId());
		}
		
		billIncomeImpl.setFeenumber(request.getParameter("feenumber"));
		billIncomeImpl.setPayername(request.getParameter("payername"));
		
		//添加进账单类型
		String incometype = request.getParameter("incometype");
//		if("1".equals(incometype)){
//			billIncomeImpl.setIncometype(InComeType.InComeType1.getCode());
//		}else if("2".equals(incometype)){
//			billIncomeImpl.setIncometype(InComeType.InComeType2.getCode());
//		}else if("3".equals(incometype)){
//			billIncomeImpl.setIncometype(InComeType.InComeType2.getCode());
//		}
		billIncomeImpl.setIncometype(incometype);
		
		billIncomeImpl.setCurrency(request.getParameter("currency"));
		billIncomeImpl.setTradedate(PubDateUtil.stringToDate(request.getParameter("tradedate"),"yyyy-MM-dd"));
		billIncomeImpl.setPayamount(Float.valueOf(request.getParameter("payamount")));
		billIncomeImpl.setLossamount(Float.valueOf(request.getParameter("lossamount")));
		billIncomeImpl.setChangeamount(Float.valueOf(request.getParameter("changeamount")));
		billIncomeImpl.setDifferamount(Float.valueOf(request.getParameter("changeamount")));
	
		//转换账单信息
		billIncomeImpl.setIsTransform(request.getParameter("isTransform"));
		billIncomeImpl.setTransformrate(new BigDecimal(request.getParameter("transformrate")));
		billIncomeImpl.setTransformcurrency(request.getParameter("transformcurrency"));
		
		//收款银行
		billIncomeImpl.setBank(request.getParameter("bank"));
		billIncomeImpl.setRemark(request.getParameter("remark"));
		
		int count =0 ;
		if("".equals(request.getParameter("inComeId")) || null==request.getParameter("inComeId")){
			count = billIncomeImplMapper.insert(billIncomeImpl);
		}else{
			count = billIncomeImplMapper.updateByPrimaryKeySelective(billIncomeImpl);
		}
		
		if(!"HTPI1300".equals(billIncomeImpl.getFeenumber().substring(0, 8))){
			if(billIncomeImpl.getIncometype().equals(InComeType.InComeType2.getCode())){
				/*添加担保财务凭证 start */
				MMap mmap = new MMap();
				mmap.put("income_id", billIncomeImpl.getIncomeId());
				calFinItemServiceMgr.dealFinItem("113", mmap,1);
				/*end*/
			}else{
				/*添加财务凭证 start */
				MMap mmap = new MMap();
				mmap.put("income_id", billIncomeImpl.getIncomeId());
				calFinItemServiceMgr.dealFinItem("103", mmap,1);
				/*end*/
			}
		}

		return count;
	}
	
	@SuppressWarnings("rawtypes")
	public Map searchBillInCome(Map criterias,BaseConditionVO vo){
		Map search = new HashMap();
		List<BillIncomeImpl> billInComeList = new ArrayList<BillIncomeImpl>();
		BillIncomeImplExample example = new BillIncomeImplExample();
		example.setOrderByClause("statementnumber desc");
		Criteria criteria = example.createCriteria();
		
		/*if(null != criterias.get("userId") && !"".equals(criterias.get("userId"))){
			criteria.andOperatorIdEqualTo((Long)criterias.get("userId"));
		}*/
		//criteria.andOperatorIdEqualTo((Long)criterias.get("userId"));
		
		if(null != criterias.get("statementnumber") && !"".equals(criterias.get("statementnumber"))){
			criteria.andStatementnumberLike("%"+criterias.get("statementnumber").toString()+"%");
		}
		
		if(null != criterias.get("payername") && !"".equals(criterias.get("payername"))){
			criteria.andPayernameLike("%"+criterias.get("payername").toString()+"%");
		}
		
		if(null != criterias.get("feenumber") && !"".equals(criterias.get("feenumber"))){
			criteria.andFeenumberLike("%"+criterias.get("feenumber").toString()+"%");
		}
		
		if(null != criterias.get("tradedate") && !"".equals(criterias.get("tradedate"))){
			criteria.andTradedateEqualTo(PubDateUtil.stringToDate(criterias.get("tradedate").toString(), "yyyy-MM-dd"));
		}
		
		if(null != criterias.get("changeamount") && !"".equals(criterias.get("changeamount"))){
			criteria.andChangeamountEqualTo(Float.valueOf(criterias.get("changeamount").toString()));
		}
		
		if(criterias.get("flag") !=null || criterias.get("bill") !=null ){
			if("0".equals(criterias.get("flag")) || "take".equals(criterias.get("bill"))){
				criteria.andCheckdateIsNull();
			}else if("1".equals(criterias.get("flag"))){
				criteria.andCheckdateIsNotNull();
			}
		} 
		
		RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		
		int count = billIncomeImplMapper.countByExample(example);
		billInComeList = billIncomeImplMapper.selectByExampleWithRowbounds(example, rb);
		search.put("billInComeList", billInComeList);
		search.put("count", count);
		
		return search;
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
