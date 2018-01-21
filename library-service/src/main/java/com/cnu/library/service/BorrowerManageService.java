package com.cnu.library.service;

import com.cnu.library.model.Book;
import com.cnu.library.model.Borrower;
import com.cnu.library.model.SaveBook;

public interface BorrowerManageService {
	
	/**
	 * 更新数据
	 * @param saveBook
	 * @param book
	 * @param borrower
	 * @return
	 */
	public boolean updateBorrowerBook(SaveBook saveBook, Book book, Borrower borrower);
	/**
	 * 还书
	 * @param book
	 * @param borrower
	 */
	public boolean returnBook(Book book, Borrower borrower);
}
