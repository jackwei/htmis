package com.git.web;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.git.web.editor.DateEditor;
import com.git.web.editor.DoubleEditor;
import com.git.web.editor.IntegerEditor;
import com.git.web.editor.LongEditor;

public abstract class BaseController {
	@Autowired
	protected ResourceBundleMessageSource _res;
	
//	@Autowired
//	protected SpringContextHolder _contextHolder;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
	
	protected ModelAndView ajaxDone(int statusCode, String message) {
		ModelAndView mav = new ModelAndView("ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		mav.addObject("id", "1234");
		return mav;
	}
	
	protected ModelAndView ajaxDone(int statusCode, String message,String navTabId,String callbackType,String forwardUrl) {
		ModelAndView mav = new ModelAndView("ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		//mav.addObject("navTabId", navTabId);
		//mav.addObject("callbackType", callbackType);
		mav.addObject("forwardUrl", forwardUrl);
		return mav;
	}
	
	protected ModelAndView ajaxDone(int statusCode, String message,String navTabId,String rel,String callbackType,String forwardUrl) {
		ModelAndView mav = new ModelAndView("ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		mav.addObject("navTabId", navTabId);
		mav.addObject("rel", rel);
		mav.addObject("callbackType", callbackType);
		mav.addObject("forwardUrl", forwardUrl);
		return mav;
	}

	protected ModelAndView ajaxDoneBack(int statusCode, String message,String result,Long id) {
		ModelAndView mav = new ModelAndView("ajaxDoneBack");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		mav.addObject("result", result);
		mav.addObject("id", id);
		return mav;
	}

	protected ModelAndView ajaxDoneSuccess(String message) {
		return ajaxDone(200, message);
	}
	
	protected ModelAndView ajaxDoneBackSuccess(String message,String result,Long id) {
		return ajaxDoneBack(200, message,result,id);
	}

	protected ModelAndView ajaxDoneError(String message) {
		return ajaxDone(300, message);
	}
	protected String getMessage(String code) {
		return this.getMessage(code, new Object[] {});
	}

	protected String getMessage(String code, Object arg0) {
		return getMessage(code, new Object[] { arg0 });
	}

	protected String getMessage(String code, Object arg0, Object arg1) {
		return getMessage(code, new Object[] { arg0, arg1 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2) {
		return getMessage(code, new Object[] { arg0, arg1, arg2 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2, Object arg3) {
		return getMessage(code, new Object[] { arg0, arg1, arg2, arg3 });
	}

	protected String getMessage(String code, Object[] args) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale locale = localeResolver.resolveLocale(request);

		return _res.getMessage(code, args, locale);
	}
	
	protected ModelAndView ajaxDone3(int statusCode, String message,String rel) {
		ModelAndView mav = new ModelAndView("ajaxDone3");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		mav.addObject("rel", rel);
		return mav;
	}
	
	protected ModelAndView ajaxDoneError(int statusCode,String message,String rel) {
		ModelAndView mav = new ModelAndView("ajaxDone3");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		mav.addObject("navTabId", "");
		mav.addObject("rel", rel);
		mav.addObject("callbackType", "");
		mav.addObject("forwardUrl", "");
		return mav;
	}
}
