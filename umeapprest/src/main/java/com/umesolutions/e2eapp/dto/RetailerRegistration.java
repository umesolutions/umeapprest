package com.umesolutions.e2eapp.dto;

import java.sql.Date;

public class RetailerRegistration {
	private String Retailer_ID;
	private String Retailer_Name;
	private String Address;
	private String city;
	private String state;
	private String country;
	private Date created_date;
	private Date last_updated;
	private int Phone_number;
	private String email_id;
	private char Phone_verified;
	private char Email_verified;
	private String phone_IME;
	public String getRetailer_ID() {
		return Retailer_ID;
	}
	public void setRetailer_ID(String retailer_ID) {
		Retailer_ID = retailer_ID;
	}
	public String getRetailer_Name() {
		return Retailer_Name;
	}
	public void setRetailer_Name(String retailer_Name) {
		Retailer_Name = retailer_Name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public int getPhone_number() {
		return Phone_number;
	}
	public void setPhone_number(int phone_number) {
		Phone_number = phone_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public char getPhone_verified() {
		return Phone_verified;
	}
	public void setPhone_verified(char phone_verified) {
		Phone_verified = phone_verified;
	}
	public char getEmail_verified() {
		return Email_verified;
	}
	public void setEmail_verified(char email_verified) {
		Email_verified = email_verified;
	}
	public String getPhone_IME() {
		return phone_IME;
	}
	public void setPhone_IME(String phone_IME) {
		this.phone_IME = phone_IME;
	}
	
}
