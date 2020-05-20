package controller;

import entity.Admin;
import entity.Borrow;
import service.BookService;
import service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method==null)method="findBorrowByState";
        HttpSession session = req.getSession();
        Admin admin = (Admin)session.getAttribute("user");
        int page=1;
        if(req.getParameter("page")!=null)page=Integer.parseInt(req.getParameter("page"));
        switch (method){
            case "findBorrowByState":
                List<Borrow> borrows = bookService.findBorrowByState(page,0);
                int pages = bookService.getBorrowPagesByState(0);
                req.setAttribute("pages",pages);
                req.setAttribute("currentPage",page);
                req.setAttribute("dataPerPage",BookServiceImpl.LIMIT);
                req.setAttribute("list",borrows);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
                break;
            case "handle":
                int id = Integer.parseInt(req.getParameter("id"));
                int state = Integer.parseInt(req.getParameter("state"));
                bookService.handleBorrow(id,admin.getId(),state);
                resp.sendRedirect("/admin");
                break;
            case "getBorrowed":
                pages = bookService.getBorrowPagesByState(1);
                borrows = bookService.findBorrowByState(page,1);
                req.setAttribute("pages",pages);
                req.setAttribute("currentPage",page);
                req.setAttribute("dataPerPage",BookServiceImpl.LIMIT);
                req.setAttribute("list",borrows);
                req.getRequestDispatcher("return.jsp").forward(req,resp);
        }
    }
}
