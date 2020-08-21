package com.dotantai.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin-building/priority-list"})
public class PriorityBuildingController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lay ds building uu tien -> luu vao variable buildings -> truyen vao file jsp
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/priorityList.jsp");
		rd.forward(request, response);
	}
	
	
}
