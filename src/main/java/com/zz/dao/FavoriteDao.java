package com.zz.dao;

import com.zz.bean.Favorite;

import java.sql.SQLException;
import java.util.List;

public interface FavoriteDao {
    Favorite getFavoriteByRid(int rid);

    Favorite getFavoriteByRid_Uid(int rid, int uid);

    int likeByRidAndUid(int rid, int uid);

    int unlikeByRidAndUid(int rid, int uid);

    List<Favorite> getListByUid(int uid) throws SQLException;
}
