package com.umesolutions.e2eapp.restservices;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;

import com.google.gson.Gson;
import com.umesolutions.e2eapp.dto.LoginDetails;
import com.umesolutions.e2eapp.dto.RootCategory;
import com.umesolutions.e2eapp.dto.SubCategories;
import com.umesolutions.e2eapp.service.CategoryService;
import com.umesolutions.e2eapp.service.RequestLoginService;
import com.umesolutions.e2eapp.serviceimpl.CategoriesServiceImpl;
import com.umesolutions.e2eapp.serviceimpl.RequestLoginServiceImpl;

@Path("/CategoriesDetails")
public class RestCategoryDetails {
	@Path("getRootCategoriesList")
	@GET
	@Produces("application/json")
	public Response getRootCategories() throws Exception {

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
	@Path("getSubCategoriesList")
	@GET
	@Produces("application/json")
	public Response getSubCategories(@DefaultValue("noval") @QueryParam("categoryID") String rootCategoryID,
			@DefaultValue("noval") @QueryParam("categoryName") String rootCategoryName) throws Exception {

		String result;
		CategoryService categoryService=new CategoriesServiceImpl();
		Gson gson=new Gson();
		rootCategoryID=(rootCategoryID.equalsIgnoreCase("noval") && rootCategoryID==null) ?null:rootCategoryID;
		rootCategoryName=(rootCategoryName.equalsIgnoreCase("noval") && rootCategoryName==null) ?null:rootCategoryName;
		List<SubCategories> subCategoriesList=categoryService.getSubCategories(rootCategoryID, rootCategoryName);
		if(subCategoriesList==null){
			result ="Sub Categories Not found";
			return Response.status(200).entity(result).build();
		}
		else{
		result=gson.toJson(subCategoriesList);		
		return Response.status(200).entity(result).build();
	}
	}
}
