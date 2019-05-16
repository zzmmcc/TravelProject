package com.zz.filter;

import com.zz.bean.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*"})
public class AdminLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();
        System.out.println(path+"被Filter过滤了");
            Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
            System.out.println(admin);
            if(null==admin||"".equals(admin)){
                System.out.println(1);
                response.sendRedirect("/TravelProject/login_admin.jsp");
                //return;
            }
        System.out.println(2);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
