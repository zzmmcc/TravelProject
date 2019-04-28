package com.zz.filter;

import com.zz.util.JedisUtil;
import redis.clients.jedis.Jedis;

import javax.servlet.*;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/route_detail.jsp","/route_list.jsp","/myfavorite.jsp","/favoriterank.jsp",
                })
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("服务器开启，清除redis中的所有缓存");
        Jedis jedis = JedisUtil.getJedis();
        jedis.flushAll();

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();
        System.out.println(path+"被Filter过滤了");
            Object user = request.getSession().getAttribute("loginUser");
            if(user==null||user.equals("")){
                response.sendRedirect("login.jsp");
                //return;
            }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
