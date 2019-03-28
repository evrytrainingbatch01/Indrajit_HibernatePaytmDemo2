package com.EvryIndia.Dao;

import org.hibernate.Session;

import com.EvryIndia.DbUtil.EV_Paytm_Util;
import com.EvryIndia.Model.EV_Account;
import com.EvryIndia.Model.EV_UserLogin;

public class EV_BaseDaoImpl implements EV_BaseDao {

	public boolean login(String loginId, String password) {
		Session session = EV_Paytm_Util.getSession();
		boolean flag = false;
		  if (session != null) {
		   try {
			   EV_UserLogin user = (EV_UserLogin) session.get(EV_UserLogin.class, loginId);
		    if (password.equals(user.getPassword())) {
		     System.out.println("User: " + user.toString());
		     flag=true;
		    }
		   } catch (Exception exception) {
		    System.out.println("Exception occred while reading user data: "
		      + exception.getMessage());
		   }

		  } else {
		   System.out.println("DB server down.....");
		  }
		  return flag;
	}

	public String register(EV_UserLogin user) {
		String msg = "Registration unsuccessful, try again.....";
		  Session session = EV_Paytm_Util.getSession();
		  if (session != null) {
		   try {
		    if (user != null) {
		     String loginId = (String) session.save(user);
		     session.beginTransaction().commit();
		     msg = "User " + loginId
		       + " created successfully, please login...";
		    }
		   } catch (Exception exception) {
		    System.out.println("Exception occred while reading user data: "
		      + exception.getMessage());
		   }

		  } else {
		   System.out.println("DB server down.....");
		  }
		  System.out.println("msg:" + msg);
		  return msg;
		 }
}
