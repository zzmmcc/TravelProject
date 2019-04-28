package com.zz.servlet;

import com.alibaba.fastjson.JSON;
import com.zz.bean.*;
import com.zz.service.*;
import com.zz.service.Impl.*;
import com.zz.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@WebServlet(name = "routeServlet",value = "/routeServlet")
public class routeServlet extends HttpServlet {
    RouteService routeService = new RouteServiceImpl();
    RouteImgService routeImgService = new RouteImgServiceImpl();
    FavoriteService favoriteService = new FavoriteServiceImpl();
    SellerService sellerService = new SellerServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method.equals("getHotTravel")){
            String jsonStr = getHotTravel();
            response.getWriter().print(jsonStr);
        }else if(method.equals("getNewest")){
            String jsonStr = getNewest();
            response.getWriter().print(jsonStr);
        }else if(method.equals("getTheme")){
            String jsonStr = getTheme();
            response.getWriter().print(jsonStr);
        }else if(method.equals("getGuoNeiList")){
            String jsonStr = getGuoNeiList();
            response.getWriter().print(jsonStr);
        }else if(method.equals("getJingWaiList")){
            String jsonStr = getJingWaiList();
            response.getWriter().print(jsonStr);
        }else if(method.equals("getRouteByRid")){
            getRouteByRid(request,response);
        }else if (method.equals("getRouteListByCid")){
            getRouteListByCid(request, response);
        }else if(method.equals("getHotsRouteListByCid")){
            getHotsRouteListByCid(request,response);
        } else {
            System.out.println(method);
        }
    }

    public void getHotsRouteListByCid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        Jedis jedis = JedisUtil.getJedis();
        String key = "hotsTravel_" + cid;
        String jedis_key = jedis.get(key);
        if(null==jedis_key || jedis_key.equals("")){
            List<Route> list = routeService.getHotsRouteListByCid(cid);
            String jsonStr = JSON.toJSONString(list);

            jedis.set(key,jsonStr);
        }
        jedis_key = jedis.get(key);
        response.getWriter().print(jedis_key);
    }

    public void getRouteByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        //获取route
        Route route = routeService.getRouteByRid(rid);
        //获取routeimg
        ArrayList<RouteImg> routeImg =  routeImgService.getRouteImgByRid(rid);
        //获取favorite
        User user = (User) request.getSession().getAttribute("loginUser");
        Favorite favorite = null;
        if(user==null || user.equals("")){
            favorite =  favoriteService.getFavoriteByRid(rid);
        }else {
             favorite = favoriteService.getFavoriteByRid_Uid(rid,user.getUid());
        }
        //获取seller
        Seller seller = sellerService.getSellerBySid(route.getSid());
        //获取category
        Category category = categoryService.getCategoryBiCid(route.getCid());

        RouteMsg routeMsg = new RouteMsg(route,routeImg,favorite,seller,null,category);

        request.setAttribute("route",route);
        request.setAttribute("routeMsg",routeMsg);
        request.getRequestDispatcher("route_detail.jsp").forward(request,response);
    }
    public void getRouteListByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        List<Route> list = routeService.getRouteListByCid(cid);
        request.setAttribute("routeList",list);
        request.getRequestDispatcher("route_list.jsp").forward(request,response);
    }

    public String getGuoNeiList() {
        Jedis jedis = JedisUtil.getJedis();
        String guoNeiList = jedis.get("guoNeiList");
        if (null==guoNeiList || guoNeiList.equals("")){
            List<Route> list = routeService.getGuoNeiList();
            String jsonStr = JSON.toJSONString(list);
            jedis.set("guoNeiList",jsonStr);
        }
        guoNeiList = jedis.get("guoNeiList");
        return guoNeiList;
    }
    public String getJingWaiList() {
        Jedis jedis = JedisUtil.getJedis();
        String jingWaiList = jedis.get("jingWaiList");
        if (null==jingWaiList || jingWaiList.equals("")){
            List<Route> list = routeService.getJingWaiList();
            String jsonStr = JSON.toJSONString(list);
            jedis.set("jingWaiList",jsonStr);
        }
        jingWaiList = jedis.get("jingWaiList");
        return jingWaiList;
    }

    public String getTheme() {
        Jedis jedis = JedisUtil.getJedis();
        String themeTour = jedis.get("themeTour");
        if (null==themeTour || themeTour.equals("")){
            List<Route> list = routeService.getTheme();
            String jsonStr = JSON.toJSONString(list);
            jedis.set("themeTour",jsonStr);
        }
        themeTour = jedis.get("themeTour");
        return themeTour;
    }
    public String getNewest() {
        Jedis jedis = JedisUtil.getJedis();
        String newEst = jedis.get("newEst");
        if (null==newEst || newEst.equals("")){
            List<Route> list = routeService.getNewest();
            String jsonStr = JSON.toJSONString(list);
            jedis.set("newEst",jsonStr);
        }
        newEst = jedis.get("newEst");
        return newEst;
    }


    public String getHotTravel() {
        Jedis jedis = JedisUtil.getJedis();
        String hotTravel = jedis.get("hotTravel");
        if (null==hotTravel || hotTravel.equals("")){
            List<Route> list = routeService.getHotTravel();
            String jsonStr = JSON.toJSONString(list);
            jedis.set("hotTravel",jsonStr);
        }
        hotTravel = jedis.get("hotTravel");
        return hotTravel;
    }

    @Test
    public  void testDemo(){
        Route route = routeService.getRouteByRid(55);
        System.out.println(route);
    }

}
