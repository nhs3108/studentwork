package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = MD5.encrypt(request.getParameter("password"));
        System.out.print(username + " " + password);
        // **************** Sua lai sau *****************
        int lastLogin = 0;
        int lastActivity = 0;
        System.out.println(username);
        System.out.println(password);
        //********************
        ArrayList<User> userList = User.getUsers("username", username);
        User user = null;
        if (userList.size() != 0 && (user = userList.get(0)).getPassword().equals(password)) {
            if (user.getPassword() == null || user.getActivation() == "") { // Kiem tra tai khoan da duoc kich hoat hay chua
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("home");
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                request.setAttribute("message", "Tài khoản bạn vừa đăng nhập hiện chưa được kích hoạt");
                request.setAttribute("msgClass", "alert-danger");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("message", "Tài khoản bạn vừa đăng nhập không tồn tại");
            request.setAttribute("msgClass", "alert-danger");
            dispatcher.forward(request, response);
        }
    }
}
