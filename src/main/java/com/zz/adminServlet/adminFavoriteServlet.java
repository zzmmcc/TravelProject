package com.zz.adminServlet;

import com.zz.bean.Route;
import com.zz.filter.MyLoginFilter;
import com.zz.service.FavoriteService;
import com.zz.service.Impl.FavoriteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminFavoriteServlet",value = "/adminFavoriteServlet")
public class adminFavoriteServlet extends HttpServlet {
    FavoriteService favoriteService = new FavoriteServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyLoginFilter.filterAdmin(request,response);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String method = request.getParameter("method");if (method.equals("getListByUid")){
            getListByUid(request,response);
        }
    }

    public void getListByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        List<Route> list = favoriteService.getListByUid(uid);
        request.setAttribute("routeList",list);
        request.getRequestDispatcher("myfavorite.jsp").forward(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
