package com.zz.service.Impl;

import com.zz.bean.Category;
import com.zz.dao.CategoryDao;
import com.zz.dao.Impl.CategoryDapImpl;
import com.zz.service.CategoryService;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDapImpl();

    @Override
    public ArrayList<Category> getCategory() {
        try {
            return categoryDao.getCategory();
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public Category getCategoryBiCid(int cid) {
        Category category = null;
        try {
            category = categoryDao.getCategoryBiCid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
