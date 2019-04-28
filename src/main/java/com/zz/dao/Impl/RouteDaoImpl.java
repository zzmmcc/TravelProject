package com.zz.dao.Impl;

import com.zz.bean.Route;
import com.zz.dao.RouteDao;
import com.zz.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    DBUtil util = new DBUtil();
    String sql = "";

    public List<Route> getHotTravel() {
        sql = "select * from tab_route order by count desc limit 0,4";
        ResultSet resultSet = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.getClose(util.rs,util.ps,util.conn);
        }
        return list;
    }

    @Override
    public List<Route> getNewest() {
        sql = "select * from tab_route order by rdate desc limit 0,4";
        ResultSet resultSet = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.getClose(util.rs,util.ps,util.conn);
        }
        return list;
    }

    public List<Route> getTheme() {
        sql = "select * from tab_route where isThemeTour = 1 limit 0,4";
        ResultSet resultSet = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.getClose(util.rs,util.ps,util.conn);
        }
        return list;
    }

    public List<Route> getGuoNeiList() {
        sql = "select * from tab_route where cid = 5 limit 0,6";
        ResultSet resultSet = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.getClose(util.rs,util.ps,util.conn);
        }
        return list;
    }

    public List<Route> getJingWaiList() {
        sql = "select * from tab_route where cid = 4 limit 0,6";
        ResultSet resultSet = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.getClose(util.rs,util.ps,util.conn);
        }
        return list;

    }

    public Route getRouteByRid(int rid) throws SQLException {
        sql = "select * from tab_route where rid = "+rid;
        ResultSet resultSet = util.execQuery(sql, null);
        Route r = null;
        while (resultSet.next()){
            r =  getR(resultSet);
        }
        return r;
    }

    @Override
    public List<Route> getRouteListByCid(String cid) {
        sql = "select * from tab_route where cid = "+cid;
        ResultSet res = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(res);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.getClose(res,null,null);
        }
        return list;
    }

    @Override
    public List<Route> getHotsRouteListByCid(int cid) {
        sql = "select * from tab_route where cid = "+cid+" order by count desc limit 0,6";
        ResultSet res = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(res);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.getClose(res,null,null);
        }
        return list;
    }

    @Override
    public int reduceCountByRid(int rid) {
        sql = "update tab_route set count = count-1 where rid = "+rid;
        return util.execUpdate(sql,null);
    }

    @Override
    public int plusCountByRid(int rid) {
        sql = "update tab_route set count = count+1 where rid = "+rid;
        return util.execUpdate(sql,null);
    }

    public Route getR(ResultSet res) throws SQLException {
        Route route = new Route();
        route.setRid(res.getInt("rid"));
        route.setRname(res.getString("rname"));
        route.setPrice(res.getDouble("price"));
        route.setRouteintroduce(res.getString("routeintroduce"));
        route.setRflag(res.getString("rflag"));
        route.setRdate(res.getString("rdate"));
        route.setIsthemetour(res.getString("isthemetour"));
        route.setCount(res.getInt("count"));
        route.setCid(res.getInt("cid"));
        route.setRimage(res.getString("rimage"));
        route.setSid(res.getInt("sid"));
        route.setSourceid(res.getString("sourceid"));
        return route;
    }
    public List<Route> autoGet(ResultSet res) throws SQLException {
        List<Route> list = new ArrayList<Route>();
        while (res.next()){
            Route route = getR(res);
            list.add(route);
        }
        return list;
    }
}
