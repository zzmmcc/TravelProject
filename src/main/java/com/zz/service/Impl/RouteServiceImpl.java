package com.zz.service.Impl;

import com.zz.bean.Route;
import com.zz.dao.Impl.RouteDaoImpl;
import com.zz.dao.RouteDao;
import com.zz.service.RouteService;
import com.zz.util.PageUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteServiceImpl implements RouteService {
    RouteDao routeDao = new RouteDaoImpl();

    @Override
    public List<Route> getHotTravel() {
        return routeDao.getHotTravel();
    }

    @Override
    public List<Route> getNewest() {
        return routeDao.getNewest();
    }

    @Override
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
    public PageUtil<Route> getRouteListByCidWithPage(int cid, int pageNow, int pageSize) {
        PageUtil page = new PageUtil();
        List<Route> list = routeDao.getRouteListByCidWithPage(cid,pageNow,pageSize);
        int pageCount = 0;
        try {
            pageCount = routeDao.getPageCountByCid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setPageSize(pageSize);
        page.setPageNow(pageNow);
        page.setList((ArrayList) list);
        page.setPageCount(pageCount);
        return page;
    }

    @Override
    public List<Route> getHotsRouteListByCid(int cid) {
        List<Route> list = routeDao.getHotsRouteListByCid(cid);
        return  list;
    }

    @Override
    public PageUtil<Route> searchRouteListByTextWithPage(String searchtext,int pageNow) {
        PageUtil page = new PageUtil();
        List<Route> list = new ArrayList<Route>();
        int pageCount = 0;
        try {
            list = routeDao.searchRouteListByTextWithPage(searchtext,pageNow);
            pageCount = routeDao.getPageCountByText(searchtext);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        page.setPageSize(8);
        page.setPageNow(pageNow);
        page.setList((ArrayList) list);
        page.setPageCount(pageCount);

        return page;
    }

    @Override
    public List<Route> getRouteListByCount() {
        List<Route> list = new ArrayList<>();
        try {
            list = routeDao.getRouteListByCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Route> getRouteListCountByRnameAndPrice(String rname,double minPrice,double maxPrice) {
        List<Route> list = new ArrayList<>();
        try {
            list = routeDao.getRouteListCountByRnameAndPrice(rname,minPrice,maxPrice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public PageUtil<Route> getRouteListBySearch_textWithPage(int pageNow,int pageSize,String search_text) {
        PageUtil page = new PageUtil();
        List<Route> list = new ArrayList<Route>();
        int pageCount = 0;
        try {
            list = routeDao.getRouteListBySearch_textWithPage(pageNow,pageSize,search_text);
            pageCount = routeDao.getPageCountByText(search_text);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        page.setPageSize(pageSize);
        page.setPageNow(pageNow);
        page.setList((ArrayList) list);
        page.setPageCount(pageCount);

        return page;
    }

    @Override
    public void delRouteByRid(int rid) {
        routeDao.delRouteByRid(rid);
    }

    @Override
    public void delRouteByRids(int[] rids) {
        routeDao.delRouteByRids(rids);
    }

    @Override
    public void submitRouteMsg(Route route) {
        routeDao.submitRouteMsg(route);
    }

    @Override
    public int addRouteByRoute(Route route) {
        return  routeDao.addRouteByRoute(route);
    }

    @Override
    public void addRimageByRid(int rid, String rimage) {
        routeDao.addRimageByRid(rid,rimage);
    }
}
