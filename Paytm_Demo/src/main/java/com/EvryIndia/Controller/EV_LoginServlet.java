package com.EvryIndia.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EvryIndia.Model.EV_UserLogin;
import com.EvryIndia.Service.EV_BaseService;
import com.EvryIndia.Service.EV_BaseServiceImpl;

public class EV_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	 /**
	  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.sendRedirect("login.jsp");
	 }

	 /**
	  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	  */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String loginId = request.getParameter("loginId");
	  String password = request.getParameter("password");
	  
	  System.out.println(loginId + " :: " + password);
	  String page = "login.jsp";
	  if(loginId.trim().length() >= 0 && loginId != null &&
	    password.trim().length() >= 0 && password != null) {
	   EV_BaseService loginService = new EV_BaseServiceImpl();
	   boolean flag = loginService.login(loginId, password);
	   if(flag) {
	    System.out.println("Login success!!!");
	    request.setAttribute("username", loginId);
	    request.setAttribute("msg", "Login Success.....");
	    page = "transaction.jsp";
	   } else {
	    request.setAttribute("msg", "Wrong Username or Password, Try again!!!");
	   }
	  } else {
	   request.setAttribute("msg", "Please enter username and password...");
	  }
	  request.getRequestDispatcher(page).include(request, response);
	 }
	}