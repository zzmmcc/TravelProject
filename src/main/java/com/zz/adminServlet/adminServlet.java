package com.zz.adminServlet;

import com.zz.bean.Admin;
import com.zz.service.AdminService;
import com.zz.service.Impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminServlet",value = "/adminServlet")
public class adminServlet extends HttpServlet {

    AdminService adminService = new AdminServiceImpl();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");

        if(method.equals("login")){
            login(request,response);
        }else if(method.equals("logout")){
            logout(request,response);
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = adminService.login(username,password);
        System.out.println(admin);
        if(admin.getId()!=null){
            request.getSession().setAttribute("loginAdmin",admin);
            response.sendRedirect("admin/index.jsp");
        }else {
            request.setAttribute("msg","账号或密码错误！");
            request.getRequestDispatcher("login_admin.jsp").forward(request,response);
        }
    }
    public  void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("loginAdmin");
        response.sendRedirect("login_admin.jsp");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
