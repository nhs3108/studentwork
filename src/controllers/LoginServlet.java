package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

import models.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("home");
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = MD5.encrypt(request.getParameter("password"));
        // **************** Sua lai sau *****************
        String lastLogin = null;
        String lastActivity = null;
        System.out.println(username);
        System.out.println(password);
        //********************
        Object user = null;
        if((Student.getStudents("username", username)).size()!=0){
        	user = Student.getStudents("username",username).get(0);
        	HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("home");
        }else if(Company.getCompanies("username", username).size() != 0){
        	user = Company.getCompanies("username",username).get(0);
        	HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("home");
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("message", "Tài khoản bạn vừa đăng nhập không tồn tại");
            request.setAttribute("msgClass", "alert-danger");
            dispatcher.forward(request, response);
        }
    }
}
