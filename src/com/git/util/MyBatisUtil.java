package com.git.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MyBatisUtil  {   
	
    private  final static SqlSessionFactory sqlSessionFactory;   
    
    static {   
    	ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:application-context.xml"); 
    	sqlSessionFactory = (SqlSessionFactory)ac.getBean("sqlSessionFactory"); 
    }   
   
    public static SqlSessionFactory getSqlSessionFactory() {   
       return sqlSessionFactory;   
    }   
}  
