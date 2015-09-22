package com.umesolutions.e2eapp.serviceimpl;

import java.sql.SQLException;

import com.umesolutions.e2eapp.dao.LoginDAO;
import com.umesolutions.e2eapp.daoimpl.LoginDAOImpl;
import com.umesolutions.e2eapp.dto.LoginDetails;
import com.umesolutions.e2eapp.service.RequestLoginService;

public class RequestLoginServiceImpl implements RequestLoginService{
    LoginDAO loginDAO;
	@Override
	public LoginDetails getLoginInfo(String userName, String password) throws SQLException, Exception {
		loginDAO=new LoginDAOImpl();
		
		return loginDAO.getLoginDAOInfo(userName, password);
		// TODO Auto-generated method stub
	}
	@Override
	public boolean addLoginDetails(LoginDetails loginDetails) throws Exception {
		// TODO Auto-generated method stub
		loginDAO=new LoginDAOImpl();
		System.out.println("Service Method Executed");
		return loginDAO.setLoginInfo(loginDetails);
	}

}
