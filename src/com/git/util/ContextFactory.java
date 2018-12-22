package com.git.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class ContextFactory
{
	private static ServletContext servletContext;
	private static WebApplicationContext webApplicationContext;
	private static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext()
	{
		if(applicationContext==null)
		{
			applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		
		return applicationContext;
	}
	public static void setApplicationContext(ApplicationContext applicationContext)
	{
		ContextFactory.applicationContext = applicationContext;
	}
	public static ServletContext getServletContext()
	{
		return servletContext;
	}
	public static void setServletContext(ServletContext servletContext)
	{
		ContextFactory.servletContext = servletContext;
	}
	public static WebApplicationContext getWebApplicationContext()
	{
		if(servletContext==null)
		{
			return null;
		}
		webApplicationContext =(WebApplicationContext)
		servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		return webApplicationContext;
	}
	public static void setWebApplicationContext(
			WebApplicationContext webApplicationContext)
	{
		ContextFactory.webApplicationContext = webApplicationContext;
	}
}
