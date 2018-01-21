package com.cnu.library.service;

import com.cnu.library.model.Book;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/1/20.
 */

public class BookServiceTest {

    public  static  void main(String[] args){
        ApplicationContext context =new ClassPathXmlApplicationContext(new String[] { "spring-service.xml", "spring-dao.xml"});
        BookService bookService = (BookService) context.getBean("bookService");

        addBook( bookService);

       /* Book book =find(bookService,"ss");
        if(book !=null)
           System.out.println(book.getId()+":"+book.getName());*/
    }

    private static Book find( BookService bookService,String ss) {
       Book book= bookService.findByName(ss);
        return book;
    }

    public static   void addBook( BookService bookService){
        Book b1 = new Book(2,"zhou","23",23);
        Book b3 = new Book(2,"liang","23",23);
        Book b4 = new Book(2,"oo","23",23);

        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b3);
        books.add(b4);

        // bookService.findBookById("zhangsan");
    }
}
