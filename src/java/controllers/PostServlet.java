/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.*;
import java.util.Date;
import javax.servlet.http.HttpSession;
import models.*;
/**
 *
 * @author HongSon
 */
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if(action.equals("add")){
            String content = request.getParameter("content");
            Users user = (Users)session.getAttribute("user");
            if(user.getType().equals("student")){
                StudentPostModel spm = new StudentPostModel();
                spm.add(new StudentPosts(user.getId(), content, new Date()));
                out.write(content);
            }else{
                //if type is company
            }
        }
    }
        
}
