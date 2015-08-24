package com.umesolutions.e2eapp.dao;

import com.umesolutions.e2eapp.dto.RegistrationRequest;

public interface RegistrationRequestDAO {
public boolean getUpdateRequestDetails(String distributorID, String activationCode, String retailerPhone) throws Exception;
public RegistrationRequest getRegReqObject(String activationCode) throws Exception;
}
