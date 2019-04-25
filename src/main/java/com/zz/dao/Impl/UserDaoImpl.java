package com.zz.dao.Impl;

import com.zz.bean.User;
import com.zz.dao.UserDao;
import com.zz.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    DBUtil util = new DBUtil();
    String sql ="";
    public User autoGet(ResultSet res) throws SQLException {
        User user = new User();
        while (res.next()){
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
    public User checkLogin(String username, String password)  throws  Exception{
        sql = "select * from tab_user where username='"+username+"' and password='"+password+"'";
        System.out.println(sql);
        ResultSet res = util.execQuery(sql, null);
        return autoGet(res);
    }

    @Override
    public void register(User user) {
        sql = "insert into tab_user values(null,'"+user.getUsername()+"','"+user.getPassword()+"', '"
                +user.getName()+"', '" +user.getBirthday()+"', '"+user.getSex()+"', '"
                +user.getTelephone()+"', '"+user.getEmail()+"', '"+user.getStatus()+"','"+user.getCode()+"' )";
        System.out.println(sql);
        util.execUpdate(sql,null);

    }

    @Override
    public User getUserByUser(User user) throws Exception {
        sql = "select * from  tab_user where username = '"+user.getUsername()+"' and password = '"+user.getPassword()+"' and name ='"
                +user.getName()+"' and birthday = '" +user.getBirthday()+"' and sex = '"+user.getSex()+"' and telephone = '"
                +user.getTelephone()+"' and email = '"+user.getEmail()+"' and status = '"+user.getStatus()+"' and code = '"+user.getCode()+"' ";
        System.out.println(sql);
        ResultSet res = util.execQuery(sql, null);
        return autoGet(res);
    }
}
