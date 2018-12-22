package com.git.db.mapper;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public interface CommonMapper 
{
	public int insertSql(Map parameterMap);
	public int updateSql(Map parameterMap);
	public int deleteSql(Map parameterMap);
	
	public List executeSQL1(Map parameterMap);
	public List executeSQL2(Map parameterMap);
	public List executeSQL3(Map parameterMap);
	public List executeSQL4(Map parameterMap);
	public List executeSQL5(Map parameterMap);
	public List executeSQL6(Map parameterMap);
	public List executeSQL7(Map parameterMap);
	public List executeSQL8(Map parameterMap);
	public List executeSQL9(Map parameterMap);
	public List executeSQL10(Map parameterMap);
}

