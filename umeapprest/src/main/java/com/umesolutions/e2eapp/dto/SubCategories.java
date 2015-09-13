package com.umesolutions.e2eapp.dto;

public class SubCategories {
	private String category_ID;
	private String category_name;
	private String parent_category_id;
	private String parent_category_name;
	private String category_desc;
	public String getCategory_desc() {
		return category_desc;
	}
	public void setCategory_desc(String category_desc) {
		this.category_desc = category_desc;
	}
	public String getCategory_ID() {
		return category_ID;
	}
	public void setCategory_ID(String category_ID) {
		this.category_ID = category_ID;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getParent_category_id() {
		return parent_category_id;
	}
	public void setParent_category_id(String parent_category_id) {
		this.parent_category_id = parent_category_id;
	}
	public String getParent_category_name() {
		return parent_category_name;
	}
	public void setParent_category_name(String parent_category_name) {
		this.parent_category_name = parent_category_name;
	}
}
