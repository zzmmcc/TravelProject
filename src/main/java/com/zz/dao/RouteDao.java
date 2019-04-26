package com.zz.dao;

import com.zz.bean.Route;

import java.sql.SQLException;
import java.util.List;

public interface RouteDao {
    List<Route> getHotTravel();

    List<Route> getNewest();

    List<Route> getTheme();

    List<Route> getGuoNeiList();

    List<Route> getJingWaiList();

    Route getRouteByRid(int id) throws SQLException;
}
