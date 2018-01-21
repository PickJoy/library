package com.cnu.library.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cnu.library.model.Book;
import com.cnu.library.model.Borrower;
import com.cnu.library.model.SaveBook;
import com.cnu.library.model.base.PageView;
import com.cnu.library.model.base.QueryResult;
import com.cnu.library.service.BookService;
import com.cnu.library.service.BorrowerManageService;
import com.cnu.library.service.BorrowerService;
import com.cnu.library.service.ReservationService;
import com.cnu.library.service.SaveBookService;
import com.cnu.library.vo.BorrowerVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "servlet/borrowerAction/")
public class BorrowerAction {

	private BorrowerService borrowerService ;
	private BookService bookService;
	private SaveBookService saveBookService;
	private ReservationService reservationService;
	private BorrowerManageService borrowerManageService;


	/**
	 * 个人信息
	 * @param request
	 * @param response
     * @return
     */
	@RequestMapping(value = "borrowerDetail")
	public String borrowerDetail(HttpServletRequest request,HttpServletResponse response){
		
		Borrower user =(Borrower) request.getSession().getAttribute("user");
		Borrower borrower = borrowerService.find(user.getId());
		request.getSession().setAttribute("user", borrower);
		return "borrower/borrowerdetail";
	}

	/**
	 *
	 * @param formbean
	 * @param request
	 * @param response
     * @return
     */
	@RequestMapping(value = "listBooks")
	public String listBooks(BorrowerVo formbean,HttpServletRequest request,HttpServletResponse response){
		
		PageView<Book> pageView = new PageView<Book>(formbean.getMaxResult(),formbean.getPage());
		
		StringBuilder sb = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		if( formbean.getName()!=null&& !formbean.getName().trim().equals("")){
			sb.append(" o.name like ? ");
			params.add("%"+formbean.getName()+"%");
			//System.out.println(formbean.getName()+"-----");
		}
		if( formbean.getInsb()!=null&& !formbean.getInsb().trim().equals("")){
			if( params.size()>0)
				sb.append(" and ");
			sb.append(" o.insb=? ");
			params.add(formbean.getInsb());
			//System.out.println(formbean.getInsb()+"-----");
		}
		
		QueryResult<Book> queryResult= bookService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(), sb.toString(), params.toArray(), null);
		pageView.setQueryResult(queryResult);
		//System.out.println(formbean.getPage()+"-------------"+queryResult.getResultlist().size());
		request.setAttribute("pageView", pageView);
		request.setAttribute("formbean", formbean);
		return "borrower/booklist";
	}

	/**
	 *
	 * @param formbean
	 * @param request
	 * @param response
     * @return
     */
	@RequestMapping(value = "borrowerBook")
	public String borrowerBook(BorrowerVo formbean,HttpServletRequest request,HttpServletResponse response){
		
		Borrower borrower =(Borrower) request.getSession().getAttribute("user");
		//Borrower borrower =borrowerService.find(user.getId());
		Book book = bookService.find(formbean.getBookId());
		if( borrower ==null){
			return "index";
		}
		
		//-1用户是否有借书权限
		if(borrower.getVisible()==false){
			request.setAttribute("message", "你没有借书权限!");
			request.setAttribute("urladdress", "/servlet/borrowerAction//listBooks.html?page=1");
			return "message";
		}
		//2.所借的书是否已经借过
		SaveBook sb =saveBookService.findByBookIdAndBorrowerId(book.getId(),borrower.getId());
		if( sb!=null){
			request.setAttribute("message", "你已经借过该书了!");
			request.setAttribute("urladdress", "/servlet/borrowerAction/listBooks.html?page=1");
			return "message";
		}
		//0.该书是否还有可借数量
		if(book.getSurplus()<=0){
			request.setAttribute("message", "该书已被借完!");
			request.setAttribute("urladdress","/servlet/borrowerAction/listBooks.html?page=1");;
			return "message";
		}
		
		
		//1.是否超出借书数量
		int maxSave = borrower.getMaxSaveBooks();
		int ownSave = borrower.getSaveBooks();
		if( ownSave>= maxSave){
			request.setAttribute("message", "你不可以借更多的书!");
			request.setAttribute("urladdress","/servlet/borrowerAction/listBooks.html?page=1");
			return "message";
		}
		
		
		
		
		//3.借书
		SaveBook saveBook = new SaveBook();
		saveBook.setBookId(book.getId());
		saveBook.setBorrowerId(borrower.getId());
		//借书数量加1
		borrower.setSaveBooks(borrower.getSaveBooks()+1);
		//书剩余数量减1
		if( book.getSurplus() >0)
		  book.setSurplus(book.getSurplus()-1);
		
		//4.更新数据
		if(borrowerManageService.updateBorrowerBook(saveBook, book, borrower)){
			request.setAttribute("message", "借书成功!");
		}else{
			request.setAttribute("message", "借书失败!");
		}
		request.setAttribute("urladdress", "/servlet/borrowerAction/listBooks.html?page=1");
		return  "message";
	}

	/**
	 *
	 * @param formbean
	 * @param request
	 * @param response
     * @return
     */
	@RequestMapping(value = "returnBook")
	public String returnBook(BorrowerVo formbean,HttpServletRequest request,HttpServletResponse response){
		
		Borrower borrower =(Borrower) request.getSession().getAttribute("user");
		if( borrower ==null){
			return "index";
		}
		Book book = bookService.find(formbean.getBookId());
		//图书数量加1
		book.setSurplus(book.getSurplus()+1);
		//用户保留书量减1
		if( borrower.getSaveBooks()>0)
		  borrower.setSaveBooks(borrower.getSaveBooks()-1);
		if(borrowerManageService.returnBook(book,borrower)){
			request.setAttribute("message", "还书成功!");
		}else{
			request.setAttribute("message", "还书失败!");
		}   
		request.setAttribute("urladdress", "/servlet/borrowerAction/listSaveBooks.html?page="+formbean.getPage());
		
		return  "message";
	} 
	

	/**
	 *
	 * @param formbean
	 * @param request
	 * @param response
     * @return
     */
	@RequestMapping(value = "listSaveBooks")
	public String listSaveBooks(BorrowerVo formbean,HttpServletRequest request,HttpServletResponse response){
		
		PageView<Book> pageView = new PageView<Book>(formbean.getMaxResult(),formbean.getPage());
		
		QueryResult<Book> queryResult=saveBookService.getSaveBook(pageView.getFirstResult(), pageView.getMaxresult());
		
		pageView.setQueryResult(queryResult);
		//System.out.println(formbean.getPage()+"-------------"+queryResult.getResultlist().size());
		request.setAttribute("pageView", pageView);
		request.setAttribute("formbean",formbean);
		return "borrower/saveBooklist";
	} 
	
	public BorrowerService getBorrowerService() {
		return borrowerService;
	}
	@Resource
	public void setBorrowerService(BorrowerService borrowerService) {
		this.borrowerService = borrowerService;
	}
	public BookService getBookService() {
		return bookService;
	}
	@Resource
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public SaveBookService getSaveBookService() {
		return saveBookService;
	}
	@Resource
	public void setSaveBookService(SaveBookService saveBookService) {
		this.saveBookService = saveBookService;
	}
	public ReservationService getReservationService() {
		return reservationService;
	}
	@Resource
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	public BorrowerManageService getBorrowerManageService() {
		return borrowerManageService;
	}
	@Resource
	public void setBorrowerManageService(BorrowerManageService borrowerManageService) {
		this.borrowerManageService = borrowerManageService;
	}

	
}
