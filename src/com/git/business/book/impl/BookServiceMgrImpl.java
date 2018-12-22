package com.git.business.book.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.book.Book;
import com.git.business.book.BookSearchFields;
import com.git.business.book.BookServiceMgr;
import com.git.business.book.Chapter;
import com.git.business.book.ChapterConditionVO;
import com.git.db.BaseConditionVO;
import com.git.db.beans.ResBook;
import com.git.db.beans.ResBookExample;
import com.git.db.beans.ResBookExample.Criteria;
import com.git.db.beans.ResChapter;
import com.git.db.beans.ResChapterExample;
import com.git.db.mapper.ResBookMapper;
import com.git.db.mapper.ResChapterMapper;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service("bookServiceMgr")
public class BookServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements BookServiceMgr {
	@Autowired
	private ResBookMapper bookMapper;
	@Autowired
	private ResChapterMapper chapterMapper;

	public Book getBook(int id) {
		ResBook po = bookMapper.selectByPrimaryKey(id);
		return new Book(po);
	}

	public void addBook(Book book) {
		Date now = new Date();
		ResBook po = book.getResBook();
		po.setInsertDate(now);
		po.setUpdateDate(now);
		bookMapper.insert(po);
	}

	public void updBook(Book book) {
		Date now = new Date();
		ResBook po = bookMapper.selectByPrimaryKey(book.getId());
		po.setSn(book.getSn());
		po.setNameCn(book.getNameCn());
		po.setNameEn(book.getNameEn());
		po.setPublish(book.getPublish());
		po.setPublishDate(book.getPublishDate());
		po.setUpdateDate(now);
		bookMapper.updateByPrimaryKey(po);
	}

	public void delBook(int id) {
		bookMapper.deleteByPrimaryKey(id);
	}

	public List<Book> searchBook(BaseConditionVO vo,
			String orderField, int startIndex, int count) {

		List<Book> bos = new ArrayList<Book>();		
		RowBounds rb = new RowBounds(startIndex, count);
		try
		{
			List<ResBook> pos = bookMapper.selectByCondition(vo.getKeywords(),rb);
			for (ResBook po : pos) 
			{
				bos.add(new Book(po));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return bos;
	}

	public int searchBookNum(BaseConditionVO vo) {
				
		int size =bookMapper.countByCondition(vo.getKeywords());
		return size;
	}

	public Chapter getChapter(int id) {
		ResChapter rc = chapterMapper.selectByPrimaryKey(id);
		return new Chapter(rc);
	}

	public void addChapter(Chapter chapter, File file) {
		Date now = new Date();
		ResChapter rc = chapter.getResChapter();
		rc.setInsertDate(now);
		rc.setInitContent(true);
		rc.setUpdateDate(now);
		chapterMapper.insert(rc);
	}

	public void updChapter(Chapter chapter) {
		
	}

	public void delChapter(int id) {
		chapterMapper.deleteByPrimaryKey(id);
	}

	public List<Chapter> listChapters(int bookId) {
		List<Chapter> bos = new ArrayList<Chapter>();
		ResChapterExample rce = new ResChapterExample();
		List<ResChapter> rc = chapterMapper.selectByExample(rce);
		for (ResChapter resChapter : rc) {
			bos.add(new Chapter(resChapter));
		}
		return bos;
	}

	public List<Chapter> searchChapters(ChapterConditionVO vo) {
		
		List<Chapter> bos = new ArrayList<Chapter>();
		
		return bos;
	}
	

	public Integer searchChaptersNum(ChapterConditionVO vo) {

		Integer count = 1;

		return count;
	}

	public void initChaptersContent() {		
	}
}
