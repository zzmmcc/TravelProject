package com.zz.service.Impl;

import com.zz.bean.Seller;
import com.zz.dao.Impl.SellerDaoImpl;
import com.zz.dao.SellerDao;
import com.zz.service.SellerService;

import java.sql.SQLException;
import java.util.ArrayList;

public class SellerServiceImpl implements SellerService {
    SellerDao sellerDao = new SellerDaoImpl();
    @Override
    public Seller getSellerBySid(int sid) {
        return sellerDao.getSellerBySid(sid);
    }

    @Override
    public ArrayList<Seller> getSellerList() {
        ArrayList<Seller> list = new ArrayList<>();
        try {
            list = sellerDao.getSellerList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int editSellerBySeller(Seller seller) {
        return sellerDao.editSellerBySeller(seller);
    }

    @Override
    public int delSellerBySid(int sid) {
        return sellerDao.delSellerBySid(sid);
    }

    @Override
    public int addSellerBySeller(Seller seller) {
        return sellerDao.addSellerBySeller(seller);
    }

}
