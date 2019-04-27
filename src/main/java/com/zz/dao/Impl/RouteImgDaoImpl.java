package com.zz.dao.Impl;

import com.zz.bean.RouteImg;
import com.zz.dao.RouteImgDao;
import com.zz.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteImgDaoImpl implements RouteImgDao {
    DBUtil util = new DBUtil();
    String sql = "";
    @Override
    public RouteImg getRouteImgByRid(int rid) {
        sql = "select * from tab_route_img where rid = "+rid;
        ResultSet resultSet = util.execQuery(sql, null);
        RouteImg routeImg = null;
        try {
            routeImg = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routeImg;
    }

    public RouteImg autoGet(ResultSet res) throws SQLException {
        RouteImg routeImg = new RouteImg();
        while (res.next()){
            routeImg.setRgid(res.getInt("rgid"));
            routeImg.setRid(res.getInt("rid"));
            routeImg.setBigpic(res.getString("bigpic"));
            routeImg.setSmallpic(res.getString("smallpic"));
        }
        return routeImg;
    }
}
