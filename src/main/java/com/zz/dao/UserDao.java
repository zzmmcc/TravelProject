package com.zz.dao;

import com.zz.bean.User;

public interface UserDao {
     User checkLogin(String username, String password) throws  Exception;

    void register(User u);

    User getUserByUser(User u)  throws  Exception;
}
