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
import entities.StudentInterests;
import entities.Users;
import models.StudentInterestModel;

/**
 *
 * @author HongSon
 */
public class InterestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getHeader("referer"));
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
                    String interest = request.getParameter("interest");
                    StudentInterestModel sim = new StudentInterestModel();
                    sim.add(new StudentInterests(user.getId(), interest));
                    out.write(interest);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "update":
                {
                    String id = request.getParameter("id");
                    String interest = request.getParameter("interest");
                    StudentInterestModel sim = new StudentInterestModel();
                    StudentInterests si = sim.getById(Integer.parseInt(id));
                    si.setInterest(interest);
                    sim.add(si);
                    out.write("Change " + interest + " id=" + id);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "del":
                out.write("Xoa");
                String[] idArray = request.getParameterValues("id");
                for (String id : idArray) {
                    StudentInterestModel sim = new StudentInterestModel();
                    StudentInterests si = sim.getById(Integer.parseInt(id));
                    sim.delete(si);
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
