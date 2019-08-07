package com.zz.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3P0Util {
    Connection conn = null;
    //操作对象
    PreparedStatement ps = null;
    //结果集对象
    ResultSet rs = null;
    static String url;
    static String user;
    static String pwd;
    static ComboPooledDataSource cpds;

    static {
        cpds = new ComboPooledDataSource();
    }

    /**
     * 获取连接
     **/
    public static Connection getConn() {
        try {
            return cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int execUpdate(String sql, Object[] obj) {
        try {
            getConn();
            ps = conn.prepareStatement(sql);
            if (obj != null) {
                //循环赋值
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    //用于查询的方法
    public ResultSet execQuery(String sql, Object[] obj) {
        try {
            getConn();
            ps = conn.prepareStatement(sql);
            if (obj != null) {
                //循环赋值
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    //关闭数据库对象的方法
    public void getClose() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}


