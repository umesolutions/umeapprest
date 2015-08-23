package com.umesolutions.e2eapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.umesolutions.e2eapp.dao.pojo.LoginDetailsPojo;

public class LoginDetailsMapper implements RowMapper<LoginDetailsPojo>  {
		   public LoginDetailsPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		      LoginDetailsPojo loginDetailsPojo = new LoginDetailsPojo();
		      
		      return loginDetailsPojo;
		   }

		
		}

