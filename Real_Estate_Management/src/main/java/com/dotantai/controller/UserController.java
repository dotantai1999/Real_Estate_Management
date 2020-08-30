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
import com.dotantai.dto.UserRoleDTO;
import com.dotantai.service.IUserRoleService;
import com.dotantai.service.IUserService;
import com.dotantai.service.impl.UserRoleServiceImpl;
import com.dotantai.service.impl.UserServiceImpl;
import com.dotantai.utils.FormUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/admin-user"})
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
	private IUserRoleService userRoleService = new UserRoleServiceImpl();
		
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
		else if (action != null && action.equals("ADD")) {
			url = "/views/admin/customer/add.jsp";
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
			ObjectMapper mapper = new ObjectMapper();  
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			try { 
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
			} catch (IOException e) {
			  System.out.print(e.getMessage());
			  
			}
			String json = sb.toString();
			JsonNode jsonNode = mapper.readTree(json);
			JsonNode arrNode = jsonNode.get("userIds");
			List<Long> ids = new ArrayList<>();
			for (JsonNode objNode : arrNode) {
				ids.add(Long.parseLong(objNode.asText()));
			}
			
			//Set status for all account is deleted
			ArrayList<UserDTO> listUserDTO = new ArrayList<>();
			for (Long item : ids) {
				try {
					UserDTO userDTO = userService.findById(item);
					userDTO.setStatus("0");
					listUserDTO.add(userDTO);
			} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			
			//Update status
			for(UserDTO item : listUserDTO) {
				userService.update(item);
			}
			return;
		} else if (action != null && action.equals("ADD")) {
			UserDTO userDTO = FormUtil.toModel(UserDTO.class, request);
			Long id = userService.insert(userDTO);
			
			UserRoleDTO userRoleDTO = new UserRoleDTO(Long.valueOf(2),id);
			userRoleService.insert(userRoleDTO);
			
			response.sendRedirect("admin-building?action=LIST");
		}
	}
	
	
}
