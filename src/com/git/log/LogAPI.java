package com.git.log;

import java.util.Map;

import com.git.business.sys.User;

public interface LogAPI {
	void log(String message, String logLevel,User user);
	
	void log(String message, Object[] objects, String logLevel,User user);
	
	/**
	 * 
	 * 得到全局日志等级
	 * @return
	 */
	LogLevel getRootLogLevel();
	
	/**
	 * 
	 * 得到自定义包的日志等级
	 * @return
	 */
	Map<String, LogLevel> getCustomLogLevel();
}
