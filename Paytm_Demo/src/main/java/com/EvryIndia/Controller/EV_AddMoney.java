package com.EvryIndia.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.EvryIndia.Model.EV_Account;

public class EV_AddMoney extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("transaction.jsp");
		System.out.println("id--"+ (Integer)request.getSession().getAttribute("customerId"));
		
		int accLoan=(Integer)request.getSession().getAttribute("accLoan");
		int accNum=(Integer)request.getSession().getAttribute("accNum");
		int balance=(Integer)request.getSession().getAttribute("balance");
		String stramount=request.getParameter("amount");
		int amount=Integer.parseInt(stramount);
		System.out.println("amount for add -- "+amount);
		
    	StandardServiceRegistry sr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta = new MetadataSources(sr).getMetadataBuilder().build(); 
    	
    	SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    	Session session = factory.openSession();  
    	Transaction t = session.beginTransaction(); 
    	int updateAmount=balance+amount;
    

    		EV_Account accObj = (EV_Account) session.get(EV_Account.class, accNum);
    		accObj.setBalance(updateAmount);
    		session.update(accObj);
    		 t.commit();  
    		System.out.println("--Amount added Successfully--");   
    		
    		RequestDispatcher rd = request.getRequestDispatcher("/transaction.jsp");
			PrintWriter out= response.getWriter();
			out.println("<h5><font color=green>Money Added Successfully</font></h5>");
			out.println("<p><font color=red>Check YOUR Balance </font></p>");
    		rd.include(request, response);
    		session.close(); 
    		factory.close();  
    	}
}
