package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String password = MD5.encrypt(request.getParameter("password"));
        String birthday = request.getParameter("birthday");
        String fullname = request.getParameter("fullname");
        //String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        //String avatar = request.getParameter("avatar");
        String activation = MD5.encrypt("" + Math.random());
        ArrayList<User> userList = User.getUsers("username", username);
        if (userList.size() != 0) {
            request.setAttribute("message", "Username " + username + " đã tồn tại!");
            request.setAttribute("msgClass", "alert-danger");
        } else {
            int isInserted = 0;
            User user = new User(0, type, username, email, password, fullname, "", address, "", 0, 0, activation);
            isInserted = user.addToDB();
            int studentId = user.getId();
            if (type.equals("student")) {
                new StudentBasic(0, studentId, birthday, gender, null, 0, "", "", "", "").addToDB();
            }
            if (isInserted == 0) {
                request.setAttribute("message", "Không thể đăng ký. Vui lòng liên hệ với admin!");
                request.setAttribute("msgClass", "alert-danger");
            } else {
                request.setAttribute("message", "Đăng ký thành công! Vui lòng kích hoạt qua địa chỉ email mà bạn đã đăng ký!");
                request.setAttribute("msgClass", "alert-success");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
