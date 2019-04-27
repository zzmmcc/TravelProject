package com.zz.dao;

import com.zz.bean.Category;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoryDao {
    ArrayList<Category> getCategory() throws SQLException;

    Category getCategoryBiCid(int cid) throws SQLException;
}
