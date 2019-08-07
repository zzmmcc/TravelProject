package com.zz.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    public static Connection conn = null;
    //操作对象
    public static PreparedStatement ps = null;
    //结果集对象
    public static ResultSet rs = null;
    DataSource dataSource = null;

    //加载驱动
    public DBUtil() {
        // TODO Auto-generated constructor stub
        try {
            InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            //通过java的反射机制获取jdbc的驱动
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //获取数据库的连接

    public Connection getConn() {
        try {
            //获取连接对象
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 用于增删改的方法
     *
     * @param sql 外部传入的sql语句
     * @param obj 外部传入的参数 因为不确定参数就的个数和类型 所以使用obj[]
     */
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
    public void getClose(ResultSet rs, PreparedStatement ps, Connection conn) {
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
