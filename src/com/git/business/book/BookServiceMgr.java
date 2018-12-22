package com.git.business.book;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.git.db.BaseConditionVO;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface BookServiceMgr extends BusinessObjectServiceMgr {
	Book getBook(int id);
	void addBook(Book book);
	void updBook(Book book);
	void delBook(int id);
	
	List<Book> searchBook(BaseConditionVO vo, String orderField,
			int startIndex, int count);

	int searchBookNum(BaseConditionVO vo);
	
	Chapter getChapter(int id);
	void addChapter(Chapter chapter, File file);
	void updChapter(Chapter chapter);
	void delChapter(int id);
	
	List<Chapter> listChapters(int bookId);
	List<Chapter> searchChapters(ChapterConditionVO vo);
	Integer searchChaptersNum(ChapterConditionVO vo);
	
	void initChaptersContent();
}
