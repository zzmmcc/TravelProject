package com.zz.service;

import com.zz.bean.Route;
import com.zz.util.PageUtil;

import java.util.List;

public interface RouteService {
    List<Route> getHotTravel();

    List<Route> getNewest();

    List<Route> getTheme();

    List<Route> getGuoNeiList();

    List<Route> getJingWaiList();

    Route getRouteByRid(int id);

    List<Route> getRouteListByCid(String cid);
    PageUtil<Route> getRouteListByCidWithPage(int cid, int pageNow, int pageSize);

    List<Route> getHotsRouteListByCid(int cid);

    List<Route> searchRouteListByText(String searchtext);

    List<Route> getRouteListByCount();

    List<Route> getRouteListCountByRnameAndPrice(String rname,double minPrice,double maxPrice);

}
