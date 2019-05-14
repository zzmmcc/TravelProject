package com.zz.service;

import com.zz.bean.Category;

import java.util.ArrayList;

public interface CategoryService {
    ArrayList<Category> getCategory();

    Category getCategoryByCid(int cid);

    int addCategory(String cname);

    ArrayList<Category> getCategoryBySort();

    int delCategoryByCid(int cid);

    int editCategoryByCate(Category category);
}
