package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.mysql.jdbc.DatabaseMetaDataUsingInfoSchema;
import com.umesolutions.e2eapp.dao.RegistrationDAO;
import com.umesolutions.e2eapp.dto.RetailerRegistration;

public class RegistrationDAOImpl implements RegistrationDAO {
	Logger logger = Logger.getLogger(RegistrationDAOImpl.class);
	private DBConnection dbConnection;
	private Connection con;

	public RegistrationDAOImpl() {
		// TODO Auto-generated constructor stub
		dbConnection = new DBConnection();
	}

	@Override
	public boolean createRetailler(RetailerRegistration retailerRegistration) {
		// TODO Auto-generated method stub

		try {
			con = dbConnection.getConnection();
			logger.info("Database Connection has been created");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
		}
		try {

			String sql = "INSERT INTO ume.retailer_registration (Retailer_ID,Retailer_Name,Address,city,state,country,created_date,last_updated,Phone_number,email_id,Phone_verified,Email_verified,phone_IME,activationCode) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			logger.info("SQL "+sql);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
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
			preparedStatement.setString(11, retailerRegistration.getPhone_verified() + "");
			preparedStatement.setString(12, retailerRegistration.getEmail_verified() + "");
			preparedStatement.setString(13, retailerRegistration.getPhone_IME());
			preparedStatement.setString(14, retailerRegistration.getActivationCode());
			if (preparedStatement.executeUpdate() > 0) {
			logger.info("Retailer details has been created");
				return true;
			} else {
				logger.info("Retailer creation failed");
				return false;
			}
		} catch (SQLException e) {
			logger.info(e.getMessage());
			return false;
		} 
	}

