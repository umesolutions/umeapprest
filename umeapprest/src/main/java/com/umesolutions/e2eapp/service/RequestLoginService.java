package com.umesolutions.e2eapp.service;

import java.sql.SQLException;

import com.umesolutions.e2eapp.dto.LoginDetails;

public interface RequestLoginService {
	
	public LoginDetails getLoginInfo(String userName, String password) throws SQLException, Exception;
	public boolean addLoginDetails(String username, String password, String usertype) throws Exception;

}
