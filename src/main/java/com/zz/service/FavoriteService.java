package com.zz.service;

import com.zz.bean.Favorite;

public interface FavoriteService {
    Favorite getFavoriteByRid(int rid);
    Favorite getFavoriteByRid_Uid(int rid,int uid);

    int unlikeByRidAndUid(int rid, int uid);

    int likeByRidAndUid(int rid, int uid);
}
