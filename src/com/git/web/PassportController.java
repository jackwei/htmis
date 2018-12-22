package com.git.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.sys.Org;
import com.git.business.sys.OrgServiceMgr;
import com.git.business.sys.User;
import com.git.business.sys.UserServiceMgr;
import com.git.util.Encrypt;
import com.git.util.MD5;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.BusinessFactory;

@Controller
@RequestMapping(value = "/passport")
public class PassportController extends BaseController {
	protected static Logger logger = Logger.getLogger(PassportController.class);

	@Autowired
	private UserServiceMgr userMgr;
	
	@Autowired
	private OrgServiceMgr orgMgr;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String usercode = request.getParameter("usercode");
		String password = request.getParameter("password");
		User user = userMgr.getUserByUserCode(usercode);
		if (user == null) {
			modelAndView.addObject("message", "该用户不存在!");
			modelAndView.setViewName("login");
			return modelAndView;
		}
		String ip = "";
		if (request.getHeader("x-forwarded-for") == null) {
			ip = request.getRemoteAddr();
		} else {
			ip = request.getHeader("x-forwarded-for");
		}
		user.setExtend3(ip);

		if (user != null && password != null
				&& MD5.getMD5ofStr(password).equals(user.getUserPwd())) {
			request.getSession().setAttribute(Constants.AUTHENTICATION_KEY,
					user);
			Org org = orgMgr.getOrg(user.getOrgId());
			request.getSession().setAttribute(Constants.ORGCODE_KEY,org);

			String backToUrl = "/main";

			try {
				backToUrl = java.net.URLDecoder.decode(backToUrl, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			System.out.println("backToUrl: " + backToUrl);

			return new ModelAndView("redirect:" + backToUrl);
		}
		modelAndView.setViewName("login");
		modelAndView.addObject("message", "用户名或密码错误。");

		return modelAndView;
	}

	@RequestMapping("/sso_login")
	public ModelAndView sso_login(HttpServletRequest request, String key) {
		ModelAndView modelAndView = new ModelAndView();
		UserServiceMgr userMgr = BusinessFactory.getInstance().getService(
				"userServiceMgr");
		OrgServiceMgr orgMgr = BusinessFactory.getInstance().getService(
		"orgServiceMgr");
		User user = userMgr.getUserByUserCode(key);
		if (user == null) {
			modelAndView.addObject("message", "该用户不存在!");
			modelAndView.setViewName("login");
			return modelAndView;
		}
		String ip = "";
		if (request.getHeader("x-forwarded-for") == null) {
			ip = request.getRemoteAddr();
		} else {
			ip = request.getHeader("x-forwarded-for");
		}
		user.setExtend3(ip);

		/*
		 * if (user != null && password!=null &&
		 * MD5.getMD5ofStr(password).equals(user.getUserPwd())) {
		 */
		request.getSession().setAttribute(Constants.AUTHENTICATION_KEY, user);
		Org org = orgMgr.getOrg(user.getOrgId());
		request.getSession().setAttribute(Constants.ORGCODE_KEY,org);
		
		String backToUrl = "/main";

		try {
			backToUrl = java.net.URLDecoder.decode(backToUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println("backToUrl: " + backToUrl);
		modelAndView.setViewName("main");
		return modelAndView;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {

		request.getSession().removeAttribute(Constants.AUTHENTICATION_KEY);

		return new ModelAndView("login");
	}

	@RequestMapping("/uptpwd")
	public ModelAndView uptpwd(HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.AUTHENTICATION_KEY);

		String newPwd = request.getParameter("newPassword");

		newPwd = MD5.getMD5ofStr(newPwd);

		boolean result = userMgr.updPassword(user.getId(), newPwd);

		if (!result) {
			return ajaxDoneError(300, "密码修改失败!", "");

		} else {
			user.setUserPwd(newPwd);

			return ajaxDoneSuccess("修改成功！");
		}
	}

	@RequestMapping(value = "/checkPwd")
	@ResponseBody
	public String checkCaseNumber(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.AUTHENTICATION_KEY);

		String password = request.getParameter("password");

		if (MD5.getMD5ofStr(password).equals(user.getUserPwd()))
			return "true";
		else
			return "false";
	}

	

	/**
	 * 基于MaxEJO的单点登录
	 * 
	 * @param req
	 * @param rootXML
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 * @throws DocumentException
	 */
	public boolean loginByMaxEJO(HttpServletRequest request,
			String rootXML) throws HttpException, IOException,
			DocumentException {
		boolean flag = false;

		if (request.getParameter("ticket") == null
				|| "".equals(request.getParameter("ticket"))) {
			String ticket = request.getParameter("ticket");
			logger.info(ticket);
			return flag;
		}
		UserServiceMgr userServiceMgr = BusinessFactory.getInstance().getService(
		"userServiceMgr");
		String key = userServiceMgr.getRemoteKey(rootXML, request);
		//key = "cuijiyu";
		if (key != null) {
			PassportController pc = new PassportController();
			pc.sso_login(request, key);
			flag = true;
		}
		return flag;
	}


	public static void main(String[] args) {

		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("SSO_LOGIN");
		Element paramEle = rootElement.addElement("param");
		paramEle.addElement("ticket").setText("1381737101403");

		String xml = requestDocument.asXML();

		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod("");
		String result = "";
		try {
			httpMethod.setRequestEntity(new StringRequestEntity(xml,
					"text/xlm", "utf-8"));
			client.executeMethod(httpMethod);
			result = httpMethod.getResponseBodyAsString().trim();
			Document responseDocument = DocumentHelper.parseText(result);
			Element huataiElement = responseDocument.getRootElement();
			String status = huataiElement.selectSingleNode("result/status")
					.getStringValue();
			String key = null;
			if ("1".equals(status)) {
				// 成功
				key = huataiElement.selectSingleNode("responseData/userKey")
						.getStringValue();
			} else {
				logger.error("单点登录失败!["
						+ huataiElement.selectSingleNode("result/desc")
								.getStringValue() + "]");
			}
			if (key != null) {
				key = Encrypt.decode(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}