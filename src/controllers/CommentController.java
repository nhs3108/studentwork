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

import models.CommentModel;
import models.StudentAwardModel;
import models.StudentPostModel;

import org.jsoup.safety.Whitelist;

import entities.StudentAwards;
import entities.Comments;
import entities.Users;

/**
 *
 * @author HongSon
 */
public class CommentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		switch (action) {
		case "add": {
			int postId = Integer.parseInt(request.getParameter("postId"));
			int userId = Integer.parseInt(request.getParameter("userId"));
			String content = request.getParameter("content");
			if (user.getType().equals("student")) {
				CommentModel cmtm = new CommentModel();
				cmtm.add(new Comments(postId, userId, content, 0, new Date()));
				out.write(content);
				//response.sendRedirect(request.getHeader("referer"));
			} else {
				// if type is company
			}
			response.sendRedirect(request.getHeader("referer"));
			break;
		}

		case "update": {
			int id = Integer.parseInt(request.getParameter("id"));
			int postId = Integer.parseInt(request.getParameter("postId"));
			int userId = Integer.parseInt(request.getParameter("userId"));
			String content = request.getParameter("content");
			if (user.getType().equals("student")) {
				CommentModel cmtm = new CommentModel();
				Comments cmt = cmtm.getById(id);
				cmt.setContent(content);
				cmt.setTime(new Date());
				cmtm.add(cmt);
				out.write(content);
			} else {
				// if type is company
			}
			response.sendRedirect(request.getHeader("referer"));
			break;
		}
		case "del":
			if (user.getType().equals("student")) {
				String[] idArray = request.getParameterValues("id");
				for (String id : idArray) {
					CommentModel cmtm = new CommentModel();
					Comments cmt = cmtm.getById(Integer.parseInt(id));
					cmtm.delete(cmt);
					out.write("Đã xóa");
				}
			} else {
				// if type is company
			}
			response.sendRedirect(request.getHeader("referer"));
			// break;
		case "view":
			out.write("Xem");
			List<StudentAwards> spl = new StudentAwardModel().getAll();
			for (StudentAwards sp : spl) {
				out.write("<font color=red>" + sp.getAward() + "</font");
			}
			break;
		}
	}
}
