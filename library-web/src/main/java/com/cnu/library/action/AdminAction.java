package com.cnu.library.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.cnu.library.model.Admin;
import com.cnu.library.model.Book;
import com.cnu.library.model.Borrower;
import com.cnu.library.model.base.PageView;
import com.cnu.library.model.base.QueryResult;
import com.cnu.library.service.AdminService;
import com.cnu.library.service.BookService;
import com.cnu.library.service.BorrowerService;
import com.cnu.library.vo.AdminVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author liang
 *图书管理员：添加读者，查看读者，添加图书，删除图书。
 */
@Controller
@RequestMapping(value = "/servlet/adminAction/")
public class AdminAction {
	
	private AdminService adminService;
	private BorrowerService borrowerService ;
	private BookService bookService;

	/**
	 * 添加借阅者
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "addBorrower")
	public String addBorrower(AdminVo formbean,HttpServletRequest request,HttpServletResponse response){
			Borrower borrower = new Borrower();
		try {
			//判断是否存在
			Borrower bo =borrowerService.findByAccount(formbean.getAccount());
			//System.out.println(formbean.getAccount()+"----------"+bo);
			if( bo ==null){
				BeanUtils.copyProperties(borrower, formbean);
				borrowerService.save(borrower);
				request.setAttribute("message", "添加读者成功!");
				request.setAttribute("urladdress", "/pages/admin/addreader.jsp");
			}else{
				request.setAttribute("message", "读者账号已存在!");
				request.setAttribute("urladdress", "/pages/admin/addreader.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "message";
	}
	/**
	 * 添加图书
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "addBook")
	public String addBook(AdminVo formbean,HttpServletRequest request,HttpServletResponse response){
		
		Book book = new Book();
		try {
			//查看图书insb是否存在
			Book ob =bookService.findByInsb(formbean.getInsb());
			if( ob !=null){
				request.setAttribute("message", "图书的INSB已存在!");
				request.setAttribute("formbean", formbean);

				return "admin/addbook";
			}else{
				BeanUtils.copyProperties(book, formbean);
				book.setSurplus(book.getSum());
				adminService.addBook(book);
				request.setAttribute("message", "添加图书成功!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加图书失败!");
		}
		request.setAttribute("urladdress", "/pages/admin/addbook.jsp");

		return "message";
	}
	
	/**
	 * 分页查询所有图书
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "listBooks")
	public String listBooks(AdminVo formbean,HttpServletRequest request,HttpServletResponse response){
		
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
		return "admin/booklist";
	}
	/**
	 * 分页查询所有读者
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "listBorrowers")
	public String listBorrowers(AdminVo formbean,HttpServletRequest request,HttpServletResponse response){
		
		PageView<Borrower> pageView = new PageView<Borrower>(formbean.getMaxResult(),formbean.getPage());
		
		QueryResult<Borrower> queryResult= borrowerService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(), null, null, null);
		pageView.setQueryResult(queryResult);
		//System.out.println(formbean.getPage()+"-------------"+queryResult.getResultlist().size());
		request.setAttribute("pageView", pageView);
		request.setAttribute("formbean",formbean);
		return "admin/borrowerlist";
	}
	/**
	 * 根据id删除图书
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "deleteBook")
	public String deleteBook(AdminVo formbean,HttpServletRequest request,HttpServletResponse response){
		
		int bookId = formbean.getId();
		bookService.delete(bookId);
		return "redirect:/servlet/adminAction/listBooks.html";
	}
	
	/**
	 * 取消读者借阅资格
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "disableBorrower")
	public String disableBorrower(AdminVo formbean,HttpServletRequest request,HttpServletResponse response){
		System.out.println("false");
		int id = formbean.getId();
		Borrower bo = borrowerService.find(id);
		if( bo !=null)
		{
			bo.setVisible(false);
			if(!borrowerService.update(bo))
			{
				System.out.println("保存失败！");
			}
		}else{
			System.out.println("读者不存在！");
		}
		return "redirect:/servlet/adminAction/listBorrowers.html?page=1";
	}
	/**
	 * 恢复读者借阅资格
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "enableBorrower")
	public String enableBorrower(AdminVo formbean,HttpServletRequest request,HttpServletResponse response){
		
		int id = formbean.getId();
		Borrower bo = borrowerService.find(id);
		if( bo !=null)
		{
			bo.setVisible(true);
			borrowerService.update(bo);
		}
		return "redirect:/servlet/adminAction/listBorrowers.html?page=1";
	}
	public BorrowerService getBorrowerService() {
		return borrowerService;
	}

	@Resource
	public void setBorrowerService(BorrowerService borrowerService) {
		this.borrowerService = borrowerService;
	}

	public AdminService getAdminService() {
		return adminService;
	}
	@Resource
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public BookService getBookService() {
		return bookService;
	}
	@Resource
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	
	
} 
