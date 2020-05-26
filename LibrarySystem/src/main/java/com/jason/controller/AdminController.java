package com.jason.controller;

import com.jason.entity.Admin;
import com.jason.entity.Borrow;
import com.jason.service.BookService;
import com.jason.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController{
    @Autowired
    private BookService bookService;

    @Autowired
    private ModelAndView modelAndView;

    @RequestMapping("/findBorrowByState")
    public ModelAndView findBorrowByState(@RequestParam(defaultValue = "1") Integer page){
        List<Borrow> borrows = bookService.findBorrowByState(page,0);
        int pages = bookService.getBorrowPagesByState(0);
        modelAndView.addObject("pages",pages);
        modelAndView.addObject("currentPage",page);
        modelAndView.addObject("dataPerPage",BookServiceImpl.LIMIT);
        modelAndView.addObject("list",borrows);
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @RequestMapping("/handle")
    public String handle(Integer id,Integer state,HttpSession session) {
        Admin admin = (Admin)session.getAttribute("user");
        bookService.handleBorrow(id,admin.getId(),state);
        return "redirect:/admin/findBorrowByState";
    }

    @RequestMapping("/getBorrowed")
    public ModelAndView getBorrowed(@RequestParam(defaultValue = "1") Integer page) {
        int pages = bookService.getBorrowPagesByState(1);
        List<Borrow> borrows = bookService.findBorrowByState(page, 1);
        modelAndView.addObject("pages", pages);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("dataPerPage", BookServiceImpl.LIMIT);
        modelAndView.addObject("list", borrows);
        modelAndView.setViewName("return");
        return modelAndView;
    }
}
