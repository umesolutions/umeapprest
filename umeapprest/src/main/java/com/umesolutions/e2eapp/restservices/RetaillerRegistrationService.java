package com.umesolutions.e2eapp.restservices;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.umesolutions.e2eapp.dto.RetailerRegistration;
import com.umesolutions.e2eapp.service.RegistrationService;
import com.umesolutions.e2eapp.serviceimpl.RegistrationServiceImpl;

@Path("/RegistrationService")
public class RetaillerRegistrationService {
	RegistrationService registrationService;

	@GET
	@Path("/AddRetailer")
	@Produces("application/json")
	public Response addRetailler(@QueryParam("retailerID") String retailerID,
			@QueryParam("retailerName") String retailerName, @QueryParam("address") String address,
			@QueryParam("city") String city, @QueryParam("state") String state, @QueryParam("country") String country,
			@QueryParam("phoneNumber") String phoneNumber, @QueryParam("emailID") String emailID,
			@QueryParam("phoneVerified") String phoneVerified, @QueryParam("emailVerified") String emailVerified,
			@QueryParam("phoneIME") String phoneIME, @QueryParam("activationCode") String activationCode) throws Exception {
		String result = null;
		registrationService = new RegistrationServiceImpl();
		RetailerRegistration retailerRegistration = new RetailerRegistration();
		retailerRegistration.setRetailer_ID(retailerID);
		retailerRegistration.setRetailer_Name(retailerName);
		retailerRegistration.setAddress(address);
		retailerRegistration.setCity(city);
		retailerRegistration.setState(state);
		retailerRegistration.setCountry(country);
		retailerRegistration.setPhone_number(Long.parseLong(phoneNumber));
		retailerRegistration.setEmail_id(emailID);
		retailerRegistration.setPhone_verified(phoneVerified);
		retailerRegistration.setEmail_verified(emailVerified);
		retailerRegistration.setPhone_IME(phoneIME);
		retailerRegistration.setActivationCode(activationCode);
			boolean value=registrationService.createRetailler(retailerRegistration);
			if (value) {
				result = retailerRegistration.getRetailer_ID() + " retailer account has been created successfully";
			} else {
				result="Account creation failed.";
			}
			System.out.println(result+": "+value);
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/UpdateRetailer")
	@Produces("application/json")
	public Response updateRetailler(@QueryParam("retailerID") String retailerID,
			@DefaultValue("noval") @QueryParam("retailerName") String retailerName, 
			@DefaultValue("noval") @QueryParam("address") String address,
			@DefaultValue("noval")  @QueryParam("city") String city, 
			@DefaultValue("noval") @QueryParam("state") String state, 
			@DefaultValue("noval") @QueryParam("country") String country,
			@DefaultValue("0") @QueryParam("phoneNumber") String phoneNumber, 
			@DefaultValue("noval") @QueryParam("emailID") String emailID,
			@DefaultValue("x") @QueryParam("phoneVerified") String phoneVerified, 
			@DefaultValue("x") @QueryParam("emailVerified") String emailVerified,
			@DefaultValue("noval") @QueryParam("phoneIME") String phoneIME, 
			@DefaultValue("noval") @QueryParam("activationCode") String activationCode) throws Exception {
		registrationService = new RegistrationServiceImpl();
		RetailerRegistration retailerRegistration =registrationService.getRetaillerDetails(retailerID);
		System.out.println("RetailerID"+retailerID);
		retailerRegistration.setRetailer_Name(retailerName.equalsIgnoreCase("noval")?retailerRegistration.getRetailer_Name():retailerName);
		retailerRegistration.setAddress(address.equalsIgnoreCase("noval")?retailerRegistration.getAddress():address);
		retailerRegistration.setCity(city.equalsIgnoreCase("noval")?retailerRegistration.getCity():city);
		retailerRegistration.setState(state.equalsIgnoreCase("noval")?retailerRegistration.getState():state);
		retailerRegistration.setCountry(country.equalsIgnoreCase("noval")?retailerRegistration.getCountry():country);
		retailerRegistration.setPhone_number(phoneNumber.equalsIgnoreCase("0")?retailerRegistration.getPhone_number():Long.parseLong(phoneNumber));
		retailerRegistration.setEmail_id(emailID.equalsIgnoreCase("noval")?retailerRegistration.getEmail_id():emailID);
		retailerRegistration.setPhone_verified(phoneVerified.equalsIgnoreCase("x")?retailerRegistration.getPhone_verified():phoneVerified);
		retailerRegistration.setEmail_verified(emailVerified.equalsIgnoreCase("x")?retailerRegistration.getEmail_verified():emailVerified);
		retailerRegistration.setPhone_IME(phoneIME.equalsIgnoreCase("noval")?retailerRegistration.getPhone_IME():phoneIME);
		retailerRegistration.setActivationCode(activationCode.equalsIgnoreCase("noval")?retailerRegistration.getActivationCode():activationCode);
		String result = null;
		System.out.println("Objected Created");
		boolean value=registrationService.updateRetailler(retailerRegistration, retailerID);
		if(value){
			result= retailerID+" Details hass been udpated successfully";
		}
		else{
			result=retailerID+" updation failed";
		}
		System.out.println("Value :"+value);
		return Response.status(200).entity(result).build();
	}
	@GET
	@Path("/deleteRetailer")
	@Produces("application/json")
	public Response deleteRetailler(@QueryParam("retailerID") String retailerID) {
		String result = null;
		registrationService = new RegistrationServiceImpl();
		try {
			registrationService.deleteRetailler(retailerID);
			result=retailerID+" profile has been deleted";
		} catch (Exception e) {
			result="Account deletion failed";
		}
		return Response.status(200).entity(result).build();
	}
	@GET
	@Path("/getRetailer")
	@Produces("application/json")
	public Response getRetailler(@QueryParam("retailerID") String retailerID) {
		String result=null;
		registrationService = new RegistrationServiceImpl();
		try{
		RetailerRegistration retailerRegistration=registrationService.getRetaillerDetails(retailerID);
		if(retailerRegistration!=null){
		Gson gson=new Gson();
		result=gson.toJson(retailerRegistration);
		}
		else{
			result="sorry for inconvenient. Not able retrieve Retailer details. Please try again.";
		}
		}catch(Exception e){
			result="sorry for inconvenient. Not able retrieve Retailer details. Please try again.";
		}
		return Response.status(200).entity(result).build();
	}
	@GET
	@Path("/getAllRetailer")
	@Produces("application/json")
	public Response getAllRetailler() {
		String result=null;
		registrationService = new RegistrationServiceImpl();
		try{
		List<RetailerRegistration> retailerRegistrationList=registrationService.getAllRetaillerDetails();
		if(retailerRegistrationList.size()!=0){
		Gson gson=new Gson();
		result=gson.toJson(retailerRegistrationList);
		}
		else{
			result="sorry for inconvenient. Not able retireve Retailer details. Please try again.";
		}
		}catch(Exception e){
			result="sorry for inconvenient. Not able retireve Retailer details. Please try again.";
		}
		return Response.status(200).entity(result).build();
	}
	@GET
	@Path("/getActivationCode")
	@Produces("application/json")
	public Response getActivationCode(@DefaultValue("noval") @QueryParam("retailerName") String retailerName, @QueryParam("phoneNumber") String phoneNumber) {
		String result=null;
		registrationService = new RegistrationServiceImpl();
		try{
		String ActivationCode=registrationService.sendActivationCode(phoneNumber, retailerName);
		if(ActivationCode!=null){
		result=ActivationCode;
		}
		else{
			result="sorry for inconvenient. Not able retireve Retailer details. Please try again.";
		}
		}catch(Exception e){
			result="sorry for inconvenient. Not able retireve Retailer details. Please try again.";
		}
		return Response.status(200).entity(result).build();
	}	

@GET
@Path("/ValidateActivationCodes")
@Produces("application/json")
public Response ValidateActivationCodes(@DefaultValue("noval") @QueryParam("retailerName") String retailerName, 
		@DefaultValue("0") @QueryParam("phoneNumber") String phoneNumber, 
		@DefaultValue("noval") @QueryParam("activationCode") String activationCode) {
	String result=null;
	registrationService = new RegistrationServiceImpl();
	try{
	RetailerRegistration retailerRegistration=registrationService.validationActivationCode(phoneNumber, retailerName, activationCode);
	if(retailerRegistration!=null){
		Gson gson=new Gson();
		result=gson.toJson(retailerRegistration);
	}
	else{
		result="sorry for inconvenient. Not able retireve Retailer details. Please try again.";
	}
	}catch(Exception e){
		result="sorry for inconvenient. Not able retireve Retailer details. Please try again.";
	}
	return Response.status(200).entity(result).build();
}	
}