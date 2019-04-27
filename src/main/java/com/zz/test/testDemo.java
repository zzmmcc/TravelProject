package com.zz.test;

import com.zz.dao.CategoryDao;
import com.zz.dao.Impl.CategoryDapImpl;
import com.zz.service.CategoryService;
import com.zz.service.Impl.CategoryServiceImpl;
import com.zz.util.C3P0Util;
import com.zz.util.JedisUtil;
import org.junit.Test;

import java.sql.SQLException;


public class testDemo {
    CategoryService categoryService = new CategoryServiceImpl();
    CategoryDao categoryDao = new CategoryDapImpl();
    @Test
    public void test1(){
        System.out.println(JedisUtil.getJedis());
    }
    @Test
    public void test2(){
        try {
            categoryDao.getCategoryBiCid(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void c3Test(){
        System.out.println(C3P0Util.getConn());
    }
}
