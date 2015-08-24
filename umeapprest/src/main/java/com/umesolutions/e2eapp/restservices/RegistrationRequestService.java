package com.umesolutions.e2eapp.restservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;

import com.google.gson.Gson;
import com.umesolutions.e2eapp.dto.RegistrationRequest;
import com.umesolutions.e2eapp.service.RequestRegistrationService;
import com.umesolutions.e2eapp.serviceimpl.RequestRegistrationServiceImpl;

@Path("/RegReqService")
public class RegistrationRequestService {
	RequestRegistrationService requestRegistrationService; 
	@GET
	@Produces("application/json")
	public Response requestLogin() throws JSONException {
		String result;
		result="Welcome to App Request Service";
		return Response.status(200).entity(result).build();
	}

	@Path("/ReqSend")
	@GET
	@Produces("application/json")
	public Response sendRequest(
			@QueryParam("distributorID") String distributorID,
			@QueryParam("activationCode") String activationCode,
			@QueryParam("retailerPhone") String retailerPhone) throws Exception {	
		String result;
		requestRegistrationService=new RequestRegistrationServiceImpl();
		if(requestRegistrationService.getUpdateRequestDetails(distributorID, activationCode, retailerPhone)){
			result="Activation Code Send successfully";	
		}
		else{
			result="Please verify your input";
		} 
		return Response.status(200).entity(result).build();
	}

	@Path("/SendReqDetails")
	@GET
	@Produces("application/json")
	public Response getSendRequest(
			@QueryParam("activationCode") String activationCode) throws Exception{
		String result;
		requestRegistrationService=new RequestRegistrationServiceImpl();
		RegistrationRequest registrationRequest=requestRegistrationService.getRegReqObject(activationCode);
		if(registrationRequest!=null){
			Gson gson=new Gson();
			result=gson.toJson(registrationRequest);
		}
		else{
			result="Please verify your input";
		} 
		return Response.status(200).entity(result).build();
	}
}
