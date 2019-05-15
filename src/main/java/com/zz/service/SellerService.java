package com.zz.service;

import com.zz.bean.Seller;

import java.util.ArrayList;

public interface SellerService {
    Seller getSellerBySid(int sid);

    ArrayList<Seller> getSellerList();

    int editSellerBySeller(Seller seller);

    int delSellerBySid(int sid);

    int addSellerBySeller(Seller seller);
}
