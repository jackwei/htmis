package com.git.web;

//import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController{

	@RequestMapping("")
	public String index() {
		return "/login";
	}
	
	@RequestMapping("/index")
	public String indexLogin() {
		return "/login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
}