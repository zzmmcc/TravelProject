package com.zz.dao;

import com.zz.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
     User checkLogin(String username, String password) throws  Exception;

    void register(User u);

    User getUserByUser(User u)  throws  Exception;

    Boolean getStatusByCode(String code) throws SQLException;

    int activeUserByCode(String code);

    int getPageCountByText(String search_text) throws SQLException;

    int getPageCount() throws SQLException;

    List<User> getUserListBySearch_textWithPage( int pageNow,int pageSize,String search_text) throws SQLException;

    User getUserByUid(int uid) throws SQLException;
}
