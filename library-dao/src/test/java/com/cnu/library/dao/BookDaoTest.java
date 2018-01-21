package com.cnu.library.dao;

import com.cnu.library.model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2016/1/21.
 */
public class BookDaoTest {

    public  static  void main(String[] args){
        ApplicationContext context =new ClassPathXmlApplicationContext(new String[] { "spring-dao.xml"});
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        Book book = new Book();
        book.setInsb("123");
        book.setName("maven");
        book.setSum(5);
        book.setSurplus(5);
        try{
            bookDao.save(book);
        }catch (Exception e){
            e.printStackTrace();
        }
        //   bookService.saveBook(book);
        // bookService.findBookById("zhangsan");
    }
}
