package com.git.web.management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.book.Book;
import com.git.business.book.BookServiceMgr;
import com.git.business.book.Chapter;
import com.git.db.BaseConditionVO;
import com.git.web.BaseController;

@Controller
@RequestMapping(value="/management/book")
public class BookController extends BaseController{
	@Autowired
	private BookServiceMgr bookMgr;
	
	@RequestMapping("")
	public String list(BaseConditionVO vo,Model model) {
		
		List<Book> bookList = bookMgr.searchBook(vo, null, vo.getStartIndex(), vo.getPageSize());
		
		int totalCount = bookMgr.searchBookNum(vo);
		vo.setTotalCount(totalCount);
		model.addAttribute(bookList);
		model.addAttribute("vo", vo);
		return "/management/book/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		return "/management/book/add";
	}
	
	@RequestMapping("/edit/{bookId}")
	public String edit(@PathVariable("bookId") int bookId, Model model) {
		Book book = bookMgr.getBook(bookId);
		List<Chapter> chapters = bookMgr.listChapters(bookId);
		
		model.addAttribute(book);
		model.addAttribute("chapters", chapters);
		
		return "/management/book/edit";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Book book) {
		bookMgr.addBook(book);

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Book book) {
		bookMgr.updBook(book);
		return ajaxDoneError(getMessage("msg.operation.success"));

	}
	
	@RequestMapping("/delete/{bookId}")
	public ModelAndView delete(@PathVariable("bookId") int bookId) {

		bookMgr.delBook(bookId);

		return ajaxDoneError(getMessage("msg.operation.success"));
	}
}
