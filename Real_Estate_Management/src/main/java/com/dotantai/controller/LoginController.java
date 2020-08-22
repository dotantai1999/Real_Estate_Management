package com.dotantai.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dotantai.service.IUserService;
import com.dotantai.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	
	private IUserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		//get username and password from form
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
				
		//check (count)
		boolean check = userService.checkAccount(userName, password);
		
		if(check) {
			HttpSession session = request.getSession();
			session.setAttribute("username",userName);
			url = "";
		} else {
			url = "";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	
	
	
}
