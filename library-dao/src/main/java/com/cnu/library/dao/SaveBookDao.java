package com.cnu.library.dao;

import com.cnu.library.dao.base.DAO;
import com.cnu.library.model.SaveBook;

public interface SaveBookDao extends DAO<SaveBook> {
	/**
	 * 删除借书记录
	 * @param bookId
	 * @param borrowerId
	 */
	public boolean deleteByBookIdAndBorrowerId(int bookId, int borrowerId);

}
