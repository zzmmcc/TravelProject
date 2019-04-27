package com.zz.dao.Impl;

import com.zz.bean.Favorite;
import com.zz.dao.FavoriteDao;
import com.zz.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteDaoImpl implements FavoriteDao {
    DBUtil util = new DBUtil();
    String sql = "";
    ResultSet resultSet = null;
    @Override
    public Favorite getFavoriteByRid(int rid) {
        sql = "select * from tab_favorite where rid = "+rid;
        resultSet = util.execQuery(sql,null);
        Favorite favorite = null;
        try {
            favorite = autoGet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favorite;
    }

    public Favorite autoGet(ResultSet resultSet) throws SQLException {
        Favorite favorite = new Favorite();
        while (resultSet.next()){
            favorite.setRid(resultSet.getInt("rid"));
            favorite.setUid(resultSet.getInt("uid"));
            favorite.setDate(resultSet.getDate("date"));
        }
        return favorite;
    }
}
