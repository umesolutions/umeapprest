package com.umesolutions.e2eapp.service;

import java.sql.SQLException;

import com.umesolutions.e2eapp.dto.LoginDetails;

public interface RequestLoginService {
	
	public LoginDetails getLoginInfo(String userName, String password);
	public boolean addLoginDetails(LoginDetails loginDetails);

}
