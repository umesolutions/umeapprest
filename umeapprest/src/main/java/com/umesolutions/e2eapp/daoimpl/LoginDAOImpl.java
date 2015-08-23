package com.umesolutions.e2eapp.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.umesolutions.e2eapp.dao.LoginDAO;
import com.umesolutions.e2eapp.dto.LoginDetails;

public class LoginDAOImpl implements LoginDAO  {
	
	private DBConnection dbConnection;
	

	@Override
	public LoginDetails getLoginDAOInfo(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		dbConnection=new DBConnection();
		LoginDetails loginDetails=null;
		Connection con= dbConnection.getConnection();
		try {
			
			String SQL = "SELECT * FROM ume.logindetails where customerID='"+username+"'"+" and password='"+password+"'";
			System.out.println(SQL);
		     Statement st=con.createStatement();
		     ResultSet rs=st.executeQuery(SQL);
		     while(rs.next()){		    	 
		    	 loginDetails=new LoginDetails();
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
		 
	   finally{
		   con.close();
		   
	   }
		return loginDetails;
	     
	}

}
