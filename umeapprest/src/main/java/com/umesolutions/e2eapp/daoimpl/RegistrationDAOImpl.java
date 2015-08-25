package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.umesolutions.e2eapp.dao.RegistrationDAO;
import com.umesolutions.e2eapp.dto.RetailerRegistration;

public class RegistrationDAOImpl implements RegistrationDAO {
	private DBConnection dbConnection;
	public RegistrationDAOImpl() {
		// TODO Auto-generated constructor stub
	dbConnection=new DBConnection();	
	}
	@Override
	public boolean createRetailler(RetailerRegistration retailerRegistration) throws Exception {
		// TODO Auto-generated method stub
		Connection con=dbConnection.getConnection();
		try{
			
			String sql="INSERT INTO ume.retailer_registration (Retailer_ID,Retailer_Name,Address,city,state,country,created_date,last_updated,Phone_number,email_id,Phone_verified,Email_verified,phone_IME) values (?,?,?,?,?,?,?,sysdate,sysdate,?,?,?,?,?)";
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, retailerRegistration.getRetailer_ID());
			preparedStatement.setString(2, retailerRegistration.getRetailer_Name());
			preparedStatement.setString(3, retailerRegistration.getAddress());
			preparedStatement.setString(4, retailerRegistration.getCity());
			preparedStatement.setString(5, retailerRegistration.getState());
			preparedStatement.setString(6, retailerRegistration.getCountry());
			preparedStatement.setInt(7, retailerRegistration.getPhone_number());
			preparedStatement.setString(8, retailerRegistration.getEmail_id());
			preparedStatement.setString(9, retailerRegistration.getPhone_verified()+"");
			preparedStatement.setString(10, retailerRegistration.getEmail_verified()+"");
			preparedStatement.setString(11, retailerRegistration.getPhone_IME());
			if(preparedStatement.executeUpdate()>0){
				return true;
			}
			else{
				return false;
			}
		}
		catch(SQLException e){
			con.close();
			return false;
		}
		finally{
			con.close();
		}
	}

	@Override
	public boolean updateRetailler(RetailerRegistration retaillerRegistration, String retailerID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRetailler(String retaillerID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RetailerRegistration getRetaillerDetails(String retaillerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RetailerRegistration> getAllRetaillerDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
