package com.umesolutions.e2eapp.dao;

import com.umesolutions.e2eapp.dto.LoginDetails;

public interface LoginDAO {
	public LoginDetails getLoginDAOInfo(String username, String password);


	public boolean setLoginInfo(LoginDetails loginDetails);
	
}
