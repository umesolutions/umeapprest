package com.umesolutions.e2eapp.restservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;

import com.google.gson.Gson;
import com.umesolutions.e2eapp.dto.LoginDetails;
import com.umesolutions.e2eapp.dto.RootCategory;
import com.umesolutions.e2eapp.service.CategoryService;
import com.umesolutions.e2eapp.service.RequestLoginService;
import com.umesolutions.e2eapp.serviceimpl.CategoriesServiceImpl;
import com.umesolutions.e2eapp.serviceimpl.RequestLoginServiceImpl;

@Path("/CategoriesDetails")
public class RestCategoryDetails {
	@Path("getRootCategoriesList")
	@GET
	@Produces("application/json")
	public Response requestLogin() throws Exception {

		String result;
		CategoryService categoryService=new CategoriesServiceImpl();
		Gson gson=new Gson();
		List<RootCategory> rootCategoriesList=categoryService.getRootCategoriesList();
		if(rootCategoriesList==null){
			result ="Categories Not found";
			return Response.status(200).entity(result).build();
		}
		else{
		result=gson.toJson(rootCategoriesList);		
		return Response.status(200).entity(result).build();
	}
	}

}
