package com.zz.service;

import com.zz.bean.Route;

import java.util.List;

public interface RouteService {
    List<Route> getHotTravel();

    List<Route> getNewest();

    List<Route> getTheme();

    List<Route> getGuoNeiList();

    List<Route> getJingWaiList();

    Route getRouteByRid(int id);
}
