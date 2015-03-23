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
import entities.*;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import models.*;
/**
 *
 * @author HongSon
 */
@WebServlet(name = "FeedbackController", urlPatterns = {"/feedback"})
public class FeedbackController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if(action.equals("del")){
            String[] idArray = request.getParameterValues("id");
            for(String id : idArray){
                FeedbackModel fbm = new FeedbackModel();
                Feedbacks fb = fbm.getById(Integer.parseInt(id));
                fbm.delete(fb);
            }
        }else if(action.equals("add")){
            Users user = (Users)session.getAttribute("user");
            int minLenght = Integer.parseInt(this.getServletContext().getInitParameter("minLenghtFeedback"));
            String content = request.getParameter("content");
            if (content.length() < minLenght) {
                request.setAttribute("message", "Bài viết quá ngắn! Vui lòng thử lại với tối tiểu " + minLenght);
                request.setAttribute("msgClass", "alert-danger");
            } else {
                FeedbackModel fm = new FeedbackModel();
                fm.add(new Feedbacks(user.getId(), content, new Date()));
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("contactus");
            dispatcher.forward(request, response);
        }
    }
}
