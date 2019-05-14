<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/13
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>左侧导航</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
</head>
<body style="background:#313131">
<div class="menu-list">
    <a href="main.html" target="mainCont" class="block menu-list-title center" style="border:none;margin-bottom:8px;color:#fff;">起始页</a>
    <ul>
        <li class="menu-list-title">
            <span>商家管理</span>
            <i>◢</i>
        </li>
        <li>
            <ul class="menu-children">
                <li><a href="order_list.jsp" title="商家列表" target="mainCont">商家列表</a></li>
            </ul>
        </li>

        <li class="menu-list-title">
            <span>路线管理</span>
            <i>◢</i>
        </li>
        <li>
            <ul class="menu-children">
                <li><a href="/TravelProject/routeServlet?method=getRouteListBySearch_textWithPage&search_text=${search_text}&pageNow=1" title="路线列表" target="mainCont">路线列表</a></li>
                <li><a href="/TravelProject/categoryServlet?method=getCategoryBySort" title="路线分类" target="mainCont">路线分类</a></li>
                <li><a href="recycle_bin.html" title="商品分类" target="mainCont">商品回收站</a></li>
            </ul>
        </li>

        <li class="menu-list-title">
            <span>会员管理</span>
            <i>◢</i>
        </li>
        <li>
            <ul class="menu-children">
                <li><a href="user_list.html" title="会员列表" target="mainCont">会员列表</a></li>
                <li><a href="add_user.html" title="添加会员" target="mainCont">添加会员</a></li>
                <li><a href="user_rank.html" title="会员等级" target="mainCont">会员等级</a></li>
                <li><a href="user_message.html" title="会员留言" target="mainCont">会员留言</a></li>
            </ul>
        </li>

    </ul>
</div>
<div class="menu-footer">© 版权所有 2015 "DeathGhost"</div>
</body>
</html>