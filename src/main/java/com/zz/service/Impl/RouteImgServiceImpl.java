package com.zz.service.Impl;

import com.zz.bean.RouteImg;
import com.zz.dao.Impl.RouteImgDaoImpl;
import com.zz.dao.RouteImgDao;
import com.zz.service.RouteImgService;

public class RouteImgServiceImpl implements RouteImgService {
    RouteImgDao routeImgDao = new RouteImgDaoImpl();
    @Override
    public RouteImg getRouteImgByRid(int rid) {
        return routeImgDao.getRouteImgByRid(rid);
    }
}
