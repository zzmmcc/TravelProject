package com.zz.dao;

import com.zz.bean.Admin;

import java.sql.SQLException;

public interface AdminDao {
    Admin login(String username, String password) throws SQLException;
}
