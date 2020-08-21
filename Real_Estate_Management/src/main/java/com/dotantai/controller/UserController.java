package com.dotantai.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin-user"})
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = "";
		if (action != null && action.equals("LIST")) {
			// Search danh sach tai khoan nguoi dung theo fullName va userName
			// Xu ly giong building LIST
			// Tra ve variable users -> truyen vao list.jsp
			url = "/views/admin/user/list.jsp";
		} else if (action != null && action.equals("EDIT")) {
			// Front end gui id cua user can sua thong qua url params
			// Xu ly
			// Tra ve trang edit.jsp voi thong tin user truyen vao (ten bien truyen vao la user)
			url= "/views/admin/user/edit.jsp";
		} 
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	
}
