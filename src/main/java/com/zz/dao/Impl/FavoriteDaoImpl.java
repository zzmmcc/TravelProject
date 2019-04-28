package com.zz.dao.Impl;

import com.zz.bean.Favorite;
import com.zz.dao.FavoriteDao;
import com.zz.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

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
        }finally {
            util.getClose(util.rs,util.ps,util.conn);
        }
        return favorite;
    }

    @Override
    public Favorite getFavoriteByRid_Uid(int rid, int uid) {
            sql = "select * from tab_favorite where rid = "+rid+" and uid = "+uid;
            resultSet = util.execQuery(sql,null);
            Favorite favorite = null;
            try {
                favorite = autoGet(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                util.getClose(util.rs,util.ps,util.conn);
            }
            return favorite;
    }

    @Override
    public int likeByRidAndUid(int rid, int uid) {
        Date date = new Date(new java.util.Date().getTime());
        sql = "insert into tab_favorite values(null,"+rid+",'"+ date +"',"+uid+")";
        int i = util.execUpdate(sql, null);
        if(i!=0){
            return 1;
        }
        return 0;
    }

    @Override
    public int unlikeByRidAndUid(int rid, int uid) {
        sql = "delete from tab_favorite where rid ="+rid+" and uid = "+uid;
        int i = util.execUpdate(sql, null);
        if(i!=0){
            return 1;
        }
        return 0;
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
