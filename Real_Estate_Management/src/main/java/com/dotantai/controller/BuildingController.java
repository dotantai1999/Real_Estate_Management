package com.dotantai.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;                                                                                                                             
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dotantai.builder.BuildingSearchBuilder;
import com.dotantai.dto.BuildingDTO;
import com.dotantai.paging.Pageable;
import com.dotantai.paging.PageableImpl;
import com.dotantai.service.IBuildingService;
import com.dotantai.service.impl.BuildingServiceImpl;
import com.dotantai.utils.FormUtil;
import com.dotantai.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/admin-building"})
public class BuildingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IBuildingService buildingService = new BuildingServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = "";
		if (action != null && action.equals("LIST")) {
			BuildingDTO building = FormUtil.toModel(BuildingDTO.class, request);
			BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder().setName(building.getName())
					.setDistrict(building.getDistrict()).setStreet(building.getStreet()).setWard(building.getWard())
					.setBuildingArea(building.getBuildingArea()).setNumberOfBasement(building.getNumberOfBasement())
					.setBuildingTypes(building.getBuildingTypes()).setAreaRentFrom(building.getAreaRentFrom())
					.setAreaRentTo(building.getAreaRentTo()).setCostRentFrom(building.getCostRentFrom())
					.setCostRentTo(building.getCostRentTo())
					.setStaffId(building.getStaffId())
					.build();
			Pageable pageable = new PageableImpl(building.getPage(), building.getLimit());
			List<BuildingDTO> buildings = buildingService.findAll(buildingSearchBuilder, pageable);
			request.setAttribute("buildings", buildings);
			url = "/views/admin/building/list.jsp";
		} else if (action != null && action.equals("EDIT")) {
			url="/views/admin/building/edit.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BuildingDTO buildingDTO = FormUtil.toModel(BuildingDTO.class, request);
		buildingDTO = buildingService.save(buildingDTO);
		response.sendRedirect("admin-building?action=LIST");
	}
	
}
