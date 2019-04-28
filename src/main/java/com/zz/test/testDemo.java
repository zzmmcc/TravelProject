package com.zz.test;

import com.zz.dao.CategoryDao;
import com.zz.dao.Impl.CategoryDapImpl;
import com.zz.service.CategoryService;
import com.zz.service.Impl.CategoryServiceImpl;
import com.zz.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

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
    public void Test(){
        Jedis jedis = JedisUtil.getJedis();
        jedis.set("test","123");
        System.out.println(jedis.get("test"));
        jedis.flushAll();
        System.out.println(jedis.get("test"));
        jedis.close();
    }
}
