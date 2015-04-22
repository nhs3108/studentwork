package controllers;

import entities.*;
import models.*;

import java.util.List;
import java.io.IOException;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

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
        Users user = (Users)session.getAttribute("user");
        if (user != null) {
        	int studentId = user.getId();
        	/*List<StudentAwards> awardList = new StudentAwardModel().getByStudentId(studentId);
        	List<StudentBasic> basicList = new StudentBasicModel().getByStudentId(studentId);
        	List<StudentEvents> eventList = new StudentEventModel().getByStudentId(studentId);
        	List<StudentExp> expList = new StudentExperienceModel().getByStudentId(studentId);
        	List<StudentInterests> interestList = new StudentInterestModel().getByStudentId(studentId);
        	List<StudentCertifications> certificationList = new StudentCertificationModel().getByStudentId(studentId);
        	List<StudentProjects> projectList = new StudentProjectModel().getByStudentId(studentId);
        	List<StudentSkills> skillList = new StudentSkillModel().getByStudentId(studentId);
        	List<StudentVolunteers> volunteerList = new StudentVolunteerModel().getByStudentId(studentId);
        	List<StudentLanguages> languagesList = new StudentLanguageModel().getByStudentId(studentId);*/
        	List<Messages> messageList = new MessageModel().getByOwnerId(studentId);
        	session.setAttribute("messageList", messageList);
        	session.setAttribute("user", user);
            String message = "Chào mừng " + ((Users) session.getAttribute("user")).getFullname() + " gia nhập studentwork - "
                    + "mạng xã hội việc làm dành cho sinh viên lớn nhất Việt Nam";
            message += "<br><a href='about'>Trang cá nhân</a> <br><a href='logout'>Đăng xuất</a>";
            request.setAttribute("message", message);
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
