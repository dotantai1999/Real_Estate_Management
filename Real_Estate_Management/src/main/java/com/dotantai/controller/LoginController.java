package com.dotantai.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dotantai.service.IUserRoleService;
import com.dotantai.service.IUserService;
import com.dotantai.service.impl.UserRoleServiceImpl;
import com.dotantai.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	
	private IUserService userService = new UserServiceImpl();
	private IUserRoleService userRoleService = new UserRoleServiceImpl();
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
			RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");
			rd.forward(request, response);
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		//get username and password from form
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
				
		//check (count)
		Long id = userService.checkAccount(userName, password);
		
		if(id != 0) {
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			session.setAttribute("username",userName);
			session.setAttribute("role",userRoleService.findRoleIdByUserId(id));
			System.out.print(id);
			response.sendRedirect("admin-home");
		} else {
			request.setAttribute("msgLoginFailed","Login Failed");
			RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");
			rd.forward(request, response);
		}

		
	}
	
	
	
	
}
