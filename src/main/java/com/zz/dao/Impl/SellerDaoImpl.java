package com.zz.dao.Impl;

import com.zz.bean.Seller;
import com.zz.dao.SellerDao;
import com.zz.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerDaoImpl implements SellerDao {
    JDBCUtil util = new JDBCUtil();
    String sql = "";
    ResultSet resultSet = null;
    @Override
    public Seller getSellerBySid(int sid) {
        sql = "select * from tab_seller where sid = "+sid;
        resultSet = util.execQuery(sql,null);
        Seller seller = null;
        try {
            seller = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.getClose(util.rs,util.ps,util.conn);
        }
        return seller;
    }

    public Seller autoGet(ResultSet resultSet) throws SQLException {
        Seller seller = new Seller();
        while (resultSet.next()){
            seller.setSid(resultSet.getInt("sid"));
            seller.setSname(resultSet.getString("sname"));
            seller.setConsphone(resultSet.getString("consphone"));
            seller.setAddress(resultSet.getString("address"));
        }
        return seller;
    }
}
