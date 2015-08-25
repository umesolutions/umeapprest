package com.umesolutions.e2eapp.restservices;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.umesolutions.e2eapp.dto.LoginDetails;
import com.umesolutions.e2eapp.dto.RetailerRegistration;
import com.umesolutions.e2eapp.service.RequestLoginService;
import com.umesolutions.e2eapp.serviceimpl.RequestLoginServiceImpl;

@Path("/RegistrationService")
public class RegistrationService {
	@GET
	@Path("/AddRetailler")
	@Produces("application/json")
	public Response addRetailler(@QueryParam("retailerID") String retailerID,
			@QueryParam("retailerName") String retailerName,
			@QueryParam("address") String address,
			@QueryParam("city") String city,
			@QueryParam("state") String state,
			@QueryParam("country") String country,
			@QueryParam("phoneNumber") String phoneNumber,
			@QueryParam("emailID") String emailID,
			@QueryParam("phoneVerified") char phoneVerified,
			@QueryParam("emailVerified") char emailVerified,
			@QueryParam("phoneIME") String phoneIME) {
		RetailerRegistration retailerRegistration=new RetailerRegistration();
		retailerRegistration.setRetailer_ID(retailerID);
		retailerRegistration.setRetailer_Name(retailerName);
		retailerRegistration.setAddress(address);
		retailerRegistration.setCity(city);
		retailerRegistration.setState(state);
		retailerRegistration.setCountry(country);
		retailerRegistration.setPhone_number(Integer.parseInt(phoneNumber));
		retailerRegistration.setEmail_id(emailID);
		retailerRegistration.setPhone_verified(phoneVerified);
		retailerRegistration.setEmail_verified(emailVerified);
		retailerRegistration.setPhone_IME(phoneIME);
	    
		String result=null;
		return Response.status(200).entity(result).build();
	}
	@GET
	@Path("/UpdateRetailler")
	@Produces("application/json")
	public Response updateRetailler(@QueryParam("retailerID") String retailerID,
			@QueryParam("retailerName") String retailerName,
			@QueryParam("address") String address,
			@QueryParam("city") String city,
			@QueryParam("state") String state,
			@QueryParam("country") String country,
			@QueryParam("phoneNumber") String phoneNumber,
			@QueryParam("emailID") String emailID,
			@QueryParam("phoneVerified") char phoneVerified,
			@QueryParam("e tomailVerified") char emailVerified,
			@QueryParam("phoneIME") String phoneIME) {
		RetailerRegistration retailerRegistration=new RetailerRegistration();
		retailerRegistration.setRetailer_ID(retailerID);
		retailerRegistration.setRetailer_Name(retailerName);
		retailerRegistration.setAddress(address);
		retailerRegistration.setCity(city);
		retailerRegistration.setState(state);
		retailerRegistration.setCountry(country);
		retailerRegistration.setPhone_number(Integer.parseInt(phoneNumber));
		retailerRegistration.setEmail_id(emailID);
		retailerRegistration.setPhone_verified(phoneVerified);
		retailerRegistration.setEmail_verified(emailVerified);
		retailerRegistration.setPhone_IME(phoneIME);
	    
		String result=null;
		return Response.status(200).entity(result).build();
	}
}
