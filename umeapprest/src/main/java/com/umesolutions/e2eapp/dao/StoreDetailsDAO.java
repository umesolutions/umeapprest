package com.umesolutions.e2eapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.umesolutions.e2eapp.dto.StoreDetails;


public interface StoreDetailsDAO {

	public boolean createStore(StoreDetails storeDetails) throws Exception;
	public boolean updateStore(StoreDetails storeDetails,String storeID) throws Exception;
	public boolean deleteStore(String storeID) throws Exception;
	public StoreDetails getStoreDetails(String storeID) throws Exception;
	public List<StoreDetails> getAllStoreDetails() throws SQLException, Exception;
}
