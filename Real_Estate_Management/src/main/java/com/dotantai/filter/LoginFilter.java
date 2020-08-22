/*
 * package com.dotantai.filter;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.FilterConfig; import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.ServletRequest; import
 * javax.servlet.ServletResponse; import javax.servlet.annotation.WebFilter;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpSession;
 * 
 * @WebFilter(urlPatterns = { "/admin-building", "/admin-customer",
 * "/admin-use", "admin-home" }) public class LoginFilter implements Filter {
 * 
 * public LoginFilter() {
 * 
 * }
 * 
 * public void destroy() {
 * 
 * }
 * 
 * public void doFilter(ServletRequest request, ServletResponse response,
 * FilterChain chain) throws IOException, ServletException {
 * 
 * HttpServletRequest req = (HttpServletRequest) request; HttpSession session =
 * req.getSession(); if (session.getAttribute("username") == null) {
 * RequestDispatcher rd =
 * request.getRequestDispatcher("/views/admin/login/login.jsp");
 * rd.forward(request, response); }
 * 
 * System.out.print("testttt"); chain.doFilter(request, response); }
 * 
 * public void init(FilterConfig fConfig) throws ServletException {
 * 
 * }
 * 
 * }
 */