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
    public Category getCategoryByCid(int cid) {
        Category category = null;
        try {
            category = categoryDao.getCategoryByCid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public int addCategory(String cname) {
        int i = categoryDao.addCategory(cname);
        return i;
    }

    @Override
    public ArrayList<Category> getCategoryBySort() {
        try {
            return categoryDao.getCategoryBySort();
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public int delCategoryByCid(int cid) {
        return categoryDao.delCategoryByCid(cid);
    }

    @Override
    public int editCategoryByCate(Category category) {
        return categoryDao.editCategoryByCate(category);
    }


}
