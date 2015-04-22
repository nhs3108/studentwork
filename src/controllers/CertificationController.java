/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.io.IOException;
import java.io.PrintWriter;
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
public class CertificationController extends HttpServlet {

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
                    String certification = request.getParameter("certification");
                    int year = Integer.parseInt(request.getParameter("year"));
                    StudentCertificationModel scm = new StudentCertificationModel();
                    scm.add(new StudentCertifications(user.getId(), certification, year));
                    out.write(certification + " " + year);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "update":
                {
                    String id = request.getParameter("id");
                    String certification = request.getParameter("certification");
                    int year = Integer.parseInt(request.getParameter("year"));
                    StudentCertificationModel scm = new StudentCertificationModel();
                    StudentCertifications sc = scm.getById(Integer.parseInt(id));
                    sc.setCertification(certification);
                    sc.setYear(year);
                    scm.add(sc);
                    out.write("Change " + certification + " id=" + year);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "del":
                out.write("Xoa");
                String[] idArray = request.getParameterValues("id");
                for (String id : idArray) {
                    StudentCertificationModel scm = new StudentCertificationModel();
                    StudentCertifications sb = scm.getById(Integer.parseInt(id));
                    scm.delete(sb);
                    out.write("Đã xóa id "+id);
                }   
                response.sendRedirect(request.getHeader("referer"));
                //break;
            case "view":
                out.write("Đây là action View");
                break;
        }
    }
}
