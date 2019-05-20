package com.zz.service.Impl;

import com.zz.bean.RouteImg;
import com.zz.dao.Impl.RouteImgDaoImpl;
import com.zz.dao.RouteImgDao;
import com.zz.service.RouteImgService;
import java.util.ArrayList;

public class RouteImgServiceImpl implements RouteImgService {
    RouteImgDao routeImgDao = new RouteImgDaoImpl();
    @Override
    public ArrayList<RouteImg> getRouteImgByRid(int rid) {
        return routeImgDao.getRouteImgByRid(rid);
    }

    @Override
    public void addRouteImgByRid(int rid, String smallpic, String bigpic) {
        routeImgDao.addRouteImgByRid(rid,smallpic,bigpic);
    }
}
