package com.cnu.library.service.impl;

import com.cnu.library.dao.BookDao;
import com.cnu.library.dao.BorrowerDao;
import com.cnu.library.dao.ReservationDao;
import com.cnu.library.dao.SaveBookDao;
import com.cnu.library.model.Book;
import com.cnu.library.model.Borrower;
import com.cnu.library.model.SaveBook;
import com.cnu.library.service.BorrowerManageService;
import com.cnu.library.service.ReservationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("borrowerManageService")
@Transactional
public class BorrowerManageServiceImpl implements BorrowerManageService {
	private ReservationDao reservationDao;
	private BorrowerDao borrowerDao;
	private SaveBookDao saveBookDao;
	private BookDao bookDao;
	
	/**
	 * 方法具有事务属性
	 */
	@Override
	public boolean updateBorrowerBook(SaveBook saveBook, Book book,
			Borrower borrower) {
		if(borrowerDao.update(borrower)&&bookDao.update(book)){
			saveBookDao.save(saveBook);
			return true;
		}
		else
			return false;
	}
	@Override
	public boolean returnBook(Book book, Borrower borrower) {
		// TODO Auto-generated method stub
		if(borrowerDao.update(borrower)&&bookDao.update(book))
		{	   
			//删除借书
			return saveBookDao.deleteByBookIdAndBorrowerId(book.getId(),borrower.getId());
			
		}else
			return false;
		
	}
	public ReservationDao getReservationDao() {
		return reservationDao;
	}
	@Resource
	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}
	public BorrowerDao getBorrowerDao() {
		return borrowerDao;
	}
	@Resource
	public void setBorrowerDao(BorrowerDao borrowerDao) {
		this.borrowerDao = borrowerDao;
	}
	public SaveBookDao getSaveBookDao() {
		return saveBookDao;
	}
	@Resource
	public void setSaveBookDao(SaveBookDao saveBookDao) {
		this.saveBookDao = saveBookDao;
	}
	
	public BookDao getBookDao() {
		return bookDao;
	}
	@Resource
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	

}
