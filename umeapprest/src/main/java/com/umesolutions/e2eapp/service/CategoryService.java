package com.umesolutions.e2eapp.service;

import java.util.List;

import com.umesolutions.e2eapp.dto.RootCategory;

public interface CategoryService {
	 public List<RootCategory> getRootCategoriesList() throws Exception;
}
