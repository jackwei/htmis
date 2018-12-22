package com.git.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileLoad {
	private static final String PROPERTIESFILE_NAME = "params.properties";
	
	private static final PropertiesFileLoad INSTANCE = new PropertiesFileLoad();
	private Properties p;
	
	public PropertiesFileLoad() {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(PROPERTIESFILE_NAME); 
		p = new Properties();
		try {
			p.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static PropertiesFileLoad getInstance() {
		return INSTANCE;
	}

	public Properties getP() {
		return p;
	}

	public void setP(Properties p) {
		this.p = p;
	}
}
