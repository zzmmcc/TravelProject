package com.zz.service.Impl;

import com.zz.bean.Route;
import com.zz.dao.Impl.RouteDaoImpl;
import com.zz.dao.RouteDao;
import com.zz.service.RouteService;

import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public List<Route> getRouteListByCid(String cid) {
        List<Route> list = routeDao.getRouteListByCid(cid);
        return list;
    }

    @Override
    public List<Route> getHotsRouteListByCid(int cid) {
        List<Route> list = routeDao.getHotsRouteListByCid(cid);
        return  list;
    }

    @Override
    public List<Route> searchRouteListByText(String searchtext) {
        List<Route> list = new ArrayList<Route>();
        try {
            list = routeDao.searchRouteListByText(searchtext);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
