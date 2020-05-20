package controller;

import entity.Admin;
import entity.Reader;
//import service.LoginService;
//import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
//    private LoginService loginService = new LoginServiceImpl();

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String type = req.getParameter("type");
//        Object user = loginService.login(username,password,type);
//        if(user!=null){
//            HttpSession session = req.getSession();
//            switch (type) {
//                case "reader":
//                    Reader reader = (Reader) user;
//                    session.setAttribute("user", reader);
//                    break;
//                case "admin":
//                    Admin admin = (Admin) user;
//                    session.setAttribute("user", admin);
//                    break;
//            }
//            req.getRequestDispatcher("/book").forward(req,resp);
//        }else resp.sendRedirect("/login.jsp");
    }
}
