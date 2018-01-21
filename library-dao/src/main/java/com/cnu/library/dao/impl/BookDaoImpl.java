package com.cnu.library.dao.impl;

import com.cnu.library.dao.BookDao;
import com.cnu.library.dao.base.DaoSupport;
import com.cnu.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 2016/1/20.
 */
@Repository("bookDao")
public class BookDaoImpl extends DaoSupport<Book> implements BookDao {


    public Book findByName(String name) {
        List<Book> list=  getHibernateTemplate().find("from Book o where  o.name=?",name);
        return  (list==null||list.size()==0)?null:(list.get(0));
    }
   /* private HibernateTemplate hibernateTemplate;

    private SessionFactory sessionFactory;

    public void add(Book book) {

       //Session session= sessionFactory.openSession();
       // Session session= sessionFactory.getCurrentSession();//从当前
       // session.save(book);
        getHibernateTemplate().save(book);
    }

    @Override
    public Book find(String id) {
        return  hibernateTemplate.get(Book.class,id);
    }

    @Override
    public Book findByName(String name) {
        List<Book> list=  getHibernateTemplate().find("from Book o where  o.name=?",name);
        return  (list==null||list.size()==0)?null:(list.get(0));
    }

     public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
   @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/
}
