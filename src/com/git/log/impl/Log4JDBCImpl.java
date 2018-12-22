package com.git.log.impl;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.git.business.service.LogEntityService;
import com.git.business.sys.User;
import com.git.db.beans.LogEntity;
import com.git.log.LogLevel;
import com.git.util.service.SequenceService;

/** 
 * 全局日志等级<包日志等级<类和方法日志等级
 * Version  2.1.0
 */
public class Log4JDBCImpl extends LogAdapter {
	
	private LogLevel rootLogLevel = LogLevel.ERROR;
	
	@Autowired
	private LogEntityService logEntityService;
	
	@Autowired
	private SequenceService sequenceService;
	
	private Map<String, LogLevel> customLogLevel = Maps.newHashMap();

	/**
	 * 
	 * @param message
	 * @param objects
	 * @param logLevel  
	 * @see com.ketayao.ketacustom.log.impl.LogAdapter#log(java.lang.String, java.lang.Object[], com.ketayao.ketacustom.log.LogLevel)
	 */
	@Override
	public void log(String message, Object[] objects, String logLevel,User user) {	
		
		MessageFormat mFormat = new MessageFormat(message);
		String result = mFormat.format(objects);
		
		if (!StringUtils.isNotBlank(result)) {
			return;
		}
		
	/*	Subject subject = SecurityUtils.getSubject();
		ShiroDbRealm.ShiroUser shiroUser = (ShiroDbRealm.ShiroUser)subject.getPrincipal();*/
		//result = shiroUser.toString() + ":" + result;
		
		LogEntity logEntity = new LogEntity();
		logEntity.setId(sequenceService.getSequence("log_id"));
		logEntity.setCreateTime(new Date());
		
		logEntity.setUsername(user.getName());
		logEntity.setMessage(result);
		logEntity.setIpAddress(user.getExtend3());
		logEntity.setLogLevel(logLevel);
		
		logEntityService.save(logEntity);
	}

	public void setRootLogLevel(LogLevel rootLogLevel) {
		this.rootLogLevel = rootLogLevel;
	}

	/**   
	 * 
	 * @return  
	 * @see com.ketayao.ketacustom.log.LogTemplate#getRootLogLevel()  
	 */
	@Override
	public LogLevel getRootLogLevel() {
		return rootLogLevel;
	}
	
	public void setCustomLogLevel(Map<String, LogLevel> customLogLevel) {
		this.customLogLevel = customLogLevel;
	}
	
	@Override
	public Map<String, LogLevel> getCustomLogLevel() {
		return customLogLevel;
	}

	public void setLogEntityService(LogEntityService logEntityService) {
		this.logEntityService = logEntityService;
	}
	
}
