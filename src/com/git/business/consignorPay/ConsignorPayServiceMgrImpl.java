/**
 * 
 */
package com.git.business.consignorPay;

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
import com.git.db.beans.ConsignorPayImpl;
import com.git.db.beans.ConsignorPayImplExample;
import com.git.db.beans.ConsignorPayImplExample.Criteria;
import com.git.db.mapper.ConsignorPayImplMapper;
import com.git.enums.PayStatus;
import com.git.util.PubDateUtil;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("consignorPayServiceMgr")
public class ConsignorPayServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements ConsignorPayServiceMgr{

	@Autowired
	private ConsignorPayImplMapper consignorPayImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	
	public int checkPay(){
		return 1;
	}
	
	public int updateConsignorPay(ConsignorPayImpl consignorPayImpl){
		return consignorPayImplMapper.updateByPrimaryKeySelective(consignorPayImpl);
	}
	
	/**
	 * 
	 * */
	public int updConsignorPay(ConsignorPayImpl consignorPayImpl,HttpServletRequest request ) throws ServiceException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);

		if("".equals(request.getParameter("payId")) || null==request.getParameter("payId")){
			consignorPayImpl.setPayId(sequenceService.getSequence("pay_id"));
			consignorPayImpl.setUserid(user.getId().toString());
			consignorPayImpl.setUseridname(user.getName());
			consignorPayImpl.setPaystatus(PayStatus.PayNew.getCode());
			consignorPayImpl.setCreateOperator(user.getId());
			consignorPayImpl.setCreateTime(new Date());
		}else{
			consignorPayImpl.setPayId(Long.valueOf(request.getParameter("payId")));
			consignorPayImpl.setModifyTime(new Date());
			consignorPayImpl.setModifyOperatorId(user.getId());
		}
		
		//查找带回收款人信息
		consignorPayImpl.setPayeename(request.getParameter("consignor.namecn"));
		consignorPayImpl.setPayeeid(request.getParameter("consignor.oid"));
		
		//查找带回开户行信息
		consignorPayImpl.setPayeeaccountname(request.getParameter("consignor.accountname"));
		consignorPayImpl.setPayeeaccountnum(request.getParameter("consignor.accountnum"));
		
		//consignorPayImpl.setBankfee(Float.valueOf(request.getParameter("bankfee")));
		//consignorPayImpl.setBanknum(request.getParameter("banknum"));
		//consignorPayImpl.setBinddetail(request.getParameter("binddetail"));
		
		consignorPayImpl.setPayamount(Float.valueOf(request.getParameter("payamount")));
		consignorPayImpl.setPaydate(PubDateUtil.stringToDate(request.getParameter("paydate"),"yyyy-MM-dd"));
		consignorPayImpl.setPaycurrency(request.getParameter("paycurrency"));
		consignorPayImpl.setFeeamount(Float.valueOf(request.getParameter("feeamount")));
		
		//查找带回机构信息 
		consignorPayImpl.setOrgnameb(request.getParameter("orgLookup.extend1"));
		consignorPayImpl.setOrgidb(request.getParameter("orgLookup.id"));
		
		consignorPayImpl.setRemark(request.getParameter("remark"));
		
		if("".equals(request.getParameter("payId")) || null==request.getParameter("payId")){
			return consignorPayImplMapper.insert(consignorPayImpl);
		}else{
			return consignorPayImplMapper.updateByPrimaryKeySelective(consignorPayImpl);
		}
	}
	
	/**
	 * 
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<Object,Object> searchConsignorPay(Map criterias,BaseConditionVO vo){
		List<ConsignorPayImpl> consignorPayList = new ArrayList<ConsignorPayImpl>();
		ConsignorPayImplExample example = new ConsignorPayImplExample();
		Map search = new HashMap<Object, Object>();
		Criteria  criteria = example.createCriteria();
		example.setOrderByClause("Pay_Id desc");
		if(null != criterias.get("userId") && !"".equals(criterias.get("userId"))){
			criteria.andCreateOperatorEqualTo((Long)criterias.get("userId"));
		}
		if(null != criterias.get("payeename") && !"".equals(criterias.get("payeename"))){
			criteria.andPayeenameLike("%"+criterias.get("payeename").toString()+"%");
		}
		
		if(null != criterias.get("payamount") && !"".equals(criterias.get("payamount"))){
			criteria.andPayamountEqualTo(Float.valueOf(criterias.get("payamount").toString()));
		}
		
		if(null != criterias.get("paystatus")){
			criteria.andPaystatusEqualTo(criterias.get("paystatus").toString());
		}
		int count = consignorPayImplMapper.countByExample(example);
		search.put("count", count);
		RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		consignorPayList = consignorPayImplMapper.selectByExampleWithRowbounds(example, rb);
		search.put("consignorPayList",consignorPayList);
		return search;
	}
	
	public ConsignorPayImpl getConsignorPay(String payId){
		ConsignorPayImpl cc = consignorPayImplMapper.selectByPrimaryKey(Long.valueOf(payId));
		return cc;
	}
	
	public int del(String payId){
		return consignorPayImplMapper.deleteByPrimaryKey(Long.valueOf(payId));
	}
	
	public int getCount(){
		ConsignorPayImplExample exa = new ConsignorPayImplExample();
		return consignorPayImplMapper.countByExample(exa);
	}


	
	
}
