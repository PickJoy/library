package com.cnu.library.dao;

import com.cnu.library.dao.base.DAO;
import com.cnu.library.model.Borrower;

public interface BorrowerDao extends DAO<Borrower> {
	/**
	 * 根据账号查找用户
	 * @param account
	 * @return
	 */
	public Borrower findByAccount(String account);
}
