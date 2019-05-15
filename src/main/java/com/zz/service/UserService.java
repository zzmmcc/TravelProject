package com.zz.service;

import com.zz.bean.User;
import com.zz.util.PageUtil;

public interface UserService {
    User checkLogin(String username, String password) throws  Exception;

    User register(User user);

    int activeUserByCode(String code);

    PageUtil<User> getUserListBySearch_textWithPage(int pageNow, int pageSize, String search_text);

    User getUserByUid(int uid);
}
