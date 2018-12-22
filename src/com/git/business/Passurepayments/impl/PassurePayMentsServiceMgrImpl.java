package com.git.business.Passurepayments.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.git.business.PassureInfos.PassureInfos;
import com.git.business.PassureInfos.PassureInfosServiceMgr;
import com.git.business.Passurepayments.PassurePayMents;
import com.git.business.Passurepayments.PassurePayMentsServiceMgr;
import com.git.business.sys.Org;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;

import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.TblPassureInfos;
import com.git.db.beans.TblPassurePayMents;
import com.git.db.beans.TblPassurePayMentsExample;
import com.git.db.beans.TblPassurePayMentsExample.Criteria;

import com.git.db.mapper.CaseBillImplMapper;
import com.git.db.mapper.TblPassureInfosMapper;
import com.git.db.mapper.TblPassurePayMentsMapper;
import com.git.enums.AssureStatus;
import com.git.util.Jutil;
import com.git.util.service.SequenceService;

import dwz.common.util.CommonUtils;
import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

@Transactional(rollbackFor = Exception.class)
@Service("PassureInfosServiceMgr")
public class PassurePayMentsServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements PassurePayMentsServiceMgr{
	@Autowired
	private TblPassurePayMentsMapper tppmapper;
	
	@Autowired
	private TblPassureInfosMapper passuremapper;
	
	@Autowired
	private CaseBillImplMapper caseBillImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private PassureInfosServiceMgr passureInfosServiceMgr;
	
	
	@SuppressWarnings("rawtypes" )
	@Override
	public List<TblPassurePayMents> searchPassurePayMents(BaseConditionVO vo,Map criterias, String orderField, int startIndex, int count) {
		List<TblPassurePayMents> ppmlist = new ArrayList<TblPassurePayMents>();
		TblPassurePayMentsExample example = new TblPassurePayMentsExample();
		example.setOrderByClause("createdate desc");
		Criteria criteria =example.createCriteria();
		
		if("yes".equals(String.valueOf(criterias.get("onlyflag")))){
			criteria.andReportflagNotEqualTo("submit");
			criteria.andReportflagNotEqualTo("pass");
			criteria.andReportflagNotEqualTo("no");
			criteria.andReportflagNotEqualTo("yes");
		}
		
		if("1".equals(String.valueOf(criterias.get("aflag")))){
			criteria.andPaydateIsNull();
		}
//		String reportflag = criterias.get("reportflag");
		if(null!=criterias.get("reportflag") && !"".equals(criterias.get("reportflag"))){
			criteria.andReportflagEqualTo(criterias.get("reportflag").toString());
		}
		System.out.println("判断aflag完毕！");
		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		List<TblPassurePayMents> passurepayList = tppmapper.selectByExampleWithRowbounds(example, rb);
		
		for(TblPassurePayMents to:passurepayList){
			ppmlist.add(to);
		}		
		return ppmlist;
	}

	@Override
	public TblPassurePayMents selectpassurepayments(Long passurepayid) {
		return tppmapper.selectByPrimaryKey(passurepayid);
	}


