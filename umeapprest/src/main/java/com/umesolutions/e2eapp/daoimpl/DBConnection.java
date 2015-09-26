package com.umesolutions.e2eapp.daoimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

 
public class DBConnection {
	Logger logger=Logger.getLogger(DBConnection.class);
	private Connection connection = null;
 public Connection getConnection() throws Exception
 {
	 /* MySQL connnection*/
	 
 try
 {
 String connectionURL = "jdbc:mysql://umesolutionsql.chx8beg1gv6a.us-west-2.rds.amazonaws.com:3306/ume"; 
 Class.forName("com.mysql.jdbc.Driver").newInstance();
 connection = DriverManager.getConnection(connectionURL, "root", "Sv25081985");
 logger.info("DB Connection Created for "+connectionURL);
 return connection;
 }	 
 catch (SQLException e)
 {
    logger.error("SQL Exception :"+e.getMessage());	 
 }
 catch(ClassNotFoundException e){
	 logger.error("ClassNotException :"+e.getMessage());
 }
 catch (Exception e)
 {
	 logger.error("Exception :"+e.getMessage());
 }
 return null;
 } 
}
