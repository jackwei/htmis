package com.git.log;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class Log4jInit
 */
public class Log4jInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log4jInit() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    }
    
    @Override
    public void init() throws ServletException {
    	 String file =this.getInitParameter("log4j");//从web.xml配置读取，名字一定要和web.xml配置一致
    	 String path = getServletContext().getRealPath("/");
    	  if(file != null){
    	     PropertyConfigurator.configure(path+file);
    	  }
    }
    
}
