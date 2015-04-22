package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import models.*;
import entities.*;
import features.MD5;

import java.util.Date;
import java.util.List;

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
        int lastLogin = (int)(new Date().getTime()/1000);
        int lastActivity = lastLogin;
        List<Users> userList = new UserModel().getByUsername(username);
        Users user = null;
        if (!userList.isEmpty() && (user = userList.get(0)).getPassword().equals(password)) {
            if ("".equals(user.getActivation())) { // Kiem tra tai khoan da duoc kich hoat hay chua
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("home");
            } else {
                request.setAttribute("message", "Tài khoản bạn vừa đăng nhập hiện chưa được kích hoạt");
                request.setAttribute("msgClass", "alert-danger");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("message", "Tài khoản bạn vừa đăng nhập không tồn tại");
            request.setAttribute("msgClass", "alert-danger");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        
    }
}
