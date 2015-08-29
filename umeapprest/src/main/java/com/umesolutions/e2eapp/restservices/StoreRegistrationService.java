package com.umesolutions.e2eapp.restservices;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.umesolutions.e2eapp.dto.StoreDetails;
import com.umesolutions.e2eapp.service.StoreDetailsService;
import com.umesolutions.e2eapp.serviceimpl.StoreDetailsServiceImpl;
@Path("/StoreRegistrationService")
public class StoreRegistrationService{
	private String Retailer_id;
	private String Store_id;
	private String Store_Name;
	private String Store_Address;
	private String Store_city;
	private String Store_state;
	private String Store_country;
	private String Store_status;
	private String Latitude;
	private String Longitude;
	private Date created_date;
	private Date last_updated;
	private String Approved_store;
	private String Approver_Distributor_id;
	StoreDetailsService storeDetailsService;

	@GET
	@Path("/AddStore")
	@Produces("application/json")
	public Response addRetailler(@QueryParam("Retailer_id") String Retailer_id,
			@QueryParam("Store_id") String Store_id, @QueryParam("Store_Name") String Store_Name,
			@QueryParam("Store_Address") String Store_Address, @QueryParam("Store_city") String Store_city, 
			@QueryParam("Store_state") String Store_state,
			@QueryParam("Store_country") String Store_country, @QueryParam("Store_status") String Store_status,
			@QueryParam("Latitude") String Latitude, @QueryParam("Longitude") String Longitude,
			@QueryParam("Approved_store") String Approved_store, @QueryParam("Approver_Distributor_id") String Approver_Distributor_id) throws Exception {
		String result = null;
		storeDetailsService = new StoreDetailsServiceImpl();
		StoreDetails storeDetails = new StoreDetails();
		storeDetails.setRetailer_id(Retailer_id);
		storeDetails.setStore_id(Store_id);
		storeDetails.setStore_Name(Store_Name);
		storeDetails.setStore_Address(Store_Address);
		storeDetails.setStore_city(Store_city);
		storeDetails.setStore_state(Store_state);
		storeDetails.setStore_country(Store_country);
		storeDetails.setStore_status(Store_status);
		storeDetails.setLatitude(Latitude);
		storeDetails.setLongitude(Longitude);
		storeDetails.setApproved_store(Approved_store);
		storeDetails.setApprover_Distributor_id(Approver_Distributor_id);
		
		boolean value=storeDetailsService.createStore(storeDetails);
			if (value) {
				result = storeDetails.getRetailer_id() + " retailer account has been created successfully";
			} else {
				result="Account creation failed.";
			}
			System.out.println(result+": "+value);
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/updateStore")
	@Produces("application/json")
	public Response updateRetailler(@DefaultValue("noval") @QueryParam("Retailer_id") String Retailer_id,
			@QueryParam("Store_id") String Store_id, 
			@DefaultValue("noval") @QueryParam("Store_Name") String Store_Name,
			@DefaultValue("noval") @QueryParam("Store_Address") String Store_Address, 
			@DefaultValue("noval") @QueryParam("Store_city") String Store_city, 
			@DefaultValue("noval") @QueryParam("Store_state") String Store_state,
			@DefaultValue("noval") @QueryParam("Store_country") String Store_country, 
			@DefaultValue("noval") @QueryParam("Store_status") String Store_status,
			@DefaultValue("noval") @QueryParam("Latitude") String Latitude, 
			@DefaultValue("noval") @QueryParam("Longitude") String Longitude,
			@DefaultValue("noval") @QueryParam("Approved_store") String Approved_store, 
			@DefaultValue("noval") @QueryParam("Approver_Distributor_id") String Approver_Distributor_id) throws Exception {
		storeDetailsService=new StoreDetailsServiceImpl();
		StoreDetails storeDetails =storeDetailsService.getStoreDetails(Store_id);
		storeDetails.setRetailer_id(Retailer_id.equalsIgnoreCase("noval")?storeDetails.getRetailer_id():Retailer_id);
		storeDetails.setStore_id(Store_id);
		storeDetails.setStore_Name(Store_Name.equalsIgnoreCase("noval")?storeDetails.getStore_Name():Store_Name);
		storeDetails.setStore_Address(Store_Address.equalsIgnoreCase("noval")?storeDetails.getStore_Address():Store_Address);
		storeDetails.setStore_city(Store_city.equalsIgnoreCase("noval")?storeDetails.getStore_city():Store_city);
		storeDetails.setStore_state(Store_state.equalsIgnoreCase("noval")?storeDetails.getStore_state():Store_state);
		storeDetails.setStore_country(Store_country.equalsIgnoreCase("noval")?storeDetails.getStore_country():Store_country);
		storeDetails.setStore_status(Store_status.equalsIgnoreCase("noval")?storeDetails.getStore_status():Store_status);
		storeDetails.setLatitude(Latitude.equalsIgnoreCase("noval")?storeDetails.getLatitude():Latitude);
		storeDetails.setLongitude(Longitude.equalsIgnoreCase("noval")?storeDetails.getLongitude():Longitude);
		storeDetails.setApproved_store(Approved_store.equalsIgnoreCase("noval")?storeDetails.getApproved_store():Approved_store);
		storeDetails.setApprover_Distributor_id(Approver_Distributor_id.equalsIgnoreCase("noval")?storeDetails.getApprover_Distributor_id():Approver_Distributor_id);
		String result = null;
		boolean value=storeDetailsService.updateStore(storeDetails, Store_id);
		if(value){
			result= Store_id+" Details hass been udpated successfully";
		}
		else{
			result=Store_id+" updation failed";
		}
		System.out.println("Value :"+value);
		return Response.status(200).entity(result).build();
	}
	@GET
	@Path("/deleteStore")
	@Produces("application/json")
	public Response deleteRetailler(@QueryParam("Store_id") String Store_id) {
		String result = null;
		storeDetailsService=new StoreDetailsServiceImpl();
		try {
			storeDetailsService.deleteStore(Store_id);
			result=Store_id+" has been deleted";
		} catch (Exception e) {
			result="Account deletion failed";
		}
		return Response.status(200).entity(result).build();
	}
	@GET
	@Path("/getStoreDetails")
	@Produces("application/json")
	public Response getRetailler(@QueryParam("Store_id") String Store_id) {
		String result=null;
		storeDetailsService=new StoreDetailsServiceImpl();
		try{
		StoreDetails storeDetails=storeDetailsService.getStoreDetails(Store_id);
		if(storeDetails!=null){
		Gson gson=new Gson();
		result=gson.toJson(storeDetails);
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
	@Path("/getAllStore")
	@Produces("application/json")
	public Response getAllRetailler() {
		String result=null;
		storeDetailsService=new StoreDetailsServiceImpl();
		try{
		List<StoreDetails> storeDetailsList=storeDetailsService.getAllStoreDetails();
		if(storeDetailsList.size()!=0){
		Gson gson=new Gson();
		result=gson.toJson(storeDetailsList);
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
