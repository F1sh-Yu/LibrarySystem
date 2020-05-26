package com.jason.controller;
import com.jason.entity.Book;
import com.jason.entity.Borrow;
import com.jason.entity.Reader;
import com.jason.service.BookService;
import com.jason.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController{
    @Autowired
    private BookService bookService;
    @Autowired
    private ModelAndView modelAndView;

    @RequestMapping("/findAll")
    public ModelAndView findAll(HttpSession session, @RequestParam(defaultValue = "1") Integer page) {
        Reader reader = (Reader) session.getAttribute("user");
        List<Book> list = bookService.findAll(page);
        int pages = bookService.getPages();
        modelAndView.addObject("list", list);
        modelAndView.addObject("dataPerPage", BookServiceImpl.LIMIT);
        modelAndView.addObject("pages", pages);
        modelAndView.addObject("currentPage", page);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/addBorrow")
    public ModelAndView addBorrow(Integer bookid,HttpSession session){
        bookService.addBorrow(bookid,((Reader)session.getAttribute("user")).getId());
        modelAndView.setViewName("redirect:findAllBorrow");
        return modelAndView;
    }

    @RequestMapping("/findAllBorrow")
    public ModelAndView findAllBorrow(HttpSession session,@RequestParam(defaultValue = "1") Integer page){
        Reader reader = (Reader)session.getAttribute("user");
        List<Borrow> borrows = bookService.findAllByReaderId(reader.getId(),page);
        int pages = bookService.getBorrowPages(reader.getId());
        modelAndView.addObject("list",borrows);
        modelAndView.addObject("pages",pages);
        modelAndView.addObject("currentPage",page);
        modelAndView.addObject("dataPerPage",BookServiceImpl.LIMIT);
        modelAndView.setViewName("borrow");
        return modelAndView;
    }
}
