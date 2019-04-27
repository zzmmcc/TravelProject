package com.zz.service;

import com.zz.bean.Category;

import java.util.ArrayList;

public interface CategoryService {
    ArrayList<Category> getCategory();

    Category getCategoryBiCid(int cid);
}
