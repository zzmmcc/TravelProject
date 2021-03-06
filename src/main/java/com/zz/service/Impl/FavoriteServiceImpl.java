package com.zz.service.Impl;

import com.zz.bean.Favorite;
import com.zz.bean.Route;
import com.zz.dao.FavoriteDao;
import com.zz.dao.Impl.FavoriteDaoImpl;
import com.zz.dao.Impl.RouteDaoImpl;
import com.zz.dao.RouteDao;
import com.zz.service.FavoriteService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    FavoriteDao favoriteDao = new FavoriteDaoImpl();
    RouteDao routeDao = new RouteDaoImpl();

    @Override
    public Favorite getFavoriteByRid(int rid) {
        return favoriteDao.getFavoriteByRid(rid);
    }

    @Override
    public Favorite getFavoriteByRid_Uid(int rid, int uid) {
        return favoriteDao.getFavoriteByRid_Uid(rid, uid);
    }

    @Override
    public int unlikeByRidAndUid(int rid, int uid) {
        int i = favoriteDao.unlikeByRidAndUid(rid, uid);
        if (i != 0) {
            i = routeDao.reduceCountByRid(rid);
            if (i != 0) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int likeByRidAndUid(int rid, int uid) {
        int i = favoriteDao.likeByRidAndUid(rid, uid);
        if (i != 0) {
            i = routeDao.plusCountByRid(rid);
            if (i != 0) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public List<Route> getListByUid(int uid) {
        List<Route> list = new ArrayList<Route>();
        try {
            List<Favorite> favorites = favoriteDao.getListByUid(uid);
            for (Favorite f : favorites) {
                Integer rid = f.getRid();
                Route route = routeDao.getRouteByRid(rid);
                list.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
