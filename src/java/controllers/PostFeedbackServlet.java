package controllers;

import models.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostFeedbackServlet
 */
@WebServlet("/postFeedback")
public class PostFeedbackServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("contactus");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int userId = 1;
        int minLenght = Integer.parseInt(this.getServletContext().getInitParameter("minLenghtFeedback"));
        String content = request.getParameter("content");
        if (content.length() < minLenght) {
            request.setAttribute("message", "Bài viết quá ngắn! Vui lòng thử lại với tối tiểu " + minLenght);
            request.setAttribute("msgClass", "alert-danger");
        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String time = dateFormat.format(date);
            Feedback feedback = new Feedback(userId, content, time);
            int result = feedback.pushNew();
            if (result != 0) {
                request.setAttribute("message", "Đã gửi! Cảm ơn ý kiến đóng góp của bạn!");
                request.setAttribute("msgClass", "alert-success");
            } else {
                request.setAttribute("message", "Đã xảy ra lỗi! Vui lòng thử lại sau");
                request.setAttribute("msgClass", "alert-danger");
            }

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("contactus");
        dispatcher.forward(request, response);
    }

}
