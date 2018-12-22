package com.git.business.finance.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.finance.FinDataItemEnum;
import com.git.db.beans.FinData;
import com.git.db.beans.FinDataDealLog;
import com.git.db.beans.FinDataResult;
import com.git.db.mapper.FinDataDealLogMapper;
import com.git.db.mapper.FinDataMapper;
import com.git.db.mapper.FinDataResultMapper;
import com.git.enums.VoucherStatus;
import com.git.util.Jutil;
import com.git.util.MMap;
import com.git.util.PubDateUtil;
import com.git.util.service.SequenceService;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service("calFinItemServiceMgr")
public class CalFinItemServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements CalFinItemServiceMgr {
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private FinDataResultMapper finDataResultMapper;
	
	@Autowired
	private FinDataMapper finDataMapper;
	
	@Autowired
	private FinDataDealLogMapper finDataDealLogMapper;
		
	private String mErrorMsg;
	/**
	 * 传入财务接口业务类型，以及所需参数的Map,flag等于 -1 时为冲账
	 * 根据业务类型查询出业务类型对应的科目及处理规则，然后将结果保存到处理结果表中
	 */
	public boolean dealFinItem(String bussType,MMap paramMap,int flag)
	{
		StringBuffer tSql = new StringBuffer(16);
		//1、先查凭证类型信息，保存数据处理结果总表
		tSql = new StringBuffer(16);
		tSql.append("select Distill_SQL dealSql from T_Fin_Buss_Type_Def where buss_id = '"+bussType+"'");
		Long tBachNo = sequenceService.getSequence("batch_no");
		try
		{
			String tDealSql = Jutil.getOneValue(tSql.toString(), "dealSql");
			if(tDealSql == null || "".equals(tDealSql))
			{
				mErrorMsg = "系统还未定义业务类型为【"+bussType+"】的凭证处理规则，无法提取凭证信息！";
				return false;
			}
			else
			{
				tDealSql = Jutil.interpretInSQL(paramMap, tDealSql);//将SQL中的变量进行转换，变成实际的值
				List<Map> dealResultList = Jutil.executeSQL(tDealSql);//执行脚本查询，得到凭证处理结果
				if(dealResultList == null || dealResultList.size() < 1)
				{
					mErrorMsg = "业务类型为【"+bussType+"】的凭证数据在进行SQL数据提取时发生错误，无法继续提取凭证信息，提取的SQL=【"+tDealSql+"】！";
					createDealLog(String.valueOf(tBachNo),"all",bussType);
					//return false;
				}
				else
				{
					FinData tFinData = new  FinData();
					
					try{
						//先保存基础数据信息
						tFinData.setBatchNo(String.valueOf(tBachNo));
						if(flag == -1){
							tFinData.setBussId("102");
						}else{
							tFinData.setBussId(bussType.substring(0, 3));
						}
												
						//获取明细金额、币种、财务日期等信息
						tFinData.setMoney(Float.valueOf(String.valueOf(dealResultList.get(0).get("money")))*flag);
						tFinData.setCurrency(String.valueOf(dealResultList.get(0).get("currency")));
						//发账日期
						if(null == dealResultList.get(0).get("finDate")){ 
							tFinData.setFinDate(PubDateUtil.stringToDate(PubDateUtil.dateFormat(new Date()), "yyyy-MM-dd HH:mm"));
						}else{
							tFinData.setFinDate(PubDateUtil.stringToDate(String.valueOf(dealResultList.get(0).get("finDate")), "yyyy-MM-dd HH:mm"));
						}
						// 凭证号(由oracle系统返回)
						//tFinData.setFinNo(String.valueOf(dealResultList.get(0).get("finNo")));
						// 日记账名称
						tFinData.setFinName(String.valueOf(dealResultList.get(0).get("finName")));
						// 捕获性信息+简称
						tFinData.setBussKeyNo(String.valueOf(dealResultList.get(0).get("bussKeyNo")));
						
						tFinData.setMakeTime(new Date());
						
						tFinData.setMakeUser(String.valueOf(dealResultList.get(0).get("makeUser")));
												
						tFinData.setDealFlag(VoucherStatus.Voucher1.getCode());//新生成的数据，导出状态 1:未导入2:成功 3:失败
						
						finDataMapper.insert(tFinData);								
						
						}
						catch(Exception e)
						{
							mErrorMsg = "处理业务类型为【"+bussType+"】的凭证明细信息时发生错误！";
							createDealLog(String.valueOf(tBachNo),"all",bussType);
							return false;
						}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			mErrorMsg = "系统还未定义业务类型为【"+bussType+"】的凭证处理规则，无法提取凭证信息！";
			return false;
		}
		
		//2、查询凭证类型下明细科目及数据提取规则信息，生成数据处理结果明细表
		tSql = new StringBuffer(16);
		tSql.append("SELECT buss_id bussId,item_id itemId,item_name itemName,item_type itemType,");
		tSql.append("distill_mode distillMode,ifnull(distill_sql,'') distillSql,ifnull(distill_class,'') class FROM T_Fin_Trans_Info_Def where buss_id='");
		tSql.append(bussType);
		tSql.append("' order by item_type desc ");
		
		List<Map> finItemList = Jutil.executeSQL(tSql.toString());
		if(finItemList == null || finItemList.size() < 1)
		{
			mErrorMsg = "系统还未定义业务类型为【"+bussType+"】的凭证处理规则，无法提取凭证信息！";
			return false;
		}
		else
		{			
			FinDataResult tFinDataResult;
			for(Map finItemMap:finItemList)
			{
				String itemId = String.valueOf(finItemMap.get("itemId"));
				String dealMode = String.valueOf(finItemMap.get("distillMode"));
				if("1".equals(dealMode))//通过SQL提取
				{
					String dealSql = String.valueOf(finItemMap.get("distillSql"));
					if(dealSql==null || "".equals(dealSql))
					{
						mErrorMsg = "科目编码为【"+itemId+"】的凭证数据提取SQL为空！";
						createDealLog(String.valueOf(tBachNo),itemId,bussType);						
						return false;
					}
					else
					{
						dealSql = Jutil.interpretInSQL(paramMap, dealSql);//将SQL中的变量进行转换，变成实际的值
						List<Map> dealResultList = Jutil.executeSQL(dealSql);//执行脚本查询，得到凭证处理结果
						if(dealResultList == null || dealResultList.size() < 1)
						{
							mErrorMsg = "科目编码为【"+itemId+"】的凭证数据在进行SQL数据没有得到数据，提取的SQL=【"+dealSql+"】！";
							createDealLog(String.valueOf(tBachNo),itemId,bussType);
							continue;
							//return false;
						}
						else
						{
							for(Map dealResultMap:dealResultList)
							{								
								tFinDataResult = new FinDataResult();
								
								try{
									
									/**
									 * 如果是分公司部门  取		贷方	3001050102	资金往来-资金往来-内部往来-收入
									 * 如果是北京部门     取    	           贷方	6001010108	主营业务收入-保险中介服务费收入
									 * */
									if(bussType.equals("101") && String.valueOf(dealResultMap.get("orgCode")).equals("859")){
										if(itemId.equals("3001050102")){
											continue;
										}
									}else if(bussType.equals("101") && !String.valueOf(dealResultMap.get("orgCode")).equals("859")){
										if(itemId.equals("6001010108")){
											continue;
										}
									}
								
									//先保存基础数据信息
									tFinDataResult.setSeqId(sequenceService.getSequence("FinDataResult"));
									tFinDataResult.setBatchNo(String.valueOf(tBachNo));
									if(flag == -1){
										tFinDataResult.setBussId("102");//业务类型
									}else{
										tFinDataResult.setBussId(bussType.substring(0, 3));//业务类型
									}
									tFinDataResult.setItemId(itemId);//科目编码
									tFinDataResult.setItemName(String.valueOf(finItemMap.get("itemName")));//科目名称
									tFinDataResult.setItemType(String.valueOf(finItemMap.get("itemType")));//借贷关系
									
									//获取明细金额、币种、财务日期等信息
									tFinDataResult.setMoney(Float.valueOf(String.valueOf(dealResultMap.get("money")))*flag);
									tFinDataResult.setCurrency(String.valueOf(dealResultMap.get("currency")));
									if( null == dealResultMap.get("finDate")){
										tFinDataResult.setFinDate(PubDateUtil.stringToDate(PubDateUtil.dateFormat(new Date()), "yyyy-MM-dd HH:mm"));
									}else{
										tFinDataResult.setFinDate(PubDateUtil.stringToDate(String.valueOf(dealResultMap.get("finDate")), "yyyy-MM-dd HH:mm"));
									}
									
									tFinDataResult.setOrgCode(String.valueOf(dealResultMap.get("orgCode")));
									//行摘要 + 加机构简称及办案人简称
									tFinDataResult.setBussKeyNo(String.valueOf(dealResultMap.get("bussKeyNo")));
									
									tFinDataResult.setMakeTime(new Date());
									
									//获取核算段信息
									tFinDataResult.setComCode(String.valueOf(dealResultMap.get(FinDataItemEnum.comCode.toString())));//公司段
									tFinDataResult.setDeptCode(String.valueOf(dealResultMap.get(FinDataItemEnum.deptCode.toString())));//部门段
									tFinDataResult.setBankCode(String.valueOf(dealResultMap.get(FinDataItemEnum.bankCode.toString())));//子目段，存储银行编号等信息
									tFinDataResult.setBussCode(String.valueOf(dealResultMap.get(FinDataItemEnum.bussCode.toString())));//业务段，辅助核算的业务号码信息
									tFinDataResult.setProductCode(String.valueOf(dealResultMap.get(FinDataItemEnum.productCode.toString())));//产品段
									tFinDataResult.setTransCode(String.valueOf(dealResultMap.get(FinDataItemEnum.transCode.toString())));//往来科目段，往来第三方等财务编号
									
									//<item name="cash_flow" >现金流编号,现金类科目会需要设置此号，业务做账会给到</item>
									tFinDataResult.setBackupCode(String.valueOf(dealResultMap.get(FinDataItemEnum.backupCode.toString())));//备用段作为现金流段
									
									tFinDataResult.setExtend1(String.valueOf(dealResultMap.get("extend1")));
									tFinDataResult.setExtend2(String.valueOf(dealResultMap.get("extend2")));
									tFinDataResult.setExtend3(String.valueOf(dealResultMap.get("extend3")));
									
									tFinDataResult.setDealFlag(VoucherStatus.Voucher1.getCode());//新生成的数据，导出状态 1:未导入2:成功 3:失败
									
									finDataResultMapper.insert(tFinDataResult);								
								
								}
								catch(Exception e)
								{
									mErrorMsg = "处理科目编码为【"+itemId+"】的凭证明细信息时发生错误！"+e.getMessage();
									log.error(e.getMessage());
									createDealLog(String.valueOf(tBachNo),itemId,bussType);
									continue;
								}
							}
							
							mErrorMsg = "科目编码为【"+itemId+"】的凭证数据处理成功，提取的SQL=【"+dealSql+"】！";
							createDealLog(String.valueOf(tBachNo),itemId,bussType);
						}
					}
				}else{
					
				}
			}			
		}
		
		return true;
	}
	
	/**
	 * 生成处理异常的日志信息
	 * @return
	 */
	private void createDealLog(String batchNo,String itemId,String bussId)
	{
		FinDataDealLog tLog = new FinDataDealLog();
		tLog.setLogId(sequenceService.getSequence("FinDataDealLog"));
		tLog.setBatchNo(batchNo);
		tLog.setItemId(itemId);
		tLog.setBussId(bussId);
		tLog.setContent(mErrorMsg);
		tLog.setMakeTime(new Date());
		
		finDataDealLogMapper.insert(tLog);
	}
	
	public String getErrorMsg()
	{
		return this.mErrorMsg;
	}
	
	//获取不同同步状态的的数据
/*	public List<FinData> getUFList(String dealFlag)
	{		
		List<FinData> uFinList = finDataMapper.selectByDealFlag(dealFlag);
		if(uFinList == null || uFinList.size() < 1)
		{
			mErrorMsg = "目前系统还没有需要同步的凭证信息，暂不处理！！";
			return null;
		}
		else
		{
			return uFinList;
		}		
	}*/
	
	public List<FinDataResult> getFinDataResultByBatchNo(){
		//finDataResultMapper.selectByDealFlag(dealFlag);
		return null;
	}
}
