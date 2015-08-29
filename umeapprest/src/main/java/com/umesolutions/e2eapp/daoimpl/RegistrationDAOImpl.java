package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.DatabaseMetaDataUsingInfoSchema;
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
			
			String sql="INSERT INTO ume.retailer_registration (Retailer_ID,Retailer_Name,Address,city,state,country,created_date,last_updated,Phone_number,email_id,Phone_verified,Email_verified,phone_IME,activationCode) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, retailerRegistration.getRetailer_ID());
			preparedStatement.setString(2, retailerRegistration.getRetailer_Name());
			preparedStatement.setString(3, retailerRegistration.getAddress());
			preparedStatement.setString(4, retailerRegistration.getCity());
			preparedStatement.setString(5, retailerRegistration.getState());
			preparedStatement.setString(6, retailerRegistration.getCountry());
			preparedStatement.setDate(7, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setDate(8, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setLong(9, retailerRegistration.getPhone_number());
			preparedStatement.setString(10, retailerRegistration.getEmail_id());
			preparedStatement.setString(11, retailerRegistration.getPhone_verified()+"");
			preparedStatement.setString(12, retailerRegistration.getEmail_verified()+"");
			preparedStatement.setString(13, retailerRegistration.getPhone_IME());
			preparedStatement.setString(14, retailerRegistration.getActivationCode());
			if(preparedStatement.executeUpdate()>0){
				System.out.println("True :"+sql);
				return true;
			}
			else{
				System.out.println("False :"+sql);
				return false;
			}
		}
		catch(SQLException e){
System.out.println(e.getMessage());
			return false;
		}
		finally{
		}
	}

	@Override
	public boolean updateRetailler(RetailerRegistration retailerRegistration, String retailerID) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("I'm in update method");
		Connection con=dbConnection.getConnection();
		try{
			
			String sql="UPDATE ume.retailer_registration SET Retailer_ID = ?, Retailer_Name = ?, Address = ?, city = ?, state = ?, country =?, Phone_number = ?, email_id = ?, Phone_verified =?, Email_verified = ?, phone_IME = ?, activationCode = ? WHERE Retailer_ID = ? ";
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, retailerRegistration.getRetailer_ID());
			preparedStatement.setString(2, retailerRegistration.getRetailer_Name());
			preparedStatement.setString(3, retailerRegistration.getAddress());
			preparedStatement.setString(4, retailerRegistration.getCity());
			preparedStatement.setString(5, retailerRegistration.getState());
			preparedStatement.setString(6, retailerRegistration.getCountry());
			preparedStatement.setLong(7, retailerRegistration.getPhone_number());
			preparedStatement.setString(8, retailerRegistration.getEmail_id());
			preparedStatement.setString(9, retailerRegistration.getPhone_verified()+"");
			preparedStatement.setString(10, retailerRegistration.getEmail_verified()+"");
			preparedStatement.setString(11, retailerRegistration.getPhone_IME());
			preparedStatement.setString(12, retailerRegistration.getActivationCode());
			preparedStatement.setString(13, retailerID);
			System.out.println(retailerRegistration.toString());
			if(preparedStatement.executeUpdate()>0){
				System.out.println("Success");
				return true;
			}
			else{
				System.out.println("Failed");
				return false;
			}
		}
		catch(SQLException e){
			System.out.println("Error:"+e.getMessage());
			return false;
		}
		}

	@Override
	public boolean deleteRetailler(String retaillerID) throws Exception {
		// TODO Auto-generated method stub
		Connection con = dbConnection.getConnection();
		try{
			
			String sql="DELETE FROM ume.retailer_registration WHERE Retailer_ID=?";
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, retaillerID);
			if(preparedStatement.executeUpdate()>0){
				return true;
			}
			else{
				return false;
			}
				
		}catch(Exception e){	
		return false;
		}
		finally{
		}
	}

	@Override
	public RetailerRegistration getRetaillerDetails(String retaillerID) throws Exception {
		// TODO Auto-generated method stub
		Connection con=dbConnection.getConnection();	
		RetailerRegistration retailerRegistration=null;
		Statement st=con.createStatement();		
		String sql="SELECT * FROM ume.retailer_registration where Retailer_ID='"+retaillerID+"'";
	     ResultSet rs=st.executeQuery(sql);
	     while(rs.next()){
	    	 retailerRegistration=new RetailerRegistration();
	    	 retailerRegistration.setRetailer_ID(rs.getString(1));
	    	 retailerRegistration.setRetailer_Name(rs.getString(2));
	    	 retailerRegistration.setAddress(rs.getString(3));
	    	 retailerRegistration.setCity(rs.getString(4));
	    	 retailerRegistration.setState(rs.getString(5));
	    	 retailerRegistration.setCountry(rs.getString(6));
	    	 retailerRegistration.setCreated_date(rs.getDate(7));
	    	 retailerRegistration.setLast_updated(rs.getDate(8));
	    	 retailerRegistration.setPhone_number(rs.getInt(9));
	    	 retailerRegistration.setEmail_id(rs.getString(10));
	    	 retailerRegistration.setPhone_verified(rs.getString(11));
	    	 retailerRegistration.setEmail_verified(rs.getString(12));
	    	 retailerRegistration.setPhone_IME(rs.getString(13));
	    	 retailerRegistration.setActivationCode(rs.getString(14)); 
	     }	     
		return retailerRegistration;
	}

	@Override
	public List<RetailerRegistration> getAllRetaillerDetails() throws Exception {
		
		Connection con=dbConnection.getConnection();
		List<RetailerRegistration> retailerRegistrationList=new ArrayList<RetailerRegistration>();
		try{
		Statement st=con.createStatement();		
		String sql="SELECT * FROM ume.retailer_registration";
	     ResultSet rs=st.executeQuery(sql);
	     while(rs.next()){
	    	 RetailerRegistration retailerRegistration=new RetailerRegistration();
	    	 retailerRegistration.setRetailer_ID(rs.getString(1));
	    	 retailerRegistration.setRetailer_Name(rs.getString(2));
	    	 retailerRegistration.setAddress(rs.getString(3));
	    	 retailerRegistration.setCity(rs.getString(4));
	    	 retailerRegistration.setState(rs.getString(5));
	    	 retailerRegistration.setCountry(rs.getString(6));
	    	 retailerRegistration.setCreated_date(rs.getDate(7));
	    	 retailerRegistration.setLast_updated(rs.getDate(8));
	    	 retailerRegistration.setPhone_number(rs.getInt(9));
	    	 retailerRegistration.setEmail_id(rs.getString(10));
	    	 retailerRegistration.setPhone_verified(rs.getString(11));
	    	 retailerRegistration.setEmail_verified(rs.getString(12));
	    	 retailerRegistration.setPhone_IME(rs.getString(13));
	    	 retailerRegistration.setActivationCode(rs.getString(14));
	    	 retailerRegistrationList.add(retailerRegistration);
	     }	     
	     if(retailerRegistrationList.size()!=0)
	    	 return retailerRegistrationList;
	     else
	    	 return null;
	}
		catch(Exception e){
			return null;
		}
		finally {
		}
	}

}
