package com.umesolutions.e2eapp.dao;

import java.util.List;

import com.umesolutions.e2eapp.dto.RootCategory;
import com.umesolutions.e2eapp.dto.SubCategories;

public interface CategoriesDAO {
  public List<RootCategory> getRootCategoriesList();
  public List<SubCategories> getSubCategories(String rootCategoryID,String rootCategoryName);
}
