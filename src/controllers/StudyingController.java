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
import entities.StudentStudyings;
import entities.Users;
import models.StudentStudyModel;

/**
 *
 * @author HongSon
 */
public class StudyingController extends HttpServlet {

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
                    String className = request.getParameter("className");
                    float score = Float.parseFloat(request.getParameter("score"));
                    String conduct = request.getParameter("conduct");
                    StudentStudyModel ssm = new StudentStudyModel();
                    ssm.add(new StudentStudyings(user.getId(), className, score, conduct));
                    out.write(className);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "update":
                {
                    String id = request.getParameter("id");
                    String className = request.getParameter("className");
                    float score = Float.parseFloat(request.getParameter("score"));
                    String conduct = request.getParameter("conduct");
                    StudentStudyModel ssm = new StudentStudyModel();
                    StudentStudyings ss = ssm.getById(Integer.parseInt(id));
                    ss.setClassName(className);
                    ss.setScore(score);
                    ss.setConduct(conduct);
                    ssm.add(ss);
                    out.write("Change " + className + " id=" + id);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "del":
                out.write("Xoa");
                String[] idArray = request.getParameterValues("id");
                for (String id : idArray) {
                    StudentStudyModel ssm = new StudentStudyModel();
                    StudentStudyings ss = ssm.getById(Integer.parseInt(id));
                    ssm.delete(ss);
                    out.write("Đã xóa id "+id);
                    //response.sendRedirect(request.getHeader("referer"));
                }   break;
            case "view":
                out.write("Đây là action View");
                break;
        }
    }
}
