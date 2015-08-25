package com.umesolutions.e2eapp.service;

import java.util.List;

import com.umesolutions.e2eapp.dto.RetailerRegistration;

public interface RegistrationService {
	public boolean createRetailler(RetailerRegistration retaillerRegistration) throws Exception;
	public boolean updateRetailler(RetailerRegistration retaillerRegistration,String retailerID);
	public boolean deleteRetailler(String retaillerID);
	public RetailerRegistration getRetaillerDetails(String retaillerID);
	public List<RetailerRegistration> getAllRetaillerDetails();
}
