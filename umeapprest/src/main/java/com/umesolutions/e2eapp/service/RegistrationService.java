package com.umesolutions.e2eapp.service;

import java.sql.SQLException;
import java.util.List;

import com.umesolutions.e2eapp.dto.RetailerRegistration;

public interface RegistrationService {
	public boolean createRetailler(RetailerRegistration retaillerRegistration) throws Exception;
	public boolean updateRetailler(RetailerRegistration retaillerRegistration,String retailerID) throws Exception;
	public boolean deleteRetailler(String retaillerID) throws Exception;
	public RetailerRegistration getRetaillerDetails(String retaillerID);
	public List<RetailerRegistration> getAllRetaillerDetails();
	public String sendActivationCode(String mobileNumber, String name)throws SQLException, Exception;
	public RetailerRegistration validationActivationCode(String mobileNumber, String name, String activationCode) throws Exception;
}
