package com.zz.service.Impl;

import com.zz.bean.Seller;
import com.zz.dao.Impl.SellerDaoImpl;
import com.zz.dao.SellerDao;
import com.zz.service.SellerService;

public class SellerServiceImpl implements SellerService {
    SellerDao sellerDao = new SellerDaoImpl();
    @Override
    public Seller getSellerBySid(int sid) {
        return sellerDao.getSellerBySid(sid);
    }
}
