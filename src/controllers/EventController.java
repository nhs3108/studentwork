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
public class EventController extends HttpServlet {

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
                    String event = request.getParameter("event");
                    String place = request.getParameter("place");
                    Date time = null;
					try {
						time = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("time"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
                    String more = request.getParameter("more");
                    StudentEventModel sem = new StudentEventModel();
                    sem.add(new StudentEvents(user.getId(), event, place, time, more));
                    out.write(event + " " + time);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "update":
                {
                    String id = request.getParameter("id");
                    String event = request.getParameter("event");
                    String place = request.getParameter("place");
                    Date time = null;
					try {
						time = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("time"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
                    String more = request.getParameter("more");
                    StudentEventModel sem = new StudentEventModel();
                    StudentEvents se = sem.getById(Integer.parseInt(id));
                    se.setEvent(event);
                    se.setPlace(place);
                    se.setTime(time);
                    se.setMore(more);
                    sem.add(se);
                    out.write("Change " + event + " id=" + id);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "del":
                out.write("Xoa");
                String[] idArray = request.getParameterValues("id");
                for (String id : idArray) {
                    StudentEventModel sem = new StudentEventModel();
                    StudentEvents se = sem.getById(Integer.parseInt(id));
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
