package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import models.*;

public class HomeServlet extends HttpServlet {

    public HomeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
    	response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
        	String message = "Chào mừng " +((User)session.getAttribute("user")).getFullname() + " gia nhập studentwork - "
        			+ "mạng xã hội việc làm dành cho sinh viên lớn nhất Việt Nam";
        	message += "<br><a href='about'>Trang cá nhân</a> <br><a href='logout'>Đăng xuất</a>";
            request.setAttribute("message", message );
            request.setAttribute("msgClass", "alert-success");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
