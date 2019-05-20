package com.zz.service;

import com.zz.bean.RouteImg;

import java.util.ArrayList;

public interface RouteImgService {
    ArrayList<RouteImg> getRouteImgByRid(int rid);

    void addRouteImgByRid(int rid, String smallpic, String bigpic);
}
