package com.EvryIndia.Dao;

import com.EvryIndia.Model.EV_Account;
import com.EvryIndia.Model.EV_UserLogin;

public interface EV_BaseDao {
	 public boolean login(String loginId, String password);
	 public String register(EV_UserLogin user);
}
