package com.umesolutions.e2eapp.dto;

public class CategoryToDistributor {

	private String categoryID;
	private String categoryName;
	private String distributorID;
	private String distributorName;
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDistributorID() {
		return distributorID;
	}
	public void setDistributorID(String distributorID) {
		this.distributorID = distributorID;
	}
	public String getDistributorName() {
		return distributorName;
	}
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}
}
