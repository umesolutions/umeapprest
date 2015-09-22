package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.umesolutions.e2eapp.dao.LoginDAO;
import com.umesolutions.e2eapp.dto.LoginDetails;

public class LoginDAOImpl implements LoginDAO {

	private DBConnection dbConnection;

	@Override
	public LoginDetails getLoginDAOInfo(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		dbConnection = new DBConnection();
		LoginDetails loginDetails = null;
		Connection con = dbConnection.getConnection();
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return loginDetails;

	}

	@Override
	public boolean setLoginInfo(LoginDetails loginDetails) throws Exception {
		// TODO Auto-generated method stub
		dbConnection = new DBConnection();
		System.out.println("DB connection Created");
		Connection con = dbConnection.getConnection();
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
}
