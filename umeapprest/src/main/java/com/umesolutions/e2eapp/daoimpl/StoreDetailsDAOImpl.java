package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.umesolutions.e2eapp.dao.StoreDetailsDAO;
import com.umesolutions.e2eapp.dto.RetailerRegistration;
import com.umesolutions.e2eapp.dto.StoreDetails;

public class StoreDetailsDAOImpl implements StoreDetailsDAO {
	private DBConnection dbConnection;

	public StoreDetailsDAOImpl() {
		// TODO Auto-generated constructor stub
		dbConnection = new DBConnection();
	}

	@Override
	public boolean createStore(StoreDetails storeDetails) throws Exception {
		Connection con = dbConnection.getConnection();
		try {
			String sql = "INSERT INTO ume.store_details (Retailer_id, Store_id, Store_Name, Store_Address, Store_city, Store_state, Store_country, Store_status, Latitude, Longitude, created_date, last_updated, Approved_store, Approver_Distributor_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, storeDetails.getRetailer_id());
			preparedStatement.setString(2, storeDetails.getStore_id());
			preparedStatement.setString(3, storeDetails.getStore_Name());
			preparedStatement.setString(4, storeDetails.getStore_Address());
			preparedStatement.setString(5, storeDetails.getStore_city());
			preparedStatement.setString(6, storeDetails.getStore_state());
			preparedStatement.setString(7, storeDetails.getStore_country());
			preparedStatement.setString(8,storeDetails.getStore_status());
			preparedStatement.setString(9, storeDetails.getLatitude());
			preparedStatement.setString(10, storeDetails.getLongitude());
			preparedStatement.setDate(11, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setDate(12, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setString(13, storeDetails.getApproved_store());
			preparedStatement.setString(14, storeDetails.getApprover_Distributor_id());
			if (preparedStatement.executeUpdate() > 0) {
				System.out.println("True :" + sql);
				return true;
			} else {
				System.out.println("False :" + sql);
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateStore(StoreDetails storeDetails, String storeID) throws Exception {
		Connection con=dbConnection.getConnection();
		try{
			
			String sql="UPDATE ume.store_details SET Retailer_id = ?, Store_id = ?, Store_Name = ?, Store_Address =?, Store_city = ?, Store_state = ?, Store_country =?, Store_status = ?, Latitude = ?, Longitude = ?, created_date =?, last_updated = ?, Approved_store =?, Approver_Distributor_id = ? WHERE Store_id = ?";
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, storeDetails.getRetailer_id());
			preparedStatement.setString(2, storeDetails.getStore_id());
			preparedStatement.setString(3, storeDetails.getStore_Name());
			preparedStatement.setString(4, storeDetails.getStore_Address());
			preparedStatement.setString(5, storeDetails.getStore_city());
			preparedStatement.setString(6, storeDetails.getStore_state());
			preparedStatement.setString(7, storeDetails.getStore_country());
			preparedStatement.setString(8,storeDetails.getStore_status());
			preparedStatement.setString(9, storeDetails.getLatitude());
			preparedStatement.setString(10, storeDetails.getLongitude());
			preparedStatement.setDate(11, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setDate(12, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setString(13, storeDetails.getApproved_store());
			preparedStatement.setString(14, storeDetails.getApprover_Distributor_id());
			preparedStatement.setString(15, storeID);
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
	public boolean deleteStore(String storeID) throws Exception {
		Connection con = dbConnection.getConnection();
		try{
			
			String sql="DELETE FROM ume.store_details WHERE Store_id=?";
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, storeID);
			if(preparedStatement.executeUpdate()>0){
				return true;
			}
			else{
				return false;
			}
				
		}catch(Exception e){	
		return false;
		}
	}

	@Override
	public StoreDetails getStoreDetails(String storeID) throws Exception {
		Connection con=dbConnection.getConnection();	
		StoreDetails storeDetails=null;
		Statement st=con.createStatement();		
		String sql="SELECT * FROM ume.store_details where Store_id='"+storeID+"'";
	     ResultSet rs=st.executeQuery(sql);
	     while(rs.next()){
	    	 storeDetails=new StoreDetails();
	    	 storeDetails.setRetailer_id(rs.getString(1));
	    	 storeDetails.setStore_id(rs.getString(2));
	    	 storeDetails.setStore_Name(rs.getString(3));
	    	 storeDetails.setStore_Address(rs.getString(4));
	    	 storeDetails.setStore_city(rs.getString(5));
	    	 storeDetails.setStore_state(rs.getString(6));
	    	 storeDetails.setStore_country(rs.getString(7));
	    	 storeDetails.setStore_status(rs.getString(8));
	    	 storeDetails.setLatitude(rs.getString(9));
	    	 storeDetails.setLongitude(rs.getString(10));
	    	 storeDetails.setCreated_date(rs.getDate(11));
	    	 storeDetails.setLast_updated(rs.getDate(12));
	    	 storeDetails.setApproved_store(rs.getString(13));
	    	 storeDetails.setApprover_Distributor_id(rs.getString(14));
	     }	     
		return storeDetails;
	}

	@Override
	public List<StoreDetails> getAllStoreDetails() throws SQLException, Exception {
		Connection con=dbConnection.getConnection();
		List<StoreDetails> storeDetailsList=new ArrayList<StoreDetails>();
		try{
		Statement st=con.createStatement();		
		String sql="SELECT * FROM ume.store_details";
	     ResultSet rs=st.executeQuery(sql);
	     while(rs.next()){
	    	 StoreDetails storeDetails=new StoreDetails();
	    	 storeDetails.setRetailer_id(rs.getString(1));
	    	 storeDetails.setStore_id(rs.getString(2));
	    	 storeDetails.setStore_Name(rs.getString(3));
	    	 storeDetails.setStore_Address(rs.getString(4));
	    	 storeDetails.setStore_city(rs.getString(5));
	    	 storeDetails.setStore_state(rs.getString(6));
	    	 storeDetails.setStore_country(rs.getString(7));
	    	 storeDetails.setStore_status(rs.getString(8));
	    	 storeDetails.setLatitude(rs.getString(9));
	    	 storeDetails.setLongitude(rs.getString(10));
	    	 storeDetails.setCreated_date(rs.getDate(11));
	    	 storeDetails.setLast_updated(rs.getDate(12));
	    	 storeDetails.setApproved_store(rs.getString(13));
	    	 storeDetails.setApprover_Distributor_id(rs.getString(14));
	    	 storeDetailsList.add(storeDetails);
	     }	     
	     if(storeDetailsList.size()!=0)
	    	 return storeDetailsList;
	     else
	    	 return null;
	}
		catch(Exception e){
			return null;
		}
	}

}
