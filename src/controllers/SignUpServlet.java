package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import models.*;

public class SignUpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("home");
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = MD5.encrypt(request.getParameter("password"));
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        
        
        if ((new User().hasUser(email))) {
        	request.setAttribute("message", "Email "+ email +" đã tồn tại!");
            request.setAttribute("msgClass", "alert-danger");
        } else {
            int isInserted = 0;
            isInserted = new User(email, password, name, phone, address, role,
                    null, null, "0000-00-00", null, null, null, null,
                    null, null).insertUser();
            out.print(isInserted);
            if (isInserted == 0) {
            	request.setAttribute("message", "Không thể đăng ký. Vui lòng liên hệ với admin!");
                request.setAttribute("msgClass", "alert-danger");
            } else {
            	request.setAttribute("message", "Đăng ký thành công!");
                request.setAttribute("msgClass", "alert-success");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
