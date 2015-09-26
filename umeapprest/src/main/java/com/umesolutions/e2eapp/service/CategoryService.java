package com.umesolutions.e2eapp.service;

import java.util.List;

import com.umesolutions.e2eapp.dto.RootCategory;
import com.umesolutions.e2eapp.dto.SubCategories;

public interface CategoryService {
	 public List<RootCategory> getRootCategoriesList();
	 public List<SubCategories> getSubCategories(String rootCategoryID,String rootCategoryName);
}
