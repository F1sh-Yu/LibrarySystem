package com.jason.controller;


import com.jason.entity.Admin;
import com.jason.entity.Reader;
import com.jason.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public ModelAndView login(String username, String password, String type, HttpSession session) {
        Object user = loginService.login(username, password, type);
        ModelAndView modelAndView = new ModelAndView();
        switch (type) {
            case "reader":
                Reader reader = (Reader) user;
                modelAndView.addObject("user", reader);
                modelAndView.setViewName("redirect:book/findAll");
                session.setAttribute("user", reader);
                return modelAndView;
            case "admin":
                Admin admin = (Admin) user;
                modelAndView.addObject("user", admin);
                session.setAttribute("user", admin);
                modelAndView.setViewName("redirect:admin/findBorrowByState");
                return modelAndView;
            default:
                modelAndView.setViewName("login");
                return modelAndView;
        }
    }
}