	@SuppressWarnings("rawtypes")
	@Override
	public TblPassurePayMents createpayment(List list) {
		System.out.println("进入方法体！");
		TblPassurePayMents tpp = null;
		BaseConditionVO vo = new BaseConditionVO();
//		Map<Object, Object> criterias = new HashMap<Object, Object>();
//		criterias.put("reportflag", "new");
//		List<TblPassurePayMents> lt = this.searchPassurePayMents(vo, criterias, null, vo.getStartIndex(), vo.getPageSize());
        
		String sql = "SELECT a.passurepayid FROM tbl_passurepayments a WHERE a.reportflag IN ('new','save') ";
		List<Map> ppm = Jutil.executeSQL(sql); 
		if(ppm.size()==0){
			tpp = new TblPassurePayMents();
			tpp.setPassurepayid(sequenceService.getSequence("passurepay_id"));	
			tpp.setCreatedate(new Date());
			tpp.setReportflag("new");
			
			//设置创建用户ID及时间
			User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
			Org org = (Org)request.getSession().getAttribute(Constants.ORGCODE_KEY);
			tpp.setOrgcode(user.getOrgCode());
			tpp.setOrgname(org.getOrgName());
			tpp.setUserid(user.getId());
			tpp.setUsername(user.getName());
			tpp.setCreateoperatorid(user.getId());
			tpp.setCreatetime(new Date());
			tpp.setModifyoperatorid(user.getId());
			tpp.setModifytime(new Date());
			tpp.setFeemount(BigDecimal.valueOf(0));
			tpp.setTotal(Long.valueOf(0));
			
			tppmapper.insertSelective(tpp);
			System.out.println("保存完毕！");
		}else{
			Long ppid = (Long) ppm.get(0).get("passurepayid");
			tpp = this.selectpassurepayments(ppid);
		}
		
		
/*		Map<String, BigDecimal> receivedetail_s = new HashMap<String, BigDecimal>();
		BigDecimal bd = new BigDecimal(0);
		int total=0;
		for(int i=0;i<list.size();i++){
			Map a = (Map) list.get(i);
			Long pid = (Long) a.get("passureid");			
			tp = passuremapper.selectByPrimaryKey(pid);			
			tp.setPaymentid(tpp.getPassurepayid());
						//设置担保状态为3
			tp.setFeestatuse(AssureStatus.AssureStatus3.getCode());
			
			//设置担保账单状态为3
			CaseBillImpl  caseBillImpl = caseBillImplMapper.selectByPrimaryKey(tp.getFeeid());
			caseBillImpl.setFeestatuse(AssureStatus.AssureStatus3.getCode());
			caseBillImplMapper.updateByPrimaryKey(caseBillImpl);
			
			bd=receivedetail_s.get(tp.getAcccurrency());
			
			if(CommonUtils.isEmpty(bd)){
				bd = tp.getAccamount();				
				receivedetail_s.put(tp.getAcccurrency(), bd);
			}else {
				bd = bd.add(tp.getAccamount());			
				receivedetail_s.put(tp.getAcccurrency(), bd);
			}
			passuremapper.updateByPrimaryKey(tp);
			System.out.println("更新tp完毕！");
			total++;
		}
		
		Iterator<String> it = receivedetail_s.keySet().iterator();
		String key = "";
		String receivedetail ="";
		while(it.hasNext()){
			key = it.next();
			if(CommonUtils.isEmpty(receivedetail)){
				receivedetail+=key+":"+receivedetail_s.get(key).toString();
			}else {
				receivedetail+=" || "+key+":"+receivedetail_s.get(key).toString();
			}			
		}*/
		
		BigDecimal sum = tpp.getFeemount();
		Long total= tpp.getTotal();
		for(int i=0;i<list.size();i++){
			Map a = (Map) list.get(i);
			Long pid = (Long) a.get("passureid");			
			TblPassureInfos tpif  = passuremapper.selectByPrimaryKey(pid);
//			TblPassureInfos tpif = passuremapper.selectByPrimaryKey(Long.valueOf(payid[i]));
			tpif.setPaymentid(tpp.getPassurepayid());
			
			//设置担保状态为3
			tpif.setFeestatuse(AssureStatus.AssureStatus3.getCode());
			
			passuremapper.updateByPrimaryKey(tpif);
			System.out.println("paymentsid:"+tpif.getPaymentid());
			total++;
			sum=sum.add(tpif.getAccamount());
		}

		tpp.setReceivedetail("USD:"+sum);
		//添加总担保份数
		tpp.setTotal(Long.valueOf(total));
		//添加申请呈批担保手续费总金额
		tpp.setFeemount(sum);
		
		tppmapper.updateByPrimaryKey(tpp);
		
		return tpp;
	}

	@Override
	public void updatepayment(PassurePayMents ppm) {
			TblPassurePayMents tpp = tppmapper.selectByPrimaryKey(ppm.getPassurepayid());
			tpp.setPaydetail(ppm.getPaydetail());
			tpp.setPaydate(ppm.getPaydate());
			User u = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
			//修改人通过Session中取得用户ID来进行修改
			tpp.setModifyoperatorid(u.getId());
			tpp.setModifytime(new Date());
			tppmapper.updateByPrimaryKeySelective(tpp);
	}
	
	public void updpayment(TblPassurePayMents ppm) {
		tppmapper.updateByPrimaryKeySelective(ppm);
}

	@Override
	public PassurePayMents getPassurePayMents(Long passurepayid) {
		TblPassurePayMents ppm = tppmapper.selectByPrimaryKey(passurepayid);
		return new PassurePayMents(ppm);
	}


