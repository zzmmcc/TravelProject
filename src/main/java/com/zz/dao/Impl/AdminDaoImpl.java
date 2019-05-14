package com.zz.dao.Impl;

import com.zz.bean.Admin;
import com.zz.dao.AdminDao;
import com.zz.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    DBUtil util = new DBUtil();
    String sql = "";
    ResultSet res = null;
    @Override
    public Admin login(String username, String password) throws SQLException {
        sql = "select * from admin where username = '"+username+"' and password = '"+password+"'";
        res = util.execQuery(sql,null);
        Admin admin = new Admin();
        while (res.next()){
            admin.setId(res.getInt("id"));
            admin.setUsername(res.getString("username"));
            admin.setPassword(res.getString("password"));
        }
        return admin;
    }
}
