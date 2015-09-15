package com.umesolutions.e2eapp.service;

import java.util.List;

import com.umesolutions.e2eapp.dto.CategoryToDistributor;

public interface DistributorService {
	public List<CategoryToDistributor> getDistributorList(String CategoryID) throws Exception;
}
