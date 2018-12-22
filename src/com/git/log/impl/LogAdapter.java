package com.git.log.impl;

import java.util.Map;

import com.google.common.collect.Maps;
import com.git.business.sys.User;
import com.git.log.LogAPI;
import com.git.log.LogLevel;


public class LogAdapter implements LogAPI {

	/**   
	 * @param message
	 * @param logLevel  
	 * @see com.ketayao.ketacustom.log.LogAPI#log(java.lang.String, com.ketayao.ketacustom.log.LogLevel)  
	 */
	@Override
	public void log(String message, String logLevel,User user) {
		log(message, null, logLevel,user);
	}

	/**   
	 * @param message
	 * @param objects
	 * @param logLevel  
	 * @see com.ketayao.ketacustom.log.LogAPI#log(java.lang.String, java.lang.Object[], com.ketayao.ketacustom.log.LogLevel)  
	 */
	@Override
	public void log(String message, Object[] objects, String logLevel,User user) {
		
	}
	
	/**   
	 * @return  
	 * @see com.ketayao.ketacustom.log.LogAPI#getRootLogLevel()  
	 */
	@Override
	public LogLevel getRootLogLevel() {
		return LogLevel.ERROR;
	}

	/**   
	 * @return  
	 * @see com.ketayao.ketacustom.log.LogAPI#getCustomLogLevel()  
	 */
	@Override
	public Map<String, LogLevel> getCustomLogLevel() {
		return Maps.newHashMap();
	}
}
