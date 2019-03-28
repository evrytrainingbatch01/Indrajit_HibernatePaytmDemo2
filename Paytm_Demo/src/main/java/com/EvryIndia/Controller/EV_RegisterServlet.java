package com.EvryIndia.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EvryIndia.Dao.EV_BaseDao;
import com.EvryIndia.Dao.EV_BaseDaoImpl;
import com.EvryIndia.Model.EV_UserLogin;

public class EV_RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("userRegistration.jsp");
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String msg = "Password and Conform Passwords must be same";
  String page = "userRegistration.jsp";
  if(request.getParameter("password").equals(request.getParameter("confPassword"))){
   EV_UserLogin user = new EV_UserLogin();
   user.setUserId(request.getParameter("userId"));  
   user.setFirstName(request.getParameter("firstName"));
   user.setLastName(request.getParameter("lastName"));
   user.setLoginId(request.getParameter("loginId"));
   user.setPassword(request.getParameter("password"));
   
   System.out.println(user.toString());
   EV_BaseDao baseDao = new EV_BaseDaoImpl();
   msg = baseDao.register(user);
   page = "login.jsp";
  } 
  request.setAttribute("msg2", msg);
  request.getRequestDispatcher(page).include(request, response);
 }
}
