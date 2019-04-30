package com.zz.servlet;

import com.alibaba.fastjson.JSON;
import com.zz.bean.Category;
import com.zz.service.CategoryService;
import com.zz.service.Impl.CategoryServiceImpl;
import com.zz.util.JedisUtil;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "categoryServlet",value = "/categoryServlet")
public class categoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");
        if(method.equals("getCategory")){
            getCategory(request,response);
        }
    }

    public void getCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jedis jedis = JedisUtil.getJedis();
        String category = jedis.get("category");
        if (null==category || category.equals("")){
            ArrayList<Category> list = categoryService.getCategory();
            jedis.set("category", JSON.toJSONString(list));
            System.out.println("缓存中没有");
            response.getWriter().print(JSON.toJSONString(list));
            return;
        }
        response.getWriter().print(category);
    }


}
