package com.zz.dao.Impl;

import com.zz.bean.Category;
import com.zz.dao.CategoryDao;
import com.zz.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDapImpl implements CategoryDao {
    JDBCUtil util = new JDBCUtil();
    //C3P0Util util = new C3P0Util();
    String sql = "";
    ResultSet res = null;

    @Override
    public ArrayList<Category> getCategory() throws SQLException {
        sql = "select * from tab_category";
        res = util.execQuery(sql, null);
        ArrayList<Category> list = new ArrayList<>();
        while (res.next()) {
            Category category = new Category(res.getInt("cid"), res.getString("cname"));
            list.add(category);
        }
        util.getClose(util.rs, util.ps, util.conn);
        return list;
    }

    @Override
    public Category getCategoryByCid(int cid) throws SQLException {
        sql = "select * from tab_category where cid = " + cid;
        ResultSet resultSet = util.execQuery(sql, null);
        Category category = null;
        while (resultSet.next()) {
            category = new Category();
            category.setCid(resultSet.getInt("cid"));
            category.setCname(resultSet.getString("cname"));
        }
        util.getClose(util.rs, util.ps, util.conn);
        return category;
    }

    @Override
    public int addCategory(String cname) {
        sql = "insert into tab_category values(null,'" + cname + "')";
        int i = util.execUpdate(sql, null);
        return i;
    }

    @Override
    public ArrayList<Category> getCategoryBySort() throws SQLException {
        sql = "select * from tab_category order by cid";
        res = util.execQuery(sql, null);
        ArrayList<Category> list = new ArrayList<>();
        while (res.next()) {
            Category category = new Category(res.getInt("cid"), res.getString("cname"));
            list.add(category);
        }
        util.getClose(util.rs, util.ps, util.conn);
        return list;
    }

    @Override
    public int delCategoryByCid(int cid) {
        sql = "delete from tab_category where cid = " + cid + "";
        int i = util.execUpdate(sql, null);
        return i;
    }

    @Override
    public int editCategoryByCate(Category category) {
        sql = "update tab_category set cname = '" + category.getCname() + "' where cid =" + category.getCid() + "";
        return util.execUpdate(sql, null);
    }
}
