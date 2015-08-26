package com.umesolutions.e2eapp.serviceimpl;

import java.util.List;

import com.umesolutions.e2eapp.dao.RegistrationDAO;
import com.umesolutions.e2eapp.daoimpl.RegistrationDAOImpl;
import com.umesolutions.e2eapp.dto.RetailerRegistration;
import com.umesolutions.e2eapp.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

	RegistrationDAO registrationDao=new RegistrationDAOImpl();
	@Override
	public boolean createRetailler(RetailerRegistration retaillerRegistration) throws Exception {
		// TODO Auto-generated method stub
		return registrationDao.createRetailler(retaillerRegistration);
	}

	@Override
	public boolean updateRetailler(RetailerRegistration retaillerRegistration, String retailerID) throws Exception {
		// TODO Auto-generated method stub
		return registrationDao.updateRetailler(retaillerRegistration, retailerID);
	}

	@Override
	public boolean deleteRetailler(String retaillerID) throws Exception {
		// TODO Auto-generated method stub
		return registrationDao.deleteRetailler(retaillerID);
	}

	@Override
	public RetailerRegistration getRetaillerDetails(String retaillerID) {
		// TODO Auto-generated method stub
		try {
			return registrationDao.getRetaillerDetails(retaillerID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<RetailerRegistration> getAllRetaillerDetails() {
		// TODO Auto-generated method stub
		try {
			return registrationDao.getAllRetaillerDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
