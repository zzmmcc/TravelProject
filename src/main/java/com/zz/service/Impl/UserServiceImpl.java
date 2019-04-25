package com.zz.service.Impl;

import com.zz.bean.User;
import com.zz.dao.Impl.UserDaoImpl;
import com.zz.dao.UserDao;
import com.zz.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();
    //登录的方法
    public User checkLogin(String username, String password) throws  Exception {
        User user =userDao.checkLogin(username,password);
        return user;
    }

    @Override
    public User register(User u) {
        userDao.register(u);
        User user = null;
        try {
            user = userDao.getUserByUser(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
