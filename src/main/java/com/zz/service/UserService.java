package com.zz.service;

import com.zz.bean.User;

public interface UserService {
    User checkLogin(String username, String password) throws  Exception;

    User register(User user);
}
