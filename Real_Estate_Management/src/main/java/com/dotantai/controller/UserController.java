package com.dotantai.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dotantai.dto.AssignmentCustomerStaffDTO;
import com.dotantai.dto.CustomerDTO;
import com.dotantai.dto.UserDTO;
import com.dotantai.service.IUserService;
import com.dotantai.service.impl.UserServiceImpl;
import com.dotantai.utils.FormUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/admin-user"})
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = "";
		if (action != null && action.equals("LIST")) {
			List<UserDTO> list = userService.findAll();
			request.setAttribute("users", list);
			url = "/views/admin/user/list.jsp";
		} else if (action != null && action.equals("EDIT")) {
			String id_string = request.getParameter("id");
			Long id = Long.parseLong(id_string);
			UserDTO userDTO = null;
			try {
				userDTO = userService.findById(id);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			request.setAttribute("user", userDTO);
			url= "/views/admin/user/edit.jsp";
		} 
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action != null && action.equals("EDIT")) {
			UserDTO user = FormUtil.toModel(UserDTO.class, request);
			user.setId(request.getParameter("id"));
			userService.update(user);
			response.sendRedirect("admin-customer?action=LIST");
			
		} else if (action != null && action.equals("DELETE")) {
			
		} else if (action != null && action.equals("ADD")) {
			
		}
	}
	
	
}
