package com.umesolutions.e2eapp.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import com.umesolutions.e2eapp.dao.StoreDetailsDAO;
import com.umesolutions.e2eapp.daoimpl.StoreDetailsDAOImpl;
import com.umesolutions.e2eapp.dto.StoreDetails;
import com.umesolutions.e2eapp.service.StoreDetailsService;

public class StoreDetailsServiceImpl implements StoreDetailsService {
	StoreDetailsDAO storeDetailsDAO = new StoreDetailsDAOImpl();

	@Override
	public boolean createStore(StoreDetails storeDetails) {
		// TODO Auto-generated method stub
		return storeDetailsDAO.createStore(storeDetails);
	}

	@Override
	public boolean updateStore(StoreDetails storeDetails, String storeID){
		// TODO Auto-generated method stub
		return storeDetailsDAO.updateStore(storeDetails, storeID);
	}

	@Override
	public boolean deleteStore(String storeID){
		// TODO Auto-generated method stub
		return storeDetailsDAO.deleteStore(storeID);
	}

	@Override
	public StoreDetails getStoreDetails(String storeID){
		// TODO Auto-generated method stub
		return storeDetailsDAO.getStoreDetails(storeID);
	}

	@Override
	public List<StoreDetails> getAllStoreDetails() {
		// TODO Auto-generated method stub
		return storeDetailsDAO.getAllStoreDetails();
	}

}
