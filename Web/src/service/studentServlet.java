package service;

import DAO.studentDAO;
import entity.Student;
import util.DButils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student")
public class studentServlet extends HttpServlet {
    private Connection connection = null;
    private List<Student> list = new ArrayList<>();
    private studentDAO studentdao = new studentDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method =req.getParameter("method");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double score = Double.parseDouble(req.getParameter("score"));
        switch (method){
            case "add":
                studentdao.add(id,name,score);
                break;
            case "update":
                studentdao.update(id,name,score);
                break;
        }
        resp.sendRedirect("/student");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method==null)method="findAll";
        switch (method) {
            case "findAll":
                list = studentdao.findAll();
                req.setAttribute("list", list);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "findById":
                int id = Integer.parseInt(req.getParameter("id"));
                Student stu = studentdao.findById(id);
                req.setAttribute("student",stu);
                req.getRequestDispatcher("update.jsp").forward(req,resp);
                break;
            case "delete":
                id = Integer.parseInt(req.getParameter("id"));
                studentdao.delete(id);
                resp.sendRedirect("/student");
        }
    }
}
