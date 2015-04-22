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
import javax.servlet.http.HttpSession;

import entities.StudentSkills;
import entities.StudentVolunteers;
import entities.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.StudentVolunteerModel;

/**
 *
 * @author HongSon
 */
public class VolunteerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.sendRedirect(request.getHeader("referer")); 
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
        Users user = (Users) session.getAttribute("user");
        if (user.getType().equals("company")) {
            String referer = request.getHeader("Referer");
            response.sendRedirect(request.getHeader("referer"));
        }
        switch (action) {
            case "add":
                {
                    String organization = request.getParameter("organization");
                    String role = request.getParameter("role");
                    String cause = request.getParameter("cause");
                    Date startTime = null;
                    Date finishTime = null;
                    try {
                    	startTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startTime"));
                    	finishTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("finishTime"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
                    int isNow = Integer.parseInt(request.getParameter("isNow"));
                    String more = request.getParameter("more");
                    StudentVolunteerModel svm = new StudentVolunteerModel();
                    svm.add(new StudentVolunteers(user.getId(), organization, role, cause, startTime, finishTime, isNow, more));
                    out.write(organization);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "update":
                {
                    String id = request.getParameter("id");                    
                    String organization = request.getParameter("organization");
                    String role = request.getParameter("role");
                    String cause = request.getParameter("cause");
                    Date startTime = null;
                    Date finishTime = null;
                    try {
                    	startTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startTime"));
                    	finishTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("finishTime"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
                    int isNow = Integer.parseInt(request.getParameter("isNow"));
                    String more = request.getParameter("more");
                    StudentVolunteerModel svm = new StudentVolunteerModel();
                    StudentVolunteers sv = svm.getById(Integer.parseInt(id));
                    
                    sv.setOrganization(organization);
                    sv.setRole(role);
                    sv.setCause(cause);
                    sv.setStartTime(startTime);
                    sv.setFinishTime(finishTime);
                    sv.setId(isNow);
                    sv.setMore(more);
                    svm.add(sv);
                    out.write("Change " + organization + " id=" + id);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "del":
                out.write("Xoa");
                String[] idArray = request.getParameterValues("id");
                for (String id : idArray) {
                    StudentVolunteerModel svm = new StudentVolunteerModel();
                    StudentVolunteers sv = svm.getById(Integer.parseInt(id));
                    svm.delete(sv);
                    out.write("Đã xóa id "+id);
                    //response.sendRedirect(request.getHeader("referer"));
                }   break;
            case "view":
                out.write("Đây là action View");
                break;
        }
    }
}