	@Override
	public boolean updateRetailler(RetailerRegistration retailerRegistration, String retailerID) {
		// TODO Auto-generated method stub
		System.out.println("I'm in update method");
		try {
			con = dbConnection.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
		}
		try {

			String sql = "UPDATE ume.retailer_registration SET Retailer_ID = ?, Retailer_Name = ?, Address = ?, city = ?, state = ?, country =?, Phone_number = ?, email_id = ?, Phone_verified =?, Email_verified = ?, phone_IME = ?, activationCode = ? WHERE Retailer_ID = ? ";
			logger.info("SQL "+sql);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, retailerRegistration.getRetailer_ID());
			preparedStatement.setString(2, retailerRegistration.getRetailer_Name());
			preparedStatement.setString(3, retailerRegistration.getAddress());
			preparedStatement.setString(4, retailerRegistration.getCity());
			preparedStatement.setString(5, retailerRegistration.getState());
			preparedStatement.setString(6, retailerRegistration.getCountry());
			preparedStatement.setLong(7, retailerRegistration.getPhone_number());
			preparedStatement.setString(8, retailerRegistration.getEmail_id());
			preparedStatement.setString(9, retailerRegistration.getPhone_verified() + "");
			preparedStatement.setString(10, retailerRegistration.getEmail_verified() + "");
			preparedStatement.setString(11, retailerRegistration.getPhone_IME());
			preparedStatement.setString(12, retailerRegistration.getActivationCode());
			preparedStatement.setString(13, retailerID);
			logger.info(retailerRegistration.toString());
			if (preparedStatement.executeUpdate() > 0) {
				logger.info("Retailer updation successful");
				return true;
			} else {
				logger.info("Retailer updation failed");
				return false;
			}
		} catch (SQLException e) {
			logger.error("Error:" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteRetailler(String retaillerID) {
		// TODO Auto-generated method stub
		try {
			con = dbConnection.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
		}
		try {

			String sql = "DELETE FROM ume.retailer_registration WHERE Retailer_ID=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, retaillerID);
			if (preparedStatement.executeUpdate() > 0) {
				logger.info("Deleted Retailer ID :"+retaillerID);
				return true;
			} else {
				logger.info("Deleting Retailer ID :"+retaillerID +"got failed");
				return false;
			}

		} catch (Exception e) {
			logger.error("SQL error occured"+e.getMessage());
			return false;
		} 
	}

	@Override
	public RetailerRegistration getRetaillerDetails(String retaillerID){
		// TODO Auto-generated method stub
		try {
			con = dbConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RetailerRegistration retailerRegistration = null;
		Statement st;
		try {
			st = con.createStatement();
		
		String sql = "SELECT * FROM ume.retailer_registration where Retailer_ID='" + retaillerID + "'";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			retailerRegistration = new RetailerRegistration();
			retailerRegistration.setRetailer_ID(rs.getString(1));
			retailerRegistration.setRetailer_Name(rs.getString(2));
			retailerRegistration.setAddress(rs.getString(3));
			retailerRegistration.setCity(rs.getString(4));
			retailerRegistration.setState(rs.getString(5));
			retailerRegistration.setCountry(rs.getString(6));
			retailerRegistration.setCreated_date(rs.getDate(7));
			retailerRegistration.setLast_updated(rs.getDate(8));
			retailerRegistration.setPhone_number(Long.parseLong(rs.getString(9)));
			retailerRegistration.setEmail_id(rs.getString(10));
			retailerRegistration.setPhone_verified(rs.getString(11));
			retailerRegistration.setEmail_verified(rs.getString(12));
			retailerRegistration.setPhone_IME(rs.getString(13));
			retailerRegistration.setActivationCode(rs.getString(14));
		}
		logger.info("Retailer Registration "+retailerRegistration);
		return retailerRegistration;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Exception "+e.getMessage());
			return null;
		}
	}

	@Override
	public List<RetailerRegistration> getAllRetaillerDetails() {

		
		try {
			con = dbConnection.getConnection();
			logger.info("Database Connection has been created");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
		}
		List<RetailerRegistration> retailerRegistrationList = new ArrayList<RetailerRegistration>();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM ume.retailer_registration";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				RetailerRegistration retailerRegistration = new RetailerRegistration();
				retailerRegistration.setRetailer_ID(rs.getString(1));
				retailerRegistration.setRetailer_Name(rs.getString(2));
				retailerRegistration.setAddress(rs.getString(3));
				retailerRegistration.setCity(rs.getString(4));
				retailerRegistration.setState(rs.getString(5));
				retailerRegistration.setCountry(rs.getString(6));
				retailerRegistration.setCreated_date(rs.getDate(7));
				retailerRegistration.setLast_updated(rs.getDate(8));
				retailerRegistration.setPhone_number(Long.parseLong(rs.getString(9)));
				retailerRegistration.setEmail_id(rs.getString(10));
				retailerRegistration.setPhone_verified(rs.getString(11));
				retailerRegistration.setEmail_verified(rs.getString(12));
				retailerRegistration.setPhone_IME(rs.getString(13));
				retailerRegistration.setActivationCode(rs.getString(14));
				retailerRegistrationList.add(retailerRegistration);
			}
			if (retailerRegistrationList.size() != 0){
				logger.info("Retailler List "+retailerRegistrationList.toString());
				return retailerRegistrationList;
			}
			else{
				logger.info("Retailer List is empty");
				return null;
			}
		} catch (Exception e) {
			logger.error("Exception :"+e.getMessage());
			return null;
		} 
	}

	@Override
	public String sendActivationCode(String mobileNumber, String name) {
		// TODO Auto-generated method stub
		long randomInt = Long.parseLong(mobileNumber);
		Random randomGenerator = new Random();
		long activationCode = (randomGenerator.nextLong()) % 10000;
		String Retailer_ID = "R" + mobileNumber;
		
		try {
			con = dbConnection.getConnection();
			logger.info("connection has been created");
		} catch (Exception e1) {
			logger.error("connection failed");
		}
		try {

			String sql = "INSERT INTO ume.retailer_registration (Retailer_ID,Retailer_Name,Phone_number,activationCode) values (?,?,?,?)";
			logger.info("SQL "+sql);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, Retailer_ID);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, mobileNumber);
			preparedStatement.setString(4, "OTP" + activationCode);
			if (preparedStatement.executeUpdate() > 0) {
				logger.info("New Retailer Created. Generated OTP is "+activationCode);
				return activationCode+"";
			} else {
				logger.info("User Creation Failed :");
				return "Error";
			}
		} catch (SQLException e) {
			logger.error("Database Exception :");
			return "Error";
		}

	}

}
