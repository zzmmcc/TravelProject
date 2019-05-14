package com.zz.dao;

import com.zz.bean.Category;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoryDao {
    ArrayList<Category> getCategory() throws SQLException;

    Category getCategoryByCid(int cid) throws SQLException;

    int addCategory(String cname);

    ArrayList<Category> getCategoryBySort() throws SQLException;

    int delCategoryByCid(int cid);

    int editCategoryByCate(Category category);
}
