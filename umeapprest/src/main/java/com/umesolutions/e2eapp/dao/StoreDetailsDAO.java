package com.umesolutions.e2eapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.umesolutions.e2eapp.dto.StoreDetails;


public interface StoreDetailsDAO {

	public boolean createStore(StoreDetails storeDetails);
	public boolean updateStore(StoreDetails storeDetails,String storeID);
	public boolean deleteStore(String storeID);
	public StoreDetails getStoreDetails(String storeID);
	public List<StoreDetails> getAllStoreDetails();
}
