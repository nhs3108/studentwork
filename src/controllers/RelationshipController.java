package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.RelationshipModel;
import entities.Users;

/**
 * Servlet implementation class RelationshipController
 */
@WebServlet("/relationship")
public class RelationshipController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelationshipController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		String action = request.getParameter("action");
		switch(action){
			case "add":{
				int user1Id = Integer.parseInt(request.getParameter("user1Id"));
				int user2Id = Integer.parseInt(request.getParameter("user2Id"));
				new RelationshipModel().makeFriend(user1Id, user2Id);
				out.print("Đã add" + user1Id + " và" + user2Id);
				response.sendRedirect(request.getHeader("referer"));
				break;
			}
			case "del":{
				int user1Id = Integer.parseInt(request.getParameter("user1Id"));
				int user2Id = Integer.parseInt(request.getParameter("user2Id"));
				new RelationshipModel().delete(new RelationshipModel().getRelationship(user1Id, user2Id));
				new RelationshipModel().delete(new RelationshipModel().getRelationship(user2Id, user1Id));
				out.print("Đã xóa" + user1Id + " và" + user2Id);
				response.sendRedirect(request.getHeader("referer"));
				break;
			}
		}
	}

}
