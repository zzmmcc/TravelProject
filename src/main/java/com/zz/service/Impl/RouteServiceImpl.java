package com.zz.service.Impl;

import com.zz.bean.Route;
import com.zz.dao.Impl.RouteDaoImpl;
import com.zz.dao.RouteDao;
import com.zz.service.RouteService;

import java.sql.SQLException;
import java.util.List;

public class RouteServiceImpl implements RouteService {
    RouteDao routeDao = new RouteDaoImpl();

    public List<Route> getHotTravel() {
        return routeDao.getHotTravel();
    }

    public List<Route> getNewest() {
        return routeDao.getNewest();
    }

    public List<Route> getTheme() {
        return routeDao.getTheme();
    }

    @Override
    public List<Route> getGuoNeiList() {
        return routeDao.getGuoNeiList();
    }

    @Override
    public List<Route> getJingWaiList() {
        return routeDao.getJingWaiList();
    }

    @Override
    public Route getRouteByRid(int id) {
        Route r = null;
        try {
          r = routeDao.getRouteByRid(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  r;
    }
}
