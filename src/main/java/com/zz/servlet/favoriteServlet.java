package com.zz.servlet;

import com.zz.service.FavoriteService;
import com.zz.service.Impl.FavoriteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "favoriteServlet",value = "/favoriteServlet")
public class favoriteServlet extends HttpServlet {
    FavoriteService favoriteService = new FavoriteServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String method = request.getParameter("method");
        if(method.equals("like")){
            likeByRidAndUid(request,response);
        }else if(method.equals("unlike")){
            unlikeByRidAndUid(request,response);
        }
    }

    public void unlikeByRidAndUid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        int uid = Integer.parseInt(request.getParameter("uid"));
        int i = favoriteService.unlikeByRidAndUid(rid,uid);
        response.getWriter().print(i);
    }

    public void likeByRidAndUid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        int uid = Integer.parseInt(request.getParameter("uid"));
        int i = favoriteService.likeByRidAndUid(rid, uid);
        response.getWriter().print(i);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
