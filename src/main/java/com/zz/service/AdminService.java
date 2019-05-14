package com.zz.service;

import com.zz.bean.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