	public void sendpassureapply(PassurePayMents ppm, List<PassureInfos> list) throws ServiceException{
		System.out.println("进入提交划付申请处理!");
		try{
			//修改划付列表标识
			TblPassurePayMents tppm = tppmapper.selectByPrimaryKey(ppm.getPassurepayid());
			tppm.setReportflag("yes");
			System.out.println("flag设置完毕!");
			tppmapper.updateByPrimaryKey(tppm);
			System.out.println("修改tbl_passurepayments完成!");
			
			PassureInfos tp = null;
			for(int i=0;i<list.size();i++){	
				tp = list.get(i);		
				
				//设置担保状态为4
				tp.setFeestatuse(AssureStatus.AssureStatus4.getCode());
				passureInfosServiceMgr.update(tp);
								
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public int count() {
        TblPassurePayMentsExample tppm = new TblPassurePayMentsExample();
        int count = tppmapper.countByExample(tppm);
		return count;
	}

	//退回申请
	public void backapply(String[] payid, PassurePayMents ppm) {
		TblPassurePayMents tppm = tppmapper.selectByPrimaryKey(ppm.getPassurepayid());
		Long total = tppm.getTotal();
		BigDecimal sum = tppm.getFeemount();
		for(int i=0;i<payid.length;i++){
			TblPassureInfos tpif = passuremapper.selectByPrimaryKey(Long.valueOf(payid[i]));
			tpif.setPaymentid(Long.valueOf(0));
			
			//设置担保状态为2
			tpif.setFeestatuse(AssureStatus.AssureStatus2.getCode());
			
/*			//设置担保账单状态为2
			CaseBillImpl  caseBillImpl = caseBillImplMapper.selectByPrimaryKey(tpif.getFeeid());
			caseBillImpl.setFeestatuse(AssureStatus.AssureStatus2.getCode());
			caseBillImplMapper.updateByPrimaryKey(caseBillImpl);*/
			
			passuremapper.updateByPrimaryKey(tpif);
			System.out.println("paymentsid:"+tpif.getPaymentid());
			total--;
			sum=sum.subtract(tpif.getAccamount());
		}
		
/*		BaseConditionVO vo = new BaseConditionVO();
		vo.setPageNum(1);
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("paymentid", String.valueOf(ppm.getPassurepayid()));
		List<PassureInfos> pif = passureInfosServiceMgr.searchAllPassureInfos(vo, criterias);
		
		String receivedetail ="USD:"+sum.toString();
/*		for(PassureInfos pi:pif){
			if(CommonUtils.isEmpty(receivedetail)){
				receivedetail+=pi.getAcccurrency()+":"+pi.getAccamount().toString();
			}else {
				receivedetail+=" || "+pi.getAcccurrency()+":"+pi.getAccamount().toString();
			}
		}*/
		
		String receivedetail ="USD:"+sum.toString();
		tppm.setFeemount(sum);
		tppm.setReceivedetail(receivedetail);
		tppm.setTotal(total);
		tppmapper.updateByPrimaryKey(tppm);
		
	}
	
	
	//提交申请
	public void sendapply(String[] payid, PassurePayMents ppm){
		TblPassurePayMents tppm = tppmapper.selectByPrimaryKey(ppm.getPassurepayid());
		Long total = tppm.getTotal();
		BigDecimal sum = tppm.getFeemount();
		//将tbl_passureinfos的paymentid字段设置为ppm.getPassurepayid()
		for(int i=0;i<payid.length;i++){
			TblPassureInfos tpif = passuremapper.selectByPrimaryKey(Long.valueOf(payid[i]));
			tpif.setPaymentid(ppm.getPassurepayid());
			
			//设置担保状态为3
			tpif.setFeestatuse(AssureStatus.AssureStatus3.getCode());
			
			//设置担保账单状态为3（账单状态不再设置）
/*			CaseBillImpl  caseBillImpl = caseBillImplMapper.selectByPrimaryKey(tpif.getFeeid());
			caseBillImpl.setFeestatuse(AssureStatus.AssureStatus3.getCode());
			caseBillImplMapper.updateByPrimaryKey(caseBillImpl);*/
			
			passuremapper.updateByPrimaryKey(tpif);
			System.out.println("paymentsid:"+tpif.getPaymentid());
			total++;
			sum=sum.add(tpif.getAccamount());
		}
		
		/*		BaseConditionVO vo = new BaseConditionVO();
		vo.setPageNum(1);
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("paymentid", String.valueOf(ppm.getPassurepayid()));
		List<PassureInfos> pif = passureInfosServiceMgr.searchAllPassureInfos(vo, criterias);
		
		
		for(PassureInfos pi:pif){
			if(CommonUtils.isEmpty(receivedetail)){
				receivedetail+=pi.getAcccurrency()+":"+pi.getAccamount().toString();
			}else {
				receivedetail+=" || "+pi.getAcccurrency()+":"+pi.getAccamount().toString();
			}
		}*/
		String receivedetail ="USD:"+sum.toString();
		tppm.setFeemount(sum);
		tppm.setReceivedetail(receivedetail);
		tppm.setTotal(total);
		tppmapper.updateByPrimaryKey(tppm);
	}




}
