package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.umesolutions.e2eapp.dao.LoginDAO;
import com.umesolutions.e2eapp.dto.LoginDetails;

public class LoginDAOImpl implements LoginDAO {
	Logger logger=Logger.getLogger(LoginDAOImpl.class);
	private DBConnection dbConnection;
    private Connection con;
	@Override
	public LoginDetails getLoginDAOInfo(String username, String password) {
		// TODO Auto-generated method stub
		dbConnection = new DBConnection();
		LoginDetails loginDetails = null;
		
		try {
			con = dbConnection.getConnection();
			logger.info("Database connection Created");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error("Connection Failed");
		}
		try {
			String SQL = "SELECT * FROM ume.logindetails where customerID='" + username + "'" + " and password='"
					+ password + "'";
			System.out.println(SQL);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				loginDetails = new LoginDetails();
				loginDetails.setCustomerID(rs.getString(1));
				loginDetails.setPassword(rs.getString(2));
				loginDetails.setPassCode(rs.getString(3));
				loginDetails.setUserType(rs.getString(4));
				loginDetails.setUserStatus(rs.getString(5));
				loginDetails.setCreatedDate(rs.getDate(6).toString());
				loginDetails.setLastLoginDate(rs.getDate(7).toString());
			}
			logger.info(loginDetails.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());

		}

		return loginDetails;

	}

	@Override
	public boolean setLoginInfo(LoginDetails loginDetails){
		// TODO Auto-generated method stub
		dbConnection = new DBConnection();
		System.out.println("DB connection Created");
		try {
			con = dbConnection.getConnection();
			logger.info("Database connection created ");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
		}
		try {
			String sql = "INSERT INTO ume.logindetails (customerID,password,passcode,userType,userStatus,createdDate,lastLoginDate) VALUES (?,?,?,?,?,?,?)";
			System.out.println("Starting sql :::"+sql);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, loginDetails.getCustomerID());
			preparedStatement.setString(2, loginDetails.getPassword());
			preparedStatement.setString(3, "0000");
			preparedStatement.setString(4, loginDetails.getUserType());
			preparedStatement.setString(5, "ACTIVE");
			preparedStatement.setDate(6, java.sql.Date.valueOf("2015-08-26"));
			preparedStatement.setDate(7, java.sql.Date.valueOf("2015-08-26"));
			if (preparedStatement.executeUpdate() > 0) {
			   logger.info("User "+ loginDetails.getCustomerID()+" has been created");
				return true;
			} else {
				logger.error("User "+ loginDetails.getCustomerID()+" creation failed");
				return false;
			}
		} catch (SQLException e) {
			logger.error("SQL Exception :"+e.getMessage());
			return false;
		}
	}
}
