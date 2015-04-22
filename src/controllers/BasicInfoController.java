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
public class BasicInfoController extends HttpServlet {

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
                    Date birthday = new Date(request.getParameter("birthday"));
                    String gender = request.getParameter("gender");
                    String college = request.getParameter("college");
                    int inYear = Integer.parseInt(request.getParameter("inYear"));
                    String major = request.getParameter("major");
                    String maritalStatus = request.getParameter("maritalStatus");
                    String nation = request.getParameter("nation");
                    String more = request.getParameter("more");
                    StudentBasicModel sbm = new StudentBasicModel();
                    sbm.add(new StudentBasic(user.getId(), birthday, gender, college, inYear, major, maritalStatus, nation, more));
                    out.write(birthday + " " + gender);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "update":
                {
                    String id = request.getParameter("id");
                    Date birthday = new Date(request.getParameter("birthday"));
                    String gender = request.getParameter("gender");
                    String college = request.getParameter("college");
                    int inYear = Integer.parseInt(request.getParameter("inYear"));
                    String major = request.getParameter("major");
                    String maritalStatus = request.getParameter("maritalStatus");
                    String nation = request.getParameter("nation");
                    String more = request.getParameter("more");
                    StudentBasicModel sbm = new StudentBasicModel();
                    StudentBasic sb = sbm.getById(Integer.parseInt(id));
                    sb.setBirthday(birthday);
                    sb.setCollege(college);
                    sb.setGender(gender);
                    sb.setInYear(inYear);
                    sb.setMajor(major);
                    sb.setMaritalStatus(maritalStatus);
                    sb.setMore(more);
                    sb.setNation(nation);
                    sbm.add(sb);
                    out.write("Change " + birthday + " id=" + id);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "del":
                out.write("Xoa");
                String[] idArray = request.getParameterValues("id");
                for (String id : idArray) {
                    StudentBasicModel sbm = new StudentBasicModel();
                    StudentBasic sb = sbm.getById(Integer.parseInt(id));
                    sbm.delete(sb);
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
