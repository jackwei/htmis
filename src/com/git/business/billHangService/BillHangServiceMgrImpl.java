/**
 * 
 */
package com.git.business.billHangService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillHangImpl;
import com.git.db.beans.BillHangImplExample;
import com.git.db.beans.BillHangImplExample.Criteria;
import com.git.db.mapper.BillHangImplMapper;
import com.git.enums.Status;
import com.git.util.PubDateUtil;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

/**
 * @author Administrator
 *
 */
@Service("billHangServiceMgr")
public class BillHangServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements BillHangServiceMgr{
	
	@Autowired
	private BillHangImplMapper billHangImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	public int insertBillHang(BillHangImpl billHangImpl){
		//User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		//billHangImpl.setId(sequenceService.getSequence("BillHangImpl"));
		billHangImpl.setStatus(Status.Normal.getCode());
		//billHangImpl.setOperatorId(user.getId());
		//billHangImpl.setEntrypeople(user.getName());
		return billHangImplMapper.insertSelective(billHangImpl);
	}
	
	public int updateBillHang(BillHangImpl billHangImpl){
		return billHangImplMapper.updateByPrimaryKeySelective(billHangImpl);
	}
		
	public int updBillHang(BillHangImpl billHangImpl,HttpServletRequest request) throws ServiceException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		int count = 0;
		if("".equals(request.getParameter("id")) || null==request.getParameter("id")){
			billHangImpl.setId(sequenceService.getSequence("BillHangImpl"));
			billHangImpl.setStatus(Status.Normal.getCode());
			billHangImpl.setCreateTime(new Date());
			billHangImpl.setOperatorId(user.getId());
			billHangImpl.setEntrypeople(user.getName());
			count = billHangImplMapper.insert(billHangImpl);
		}else{
			billHangImpl.setId(Long.valueOf(request.getParameter("id")));
			billHangImpl.setModifyTime(new Date());
			billHangImpl.setModifyOperatorId(user.getId());
			count = billHangImplMapper.updateByPrimaryKeySelective(billHangImpl);
		}

		return count;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map searchBillHang(Map criterias,BaseConditionVO vo){
		Map search = new HashMap();
		
		BillHangImplExample example = new BillHangImplExample();
		example.setOrderByClause("id desc");
		Criteria criteria = example.createCriteria();
		
		criteria.andStatusEqualTo(Status.Normal.getCode());
		
		if(null != criterias.get("remitter") && !"".equals(criterias.get("remitter"))){
			criteria.andRemitterLike("%"+criterias.get("remitter").toString()+"%");
		}
		
		if(null != criterias.get("remitmoney") && !"".equals(criterias.get("remitmoney"))){
			criteria.andRemitmoneyEqualTo(Float.valueOf(criterias.get("remitmoney").toString()));
		}
		
		if(null != criterias.get("remittancedate") && !"".equals(criterias.get("remittancedate"))){
			criteria.andRemittancedateEqualTo(PubDateUtil.stringToDate(criterias.get("remittancedate").toString(), "yyyy-MM-dd"));
		}
		example.setOrderByClause(" remittancedate desc ");
		RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		int count = billHangImplMapper.countByExample(example);
		List<BillHangImpl> billHangList = billHangImplMapper.selectByExampleWithRowbounds(example, rb);
		search.put("billHangList", billHangList);
		search.put("count", count);
		
		return search;
	}
	
	public BillHangImpl getBillHang(String id){
		BillHangImpl ci = billHangImplMapper.selectByPrimaryKey(Long.valueOf(id));
		return ci;
	}
	
	public void delBillHang(String id){
		billHangImplMapper.deleteByPrimaryKey(Long.valueOf(id));
	}
	
}
