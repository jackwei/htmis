package com.git.util.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.git.util.MyBatisUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonSqlService
{
	private List list;
	private HashMap hashMap=new HashMap();
	private static Map queryDispatcher=new HashMap();
	private final static int QUERY_POOL_SIZE=10;
	private final static int TIMEOUT_CLEAR=3*60*1000;
	private static final Log log=LogFactory.getLog(CommonSqlService.class);
		
	static SqlSessionFactory sqlSessionFactory = null; 
    static 
    { 
       sqlSessionFactory = MyBatisUtil.getSqlSessionFactory(); 
    } 
	
	public List executeSQL(Map parameterMap)
	{
			
		hashMap.clear();
		hashMap.putAll(parameterMap);
		int dispatcherNo=this.getQueryDispatcherNo();
		if(dispatcherNo<0)
		{
			return null;
		}
		
		SqlSession session = sqlSessionFactory.openSession();	
		try{			
			//查询得到多组数据
			list = (List)session.selectList("com.git.db.mapper.CommonMapper.executeSQL"+dispatcherNo,parameterMap);			
			
		}finally{
			session.close();
		}
		
		this.releaseQuery(dispatcherNo);
		return list;
		
	}
	
	public List executeSQL(String sql)
	{
		Map parameterMap=new HashMap();
		parameterMap.put("SQL", sql);
		hashMap.clear();
		hashMap.putAll(parameterMap);
		int dispatcherNo=this.getQueryDispatcherNo();
		if(dispatcherNo<0)
		{
			return null;
		}
		
		SqlSession session = sqlSessionFactory.openSession();	
		try{			
			//查询得到多组数据
			list = (List)session.selectList("com.git.db.mapper.CommonMapper.executeSQL"+dispatcherNo,parameterMap);
			
		}finally{
			session.close();
		}
		
		this.releaseQuery(dispatcherNo);
		return list;
	}
	
	public List executeSQL(Map parameterMap,RowBounds rb)
	{
			
		hashMap.clear();
		hashMap.putAll(parameterMap);
		int dispatcherNo=this.getQueryDispatcherNo();
		if(dispatcherNo<0)
		{
			return null;
		}
		
		SqlSession session = sqlSessionFactory.openSession();	
		try{			
			//查询得到多组数据
			list = (List)session.selectList("com.git.db.mapper.CommonMapper.executeSQL"+dispatcherNo,parameterMap,rb);			
			
		}finally{
			session.close();
		}
		
		this.releaseQuery(dispatcherNo);
		return list;
		
	}
	
	public List executeSQL(String sql,RowBounds rb)
	{
		Map parameterMap=new HashMap();
		parameterMap.put("SQL", sql);
		hashMap.clear();
		hashMap.putAll(parameterMap);
		int dispatcherNo=this.getQueryDispatcherNo();
		if(dispatcherNo<0)
		{
			return null;
		}
		
		SqlSession session = sqlSessionFactory.openSession();	
		try{			
			//查询得到多组数据
			list = (List)session.selectList("com.git.db.mapper.CommonMapper.executeSQL"+dispatcherNo,parameterMap,rb);
			
		}finally{
			session.close();
		}
		
		this.releaseQuery(dispatcherNo);
		return list;
	}
	
	/*
	 * 执行更新SQL
	 */
	public int updateSQL(Map parameterMap)
	{
		HashMap hashMap=new HashMap();
		hashMap.putAll(parameterMap);
		int rows = 0;
		SqlSession session = sqlSessionFactory.openSession();	
		try{			
			//查询得到多组数据
			rows = session.update("com.git.db.mapper.CommonMapper.updateSql",parameterMap);
			
		}finally{
			session.close();
		}
		
		return rows;
	}
	
	/*
	 * 执行更新SQL
	 */
	public int insertSQL(Map parameterMap)
	{
		HashMap hashMap=new HashMap();
		hashMap.putAll(parameterMap);
		int rows = 0;
		SqlSession session = sqlSessionFactory.openSession();	
		try{			
			//查询得到多组数据
			rows = session.insert("com.git.db.mapper.CommonMapper.insertSql",parameterMap);
			
		}finally{
			session.close();
		}
		
		return rows;
	}
	
	/*
	 * 执行更新SQL
	 */
	public int deleteSQL(Map parameterMap)
	{
		HashMap hashMap=new HashMap();
		hashMap.putAll(parameterMap);
		int rows = 0;
		SqlSession session = sqlSessionFactory.openSession();	
		try{
			//查询得到多组数据
			rows = session.delete("com.git.db.mapper.CommonMapper.deleteSql",parameterMap);
			
		}finally{
			session.close();
		}
		
		return rows;
	}
		
	private synchronized int getQueryDispatcherNo()
	{
		int dispatcherNo=-1;
		if(this.queryDispatcher.size()==this.QUERY_POOL_SIZE)
		{
			log.error("QUERY_POOL IS FULL~~!!!!");
			return -1;
		}
		int i=1;
		while(this.queryDispatcher.get(i)!=null)
		{
			i++;
		}
		dispatcherNo=i;
		this.queryDispatcher.put(dispatcherNo,System.currentTimeMillis());
		log.debug("get query pool "+dispatcherNo);
		return dispatcherNo;
	}
	
	private void releaseQuery(int dispatcherNo)
	{
		this.queryDispatcher.remove(dispatcherNo);
		log.debug("release query pool "+dispatcherNo);
	}
}

