package com.umesolutions.e2eapp.restservices;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.umesolutions.e2eapp.dto.CategoryToDistributor;
import com.umesolutions.e2eapp.dto.SubCategories;
import com.umesolutions.e2eapp.service.CategoryService;
import com.umesolutions.e2eapp.service.DistributorService;
import com.umesolutions.e2eapp.serviceimpl.CategoriesServiceImpl;
import com.umesolutions.e2eapp.serviceimpl.DistributorServiceImpl;

@Path("/DistributorDetails")
public class DistributorDetailsService {
	@Path("getDistributorList")
	@GET
	@Produces("application/json")
	public Response getDistributorList(@QueryParam("categoryID") String categoryID) throws Exception {
		String result;
		DistributorService distributorService=new DistributorServiceImpl();
		Gson gson=new Gson();
		List<CategoryToDistributor> categoryToDistributorList=distributorService.getDistributorList(categoryID);
		if(categoryToDistributorList==null){
			result ="Distributor Not found";
			return Response.status(200).entity(result).build();
		}
		else{
		result=gson.toJson(categoryToDistributorList);		
		return Response.status(200).entity(result).build();
	}
	}
	

}
