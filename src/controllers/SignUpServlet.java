/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.*;
import entities.*;
import features.MD5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

import javax.servlet.RequestDispatcher;
/**
 *
 * @author HongSon
 */
@WebServlet(name = "SignUpSerlvet", urlPatterns = {"/SignUpSerlvet"})
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("home");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String type = request.getParameter("type");
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = MD5.encrypt(request.getParameter("password"));
        String birthdayS = request.getParameter("birthday");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
        Date birthday = new Date();
        try {
            birthday = formatter.parse(birthdayS);
        } catch (ParseException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        //String avatar = request.getParameter("avatar");
        String activation = "";//MD5.encrypt("" + Math.random());
        List<Users> userList = new UserModel().getByUsername(username);
        if (!userList.isEmpty()) {
            request.setAttribute("message", "Username " + username + " đã tồn tại!");
            request.setAttribute("msgClass", "alert-danger");
        }else {
            Users user = new Users(type, username, email, password, fullname, "", address, "", Integer.MIN_VALUE, Integer.MAX_VALUE, activation);
            boolean isInserted  = new UserModel().add(user);
            if (type.equals("student")) {
                user = new UserModel().getByUsername(username).get(0);
                System.out.println(user);	
                new StudentBasicModel().add(new StudentBasic(user.getId(), birthday , gender, "", 0, "", "", "", ""));
            }
            if (!isInserted) {
                request.setAttribute("message", "Không thể đăng ký. Vui lòng liên hệ với admin!");
                request.setAttribute("msgClass", "alert-danger");
            } else {
                request.setAttribute("message", "Đăng ký thành công! Vui lòng kích hoạt qua địa chỉ email mà bạn đã đăng ký!");
                request.setAttribute("msgClass", "alert-success");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
