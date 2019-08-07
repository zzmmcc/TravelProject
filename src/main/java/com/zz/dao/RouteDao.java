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

    List<Route> getRouteListByCid(String cid);

    List<Route> getHotsRouteListByCid(int cid);

    List<Route> getRouteListByCidWithPage(int cid, int pageNow, int pageSize);

    int reduceCountByRid(int rid);

    int plusCountByRid(int rid);

    List<Route> searchRouteListByTextWithPage(String searchtext, int pageNow) throws SQLException;

    List<Route> getRouteListByCount() throws SQLException;

    List<Route> getRouteListCountByRnameAndPrice(String rname, double minPrice, double maxPrice) throws SQLException;

    int getPageCountByCid(int cid) throws SQLException;

    int getPageCountByText(String searchtext) throws SQLException;

    int getPageCount() throws SQLException;

    List<Route> getRouteListBySearch_textWithPage(int pageNow, int pageSize, String search_text) throws SQLException;

    void delRouteByRid(int rid);

    void delRouteByRids(int[] rids);

    void submitRouteMsg(Route route);

    int addRouteByRoute(Route route);

    void addRimageByRid(int rid, String rimage);
}
