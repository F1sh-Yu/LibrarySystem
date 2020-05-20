package controller;

import dao.BookDao;
import dao.BorrowDao;
import dao.impl.BookDaoImpl;
import entity.Book;
import entity.Borrow;
import entity.Reader;
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

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method==null)method="findAll";
        HttpSession session = req.getSession();
        Reader reader = (Reader)session.getAttribute("user");
        switch (method){
            case "findAll":
                String spage = req.getParameter("page");
                int page=1;
                if(spage!=null)page=Integer.parseInt(spage);
                List<Book>list = bookService.findAll(page);
                int pages = bookService.getPages();
                req.setAttribute("list",list);
                req.setAttribute("dataPerPage",BookServiceImpl.LIMIT);
                req.setAttribute("pages",pages);
                req.setAttribute("currentPage",page);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                break;
            case "addBorrow":
                int bookid = Integer.parseInt(req.getParameter("bookid"));
                bookService.addBorrow(bookid,reader.getId());
                resp.sendRedirect("/book?method=findAllBorrow&page=1");
                break;
            case "findAllBorrow":
                spage = req.getParameter("page");
                page=1;
                if(spage!=null)page=Integer.parseInt(spage);
                List<Borrow> borrows = bookService.findAllByReaderId(reader.getId(),page);
                pages = bookService.getBorrowPages(reader.getId());
                req.setAttribute("list",borrows);
                req.setAttribute("pages",pages);
                req.setAttribute("currentPage",page);
                req.setAttribute("dataPerPage",BookServiceImpl.LIMIT);
                req.getRequestDispatcher("borrow.jsp").forward(req,resp);
        }
    }
}
