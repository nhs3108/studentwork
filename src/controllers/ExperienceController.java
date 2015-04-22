/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.*;
import entities.*;

/**
 *
 * @author HongSon
 */
public class ExperienceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getHeader("referer")); 
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
        Users user = (Users) session.getAttribute("user");
        if (user.getType().equals("company")) {
            String referer = request.getHeader("Referer");
            response.sendRedirect(request.getHeader("referer"));
        }
        switch (action) {
            case "add":
                {
                    String company = request.getParameter("company");
                    String title = request.getParameter("title");
                    Date startTime = null;
                    Date finishTime = null;
                    try {
                    	startTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startTime"));
                    	finishTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("finishTime"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
                    String more = request.getParameter("more");
                    StudentExperienceModel sem = new StudentExperienceModel();
                    sem.add(new StudentExp(user.getId(), company, title, startTime, finishTime, more));
                    out.write(company + " " + startTime);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "update":
                {
                    String id = request.getParameter("id");
                    String company = request.getParameter("company");
                    String title = request.getParameter("title");
                    Date startTime = null;
                    Date finishTime = null;
                    try {
                    	startTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startTime"));
                    	finishTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("finishTime"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
                    String more = request.getParameter("more");
                    StudentExperienceModel sem = new StudentExperienceModel();
                    StudentExp se = sem.getById(Integer.parseInt(id));
                    se.setCompany(company);
                    se.setTitle(title);
                    se.setStartTime(startTime);
                    se.setFinishTime(finishTime);
                    se.setMore(more);
                    sem.add(se);
                    out.write("Change " + company + " id=" + id);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "del":
                out.write("Xoa");
                String[] idArray = request.getParameterValues("id");
                for (String id : idArray) {
                    StudentExperienceModel sem = new StudentExperienceModel();
                    StudentExp se = sem.getById(Integer.parseInt(id));
                    sem.delete(se);
                    out.write("Đã xóa id "+id);
                }   
                //response.sendRedirect(request.getHeader("referer"));
                break;
            case "view":
                out.write("Đây là action View");
                break;
        }
    }
}
