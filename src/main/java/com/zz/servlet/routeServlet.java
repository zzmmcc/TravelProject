package com.zz.servlet;

import com.alibaba.fastjson.JSON;
import com.zz.bean.*;
import com.zz.service.*;
import com.zz.service.Impl.*;
import com.zz.util.JedisUtil;
import com.zz.util.PageUtil;
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
            getRouteListByCidWithPage(request, response);
        }else if(method.equals("getHotsRouteListByCid")){
            getHotsRouteListByCid(request,response);
        }else if(method.equals("searchRouteListByTextWithPage")){
            searchRouteListByTextWithPage(request,response);
        }else if(method.equals("getRouteListByCount")){
            getRouteListByCount(request,response);
        }else if(method.equals("getRouteListCountByRnameAndPrice")){
            getRouteListCountByRnameAndPrice(request,response);
        }else if(method.equals("getRouteListBySearch_textWithPage")){
            getRouteListBySearch_textWithPage(request,response);
        }else if(method.equals("getRouteForEditByRid")){
            getRouteForEditByRid(request,response);
        }else if(method.equals("delRouteByRid")){
            delRouteByRid(request,response);
        } else if(method.equals("delRoutesByRids")){
            delRoutesByRids(request,response);
        }else  {
            System.out.println(method);
        }


    }

    public void delRoutesByRids(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] checkIds = request.getParameterValues("checkId");
        String[] split = checkIds[0].split(",");
        int rids[] = new int[split.length];
        for(int i=0;i<split.length;i++){
            rids[i] = Integer.parseInt(split[i]);
        }
        routeService.delRouteByRids(rids);
        getRouteListBySearch_textWithPage(request,response);

    }

    public void delRouteByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        routeService.delRouteByRid(rid);
        getRouteListBySearch_textWithPage(request,response);
    }

    public void getRouteForEditByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        Category category = categoryService.getCategoryByCid(route.getCid());

        RouteMsg routeMsg = new RouteMsg(route,routeImg,favorite,seller,null,category);

        ArrayList<Category> cate = categoryService.getCategory();
        request.setAttribute("cateList",cate);
        request.setAttribute("routeMsg",routeMsg);
        request.getRequestDispatcher("admin/edit_route.jsp").forward(request,response);
    }

    public void getRouteListBySearch_textWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search_text = request.getParameter("search_text");
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        int pageSize = 16;
        PageUtil<Route> pageList = routeService.getRouteListBySearch_textWithPage(pageNow,pageSize,search_text);
        ArrayList<Category> cate = categoryService.getCategory();
        request.setAttribute("search_text",search_text);
        request.setAttribute("cateList",cate);
        request.setAttribute("pageList",pageList);
        request.getRequestDispatcher("admin/route_list.jsp").forward(request,response);
    }

    public void getRouteListCountByRnameAndPrice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String rname = request.getParameter("rname");
        String minP = request.getParameter("minPrice");
        double minPrice = Double.MIN_VALUE;
        double maxPrice = Double.MAX_VALUE;
        if(null!=minP && !minP.equals("")){
            minPrice = Double.parseDouble(minP);
        }
        String maxP = request.getParameter("maxPrice");
        if(null!=maxP && !maxP.equals("")){
            maxPrice = Double.parseDouble(maxP);
        }
        List<Route> list = routeService.getRouteListCountByRnameAndPrice(rname,minPrice,maxPrice);
        response.getWriter().print(JSON.toJSONString(list));
    }

    public void getRouteListByCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Route> list = routeService.getRouteListByCount();
        response.getWriter().print(JSON.toJSONString(list));
    }

    public void searchRouteListByTextWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchtext = request.getParameter("searchtext");
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        PageUtil<Route> list = routeService.searchRouteListByTextWithPage(searchtext,pageNow);
        request.setAttribute("pageList_Search",list);
        request.setAttribute("search_text",searchtext);
        request.getRequestDispatcher("route_list.jsp").forward(request,response);
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
            response.getWriter().print(jsonStr);
        }
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
        Category category = categoryService.getCategoryByCid(route.getCid());

        RouteMsg routeMsg = new RouteMsg(route,routeImg,favorite,seller,null,category);

        request.setAttribute("route",route);
        request.setAttribute("routeMsg",routeMsg);
        request.getRequestDispatcher("route_detail.jsp").forward(request,response);
    }
    public void getRouteListByCidWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        int pageSize = 8;
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        PageUtil<Route> pageList = routeService.getRouteListByCidWithPage(cid, pageNow, pageSize);
        request.setAttribute("pageList",pageList);
        request.getRequestDispatcher("route_list.jsp").forward(request,response);
    }

    public String getGuoNeiList() {
        Jedis jedis = JedisUtil.getJedis();
        String guoNeiList = jedis.get("guoNeiList");
        if (null==guoNeiList || guoNeiList.equals("")){
            List<Route> list = routeService.getGuoNeiList();
            String jsonStr = JSON.toJSONString(list);
            jedis.set("guoNeiList",jsonStr);
            return  jsonStr;
        }
        return guoNeiList;
    }
    public String getJingWaiList() {
        Jedis jedis = JedisUtil.getJedis();
        String jingWaiList = jedis.get("jingWaiList");
        if (null==jingWaiList || jingWaiList.equals("")){
            List<Route> list = routeService.getJingWaiList();
            String jsonStr = JSON.toJSONString(list);
            jedis.set("jingWaiList",jsonStr);
            return jsonStr;
        }
        return jingWaiList;
    }

    public String getTheme() {
        Jedis jedis = JedisUtil.getJedis();
        String themeTour = jedis.get("themeTour");
        if (null==themeTour || themeTour.equals("")){
            List<Route> list = routeService.getTheme();
            String jsonStr = JSON.toJSONString(list);
            jedis.set("themeTour",jsonStr);
            return jsonStr;
        }
        return themeTour;
    }
    public String getNewest() {
        Jedis jedis = JedisUtil.getJedis();
        String newEst = jedis.get("newEst");
        if (null==newEst || newEst.equals("")){
            List<Route> list = routeService.getNewest();
            String jsonStr = JSON.toJSONString(list);
            jedis.set("newEst",jsonStr);
            return  jsonStr;
        }
        return newEst;
    }


    public String getHotTravel() {
        Jedis jedis = JedisUtil.getJedis();
        String hotTravel = jedis.get("hotTravel");
        if (null==hotTravel || hotTravel.equals("")){
            List<Route> list = routeService.getHotTravel();
            String jsonStr = JSON.toJSONString(list);
            jedis.set("hotTravel",jsonStr);
            return jsonStr;
        }
        return hotTravel;
    }

    @Test
    public  void testDemo(){
        Route route = routeService.getRouteByRid(55);
        System.out.println(route);
    }

}
