package com.dotantai.api;

import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns = { "/api-building"})
public class BuildingAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IBuildingService buildingService = new BuildingServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
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

		mapper.writeValue(response.getOutputStream(), buildings);

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
