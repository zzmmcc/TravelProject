package com.zz.dao.Impl;

import com.zz.bean.Category;
import com.zz.dao.CategoryDao;
import com.zz.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDapImpl implements CategoryDao {
    DBUtil util = new DBUtil();
    //C3P0Util util = new C3P0Util();
    String sql = "";
    ResultSet res = null;

    @Override
    public ArrayList<Category> getCategory() throws SQLException {
        sql = "select * from tab_category";
        res = util.execQuery(sql, null);
        ArrayList<Category> list = new ArrayList<>();
        while (res.next()){
            Category category = new Category(res.getInt("cid"),res.getString("cname"));
            list.add(category);
        }
        return list;
    }

    @Override
    public Category getCategoryBiCid(int cid) throws SQLException {
        sql = "select * from tab_category where cid = "+cid;
        ResultSet resultSet = util.execQuery(sql, null);
        Category category = null;
        while (resultSet.next()){
            category = new Category();
            category.setCid(resultSet.getInt("cid"));
            category.setCname(resultSet.getString("cname"));
        }
        return category;
    }
}
