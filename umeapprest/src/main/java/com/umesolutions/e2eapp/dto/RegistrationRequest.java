package com.umesolutions.e2eapp.dto;

public class RegistrationRequest {

	 private String distributorID;
	  private String activationCode;
	  private String retailerPhone;
	public String getDistributorID() {
		return distributorID;
	}
	public void setDistributorID(String distributorID) {
		this.distributorID = distributorID;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public String getRetailerPhone() {
		return retailerPhone;
	}
	public void setRetailerPhone(String retailerPhone) {
		this.retailerPhone = retailerPhone;
	}

}
