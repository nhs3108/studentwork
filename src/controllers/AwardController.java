/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.StudentAwards;
import entities.StudentPosts;
import entities.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.StudentAwardModel;
import models.StudentPostModel;

/**
 *
 * @author HongSon
 */
public class AwardController extends HttpServlet {

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
                    String award = request.getParameter("award");
                    int year = Integer.parseInt(request.getParameter("year"));
                    String more = request.getParameter("more");
                    StudentAwardModel sam = new StudentAwardModel();
                    sam.add(new StudentAwards(user.getId(), award, year, more));
                    out.write(award + " " + year);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "update":
                {
                    String id = request.getParameter("id");
                    String award = request.getParameter("award");
                    int year = Integer.parseInt(request.getParameter("year"));
                    String more = request.getParameter("more");
                    StudentAwardModel sam = new StudentAwardModel();
                    StudentAwards sa = sam.getById(Integer.parseInt(id));
                    sa.setAward(award);
                    sa.setYear(year); //Change content
                    sa.setMore(more); //Change time
                    sam.add(sa);
                    out.write("Change " + award + " id=" + id);
                    response.sendRedirect(request.getHeader("referer"));;
                }
            case "del":
                out.write("Vai ca loz");
                String[] idArray = request.getParameterValues("id");
                for (String id : idArray) {
                    StudentAwardModel sam = new StudentAwardModel();
                    StudentAwards sa = sam.getById(Integer.parseInt(id));
                    sam.delete(sa);
                    out.write("Đã xóa");
                }   
                response.sendRedirect(request.getHeader("referer"));
                //break;
            case "view":
                out.write("Đây là action View");
                break;
        }
    }
}
