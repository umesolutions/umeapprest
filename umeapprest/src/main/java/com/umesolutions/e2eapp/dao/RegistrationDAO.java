package com.umesolutions.e2eapp.dao;

import java.util.List;

import com.umesolutions.e2eapp.dto.RetailerRegistration;

public interface RegistrationDAO {
	public boolean createRetailler(RetailerRegistration retaillerRegistration) throws Exception;
	public boolean updateRetailler(RetailerRegistration retaillerRegistration,String retailerID);
	public boolean deleteRetailler(String retaillerID);
	public RetailerRegistration getRetaillerDetails(String retaillerID);
	public List<RetailerRegistration> getAllRetaillerDetails();
}
