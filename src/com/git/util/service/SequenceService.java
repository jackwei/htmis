package com.git.util.service;

import com.git.db.beans.ExchageRateImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;


public interface SequenceService extends BusinessObjectServiceMgr
{
	
	public  long getSequence(String sequenceName);
	
	public  String getSequence(String sequenceName,String prefix,String suffix);
	
	
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
	public  String getSequence(String sequenceName,String prefix,String suffix,int intLength,char appendchar,char LRApp);
	
	public  String getSequence(String sequenceName,String prefix,String middle,String suffix,int intLength,char appendchar,char LRApp);
	
	public ExchageRateImpl getRateByCurrency(String currency);
}
