package com.zz.filter;

import com.zz.bean.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyLoginFilter  {
    public static void filterAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("loginAdmin");
        if(null==admin || "".equals(admin)){
            request.setAttribute("msg","您还未登录！");
            request.getRequestDispatcher("login_admin.jsp").forward(request,response);
        }
    }
}
