package com.git.task;

import com.git.business.book.BookServiceMgr;

import dwz.framework.sys.business.BusinessFactory;

public class Pdf2jsonTask {

	
	public void execute() {
		System.out.println("Start Pdf2jsonTask...");
		BookServiceMgr bookMgr = BusinessFactory.getInstance().getService("bookServiceMgr");
		//bookMgr.initChaptersContent();
	}	
}
