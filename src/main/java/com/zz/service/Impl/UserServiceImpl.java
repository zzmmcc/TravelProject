package com.zz.service.Impl;

import com.zz.bean.User;
import com.zz.dao.Impl.UserDaoImpl;
import com.zz.dao.UserDao;
import com.zz.service.UserService;
import com.zz.util.PageUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    //登录的方法
    @Override
    public User checkLogin(String username, String password) throws Exception {
        User user = userDao.checkLogin(username, password);
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

    @Override
    public int activeUserByCode(String code) {
        int i = 0;
        Boolean boo = false;
        try {
            boo = userDao.getStatusByCode(code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (boo) {
            i = 9;
        } else {
            i = userDao.activeUserByCode(code);
        }
        return i;
    }

    @Override
    public PageUtil<User> getUserListBySearch_textWithPage(int pageNow, int pageSize, String search_text) {
        PageUtil page = new PageUtil();
        List<User> list = new ArrayList<User>();
        int pageCount = 0;
        try {
            list = userDao.getUserListBySearch_textWithPage(pageNow, pageSize, search_text);
            pageCount = userDao.getPageCountByText(search_text);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        page.setPageSize(pageSize);
        page.setPageNow(pageNow);
        page.setList((ArrayList) list);
        page.setPageCount(pageCount);
        return page;
    }

    @Override
    public User getUserByUid(int uid) {
        User user = new User();
        try {
            user = userDao.getUserByUid(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
