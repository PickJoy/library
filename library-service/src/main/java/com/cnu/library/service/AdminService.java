package com.cnu.library.service;

import com.cnu.library.model.Admin;
import com.cnu.library.model.Book;

public interface AdminService {

	public Admin login(String account, String password);
	public void addBook(Book book);
}
