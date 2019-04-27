package com.zz.service.Impl;

import com.zz.bean.Favorite;
import com.zz.dao.FavoriteDao;
import com.zz.dao.Impl.FavoriteDaoImpl;
import com.zz.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {
    FavoriteDao favoriteDao = new FavoriteDaoImpl();
    @Override
    public Favorite getFavoriteByRid(int rid) {
        return favoriteDao.getFavoriteByRid(rid);
    }
}
