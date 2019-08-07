package com.zz.service.Impl;

import com.zz.bean.Admin;
import com.zz.dao.AdminDao;
import com.zz.dao.Impl.AdminDaoImpl;
import com.zz.service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin login(String username, String password) {
        Admin admin = null;
        try {
            admin = adminDao.login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
