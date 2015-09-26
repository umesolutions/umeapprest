package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.umesolutions.e2eapp.dao.StoreDetailsDAO;
import com.umesolutions.e2eapp.dto.RetailerRegistration;
import com.umesolutions.e2eapp.dto.StoreDetails;

public class StoreDetailsDAOImpl implements StoreDetailsDAO {
	Logger logger=Logger.getLogger(StoreDetailsDAOImpl.class);
	private DBConnection dbConnection;
	private Connection con;

	public StoreDetailsDAOImpl() {
		// TODO Auto-generated constructor stub
		dbConnection = new DBConnection();
	}

	@Override
	public boolean createStore(StoreDetails storeDetails) {

		try {
			con = dbConnection.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
		}
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
			preparedStatement.setString(8, storeDetails.getStore_status());
			preparedStatement.setString(9, storeDetails.getLatitude());
			preparedStatement.setString(10, storeDetails.getLongitude());
			preparedStatement.setDate(11, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setDate(12, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setString(13, storeDetails.getApproved_store());
			preparedStatement.setString(14, storeDetails.getApprover_Distributor_id());
			if (preparedStatement.executeUpdate() > 0) {
				logger.error("Store details has been created :"+storeDetails.toString());
				return true;
			} else {
				logger.error("Store details creation"+storeDetails.toString()+" Failed ");
				return false;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateStore(StoreDetails storeDetails, String storeID){
		try {
			con = dbConnection.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
		}
		try {

			String sql = "UPDATE ume.store_details SET Retailer_id = ?, Store_id = ?, Store_Name = ?, Store_Address =?, Store_city = ?, Store_state = ?, Store_country =?, Store_status = ?, Latitude = ?, Longitude = ?, created_date =?, last_updated = ?, Approved_store =?, Approver_Distributor_id = ? WHERE Store_id = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, storeDetails.getRetailer_id());
			preparedStatement.setString(2, storeDetails.getStore_id());
			preparedStatement.setString(3, storeDetails.getStore_Name());
			preparedStatement.setString(4, storeDetails.getStore_Address());
			preparedStatement.setString(5, storeDetails.getStore_city());
			preparedStatement.setString(6, storeDetails.getStore_state());
			preparedStatement.setString(7, storeDetails.getStore_country());
			preparedStatement.setString(8, storeDetails.getStore_status());
			preparedStatement.setString(9, storeDetails.getLatitude());
			preparedStatement.setString(10, storeDetails.getLongitude());
			preparedStatement.setDate(11, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setDate(12, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setString(13, storeDetails.getApproved_store());
			preparedStatement.setString(14, storeDetails.getApprover_Distributor_id());
			preparedStatement.setString(15, storeID);
			if (preparedStatement.executeUpdate() > 0) {
				logger.info("store details has been created"+storeDetails.toString());
				return true;
			} else {
				logger.info("store details creation failed"+storeDetails.toString());
				return false;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteStore(String storeID) {
		try {
			con = dbConnection.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			String sql = "DELETE FROM ume.store_details WHERE Store_id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, storeID);
			if (preparedStatement.executeUpdate() > 0) {
				logger.info("Store "+storeID+" has been deleted");
				return true;
			} else {
				logger.info("deleting Store "+storeID+" failed");
				return false;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	@Override
	public StoreDetails getStoreDetails(String storeID) {
		try {
			con = dbConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		
		Statement st;
		try {
			st = con.createStatement();
			StoreDetails storeDetails = null;
			String sql = "SELECT * FROM ume.store_details where Store_id='" + storeID + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				storeDetails = new StoreDetails();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<StoreDetails> getAllStoreDetails() {
		try {
			con = dbConnection.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
		}
		List<StoreDetails> storeDetailsList = new ArrayList<StoreDetails>();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM ume.store_details";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				StoreDetails storeDetails = new StoreDetails();
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
			if (storeDetailsList.size() != 0){
				logger.info("Fetched store details:"+storeDetailsList.toString());
				return storeDetailsList;
			}
			else{
				logger.info("Store Details is empty");
				return null;
			}
				
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

}
