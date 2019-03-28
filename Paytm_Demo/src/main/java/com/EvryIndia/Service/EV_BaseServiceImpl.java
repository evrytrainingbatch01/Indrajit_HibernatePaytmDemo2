package com.EvryIndia.Service;

import com.EvryIndia.Dao.EV_BaseDao;
import com.EvryIndia.Dao.EV_BaseDaoImpl;
import com.EvryIndia.Model.EV_UserLogin;

public class EV_BaseServiceImpl implements EV_BaseService {
	
	private EV_BaseDao loginDao = new EV_BaseDaoImpl();
	public boolean login(String loginId, String password) {
		return loginDao.login(loginId, password);
	}

	public String registration(EV_UserLogin user) {
		return loginDao.register(user);
	}
}