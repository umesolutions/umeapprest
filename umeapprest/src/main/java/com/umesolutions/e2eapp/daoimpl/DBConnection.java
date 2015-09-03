package com.umesolutions.e2eapp.daoimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
 
 public Connection getConnection() throws Exception
 {
	 /* MySQL connnection*/ 
 try
 {
 String connectionURL = "jdbc:mysql://umesolutionsql.chx8beg1gv6a.us-west-2.rds.amazonaws.com:3306/ume";
 Connection connection = null;
 Class.forName("com.mysql.jdbc.Driver").newInstance();
 connection = DriverManager.getConnection(connectionURL, "root", "Sv25081985");
 return connection;
 }
	 
 catch (SQLException e)
 {
 throw e;
 }
 catch (Exception e)
 {
 throw e;
 }
 } 
}
