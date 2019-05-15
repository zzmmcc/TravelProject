package com.zz.adminServlet;

import com.zz.bean.Route;
import com.zz.bean.User;
import com.zz.service.CategoryService;
import com.zz.service.FavoriteService;
import com.zz.service.Impl.CategoryServiceImpl;
import com.zz.service.Impl.FavoriteServiceImpl;
import com.zz.service.Impl.UserServiceImpl;
import com.zz.service.UserService;
import com.zz.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "adminUserServlet",value = "/adminUserServlet")
public class adminUserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    FavoriteService favoriteService = new FavoriteServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method.equals("getUserListBySearch_textWithPage")){
            getUserListBySearch_textWithPage(request,response);
        }else if(method.equals("getUserMsgsByUid")){
            getUserMsgsByUid(request,response);
        }
    }

    public void getUserMsgsByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        User user = userService.getUserByUid(uid);
        List<Route> routeList = favoriteService.getListByUid(uid);
        request.setAttribute("user",user);
        request.setAttribute("routeList",routeList);
        request.getRequestDispatcher("/admin/user_msg.jsp").forward(request,response);

    }

    public void getUserListBySearch_textWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search_text = request.getParameter("search_text");
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        int pageSize = 8;
        PageUtil<User> pageList = userService.getUserListBySearch_textWithPage(pageNow,pageSize,search_text);
        request.setAttribute("search_text",search_text);
        request.setAttribute("pageList",pageList);
        request.getRequestDispatcher("admin/user_list.jsp").forward(request,response);
    }



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


}
