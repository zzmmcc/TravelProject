package com.zz.test;

import com.zz.bean.Route;
import com.zz.dao.CategoryDao;
import com.zz.dao.Impl.CategoryDapImpl;
import com.zz.dao.Impl.RouteDaoImpl;
import com.zz.service.CategoryService;
import com.zz.service.Impl.CategoryServiceImpl;
import com.zz.service.Impl.RouteServiceImpl;
import com.zz.service.RouteService;
import com.zz.util.JedisUtil;
import com.zz.util.PageUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;


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

    @Test
    public  void testGuoNei1(){
        RouteDaoImpl dao = new RouteDaoImpl();
        for (int i=1;i<4;i++){
            List<Route> list = dao.getGuoNeiListWithPage(i, 3);
            for (Route route : list) {
                System.out.println(route);

            }
            System.out.println("------------------------");
        }

    }
    @Test
    public  void testPage(){
        RouteService routeService = new RouteServiceImpl();
        for (int i=1;i<4;i++){
            PageUtil<Route> pageList = routeService.getRouteListByCidWithPage(5, i, 5);
            System.out.println("------------------------");
        }

    }
}
