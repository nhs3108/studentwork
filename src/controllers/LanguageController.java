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
import entities.StudentLanguages;
import entities.Users;
import models.StudentLanguageModel;

/**
 *
 * @author HongSon
 */
public class LanguageController extends HttpServlet {

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
                    String language = request.getParameter("language");
                    int level = Integer.parseInt(request.getParameter("language"));
                    StudentLanguageModel slm = new StudentLanguageModel();
                    slm.add(new StudentLanguages(user.getId(), language, level));
                    out.write(language);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "update":
                {
                    String id = request.getParameter("id");
                    String language = request.getParameter("language");
                    int level = Integer.parseInt(request.getParameter("level"));
                    StudentLanguageModel slm = new StudentLanguageModel();
                    StudentLanguages sl = slm.getById(Integer.parseInt(id));
                    sl.setLanguage(language);
                    sl.setLevel(level);
                    slm.add(sl);
                    out.write("Change " + language + " id=" + id);
                    response.sendRedirect(request.getHeader("referer"));
                    break;
                }
            case "del":
                out.write("Xoa");
                String[] idArray = request.getParameterValues("id");
                for (String id : idArray) {
                    StudentLanguageModel slm = new StudentLanguageModel();
                    StudentLanguages sl = slm.getById(Integer.parseInt(id));
                    slm.delete(sl);
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
