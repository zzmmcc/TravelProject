<%@ page import="com.zz.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/4/25
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!-- 头部 start -->
<header id="header">
    <div class="top_banner">
        <img src="images/top_banner.jpg" alt="">
    </div>
    <div class="shortcut">

        <!-- 未登录状态  -->
       <c:if test="${empty loginUser}">
            <div class="login_out">
                <a href="login.jsp">登录</a>
                <a href="register.jsp">注册</a>
            </div>
        </c:if>
        <!-- 登录状态  -->
        <c:if test="${not empty loginUser}" var="u">
            <div class="login">
                <span>欢迎回来,${loginUser.name}</span>
                <a href="myfavorite.jsp" class="collection">我的收藏</a>
                <a href="userServlet?method=logout" >退出</a>
            </div>
        </c:if>
    </div>
    <div class="header_wrap">
        <div class="topbar">
            <div class="logo">
                <a href="/"><img src="images/logo.png" alt=""></a>
            </div>
            <div class="search">
                <input name="" type="text" placeholder="请输入路线名称" class="search_input" autocomplete="off">
                <a href="javascript:;" class="search-button">搜索</a>
            </div>
            <div class="hottel">
                <div class="hot_pic">
                    <img src="images/hot_tel.jpg" alt="">
                </div>
                <div class="hot_tel">
                    <p class="hot_time">客服热线(9:00-6:00)</p>
                    <p class="hot_num">400-618-9090</p>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- 头部 end -->
<!-- 首页导航 -->
<div class="navitem">
    <ul class="nav">
        <li class="nav-active"><a href="index.html">首页</a></li>
        <li><a href="route_list.html">门票</a></li>
        <li><a href="route_list.html">酒店</a></li>
        <li><a href="route_list.html">香港车票</a></li>
        <li><a href="route_list.html">出境游</a></li>
        <li><a href="route_list.html">国内游</a></li>
        <li><a href="route_list.html">港澳游</a></li>
        <li><a href="route_list.html">抱团定制</a></li>
        <li><a href="route_list.html">全球自由行</a></li>
        <li><a href="favoriterank.html">收藏排行榜</a></li>
    </ul>
</div>

