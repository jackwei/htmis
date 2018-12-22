package com.git.business.PassureInfos.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.PassureInfos.PassureInfos;
import com.git.business.PassureInfos.PassureInfosServiceMgr;
import com.git.business.billService.BillCheckServiceMgr;
import com.git.business.caseService.CaseServiceMgr;
import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.sys.Org;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillCheckImpl;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.CaseInfoImplExample;
import com.git.db.beans.TblPassureInfos;
import com.git.db.beans.TblPassureInfosExample;
import com.git.db.beans.TblPassureInfosExample.Criteria;
import com.git.db.beans.TblPassurePayMents;
import com.git.db.mapper.CaseBillImplMapper;
import com.git.db.mapper.CaseInfoImplMapper;
import com.git.db.mapper.TblPassureInfosMapper;
import com.git.db.mapper.TblPassurePayMentsMapper;
import com.git.enums.AssureStatus;
import com.git.enums.PClientStatus;
import com.git.util.CommonUtil;
import com.git.util.Jutil;
import com.git.util.MMap;
import com.git.util.PubDateUtil;
import com.git.util.StrTool;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

@Transactional(rollbackFor = Exception.class)
@Service("passureInfosServiceMgr")
public class PassureInfosServiceMgrImpl extends
		AbstractBusinessObjectServiceMgr implements PassureInfosServiceMgr {

	@Autowired
	private TblPassureInfosMapper passuremapper;

	@Autowired
	private SequenceService sequenceService;

	@Autowired
	private TblPassurePayMentsMapper passurepaymapper;

	@Autowired
	private CaseBillImplMapper caseBillImplMapper;

	@Autowired
	private CaseServiceMgr caseServiceMgr;
	
	@Autowired
	private BillCheckServiceMgr billCheckServiceMgr;
	
	@Autowired
	private CaseInfoImplMapper caseInfoImplMapper;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;


	// 查找对应案件担保记录
	@SuppressWarnings("rawtypes")
	@Override
	public List<PassureInfos> searchPassureInfos(BaseConditionVO vo, Map criterias, String orderField, int startIndex, int count) {
		List<PassureInfos> tplist = new ArrayList<PassureInfos>();
		TblPassureInfosExample tie = new TblPassureInfosExample();
		Criteria criteria = tie.createCriteria();
		//案件下担保判断
		if (null != criterias.get("caseId") && !"".equals(criterias.get("caseId"))) {
			criteria.andCaseidEqualTo(StrTool.getLong(criterias.get("caseId")));
		}
		//页面搜索条件判断
		if(null != criterias.get("rewarranter") && !"".equals(criterias.get("rewarranter"))){
			criteria.andRewarranterLike("%"+String.valueOf(criterias.get("rewarranter"))+"%");		
		}
		
		if(null != criterias.get("assurenum") && !"".equals(criterias.get("assurenum"))){
			criteria.andAssurenumLike("%"+String.valueOf(criterias.get("assurenum"))+"%");		
		}
		
		if(null != criterias.get("currency") && !"".equals(criterias.get("currency"))){
			criteria.andCurrencyEqualTo(String.valueOf(criterias.get("currency")));		
		}
		
		if(null != criterias.get("accdate1") && !"".equals(criterias.get("accdate1"))){
			criteria.andAccdateGreaterThanOrEqualTo(PubDateUtil.stringToDate(criterias.get("accdate1").toString(), "yyyy-MM-dd"));
		}
		
		if(null != criterias.get("accdate2") && !"".equals(criterias.get("accdate2"))){
			criteria.andAccdateLessThanOrEqualTo(PubDateUtil.stringToDate(criterias.get("accdate2").toString(), "yyyy-MM-dd"));		
		}
		
		if(null != criterias.get("assurefee1") && !"".equals(criterias.get("assurefee1"))){
			criteria.andAssurefeeGreaterThanOrEqualTo(BigDecimal.valueOf(Long.valueOf(criterias.get("assurefee1").toString())));
		}
		
		if(null != criterias.get("assurefee2") && !"".equals(criterias.get("assurefee2"))){
			criteria.andAssurefeeLessThanOrEqualTo(BigDecimal.valueOf(Long.valueOf(criterias.get("assurefee2").toString())));		
		}
		
		//生成账单担保判断
		if ("1" == criterias.get("aflag") && !"".equals(criterias.get("aflag"))){
			criteria.andFeeidIsNotNull();
			System.out.println("判断flag成功！");
		}
		//本账单关联担保判断
		if(null !=criterias.get("feeid") && !"".equals(criterias.get("feeid"))){
			criteria.andFeeidEqualTo(StrTool.getLong(criterias.get("feeid")));
		}
		//未生成账单担保判断
		if("1" == criterias.get("bflag") && !"".equals(criterias.get("bflag"))){
			criteria.andFeeidIsNull();
		}
		
		//对应申请划付担保判断
		if(null !=criterias.get("paymentid") && !"".equals(criterias.get("paymentid"))){
			criteria.andPaymentidEqualTo(StrTool.getLong(criterias.get("paymentid")));
		}
		
		//未提交划付申请判断
		if("1" == criterias.get("paflag") && !"".equals(criterias.get("paflag"))){
			criteria.andPaymentidIsNull();
		}
		if("1" == criterias.get("pbflag") && !"".equals(criterias.get("pbflag"))){
			criteria.andArrdateIsNotNull();
		}
		
		//与创建人ID判断
		if("1" == criterias.get("createid") && !"".equals(criterias.get("createid"))){
			criteria.andCreateoperatoridEqualTo(StrTool.getLong(criterias.get("createid")));
		}
		
		    RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
			List<TblPassureInfos> tb = passuremapper.selectByExampleWithRowbounds(tie, rb);
			for (TblPassureInfos to : tb) {
				tplist.add(new PassureInfos(to));
				System.out.println(tplist);
			}
			System.out.println("tplist:"+tplist);
		return tplist;
	}
	

	@SuppressWarnings("rawtypes")
	public int countPassureInfos(TblPassureInfosExample example, Map criterias) {
		Criteria criteria = example.createCriteria();
		//案件下担保判断
		if (null != criterias.get("caseId") && !"".equals(criterias.get("caseId"))) {
			criteria.andCaseidEqualTo(StrTool.getLong(criterias.get("caseId")));
		}

		//页面搜索条件判断
		if(null != criterias.get("rewarranter") && !"".equals(criterias.get("rewarranter"))){
			criteria.andRewarranterLike("%"+String.valueOf(criterias.get("rewarranter"))+"%");		
		}
		
		if(null != criterias.get("assurenum") && !"".equals(criterias.get("assurenum"))){
			criteria.andAssurenumLike("%"+String.valueOf(criterias.get("assurenum"))+"%");		
		}
		
		if(null != criterias.get("currency") && !"".equals(criterias.get("currency"))){
			criteria.andCurrencyEqualTo(String.valueOf(criterias.get("currency")));		
		}
		
		if(null != criterias.get("accdate1") && !"".equals(criterias.get("accdate1"))){
			criteria.andAccdateGreaterThanOrEqualTo(PubDateUtil.stringToDate(criterias.get("accdate1").toString(), "yyyy-MM-dd"));
		}
		
		if(null != criterias.get("accdate2") && !"".equals(criterias.get("accdate2"))){
			criteria.andAccdateLessThanOrEqualTo(PubDateUtil.stringToDate(criterias.get("accdate2").toString(), "yyyy-MM-dd"));		
		}
		
		if(null != criterias.get("assurefee1") && !"".equals(criterias.get("assurefee1"))){
			criteria.andAssurefeeGreaterThanOrEqualTo(BigDecimal.valueOf(Long.valueOf(criterias.get("assurefee1").toString())));
		}
		
		if(null != criterias.get("assurefee2") && !"".equals(criterias.get("assurefee2"))){
			criteria.andAssurefeeLessThanOrEqualTo(BigDecimal.valueOf(Long.valueOf(criterias.get("assurefee2").toString())));		
		}
		
		//生成账单担保判断
		if ("1" == criterias.get("aflag") && !"".equals(criterias.get("aflag"))){
			criteria.andFeeidIsNotNull();
			System.out.println("判断flag成功！");
		}
		//本账单关联担保判断
		if(null !=criterias.get("feeid") && !"".equals(criterias.get("feeid"))){
			criteria.andFeeidEqualTo(StrTool.getLong(criterias.get("feeid")));
		}
		//未生成账单担保判断
		if("1" == criterias.get("bflag") && !"".equals(criterias.get("bflag"))){
			criteria.andFeeidIsNull();
		}
		
		//对应申请划付担保判断
		if(null !=criterias.get("paymentid") && !"".equals(criterias.get("paymentid"))){
			criteria.andPaymentidEqualTo(StrTool.getLong(criterias.get("paymentid")));
		}
		
		//未提交划付申请判断
		if("1" == criterias.get("paflag") && !"".equals(criterias.get("paflag"))){
			criteria.andPaymentidIsNull();
		}
		if("1" == criterias.get("pbflag") && !"".equals(criterias.get("pbflag"))){
			criteria.andArrdateIsNotNull();
		}
		
		int total = passuremapper.countByExample(example);
		
		return total;
	}
	

	// 按id删除担保
	@Override
	public void deleteByPrimaryKey(Long passureid) {
		passuremapper.deleteByPrimaryKey(passureid);
	}

	// 计算担保总记录数
	@Override
	public int countByExample(TblPassureInfosExample example) {
		int total = passuremapper.countByExample(example);
		return total;
	}

	// 修改担保记录
	@Override
	public void update(PassureInfos passureInfos) {
		TblPassureInfos passure = passureInfos.getPassureInofs();
		// 添加修改人ID和修改时间
		User u = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		passure.setModifyoperatorid(u.getId());
		passure.setModifytime(new Date());

		passuremapper.updateByPrimaryKeySelective(passure);
	}

	// 修改记录时先通过passureid获取该条记录
	@Override
	public PassureInfos getPassureInfos(Long passureid) {
		TblPassureInfos tpi = passuremapper.selectByPrimaryKey(passureid);
		return new PassureInfos(tpi);
	}

	// 添加担保记录
	@Override
	public void add(PassureInfos passureInfos) {
		TblPassureInfos tpf = passureInfos.getPassureInofs();
		// 自动判断添加passureid
		tpf.setPassureid(sequenceService.getSequence("passureid"));
		//设置初始feeid为0
		tpf.setFeeid(Long.valueOf(0));
		// 添加创建人修改人ID及创建修改时间
		User user = (User) request.getSession().getAttribute(
				Constants.AUTHENTICATION_KEY);
		tpf.setCreateoperatorid(user.getId());
		tpf.setModifyoperatorid(user.getId());
		tpf.setCreatetime(new Date());
		tpf.setModifytime(new Date());
		passuremapper.insert(tpf);
	}

	// 添加担保账单
	public void addpassurebill(String[] aids, CaseBillImpl caseBillImpl, HttpServletRequest request) {
		float rate = Float.parseFloat(request.getParameter("accrate"));
		float a = 0 ;
		float b = 0;
		for(int i=0;i<aids.length;i++){
			System.out.println("第"+i+"次循环！");
			String passureid = aids[i];
			System.out.println("passureid:"+passureid);
			TblPassureInfos tpif = passuremapper.selectByPrimaryKey(Long.valueOf(passureid));
			System.out.println("sfee:"+tpif.getServicefee()+"accrate:"+tpif.getAccrate());
			a += tpif.getServicefee().floatValue()/rate;
		}

		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(request.getParameter("caseId"));
		
		//从Session中获取登录用户信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		
		try{
			if(CommonUtil.isEmpty(caseBillImpl.getBillId())){
				caseBillImpl.setBillId(sequenceService.getSequence("Bill_Id"));
				System.out.println("判断如果账单ID为空则为添加账单，并在此处设置账单ID！");

				// 添加创建人ID及创建时间
				caseBillImpl.setOperatorId(user.getId());
				caseBillImpl.setCreateTime(new Date());	
				
				// 设置账单状态,通过枚举类实现
				caseBillImpl.setFeestatuse(AssureStatus.AssureStatus0.getCode());
				System.out.println("设置账单状态完毕！");
				
				// 担保账单编号生成规则
				long feecount = caseInfoImpl.getFeecount();
				feecount++;
				String feeNumber = caseInfoImpl.getCasenumber() + "_" + feecount;
				caseBillImpl.setFeenumber(feeNumber);
				System.out.println("设置账单编号完毕！");
				
				// 修改tbl_case账单数，即每添加一个账单案件表中账单数该字段+1
				caseInfoImpl.setFeecount(feecount);
				caseServiceMgr.updateCase(caseInfoImpl);
				System.out.println("修改案件信息表完毕！");	
				
				caseBillImpl.setCasenumber(caseInfoImpl.getCasenumber());
				caseBillImpl.setCaseId(caseInfoImpl.getCaseId());
				caseBillImpl.setPayer(request.getParameter("payer"));
				caseBillImpl.setConame(request.getParameter("coname"));
				caseBillImpl.setAddress(request.getParameter("address"));
				
				caseBillImpl.setAssurefee(a);
				System.out.println("担保手续费："+a);
				caseBillImpl.setFeeamount(a);
				//未到账金额
				caseBillImpl.setReplaceamount(a);
				caseBillImpl.setServicefee(b);
				caseBillImpl.setExpendses(b);
				
				caseBillImpl.setOrgcode(caseInfoImpl.getOrgcode());
				caseBillImpl.setOrgname(caseInfoImpl.getOraname());
				
				//设置账单类型为担保账单
//				caseBillImpl.setFeetype("assurebill");
				caseBillImpl.setFeetype("assure");
				
				caseBillImpl.setCurrency(request.getParameter("currency"));
				caseBillImpl.setRemark(request.getParameter("remark"));

				caseBillImplMapper.insert(caseBillImpl);
				System.out.println("账单添加成功！");
			}else{
				CaseBillImpl cb = caseBillImplMapper.selectByPrimaryKey(caseBillImpl.getBillId());
				
				// 添加修改人ID及修改时间
				cb.setModifyOperatorId(user.getId());
				cb.setModifyTime(new Date());
				
				//添加担保手续费和记帐金额
				cb.setAssurefee(cb.getAssurefee()+a);
				cb.setFeeamount(cb.getFeeamount()+a);
				
				cb.setCurrency(request.getParameter("currency"));
				cb.setRemark(request.getParameter("remark"));

				caseBillImplMapper.updateByPrimaryKey(cb);
				System.out.println("账单修改成功！");
			}
			
			// 修改tbl_passureinfos账单id，汇率，发账币种
			for(int i=0;i<aids.length;i++){
				System.out.println("根据passureid获取担保信息！");
				TblPassureInfos tp = passuremapper.selectByPrimaryKey(Long.valueOf(aids[i]));
				tp.setFeeid(caseBillImpl.getBillId());
				System.out.println("billId:" + caseBillImpl.getBillId());
				tp.setAccrate(BigDecimal.valueOf(rate));
				tp.setAcccurrency(request.getParameter("currency"));
				tp.setAccamount(BigDecimal.valueOf(tp.getServicefee().floatValue()/rate));
				passuremapper.updateByPrimaryKeySelective(tp);
			}
			
			System.out.println("更新担保信息完毕！");
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// 去除担保
	public void cutpassurebill(String[] aids, CaseBillImpl caseBillImpl, HttpServletRequest request) {
		float a = 0 ;
		for(int i=0;i<aids.length;i++){
			System.out.println("第"+i+"次循环！");
			String passureid = aids[i];
			System.out.println("passureid:"+passureid);
			TblPassureInfos tpif = passuremapper.selectByPrimaryKey(Long.valueOf(passureid));
			System.out.println("sfee:"+tpif.getServicefee()+"accrate:"+tpif.getAccrate());
			a += tpif.getServicefee().floatValue()/tpif.getAccrate().floatValue();
		}
		
		//从Session中获取登录用户信息
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		
		try{
			    CaseBillImpl cbi = caseBillImplMapper.selectByPrimaryKey(caseBillImpl.getBillId());
			
			    cbi.setPayer(request.getParameter("payer"));
			    cbi.setConame(request.getParameter("coname"));
			    cbi.setAddress(request.getParameter("address"));
				
				// 添加修改人ID及修改时间
			    cbi.setModifyOperatorId(user.getId());
			    cbi.setModifyTime(new Date());
				
				//减去担保手续费和记帐金额
			    cbi.setAssurefee(cbi.getAssurefee()-a);
			    cbi.setFeeamount(cbi.getFeeamount()-a);
				
			    cbi.setCurrency(request.getParameter("currency"));
			    cbi.setRemark(request.getParameter("remark"));
				
			    cbi.setFeetype("assure");

				caseBillImplMapper.updateByPrimaryKey(cbi);
				System.out.println("账单修改成功！");
			
			// 修改tbl_passureinfos账单id，汇率，发账币种
			for(int i=0;i<aids.length;i++){
				System.out.println("根据passureid获取担保信息！");
				TblPassureInfos tp = passuremapper.selectByPrimaryKey(Long.valueOf(aids[i]));
				tp.setFeeid(Long.valueOf(0));
				tp.setAccrate(BigDecimal.valueOf(0));
				tp.setAcccurrency("");
				tp.setAccamount(BigDecimal.valueOf(0));
				//设置修改人及修改时间
				tp.setModifyoperatorid(user.getId());
				tp.setModifytime(new Date());
				passuremapper.updateByPrimaryKeySelective(tp);
			}			
			System.out.println("更新担保信息完毕！");
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// 通过passureid获取担保信息
	public PassureInfos getpassureinfos(Long passureid) {
		TblPassureInfos tpi = passuremapper.selectByPrimaryKey(passureid);
		return new PassureInfos(tpi);
	}

	// 生成划付列表
	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public String createpayment() {
		String flag = "";
		StringBuffer csql = new StringBuffer(16);
		csql.append("select * from tbl_Passureinfos tp where tp.paymentid is null and tp.arrdate is not null ");
		User user = (User) request.getSession().getAttribute(
				Constants.AUTHENTICATION_KEY);
		Org org = (Org)request.getSession().getAttribute(Constants.ORGCODE_KEY);

		TblPassurePayMents tpp = new TblPassurePayMents();
		TblPassureInfos tp = null;
		tpp.setOrgcode(String.valueOf(user.getOrgId()));
		tpp.setOrgname(org.getOrgName());
		tpp.setUserid(user.getId());
		tpp.setUsername(user.getName());
		tpp.setReportflag("no");

		List<String> clist = Jutil.executeSQL(csql.toString());
		Map<String, BigDecimal> receivedetail_s = new HashMap<String, BigDecimal>();
		BigDecimal bd = new BigDecimal(0);
		if (clist.size() == 0) {
			flag = "a";
			return flag;
		}
		passurepaymapper.insert(tpp);

		return "操作成功";

	}
	
	//提交财务处理
	@SuppressWarnings("rawtypes")
	public void assureSendBill(CaseBillImpl caseBillImpl)throws ServiceException{		
		try{
		//设置发账时间
		caseBillImpl.setAccdate(new Date());
		System.out.println("发账时间设置完毕！");
		//设置账单状态为1，通过枚举类实现
		caseBillImpl.setFeestatuse(String.valueOf(AssureStatus.AssureStatus1.getCode()));
		System.out.println("账单状态设置完毕！");

		caseBillImplMapper.updateByPrimaryKeySelective(caseBillImpl);
		
		// 修改tbl_passureinfos发账时间
		Long billid = caseBillImpl.getBillId();
		System.out.println("billid:"+billid);
		Long caseid = caseBillImpl.getCaseId();
		System.out.println("caseid:"+caseid);

		StringBuffer tp = new StringBuffer(16);
		tp.append("select passureid from tbl_passureinfos where caseid = '"+caseid+"' and feeid = '"+billid+"'  ");
		List tplist = Jutil.executeSQL(tp.toString());
		//对list进行迭代取出passureid
		Iterator  it = tplist.iterator();
		while(it.hasNext()){
			Map ss = (Map)it.next();
			System.out.println("是否取到值？："+ss.get("passureid"));
			TblPassureInfos pif = passuremapper.selectByPrimaryKey((Long) ss.get("passureid"));
			System.out.println("pif是什么？"+pif);
        	pif.setAccdate(caseBillImpl.getAccdate());
        	pif.setFeestatuse(PClientStatus.ClientFee1.getCode());
        	passuremapper.updateByPrimaryKeySelective(pif);
    		System.out.println("更新担保信息完毕！");
    		
    		if(!"HTPI1300".equals(caseBillImpl.getCasenumber().substring(0, 8))){
    			/*添加财务凭证 start */
        		MMap mmap = new MMap();
        		mmap.put("bill_id", caseBillImpl.getBillId());
        		mmap.put("passureid",pif.getPassureid());
        		calFinItemServiceMgr.dealFinItem("112", mmap,1);
        		/*end*/
    		}
            
		}
		
        System.out.println("修改tbl_passureinfos发账单时间完毕！");
        

        
        //添加对账单
		BillCheckImpl billCheckImpl = billCheckServiceMgr.getBillCheckByBillId(caseBillImpl.getBillId().toString());
		if(billCheckImpl == null){
			 billCheckImpl = new BillCheckImpl();
		     billCheckImpl.setCheckId(sequenceService.getSequence("check_id"));
		     
		     billCheckImpl.setFeeid(caseBillImpl.getBillId().toString());
				billCheckImpl.setAccdate(new Date());
				billCheckImpl.setBiztypeid("psys");
				billCheckImpl.setBiztype("海事");
				billCheckImpl.setFeenum(caseBillImpl.getFeenumber());
				billCheckImpl.setCurrency(caseBillImpl.getCurrency());
				billCheckImpl.setExpends(caseBillImpl.getExpendses());
				billCheckImpl.setIncome(caseBillImpl.getServicefee());
				billCheckImpl.setReplaceamount(caseBillImpl.getAssurefee());
				billCheckImpl.setFlag("1");
				billCheckImpl.setFeeamount(caseBillImpl.getFeeamount());
				billCheckImpl.setDifferamount(caseBillImpl.getFeeamount());
				billCheckImpl.setOrgcode(caseBillImpl.getOrgcode());
				billCheckImpl.setOrgname(caseBillImpl.getOrgname());
				billCheckImpl.setPayername(caseBillImpl.getPayer());
				billCheckImpl.setChangedate(new Date());
				billCheckImpl.setCreateTime(new Date());
				//添加担保费用
				billCheckImpl.setExtend1(caseBillImpl.getAssurefee().toString()); 
				//收入 （费用+服务费）
				billCheckImpl.setExtend2(String.valueOf(caseBillImpl.getServicefee()+caseBillImpl.getExpendses()));
		      
				billCheckServiceMgr.addBillCheck(billCheckImpl);
		}else{
			billCheckImpl.setCheckId(billCheckImpl.getCheckId());
			
			billCheckImpl.setFeeid(caseBillImpl.getBillId().toString());
			billCheckImpl.setAccdate(new Date());
			billCheckImpl.setBiztypeid("psys");
			billCheckImpl.setBiztype("海事");
			billCheckImpl.setFeenum(caseBillImpl.getFeenumber());
			billCheckImpl.setCurrency(caseBillImpl.getCurrency());
			billCheckImpl.setExpends(caseBillImpl.getExpendses());
			billCheckImpl.setIncome(caseBillImpl.getServicefee());
			billCheckImpl.setReplaceamount(caseBillImpl.getAssurefee());
			billCheckImpl.setFlag("1");
			billCheckImpl.setFeeamount(caseBillImpl.getFeeamount());
			billCheckImpl.setDifferamount(caseBillImpl.getFeeamount());
			billCheckImpl.setOrgcode(caseBillImpl.getOrgcode());
			billCheckImpl.setOrgname(caseBillImpl.getOrgname());
			billCheckImpl.setPayername(caseBillImpl.getPayer());
			billCheckImpl.setChangedate(new Date());
			billCheckImpl.setCreateTime(new Date());
			//添加担保费用
			billCheckImpl.setExtend1(caseBillImpl.getAssurefee().toString()); 
			//收入 （费用+服务费）
			billCheckImpl.setExtend2(String.valueOf(caseBillImpl.getServicefee()+caseBillImpl.getExpendses()));
	      
			billCheckServiceMgr.updBillCheck(billCheckImpl);
		}
		

        
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	@Override
	public List<PassureInfos> searchall(TblPassureInfosExample example) {
		List<PassureInfos> tplist = new ArrayList<PassureInfos>();
		List<TblPassureInfos> tb = passuremapper.selectByExample(example);
		for (TblPassureInfos to : tb) {
			tplist.add(new PassureInfos(to));
			System.out.println(tplist);
		}
		return tplist;
	}

	public int countPassureInfos(Map criterias) {
		TblPassureInfosExample tie = new TblPassureInfosExample();
		Criteria criteria = tie.createCriteria();
		//判断已到账并且未划付担保
		if(null !=criterias.get("chflag") && !"".equals(criterias.get("chflag"))){
			criteria.andArrdateIsNotNull();
		}
		if(null !=criterias.get("payflag") && !"".equals(criterias.get("payflag"))){
			criteria.andPaydateIsNull();
		}
		List<TblPassureInfos> tb = passuremapper.selectByExample(tie);
		int total = tb.size();
		return total;
	}
	

	@SuppressWarnings("rawtypes")
	@Override
	public List<PassureInfos> searchAllPassureInfos(BaseConditionVO vo,Map criterias) {
		List<PassureInfos> tplist = new ArrayList<PassureInfos>();
		TblPassureInfosExample tie = new TblPassureInfosExample();
		tie.setOrderByClause(" arrdate desc ");
		Criteria criteria = tie.createCriteria();
		//案件下担保判断
		if (null != criterias.get("caseId") && !"".equals(criterias.get("caseId"))) {
			criteria.andCaseidEqualTo(StrTool.getLong(criterias.get("caseId")));
		}

		//页面搜索条件判断
		if(null != criterias.get("rewarranter") && !"".equals(criterias.get("rewarranter"))){
			criteria.andRewarranterLike("%"+String.valueOf(criterias.get("rewarranter"))+"%");		
		}
		
		if(null != criterias.get("assurenum") && !"".equals(criterias.get("assurenum"))){
			criteria.andAssurenumLike("%"+String.valueOf(criterias.get("assurenum"))+"%");		
		}
		
		if(null != criterias.get("currency") && !"".equals(criterias.get("currency"))){
			criteria.andCurrencyEqualTo(String.valueOf(criterias.get("currency")));		
		}
		
		if(null != criterias.get("accdate1") && !"".equals(criterias.get("accdate1"))){
			criteria.andAccdateGreaterThanOrEqualTo(PubDateUtil.stringToDate(criterias.get("accdate1").toString(), "yyyy-MM-dd"));
		}
		
		if(null != criterias.get("accdate2") && !"".equals(criterias.get("accdate2"))){
			criteria.andAccdateLessThanOrEqualTo(PubDateUtil.stringToDate(criterias.get("accdate2").toString(), "yyyy-MM-dd"));		
		}
		
		if(null != criterias.get("assurefee1") && !"".equals(criterias.get("assurefee1"))){
			criteria.andAssurefeeGreaterThanOrEqualTo(BigDecimal.valueOf(Long.valueOf(criterias.get("assurefee1").toString())));
		}
		
		if(null != criterias.get("assurefee2") && !"".equals(criterias.get("assurefee2"))){
			criteria.andAssurefeeLessThanOrEqualTo(BigDecimal.valueOf(Long.valueOf(criterias.get("assurefee2").toString())));		
		}
		
		//生成账单担保判断
		if ("1".equals(String.valueOf(criterias.get("aflag"))) && !"".equals(criterias.get("aflag"))){
			criteria.andFeeidIsNotNull();
			System.out.println("判断aflag成功！");
		}
		//本账单关联担保判断
		if(null !=criterias.get("feeid") && !"".equals(criterias.get("feeid"))){
			criteria.andFeeidEqualTo(StrTool.getLong(criterias.get("feeid")));
		}
		//未生成账单担保判断
		if("1".equals(String.valueOf(criterias.get("bflag"))) && !"".equals(criterias.get("bflag"))){
			criteria.andFeeidEqualTo(StrTool.getLong(0));
		}
		
		//对应申请划付担保判断
		if(null !=criterias.get("paymentid") && !"".equals(criterias.get("paymentid"))){
			criteria.andPaymentidEqualTo(StrTool.getLong(criterias.get("paymentid")));
		}
		
		//未提交划付申请判断
		if("1".equals(String.valueOf(criterias.get("paflag"))) && !"".equals(criterias.get("paflag"))){
			System.out.println("判断paflag=1成功");
			criteria.andPaymentidEqualTo(Long.valueOf(0));
		}
		if("1".equals(String.valueOf(criterias.get("pbflag"))) && !"".equals(criterias.get("pbflag"))){
			System.out.println("判断pbflag=1成功");
			criteria.andArrdateIsNotNull();
		}
		
		//担保状态判断
		if(null !=criterias.get("feestatuse") && !"".equals(criterias.get("feestatuse"))){
			criteria.andFeestatuseEqualTo(String.valueOf(criterias.get("feestatuse")));
		}
		
		//判断已到账并且未划付担保
		if(null !=criterias.get("chflag") && !"".equals(criterias.get("chflag"))){
			criteria.andArrdateIsNotNull();
		}
		if(null !=criterias.get("payflag") && !"".equals(criterias.get("payflag"))){
			criteria.andPaydateIsNull();
		}
		
		//是否申请呈批判断statusflag
		if(null !=criterias.get("statusflag") && !"".equals(criterias.get("statusflag"))){
			criteria.andFeestatuseEqualTo(criterias.get("statusflag").toString());
		}
		
//		    tie.setOrderByClause(" feestatuse asc");
		    RowBounds rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize());
			List<TblPassureInfos> tb = passuremapper.selectByExampleWithRowbounds(tie, rowBounds);
			for (TblPassureInfos to : tb) {
				tplist.add(new PassureInfos(to));
				System.out.println(tplist);
			}
			System.out.println("tplist:"+tplist);
		return tplist;
	}

	 

	@SuppressWarnings("rawtypes")
	@Override
	public List searchunapply() {
		StringBuffer pym = new StringBuffer(16);
		pym.append("select * from tbl_passureinfos tp where tp.feestatuse = 2 ");
		List list = Jutil.executeSQL(pym.toString());
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List searchpassurebybillid(Long billid){
		StringBuffer spb = new StringBuffer(16);
		spb.append("select * from tbl_passureinfos tf where tf.feeid = '"+billid+"' ");
		List list = Jutil.executeSQL(spb.toString());
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<Object, Object> searchCase(Map criterias,BaseConditionVO vo){
		Map<Object, Object> search = new HashMap<Object, Object>();
		
		CaseInfoImplExample example = new CaseInfoImplExample();
		example.setOrderByClause("casenumber desc");
		com.git.db.beans.CaseInfoImplExample.Criteria  criteria = example.createCriteria();

		if(!"".equals(criterias.get("casenumber")) && null !=criterias.get("casenumber") ){
			criteria.andCasenumberLike("%"+criterias.get("casenumber").toString()+"%");
		}
		if(!"".equals(criterias.get("shipname")) && null !=criterias.get("shipname")){
			criteria.andShipnameLike("%"+criterias.get("shipname").toString()+"%");
		}
		if(!"".equals(criterias.get("excasenumber")) && null !=criterias.get("excasenumber") ){
			criteria.andExcasenumberLike("%"+criterias.get("excasenumber").toString()+"%");
		}
		if(!"".equals(criterias.get("billstatus")) && null != criterias.get("billstatus")){
			
		}
		
		int count = caseInfoImplMapper.countByExample(example);
		search.put("count", count);
		RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		//example.or(criteria);
		List<CaseInfoImpl> caseList = caseInfoImplMapper.selectByExampleWithRowbounds(example, rb);
		search.put("caseList", caseList);
		return search;
	}

}
