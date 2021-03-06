package com.zz.dao.Impl;

import com.zz.bean.Route;
import com.zz.dao.RouteDao;
import com.zz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    JDBCUtil util = new JDBCUtil();
    String sql = "";

    @Override
    public List<Route> getHotTravel() {
        sql = "select * from tab_route order by count desc limit 0,4";
        ResultSet resultSet = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.getClose(util.rs, util.ps, util.conn);
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
        } finally {
            util.getClose(util.rs, util.ps, util.conn);
        }
        return list;
    }

    @Override
    public List<Route> getTheme() {
        sql = "select * from tab_route where isThemeTour = 1 limit 0,4";
        ResultSet resultSet = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.getClose(util.rs, util.ps, util.conn);
        }
        return list;
    }

    @Override
    public List<Route> getGuoNeiList() {
        sql = "select * from tab_route where cid = 5 limit 0,6";
        ResultSet resultSet = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.getClose(util.rs, util.ps, util.conn);
        }
        return list;
    }

    @Override
    public List<Route> getJingWaiList() {
        sql = "select * from tab_route where cid = 4 limit 0,6";
        ResultSet resultSet = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.getClose(util.rs, util.ps, util.conn);
        }
        return list;

    }

    @Override
    public Route getRouteByRid(int rid) throws SQLException {
        sql = "select * from tab_route where rid = " + rid;
        ResultSet resultSet = util.execQuery(sql, null);
        Route r = null;
        while (resultSet.next()) {
            r = getR(resultSet);
        }
        util.getClose(util.rs, util.ps, util.conn);
        return r;
    }

    @Override
    public List<Route> getRouteListByCid(String cid) {
        sql = "select * from tab_route where cid = " + cid;
        ResultSet res = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(res);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.getClose(res, null, null);
        }
        return list;
    }

    @Override
    public List<Route> getHotsRouteListByCid(int cid) {
        sql = "select * from tab_route where cid = " + cid + " order by count desc limit 0,6";
        ResultSet res = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(res);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.getClose(res, null, null);
        }
        return list;
    }

    @Override
    public List<Route> getRouteListByCidWithPage(int cid, int pageNow, int pageSize) {
        sql = "select * from tab_route where cid = " + cid + "  limit " + pageSize * (pageNow - 1) + "," + pageSize + "";
        ResultSet res = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(res);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.getClose(res, null, null);
        }
        return list;
    }

    @Override
    public int reduceCountByRid(int rid) {
        sql = "update tab_route set count = count-1 where rid = " + rid;
        return util.execUpdate(sql, null);
    }

    @Override
    public int plusCountByRid(int rid) {
        sql = "update tab_route set count = count+1 where rid = " + rid;
        int i = util.execUpdate(sql, null);
        util.getClose(util.rs, util.ps, util.conn);
        return i;
    }

    @Override
    public List<Route> searchRouteListByTextWithPage(String searchtext, int pageNow) throws SQLException {
        sql = "select * from tab_route where rname like '%" + searchtext + "%' limit " + (pageNow - 1) * 8 + ",8";
        ResultSet res = util.execQuery(sql, null);
        List<Route> list = autoGet(res);
        util.getClose(util.rs, util.ps, util.conn);
        return list;
    }

    @Override
    public List<Route> getRouteListByCount() throws SQLException {
        sql = "select * from tab_route order by count desc limit 0,8";
        ResultSet res = util.execQuery(sql, null);
        List<Route> list = autoGet(res);
        util.getClose(util.rs, util.ps, util.conn);
        return list;
    }

    @Override
    public List<Route> getRouteListCountByRnameAndPrice(String rname, double minPrice, double maxPrice) throws SQLException {
        if (null == rname || rname.equals("")) {
            sql = "select * from tab_route where price < " + maxPrice + " and price > " + minPrice + " order by count desc limit 0,8";
        } else {
            sql = "select * from tab_route where rname like '%" + rname + "%' and price < " + maxPrice + " and price > " + minPrice + " order by count desc limit 0,8";
        }
        ResultSet res = util.execQuery(sql, null);
        List<Route> list = autoGet(res);
        util.getClose(util.rs, util.ps, util.conn);
        return list;
    }

    @Override
    public int getPageCountByCid(int cid) throws SQLException {
        sql = "select count(*) from tab_route where cid =" + cid + "";
        ResultSet resultSet = util.execQuery(sql, null);
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public int getPageCountByText(String searchtext) throws SQLException {
        sql = "select count(*) from tab_route where rname like '%" + searchtext + "%'";
        ResultSet resultSet = util.execQuery(sql, null);
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public int getPageCount() throws SQLException {
        sql = "select count(*) from tab_route";
        ResultSet resultSet = util.execQuery(sql, null);
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public List<Route> getRouteListBySearch_textWithPage(int pageNow, int pageSize, String search_text) throws SQLException {
        if (search_text == null || "".equals(search_text)) {
            sql = "select * from tab_route  limit " + (pageNow - 1) * pageSize + "," + pageSize + "";
        } else {
            sql = "select * from tab_route where rname like '%" + search_text + "%' limit " + (pageNow - 1) * pageSize + "," + pageSize + "";
        }
        ResultSet res = util.execQuery(sql, null);
        List<Route> list = autoGet(res);
        util.getClose(util.rs, util.ps, util.conn);
        return list;
    }

    @Override
    public void delRouteByRid(int rid) {
        Connection conn = util.getConn();
        try {
            //开启事务
            conn.setAutoCommit(false);
            sql = "UPDATE tab_route_img set rid = 9999 WHERE rid = " + rid + " ";
            util.execUpdate(sql, null);
            sql = "delete from tab_route where rid = " + rid + "";
            util.execUpdate(sql, null);
            //try的最后提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                //回滚事务
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    @Override
    public void delRouteByRids(int[] rids) {
        String first = "UPDATE tab_route_img set rid = 9999 WHERE rid in ( ";
        String second = "delete from tab_route where rid in (";
        for (int i = 0; i < rids.length; i++) {
            first += rids[i] + ",";
            second += rids[i] + ",";
        }
        first = first.substring(0, first.length() - 1) + ")";
        second = second.substring(0, second.length() - 1) + ")";
        util.execUpdate(first, null);
        util.execUpdate(second, null);
    }

    @Override
    public void submitRouteMsg(Route route) {
        if (null != route.getRdate() && !"".equals(route.getRdate())) {
            sql = "update tab_route set rname = ?,price = ?,routeIntroduce = ?,rflag = ?,rdate = ?,isThemeTour = ?,cid =? where rid = ?";
            Object[] obj = {route.getRname(), route.getPrice(), route.getRouteintroduce(), route.getRflag(),
                    route.getRdate(), route.getIsthemetour(), route.getCid(), route.getRid()};
            util.execUpdate(sql, obj);
        } else {
            sql = "update tab_route set rname = ?,price = ?,routeIntroduce = ?,rflag = ?,isThemeTour = ?,cid =? where rid = ?";
            Object[] obj = {route.getRname(), route.getPrice(), route.getRouteintroduce(),
                    route.getRflag(), route.getIsthemetour(), route.getCid(), route.getRid()};
            util.execUpdate(sql, obj);
        }


    }

    @Override
    public int addRouteByRoute(Route r) {
        int rid = -1;
        try {
            sql = "insert into tab_route(rname,price,routeIntroduce,rflag,rdate,isThemeTour,cid,sid,sourceId) values(?,?,?,?,?,?,?,?,?)";
            Object[] obj = {r.getRname(), r.getPrice(), r.getRouteintroduce(), r.getRflag(), r.getRdate(),
                    r.getIsthemetour(), r.getCid(), r.getSid(), r.getSourceid()};
            util.execUpdate(sql, obj);
            sql = "select rid from tab_route where rname = ? and price = ? and routeIntroduce = ? and rflag = ? and rdate = ? and isThemeTour = ? and cid = ? and sid = ? and sourceId = ?";
            System.out.println(sql);
            ResultSet set = util.execQuery(sql, obj);
            while (set.next()) {
                rid = set.getInt("rid");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rid;
    }

    @Override
    public void addRimageByRid(int rid, String rimage) {
        sql = "update tab_route set rimage = '" + rimage + "' where rid = " + rid + " and rimage  is null";
        util.execUpdate(sql, null);
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
        while (res.next()) {
            Route route = getR(res);
            list.add(route);
        }
        return list;
    }

    public List<Route> getGuoNeiListWithPage(int pageNow, int pageSize) {
        sql = "select * from tab_route where cid = 5 limit 0,6";
        ResultSet resultSet = util.execQuery(sql, null);
        List<Route> list = null;
        try {
            list = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.getClose(util.rs, util.ps, util.conn);
        }
        return list;
    }
}
