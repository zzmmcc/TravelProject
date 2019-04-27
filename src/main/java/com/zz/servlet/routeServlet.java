package com.zz.servlet;

import com.alibaba.fastjson.JSON;
import com.zz.bean.*;
import com.zz.service.FavoriteService;
import com.zz.service.Impl.FavoriteServiceImpl;
import com.zz.service.Impl.RouteImgServiceImpl;
import com.zz.service.Impl.RouteServiceImpl;
import com.zz.service.Impl.SellerServiceImpl;
import com.zz.service.RouteImgService;
import com.zz.service.RouteService;
import com.zz.service.SellerService;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        }
    }

    public void getRouteByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        //获取route
        Route route = routeService.getRouteByRid(rid);
        //获取routeimg
        RouteImg routeImg =  routeImgService.getRouteImgByRid(rid);
        //获取favorite
        Favorite favorite = favoriteService.getFavoriteByRid(rid);
        //获取seller
        Seller seller = sellerService.getSellerByRid(route.getSid());
        RouteMsg routeMsg = new RouteMsg();
        routeMsg.setFavorite(favorite);
        routeMsg.setRoute(route);
        routeMsg.setRouteImg(routeImg);
        routeMsg.setSeller(seller);
        System.out.println(routeMsg.getRoute());
        request.setAttribute("route",route);
        request.setAttribute("routeMsg",routeMsg);
        request.getRequestDispatcher("route_detail.jsp").forward(request,response);
    }


    public String getGuoNeiList() {
        List<Route> list = routeService.getGuoNeiList();
        String jsonStr = JSON.toJSONString(list);
        System.out.println(jsonStr);
        return jsonStr;
    }
    public String getJingWaiList() {
        List<Route> list = routeService.getJingWaiList();
        String jsonStr = JSON.toJSONString(list);
        System.out.println(jsonStr);
        return jsonStr;
    }

    public String getTheme() {
        List<Route> list = routeService.getTheme();
        String jsonStr = JSON.toJSONString(list);
        System.out.println(jsonStr);
        return jsonStr;
    }
    public String getNewest() {
        List<Route> list = routeService.getNewest();
        String jsonStr = JSON.toJSONString(list);
        System.out.println(jsonStr);
        return jsonStr;
    }


    public String getHotTravel() {
        List<Route> list = routeService.getHotTravel();

        String jsonStr = JSON.toJSONString(list);
        System.out.println(jsonStr);
        return jsonStr;
    }

    @Test
    public  void testDemo(){
        Route route = routeService.getRouteByRid(55);
        System.out.println(route);
    }

}
