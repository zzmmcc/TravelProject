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
    <a href="main.jsp" target="mainCont" class="block menu-list-title center" style="border:none;margin-bottom:8px;color:#fff;">起始页</a>
    <ul>
        <li class="menu-list-title">
            <span>商家管理</span>
            <i>◢</i>
        </li>
        <li>
            <ul class="menu-children">
                <li><a href="/TravelProject/adminSellerServlet?method=getSellerList" title="商家列表" target="mainCont">商家列表</a></li>
            </ul>
        </li>

        <li class="menu-list-title">
            <span>路线管理</span>
            <i>◢</i>
        </li>
        <li>
            <ul class="menu-children">
                <li><a href="/TravelProject/adminRouteServlet?method=getRouteListBySearch_textWithPage&search_text=${search_text}&pageNow=1" title="路线列表" target="mainCont">路线列表</a></li>
                <li><a href="/TravelProject/adminCategoryServlet?method=getCategoryBySort" title="路线分类" target="mainCont">路线分类</a></li>
            </ul>
        </li>

        <li class="menu-list-title">
            <span>用户管理</span>
            <i>◢</i>
        </li>
        <li>
            <ul class="menu-children">
                <li><a href="/TravelProject/adminUserServlet?method=getUserListBySearch_textWithPage&search_text=${search_text}&pageNow=1" title="会员列表" target="mainCont">用户列表</a></li>
            </ul>
        </li>

    </ul>
</div>
<div class="menu-footer">© 版权所有 2015 "DeathGhost"</div>
</body>
</html>