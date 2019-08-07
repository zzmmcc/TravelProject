package com.zz.servlet;

import com.zz.bean.User;
import com.zz.service.CategoryService;
import com.zz.service.FavoriteService;
import com.zz.service.Impl.CategoryServiceImpl;
import com.zz.service.Impl.FavoriteServiceImpl;
import com.zz.service.Impl.UserServiceImpl;
import com.zz.service.UserService;
import com.zz.util.MailUtils;
import com.zz.util.Md5Util;
import com.zz.util.UuidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;


@WebServlet(name = "userServlet", value = "/userServlet")
public class userServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    FavoriteService favoriteService = new FavoriteServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if (method.equals("login")) {
            try {
                login(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (method.equals("register")) {
            try {
                register(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (method.equals("logout")) {
            logout(request, response);
        } else if (method.equals("activeUser")) {
            activeUser(request, response);
        }
    }


    public void activeUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        int i = userService.activeUserByCode(code);
        if (i == 9) {
            response.getWriter().write("<script>alert('该账户无需激活，请直接登录！');window.location.href='http://127.0.0.1:8080/TravelProject/login.jsp';window.close;</script>");
        } else if (i != 0 && i != 9) {
            //激活成功
            response.getWriter().write("<script>alert('激活成功，请登录！');window.location.href='http://127.0.0.1:8080/TravelProject/login.jsp';window.close;</script>");
        } else {
            response.getWriter().write("<script>alert('激活失败，请重试！');window.close;</script>");
            //激活失败
        }
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String check = request.getParameter("check");
        System.out.println(check);
        String checkStr = request.getSession().getAttribute("checkStr").toString();
        if (check.equalsIgnoreCase(checkStr)) {
            //验证码正确才进行下一步
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //加密密码
            User user = userService.checkLogin(username, Md5Util.encodeByMd5(password));
            System.out.println(user);
            if (null == user.getUsername() || user.getUsername().equals("")) {
                //账户账号密码错误或不存在
                response.getWriter().print(1);
            } else if (user.getStatus().equals("1")) {
                //登录成功
                request.getSession().setAttribute("loginUser", user);
                System.out.println("session:" + request.getSession().getAttribute("loginUser"));
                response.getWriter().print(0);
            } else if (user.getStatus().equals("0")) {
                //账户未激活
                response.getWriter().print(2);

            }
        } else {
            //验证码错误直接返回
            response.getWriter().print(9);
        }
    }

    //注册
    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String check = request.getParameter("check");
        String checkStr = request.getSession().getAttribute("checkStr").toString();
        if (check.equalsIgnoreCase(checkStr)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String telephone = request.getParameter("telephone");
            String email = request.getParameter("email");
            String date = request.getParameter("birthday");
            if (date.equals(""))
                date = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = new Date(sdf.parse(date).getTime());

            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            //加密密码
            String code = UuidUtil.getUuid();
            User user = new User(username, Md5Util.encodeByMd5(password), name, birthday, sex, telephone, email, "0", code);
            //注册
            User u = userService.register(user);
            if (u.equals("") || null == u) {
                //注册失败
                response.getWriter().print(1);
            } else {
                //注册成功
                //给用户发送邮件
                MailUtils.sendMail(email, "尊敬的" + name + "，请点击链接完成激活：http://127.0.0.1:8080/TravelProject/userServlet?method=activeUser&code=" + code, "激活账户");
                response.getWriter().print(0);
            }
        } else {
            //验证码错误
            response.getWriter().print(2);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("loginUser");
        response.sendRedirect("login.jsp");
    }
}
