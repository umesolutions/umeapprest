package com.umesolutions.e2eapp.serviceimpl;

import java.util.List;

import com.umesolutions.e2eapp.dao.DistributorDAO;
import com.umesolutions.e2eapp.daoimpl.DistributorDAOImpl;
import com.umesolutions.e2eapp.dto.CategoryToDistributor;
import com.umesolutions.e2eapp.service.DistributorService;

public class DistributorServiceImpl implements DistributorService {
	DistributorDAO distributorDAO=new DistributorDAOImpl();
	@Override
	public List<CategoryToDistributor> getDistributorList(String CategoryID) throws Exception {
		// TODO Auto-generated method stub
		return distributorDAO.getDistributorList(CategoryID);
	}

}
