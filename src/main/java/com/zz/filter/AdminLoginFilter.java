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
            Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
            if(null==admin||"".equals(admin)){
                response.sendRedirect("/TravelProject/login_admin.jsp");
                //return;
            }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
