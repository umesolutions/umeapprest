package com.umesolutions.e2eapp.serviceimpl;

import java.util.List;

import com.umesolutions.e2eapp.dao.CategoriesDAO;
import com.umesolutions.e2eapp.daoimpl.CategoriesDAOImpl;
import com.umesolutions.e2eapp.dto.RootCategory;
import com.umesolutions.e2eapp.dto.SubCategories;
import com.umesolutions.e2eapp.service.CategoryService;

public class CategoriesServiceImpl implements CategoryService {
	CategoriesDAO categoriesDAO=new CategoriesDAOImpl();
	@Override
	public List<RootCategory> getRootCategoriesList() {
		// TODO Auto-generated method stub
		return categoriesDAO.getRootCategoriesList();
	}
	@Override
	public List<SubCategories> getSubCategories(String rootCategoryID, String rootCategoryName) {
		// TODO Auto-generated method stub
		return categoriesDAO.getSubCategories(rootCategoryID, rootCategoryName);
	}

}
