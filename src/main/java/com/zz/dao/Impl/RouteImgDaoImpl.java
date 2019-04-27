package com.zz.dao.Impl;

import com.zz.bean.RouteImg;
import com.zz.dao.RouteImgDao;
import com.zz.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RouteImgDaoImpl implements RouteImgDao {
    DBUtil util = new DBUtil();
    String sql = "";
    @Override
    public ArrayList<RouteImg> getRouteImgByRid(int rid) {
        sql = "select * from tab_route_img where rid = "+rid;
        ResultSet resultSet = util.execQuery(sql, null);
        RouteImg routeImg = null;
        ArrayList<RouteImg> list = new ArrayList<RouteImg>();
        try {
            list = autoGetsList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<RouteImg> autoGetsList(ResultSet res) throws SQLException{
        ArrayList<RouteImg> list = new ArrayList<RouteImg>();
        while (res.next()) {
            RouteImg routeImg = autoGet(res);
            list.add(routeImg);
        }
        return list;
    }

    public RouteImg autoGet(ResultSet res) throws SQLException {
        RouteImg routeImg = new RouteImg();
            routeImg.setRgid(res.getInt("rgid"));
            routeImg.setRid(res.getInt("rid"));
            routeImg.setBigpic(res.getString("bigpic"));
            routeImg.setSmallpic(res.getString("smallpic"));
        return routeImg;
    }
}
