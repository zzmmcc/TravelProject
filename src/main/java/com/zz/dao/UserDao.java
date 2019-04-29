package com.zz.dao;

import com.zz.bean.User;

import java.sql.SQLException;

public interface UserDao {
     User checkLogin(String username, String password) throws  Exception;

    void register(User u);

    User getUserByUser(User u)  throws  Exception;

    Boolean getStatusByCode(String code) throws SQLException;

    int activeUserByCode(String code);

}
