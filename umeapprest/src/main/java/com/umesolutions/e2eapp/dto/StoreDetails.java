package com.umesolutions.e2eapp.dto;

import java.sql.Date;

public class StoreDetails {
	private String Retailer_id;
	private String Store_id;
	private String Store_Name;
	private String Store_Address;
	private String Store_city;
	private String Store_state;
	private String Store_country;
	private String Store_status;
	private String Latitude;
	private String Longitude;
	private Date created_date;
	private Date last_updated;
	private String Approved_store;
	private String Approver_Distributor_id;
	
	public String getRetailer_id() {
		return Retailer_id;
	}
	public void setRetailer_id(String retailer_id) {
		Retailer_id = retailer_id;
	}
	public String getStore_id() {
		return Store_id;
	}
	public void setStore_id(String store_id) {
		Store_id = store_id;
	}
	public String getStore_Name() {
		return Store_Name;
	}
	public void setStore_Name(String store_Name) {
		Store_Name = store_Name;
	}
	public String getStore_Address() {
		return Store_Address;
	}
	public void setStore_Address(String store_Address) {
		Store_Address = store_Address;
	}
	public String getStore_city() {
		return Store_city;
	}
	public void setStore_city(String store_city) {
		Store_city = store_city;
	}
	public String getStore_state() {
		return Store_state;
	}
	public void setStore_state(String store_state) {
		Store_state = store_state;
	}
	public String getStore_country() {
		return Store_country;
	}
	public void setStore_country(String store_country) {
		Store_country = store_country;
	}
	public String getStore_status() {
		return Store_status;
	}
	public void setStore_status(String store_status) {
		Store_status = store_status;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}
	public String getApproved_store() {
		return Approved_store;
	}
	public void setApproved_store(String approved_store) {
		Approved_store = approved_store;
	}
	public String getApprover_Distributor_id() {
		return Approver_Distributor_id;
	}
	public void setApprover_Distributor_id(String approver_Distributor_id) {
		Approver_Distributor_id = approver_Distributor_id;
	}	
}
