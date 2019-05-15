package com.zz.dao;

import com.zz.bean.Seller;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SellerDao {
    Seller getSellerBySid(int rid);

    ArrayList<Seller> getSellerList() throws SQLException;

    int delSellerBySid(int sid);

    int editSellerBySeller(Seller seller);

    int addSellerBySeller(Seller seller);
}
