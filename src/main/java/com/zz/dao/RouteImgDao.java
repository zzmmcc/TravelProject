package com.zz.dao;

import com.zz.bean.RouteImg;

import java.util.ArrayList;


public interface RouteImgDao {
    ArrayList<RouteImg> getRouteImgByRid(int rid);

    void addRouteImgByRid(int rid, String smallpic, String bigpic);
}
