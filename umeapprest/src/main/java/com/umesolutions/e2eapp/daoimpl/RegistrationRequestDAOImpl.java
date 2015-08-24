package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.umesolutions.e2eapp.dao.RegistrationRequestDAO;
import com.umesolutions.e2eapp.dto.RegistrationRequest;

public class RegistrationRequestDAOImpl implements RegistrationRequestDAO {
	private DBConnection dbConnection;

	@Override
	public boolean getUpdateRequestDetails(String distributorID, String activationCode, String retailerPhone)
			throws Exception {
		// TODO Auto-generated method stub
		dbConnection = new DBConnection();
		Connection con = dbConnection.getConnection();
		PreparedStatement pre = con.prepareStatement(
				"insert into registrationrequest (distributorID,activationCode,retailerPhone) values (?,?,?)");
		pre.setString(1, distributorID);
		pre.setString(2, activationCode);
		pre.setString(3, retailerPhone);
		if (pre.executeUpdate() > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public RegistrationRequest getRegReqObject(String activationCode) throws Exception {
		// TODO Auto-generated method stub
		RegistrationRequest registrationRequest = null;
		dbConnection = new DBConnection();
		Connection con = dbConnection.getConnection();
		try {
			String SQL = "SELECT * FROM ume.registrationrequest where activationCode='" + activationCode+ "'";
			System.out.println(SQL);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				registrationRequest = new RegistrationRequest();
				registrationRequest.setDistributorID(rs.getString(1));
				registrationRequest.setActivationCode(rs.getString(2));
				registrationRequest.setRetailerPhone(rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
		return registrationRequest;
	}

}
