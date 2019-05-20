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

    PageUtil<Route> searchRouteListByTextWithPage(String searchtext,int pageNow);

    List<Route> getRouteListByCount();

    List<Route> getRouteListCountByRnameAndPrice(String rname,double minPrice,double maxPrice);

    PageUtil<Route> getRouteListBySearch_textWithPage(int pageNow,int pageSize,String search_text);

    void delRouteByRid(int rid);

    void delRouteByRids(int[] rids);

    void submitRouteMsg(Route route);

    int addRouteByRoute(Route route);

    void addRimageByRid(int rid, String rimage);
}
