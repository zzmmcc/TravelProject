package com.zz.dao.Impl;

import com.zz.bean.RouteImg;
import com.zz.dao.RouteImgDao;
import com.zz.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RouteImgDaoImpl implements RouteImgDao {
    JDBCUtil util = new JDBCUtil();
    String sql = "";

    @Override
    public ArrayList<RouteImg> getRouteImgByRid(int rid) {
        sql = "select * from tab_route_img where rid = " + rid;
        ResultSet resultSet = util.execQuery(sql, null);
        RouteImg routeImg = null;
        ArrayList<RouteImg> list = new ArrayList<RouteImg>();
        try {
            list = autoGetsList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.getClose(util.rs, util.ps, util.conn);
        }
        return list;
    }

    @Override
    public void addRouteImgByRid(int rid, String smallpic, String bigpic) {
        sql = "insert into tab_route_img (rgid,rid,bigPic,smallPic) values(null,?,?,?)";
        Object[] obj = {rid, bigpic, smallpic};
        util.execUpdate(sql, obj);
    }

    public ArrayList<RouteImg> autoGetsList(ResultSet res) throws SQLException {
        ArrayList<RouteImg> list = new ArrayList<RouteImg>();
        while (res.next()) {
            RouteImg routeImg = autoGet(res);
            list.add(routeImg);
        }
        util.getClose(util.rs, util.ps, util.conn);
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
