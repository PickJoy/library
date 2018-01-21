package com.cnu.library.service;

import com.cnu.library.model.Book;
import com.cnu.library.model.SaveBook;
import com.cnu.library.model.base.QueryResult;

public interface SaveBookService {
	/**
	 * 根据id查找借书记录
	 * @param id
	 * @return
	 */
	public SaveBook find(String id);
	/**
	 * 分页查询已借图书
	 * @param currentpage
	 * @param maxresult
	 * @return
	 */
	public QueryResult<SaveBook> getScrollData(int currentpage, int maxresult);
	/**
	 * 查看已借图书
	 * @param currentpage
	 * @param maxresult
	 * @return
	 */
	public QueryResult<Book> getSaveBook(int currentpage, int maxresult);
	/**
	 * 查看已借图书
	 * @param bookId
	 * @param borrowerId
	 * @return
	 */
	public SaveBook findByBookIdAndBorrowerId(int bookId, int borrowerId);
	
}
