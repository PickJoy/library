package com.cnu.library.action;

import com.cnu.library.model.Book;
import com.cnu.library.service.BookService;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by dell on 2016/1/22.
 */
@Controller
@RequestMapping("/book/")
public class BookManagerAction {

    private BookService bookService ;
   @RequestMapping("find")
    public ModelAndView findBook( String name){
       ModelAndView mv = new ModelAndView("right");

       Book book = bookService.findByName(name);
       mv.addObject("book",book);
       if( book !=null)
           System.out.println("---------"+book.getName());
       else
           System.out.println(name+"---------");
       return mv;
    }
    @RequestMapping("book")
    public String find(Model model, String name){
        Book book = bookService.findByName(name);

        model.addAttribute("book",book);
        if( book !=null)
            System.out.println("---------"+book.getName());
        else
            System.out.println(name+"---------");
        return "right";
    }
    public BookService getBookService() {
        return bookService;
    }
    @Resource
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
