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
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import models.*;
/**
 *
 * @author HongSon
 */
public class PostController extends HttpServlet {
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
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Users user = (Users)session.getAttribute("user");
        switch (action) {
            case "add":
                {
                    String contentUnSafe = request.getParameter("content");
                    String content = Jsoup.clean(contentUnSafe, Whitelist.basic());
                    if(user.getType().equals("student")){
                        StudentPostModel spm = new StudentPostModel();
                        spm.add(new StudentPosts(user.getId(), content, new Date(),0,0,0));
                        out.write(content);
                        //response.sendRedirect(request.getHeader("referer"));
                    }else{
                        //if type is company
                    }       
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
                
            case "update":
            {
                String id = request.getParameter("id");
                String content = request.getParameter("content");
                if(user.getType().equals("student")){
                    StudentPostModel spm = new StudentPostModel();
                    StudentPosts sp = spm.getById(Integer.parseInt(id));
                    sp.setContent(content); //Change content
                    sp.setTime(new Date()); //Change time
                    spm.add(sp);
                    out.write(content);
                }else{
                    //if type is company
                }       
                response.sendRedirect(request.getHeader("referer"));
                break;
            }
            case "del":
                out.write("Vai ca loz");
                if(user.getType().equals("student")){
                    String[] idArray = request.getParameterValues("id");
                    for(String id : idArray){
                        StudentPostModel spm = new StudentPostModel();
                        StudentPosts fb = spm.getById(Integer.parseInt(id));
                        spm.delete(fb);
                        out.write("Đã xóa");
                    }
                }else{
                    //if type is company
                }   
                response.sendRedirect(request.getHeader("referer"));
                //break;
            case "view":
                out.write("Vai ca lozxxxxxxxxxxxxx");
                List<StudentAwards> spl = new StudentAwardModel().getAll();
                for(StudentAwards sp : spl){
                out.write("<font color=red>"+ sp.getAward()+ "</font");
            }   break;
        }
    }
        
}
