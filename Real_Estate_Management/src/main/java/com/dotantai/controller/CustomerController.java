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

import com.dotantai.dto.BuildingDTO;
import com.dotantai.dto.CustomerDTO;
import com.dotantai.service.IBuildingService;
import com.dotantai.service.ICustomerService;
import com.dotantai.service.impl.BuildingServiceImpl;
import com.dotantai.service.impl.CustomerServiceImpl;
import com.dotantai.utils.FormUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = { "/admin-customer" })
public class CustomerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ICustomerService customerService = new CustomerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = "";
		if (action != null && action.equals("LIST")) {
			// Search danh sach tai khoan nguoi dung theo name va phone va email
			// Xu ly giong building LIST
			// Tra ve variable customers -> truyen vao list.jsp
			CustomerDTO customer = FormUtil.toModel(CustomerDTO.class, request);

			List<CustomerDTO> list = customerService.findAll(customer);
			request.setAttribute("customers", list);
			url = "/views/admin/customer/list.jsp";
		} else if (action != null && action.equals("EDIT")) {
			// Front end gui id cua customer can sua thong qua url params
			// Xu ly
			// Tra ve trang edit.jsp voi thong tin user truyen vao (ten bien truyen vao la
			// customer)
			String id_string = request.getParameter("id");
			Long id = Long.parseLong(id_string);
			CustomerDTO customerDTO = null;
			try {
				customerDTO = customerService.findById(id);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("customer", customerDTO);
			url = "/views/admin/customer/edit.jsp";
		} else if (action != null && action.equals("ADD")) {
			url = "/views/admin/building/add.jsp";
		} else if (action != null && action.equals("VIEW")) {
			// Front end gui id cua building can xem thong qua url params
			// Xu ly
			// Tra ve trang view.jsp voi thong tin building truyen vao (ten bien truyen vao
			// la building)

			String id_string = request.getParameter("id");
			Long id = Long.parseLong(id_string);
			CustomerDTO customerDTO = null;
			try {
				customerDTO = customerService.findById(id);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			request.setAttribute("customer", customerDTO);
			url = "/views/admin/building/view.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action != null && action.equals("EDIT")) {

			CustomerDTO customer = FormUtil.toModel(CustomerDTO.class, request);
			customer.setId(Long.parseLong(request.getParameter("id")));
			customerService.update(customer);
			response.sendRedirect("/admin-customer?action=EDIT");
		} else if (action != null && action.equals("DELETE")) {
			// Front end gui file json: keys = buildingIds, value = array id
			// Xu ly
			// Dieu huong ve lai trang action=LIST (GET)
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
			JsonNode arrNode = jsonNode.get("customerIds");
			List<Long> ids = new ArrayList<>();
			for (JsonNode objNode : arrNode) {
				ids.add(Long.parseLong(objNode.asText()));
			}
			for (Long item : ids) {
				boolean check = customerService.delete(item);
			}
			return;
		} else if (action != null && action.equals("ADD")) {
			if (action != null && action.equals("ADD")) {
				CustomerDTO customerDTO = FormUtil.toModel(CustomerDTO.class, request);
				Long id = customerService.insert(customerDTO);
				response.sendRedirect("admin-building?action=LIST");
			}
		}
	}

}
