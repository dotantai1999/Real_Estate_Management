package com.dotantai.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dotantai.dto.UserDTO;
import com.dotantai.service.IAssignmentStaffService;
import com.dotantai.service.IBuildingService;
import com.dotantai.service.IUserService;
import com.dotantai.service.impl.AssignmentStaffServiceImpl;
import com.dotantai.service.impl.BuildingServiceImpl;
import com.dotantai.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/AssignBuildingAPI")
public class AssignBuildingAPI extends HttpServlet {
	
	private IUserService userService = new UserServiceImpl();
	private IAssignmentStaffService assignmentStaffService = new AssignmentStaffServiceImpl(); 
	
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get building id from json
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
		JsonNode objNode = jsonNode.get("id");
		Long id = objNode.asLong();
		
		// lay danh sach nguoi quan ly cua toa nha
		List<UserDTO> list = userService.getStaffByBuildingId(id);
		
		
		// tra ve json ket qua
		mapper.writeValue(response.getOutputStream(), list);
		
		System.out.print("");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get buildingid and array of staffId
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
		JsonNode arrNode = jsonNode.get("staffIds");
		List<Long> staffIds = new ArrayList<>();
		for (JsonNode objNode : arrNode) {
			staffIds.add(Long.parseLong(objNode.asText()));
		}
		JsonNode objNode = jsonNode.get("idBuilding");
		Long buildingId = objNode.asLong();
		
		// delete dong cu (id)
		assignmentStaffService.deleteStaffByBuildingId(buildingId);
		
		// inseret dong moi
		for(Long staffId : staffIds) {
			assignmentStaffService.insertAssignmentStaff(buildingId, staffId);
		}
		//response.sendRedirect("admin-building?action=LIST");
	}
	
}
