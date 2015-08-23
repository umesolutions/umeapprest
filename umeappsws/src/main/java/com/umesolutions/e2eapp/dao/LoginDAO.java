package com.umesolutions.e2eapp.dao;

import com.umesolutions.e2eapp.dao.pojo.LoginDetailsPojo;

public interface LoginDAO {
	public LoginDetailsPojo getLoginDAOInfo(String username, String password);
	
}
