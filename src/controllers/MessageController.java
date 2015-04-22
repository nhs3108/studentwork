package controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.MessageModel;
import models.StudentBasicModel;
import entities.Messages;
import entities.StudentBasic;
import entities.Users;

/**
 * Servlet implementation class MessageController
 */
@WebServlet("/message")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		if(action==null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/message.jsp");
			dispatcher.forward(request, response);
		}else{
			switch (action) {
				case "send": {
					int ownerId = Integer.parseInt(request.getParameter("ownerId"));
					String content = request.getParameter("content");
					Messages newMsg = new Messages(ownerId, user.getId(), content, MessageModel.NOT_HAVE_SEEN, null, new Date());
					new MessageModel().add(newMsg);
					response.sendRedirect(request.getHeader("referer"));
					break;
				}
				case "del":{
	                String[] idArray = request.getParameterValues("id");
	                for (String id : idArray) {
	                    MessageModel mm = new MessageModel();
	                    Messages msg = mm.getById(Integer.parseInt(id));
	                    mm.delete(msg);
	                }   
	                //response.sendRedirect(request.getHeader("referer"));
	                break;
				}
				default: {
					
				}
			}
		}
		
	}

}
