package com.cnu.library.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cnu.library.dao.BookDao;
import com.cnu.library.dao.SaveBookDao;
import com.cnu.library.model.Book;
import com.cnu.library.model.SaveBook;
import com.cnu.library.model.base.QueryResult;
import com.cnu.library.service.SaveBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("saveBookService")
@Transactional
public class SaveBookServiceImpl implements SaveBookService {
	private SaveBookDao saveBookDao;
	private BookDao bookDao;
	public SaveBookDao getSaveBookDao() {
		return saveBookDao;
	}
	@Resource
	public void setSaveBookDao(SaveBookDao saveBookDao) {
		this.saveBookDao = saveBookDao;
	}

	@Override
	public SaveBook find(String id) {
		// TODO Auto-generated method stub
		return saveBookDao.find(id);
	}

	@Override
	public QueryResult<SaveBook> getScrollData(int currentpage, int maxresult) {
		// TODO Auto-generated method stub
		return saveBookDao.getScrollData(currentpage, maxresult);
	}

	public BookDao getBookDao() {
		return bookDao;
	}
	@Resource
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public QueryResult<Book> getSaveBook(int currentpage, int maxresult) {
		// TODO Auto-generated method stub
		QueryResult<SaveBook> saves= saveBookDao.getScrollData(currentpage, maxresult);
		List<Book> books = null;

		QueryResult<Book> qr = new QueryResult<Book>();
		if( saves!=null && saves.getResultlist()!=null && saves.getResultlist().size()>0)
		{
			StringBuilder stb =new StringBuilder(" o.id in ( ");
			List<Object> queryParams= new ArrayList<Object>();
			List<SaveBook> listSaveBooks= saves.getResultlist();
			for( SaveBook sb : listSaveBooks){
				queryParams.add(sb.getBookId());
				stb.append("?,");
			}
			stb.deleteCharAt(stb.toString().length()-1);
			stb.append(" )");
			
			books= bookDao.getAllData(stb.toString(), queryParams.toArray());
			
		}
		qr.setResultlist(books);
		 if( saves!=null)
		   qr.setTotalrecord(saves.getTotalrecord());
		 else
			qr.setTotalrecord(0);
		 
		return qr;
	}

	@Override
	public SaveBook findByBookIdAndBorrowerId(int bookId, int borrowerId) {
		// TODO Auto-generated method stub
		String wherejpql=" o.bookId=? and o.borrowerId=? ";
		List<Object> queryParams= new ArrayList<Object>();
		queryParams.add(bookId);
		queryParams.add(borrowerId);
		List<SaveBook> list= saveBookDao.getAllData(wherejpql, queryParams.toArray());
		if( list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
}
