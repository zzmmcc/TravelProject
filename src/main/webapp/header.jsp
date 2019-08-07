<%@ page import="com.zz.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/4/25
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
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
                <a href="login_admin.jsp">管理员登录</a>
            </div>
        </c:if>
        <!-- 登录状态  -->
        <c:if test="${not empty loginUser}" var="u">
            <div class="login">
                <span>欢迎回来,${loginUser.name}</span>
                <a href="favoriteServlet?method=getListByUid&uid=${loginUser.uid}" class="collection">我的收藏</a>
                <a href="userServlet?method=logout">退出</a>
                <a href="login_admin.jsp">管理员登录</a>
            </div>
        </c:if>
    </div>
    <div class="header_wrap">
        <div class="topbar">
            <div class="logo">
                <a href="/"><img src="images/logo.png" alt=""></a>
            </div>
            <form id="search_from" action="routeServlet?method=searchRouteListByTextWithPage&pageNow=1" method="post">
                <div class="search">
                    <input name="searchtext" type="text" placeholder="请输入路线名称" class="search_input" autocomplete="off">
                    <button type="submit" class="search-button">搜索</button>
                </div>
            </form>
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
    <ul class="nav" id="write_category">
        <%--append--%>
    </ul>
</div>
<script src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
    $(function () {
        getCategory();
    });

    function getCategory() {
        $.ajax({
            url: "categoryServlet?method=getCategory",
            data: {},
            type: "POST",
            dataType: "json",
            success: function (data) {
                console.log(1);
                $('#write_category').append("<li class='nav-active'><a href='index.jsp'>首页</a></li>");
                $.each(data, function (i, cate) {
                    var name = cate.cname;
                    var id = cate.cid;
                    var con = "<li><a href='routeServlet?method=getRouteListByCid&cid=" + id + "&pageNow=1'>" + name + "</a></li>";
                    $('#write_category').append(con);
                });
                $('#write_category').append("<li><a href='favoriterank.jsp'>收藏排行榜</a></li>");
            },
            error: function (data) {
                console.log(2);
            }
        });
    }
</script>

