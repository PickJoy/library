package com.cnu.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cnu.library.dao.BorrowerDao;
import com.cnu.library.dao.base.DaoSupport;
import com.cnu.library.model.Borrower;
import org.springframework.stereotype.Repository;

@Repository("borrowerDao")
public class BorrowerDaoImpl extends DaoSupport<Borrower> implements BorrowerDao{

	@Override
	public Borrower findByAccount(String account) {
		List<Borrower> list= getHibernateTemplate().find("from  Borrower where account =? ",account);
		return (list==null || list.size()==0)?null:list.get(0);
	}

}
