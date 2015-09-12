package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.umesolutions.e2eapp.dao.CategoriesDAO;
import com.umesolutions.e2eapp.dto.RootCategory;
import com.umesolutions.e2eapp.dto.SubCategories;

public class CategoriesDAOImpl implements CategoriesDAO {
	private DBConnection dbConnection;
	@Override
	public List<RootCategory> getRootCategoriesList() throws Exception {
		// TODO Auto-generated method stub
		dbConnection=new DBConnection();
		List <RootCategory> rootCategoriesList=new ArrayList<RootCategory>();
		
		Connection con= dbConnection.getConnection();
		try {
				
			String SQL = "select * from categories where Parent_category_id=''";
			System.out.println(SQL);
		     Statement st=con.createStatement();
		     ResultSet rs=st.executeQuery(SQL);
		     while(rs.next()){		    	 
		    	 RootCategory rootCategory=new RootCategory();
		         rootCategory.setCategory_ID(rs.getString(1));
		         rootCategory.setCategory_name(rs.getString(2));
		         rootCategoriesList.add(rootCategory);
		     }
		     if(rootCategoriesList.size()==0){
		    	 return null;
		     }
		     else
		     {
		    	 return rootCategoriesList;
		     }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}

	@Override
	public List<SubCategories> getSubCategories(String rootCategoryID) {
		// TODO Auto-generated method stub
		return null;
	}

}
