package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.umesolutions.e2eapp.dao.DistributorDAO;
import com.umesolutions.e2eapp.dto.CategoryToDistributor;
import com.umesolutions.e2eapp.dto.RootCategory;

public class DistributorDAOImpl implements DistributorDAO {
	private DBConnection dbConnection;

	@Override
	public List<CategoryToDistributor> getDistributorList(String CategoryID) throws Exception {
		// TODO Auto-generated method stub
		dbConnection = new DBConnection();
		List<CategoryToDistributor> categoryToDistributorsList = new ArrayList<CategoryToDistributor>();

		Connection con = dbConnection.getConnection();
		try {

			String SQL = "select ctd.categoryID, c1.category_name, ctd.distributorID,dreg.distributor_name from category_to_distributor ctd, categories c1, distributor_registration dreg where ctd.categoryID=c1.category_id and c1.Category_Desc='Brand' and dreg.distributor_id=ctd.distributorID and ctd.categoryID='"+CategoryID+"'";
			System.out.println(SQL);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				CategoryToDistributor categoryToDistributor = new CategoryToDistributor();
				categoryToDistributor.setCategoryID(rs.getString(1));
				categoryToDistributor.setCategoryName(rs.getString(2));
				categoryToDistributor.setDistributorID(rs.getString(3));
				categoryToDistributor.setDistributorName(rs.getString(4));
				categoryToDistributorsList.add(categoryToDistributor);
			}
			if (categoryToDistributorsList.size() == 0) {
				return null;
			} else {
				return categoryToDistributorsList;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
