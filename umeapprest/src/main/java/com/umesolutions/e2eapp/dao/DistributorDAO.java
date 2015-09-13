package com.umesolutions.e2eapp.dao;

import java.util.List;

import com.umesolutions.e2eapp.dto.CategoryToDistributor;

public interface DistributorDAO {
	
	public List<CategoryToDistributor> getDistributorList(String CategoryID);

}
