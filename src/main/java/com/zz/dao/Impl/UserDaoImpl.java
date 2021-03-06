package com.zz.dao.Impl;

import com.zz.bean.User;
import com.zz.dao.UserDao;
import com.zz.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    JDBCUtil util = new JDBCUtil();
    String sql = "";

    public User autoGet(ResultSet res) throws SQLException {
        User user = new User();
        while (res.next()) {
            user.setUid(res.getInt("uid"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            user.setName(res.getString("name"));
            user.setBirthday(res.getDate("birthday"));
            user.setSex(res.getString("sex"));
            user.setTelephone(res.getString("telephone"));
            user.setEmail(res.getString("email"));
            user.setStatus(res.getString("status"));
            user.setCode(res.getString("code"));
        }
        return user;
    }

    @Override
    public User checkLogin(String username, String password) throws Exception {
        sql = "select * from tab_user where username='" + username + "' and password='" + password + "'";
        ResultSet res = util.execQuery(sql, null);
        User user = autoGet(res);
        util.getClose(util.rs, util.ps, util.conn);
        return user;
    }

    @Override
    public void register(User user) {
        sql = "insert into tab_user values(null,'" + user.getUsername() + "','" + user.getPassword() + "', '"
                + user.getName() + "', '" + user.getBirthday() + "', '" + user.getSex() + "', '"
                + user.getTelephone() + "', '" + user.getEmail() + "', '" + user.getStatus() + "','" + user.getCode() + "' )";
        util.execUpdate(sql, null);
        util.getClose(util.rs, util.ps, util.conn);
    }

    @Override
    public User getUserByUser(User user) throws Exception {
        sql = "select * from  tab_user where username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "' and name ='"
                + user.getName() + "' and birthday = '" + user.getBirthday() + "' and sex = '" + user.getSex() + "' and telephone = '"
                + user.getTelephone() + "' and email = '" + user.getEmail() + "' and status = '" + user.getStatus() + "' and code = '" + user.getCode() + "' ";
        ResultSet res = util.execQuery(sql, null);
        return autoGet(res);
    }

    @Override
    public Boolean getStatusByCode(String code) throws SQLException {
        sql = "select * from tab_user where code = '" + code + "' and status = 1";
        System.out.println(sql);
        ResultSet res = util.execQuery(sql, null);
        User user = autoGet(res);
        if (user.getName() == null || user.getName().equals("")) {
            util.getClose(util.rs, util.ps, util.conn);
            return false;
        }
        util.getClose(util.rs, util.ps, util.conn);
        return true;
    }

    @Override
    public int activeUserByCode(String code) {
        sql = "update tab_user set status = 1 where code = '" + code + "' and status = 0";
        System.out.println(sql);
        int i = util.execUpdate(sql, null);
        util.getClose(util.rs, util.ps, util.conn);
        return i;
    }


    @Override
    public int getPageCountByText(String searchtext) throws SQLException {
        sql = "select count(*) from tab_user where name like '%" + searchtext + "%'";
        ResultSet resultSet = util.execQuery(sql, null);
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public int getPageCount() throws SQLException {
        sql = "select count(*) from tab_user";
        ResultSet resultSet = util.execQuery(sql, null);
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public List<User> getUserListBySearch_textWithPage(int pageNow, int pageSize, String search_text) throws SQLException {
        if (search_text == null || "".equals(search_text)) {
            sql = "select * from tab_user  limit " + (pageNow - 1) * pageSize + "," + pageSize + "";
        } else {
            sql = "select * from tab_user where name like '%" + search_text + "%' limit " + (pageNow - 1) * pageSize + "," + pageSize + "";
        }
        ResultSet res = util.execQuery(sql, null);
        List<User> list = new ArrayList<>();
        while (res.next()) {
            User user = new User();
            user.setUid(res.getInt("uid"));
            user.setUsername(res.getString("username"));
            user.setPassword(null);
            user.setName(res.getString("name"));
            user.setBirthday(res.getDate("birthday"));
            user.setSex(res.getString("sex"));
            user.setTelephone(res.getString("telephone"));
            user.setEmail(res.getString("email"));
            user.setStatus(res.getString("status"));
            user.setCode(res.getString("code"));
            list.add(user);
        }
        util.getClose(util.rs, util.ps, util.conn);
        return list;
    }

    @Override
    public User getUserByUid(int uid) throws SQLException {
        sql = "select * from tab_user where uid=" + uid;
        ResultSet res = util.execQuery(sql, null);
        User user = new User();
        while (res.next()) {
            user.setUid(res.getInt("uid"));
            user.setUsername(res.getString("username"));
            user.setPassword(null);
            user.setName(res.getString("name"));
            user.setBirthday(res.getDate("birthday"));
            user.setSex(res.getString("sex"));
            user.setTelephone(res.getString("telephone"));
            user.setEmail(res.getString("email"));
            user.setStatus(res.getString("status"));
            user.setCode(res.getString("code"));
        }
        return user;
    }
}
