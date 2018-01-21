package com.cnu.library.service.impl;

import com.cnu.library.dao.BookDao;
import com.cnu.library.model.Book;
import com.cnu.library.model.base.QueryResult;
import com.cnu.library.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by dell on 2016/1/20.
 */
@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    @Override
    public Book findByName(String name) {
        return bookDao.findByName(name);
    }

    @Override
    public void save(Book entity) {
        // TODO Auto-generated method stub
        bookDao.save(entity);
    }

    @Override
    public Book find(Serializable key) {
        // TODO Auto-generated method stub
        return bookDao.find(key);
    }

    @Override
    public boolean update(Book entity) {
        // TODO Auto-generated method stub
        return bookDao.update(entity);
    }

    @Override
    public void delete(Serializable... entityids) {
        // TODO Auto-generated method stub
        bookDao.delete(entityids);
    }

    @Override
    public QueryResult<Book> getScrollData(int page, int maxresult,
                                           String wherejpql, Object[] queryParams,
                                           LinkedHashMap<String, String> orderby) {
        return bookDao.getScrollData(page, maxresult, wherejpql, queryParams);
    }

    public BookDao getBookDao() {
        return bookDao;
    }
    @Resource
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book findByInsb(String insb) {
        // TODO Auto-generated method stub
        String wherejpql="o.insb=?";

        List<Object> queryParams= new ArrayList<Object>();
        queryParams.add(insb);
        List<Book> books= bookDao.getAllData(wherejpql, queryParams.toArray());
        if( books !=null && books.size()>0)
            return books.get(0);
        return null;
    }
}
