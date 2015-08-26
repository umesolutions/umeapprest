package com.umesolutions.e2eapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.umesolutions.e2eapp.dto.RetailerRegistration;

public interface RegistrationDAO {
	public boolean createRetailler(RetailerRegistration retaillerRegistration) throws Exception;
	public boolean updateRetailler(RetailerRegistration retaillerRegistration,String retailerID) throws Exception;
	public boolean deleteRetailler(String retaillerID) throws Exception;
	public RetailerRegistration getRetaillerDetails(String retaillerID) throws Exception;
	public List<RetailerRegistration> getAllRetaillerDetails() throws SQLException, Exception;
}
