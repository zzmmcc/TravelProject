package com.zz.dao.Impl;

import com.zz.bean.Seller;
import com.zz.dao.SellerDao;
import com.zz.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SellerDaoImpl implements SellerDao {
    JDBCUtil util = new JDBCUtil();
    String sql = "";
    ResultSet resultSet = null;

    @Override
    public Seller getSellerBySid(int sid) {
        sql = "select * from tab_seller where sid = " + sid;
        resultSet = util.execQuery(sql, null);
        Seller seller = null;
        try {
            while (resultSet.next()) {
                seller = autoGet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.getClose(util.rs, util.ps, util.conn);
        }
        return seller;
    }

    @Override
    public ArrayList<Seller> getSellerList() throws SQLException {
        sql = "select * from tab_seller";
        resultSet = util.execQuery(sql, null);
        ArrayList<Seller> list = new ArrayList<Seller>();
        while (resultSet.next()) {
            Seller seller = autoGet(resultSet);
            list.add(seller);
        }
        return list;
    }

    @Override
    public int delSellerBySid(int sid) {
        sql = "delete from tab_seller where sid=" + sid;
        int i = util.execUpdate(sql, null);
        return i;
    }

    @Override
    public int editSellerBySeller(Seller seller) {
        sql = "update tab_seller set sname =?,address =?,consphone =? where sid=?";
        Object[] obj = {seller.getSname(), seller.getAddress(), seller.getConsphone(), seller.getSid()};
        int i = util.execUpdate(sql, obj);
        return i;
    }

    @Override
    public int addSellerBySeller(Seller seller) {
        sql = "insert into tab_seller values (?,?,?,?)";
        Object[] obj = {seller.getSid(), seller.getSname(), seller.getConsphone(), seller.getAddress()};
        int i = util.execUpdate(sql, obj);
        return i;
    }

    public Seller autoGet(ResultSet resultSet) throws SQLException {
        Seller seller = new Seller();
        seller.setSid(resultSet.getInt("sid"));
        seller.setSname(resultSet.getString("sname"));
        seller.setConsphone(resultSet.getString("consphone"));
        seller.setAddress(resultSet.getString("address"));
        return seller;
    }
}
