package com.cnu.library.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.cnu.library.dao.BorrowerDao;
import com.cnu.library.dao.impl.BorrowerDaoImpl;
import com.cnu.library.model.Borrower;
import com.cnu.library.model.base.QueryResult;
import com.cnu.library.service.BorrowerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("borrowerService")
@Transactional
public class BorrowerServiceImpl implements BorrowerService {
	private BorrowerDao borrowerDao;
	/**
	 * 通过账号查找用户
	 */
	@Override
	public Borrower findByAccount(String account) {
		
		return borrowerDao.findByAccount(account);
	}
	
	@Override
	public Borrower find(int id) {
		return borrowerDao.find(id);
	}
	
	@Override
	public boolean update(Borrower borrower) {
		// TODO Auto-generated method stub
		return borrowerDao.update(borrower);
	}
	@Override
	public void save(Borrower borrower) {
		// TODO Auto-generated method stub
		borrowerDao.save(borrower);
	}


	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return borrowerDao.getCount();
	}

	@Override
	public QueryResult<Borrower> getScrollData(int page, int maxresult,
			String wherejpql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return borrowerDao.getScrollData(page, maxresult, wherejpql, queryParams, orderby);
	}


	public BorrowerDao getBorrowerDao() {
		return borrowerDao;
	}
	@Resource
	public void setBorrowerDao(BorrowerDao borrowerDao) {
		this.borrowerDao = borrowerDao;
	}

	@Override
	public void makeVisible(String id, boolean visible) {
		// TODO Auto-generated method stub
		Borrower bor =borrowerDao.find(id);
		if( bor !=null){
			bor.setVisible(visible);
			borrowerDao.update(bor);
		}
	}

	@Override
	public Borrower login(String account, String password) {
		String wherejpql="o.account=? and o.password=?";
		List<Object> params = new ArrayList<Object>();
		params.add(account);
		params.add(password);
		List<Borrower> list = borrowerDao.getAllData(wherejpql, params.toArray());
		if( list !=null && list.size()>0)
			return list.get(0);
		return null;
	}

}
