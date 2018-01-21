package com.cnu.library.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cnu.library.dao.AdminDao;
import com.cnu.library.dao.BookDao;
import com.cnu.library.model.Admin;
import com.cnu.library.model.Book;
import com.cnu.library.model.base.QueryResult;
import com.cnu.library.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	private AdminDao adminDao;
	private BookDao bookDao;
	
	@Override
	public Admin login(String account, String password) {
		String wherejpql="o.account=? and o.password=?";
		List<Object> params = new ArrayList<Object>();
		params.add(account);
		params.add(password);
		List<Admin> list =adminDao.getAllData(wherejpql,params.toArray());
		if( list !=null&& list.size()>0)
			return list.get(0);
		return null;
	}

	@Override
	public void addBook(Book book) {
		bookDao.save(book);
		
	}
	public AdminDao getAdminDao() {
		return adminDao;
	}
	@Resource
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public BookDao getBookDao() {
		return bookDao;
	}
	@Resource
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}


	
}
