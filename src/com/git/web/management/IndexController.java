package com.git.web.management;

//import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dwz.framework.config.AppConfiguration;

@Controller("management.indexController")
@RequestMapping("/management")
public class IndexController {

	// @Inject
	// private User user;

	@RequestMapping("")
	public String index() {
		
		return "/management/index";
	}

	
}