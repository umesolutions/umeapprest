package com.umesolutions.e2eapp.restservices;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;

import com.google.gson.Gson;
import com.umesolutions.e2eapp.dao.LoginDAO;
import com.umesolutions.e2eapp.daoimpl.LoginDAOImpl;
import com.umesolutions.e2eapp.dto.LoginDetails;
import com.umesolutions.e2eapp.service.RequestLoginService;
import com.umesolutions.e2eapp.serviceimpl.RequestLoginServiceImpl;

@Path("/LoginService")
public class RestLoginService {
	@GET
	@Produces("application/json")
	public Response requestLogin() throws JSONException {

		String result;
		Gson gson = new Gson();
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setCustomerID("12345");
		loginDetails.setPassword("password");
		loginDetails.setPassCode("1234");
		loginDetails.setCreatedDate("date");
		result = gson.toJson(loginDetails);
		return Response.status(200).entity(result).build();
	}

	@Path("{userName}/{password}")
	@GET
	@Produces("application/json")
	public Response convertFtoCfromInput(@PathParam("userName") String userName, @PathParam("password") String password)
			throws SQLException, Exception {
		String result; 
		RequestLoginService loginsservice=new RequestLoginServiceImpl();
		Gson gson=new Gson();
		LoginDetails loginDetails=loginsservice.getLoginInfo(userName, password);
		if(loginDetails==null){
			result ="User Not Found";
			return Response.status(200).entity(result).build();
		}
		else{
		result=gson.toJson(loginDetails);		
		return Response.status(200).entity(result).build();
	}
}
}
