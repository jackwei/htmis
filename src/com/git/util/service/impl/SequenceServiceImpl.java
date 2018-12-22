package com.git.util.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.db.beans.ExchageRateImpl;
import com.git.db.beans.ExchageRateImplExample;
import com.git.db.beans.SysSequence;
import com.git.db.mapper.ExchageRateImplMapper;
import com.git.db.mapper.SysSequenceMapper;
import com.git.util.StrTool;
import com.git.util.service.SequenceService;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service("SequenceService")
public class SequenceServiceImpl extends AbstractBusinessObjectServiceMgr implements SequenceService
{
	@Autowired
	private SysSequenceMapper tSysSequenceMapper;
	
	@Autowired
	private ExchageRateImplMapper exchageRateImplMapper;
	
	public  long getSequence(String sequenceName)
	{
		long sequenceNo=0;
		SysSequence tSysSequence=tSysSequenceMapper.selectByPrimaryKey(sequenceName);
		if(tSysSequence==null)
		{
			tSysSequence=new SysSequence();
			tSysSequence.setSeqName(sequenceName);
			tSysSequence.setSeqNo((long)10001);
			sequenceNo=tSysSequence.getSeqNo();
			tSysSequenceMapper.insert(tSysSequence);
		}
		else
		{
			tSysSequence.setSeqNo(tSysSequence.getSeqNo()+1);
			sequenceNo=tSysSequence.getSeqNo();
			tSysSequenceMapper.updateByPrimaryKey(tSysSequence);
		}
		
		return sequenceNo;
	}
	
	public  String getSequence(String sequenceName,String prefix,String suffix)
	{
		String sequenceNo="";
		SysSequence tSysSequence=tSysSequenceMapper.selectByPrimaryKey(sequenceName);
		if(tSysSequence==null)
		{
			tSysSequence=new SysSequence();
			tSysSequence.setSeqName(sequenceName);
			tSysSequence.setPrefix(prefix);
			tSysSequence.setSuffix(suffix);
			tSysSequence.setSeqNo((long)101);
			
			sequenceNo=tSysSequence.getPrefix()+tSysSequence.getSeqNo()+tSysSequence.getSuffix();
			tSysSequenceMapper.insert(tSysSequence);
		}
		else
		{
			tSysSequence.setSeqNo(tSysSequence.getSeqNo()+1);
			sequenceNo=tSysSequence.getPrefix()+tSysSequence.getSeqNo()+tSysSequence.getSuffix();
			tSysSequenceMapper.updateByPrimaryKey(tSysSequence);
		}
		
		return sequenceNo;
	}
	
	/**
     * 以指定内容生成给定长度的字符串,不足以指定字符按指定方式补齐,超长截去
     * @param sequenceName String 序列名称
     * @param prefix String 序列前缀
     * @param suffix String 序列后缀
     * @param intLength int 可变序列的字符串长度
     * @param appendchar char 指定字符
     * @param LRApp char 指定方式 L:左补齐  R:右补齐
     * @return String
     */
	public  String getSequence(String sequenceName,String prefix,String suffix,int intLength,char appendchar,char LRApp)
	{
		String sequenceNo="";
		SysSequence tSysSequence=tSysSequenceMapper.selectByPrimaryKey(sequenceName);
		if(tSysSequence==null)
		{
			tSysSequence=new SysSequence();
			tSysSequence.setSeqName(sequenceName);
			tSysSequence.setPrefix(prefix);
			tSysSequence.setSuffix(suffix);
			tSysSequence.setSeqNo((long)1);
			
			String nowIndex = StrTool.getStringWith(String.valueOf(tSysSequence.getSeqNo()), intLength,appendchar,LRApp);
			sequenceNo=tSysSequence.getPrefix().concat(nowIndex).concat(tSysSequence.getSuffix());
			tSysSequenceMapper.insert(tSysSequence);
		}
		else
		{
			tSysSequence.setSeqNo(tSysSequence.getSeqNo()+1);
			
			String nowIndex = StrTool.getStringWith(String.valueOf(tSysSequence.getSeqNo()), intLength,appendchar,LRApp);
			sequenceNo=tSysSequence.getPrefix().concat(nowIndex).concat(tSysSequence.getSuffix());
			
			tSysSequenceMapper.updateByPrimaryKey(tSysSequence);
		}
		
		return sequenceNo;
	}
	
	/**
	 * 案件编号生成规则
     * @param sequenceName String 序列名称
     * @param prefix String 序列前缀
     * @param middle String 序列中间
     * @param suffix String 序列后缀
     * @param intLength int 可变序列的字符串长度
     * @param appendchar char 指定字符
     * @param LRApp char 指定方式 L:左补齐  R:右补齐
     * @return String
	 * 
	 * */
	public  String getSequence(String sequenceName,String prefix,String middle,String suffix,int intLength,char appendchar,char LRApp)
	{
		String sequenceNo="";
		SysSequence tSysSequence=tSysSequenceMapper.selectByPrimaryKey(sequenceName);
		if(tSysSequence==null)
		{
			tSysSequence=new SysSequence();
			tSysSequence.setSeqName(sequenceName);
			tSysSequence.setPrefix(prefix);
			tSysSequence.setSuffix(middle);
			tSysSequence.setSeqNo((long)580);
			
			String nowIndex = StrTool.getStringWith(String.valueOf(tSysSequence.getSeqNo()), intLength,appendchar,LRApp);
			sequenceNo=tSysSequence.getPrefix().concat(middle).concat(nowIndex);
			tSysSequenceMapper.insert(tSysSequence);
		}
		else
		{
			if(!middle.equals(tSysSequence.getSuffix())){
				tSysSequence.setSuffix(middle);
				tSysSequence.setSeqNo((long)1);
			}else{
				tSysSequence.setSeqNo(tSysSequence.getSeqNo()+1);
			}
			
			String nowIndex = StrTool.getStringWith(String.valueOf(tSysSequence.getSeqNo()), intLength,appendchar,LRApp);
			sequenceNo=tSysSequence.getPrefix().concat(tSysSequence.getSuffix()).concat(nowIndex);
			
			tSysSequenceMapper.updateByPrimaryKey(tSysSequence);
		}
		
		return sequenceNo;
	}
	
	/**
	 * 根据币种获取汇率
	 * */
	public ExchageRateImpl getRateByCurrency(String currency){
		ExchageRateImplExample example = new ExchageRateImplExample();
		example.setOrderByClause(" id desc");
		example.createCriteria().andShortnameEqualTo(currency);
		ExchageRateImpl exchageRateImpl = exchageRateImplMapper.selectByExample(example).get(0);
		return exchageRateImpl;
	}
	
}
