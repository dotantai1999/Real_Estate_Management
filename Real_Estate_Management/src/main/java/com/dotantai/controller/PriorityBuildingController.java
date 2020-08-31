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
import javax.servlet.http.HttpSession;

import com.dotantai.dto.BuildingDTO;
import com.dotantai.dto.PriorityBuildingListDTO;
import com.dotantai.service.IBuildingService;
import com.dotantai.service.IPriorityBuildingListService;
import com.dotantai.service.impl.BuildingServiceImpl;
import com.dotantai.service.impl.PriorityBuildingListServiceImpl;
import com.dotantai.utils.FormUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = { "/admin-building/priority-list" })
public class PriorityBuildingController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IPriorityBuildingListService priorityBuildingListService = new PriorityBuildingListServiceImpl();
	private IBuildingService buildingService = new BuildingServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action != null && action.equals("ADD")) {
			HttpSession session = request.getSession();
			Long userId = (Long) session.getAttribute("id");
			Long buildingId = Long.parseLong(request.getParameter("buildingId"));

			PriorityBuildingListDTO priorityBuildingListDTO = new PriorityBuildingListDTO();
			priorityBuildingListDTO.setUserId(userId);
			priorityBuildingListDTO.setBuildingId(buildingId);
			Long id = priorityBuildingListService.insert(priorityBuildingListDTO);
			response.sendRedirect("/Real_Estate_Management/admin-building/priority-list?action=LIST");
		} else {
			HttpSession session = request.getSession();
			Long idUser = (Long) session.getAttribute("id");

			ArrayList<Long> Ids = (ArrayList<Long>) priorityBuildingListService.findPriorityBuildingIdByUserId(idUser);
			List<BuildingDTO> listBuildings = priorityBuildingListService.findPriorityBuildingListByBuildingId(Ids);

			request.setAttribute("buildings", listBuildings);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/building/priorityList.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action != null && action.equals("ADD")) {
			HttpSession session = request.getSession();
			Long userId = (Long) session.getAttribute("id");
			Long buildingId = Long.parseLong(request.getParameter("buildingId"));

			PriorityBuildingListDTO priorityBuildingListDTO = new PriorityBuildingListDTO();
			priorityBuildingListDTO.setUserId(userId);
			priorityBuildingListDTO.setBuildingId(buildingId);
			Long id = priorityBuildingListService.insert(priorityBuildingListDTO);
			response.sendRedirect("admin-building/priority-list?action=LIST");
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
			JsonNode arrNode = jsonNode.get("buildingIds");
			List<Long> ids = new ArrayList<>();
			for (JsonNode objNode : arrNode) {
				ids.add(Long.parseLong(objNode.asText()));
			}

			HttpSession session = request.getSession();
			Long idUser = (Long) session.getAttribute("id");

			for (Long item : ids) {
				boolean check = priorityBuildingListService.delete(item, idUser);
			}
			return;
		}
	}

}
