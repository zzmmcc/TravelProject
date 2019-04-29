package com.zz.util;



import org.junit.Test;

import java.sql.*;

public class JDBCUtil {
	private String url = "jdbc:mysql://localhost:3306/travelproject";
	private String user = "root";
	private String pwd = "root";
	public  static Connection conn  = null;

	public  static PreparedStatement ps = null;

	public  static ResultSet rs = null;
	public JDBCUtil() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConn(){
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	@Test
	public void get(){
		try {

			conn = getConn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(conn);
	}

	public int execUpdate(String sql,Object[] obj){
		try {
			getConn();
			ps = conn.prepareStatement(sql);
			if(obj!=null){
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public ResultSet execQuery(String sql,Object[] obj){
		try {
			getConn();
			ps = conn.prepareStatement(sql);
			if(obj!=null){
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			return ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void getClose(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
