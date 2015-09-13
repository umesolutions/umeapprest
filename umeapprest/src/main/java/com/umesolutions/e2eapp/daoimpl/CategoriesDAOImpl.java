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
		dbConnection = new DBConnection();
		List<RootCategory> rootCategoriesList = new ArrayList<RootCategory>();

		Connection con = dbConnection.getConnection();
		try {

			String SQL = "select * from categories where Parent_category_id=''";
			System.out.println(SQL);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				RootCategory rootCategory = new RootCategory();
				rootCategory.setCategory_ID(rs.getString(1));
				rootCategory.setCategory_name(rs.getString(2));
				rootCategoriesList.add(rootCategory);
			}
			if (rootCategoriesList.size() == 0) {
				return null;
			} else {
				return rootCategoriesList;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<SubCategories> getSubCategories(String rootCategoryID, String rootCategoryName) throws Exception {
		dbConnection = new DBConnection();
		List<SubCategories> subCategoriesList = new ArrayList<SubCategories>();

		Connection con = dbConnection.getConnection();
		try {
			String SQL = "";
			if (rootCategoryID == null && rootCategoryName == null) {
				SQL += "select * from categories where Parent_category_id!=''";
			} else if (rootCategoryName != null) {
				SQL = "select c1.category_id,c1.Category_name,c2.Category_ID,c2.Category_name,c2.Category_Desc from categories c1, categories c2 where c1.category_id=c2.parent_category_id and c2.parent_category_id='"
						+ rootCategoryID + "'";
			} else if (rootCategoryID != null) {
				SQL = "select c1.category_id,c1.Category_name,c2.Category_ID,c2.Category_name,c2.Category_Desc from categories c1, categories c2 where c1.category_id=c2.parent_category_id and c1.category_name='"
						+ rootCategoryName + "'";
			} else {
				SQL = "select c1.category_id,c1.Category_name,c2.Category_ID,c2.Category_name,c2.Category_Desc from categories c1, categories c2 where c1.category_id=c2.parent_category_id and c1.category_name='"
						+ rootCategoryName + "' and c2.parent_category_id='" + rootCategoryID + "'";
			}
			System.out.println(SQL);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				SubCategories subCategories = new SubCategories();
				subCategories.setParent_category_id(rs.getString(1));
				subCategories.setParent_category_name(rs.getString(2));
				subCategories.setCategory_ID(rs.getString(3));
				subCategories.setCategory_name(rs.getString(4));
				subCategories.setCategory_desc(rs.getString(5));
				subCategoriesList.add(subCategories);
			}
			if (subCategoriesList.size() == 0) {
				return null;
			} else {
				return subCategoriesList;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
