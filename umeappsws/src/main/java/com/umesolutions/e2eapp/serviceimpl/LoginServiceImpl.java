package com.umesolutions.e2eapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umesolutions.e2eapp.dao.LoginDAO;
import com.umesolutions.e2eapp.dao.pojo.LoginDetailsPojo;
import com.umesolutions.e2eapp.login.LoginDetails;
import com.umesolutions.e2eapp.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginDAO loginDAO;

	@Override
	public LoginDetails getLoginInfo(String userName, String password) {
		// TODO Auto-generated method stub
		LoginDetailsPojo loginDetailsPojo = loginDAO.getLoginDAOInfo(userName, password);
		if (loginDetailsPojo == null) {
			return null;
		} else {
			LoginDetails loginDetails=new LoginDetails();
			loginDetails.setCustomerID(loginDetailsPojo.getCustomerID());
			loginDetails.setPassword(loginDetailsPojo.getPassword());
			loginDetails.setPassCode(loginDetailsPojo.getPassCode());
			loginDetails.setUserStatus(loginDetailsPojo.getUserStatus());
			loginDetails.setCreatedDate(loginDetailsPojo.getCreatedDate());
			loginDetails.setLastLoginDate(loginDetailsPojo.getLastLoginDate());
			return loginDetails;
		}
	}

}
