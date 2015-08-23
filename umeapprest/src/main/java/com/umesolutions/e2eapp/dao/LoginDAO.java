package com.umesolutions.e2eapp.dao;

import java.sql.SQLException;

import com.umesolutions.e2eapp.dto.LoginDetails;

public interface LoginDAO {
	public LoginDetails getLoginDAOInfo(String username, String password) throws SQLException, Exception;
	
}
