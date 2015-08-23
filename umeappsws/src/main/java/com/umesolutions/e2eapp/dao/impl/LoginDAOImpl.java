package com.umesolutions.e2eapp.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.umesolutions.e2eapp.dao.LoginDAO;
import com.umesolutions.e2eapp.dao.mapper.LoginDetailsMapper;
import com.umesolutions.e2eapp.dao.pojo.LoginDetailsPojo;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public LoginDetailsPojo getLoginDAOInfo(String username, String password) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		 String SQL = "select * from LoginDetails where customerID = ? and password=?";
	      LoginDetailsPojo loginDetailsPojo = jdbcTemplate.queryForObject(SQL, 
	                        new Object[]{username,password}, new LoginDetailsMapper());
	      return loginDetailsPojo;
	}

}
