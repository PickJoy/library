package com.cnu.library.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import com.cnu.library.dao.SaveBookDao;
import com.cnu.library.dao.base.DaoSupport;
import com.cnu.library.model.SaveBook;
import com.cnu.library.model.base.QueryResult;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository("saveBookDao")
public class SaveBookDaoImpl extends DaoSupport<SaveBook> implements
		SaveBookDao {

	@Override
	public boolean deleteByBookIdAndBorrowerId(final int bookId, final int borrowerId) {
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>() {
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
				Query query= session.createQuery("delete from SaveBook where bookId=? and borrowerId=?");
				query.setParameter(0,bookId);
				query.setParameter(1,borrowerId);
				int count =query.executeUpdate();
				return count ==0 ? false:true;
			}
		});
	}

}
