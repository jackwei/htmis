package com.wabacus.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.wabacus.config.database.datasource.AbsDataSource;
import com.wabacus.exception.WabacusRuntimeException;

import dwz.framework.spring.SpringContextHolder;

public class SpringDataSource extends AbsDataSource {
	 
	private static Logger logger = Logger.getLogger(SpringDataSource.class);
	 
	private DataSource ds;
	 
	public SpringDataSource() 
	{
		this.ds = (DataSource) SpringContextHolder.getApplicationContext().getBean ("dataSource");
	}
	 
	@Override
	public Connection getConnection() {
		try {
			logger.debug("从数据源"+this.getName()+"获取数据库连接");
			return this.ds.getConnection();
		} catch(SQLException e) {
			throw new WabacusRuntimeException("获取"+this.getName()+"数据源的数据库连接失败",e);
		}
	}
	 
	@Override
	public DataSource getDataSource() {
		return this.ds;
	}
}