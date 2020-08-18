package com.dotantai.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dotantai.dto.UserDTO;
import com.dotantai.service.IUserService;
import com.dotantai.service.impl.UserServiceImpl;
import com.dotantai.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = { "/api-user"})
public class UserAPI extends HttpServlet {
	
	private IUserService userService;
	
	public UserAPI () {
		userService = new UserServiceImpl();
	}
	
	
	private static final long serialVersionUID = -2244941222124032374L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserDTO userDTO =  HttpUtil.of(request.getReader()).toModel(UserDTO.class);
		userDTO = userService.save(userDTO);
		mapper.writeValue(response.getOutputStream(), userDTO);
	}
	
	
}
