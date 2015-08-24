package com.umesolutions.e2eapp.serviceimpl;

import com.umesolutions.e2eapp.dao.RegistrationRequestDAO;
import com.umesolutions.e2eapp.daoimpl.RegistrationRequestDAOImpl;
import com.umesolutions.e2eapp.dto.RegistrationRequest;
import com.umesolutions.e2eapp.service.RequestRegistrationService;

public class RequestRegistrationServiceImpl implements RequestRegistrationService{

	RegistrationRequestDAO registrationRequestDAO;
	
	@Override
	public boolean getUpdateRequestDetails(String distributorID, String activationCode, String retailerPhone)
			throws Exception {
		registrationRequestDAO =new RegistrationRequestDAOImpl();
		return registrationRequestDAO.getUpdateRequestDetails(distributorID, activationCode, retailerPhone);
	}

	@Override
	public RegistrationRequest getRegReqObject(String activationCode) throws Exception {
		registrationRequestDAO =new RegistrationRequestDAOImpl();
		return registrationRequestDAO.getRegReqObject(activationCode);
	}

}
